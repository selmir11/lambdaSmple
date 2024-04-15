package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiEmployerSponsoredHealthInsurancePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class OhiEmployerSponsoredHealthInsuranceSteps {
    OhiEmployerSponsoredHealthInsurancePage ohiEmployerSponsoredHealthInsurancePage = new OhiEmployerSponsoredHealthInsurancePage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the ESI page")
    public void iClickGoBack(){ohiEmployerSponsoredHealthInsurancePage.clickGoBack();
    }

    @Then("I select the employer on the ESI page")
    public void iSelectEmployer(){ohiEmployerSponsoredHealthInsurancePage.selectEmployer();
    }

    @Then("I select the Are you currently enrolled Yes button on the ESI page")
    public void iClickCurrentlyEnrolledYes(){ohiEmployerSponsoredHealthInsurancePage.clickCurrentlyEnrolledYes();
    }

    @Then("I select the Will Insurance End Yes button on the ESI page")
    public void iClickInsuranceEndYes(){ohiEmployerSponsoredHealthInsurancePage.clickInsuranceEndYes();
    }

    @Then("I open or close the Help Drawer on the ESI page")
    public void iClickMainHelp(){ohiEmployerSponsoredHealthInsurancePage.clickMainHelp();
    }

    @Then("I open or close the {string} Help Drawer on the ESI page")
    public void iClickIconHelp(String iconName){ohiEmployerSponsoredHealthInsurancePage.clickIconHelp(iconName);
    }

    @Then("I click on {string} link in Help Drawer on the ESI page")
    public void iClickHelpDrawerContactUs(String lnkName){ohiEmployerSponsoredHealthInsurancePage.clickHelpDrawerContactUs(lnkName);
    }

    @Then("I click {string} for offer family plans question")
    public void iClickFamilyPlansOffered(String currentlyOffered){ohiEmployerSponsoredHealthInsurancePage.clickFamilyPlansOffered(currentlyOffered);}

    @Then("I enter {string} for offer family amount question")
    public void iEnterMonthlyAmount(String familyAmount){ohiEmployerSponsoredHealthInsurancePage.enterMonthlyAmount(familyAmount);}

    @Then("I click {string} enrollment status for first member question")
    public void iClickFamilyEnrollmentStatusMember1(String enrollmentStatus){ohiEmployerSponsoredHealthInsurancePage.clickFamilyEnrollmentStatusMember1(enrollmentStatus);}

    @Then("I click {string} enrollment status for second member question")
    public void iClickFamilyEnrollmentStatusMember2(String enrollmentStatus){ohiEmployerSponsoredHealthInsurancePage.clickFamilyEnrollmentStatusMember2(enrollmentStatus);}

    @Then("I click continue on the ESI page")
    public void iClickSaveAndContinue(){ohiEmployerSponsoredHealthInsurancePage.clickSaveAndContinue();}


    // =================== VALIDATION STEPS ===============//
    @And("I verify the Help Drawer is {string} on the ESI page")
    public void iVerifyHelpDrawerStatus(String drawerStatus){ohiEmployerSponsoredHealthInsurancePage.verifyHelpDrawerStatus(drawerStatus);
    }

    @And("I verify the Help Drawer {string} text in {string} on the ESI page")
    public void iVerifyHelpDrawerText(String drawerPage, String language){ohiEmployerSponsoredHealthInsurancePage.verifyHelpDrawerText(drawerPage, language);
    }

    @And("I verify offer family health plans is {string} on the ESI page")
    public void iVerifyFamilyOfferedToEnrollOption(String currentlyOffered){ohiEmployerSponsoredHealthInsurancePage.verifyFamilyOfferedToEnrollOption(currentlyOffered);}

    @And("I verify offered family amount is {string} on the ESI page")
    public void iVerifyMonthlyAmount(String familyAmount){ohiEmployerSponsoredHealthInsurancePage.verifyMonthlyAmount(familyAmount);}

    @And("I verify {string} enrollment status for first member question")
    public void iVerifyFamilyEnrollmentStatusMember1(String enrollmentStatus){ohiEmployerSponsoredHealthInsurancePage.verifyFamilyEnrollmentStatusMember1(enrollmentStatus);}

    @And("I verify {string} enrollment status for second member question")
    public void iVerifyFamilyEnrollmentStatusMember2(String enrollmentStatus){ohiEmployerSponsoredHealthInsurancePage.verifyFamilyEnrollmentStatusMember2(enrollmentStatus);}


}
