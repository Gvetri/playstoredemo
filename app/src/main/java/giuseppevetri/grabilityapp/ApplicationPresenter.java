package giuseppevetri.grabilityapp;

import java.util.List;

import giuseppevetri.grabilityapp.models.apps.App;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Image;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Name;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Price;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Price_Attributes;
import giuseppevetri.grabilityapp.models.apps.apps_attributes.Summary;

/**
 * Created by giuseppe on 08/01/17.
 */

public class ApplicationPresenter implements ApplicationPresenterInterface {
    private List<App> appList;

    public ApplicationPresenter() {
    }

    @Override
    public List<App> getApps() {
        Name name = new Name("App 1");
        Summary summary = new Summary("Super aplicacion que esta en la playstore");
        Price price = getPrice();

        App app = new App(name,summary,price);
        App app1 = new App(name,summary,price);
        App app2 = new App(name,summary,price);
        appList.add(app);
        appList.add(app1);
        appList.add(app2);

        return appList;

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

    public List<App> geta(){
        Name name = new Name("App 1");
        Summary summary = new Summary("Super aplicacion que esta en la playstore");
        Price price = getPrice();

        App app = new App(name,summary,price);
        App app1 = new App(name,summary,price);
        App app2 = new App(name,summary,price);
        appList.add(app);
        appList.add(app1);
        appList.add(app2);

        return appList;
    }


    @Override
    public void getCategoryApps() {

    }
}
