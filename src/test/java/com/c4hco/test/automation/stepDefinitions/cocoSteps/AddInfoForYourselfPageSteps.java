package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.AddInfoForYourselfPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddInfoForYourselfPageSteps {
    AddInfoForYourselfPage addInfoForYourselfPage = new AddInfoForYourselfPage(WebDriverManager.getDriver());

    @And("I enter my residential address {string}, {string}, {string}, {string}, {string}")
    public void enterMemberResidentialCOAddress(String addressLine1, String city, String state, String zipcode, String county){addInfoForYourselfPage.memberResidentialAddressCoCo(addressLine1, city, state, zipcode, county);}

    @And("I update my residential address {string}, {string}, {string}, {string}, {string}")
    public void updateMemberResidentialCOAddress(String addressLine1, String city, String state, String zipcode, String county){addInfoForYourselfPage.updateResidentialAddressCoCo(addressLine1, city, state, zipcode, county);}

    @And("I select {string} for mailing address option")
    public void iAnswerMailingAddressQuestion(String YNMailingAddress){addInfoForYourselfPage.mailingAddressSelection(YNMailingAddress);}

    @And("I enter my mailing address {string}, {string}, {string}, {string}, {string}")
    public void enterMemberMailingCOAddress(String addressLine1, String city, String state, String zipcode, String county){addInfoForYourselfPage.memberMailingAddressCoCo(addressLine1, city, state, zipcode, county);}

    @And("I select {string} for live in Colorado option")
    public void iAnswerLiveInColoradoQuestion(String YNLiveInColorado){addInfoForYourselfPage.liveInColoradoSelection(YNLiveInColorado);}

    @And("I click continue on the Add info for yourself page")
    public void clickContinue(){addInfoForYourselfPage.clickSaveAndContinueButton();}

    @Then("I click Go Back on the additional information for yourself page")
    public void clickGoBack() {
        addInfoForYourselfPage.clickGoBackButton();
    }

    @Then("I verify text on the Additional information for yourself page in {string}")
    public void verifyAddInfoForYourselfPageText(String Language)  { addInfoForYourselfPage.verifyTextOnAddInfoForYourself(Language); }

    @Then("I validate the error messages on the Add info for yourself page in {string}")
    public void verifyErrorMessagesOnTheAddInfoForYourselfPage(String Language) { addInfoForYourselfPage.verifyErrorMessagesAddInfoForYourself(Language); }

    @And("I validate the available counties from dropdown to select are")
    public void validateCounties(String counties){
        addInfoForYourselfPage.validateCounties(counties);
    }

    @And("I update the state and zipcode to {string} and {string}")
    public void updateStateAndZip(String state, String zipcode){
        addInfoForYourselfPage.updateStateAndZip(state, zipcode);
    }

    @Then("I validate the county field is greyed out")
    public void validateCountyDisabled(){
        addInfoForYourselfPage.validateCountyField();
    }

}
