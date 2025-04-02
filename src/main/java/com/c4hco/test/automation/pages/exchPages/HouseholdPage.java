package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HouseholdPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public HouseholdPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    // update locators to ids and rename methods
    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id = "submitButton_ContinueIncome")
    WebElement saveAndContinue;

    @FindBy(id = "submitButton_AddMember")
    WebElement addAdditionalMember;

    @FindBy(xpath = "//*[@id='memberMgmt']//tr[2]/td[1]/input")
    WebElement viewDetailsLink;

    @FindBy(id = "submitButton_Income")
    WebElement editIncomeLink;

    @FindBy(xpath = "//input[@class = 'linkButton']")
    WebElement editPrimaryMember;

    @FindBy(css = ".memberBasicRow  #editBasicInfo")
    List<WebElement> memberBasicInformation;

    @FindBy(css = ".table-striped")
    WebElement familyOverviewTable;

    @FindBy(xpath = "//*[@class = 'fa fa-plus-circle toggleAddlRow']")
    List<WebElement> tableDropdown;

    @FindBy(css = "input[value='Edit'][alt='Submit']")
    WebElement redIcon;

    @FindBy(css = ".memberBasicRow input.linkButton[type='submit']")
    List<WebElement> memberNamesLinks;

    @FindBy(xpath = "//*[contains(text(),'Account ID:') or contains(text(),'Identificaci\u00F3n de la cuenta')]")
    WebElement accountIdTxt;

    @FindBy(css = ".memberBasicRow .linkButton[name=\'hhSelectMember\']")
    List<WebElement> basicMemberList;

    @FindBy(xpath = "//tr[4]//input[@name='hhDeleteMember']")
    WebElement removeMemberLnk;
    @FindBy(xpath = "//td[normalize-space()='Not Applicable']")
    WebElement nfaInfo;
    @FindBy(id = "totalIncome")
    WebElement faInfo;

    @FindBy(xpath = "//*[@class = 'c4PageHeader']")
    WebElement getFamilyOverviewHeader;

    @FindBy(id = "overviewButton")
    WebElement getHelpMeLink;

    @FindBy(xpath = "//*[contains(text(),'Account ID:')]")
    WebElement getAcctID;

    @FindBy(xpath = "//*[contains(text(),'Identificaci\u00F3n de la cuenta')]")
    WebElement getAcctIDSP;

    @FindBy(xpath = "//span[contains(text(),'Tax Household #1')]")
    WebElement getTaxHouseholdID;

    @FindBy(xpath = "//span[contains(text(),'Hogar Fiscal #1')]")
    WebElement getTaxHouseholdIDSP;

    @FindBy(xpath = "//*[@class = 'table table-striped']")
    WebElement getTableText;


    @FindBy(xpath = "//*[contains(text(),'Complete')]")
    WebElement getCompleteText;

    @FindBy(xpath = "//*[contains(text(),'Incomplete')]")
    WebElement getInCompleteText;

    @FindBy(xpath = "//*[contains(text(),'Completa')]")
    WebElement getCompleteTextSP;

    @FindBy(xpath = "//*[contains(text(),'Incompleta')]")
    WebElement getInCompleteTextSP;

    @FindBy(xpath="//input[@id='submitButton_AddMember']")
    WebElement getAdditionalMemberText;

    @FindBy(xpath="//input[@id='submitButton_AddMember']")
    WebElement getAdditionalMemberTextSP;

    @FindBy(xpath="//input[@id='submitButton_ContinueIncome']")
    WebElement getSaveAndContinueText;
    @FindBy(xpath="//input[@id='submitButton_ContinueIncome']")
    WebElement getGetSaveAndContinueTextSP;






    public void clickAddMember() {
        basicActions.waitForElementToBeClickable(addAdditionalMember, 15);
        addAdditionalMember.click();
    }

    public void clickContinue() {
        basicActions.waitForElementToBePresent(saveAndContinue, 15);
        getAccountId();
        saveAndContinue.click();
    }

    public void getAccountId() {
        basicActions.waitForElementToBePresent(accountIdTxt, 15);

        Matcher matcher = Pattern.compile("\\d+").matcher(accountIdTxt.getText());
        String accId = matcher.find() ? matcher.group() : null;

        SharedData.getPrimaryMember().setAccount_id(new BigDecimal(accId));
        System.out.println("Account_id : " + new BigDecimal(accId));
    }


    public void iVerifyFamilyOverviewTablePresent() {
        // TO DO:: Sometimes, rarely we see 2 tables here. Make sure the code doesn't break when we get 2 tables displayed
        basicActions.waitForElementToBePresent(familyOverviewTable, 30);
        softAssert.assertTrue(familyOverviewTable.isDisplayed());
        softAssert.assertAll();
    }

    public void iClickTableItem(String namePrefix) {
        basicActions.waitForElementToBePresent(editPrimaryMember, 30);
        basicActions.waitForElementListToBePresent(tableDropdown, 30);
        String xpath = String.format("//*[contains(@value,'"+namePrefix+"')]//preceding::i[2]");
        WebElement button = basicActions.getDriver().findElement(By.xpath(xpath));
        button.click();
    }

    public void clickViewDetails(String namePrefix) {
        basicActions.waitForElementToBePresent(viewDetailsLink, 15);
        String xpath = String.format("//*[contains(@value,'"+namePrefix+"')]//following::input[1]");
        WebElement button = basicActions.getDriver().findElement(By.xpath(xpath));
        button.click();
    }

    public void clickBasicInfoMemberButton(String namePrefix) {
        basicActions.waitForElementListToBePresent(memberBasicInformation, 15);
        String xpath = String.format("//*[contains(@value,'"+namePrefix+"')]//following::*[@id='editBasicInfo'][1]");
        WebElement button = basicActions.getDriver().findElement(By.xpath(xpath));
        button.click();
    }

    public void iClickEditIncomeLink(String namePrefix) {
        basicActions.waitForElementToBePresent(editIncomeLink, 15);
        editIncomeLink.isDisplayed();
        String xpath = String.format("//*[contains(@value,'"+namePrefix+"')]//following::*[@id='submitButton_Income'][1]");
        WebElement button = basicActions.getDriver().findElement(By.xpath(xpath));
        button.click();
    }

    public void clickMember(String memNameToClick) {
        basicActions.waitForElementListToBePresent(memberNamesLinks, 10);
        for (WebElement memNameLink : memberNamesLinks) {
            if (memNameLink.getAttribute("value").contains(memNameToClick)) {
                memNameLink.click();
                break;
            }
        }
    }

    public void clickRemoveMember() {
        basicActions.waitForElementToBePresent(removeMemberLnk, 20);
        basicActions.scrollToElement(removeMemberLnk);
        removeMemberLnk.click();
    }

    public void clickOptionOnRemoveWindow(String option) {
        Alert alert = basicActions.getDriver().switchTo().alert();
        switch (option) {
            case "OK":
                alert.accept();
                break;
            case "Cancel":
                alert.dismiss();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
    }

    public void verifyNoErrorMessage_Household() {
        Assert.assertTrue(basicActions.waitForElementToDisappear(redIcon, 30), "Error is displayed");
    }
    public void verifyAnnualFinancialInformation(String financialInfo){

        switch (financialInfo) {
            case "NFA":
                softAssert.assertEquals(nfaInfo.getText(), "Not Applicable");
                break;

            case "FA":
                softAssert.assertEquals(faInfo.getText().replaceAll("[^0-9]", ""),SharedData.getFinancialIncome());
                System.out.println(SharedData.getFinancialIncome()+"shared data"+faInfo.getText().replaceAll("[^0-9]", "")+"web");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + financialInfo);
        }
        softAssert.assertAll();
    }


    public void iValidateTextDisplayed(String language){
        basicActions.waitForElementToDisappear( spinner, 20 );
        switch (language) {
            case "English":
                validateEnglishHousehold();
                break;
            case "Spanish":
                validateSpanishHousehold();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + language );

        }

    }

    public void validateEnglishHousehold(){
       basicActions.waitForElementToDisappear( spinner, 100 );
        softAssert.assertEquals( getFamilyOverviewHeader.getText(), "Family Overview: Here's what you've told us so far" );
        softAssert.assertEquals( getHelpMeLink.getText(), "Help me understand this page" );
        softAssert.assertTrue(getAcctID.getText().contains("Account ID:"));
        softAssert.assertEquals( getTaxHouseholdID.getText(), "Tax Household #1" );

        softAssert.assertEquals( getTableText.getText(), "NAME APPLYING FOR\n"+
                "HEALTH INSURANCE? BASIC INFORMATION ANNUAL FINANCIAL\n"+
                "INFORMATION\n"+
                "Yes\n"+
                "Not Started\n"+
                "\n"+
                "\n"+
                "HOUSEHOLD TOTAL \u00A40.00");

        softAssert.assertEquals( getCompleteText.getText(), "Complete" );
        softAssert.assertEquals( getInCompleteText.getText(), "Incomplete" );

        softAssert.assertEquals( getAdditionalMemberText.getAttribute("value"), "+ Add another family member" );
        softAssert.assertEquals( getSaveAndContinueText.getAttribute("value"), "Save and Continue" );
        softAssert.assertAll();
    }

    public void validateSpanishHousehold(){
        basicActions.waitForElementToDisappear( spinner, 20 );
        softAssert.assertEquals( getFamilyOverviewHeader.getText(), "Resumen de la familia: Esta es la informaci\u00F3n que nos ha dado hasta el momento" );
        softAssert.assertEquals( getHelpMeLink.getText(), "Ayuda para entender esta p\u00E1gina" );
        softAssert.assertTrue(getAcctIDSP.getText().contains("Identificaci\u00F3n de la cuenta"));
        softAssert.assertEquals( getTaxHouseholdIDSP.getText(), "Hogar Fiscal #1" );

        softAssert.assertEquals( getTableText.getText(), "NOMBRE PARA SOLICITAR\n" +
                "SEGURO DE SALUD INFORMACI\u00D3N B\u00C1SICA INFORMACI\u00D3N\n" +
                "FINANCIERA ANUAL\n" +
                "S\u00ED\n" +
                "No iniciada\n"+
                "\n"+
                "\n"+
                "TOTAL DEL HOGAR \u00A40.00");

        softAssert.assertEquals( getCompleteTextSP.getText(), "Completa");
        softAssert.assertEquals( getInCompleteTextSP.getText(), "Incompleta");

        softAssert.assertEquals( getAdditionalMemberTextSP.getAttribute("value"), "+ Agregar a otro miembro de la familia" );
        softAssert.assertEquals( getGetSaveAndContinueTextSP.getAttribute("value"), "Guardar y Continuar" );
        softAssert.assertAll();

    }
}