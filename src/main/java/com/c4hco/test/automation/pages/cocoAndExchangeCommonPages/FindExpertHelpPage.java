package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class FindExpertHelpPage {
    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    @FindBy(xpath ="//h2[@class='header-2']")
    WebElement pageHeader;

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

    public void verifyTitlePage(String language){
        String ExpectedTitle = "";
        String ActualTitle =pageTitle.getText();

        switch (language) {
            case "English":
                ExpectedTitle = "Colorado Connect offers a statewide network of certified experts who can help you complete your application and shop for a plan in person.";
                break;
            case "Spanish":
                ExpectedTitle = "Colorado Connect ofrece una red estatal de expertos certificados que le pueden ayudar a completar su solicitud y buscar un plan en persona.";
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

}
