package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;

public class PeakPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public PeakPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//input[@placeholder='Enter email address or mobile number']")
    WebElement peakUsername;

    @FindBy(xpath = "//input[@id='input-102']")
    WebElement peakPassword;

    @FindBy(xpath = "//button[@name='SignInButton']")
    WebElement peakSignInButton;

    @FindBy(xpath = "//button[@name='SignInWithConnectForHealthColorado']")
    WebElement peakSignInWithConnectForHealthColoradoButton;

    @FindBy(xpath = "//div[normalize-space()='Sign out']")
    WebElement peakSignOUtButton;

    @FindBy(xpath = "//div[@class='inner-wrapper']//div")
    List<WebElement> peakSkeletonErrorMessage;

    @FindBy(xpath = "//div[@role='heading']//lightning-formatted-rich-text")
    WebElement peakWelcomeText;

    @FindBy(id = "myProfile_username")
    WebElement c4AssignedUsername;

    @FindBy(id = "myProfile_accountId")
    WebElement c4AssignedAccountId;

    public void clickOkOnThePeakAlertWindow() {
        try{
            Alert peakAlertWindow = basicActions.getDriver().switchTo().alert();
            peakAlertWindow.accept();
        }
        catch(NoAlertPresentException ex){
            System.out.println("Alert is NOT Displayed");
        }
    }

    public void loginPeakUser(String username, String password) {
        basicActions.waitForElementToBePresentWithRetries(peakUsername, 50);
        peakUsername.sendKeys(username);
        basicActions.waitForElementToBePresentWithRetries(peakPassword, 50);
        peakPassword.sendKeys(password);
        peakSignInButton.click();
    }

    public void validatePeakSkeletonErrorMessage() {
        basicActions.waitForElementListToBePresentWithRetries(peakSkeletonErrorMessage, 20);
        softAssert.assertEquals(peakSkeletonErrorMessage.get(0).getText(), "We\u2019re sorry, but there was an error,");
        softAssert.assertEquals(peakSkeletonErrorMessage.get(1).getText(), "and we cannot sign you into Connect for Health Colorado.");
        softAssert.assertEquals(peakSkeletonErrorMessage.get(2).getText(), "Please call us at 855-752-6749.");
        softAssert.assertAll();
    }

    public void clickSignInWIthConnectForHealthColoradoButton() {
        basicActions.waitForElementToBePresentWithRetries(peakSignInWithConnectForHealthColoradoButton, 20);
        peakSignInWithConnectForHealthColoradoButton.click();
    }

    public void clickPeakSignOUtButton() {
        basicActions.waitForElementToBePresentWithRetries(peakSignOUtButton, 20);
        peakSignOUtButton.click();
    }

    public void validatePeakWelcomeText() {
        basicActions.waitForElementToBePresentWithRetries(peakWelcomeText, 20);
        softAssert.assertEquals(peakWelcomeText.getText(), "Hello " + SharedData.getPrimaryMember().getFirstName() + ", welcome to PEAK");
        softAssert.assertAll();
    }

    public void validatePeakStgUrlRedirection(String peakUrl) {
        basicActions.waitForElementToBePresentWithRetries(peakSignInWithConnectForHealthColoradoButton, 20);
        Assert.assertTrue(basicActions.getUrlWithWait(peakUrl, 45).contains(peakUrl), "expected page::" + peakUrl + "::did not load");
    }

    public void saveC4AccountDetails() {
        basicActions.waitForElementToBePresentWithRetries(c4AssignedUsername, 20);

        MemberDetails newC4Member = new MemberDetails();
        newC4Member.setEmailId(c4AssignedUsername.getText());
        BigDecimal newAccountId = new BigDecimal(c4AssignedAccountId.getText());
        newC4Member.setAccount_id(newAccountId);
        SharedData.setPrimaryMember(newC4Member);
    }

    public void verifyC4AccountDetails() {
        basicActions.waitForElementToBePresentWithRetries(c4AssignedUsername, 20);

        softAssert.assertEquals(c4AssignedUsername.getText(), SharedData.getPrimaryMember().getEmailId());
        BigDecimal foundAccountId = new BigDecimal(c4AssignedAccountId.getText());
        softAssert.assertEquals(foundAccountId, SharedData.getPrimaryMember().getAccount_id());
        softAssert.assertAll();
    }
}
