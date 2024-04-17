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




    // =================== VALIDATION STEPS ===============//
    @And("I verify the Help Drawer is {string} on the ESI page")
    public void iVerifyHelpDrawerStatus(String drawerStatus){ohiEmployerSponsoredHealthInsurancePage.verifyHelpDrawerStatus(drawerStatus);
    }

    @And("I verify the Help Drawer {string} text in {string} on the ESI page")
    public void iVerifyHelpDrawerText(String drawerPage, String language){ohiEmployerSponsoredHealthInsurancePage.verifyHelpDrawerText(drawerPage, language);
    }


}
