package giuseppevetri.grabilityapp;

import java.util.List;

import giuseppevetri.grabilityapp.models.apps.Entry;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Image;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Name;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Price;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Price_Attributes;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Summary;

/**
 * Created by giuseppe on 08/01/17.
 */

public class ApplicationPresenter implements ApplicationPresenterInterface {
    private List<Entry> entryList;

    public ApplicationPresenter() {
    }

    @Override
    public List<Entry> getApps() {
        Name name = new Name("App 1");
        Summary summary = new Summary("Super aplicacion que esta en la playstore");
        Price price = getPrice();

        Entry entry = new Entry();
        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
        entryList.add(entry);
        entryList.add(entry1);
        entryList.add(entry2);

        return entryList;

    }

    private Price getPrice() {
        Price_Attributes priceAttributes = new Price_Attributes(0.00f,"$");
        Price price = new Price(priceAttributes);
        return price;
    }

    private Image getImage() {
        Image image = null;

        return image;
    }

    public List<Entry> geta(){
        Name name = new Name("App 1");
        Summary summary = new Summary("Super aplicacion que esta en la playstore");
        Price price = getPrice();

        Entry entry = new Entry();
        Entry entry1 = new Entry();
        Entry entry2 = new Entry();
        entryList.add(entry);
        entryList.add(entry1);
        entryList.add(entry2);

        return entryList;
    }


    @Override
    public void getCategoryApps() {

    }
}
