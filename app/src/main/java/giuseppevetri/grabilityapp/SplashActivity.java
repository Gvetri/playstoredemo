package giuseppevetri.grabilityapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.TransitionInflater;
import android.util.Log;
import android.widget.Toast;

public class SplashActivity extends AppCompatActivity implements ConnectivityReceiver.ConnectivityReceiverListener {

    private static final String TAG = "Splash";
    protected boolean splash_screan_loaded = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setupWindowAnimations();
        moveToMainActivity();
    }

    private void setupWindowAnimations() {
        Fade fade = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            fade = (Fade) TransitionInflater.from(this).inflateTransition(R.transition.activity_fade);
            fade.setDuration(3000);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setExitTransition(fade);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        AppController.getInstance().setConnectivityListener(this);
        moveToMainActivity();
    }

    public void moveToMainActivity(){
        if (checkConnection() ) {
            if (splash_screan_loaded) {
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run() {
                        moveToMain();
                        splash_screan_loaded = false;
                        Log.d(TAG, "run: Espera... ");
                    }
                }, 1000);
            } else {
                moveToMain();
                Log.d(TAG, "onCreate: No esperas nada.");
            }
        } else {
            if (getInformation()){
                Toast.makeText(this, "No hay conexion, se mostraran los datos almacenados", Toast.LENGTH_SHORT).show();
                moveToMain();
            } else {
                Toast.makeText(this, "No hay conexion para obtener la informacion.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void moveToMain() {
        Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
        startActivity(mainIntent);
        finish();
    }

    private boolean getInformation() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        Boolean information = preferences.getBoolean("data",false);
        return information;
    }

    private boolean checkConnection() {
        return ConnectivityReceiver.isConnected();
    }

    private void showToast(boolean isConnected) {
        if (!isConnected) {
            String message = "No estas conectado a internet, se mostraran los datos que ya fueron almacenados";
            Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        AppController.getInstance().setConnectivityListener(this);
    }


    /**
     * Callback que se activa cuando no hay internet
     *
     */
    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {
        showToast(isConnected);
    }
}
