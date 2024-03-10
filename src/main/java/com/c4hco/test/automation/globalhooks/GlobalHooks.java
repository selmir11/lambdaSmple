package com.c4hco.test.automation.globalhooks;

import io.cucumber.java8.En;
import io.cucumber.java8.Scenario;


public class GlobalHooks implements En{

    public GlobalHooks() {
        Before((Scenario scenario) -> {
        });

        After((Scenario scenario) -> {
         //  WebDriverManager.closeDriver();
        });
    }

}