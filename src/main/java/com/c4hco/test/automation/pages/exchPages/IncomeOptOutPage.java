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

    @FindBy(css = "#financial-help-percentage")
    WebElement helpPercentage;

    @FindBy(css = "#financial-help-percentage-text span")
    List<WebElement> helpPercentageText;

    @FindBy(css = "app-financial-help .body-text-1")
    List<WebElement> pageText;

    @FindBy(id = "ExternalFinancialHelpUrl")
    WebElement fincancialHelpLnk;

    @FindBy(id="NoFinancialHelpWanted")
    WebElement noThanks;

    @FindBy(id = "ApplyForFinancialHelp")
    WebElement apply;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public IncomeOptOutPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void chooseNoFinancialHelp(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBeClickable(noThanks,10);
        basicActions.scrollToElement(noThanks);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setAptcAmt("$0");
        subscriber.setFinancialHelp(false);
        SharedData.setPrimaryMember(subscriber);
        basicActions.clickElementWithRetries(noThanks, 10);
    }

    public void chooseApply(){
        basicActions.waitForElementToDisappear(spinner, 40);
        basicActions.waitForElementToBePresent(headerText, 50);
        basicActions.waitForElementToBePresent(noThanks, 50);
        basicActions.waitForElementToBePresent(apply, 60);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setFinancialHelp(true);
        basicActions.clickElementWithRetries(apply, 30);
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
                softAssert.assertEquals(helpPercentage.getText(), "81");
                softAssert.assertEquals(helpPercentageText.get(0).getText(), "of customers get financial help");
                softAssert.assertEquals(helpPercentageText.get(1).getText(), "to lower the cost of health insurance");
                softAssert.assertEquals(pageText.get(0).getText(), "Connect for Health Colorado is the only place you can apply for financial help to lower the cost of health insurance. When you apply for financial help, we'll ask you about your household's income, tax information, and other health insurance options to see if you qualify.");
                softAssert.assertEquals(fincancialHelpLnk.getText(),"financial help");
                softAssert.assertEquals(apply.getText(), "Apply for financial help");
                softAssert.assertEquals(pageText.get(1).getText(), "No thanks, I want to purchase a plan without financial help.");
                softAssert.assertEquals(noThanks.getText(), "purchase a plan without financial help.");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(headerText.getText(), "\u00BFQuiere ahorrar dinero en su seguro de salud?");
                softAssert.assertEquals(helpPercentage.getText(), "81");
                softAssert.assertEquals(helpPercentageText.get(0).getText(), "de los clientes reciben ayuda financiera");
                softAssert.assertEquals(helpPercentageText.get(1).getText(), "para bajar el costo del seguro de salud");
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