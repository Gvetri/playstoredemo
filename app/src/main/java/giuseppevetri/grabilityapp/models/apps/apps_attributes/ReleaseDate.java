package giuseppevetri.grabilityapp.models.apps.apps_attributes;

/**
 * Created by giuseppe on 07/01/17.
 */

public class ReleaseDate {
    private String label;
    private ReleaseDate_Attributes releaseDateAttributes;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public ReleaseDate_Attributes getReleaseDateAttributes() {
        return releaseDateAttributes;
    }

    public void setReleaseDateAttributes(ReleaseDate_Attributes releaseDateAttributes) {
        this.releaseDateAttributes = releaseDateAttributes;
    }
}
