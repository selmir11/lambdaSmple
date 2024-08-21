package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class IncomeOptOutPage {
    // NFA Page

    @FindBy(css = "app-financial-help .header-1")
    WebElement headerText;

    @FindBy(css = "app-financial-help .body-text-1")
    List<WebElement> pageText;

    @FindBy(id = "ExternalFinancialHelpUrl")
    WebElement fincancialHelpLnk;

    @FindBy(id="NoFinancialHelpWanted")
    WebElement noThanks;

    @FindBy(id = "ApplyForFinancialHelp")
    WebElement apply;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public IncomeOptOutPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void chooseNoFinancialHelp(){
        basicActions.waitForElementToBeClickable(noThanks,10);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setAptcAmt("$0");
        subscriber.setFinancialHelp(false);
        SharedData.setPrimaryMember(subscriber);
        noThanks.click();
    }

    public void chooseApply(){
        basicActions.waitForAngular( 15 );
        //basicActions.waitForElementToBePresent(headerText, 50);
        basicActions.waitForElementToBeClickableWithRetries(apply, 50);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setFinancialHelp(true);
        apply.click();
    }

    public void financialHelpWithinText(){
        basicActions.waitForElementToBeClickable(fincancialHelpLnk, 15);
        fincancialHelpLnk.click();
    }

    public void verifyPageText(String Language){
        basicActions.waitForElementToBePresent(headerText, 30);
        switch(Language){
            case "English":
                softAssert.assertEquals(headerText.getText(), "Do you want to save money on your health insurance?");
                softAssert.assertEquals(pageText.get(0).getText(), "Connect for Health Colorado is the only place you can apply for financial help to lower the cost of health insurance. When you apply for financial help, we'll ask you about your household's income, tax information, and other health insurance options to see if you qualify.");
                softAssert.assertEquals(fincancialHelpLnk.getText(),"financial help");
                softAssert.assertEquals(apply.getText(), "Apply for financial help");
                softAssert.assertEquals(pageText.get(1).getText(), "No thanks, I want to purchase a plan without financial help.");
                softAssert.assertEquals(noThanks.getText(), "purchase a plan without financial help.");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(headerText.getText(), "\u00BFQuiere ahorrar dinero en su seguro de salud?");
                softAssert.assertEquals(pageText.get(0).getText(), "Connect for Health Colorado es el \u00FAnico sitio donde puede solicitar ayuda financiera para reducir el costo de su seguro de salud. Cuando solicite ayuda financiera, le pediremos informaci\u00F3n acerca de su ingreso familiar, informaci\u00F3n sobre los impuestos y otras opciones del seguro de salud para ver si califica.");
                softAssert.assertEquals(fincancialHelpLnk.getText(),"ayuda financiera");
                softAssert.assertEquals(apply.getText(), "Solicitar ayuda financiera");
                softAssert.assertEquals(pageText.get(1).getText(), "No, gracias, Quiero adquirir un plan sin ayuda financiera.");
                softAssert.assertEquals(noThanks.getText(), "adquirir un plan sin ayuda financiera.");
                softAssert.assertAll();
                break;
        }
    }
}