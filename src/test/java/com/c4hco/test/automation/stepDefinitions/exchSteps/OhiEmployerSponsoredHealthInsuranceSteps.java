package com.c4hco.test.automation.stepDefinitions.exchSteps;

import com.c4hco.test.automation.pages.exchPages.OhiEmployerSponsoredHealthInsurancePage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

public class OhiEmployerSponsoredHealthInsuranceSteps {
    OhiEmployerSponsoredHealthInsurancePage ohiEmployerSponsoredHealthInsurancePage = new OhiEmployerSponsoredHealthInsurancePage(WebDriverManager.getDriver());

    @Then("I select the Go Back button on the ESI page")
    public void iClickGoBack(){ohiEmployerSponsoredHealthInsurancePage.clickGoBack();
    }

    @Then("I select the {string} employer on the ESI page")
    public void iSelectEmployer(String intString){ohiEmployerSponsoredHealthInsurancePage.selectEmployer(intString);
    }

    @Then("I select {string} for meet the Minimum Value Standard on the ESI page")
    public void iClickMinValueStandard(String minValueStandard){ohiEmployerSponsoredHealthInsurancePage.clickMinValueStandard(minValueStandard);
    }

    @Then("I enter {string} for employee amount question on the ESI page")
    public void iEnterMonthlyAmount(String employeeAmount){ohiEmployerSponsoredHealthInsurancePage.enterMonthlyAmount(employeeAmount);}

    @Then("I enter the end date as {string} on the ESI page")
    public void iEnterEndDate(String endDate){ohiEmployerSponsoredHealthInsurancePage.enterEndDate(endDate);}

    @Then("I select the Are you voluntarily ending {string} button on the ESI page")
    public void iClickVoluntarilyEnding(String voluntarilyEnding){ohiEmployerSponsoredHealthInsurancePage.clickVoluntarilyEnding(voluntarilyEnding);
    }

    @Then("I select the Are you currently enrolled {string} button on the ESI page")
    public void iClickCurrentlyEnrolled(String currentlyEnrolled){ohiEmployerSponsoredHealthInsurancePage.clickCurrentlyEnrolled(currentlyEnrolled);
    }

    @Then("I select the Will Insurance End {string} button on the ESI page")
    public void iClickInsuranceEnd(String willEnd){ohiEmployerSponsoredHealthInsurancePage.clickInsuranceEnd(willEnd);
    }

    @Then("I click {string} for offer family plans question")
    public void iClickFamilyPlansOffered(String currentlyOffered){ohiEmployerSponsoredHealthInsurancePage.clickFamilyPlansOffered(currentlyOffered);}

    @Then("I enter {string} for offer family amount question")
    public void iEnterMonthlyFamilyAmount(String familyAmount){ohiEmployerSponsoredHealthInsurancePage.enterMonthlyFamilyAmount(familyAmount);}

    @Then("I click enrollment status for the members")
    public void iClickFamilyEnrollmentStatusMembers(List<Map<String, String>> expectedValues)
    {ohiEmployerSponsoredHealthInsurancePage.clickFamilyEnrollmentStatusMembers(expectedValues);}

    @Then("I click continue on the ESI page")
    public void iClickSaveAndContinue(){ohiEmployerSponsoredHealthInsurancePage.clickSaveAndContinue();}

    @Then("I open or close the Help Drawer on the ESI page")
    public void iClickMainHelp(){ohiEmployerSponsoredHealthInsurancePage.clickMainHelp();
    }

    @Then("I open or close the {string} Help Drawer on the ESI page")
    public void iClickIconHelp(String iconName){ohiEmployerSponsoredHealthInsurancePage.clickIconHelp(iconName);
    }

    @Then("I click on {string} link in Help Drawer on the ESI page")
    public void iClickHelpDrawerContactUs(String lnkName){ohiEmployerSponsoredHealthInsurancePage.clickHelpDrawerContactUs(lnkName);
    }


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

    @Then("I verify enrollment status for the members")
    public void iVerifyFamilyEnrollmentStatusMembers(List<Map<String, String>> expectedValues)
    {ohiEmployerSponsoredHealthInsurancePage.verifyFamilyEnrollmentStatusMembers(expectedValues);}

    @And("I verify the {string} ESI page data in {string}")
    public void iVerifyVaHealthcarePageData(String dataToVerify, String language) {ohiEmployerSponsoredHealthInsurancePage.verifyEsiPageData(dataToVerify, language);}

    @And("I verify {string} error in {string} on the ESI page")
    public void iVerifyErrorMessage(String errorType, String language){ohiEmployerSponsoredHealthInsurancePage.verifyErrorMessage(errorType, language);}

    @And("I verify {string} error does not show for ESI page")
    public void iVerifyNoErrorMessage(String errorType)  {ohiEmployerSponsoredHealthInsurancePage.verifyNoErrorMessage(errorType);}


}
