package com.c4hco.test.automation.utils;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BasicActions {
    private WebDriver driver;

    private ArrayList<String> tabs;

    public BasicActions(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public BasicActions() {

    }

    public WebDriver getDriver() {
        return this.driver;
    }

    public static BasicActions getInstance() {
        return LazyHolder.INSTANCE;
    }
    private static final String SSN_REGEX =
            "^(?!000|666|9\\d{2})\\d{3}[- ]?(?!00)\\d{2}[- ]?(?!0000)\\d{4}$";
    private static final Pattern SSN_PATTERN = Pattern.compile(SSN_REGEX);

    public void clickBackButtonFromBrowser() {
        getDriver().navigate().back();
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

    public void selectValueFromDropdown(WebElement dropdownElement, List<WebElement> dropdownOptionsElement, String text) {
        dropdownElement.click();
        dropdownOptionsElement.stream().filter(e -> e.getText().equalsIgnoreCase(text)).forEach(WebElement::click);
    }

    public Boolean waitForElementToBeClickable(WebElement webElement, int waitTime) {
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.elementToBeClickable(webElement));
        } catch (TimeoutException ignore) {
            Log.info("Element is not clickable");
            Assert.fail("Element is not clickable");
            return false;
        }
        return true;
    }

    public Boolean waitForElementToBeClickableWithRetries(WebElement webElement, int waitTime) {
        int retries = 5; // Number of retries to handle stale elements
        while (retries > 0) {
            try {
                new WebDriverWait(driver,
                        Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.elementToBeClickable(webElement));
                return true;
            } catch (StaleElementReferenceException e) {
                retries--;
                Log.info("StaleElementReferenceException caught. Retrying... Attempts left: " + retries);
            } catch (TimeoutException e) {
                Log.info("Element is not clickable");
                Assert.fail("Element is not clickable");
                return false;
            }
        }
        return false;
    }

    public Boolean waitForElementToDisappear(WebElement webElement, int waitTime) {
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.invisibilityOf(webElement));
        } catch (TimeoutException ignore) {
            Log.info("Element is still visible after the wait");
            return false;
        }
        return true;
    }

    public Boolean waitForElementListToDisappear(List<WebElement> webElementList, int waitTime) {
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.invisibilityOfAllElements(webElementList));
        } catch (TimeoutException ignore) {
            Log.info("Element is still visible after the wait");
            return false;
        }
        return true;
    }

    public Boolean waitForElementToBePresent(WebElement webElement, int waitTime) {
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException ignore) {
            Log.info("Element is not present");
            return false;
        }
        return true;
    }

    public Boolean isElementDisplayed(WebElement webElement, int waitTime){
        Boolean isElementPresent = true;
        try{
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOf(webElement));
        } catch(NoSuchElementException|TimeoutException ignore){
            isElementPresent = false;
        }
        return isElementPresent;
    }

    public Boolean waitForElementToBePresentWithRetries(WebElement webElement, int waitTime) {
        int retries = 5; // Number of retries to handle stale element
        while (retries > 0) {
            try {
                new WebDriverWait(driver,
                        Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOf(webElement));
                return true;
            } catch (StaleElementReferenceException e) {
                retries--;
                Log.info("StaleElementReferenceException caught. Retrying... Attempts left: " + retries);
            } catch (TimeoutException e) {
                Log.info("Element is not present");
                return false;
            }
        }
        return false;
    }

    public Boolean waitForElementPresence(WebElement webElement, int waitTime) {
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException|NoSuchElementException ignore) {
            Log.info("Element is not present");
            return false;
        }
        return true;
    }

    public void refreshPage() {
        getDriver().navigate().refresh();
    }

    public void goBack() {
        getDriver().navigate().back();
    }

    public Boolean waitForElementListToBePresent(List<WebElement> webElementList, int waitTime) {
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOfAllElements(webElementList));
        } catch (TimeoutException ignore) {
            Log.info("Element is not present");
            return false;
        }
        return true;
    }

    public Boolean waitForElementListToBePresentWithRetries(List<WebElement> webElementList, int waitTime) {
        int retries = 5; // Number of retries to handle stale elements
        while (retries > 0) {
            try {
                new WebDriverWait(driver,
                        Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOfAllElements(webElementList));
                return true;
            } catch (StaleElementReferenceException e) {
                retries--;
                Log.info("StaleElementReferenceException caught. Retrying... Attempts left: " + retries);
            } catch (TimeoutException e) {
                Log.info("Element list is not present");
                return false;
            }
        }
        return false;
    }

    public void wait(int milliSeconds) {
        try {
            Thread.sleep(milliSeconds);
        } catch (Exception e) {
            // Exception is supressed because it is just wait statement
        }
    }

    public void click(WebElement element) {
        Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofMillis(100))
                .ignoring(NoSuchElementException.class);

        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));

        try {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    public void clickById(String elementId){
        WebElement element = WebDriverManager.getDriver().findElement(By.id(elementId));
        ((JavascriptExecutor) WebDriverManager.getDriver()).executeScript("arguments[0].click()",element );
    }

    public void waitForPresence(WebElement webElement) {
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
    public void scrollToElement(WebElement element) {
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

    public void switchtoactiveTab() {
        tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(1));
    }
    public void switchtoPreviousTab() {
        tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(0));
    }

    public void switchTabs(int tabNumber) {
        tabs = new ArrayList<>(getDriver().getWindowHandles());
        getDriver().switchTo().window(tabs.get(tabNumber));
    }

    public void changeToNewUrl(String page){
        String currentUrl = getCurrentUrl();
        String primaryMemId = SharedData.getPrimaryMemberId();
        String newUrl = "";
        switch(page){
            case "Elmo Other Health Coverage Page":
                newUrl = "OtherHealthCoveragePortal/members/"+primaryMemId+"/otherHealthCoverage";
                newUrl = currentUrl.replace("nes/otherHealthInsuranceBegin", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Elmo COBRA Page":
                newUrl = "OtherHealthCoveragePortal/members/"+primaryMemId+"/otherHealthCoverage/cobra";
                newUrl = currentUrl.replace("nes/cobra", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Elmo Ohi Retiree Page":
                newUrl = "OtherHealthCoveragePortal/members/"+primaryMemId+"/otherHealthCoverage/retiree";
                newUrl = currentUrl.replace("nes/retireeHealth", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Elmo Ohi Medicare Page":
                newUrl = "OtherHealthCoveragePortal/members/"+primaryMemId+"/otherHealthCoverage/medicare";
                newUrl = currentUrl.replace("nes/medicare", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Elmo Ohi VA Healthcare Page":
                newUrl = "OtherHealthCoveragePortal/members/"+primaryMemId+"/otherHealthCoverage/va";
                newUrl = currentUrl.replace("nes/vaHealth", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Elmo Ohi Individual Insurance Page":
                newUrl = "OtherHealthCoveragePortal/members/"+primaryMemId+"/otherHealthCoverage/individual";
                newUrl = currentUrl.replace("nes/individualInsurance", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Elmo Ohi Peace Corps Page":
                newUrl = "OtherHealthCoveragePortal/members/"+primaryMemId+"/otherHealthCoverage/peaceCorps";
                newUrl = currentUrl.replace("nes/peaceCorps", newUrl);
                getDriver().navigate().to(newUrl);
				break;
            case "Elmo Ohi Tricare Page":
                newUrl = "OtherHealthCoveragePortal/members/"+primaryMemId+"/otherHealthCoverage/tricare";
                newUrl = currentUrl.replace("nes/tricare", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Income portal Error CoCo":
                newUrl = "income-portal/error";
                newUrl = currentUrl.replaceAll("income-portal/additionalIncome/[^/]*", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Income portal Unauthorized CoCo":
                newUrl = "income-portal/unauthorized";
                newUrl = currentUrl.replaceAll("income-portal/additionalIncome/[^/]*", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Income portal Error Exch":
                newUrl = "IncomePortal/error";
                newUrl = currentUrl.replaceAll("IncomePortal/additionalIncome/[^/]*", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Income portal Unauthorized Exch":
                newUrl = "IncomePortal/unauthorized";
                newUrl = currentUrl.replaceAll("IncomePortal/additionalIncome/[^/]*", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Welcome portal Error CoCo":
                newUrl = "WelcomePortal/error";
                newUrl = currentUrl.replaceAll("WelcomePortal/welcome", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Welcome portal Unauthorized CoCo":
                newUrl = "WelcomePortal/unauthorized";
                newUrl = currentUrl.replaceAll("WelcomePortal/welcome", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Family Overview portal Error CoCo":
                newUrl = "WelcomePortal/error";
                newUrl = currentUrl.replaceAll("WelcomePortal/familyOverview[^/]*", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Family Overview portal Unauthorized CoCo":
                newUrl = "WelcomePortal/unauthorized";
                newUrl = currentUrl.replaceAll("WelcomePortal/familyOverview[^/]*", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "LCE portal Error CoCo":
                newUrl = "lce-portal/error";
                newUrl = currentUrl.replaceAll("lce-portal/lces[^/]*", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "LCE portal Unauthorized CoCo":
                newUrl = "lce-portal/unauthorized";
                newUrl = currentUrl.replaceAll("lce-portal/lces[^/]*", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Declarations and Signature portal Error CoCo":
                newUrl = "WelcomePortal/error";
                newUrl = currentUrl.replaceAll("WelcomePortal/declarationsAndSignature[^/]*", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Declarations and Signature portal Unauthorized CoCo":
                newUrl = "WelcomePortal/unauthorized";
                newUrl = currentUrl.replaceAll("WelcomePortal/declarationsAndSignature[^/]*", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Other Health Coverage portal Error Exch":
                newUrl = "OtherHealthCoveragePortal/error";
                newUrl = currentUrl.replaceAll("OtherHealthCoveragePortal/members/[^/]*/otherHealthCoverage/employerSponsored", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Other Health Coverage portal Unauthorized Exch":
                newUrl = "OtherHealthCoveragePortal/unauthorized";
                newUrl = currentUrl.replaceAll("OtherHealthCoveragePortal/members/[^/]*/otherHealthCoverage/employerSponsored", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + page);
        }
    }
    public static boolean isSSNValid(String SSNvalue){
        if (SSNvalue == null) {
            return false;
        }
        Matcher matcher = SSN_PATTERN.matcher(SSNvalue);
        return matcher.matches();
    }

    public static String capitalizeFirstLetter(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    public String getNoticesDownloadPath(){
        String timestamp = new SimpleDateFormat("MMddyyyy-HHmmss").format(new Date());
        String noticesFolderPath = "target/notices-downloads/download-" + timestamp;
        File reportFolder = new File(noticesFolderPath);
        if (!reportFolder.exists()) {
            boolean folderCreated = reportFolder.mkdirs();
            if (!folderCreated) {
                System.out.println("Failed to create the report folder.");
            }
        }
        SharedData.setLocalPathToDownloadFile(noticesFolderPath);
        return noticesFolderPath;
    }
    public static String getUniquePW(){
        return RandomStringUtils.random(8,1234+"2@ACRTYUIOPcdefghijklmnopQWERTYUIOPASDFqrstuvwxyz234566");
    }

    public Boolean waitForPageLoad(int waitTime) {
        try {
            new WebDriverWait( driver, Duration.ofSeconds( waitTime ) ).until( (ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript( "return document.readyState" ).equals( "complete" ) );
        } catch (TimeoutException ignore) {
            Log.info( "Document ready state not complete" );
            Assert.fail( "Document ready state not complete" );
            return false;
        }
        return true;
    }
    public Boolean waitForAngular(int waitTime) {
        driver.manage().timeouts().setScriptTimeout(waitTime, TimeUnit.SECONDS);
        try {
            //Wait for DOM ready
            waitForPageLoad(waitTime);
            //Wait for Angular ready
            ((JavascriptExecutor) driver).executeAsyncScript(
                    "getAllAngularTestabilities()[0].whenStable(arguments[arguments.length - 1], " + (waitTime * 1000) + ")");
        } catch (TimeoutException ignore) {
            Log.info( "Angular ready state not complete" );
            Assert.fail( "Angular ready state not complete" );
            return false;
        }
        return true;
    }
}

