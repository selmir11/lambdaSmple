package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.c4hco.test.automation.utils.ApplicationProperties;

import java.util.Objects;

public class CRMLoginPage {

    @FindBy(name = "loginfmt")
    WebElement txtCRMUsername;

    @FindBy(xpath = "//input[@value='Next']")
    WebElement btnCRMLoginNext;

    @FindBy(name = "passwd")
    WebElement txtCRMPassword;

    @FindBy(xpath = "//input[@value='Sign in']")
    WebElement btnCRMLoginSignIn;

    @FindBy(xpath = "//input[@value='No']")
    WebElement btnCRMLoginStayLoggedInNo;

    @FindBy(id = "AppLandingPage")
    WebElement iframeCRMLandingPage;

    @FindBy(xpath = "//a[@title='C4HCO CS Hub']")
    WebElement btnCRMCSHub;

    private BasicActions basicActions;

    public CRMLoginPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public void openCRM(){
//        basicActions.getDriver().get("https://c4hcodev.crm.dynamics.com/");
//        basicActions.refreshPage();
//
//        String env = ApplicationProperties.getInstance().getProperty("env");

        if(Objects.equals(ApplicationProperties.getInstance().getProperty("env"), "staging")){
            basicActions.getDriver().get("https://c4hcostg.crm.dynamics.com/");
            basicActions.refreshPage();
            }
        else if(Objects.equals(ApplicationProperties.getInstance().getProperty("env"), "qa")){
            basicActions.getDriver().get("https://c4hcodev.crm.dynamics.com/");
            basicActions.refreshPage();
        }
        else{System.out.println("Invalid CRM Environment URL");};

        basicActions.waitForElementToBeClickableWithRetries(txtCRMUsername, 30);
        txtCRMUsername.sendKeys(ApplicationProperties.getInstance().getProperty("crmAdmin_UN"));
        btnCRMLoginNext.click();

        basicActions.waitForElementToBeClickableWithRetries(txtCRMPassword, 30);
        txtCRMPassword.sendKeys(ApplicationProperties.getInstance().getProperty("crmAdmin_PW"));
        btnCRMLoginSignIn.click();

        basicActions.waitForElementToBeClickableWithRetries(btnCRMLoginStayLoggedInNo, 30);
        btnCRMLoginStayLoggedInNo.click();

        if(Objects.equals(ApplicationProperties.getInstance().getProperty("env"), "staging")){
            basicActions.waitForElementToBePresentWithRetries(iframeCRMLandingPage, 30);
            basicActions.getDriver().switchTo().frame(iframeCRMLandingPage);
            basicActions.waitForElementToBeClickableWithRetries(btnCRMCSHub, 30);
            btnCRMCSHub.click();
        }
    }
}
