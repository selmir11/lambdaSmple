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

    @FindBy(css = ".dropdown .clickable")
    List<WebElement> getAssistanceLinkOption;

    @FindBy(css = ".toolbar-content .username")
    WebElement userNameLink;

    @FindBy(css = ".toolbar-content .toolbar-text .toolbar-text")
    WebElement userNameLinkExch;

    @FindBy(id = "globe-image")
    WebElement languageDrp;

    @FindBy(css = "#globe p")
    List<WebElement> languageDrpOption;

    @FindBy(css = "#globe a")
    List<WebElement> languageDrpOptionNonElmo;

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
    WebElement contactUsLinkExch;

    @FindBy(css = ".terms-container .copyright")
    WebElement copyRightCoCoText;

    @FindBy(css = ".content-container .follow-us")
    WebElement followUsText;

    @FindBy(id = "facebook-img")
    WebElement FacebookIcon;

    @FindBy(id = "x-img")
    WebElement xIcon;

    @FindBy(id = "youtube-img")
    WebElement YouTubeIcon;

    @FindBy(id = "LinkedIn-img")
    WebElement LinkedInIcon;

    @FindBy(id = "threads-img")
    WebElement ThreadsIcon;

    @FindBy(id = "instagram-img")
    WebElement InstagramIcon;

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
            case "English NonElmo":
                basicActions.waitForElementToBePresent(languageDrpOptionNonElmo.get(0), 60);
                languageDrpOptionNonElmo.get(0).click();
                break;
            case "Spanish NonElmo":
                basicActions.waitForElementToBePresent(languageDrpOptionNonElmo.get(1), 60);
                languageDrpOptionNonElmo.get(1).click();
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

    public void verifyTextInExchHeader(){
        basicActions.waitForElementToBePresent(connectLogoLink,10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Apply for Coverage");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Find a Plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "My Account");
        softAssert.assertEquals(learnMoreLink.getText(), "Learn More");
        softAssert.assertEquals(userNameLinkExch.getText(), SharedData.getEmailId());
        softAssert.assertEquals(languageDrp.getText(), "");
        clickLanguageDrp();
        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLink.getText(), "Sign Out");
        softAssert.assertEquals(getAssistanceLink.getText(), "Get Assistance");
        clickGetAssistanceLink();
        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Contact Us");
        softAssert.assertEquals(getAssistanceLinkOption.get(1).getText(), "Find Expert Assistance in Your Community");
        softAssert.assertAll();
    }

    public void verifyTextInExchHeaderSpanish(){
        basicActions.waitForElementToBePresent(connectLogoLink,10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Solicitud de cobertura");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Buscar un plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "Mi cuenta");
        softAssert.assertEquals(learnMoreLink.getText(), "M\u00E1s informaci\u00F3n");
        softAssert.assertEquals(userNameLinkExch.getText(), SharedData.getEmailId());
        softAssert.assertEquals(languageDrp.getText(), "");
        clickLanguageDrp();
        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLink.getText(), "Cerrar sesi\u00F3n");
        softAssert.assertEquals(getAssistanceLink.getText(), "Obtener asistencia");
        clickGetAssistanceLink();
        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Contacta con nosotros");
        softAssert.assertEquals(getAssistanceLinkOption.get(1).getText(), "Buscar asistencia de expertos en su comunidad");
        softAssert.assertAll();
    }


    // =========HEADER AND FOOTER============== //
    public void verifyHeaderFooterText(String HeaderOrFooter) {
        switch (HeaderOrFooter) {
            case "Header":
                verifyTextInCoCoHeader();
                break;
            case "Footer":
                verifyTextInCoCoFooter();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + HeaderOrFooter);
        }
    }

        public void verifyExchHeaderFooterTextEnglish(String HeaderOrFooter){
            switch (HeaderOrFooter) {
                case "Header":
                    verifyTextInExchHeader();
                    break;
                case "Footer":
                    verifyTextInExchFooter();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + HeaderOrFooter);
            }
    }

    public void verifyExchHeaderFooterTextSpanish(String HeaderOrFooter){
        switch (HeaderOrFooter) {
            case "Header":
                verifyTextInExchHeaderSpanish();
                break;
            case "Footer":
                verifyTextInExchFooterSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + HeaderOrFooter);
        }
    }

    public void verifyExchHeaderFooterText(String language, String HeaderOrFooter) {
        switch (language) {
            case "English":
                verifyExchHeaderFooterTextEnglish(HeaderOrFooter);
                break;
            case "Spanish":
                verifyExchHeaderFooterTextSpanish(HeaderOrFooter);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
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

    public void verifyTextInExchFooter(){
        basicActions.waitForElementToBePresent(connectLogoLink,10);
        softAssert.assertEquals(privacyPolicyLink.getText(), "Privacy Policy");
        softAssert.assertEquals(termsOfUseLink.getText(), "Terms Of Use");
        softAssert.assertEquals(contactUsLinkExch.getText(), "Contact Us");
        softAssert.assertEquals(copyRightCoCoText.getText(), "\u00a9 2024 Connect for Health Colorado. All Rights Reserved.");
        softAssert.assertEquals(followUsText.getText(), "Follow Us:");
        softAssert.assertEquals(FacebookIcon.getAttribute("title"), "Facebook");
        softAssert.assertEquals(xIcon.getAttribute("title"), "X");
        softAssert.assertEquals(YouTubeIcon.getAttribute("title"), "Youtube");
        softAssert.assertEquals(InstagramIcon.getAttribute("title"), "Instagram");
        softAssert.assertEquals(LinkedInIcon.getAttribute("title"), "LinkedIn");
        softAssert.assertEquals(ThreadsIcon.getAttribute("title"), "Threads");
        softAssert.assertAll();
    }

    public void verifyTextInExchFooterSpanish(){
        basicActions.waitForElementToBePresent(connectLogoLink,10);
        softAssert.assertEquals(privacyPolicyLink.getText(), "P\u00F3liza de privacidad");
        softAssert.assertEquals(termsOfUseLink.getText(), "T\u00E9rminos y Condiciones");
        softAssert.assertEquals(contactUsLinkExch.getText(), "Comentarios");
        softAssert.assertEquals(copyRightCoCoText.getText(), "\u00a9 2024 Connect for Health Colorado. Todos los derechos reservados.");
        softAssert.assertEquals(followUsText.getText(), "S\u00EDguenos en:");
        softAssert.assertEquals(FacebookIcon.getAttribute("title"), "Facebook");
        softAssert.assertEquals(xIcon.getAttribute("title"), "X");
        softAssert.assertEquals(YouTubeIcon.getAttribute("title"), "Youtube");
        softAssert.assertEquals(InstagramIcon.getAttribute("title"), "Instagram");
        softAssert.assertEquals(LinkedInIcon.getAttribute("title"), "LinkedIn");
        softAssert.assertEquals(ThreadsIcon.getAttribute("title"), "Threads");
        softAssert.assertAll();
    }

}
