package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.LifeChangeEventsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class LifeChangeEventsPageSteps {
    LifeChangeEventsPage lifeChangeEventsPage = new LifeChangeEventsPage(WebDriverManager.getDriver());


    @And("I report {string} and click continue")
    public void iClickQLCEOption(String lceOption){
        lifeChangeEventsPage.selectLCE(lceOption);
    }

    @And("I click Continue button on Report a Life Change Page")
    public void iClickContinueWithApplication(){
        lifeChangeEventsPage.clickContinueWithApplication();
    }

    @And("I validate the verbiage on the Report a life change page in {string}")
    public void iValidateTheVerbiageOnTheReportALifeChangePageIn(String language) {
        lifeChangeEventsPage.validateTheVerbiageOnReportALifeChangePage(language);
    }

    @And("I validate the header on the Report a life change in {string}")
    public void iValidateTheHeaderOnReportALifeChangePage(String language) {
        lifeChangeEventsPage.validateTheHeaderOnReportALifeChangePage(language);
    }

}
