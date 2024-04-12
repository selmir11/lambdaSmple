package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

public class BasicActions {
    private WebDriver driver;
    WebDriverManager basicActions;

    public BasicActions(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public BasicActions(){

    }

    public WebDriver getDriver() {
        return this.driver;
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
            Assert.fail("Element is not clickable");
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

    public Boolean waitForElementListToDisappear(List<WebElement> webElementList, int waitTime){
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.invisibilityOfAllElements(webElementList));
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
            Assert.fail("Element waiting for is not displayed");
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

    public void wait(int milliSeconds){
        try {
            Thread.sleep(milliSeconds);
        } catch(Exception e){
            // Exception is supressed because it is just wait statement
        }
    }

    public void click(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));

        element.click();
    }

    public void waitForPresence(WebElement webElement){
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public void switchToParentPage(String pageTitle) {
        Set<String> allWindowHandles = getDriver().getWindowHandles();
        for (String windowHandle : allWindowHandles) {
            getDriver().switchTo().window(windowHandle);
            if (getDriver().getTitle().equals(pageTitle)) {
                break;
            }
        }
    }

    public  void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public List<MemberDetails> addPrimaryMemToMembersListIfAbsent() {
        List<MemberDetails> members = SharedData.getMembers();
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        if (!members.contains(primaryMem)) {
            members.add(primaryMem);
        }
        return members;
    }
     public Boolean waitUntilUrlIsPresent(String pageUrl){
        try {
         Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                 .withTimeout(Duration.ofSeconds(30))
                 .pollingEvery(Duration.ofMillis(100))
                 .ignoring(NoSuchElementException.class);

         wait.until(ExpectedConditions.urlContains(pageUrl));
     }
        catch(TimeoutException e) {
            System.out.println("Url waiting for is not displayed");
        return false;
        }
        return true;
}

    public void changeToNewUrl(String page){
        String currentUrl = getCurrentUrl();
        String primaryMemId = SharedData.getPrimaryMemberId();
        switch(page){
            case "Elmo Other Health Insurance Page":
                String newUrl = "OtherHealthInsurancePortal/members/"+primaryMemId+"/otherHealthInsurance";
                newUrl = currentUrl.replace("nes/otherHealthInsuranceBegin", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Elmo COBRA":
                String newUrl1 = "OtherHealthInsurancePortal/members/"+primaryMemId+"/otherHealthInsurance/cobra";
                newUrl1 = currentUrl.replace("nes/cobra", newUrl1);
                getDriver().navigate().to(newUrl1);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + page);
        }
    }

}

