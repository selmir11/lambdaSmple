package com.c4hco.test.automation.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Selenese {
    private WebDriver driver;
    public static int WAIT_FOR_ELEMENT = 30;

    private Selenese(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        this.driver = new ChromeDriver(options);

    }

    public static Selenese getInstance(){
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder{
        private static final Selenese INSTANCE = new Selenese();
    }

    public void setDriver(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public String getText(WebElement webElement){
        return webElement.getText();
    }
}
