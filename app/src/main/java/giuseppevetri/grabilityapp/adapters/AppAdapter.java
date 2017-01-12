package giuseppevetri.grabilityapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.List;

import giuseppevetri.grabilityapp.R;
import giuseppevetri.grabilityapp.models.apps.Entry;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Image;


import static android.content.ContentValues.TAG;

/**
 * Created by giuseppe on 08/01/17.
 */

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.MyViewHolder> {
    private List<Entry> list;
    private Context context;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,description,price;
        public ImageView image;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_titulo);
            description = (TextView) itemView.findViewById(R.id.tv_descripcion);
            image = (ImageView) itemView.findViewById(R.id.app_image);
            price = (TextView) itemView.findViewById(R.id.tv_precio);

        }
    }


    public AppAdapter(List<Entry> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.app_card, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        //TODO revisar por que el tipo de dato app da ese problema
        Entry entry = list.get(position);
        String nombre = entry.getName();
        String summary = entry.getSummary();
        String price = entry.getPrice();
        Image image = entry.getImage();

        holder.title.setText(nombre);
        holder.description.setText(summary);
        holder.price.setText(price);
        loadImages(image,holder);

    }

    private void loadImages(Image imagen,MyViewHolder holder) {
        Glide.with(context).load(imagen.getSmall_url())
                .thumbnail(0.5f)
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.image);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
