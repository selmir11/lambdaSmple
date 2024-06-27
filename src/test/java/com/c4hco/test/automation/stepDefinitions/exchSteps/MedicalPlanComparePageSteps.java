package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.MedicalComparePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class MedicalPlanComparePageSteps {

    MedicalComparePage medicalComparePage = new MedicalComparePage( WebDriverManager.getDriver());

    @And( "I validate the summary pdf link" )
    public void clickPDFCompareSummary() {medicalComparePage.clickPDFSummary();
    }

    @And( "I click Go Back on the Compare page" )
    public void clickGoBackCompare(){medicalComparePage.clickGoBackCompare();}

    @And("I click the InNetwork Link")
    public void clickInNetworkLink(){medicalComparePage.clickInNetworkLink();}

    @And("I click the OutNetwork Link")
    public void clickOutNetworkLink(){medicalComparePage.clickOutNetworkLink();}

    @And( "I validate the Disclaimer text")
    public void validateDisclaimerCompare(){medicalComparePage.validateDisclaimerCompare();}

    @And( "I validate the text headers and subheaders for the InNetwork Compare page" )
    public void validateInNetworkTextHeaders(){medicalComparePage.validateDisclaimerCompare();}

    @And( "I validate the text headers and subheaders for the OutNetwork Compare page" )
    public void validateOutNetworkTextHeaders(){medicalComparePage.validateDisclaimerCompare();}




}
