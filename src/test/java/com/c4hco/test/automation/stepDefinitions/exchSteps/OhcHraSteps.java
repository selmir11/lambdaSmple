package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcHraPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class OhcHraSteps {
    OhcHraPage ohcHraPage = new OhcHraPage(WebDriverManager.getDriver());

    @Then("I click continue on the OHC HRA page")
    public void iClickSaveAndContinue(){ohcHraPage.clickSaveAndContinue();}

    @Then("I click Go Back on the OHC HRA page")
    public void iClickGoBack(){ohcHraPage.clickGoBack();}

    @Then("I select Current Year year dropdown on the OHC HRA page")
    public void iClickYear(){ohcHraPage.clickYear();}

    @Then("I enter {string} amount on the OHC HRA page")
    public void iEnterAmount(String amount){ohcHraPage.enterAmount(amount);}

    @Then("I select {string} for HRA type")
    public void iSelectHraType(String type){ohcHraPage.selectHraType(type);}

    @Then("I select {string} for opt out on the OHC HRA page")
    public void iSelectOptOut(String aptc){ohcHraPage.selectOptOut(aptc);}

    @And("I select {string} icon on the HRA Page")
    public void iSelectHelpIcon(String labelIcon){ohcHraPage.clickHelpIcon(labelIcon);}

    @And("I click HRA Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){ohcHraPage.clickHelpContactUsNavigation();}









    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the HRA page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String language){ohcHraPage.verifyHeadersHraOhcPage(language);}

    @And("I verify the {string} amount {string} HRA page data in {string}")
    public void iVerifyHraPage(String dataToVerify, String expectedIncome, String language) {ohcHraPage.verifyHraData(dataToVerify, expectedIncome, language);}

    @And("I verify year is {string}, amount is {string}, type is {string}, {string} APTC question {string} on the HRA page")
    public void iVerifyEnrolledOption(String year, String amount, String type, String withOrWithout, String aptc){ohcHraPage.verifyEnrolledOption(year, amount, type, withOrWithout, aptc);}

    @And("I verify the {string} HRA page data in {string}")
    public void iVerifyHraPageData(String dataToVerify, String language) {ohcHraPage.verifyHraPageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the HRA page")
    public void iVerifyErrorMessage(String errorType, String language){ohcHraPage.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for HRA page")
    public void iVerifyNoErrorMessage(String errorType)  {ohcHraPage.verifyNoErrorMessage(errorType);}

    @Then("I validate HRA help drawer verbiage in {string}")
    public void iValidateHelp(String language){ohcHraPage.validateHelpVerbiage(language);}

    @Then("I validate HRA dropdown options for {string}")
    public void iValidateDropdownOptions(String dateType){ohcHraPage.validateDropdownOptions(dateType);}

    @And("I select {string} option on the HRA page")
    public void iSelectYearOption(String year){ohcHraPage.selectYearOption(year);}

    @And("I validate that, after selecting ICHRA the message is displayed in OHC HRA Page")
    public void iValidateThatAfterSelectingICHRATheMessageIsDisplayedInInOHCHRAPage( List<String> messege) {
        ohcHraPage.validateICHRAmessagedisplayed(messege);
    }



}
