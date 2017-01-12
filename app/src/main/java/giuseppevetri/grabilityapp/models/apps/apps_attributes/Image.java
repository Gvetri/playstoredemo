package giuseppevetri.grabilityapp.models.apps.apps_attributes;

/**
 * Created by giuseppe on 07/01/17.
 */

public class Image {
    private String label;
    private Image_Attributes imageAttribute;

    public Image(String label, Image_Attributes imageAttribute) {
        this.label = label;
        this.imageAttribute = imageAttribute;
    }


    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Image_Attributes getImageAttribute() {
        return imageAttribute;
    }

    public void setImageAttribute(Image_Attributes imageAttribute) {
        this.imageAttribute = imageAttribute;
    }
}
