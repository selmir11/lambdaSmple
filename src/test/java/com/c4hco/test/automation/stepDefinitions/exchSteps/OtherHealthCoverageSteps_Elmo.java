package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OtherHealthCoveragePage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OtherHealthCoverageSteps_Elmo {
    OtherHealthCoveragePage_Elmo otherHealthCoveragePage_Elmo = new OtherHealthCoveragePage_Elmo(WebDriverManager.getDriver());

    @Then("I select {string} as ELMO health coverage option")
    public void iSelectInsuranceOptionOnly(String insuranceOption){otherHealthCoveragePage_Elmo.selectInsuranceOptionOnly(insuranceOption);}

    @Then("I click continue on the ELMO health coverage page")
    public void iClickSaveAndContinue(){otherHealthCoveragePage_Elmo.clickSaveAndContinue();}

    @Then("I click Go back on the ELMO health coverage page")
    public void iClickGoBack(){otherHealthCoveragePage_Elmo.clickGoBack();}

    @And("I click Help me understand this page link on the Other Health Coverage page")
    public void iClickHelpMeUnderstandThisPageLink(){
        otherHealthCoveragePage_Elmo.clickHelpMeUnderstandLink();
    }

    @And("I click Help side button on the Other Health Coverage page")
    public void iClickHelpSideButton(){
        otherHealthCoveragePage_Elmo.clickHelpSideButton();
    }

    @And("I click Contact Us link in help drawer footer of the Other Health Coverage page")
    public void iClickHelpContactUsLink(){otherHealthCoveragePage_Elmo.clickHelpContactUsNavigation();}


    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify text on the Other Health Coverage page in {string}")
    public void iVerifyTextOnOtherHealthCoveragePage(String language){otherHealthCoveragePage_Elmo.verifyTextOnOtherHealthCoveragePage(language);}

    @And("I verify the checkboxes on the Other Health Coverage page")
    public void iVerifyCheckboxesOnOtherHealthCoveragePage(){otherHealthCoveragePage_Elmo.verifyCheckboxesOnOtherHealthCoveragePage();}

    @And("I verify help icons on the Other Health Coverage page")
    public void iVerifyHelpIconsOnOtherHealthCoveragePage(){otherHealthCoveragePage_Elmo.verifyHelIconsOnOtherHealthCoveragePage();}

    @And("I verify the header for {string} Member on the Other Health Coverage page in {string}")
    public void iVerifyHeadersOtherHealthCoveragePage(String member, String language){otherHealthCoveragePage_Elmo.verifyHeadersOtherHealthCoveragePage(member, language);}

    @And("I validate Other Health Coverage options load {string}")
    public void iVerifyCheckboxesAttribute(String checkboxExpected){otherHealthCoveragePage_Elmo.verifyCheckboxesAttribute(checkboxExpected);}

    @And("I verify error message in {string} on the Other Health Coverage page")
    public void iVerifyErrorMessage(String language){otherHealthCoveragePage_Elmo.verifyErrorMessage(language);}

    @And("I verify error message does not show for Individual Insurance page")
    public void iVerifyNoErrorMessage()  {otherHealthCoveragePage_Elmo.verifyNoErrorMessage();}

    @And("I verify the text on Other Health Coverage page data in {string}")
    public void iVerifyVaHealthcarePageData(String language) {otherHealthCoveragePage_Elmo.verifyOhcPageData(language);}

    @Then("I verify help text in {string} for {string} question on the Other Health Coverage page")
    public void iVerifyHelpTextForQuestions(String language, String insurance){otherHealthCoveragePage_Elmo.verifyHelpDrawerTextForQuestions(language, insurance);}

    @Then("I verify help drawer header text in {string} on the Other Health Coverage page")
    public void iVerifyHelpDrawerHeader(String language){otherHealthCoveragePage_Elmo.verifyHelpDrawerHeaderText(language);}

    @Then("I verify help drawer body text in {string} on the Other Health Coverage page")
    public void iVerifyHelpDrawerBody(String language){otherHealthCoveragePage_Elmo.verifyHelpDrawerBodyText(language);}

    @Then("I verify help drawer footer text in {string} on the Other Health Coverage page")
    public void iVerifyHelpDrawerFooter(String language){otherHealthCoveragePage_Elmo.verifyHelpDrawerFooterText(language);}

    @Then("I verify main OHC checkbox in {string} state")
    public void iVerifyStateOfMainOHCCheckboxes(String state){
        otherHealthCoveragePage_Elmo.verifyMainOHCCheckboxes(state);}

    @Then("I validate selecting insurance options")
    public void iValidateSelectingInsuranceOptions(DataTable insuranceOptionsTable) {
        otherHealthCoveragePage_Elmo.selectInsuranceOptions(insuranceOptionsTable);
    }

}
