package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import static com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CreateAccountPage.emailId;


public class HeaderAndFooterPage {
    @FindBy(id = "logo-image")
    WebElement connectLogoLink;

    @FindBy(xpath = "//*[text()=' Apply for Coverage']")
    WebElement applyForCoverageLink;

    @FindBy(xpath = "//*[text()='Find a Plan']")
    WebElement findAPlanLink;

    @FindBy(xpath = "//*[text()='My Account']")
    WebElement myAccountLink;

    @FindBy(xpath = "//*[text()=' Learn More']")
    WebElement learnMoreLink;

    @FindBy(xpath = "//*[text()='Get Assistance']")
    WebElement getAssistanceLink;

    @FindBy(xpath = "//*[text()=' Find Expert Assistance in Your Community ']")
    WebElement findExpertAssistanceLink;

    @FindBy(xpath = "//div[2]//div[3]/a")
    WebElement userNameLink;

    @FindBy(id = "globe-image")
    WebElement languageDrp;

    @FindBy(xpath = "//p[normalize-space()='English']")
    WebElement englishLanguageCoCo;

    @FindBy(xpath = "//p[normalize-space()='En espa\u00f1ol']")
    WebElement spanishLanguageCoCo;

    @FindBy(xpath = "//div[@class='dropdown-content-lang']//a[contains(text(),'English')]")
    WebElement englishLanguage;

    @FindBy(xpath = "//div[@class='dropdown-content-lang']//a[contains(text(),'Spanish')]")
    WebElement spanishLanguage;

    @FindBy(xpath = "//div[@class='p-2 sign-out']//a[@class='toolbar-text clickable']")
    WebElement signOutLink;

    // =========FOOTER============== //
    @FindBy(id = "privacyPolicyLink")
    WebElement privacyPolicyLink;

    @FindBy(id = "termsOfUseLink")
    WebElement termsOfUseLink;

    @FindBy(id = "contactUsLink")
    WebElement contactUsLink;

    @FindBy(xpath = "//span[contains (text(), 'ALL RIGHTS RESERVED')]")
    WebElement copyRightCoCoText;



    private BasicActions basicActions;

    public HeaderAndFooterPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public void clickConnectLogoLink() {
        basicActions.waitForElementToBeClickable(connectLogoLink, 10);
        connectLogoLink.click();
    }
    public void clickApplyForCoverageLink() {
        basicActions.waitForElementToBeClickable(applyForCoverageLink, 10);
        applyForCoverageLink.click();
    }
    public void clickFindAPlanLinkLink() {
        basicActions.waitForElementToBeClickable(findAPlanLink, 10);
        findAPlanLink.click();
    }
    public void clickMyAccountLink() {
        basicActions.waitForElementToBeClickable(myAccountLink, 10);
        myAccountLink.click();
    }
    public void clickLearnMoreLink() {
        basicActions.waitForElementToBeClickable(learnMoreLink, 10);
        learnMoreLink.click();
    }
    public void clickGetAssistanceLink() {
        basicActions.waitForElementToBeClickable(getAssistanceLink, 10);
        getAssistanceLink.click();
    }
    public void clickFindExpertAssistanceLink() {
        basicActions.waitForElementToBeClickable(findExpertAssistanceLink, 20);
        findExpertAssistanceLink.click();
    }
    public void clickUserNameLink() {
        basicActions.waitForElementToBeClickable(userNameLink, 20);
        userNameLink.click();
    }

    public void clickLanguageDrp() {
        basicActions.waitForElementToBePresent(languageDrp, 60);
        languageDrp.click();
    }

    public void changeLanguage(String language) {
        basicActions.waitForElementToBePresent(languageDrp, 60);
        languageDrp.click();

        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(englishLanguage, 60);
                englishLanguage.click();
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(spanishLanguage, 60);
                spanishLanguage.click();
                break;
            case "English ELMO":
                basicActions.waitForElementToBePresent(englishLanguageCoCo, 60);
                englishLanguageCoCo.click();
                break;
            case "Spanish ELMO":
                basicActions.waitForElementToBePresent(spanishLanguageCoCo, 60);
                spanishLanguageCoCo.click();
                break;
        }
    }

    public void clickSignOutLink() {
        basicActions.waitForElementToBeClickable(signOutLink, 20);
        signOutLink.click();
    }

    public void verifyTextInCoCoHeader(){
        basicActions.waitForElementToBePresent(connectLogoLink,10);
        String header  = connectLogoLink.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(applyForCoverageLink.getText(), "Apply for Coverage");
        softAssert.assertEquals(findAPlanLink.getText(), "Find a Plan");
        softAssert.assertEquals(myAccountLink.getText(), "My Account");
        softAssert.assertEquals(learnMoreLink.getText(), "Learn More");
        softAssert.assertEquals(getAssistanceLink.getText(), "Get Assistance");
        clickGetAssistanceLink();
        softAssert.assertEquals(findExpertAssistanceLink.getText(), "Find Expert Assistance in Your Community");
        softAssert.assertEquals(userNameLink.getText(), emailId);
        softAssert.assertEquals(languageDrp.getText(), "");
        clickLanguageDrp();
        softAssert.assertEquals(englishLanguageCoCo.getText(), "English");
        softAssert.assertEquals(spanishLanguageCoCo.getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLink.getText(), "Sign Out");
        softAssert.assertAll();
    }

    // =========FOOTER============== //
    public void clickPrivacyPolicyLink() {
        basicActions.waitForElementToBeClickable(privacyPolicyLink, 20);
        privacyPolicyLink.click();
    }
    public void clickTermsOfUseLink() {
        basicActions.waitForElementToBeClickable(termsOfUseLink, 10);
        termsOfUseLink.click();
    }
    public void clickContactUsLink() {
        basicActions.waitForElementToBeClickable(contactUsLink, 10);
        contactUsLink.click();
    }

    public void verifyTextInCoCoFooter(){
        basicActions.waitForElementToBePresent(connectLogoLink,10);
        String header  = connectLogoLink.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(privacyPolicyLink.getText(), "Privacy Policy");
        softAssert.assertEquals(termsOfUseLink.getText(), "Terms Of Use");
        softAssert.assertEquals(contactUsLink.getText(), "Contact Us");
        softAssert.assertEquals(copyRightCoCoText.getText(), "\u00a92024 COLORADO CONNECT. ALL RIGHTS RESERVED.");
        softAssert.assertAll();
    }

}
