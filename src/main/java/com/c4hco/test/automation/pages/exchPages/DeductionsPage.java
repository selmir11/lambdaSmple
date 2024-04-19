package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DeductionsPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public DeductionsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "app-deductions .additional-income-row button")
    List<WebElement> addtlDeductionOptionsCheckbox;

    @FindBy(id = "ELIG-Deductions-AOSS-amountInput")
    WebElement txtAOSSAmount;

    @FindBy(id = "ELIG-Deductions-AOSS-frequencySelect")
    WebElement selectAOSSFrequency;

    @FindBy(id = "ELIG-Deductions-PRAC-amountInput")
    WebElement txtPRACAmount;

    @FindBy(id = "ELIG-Deductions-PRAC-frequencySelect")
    WebElement selectPRACFrequency;

    @FindBy(id = "ELIG-Deductions-SETX-amountInput")
    WebElement txtSETXAmount;

    @FindBy(id = "ELIG-Deductions-SETX-frequencySelect")
    WebElement selectSETXFrequency;

    @FindBy(css = ".monetary-input-container input")
    List<WebElement> deductionsAmount;

    @FindBy(css = ".col .form-select")
    List<WebElement> deductionsFrequency;

    @FindBy(css = "lib-list-error .error-message")
    WebElement deductionsSelectError;

    @FindBy(css = "lib-input .row.error-row")
    List<WebElement> deductionsAmountError;

    @FindBy(css = "lib-dropdown .row.error-row")
    List<WebElement> deductionsFrequencyError;

    @FindBy(id = "Deductions-SaveAndContinue")
    WebElement saveAndContinueBtn;

    public void selectAddtlDeductionOption(String addtlDeductionOption, String Amount, String Frequency){
        switch(addtlDeductionOption){
            case "Alimony or spousal support paid out":
                addtlDeductionOptionsCheckbox.get(0).click();
                basicActions.waitForElementToBeClickable(txtAOSSAmount, 10);
                txtAOSSAmount.sendKeys(Amount);

                Select dropdown = new Select(selectAOSSFrequency);
                dropdown.selectByVisibleText(" "+Frequency+" ");
                break;
            case "Pre-tax retirement account contribution":
                basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 10);
                addtlDeductionOptionsCheckbox.get(3).click();
                txtPRACAmount.sendKeys(Amount);

                Select dropdown4 = new Select(selectPRACFrequency);
                dropdown4.selectByVisibleText(" "+Frequency+" ");
                break;
            case "Self-employment tax":
                basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 10);
                addtlDeductionOptionsCheckbox.get(5).click();
                txtSETXAmount.sendKeys(Amount);

                Select dropdown6 = new Select(selectSETXFrequency);
                dropdown6.selectByVisibleText(" "+Frequency+" ");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlDeductionOption);
        }
    }

    public void selectNoneAddtlDeductionOption(){
        basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 20);
        addtlDeductionOptionsCheckbox.get(10).click();
        saveAndContinueBtn.click();
    }

    public void clickContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueBtn, 20);
        saveAndContinueBtn.click();
    }



    // ############################## VALIDATION METHODS #########################
    // Add only validation methods below this line

    public void selectAddtlDeductionOptionOnly(String addtlDeductionOption){
//        Alimony or spousal support paid out = AOSS
//        Domestic production activities = DPAC
//        Health Savings Account contribution = HSAC
//        Pre-tax retirement account contribution = PRAC
//        School tuition and fees = STAF
//        Self-employment tax = SETX
//        Student loan interest = STLI
//        Self-employment health insurance = SEHI
//        Self-employment retirement plan = SERP
//        Moving expenses = MOVE
//        None of these = NoDeductions

        basicActions.waitForElementListToBePresent(addtlDeductionOptionsCheckbox, 20);
        WebElement addtlDeductionOptionBox = basicActions.getDriver().findElement(By.xpath("//*[@id='ELIG-Deductions-"+addtlDeductionOption+"-checkBoxButton']"));
        addtlDeductionOptionBox.click();
    }

    public void verifyDeductionsOptionAmt1Error(String language){
        switch (language) {
            case "English":
                softAssert.assertEquals(deductionsAmountError.get(0).getText(), "Amount is required");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(deductionsAmountError.get(0).getText(), "Esta cantidad es obligatoria");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyDeductionsOptionFreq1Error(String language){
        switch (language) {
            case "English":
                softAssert.assertEquals(deductionsFrequencyError.get(0).getText(), "Please select one of the options below");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(deductionsFrequencyError.get(0).getText(), "Seleccione una de las siguientes opciones");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyDeductionsOptionNoError(){
        basicActions.waitForElementListToDisappear(deductionsAmountError, 10);
        basicActions.waitForElementListToDisappear(deductionsFrequencyError, 10);
        softAssert.assertAll();
    }

    public void verifyDeductionOption(String addtlDeductionOption, String Amount, String Frequency){
        switch(addtlDeductionOption){
            case "2nd Checked":
                softAssert.assertEquals(deductionsAmount.get(1).getAttribute("value"), Amount);
                softAssert.assertEquals(deductionsFrequency.get(1).getAttribute("value"), Frequency);
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + addtlDeductionOption);
        }
    }

    public void verifyDeductionsPageNoError(){
        basicActions.waitForElementToDisappear(deductionsSelectError, 10);
        softAssert.assertAll();
    }

    public void verifyDeductionsPageError(String language){
        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(deductionsSelectError,20);
                softAssert.assertEquals(deductionsSelectError.getText(), "Please select one or more of the options below");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(deductionsSelectError,20);
                softAssert.assertEquals(deductionsSelectError.getText(), "Seleccione una o m\u00E1s de las siguientes opciones");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}
