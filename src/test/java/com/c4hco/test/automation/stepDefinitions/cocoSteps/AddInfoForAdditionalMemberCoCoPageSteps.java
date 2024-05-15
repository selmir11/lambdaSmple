package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.AddInfoForAdditionalMemberCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AddInfoForAdditionalMemberCoCoPageSteps {

    AddInfoForAdditionalMemberCoCoPage addInfoForAdditionalMemberPage = new AddInfoForAdditionalMemberCoCoPage(WebDriverManager.getDriver());

    @And("I enter residential address details for additional member {string}, {string}, {string}, {string}, {string}")
    public void enterMemberResidentialCOAddress(String addressLine1, String city, String state, String zipcode, String county){addInfoForAdditionalMemberPage.addMemberResidentialAddressCoCo(addressLine1, city, state, zipcode, county);}

    @And("I select {string} for live in Colorado option for additional member")
    public void iAnswerLiveInColoradoQuestion(String YNLiveInColorado){addInfoForAdditionalMemberPage.liveInColoradoSelection(YNLiveInColorado);}

    @And("I click continue on the Additional information for additional member page")
    public void clickContinue(){addInfoForAdditionalMemberPage.clickSaveAndContinueButton();}

    @Then("I click Go Back on the Additional information for additional member page")
    public void clickGoBack() {
        addInfoForAdditionalMemberPage.clickGoBackButton();
    }
    
}
