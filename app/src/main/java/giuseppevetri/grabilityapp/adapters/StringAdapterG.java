package giuseppevetri.grabilityapp.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import giuseppevetri.grabilityapp.R;


public class StringAdapterG extends RecyclerView.Adapter<StringAdapterG.MyViewHolder> {
    private List<String> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView title,description,price;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_nombre);
            description = (TextView) itemView.findViewById(R.id.tv_descripcion);
            //image = (ImageView) itemView.findViewById(R.id.app_image);
            price = (TextView) itemView.findViewById(R.id.tv_precio);
        }
    }


    public StringAdapterG(List<String> list) {
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
        String string = list.get(position);
        holder.title.setText(string);
        holder.description.setText(string);
        holder.price.setText(string);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
