package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhcHraPage_Elmo;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhcHraSteps_Elmo {
    OhcHraPage_Elmo ohcHraPage_Elmo = new OhcHraPage_Elmo(WebDriverManager.getDriver());

    @Then("I click continue on the Elmo OHI HRA page")
    public void iClickSaveAndContinue(){ohcHraPage_Elmo.clickSaveAndContinue();}

    @Then("I click Go Back on the Elmo OHI HRA page")
    public void iClickGoBack(){ohcHraPage_Elmo.clickGoBack();}

    @Then("I select Current Year year dropdown on the Elmo OHI HRA page")
    public void iClickYear(){ohcHraPage_Elmo.clickYear();}

    @Then("I enter {string} amount on the Elmo OHI HRA page")
    public void iEnterAmount(String amount){ohcHraPage_Elmo.enterAmount(amount);}

    @Then("I select {string} for HRA type")
    public void iSelectHraType(String type){ohcHraPage_Elmo.selectHraType(type);}

    @Then("I select {string} for opt out on the Elmo OHI HRA page")
    public void iSelectOptOut(String aptc){ohcHraPage_Elmo.selectOptOut(aptc);}

    @And("I select {string} icon on the HRA Page")
    public void iSelectHelpIcon(String labelIcon){ohcHraPage_Elmo.clickHelpIcon(labelIcon);}

    @And("I click HRA Contact Us link in help drawer footer")
    public void iClickHelpContactUsLink(){ohcHraPage_Elmo.clickHelpContactUsNavigation();}









    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the HRA page in {string}")
    public void iVerifyTextOnOtherHealthInsurancePage(String language){ohcHraPage_Elmo.verifyHeadersHraOhcPage(language);}

    @And("I verify the {string} amount {string} HRA page data in {string}")
    public void iVerifyHraPage(String dataToVerify, String expectedIncome, String language) {ohcHraPage_Elmo.verifyHraData(dataToVerify, expectedIncome, language);}

    @And("I verify year is {string}, amount is {string}, type is {string}, {string} APTC question {string} on the HRA page")
    public void iVerifyEnrolledOption(String year, String amount, String type, String withOrWithout, String aptc){ohcHraPage_Elmo.verifyEnrolledOption(year, amount, type, withOrWithout, aptc);}

    @And("I verify the {string} HRA page data in {string}")
    public void iVerifyHraPageData(String dataToVerify, String language) {ohcHraPage_Elmo.verifyHraPageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the HRA page")
    public void iVerifyErrorMessage(String errorType, String language){ohcHraPage_Elmo.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for HRA page")
    public void iVerifyNoErrorMessage(String errorType)  {ohcHraPage_Elmo.verifyNoErrorMessage(errorType);}

    @Then("I validate HRA help drawer verbiage in {string}")
    public void iValidateHelp(String language){ohcHraPage_Elmo.validateHelpVerbiage(language);}

    @Then("I validate HRA dropdown options for {string}")
    public void iValidateDropdownOptions(String dateType){ohcHraPage_Elmo.validateDropdownOptions(dateType);}

    @And("I select {string} option on the HRA page")
    public void iSelectYearOption(String year){ohcHraPage_Elmo.selectYearOption(year);}





}
