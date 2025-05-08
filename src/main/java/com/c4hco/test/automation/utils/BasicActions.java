package com.c4hco.test.automation.utils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.security.SecureRandom;
import java.text.Collator;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAccessor;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.ChronoField;

import static org.testng.AssertJUnit.assertTrue;

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

    public void openUrlWithQueryStringInNewTab(String query) {
        String currUrl = getCurrentUrl();
        String newUrl = currUrl + query;
        openNewTab();
        driver.get(newUrl);
    }



    public String extractDateFromUrl(String url) {
        try {
            URL u = new URL(url);
            URI uri = u.toURI();
            String query = uri.getQuery();
            if (query != null) {
                String[] pairs = query.split("&");
                for (String pair : pairs) {
                    String[] keyValue = pair.split("=");
                    if (keyValue[0].equals("dateOverride")) {
                        return keyValue[1];
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void openNewTab() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open();");
        Set<String> windowHandles = driver.getWindowHandles();
        String newTabHandle = null;
        for (String handle : windowHandles) {
            if (!handle.equals(driver.getWindowHandle())) {
                newTabHandle = handle;
                break;
            }
        }
        driver.switchTo().window(newTabHandle);
    }

    public void openCurrPageInNewTab() {
        String currentUrl = getCurrentUrl();
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        jse.executeScript("window.open()");
        for (String handle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(handle);
        }
        getDriver().get(currentUrl);
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
            } catch (TimeoutException e) {
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
            return false;
        }
        return true;
    }

    public Boolean isElementDisplayed(WebElement webElement, int waitTime) {
        Boolean isElementPresent = true;
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOf(webElement));
        } catch (NoSuchElementException | TimeoutException ignore) {
            isElementPresent = false;
        }
        return isElementPresent;
    }

    public Boolean waitForElementToBePresentWithRetries(WebElement webElement, int waitTime) {
        int retries = 10; // Number of retries to handle stale element
        while (retries > 0) {
            try {
                new WebDriverWait(driver,
                        Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOf(webElement));
                return true;
            } catch (StaleElementReferenceException | NoSuchElementException | IndexOutOfBoundsException | ElementNotInteractableException e) {
                retries--;

            } catch (TimeoutException e) {

                return false;
            }
        }
        return false;
    }

    public Boolean clickElementWithRetries(WebElement webElement, int waitTime) {
        int retries = 5; // Number of retries to handle element interception
        while (retries > 0) {
            try {
                new WebDriverWait(driver,
                        Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOf(webElement));
                webElement.click();
                return true;
            } catch (ElementClickInterceptedException|NoSuchElementException e) {
                retries--;
            } catch (TimeoutException e) {
                return false;
            }
        }
        return false;
    }

    public Boolean waitForElementPresence(WebElement webElement, int waitTime) {
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException | NoSuchElementException ignore) {
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
            } catch (TimeoutException e) {
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

    public Boolean waitForElementToBePresent(WebElement webElement, int waitTime) {
        try {
            new WebDriverWait(driver,
                    Duration.ofSeconds(waitTime)).pollingEvery(Duration.ofMillis(100)).until(ExpectedConditions.visibilityOf(webElement));
        } catch (TimeoutException | NoSuchElementException | IndexOutOfBoundsException ignore) {
            return false;
        }
        return true;
    }


    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
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
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        tabs = new ArrayList<>(getDriver().getWindowHandles());
        String targetHandle = (String) tabs.toArray()[tabNumber];
        getDriver().switchTo().window(targetHandle);
    }

    public void changeToNewUrl(String page) {
        String currentUrl = getCurrentUrl();
        String newUrl = "";
        switch (page) {
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
            case "Employment Income Unauthorized CoCo":
                newUrl = "income-portal/unauthorized";
                newUrl = currentUrl.replaceAll("income-portal/member/[^/]*/employmentInfo(/summary)?[^/]*", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            case "Employment Income Unauthorized Exch":
                newUrl = "IncomePortal/unauthorized";
                newUrl = currentUrl.replaceAll("IncomePortal/member/[^/]*/employmentInfo(/summary)?[^/]*", newUrl);
                getDriver().navigate().to(newUrl);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + page);
        }
    }

    public static boolean isSSNValid(String SSNvalue) {
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

    public static String getUniquePW() {
        return RandomStringUtils.random(2, "@&%@@") + RandomStringUtils.randomAlphanumeric(8) + RandomStringUtils.random(1, "QWERTYUIOPASD") + RandomStringUtils.randomNumeric(2);
    }

    public Boolean waitForPageLoad(int waitTime) {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(waitTime)).until((ExpectedCondition<Boolean>) wd ->
                    ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));
        } catch (TimeoutException ignore) {
            Assert.fail("Document ready state not complete");
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

            Assert.fail("Angular ready state not complete");
            return false;
        }
        return true;
    }

    public boolean elementExists( By locator) {
        return !driver.findElements(locator).isEmpty();
    }

    public boolean isSortedAscending(List<WebElement> objectDetails) {
        waitForElementListToBePresentWithRetries(objectDetails, 10);
        List<String> stringList = objectDetails.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        for (int i = 0; i < stringList.size() - 1; i++) {
            double currentAmount = Double.parseDouble(stringList.get(i).replace("$", ""));
            double nextAmount = Double.parseDouble(stringList.get(i + 1).replace("$", ""));
            if (currentAmount > nextAmount) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedDescending(List<WebElement> objectDetails) {
        waitForElementListToBePresentWithRetries(objectDetails, 10);
        List<String> amounts = objectDetails.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        for (int i = 0; i < amounts.size() - 1; i++) {
            double currentAmount = Double.parseDouble(amounts.get(i).replace("$", ""));
            double nextAmount = Double.parseDouble(amounts.get(i + 1).replace("$", ""));
            if (currentAmount < nextAmount) {
                return false;
            }
        }
        return true;
    }

    public String doubleAmountFormat(String amountText) {
        String formattedAmt = amountText.replaceAll("[^\\d.]", "");
        // Parse the amount string to a double
        double amount = Double.parseDouble(formattedAmt);
        // Check if the amount is a whole number
        if (amount % 1 == 0) {
            return String.format("%.0f", amount); // No decimals for whole numbers
        } else {
            return String.format("%.2f", amount); // Two decimals for fractional amounts
        }
    }

    public String getCurrYear() {
        LocalDate today = LocalDate.now();
        return Integer.toString(today.getYear());
    }
    public String getPastYear(int num) {
        return Integer.toString(Year.now().getValue() - num);
    }

    public String getStartDateOE() {// Today
        LocalDate date = LocalDate.of(Integer.parseInt(getCurrYear()), 11, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return date.format(formatter);
    }

    public String getEndDateOE() {// Today
        LocalDate date = LocalDate.of(Integer.parseInt(getCurrYear()), 12, 31);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return date.format(formatter);
    }

    public String getFutureYear() {
        LocalDate today = LocalDate.now();
        return Integer.toString(today.getYear() + 1);
    }

    public String getFirstOfJanNextYr() { // January 1st of next year
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(today.getYear() + 1, 1, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    public String getFirstOfJanCurrYr() { // January 1st of current year
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(today.getYear(), 1, 1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    public String getLastDayOfCurrYr() {// December 31st of the current year
        LocalDate today = LocalDate.now();
        LocalDate date = LocalDate.of(today.getYear(), 12, 31);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    public String firstDateOfNextMonth() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfNextMonth = today.plusMonths(1).withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return firstDayOfNextMonth.format(formatter);
    }
    public String firstDateOfNextMonthAfterSpecificDate(String dateStr) {
        DateTimeFormatter formatter;
        if (dateStr.contains("-")) {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        } else {
            formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        }
        LocalDate firstDayOfNextMonth = LocalDate.parse(dateStr, formatter).plusMonths(1).withDayOfMonth(1);
        return firstDayOfNextMonth.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }


    public String firstDateOfLastMonth() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfLastMonth = today.minusMonths(1).withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return firstDayOfLastMonth.format(formatter);
    }

    public String firstDateOfCurrMonth() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfCurrMonth = today.withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return firstDayOfCurrMonth.format(formatter);
    }

    public String lastDateOfCurrentMonth() {
        LocalDate today = LocalDate.now();
        LocalDate lastDayOfCurrentMonth = YearMonth.from(today).atEndOfMonth();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return lastDayOfCurrentMonth.format(formatter);
    }

    public String lastDateOfNextMonth() {
        LocalDate today = LocalDate.now();
        LocalDate lastDayOfNextMonth = YearMonth.from(today).plusMonths(1).atEndOfMonth();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return lastDayOfNextMonth.format(formatter);
    }

    public String lastDateOfCurrMonth() {
        LocalDate today = LocalDate.now();
        LocalDate lastDayOfCurrMonth = YearMonth.from(today).atEndOfMonth();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return lastDayOfCurrMonth.format(formatter);
    }

    public String lastDateOfPriorMonth() {
        LocalDate today = LocalDate.now();
        LocalDate lastDayOfPriorMonth = YearMonth.from(today).minusMonths(1).atEndOfMonth();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        return lastDayOfPriorMonth.format(formatter);
    }

    public String getTodayDate() {// Today
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return date.format(formatter);
    }


    public String getFutureDate(int daysToMove) {
        LocalDate date = LocalDate.now().plusDays(daysToMove);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return date.format(formatter);
    }

    public String getPastDate(int daysToMove) {
        LocalDate date = LocalDate.now().minusDays(daysToMove);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return date.format(formatter);
    }

    public String changeDateFormat(String dateString, String inputFormat, String outputFormat) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat); // e.g., "yyyy-MM-dd"
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat); // e.g., "MM/dd/yyyy"
        LocalDate date = LocalDate.parse(dateString, inputFormatter);

        return date.format(outputFormatter);
    }

    public String changeDateTimeFormat(String dateString, String outputFormat) {
        List<DateTimeFormatter> inputFormatters = List.of(
                new DateTimeFormatterBuilder()
                        .appendPattern("yyyy-MM-dd HH:mm:ss")
                        .optionalStart().appendFraction(ChronoField.NANO_OF_SECOND, 1, 9, true).optionalEnd()
                        .toFormatter(),
                DateTimeFormatter.ofPattern("yyyy-MM-dd")
        );

        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat);

        for (DateTimeFormatter formatter : inputFormatters) {
            try {
                TemporalAccessor parsed = formatter.parse(dateString);
                if (parsed.isSupported(ChronoField.HOUR_OF_DAY)) {
                    return outputFormatter.format(LocalDateTime.from(parsed).toLocalDate());
                } else {
                    return outputFormatter.format(LocalDate.from(parsed));
                }
            } catch (DateTimeParseException ignored) {
            }
        }
        throw new DateTimeParseException("Unable to parse date: " + dateString, dateString, 0);
    }

    public String changeDateFormat(String dateString, String inputFormat, String outputFormat, Locale locale) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputFormat, locale);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputFormat, locale);
        LocalDate date = LocalDate.parse(dateString, inputFormatter);

        return date.format(outputFormatter);
    }

    public String getDateBasedOnRequirement(String dateRequirement) {
        String date;
        if (dateRequirement.contains("Future") || dateRequirement.contains("Past")) {
            String[] parts = dateRequirement.split(" ");
            String dateRequirementPart = parts[0];
            int daysToMove = Integer.parseInt(parts[1]);
            switch (dateRequirementPart) {
                case "Future":
                    date = getFutureDate(daysToMove);
                    break;
                case "Past":
                    date = getPastDate(daysToMove);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + dateRequirementPart);
            }
        } else {
            switch (dateRequirement) {
                case "First Day Of Current Year":
                    date = getFirstOfJanCurrYr();
                    break;
                case "Last Day Of Current Year":
                    date = getLastDayOfCurrYr();
                    break;
                case "First Of Next Month":
                    date = firstDateOfNextMonth();
                    break;
                case "Last Of Next Month":
                    date = lastDateOfNextMonth();
                    break;
                case "Today":
                    date = getTodayDate();
                    break;
                case "Current Date":
                    date = changeDateFormat(getTodayDate(), "MM/dd/yyyy", "yyyy-MM-dd");
                    break;
                case "First Day of Current Month":
                    date = firstDateOfCurrMonth();
                    break;
                case "Current Year":
                    date = getCurrYear();
                    break;
                case "Previous Year":
                    date = getPastYear(1);
                    break;
                case "Previous Previous Year":
                    date = getPastYear(2);
                    break;
                case "First Day Of Next Year":
                    date = getFirstOfJanNextYr();
                    break;
                case "Last Day Of Current Month":
                    date = lastDateOfCurrentMonth();
                    break;
                case "End of May Current Year":
                    date = getCurrYear()+"-05-31";
                    break;
                case "First of May Current Year":
                    date = getCurrYear()+"-05-01";
                    break;
                case "April 10 Current Year":
                    date = getCurrYear()+"-04-10";
                    break;
                case "End of April Current Year":
                    date = getCurrYear()+"-04-30";
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + dateRequirement);
            }
        }
        return date;
    }

    public String endOfMonthDate() {
        LocalDate today = LocalDate.now();
        LocalDate endOfMonth = today.withDayOfMonth(today.lengthOfMonth());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        return endOfMonth.format(formatter);
    }
    public String getMemberIDFromURL() {
        String[] parts = getCurrentUrl().split("/");
        return parts[parts.length - 1];
    }



    public static String getUniqueString(int length) {
        return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");
    }






    public boolean hardRefreshUntilVisible(WebElement element, int timeout, int pollInterval) {
                FluentWait<WebDriver> wait = new FluentWait<>(driver)
                        .withTimeout(Duration.ofSeconds(timeout))
                        .pollingEvery(Duration.ofMillis(pollInterval))
                        .ignoring(NoSuchElementException.class);
        int attempts = 0;
        while (attempts < timeout) {
            try {
                wait.until(driver -> {
                    return (element != null && element.isDisplayed()) ? element : null;
                });
                return true;
            } catch (TimeoutException e) {
                driver.navigate().refresh();
                System.out.println("Element not found, refreshing the page...");
                attempts++;
            }
        }
        System.out.println("Timeout reached, element not found.");
        return false;
    }

    public void validateTimeWithinLast10Minutes(String actualTime) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        dateFormat.setTimeZone(TimeZone.getTimeZone("America/Denver"));

        try {
            Date actualDate = dateFormat.parse(actualTime);
            Date currentDate = new Date();

            SimpleDateFormat currentDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            currentDateFormat.setTimeZone(TimeZone.getTimeZone("America/Denver"));
            String formattedCurrentTime = currentDateFormat.format(currentDate);
            Date currentMountainTime = currentDateFormat.parse(formattedCurrentTime);

            long diffInMillis = currentMountainTime.getTime() - actualDate.getTime();
            long diffInMinutes = diffInMillis / (60 * 1000);

            if (diffInMinutes <= 10) {
                return;
            }
            System.out.println("The time is not within the last 10 minutes.");

        } catch (ParseException e) {
            System.out.println("Error parsing the time: " + e.getMessage());
        }
    
	}

    public String getDateAndTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HH_mm");
        return sdf.format(date);
    }

    public int getAge(String dob) {
        dob = changeDateFormat(dob, "MMddyyyy", "MM/dd/yyyy");
        return Period.between(LocalDate.parse(dob, DateTimeFormatter.ofPattern("MM/dd/yyyy")), LocalDate.now()).getYears();
    }

