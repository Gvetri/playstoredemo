package giuseppevetri.grabilityapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import giuseppevetri.grabilityapp.adapters.AppAdapter;
import giuseppevetri.grabilityapp.adapters.StringAdapterG;
import giuseppevetri.grabilityapp.dialog.AppDialog;
import giuseppevetri.grabilityapp.models.apps.Entry;

import static android.content.ContentValues.TAG;


public class CategoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private AppAdapter appAdapter,game_adapter,utilities_adapter,social_adapter,photo_video_adapter
            ,navigation_adapter,travel_adapter,productivity_adapter,shopping_adapter,entertainment_adapter,music_adapter;
    private List<Entry> applist,game_category,utilities_category,social_networking_category,photo_video_category,navigation_category
            ,travel_category,productivity_category,shopping_category,entertainment_category,music_category;
    private static final String ENDPOINT = "https://itunes.apple.com/us/rss/topfreeapplications/limit=20/json";
    private RequestQueue requestQueue;

    private static String VOLLEY = "volley request";
    private RecyclerView recyclerView_music;
    private RecyclerView recyclerView_Utilities;
    private RecyclerView recyclerView_social;
    private RecyclerView recyclerView_photo;
    private RecyclerView recyclerView_navigation;
    private RecyclerView recyclerView_travel;
    private RecyclerView recyclerView_productivity;
    private RecyclerView recyclerView_shopping;
    private RecyclerView recyclerView_Entertainment;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_category, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadAppData();
        requestQueue = Volley.newRequestQueue(getContext());
        fetchAppData();
        setupRecyclerViewListener();
        orderByCategory();
    }

    private void orderByCategory() {
        game_category = new ArrayList<>();
        utilities_category = new ArrayList<>();
        social_networking_category = new ArrayList<>();
        photo_video_category = new ArrayList<>();
        navigation_category = new ArrayList<>();
        travel_category = new ArrayList<>();
        productivity_category = new ArrayList<>();
        shopping_category = new ArrayList<>();
        entertainment_category = new ArrayList<>();
        music_category = new ArrayList<>();

        for (int i = 0; i < applist.size(); i++) {
            switch(applist.get(i).getCategory()){
                case "Games":
                    game_category.add(applist.get(i));
                    break;  //optional
                case "Utilities":
                    utilities_category.add(applist.get(i));
                    break;  //optional
                case "Social Networking":
                    social_networking_category.add(applist.get(i));
                    break;
                case "Photo & Video":
                    photo_video_category.add(applist.get(i));
                    break;
                case "Navigation":
                    navigation_category.add(applist.get(i));
                    break;
                case "Travel":
                    travel_category.add(applist.get(i));
                    break;
                case "Productivity":
                    productivity_category.add(applist.get(i));
                    break;
                case "Shopping":
                    shopping_category.add(applist.get(i));
                    break;
                case "Entertainment":
                    entertainment_category.add(applist.get(i));
                    break;
                case "Music":
                    music_category.add(applist.get(i));
                    break;
                default:
                    break;
            }
        }

        initializeAdapters();
    }

    private void initializeAdapters() {
        initializeGameAdapter();
        initializeUtilitiesAdapter();
        initializeSocialAdapter();
        initializePhotoVideoAdapter();
        initializeNavigationAdapter();
        initializeTravelAdapter();
        initializeProductivityAdapter();
        initializeShoppingCategoryadapter();
        initializeEntertainmentAdapter();
        initializeMusicAdapter();
    }

    private void initializeMusicAdapter() {
        recyclerView_music = (RecyclerView) getView().findViewById(R.id.recyclerview_musica);
        Log.d("FRAGMENT", "loadData: applist info musica"+music_category.size());
        music_adapter = new AppAdapter(music_category, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_music.setLayoutManager(mLayoutManager);
        recyclerView_music.setItemAnimator(new DefaultItemAnimator());
        recyclerView_music.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerView_music.setAdapter(music_adapter);

    }

    private void initializeEntertainmentAdapter() {
        recyclerView_Entertainment = (RecyclerView) getView().findViewById(R.id.recyclerview_entretenimiento);
        Log.d("FRAGMENT", "loadData: applist info "+entertainment_category.size());
        entertainment_adapter = new AppAdapter(entertainment_category, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_Entertainment.setLayoutManager(mLayoutManager);
        recyclerView_Entertainment.setItemAnimator(new DefaultItemAnimator());
        recyclerView_Entertainment.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerView_Entertainment.setAdapter(entertainment_adapter);

    }

    private void initializeShoppingCategoryadapter() {
        recyclerView_shopping = (RecyclerView) getView().findViewById(R.id.recyclerview_shopping);
        Log.d("FRAGMENT", "loadData: applist info "+shopping_category.size());
        shopping_adapter = new AppAdapter(shopping_category, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_shopping.setLayoutManager(mLayoutManager);
        recyclerView_shopping.setItemAnimator(new DefaultItemAnimator());
        recyclerView_shopping.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerView_shopping.setAdapter(shopping_adapter);
    }

    private void initializeProductivityAdapter() {
        recyclerView_productivity = (RecyclerView) getView().findViewById(R.id.recyclerview_productividad);
        Log.d("FRAGMENT", "loadData: applist info "+productivity_category.size());
        productivity_adapter = new AppAdapter(productivity_category, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_productivity.setLayoutManager(mLayoutManager);
        recyclerView_productivity.setItemAnimator(new DefaultItemAnimator());
        recyclerView_productivity.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerView_productivity.setAdapter(productivity_adapter);

    }

    private void initializeTravelAdapter() {
        recyclerView_travel = (RecyclerView) getView().findViewById(R.id.recyclerview_viaje);
        Log.d("FRAGMENT", "loadData: applist info "+travel_category.size());
        travel_adapter = new AppAdapter(travel_category, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_travel.setLayoutManager(mLayoutManager);
        recyclerView_travel.setItemAnimator(new DefaultItemAnimator());
        recyclerView_travel.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerView_travel.setAdapter(travel_adapter);
    }

    private void initializeNavigationAdapter() {
        recyclerView_navigation = (RecyclerView) getView().findViewById(R.id.recyclerview_navegacion);
        Log.d("FRAGMENT", "loadData: applist info "+navigation_category.size());
        navigation_adapter = new AppAdapter(navigation_category, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_navigation.setLayoutManager(mLayoutManager);
        recyclerView_navigation.setItemAnimator(new DefaultItemAnimator());
        recyclerView_navigation.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerView_navigation.setAdapter(navigation_adapter);
    }

    private void initializePhotoVideoAdapter() {
        recyclerView_photo = (RecyclerView) getView().findViewById(R.id.recyclerview_foto_y_video);
        Log.d("FRAGMENT", "loadData: applist info "+photo_video_category.size());
        photo_video_adapter = new AppAdapter(photo_video_category, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_photo.setLayoutManager(mLayoutManager);
        recyclerView_photo.setItemAnimator(new DefaultItemAnimator());
        recyclerView_photo.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerView_photo.setAdapter(photo_video_adapter);
    }

    private void initializeSocialAdapter() {
        recyclerView_social = (RecyclerView) getView().findViewById(R.id.recyclerview_social);
        Log.d("FRAGMENT", "loadData: applist info "+social_networking_category.size());
        social_adapter = new AppAdapter(social_networking_category, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_social.setLayoutManager(mLayoutManager);
        recyclerView_social.setItemAnimator(new DefaultItemAnimator());
        recyclerView_social.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerView_social.setAdapter(social_adapter);
    }

    private void initializeUtilitiesAdapter() {
        recyclerView_Utilities = (RecyclerView) getView().findViewById(R.id.recyclerview_utilidades);
        Log.d("FRAGMENT", "loadData: applist info "+utilities_category.size());
        utilities_adapter = new AppAdapter(utilities_category, getContext());
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_Utilities.setLayoutManager(mLayoutManager);
        recyclerView_Utilities.setItemAnimator(new DefaultItemAnimator());
        recyclerView_Utilities.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerView_Utilities.setAdapter(utilities_adapter);
    }

    private void initializeGameAdapter() {
        appAdapter.setList(game_category);
        appAdapter.notifyDataSetChanged();
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
                        orderByCategory();
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
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), LinearLayoutManager.HORIZONTAL));
        recyclerView.setAdapter(appAdapter);
    }

}
