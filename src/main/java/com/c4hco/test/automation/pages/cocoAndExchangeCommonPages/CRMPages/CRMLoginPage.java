package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.c4hco.test.automation.utils.ApplicationProperties;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
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

    @FindBy(css = "#otherTileText")
    WebElement btnUseAnother;

    private BasicActions basicActions;

    public CRMLoginPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public void openCRM(){

        if(Objects.equals(ApplicationProperties.getInstance().getProperty("env"), "staging")){
            basicActions.getDriver().get("https://c4hcostg.crm.dynamics.com/");
            basicActions.refreshPage();
            }
        else if(Objects.equals(ApplicationProperties.getInstance().getProperty("env"), "qa")){
            basicActions.getDriver().get("https://c4hcodev.crm.dynamics.com/");
            basicActions.refreshPage();
        }
        else{System.out.println("Invalid CRM Environment URL");};

        basicActions.wait(50);
        List<WebElement> elements = basicActions.getDriver().findElements(By.cssSelector("#otherTileText"));
        if (!elements.isEmpty()) {
            WebElement btnUseAnother = elements.get(0);
            try {
                WebDriverWait wait = new WebDriverWait(basicActions.getDriver(), Duration.ofSeconds(60));
                wait.until(ExpectedConditions.visibilityOf(btnUseAnother));
                wait.until(ExpectedConditions.elementToBeClickable(btnUseAnother));
                btnUseAnother.click();
            } catch (TimeoutException e) {
                System.out.println("btnUseAnother did not become visible or clickable within the timeout. Skipping this step.");
            }
        } else {
            System.out.println("btnUseAnother is not present in the DOM. Skipping this step.");
        }

        basicActions.waitForElementToBeClickableWithRetries(txtCRMUsername, 30);
        txtCRMUsername.sendKeys(ApplicationProperties.getInstance().getProperty("crmAdmin_UN"));
        btnCRMLoginNext.click();

        basicActions.waitForElementToBeClickableWithRetries(txtCRMPassword, 30);
        txtCRMPassword.sendKeys(ApplicationProperties.getInstance().getProperty("crmAdmin_PW"));
        btnCRMLoginSignIn.click();

        basicActions.waitForElementToBeClickableWithRetries(btnCRMLoginStayLoggedInNo, 30);
        btnCRMLoginStayLoggedInNo.click();

        try {
            if (basicActions.waitForElementToBePresentWithRetries(iframeCRMLandingPage, 30)
                    && Objects.equals(ApplicationProperties.getInstance().getProperty("env"), "staging")
                    && iframeCRMLandingPage.isDisplayed()) {
                basicActions.getDriver().switchTo().frame(iframeCRMLandingPage);
                if (basicActions.waitForElementToBePresentWithRetries(btnCRMCSHub, 30)
                        && btnCRMCSHub.isDisplayed()) {
                    btnCRMCSHub.click();
                }
                basicActions.getDriver().switchTo().defaultContent();
            }
        } catch (TimeoutException | NoSuchElementException e) {
        } finally {
            basicActions.getDriver().switchTo().defaultContent();
        }
    }
}
