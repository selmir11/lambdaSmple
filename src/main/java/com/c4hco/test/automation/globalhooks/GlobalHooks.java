package com.c4hco.test.automation.globalhooks;

import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;
import com.c4hco.test.automation.utils.ApplicationProperties;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.PropertyFile;


public class GlobalHooks implements En{

    private GlobalHooks lastInstance;
    private BasicActions basicActions = new BasicActions();

    public GlobalHooks() {
        Before((Scenario scenario) -> {
            System.out.println("Before Called");
        });
        After((Scenario scenario) -> {
         //   this.basicActions.getInstance().closeBrowser();
            System.out.println("After Called");
          //  WebDriverManager.closeDriver();
        });
    }

}