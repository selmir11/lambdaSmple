package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


public class EmploymentInfoPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public EmploymentInfoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "app-employment-container .header-1")
    WebElement txtHeaderPart1;

    @FindBy(xpath = "//app-employment-container//div[2]/span")
    WebElement txtHeaderPart2;

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

    @FindBy(css = "#ELIG-Exch-EmploymentIncomeJob-employerAddress-addressLine1Input")
    WebElement txtAddressOne;

    @FindBy(css = "#ELIG-Exch-EmploymentIncomeJob-employerAddress-addressLine2Input")
    WebElement txtAddressTwo;

    @FindBy(css = "#ELIG-Exch-EmploymentIncomeJob-employerAddress-cityInput")
    WebElement txtCity;

    @FindBy(css = "#ELIG-Exch-EmploymentIncomeJob-employerAddress-selectState")
    WebElement selectState;

    @FindBy(css = "#ELIG-Exch-EmploymentIncomeJob-employerAddress-zipCodeInput")
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

    @FindBy(css = "lib-help-icon a")
    List<WebElement> helpIcons;

    @FindBy(xpath = "//*[@class='company-column-value']")
    List<WebElement> Companynames;

    @FindBy(css = ".title-row .title")
    WebElement helpDrawerHeaderIncome;

    @FindBy(css = ".c4-text-body-200")
    List<WebElement> helpDrawerMainHeaders;

    @FindBy(css = "div.section-help-content-container > p")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = ".help-footer .c4-type-links-md")
    List<WebElement> helpDrawerFooter;

    @FindBy(css = ".help-footer .clickable")
    WebElement helpDrawerContactUsLink;

    @FindBy(xpath = "(//a[@class=’clickable link-text-1’])[0]")
    List<WebElement> EditUpdateLink;

    @FindBy(xpath = "(//label[@class='input-label form-label']//span)[1]")
    WebElement haveAJobOrEmployedQuestion;

    @FindBy(xpath = "(//label[@class='input-label form-label']//span)[2]")
    WebElement selfEmploymentQuestion;

    @FindBy(id = "ExchEmploymentIncomeJob-GoBack")
    WebElement goBackButton;

    @FindBy(xpath = "//div[2]/lib-help-icon/a")
    WebElement helpLabel;

    @FindBy(xpath = "//div//div//div//label[@class='input-label form-label ng-star-inserted']")
    WebElement companyNameLabel;

    @FindBy(xpath = "//div//div//div//label[@class='form-label']")
    WebElement currentNetIncomeQuestion;

    @FindBy(xpath = "//div//div//span[@class='field-info']")
    WebElement enterProfitLabel;

    @FindBy(xpath = "(//div//div//lib-fi[@name='dollar-sign']//*)[1]")
    WebElement dollarSign;

    @FindBy(xpath = "//input[@id='ELIG-Exch-EmploymentIncomeJob-amountInput']")
    WebElement amountLabelInAmountInputField;

    @FindBy(xpath = "(//select[@id='ELIG-Exch-EmploymentIncomeJob-frequencySelect']//option)[1]")
    WebElement selectOptionLabel;

    @FindBy(xpath = "(//label[@class='input-label form-label']//span)[3]")
    WebElement incomeSameLowerNextYearQuestionWhenYesToSelfEmployedQuestion;

    @FindBy(xpath = "(//div//div//div//label[@class='input-label form-label ng-star-inserted'])[2]")
    WebElement addressLine1Label;

    @FindBy(xpath = "(//div//div//div//label[@class='input-label form-label ng-star-inserted'])[3]")
    WebElement addressLine2Label;

    @FindBy(xpath = "(//div//div//div//label[@class='input-label form-label ng-star-inserted'])[4]")
    WebElement cityLabel;

    @FindBy(xpath = "(//div//div//div//label[@class='input-label form-label ng-star-inserted'])[5]")
    WebElement zipCodeLabel;

    @FindBy(xpath = "//*[@for='ELIG-Exch-EmploymentIncomeJob-employerAddress-selectState']")
    WebElement stateLabel;

    @FindBy(xpath = "//*[contains(@id, 'selectState')]/*[@value='0: null']")
    WebElement stateDropDownLabel;

    @FindBy(xpath = "//div//div//div//label[@class='form-label']")
    WebElement currentGrossIncomeQuestion;

    @FindBy(xpath = "//div//div//span[@class='field-info']")
    WebElement commissionLabel;

    @FindBy(xpath = "(//label[@class='input-label form-label']//span)[3]")
    WebElement incomeSeasonalQuestion;

    @FindBy(xpath = "(//label[@class='input-label form-label']//span)[4]")
    WebElement incomeSameLowerNextYearQuestionWhenNoToSelfEmployedQuestion;

    @FindBy(id = "ELIG-summaryDetails-incomeAmountInput")
    WebElement projectedIncomeInput;

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinnerOverlay;

    @FindBy(xpath = "//label[@for='ELIG-Exch-EmploymentIncomeJob-IsEmployed']")
    WebElement employmentStatusLabel;

    @FindBy(xpath = "(//div[@class=\"input-error-message error-icon ng-star-inserted\"]/span)[1]")
    WebElement CompanyNameErrorMessage;

    @FindBy(xpath = "(//div[@class=\"input-error-message error-icon ng-star-inserted\"]/span)[2]")
    WebElement EnterProfitAmountError;

    @FindBy(xpath = "(//div[@class=\"input-error-message error-icon ng-star-inserted\"]/span)[1]")
    WebElement IncomeTypeFrequencyErrorMessage;

    @FindBy(xpath = "(//div[@class=\"input-error-message error-icon ng-star-inserted\"]/span)[2]")
    WebElement IncomeSameOrLowerNextYearErrorMessage;

    @FindBy(xpath = "//div[@class='header-1 text-center ng-star-inserted']")
    WebElement txtEmploymentHeader1;

    @FindBy(xpath = "//div[@class='header-2 text-center ng-star-inserted']/span")
    WebElement txtEmploymentHeader2;

    @FindBy(xpath = "//*[@class='error-message c4-text-body-100 ng-star-inserted']")
    List<WebElement> c4bodyTextError;

    public void clickEditUpdateLink(int employer) {
        basicActions.waitForElementListToBePresent(EditUpdateLink, 10);
        EditUpdateLink.get(employer).click();
    }

    public void isUserEmployed(String employmentOption) {
        basicActions.waitForElementToDisappear(spinner,60);
        basicActions.waitForElementToDisappear(spinnerOverlay,60);
        basicActions.waitForElementToBePresent(btnYesEmployed, 15);
        switch (employmentOption) {
            case "Yes":
                basicActions.clickElementWithRetries(btnYesEmployed, 10);
                break;
            case "No":
                btnNoEmployed.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + employmentOption);
        }
    }

    public void isUserSelfEmplyed(String selfEmploymentOption) {
        basicActions.waitForElementToBeClickable(btnYesSelfEmployed, 60);
        basicActions.waitForElementToBeClickable(btnNoSelfEmployed, 60);
        switch (selfEmploymentOption) {
            case "Yes":
                btnYesSelfEmployed.click();
                break;
            case "No":
                btnNoSelfEmployed.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + selfEmploymentOption);
        }
    }

    public static String getUniqueString(int length) {
        return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");
    }

    public void addEmploymentInfo(String Salary, String Frequency) {
        // Should not use this method anymore- should use genericEmploymentInfo method
        basicActions.waitForElementToBePresent(txtHeaderPart1, 20);
        String companyName = getUniqueString(8) + "Company";
        String name = txtHeaderPart1.getText();

        MemberDetails primaryMem = SharedData.getPrimaryMember();
        List<MemberDetails> memberList = SharedData.getMembers();
        String primaryFirstName = BasicActions.capitalizeFirstLetter(primaryMem.getFirstName());

        if (name.contains(primaryFirstName)) {
            primaryMem.setEmployerName(companyName);
            SharedData.setPrimaryMember(primaryMem);
        } else if (memberList.size() > 0) {
            Optional<MemberDetails> requiredMem = memberList.stream().filter(mem -> name.contains(BasicActions.capitalizeFirstLetter(mem.getFirstName()))).findFirst();
            if (requiredMem.isPresent()) {
                MemberDetails member = (MemberDetails) requiredMem.get();
                member.setEmployerName(companyName);
            } else {
                Assert.fail("No matching member found in the member list.");
            }
        }
        List<String> employerNames = SharedData.getCompanyname();
        if (employerNames == null) {
            employerNames = new ArrayList<>();
        }
        employerNames.add(companyName);
        SharedData.setCompanyname(employerNames);
        txtCompanyName.sendKeys(companyName);

        txtAddressOne.sendKeys("123 Test Address");
        txtAddressTwo.sendKeys("Test Suite 321");
        txtCity.sendKeys("Denver");

        Select dropdownState = new Select(selectState);
        dropdownState.selectByVisibleText(" CO ");

        txtZip.sendKeys("80205");
        txtIncomeAmount.clear();
        txtIncomeAmount.sendKeys(Salary);
        SharedData.setFinancialIncome(Salary);

        Select dropdown = new Select(selectIncomeFreq);
        dropdown.selectByVisibleText(" " + Frequency + " ");
    }

    public void addSelfEmploymentInfo(String Salary, String Frequency, String Same) {
        basicActions.waitForElementToBePresent(txtHeaderPart1, 20);
        String companyName = getUniqueString(8) + "Company";
        String name = txtHeaderPart1.getText();

        MemberDetails primaryMem = SharedData.getPrimaryMember();
        List<MemberDetails> memberList = SharedData.getMembers();
        String primaryFirstName = BasicActions.capitalizeFirstLetter(primaryMem.getFirstName());

        if (name.contains(primaryFirstName)) {
            primaryMem.setEmployerName(companyName);
            SharedData.setPrimaryMember(primaryMem);
        } else if (memberList.size() > 0) {
            Optional<MemberDetails> requiredMem = memberList.stream().filter(mem -> name.contains(BasicActions.capitalizeFirstLetter(mem.getFirstName()))).findFirst();
            if (requiredMem.isPresent()) {
                MemberDetails member = (MemberDetails) requiredMem.get();
                member.setEmployerName(companyName);
            } else {
                Assert.fail("No matching member found in the member list.");
            }
        }
        txtCompanyName.sendKeys(companyName);

        txtIncomeAmount.clear();
        txtIncomeAmount.sendKeys(Salary);
        Select dropdown = new Select(selectIncomeFreq);
        dropdown.selectByVisibleText(" " + Frequency + " ");

        projectedIncomeQuestion(Same);
    }

    public void genericEmploymentInfo(String addressline1, String city, String state, String zipcode, String Salary, String Frequency) {

        basicActions.waitForElementToBePresent(txtHeaderPart1, 20);
        String companyName = getUniqueString(8) + "Company";
        List<String> employerNames = SharedData.getCompanyname();
        if (employerNames == null) {
            employerNames = new ArrayList<>();
        }
        employerNames.add(companyName);
        SharedData.setCompanyname(employerNames);
        String name = txtHeaderPart1.getText();

        MemberDetails primaryMem = SharedData.getPrimaryMember();
        List<MemberDetails> memberList = SharedData.getMembers();
        String primaryFirstName = BasicActions.capitalizeFirstLetter(primaryMem.getFirstName());

        if (name.contains(primaryFirstName)) {
            primaryMem.setEmployerName(companyName);
            SharedData.setPrimaryMember(primaryMem);
        } else if (memberList.size() > 0) {
            Optional<MemberDetails> requiredMem = memberList.stream().filter(mem -> name.contains(BasicActions.capitalizeFirstLetter(mem.getFirstName()))).findFirst();
            if (requiredMem.isPresent()) {
                MemberDetails member = (MemberDetails) requiredMem.get();
                member.setEmployerName(companyName);
            } else {
                Assert.fail("No matching member found in the member list.");
            }
        }
        txtCompanyName.sendKeys(companyName);

        txtAddressOne.sendKeys(addressline1);
        txtCity.sendKeys(city);

        Select dropdownState = new Select(selectState);
        dropdownState.selectByVisibleText(state);

        txtZip.sendKeys(zipcode);
        txtIncomeAmount.sendKeys(Salary);

        Select dropdown = new Select(selectIncomeFreq);
        dropdown.selectByVisibleText(" " + Frequency + " ");

    }

    public void enterEmploymentIncome(String Salary) {
        basicActions.waitForElementToBePresent(txtIncomeAmount, 15);
        txtIncomeAmount.clear();
        txtIncomeAmount.click();
        txtIncomeAmount.sendKeys(Salary);

    }

    public void isUserEmploymentSeasonal(String seasonalEmploymentOption) {
        switch (seasonalEmploymentOption) {
            case "Yes":
                btnIsSeasonalYes.click();
                break;
            case "No":
                btnIsSeasonalNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + seasonalEmploymentOption);
        }
    }

    public void projectedIncomeQuestion(String projectedIncomeOption) {
        basicActions.waitForElementToBePresent(btnIncomeSameYes,30);
        switch (projectedIncomeOption) {
            case "Yes":
                btnIncomeSameYes.click();
                break;
            case "No":
                btnIncomeSameNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + projectedIncomeOption);
        }
    }

    public void saveAndContinue() {
        basicActions.waitForElementToDisappear(spinner,90);
        basicActions.waitForElementToDisappear(spinnerOverlay,90);
        basicActions.waitForElementToBePresent(btnContinue, 90);
        basicActions.waitForElementToBePresent(txtHeaderPart1, 90);
        basicActions.scrollToElement(btnContinue);
        btnContinue.click();
    }

    public void clickHelpIcon(String label) {
        basicActions.waitForElementListToBePresent(helpIcons, 10);
        switch (label) {
            case "General help":
                helpIcons.get(0).click();
                break;
            case "Do you have job":
                helpIcons.get(1).click();
                break;
            case "Is it self-employment":
                helpIcons.get(2).click();
                break;
            case "Company Name":
                helpIcons.get(3).click();
                break;
            case "Net Income":
                helpIcons.get(4).click();
                break;
            case "Income Change":
                helpIcons.get(5).click();
                break;
                /*commented out due to bug ticket TAM-5424
            case "Address 1":
                helpIcons.get(3).click();
                break;
            case "Address 2":
                helpIcons.get(5).click();
                break;
            case "City":
                helpIcons.get(6).click();
                break;
            case "State":
                helpIcons.get(7).click();
                break;
            case "Zip":
                helpIcons.get(8).click();
                break;*/
            case "Gross Income":
                helpIcons.get(4).click();
                break;
            case "Seasonal":
                helpIcons.get(5).click();
                break;
            case "Job Income Change":
                helpIcons.get(6).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + label);
        }
    }

    public void clickHelpContactUsNavigation() {
        basicActions.waitForElementToBePresent(helpDrawerContactUsLink, 10);
        helpDrawerContactUsLink.click();
    }
    public void goBackButton() {
        basicActions.waitForElementToDisappear(spinner,15);
        basicActions.waitForElementToDisappear(spinnerOverlay,15);
        basicActions.waitForElementToBePresent(goBackButton, 90);
        basicActions.waitForElementToBePresent(txtHeaderPart1, 90);
        basicActions.scrollToElement(goBackButton);
        goBackButton.click();
    }

    // ############################## VALIDATION METHODS #########################

    public void validateHelpHeaderVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerMainHeaders.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Income");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Ingreso");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateGeneralHelpBodyVerbiage(String language) {
        basicActions.click(helpDrawerMainHeaders.get(0));
        basicActions.click(helpDrawerBodyParagraphs.get(0));
        switch (language) {
            case "English":
                validateGeneralHelpBodyVerbiageEng();
                break;
            case "Spanish":
                validateGeneralHelpBodyVerbiageSp();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);

        }
    }

    public void validateGeneralHelpBodyVerbiageEng() {
        softAssert.assertEquals(helpDrawerMainHeaders.get(1).getText(), "Overview");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "We need to know how much you and your family members earn at your job(s).");
        softAssert.assertEquals(helpDrawerMainHeaders.get(2).getText(), "Employment");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "Does this person earn money through a job or by being self-employed?");
        softAssert.assertEquals(helpDrawerMainHeaders.get(3).getText(), "Company Name");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Enter a company name for each job.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(4).getText(), "Employment");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "We need to know about the company you work for.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(5).getText(), "Gross Income");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "Tell us the total amount paid by this job BEFORE taxes or any other deductions (like retirement contributions) are taken out. This is gross pay and would be MORE than the amount received on a check or deposited in a bank account, which is the net pay.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(6).getText(), "Seasonal, commission or tipped base employment");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(5).getText(), "This question helps us calculate the annual income for customers who don't have the same income every week or month.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(7).getText(), "Same or lower");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(6).getText(), "We ask this question to make sure the calculation of your annual income is correct for customers who don't have consistent income.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(7).getText(), "We need to know how much money you make from self-employment.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(8).getText(), "Net Income");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(8).getText(), "Tell us your income from your self-employment after business expenses have been paid. (Net income is sometimes called \"profit\".)");
        softAssert.assertEquals(helpDrawerMainHeaders.get(9).getText(), "Same or lower");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(9).getText(), "We ask this question to make sure the calculation of your annual income is correct for customers who don't have consistent income.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(10).getText(), "Employer Address");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(10).getText(), "Connect for Health Colorado will notify an employer if an employee has been determined eligible for Advance Premium Tax Credits and/or Cost-Sharing Reductions and has enrolled in a Qualified Health Plan. The employer has the right to file an appeal if they believe this determination is incorrect. The correct contact information for the employer is required to support the employer appeal process, so please double check your entry of the employer contact information.");
        softAssert.assertAll();
    }

    public void validateGeneralHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerMainHeaders.get(1).getText(), "Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Necesitamos saber cu\u00E1nto ganan usted y los miembros de su familia en su(s) trabajo(s).");
        softAssert.assertEquals(helpDrawerMainHeaders.get(2).getText(), "Empleo");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(1).getText(), "\u00BFEsta persona tiene un ingreso como empleado o como trabajador independiente?");
        softAssert.assertEquals(helpDrawerMainHeaders.get(3).getText(), "Nombre de la empresa");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Ingrese el nombre de la empresa de cada trabajo.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(4).getText(), "Empleo");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(3).getText(), "Necesitamos informaci\u00F3n sobre la empresa para la que trabaja usted.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(5).getText(), "Ingreso bruto");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "Indique la cantidad total que le pagan en este trabajo ANTES de descontar impuestos o hacer otras deducciones (como aportes para el retiro). Es el salario bruto y debe ser m\u00E1s que la cantidad que recibe en cheque o le depositan en su cuenta bancaria, que es el salario neto.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(6).getText(), "Trabajo temporal, por comisiones o por propinas");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(5).getText(), "Esta pregunta nos ayuda a calcular el ingreso anual de los clientes que no tienen el mismo ingreso cada semana o mes.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(7).getText(), "Igual o bajar\u00E1");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(6).getText(), "Le hacemos esta pregunta para asegurarnos de calcular correctamente su ingreso anual, como es el caso de clientes que no tienen un ingreso constante.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(7).getText(), "Necesitamos saber cu\u00E1nto gana como trabajador independiente.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(8).getText(), "Ingreso neto");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(8).getText(), "Indique su ingreso como trabajador independiente despues de pagar sus gastos de negocios. (Ingreso neto a veces se llama \"ganacias\".)");
        softAssert.assertEquals(helpDrawerMainHeaders.get(9).getText(), "Igual o bajar\u00E1");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(9).getText(), "Le hacemos esta pregunta para asegurarnos de calcular correctamente su ingreso anual, como es el caso de clientes que no tienen un ingreso constante.");
        softAssert.assertEquals(helpDrawerMainHeaders.get(10).getText(), "Direcci\u00F3n del empleador");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(10).getText(), "Connect for Health Colorado notificar\u00E1 a un empleador si un empleado ha sido determinado elegible para Cr\u00E9dito fiscal anticipado para la cuota y/o reducciones en los costos compartidos y se ha inscrito en un Plan de salud calificado. El empleador tiene el derecho a presentar una apelaci\u00F3n si creen que esta determinaci\u00F3n es incorrecta. Se requiere la informaci\u00F3n de contacto correcta para el empleador para apoyar este proceso, por favor verifique que la informaci\u00F3n del empleador esta correcta.");
        softAssert.assertAll();
    }

    public void validateHelpFooterVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0), 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                basicActions.scrollToElement(helpDrawerFooter.get(0));
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateHeaderOnEmploymentInfo(String language) {
        basicActions.waitForElementToBePresent(txtHeaderPart2, 45);
        switch (language) {
            case "English":
                softAssert.assertEquals(txtHeaderPart2.getText(), "Employment Income");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(txtHeaderPart2.getText(), "Ingresos por empleo");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateJobQuestionsHelpVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerMainHeaders.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        basicActions.waitForElementToBePresent(helpDrawerBodyParagraphs.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0), 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Income");
                softAssert.assertEquals(helpDrawerMainHeaders.get(1).getText(), "Overview");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "We need to know how much you and your family members earn at your job(s).");
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
                softAssert.assertAll();
                break;
            case "English job":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Employment");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Does this person earn money through a job or by being self-employed?");
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Empleo");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "\u00BFEsta persona tiene un ingreso como empleado o como trabajador independiente?");
                basicActions.scrollToElement(helpDrawerFooter.get(0));
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateCompanyHelpVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerMainHeaders.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        basicActions.waitForElementToBePresent(helpDrawerBodyParagraphs.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0), 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Company Name");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Connect for Health Colorado will notify an employer if an employee has been determined eligible for Advance Premium Tax Credits and/or Cost-Sharing Reductions and has enrolled in a Qualified Health Plan. The employer has the right to file an appeal if they believe this determination is incorrect. The correct contact information for the employer is required to support the employer appeal process, so please double check your entry of the employer contact information.");
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Nombre de la empresa");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Connect for Health Colorado notificar\u00E1 a un empleador si un empleado ha sido determinado elegible para Cr\u00E9dito fiscal anticipado para la cuota y/o reducciones en los costos compartidos y se ha inscrito en un Plan de salud calificado. El empleador tiene el derecho a presentar una apelaci\u00F3n si creen que esta determinaci\u00F3n es incorrecta. Se requiere la informaci\u00F3n de contacto correcta para el empleador para apoyar este proceso, por favor verifique que la informaci\u00F3n del empleador esta correcta.");
                basicActions.scrollToElement(helpDrawerFooter.get(0));
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateNetIncomeHelpVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerMainHeaders.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        basicActions.waitForElementToBePresent(helpDrawerBodyParagraphs.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0), 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Net Income");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Tell us your income from your self-employment after business expenses have been paid. (Net income is sometimes called \"profit\".)");
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Ingreso neto");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Indique su ingreso como trabajador independiente despues de pagar sus gastos de negocios. (Ingreso neto a veces se llama \"ganacias\".)");
                basicActions.scrollToElement(helpDrawerFooter.get(0));
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateGrossIncomeHelpVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerMainHeaders.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        basicActions.waitForElementToBePresent(helpDrawerBodyParagraphs.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0), 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Gross Income");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Tell us the total amount paid by this job BEFORE taxes or any other deductions (like retirement contributions) are taken out. This is gross pay and would be MORE than the amount received on a check or deposited in a bank account, which is the net pay.");
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Ingreso bruto");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Indique la cantidad total que le pagan en este trabajo ANTES de descontar impuestos o hacer otras deducciones (como aportes para el retiro). Es el salario bruto y debe ser m\u00E1s que la cantidad que recibe en cheque o le depositan en su cuenta bancaria, que es el salario neto.");
                basicActions.scrollToElement(helpDrawerFooter.get(0));
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateIncomeChangeHelpVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerMainHeaders.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        basicActions.waitForElementToBePresent(helpDrawerBodyParagraphs.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0), 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Same or lower");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "We ask this question to make sure the calculation of your annual income is correct for customers who don't have consistent income.");
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Igual o bajar\u00E1");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Le hacemos esta pregunta para asegurarnos de calcular correctamente su ingreso anual, como es el caso de clientes que no tienen un ingreso constante.");
                basicActions.scrollToElement(helpDrawerFooter.get(0));
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateAddress1HelpVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerMainHeaders.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        basicActions.waitForElementToBePresent(helpDrawerBodyParagraphs.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0), 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Employer Address");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Connect for Health Colorado will notify an employer if an employee has been determined eligible for Advance Premium Tax Credits and/or Cost-Sharing Reductions and has enrolled in a Qualified Health Plan. The employer has the right to file an appeal if they believe this determination is incorrect. The correct contact information for the employer is required to support the employer appeal process, so please double check your entry of the employer contact information.");
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Direcci\u00F3n del empleador");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Connect for Health Colorado notificar\u00E1 a un empleador si un empleado ha sido determinado elegible para Cr\u00E9dito fiscal anticipado para la cuota y/o reducciones en los costos compartidos y se ha inscrito en un Plan de salud calificado. El empleador tiene el derecho a presentar una apelaci\u00F3n si creen que esta determinaci\u00F3n es incorrecta. Se requiere la informaci\u00F3n de contacto correcta para el empleador para apoyar este proceso, por favor verifique que la informaci\u00F3n del empleador esta correcta.");
                basicActions.scrollToElement(helpDrawerFooter.get(0));
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateSeasonalHelpVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerMainHeaders.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        basicActions.waitForElementToBePresent(helpDrawerBodyParagraphs.get(0), 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter.get(0), 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Seasonal, commission or tipped base employment");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "This question helps us calculate the annual income for customers who don't have the same income every week or month.");
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "Need more help?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Trabajo temporal, por comisiones o por propinas");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Esta pregunta nos ayuda a calcular el ingreso anual de los clientes que no tienen el mismo ingreso cada semana o mes.");
                basicActions.scrollToElement(helpDrawerFooter.get(0));
                softAssert.assertEquals(helpDrawerFooter.get(0).getText(), "\u00BFNecesitas m\u00E1s ayuda?");
                softAssert.assertEquals(helpDrawerContactUsLink.getText(), "Cont\u00E1ctenos");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyTextOnInitialIncomePage(List<String> dataText) {
        basicActions.waitForElementToBePresent(txtHeaderPart1, 10);
        basicActions.waitForElementToBePresent(txtHeaderPart2, 10);
        basicActions.waitForElementToBePresent(haveAJobOrEmployedQuestion, 10);
        basicActions.waitForElementToBePresent(goBackButton, 10);
        basicActions.waitForElementToBePresent(btnContinue, 10);
        basicActions.waitForElementToBePresent(helpLabel, 10);
        basicActions.waitForElementToBePresent(btnYesEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoEmployed, 10);
        softAssert.assertEquals(txtHeaderPart1.getText(), dataText.get(0) + " " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(txtHeaderPart2.getText(), dataText.get(1), "Title Not matching");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getText(), dataText.get(2), "Question Not matching");
        softAssert.assertEquals(btnYesEmployed.getText(), dataText.get(3), "Yes button label not matching");
        softAssert.assertEquals(btnNoEmployed.getText(), dataText.get(4), "No button label not matching");
        softAssert.assertEquals(goBackButton.getText().trim(), dataText.get(5), "back button label not matching");
        softAssert.assertEquals(btnContinue.getText().trim(), dataText.get(6), "continue button label not matching");
        softAssert.assertAll();
    }

    public void verifyTextOnIncomePageAfterClickingYesToEmploymentQuestion(List<String> dataText) {
        basicActions.waitForElementToBePresent(txtHeaderPart1, 10);
        basicActions.waitForElementToBePresent(txtHeaderPart2, 10);
        basicActions.waitForElementToBePresent(haveAJobOrEmployedQuestion, 10);
        basicActions.waitForElementToBePresent(goBackButton, 10);
        basicActions.waitForElementToBePresent(btnContinue, 10);
        basicActions.waitForElementToBePresent(helpLabel, 10);
        basicActions.waitForElementToBePresent(btnYesEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoEmployed, 10);
        basicActions.waitForElementToBePresent(selfEmploymentQuestion, 10);
        basicActions.waitForElementToBePresent(btnYesSelfEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoSelfEmployed, 10);
        softAssert.assertEquals(txtHeaderPart1.getText(), dataText.get(0) + " " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(txtHeaderPart2.getText(), dataText.get(1), "Title Not matching");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getText(), dataText.get(2), "Employment Question Not matching");
        softAssert.assertEquals(btnYesEmployed.getText(), dataText.get(3), "Yes button label for Employment question not matching");
        softAssert.assertEquals(btnNoEmployed.getText(), dataText.get(4), "No button label for Employment question not matching");
        softAssert.assertEquals(goBackButton.getText().trim(), dataText.get(5), "back button label not matching");
        softAssert.assertEquals(btnContinue.getText().trim(), dataText.get(6), "continue button label not matching");
        softAssert.assertEquals(selfEmploymentQuestion.getText(), dataText.get(7), "Self Employment Question Not matching");
        softAssert.assertEquals(btnYesSelfEmployed.getText(), dataText.get(8), "Yes button label for Self Employment question not matching");
        softAssert.assertEquals(btnNoSelfEmployed.getText(), dataText.get(9), "No button label for Self Employment question not matching");
        softAssert.assertAll();
    }

    public void verifyTextOnIncomePageAfterClickingYesToSelfEmploymentQuestion(List<String> dataText) {
        basicActions.waitForElementToBePresent(txtHeaderPart1, 10);
        basicActions.waitForElementToBePresent(txtHeaderPart2, 10);
        basicActions.waitForElementToBePresent(haveAJobOrEmployedQuestion, 10);
        basicActions.waitForElementToBePresent(goBackButton, 10);
        basicActions.waitForElementToBePresent(btnContinue, 10);
        basicActions.waitForElementToBePresent(helpLabel, 10);
        basicActions.waitForElementToBePresent(btnYesEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoEmployed, 10);
        basicActions.waitForElementToBePresent(selfEmploymentQuestion, 10);
        basicActions.waitForElementToBePresent(btnYesSelfEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoSelfEmployed, 10);
        basicActions.waitForElementToBePresent(companyNameLabel, 10);
        basicActions.waitForElementToBePresent(currentNetIncomeQuestion, 10);
        basicActions.waitForElementToBePresent(enterProfitLabel, 10);
        basicActions.waitForElementToBePresent(dollarSign, 10);
        basicActions.waitForElementToBePresent(amountLabelInAmountInputField, 10);
        basicActions.waitForElementToBePresent(selectOptionLabel, 10);
        basicActions.waitForElementToBePresent(incomeSameLowerNextYearQuestionWhenYesToSelfEmployedQuestion, 10);
        basicActions.waitForElementToBePresent(btnIncomeSameYes, 10);
        basicActions.waitForElementToBePresent(btnIncomeSameNo, 10);
        softAssert.assertEquals(txtHeaderPart1.getText(), dataText.get(0) + " " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(txtHeaderPart2.getText(), dataText.get(1), "Title Not matching");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getText(), dataText.get(2), "Employment Question Not matching");
        softAssert.assertEquals(btnYesEmployed.getText(), dataText.get(3), "Yes button label for Employment question not matching");
        softAssert.assertEquals(btnNoEmployed.getText(), dataText.get(4), "No button label for Employment question not matching");
        softAssert.assertEquals(goBackButton.getText().trim(), dataText.get(5), "back button label not matching");
        softAssert.assertEquals(btnContinue.getText().trim(), dataText.get(6), "continue button label not matching");
        softAssert.assertEquals(selfEmploymentQuestion.getText(), dataText.get(7), "Self Employment Question Not matching");
        softAssert.assertEquals(btnYesSelfEmployed.getText(), dataText.get(8), "Yes button label for Self Employment question not matching");
        softAssert.assertEquals(btnNoSelfEmployed.getText(), dataText.get(9), "No button label for Self Employment question not matching");
        softAssert.assertEquals(companyNameLabel.getText(), dataText.get(10), "Company Name label not matching");
        softAssert.assertEquals(currentNetIncomeQuestion.getText(), dataText.get(11), "Current Net Income question not matching");
        softAssert.assertEquals(enterProfitLabel.getText(), dataText.get(12), "Enter Profit label not matching");
        softAssert.assertTrue(dollarSign.isDisplayed(), "Dollar sign not visible"); // Verifying dollar sign is present
        softAssert.assertEquals(amountLabelInAmountInputField.getAttribute("Placeholder"), dataText.get(13), "amount label in input text field not matching");
        softAssert.assertEquals(selectOptionLabel.getText(), dataText.get(14), "Select Option Label not matching");
        softAssert.assertEquals(incomeSameLowerNextYearQuestionWhenYesToSelfEmployedQuestion.getText(), dataText.get(15), "Income same or Lower question not matching");
        softAssert.assertEquals(btnIncomeSameYes.getText(), dataText.get(16), "Yes button label for Income Same question not matching");
        softAssert.assertEquals(btnIncomeSameNo.getText(), dataText.get(17), "No button label for Income Same question not matching");
        softAssert.assertAll();
    }

    public void verifyTextOnIncomePageAfterClickingNoToSelfEmploymentQuestion(List<String> dataText) {
        basicActions.waitForElementToBePresent(txtHeaderPart1, 10);
        basicActions.waitForElementToBePresent(txtHeaderPart2, 10);
        basicActions.waitForElementToBePresent(haveAJobOrEmployedQuestion, 10);
        basicActions.waitForElementToBePresent(goBackButton, 10);
        basicActions.waitForElementToBePresent(btnContinue, 10);
        basicActions.waitForElementToBePresent(helpLabel, 10);
        basicActions.waitForElementToBePresent(btnYesEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoEmployed, 10);
        basicActions.waitForElementToBePresent(selfEmploymentQuestion, 10);
        basicActions.waitForElementToBePresent(btnYesSelfEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoSelfEmployed, 10);
        basicActions.waitForElementToBePresent(companyNameLabel, 10);
        basicActions.waitForElementToBePresent(dollarSign, 10);
        basicActions.waitForElementToBePresent(amountLabelInAmountInputField, 10);
        basicActions.waitForElementToBePresent(selectOptionLabel, 10);
        basicActions.waitForElementToBePresent(incomeSameLowerNextYearQuestionWhenNoToSelfEmployedQuestion, 10);
        basicActions.waitForElementToBePresent(btnIncomeSameYes, 10);
        basicActions.waitForElementToBePresent(btnIncomeSameNo, 10);
        basicActions.waitForElementToBePresent(addressLine1Label, 10);
        basicActions.waitForElementToBePresent(addressLine2Label, 10);
        basicActions.waitForElementToBePresent(cityLabel, 10);
        basicActions.waitForElementToBePresent(stateLabel, 10);
        basicActions.waitForElementToBePresent(stateDropDownLabel, 10);
        basicActions.waitForElementToBePresent(zipCodeLabel, 10);
        basicActions.waitForElementToBePresent(currentGrossIncomeQuestion, 10);
        basicActions.waitForElementToBePresent(commissionLabel, 10);
        basicActions.waitForElementToBePresent(incomeSeasonalQuestion, 10);
        basicActions.waitForElementToBePresent(btnIsSeasonalYes, 10);
        basicActions.waitForElementToBePresent(btnIsSeasonalNo, 10);
        softAssert.assertEquals(txtHeaderPart1.getText(), dataText.get(0) + " " + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(txtHeaderPart2.getText(), dataText.get(1), "Title Not matching");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getText(), dataText.get(2), "Employment Question Not matching");
        softAssert.assertEquals(btnYesEmployed.getText(), dataText.get(3), "Yes button label for Employment question not matching");
        softAssert.assertEquals(btnNoEmployed.getText(), dataText.get(4), "No button label for Employment question not matching");
        softAssert.assertEquals(goBackButton.getText().trim(), dataText.get(5), "back button label not matching");
        softAssert.assertEquals(btnContinue.getText().trim(), dataText.get(6), "continue button label not matching");
        softAssert.assertEquals(selfEmploymentQuestion.getText(), dataText.get(7), "Self Employment Question Not matching");
        softAssert.assertEquals(btnYesSelfEmployed.getText(), dataText.get(8), "Yes button label for Self Employment question not matching");
        softAssert.assertEquals(btnNoSelfEmployed.getText(), dataText.get(9), "No button label for Self Employment question not matching");
        softAssert.assertEquals(companyNameLabel.getText(), dataText.get(10), "Company Name label not matching");
        softAssert.assertTrue(dollarSign.isDisplayed(), "Dollar sign not visible"); // Verifying dollar sign is present
        softAssert.assertEquals(amountLabelInAmountInputField.getAttribute("Placeholder"), dataText.get(11), "Amount label not matching");
        softAssert.assertEquals(selectOptionLabel.getText(), dataText.get(12), "Select option label not matching");
        softAssert.assertEquals(incomeSameLowerNextYearQuestionWhenNoToSelfEmployedQuestion.getText(), dataText.get(13), "Income same question not matching");
        softAssert.assertEquals(btnIncomeSameYes.getText(), dataText.get(14), "Yes button label for Income same question not matching");
        softAssert.assertEquals(btnIncomeSameNo.getText(), dataText.get(15), "No button label for Income same question not matching");
        softAssert.assertEquals(addressLine1Label.getText(), dataText.get(16), "Address line1 label not matching");
        softAssert.assertEquals(addressLine2Label.getText(), dataText.get(17), "Address line2 label not matching");
        softAssert.assertEquals(cityLabel.getText(), dataText.get(18), "City label not matching");
        softAssert.assertEquals(stateLabel.getText(), dataText.get(19), "State label not matching");
        softAssert.assertEquals(stateDropDownLabel.getText(), dataText.get(20), "Select Option label for state dropdown not matching");
        softAssert.assertEquals(zipCodeLabel.getText(), dataText.get(21), "zip code label not matching");
        softAssert.assertEquals(currentGrossIncomeQuestion.getText(), dataText.get(22), "Current Gross Income question not matching");
        softAssert.assertEquals(commissionLabel.getText(), dataText.get(23), "Commission label not matching");
        softAssert.assertEquals(incomeSeasonalQuestion.getText(), dataText.get(24), "Income Seasonal question not matching");
        softAssert.assertEquals(btnIsSeasonalYes.getText(), dataText.get(25), "Yes button label for Income seasonal question not matching");
        softAssert.assertEquals(btnIsSeasonalNo.getText(), dataText.get(26), "No button label for Income seasonal question not matching");
        softAssert.assertAll();
    }

    public void enterProjectedIncome(String projectedIncome) {
        basicActions.waitForElementToBePresent(projectedIncomeInput, 75);
        projectedIncomeInput.clear();
        projectedIncomeInput.click();
        projectedIncomeInput.sendKeys(projectedIncome);
    }

    public void validateNetIncomeFrequencyDropdown(String language) {

        basicActions.waitForElementToBePresent(selectIncomeFreq, 10);

        Select dropdown = new Select(selectIncomeFreq);
        List<WebElement> options = dropdown.getOptions();

        List<String> actualOptions = options.stream().map(WebElement::getText).collect(Collectors.toList());
    List<String> expectedOptions = new ArrayList<>();

        switch (language.toLowerCase()) {
            case "english":
                // Expected values in the dropdown menu
                expectedOptions = Arrays.asList("Weekly", "Twice a month", "Monthly", "Annually", "Every 2 weeks");
                // Validate the dropdown contains all expected options
                break;
            case "spanish":
                // Expected values in the dropdown menu in Spanish
                 expectedOptions = Arrays.asList("Anualmente", "Cada dos semanas", "Mensualmente", "Dos veces por mes", "Semanalmente");
                break;
            default:
                Assert.fail("Invalid option: " + language);
        }
        for (String expectedOption : expectedOptions) {
            boolean optionExists = actualOptions.stream().anyMatch(optionText -> optionText.equals(expectedOption)); // Check for the expected value
            Assert.assertTrue(optionExists, "Option " + expectedOption + " was not found in the dropdown");
        }
    }



    public void validateCompanyName() {
        basicActions.wait(500);
        basicActions.waitForElementListToBePresent(Companynames, 30);
        List<String> actualList = new ArrayList<>();
        for (WebElement element : Companynames) {
            actualList.add(element.getText().trim());
        }
        List<String> expectedList = SharedData.getCompanyname();
        softAssert.assertEquals(actualList, expectedList, "Company names do not match! expected: "+expectedList+ " actual: "+actualList );
        softAssert.assertAll();
    }


    public void verifyNoEmployedButtonIsEnabled() {
        basicActions.waitForElementToBePresent(btnNoEmployed, 10);
        softAssert.assertTrue(btnNoEmployed.isEnabled(), "'No Employment' button should be enabled");
        softAssert.assertAll();
    }

    public void validateEmploymentStatusLabelAbsence() {
        softAssert.assertTrue(basicActions.waitForElementToDisappear(employmentStatusLabel,20), "Employment Status Label is present, but it should NOT be.");
        softAssert.assertAll();
    }

    public void clickOnCompanyNameInputFieldAndClickOutOfIt() {
        basicActions.waitForElementToBePresent(txtCompanyName, 10);
        txtCompanyName.click();
        companyNameLabel.click();
    }

    public void validateCompanyNameErrorMessage(String expectedErrorMessage) {
        basicActions.waitForElementToBePresent(CompanyNameErrorMessage, 10);
        softAssert.assertEquals(CompanyNameErrorMessage.getText(),expectedErrorMessage,"Error Message related to company name field is not matching");
        softAssert.assertAll();
    }

    public void enterValueInCompanyNameInputField(String value) {
        basicActions.waitForElementToBePresent(txtCompanyName, 10);
        txtCompanyName.clear();
        txtCompanyName.sendKeys(value);
    }

    public void validateFieldDoesNotAcceptMoreThan100Characters() {
        basicActions.waitForElementToBePresent( txtCompanyName,20);
        txtCompanyName.clear();
        txtCompanyName.sendKeys("IEnter110characterskdsjvbsdkjvbdjkvcjkjkdcbkjewbckjwefbcewuifuieihuqowiruzxlkcnsjdkhfdgrtwehoifvejweutcnvbdjsk");
        softAssert.assertTrue(txtCompanyName.getAttribute("value").length()<101,"Company name field accepting more than 100 characters");
        softAssert.assertAll();
    }

    public void verifyCompanyNameFieldNoError(){
        basicActions.waitForElementToDisappear(CompanyNameErrorMessage, 10);
        softAssert.assertAll();
    }

    public void clickOnEnterProfitInputFieldAndClickOutOfIt() {
        basicActions.waitForElementToBePresent(txtIncomeAmount, 10);
        txtIncomeAmount.click();
        currentNetIncomeQuestion.click();
    }

    public void validateEnterProfitAmountErrorMessage(String expectedErrorMessage) {
        basicActions.waitForElementToBePresent(EnterProfitAmountError, 40);
        softAssert.assertEquals(EnterProfitAmountError.getText(),expectedErrorMessage,"Error Message related to Enter profit amount is not matching");
        softAssert.assertAll();
    }

    public void validateEnterProfitAmount(String expectedAmount) {
        basicActions.waitForElementToBePresent(txtIncomeAmount, 40);
        softAssert.assertEquals(txtIncomeAmount.getAttribute("value"),expectedAmount,"Expected and Actual Income amount not matching");
        softAssert.assertAll();
    }

    public void verifyEnterProfitIncomeFieldNoError(){
        basicActions.waitForElementToDisappear(EnterProfitAmountError, 10);
        softAssert.assertAll();
    }

    public void validateIncomeFrequencyErrorMessage(String expectedErrorMessage) {
        basicActions.waitForElementToBePresent(IncomeTypeFrequencyErrorMessage, 40);
        softAssert.assertEquals(IncomeTypeFrequencyErrorMessage.getText(),expectedErrorMessage,"Error Message for Income frequency type is not matching");
        softAssert.assertAll();
    }

    public void validateIncomeSameOrLowerErrorMessage(String expectedErrorMessage) {
        basicActions.waitForElementToBePresent(IncomeSameOrLowerNextYearErrorMessage, 40);
        softAssert.assertEquals(IncomeSameOrLowerNextYearErrorMessage.getText(),expectedErrorMessage,"Error Message for Income same or lower question is not matching");
        softAssert.assertAll();
    }

    public void verifyNoErrorsShowForFrequencyAndIncomeSameLowerField(){
        basicActions.waitForElementToDisappear(IncomeTypeFrequencyErrorMessage, 20);
        basicActions.waitForElementToDisappear(IncomeSameOrLowerNextYearErrorMessage, 20);
        softAssert.assertAll();
    }

    public void validateHeaderOnEmploymentIncome(List<String> pageHeader) {
        String signature=SharedData.getPrimaryMember().getSignature();
        softAssert.assertEquals(txtEmploymentHeader1.getText(), pageHeader.get(0)+" "+signature);
        softAssert.assertEquals(txtEmploymentHeader2.getText(), pageHeader.get(1));
        softAssert.assertAll();
    }

    public void validateAllErrorMessageColourAndText(List<String> errorMessages) {
        for (WebElement webElement : c4bodyTextError) {
            softAssert.assertEquals(webElement.getCssValue("color"), "rgba(150, 0, 0, 1)");
        }
        for (int i = 0; i < errorMessages.size(); i++) {

            softAssert.assertEquals(c4bodyTextError.get(i).getText(), errorMessages.get(i), "Error message is not correct");
        }
        softAssert.assertAll();
    }

    public void validateMaxLengthOfEachTextField() {
        txtCompanyName.sendKeys(basicActions.generateRandomStringWithAnyLength(105));
        softAssert.assertTrue(txtCompanyName.getAttribute("value").length() == 100, "Company name accepting more than 100 chars");
        txtAddressOne.sendKeys(basicActions.generateRandomStringWithAnyLength(36));
        softAssert.assertFalse(txtAddressOne.getAttribute("value").length() == 35, "Address Line 1 accepting more than 35 chars");
        txtAddressTwo.sendKeys(basicActions.generateRandomStringWithAnyLength(21));
        softAssert.assertFalse(txtAddressTwo.getAttribute("value").length() == 20, "Address Line 2 accepting more than 20 chars");
        txtCity.sendKeys(basicActions.generateRandomStringWithAnyLength(21));
        softAssert.assertFalse(txtAddressTwo.getAttribute("value").length() == 20, "Address Line 2 accepting more than 20 chars");
        txtZip.sendKeys("5809089");
        softAssert.assertTrue(txtZip.getAttribute("value").length() == 5, "Zip field accepting more than 5 numbers");
        txtIncomeAmount.sendKeys("1234567891234");
        softAssert.assertTrue(txtIncomeAmount.getAttribute("value").replaceAll("\\D", "").length() == 11, "Amount accepting more than 11 numerical");
        softAssert.assertAll();
    }
    public void validateZipCodeAndCommissionTextField(){
        txtZip.click();
        txtIncomeAmount.click();
        basicActions.sendTextUsingJavaScript(txtZip,"ABCDE");
        txtZip.click();
        txtZip.sendKeys(Keys.BACK_SPACE);
        softAssert.assertEquals(c4bodyTextError.get(0).getText(),"ZIP Code must be five numbers","Accepting Only Chars");
        txtZip.clear();
        basicActions.sendTextUsingJavaScript(txtZip,"123");
        softAssert.assertEquals(c4bodyTextError.get(0).getText(),"ZIP Code must be five numbers","Accepting less than 5 numbers");
        txtZip.clear();
        basicActions.sendTextUsingJavaScript(txtZip,"!@#$%");
        softAssert.assertEquals(c4bodyTextError.get(0).getText(),"ZIP Code must be five numbers","Accepting special characters");
        txtIncomeAmount.clear();
        txtIncomeAmount.sendKeys("ABCDE");
        softAssert.assertTrue(txtIncomeAmount.getAttribute("value").isEmpty(),"Amount accepting Characters");
        txtIncomeAmount.clear();
        txtIncomeAmount.sendKeys("!@#$%");
        softAssert.assertTrue(txtIncomeAmount.getAttribute("value").isEmpty(),"Amount accepting special Characters");
        softAssert.assertAll();
    }

    public void validateIncomeFreAllowsSingleSelection(){
        Assert.assertFalse( basicActions.isMultipleSelection(selectIncomeFreq));
    }
    public void validateFunctionalityOfQuestions(String question){
        switch (question){
            case "Is this income part of seasonal":
                basicActions.waitForElementToBePresent(btnIsSeasonalYes,10);
                btnIsSeasonalYes.click();
                softAssert.assertTrue(btnIsSeasonalYes.getAttribute("class").contains("selected"),"Yes button not Selected");
                softAssert.assertFalse(btnIsSeasonalNo.getAttribute("class").contains("selected"),"No button is selected");
                softAssert.assertEquals(incomeSeasonalQuestion.getText(),"Is this income part of seasonal, commission, or tip based employment?","text is not matching for seasonal");
                softAssert.assertAll();
                break;
            case "Will this income be the same":
                basicActions.waitForElementToBePresent(btnIncomeSameYes,10);
                btnIncomeSameYes.click();
                softAssert.assertTrue(btnIncomeSameYes.getAttribute("class").contains("selected"),"Yes button not Selected");
                softAssert.assertFalse(btnIncomeSameNo.getAttribute("class").contains("selected"),"No button is Selected");
                softAssert.assertEquals(incomeSameLowerNextYearQuestionWhenNoToSelfEmployedQuestion.getText(),"Will this income be the same or lower next year?","text is not matching for same or lower");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +question);
        }
    }
    public void verifiEmploymentIncomeTextDesign() {
        basicActions.waitForElementToDisappear(txtHeaderPart1, 20);

        softAssert.assertEquals(txtHeaderPart1.getCssValue("font-size"), "36px", "Font size mismatch for Income");
        softAssert.assertEquals(txtHeaderPart1.getCssValue("font-weight"), "700", "Font weight mismatch for Income");
        softAssert.assertEquals(txtHeaderPart1.getCssValue("line-height"), "48px", "Line height mismatch for Income");
        softAssert.assertEquals(txtHeaderPart1.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Color mismatch for Income");

        softAssert.assertEquals(txtHeaderPart2.getText(), "Employment Income", "Header text mismatch for Employment Income");
        softAssert.assertEquals(txtHeaderPart2.getCssValue("font-size"), "28px", "Font size mismatch for Employment Income");
        softAssert.assertEquals(txtHeaderPart2.getCssValue("font-weight"), "700", "Font weight mismatch for Employment Income");
        softAssert.assertEquals(txtHeaderPart2.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Color mismatch for Employment Income");

        softAssert.assertEquals(haveAJobOrEmployedQuestion.getText(), "Do you have a job or are you currently employed?", "Text mismatch for employment question");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getCssValue("font-size"), "16px", "Font size mismatch for employment question");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getCssValue("font-weight"), "400", "Font weight mismatch for employment question");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Color mismatch for employment question");

        // Yes Button
        softAssert.assertEquals(btnYesEmployed.getText(), "Yes", "Text mismatch for Yes button");
        softAssert.assertEquals(btnYesEmployed.getCssValue("font-size"), "16px", "Font size mismatch for Yes button");
        softAssert.assertEquals(btnYesEmployed.getCssValue("font-weight"), "400", "Font weight mismatch for Yes button");
        softAssert.assertEquals(btnYesEmployed.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(77, 77, 79)", "Color mismatch for Yes button");
        softAssert.assertEquals(btnYesEmployed.getCssValue("background-color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(255, 255, 255)", "Background color mismatch for Yes button");
        softAssert.assertEquals(btnYesEmployed.getCssValue("border-color"), "rgb(149, 147, 147)", "Border color mismatch for Yes button");
        softAssert.assertEquals(btnYesEmployed.getCssValue("border-width"), "1px", "Border width mismatch for Yes button");
        softAssert.assertEquals(btnYesEmployed.getCssValue("border-radius"), "4px", "Border radius mismatch for Yes button");

        // No Button
        softAssert.assertEquals(btnNoEmployed.getText(), "No", "Text mismatch for No button");
        softAssert.assertEquals(btnNoEmployed.getCssValue("font-size"), "16px", "Font size mismatch for No button");
        softAssert.assertEquals(btnNoEmployed.getCssValue("font-weight"), "400", "Font weight mismatch for No button");
        softAssert.assertEquals(btnNoEmployed.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(77, 77, 79)", "Color mismatch for No button");
        softAssert.assertEquals(btnNoEmployed.getCssValue("background-color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(255, 255, 255)", "Background color mismatch for No button");
        softAssert.assertEquals(btnNoEmployed.getCssValue("border-color"), "rgb(149, 147, 147)", "Border color mismatch for No button");
        softAssert.assertEquals(btnNoEmployed.getCssValue("border-width"), "1px", "Border width mismatch for No button");
        softAssert.assertEquals(btnNoEmployed.getCssValue("border-radius"), "4px", "Border radius mismatch for No button");

        // Go Back Button
        softAssert.assertEquals(goBackButton.getText(), "Go back", "Text mismatch for Go Back button");
        softAssert.assertEquals(goBackButton.getCssValue("font-family").replace("\"", ""), "PT Sans, sans-serif", "Font family mismatch");
        softAssert.assertEquals(goBackButton.getCssValue("font-weight"), "700", "Font weight mismatch");
        softAssert.assertEquals(goBackButton.getCssValue("font-size"), "20px", "Font size mismatch");
        softAssert.assertEquals(goBackButton.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(26, 112, 179)", "Color mismatch");

        // Continue Button
        softAssert.assertEquals(btnContinue.getCssValue("background-color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(26, 112, 179)", "Background color mismatch");
        softAssert.assertEquals(btnContinue.getCssValue("border-color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(26, 112, 179)", "Border color mismatch");
        softAssert.assertEquals(btnContinue.getCssValue("padding"), "12px 20px", "Padding mismatch");
        softAssert.assertEquals(btnContinue.getCssValue("border-width"), "2px", "Border width mismatch");
        softAssert.assertEquals(btnContinue.getCssValue("border-radius"), "4px", "Border radius mismatch");

        softAssert.assertAll();
    }

    public void verifiEmploymentIncomeTextDesignYesOption() {
        basicActions.waitForElementToDisappear(txtHeaderPart1, 20);

        softAssert.assertEquals(txtHeaderPart1.getCssValue("font-size"), "36px", "Font size mismatch for Income");
        softAssert.assertEquals(txtHeaderPart1.getCssValue("font-weight"), "700", "Font weight mismatch for Income");
        softAssert.assertEquals(txtHeaderPart1.getCssValue("line-height"), "48px", "Line height mismatch for Income");
        softAssert.assertEquals(txtHeaderPart1.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Color mismatch for Income");

        softAssert.assertEquals(txtHeaderPart2.getText(), "Employment Income", "Header text mismatch for Employment Income");
        softAssert.assertEquals(txtHeaderPart2.getCssValue("font-size"), "28px", "Font size mismatch for Employment Income");
        softAssert.assertEquals(txtHeaderPart2.getCssValue("font-weight"), "700", "Font weight mismatch for Employment Income");
        softAssert.assertEquals(txtHeaderPart2.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Color mismatch for Employment Income");

        softAssert.assertEquals(haveAJobOrEmployedQuestion.getText(), "Do you have a job or are you currently employed?", "Label text mismatch");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getCssValue("font-family").replace("'", ""), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getCssValue("font-weight"), "400", "Font weight mismatch");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getCssValue("font-size"), "16px", "Font size mismatch");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Font color mismatch");



        softAssert.assertEquals(btnYesEmployed.getText(), "Yes", "Yes button text mismatch");
        softAssert.assertEquals(btnNoEmployed.getText(), "No", "No button text mismatch");

        softAssert.assertEquals(selfEmploymentQuestion.getCssValue("font-family").replace("'", ""), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(selfEmploymentQuestion.getCssValue("font-weight"), "400", "Font weight mismatch");
        softAssert.assertEquals(selfEmploymentQuestion.getCssValue("font-size"), "16px", "Font size mismatch");
        softAssert.assertEquals(selfEmploymentQuestion.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Font color mismatch");

        softAssert.assertEquals(btnYesEmployed.getCssValue("font-family").replace("'", ""), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(btnYesEmployed.getCssValue("font-weight"), "700", "Font weight mismatch");
        softAssert.assertEquals(btnYesEmployed.getCssValue("font-size"), "16px", "Font size mismatch");
        softAssert.assertEquals(btnYesEmployed.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(255, 255, 255)", "Font color mismatch");
        softAssert.assertEquals(btnYesEmployed.getCssValue("background-color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(112, 163, 0)", "Background color mismatch");
        softAssert.assertEquals(btnYesEmployed.getCssValue("border-color"), "rgb(112, 163, 0)", "Border color mismatch");
        softAssert.assertEquals(btnYesEmployed.getCssValue("padding"), "1px 6px", "Padding mismatch");
        softAssert.assertEquals(btnYesEmployed.getCssValue("border-radius"), "4px", "Border radius mismatch");


        softAssert.assertEquals(btnNoEmployed.getText(), "No", "No button text mismatch");
        softAssert.assertEquals(btnNoEmployed.getCssValue("font-family").replace("'", ""), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(btnNoEmployed.getCssValue("font-weight"), "400", "Font weight mismatch");
        softAssert.assertEquals(btnNoEmployed.getCssValue("font-size"), "16px", "Font size mismatch");
        softAssert.assertEquals(btnNoEmployed.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(77, 77, 79)", "Font color mismatch");
        softAssert.assertEquals(btnNoEmployed.getCssValue("background-color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(255, 255, 255)", "Background color mismatch");
        softAssert.assertEquals(btnNoEmployed.getCssValue("border-color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(149, 147, 147)", "Border color mismatch");
        softAssert.assertEquals(btnNoEmployed.getCssValue("padding"), "1px 6px", "Padding mismatch");
        softAssert.assertEquals(btnNoEmployed.getCssValue("border-radius"), "4px", "Border radius mismatch");


        softAssert.assertAll();
    }


    public void verifiEmploymentIncomeTextDesignNoOption() {

        basicActions.waitForElementToDisappear(txtHeaderPart1, 20);

        // Header Part 1
        softAssert.assertEquals(txtHeaderPart1.getCssValue("font-size"), "36px", "Font size mismatch for Income");
        softAssert.assertEquals(txtHeaderPart1.getCssValue("font-weight"), "700", "Font weight mismatch for Income");
        softAssert.assertEquals(txtHeaderPart1.getCssValue("line-height"), "48px", "Line height mismatch for Income");
        softAssert.assertEquals(txtHeaderPart1.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Color mismatch for Income");

        // Header Part 2
        softAssert.assertEquals(txtHeaderPart2.getText(), "Employment Income", "Header text mismatch for Employment Income");
        softAssert.assertEquals(txtHeaderPart2.getCssValue("font-size"), "28px", "Font size mismatch for Employment Income");
        softAssert.assertEquals(txtHeaderPart2.getCssValue("font-weight"), "700", "Font weight mismatch for Employment Income");
        softAssert.assertEquals(txtHeaderPart2.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Color mismatch for Employment Income");

        // Employment Question
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getText(), "Do you have a job or are you currently employed?", "Label text mismatch");
        softAssert.assertTrue(haveAJobOrEmployedQuestion.getCssValue("font-family").contains("PT Sans"), "Font family mismatch");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getCssValue("font-weight"), "400", "Font weight mismatch");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getCssValue("font-size"), "16px", "Font size mismatch");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Font color mismatch");

        // Self-Employment Question
        softAssert.assertEquals(selfEmploymentQuestion.getText(), "Is this job self-employment?", "Label text mismatch");
        softAssert.assertEquals(selfEmploymentQuestion.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch");
        softAssert.assertEquals(selfEmploymentQuestion.getCssValue("font-weight"), "400", "Font weight mismatch");
        softAssert.assertEquals(selfEmploymentQuestion.getCssValue("font-size"), "16px", "Font size mismatch");
        softAssert.assertEquals(selfEmploymentQuestion.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Font color mismatch");


        // Address Labels
        softAssert.assertEquals(addressLine1Label.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch for Address Line 1");
        softAssert.assertEquals(addressLine1Label.getCssValue("font-weight"), "400", "Font weight mismatch for Address Line 1");
        softAssert.assertEquals(addressLine1Label.getCssValue("font-size"), "16px", "Font size mismatch for Address Line 1");
        softAssert.assertEquals(addressLine1Label.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Font color mismatch for Address Line 1");


        softAssert.assertEquals(addressLine2Label.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch for Address Line 2");
        softAssert.assertEquals(addressLine2Label.getCssValue("font-weight"), "400", "Font weight mismatch for Address Line 2");
        softAssert.assertEquals(addressLine2Label.getCssValue("font-size"), "16px", "Font size mismatch for Address Line 2");
        softAssert.assertEquals(addressLine2Label.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Font color mismatch for Address Line 2");

        softAssert.assertEquals(cityLabel.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch for City");
        softAssert.assertEquals(cityLabel.getCssValue("font-weight"), "400", "Font weight mismatch for City");
        softAssert.assertEquals(cityLabel.getCssValue("font-size"), "16px", "Font size mismatch for City");
        softAssert.assertEquals(cityLabel.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Font color mismatch for City");


        softAssert.assertEquals(stateLabel.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch for State");
        softAssert.assertEquals(stateLabel.getCssValue("font-weight"), "400", "Font weight mismatch for State");
        softAssert.assertEquals(stateLabel.getCssValue("font-size"), "16px", "Font size mismatch for State");
        softAssert.assertEquals(stateLabel.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Font color mismatch for State");

        softAssert.assertEquals(zipCodeLabel.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch for Zip Code");
        softAssert.assertEquals(zipCodeLabel.getCssValue("font-weight"), "400", "Font weight mismatch for Zip Code");
        softAssert.assertEquals(zipCodeLabel.getCssValue("font-size"), "16px", "Font size mismatch for Zip Code");
        softAssert.assertEquals(zipCodeLabel.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Font color mismatch for Zip Code");

        // Income Question
        softAssert.assertEquals(currentGrossIncomeQuestion.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch for Gross Income");
        softAssert.assertEquals(currentGrossIncomeQuestion.getCssValue("font-weight"), "400", "Font weight mismatch for Gross Income");
        softAssert.assertEquals(currentGrossIncomeQuestion.getCssValue("font-size"), "16px", "Font size mismatch for Gross Income");
        softAssert.assertEquals(currentGrossIncomeQuestion.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Font color mismatch for Gross Income");

        // Commission Label
        softAssert.assertEquals(commissionLabel.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch for Commission Label");
        softAssert.assertEquals(commissionLabel.getCssValue("font-weight"), "400", "Font weight mismatch for Commission Label");
        softAssert.assertEquals(commissionLabel.getCssValue("font-size"), "14px", "Font size mismatch for Commission Label");
        softAssert.assertEquals(commissionLabel.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Font color mismatch for Commission Label");

        // Income Lower Next Year Question
        softAssert.assertEquals(incomeSameLowerNextYearQuestionWhenNoToSelfEmployedQuestion.getCssValue("font-family"), "\"PT Sans\", sans-serif", "Font family mismatch for Income Lower Next Year Question");
        softAssert.assertEquals(incomeSameLowerNextYearQuestionWhenNoToSelfEmployedQuestion.getCssValue("font-weight"), "400", "Font weight mismatch for Income Lower Next Year Question");
        softAssert.assertEquals(incomeSameLowerNextYearQuestionWhenNoToSelfEmployedQuestion.getCssValue("font-size"), "16px", "Font size mismatch for Income Lower Next Year Question");
        softAssert.assertEquals(incomeSameLowerNextYearQuestionWhenNoToSelfEmployedQuestion.getCssValue("color").replace("rgba(", "rgb(").replace(", 1)", ")"), "rgb(43, 49, 60)", "Font color mismatch for Income Lower Next Year Question");

        softAssert.assertAll();
    }

    public void verifyTextForSecondaryMemberOnInitialIncomePage(List<String> dataText) {
        basicActions.waitForElementToBePresent(txtHeaderPart1, 10);
        basicActions.waitForElementToBePresent(txtHeaderPart2, 10);
        basicActions.waitForElementToBePresent(haveAJobOrEmployedQuestion, 10);
        basicActions.waitForElementToBePresent(goBackButton, 10);
        basicActions.waitForElementToBePresent(btnContinue, 10);
        basicActions.waitForElementToBePresent(helpLabel, 10);
        basicActions.waitForElementToBePresent(btnYesEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoEmployed, 10);
        softAssert.assertEquals(txtHeaderPart1.getText(), dataText.get(0) + " " + SharedData.getMembers().get(0).getFirstName() + " " +  SharedData.getMembers().get(0).getMiddleName().charAt(0) + "." + " " + SharedData.getMembers().get(0).getLastName());
        softAssert.assertEquals(txtHeaderPart2.getText(), dataText.get(1), "Title Not matching");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getText(), dataText.get(2), "Question Not matching");
        softAssert.assertEquals(btnYesEmployed.getText(), dataText.get(3), "Yes button label not matching");
        softAssert.assertEquals(btnNoEmployed.getText(), dataText.get(4), "No button label not matching");
        softAssert.assertEquals(goBackButton.getText().trim(), dataText.get(5), "back button label not matching");
        softAssert.assertEquals(btnContinue.getText().trim(), dataText.get(6), "continue button label not matching");
        softAssert.assertAll();
    }

    public void verifyTextOnIncomePageForSecondaryMemberAfterSelectingYesToEmployment(List<String> dataText) {
        basicActions.waitForElementToBePresent(txtHeaderPart1, 10);
        basicActions.waitForElementToBePresent(txtHeaderPart2, 10);
        basicActions.waitForElementToBePresent(haveAJobOrEmployedQuestion, 10);
        basicActions.waitForElementToBePresent(goBackButton, 10);
        basicActions.waitForElementToBePresent(btnContinue, 10);
        basicActions.waitForElementToBePresent(helpLabel, 10);
        basicActions.waitForElementToBePresent(btnYesEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoEmployed, 10);
        basicActions.waitForElementToBePresent(selfEmploymentQuestion, 10);
        basicActions.waitForElementToBePresent(btnYesSelfEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoSelfEmployed, 10);
        softAssert.assertEquals(txtHeaderPart1.getText(), dataText.get(0) + " " + SharedData.getMembers().get(0).getFirstName() + " " +  SharedData.getMembers().get(0).getMiddleName().charAt(0) + "." + " " + SharedData.getMembers().get(0).getLastName());
        softAssert.assertEquals(txtHeaderPart2.getText(), dataText.get(1), "Title Not matching");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getText(), dataText.get(2), "Employment Question Not matching");
        softAssert.assertEquals(btnYesEmployed.getText(), dataText.get(3), "Yes button label for Employment question not matching");
        softAssert.assertEquals(btnNoEmployed.getText(), dataText.get(4), "No button label for Employment question not matching");
        softAssert.assertEquals(goBackButton.getText().trim(), dataText.get(5), "back button label not matching");
        softAssert.assertEquals(btnContinue.getText().trim(), dataText.get(6), "continue button label not matching");
        softAssert.assertEquals(selfEmploymentQuestion.getText(), dataText.get(7), "Self Employment Question Not matching");
        softAssert.assertEquals(btnYesSelfEmployed.getText(), dataText.get(8), "Yes button label for Self Employment question not matching");
        softAssert.assertEquals(btnNoSelfEmployed.getText(), dataText.get(9), "No button label for Self Employment question not matching");
        softAssert.assertAll();
    }

    public void verifyYesButtonIsSelectedForHaveAJobOrCurrentlyEmployedQuestion() {
        basicActions.waitForElementToBePresent(btnYesEmployed, 40);
        softAssert.assertTrue(btnYesEmployed.getAttribute("class").contains("option-button-selected"),"Yes button for have a job or currently employed question is not selected");
        softAssert.assertAll();
    }

    public void verifyPageTextForSecondaryMemberOnIncomePageAfterSelectingYesToSelfEmployment(List<String> dataText) {
        basicActions.waitForElementToBePresent(txtHeaderPart1, 10);
        basicActions.waitForElementToBePresent(txtHeaderPart2, 10);
        basicActions.waitForElementToBePresent(haveAJobOrEmployedQuestion, 10);
        basicActions.waitForElementToBePresent(goBackButton, 10);
        basicActions.waitForElementToBePresent(btnContinue, 10);
        basicActions.waitForElementToBePresent(helpLabel, 10);
        basicActions.waitForElementToBePresent(btnYesEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoEmployed, 10);
        basicActions.waitForElementToBePresent(selfEmploymentQuestion, 10);
        basicActions.waitForElementToBePresent(btnYesSelfEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoSelfEmployed, 10);
        basicActions.waitForElementToBePresent(companyNameLabel, 10);
        basicActions.waitForElementToBePresent(currentNetIncomeQuestion, 10);
        basicActions.waitForElementToBePresent(enterProfitLabel, 10);
        basicActions.waitForElementToBePresent(dollarSign, 10);
        basicActions.waitForElementToBePresent(amountLabelInAmountInputField, 10);
        basicActions.waitForElementToBePresent(selectOptionLabel, 10);
        basicActions.waitForElementToBePresent(incomeSameLowerNextYearQuestionWhenYesToSelfEmployedQuestion, 10);
        basicActions.waitForElementToBePresent(btnIncomeSameYes, 10);
        basicActions.waitForElementToBePresent(btnIncomeSameNo, 10);
        softAssert.assertEquals(txtHeaderPart1.getText(), dataText.get(0) + " " + SharedData.getMembers().get(0).getFirstName() + " " +  SharedData.getMembers().get(0).getMiddleName().charAt(0) + "." + " " + SharedData.getMembers().get(0).getLastName());
        softAssert.assertEquals(txtHeaderPart2.getText(), dataText.get(1), "Title Not matching");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getText(), dataText.get(2), "Employment Question Not matching");
        softAssert.assertEquals(btnYesEmployed.getText(), dataText.get(3), "Yes button label for Employment question not matching");
        softAssert.assertEquals(btnNoEmployed.getText(), dataText.get(4), "No button label for Employment question not matching");
        softAssert.assertEquals(goBackButton.getText().trim(), dataText.get(5), "back button label not matching");
        softAssert.assertEquals(btnContinue.getText().trim(), dataText.get(6), "continue button label not matching");
        softAssert.assertEquals(selfEmploymentQuestion.getText(), dataText.get(7), "Self Employment Question Not matching");
        softAssert.assertEquals(btnYesSelfEmployed.getText(), dataText.get(8), "Yes button label for Self Employment question not matching");
        softAssert.assertEquals(btnNoSelfEmployed.getText(), dataText.get(9), "No button label for Self Employment question not matching");
        softAssert.assertEquals(companyNameLabel.getText(), dataText.get(10), "Company Name label not matching");
        softAssert.assertEquals(currentNetIncomeQuestion.getText(), dataText.get(11), "Current Net Income question not matching");
        softAssert.assertEquals(enterProfitLabel.getText(), dataText.get(12), "Enter Profit label not matching");
        softAssert.assertTrue(dollarSign.isDisplayed(), "Dollar sign not visible"); // Verifying dollar sign is present
        softAssert.assertEquals(amountLabelInAmountInputField.getAttribute("Placeholder"), dataText.get(13), "amount label in input text field not matching");
        softAssert.assertEquals(selectOptionLabel.getText(), dataText.get(14), "Select Option Label not matching");
        softAssert.assertEquals(incomeSameLowerNextYearQuestionWhenYesToSelfEmployedQuestion.getText(), dataText.get(15), "Income same or Lower question not matching");
        softAssert.assertEquals(btnIncomeSameYes.getText(), dataText.get(16), "Yes button label for Income Same question not matching");
        softAssert.assertEquals(btnIncomeSameNo.getText(), dataText.get(17), "No button label for Income Same question not matching");
        softAssert.assertAll();
    }

    public void verifyTheMentionedButtonIsSelectedForTheSelfEmploymentQuestion(String button) {
        switch (button) {
            case "Yes":
                basicActions.waitForElementToBePresent(btnYesSelfEmployed, 30);
                softAssert.assertTrue(btnYesSelfEmployed.getAttribute("class").contains("option-button-selected"),"Yes button for self-employment question is not selected");
                softAssert.assertAll();
                break;
            case "No":
                basicActions.waitForElementToBePresent(btnNoSelfEmployed, 30);
                softAssert.assertTrue(btnNoSelfEmployed.getAttribute("class").contains("option-button-selected"),"No button for self-employment question is not selected");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + button);
        }
    }

    public void verifyPageTextForSecondaryMemberOnIncomePageAfterSelectingNoToSelfEmployment(List<String> dataText) {
        basicActions.waitForElementToBePresent(txtHeaderPart1, 10);
        basicActions.waitForElementToBePresent(txtHeaderPart2, 10);
        basicActions.waitForElementToBePresent(haveAJobOrEmployedQuestion, 10);
        basicActions.waitForElementToBePresent(goBackButton, 10);
        basicActions.waitForElementToBePresent(btnContinue, 10);
        basicActions.waitForElementToBePresent(helpLabel, 10);
        basicActions.waitForElementToBePresent(btnYesEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoEmployed, 10);
        basicActions.waitForElementToBePresent(selfEmploymentQuestion, 10);
        basicActions.waitForElementToBePresent(btnYesSelfEmployed, 10);
        basicActions.waitForElementToBePresent(btnNoSelfEmployed, 10);
        basicActions.waitForElementToBePresent(companyNameLabel, 10);
        basicActions.waitForElementToBePresent(dollarSign, 10);
        basicActions.waitForElementToBePresent(amountLabelInAmountInputField, 10);
        basicActions.waitForElementToBePresent(selectOptionLabel, 10);
        basicActions.waitForElementToBePresent(incomeSameLowerNextYearQuestionWhenNoToSelfEmployedQuestion, 10);
        basicActions.waitForElementToBePresent(btnIncomeSameYes, 10);
        basicActions.waitForElementToBePresent(btnIncomeSameNo, 10);
        basicActions.waitForElementToBePresent(addressLine1Label, 10);
        basicActions.waitForElementToBePresent(addressLine2Label, 10);
        basicActions.waitForElementToBePresent(cityLabel, 10);
        basicActions.waitForElementToBePresent(stateLabel, 10);
        basicActions.waitForElementToBePresent(stateDropDownLabel, 10);
        basicActions.waitForElementToBePresent(zipCodeLabel, 10);
        basicActions.waitForElementToBePresent(currentGrossIncomeQuestion, 10);
        basicActions.waitForElementToBePresent(commissionLabel, 10);
        basicActions.waitForElementToBePresent(incomeSeasonalQuestion, 10);
        basicActions.waitForElementToBePresent(btnIsSeasonalYes, 10);
        basicActions.waitForElementToBePresent(btnIsSeasonalNo, 10);
        softAssert.assertEquals(txtHeaderPart1.getText(), dataText.get(0) + " " + SharedData.getMembers().get(0).getFirstName() + " " +  SharedData.getMembers().get(0).getMiddleName().charAt(0) + "." + " " + SharedData.getMembers().get(0).getLastName());
        softAssert.assertEquals(txtHeaderPart2.getText(), dataText.get(1), "Title Not matching");
        softAssert.assertEquals(haveAJobOrEmployedQuestion.getText(), dataText.get(2), "Employment Question Not matching");
        softAssert.assertEquals(btnYesEmployed.getText(), dataText.get(3), "Yes button label for Employment question not matching");
        softAssert.assertEquals(btnNoEmployed.getText(), dataText.get(4), "No button label for Employment question not matching");
        softAssert.assertEquals(goBackButton.getText().trim(), dataText.get(5), "back button label not matching");
        softAssert.assertEquals(btnContinue.getText().trim(), dataText.get(6), "continue button label not matching");
        softAssert.assertEquals(selfEmploymentQuestion.getText(), dataText.get(7), "Self Employment Question Not matching");
        softAssert.assertEquals(btnYesSelfEmployed.getText(), dataText.get(8), "Yes button label for Self Employment question not matching");
        softAssert.assertEquals(btnNoSelfEmployed.getText(), dataText.get(9), "No button label for Self Employment question not matching");
        softAssert.assertEquals(companyNameLabel.getText(), dataText.get(10), "Company Name label not matching");
        softAssert.assertTrue(dollarSign.isDisplayed(), "Dollar sign not visible"); // Verifying dollar sign is present
        softAssert.assertEquals(amountLabelInAmountInputField.getAttribute("Placeholder"), dataText.get(11), "Amount label not matching");
        softAssert.assertEquals(selectOptionLabel.getText(), dataText.get(12), "Select option label not matching");
        softAssert.assertEquals(incomeSameLowerNextYearQuestionWhenNoToSelfEmployedQuestion.getText(), dataText.get(13), "Income same question not matching");
        softAssert.assertEquals(btnIncomeSameYes.getText(), dataText.get(14), "Yes button label for Income same question not matching");
        softAssert.assertEquals(btnIncomeSameNo.getText(), dataText.get(15), "No button label for Income same question not matching");
        softAssert.assertEquals(addressLine1Label.getText(), dataText.get(16), "Address line1 label not matching");
        softAssert.assertEquals(addressLine2Label.getText(), dataText.get(17), "Address line2 label not matching");
        softAssert.assertEquals(cityLabel.getText(), dataText.get(18), "City label not matching");
        softAssert.assertEquals(stateLabel.getText(), dataText.get(19), "State label not matching");
        softAssert.assertEquals(stateDropDownLabel.getText(), dataText.get(20), "Select Option label for state dropdown not matching");
        softAssert.assertEquals(zipCodeLabel.getText(), dataText.get(21), "zip code label not matching");
        softAssert.assertEquals(currentGrossIncomeQuestion.getText(), dataText.get(22), "Current Gross Income question not matching");
        softAssert.assertEquals(commissionLabel.getText(), dataText.get(23), "Commission label not matching");
        softAssert.assertEquals(incomeSeasonalQuestion.getText(), dataText.get(24), "Income Seasonal question not matching");
        softAssert.assertEquals(btnIsSeasonalYes.getText(), dataText.get(25), "Yes button label for Income seasonal question not matching");
        softAssert.assertEquals(btnIsSeasonalNo.getText(), dataText.get(26), "No button label for Income seasonal question not matching");
        softAssert.assertAll();
    }


}


