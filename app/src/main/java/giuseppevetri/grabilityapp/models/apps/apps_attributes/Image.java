package giuseppevetri.grabilityapp.models.apps.apps_attributes;

/**
 * Created by giuseppe on 07/01/17.
 */

public class Image {
    private String small_url,medium_url,large_url;

    public Image() {
    }

    public Image(String small_url, String medium_url, String large_url) {
        this.small_url = small_url;
        this.medium_url = medium_url;
        this.large_url = large_url;
    }

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
}
