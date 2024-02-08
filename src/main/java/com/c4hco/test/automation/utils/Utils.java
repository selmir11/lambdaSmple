package com.c4hco.test.automation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Utils {
    private String env = ApplicationProperties.getInstance().getProperty("env");
    private BasicActions basicActions;

    public Utils(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public String getBaseLoginUrl(String appType){
        String baseUrl = "";
        switch(appType){
            case "login":
                baseUrl = Constants.PROTOCOL+env+Constants.LOGIN;
                break;
            case "broker":
                baseUrl = Constants.PROTOCOL+env+Constants.BROKER;
                break;

            case "admin":
                baseUrl = Constants.PROTOCOL+env+Constants.ADMIN;
                break;
        }
        return baseUrl;
    }

    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void refreshPage(){
        basicActions.getDriver().navigate().refresh();
    }

    public WebElement waitForVisibility(WebElement element, Duration timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(basicActions.getDriver(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void implicitWait(int second){
        basicActions.getDriver().manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
    }


    public  WebElement waitForClickablility(WebElement element, Duration timeout) {
        WebDriverWait wait = new WebDriverWait(basicActions.getDriver(), timeout);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public  void scrollToElement(WebElement element) {
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}
