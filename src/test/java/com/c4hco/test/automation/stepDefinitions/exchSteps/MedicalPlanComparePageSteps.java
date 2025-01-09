package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MedicalComparePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class MedicalPlanComparePageSteps {

    MedicalComparePage medicalComparePage = new MedicalComparePage( WebDriverManager.getDriver());

    @And( "I validate the summary pdf link" )
    public void clickPDFCompareSummary() {medicalComparePage.clickPDFSummary();
    }

    @And( "I click the Go Back Button on the Medical Compare page" )
    public void clickGoBackCompare(){medicalComparePage.clickGoBackCompare();}

    @And( "I click the Go Back Link on the Medical Compare page" )
    public void clickGoBackCompareLink(){medicalComparePage.clickGoBackCompareLink();}

    @And("I click the InNetwork Link")
    public void clickInNetworkLink(){medicalComparePage.clickInNetworkLink();}

    @And("I click the OutNetwork Link")
    public void clickOutNetworkLink(){medicalComparePage.clickOutNetworkLink();}

    @And( "I validate the text headers and subheaders for the InNetwork Compare page" )
    public void validateInNetworkTextHeaders(){medicalComparePage.validateInNetworkTextHeaders();}

    @And( "I validate the text headers and subheaders for the OutNetwork Compare page" )
    public void validateOutNetworkTextHeaders(){medicalComparePage.validateOutNetworkTextHeaders();}

    @And("I validate the 2 plan documents columns are available for viewing on the Medical Compare page")
    public void validatePlanDocuments2(){medicalComparePage.validatePlanDocuments2();}

    @And("I validate the 3 plan documents columns are available for viewing on the Medical Compare page")
    public void validatePlanDocuments3(){medicalComparePage.validatePlanDocuments3();}

    @And( "I validate the Plan Detail link and click" )
    public void validateComparePlanDetailLink(){medicalComparePage.clickPlanDetailLink();}

    @And( "I validate the header dropdown functionality" )
    public void validateHeaderFunctionality(){medicalComparePage.validateHeaderFunctionality();}





}
