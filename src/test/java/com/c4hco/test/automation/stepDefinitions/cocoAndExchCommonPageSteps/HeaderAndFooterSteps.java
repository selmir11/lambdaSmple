package com.c4hco.test.automation.stepDefinitions.cocoAndExchCommonPageSteps;

import com.c4hco.test.automation.pages.cocoPages.HeaderAndFooter;
import io.cucumber.java.en.And;

public class HeaderAndFooterSteps {

    HeaderAndFooter headerAndFooter = new HeaderAndFooter();

    @And("I click on the Colorado Connect or C4 Logo in the Header")
    public void iClickConnectLogoLink(){ headerAndFooter.clickConnectLogoLink(); }
    @And("I click on Apply for Coverage in the Header")
    public void iClickApplyForCoverageLink(){ headerAndFooter.clickApplyForCoverageLink(); }
    @And("I click on Find a Plan in the Header")
    public void iClickFindAPlanLinkLink(){ headerAndFooter.clickFindAPlanLinkLink(); }
    @And("I click on My Account in the Header")
    public void iClickMyAccountLink(){ headerAndFooter.clickMyAccountLink(); }
    @And("I click on Learn More in the Header")
    public void iClickLearnMoreLink(){ headerAndFooter.clickLearnMoreLink(); }
    @And("I click on Get Assistance in the Header")
    public void iClickGetAssistanceLink(){ headerAndFooter.clickGetAssistanceLink(); }
    @And("I click on Find Expert Assistance in the Header")
    public void iClickFindExpertAssistanceLink(){ headerAndFooter.clickFindExpertAssistanceLink(); }



    @And("I click on Privacy Policy in the Footer")
    public void iClickPrivacyPolicyLink(){ headerAndFooter.clickPrivacyPolicyLink(); }
    @And("I click on Terms Of Use in the Footer")
    public void iClickTermsOfUseLink(){ headerAndFooter.clickTermsOfUseLink(); }
    @And("I click on Contact Us in the Footer")
    public void iClickContactUsLink(){ headerAndFooter.clickContactUsLink(); }



}
