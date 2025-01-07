package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.AddInfoForAdditionalMemberCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddInfoForAdditionalMemberCoCoPageSteps {

    AddInfoForAdditionalMemberCoCoPage addInfoForAdditionalMemberPage = new AddInfoForAdditionalMemberCoCoPage(WebDriverManager.getDriver());

    @And("I enter residential address details for additional member {string}, {string}, {string}, {string}, {string}")
    public void enterMemberResidentialCOAddress(String addressLine1, String city, String state, String zipcode, String county){addInfoForAdditionalMemberPage.addMemberResidentialAddressCoCo(addressLine1, city, state, zipcode, county);}

    @And("I enter complete residential address details for additional member addressLine1 {string},addressLine2 {string},city {string},state {string},zipcode {string},county {string}")
    public void enterMemberResidentialCOAddress(String addressLine1, String addressLine2, String city, String state, String zipcode, String county){addInfoForAdditionalMemberPage.addMemberCompleteResidentialAddressCoCo(addressLine1, addressLine2, city, state, zipcode, county);}
    @And("I select {string} for live in Colorado option for additional member")
    public void iAnswerLiveInColoradoQuestion(String YNLiveInColorado){addInfoForAdditionalMemberPage.liveInColoradoSelection(YNLiveInColorado);}

    @And("I click continue on the Additional information for additional member page")
    public void clickContinue(){addInfoForAdditionalMemberPage.clickSaveAndContinueButton();}

    @Then("I click Go Back on the Additional information for additional member page")
    public void clickGoBack() {
        addInfoForAdditionalMemberPage.clickGoBackButton();
    }

    @Then("I validate the page text on the Additional information for add members in {string}")
    public void validatePageTextOnTheAdditionalInformationForAdditionalMembers(String Language) { addInfoForAdditionalMemberPage.verifyTextOnAdditionalInformationForAdditionalMemberPage(Language);
    }

    @Then("I validate the error messages on the Add info for add member page in {string}")
    public void verifyErrorMessagesOnTheAddInfoForAddMemberPage (String Language) {
        addInfoForAdditionalMemberPage.verifyErrorMessagesAddInfoForAddMember(Language);
    }

    @And("I update the state and zipcode to {string} and {string} for additional member")
    public void updateStateAndZip(String state, String zip){
        addInfoForAdditionalMemberPage.updateStateAndZipAddtlMem(state, zip);
    }

    @Then("I validate the county field is greyed out for additional member")
    public void validateCountyDisabled(){
        addInfoForAdditionalMemberPage.validateCountyFieldAddtlMem();
    }

    @Then("I validate complete residential address details for additional member addressLine1 {string},addressLine2 {string},city {string},state {string},zipcode {string},county {string}")
    public void validateAddMemberResidentialAddress(String addressLine1, String addressLine2, String city, String state, String zipcode, String county){
        addInfoForAdditionalMemberPage.validateAddMemberCompleteResidentialAddressCoCo(addressLine1, addressLine2, city, state, zipcode, county);
    }

    @Then("I am validating that the {string} option was selected for living in Colorado for the additional member.")
    public void validateliveInColoradoButton(String liveInColoradoButton){
        addInfoForAdditionalMemberPage.validateColoradoOption(liveInColoradoButton);
    }

    @And("I update the AddressLine1 and AddressLine2 to {string} and {string} for additional member")
    public void updateaddressLine1AndaddressLine2(String addressLine1, String addressLine2){
        addInfoForAdditionalMemberPage.updateAddressLine1AndAddressLine2AddtlMem(addressLine1, addressLine2);
    }
}
