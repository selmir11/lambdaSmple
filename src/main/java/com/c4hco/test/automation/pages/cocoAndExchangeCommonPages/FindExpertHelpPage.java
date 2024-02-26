package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

public class FindExpertHelpPage {

    @FindBy(xpath ="//h2[@id='experthelp-title']")
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




    private BasicActions basicActions;
    public FindExpertHelpPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    public void verifyHeaderPage(String Language){
        String ExpectedTitle = "";
        basicActions.waitForElementToBePresent(pageHeader,10);
        String ActualTitle =pageHeader.getText();

        switch (Language) {
            case "English":
                ExpectedTitle = "Find expert help near you";
                break;
            case "Spanish":
                ExpectedTitle = "Encuentre un experto cerca de usted";
                break;
            default:
                System.out.println("The wrong language option has been selected");
        }
        Assert.assertEquals(ExpectedTitle,ActualTitle);
    }

    public void verifyTitlePage(String Language){
        String ExpectedTitle = "";
        String ActualTitle =pageTitle.getText();

        switch (Language) {
            case "English":
                ExpectedTitle = "Colorado Connect offers a statewide network of certified experts who can help you complete your application and shop for a plan in person.";
                break;
            case "Spanish":
                ExpectedTitle = "Colorado Connect ofrece una red estatal de expertos certificados que le pueden ayudar a completar su solicitud y buscar un plan en persona.";
                break;
            default:
                System.out.println("The wrong language option has been selected");
        }
        Assert.assertEquals(ExpectedTitle,ActualTitle);
    }

    public void verifyPageText(String Language){
        SoftAssert softAssert = new SoftAssert();
        switch (Language) {
            case "English":
        softAssert.assertEquals(helpFromBroker.getText(),"Help from a Broker");
        softAssert.assertEquals(helpFromBrokerText.getText(),"Our brokers are licensed to help you evaluate health insurance benefits and coverage, recommend a plan based on your specific needs and enroll you in that plan. They can also help you apply for financial help.");
        break;
        case "Spanish":
        softAssert.assertEquals(helpFromBroker.getText(),"Ayuda de un Agente");
        softAssert.assertEquals(helpFromBrokerText.getText(),"Nuestros Agentes están autorizados para ayudarle a evaluar beneficios y cobertura de seguro de salud, recomendar un plan acorde a sus necesidades específicas e inscribirlo en ese plan. Pueden también ayudarle a solicitar ayuda financiera.");
        break;
        default:
        System.out.println("The wrong language option has been selected");
        }
    }

    public void verifyButtontext(String Language){
        SoftAssert softAssert = new SoftAssert();
        switch (Language) {
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
                System.out.println("The wrong language option has been selected");
        }
    }

}
