package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FamilyOverviewPage {

    Actions actions = new Actions(WebDriverManager.getDriver());

    @FindBy(xpath = "//h1[contains(text(), 'Family Overview: Here’s what you’ve told us so far')]")
    WebElement familyOverviewHeader;

    @FindBy (css = "app-family-member-overview a.edit-update-btn")
    List<WebElement> editUpdateLink;

    @FindBy (xpath = "//*[contains(@id, 'remove-family-member-')]")
    WebElement removeFamilyMemberLink;

    @FindBy (xpath = "//a/parent::div/preceding-sibling::div/div[contains(text(), '$')]")
    WebElement annualIncomeAmount;

    @FindBy (css = ".container .family-overview-household-income")
    WebElement totalIncomeAmount;

    @FindBy (xpath = "//app-family-overview//div[2]/a")
    WebElement addAnotherMemberButton;

    @FindBy(id = "familyOverview-SaveAndContinue")
    WebElement continueButton;

    @FindBy(id = "familyOverview-GoBack")
    WebElement manageWhoHelpsYouButton;

    @FindBy(css = ".errorMessage.smaller")
    WebElement noOneApplyingErrorText;

    @FindBy(css = ".household-account-id")
    WebElement accountIdTxt;

    @FindBy(css = ".errorMessage.smaller")
    WebElement needMoreInfoErrorText;

    @FindBy(css = ".family-overview-exclamation .red-circle svg")
    List<WebElement> redCircleExclamationMarkForBasicHouseholdAndAnnualFinancialInformation;

    @FindBy(xpath = "//h1[contains(text(),'Family Overview: Here’s what you’ve told us so far')]//following::div[28]")
    WebElement annualFinInfoAmt;

    SoftAssert softAssert = new SoftAssert();

    private BasicActions basicActions;

    public FamilyOverviewPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickEditUpdateLink(String name) {
        if(name.equals("getFromSharedData")){
            name = SharedData.getPrimaryMember().getFirstName();
        }
        basicActions.waitForElementListToBePresentWithRetries(editUpdateLink, 30);
        String xpath = String.format("//*[contains(text(),'"+name+"')]//following::a[1]");
        WebElement button = basicActions.getDriver().findElement(By.xpath(xpath));
        button.click();
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
        softAssert.assertEquals(manageWhoHelpsYouButton.getText(), "Manage who helps you" );
        softAssert.assertAll();
    }

    public void verifyTextManageWhoHelpsYouButtonSpanish(){
        basicActions.waitForElementToBePresent(manageWhoHelpsYouButton, 30);
        softAssert.assertEquals(manageWhoHelpsYouButton.getText(), "Administrar qui\u00E9n te ayuda");
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

    public void validateActionLinksFamilyOverview(){
        basicActions.waitForElementToBePresent(continueButton, 15);
        softAssert.assertEquals(editUpdateLink.get(0).getCssValue("font-size"),"14px");
        softAssert.assertEquals(editUpdateLink.get(0).getCssValue("font-weight"),"400");
        softAssert.assertEquals(editUpdateLink.get(0).getCssValue("line-height"),"24px");
        softAssert.assertEquals(editUpdateLink.get(0).getCssValue("color"),"rgba(26, 112, 179, 1)");
        softAssert.assertEquals(editUpdateLink.get(1).getCssValue("font-size"),"14px");
        softAssert.assertEquals(editUpdateLink.get(1).getCssValue("font-weight"),"400");
        softAssert.assertEquals(editUpdateLink.get(1).getCssValue("line-height"),"24px");
        softAssert.assertEquals(editUpdateLink.get(1).getCssValue("color"),"rgba(26, 112, 179, 1)");
        softAssert.assertEquals(addAnotherMemberButton.getCssValue("font-size"), "18px");
        softAssert.assertEquals(addAnotherMemberButton.getCssValue("font-weight"),"700");
        softAssert.assertEquals(addAnotherMemberButton.getCssValue("line-height"),"28px");
        softAssert.assertEquals(addAnotherMemberButton.getCssValue("color"),"rgba(26, 112, 179, 1)");
        softAssert.assertEquals(removeFamilyMemberLink.getCssValue("font-size"),"14px");
        softAssert.assertEquals(removeFamilyMemberLink.getCssValue("font-weight"),"400");
        softAssert.assertEquals(removeFamilyMemberLink.getCssValue("line-height"),"12px");
        softAssert.assertEquals(removeFamilyMemberLink.getCssValue("color"),"rgba(26, 112, 179, 1)");
        softAssert.assertAll();
        actions.moveToElement(editUpdateLink.get(0)).perform();
        basicActions.wait(300);
        softAssert.assertEquals(editUpdateLink.get(0).getCssValue("color"),"rgba(22, 156, 216, 1)");
        softAssert.assertAll();
        actions.moveToElement(editUpdateLink.get(1)).perform();
        basicActions.wait(300);
        softAssert.assertEquals(editUpdateLink.get(1).getCssValue("color"),"rgba(22, 156, 216, 1)");
        softAssert.assertAll();
        actions.moveToElement(addAnotherMemberButton).perform();
        basicActions.wait(300);
        softAssert.assertEquals(addAnotherMemberButton.getCssValue("color"),"rgba(22, 156, 216, 1)");
        softAssert.assertAll();
        actions.moveToElement(removeFamilyMemberLink).perform();
        basicActions.wait(300);
        softAssert.assertEquals(removeFamilyMemberLink.getCssValue("color"),"rgba(22, 156, 216, 1)");
        softAssert.assertAll();
    }

    private void getAccountId() {
        basicActions.waitForElementToBePresent(accountIdTxt, 15);

        Matcher matcher = Pattern.compile("\\d+").matcher(accountIdTxt.getText());
        String accId = matcher.find() ? matcher.group() : null;

        SharedData.getPrimaryMember().setAccount_id(new BigDecimal(accId));
        System.out.println("Account_id : " + new BigDecimal(accId));
    }

    public void verifyNoErrorIsPresentAndContinueButtonIsEnabled(){
        basicActions.waitForElementToDisappear(noOneApplyingErrorText, 30);
        basicActions.waitForElementToDisappear(needMoreInfoErrorText, 30);
        basicActions.waitForElementToBePresent(continueButton, 10);
        softAssert.assertTrue(continueButton.isEnabled(),"continue button is not enabled");
        softAssert.assertAll();
    }

    public void verifyWeNeedMoreInfoTextAndOtherDetails(){
        basicActions.waitForElementToBePresent(needMoreInfoErrorText, 10);
        basicActions.waitForElementListToBePresent(editUpdateLink, 10);
        basicActions.waitForElementListToBePresent(redCircleExclamationMarkForBasicHouseholdAndAnnualFinancialInformation, 10);
        softAssert.assertEquals(needMoreInfoErrorText.getText(),"Looks like we need a bit more information. Please click the \u201CEdit/Update\u201D link below to complete");
        softAssert.assertTrue(editUpdateLink.get(0).isDisplayed(),"Edit/Update link is not visible");
        softAssert.assertTrue(redCircleExclamationMarkForBasicHouseholdAndAnnualFinancialInformation.get(0).isDisplayed(),"Red circle exclamation mark for Basic Household Information is not visible");
        softAssert.assertTrue(redCircleExclamationMarkForBasicHouseholdAndAnnualFinancialInformation.get(1).isDisplayed(),"Red circle exclamation mark for Annual Financial Information is not visible");
        softAssert.assertAll();
    }

    public void verifyDeductionAmount(String amount){
        basicActions.waitForElementListToBePresent(editUpdateLink, 10);
        softAssert.assertEquals(annualFinInfoAmt.getText(),amount);
        softAssert.assertAll();
    }
}
