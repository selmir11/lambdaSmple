package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.AddInfoForYourselfPage;
import io.cucumber.java.en.And;

public class AddInfoForYourselfPageSteps {
    AddInfoForYourselfPage addInfoForYourselfPage = new AddInfoForYourselfPage();

    @And("I enter my residential address {string}, {string}, {string}, {string}, {string}")
    public void enterMemberResidentialCOAddress(String addressLine1, String city, String state, String zipcode, String county){addInfoForYourselfPage.memberResidentialAddressCoCo(addressLine1, city, state, zipcode, county);}

    @And("I select {string} for mailing address option")
    public void iAnswerMailingAddressQuestion(String YNMailingAddress){addInfoForYourselfPage.mailingAddressSelection(YNMailingAddress);}

    @And("I select {string} for live in Colorado option")
    public void iAnswerLiveInColoradoQuestion(String YNLiveInColorado){addInfoForYourselfPage.liveInColoradoSelection(YNLiveInColorado);}

    @And("I click continue on the Add info for yourself page")
    public void clickContinue(){addInfoForYourselfPage.clickSaveAndContinueButton();}
}
