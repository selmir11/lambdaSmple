package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FindExpertHelpPage {
    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    @FindBy(id = "contineOwn-button")
    WebElement continueOnMyOwnButton;
    @FindBy(id = "BP-Findexperthelpnearyou-Back")
    WebElement backButton;
    @FindBy(id ="experthelp-title")
    WebElement pageHeader;

    @FindBy(id ="experthelp-manage")
    WebElement pageHeaderManageWhoHelps;

    @FindBy(id ="experthelp-text")
    WebElement pageTitle;
    @FindBy(id ="broker-title")
    WebElement helpFromBroker;

    @FindBy(id ="broker-text")
    WebElement helpFromBrokerText;
    @FindBy(id ="broker-button")
    WebElement FindBroker;

    @FindBy(id ="broker-callyou-button")
    WebElement HaveBrokerCallYou;

    @FindBy(id ="assister-button")
    WebElement FindAnAssister;

    @FindBy(id ="authorize-assister-button")
    WebElement AuthorizeAssisterOrganization;

    @FindBy(id ="broker-button")
    WebElement findBroker;

    @FindBy(id ="broker-button-change")
    WebElement ChangeBroker;

    @FindBy(id ="broker-existing-title")
    WebElement brokerExistsText;

    @FindBy(id ="broker-table-brokerName")
    WebElement brokerNameColumnHeader;

    @FindBy(id ="broker-table-agencyName")
    WebElement agencyNameColumnHeader;

    @FindBy(id ="broker-table-license")
    WebElement licenseNumberColumnHeader;

    @FindBy(id ="broker-table-zipCode")
    WebElement zipCodeColumnHeader;

    @FindBy(id ="broker-table-phone")
    WebElement phoneNumberColumnHeader;

    @FindBy(id ="broker-table-type")
    WebElement typeColumnHeader;

    @FindBy(id ="broker-table-status")
    WebElement statusColumnHeader;

    @FindBy(id ="broker-table-action")
    WebElement actionColumnHeader;

    @FindBy(id ="broker-organizationName")
    WebElement currentBrokerName;

    @FindBy(id ="broker-exchangeId")
    WebElement currentAgencyName;

    @FindBy(id ="broker-license")
    WebElement currentBrokerLicense;

    @FindBy(id ="broker-zipCode")
    WebElement currentBrokerZipCode;

    @FindBy(id ="broker-phoneNumber")
    WebElement currentBrokerPhone;

    @FindBy(id ="broker-helperType")
    WebElement currentBrokerType;

    @FindBy(id ="broker-status")
    WebElement currentBrokerStatus;

    @FindBy(id ="broker-action")
    WebElement currentBrokerAction;

    public FindExpertHelpPage(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void verifyHeaderPage(String language){
        String ExpectedTitle = "";
        basicActions.waitForElementToBePresent(pageHeader,20);
        String ActualTitle =pageHeader.getText();

        switch (language) {
            case "English":
                ExpectedTitle = "Find expert help near you";
                break;
            case "Spanish":
                ExpectedTitle = "Encuentre un experto cerca de usted";
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        Assert.assertEquals(ExpectedTitle,ActualTitle);
    }

    public void verifyManageWhoHelpsYouHeaderText(String language){
        String ExpectedTitle = "";
        basicActions.waitForElementToBePresent(pageHeaderManageWhoHelps,20);
        String ActualTitle =pageHeaderManageWhoHelps.getText();

        switch (language) {
            case "English":
                ExpectedTitle = "Manage who helps you";
                break;
            case "Spanish":
                ExpectedTitle = "administrar qui\u00E9n te ayuda";
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        Assert.assertEquals(ExpectedTitle,ActualTitle);
    }

    public void verifyTitlePage(String Marketplace, String language){
        String ExpectedTitle = "";
        String ActualTitle =pageTitle.getText();
        String market = "";

        switch (Marketplace) {
            case "Exch":
                market = "Connect for Health Colorado";
                break;
            case "CoCo":
                market = "Colorado Connect";
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }

        switch (language) {
            case "English":
                ExpectedTitle = market +" offers a statewide network of certified experts who can help you complete your application and shop for a plan in person.";
                break;
            case "Spanish":
                ExpectedTitle = market +" ofrece una red estatal de expertos certificados que le pueden ayudar a completar su solicitud y buscar un plan en persona.";
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        Assert.assertEquals(ExpectedTitle,ActualTitle);
    }

    public void verifyPageText(String language){
        switch (language) {
            case "English":
                softAssert.assertEquals(helpFromBroker.getText(),"Help from a Broker");
                softAssert.assertEquals(helpFromBrokerText.getText(),"Our brokers are licensed to help you evaluate health insurance benefits and coverage, recommend a plan based on your specific needs and enroll you in that plan. They can also help you apply for financial help.");
                break;
            case "Spanish":
                softAssert.assertEquals(helpFromBroker.getText(),"Ayuda de un Agente");
                softAssert.assertEquals(helpFromBrokerText.getText(),"Nuestros Agentes están autorizados para ayudarle a evaluar beneficios y cobertura de seguro de salud, recomendar un plan acorde a sus necesidades específicas e inscribirlo en ese plan. Pueden también ayudarle a solicitar ayuda financiera.");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyButtontext(String language){
        switch (language) {
            case "English":
                softAssert.assertEquals(FindBroker.getText(),"Find a Broker");
                softAssert.assertEquals(HaveBrokerCallYou.getText(),"Have a Broker call you");
                softAssert.assertEquals(FindAnAssister.getText(),"Find an Assister");
                softAssert.assertEquals(AuthorizeAssisterOrganization.getText(),"Authorize Assister Organization");
                break;
            case "Spanish":
                softAssert.assertEquals(FindBroker.getText(),"Busque un agente");
                softAssert.assertEquals(HaveBrokerCallYou.getText(),"Solicitar llamada de un agente");
                softAssert.assertEquals(FindAnAssister.getText(),"Busque un Asistente");
                softAssert.assertEquals(AuthorizeAssisterOrganization.getText(),"Autorizar organización asistente");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void clickFindBroker() {
        basicActions.waitForElementToBePresent(findBroker,10);
        findBroker.click();
    }

    public void validateBrokerExists(){
        basicActions.waitForElementToBePresent(brokerExistsText,100);
        softAssert.assertEquals(brokerExistsText.getText(),"This is your current Broker");
        softAssert.assertAll();
    }

    public void validateCurrentBrokerTableHeader(){
        basicActions.waitForElementToBePresent(brokerNameColumnHeader,100);
        softAssert.assertEquals(brokerNameColumnHeader.getText(),"Broker Name");
        softAssert.assertEquals(agencyNameColumnHeader.getText(),"Agency Name");
        softAssert.assertEquals(licenseNumberColumnHeader.getText(),"License Number");
        softAssert.assertEquals(zipCodeColumnHeader.getText(),"Zip Code");
        softAssert.assertEquals(phoneNumberColumnHeader.getText(),"Phone Number");
        softAssert.assertEquals(typeColumnHeader.getText(),"Type");
        softAssert.assertEquals(statusColumnHeader.getText(),"Status");
        softAssert.assertEquals(actionColumnHeader.getText(),"Action");
        softAssert.assertAll();
    }

    public void validateBrokerDetailsCurrentBrokerTable(String brokerName, String agencyName, String licenseNumber, String zipCode, String phoneNumber, String type, String status){
        basicActions.waitForElementToBePresent(currentBrokerName,100);
        softAssert.assertEquals(currentBrokerName.getText(),brokerName);
        softAssert.assertEquals(currentAgencyName.getText(),agencyName);
        softAssert.assertEquals(currentBrokerLicense.getText(),licenseNumber);
        softAssert.assertEquals(currentBrokerZipCode.getText(),zipCode);
        softAssert.assertEquals(currentBrokerPhone.getText(),phoneNumber);
        softAssert.assertEquals(currentBrokerType.getText(),type);
        softAssert.assertEquals(currentBrokerStatus.getText(),status);
        softAssert.assertEquals(currentBrokerAction.getText(),"Remove");
        softAssert.assertAll();
    }

    public void validateFindABrokerButtonExists(String expectedState){
        if(expectedState.equals("is")){
            basicActions.waitForElementToBePresent(FindBroker,30);
            softAssert.assertEquals(FindBroker.getText(),"Find a Broker");
            softAssert.assertAll();
        } else if (expectedState.equals("is not")) {
            softAssert.assertFalse(basicActions.waitForElementPresence(FindBroker,30));
            softAssert.assertAll();
        }
    }

    public void validateChangeBrokerButtonExists(String expectedState){
        if(expectedState.equals("is")){
            basicActions.waitForElementToBePresent(ChangeBroker,30);
            softAssert.assertEquals(ChangeBroker.getText(),"Change Broker");
            softAssert.assertAll();
        } else if (expectedState.equals("is not")) {
            softAssert.assertFalse(basicActions.waitForElementPresence(ChangeBroker,30));
            softAssert.assertAll();
        }
    }

    public void validateHaveABrokerCallYouButtonExists(){
        basicActions.waitForElementToBePresent(HaveBrokerCallYou,30);
        softAssert.assertAll();
    }

    public void validateFindAnAssisterButtonExists(){
        basicActions.waitForElementToBePresent(FindAnAssister,30);
        softAssert.assertAll();
    }

    public void validateAuthorizeAssisterOrganizationButtonExists(String expectedState){
        if(expectedState.equals("is")){
            basicActions.waitForElementToBePresent(AuthorizeAssisterOrganization,100);
            softAssert.assertEquals(AuthorizeAssisterOrganization.getText(),"Authorize Assister Organization");
            softAssert.assertAll();
        } else if (expectedState.equals("is not")) {
            softAssert.assertFalse(basicActions.waitForElementPresence(AuthorizeAssisterOrganization,30));
            softAssert.assertAll();
        }
    }

    public void clickBackButton() {
        basicActions.waitForElementToBeClickable(backButton, 5);
        backButton.click();
    }

    public void clickContinueOnMyOwnButton() {
        basicActions.waitForElementToBePresent(continueOnMyOwnButton, 50);
        continueOnMyOwnButton.click();
    }

    public void validateNoBrokerIsAuthorized() {
        basicActions.waitForElementToBePresent(findBroker,30);
        softAssert.assertTrue(findBroker.isDisplayed());
        softAssert.assertAll();
    }

    public void validateContinueOnMyOwnButtonExists(String expectedState){
        if(expectedState.equals("is")){
            basicActions.waitForElementToBePresent(continueOnMyOwnButton,10);
            softAssert.assertEquals(continueOnMyOwnButton.getText(),"Continue on my own");
            softAssert.assertAll();
        } else if (expectedState.equals("is not")) {
            softAssert.assertFalse(basicActions.waitForElementPresence(continueOnMyOwnButton,10));
            softAssert.assertAll();
        }
    }

    public void validateContinueWithMyApplicationButtonExists(String expectedState){
        if(expectedState.equals("is")){
            basicActions.waitForElementToBePresent(continueOnMyOwnButton,10);
            softAssert.assertEquals(continueOnMyOwnButton.getText(),"Continue with my application");
            softAssert.assertAll();
        } else if (expectedState.equals("is not")) {
            softAssert.assertFalse(basicActions.waitForElementPresence(continueOnMyOwnButton,10));
            softAssert.assertAll();
        }
    }
}
