package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class FamilyOverviewPage {
    @FindBy(xpath = "//h1[contains(text(), 'Family Overview: Here’s what you’ve told us so far')]")
    WebElement familyOverviewHeader;

    @FindBy (css = "app-family-member-overview a.edit-update-btn")
    List<WebElement> editUpdateLink;

    @FindBy (xpath = "//a/parent::div/preceding-sibling::div/div[contains(text(), '$')]")
    WebElement annualIncomeAmount;

    @FindBy (css = ".container .family-overview-household-income")
    WebElement totalIncomeAmount;

    @FindBy(id = "familyOverview-SaveAndContinue")
    WebElement continueButton;

    @FindBy(id = "familyOverview-GoBack")
    WebElement manageWhoHelpsYouButton;

    @FindBy(css = ".errorMessage.smaller.ng-star-inserted")
    WebElement noOneApplyingErrorText;

    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public FamilyOverviewPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickPrimaryEditUpdateLink() {
        basicActions.waitForElementListToBePresent(editUpdateLink, 30);
        editUpdateLink.get(0).click();
    }

    public void clickContinueButton() {
        basicActions.waitForElementToBeClickable(continueButton, 30);
        continueButton.click();
    }

    public void clickManageWhoHelpsYouButton() {
        basicActions.waitForElementToBeClickable(manageWhoHelpsYouButton, 30);
        manageWhoHelpsYouButton.click();
    }

    public void validateTotalIncomeEqualsAnnualIncome(){
        basicActions.waitForElementToBePresent(annualIncomeAmount, 30);
        basicActions.waitForElementToBePresent(totalIncomeAmount, 30);
        softAssert.assertEquals(totalIncomeAmount.getText(), annualIncomeAmount.getText());
        softAssert.assertAll();
    }

    public void verifyTextManageWhoHelpsYouButton(String language) {
        basicActions.waitForElementToBePresent(manageWhoHelpsYouButton, 10);
        switch (language) {
            case "English":
                verifyTextManageWhoHelpsYouButtonEnglish();
                break;
            case "Spanish":
                verifyTextManageWhoHelpsYouButtonSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }

    public void verifyTextManageWhoHelpsYouButtonEnglish(){
        basicActions.waitForElementToBePresent(manageWhoHelpsYouButton, 30);
        softAssert.assertEquals(manageWhoHelpsYouButton.getText(), "  Manage who helps you" );
        softAssert.assertAll();
    }

    public void verifyTextManageWhoHelpsYouButtonSpanish(){
        basicActions.waitForElementToBePresent(manageWhoHelpsYouButton, 30);
        softAssert.assertEquals(manageWhoHelpsYouButton.getText(), "  Administrar quién te ayuda");
        softAssert.assertAll();
    }

    public void verifyContinueButtonIsDisabled() {
        if (continueButton.isEnabled()) {
            throw new AssertionError("Continue button is enabled when it should be disabled.");
        }
    }

    public void verifyNoOneIsApplyingText(){
        basicActions.waitForElementToBePresent(noOneApplyingErrorText, 30);
        softAssert.assertEquals(noOneApplyingErrorText.getText(), "You\u2019ve indicated that no one is applying for health insurance.\nTo continue, please indicate which member(s) are applying by clicking the \u201CEdit/Update\u201D button in the table below");
        softAssert.assertAll();
    }
}
