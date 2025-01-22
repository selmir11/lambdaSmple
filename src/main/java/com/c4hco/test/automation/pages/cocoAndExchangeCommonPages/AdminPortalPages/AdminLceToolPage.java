package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AdminLceToolPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    private ArrayList<String> tabs;

    public AdminLceToolPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "accountId")
    WebElement adminLCEToolAccountIdInput; // Admin LCE Tool PAGE

    @FindBy(id = "submitButton")
    WebElement lookUpBtn;

    @FindBy(css = ".panel-body #adminLceSubmit")
    WebElement lookUpSearchResults;

    @FindBy(id = "planYear")
    WebElement planYrDropdown;

    @FindBy(css = "#planYear option")
    List<WebElement> planYrDrpdwnOptions; // includes default text and years

    @FindBy(id = "changeEffDate")
    WebElement changeEffectiveDt;

    @FindBy(id = "addAdminButton")
    WebElement submitBtn;
    @FindBy(css = "#heading, body > div.outer-container > div.container > h1")
    WebElement titleAdminLceTool;
    @FindBy(xpath = "//b[normalize-space()='Account Number']")
    WebElement acctNumberLceTool;
    @FindBy(css = "#header-user span:nth-child(3)")
    WebElement dropdownArrow;
    @FindBy(id = "logout-link")
    WebElement logoutAdmin;

    //new admin LCE - Expected release date in QA is mid Feb
    @FindBy(xpath = "//strong[normalize-space()='Admin LCE Portal']")
    WebElement adminLCEPortalTitle;

    @FindBy(id = "heading")
    WebElement adminLCEHeading;

    @FindBy(xpath = "//input[@type='text']")
    WebElement adminLCEAccountInput;

    @FindBy(xpath = "//button[normalize-space()='Look Up']")
    WebElement lookUpButton;

    @FindBy(xpath = "//div[@class='select-info']")
    WebElement selectPlanYearMessage;

    @FindBy(xpath = "//app-admin-lce-portal[1]/div[1]/div[1]/div[2]/div[2]/div[3]/div[1]/span[1]")
    WebElement currentYear;

    @FindBy(xpath = "//span[@class = 'plan-year']")
    List<WebElement> planYears;

    @FindBy(xpath = "//div//div//span//span//*[name()='svg']")
    List<WebElement> appDataDropdowns;

    @FindBy(css = ".plan-body.active")
    List<WebElement> appDatatext;

    @FindBy(xpath = "//h4[@id='modal-header-title']")
    WebElement confirmChangeEffectiveDateTitle;

    @FindBy(xpath = "//p[@id='modal-body-text']")
    WebElement confirmChangemessage;

    @FindBy(xpath = "//input[@id='effective-date']")
    WebElement dateInputField;

    @FindBy(id = "go-back-btn")
    WebElement goBackButton;

    @FindBy(id = "confirm-btn")
    WebElement confirmButton;
    @FindBy(id = "modal-content")
    List<WebElement> modals;

    @FindBy(id = "planYear")
    WebElement planYearrDrpdwnOptions;


    public void lookUpAccId() {
        tabs = new ArrayList<>(basicActions.getDriver().getWindowHandles());
        basicActions.getDriver().switchTo().window(tabs.get(1));
        softAssert.assertEquals(basicActions.getCurrentUrl().contains("adminLce"), true);
        softAssert.assertAll();
        basicActions.waitForElementToBePresent(adminLCEToolAccountIdInput, 10);
        System.out.println("Account ID ::" + SharedData.getPrimaryMember().getAccount_id());
        adminLCEToolAccountIdInput.sendKeys(String.valueOf(SharedData.getPrimaryMember().getAccount_id()));
        lookUpBtn.click();
        // validate look up returned results
        basicActions.waitForElementToBePresent(lookUpSearchResults, 10);
    }

    public void validatePlanYearOptions() {
        basicActions.waitForElementToBePresent(planYrDropdown, 10);

        int currentYear = Year.now().getValue();
        List<String> expectedOptions = List.of("Select Option", String.valueOf(currentYear), String.valueOf(currentYear - 1), String.valueOf(currentYear - 2), String.valueOf(currentYear - 3));

        planYrDropdown.click();
        Select dropdown = new Select(planYrDropdown);
        basicActions.waitForElementListToBePresent(dropdown.getOptions(), 10);
        List<String> actualOptions = dropdown.getOptions().stream().map(WebElement::getText).collect(Collectors.toList());

        Assert.assertEquals(actualOptions, expectedOptions, "Plan Year options in the dropdown did not match");
    }

    public void changeEffectiveDate(String effectiveDate, String planYear) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
        basicActions.waitForElementToBePresent(planYrDropdown, 10);
        planYrDropdown.click();

        selectPlanYear(planYear);

        changeEffectiveDt.sendKeys(effectiveDate);
        submitBtn.click();
        basicActions.waitForElementToDisappear(lookUpSearchResults, 10);

        SharedData.setPrimaryMember(subscriber);

        closeTabAndSwitchToCurrentWindow();
    }

    private void selectPlanYear(String planYear) {
        switch (planYear) {
            case "current year":
                planYrDrpdwnOptions.get(1).click(); // selects current year
                break;
            case "last available year":
                planYrDrpdwnOptions.get(4).click(); // selects current year minus 3 years
                SharedData.setPlanYear(String.valueOf(Year.now().getValue() - 3));
                break;
            default:
                Assert.fail("Invalid argument passed");
        }

    }

    public void closeTabAndSwitchToCurrentWindow() {
        // TO DO: Check if this can be made re-usable by moving it to basicActions.
        basicActions.closeBrowserTab();
        basicActions.getDriver().switchTo().window(tabs.get(0));
    }

    public void verifyAdminLceContainerTitle() {
        titleAdminLceTool.isDisplayed();
        softAssert.assertEquals(titleAdminLceTool.getText(), "Admin LCE Tool");
        softAssert.assertTrue(acctNumberLceTool.isDisplayed());
        softAssert.assertAll();
    }

    public void logoutFromAdminLce() {
        basicActions.switchToParentPage("C4HCO Admin Portal");
        basicActions.waitForElementToBePresent(dropdownArrow, 100);
        dropdownArrow.click();
        basicActions.waitForElementToBePresent(logoutAdmin, 100);
        logoutAdmin.click();
    }

    public void initiateIncomingPage() {
        basicActions.switchtoactiveTab();
    }

    //new Admin LCE page functions below - expected to release in QA mid Feb//

    public void navigatetoLCE() {
        basicActions.getDriver().navigate().to("https://qa-aws.connectforhealthco.com/admin-lce-portal/");
    }

    public void verifyAdminLceTitle() {
        adminLCEPortalTitle.isDisplayed();
        softAssert.assertEquals(adminLCEPortalTitle.getText(), "Admin LCE Portal");
        adminLCEHeading.isDisplayed();
        softAssert.assertEquals(adminLCEHeading.getText(), "Admin LCE");
        softAssert.assertAll();
    }

    public void enterAccountIdToAnyENV(String accountIdSTG, String accountIdQA) {
        basicActions.wait(2000);
        if (SharedData.getEnv().equals("staging")) {
            adminLCEAccountInput.sendKeys(accountIdSTG);
        } else {
            adminLCEAccountInput.sendKeys(accountIdQA);
        }
    }

    public void clickLookUpButton() {
        lookUpButton.isDisplayed();
        softAssert.assertEquals(lookUpButton.getText(), "Look Up");
        softAssert.assertAll();
        lookUpButton.click();
    }

    public void validateSelectPlanYearMessage() {
        selectPlanYearMessage.isDisplayed();
        softAssert.assertEquals(selectPlanYearMessage.getText(), "Select plan year to edit");
        softAssert.assertAll();
    }

    public void verifyapplicationyearsData() {
        WebElement firstYearElement = currentYear;
        String firstYearText = firstYearElement.getText();

        String[] splitText = firstYearText.split(" ");

        String yearString = splitText[splitText.length - 1].trim();

        int firstYear = Integer.parseInt(yearString);

        List<Integer> expectedPlanYears = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            expectedPlanYears.add(firstYear - i);
        }

        List<WebElement> displayedPlanYearsElements = planYears;

        List<Integer> displayedPlanYears = new ArrayList<>();
        for (WebElement planYearElement : displayedPlanYearsElements) {
            String planYearText = planYearElement.getText().trim();
            String[] splitText1 = planYearText.split(" ");
            String yearString1 = splitText1[splitText1.length - 1].trim();

            int year = Integer.parseInt(yearString1);
            displayedPlanYears.add(year);
        }

        softAssert.assertEquals(displayedPlanYears, expectedPlanYears, "Plan years not match");

    }

    public void clickAppDataDropdown() {
        basicActions.waitForElementListToBePresent(appDataDropdowns, 30);
        for (WebElement option : appDataDropdowns) {
            int i = 0;
            option.click();
            basicActions.isElementDisplayed(appDatatext.get(i), 30);
        }
    }

    public void validateMessage() {
        String expectedMessage = "There is no application data for this year.";
        boolean messageFound = appDatatext.stream()
                .filter(element -> element != null)
                .anyMatch(element -> element.getText().trim().contains(expectedMessage));
        softAssert.assertTrue(messageFound, "Expected message not found in any of the elements.");
    }

    public void clickRecreateApplicationLink(int planYear, int linkIndex) {
        String createlink = String.format("//*[@id='planYearLabel_%d']//following::*[starts-with(@id, 'recreateLink_')][%d]", planYear, linkIndex);
        basicActions.getDriver().findElement(By.xpath(createlink)).click();
    }

    public void confirmEffectiveDatePopUp() {
        basicActions.waitForElementToBePresent(confirmChangeEffectiveDateTitle, 30);
        softAssert.assertEquals(confirmChangeEffectiveDateTitle.getText(), "Confirm change effective dates");
        softAssert.assertEquals(confirmChangemessage.getText(), "You have chosen to recreate and make corrections to the application from Plan Year 2025. Please enter the date the changes will become effective and select confirm to begin.");
        softAssert.assertAll();
    }

    public void enterDate(String endDate) {
        String formattedDate = basicActions.getDateBasedOnRequirement(endDate);
        dateInputField.sendKeys(formattedDate);
    }

    public void clickConfirmButton(){
    basicActions.waitForElementToBePresent(confirmButton, 30);
    confirmButton.click();
}
    public void clickGoBackButton() {
        basicActions.waitForElementToBePresent(goBackButton, 50);
        goBackButton.click();
        softAssert.assertTrue(modals.isEmpty());
        softAssert.assertAll();
    }

    public void currentDateAsLCEDate(){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        planYearrDrpdwnOptions.click();
        Select select = new Select(planYearrDrpdwnOptions);
        select.selectByVisibleText(SharedData.getPlanYear());
        changeEffectiveDt.sendKeys(basicActions.changeDateFormat(basicActions.getTodayDate(),"MM/dd/yyyy","MM/dd"));
        submitBtn.click();
        basicActions.waitForElementToDisappear(lookUpSearchResults, 10);
        SharedData.setPrimaryMember(subscriber);
        closeTabAndSwitchToCurrentWindow();
    }
}



