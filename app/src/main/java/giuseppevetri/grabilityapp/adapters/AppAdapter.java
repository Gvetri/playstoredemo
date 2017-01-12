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

import java.util.List;

import giuseppevetri.grabilityapp.AppFragment;
import giuseppevetri.grabilityapp.R;
import giuseppevetri.grabilityapp.models.apps.App;

import static android.content.ContentValues.TAG;

/**
 * Created by giuseppe on 08/01/17.
 */

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.MyViewHolder> {
    private List<App> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,description,price;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_titulo);
            description = (TextView) itemView.findViewById(R.id.tv_descripcion);
            //image = (ImageView) itemView.findViewById(R.id.app_image);
            price = (TextView) itemView.findViewById(R.id.tv_precio);
        }
    }

    public AppAdapter(List<App> list) {
        this.list = list;
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
        App app = list.get(position);
        String nombre = "";
        String description = "";
        String price = "";
        if (app == null) {
            Log.d(TAG, "onBindViewHolder: App nula");
        } else{
            nombre = app.getName().getLabel();
            description = app.getSummary().getLabel();
            price = app.getPrice().getPriceWithCurrency();
            Log.d(TAG, "onBindViewHolder: entro en el else");
        }
        holder.title.setText(nombre);
        holder.description.setText(description);
        holder.price.setText(price);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


}
