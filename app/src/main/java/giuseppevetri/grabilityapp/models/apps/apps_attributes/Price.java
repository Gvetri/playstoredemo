package giuseppevetri.grabilityapp.models.apps.apps_attributes;

/**
 * Created by giuseppe on 07/01/17.
 */

public class Price {
    private String label;
    private Price_Attributes price_attributes;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Price_Attributes getPrice_attributes() {
        return price_attributes;
    }

    public void setPrice_attributes(Price_Attributes price_attributes) {
        this.price_attributes = price_attributes;
    }
}
