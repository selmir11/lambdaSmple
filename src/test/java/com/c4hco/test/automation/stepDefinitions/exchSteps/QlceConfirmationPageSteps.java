package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.QlceConfirmationPage;
import io.cucumber.java.en.*;

public class QlceConfirmationPageSteps {

    QlceConfirmationPage qlceConfirmationPage = new QlceConfirmationPage();

    @Then("I select {string} QLCE on tell us about life changes page")
    public void selectQlceType(String qlceOption){
        qlceConfirmationPage.selectQLCE(qlceOption);
        // Move the below to a different step
        qlceConfirmationPage.saveNContinue();
    }
}
