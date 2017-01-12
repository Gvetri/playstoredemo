package giuseppevetri.grabilityapp;

import java.util.List;

import giuseppevetri.grabilityapp.models.apps.App;

/**
 * Created by giuseppe on 08/01/17.
 */
public interface ApplicationPresenterInterface {

    List<App> getApps();
    void getCategoryApps();

}
