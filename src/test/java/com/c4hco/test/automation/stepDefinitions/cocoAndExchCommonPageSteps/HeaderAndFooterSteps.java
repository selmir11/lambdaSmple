package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.HeaderAndFooterPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.And;

public class HeaderAndFooterSteps {

    HeaderAndFooterPage headerAndFooterPage = new HeaderAndFooterPage(WebDriverManager.getDriver());

    @And("I click on the Colorado Connect or C4 Logo in the {string} Header")
    public void iClickConnectLogoLink(String pageType){ headerAndFooterPage.clickConnectLogoLink(pageType); }

    @And("I click on Apply for Coverage in the {string} Header")
    public void iClickApplyForCoverageLink(String pageType){ headerAndFooterPage.clickApplyForCoverageLink(pageType); }

    @And("I click on Find a Plan in the {string} Header")
    public void iClickFindAPlanLinkLink(String pageType){ headerAndFooterPage.clickFindAPlanLinkLink(pageType); }

    @And("I click on My Account in the {string} Header")
    public void iClickMyAccountLink(String pageType){ headerAndFooterPage.clickMyAccountLink(pageType); }

    @And("I click on Learn More in the Header")
    public void iClickLearnMoreLink(){ headerAndFooterPage.clickLearnMoreLink(); }

    @And("I click on Get Assistance in the {string} Header")
    public void iClickGetAssistanceLink(String pageType){ headerAndFooterPage.clickGetAssistanceLink(pageType); }

    @And("I click on Find Expert Assistance in the {string} Header")
    public void iClickFindExpertAssistanceLink(String pageType){ headerAndFooterPage.clickFindExpertAssistanceLink(pageType); }

    @And("I click on Contact Us in the Header")
    public void iClickContactUsHeaderLink(){ headerAndFooterPage.clickContactUsHeaderLink(); }

    @And("I click on the Username in the {string} Header")
    public void iClickUserNameLink(String pageType){ headerAndFooterPage.clickUserNameLink(pageType); }

    @And("I click on Sign Out in the Header for {string}")
    public void iClickSignOutLink(String pageType){ headerAndFooterPage.clickSignOutLink(pageType); }

    @And("I change the language from header to {string}")
    public void iChangeLanguage(String language){ headerAndFooterPage.changeLanguage(language);}

    @And("I change the language from Elmo header to {string} if it isn't already in that language")
    public void verifyHeaderLanguage(String language){ headerAndFooterPage.headerLanguage(language);}


    // =========HEADER AND FOOTER============== //
    @And("I verify text on the {string} {string} in {string}")
    public void verifyExchHeaderText(String appType, String HeaderOrFooter, String language) {headerAndFooterPage.verifyHeaderFooterText(appType,language, HeaderOrFooter);}

    @And("I verify User name Link is displayed in the {string} Header")
    public void verifyUserNameLinkPresent(String pageType){ headerAndFooterPage.verifyUserNameLinkPresent(pageType); }

    @And("I verify User name Link is not displayed in the {string} Header")
    public void verifyUserNameLinkNotPresent(String pageType){ headerAndFooterPage.verifyUserNameLinkNotPresent(pageType); }

        // =========FOOTER============== //
    @And("I click on Privacy Policy in the {string} Footer")
    public void PortaliClickPrivacyPolicyLink(String appType){ headerAndFooterPage.clickPrivacyPolicyLink(appType); }

    @And("I click on Terms Of Use in the {string} Footer")
    public void iClickTermsOfUseLink(String appType){ headerAndFooterPage.clickTermsOfUseLink(appType); }

    @And("I click on Contact Us in the {string} Footer")
    public void iClickContactUsLink(String appType){ headerAndFooterPage.clickContactUsLink(appType); }

    @And("I click on {string} Icon in the Footer")
    public void iClickFacebookIcon(String MediaIcon){ headerAndFooterPage.clickFacebookIcon(MediaIcon); }


}
