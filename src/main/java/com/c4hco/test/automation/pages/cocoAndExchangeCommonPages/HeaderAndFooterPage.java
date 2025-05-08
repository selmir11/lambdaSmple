package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;
import com.c4hco.test.automation.utils.BasicActions;

import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.time.Year;
import java.util.List;
import java.util.Map;

public class HeaderAndFooterPage {
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(WebDriverManager.getDriver());

    @FindBy(id = "logo-image")
    WebElement connectLogoLink;

    @FindBy(xpath = "//a[@class='logo']")
    WebElement connectLogoNonElmo;

    @FindBy(css = ".logo")
    WebElement connectLogoLinkNonElmo;
    @FindBy(id = "logo")
    WebElement connectLogoLinkExpertHelp;

    @FindBy(css = ".center-links .clickable")
    List<WebElement> centerHeaderLink;

    @FindBy (xpath = "//*[@class = 'strong vertical-ruler-left']")
    WebElement FindAPlan;

    @FindBy(css = "div.top-navigation > div > nav > ul > li > a")
    List<WebElement> centerHeaderLinkNonElmo;

    @FindBy(css = ".center-links a")
    List<WebElement> centerHeaderLinkExpertHelp;

    @FindBy(css = ".learnmore-getassistance-flex-item .learn-more")
    WebElement learnMoreLink;

    @FindBy(css = ".top-navigation > div > nav > ul > span > li > a")
    WebElement learnMoreLinkNonElmo;

    @FindBy(css = ".learnmore-getassistance-flex-item .get-assistance")
    WebElement getAssistanceLink;

    @FindBy(css = ".top-navigation > div > nav > ul > span > li.stacked.dropdown > div:nth-child(1) > a")
    WebElement getAssistanceLinkNonElmo;

    @FindBy(id = "navbarDropdown")
    WebElement getAssistanceLinkExpertHelp;

    @FindBy(id = "ga")
    WebElement getAssistanceLinkLoginPortal;

    @FindBy(xpath = "//button[normalize-space()='Get Assistance']")
    WebElement getAssistanceLinkMyDocument;

    @FindBy(css = ".dropdown .clickable")
    List<WebElement> getAssistanceLinkOption;

    @FindBy(xpath = "//div[@class='dropdown-menu show']//a")
    List<WebElement> getAssistanceLoginPortalOption;

    @FindBy(css = ".stacked.dropdown > div.dropdown-content > a")
    WebElement getAssistanceLinkOptionNonElmo;

    @FindBy(css = ".stacked.dropdown > div.dropdown-content > form > a")
    WebElement getAssistanceLinkOptionNonElmo1;
    @FindBy(xpath = "//*[@id='get-assistance']/div/a[2]")
    WebElement findExpertAssistanceExpertHelp;
    @FindBy(xpath = "//span/li[2]/div[2]/form")
    WebElement findExpertAssistanceIndividualDashboard;
    @FindBy(css = "span > li.stacked.dropdown > div.dropdown-content > a:nth-child(2)")
    WebElement findExpertAssistanceLugy;

    @FindBy(id = "expert-ga")
    WebElement findExpertAssistanceExpertInCoomunity;

    @FindBy(css = ".toolbar-content .username")
    WebElement userNameLink;

    @FindBy(css = ".toolbar-content .toolbar-text .toolbar-text")
    WebElement userNameLinkExch;

    @FindBy(css = "nav > ul > li > span > a > strong")
    WebElement userNameLinkExchNonElmo;

    @FindBy(id = "globe-image")
    WebElement languageDrp;

    @FindBy(css = "a[class='icon-link language']")
    WebElement languageDrpNonElmo;

    @FindBy(id = "globe-image")
    WebElement languageDrpSignIn;

    @FindBy(css = "#globe p")
    List<WebElement> languageDrpOption;

    @FindBy(css = "#globe a")
    List<WebElement> languageDrpOption2;

    @FindBy(id = "esp")
    WebElement languageDrpOptionSignInSpanish;

    @FindBy(id = "eng")
    WebElement languageDrpOptionSignInEnglish;

    @FindBy(css = "li[class='vertical-ruler'] li")
    List<WebElement> languageDrpOptionNonElmo;

    @FindBy(css = ".toolbar-content .sign-out")
    WebElement signOutLink;


    @FindBy(xpath = "//strong[normalize-space()='Sign Out']")
    WebElement signOutOverview;

    @FindBy(xpath = "//strong[normalize-space()='Sign Out']")
    WebElement signOutHousholdPage;
    @FindBy(linkText = "Sign Out")
    WebElement signOutinCaseIdPage;

    @FindBy(css = ".logged-in li:nth-child(3) a")
    WebElement signOutLinkNonElmo;

    //@FindBy(xpath = "//*[@id ='sign-out") //
    @FindBy(css = "#sign-out")
    WebElement signOutLinkPortal;

    @FindBy(xpath = "//div[@class = 'p-2 sign-out']")
    WebElement medicalSignoutLink;

    @FindBy(xpath = "//*[@id ='sign-out']")
    WebElement  signOutDentalPlanResults;

    @FindBy(css = "#sign-out") // this is for "Who helps you Page" Sign out only.
    WebElement signOutLinkWhoHelpsPage;

    // =========FOOTER============== //

    //Admin Portal Footer Links
    @FindBy(linkText = "Privacy Policy")
    WebElement APprivacyPolicyLink;

    @FindBy(linkText = "Terms of Use")
    WebElement APtermsOfUseLink;

    @FindBy(linkText = "Contact Us")
    WebElement APcontactUsLink;

    @FindBy(css = "div[class='copyright'] span")
    WebElement APcopyRightText;

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

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinnerOverlay;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(xpath = "//button[@class='dropbtn header-link-text']")
    WebElement getAssistance;

    private BasicActions basicActions;

    public HeaderAndFooterPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickConnectLogoLink(String pageType) {
        switch (pageType){
            case "NonElmo":
                basicActions.waitForElementToBeClickable(connectLogoNonElmo, 10);
                connectLogoNonElmo.click();
                break;
            case "Elmo":
                basicActions.waitForElementToDisappear(spinner, 30);
                basicActions.waitForElementToBeClickableWithRetries(connectLogoLink, 10);
                connectLogoLink.click();
                break;
            case "FindAPlan":
                basicActions.waitForElementToBePresent( FindAPlan, 15 );
                FindAPlan.click();
                break;
            case "ExpertHelp":
                basicActions.waitForElementToBePresent(connectLogoLinkExpertHelp,20);
                connectLogoLinkExpertHelp.click();
                break;
            case "My Policies":
                basicActions.waitForElementToBeClickable(connectLogoLink, 10);
                connectLogoLink.click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }

    }

