package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class ApplicationSummaryPage {

    SoftAssert softAssert = new SoftAssert();

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;
    @FindBy(id = "editBasicInfo")
    WebElement editBasicInfoButton;
    @FindBy(id = "submitButton_Income")
    WebElement editIncome;
    @FindBy(css = ":nth-child(21) b")
    WebElement existingHealthInsuranceLabel;
    @FindBy(css = ":nth-child(21) div div")
    WebElement existingHealthInsuranceData;
    @FindBy(css = "#submitButton")
    WebElement backButton;

    @FindBy(xpath = "//td[normalize-space()='Projected Income']//following::td[1]")
    WebElement txtProjectedIncome;

    @FindBy(xpath = "//td[normalize-space()='Projected Income']//following::td[6]")
    WebElement txtProjectedIncome2;

    @FindBy(xpath = "//*[@id='doubleAccord-fin0']")
    WebElement finacnceDropdown;

    private BasicActions basicActions;

    public ApplicationSummaryPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()),this);
    }

    public void clickEditBasicLink(){
        basicActions.waitForElementToBePresent(editBasicInfoButton, 30);
        basicActions.scrollToElement(editBasicInfoButton);
        editBasicInfoButton.click();
    }
    public void clickEditIncomelink(){
        basicActions.waitForElementToDisappear( spinner, 60 );
        basicActions.waitForElementToBePresentWithRetries( editIncome, 40);
        basicActions.scrollToElement(editIncome);
        editIncome.click();
    }

    public void clickBackButton(){
        basicActions.waitForElementToBePresent(backButton,20);
        backButton.click();
    }




    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line

    public void verifyExistingHealthInsurance(String OhcData, String language){
        basicActions.waitForElementToBePresent(existingHealthInsuranceLabel, 30);
        String expectedText = switch (language.toLowerCase()) {
            case "spanish" -> "Seguro de salud existente:";
            default -> "Existing health insurance:";
        };
        softAssert.assertEquals(existingHealthInsuranceLabel.getText(), expectedText);
        softAssert.assertEquals(existingHealthInsuranceData.getText(), OhcData);
        softAssert.assertAll();
    }

    public void verifyProjectedIncome(String member, String income){
        basicActions.waitForElementToBePresent(finacnceDropdown, 50);
        finacnceDropdown.click();
        switch (member) {
            case "primary":
                basicActions.waitForElementToBePresent(txtProjectedIncome, 30);
                softAssert.assertEquals(txtProjectedIncome.getText(),income);
                softAssert.assertAll();
                break;
            case "primaryandspouse":
                basicActions.waitForElementToBePresent(txtProjectedIncome, 30);
                softAssert.assertEquals(txtProjectedIncome.getText(),income);
                basicActions.waitForElementToBePresent(txtProjectedIncome2, 30);
                softAssert.assertEquals(txtProjectedIncome2.getText(),income);
                softAssert.assertAll();
                break;
            default:
                Assert.fail("Invalid argument passed!!");
        } }  }
