package giuseppevetri.grabilityapp.dialog;

import android.app.Dialog;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import giuseppevetri.grabilityapp.R;
import giuseppevetri.grabilityapp.models.apps.Entry;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Image;

/**
 * Created by giuseppe on 12/01/17.
 */

public class AppDialog extends DialogFragment{
    private static final String TAG = "AppDialog";
    private TextView name,title,artist,price,summary;
    private ImageView imageView,close_dialog_imageview;
    public AppDialog() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.app_dialog,container,false);
        initializeUI(view);
        final Entry entry = getArguments().getParcelable("entry");
        if (entry == null) {
            Toast.makeText(getActivity(), "Ha ocurrido un error cargando la informacion de la app.", Toast.LENGTH_SHORT).show();
        } else{
            setData(entry);
        }
        return view;
    }

    private void setData(Entry entry) {
        name.setText(entry.getName());
        title.setText(entry.getTitle());
        artist.setText(entry.getArtist());
        price.setText(entry.getPrice());
        summary.setText(entry.getSummary());

        Image image = getArguments().getParcelable("image");
        if (image == null) {
            Toast.makeText(getActivity(), "Ha ocurrido un error cargando la imagen", Toast.LENGTH_SHORT).show();
        } else{
            Glide.with(getActivity()).load(image.getMedium_url())
                    .thumbnail(0.5f)
                    .crossFade()
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(imageView);
        }
    }

    private void initializeUI(View view) {
        name = (TextView) view.findViewById(R.id.tv_nombre);
        title = (TextView) view.findViewById(R.id.tv_titulo);
        artist = (TextView) view.findViewById(R.id.tv_artista);
        price = (TextView) view.findViewById(R.id.tv_precio);
        summary = (TextView) view.findViewById(R.id.tv_descripcion);
        imageView = (ImageView) view.findViewById(R.id.iv_imagen);
        close_dialog_imageview = (ImageView) view.findViewById(R.id.iv_close);

        close_dialog_imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
    }


    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }


    public static AppDialog newInstance(Entry entry){
        AppDialog f = new AppDialog();
        Bundle args = new Bundle();
        args.putParcelable("entry",entry);
        args.putParcelable("image",entry.getImage());
        f.setArguments(args);
        return f;

    }



    @Override

    public void onResume() {

        // Get existing layout params for the window

        ViewGroup.LayoutParams params = getDialog().getWindow().getAttributes();

        // Assign window properties to fill the parent

        params.width = WindowManager.LayoutParams.MATCH_PARENT;

        params.height = WindowManager.LayoutParams.MATCH_PARENT;

        getDialog().getWindow().setAttributes((android.view.WindowManager.LayoutParams) params);

        // Call super onResume after sizing

        super.onResume();

    }

}
