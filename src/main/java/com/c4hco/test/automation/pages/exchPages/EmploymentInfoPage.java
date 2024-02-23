package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class EmploymentInfoPage {
    private BasicActions basicActions;
    public EmploymentInfoPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsEmployed-YesButton")
    WebElement btnYesEmployed;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsEmployed-NoButton")
    WebElement btnNoEmployed;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsSelfEmployment-YesButton")
    WebElement btnYesSelfEmployed;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsSelfEmployment-NoButton")
    WebElement btnNoSelfEmployed;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-employerNameInput")
    WebElement txtCompanyName;

    @FindBy(id = "ELIG-employerAddress-addressLine1Input")
    WebElement txtAddressOne;

    @FindBy(id = "ELIG-employerAddress-addressLine2Input")
    WebElement txtAddressTwo;

    @FindBy(id = "ELIG-employerAddress-cityInput")
    WebElement txtCity;

    @FindBy(id = "ELIG-employerAddress-stateSelect")
    WebElement selectState;

    @FindBy(id = "ELIG-employerAddress-zipCodeInput")
    WebElement txtZip;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-amountInput")
    WebElement txtIncomeAmount;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-frequencySelect")
    WebElement selectIncomeFreq;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsIncomeSeasonal-YesButton")
    WebElement btnIsSeasonalYes;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsIncomeSeasonal-NoButton")
    WebElement btnIsSeasonalNo;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsIncomeSame-YesButton")
    WebElement btnIncomeSameYes;

    @FindBy(id = "ELIG-Exch-EmploymentIncomeJob-IsIncomeSame-NoButton")
    WebElement btnIncomeSameNo;

    @FindBy(id = "ExchEmploymentIncomeJob-SaveAndContinue")
    WebElement btnContinue;

    @FindBy(css = ".drawer-controls .btn")
    WebElement helpDrawerButton;

    @FindBy(css = "[class='drawer-heading ng-tns-c3-1'] div")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = "[class='drawer-heading ng-tns-c3-1'] h3")
    WebElement helpDrawerHeaderIncome;

    @FindBy(css = "[class='drawer-text-content body-text-1 ng-tns-c3-1'] div")
    List<WebElement> helpDrawerBodyHeaders;

    @FindBy(css = "[class='drawer-text-content body-text-1 ng-tns-c3-1'] p")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = "[class='drawer-text-content body-text-1 ng-tns-c3-1'] li")
    List<WebElement> helpDrawerBodyPoints;

    @FindBy(css = "[class='ng-tns-c3-1'] h3")
    WebElement helpDrawerFooter;

    @FindBy(css = "[class='ng-tns-c3-1'] a")
    WebElement helpDrawerContactUsLink;

    public void isUserEmployed(String employmentOption){
        basicActions.waitForElementToBeClickable(btnYesEmployed, 10);

        switch(employmentOption){
            case "Yes":
                btnYesEmployed.click();
                break;
            case "No":
                btnNoEmployed.click();
                break;
        }
    }

    public void isUserSelfEmplyed(String selfEmploymentOption){
        switch(selfEmploymentOption){
            case "Yes":
                btnYesSelfEmployed.click();
                break;
            case "No":
                btnNoSelfEmployed.click();
                break;
        }
    }

    public void addEmploymentInfo(String Salary, String Frequency){

        txtCompanyName.sendKeys("Test Company Name");
        txtAddressOne.sendKeys("123 Test Address");
        txtAddressTwo.sendKeys("Test Suite 321");
        txtCity.sendKeys("Denver");

        Select dropdown = new Select(selectState);
        dropdown.selectByVisibleText(" CO ");

        txtZip.sendKeys("80205");
        txtIncomeAmount.sendKeys(Salary);

        dropdown = new Select(selectIncomeFreq);
        dropdown.selectByVisibleText(" "+Frequency+" ");
    }

    public void isUserEmploymentSeasonal(String seasonalEmploymentOption){
        switch(seasonalEmploymentOption){
            case "Yes":
                btnIsSeasonalYes.click();
                break;
            case "No":
                btnIsSeasonalNo.click();
                break;
        }
    }

    public void projectedIncomeQuestion(String projectedUncomeOption){
        switch(projectedUncomeOption){
            case "Yes":
                btnIncomeSameYes.click();
                break;
            case "No":
                btnIncomeSameNo.click();
                break;
        }
    }

    public void saveAndContinue(){btnContinue.click();}

    public void maximizeHeldDrawer(){
        basicActions.waitForElementToBeClickable(helpDrawerButton, 10);
        helpDrawerButton.click();
    }

    public void clickHelpContactUsNavigation(){
        basicActions.waitForElementToBePresent(helpDrawerContactUsLink, 10);
        helpDrawerContactUsLink.click();
    }

    // ############################## VALIDATION METHODS #########################

    public void validateHelpHeaderVerbiageEng(){
        SoftAssert softAssert = new SoftAssert();
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 10);
        softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Income");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageEng(){
        SoftAssert softAssert = new SoftAssert();
        basicActions.waitForElementListToBePresent(helpDrawerBodyHeaders, 10);
        softAssert.assertEquals(helpDrawerBodyHeaders.get(0).getText(), "Income");
        softAssert.assertEquals(helpDrawerBodyHeaders.get(1).getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyHeaders.get(2).getText(), "Employment");
        softAssert.assertEquals(helpDrawerBodyHeaders.get(3).getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyHeaders.get(4).getText(), "Employment");
        softAssert.assertEquals(helpDrawerBodyHeaders.get(5).getText(), "Overview");
        basicActions.waitForElementListToBePresent(helpDrawerBodyParagraphs, 10);
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "We need to know how much you and your family members earn at your job(s).");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "We need to know about the company you work for.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "We need to know how much money you make from self-employment.");
        basicActions.waitForElementListToBePresent(helpDrawerBodyPoints, 10);
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "Employment\n" +
                "Does this person earn money through a job or by being self-employed?");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "Company Name\n" +
                "Enter a company name for each job.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "Gross Income\n" +
                "Tell us the total amount paid by this job BEFORE taxes or any other deductions (like retirement contributions) are taken out. This is gross pay and would be MORE than the amount received on a check or deposited in a bank account, which is the net pay.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(3).getText(), "Seasonal, commission or tipped base employment\n" +
                "This question helps us calculate the annual income for customers who don't have the same income every week or month.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(4).getText(), "Same or lower\n" +
                "We ask this question to make sure the calculation of your annual income is correct for customers who don't have consistent income.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(5).getText(), "Net Income\n" +
                "Tell us your income from your self-employment after business expenses have been paid. (Net income is sometimes called \"profit\".)");
        softAssert.assertEquals(helpDrawerBodyPoints.get(6).getText(), "Same or lower\n" +
                "We ask this question to make sure the calculation of your annual income is correct for customers who don't have consistent income.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(7).getText(), "Employer Address\n" +
                "Connect for Health Colorado will notify an employer if an employee has been determined eligible for Advance Premium Tax Credits and/or Cost-Sharing Reductions and has enrolled in a Qualified Health Plan. The employer has the right to file an appeal if they believe this determination is incorrect. The correct contact information for the employer is required to support the employer appeal process, so please double check your entry of the employer contact information.");
        softAssert.assertAll();
    }

    public void validateHelpFooterVerbiageEng() {
        SoftAssert softAssert = new SoftAssert();
        basicActions.waitForElementToBePresent(helpDrawerFooter, 10);
        softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact Us");
        softAssert.assertAll();
    }

}