package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.PrescreenPage;
import io.cucumber.java8.En;

public class PreScreenPageSteps implements En {
    public PreScreenPageSteps() {
        PrescreenPage prescreenPage = new PrescreenPage();

        And("I click create my account from pre-screen page", () -> {
            prescreenPage.clickCreateAccountLink();
        });

        And("I validate I am on the pre-screen page", () -> {
            prescreenPage.validatePreScreenPage();
        });

    }
}
