package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HeaderAndFooter {
    @FindBy(id = "logo-image")
    private WebElement connectLogoLink;
    @FindBy(xpath = "//*[text()=' Apply for Coverage']")
    private WebElement applyForCoverageLink;
    @FindBy(xpath = "//*[text()='Find a Plan']")
    private WebElement findAPlanLink;
    @FindBy(xpath = "//*[text()='My Account']")
    private WebElement myAccountLink;
    @FindBy(xpath = "//*[text()=' Learn More']")
    private WebElement learnMoreLink;
    @FindBy(xpath = "//*[text()='Get Assistance']")
    private WebElement getAssistanceLink;
    @FindBy(xpath = "//*[text()=' Find Expert Assistance in Your Community ']")
    private WebElement findExpertAssistanceLink;

    @FindBy(id = "privacyPolicyLink")
    private WebElement privacyPolicyLink;
    @FindBy(id = "termsOfUseLink")
    private WebElement termsOfUseLink;
    @FindBy(id = "contactUsLink")
    private WebElement contactUsLink;


    private BasicActions basicActions;
    private Utils utils = new Utils();

    public HeaderAndFooter() {
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

}
