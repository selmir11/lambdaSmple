package com.c4hco.test.automation.stepDefinitions.cocoSteps;

import com.c4hco.test.automation.pages.cocoPages.FamilyOverviewPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class FamilyOverviewSteps {
    FamilyOverviewPage familyOverviewPage = new FamilyOverviewPage(WebDriverManager.getDriver());

    @Then("I click {string} EditUpdate on the Family Overview page")
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









}
