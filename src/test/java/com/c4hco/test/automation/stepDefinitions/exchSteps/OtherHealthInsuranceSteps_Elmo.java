package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OtherHealthInsurancePage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OtherHealthInsuranceSteps_Elmo {
    OtherHealthInsurancePage_Elmo otherHealthInsurancePage_Elmo = new OtherHealthInsurancePage_Elmo(WebDriverManager.getDriver());

    @Then("I select {string} as ELMO health insurance option")
    public void iSelectInsuranceOptionOnly(String insuranceOption){
        otherHealthInsurancePage_Elmo.selectInsuranceOptionOnly(insuranceOption);
    }


    @Then("I click continue on the ELMO health insurance page")
    public void iClickSaveAndContinue(){otherHealthInsurancePage_Elmo.clickSaveAndContinue();}

    @Then("I verify help text in {string} for {string} question on the Other Health Insurance page")
    public void iVerifyHelpTextForQuestions(String language, String insurance){
        otherHealthInsurancePage_Elmo.verifyHelpDrawerTextForQuestions(language, insurance);
    }

    @Then("I verify help drawer header text in {string} on the Other Health Insurance page")
    public void iVerifyHelpDrawerHeader(String language){
        otherHealthInsurancePage_Elmo.verifyHelpDrawerHeaderText(language);
    }

    @Then("I verify help drawer body text in {string} on the Other Health Insurance page")
    public void iVerifyHelpDrawerBody(String language){
        otherHealthInsurancePage_Elmo.verifyHelpDrawerBodyText(language);
    }

    @Then("I verify help drawer footer text in {string} on the Other Health Insurance page")
    public void iVerifyHelpDrawerFooter(String language){
        otherHealthInsurancePage_Elmo.verifyHelpDrawerFooterText(language);
    }




    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify text on the Other Health Insurance page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String language){
        otherHealthInsurancePage_Elmo.verifyTextOnOtherHealthInsurancePage(language);
    }
    @And("I verify the checkboxes on the Other Health Insurance page")
    public void iVerifyCheckboxesOnOtherHealthInsurancePage(){
        otherHealthInsurancePage_Elmo.verifyCheckboxesOnOtherHealthInsurancePage();
    }
    @And("I verify help icons on the Other Health Insurance page")
    public void iVerifyHelpIconsOnOtherHealthInsurancePage(){
        otherHealthInsurancePage_Elmo.verifyHelIconsOnOtherHealthInsurancePage();
    }
    @And("I verify the header for Primary Member on the Other Health Insurance page")
    public void iVerifyHeadersOtherHealthInsurancePageEnglish(){otherHealthInsurancePage_Elmo.verifyHeadersOtherHealthInsurancePageEnglish();}
    @And("I validate Other Health Insurance options load {string}")
    public void iVerifyCheckboxesAttribute(String checkboxExpected){otherHealthInsurancePage_Elmo.verifyCheckboxesAttribute(checkboxExpected);}

    @And("I verify error message in {string} on the Other Health Insurance page")
    public void iVerifyErrorMessage(String language){otherHealthInsurancePage_Elmo.verifyErrorMessage(language);}

    @And("I verify error message does not show for Individual Insurance page")
    public void iVerifyNoErrorMessage()  {otherHealthInsurancePage_Elmo.verifyNoErrorMessage();}

    @And("I verify the text on Other Health Insurance page data in {string}")
    public void iVerifyVaHealthcarePageData(String language) {otherHealthInsurancePage_Elmo.verifyOhiPageData(language);}

    @And("I click Help me understand this page link on the Other Health Insurance page")
    public void iClickHelpMeUnderstandThisPageLink(){
        otherHealthInsurancePage_Elmo.clickHelpMeUnderstandLink();
    }

    @And("I click Help side button on the Other Health Insurance page")
    public void iClickHelpSideButton(){
        otherHealthInsurancePage_Elmo.clickHelpSideButton();
    }


}
