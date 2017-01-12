package giuseppevetri.grabilityapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import giuseppevetri.grabilityapp.adapters.AppAdapter;
import giuseppevetri.grabilityapp.adapters.StringAdapterG;
import giuseppevetri.grabilityapp.models.apps.App;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Name;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Price;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Price_Attributes;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Summary;

import static android.content.ContentValues.TAG;


public class AppFragment extends Fragment {

    private RecyclerView recyclerView;
    private AppAdapter appAdapter;
    private List<App> applist;
    private List<String> list;
    private StringAdapterG sAdapter;

    public AppFragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_app, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //loadStringData();
        loadAppData();
    }

    private void loadAppData() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview);
        applist = new ArrayList<>();
        Log.d("FRAGMENT", "loadData: applist info "+applist.size());
        appAdapter = new AppAdapter(applist);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(appAdapter);
        loadData();
    }

    private void loadStringData() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview);
        list = new ArrayList<>();
        sAdapter = new StringAdapterG(list);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(sAdapter);
        list.add("hola1");
        list.add("hola2");
        list.add("hola3");
        Log.d(TAG, "onActivityCreated: list size : "+list.size());
        sAdapter.notifyDataSetChanged();
    }


    private void loadData() {

        Name name = new Name("App 1");
        Summary summary = new Summary("Super aplicacion que esta en la playstoreeeeeeeeeeeeeeeeeeeee");
        Price price = getPrice();
        App app = new App(name,summary,price);
        App app1 = new App(name,summary,price);
        App app2 = new App(name,summary,price);
        applist.add(app);
        applist.add(app1);
        applist.add(app2);
        Log.d("FRAGMENT", "loadData: applist info "+applist.size());
       // appAdapter.notifyDataSetChanged();

    }

    private Price getPrice() {
        Price_Attributes priceAttributes = new Price_Attributes(0.00f,"$");
        Price price = new Price(priceAttributes);
        return price;
    }

}
