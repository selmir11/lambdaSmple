package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.MedicalCompareCoCoPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;


public class MedicalCompareCoCoPageSteps {

    MedicalCompareCoCoPage medicalCompareCoCoPage = new MedicalCompareCoCoPage(WebDriverManager.getDriver());

    @And("I select the Go Back button on the Medical Plan Compare page")
    public void clickMedicalCompareGoBack(){medicalCompareCoCoPage.clickMedicalCompareGoBack();}

    @And( "I verify the Medical Compare page In-Network headers and subheaders" )
    public void verifyTxtCompareHeader(){medicalCompareCoCoPage.verifyTxtCompareHeader();}

    @And( "I verify the Medical Compare page Out-Network headers and subheaders" )
    public void verifyTxtOutofNetworkHeader(){medicalCompareCoCoPage.verifyTxtOutofNetworkCompareHeader();}

    @And("I deselect the first plan and validate on the Medical Plan Compare page")
    public void verifyPlanDeselectionOne(){medicalCompareCoCoPage.verifyPlanDeselectionOne();}

    @And("I deselect the second plan and validate on the Medical Plan Compare page")
    public void verifyPlanDeselectionTwo(){medicalCompareCoCoPage.verifyPlanDeselectionTwo();}

    @And( "I deselect the third plan and validate on the Medical Plan Compare page" )
    public void verifyPlanDeselectionThree(){medicalCompareCoCoPage.verifyPlanDeselectionThree();}

    @And("I verify that no plans exist on the Medical Plan Compare page")
    public void verifyNoPlansSelectedTxt(){medicalCompareCoCoPage.verifyNoPlansSelectedTxt();}

    @And("I verify text in Medical plan Compare coco page")
    public void verifyTextinMedicalCompr(List<String> planDetails){
        medicalCompareCoCoPage.verifyTextMedicalplancmpr(planDetails);
    }
}
