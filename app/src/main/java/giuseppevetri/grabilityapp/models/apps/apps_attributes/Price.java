package giuseppevetri.grabilityapp.models.apps.apps_attributes;

/**
 * Created by giuseppe on 07/01/17.
 */

public class Price {
    private String label;
    private Price_Attributes price_attributes;

    public Price(String label, Price_Attributes price_attributes) {
        this.label = label;
        this.price_attributes = price_attributes;
    }

    public String getLabel() {
        return label;
    }

    public Price(Price_Attributes price_attributes) {
        this.price_attributes = price_attributes;
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

    public String getPriceWithCurrency(){
        String amount = String.valueOf(this.getPrice_attributes().getAmount());
        String currency = this.getPrice_attributes().getCurrency();
        return amount+currency;
    }
}
