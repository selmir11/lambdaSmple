package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.List;
import java.util.Map;

public class EmploymentIncomePage {
    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public EmploymentIncomePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".header-1")
    WebElement hdr_Income;

    @FindBy(css = ".header-2")
    WebElement hdr_EmploymentIncome;

    @FindBy(css = "#ELIG-CocoEmploymentIncomeJob-IncomeJob-container > div.row.label-row.ng-star-inserted > div > label > span")
    WebElement employmentText;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-IncomeJob-YesButton")
    WebElement employmentYesButton;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-IncomeJob-NoButton")
    WebElement employmentNoButton;

    @FindBy(css = "#ELIG-CocoEmploymentIncomeJob-amountInput-container > div.row.label-row.ng-star-inserted > div > label")
    WebElement incomeText;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-amountInput")
    WebElement incomeInput;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-frequencySelect")
    WebElement incomeFrequencyDropdown;

    @FindBy(css = "lib-dropdown option")
    List<WebElement> incomeFrequencyOptions;

    @FindBy(css = "#ELIG-CocoEmploymentIncomeJob-SeasonalIncome-container > div.row.label-row.ng-star-inserted > div > label > span")
    WebElement incomeSeasonalText;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-SeasonalIncome-YesButton")
    WebElement incomeSeasonalYesButton;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-SeasonalIncome-NoButton")
    WebElement incomeSeasonalNoButton;

    @FindBy(css = "#ELIG-CocoEmploymentIncomeJob-IncomeChangeEveryYear-container > div.row.label-row.ng-star-inserted > div > label > span")
    WebElement incomeChangesText;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-IncomeChangeEveryYear-YesButton")
    WebElement incomeChangesYesButton;

    @FindBy(id = "ELIG-CocoEmploymentIncomeJob-IncomeChangeEveryYear-NoButton")
    WebElement incomeChangesNoButton;

    @FindBy(id = "EmploymentIncomeJob-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(css = ".input-error-message")
    WebElement errorMessage;

    @FindBy(css = ".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(css = "#EmploymentIncomeJob-GoBack")
    WebElement goBackButton;

    @FindBy(id = "logo-image")
    WebElement connectLogoLink;

    @FindBy(css = ".toolbar-content .username")
    WebElement userNameLink;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBePresent(saveAndContinueButton, 30);
        basicActions.click(saveAndContinueButton);
    }

    public void clickGoBackButton() {
        basicActions.waitForElementToBePresent(goBackButton, 30);
        basicActions.click(goBackButton);
    }

    public void answerEmploymentQs(String employment) {
        basicActions.waitForElementToDisappear(spinner, 40);
        switch (employment) {
            case "Yes":
                basicActions.waitForElementToBePresent(employmentYesButton, 100);
                employmentYesButton.click();
                break;
            case "No":
                basicActions.waitForElementToBePresent(employmentNoButton, 100);
                employmentNoButton.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + employment);
        }
    }

    public void enterIncomeAmount(String amountOfIncome) {
        basicActions.waitForElementToBePresent(incomeInput, 10);
        incomeInput.sendKeys(amountOfIncome);
    }

    public void selectIncomeFrequency(String frequencyOfIncome) {
        basicActions.waitForElementToBePresent(incomeFrequencyDropdown, 10);
        incomeFrequencyDropdown.click();

        basicActions.waitForElementListToBePresent(incomeFrequencyOptions, 10);
        switch (frequencyOfIncome) {
            case "Select Option":
                incomeFrequencyOptions.get(0).click();
                break;
            case "Annually":
                incomeFrequencyOptions.get(1).click();
                break;
            case "Every 2 weeks":
                incomeFrequencyOptions.get(2).click();
                break;
            case "Monthly":
                incomeFrequencyOptions.get(3).click();
                break;
            case "Twice a month":
                incomeFrequencyOptions.get(4).click();
                break;
            case "Weekly":
                incomeFrequencyOptions.get(5).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + frequencyOfIncome);
        }
    }

    public void answerIsIncomeSeasonalQs(String seasonal) {
        switch (seasonal) {
            case "Yes":
                basicActions.waitForElementToBePresent(incomeSeasonalYesButton, 10);
                incomeSeasonalYesButton.click();
                break;
            case "No":
                basicActions.waitForElementToBePresent(incomeSeasonalNoButton, 10);
                incomeSeasonalNoButton.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + seasonal);
        }
    }

    public void answerIncomeChangesQs(String changes) {
        switch (changes) {
            case "Yes":
                basicActions.waitForElementToBePresent(incomeChangesYesButton, 10);
                incomeChangesYesButton.click();
                break;
            case "No":
                basicActions.waitForElementToBePresent(incomeChangesNoButton, 10);
                incomeChangesNoButton.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + changes);
        }
    }

    //////////////////////////////////////////////VALIDATION METHODS//////////////////////////////////////////////////
    public void verifyHeadersEmploymentIncomePage(String language) {
        switch (language) {
            case "English":
                verifyHeadersEmploymentIncomePageEnglish();
                break;
            case "Spanish":
                verifyHeadersEmploymentIncomePageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersEmploymentIncomePageEnglish() {
        basicActions.waitForElementToBePresent(hdr_Income, 15);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Income: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_Income.getCssValue("font-size"), "36px");
        softAssert.assertEquals(hdr_Income.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_Income.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(hdr_EmploymentIncome.getText(), "Employment Income (Please include income from all jobs and employers.)");
        softAssert.assertEquals(hdr_EmploymentIncome.getCssValue("font-size"), "28px");
        softAssert.assertEquals(hdr_EmploymentIncome.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_EmploymentIncome.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
    }

    public void verifyHeadersEmploymentIncomePageSpanish() {
        basicActions.waitForElementToBePresent(hdr_Income, 50);
        basicActions.waitForElementToBePresent(hdr_EmploymentIncome, 50);
        softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Ingresos: " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName()));
        softAssert.assertEquals(hdr_Income.getCssValue("font-size"), "36px");
        softAssert.assertEquals(hdr_Income.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_Income.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(hdr_EmploymentIncome.getText(), "Ingresos por empleo (Incluya el ingreso que recibe de todos los trabajos y empleadores.)");
        softAssert.assertEquals(hdr_EmploymentIncome.getCssValue("font-size"), "28px");
        softAssert.assertEquals(hdr_EmploymentIncome.getCssValue("font-weight"), "700");
        softAssert.assertEquals(hdr_EmploymentIncome.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
    }

    public void verifyAdditionalMemberHeadersOnEmploymentIncomeCoCoPage(String language) {
        basicActions.waitForElementToBePresent(hdr_Income, 50);
        switch (language) {
            case "English":
                softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Income: " + basicActions.getFullNameWithPrefix("Spouse")));
                softAssert.assertEquals(hdr_Income.getCssValue("font-size"), "36px");
                softAssert.assertEquals(hdr_Income.getCssValue("font-weight"), "700");
                softAssert.assertEquals(hdr_Income.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(hdr_EmploymentIncome.getText(), "Employment Income (Please include income from all jobs and employers.)");
                softAssert.assertEquals(hdr_EmploymentIncome.getCssValue("font-size"), "28px");
                softAssert.assertEquals(hdr_EmploymentIncome.getCssValue("font-weight"), "700");
                softAssert.assertEquals(hdr_EmploymentIncome.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(hdr_EmploymentIncome, 50);
                softAssert.assertTrue(hdr_Income.getText().equalsIgnoreCase("Ingresos: " + basicActions.getFullNameWithPrefix("Spouse")));
                softAssert.assertEquals(hdr_Income.getCssValue("font-size"), "36px");
                softAssert.assertEquals(hdr_Income.getCssValue("font-weight"), "700");
                softAssert.assertEquals(hdr_Income.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(hdr_EmploymentIncome.getText(), "Ingresos por empleo (Incluya el ingreso que recibe de todos los trabajos y empleadores.)");
                softAssert.assertEquals(hdr_EmploymentIncome.getCssValue("font-size"), "28px");
                softAssert.assertEquals(hdr_EmploymentIncome.getCssValue("font-weight"), "700");
                softAssert.assertEquals(hdr_EmploymentIncome.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyNoErrorMessage_EmploymentInfo() {
        softAssert.assertFalse(basicActions.waitForElementPresence(errorMessage, 20));
        softAssert.assertAll();
    }

    public void verifyJobOption_EmploymentInfo(String isEmployed) {
        switch (isEmployed) {
            case "Yes":
                basicActions.waitForElementToBePresent(employmentYesButton, 15);
                softAssert.assertTrue(employmentYesButton.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(employmentNoButton, 15);
                softAssert.assertTrue(employmentNoButton.getAttribute("class").contains("selected"));
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + isEmployed);
        }
    }

    public void validateCoCoEmploymentIncomeText(String language) {
        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(employmentText, 15);
                softAssert.assertEquals(employmentText.getText(), "Do you have a job or are you currently employed?");
                softAssert.assertEquals(incomeText.getText(), "What is your total income? Include commission or tips earned.");
                softAssert.assertEquals(incomeSeasonalText.getText(), "Is this income self-employment income or part of seasonal, commission or tip-based work?");
                softAssert.assertEquals(incomeChangesText.getText(), "Does your income change during the year or from year to year?");
                softAssert.assertAll();
                verifyBaseTextFormatting(employmentText);
                verifyBaseTextFormatting(incomeText);
                verifyBaseTextFormatting(incomeSeasonalText);
                verifyBaseTextFormatting(incomeChangesText);
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(employmentText, 15);
                softAssert.assertEquals(employmentText.getText(), "\u00bfTiene un trabajo o empleo actualmente?");
                softAssert.assertEquals(incomeText.getText(), "\u00bfCu\u00e1l es su ingreso total? Incluya comisiones o propinas ganadas.");
                softAssert.assertEquals(incomeSeasonalText.getText(), "\u00bfEstos ingresos son por trabajo independiente o forman parte de un empleo temporal, por comisi\u00f3n o por propinas?");
                softAssert.assertEquals(incomeChangesText.getText(), "\u00bfSus ingresos cambian durante el a\u00f1o o de un a\u00f1o a otro?");
                softAssert.assertAll();
                verifyBaseTextFormatting(employmentText);
                verifyBaseTextFormatting(incomeText);
                verifyBaseTextFormatting(incomeSeasonalText);
                verifyBaseTextFormatting(incomeChangesText);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);

        }
    }

    public void verifyIncomeFrequencyOptionsCoCo(String language) {
        basicActions.waitForElementToBePresent(hdr_Income, 15);
        switch (language) {
            case "English":
                softAssert.assertEquals(incomeFrequencyOptions.get(0).getText(), "Select Option");
                softAssert.assertEquals(incomeFrequencyOptions.get(1).getText(), "Annually");
                softAssert.assertEquals(incomeFrequencyOptions.get(2).getText(), "Every 2 weeks");
                softAssert.assertEquals(incomeFrequencyOptions.get(3).getText(), "Monthly");
                softAssert.assertEquals(incomeFrequencyOptions.get(4).getText(), "Twice a month");
                softAssert.assertEquals(incomeFrequencyOptions.get(5).getText(), "Weekly");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(incomeFrequencyOptions.get(0).getText(), "Seleccionar opci\u00f3n");
                softAssert.assertEquals(incomeFrequencyOptions.get(1).getText(), "Anualmente");
                softAssert.assertEquals(incomeFrequencyOptions.get(2).getText(), "Cada dos semanas");
                softAssert.assertEquals(incomeFrequencyOptions.get(3).getText(), "Mensualmente");
                softAssert.assertEquals(incomeFrequencyOptions.get(4).getText(), "Dos veces por mes");
                softAssert.assertEquals(incomeFrequencyOptions.get(5).getText(), "Semanalmente");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyEmploymentIncomeNavigationButtonsCoCo(String language) {
        basicActions.waitForElementToBePresent(hdr_Income, 15);
        switch (language) {
            case "English":
                softAssert.assertEquals(goBackButton.getText(), "  Go back");
                softAssert.assertEquals(goBackButton.getCssValue("font-weight"), "700");
                softAssert.assertEquals(goBackButton.getCssValue("font-size"), "20px");
                softAssert.assertEquals(goBackButton.getCssValue("line-height"), "32px");
                softAssert.assertEquals(goBackButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
                softAssert.assertEquals(goBackButton.getCssValue("background-color"), "rgba(255, 255, 255, 1)");
                softAssert.assertEquals(saveAndContinueButton.getText(), "Save and continue");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("font-weight"), "700");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("font-size"), "20px");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("line-height"), "32px");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("color"), "rgba(255, 255, 255, 1)");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("background-color"), "rgba(26, 112, 179, 1)");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(goBackButton.getText(), "  Volver");
                softAssert.assertEquals(goBackButton.getCssValue("font-weight"), "700");
                softAssert.assertEquals(goBackButton.getCssValue("font-size"), "20px");
                softAssert.assertEquals(goBackButton.getCssValue("line-height"), "32px");
                softAssert.assertEquals(goBackButton.getCssValue("color"), "rgba(26, 112, 179, 1)");
                softAssert.assertEquals(goBackButton.getCssValue("background-color"), "rgba(255, 255, 255, 1)");
                softAssert.assertEquals(saveAndContinueButton.getText(), "Guardar y continuar");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("font-weight"), "700");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("font-size"), "20px");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("line-height"), "32px");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("color"), "rgba(255, 255, 255, 1)");
                softAssert.assertEquals(saveAndContinueButton.getCssValue("background-color"), "rgba(26, 112, 179, 1)");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyBaseTextFormatting(WebElement BaseText) {
        softAssert.assertEquals(BaseText.getCssValue("font-weight"), "400");
        softAssert.assertEquals(BaseText.getCssValue("font-size"), "16px");
        softAssert.assertEquals(BaseText.getCssValue("line-height"), "28px");
        softAssert.assertEquals(BaseText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertAll();
    }

    public void verifyPageNavigation(DataTable dataTable) {
        basicActions.waitForElementToDisappear(spinner, 10);
        basicActions.waitForElementToBePresent(saveAndContinueButton, 10);

        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);

        // Iterate over each row in the DataTable
        for (Map<String, String> row : data) {
            String hyperlinkText = row.get("HyperLinkText");
            String expectedPageTitle = row.get("ExpectedPageTitle");
            String containsUrl = row.get("ContainsUrl");
            WebElement hyperlink;

            if (hyperlinkText.equalsIgnoreCase("CoCo Logo")) {
                hyperlink =connectLogoLink;
            } else if (hyperlinkText.equalsIgnoreCase("UserName")) {
                hyperlink = userNameLink;
            }else {
                hyperlink = basicActions.getDriver().findElement(By.partialLinkText(hyperlinkText));
            }

            //Creating new tab with [Ctrl+Click] and change focus to the new tab
            Actions actionKey = new Actions(basicActions.getDriver());
            actionKey.keyDown(Keys.CONTROL).click(hyperlink).keyUp(Keys.CONTROL).build().perform();
            basicActions.switchtoactiveTab();
            basicActions.waitForElementToDisappear(spinner, 20);

            //Assertion
            String actualTitle = basicActions.getDriver().getTitle();
            String currentUrl = basicActions.getDriver().getCurrentUrl();
            softAssert.assertEquals(actualTitle, expectedPageTitle);
            softAssert.assertTrue(currentUrl.contains(containsUrl));
            softAssert.assertAll();

            //Close the new tab and change focus to the existing tab
            basicActions.getDriver().close();
            basicActions.switchtoPreviousTab();
        }
    }
}