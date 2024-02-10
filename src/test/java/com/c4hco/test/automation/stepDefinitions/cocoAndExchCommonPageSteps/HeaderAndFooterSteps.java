package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoPages.HeaderAndFooterPage;
import io.cucumber.java.en.And;

public class HeaderAndFooterSteps {

    HeaderAndFooterPage headerAndFooterPage = new HeaderAndFooterPage();

    @And("I click on the Colorado Connect or C4 Logo in the Header")
    public void iClickConnectLogoLink(){ headerAndFooterPage.clickConnectLogoLink(); }

    @And("I click on Apply for Coverage in the Header")
    public void iClickApplyForCoverageLink(){ headerAndFooterPage.clickApplyForCoverageLink(); }

    @And("I click on Find a Plan in the Header")
    public void iClickFindAPlanLinkLink(){ headerAndFooterPage.clickFindAPlanLinkLink(); }

    @And("I click on My Account in the Header")
    public void iClickMyAccountLink(){ headerAndFooterPage.clickMyAccountLink(); }

    @And("I click on Learn More in the Header")
    public void iClickLearnMoreLink(){ headerAndFooterPage.clickLearnMoreLink(); }

    @And("I click on Get Assistance in the Header")
    public void iClickGetAssistanceLink(){ headerAndFooterPage.clickGetAssistanceLink(); }

    @And("I click on Find Expert Assistance in the Header")
    public void iClickFindExpertAssistanceLink(){ headerAndFooterPage.clickFindExpertAssistanceLink(); }

    @And("I click on the Username in the Header")
    public void iClickUserNameLink(){ headerAndFooterPage.clickUserNameLink(); }

    @And("I click on Sign Out in the Header")
    public void iClickSignOutLink(){ headerAndFooterPage.clickSignOutLink(); }

    @And("I change the language from header to {string}")
    public void iChangeLanguage(String language){ headerAndFooterPage.changeLanguage(language);}

        // =========FOOTER============== //
    @And("I click on Privacy Policy in the Footer")
    public void iClickPrivacyPolicyLink(){ headerAndFooterPage.clickPrivacyPolicyLink(); }

    @And("I click on Terms Of Use in the Footer")
    public void iClickTermsOfUseLink(){ headerAndFooterPage.clickTermsOfUseLink(); }

    @And("I click on Contact Us in the Footer")
    public void iClickContactUsLink(){ headerAndFooterPage.clickContactUsLink(); }


}
