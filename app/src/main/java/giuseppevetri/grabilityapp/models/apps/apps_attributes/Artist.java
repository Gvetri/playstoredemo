package giuseppevetri.grabilityapp.models.apps.apps_attributes;

/**
 * Created by giuseppe on 07/01/17.
 */

public class Artist {
    private String label;
    private Artist_Attributes artistAttributes;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Artist_Attributes getArtistAttributes() {
        return artistAttributes;
    }

    public void setArtistAttributes(Artist_Attributes artistAttributes) {
        this.artistAttributes = artistAttributes;
    }
}
