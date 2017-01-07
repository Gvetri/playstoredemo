package giuseppevetri.grabilityapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    private static final String TAG = "Splash";
    protected boolean splash_screan_loaded = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        final Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
        if (splash_screan_loaded) {
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    /* Create an Intent that will start the Menu-Activity. */
                    startActivity(
                            mainIntent);
                    splash_screan_loaded = false;
                    Log.d(TAG, "run: Espera tres minutos... ");
                    finish();
                }
            }, 5000);
        } else {
            Log.d(TAG, "onCreate: No esperas nada.");
            startActivity(mainIntent);
            finish();
        }

    }

    @Override
    protected void onResume() {
        super.onResume();
        final Intent mainIntent = new Intent(SplashActivity.this,MainActivity.class);
        if (splash_screan_loaded) {
            new Handler().postDelayed(new Runnable(){
                @Override
                public void run() {
                    /* Create an Intent that will start the Menu-Activity. */
                    startActivity(
                            mainIntent);
                    splash_screan_loaded = false;
                    Log.d(TAG, "run: Espera tres minutos... ");
                    finish();
                }
            }, 5000);
        } else {
            Log.d(TAG, "onCreate: No esperas nada.");
            startActivity(mainIntent);
            finish();
        }
    }
}
