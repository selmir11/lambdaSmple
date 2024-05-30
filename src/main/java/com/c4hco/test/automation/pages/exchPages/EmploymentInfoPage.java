package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.List;


public class EmploymentInfoPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public EmploymentInfoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "header-1 content-center")
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

    @FindBy(css = "lib-help-icon a")
    List<WebElement> helpIcons;

    @FindBy(css = ".drawer-heading .body-text-1")
    WebElement helpDrawerHeaderHelp;

    @FindBy(css = ".drawer-heading .drawer-title")
    WebElement helpDrawerHeaderIncome;

    @FindBy(css = ".drawer .header-1")
    List<WebElement> helpDrawerMainHeaders;

    @FindBy(css = ".drawer .header-2")
    List<WebElement> helpDrawerOverviewHeaders;

    @FindBy(css = ".drawer-body .drawer-text-content")
    WebElement questionsHelpText;

    @FindBy(css = ".drawer-text-content p")
    List<WebElement> helpDrawerBodyParagraphs;

    @FindBy(css = ".drawer-text-content li")
    List<WebElement> helpDrawerBodyPoints;

    @FindBy(css = ".drawer-footer h3")
    WebElement helpDrawerFooter;

    @FindBy(css = ".drawer-footer h3 a")
    WebElement helpDrawerContactUsLink;

    @FindBy(xpath = "(//a[@class=’clickable link-text-1’])[0]")
    List<WebElement>EditUpdateLink;

    public void clickEditUpdateLink(int employer){
    basicActions.waitForElementListToBePresent(EditUpdateLink, 10);
        EditUpdateLink.get(employer).click();
    }

    public void isUserEmployed(String employmentOption) {
        basicActions.waitForElementToBeClickable(btnYesEmployed, 10);

        switch (employmentOption) {
            case "Yes":
                btnYesEmployed.click();
                break;
            case "No":
                btnNoEmployed.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + employmentOption);
        }
    }

    public void isUserSelfEmplyed(String selfEmploymentOption) {
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

    public static String getUniqueString(int length){
        return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");
    }

    public void addEmploymentInfo(String Salary, String Frequency) {
        // Should not use this method anymore- should use genericEmploymentInfo method
        SharedData.setEmployerName(getUniqueString(8)+"Company");
        txtCompanyName.sendKeys(SharedData.getEmployerName());
        txtAddressOne.sendKeys("123 Test Address");
        txtAddressTwo.sendKeys("Test Suite 321");
        txtCity.sendKeys("Denver");

        Select dropdown = new Select(selectState);
        dropdown.selectByVisibleText(" CO ");

        txtZip.sendKeys("80205");
        txtIncomeAmount.sendKeys(Salary);

        dropdown = new Select(selectIncomeFreq);
        dropdown.selectByVisibleText(" " + Frequency + " ");
    }

    public void genericEmploymentInfo(String addressline1, String city,String state, String zipcode, String Salary, String Frequency){
        SharedData.setEmployerName(getUniqueString(8)+" Company");
        txtCompanyName.sendKeys(SharedData.getEmployerName());
        txtAddressOne.sendKeys(addressline1);
        txtCity.sendKeys(city);

        Select dropdown = new Select(selectState);
        dropdown.selectByVisibleText(state);

        txtZip.sendKeys(zipcode);
        txtIncomeAmount.sendKeys(Salary);

        dropdown = new Select(selectIncomeFreq);
        dropdown.selectByVisibleText(" " + Frequency + " ");
    }

    public void enterEmploymentIncome(String Salary) {
        basicActions.waitForElementToBePresent(txtIncomeAmount,15);
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
        basicActions.waitForElementToBeClickable(btnContinue,50);
        basicActions.scrollToElement(btnContinue);
        btnContinue.click();
    }

    public void clickHelpIcon(String label) {
        basicActions.waitForElementListToBePresent(helpIcons, 10);
        switch(label){
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
            default:
                throw new IllegalArgumentException("Invalid option: " + label);
        }
    }

    public void clickHelpContactUsNavigation() {
        basicActions.waitForElementToBePresent(helpDrawerContactUsLink, 10);
        helpDrawerContactUsLink.click();
    }

    // ############################## VALIDATION METHODS #########################

    public void validateHelpHeaderVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Income");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Ingreso");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateGeneralHelpBodyVerbiage(String language){
        basicActions.click(helpDrawerMainHeaders.get(0));
        basicActions.click(helpDrawerBodyParagraphs.get(0));
        basicActions.click(helpDrawerBodyPoints.get(0));
        switch(language){
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
                softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText()+" "+helpDrawerOverviewHeaders.get(0).getText(), "Income Overview");
                softAssert.assertEquals(helpDrawerMainHeaders.get(1).getText()+" "+helpDrawerOverviewHeaders.get(1).getText(), "Employment Overview");
                softAssert.assertEquals(helpDrawerMainHeaders.get(2).getText()+" "+helpDrawerOverviewHeaders.get(2).getText(), "Employment Overview");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "We need to know how much you and your family members earn at your job(s).");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "We need to know about the company you work for.");
                softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "We need to know how much money you make from self-employment.");
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

    public void validateGeneralHelpBodyVerbiageSp() {
        softAssert.assertEquals(helpDrawerMainHeaders.get(0).getText()+" "+helpDrawerOverviewHeaders.get(0).getText(), "Ingreso Resumen");
        softAssert.assertEquals(helpDrawerMainHeaders.get(1).getText()+" "+helpDrawerOverviewHeaders.get(1).getText(), "Empleo Resumen");
        softAssert.assertEquals(helpDrawerMainHeaders.get(2).getText()+" "+helpDrawerOverviewHeaders.get(2).getText(), "Empleo Resumen");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(0).getText(), "Necesitamos saber cu\u00E1nto ganan usted y los miembros de su familia en su(s) trabajo(s).");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(2).getText(), "Necesitamos informaci\u00F3n sobre la empresa para la que trabaja usted.");
        softAssert.assertEquals(helpDrawerBodyParagraphs.get(4).getText(), "Necesitamos saber cu\u00E1nto gana como trabajador independiente.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(0).getText(), "Empleo\n" +
                "\u00BFEsta persona tiene un ingreso como empleado o como trabajador independiente?");
        softAssert.assertEquals(helpDrawerBodyPoints.get(1).getText(), "Nombre de la empresa\n" +
                "Ingrese el nombre de la empresa de cada trabajo.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(2).getText(), "Ingreso bruto\n" +
                "Indique la cantidad total que le pagan en este trabajo ANTES de descontar impuestos o hacer otras deducciones (como aportes para el retiro). Es el salario bruto y debe ser m\u00E1s que la cantidad que recibe en cheque o le depositan en su cuenta bancaria, que es el salario neto.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(3).getText(), "Trabajo temporal, por comisiones o por propinas\n" +
                "Esta pregunta nos ayuda a calcular el ingreso anual de los clientes que no tienen el mismo ingreso cada semana o mes.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(4).getText(), "Igual o bajar\u00E1\n" +
                "Le hacemos esta pregunta para asegurarnos de calcular correctamente su ingreso anual, como es el caso de clientes que no tienen un ingreso constante.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(5).getText(), "Ingreso neto\n" +
                "Indique su ingreso como trabajador independiente despues de pagar sus gastos de negocios. (Ingreso neto a veces se llama \"ganacias\".)");
        softAssert.assertEquals(helpDrawerBodyPoints.get(6).getText(), "Igual o bajar\u00E1\n" +
                "Le hacemos esta pregunta para asegurarnos de calcular correctamente su ingreso anual, como es el caso de clientes que no tienen un ingreso constante.");
        softAssert.assertEquals(helpDrawerBodyPoints.get(7).getText(), "Direcci\u00F3n del empleador\n" +
                "Connect for Health Colorado notificar\u00E1 a un empleador si un empleado ha sido determinado elegible para Cr\u00E9dito fiscal anticipado para la cuota y/o reducciones en los costos compartidos y se ha inscrito en un Plan de salud calificado. El empleador tiene el derecho a presentar una apelaci\u00F3n si creen que esta determinaci\u00F3n es incorrecta. Se requiere la informaci\u00F3n de contacto correcta para el empleador para apoyar este proceso, por favor verifique que la informaci\u00F3n del empleador esta correcta.");
        softAssert.assertAll();
    }

    public void validateHelpFooterVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerFooter, 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
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
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        basicActions.waitForElementToBePresent(questionsHelpText, 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter, 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Employment");
                softAssert.assertEquals(questionsHelpText.getText(), "Does this person earn money through a job or by being self-employed?");
                softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Empleo");
                softAssert.assertEquals(questionsHelpText.getText(), "\u00BFEsta persona tiene un ingreso como empleado o como trabajador independiente?");
                softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateCompanyHelpVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        basicActions.waitForElementToBePresent(questionsHelpText, 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter, 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Company Name");
                softAssert.assertEquals(questionsHelpText.getText(), "Connect for Health Colorado will notify an employer if an employee has been determined eligible for Advance Premium Tax Credits and/or Cost-Sharing Reductions and has enrolled in a Qualified Health Plan. The employer has the right to file an appeal if they believe this determination is incorrect. The correct contact information for the employer is required to support the employer appeal process, so please double check your entry of the employer contact information.");
                softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Direcci\u00F3n del empleador");
                softAssert.assertEquals(questionsHelpText.getText(), "Connect for Health Colorado notificar\u00E1 a un empleador si un empleado ha sido determinado elegible para Cr\u00E9dito fiscal anticipado para la cuota y/o reducciones en los costos compartidos y se ha inscrito en un Plan de salud calificado. El empleador tiene el derecho a presentar una apelaci\u00F3n si creen que esta determinaci\u00F3n es incorrecta. Se requiere la informaci\u00F3n de contacto correcta para el empleador para apoyar este proceso, por favor verifique que la informaci\u00F3n del empleador esta correcta.");
                softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateNetIncomeHelpVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        basicActions.waitForElementToBePresent(questionsHelpText, 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter, 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Net Income");
                softAssert.assertEquals(questionsHelpText.getText(), "Tell us your income from your self-employment after business expenses have been paid. (Net income is sometimes called \"profit\".)");
                softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Ingreso neto");
                softAssert.assertEquals(questionsHelpText.getText(), "Indique su ingreso como trabajador independiente despues de pagar sus gastos de negocios. (Ingreso neto a veces se llama \"ganacias\".)");
                softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateIncomeChangeHelpVerbiage(String language) {
        basicActions.waitForElementToBePresent(helpDrawerHeaderHelp, 10);
        basicActions.waitForElementToBePresent(helpDrawerHeaderIncome, 10);
        basicActions.waitForElementToBePresent(questionsHelpText, 10);
        basicActions.waitForElementToBePresent(helpDrawerFooter, 10);
        switch (language) {
            case "English":
                softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Help");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Same or lower");
                softAssert.assertEquals(questionsHelpText.getText(), "We ask this question to make sure the calculation of your annual income is correct for customers who don't have consistent income.");
                softAssert.assertEquals(helpDrawerFooter.getText(), "Need more help? Contact us");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(helpDrawerHeaderHelp.getText(), "Ayuda");
                softAssert.assertEquals(helpDrawerHeaderIncome.getText(), "Igual o bajar\u00E1");
                softAssert.assertEquals(questionsHelpText.getText(), "Le hacemos esta pregunta para asegurarnos de calcular correctamente su ingreso anual, como es el caso de clientes que no tienen un ingreso constante.");
                softAssert.assertEquals(helpDrawerFooter.getText(), "\u00BFNecesitas m\u00E1s ayuda? Cont\u00E1ctenos");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

}