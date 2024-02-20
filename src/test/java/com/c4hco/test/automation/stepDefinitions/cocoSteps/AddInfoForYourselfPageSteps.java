package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.AddInfoForYourselfPage;
import io.cucumber.java.en.And;

public class AddInfoForYourselfPageSteps {
    AddInfoForYourselfPage addInfoForYourselfPage = new AddInfoForYourselfPage();

    @And("I enter my residential address {string}, {string}, {string}, {string}, {string} and indicate I live in Colorado")
    public void enterMemberResidentialCOAddress(String addressLine1, String city, String state, String zipcode, String county){addInfoForYourselfPage.memberResidentialAddressCoCo(addressLine1, city, state, zipcode, county);}
}