    public void clickApplyForCoverageLink(String pageType) {
//        "Elmo" for CoCo and Exch Elmo pages
////        Exch Elmo pages include: Income Opt Out, Employment Income, Employment Summary, Additional income, Deductions, Income Summary, Employer Sponsored Health Insurance (ESI)
//        "NonElmo" non Elmo pages (not listed above)
//        "ExpertHelp" is for the following pages: Create Account, Manage who helps you/Find Expert Help
        basicActions.waitForElementToDisappear(spinner,60);
        basicActions.waitForElementToDisappear(spinnerOverlay,60);
        switch (pageType) {
            case "Elmo":
                basicActions.waitForElementListToBePresentWithRetries(centerHeaderLink, 70);
                basicActions.waitForElementToBePresentWithRetries(learnMoreLink, 70);
                basicActions.waitForElementToBePresentWithRetries(getAssistanceLink, 70);
                basicActions.waitForElementToBePresentWithRetries(languageDrp, 70);
                basicActions.scrollToElement(learnMoreLink);
                centerHeaderLink.get(0).click();
                break;
            case "NonElmo":
                basicActions.waitForElementListToBePresent(centerHeaderLinkNonElmo, 15);
                centerHeaderLinkNonElmo.get(0).click();
                break;
            case "ExpertHelp":
                basicActions.waitForElementListToBePresentWithRetries(centerHeaderLinkExpertHelp, 70);
                centerHeaderLinkExpertHelp.get(0).click();
                break;

            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }
    }

    public void rightClickApplyForCoverageLink() {
        basicActions.waitForElementListToBePresentWithRetries(centerHeaderLink, 70);
        basicActions.waitForElementToBePresentWithRetries(learnMoreLink, 70);
        basicActions.waitForElementToBePresentWithRetries(getAssistanceLink, 70);
        basicActions.waitForElementToBePresentWithRetries(languageDrp, 70);
        basicActions.scrollToElement(learnMoreLink);
        Actions actions = new Actions(basicActions.getDriver());
        actions.keyDown(Keys.CONTROL)
                .click(centerHeaderLink.get(0))
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
    }

    public void clickFindAPlanLinkLink(String pageType) {
        switch (pageType){
            case "Elmo":
            basicActions.waitForElementListToBePresentWithRetries(centerHeaderLink, 90);
            basicActions.waitForElementToBePresentWithRetries(connectLogoLink, 60);
            centerHeaderLink.get(1).click();
            break;
            case "NonElmo":
                basicActions.waitForElementListToBePresent(centerHeaderLinkNonElmo, 15);
                centerHeaderLinkNonElmo.get(1).click();
                break;
            case "Expert Help":
            basicActions.waitForElementListToBePresentWithRetries(centerHeaderLinkExpertHelp, 15);
            centerHeaderLinkExpertHelp.get(1).click();
            break;
        default:
            throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }
    }

