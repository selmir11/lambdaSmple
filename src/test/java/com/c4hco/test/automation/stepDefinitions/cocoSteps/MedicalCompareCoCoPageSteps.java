package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MedicalCompareCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

import java.util.List;


public class MedicalCompareCoCoPageSteps {

    MedicalCompareCoCoPage medicalCompareCoCoPage = new MedicalCompareCoCoPage(WebDriverManager.getDriver());

    @And( "I validate and click the COCO Medical Compare Plan Detail link" )
    public void clickComparePlanDetailLinkCoCoPage(){medicalCompareCoCoPage.clickComparePlanDetailLinkCoCoPage();}

    @And("I select the Go Back button on the Medical Plan Compare page")
    public void clickMedicalCompareGoBackButton(){medicalCompareCoCoPage.clickMedicalCompareGoBackButton();}

    @And("I deselect the first plan and validate on the Medical Plan Compare page")
    public void verifyPlanDeselectionOne(){medicalCompareCoCoPage.selectPlanDeselectionOne();}

    @And("I deselect the second plan and validate on the Medical Plan Compare page")
    public void verifyPlanDeselectionTwo(){medicalCompareCoCoPage.selectPlanDeselectionTwo();}

    @And( "I deselect the third plan and validate on the Medical Plan Compare page" )
    public void verifyPlanDeselectionThree(){medicalCompareCoCoPage.selectPlanDeselectionThree();}

    @And("I verify that no plans exist on the Medical Plan Compare page")
    public void verifyNoPlansSelectedTxt(){medicalCompareCoCoPage.verifyNoPlansSelectedTxt();}

    @And("I verify text in Medical plan Compare coco page")
    public void verifyTextinMedicalCompare(List<String> planDetails){medicalCompareCoCoPage.verifyTextinMedicalCompare(planDetails); }


    // used for SCLR-90
    @And( "I validate the {string} Medical Compare page In-Network headers and subheaders" )
    public void verifyTxtCompareInNetwork(String language){medicalCompareCoCoPage.validateTextComparePlanCoCoPage(language);}

    // old SCLR-90
    @And( "I verify the Medical Compare page In-Network headers and subheaders" )
    public void verifyTxtCompareHeader(){medicalCompareCoCoPage.verifyTxtCompareHeader();}

    // used for SCLR-93
    @And( "I validate the {string} Medical Compare page Out-Network headers and subheaders" )
    public void verifyTxtCompareOutOfNetworkCoCoPage(String language){medicalCompareCoCoPage.validateTextComparePlanCoCoPage(language);}

    // old SCLR-93
    @And( "I verify the Medical Compare page Out-Network headers and subheaders" )
    public void verifyTxtOutofNetworkHeader(){medicalCompareCoCoPage.verifyTxtOutofNetworkCompareHeader();}

    // could used for one big test
    @And ("I validate the {string} text on the Medical Compare COCO page")
    public void validateTextComparePlanCoCoPage(String language) {medicalCompareCoCoPage.validateTextComparePlanCoCoPage(language);}



}
