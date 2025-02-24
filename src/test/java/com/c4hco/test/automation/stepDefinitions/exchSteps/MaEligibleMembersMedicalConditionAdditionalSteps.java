package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MaEligibleMembersMedicalConditionAdditionalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MaEligibleMembersMedicalConditionAdditionalSteps {

    MaEligibleMembersMedicalConditionAdditionalPage maEligibleMembersMedicalConditionAdditionalPage = new MaEligibleMembersMedicalConditionAdditionalPage(WebDriverManager.getDriver());
    
    @And("I validate the {string} text on the Medical Condition Additional MA page")
    public void iValidateMedicalConditionAdditionalText(String language) {maEligibleMembersMedicalConditionAdditionalPage.iValidateMedicalConditionAdditionalText( language );}

    @And("I select the medical condition date on the Medical Condition Additional MA page")
    public void iValidateMedicalConditionText() {maEligibleMembersMedicalConditionAdditionalPage.iselectMedicalConditionDate();}

    @And("I click continue on the Medical Condition Additional MA page")
    public void iContinue() {maEligibleMembersMedicalConditionAdditionalPage.iContinue();}


}