    public void clickMyAccountLink(String pageType) {

        // "Elmo" for CoCo and Exch Elmo pages
////       Exch Elmo pages include: Income Opt Out, Employment Income, Employment Summary, Additional income, Deductions, Income Summary, Employer Sponsored Health Insurance (ESI)
//        "ENonElmo" non Elmo pages (not listed above)
        switch (pageType) {
            case "Elmo":
                basicActions.waitForElementListToBePresentWithRetries(centerHeaderLink, 60);
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
        basicActions.waitForElementToDisappear(spinner,20);
        basicActions.waitForElementToBeClickableWithRetries(learnMoreLink, 60);
        learnMoreLink.click();
    }

    public void clickGetAssistanceLink(String pageType) {
        switch (pageType){
            case "Exch":
                basicActions.waitForElementToBeClickableWithRetries(getAssistanceLink, 15);
                getAssistanceLink.click();
                break;
            case "Exch NonElmo":
                basicActions.waitForElementToBeClickable(getAssistanceLinkNonElmo, 15);
                getAssistanceLinkNonElmo.click();
                break;
            case "Exch ExpertHelp":
                basicActions.waitForElementToBeClickable(getAssistanceLinkExpertHelp, 20);
                getAssistanceLinkExpertHelp.click();
                break;
            case "Login Portal":
                basicActions.waitForElementToBeClickable(getAssistanceLinkLoginPortal, 15);
                getAssistanceLinkLoginPortal.click();
                break;
            case "My Document":
                basicActions.waitForElementToBePresent(getAssistanceLinkMyDocument, 30);
                getAssistanceLinkMyDocument.click();
            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }
    }

    public void clickFindExpertAssistanceLink(String pageType) {
        switch (pageType) {
            case "CoCo":
                basicActions.waitForElementToBeClickable(getAssistanceLinkOption.get(0), 20);
                getAssistance.click();
                getAssistanceLinkOption.get(0).click();
                break;
            case "Exch":
                basicActions.waitForElementToBeClickable(getAssistanceLinkOption.get(1), 20);
                getAssistanceLinkOption.get(1).click();
                break;
            case "Login Portal":
                basicActions.waitForElementToBeClickable(getAssistanceLoginPortalOption.get(1), 20);
                getAssistanceLoginPortalOption.get(1).click();
                break;
            case "Exch ExpertHelp":
                basicActions.waitForElementToBeClickable(findExpertAssistanceExpertHelp, 20);
                findExpertAssistanceExpertHelp.click();
                break;
                case "individual dashboard":
                basicActions.waitForElementToBeClickable(findExpertAssistanceIndividualDashboard, 20);
                findExpertAssistanceIndividualDashboard.click();
                break;
            case "ExpertHelp in community":
                basicActions.waitForElementToBeClickable(findExpertAssistanceExpertInCoomunity, 20);
                findExpertAssistanceExpertInCoomunity.click();
                break;
                case "Lugy Page":
                basicActions.waitForElementToBeClickable(findExpertAssistanceLugy, 20);
                    findExpertAssistanceLugy.click();
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
        switch (pageType) {
            case "CoCo":
                basicActions.waitForElementToBeClickable(languageDrp, 90);
                basicActions.waitForElementToBeClickable(userNameLink, 90);
                basicActions.clickElementWithRetries(userNameLink, 20);
                break;
            case "Exch":
                basicActions.waitForElementToBeClickable(languageDrp, 90);
                basicActions.waitForElementToBeClickable(userNameLinkExch, 90);
                basicActions.scrollToElement(userNameLinkExch);
                userNameLinkExch.click();
                break;
            case "Exch NonElmo":
                basicActions.waitForElementToBeClickable(userNameLinkExchNonElmo, 90);
                userNameLinkExchNonElmo.click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }
    }

    public void clickLanguageDrp(String pageType) {
        switch (pageType){
            case "Exch":
                basicActions.waitForElementToBePresentWithRetries(languageDrp, 60);
                languageDrp.click();
                break;
            case "Exch NonElmo":
                basicActions.waitForElementToBePresent(languageDrpNonElmo, 60);
                languageDrpNonElmo.click();
                break;
            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }
    }

    public void headerLanguage(String language){
        basicActions.wait(250);
        basicActions.waitForElementListToBePresentWithRetries(centerHeaderLink, 100);
        basicActions.waitForElementToBePresentWithRetries(languageDrp, 120);
        for (WebElement headerLink : centerHeaderLink) {
            if (headerLink.getAttribute("text").contains("Apply for Coverage")) {
                changeLanguage(language);
                break;
            }
        }
        basicActions.wait(600);
    }

    public void changeLanguage(String language) {
//        "English" and "Spanish" for CoCo and Exch Elmo pages
////        Exch Elmo pages include: Income Opt Out, Employment Income, Employment Summary, Additional income, Deductions, Income Summary, Employer Sponsored Health Insurance (ESI)
//        "English Login" and "Spanish Login" is for the Login page
//        "English ExpertHelp" and "Spanish ExpertHelp" is for the following pages: Create Account, Manage who helps you/Find Expert Help

        basicActions.wait(250);
        switch (language) {
            case "English":
                basicActions.waitForElementToDisappear(spinner,20);
                basicActions.waitForElementToBePresent(languageDrp, 60);
                actions.moveToElement(connectLogoLink).perform();
                languageDrp.click();
                basicActions.waitForElementToBePresent(languageDrpOption.get(0), 60);
                languageDrpOption.get(0).click();
                break;
            case "Spanish":
                basicActions.waitForElementToDisappear(spinner,20);
                basicActions.waitForElementListToBePresentWithRetries(centerHeaderLink, 70);
                basicActions.waitForElementToBePresentWithRetries(learnMoreLink, 70);
                basicActions.waitForElementToBePresentWithRetries(getAssistanceLink, 70);
                basicActions.waitForElementToBePresentWithRetries(languageDrp, 70);
                languageDrp.click();
                basicActions.waitForElementToBePresentWithRetries(languageDrpOption.get(1), 80);
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
                basicActions.waitForElementToBePresent(languageDrpOptionSignInEnglish, 60);
                languageDrpOptionSignInEnglish.click();
                break;
            case "Spanish Login":
                basicActions.waitForElementToBePresent(languageDrpSignIn, 60);
                languageDrpSignIn.click();
                basicActions.waitForElementToBePresent(languageDrpOptionSignInSpanish, 60);
                languageDrpOptionSignInSpanish.click();
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
        basicActions.wait(50);
    }

    public void clickSignOutLink(String pageType) {
        switch (pageType) {
            case "Elmo":
                basicActions.waitForElementToBePresentWithRetries(signOutLink, 30);
                basicActions.waitForElementToBePresentWithRetries(learnMoreLink, 25);
                basicActions.waitForElementToBePresentWithRetries(getAssistanceLink, 25);
                basicActions.waitForElementToBePresentWithRetries(languageDrp, 25);
                basicActions.scrollToElement(signOutLink);
                basicActions.click(signOutLink);
                break;
            case "NonElmo":
                basicActions.waitForElementToBePresentWithRetries(signOutLinkNonElmo, 20);
                basicActions.click(signOutLinkNonElmo);
                break;
            case "WhoHelpsYouPage":
                basicActions.waitForElementToBePresent(signOutLinkWhoHelpsPage, 10);
                basicActions.scrollToElement(signOutLinkWhoHelpsPage);
                basicActions.click(signOutLinkWhoHelpsPage);
                break;
            case "Portal":
                basicActions.waitForElementToBePresent(signOutLinkPortal, 30);
                basicActions.scrollToElement(signOutLinkPortal);
                basicActions.click(signOutLinkPortal);
                break;
            case "MedicalDetail":
                basicActions.waitForElementToDisappear( spinner, 30 );
                basicActions.waitForElementToBePresent(medicalSignoutLink, 30  );
                basicActions.click( medicalSignoutLink );
                break;
            case "DentalPlanResults":
                basicActions.waitForElementToBePresent(signOutDentalPlanResults, 20);
                basicActions.scrollToElement(signOutDentalPlanResults);
                basicActions.click(signOutDentalPlanResults);
                break;
            case "Account Overview":
                basicActions.waitForElementToBePresentWithRetries(signOutOverview,30);
                basicActions.click(signOutOverview);
                break;
            case "CaseId Page":
                basicActions.wait(2000);
                basicActions.waitForElementToBeClickable(signOutinCaseIdPage,10);
                basicActions.click(signOutinCaseIdPage);
                break;
            case "Household Page":
                basicActions.wait(2000);
                basicActions.waitForElementToBePresentWithRetries(signOutHousholdPage,30);
                basicActions.click(signOutHousholdPage);
                break;
            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }
    }

//    public void verifyTextInCoCoHeader() {
//        basicActions.waitForElementToBePresentWithRetries(connectLogoLink, 60);
//        basicActions.waitForElementListToBePresentWithRetries(centerHeaderLink, 60);
//        softAssert.assertEquals(connectLogoLink.getText(), "");
//        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Apply for Coverage");
//        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Find a Plan");
//        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "My Account");
//        softAssert.assertEquals(learnMoreLink.getText(), "Learn More");
//        clickLanguageDrp("Exch");
//        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
//        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
//        softAssert.assertEquals(signOutLink.getText(), "Sign Out");
//        softAssert.assertEquals(getAssistanceLink.getText(), "Get Assistance");
//        actions.moveToElement(getAssistanceLink).perform();
//        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Find Expert Assistance in Your Community");
//        actions.moveToElement(connectLogoLink).perform();
//        softAssert.assertEquals(userNameLink.getText(), SharedData.getPrimaryMember().getEmailId());
//        softAssert.assertEquals(languageDrp.getText(), "");
//        softAssert.assertAll();
//    }
//
//    public void verifyTextInCoCoOBOHeader() {
//        basicActions.waitForElementToBePresent(connectLogoLink, 10);
//        softAssert.assertEquals(connectLogoLink.getText(), "");
//        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Apply for Coverage");
//        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Find a Plan");
//        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "My Account");
//        softAssert.assertEquals(learnMoreLink.getText(), "Learn More");
//        clickLanguageDrp("Exch");
//        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
//        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
//        softAssert.assertEquals(signOutLink.getText(), "Sign Out");
//        softAssert.assertEquals(getAssistanceLink.getText(), "Get Assistance");
//        actions.moveToElement(getAssistanceLink).perform();
//        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Find Expert Assistance in Your Community");
//        actions.moveToElement(connectLogoLink).perform();
//        if (SharedData.getEnv().equals("qa")) {
//            softAssert.assertEquals(userNameLink.getText(), "C4test.aduser123@gmail.com");
//        } else {
//            softAssert.assertEquals(userNameLink.getText(), "C4testaduser123@gmail.com");
//        }
//        softAssert.assertEquals(languageDrp.getText(), "");
//        softAssert.assertAll();
//    }
//
//    public void verifyTextInCoCoHeaderSpanish() {
//        basicActions.waitForElementToBePresent(connectLogoLink, 10);
//        softAssert.assertEquals(connectLogoLink.getText(), "");
//        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Solicitud de cobertura");
//        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Buscar un plan");
//        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "Mi cuenta");
//        softAssert.assertEquals(learnMoreLink.getText(), "M\u00E1s informaci\u00F3n");
//        clickLanguageDrp("Exch");
//        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
//        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
//        softAssert.assertEquals(signOutLink.getText(), "Cerrar sesi\u00F3n");
//        softAssert.assertEquals(getAssistanceLink.getText(), "Obtener asistencia");
//        actions.moveToElement(getAssistanceLink).perform();
//        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Buscar asistencia de expertos en su comunidad");
//        actions.moveToElement(connectLogoLink).perform();
//        softAssert.assertEquals(userNameLink.getText(), SharedData.getPrimaryMember().getEmailId());
//        softAssert.assertEquals(languageDrp.getText(), "");
//        softAssert.assertAll();
//    }
//
//    public void verifyTextInCoCoOBOHeaderSpanish() {
//        basicActions.waitForElementToBePresent(connectLogoLink, 10);
//        softAssert.assertEquals(connectLogoLink.getText(), "");
//        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Solicitud de cobertura");
//        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Buscar un plan");
//        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "Mi cuenta");
//        softAssert.assertEquals(learnMoreLink.getText(), "M\u00E1s informaci\u00F3n");
//        clickLanguageDrp("Exch");
//        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
//        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
//        softAssert.assertEquals(signOutLink.getText(), "Cerrar sesi\u00F3n");
//        softAssert.assertEquals(getAssistanceLink.getText(), "Obtener asistencia");
//        actions.moveToElement(getAssistanceLink).perform();
//        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Buscar asistencia de expertos en su comunidad");
//        actions.moveToElement(connectLogoLink).perform();
//        if (SharedData.getEnv().equals("qa")) {
//            softAssert.assertEquals(userNameLink.getText(), "C4test.aduser123@gmail.com");
//        } else {
//            softAssert.assertEquals(userNameLink.getText(), "C4testaduser123@gmail.com");
//        }
//        softAssert.assertEquals(languageDrp.getText(), "");
//        softAssert.assertAll();
//    }
//
//    public void verifyTextInExchHeader() {
//        basicActions.waitForElementToBePresentWithRetries(connectLogoLink, 90);
//        basicActions.waitForElementListToBePresentWithRetries(centerHeaderLink, 90);
//        basicActions.waitForElementToBePresentWithRetries(learnMoreLink, 90);
//        softAssert.assertEquals(connectLogoLink.getText(), "");
//        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Apply for Coverage");
//        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Find a Plan");
//        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "My Account");
//        softAssert.assertEquals(learnMoreLink.getText(), "Learn More");
//        softAssert.assertEquals(userNameLinkExch.getText(), SharedData.getPrimaryMember().getEmailId());
//        softAssert.assertEquals(languageDrp.getText(), "");
//        clickLanguageDrp("Exch");
//        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
//        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
//        softAssert.assertEquals(signOutLink.getText(), "Sign Out");
//        softAssert.assertEquals(getAssistanceLink.getText(), "Get Assistance");
//        actions.moveToElement(getAssistanceLink).perform();
//        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Contact Us");
//        softAssert.assertEquals(getAssistanceLinkOption.get(1).getText(), "Find Expert Assistance in Your Community");
//        actions.moveToElement(connectLogoLink).perform();
//        softAssert.assertAll();
//    }
//
//    public void verifyTextInExchOBOHeader() {
//        basicActions.waitForElementToBePresent(connectLogoLink, 10);
//        softAssert.assertEquals(connectLogoLink.getText(), "");
//        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Apply for Coverage");
//        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Find a Plan");
//        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "My Account");
//        softAssert.assertEquals(learnMoreLink.getText(), "Learn More");
//        if (SharedData.getEnv().equals("qa")) {
//            softAssert.assertEquals(userNameLinkExch.getText(), "C4test.aduser123@gmail.com");
//        } else {
//            softAssert.assertEquals(userNameLinkExch.getText(), "C4testaduser123@gmail.com");
//        }
//        softAssert.assertEquals(languageDrp.getText(), "");
//        clickLanguageDrp("Exch");
//        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
//        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
//        softAssert.assertEquals(signOutLink.getText(), "Sign Out");
//        softAssert.assertEquals(getAssistanceLink.getText(), "Get Assistance");
//        clickGetAssistanceLink("Exch");
//        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Contact Us");
//        softAssert.assertEquals(getAssistanceLinkOption.get(1).getText(), "Find Expert Assistance in Your Community");
//        softAssert.assertAll();
//    }

    public void verifyTextInExchAnonymousHeader() {
        basicActions.waitForElementToBePresent(connectLogoLink, 10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Apply for Coverage");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Find a Plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "My Account");
        softAssert.assertEquals(learnMoreLink.getText(), "Learn More");
        softAssert.assertFalse(basicActions.waitForElementPresence(userNameLinkExch, 10));
        softAssert.assertEquals(languageDrp.getText(), "");
        clickLanguageDrp("Exch");
        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLink.getText(), "Sign Out");
        softAssert.assertEquals(getAssistanceLink.getText(), "Get Assistance");
        clickGetAssistanceLink("Exch");
        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Contact Us");
        softAssert.assertEquals(getAssistanceLinkOption.get(1).getText(), "Find Expert Assistance in Your Community");
        softAssert.assertAll();
    }

//    public void verifyTextInExchNonElmoHeader() {
//        basicActions.waitForElementToBePresent(connectLogoLinkNonElmo, 50);
//        softAssert.assertEquals(connectLogoLinkNonElmo.getText(), "Connect for Health Colorado");
//        softAssert.assertEquals(centerHeaderLinkNonElmo.get(0).getText(), "Apply for Coverage");
//        softAssert.assertEquals(centerHeaderLinkNonElmo.get(1).getText(), "Find a Plan");
//        softAssert.assertEquals(centerHeaderLinkNonElmo.get(2).getText(), "My Account");
//        softAssert.assertEquals(learnMoreLinkNonElmo.getText(), "Learn More");
//        softAssert.assertEquals(userNameLinkExchNonElmo.getText(), SharedData.getPrimaryMember().getEmailId());
//        softAssert.assertEquals(languageDrpNonElmo.getText(), "Language");
//        clickLanguageDrp("Exch NonElmo");
//        softAssert.assertEquals(languageDrpOptionNonElmo.get(0).getText(), "English");
//        softAssert.assertEquals(languageDrpOptionNonElmo.get(1).getText(), "En espa\u00f1ol");
//        softAssert.assertEquals(signOutLinkNonElmo.getText(), "Sign Out");
//        softAssert.assertEquals(getAssistanceLinkNonElmo.getText(), "Get Assistance");
//        clickGetAssistanceLink("Exch NonElmo");
//        softAssert.assertEquals(getAssistanceLinkOptionNonElmo.getText(), "Contact Us");
//        softAssert.assertEquals(getAssistanceLinkOptionNonElmo1.getText(), "Find Expert Assistance in Your Community");
//        softAssert.assertAll();
//    }

//    public void verifyTextInExchHeaderSpanish() {
//        basicActions.waitForElementToBePresent(connectLogoLink, 10);
//        softAssert.assertEquals(connectLogoLink.getText(), "");
//        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Solicitud de cobertura");
//        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Buscar un plan");
//        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "Mi cuenta");
//        softAssert.assertEquals(learnMoreLink.getText(), "M\u00E1s informaci\u00F3n");
//        softAssert.assertEquals(userNameLinkExch.getText(), SharedData.getPrimaryMember().getEmailId());
//        softAssert.assertEquals(languageDrp.getText(), "");
//        actions.moveToElement(connectLogoLink).perform();
//        clickLanguageDrp("Exch");
//        basicActions.waitForElementListToBePresent(languageDrpOption,15);
//        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
//        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
//        softAssert.assertEquals(signOutLink.getText(), "Cerrar sesi\u00F3n");
//        softAssert.assertEquals(getAssistanceLink.getText(), "Obtener asistencia");
//        actions.moveToElement(getAssistanceLink).perform();
//        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Contacta con nosotros");
//        softAssert.assertEquals(getAssistanceLinkOption.get(1).getText(), "Buscar asistencia de expertos en su comunidad");
//        actions.moveToElement(connectLogoLink).perform();
//        softAssert.assertAll();
//    }

//    public void verifyTextInExchOBOHeaderSpanish() {
//        basicActions.waitForElementToBePresent(connectLogoLink, 10);
//        softAssert.assertEquals(connectLogoLink.getText(), "");
//        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Solicitud de cobertura");
//        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Buscar un plan");
//        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "Mi cuenta");
//        softAssert.assertEquals(learnMoreLink.getText(), "M\u00E1s informaci\u00F3n");
//        if (SharedData.getEnv().equals("qa")) {
//            softAssert.assertEquals(userNameLinkExch.getText(), "C4test.aduser123@gmail.com");
//        } else {
//            softAssert.assertEquals(userNameLinkExch.getText(), "C4testaduser123@gmail.com");
//        }
//        softAssert.assertEquals(languageDrp.getText(), "");
//        clickLanguageDrp("Exch");
//        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
//        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
//        softAssert.assertEquals(signOutLink.getText(), "Cerrar sesi\u00F3n");
//        softAssert.assertEquals(getAssistanceLink.getText(), "Obtener asistencia");
//        clickGetAssistanceLink("Exch");
//        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Contacta con nosotros");
//        softAssert.assertEquals(getAssistanceLinkOption.get(1).getText(), "Buscar asistencia de expertos en su comunidad");
//        softAssert.assertAll();
//    }

    public void verifyTextInExchAnonymousHeaderSpanish() {
        basicActions.waitForElementToBePresent(connectLogoLink, 10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Solicitud de cobertura");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Buscar un plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "Mi cuenta");
        softAssert.assertEquals(learnMoreLink.getText(), "M\u00E1s informaci\u00F3n");
        softAssert.assertFalse(basicActions.waitForElementPresence(userNameLinkExch, 10));
        softAssert.assertEquals(languageDrp.getText(), "");
        clickLanguageDrp("Exch");
        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLink.getText(), "Cerrar sesi\u00F3n");
        softAssert.assertEquals(getAssistanceLink.getText(), "Obtener asistencia");
        clickGetAssistanceLink("Exch");
        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Contacta con nosotros");
        softAssert.assertEquals(getAssistanceLinkOption.get(1).getText(), "Buscar asistencia de expertos en su comunidad");
        softAssert.assertAll();
    }

//    public void verifyTextInExchNonElmoHeaderSpanish() {
//        basicActions.waitForElementToBePresent(connectLogoLinkNonElmo, 10);
//        softAssert.assertEquals(connectLogoLinkNonElmo.getText(), "Connect for Health Colorado");
//        softAssert.assertEquals(centerHeaderLinkNonElmo.get(0).getText(), "Solicitud de cobertura");
//        softAssert.assertEquals(centerHeaderLinkNonElmo.get(1).getText(), "Buscar un plan");
//        softAssert.assertEquals(centerHeaderLinkNonElmo.get(2).getText(), "Mi cuenta");
//        softAssert.assertEquals(learnMoreLinkNonElmo.getText(), "M\u00E1s informaci\u00F3n");
//        softAssert.assertEquals(userNameLinkExchNonElmo.getText(), SharedData.getPrimaryMember().getEmailId());
//        softAssert.assertEquals(languageDrpNonElmo.getText(), "Language");
//        clickLanguageDrp("Exch NonElmo");
//        softAssert.assertEquals(languageDrpOptionNonElmo.get(0).getText(), "English");
//        softAssert.assertEquals(languageDrpOptionNonElmo.get(1).getText(), "En espa\u00f1ol");
//        softAssert.assertEquals(signOutLinkNonElmo.getText(), "Cerrar sesi\u00F3n");
//        softAssert.assertEquals(getAssistanceLinkNonElmo.getText(), "Obtener asistencia");
//        clickGetAssistanceLink("Exch NonElmo");
//        softAssert.assertEquals(getAssistanceLinkOptionNonElmo.getText(), "Cont\u00E1ctenos");
//        softAssert.assertEquals(getAssistanceLinkOptionNonElmo1.getText(), "Buscar asistencia de expertos en su comunidad");
//        softAssert.assertAll();
//    }


    // =========HEADER AND FOOTER============== //
//    public void verifyHeaderFooterText(String appType, String HeaderOrFooter, String language) {
//        switch (appType) {
//            case "Exch":
//                verifyExchHeaderFooterText(HeaderOrFooter, language);
//                break;
//            case "Exch NonElmo":
//                verifyExchNonElmoHeaderFooterText(HeaderOrFooter, language);
//                break;
//            case "CoCo":
//                verifyCoCoHeaderFooterText(HeaderOrFooter, language);
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid option: " + appType);
//        }
//    }

//    public void verifyCoCoHeaderFooterTextEnglish(String HeaderOrFooter) {
//        switch (HeaderOrFooter) {
//            case "Header":
//                verifyTextInCoCoHeader();
//                break;
//            case "Admin portal OBO Header":
//                verifyTextInCoCoOBOHeader();
//                break;
//            case "Footer":
//                verifyTextInCoCoFooter();
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid option: " + HeaderOrFooter);
//        }
//    }

//    public void verifyCoCoHeaderFooterTextSpanish(String HeaderOrFooter) {
//        switch (HeaderOrFooter) {
//            case "Header":
//                verifyTextInCoCoHeaderSpanish();
//                break;
//            case "Admin portal OBO Header":
//                verifyTextInCoCoOBOHeaderSpanish();
//                break;
//            case "Footer":
//                verifyTextInCoCoFooterSpanish();
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid option: " + HeaderOrFooter);
//        }
//    }

//    public void verifyExchHeaderFooterTextEnglish(String HeaderOrFooter) {
//        switch (HeaderOrFooter) {
//            case "Header":
//                verifyTextInExchHeader();
//                break;
//            case "Admin portal OBO Header":
//                verifyTextInExchOBOHeader();
//                break;
//            case "Footer":
//                verifyTextInExchFooter();
//                break;
//            case "Admin portal Footer": //This is Admin portal Footer - displaying for all admin portal pages except admin login page - Admin login page use standard one so didnt add specific one for that.
//                verifyTextAPFooter(); /// this method name used as we are using it specific to admin portal text validation.
//                break;
//            case "Anonymous Find Expert Help":
//                verifyTextInExchAnonymousHeader();
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid option: " + HeaderOrFooter);
//        }
//    }

//    public void verifyExchNonElmoHeaderFooterTextEnglish(String HeaderOrFooter) {
//        switch (HeaderOrFooter) {
//            case "Header":
//                verifyTextInExchNonElmoHeader();
//                break;
//            case "Footer":
//                verifyTextInExchFooter();
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid option: " + HeaderOrFooter);
//        }
//    }

//    public void verifyExchHeaderFooterTextSpanish(String HeaderOrFooter) {
//        switch (HeaderOrFooter) {
//            case "Header":
//                verifyTextInExchHeaderSpanish();
//                break;
//            case "Admin portal OBO Header":
//                verifyTextInExchOBOHeaderSpanish();
//                break;
//            case "Footer":
//                verifyTextInExchFooterSpanish();
//                break;
//            case "Login Footer":
//                verifyTextInLoginPortalFooterSpanish();
//                break;
//            case "Anonymous Find Expert Help":
//                verifyTextInExchAnonymousHeaderSpanish();
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid option: " + HeaderOrFooter);
//        }
//    }

//    public void verifyExchNonElmoHeaderFooterTextSpanish(String HeaderOrFooter) {
//        switch (HeaderOrFooter) {
//            case "Header":
//                verifyTextInExchNonElmoHeaderSpanish();
//                break;
//            case "Footer":
//                verifyTextInExchFooterSpanish();
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid option: " + HeaderOrFooter);
//        }
//    }

//    public void verifyExchHeaderFooterText(String language, String HeaderOrFooter) {
//        switch (language) {
//            case "English":
//                verifyExchHeaderFooterTextEnglish(HeaderOrFooter);
//                break;
//            case "Spanish":
//                verifyExchHeaderFooterTextSpanish(HeaderOrFooter);
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid option: " + language);
//        }
//    }

//    public void verifyExchNonElmoHeaderFooterText(String language, String HeaderOrFooter) {
//        switch (language) {
//            case "English":
//                verifyExchNonElmoHeaderFooterTextEnglish(HeaderOrFooter);
//                break;
//            case "Spanish":
//                verifyExchNonElmoHeaderFooterTextSpanish(HeaderOrFooter);
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid option: " + language);
//        }
//    }

//    public void verifyCoCoHeaderFooterText(String language, String HeaderOrFooter) {
//        switch (language) {
//            case "English":
//                verifyCoCoHeaderFooterTextEnglish(HeaderOrFooter);
//                break;
//            case "Spanish":
//                verifyCoCoHeaderFooterTextSpanish(HeaderOrFooter);
//                break;
//            default:
//                throw new IllegalArgumentException("Invalid option: " + language);
//        }
//    }

    public void verifyUserNameLinkNotPresent(String pageType) {
        switch (pageType) {
            case "CoCo":
                Assert.assertFalse(basicActions.waitForElementToBePresentWithRetries(userNameLink, 30), "User name link is displayed");
                break;
            case "Exch":
                Assert.assertFalse(basicActions.waitForElementToBePresent(userNameLinkExch, 30), "User name link is displayed");
                break;
            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }
    }

    public void verifyUserNameLinkPresent(String pageType) {
        switch (pageType) {
            case "CoCo":
                Assert.assertTrue(basicActions.waitForElementToBePresent(userNameLink, 30), "User name link is NOT displayed");
                break;
            case "Exch":
                Assert.assertTrue(basicActions.waitForElementToBePresent(userNameLinkExch, 30), "User name link is NOT displayed");
                break;
            default:
                throw new IllegalArgumentException("Unsupported page type: " + pageType);
        }
    }


    // =========FOOTER============== //

    public void clickPrivacyPolicyLink(String appType) {
        switch (appType) {
            case "Admin Portal":
                basicActions.waitForElementToBeClickable(APprivacyPolicyLink, 20);
                APprivacyPolicyLink.click();
                break;
            case "Individual Portal":
                basicActions.waitForElementToBeClickableWithRetries(privacyPolicyLink, 70);
                basicActions.waitForElementToBeClickableWithRetries(termsOfUseLink, 70);
                basicActions.waitForElementToBeClickableWithRetries(privacyPolicyLink, 70);
                basicActions.scrollToElement(privacyPolicyLink);
                basicActions.waitForElementPresence(privacyPolicyLink, 70);
                basicActions.waitForElementToBeClickableWithRetries(privacyPolicyLink, 70);
                 privacyPolicyLink.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + appType);
        }
    }

    public void clickTermsOfUseLink(String appType) {
        switch (appType) {
            case "Admin Portal":
                basicActions.waitForElementToBeClickable(APtermsOfUseLink, 20);
                APtermsOfUseLink.click();
                break;
            case "Individual Portal":
                basicActions.waitForElementToBeClickable(termsOfUseLink, 10);
                termsOfUseLink.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + appType);
        }
    }

    public void clickContactUsLink(String appType) {
        switch(appType){
            case "CoCo":
                basicActions.waitForElementToBeClickable(contactUsLink, 10);
                contactUsLink.click();
                break;
            case "Exch":
                basicActions.waitForElementToDisappear(spinner, 90);
                basicActions.waitForElementToBePresent(contactUsLinkExch, 70);
                basicActions.waitForElementToBeClickable(contactUsLinkExch, 60);
                basicActions.scrollToElement(contactUsLinkExch);
                basicActions.waitForElementToBeClickable(contactUsLinkExch,90);
                contactUsLinkExch.click();
                break;
            case "Admin Portal":
                basicActions.waitForElementToBeClickable(APcontactUsLink, 10);
                APcontactUsLink.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + appType);
        }
    }
    public void clickFacebookIcon(String MediaIcon) {
        switch (MediaIcon){
            case "Facebook":
                basicActions.waitForElementToBeClickable(FacebookIcon, 10);
                basicActions.scrollToElement(FacebookIcon);
                basicActions.click(FacebookIcon);
                break;
            case "X":
                basicActions.waitForElementToBeClickable(xIcon, 10);
                basicActions.scrollToElement(xIcon);
                basicActions.click(xIcon);
                break;
            case "YouTube":
                basicActions.waitForElementToBeClickable(YouTubeIcon, 10);
                basicActions.scrollToElement(YouTubeIcon);
                basicActions.click(YouTubeIcon);
                break;
            case "Instagram":
                basicActions.waitForElementToBeClickable(InstagramIcon, 10);
                basicActions.scrollToElement(InstagramIcon);
                basicActions.click(InstagramIcon);
                break;
            case "LinkedIn":
                basicActions.waitForElementToBeClickable(LinkedInIcon, 10);
                basicActions.scrollToElement(LinkedInIcon);
                ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", LinkedInIcon);
                break;
            case "Threads":
                basicActions.waitForElementToBeClickable(ThreadsIcon, 10);
                basicActions.scrollToElement(ThreadsIcon);
                ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", ThreadsIcon);
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
        softAssert.assertEquals(copyRightCoCoText.getText(), "\u00a92025 COLORADO CONNECT. ALL RIGHTS RESERVED.");
        softAssert.assertAll();
    }

    public void verifyTextInCoCoFooterSpanish(){
        basicActions.waitForElementToBePresent(connectLogoLink,10);
        softAssert.assertEquals(privacyPolicyLink.getText(), "Pol\u00EDtica de privacidad");
        softAssert.assertEquals(termsOfUseLink.getText(), "T\u00E9rminos de uso");
        softAssert.assertEquals(contactUsLink.getText(), "P\u00F3ngase en contacto");
        softAssert.assertEquals(copyRightCoCoText.getText(), "\u00a92025 COLORADO CONNECT. Todos los derechos reservados.");
        softAssert.assertAll();
    }

    public void verifyTextInExchFooter(){
        basicActions.waitForElementToBePresent(privacyPolicyLink,10);
        basicActions.waitForElementToBeClickable(privacyPolicyLink,10);
        softAssert.assertEquals(privacyPolicyLink.getText(), "Privacy Policy");
        softAssert.assertEquals(termsOfUseLink.getText(), "Terms of Use");
        softAssert.assertEquals(contactUsLinkExch.getText(), "Contact Us");
        softAssert.assertEquals(copyRightCoCoText.getText(), "\u00a9 2025 Connect for Health Colorado. All Rights Reserved.");
        softAssert.assertTrue(followUsText.getText().contains("Follow"));
        softAssert.assertTrue(followUsText.getText().contains("Us:"));
        softAssert.assertEquals(FacebookIcon.getAttribute("title"), "Facebook");
        softAssert.assertEquals(xIcon.getAttribute("title"), "X");
        softAssert.assertEquals(YouTubeIcon.getAttribute("title"), "Youtube");
        softAssert.assertEquals(InstagramIcon.getAttribute("title"), "Instagram");
        softAssert.assertEquals(LinkedInIcon.getAttribute("title"), "LinkedIn");
        softAssert.assertEquals(ThreadsIcon.getAttribute("title"), "Threads");
        softAssert.assertAll();
    }

    public void verifyTextInExchFooterSpanish(){
        basicActions.waitForElementToBePresent(privacyPolicyLink,10);
        basicActions.waitForElementToBeClickable(privacyPolicyLink,10);
        softAssert.assertEquals(privacyPolicyLink.getText(), "P\u00F3liza de privacidad");
        softAssert.assertEquals(termsOfUseLink.getText(), "T\u00E9rminos y Condiciones");
        softAssert.assertEquals(contactUsLinkExch.getText(), "Comentarios");
        softAssert.assertEquals(copyRightCoCoText.getText(), "\u00a9 2025 Connect for Health Colorado. Todos los derechos reservados.");
        softAssert.assertEquals(followUsText.getText(), "S\u00EDguenos en:");
        softAssert.assertEquals(FacebookIcon.getAttribute("title"), "Facebook");
        softAssert.assertEquals(xIcon.getAttribute("title"), "X");
        softAssert.assertEquals(YouTubeIcon.getAttribute("title"), "Youtube");
        softAssert.assertEquals(InstagramIcon.getAttribute("title"), "Instagram");
        softAssert.assertEquals(LinkedInIcon.getAttribute("title"), "LinkedIn");
        softAssert.assertEquals(ThreadsIcon.getAttribute("title"), "Threads");
        softAssert.assertAll();
    }
    public void verifyTextInLoginPortalFooterSpanish(){
        basicActions.waitForElementToBePresent(privacyPolicyLink,10);
        basicActions.waitForElementToBeClickable(privacyPolicyLink,10);
        softAssert.assertEquals(privacyPolicyLink.getText(), "P\u00F3liza de privacidad");
        softAssert.assertEquals(termsOfUseLink.getText(), "T\u00E9rminos y Condiciones");
        softAssert.assertEquals(contactUsLinkExch.getText(), "Comentarios");
        softAssert.assertEquals(copyRightCoCoText.getText(), "\u00a9 2025 Connect for Health Colorado. Todos los derechos reservados.");
        softAssert.assertEquals(followUsText.getText(), "S\u00EDguenos en:");
        softAssert.assertEquals(FacebookIcon.getAttribute("title"), "Facebook");
        softAssert.assertEquals(xIcon.getAttribute("title"), "X");
        softAssert.assertEquals(YouTubeIcon.getAttribute("title"), "Youtube");
        softAssert.assertEquals(InstagramIcon.getAttribute("title"), "Instagram");
        softAssert.assertEquals(LinkedInIcon.getAttribute("title"), "LinkedIn");
        softAssert.assertEquals(ThreadsIcon.getAttribute("title"), "Threads");
        softAssert.assertAll();
    }


    public void verifyTextAPFooter() {
        basicActions.waitForElementToBePresent(APprivacyPolicyLink, 10);
        softAssert.assertEquals(APprivacyPolicyLink.getText(), "Privacy Policy");
        softAssert.assertEquals(APtermsOfUseLink.getText(), "Terms of Use");
        softAssert.assertEquals(APcontactUsLink.getText(), "Contact Us");
        softAssert.assertEquals(APcopyRightText.getText(), "\u00a9 2025 Connect for Health Colorado. All Rights Reserved.");
        softAssert.assertAll();
    }

    public void clickConnectLogoLinkLinkForNonElmoPages() {
        basicActions.waitForElementToBePresent(connectLogoLinkNonElmo,20);
        connectLogoLinkNonElmo.click();
    }

//    public void validateTextinHeader(String expectedText) {
//        basicActions.waitForElementListToBePresent(centerHeaderLink,20);
//        switch (expectedText) {
//            case "Username":
//                basicActions.waitForElementToBePresent(userNameLinkExch, 100);
//                Assert.assertEquals(userNameLinkExch.getText(), SharedData.getPrimaryMember().getEmailId());
//                break;
//            case "Apply for coverage Spanish":
//                basicActions.waitForElementToBePresent(centerHeaderLink.get(0),20);
//                softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Solicitud de cobertura" , expectedText + " Not Found ");
//                break;
//            case "Find a plan Spanish":
//                 basicActions.waitForElementToBePresent(centerHeaderLink.get(1),20);
//                 softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Buscar un plan" , expectedText + " Not Found ");
//                 break;
//            case "My Account Spanish":
//                basicActions.waitForElementToBePresent(centerHeaderLink.get(2),20);
//                softAssert.assertEquals(centerHeaderLink.get(2).getText(), "Mi cuenta" , expectedText + " Not Found ");
//                break;
//            case "Learn More Spanish":
//                 basicActions.waitForElementToBePresent(learnMoreLink,20);
//                 softAssert.assertEquals(learnMoreLink.getText() , "M\u00E1s informaci\u00F3n" , expectedText + " Not Found ");
//                  break;
//            case "Contact US Spanish":
//                  basicActions.waitForElementToBePresent(getAssistanceLink,20);
//                  actions.moveToElement(getAssistanceLink).perform();
//                  softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Contacta con nosotros");
//                  break;
//            case "Find Expert Assistance Spanish":
//                  basicActions.waitForElementToBePresent(getAssistanceLink,20);
//                  actions.moveToElement(getAssistanceLink).perform();
//                  softAssert.assertEquals(getAssistanceLinkOption.get(1).getText(), "Buscar asistencia de expertos en su comunidad");
//                  break;
//            case "Globe":
//                  basicActions.waitForElementToBePresent(languageDrp,20);
//                  softAssert.assertEquals(languageDrp.getText(), "");
//                  clickLanguageDrp("Exch");
//                  softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
//                  softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
//                  break;
//            case "Privacy Policy Spanish":
//                  basicActions.waitForElementToBePresent(privacyPolicyLink,20);
//                  softAssert.assertEquals(privacyPolicyLink.getText(), "P\u00F3liza de privacidad");
//                  break;
//            case "Terms of Use Spanish":
//                  basicActions.waitForElementToBePresent(termsOfUseLink,20);
//                  softAssert.assertEquals(termsOfUseLink.getText(), "T\u00E9rminos y Condiciones");
//                  break;
//            case "Contact Us Footer Link Spanish":
//                basicActions.waitForElementToBePresent(contactUsLinkExch,20);
//                softAssert.assertEquals(contactUsLinkExch.getText(), "Comentarios");
//                break;
//
//            case "Copy Rights Spanish":
//                  String CurrentYear = String.valueOf(Year.now().getValue());
//                  basicActions.waitForElementToBePresent(copyRightCoCoText,20);
//                  softAssert.assertEquals(copyRightCoCoText.getText(), "\u00a9 "+CurrentYear+" Connect for Health Colorado. Todos los derechos reservados.");
//                 break;
//            case "Follow Us Spanish":
//                    basicActions.waitForElementToBePresent(followUsText,20);
//                    softAssert.assertEquals(followUsText.getText(), "S\u00EDguenos en:");
//                    break;
//            case "Copy Rights":
//                String MyCurrentYear = String.valueOf(Year.now().getValue());
//                basicActions.waitForElementToBePresent(APcopyRightText,20);
//                softAssert.assertEquals(APcopyRightText.getText(), "\u00a9 "+MyCurrentYear+" Connect for Health Colorado. All Rights Reserved.");
//                break;
//                default:
//                    throw new IllegalArgumentException("Text not present: " + expectedText);
//            }
//            softAssert.assertAll();
//    }

    public void verifyFooterlinktextNavigation(String language, DataTable dataTable) {
        basicActions.waitForElementToDisappear(spinner, 200);
        basicActions.waitForElementToBePresent(privacyPolicyLink,200);
        List<Map<String, String>> data = dataTable.asMaps();
        for (Map<String, String> row : data) {
            String hyperlinkText = row.get("HyperLinkText");
            String expectedPageTitle = row.get("ExpectedPageTitle");
            String containsUrl = row.get("ContainsUrl");
            WebElement hyperlink;
            switch (hyperlinkText.toLowerCase()) {
                case "facebookicon":
                    hyperlink = FacebookIcon;
                    break;
                case "xicon":
                    hyperlink = xIcon;
                    break;
                case "youtubeicon":
                    hyperlink = YouTubeIcon;
                    break;
                case "linkedinicon":
                    hyperlink = LinkedInIcon;
                    break;
                case "instagramicon":
                    hyperlink = InstagramIcon;
                    System.out.println(basicActions.getDriver().getTitle());
                    break;
                case "threadsicon":
                    hyperlink = ThreadsIcon;
                    break;
                default:
                    hyperlink = basicActions.getDriver().findElement(By.partialLinkText(hyperlinkText));
                    break;
            }
            Actions actionKey = new Actions(basicActions.getDriver());
            basicActions.wait(200);
            actionKey.keyDown(Keys.CONTROL).click(hyperlink).keyUp(Keys.CONTROL).build().perform();
            basicActions.switchtoactiveTab();
            basicActions.wait(250);
            basicActions.waitForElementToDisappear(spinner, 400);
            String actualTitle = basicActions.getDriver().getTitle();
            String currentUrl = basicActions.getDriver().getCurrentUrl();
            softAssert.assertTrue(actualTitle.contains(expectedPageTitle),"Expected title is not present for "+expectedPageTitle+", shows title "+actualTitle);
            softAssert.assertTrue(currentUrl.contains(containsUrl),"Does not contain URL "+containsUrl+", shows URL "+currentUrl);
            softAssert.assertAll();
            basicActions.getDriver().close();
            basicActions.switchtoPreviousTab();
        }
        softAssert.assertAll();
    }


    public void verifyCopyRightsText() {
        String MyCurrentYear = String.valueOf(Year.now().getValue());
        basicActions.waitForElementToBePresent(APcopyRightText,20);
        softAssert.assertEquals(APcopyRightText.getText(), "\u00a9 "+MyCurrentYear+" Connect for Health Colorado. All Rights Reserved.");
    }
}
