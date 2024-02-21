package com.c4hco.test.automation.utils;


import com.c4hco.test.automation.selenium.Selenese;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasicActions {
    private WebDriver driver;
    private WebDriverWait wait;
    private Selenese selenese = Selenese.getInstance();

    // Constructor to initialize WebDriver
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

    public void closeBrowserTab() {
        if (this.driver != null) {
            this.driver.close();
        }
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

    public String getUrlWithWait(String url, int waitTime) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.urlContains(url));
        } catch (TimeoutException ignore) {
            Log.info("The expected URL:" + url + "wasn't there after" + waitTime + "seconds");
            return "";
        }
        return getDriver().getCurrentUrl();
    }

    public void selectValueFromDropdown(WebElement dropdownElement, List<WebElement> dropdownOptionsElement, String text){
        dropdownElement.click();
        dropdownOptionsElement.stream().filter(e-> e.getText().equalsIgnoreCase(text)).forEach(WebElement::click);
    }

    public Boolean waitForElementToBeClickable(WebElement webElement, int waitTime){
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.elementToBeClickable(webElement));
        } catch(TimeoutException ignore){
            Log.info("Element is not clickable");
            return false;
        }
        return true;
    }

    public Boolean waitForElementToDisappear(WebElement webElement, int waitTime){
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.invisibilityOf(webElement));
        } catch(TimeoutException ignore){
            Log.info("Element is still visible after the wait");
            return false;
        }
        return true;
    }

    public Boolean waitForElementToBePresent(WebElement webElement, int waitTime){
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOf(webElement));
        } catch(TimeoutException ignore){
            Log.info("Element is not present");
            return false;
        }
        return true;
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public Boolean waitForElementListToBePresent(List<WebElement> webElementList , int waitTime){
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOfAllElements(webElementList));
        } catch(TimeoutException ignore){
            Log.info("Element is not present");
            return false;
        }
        return true;
    }

    public void assertElementTextMatched(WebElement element, String expectedText) {
        String actualText = element.getText().trim();
        Assert.assertTrue("Expected text '" + expectedText + "' not found in actual text: '" + actualText + "'", actualText.contains(expectedText));
    }

    public void assertPlaceholderTextMatched(WebElement element, String expectedPlaceholder) {
        String actualPlaceholder = element.getAttribute("placeholder");
        Assert.assertEquals("Expected placeholder text '" + expectedPlaceholder + "' not found in actual placeholder: '" + actualPlaceholder + "'", expectedPlaceholder, actualPlaceholder);
    }

//    public void waitForElementTobeClickableAndClick(WebElement webElement, int waitTime){
//        try {
//            new WebDriverWait(driver,
//                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.elementToBeClickable(webElement));
//            webElement.click();
//        } catch(TimeoutException ignore){
//            Log.info("Element is not clickable");
//        }
//
//    }
//
//    public  void scrollToElement(WebElement element) {
//        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
//    }

//    public  void switchToWindow(String targetTitle) {
//        String origin = getDriver().getWindowHandle();
//        for (String handle :getDriver().getWindowHandles()) {
//            getDriver().switchTo().window(handle);
//            if (getDriver().getTitle().equals(targetTitle)) {
//                return;
//            }
//        }
//        getDriver().switchTo().window(origin);
//    }

//    public void implicitWait(int second){
//        getDriver().manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
//    }

}

