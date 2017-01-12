package giuseppevetri.grabilityapp.models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import giuseppevetri.grabilityapp.ApplicationPresenter;
import giuseppevetri.grabilityapp.models.apps.Entry;

/**
 * Created by giuseppe on 07/01/17.
 */

public class Feed {
    private Entry[] entries;
    //private Entry entries;

    public Entry[] getEntries() {
        return entries;
    }

    public void setEntries(Entry[] entries) {
        this.entries = entries;
    }

    public int getAppsSize(){
        if (entries == null){
            return -1;
        } else{
            return entries.length;
        }
    }

    public void setEntries(JSONArray entry) {
        Log.d("FEED MODEL", "setEntries: "+entry.length()+"\n "+entry.toString());
//        for (int i = 0; i < entry.length(); i++) {
//            ArrayList<Entry> entryArrayList = null;
//            try {
//                Entry entry_object = (Entry) entry.get(i);
//                entryArrayList.add(entry_object);
//                Log.d("feed model", "setEntries: "+i);
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            entries = (Entry[]) entryArrayList.toArray();
//            Log.d("FEED MODEL", "setEntries: size"+entries.length);
//        }
    }

}
