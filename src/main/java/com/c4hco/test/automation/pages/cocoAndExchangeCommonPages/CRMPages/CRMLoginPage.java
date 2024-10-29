package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.c4hco.test.automation.utils.ApplicationProperties;

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

    private BasicActions basicActions;

    public CRMLoginPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public void openCRM(){
        basicActions.getDriver().get("https://c4hcodev.crm.dynamics.com/");
        basicActions.refreshPage();
        basicActions.wait(5000);

        basicActions.waitForElementToBeClickable(txtCRMUsername, 30);
        txtCRMUsername.sendKeys(ApplicationProperties.getInstance().getProperty("crmAdmin_UN_QA"));
        btnCRMLoginNext.click();

        basicActions.wait(5000);
        basicActions.waitForElementToBeClickable(txtCRMPassword, 30);
        txtCRMPassword.sendKeys(ApplicationProperties.getInstance().getProperty("crmAdmin_PW_QA"));
        btnCRMLoginSignIn.click();

        basicActions.waitForElementToBeClickable(btnCRMLoginStayLoggedInNo, 30);
        btnCRMLoginStayLoggedInNo.click();
    }
}
