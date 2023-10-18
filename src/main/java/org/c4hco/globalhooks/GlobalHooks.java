package org.c4hco.globalhooks;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import org.c4hco.utils.ApplicationProperties;
import org.c4hco.utils.BasicActions;
import org.c4hco.utils.PropertyFile;


public class GlobalHooks implements En{

    private GlobalHooks lastInstance;
    private BasicActions basicActions = new BasicActions();

    public GlobalHooks() {
        Before((Scenario scenario) -> {
            System.out.println("Before Called");
            PropertyFile getEnvironment = new PropertyFile(ApplicationProperties.getInstance().getProperty("env"));
            String url = getEnvironment.getProperty("url");
            System.out.println("ENV URL::"+url);
        });
        After((Scenario scenario) -> {
            this.basicActions.getInstance().closeBrowser();
            System.out.println("After Called");

        });
    }

}