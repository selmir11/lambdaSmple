package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.LifeChangeEventsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class LifeChangeEventsPageSteps {
    LifeChangeEventsPage lifeChangeEventsPage = new LifeChangeEventsPage(WebDriverManager.getDriver());


    @And("I report {string} and click continue")
    public void iClickQLCEOption(String lceOption){
        lifeChangeEventsPage.selectLCE(lceOption);
    }

    @And("I click Continue With Application button on Report Life Change Page")
    public void iClickContinueWithApplication(){
        lifeChangeEventsPage.clickContinueWithApplication();
    }

    @Then("I click back button on Report a Life Change Page")
    public void iClickOnBackButton(){
        lifeChangeEventsPage.clickBackButton();
    }

    @And("I validate the verbiage on the Report a life change page in {string}")
    public void iValidateTheVerbiageOnTheReportALifeChangePageIn(String language) {
        lifeChangeEventsPage.validateTheVerbiageOnReportALifeChangePage(language);
    }

    @And("I validate the header on the Report a life change in {string}")
    public void iValidateTheHeaderOnReportALifeChangePage(String language) {
        lifeChangeEventsPage.validateTheHeaderOnReportALifeChangePage(language);
    }

    @Then("I click on the help drawer icon on the page")
    public void iClickOnTheHelpDrawerIconOnThePage() {
        lifeChangeEventsPage.clickHelpDrawerIcon();
    }

    @And("I validate the below help drawer text in {string}")
    public void iValidateTheBelowHelpDrawerTextIn(String language, List<String> data) {
        lifeChangeEventsPage.validateHelpDrawerText(language, data);
    }

    @Then("I click on the help icon next to special requirement option")
    public void iClickOnTheHelpIconNextToSpecialRequirementOption() {
        lifeChangeEventsPage.clickHelpIconNextToSpecialRequirement();
    }

    @And("I click Help me understand this page link on Report a Life change Page")
    public void iClickHelpMeUnderstandThisPageLink(){
        lifeChangeEventsPage.clickHelpMeUnderstandLink();
    }
}
