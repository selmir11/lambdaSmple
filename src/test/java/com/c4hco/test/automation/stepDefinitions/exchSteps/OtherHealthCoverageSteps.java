package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OtherHealthCoveragePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class OtherHealthCoverageSteps {
    OtherHealthCoveragePage otherHealthCoveragePage = new OtherHealthCoveragePage(WebDriverManager.getDriver());

    @Then("I select {string} as health coverage option")
    public void iSelectInsuranceOptionOnly(String insuranceOption){otherHealthCoveragePage.selectInsuranceOptionOnly(insuranceOption);}

    @Then("I click continue on the health coverage page")
    public void iClickSaveAndContinue(){otherHealthCoveragePage.clickSaveAndContinue();}

    @Then("I click Go back on the health coverage page")
    public void iClickGoBack(){otherHealthCoveragePage.clickGoBack();}

    @And("I click Help me understand this page link on the Other Health Coverage page")
    public void iClickHelpMeUnderstandThisPageLink(){
        otherHealthCoveragePage.clickHelpMeUnderstandLink();
    }

    @And("I click Help side button on the Other Health Coverage page")
    public void iClickHelpSideButton(){
        otherHealthCoveragePage.clickHelpSideButton();
    }

    @And("I click Contact Us link in help drawer footer of the Other Health Coverage page")
    public void iClickHelpContactUsLink(){otherHealthCoveragePage.clickHelpContactUsNavigation();}


    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify text on the Other Health Coverage page in {string}")
    public void iVerifyTextOnOtherHealthCoveragePage(String language){otherHealthCoveragePage.verifyTextOnOtherHealthCoveragePage(language);}

    @And("I verify the checkboxes on the Other Health Coverage page")
    public void iVerifyCheckboxesOnOtherHealthCoveragePage(){otherHealthCoveragePage.verifyCheckboxesOnOtherHealthCoveragePage();}

    @And("I verify help icons on the Other Health Coverage page")
    public void iVerifyHelpIconsOnOtherHealthCoveragePage(){otherHealthCoveragePage.verifyHelIconsOnOtherHealthCoveragePage();}

    @And("I verify the header for {string} Member on the Other Health Coverage page in {string}")
    public void iVerifyHeadersOtherHealthCoveragePage(String member, String language){otherHealthCoveragePage.verifyHeadersOtherHealthCoveragePage(member, language);}

    @And("I validate Other Health Coverage options load {string}")
    public void iVerifyCheckboxesAttribute(String checkboxExpected){otherHealthCoveragePage.verifyCheckboxesAttribute(checkboxExpected);}

    @And("I verify error message in {string} on the Other Health Coverage page")
    public void iVerifyErrorMessage(String language){otherHealthCoveragePage.verifyErrorMessage(language);}

    @And("I verify error message does not show for Individual Insurance page")
    public void iVerifyNoErrorMessage()  {otherHealthCoveragePage.verifyNoErrorMessage();}

    @And("I verify the text on Other Health Coverage page data in {string}")
    public void iVerifyVaHealthcarePageData(String language) {otherHealthCoveragePage.verifyOhcPageData(language);}

    @Then("I verify help text in {string} for {string} question on the Other Health Coverage page")
    public void iVerifyHelpTextForQuestions(String language, String insurance){otherHealthCoveragePage.verifyHelpDrawerTextForQuestions(language, insurance);}

    @Then("I verify help drawer header text in {string} on the Other Health Coverage page")
    public void iVerifyHelpDrawerHeader(String language){otherHealthCoveragePage.verifyHelpDrawerHeaderText(language);}

    @Then("I verify help drawer body text in {string} on the Other Health Coverage page")
    public void iVerifyHelpDrawerBody(String language){otherHealthCoveragePage.verifyHelpDrawerBodyText(language);}

    @Then("I verify help drawer footer text in {string} on the Other Health Coverage page")
    public void iVerifyHelpDrawerFooter(String language){otherHealthCoveragePage.verifyHelpDrawerFooterText(language);}

    @Then("I verify main OHC checkbox in {string} state")
    public void iVerifyStateOfMainOHCCheckboxes(String state){
        otherHealthCoveragePage.verifyMainOHCCheckboxes(state);}

    @Then("I verify insurance options selected on the Other Health Coverage page")
    public void iValidateSelectingInsuranceOptions(DataTable insuranceOptionsTable) {
        otherHealthCoveragePage.verifyInsuranceOptions(insuranceOptionsTable);
    }

    @Then("I validate font colour format of the text in employee sponsored page")
    public void iValidateFontColourFormatOfTheTextInEmployeeSponsoredPage() {
        otherHealthCoveragePage.validateFontColorSizeWhenNoJob();
    }

    @Then("I validate below texts in employee sponsored page")
    public void iValidateTheBelowTextsInEmployeeSponsoredPage(List<String> pageTexts) {
        otherHealthCoveragePage.validatePageTextESPage(pageTexts);
    }

    @When("I click on go back button in employee sponsored page")
    public void iClickOnGoBackButtonInEmployeeSponsoredPage() {
        otherHealthCoveragePage.clickOnGoBackBtnESPage();
    }

    @Then("I validate font colour format of the text when one job added")
    public void iValidateFontColourFormatOfTheTextWhenOneJobAdded() {
        otherHealthCoveragePage.validateFontColorSizeTextWhenOneJobAdded();
    }

    @When("I select the first option in which_job_is_offering dropdown")
    public void iSelectTheFirstOptionInWhichJobIsOfferingDropdown() {
        otherHealthCoveragePage.selectFirstOptInWhichJobIsOfferingDropdown();
    }

    @Then("I validate font colour etc when option is selected")
    public void iValidateFontColourEtcWhenOptionIsSelected() {
        otherHealthCoveragePage.validateColorFontSizeWhenOptionIsSelected();
    }

    @When("I click {string} in Are you currently enrolled question")
    public void iClickInAreYouCurrentlyEnrolledQuestion(String btnName) {
        otherHealthCoveragePage.clickOnAreYouCurrentlyEnrolledQstn(btnName);
    }

    @Then("I validate color border font when Are-you-currently-enrolled is {string}")
    public void iValidateColorBorderFontWhenAreYouCurrentlyEnrolledIs(String btnName) {
        otherHealthCoveragePage.validateColorFontSizeBorderWhenAreYouCurrentlyEnrolled(btnName);
    }

    @When("I select {string} in Will this health insurance end question")
    public void iSelectInWillThisHealthInsuranceEndQuestion(String btnName) {
        otherHealthCoveragePage.clickOnWillThisHealthInsuranceEndQuestion(btnName);
    }

    @Then("I validate when Will_this_health_insurance is Yes")
    public void iValidateWhenWill_this_health_insuranceIs() {
        otherHealthCoveragePage.validateColorFontSizeBorderWhenWillThisHealthInsurance();
    }
}
