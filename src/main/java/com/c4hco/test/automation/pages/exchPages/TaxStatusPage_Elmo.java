package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class TaxStatusPage_Elmo {
    private BasicActions basicActions;
    public TaxStatusPage_Elmo(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    Actions actions = new Actions(WebDriverManager.getDriver());

    SoftAssert softAssert = new SoftAssert();

    @FindBy(css = ".container .header-1")
    WebElement existingTaxStatusHeader;

    @FindBy(css = "lib-checkbox-control label")
    List<WebElement> checkboxContainersTax;

    @FindBy(css = "lib-checkbox-control button")
    List<WebElement> checkboxesTax;

    @FindBy(id = "ELIG-taxStatus-claimedAsDependent-yesButton")
    WebElement claimedAsDependentYes;

    @FindBy(id = "ELIG-taxStatus-claimedAsDependent-noButton")
    WebElement claimedAsDependentNo;

    @FindBy(id = "ELIG-taxStatus-willFile-yesButton")
    WebElement willFileTaxReturnYes;

    @FindBy(id = "ELIG-taxStatus-willFile-noButton")
    WebElement willFileTaxReturnNo;

    @FindBy(css = ".c4-input select option")
    List<WebElement> filingStatusDpd;

    @FindBy(id = "ELIG-taxStatus-willClaimDependents-yesButton")
    WebElement willClaimDependentsYes;

    @FindBy(id = "ELIG-taxStatus-willClaimDependents-noButton")
    WebElement willClaimDependentsNo;
    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-container input")
    List<WebElement> filingJointlyWithRadio;

    @FindBy(id = "ELIG-taxStatus-nav-SaveAndContinue")
    WebElement saveAndContinueBtn;

    public void selectClaimedAsDependent(String claimedAsDependent){
        switch (claimedAsDependent) {
            case "Yes":
                basicActions.waitForElementToBeClickable(claimedAsDependentYes, 20);
                basicActions.click(claimedAsDependentYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(claimedAsDependentNo, 20);
                basicActions.click(claimedAsDependentNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + claimedAsDependent);
        }
    }

    public void selectWillFileTaxReturn(String willFile){
        switch (willFile) {
            case "Yes":
                basicActions.waitForElementToBeClickable(willFileTaxReturnYes, 20);
                basicActions.click(willFileTaxReturnYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(willFileTaxReturnNo, 20);
                basicActions.click(willFileTaxReturnNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + willFile);
        }
    }

    public void selectFilingStatus(String option) {
        basicActions.waitForElementListToBePresent(filingStatusDpd, 50);

        switch (option) {
            case "Select Option":
                filingStatusDpd.get(0).click();
                break;
            case "Married filing jointly":
                filingStatusDpd.get(1).click();
                break;
            case "Married filing single":
                filingStatusDpd.get(2).click();
                break;
            case "Head of household":
                filingStatusDpd.get(3).click();
                break;
            case "Single":
                filingStatusDpd.get(4).click();
                break;
            case "Qualified widow(er)":
                filingStatusDpd.get(5).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
    }

public void selectFilingJointlyWithOption(String filingJointlyOption) {
    basicActions.waitForElementListToBePresent(filingJointlyWithRadio, 50);

    switch (filingJointlyOption) {
        case "Spouse":
            filingJointlyWithRadio.get(0).click();
            break;
        case "Someone else":
            filingJointlyWithRadio.get(1).click();
            break;
        default:
            throw new IllegalArgumentException("Invalid option: " + filingJointlyOption);
    }
}

    public void selectWillClaimDependents(String willFile){
        switch (willFile) {
            case "Yes":
                basicActions.waitForElementToBeClickable(willClaimDependentsYes, 20);
                basicActions.click(willClaimDependentsYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(willClaimDependentsNo, 20);
                basicActions.click(willClaimDependentsNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + willFile);
        }
    }

    public void clickSaveAndContinue(){
        basicActions.waitForElementToBePresentWithRetries(existingTaxStatusHeader, 40);
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueBtn, 20);
        basicActions.scrollToElement(saveAndContinueBtn);
        saveAndContinueBtn.click();
    }


    /////////////////////////////////// Validation methods ///////////////////////////////////

    public void verifyTaxCheckboxes(String state){
        switch (state){
            case "Selected":
                verifySelectedStateOfCheckboxes();
                break;
            case "Hover":
                verifyHoverStateOfCheckboxes();
                break;
            case "Focus":
                verifyFocusStateOfCheckboxes();
                break;
            case "Not Selected":
                verifyNotSelectedStateOfCheckboxesCOCO();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + state);
        }
    }

    public void verifyNotSelectedStateOfCheckboxesCOCO() {
        basicActions.waitForElementListToBePresent(checkboxesTax, 15);
        for (int i = 0; i < checkboxesTax.size(); i++) {
            WebElement element1 = checkboxesTax.get(i);
            WebElement element2 = checkboxContainersTax.get(i);
            basicActions.wait(100);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container"));
            softAssert.assertEquals(element1.getCssValue("width"), "32px");
            softAssert.assertEquals(element1.getCssValue("height"), "32px");
            softAssert.assertEquals(element1.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element1.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element1.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element1.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element1.getCssValue("border"), "1px solid rgb(55, 55, 55)");
            softAssert.assertAll();
            element1.click();
            basicActions.wait(100);
        }
    }

    public void verifyFocusStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(checkboxesTax, 15);
        for (int i = 0; i < checkboxesTax.size(); i++) {
            WebElement element = checkboxesTax.get(i);
            element.sendKeys(Keys.SHIFT);
            basicActions.wait(200);
            softAssert.assertEquals(element.getCssValue("width"), "32px");
            softAssert.assertEquals(element.getCssValue("height"), "32px");
            softAssert.assertEquals(element.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertEquals(element.getCssValue("box-shadow"), "rgb(112, 163, 0) 0px 0px 7px 3px");
            softAssert.assertAll();
            element.click();
            basicActions.wait(200);
        }
    }

    public void verifyHoverStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(checkboxesTax, 15);
        for (int i = 0; i < checkboxesTax.size(); i++) {
            WebElement element = checkboxesTax.get(i);
            actions.moveToElement(element).perform();
            basicActions.wait(300);
            softAssert.assertEquals(element.getCssValue("width"), "32px");
            softAssert.assertEquals(element.getCssValue("height"), "32px");
            softAssert.assertEquals(element.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertAll();
            element.click();
            basicActions.wait(300);
        }
    }

    public void verifySelectedStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(checkboxesTax, 15);
        for (int i = 0; i < checkboxesTax.size(); i++) {
            WebElement element1 = checkboxesTax.get(i);
            WebElement element2 = checkboxContainersTax.get(i);
            element1.click();
            basicActions.wait(200);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container checked"));
            softAssert.assertEquals(element1.getCssValue("width"), "32px");
            softAssert.assertEquals(element1.getCssValue("height"), "32px");
            softAssert.assertEquals(element1.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element1.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element1.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertEquals(element1.getCssValue("background-color"), "rgba(112, 163, 0, 1)");
            softAssert.assertEquals(element1.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element1.getCssValue("border"), "1px solid rgb(112, 163, 0)");
            softAssert.assertAll();
            basicActions.wait(200);
        }
    }
}
