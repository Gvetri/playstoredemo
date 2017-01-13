package giuseppevetri.grabilityapp;

import android.app.DialogFragment;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import giuseppevetri.grabilityapp.adapters.AppAdapter;
import giuseppevetri.grabilityapp.adapters.StringAdapterG;
import giuseppevetri.grabilityapp.dialog.AppDialog;
import giuseppevetri.grabilityapp.models.Feed;
import giuseppevetri.grabilityapp.models.apps.Entry;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Name;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Price;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Price_Attributes;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Summary;
import giuseppevetri.grabilityapp.AppController;

import static android.content.ContentValues.TAG;


public class AppFragment extends Fragment {

    private RecyclerView recyclerView;
    private AppAdapter appAdapter;
    private List<Entry> applist;
    private List<String> list;
    private StringAdapterG sAdapter;
    private static final String ENDPOINT = "https://itunes.apple.com/us/rss/topfreeapplications/limit=20/json";
    private RequestQueue requestQueue;
    private Gson gson;

    private static String VOLLEY = "volley request";


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
        requestQueue = Volley.newRequestQueue(getContext());
        fetchAppData();
        setupRecyclerViewListener();
    }

    private void setupRecyclerViewListener() {

        recyclerView.addOnItemTouchListener(new AppAdapter.RecyclerTouchListener(getContext(), recyclerView, new AppAdapter.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Entry entry = applist.get(position);
                showAppDialog(entry);
            }

            @Override
            public void onLongClick(View view, int position) {
            }
        }));
    }

    private void showAppDialog(Entry entry) {
        FragmentManager fm = getFragmentManager();
        AppDialog appDialog = AppDialog.newInstance(entry);
        appDialog.show(fm,"app_dialog");

    }

    private void fetchAppData() {
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, ENDPOINT, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(VOLLEY, "onResponse: "+response.toString());
                        try {
                            Log.d(VOLLEY, "onResponse: obtenido el response");
                            JSONObject object = response.getJSONObject("feed");
                            JSONArray json_array = object.getJSONArray("entry");
                            applist.clear();
                                for (int i = 0; i < json_array.length(); i++) {
                                    Entry entry = new Entry();
                                    entry.InitializeEntry(object,i);
                                    applist.add(entry);
                                    Log.d(TAG, "fetchAppData: entry: "+entry.getName());
                                }
                            Log.d(TAG, "onResponse: app list"+applist.size());
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        appAdapter.notifyDataSetChanged();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d(TAG, "onErrorResponse: "+error.toString());
                    }
                });
        AppController.getInstance().addToRequestQueue(req);
    }


    private void loadAppData() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerview);
        applist = new ArrayList<>();
        Log.d("FRAGMENT", "loadData: applist info "+applist.size());
        appAdapter = new AppAdapter(applist, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(appAdapter);
    }






}
