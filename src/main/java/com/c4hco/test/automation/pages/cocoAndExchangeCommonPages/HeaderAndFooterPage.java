package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HeaderAndFooterPage {
    SoftAssert softAssert = new SoftAssert();

    @FindBy(id = "logo-image")
    WebElement connectLogoLink;

    @FindBy(css = ".center-links .clickable")
    List<WebElement> centerHeaderLink;

    @FindBy(css = ".learnmore-getassistance-flex-item .learn-more")
    WebElement learnMoreLink;

    @FindBy(css = ".learnmore-getassistance-flex-item .get-assistance")
    WebElement getAssistanceLink;

    @FindBy(css = ".learnmore-getassistance-flex-item .dropdown-content")
    List<WebElement> getAssistanceLinkOption;

    @FindBy(css = ".toolbar-content .username")
    WebElement userNameLink;

    @FindBy(id = "globe-image")
    WebElement languageDrp;

    @FindBy(css = "#globe p")
    List<WebElement> languageDrpOption;

    @FindBy(css = "#globe a")
    List<WebElement> languageDrpOptionCreatePage;

    @FindBy(css = ".toolbar-content .sign-out")
    WebElement signOutLink;

    // =========FOOTER============== //
    @FindBy(id = "privacyPolicyLink")
    WebElement privacyPolicyLink;

    @FindBy(id = "termsOfUseLink")
    WebElement termsOfUseLink;

    @FindBy(id = "contactUsLink")
    WebElement contactUsLink;

    @FindBy(css = ".flex-row .copyright")
    WebElement copyRightCoCoText;

    private BasicActions basicActions;

    public HeaderAndFooterPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public void clickConnectLogoLink() {
        basicActions.waitForElementToBeClickable(connectLogoLink, 10);
        connectLogoLink.click();
    }
    public void clickApplyForCoverageLink() {
        basicActions.waitForElementToBeClickable(centerHeaderLink.get(0), 90);
        centerHeaderLink.get(0).click();
    }
    public void clickFindAPlanLinkLink() {
        basicActions.waitForElementToBeClickable(centerHeaderLink.get(1), 90);
        centerHeaderLink.get(1).click();
    }
    public void clickMyAccountLink() {
        basicActions.waitForElementToBeClickable(centerHeaderLink.get(2), 90);
        centerHeaderLink.get(2).click();
    }
    public void clickLearnMoreLink() {
        basicActions.waitForElementToBeClickable(learnMoreLink, 90);
        learnMoreLink.click();
    }
    public void clickGetAssistanceLink() {
        basicActions.waitForElementToBeClickable(getAssistanceLink, 90);
        getAssistanceLink.click();
    }
    public void clickFindExpertAssistanceLink() {
        basicActions.waitForElementToBeClickable(getAssistanceLinkOption.get(0), 20);
        getAssistanceLinkOption.get(0).click();
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
                basicActions.waitForElementToBePresent(languageDrpOption.get(0), 60);
                languageDrpOption.get(0).click();
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(languageDrpOption.get(1), 60);
                languageDrpOption.get(1).click();
                break;
            case "English Create":
                basicActions.waitForElementToBePresent(languageDrpOptionCreatePage.get(0), 60);
                languageDrpOptionCreatePage.get(0).click();
                break;
            case "Spanish Create":
                basicActions.waitForElementToBePresent(languageDrpOptionCreatePage.get(1), 60);
                languageDrpOptionCreatePage.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void clickSignOutLink() {
        basicActions.waitForElementToBeClickable(signOutLink, 20);
        signOutLink.click();
    }

    public void verifyTextInCoCoHeader(){
        basicActions.waitForElementToBePresent(connectLogoLink,10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Apply for Coverage");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Find a Plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "My Account");
        softAssert.assertEquals(learnMoreLink.getText(), "Learn More");
        softAssert.assertEquals(getAssistanceLink.getText(), "Get Assistance");
        clickGetAssistanceLink();
        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Find Expert Assistance in Your Community");
        softAssert.assertEquals(userNameLink.getText(), SharedData.getEmailId());
        softAssert.assertEquals(languageDrp.getText(), "");
        clickLanguageDrp();
        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
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
        softAssert.assertEquals(privacyPolicyLink.getText(), "Privacy Policy");
        softAssert.assertEquals(termsOfUseLink.getText(), "Terms Of Use");
        softAssert.assertEquals(contactUsLink.getText(), "Contact Us");
        softAssert.assertEquals(copyRightCoCoText.getText(), "\u00a92024 COLORADO CONNECT. ALL RIGHTS RESERVED.");
        softAssert.assertAll();
    }

}
