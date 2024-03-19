package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.SharedData;
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

    @FindBy(css = "div.top-navigation > div > nav > ul > li > a")
    List<WebElement> centerHeaderLinkNonElmo;

    @FindBy(css = "#navMenu > div > a")
    List<WebElement> centerHeaderLinkExpertHelp;

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

    @FindBy(css = "a[class='icon-link language']")
    WebElement languageDrpNonElmo;

    @FindBy(id = "langDropdown")
    WebElement languageDrpSignIn;

    @FindBy(css = "#globe p")
    List<WebElement> languageDrpOption;

    @FindBy(css = "#globe a")
    List<WebElement> languageDrpOption2;

    @FindBy(css = "header  > div > .dropdown-item")
    List<WebElement> languageDrpOptionSignIn;

    @FindBy(css = "li[class='vertical-ruler'] li")
    List<WebElement> languageDrpOptionNonElmo;

    @FindBy(css = ".toolbar-content .sign-out")
    WebElement signOutLink;

    @FindBy(css = ".logged-in li:nth-child(3) a")
    WebElement signOutLinkNonElmo;

    // =========FOOTER============== //
    @FindBy(id = "privacyPolicyLink")
    WebElement privacyPolicyLink;

    @FindBy(id = "termsOfUseLink")
    WebElement termsOfUseLink;

    @FindBy(id = "contactUsLink")
    WebElement contactUsLink;

    @FindBy(id = "contactUsFooterLink")
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
    public void clickApplyForCoverageLink(String pageType) {
//        "Elmo" for CoCo and Exch Elmo pages
////        Exch Elmo pages include: Income Opt Out, Employment Income, Employment Summary, Additional income, Deductions, Income Summary, Employer Sponsored Health Insurance (ESI)
//        "NonElmo" non Elmo pages (not listed above)
//        "ExpertHelp" is for the following pages: Create Account, Manage who helps you/Find Expert Help
        switch (pageType){
            case "Elmo":
                basicActions.waitForElementListToBePresent(centerHeaderLink, 15);
                centerHeaderLink.get(0).click();
                break;
            case "NonElmo":
                basicActions.waitForElementListToBePresent(centerHeaderLinkNonElmo, 15);
                centerHeaderLinkNonElmo.get(0).click();
                break;
            case "ExpertHelp":
                basicActions.waitForElementListToBePresent(centerHeaderLinkExpertHelp, 15);
                centerHeaderLinkExpertHelp.get(0).click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }
    }
    public void clickFindAPlanLinkLink() {
        basicActions.waitForElementListToBePresent(centerHeaderLink, 15);
        centerHeaderLink.get(1).click();
    }
    public void clickMyAccountLink(String pageType) {

        // "Elmo" for CoCo and Exch Elmo pages
////       Exch Elmo pages include: Income Opt Out, Employment Income, Employment Summary, Additional income, Deductions, Income Summary, Employer Sponsored Health Insurance (ESI)
//        "ENonElmo" non Elmo pages (not listed above)
        switch (pageType) {
            case "Elmo":
                basicActions.waitForElementListToBePresent(centerHeaderLink, 15);
                centerHeaderLink.get(2).click();
                break;
            case "NonElmo":
                basicActions.waitForElementListToBePresent(centerHeaderLinkNonElmo, 15);
                centerHeaderLinkNonElmo.get(2).click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }
    }

    public void clickLearnMoreLink() {
        basicActions.waitForElementToBeClickable(learnMoreLink, 15);
        learnMoreLink.click();
    }
    public void clickGetAssistanceLink() {
        basicActions.waitForElementToBeClickable(getAssistanceLink, 15);
        getAssistanceLink.click();
    }
    public void clickFindExpertAssistanceLink(String pageType) {
        switch (pageType){
            case "CoCo":
                basicActions.waitForElementToBeClickable(getAssistanceLinkOption.get(0), 20);
                getAssistanceLinkOption.get(0).click();
                break;
            case "Exch":
                basicActions.waitForElementToBeClickable(getAssistanceLinkOption.get(1), 20);
                getAssistanceLinkOption.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);

        }
    }
    public void clickContactUsHeaderLink() {
        basicActions.waitForElementToBeClickable(getAssistanceLinkOption.get(0), 20);
        getAssistanceLinkOption.get(0).click();
    }
    public void clickUserNameLink(String pageType) {
        switch (pageType){
            case "CoCo":
                basicActions.waitForElementToBeClickable(userNameLink, 90);
                userNameLink.click();
                break;
            case "Exch":
                basicActions.waitForElementToBeClickable(userNameLinkExch, 90);
                userNameLinkExch.click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }
    }

    public void clickLanguageDrp() {
        basicActions.waitForElementToBePresent(languageDrp, 60);
        languageDrp.click();
    }

    public void changeLanguage(String language) {
//        "English" and "Spanish" for CoCo and Exch Elmo pages
////        Exch Elmo pages include: Income Opt Out, Employment Income, Employment Summary, Additional income, Deductions, Income Summary, Employer Sponsored Health Insurance (ESI)
//        "English Login" and "Spanish Login" is for the Login page
//        "English ExpertHelp" and "Spanish ExpertHelp" is for the following pages: Create Account, Manage who helps you/Find Expert Help

        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(languageDrp, 60);
                languageDrp.click();
                basicActions.waitForElementToBePresent(languageDrpOption.get(0), 60);
                languageDrpOption.get(0).click();
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(languageDrp, 60);
                languageDrp.click();
                basicActions.waitForElementToBePresent(languageDrpOption.get(1), 60);
                languageDrpOption.get(1).click();
                break;
            case "English NonElmo":
                basicActions.waitForElementToBePresent(languageDrpNonElmo, 60);
                languageDrpNonElmo.click();
                basicActions.waitForElementToBePresent(languageDrpOptionNonElmo.get(0), 60);
                languageDrpOptionNonElmo.get(0).click();
                break;
            case "Spanish NonElmo":
                basicActions.waitForElementToBePresent(languageDrpNonElmo, 60);
                languageDrpNonElmo.click();
                basicActions.waitForElementToBePresent(languageDrpOptionNonElmo.get(1), 60);
                languageDrpOptionNonElmo.get(1).click();
                break;
            case "English Login":
                basicActions.waitForElementToBePresent(languageDrpSignIn, 60);
                languageDrpSignIn.click();
                basicActions.waitForElementToBePresent(languageDrpOptionSignIn.get(0), 60);
                languageDrpOptionSignIn.get(0).click();
                break;
            case "Spanish Login":
                basicActions.waitForElementToBePresent(languageDrpSignIn, 60);
                languageDrpSignIn.click();
                basicActions.waitForElementToBePresent(languageDrpOptionSignIn.get(1), 60);
                languageDrpOptionSignIn.get(1).click();
                break;
            case "English ExpertHelp":
                basicActions.waitForElementToBePresent(languageDrp, 60);
                languageDrp.click();
                basicActions.waitForElementToBePresent(languageDrpOption2.get(0), 60);
                languageDrpOption2.get(0).click();
                break;
            case "Spanish ExpertHelp":
                basicActions.waitForElementToBePresent(languageDrp, 60);
                languageDrp.click();
                basicActions.waitForElementToBePresent(languageDrpOption2.get(1), 60);
                languageDrpOption2.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void clickSignOutLink(String pageType) {
        switch (pageType) {
            case "Elmo":
                basicActions.waitForElementToBePresent(signOutLink,10);
                basicActions.scrollToElement(signOutLink);
                basicActions.click(signOutLink);
                break;
            case "NonElmo":
                basicActions.waitForElementToBePresent(signOutLinkNonElmo,10);
                basicActions.scrollToElement(signOutLinkNonElmo);
                basicActions.click(signOutLinkNonElmo);
                break;
            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }
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
        softAssert.assertEquals(userNameLink.getText(), SharedData.getSubscriber().getEmailId());
        softAssert.assertEquals(languageDrp.getText(), "");
        clickLanguageDrp();
        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLink.getText(), "Sign Out");
        softAssert.assertAll();
    }

    public void verifyTextInCoCoHeaderSpanish(){
        basicActions.waitForElementToBePresent(connectLogoLink,10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Solicitud de cobertura");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Buscar un plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "Mi cuenta");
        softAssert.assertEquals(learnMoreLink.getText(), "M\u00E1s informaci\u00F3n");
        softAssert.assertEquals(getAssistanceLink.getText(), "Obtener asistencia");
        clickGetAssistanceLink();
        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Buscar asistencia de expertos en su comunidad");
        softAssert.assertEquals(userNameLink.getText(), SharedData.getSubscriber().getEmailId());
        softAssert.assertEquals(languageDrp.getText(), "");
        clickLanguageDrp();
        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLink.getText(), "Cerrar sesi\u00F3n");
        softAssert.assertAll();
    }

    public void verifyTextInExchHeader(){
        basicActions.waitForElementToBePresent(connectLogoLink,10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Apply for Coverage");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Find a Plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "My Account");
        softAssert.assertEquals(learnMoreLink.getText(), "Learn More");
        softAssert.assertEquals(userNameLinkExch.getText(), SharedData.getSubscriber().getEmailId());
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
        softAssert.assertEquals(userNameLinkExch.getText(), SharedData.getSubscriber().getEmailId());
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
    public void verifyHeaderFooterText(String appType, String HeaderOrFooter, String language) {
        switch (appType) {
            case "Exch":
                verifyExchHeaderFooterText(HeaderOrFooter, language);
                break;
            case "CoCo":
                verifyCoCoHeaderFooterText(HeaderOrFooter, language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + appType);
        }
    }

    public void verifyCoCoHeaderFooterTextEnglish(String HeaderOrFooter) {
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

    public void verifyCoCoHeaderFooterTextSpanish(String HeaderOrFooter) {
        switch (HeaderOrFooter) {
            case "Header":
                verifyTextInCoCoHeaderSpanish();
                break;
            case "Footer":
                verifyTextInCoCoFooterSpanish();
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

    public void verifyCoCoHeaderFooterText(String language, String HeaderOrFooter) {
        switch (language) {
            case "English":
                verifyCoCoHeaderFooterTextEnglish(HeaderOrFooter);
                break;
            case "Spanish":
                verifyCoCoHeaderFooterTextSpanish(HeaderOrFooter);
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
    public void clickContactUsLink(String appType) {
        switch(appType){
            case "CoCo":
                basicActions.waitForElementToBeClickable(contactUsLink, 10);
                contactUsLink.click();
                break;
            case "Exch":
                basicActions.waitForElementToBeClickable(contactUsLinkExch, 10);
                contactUsLinkExch.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + appType);
        }
    }
    public void clickFacebookIcon(String MediaIcon) {
        switch (MediaIcon){
            case "Facebook":
                basicActions.waitForElementToBeClickable(FacebookIcon, 10);
                FacebookIcon.click();
                break;
            case "X":
                basicActions.waitForElementToBeClickable(xIcon, 10);
                xIcon.click();
                break;
            case "YouTube":
                basicActions.waitForElementToBeClickable(YouTubeIcon, 10);
                YouTubeIcon.click();
                break;
            case "Instagram":
                basicActions.waitForElementToBeClickable(InstagramIcon, 10);
                InstagramIcon.click();
                break;
            case "LinkedIn":
                basicActions.waitForElementToBeClickable(LinkedInIcon, 10);
                LinkedInIcon.click();
                break;
            case "Threads":
                basicActions.waitForElementToBeClickable(ThreadsIcon, 10);
                ThreadsIcon.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + MediaIcon);
        }
    }

    public void verifyTextInCoCoFooter(){
        basicActions.waitForElementToBePresent(connectLogoLink,10);
        softAssert.assertEquals(privacyPolicyLink.getText(), "Privacy Policy");
        softAssert.assertEquals(termsOfUseLink.getText(), "Terms Of Use");
        softAssert.assertEquals(contactUsLink.getText(), "Contact Us");
        softAssert.assertEquals(copyRightCoCoText.getText(), "\u00a92024 COLORADO CONNECT. ALL RIGHTS RESERVED.");
        softAssert.assertAll();
    }

    public void verifyTextInCoCoFooterSpanish(){
        basicActions.waitForElementToBePresent(connectLogoLink,10);
        softAssert.assertEquals(privacyPolicyLink.getText(), "Pol\u00EDtica de privacidad");
        softAssert.assertEquals(termsOfUseLink.getText(), "T\u00E9rminos de uso");
        softAssert.assertEquals(contactUsLink.getText(), "P\u00F3ngase en contacto");
        softAssert.assertEquals(copyRightCoCoText.getText(), "\u00a92024 COLORADO CONNECT. Todos los derechos reservados.");
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
