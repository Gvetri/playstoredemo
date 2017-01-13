package giuseppevetri.grabilityapp.models.apps.apps_attributes;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by giuseppe on 07/01/17.
 */

public class Image implements Parcelable {
    private String small_url,medium_url,large_url;

    public Image() {
    }

    public Image(String small_url, String medium_url, String large_url) {
        this.small_url = small_url;
        this.medium_url = medium_url;
        this.large_url = large_url;
    }

    protected Image(Parcel in) {
        small_url = in.readString();
        medium_url = in.readString();
        large_url = in.readString();
    }

    public static final Creator<Image> CREATOR = new Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    public String getSmall_url() {
        return small_url;
    }

    public void setSmall_url(String small_url) {
        this.small_url = small_url;
    }

    public String getMedium_url() {
        return medium_url;
    }

    public void setMedium_url(String medium_url) {
        this.medium_url = medium_url;
    }

    public String getLarge_url() {
        return large_url;
    }

    public void setLarge_url(String large_url) {
        this.large_url = large_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(small_url);
        dest.writeString(medium_url);
        dest.writeString(large_url);
    }
}
