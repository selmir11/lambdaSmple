package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.LifeChangeEventsCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;

public class LifeChangeEventsCoCoPageSteps {
    LifeChangeEventsCoCoPage lifeChangeEventsCoCoPage = new LifeChangeEventsCoCoPage(WebDriverManager.getDriver());

    @And("I select {string} life change event with event date of {string}")
    public void selectQLCEOption(String lceOption, String dateType){lifeChangeEventsCoCoPage.selectLCE(lceOption, dateType);}

    @And("I check {string} life change event checkbox")
    public void selectQLCEOptionCheckbox(String lceOption){lifeChangeEventsCoCoPage.selectLCECheckbox(lceOption);}

    @And("I select all members of {string} Life Change Event")
    public void selectMemberForLCEOption(String lifeChangeEvent){lifeChangeEventsCoCoPage.selectMemberForLCE(lifeChangeEvent);}

    @And("I set date for all members of {string} Life Change Event to event date of {string}")
    public void iSetDateForLCE(String lifeChangeEvent, String dateType){lifeChangeEventsCoCoPage.setDateForLCE(lifeChangeEvent, dateType);}

    @And("I select continue on the LCE page")
    public void selectSaveAndContinue(){lifeChangeEventsCoCoPage.saveAndContinue();}

    @And("I select Go Back on the LCE page")
    public void selectGoBack(){lifeChangeEventsCoCoPage.goBack();}





    // ############################## VALIDATION STEPS #########################
    // Add only validation methods below this line
    @And("I verify the header for Primary Member on the CoCo LCE page in {string}")
    public void iVerifyTextOnLcePage(String language){lifeChangeEventsCoCoPage.verifyHeadersEmploymentIncomePage(language);}

    @Then("I verify {string} life change event {string} selected")
    public void iVerifyLCECheckboxState(String LCEType, String Selection){lifeChangeEventsCoCoPage.verifyLCECheckboxState(LCEType, Selection);}

    @Then("I verify {string} error does not exist in {string}")
    public void iVerifyNoErrorMessage(String errorType, String language){lifeChangeEventsCoCoPage.verifyNoErrorMessage(errorType, language);}

    @Then("I verify {string} error does exist in {string}")
    public void iVerifyErrorMessage(String errorType, String language){lifeChangeEventsCoCoPage.verifyErrorMessage(errorType, language);}

    @Then("I verify LCE checkbox COCO in {string} state")
    public void iVerifyStateOfLCECheckboxesCOCO(String state){
        lifeChangeEventsCoCoPage.verifyLCECheckboxesCOCO(state);}

    @Then("I verify LCE CoCo error format for {string}")
    public void iVerifyErrorFormat(String incomeType){lifeChangeEventsCoCoPage.verifyErrorFormat(incomeType);}

    @Then("I validate the text format is aligned with {string} language")
    public void i_validate_the_text_format_is_aligned_with_language(String language, List<String> expectedText) {
    lifeChangeEventsCoCoPage.verifyTextFormatInGivenLanguage(language,expectedText);
    }
}