package giuseppevetri.grabilityapp.models.apps;

import android.util.Log;

import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

import giuseppevetri.grabilityapp.models.apps.apps_attributes.Artist;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Category;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Image;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Link;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Name;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Price;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.ReleaseDate;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Rights;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Summary;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Title;

/**
 * Created by giuseppe on 07/01/17.
 */

public class Entry {
    private String name,summary,price,rights,title,link,artist,category,releaseDate,app_id;
    private Image image;
    final static String TAG = "Entry";

    public Entry(String name, Image image, String summary, String price, String rights, String title, String link, String artist, String category, String releaseDate, String app_id) {
        this.name = name;
        this.image = image;
        this.summary = summary;
        this.price = price;
        this.rights = rights;
        this.title = title;
        this.link = link;
        this.artist = artist;
        this.category = category;
        this.releaseDate = releaseDate;
        this.app_id = app_id;
    }

    public Entry() {

    }

    public String getApp_id() {
        return app_id;
    }

    public void setApp_id(String app_id) {
        this.app_id = app_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getRights() {
        return rights;
    }

    public void setRights(String rights) {
        this.rights = rights;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }


    public void setNameFromRequest(JSONObject object,int position){
        JSONArray json_array = null;
        try {
            json_array = object.getJSONArray("entry");
            JSONObject entry = json_array.getJSONObject(position);
            JSONObject name_object = entry.getJSONObject("im:name");
            name = name_object.getString("label");
            Log.d("ENTRY", "setNameFromRequest: name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setSummaryFromRequest(JSONObject object,int position){
        JSONArray json_array = null;
        try {
            json_array = object.getJSONArray("entry");
            JSONObject entry = json_array.getJSONObject(position);
            JSONObject name_object = entry.getJSONObject("summary");
            summary = name_object.getString("label");
            Log.d("ENTRY", "setNameFromRequest: name");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setTitleFromRequest(JSONObject object,int position){
        JSONArray json_array = null;
        try {
            json_array = object.getJSONArray("entry");
            JSONObject entry = json_array.getJSONObject(position);
            JSONObject name_object = entry.getJSONObject("title");
            title = name_object.getString("label");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setIdFromRequest(JSONObject object,int position){
        JSONArray json_array = null;
        try {
            json_array = object.getJSONArray("entry");
            JSONObject entry = json_array.getJSONObject(position);
            JSONObject name_object = entry.getJSONObject("id");
            app_id = name_object.getString("label");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setArtistFromRequest(JSONObject object,int position){
        JSONArray json_array = null;
        try {
            json_array = object.getJSONArray("entry");
            JSONObject entry = json_array.getJSONObject(position);
            JSONObject name_object = entry.getJSONObject("im:artist");
            artist = name_object.getString("label");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setReleaseDateFromRequest(JSONObject object,int position){
        JSONArray json_array;
        try {
            json_array = object.getJSONArray("entry");
            JSONObject entry = json_array.getJSONObject(position);
            JSONObject release_date_object = entry.getJSONObject("im:releaseDate");
            JSONObject release_date_label = release_date_object.getJSONObject("attributes");
            releaseDate = release_date_label.getString("label");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setRightsFromRequest(JSONObject object,int position){
        JSONArray json_array;
        try {
            json_array = object.getJSONArray("entry");
            JSONObject entry = json_array.getJSONObject(position);
            JSONObject rights_object = entry.getJSONObject("rights");
            rights = rights_object.getString("label");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setLinkFromRequest(JSONObject object,int position){
        JSONArray json_array;
        try {
            json_array = object.getJSONArray("entry");
            JSONObject entry = json_array.getJSONObject(position);
            JSONObject link_object = entry.getJSONObject("link");
            JSONObject link_attributes_object = link_object.getJSONObject("attributes");
            link = link_attributes_object.getString("href");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setPriceFromRequest(JSONObject object,int position){
        JSONArray json_array;
        try {
            json_array = object.getJSONArray("entry");
            JSONObject entry = json_array.getJSONObject(position);
            JSONObject price_object = entry.getJSONObject("im:price");
            JSONObject price_attributes_object = price_object.getJSONObject("attributes");
            String amount = price_attributes_object.getString("amount");
            amount = amount.substring(0,3);
            String currency = price_attributes_object.getString("currency");
            price = amount + currency;
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setCategoryFromRequest(JSONObject object,int position){
        JSONArray json_array;
        try {
            json_array = object.getJSONArray("entry");
            JSONObject entry = json_array.getJSONObject(position);
            JSONObject category_object = entry.getJSONObject("category");
            JSONObject category_attributes_object = category_object.getJSONObject("attributes");
            category = category_attributes_object.getString("label");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public void setImagesFromRequest(JSONObject object,int position){
        JSONArray json_array;
        try {
            json_array = object.getJSONArray("entry");
            JSONObject entry = json_array.getJSONObject(position);
            JSONArray image_array = entry.getJSONArray("im:image");
            image = new Image();
            for (int i = 0; i < image_array.length(); i++) {
                JSONObject json_image_object = image_array.getJSONObject(i);
                String image_url = json_image_object.getString("label");
                switch(i){
                    case 0:
                        image.setSmall_url(image_url);
                        break;  //optional
                    case 1:
                        image.setMedium_url(image_url);
                        break;  //optional
                    case 2:
                        image.setLarge_url(image_url);
                        break;
                    default:
                        break;
                }
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    public void InitializeEntry(JSONObject object,int position){

        this.setNameFromRequest(object,position);
        Log.d(TAG, "valor del entry name "+this.getName());
        this.setSummaryFromRequest(object,position);
        Log.d(TAG, "valor del summary "+this.getSummary());
        this.setTitleFromRequest(object,position);
        Log.d(TAG, "valor del title "+this.getTitle());
        this.setIdFromRequest(object,position);
        Log.d(TAG, "valor del id "+this.getApp_id());
        this.setArtistFromRequest(object,position);
        Log.d(TAG, "valor del artist "+this.getArtist());
        this.setReleaseDateFromRequest(object,position);
        Log.d(TAG, "valor del release date "+this.getReleaseDate());
        this.setRightsFromRequest(object,position);
        Log.d(TAG, "valor del rights "+this.getRights());
        this.setLinkFromRequest(object,position);
        Log.d(TAG, "valor del link "+this.getLink());
        this.setPriceFromRequest(object,position);
        Log.d(TAG, "valor del price "+this.getPrice());
        this.setCategoryFromRequest(object,position);
        Log.d(TAG, "valor de la categoria "+this.getCategory());
        this.setImagesFromRequest(object,position);
        Log.d(TAG, "Valor final: "+this.getImage().getSmall_url()+"\n"+this.getImage().getMedium_url()+"\n"+this.getImage().getLarge_url());
    }
}
