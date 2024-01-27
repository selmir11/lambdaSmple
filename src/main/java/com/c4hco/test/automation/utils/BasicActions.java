package com.c4hco.test.automation.utils;


import com.c4hco.test.automation.selenium.Selenese;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasicActions {
    private WebDriver driver;
    private Selenese selenese = Selenese.getInstance();


    public BasicActions() {
        this.driver = selenese.getDriver();
    }

    public WebDriver getDriver() {
        return selenese.getDriver();
    }

    public static BasicActions getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final BasicActions INSTANCE = new BasicActions();
    }

    public void closeBrowser() {
        if (this.driver != null) {
            this.driver.quit();
        }
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public void clickButton(WebElement elementLocator){
        elementLocator.click();
    }

    // wait for page load

    public String getUrlWithWait(String url, int waitTime) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.urlContains(url));
        } catch (TimeoutException ignore) {
            Log.info("The expected URL:" + url + "wasn't there after" + waitTime + "seconds");
            return "";
        }
        return getDriver().getCurrentUrl();
    }

}

