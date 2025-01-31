package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class HeaderAndFooterPage {
    SoftAssert softAssert = new SoftAssert();
    Actions actions = new Actions(WebDriverManager.getDriver());

    @FindBy(id = "logo-image")
    WebElement connectLogoLink;

    @FindBy(xpath = "//a[@class='logo']")
    WebElement connectLogoNonElmo;

    @FindBy(css = ".logo")
    WebElement connectLogoLinkNonElmo;
    @FindBy(css = "#logo")
    WebElement connectLogoLinkExpertHelp;

    @FindBy(css = ".center-links .clickable")
    List<WebElement> centerHeaderLink;

    @FindBy (xpath = "//*[@class = 'strong vertical-ruler-left']")
    WebElement FindAPlan;

    @FindBy(css = "div.top-navigation > div > nav > ul > li > a")
    List<WebElement> centerHeaderLinkNonElmo;

    @FindBy(css = "#navMenu > div > a")
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

    @FindBy(xpath = "//a[normalize-space()='Find Expert Assistance in Your Community']")
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

    @FindBy(xpath = "//a[.='Sign Out']")
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

    @FindBy(id = "nesHeader-signOut-link") // this is for "Who helps you Page" Sign out only.
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

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

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
                basicActions.waitForElementToBeClickable(connectLogoLink, 10);
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
                basicActions.waitForElementListToBePresentWithRetries(centerHeaderLinkExpertHelp, 15);
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
            basicActions.waitForElementListToBePresent(centerHeaderLink, 15);
            basicActions.waitForElementToBePresent(connectLogoLink, 15);
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
        basicActions.waitForElementToBeClickableWithRetries(learnMoreLink, 15);
        learnMoreLink.click();
    }

    public void clickGetAssistanceLink(String pageType) {
        switch (pageType){
            case "Exch":
                basicActions.waitForElementToBeClickable(getAssistanceLink, 15);
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
        basicActions.waitForElementListToBePresentWithRetries(centerHeaderLink, 100);
        basicActions.waitForElementToBePresentWithRetries(languageDrp, 100);
        basicActions.waitForElementToBeClickableWithRetries(languageDrp, 100);
        for (WebElement headerLink : centerHeaderLink) {
            if (headerLink.getAttribute("text").contains("Apply for Coverage")) {
                changeLanguage(language);
                break;
            }
        }
    }

    public void changeLanguage(String language) {
//        "English" and "Spanish" for CoCo and Exch Elmo pages
////        Exch Elmo pages include: Income Opt Out, Employment Income, Employment Summary, Additional income, Deductions, Income Summary, Employer Sponsored Health Insurance (ESI)
//        "English Login" and "Spanish Login" is for the Login page
//        "English ExpertHelp" and "Spanish ExpertHelp" is for the following pages: Create Account, Manage who helps you/Find Expert Help

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
    }

    public void clickSignOutLink(String pageType) {
        switch (pageType) {
            case "Elmo":
                basicActions.waitForElementToBePresent(signOutLink, 30);
                basicActions.waitForElementToBePresent(learnMoreLink, 25);
                basicActions.waitForElementToBePresent(getAssistanceLink, 25);
                basicActions.waitForElementToBePresent(languageDrp, 25);
                basicActions.scrollToElement(signOutLink);
                basicActions.click(signOutLink);
                break;
            case "NonElmo":
                basicActions.waitForElementToBePresent(signOutLinkNonElmo, 10);
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
                basicActions.waitForElementToBeClickable(signOutOverview,10);
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

    public void verifyTextInCoCoHeader() {
        basicActions.waitForElementToBePresent(connectLogoLink, 10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Apply for Coverage");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Find a Plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "My Account");
        softAssert.assertEquals(learnMoreLink.getText(), "Learn More");
        clickLanguageDrp("Exch");
        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLink.getText(), "Sign Out");
        softAssert.assertEquals(getAssistanceLink.getText(), "Get Assistance");
        actions.moveToElement(getAssistanceLink).perform();
        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Find Expert Assistance in Your Community");
        actions.moveToElement(connectLogoLink).perform();
        softAssert.assertEquals(userNameLink.getText(), SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(languageDrp.getText(), "");
        softAssert.assertAll();
    }

    public void verifyTextInCoCoHeaderSpanish() {
        basicActions.waitForElementToBePresent(connectLogoLink, 10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Solicitud de cobertura");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Buscar un plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "Mi cuenta");
        softAssert.assertEquals(learnMoreLink.getText(), "M\u00E1s informaci\u00F3n");
        clickLanguageDrp("Exch");
        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLink.getText(), "Cerrar sesi\u00F3n");
        softAssert.assertEquals(getAssistanceLink.getText(), "Obtener asistencia");
        actions.moveToElement(getAssistanceLink).perform();
        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Buscar asistencia de expertos en su comunidad");
        actions.moveToElement(connectLogoLink).perform();
        softAssert.assertEquals(userNameLink.getText(), SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(languageDrp.getText(), "");
        softAssert.assertAll();
    }

    public void verifyTextInExchHeader() {
        basicActions.waitForElementToBePresent(connectLogoLink, 10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Apply for Coverage");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Find a Plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "My Account");
        softAssert.assertEquals(learnMoreLink.getText(), "Learn More");
        softAssert.assertEquals(userNameLinkExch.getText(), SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(languageDrp.getText(), "");
        clickLanguageDrp("Exch");
        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLink.getText(), "Sign Out");
        softAssert.assertEquals(getAssistanceLink.getText(), "Get Assistance");
        actions.moveToElement(getAssistanceLink).perform();
        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Contact Us");
        softAssert.assertEquals(getAssistanceLinkOption.get(1).getText(), "Find Expert Assistance in Your Community");
        actions.moveToElement(connectLogoLink).perform();
        softAssert.assertAll();
    }

    public void verifyTextInExchOBOHeader() {
        basicActions.waitForElementToBePresent(connectLogoLink, 10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Apply for Coverage");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Find a Plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "My Account");
        softAssert.assertEquals(learnMoreLink.getText(), "Learn More");
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertEquals(userNameLinkExch.getText(), "C4test.aduser123@gmail.com");
        } else {
            softAssert.assertEquals(userNameLinkExch.getText(), "C4testaduser123@gmail.com");
        }
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

    public void verifyTextInExchNonElmoHeader() {
        basicActions.waitForElementToBePresent(connectLogoLinkNonElmo, 50);
        softAssert.assertEquals(connectLogoLinkNonElmo.getText(), "Connect for Health Colorado");
        softAssert.assertEquals(centerHeaderLinkNonElmo.get(0).getText(), "Apply for Coverage");
        softAssert.assertEquals(centerHeaderLinkNonElmo.get(1).getText(), "Find a Plan");
        softAssert.assertEquals(centerHeaderLinkNonElmo.get(2).getText(), "My Account");
        softAssert.assertEquals(learnMoreLinkNonElmo.getText(), "Learn More");
        softAssert.assertEquals(userNameLinkExchNonElmo.getText(), SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(languageDrpNonElmo.getText(), "Language");
        clickLanguageDrp("Exch NonElmo");
        softAssert.assertEquals(languageDrpOptionNonElmo.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOptionNonElmo.get(1).getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLinkNonElmo.getText(), "Sign Out");
        softAssert.assertEquals(getAssistanceLinkNonElmo.getText(), "Get Assistance");
        clickGetAssistanceLink("Exch NonElmo");
        softAssert.assertEquals(getAssistanceLinkOptionNonElmo.getText(), "Contact Us");
        softAssert.assertEquals(getAssistanceLinkOptionNonElmo1.getText(), "Find Expert Assistance in Your Community");
        softAssert.assertAll();
    }

    public void verifyTextInExchHeaderSpanish() {
        basicActions.waitForElementToBePresent(connectLogoLink, 10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Solicitud de cobertura");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Buscar un plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "Mi cuenta");
        softAssert.assertEquals(learnMoreLink.getText(), "M\u00E1s informaci\u00F3n");
        softAssert.assertEquals(userNameLinkExch.getText(), SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(languageDrp.getText(), "");
        clickLanguageDrp("Exch");
        softAssert.assertEquals(languageDrpOption.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOption.get(1).getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLink.getText(), "Cerrar sesi\u00F3n");
        softAssert.assertEquals(getAssistanceLink.getText(), "Obtener asistencia");
        actions.moveToElement(getAssistanceLink).perform();
        softAssert.assertEquals(getAssistanceLinkOption.get(0).getText(), "Contacta con nosotros");
        softAssert.assertEquals(getAssistanceLinkOption.get(1).getText(), "Buscar asistencia de expertos en su comunidad");
        actions.moveToElement(connectLogoLink).perform();
        softAssert.assertAll();
    }

    public void verifyTextInExchOBOHeaderSpanish() {
        basicActions.waitForElementToBePresent(connectLogoLink, 10);
        softAssert.assertEquals(connectLogoLink.getText(), "");
        softAssert.assertEquals(centerHeaderLink.get(0).getText(), "Solicitud de cobertura");
        softAssert.assertEquals(centerHeaderLink.get(1).getText(), "Buscar un plan");
        softAssert.assertEquals(centerHeaderLink.get(2).getText(), "Mi cuenta");
        softAssert.assertEquals(learnMoreLink.getText(), "M\u00E1s informaci\u00F3n");
        if (SharedData.getEnv().equals("qa")) {
            softAssert.assertEquals(userNameLinkExch.getText(), "C4test.aduser123@gmail.com");
        } else {
            softAssert.assertEquals(userNameLinkExch.getText(), "C4testaduser123@gmail.com");
        }
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

    public void verifyTextInExchNonElmoHeaderSpanish() {
        basicActions.waitForElementToBePresent(connectLogoLinkNonElmo, 10);
        softAssert.assertEquals(connectLogoLinkNonElmo.getText(), "Connect for Health Colorado");
        softAssert.assertEquals(centerHeaderLinkNonElmo.get(0).getText(), "Solicitud de cobertura");
        softAssert.assertEquals(centerHeaderLinkNonElmo.get(1).getText(), "Buscar un plan");
        softAssert.assertEquals(centerHeaderLinkNonElmo.get(2).getText(), "Mi cuenta");
        softAssert.assertEquals(learnMoreLinkNonElmo.getText(), "M\u00E1s informaci\u00F3n");
        softAssert.assertEquals(userNameLinkExchNonElmo.getText(), SharedData.getPrimaryMember().getEmailId());
        softAssert.assertEquals(languageDrpNonElmo.getText(), "Language");
        clickLanguageDrp("Exch NonElmo");
        softAssert.assertEquals(languageDrpOptionNonElmo.get(0).getText(), "English");
        softAssert.assertEquals(languageDrpOptionNonElmo.get(1).getText(), "En espa\u00f1ol");
        softAssert.assertEquals(signOutLinkNonElmo.getText(), "Cerrar sesi\u00F3n");
        softAssert.assertEquals(getAssistanceLinkNonElmo.getText(), "Obtener asistencia");
        clickGetAssistanceLink("Exch NonElmo");
        softAssert.assertEquals(getAssistanceLinkOptionNonElmo.getText(), "Cont\u00E1ctenos");
        softAssert.assertEquals(getAssistanceLinkOptionNonElmo1.getText(), "Buscar asistencia de expertos en su comunidad");
        softAssert.assertAll();
    }


    // =========HEADER AND FOOTER============== //
    public void verifyHeaderFooterText(String appType, String HeaderOrFooter, String language) {
        switch (appType) {
            case "Exch":
                verifyExchHeaderFooterText(HeaderOrFooter, language);
                break;
            case "Exch NonElmo":
                verifyExchNonElmoHeaderFooterText(HeaderOrFooter, language);
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

    public void verifyExchHeaderFooterTextEnglish(String HeaderOrFooter) {
        switch (HeaderOrFooter) {
            case "Header":
                verifyTextInExchHeader();
                break;
            case "Admin portal OBO Header":
                verifyTextInExchOBOHeader();
                break;
            case "Footer":
                verifyTextInExchFooter();
                break;
            case "Admin portal Footer": //This is Admin portal Footer - displaying for all admin portal pages except admin login page - Admin login page use standard one so didnt add specific one for that.
                verifyTextAPFooter(); /// this method name used as we are using it specific to admin portal text validation.
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + HeaderOrFooter);
        }
    }

    public void verifyExchNonElmoHeaderFooterTextEnglish(String HeaderOrFooter) {
        switch (HeaderOrFooter) {
            case "Header":
                verifyTextInExchNonElmoHeader();
                break;
            case "Footer":
                verifyTextInExchFooter();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + HeaderOrFooter);
        }
    }

    public void verifyExchHeaderFooterTextSpanish(String HeaderOrFooter) {
        switch (HeaderOrFooter) {
            case "Header":
                verifyTextInExchHeaderSpanish();
                break;
            case "Admin portal OBO Header":
                verifyTextInExchOBOHeaderSpanish();
                break;
            case "Footer":
                verifyTextInExchFooterSpanish();
                break;
            case "Login Footer":
                verifyTextInLoginPortalFooterSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + HeaderOrFooter);
        }
    }

    public void verifyExchNonElmoHeaderFooterTextSpanish(String HeaderOrFooter) {
        switch (HeaderOrFooter) {
            case "Header":
                verifyTextInExchNonElmoHeaderSpanish();
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

    public void verifyExchNonElmoHeaderFooterText(String language, String HeaderOrFooter) {
        switch (language) {
            case "English":
                verifyExchNonElmoHeaderFooterTextEnglish(HeaderOrFooter);
                break;
            case "Spanish":
                verifyExchNonElmoHeaderFooterTextSpanish(HeaderOrFooter);
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
                basicActions.waitForElementToBeClickable(contactUsLinkExch, 10);
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
                FacebookIcon.click();
                break;
            case "X":
                basicActions.waitForElementToBeClickable(xIcon, 10);
                basicActions.scrollToElement(xIcon);
                xIcon.click();
                break;
            case "YouTube":
                basicActions.waitForElementToBeClickable(YouTubeIcon, 10);
                basicActions.scrollToElement(YouTubeIcon);
                YouTubeIcon.click();
                break;
            case "Instagram":
                basicActions.waitForElementToBeClickable(InstagramIcon, 10);
                basicActions.scrollToElement(InstagramIcon);
                InstagramIcon.click();
                break;
            case "LinkedIn":
                basicActions.waitForElementToBeClickable(LinkedInIcon, 10);
                basicActions.scrollToElement(LinkedInIcon);
                LinkedInIcon.click();
                break;
            case "Threads":
                basicActions.waitForElementToBeClickable(ThreadsIcon, 10);
                basicActions.scrollToElement(ThreadsIcon);
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
}
