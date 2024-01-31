package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.QlceConfirmationPage;
import io.cucumber.java.en.*;

public class TellUsAboutLifeChangesSteps_LR {

    QlceConfirmationPage qlceConfirmationPage = new QlceConfirmationPage();

    @Then("I select {string} QLCE on tell us about life changes page")
    public void birthLifeChange(String QLCEType){
        qlceConfirmationPage.selectLCE("Birth");
        qlceConfirmationPage.saveNContinue();
    }
}
