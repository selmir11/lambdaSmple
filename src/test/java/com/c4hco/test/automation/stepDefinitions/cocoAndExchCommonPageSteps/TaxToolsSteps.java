package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.TaxToolsPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.Then;

public class TaxToolsSteps {
    TaxToolsPage taxToolsPage = new TaxToolsPage(WebDriverManager.getDriver());
    @Then("I enter for one member {string} and {string} {string} and validate {string} {string} {string}")
    public void iEnterForOneMemberAndAndValidate(String zipCode, String county,String age,  String ExpectedPremium, String ExpectedProvider, String ExpectedPlan) {
        taxToolsPage.enterForOneMemberAndAndValidate(zipCode, county,age, ExpectedPremium, ExpectedProvider,ExpectedPlan);
    }


    @Then("I enter for one member {string} and {string} {string} second member {string}and validate {string} {string} {string}")
    public void iEnterForOneMemberAndSecondMemberAndValidate(String zipCode, String county,String age, String age2, String ExpectedPremium, String ExpectedProvider, String ExpectedPlan) {
        taxToolsPage.validatePlanForTwoMembers(zipCode, county,age, age2, ExpectedPremium, ExpectedProvider,ExpectedPlan);
    }

    @Then("I enter for one member {string} and {string} {string} second member {string} third member {string} and validate {string} {string} {string}")
    public void iEnterForOneMemberAndSecondMemberThirdMemberAndValidate(String zipCode, String county,String age, String age2,String age3, String ExpectedPremium, String ExpectedProvider, String ExpectedPlan) {
        taxToolsPage.validatePlanFor3Members(zipCode, county,age, age2, age3, ExpectedPremium, ExpectedProvider,ExpectedPlan);
    }

    @Then("I enter for one member {string} and {string} {string} second member {string} third member {string} fourth member {string}and validate {string} {string} {string}")
    public void iEnterForOneMemberAndSecondMemberThirdMemberFourthMemberAndValidate(String zipCode, String county,String age, String age2,String age3, String age4,String ExpectedPremium, String ExpectedProvider, String ExpectedPlan) {
        taxToolsPage.validatePlanFor4Members(zipCode, county,age, age2, age3, age4,ExpectedPremium, ExpectedProvider,ExpectedPlan);
    }

    @Then("I enter for one member {string} and {string} {string} second member {string} third member {string} fourth member {string} fifth member {string} and validate {string} {string} {string}")
    public void iEnterForOneMemberAndSecondMemberThirdMemberFourthMemberFifthMemberAndValidate(String zipCode, String county,String age, String age2,String age3, String age4,String age5,String ExpectedPremium, String ExpectedProvider, String ExpectedPlan) {
        taxToolsPage.validatePlanFor5Members(zipCode, county,age, age2, age3, age4,age5, ExpectedPremium, ExpectedProvider,ExpectedPlan);
    }

    @Then("I enter for one member {string} and {string} {string} second member {string} third member {string} fourth member {string} fifth member {string} sixth member {string} and validate {string} {string} {string}")
    public void iEnterForOneMemberAndSecondMemberThirdMemberFourthMemberFifthMemberSixthMemberAndValidate(String zipCode, String county,String age, String age2,String age3, String age4,String age5,String age6,String ExpectedPremium, String ExpectedProvider, String ExpectedPlan) {
        taxToolsPage.validatePlanFor6Members(zipCode, county,age, age2, age3, age4,age5,age6, ExpectedPremium, ExpectedProvider,ExpectedPlan);
    }
}
