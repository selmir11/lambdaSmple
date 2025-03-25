package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.FamilyOverviewPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class FamilyOverviewSteps {
    FamilyOverviewPage familyOverviewPage = new FamilyOverviewPage(WebDriverManager.getDriver());

    @Then("I click EditUpdate on Family Overview page for {string}")
    public void iClickEditUpdateLink(String name){ familyOverviewPage.clickEditUpdateLink(name); }

    @Then("I validate the Total Income on the Family Overview page equals {string}")
    public void validateTotalIncome(String Amount){ familyOverviewPage.validateTotalIncome(Amount);}

    @Then("I validate Total Income equals to annual income")
    public void validateTotalIncomeAmount(){ familyOverviewPage.validateTotalIncomeEqualsAnnualIncome(); }

    @And("I select continue on the Family Overview page")
    public void selectContinueFamOverview(){familyOverviewPage.clickContinueButton();}

    @Then("I select add another family member on the Family Overview page")
    public void iClickaddAnotherMemberButton(){familyOverviewPage.clickaddAnotherMemberButton();}

    @Then("I click Manage who helps you on the Family Overview page")
    public void clickManageWhoHelpsYouFamilyOverview(){ familyOverviewPage.clickManageWhoHelpsYouButton(); }

    @Then("I verify button text Manage who helps you in {string}")
    public void verifyButtonTextManageWhoHelpsYou(String language) { familyOverviewPage.verifyTextManageWhoHelpsYouButton(language); }

    @Then("I verify continue button is disabled on the Family Overview page")
    public void verifyContinueButtonIsDisabledFamOverview() { familyOverviewPage.verifyContinueButtonIsDisabled(); }

    @Then("I verify no one is applying text on the Family Overview page")
    public void verifyNoOneIsApplyingTextFamOverview() { familyOverviewPage.verifyNoOneIsApplyingText(); }

    @Then("I validate the action link properties on the CoCo Family Overview page")
    public void iValidateActionLinksFamilyOverview() {familyOverviewPage.validateActionLinksFamilyOverview();}

    @Then("I verify no error gets displayed and continue button is enabled")
    public void iVerifyNoErrorIsPresentAndContinueButtonIsEnabled() {familyOverviewPage.verifyNoErrorIsPresentAndContinueButtonIsEnabled();}

    @Then("I verify we need more information text along with the red exclamation marks and edit update link")
    public void iVerifyWeNeedMoreInfoTextAndOtherDetails() { familyOverviewPage.verifyWeNeedMoreInfoTextAndOtherDetails(); }

    @Then("I verify the deduction Amount {string} on the CoCo Family Overview page")
    public void iVerifyDeductionAmountInFamilyOverviewPage(String amount) {
        familyOverviewPage.verifyDeductionAmount(amount);}

    @And("I retrieve the memberId of primary member from url")
    public void iRetrieveTheMemberIdOfMemberFromUrl() {
        familyOverviewPage.retrievePrimaryMemberId();
    }
    @Then("I validate CoCo URL to reflect a Member ID of a CoCo member within or without the current household for {string} page")
    public void iValidateCoCoURLToReflectAMemberIDOfACoCoMemberWithinTheCurrentHouseholdFor(String pageName) {
        familyOverviewPage.validateCocoUrlToReflectMemberID(pageName);
    }

}
