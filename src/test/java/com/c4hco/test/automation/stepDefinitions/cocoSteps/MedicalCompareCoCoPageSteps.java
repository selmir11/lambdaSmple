package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MedicalCompareCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

import java.util.List;


public class MedicalCompareCoCoPageSteps {

    MedicalCompareCoCoPage medicalCompareCoCoPage = new MedicalCompareCoCoPage( WebDriverManager.getDriver() );

    @And("I validate and click the COCO Medical Compare Plan Detail link")
    public void clickComparePlanDetailLinkCoCoPage() {
        medicalCompareCoCoPage.clickComparePlanDetailLinkCoCoPage();
    }

    @And("I select the Go Back button on the Medical Plan Compare page")
    public void clickMedicalCompareGoBackButton() {
        medicalCompareCoCoPage.clickMedicalCompareGoBackButton();
    }

    @And("I deselect the first plan and validate on the Medical Plan Compare page")
    public void verifyPlanDeselectionOne() {
        medicalCompareCoCoPage.selectPlanDeselectionOne();
    }

    @And("I deselect the second plan and validate on the Medical Plan Compare page")
    public void verifyPlanDeselectionTwo() {
        medicalCompareCoCoPage.selectPlanDeselectionTwo();
    }

    @And("I deselect the third plan and validate on the Medical Plan Compare page")
    public void verifyPlanDeselectionThree() {
        medicalCompareCoCoPage.selectPlanDeselectionThree();
    }

    @And("I verify that no plans exist on the Medical Plan Compare page")
    public void verifyNoPlansSelectedTxt() {
        medicalCompareCoCoPage.verifyNoPlansSelectedTxt();
    }

    @And("I verify text in Medical plan Compare coco page")
    public void verifyTextinMedicalCompare(List<String> planDetails) {
        medicalCompareCoCoPage.verifyTextinMedicalCompare( planDetails );
    }


    // used for SCLR-90
    @And("I validate the {string} Medical Compare page In-Network headers and subheaders")
    public void verifyTxtCompareInNetwork(String language) {
        medicalCompareCoCoPage.validateTextComparePlanCoCoPageInNetwork( language );
    }

    // old SCLR-90
    @And("I verify the Medical Compare page In-Network headers and subheaders")
    public void verifyTxtCompareHeader() {
        medicalCompareCoCoPage.verifyTxtCompareHeader();
    }

    // used for SCLR-93
    @And("I validate the {string} Medical Compare page Out-Network headers and subheaders")
    public void verifyTxtCompareOutOfNetworkCoCoPage(String language) {
        medicalCompareCoCoPage.validateTextComparePlanCoCoPageOutNetwork( language );
    }

    // old SCLR-93
    @And("I verify the Medical Compare page Out-Network headers and subheaders")
    public void verifyTxtOutofNetworkHeader() {
        medicalCompareCoCoPage.verifyTxtOutofNetworkCompareHeader();
    }


    // could use for new test on network tab navigation
    @And("I validate the 2 Network tabs can be utilized when available")
    public void validateNetworkTierTabs() {
        medicalCompareCoCoPage.validate2InNetworkTierTabs();
    }

    // validate 2 or 3 document columns
    @And("I validate {string} document columns on the Compare page")
    public void validateDocumentationComparePlan(String carrier) {
        medicalCompareCoCoPage.validateDocumentationComparePlan( carrier );
    }
}
