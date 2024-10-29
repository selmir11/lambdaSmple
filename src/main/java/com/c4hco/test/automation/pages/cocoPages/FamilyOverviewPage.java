package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FamilyOverviewPage {
    @FindBy(xpath = "//h1[contains(text(), 'Family Overview: Here’s what you’ve told us so far')]")
    WebElement familyOverviewHeader;

    @FindBy (css = "app-family-member-overview a.edit-update-btn")
    List<WebElement> editUpdateLink;

    @FindBy (xpath = "//a/parent::div/preceding-sibling::div/div[contains(text(), '$')]")
    WebElement annualIncomeAmount;

    @FindBy (css = ".container .family-overview-household-income")
    WebElement totalIncomeAmount;

    @FindBy (css = "div.family-overview-add-link")
    WebElement addAnotherMemberButton;

    @FindBy(id = "familyOverview-SaveAndContinue")
    WebElement continueButton;

    @FindBy(id = "familyOverview-GoBack")
    WebElement manageWhoHelpsYouButton;

    @FindBy(css = ".errorMessage.smaller")
    WebElement noOneApplyingErrorText;

    @FindBy(css = ".household-account-id")
    WebElement accountIdTxt;

    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public FamilyOverviewPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickPrimaryEditUpdateLink() {
        basicActions.waitForElementListToBePresentWithRetries(editUpdateLink, 30);
        editUpdateLink.get(0).click();
    }

    public void clickaddAnotherMemberButton() {
        basicActions.waitForElementToBePresent(addAnotherMemberButton, 30);
        basicActions.scrollToElement(addAnotherMemberButton);
        addAnotherMemberButton.click();
    }

    public void clickContinueButton() {
        basicActions.waitForElementToBeClickable(continueButton, 30);
        getAccountId();
        continueButton.click();
    }
    public void getAccountId() {
        basicActions.waitForElementToBePresent(accountIdTxt, 15);

        Matcher matcher = Pattern.compile("\\d+").matcher(accountIdTxt.getText());
        String accId = matcher.find() ? matcher.group() : null;

        SharedData.getPrimaryMember().setAccount_id(new BigDecimal(accId));
        System.out.println("Account_id : " + new BigDecimal(accId));
    }

    public void clickManageWhoHelpsYouButton() {
        basicActions.waitForElementToBeClickable(manageWhoHelpsYouButton, 30);
        manageWhoHelpsYouButton.click();
    }

    public void validateTotalIncome(String Amount){
        basicActions.waitForElementToBePresent(totalIncomeAmount, 30);
        softAssert.assertEquals(totalIncomeAmount.getText().contains(Amount), Amount);
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
        softAssert.assertEquals(manageWhoHelpsYouButton.getText(), "  Administrar qui\u00E9n te ayuda");
        softAssert.assertAll();
    }

    public void verifyContinueButtonIsDisabled() {
        Assert.assertFalse(continueButton.isEnabled());
    }

    public void verifyNoOneIsApplyingText(){
        basicActions.waitForElementToBePresent(noOneApplyingErrorText, 30);
        softAssert.assertEquals(noOneApplyingErrorText.getText(), "You\u2019ve indicated that no one is applying for health insurance.\nTo continue, please indicate which member(s) are applying by clicking the \u201CEdit/Update\u201D button in the table below");
        softAssert.assertAll();
    }

    private void getAccountId() {
        basicActions.waitForElementToBePresent(accountIdTxt, 15);

        Matcher matcher = Pattern.compile("\\d+").matcher(accountIdTxt.getText());
        String accId = matcher.find() ? matcher.group() : null;

        SharedData.getPrimaryMember().setAccount_id(new BigDecimal(accId));
        System.out.println("Account_id : " + new BigDecimal(accId));
    }
}