//    public void setMinor() {
//        List<MemberDetails> allMembers = getAllMem();
//        for (MemberDetails mem : allMembers) {
//            if (getAge(mem.getDob()) < 18) {
//                mem.setIsMinor(true);
//            }
//        }
//    }

    public String formatPhNum(String number) {
        // inputFormat - 1234567890 outputFormat - 123-456-7890
        return number.substring(0, 3) + "-" +
                number.substring(3, 6) + "-" +
                number.substring(6);
    }

    public String formatDob(String dob) {
        // inputFormat - MMddyyyy outputFormat - yyyy-MM-dd
        String formattedDob = "";
        try{
            formattedDob = new SimpleDateFormat("yyyy-MM-dd")
                    .format(new SimpleDateFormat("MMddyyyy").parse(dob));
        } catch(ParseException e){
            Assert.fail();
        }
        return formattedDob;
    }

    public static boolean isPageAtTop(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Long scrollPosition = (Long) js.executeScript("return window.scrollY;");
        System.out.println("Scroll position is "+scrollPosition);
        return scrollPosition <= 60;
    }

    public void pageAtTop() {
        wait(500);
        assertTrue("The page is not at the top.", isPageAtTop(driver));
        System.out.println("The page is at the top.");
    }

    public Boolean clearElementWithRetries(WebElement webElement) {
        Boolean isCleared = false;
        try{
            for (int i = 0; i < 5; i++) {
                webElement.click();
                webElement.clear();
                wait(2000);
                webElement.clear();
                // Use JavaScriptExecutor to clear the field
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].value = '';", webElement);

                if (webElement.getAttribute("value").isEmpty()) {
                    isCleared = true;
                    break; // Exit if the field is cleared
                }
                Thread.sleep(200); // Wait before retrying
            }
        } catch (InterruptedException e){
            Assert.fail();
        }
        return isCleared;
    }

    public static CharSequence generatePhoneNumber(){
        Random rand = new Random();
        int num1 = (rand.nextInt(7)+1)*100;
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);
        DecimalFormat df3 = new DecimalFormat("000");
        DecimalFormat df4 = new DecimalFormat("0000");
        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
        return phoneNumber;
    }


    public String firstDateOfTheMonthAfterNext() {
        LocalDate today = LocalDate.now();
        LocalDate firstDayOfNextMonth = today.plusMonths(2).withDayOfMonth(1);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return firstDayOfNextMonth.format(formatter);
    }

    public String enrollmentStartDate(){
        int actualDate = Integer.parseInt(changeDateFormat(getTodayDate(),"MM/dd/yyyy","dd"));
        if(actualDate<16){
            //if plan purchase date is from 1 to 15 - Next month 1st will be plan start date
            return changeDateFormat(firstDateOfNextMonth(),"yyyy-MM-dd","MM/dd/yyyy");
        }
        else{
            //if plan purchase date is from 16 to 31 - Month after Next 1st will be plan start date
            return changeDateFormat(firstDateOfTheMonthAfterNext(),"yyyy-MM-dd","MM/dd/yyyy");
        }
    }

    public  String getUniqueNumber(int length) {
        return RandomStringUtils.random(length, "123456789");
    }



    public boolean isAscendingOrder(String language, List<String> list) {
        List<String> sortedList = new ArrayList<>(list);

        if(language.equals("Spanish")){
            Collator collator = Collator.getInstance(new Locale("es","ES"));
            collator.setStrength(Collator.IDENTICAL);
            sortedList.sort(collator);
        }
        else {
            Collections.sort(sortedList);
        }
        return  list.equals(sortedList);
    }

    private String lastDownloadedFileName = null; // Track last file to avoid duplicates


    private static File getLatestFile(File dir) {
        File[] files = dir.listFiles();
        if (files == null || files.length == 0) {
            return null; // No files found
        }
        // Sort by last modified, newest file first
        return Arrays.stream(files)
                .filter(File::isFile)
                .max(Comparator.comparingLong(File::lastModified))
                .orElse(null);
    }

    private static boolean isValidFile(File file) {
        return (file.getName().endsWith(".pdf") || file.getName().endsWith(".docx")) && file.length() > 0; // Ensure it's a non-empty PDF or DOCX
    }

    private static boolean isFileDownloadComplete(File file) {
        if (file.getName().endsWith(".crdownload") || file.getName().endsWith(".part")) {
            return false; // Ignore temp files
        }
        long previousSize;
        long currentSize = file.length();
        do {
            previousSize = currentSize;
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return false;
            }
            currentSize = file.length();
        } while (previousSize != currentSize);
        return true;
    }

    public void changeMemberIdInUrlWithRandom() {
        String currentUrl = driver.getCurrentUrl();
        String randomMemberId = String.format("%08d", new Random().nextInt(100000000));
        String newUrl = currentUrl.replaceAll("/\\d+$", "/" + randomMemberId);
        driver.navigate().to(newUrl);
    }
    public boolean isMultipleSelection(WebElement dropdownElement) {
        boolean status;
        Select select=new Select(dropdownElement);
        if (select.isMultiple()) {System.out.println("This select element allows multiple selections.");
            status=true;
        } else {
            System.out.println("This select element allows single selection.");
            status=false;
        }
        return status;
    }
    public String generateRandomStringWithAnyLength(int length) {
        final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        final SecureRandom random = new SecureRandom();
        StringBuilder result = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(CHARACTERS.length());
            result.append(CHARACTERS.charAt(index));
        }
        return result.toString();
    }
    public void sendTextUsingJavaScript(WebElement element,String text) {
        JavascriptExecutor jsExecutor = (JavascriptExecutor) getDriver();
        jsExecutor.executeScript("arguments[0].value = arguments[1];", element, text);
    }
    public String removeCommaAndDollarSignFromAmount(String input){
        String amountWithoutDollarSign = input.replace("$", "");
        // Remove commas
        return amountWithoutDollarSign.replaceAll(",", "");
    }
    public List<WebElement> selectAllOptionsFromDropDown(WebElement selectDrpDwnElement){
        Select select=new Select(selectDrpDwnElement);
        return select.getOptions();
    }
    public WebElement getFirstSelectedOptionFromDD(WebElement selectDrpDwnElement){
        Select select=new Select(selectDrpDwnElement);
        return select.getFirstSelectedOption();
    }
    public void mouseHoverOnElement(WebElement element){
        Actions actions = new Actions(getDriver());
        actions.moveToElement(element).perform();
    }

    public boolean isElementNotDisplayed(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(15));
            wait.until(ExpectedConditions.invisibilityOf(element));
            return true;
        } catch (NoSuchElementException e) {
            return true;
        }
    }

    public void closeChildWindow() {
        String parentWindow = driver.getWindowHandle();
        Set<String> allWindowHandles = getDriver().getWindowHandles();
        for (String childWindow : allWindowHandles) {
            if (!childWindow.equalsIgnoreCase(parentWindow)) {
                getDriver().switchTo().window(childWindow);
                break;
            }
        }
        getDriver().close();
        driver.switchTo().window(parentWindow);
    }
    public int generateRandomDigits(int endBound){ //starting from 0 to given bound
        Random rand = new Random();
        return rand.nextInt(endBound);
    }
}




