package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.QlceConfirmationPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;

public class QlceConfirmationPageSteps {

    QlceConfirmationPage qlceConfirmationPage = new QlceConfirmationPage(WebDriverManager.getDriver());

    @Then("I select {string} QLCE on tell us about life changes page")
    public void selectQlceType(String qlceOption){
        qlceConfirmationPage.selectQLCE(qlceOption);
    }

    // WIP- rewrite this step
    @Then("I select Birth QLCE on tell us about life changes page with dob type {string}")
    public void selectQlceTypeforlastmemebr(String dobType) {
        qlceConfirmationPage.selectBirthLCE(dobType);
    }

    @Then("I click on Save and Continue")
    public void saveAndContinue(){
        qlceConfirmationPage.saveAndContinue();
    }
}
