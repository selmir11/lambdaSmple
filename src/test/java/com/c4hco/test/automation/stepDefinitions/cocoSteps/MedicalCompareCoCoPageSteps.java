package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MedicalCompareCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


public class MedicalCompareCoCoPageSteps {

    MedicalCompareCoCoPage medicalCompareCoCoPage = new MedicalCompareCoCoPage(WebDriverManager.getDriver());

    @And("I select the Go Back button on the Medical Plan Compare page")
    public void clickMedicalCompareGoBack(){medicalCompareCoCoPage.clickMedicalCompareGoBack();}

    @And( "I verify the Medical Compare page In-Network headers and subheaders" )
    public void verifyTxtCompareHeader(){medicalCompareCoCoPage.verifyTxtCompareHeader();}

    @And( "I verify the Medical Compare page Out-Network headers and subheaders" )
    public void verifyTxtOutofNetworkHeader(){medicalCompareCoCoPage.verifyTxtOutofNetworkCompareHeader();}
}
