package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.ApplicationProperties;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LifeChangeEventsCoCoPage {

    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public LifeChangeEventsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".header-1")
    WebElement hdr_Lce;

    @FindBy(css = ".page-header")
    WebElement hdr_LceText;

    @FindBy(css = "#ELIG-LceOption-LOSS_OF_MEC_OTHER-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement insuranceLossLCEContainer;
    @FindBy(id = "ELIG-LceOption-LOSS_OF_MEC_OTHER-checkBoxButton")
    WebElement insuranceLossLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-LOSS_OF_MEC_OTHER')]")
    List<WebElement> allMemberInsuranceLossCheckbox;
    @FindBy (xpath = "//input[contains(@id, 'ELIG-LceMember-LOSS_OF_MEC_OTHER')]")
    List<WebElement> insuranceLossEventDate;
    @FindBy(css = "#ELIG-LceOption-BIRTH_ADOPTION_OR_PLACEMENT_FOR_ADOPTION-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement birthLCEContainer;
    @FindBy(id = "ELIG-LceOption-BIRTH_ADOPTION_OR_PLACEMENT_FOR_ADOPTION-checkBoxButton")
    WebElement birthLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-BIRTH')]")
    List<WebElement> allMembersBirthCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-BIRTH')]")
    List<WebElement> birthEventDate;
    @FindBy(css = "#ELIG-LceOption-PREGNANCY-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement pregnancyLCEContainer;
    @FindBy(id = "ELIG-LceOption-PREGNANCY-checkBoxButton")
    WebElement pregnancyLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-PREGNANCY')]")
    List<WebElement> allMembersPregnancyCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-PREGNANCY')]")
    List<WebElement> pregnancyEventDate;
    @FindBy(css = "#ELIG-LceOption-MARRIAGE_CIVILUNION_OR_DOMESTIC_PARTNER-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement marriageLCEContainer;
    @FindBy(id ="ELIG-LceOption-MARRIAGE_CIVILUNION_OR_DOMESTIC_PARTNER-checkBoxButton")
    WebElement marriageLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-MARRIAGE')]")
    List<WebElement> allMembersMarriageCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-MARRIAGE')]")
    List<WebElement> marriageEventDate;
    @FindBy(css = "#ELIG-LceOption-DIVORCE_ANNULMENT_OR_SEPARATION-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement divorceLCEContainer;
    @FindBy(id ="ELIG-LceOption-DIVORCE_ANNULMENT_OR_SEPARATION-checkBoxButton")
    WebElement divorceLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-DIVORCE')]")
    List<WebElement> allMembersDivorceCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-DIVORCE')]")
    List<WebElement> divorceEventDate;
    @FindBy(css = "#ELIG-LceOption-DEATH-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement deathLCEContainer;
    @FindBy(id ="ELIG-LceOption-DEATH-checkBoxButton")
    WebElement deathLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-DEATH')]")
    List<WebElement> allMembersDeathCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-DEATH')]")
    List<WebElement> deathEventDate;
    @FindBy(css = "#ELIG-LceOption-CHANGE_OF_RESIDENCE-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement addressChangeLCEContainer;
    @FindBy(id="ELIG-LceOption-CHANGE_OF_RESIDENCE-checkBoxButton")
    WebElement addressChangeLCE; //Moved to Colorado
    @FindBy(css=".c4-input [id^='ELIG-LceMember-CHANGE_OF_RESIDENCE-Member'][role='checkbox']")
    List<WebElement> qamemberChangeOfAddressCheckbox;

    @FindBy(css=".checkbox-description [id^='ELIG-LceMember-CHANGE']")
    List<WebElement> stgmemberChangeOfAddressCheckbox;

    @FindBy(css = ".c4-input [id^='ELIG-LceMember-CHANGE_OF_RESIDENCE-Member'][type='date']")
    List<WebElement> qachangeOfAddressEventDate;

    @FindBy(css = ".col [id^='ELIG-LceMember-CHANGE']")
    List<WebElement> stgchangeOfAddressEventDate;

    @FindBy(xpath = "//button[contains(@id,'movedToColorado-checkBoxButton')]")
    List<WebElement> movedToColoradoCheckbox;
    @FindBy(css = "#ELIG-LceOption-noneOfThese-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    //@FindBy(css = "#-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement noneOfTheseLCEContainer;
    @FindBy(id ="ELIG-LceOption-noneOfThese-checkBoxButton")
    WebElement noneOfTheseLCE;
    @FindBy(id = "LceOverview-SaveAndContinue")
    WebElement saveAndContinueButton;
    @FindBy(id = "LceOverview-GoBack")
    WebElement goBackButton;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd");
        Date date = new Date();
        // Now format the date
        return dateFormat.format(date);
    }

    public void selectLCE(String LCEType) {
        basicActions.waitForElementToDisappear(spinner,20);
        switch (LCEType) {
            case "InsuranceLoss":
                basicActions.waitForElementToBeClickable(insuranceLossLCE,10);
                insuranceLossLCE.click();
                for (var i = 0; i < allMemberInsuranceLossCheckbox.size(); i++) {
                    allMemberInsuranceLossCheckbox.get(i).click();
                    insuranceLossEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "Birth":
                basicActions.waitForElementToBeClickable(birthLCE,10);
                birthLCE.click();
                for (var i = 0; i < allMembersBirthCheckbox.size(); i++) {
                    allMembersBirthCheckbox.get(i).click();
                    birthEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "Pregnancy":
                basicActions.waitForElementToBeClickable(pregnancyLCE,10);
                pregnancyLCE.click();
                for (var i = 0; i < allMembersPregnancyCheckbox.size(); i++) {
                    allMembersPregnancyCheckbox.get(i).click();
                    pregnancyEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "Marriage":
                basicActions.waitForElementToBeClickable(marriageLCE,10);
                marriageLCE.click();
                for (var i = 0; i < allMembersMarriageCheckbox.size(); i++) {
                    allMembersMarriageCheckbox.get(i).click();
                    marriageEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "Divorce":
                basicActions.waitForElementToBeClickable(divorceLCE,10);
                divorceLCE.click();
                for (var i = 0; i < allMembersDivorceCheckbox.size(); i++) {
                    allMembersDivorceCheckbox.get(i).click();
                    divorceEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "Death":
                basicActions.waitForElementToBeClickable(deathLCE,10);
                deathLCE.click();
                for (var i = 0; i < allMembersDeathCheckbox.size(); i++) {
                    allMembersDeathCheckbox.get(i).click();
                    deathEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "MoveToCO":
                basicActions.waitForElementToBeClickable(addressChangeLCE,10);
                addressChangeLCE.click();
                List<WebElement> memberChangeOfAddressCheckbox = null;
                List<WebElement> changeOfAddressEventDate = null;

                memberChangeOfAddressCheckbox = qamemberChangeOfAddressCheckbox;
                changeOfAddressEventDate = qachangeOfAddressEventDate;


                for (var i = 0; i < memberChangeOfAddressCheckbox.size(); i++) {
                    basicActions.waitForElementToBeClickable(memberChangeOfAddressCheckbox.get(i),10);
                    memberChangeOfAddressCheckbox.get(i).click();
                    basicActions.waitForElementToBePresent(changeOfAddressEventDate.get(i),10);
                    changeOfAddressEventDate.get(i).sendKeys(getCurrentDate());
                    movedToColoradoCheckbox.get(i).click();
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + LCEType);
        }
    }

    public void selectNoneOfThese(){
        basicActions.waitForElementToBeClickableWithRetries(noneOfTheseLCE,10);
        noneOfTheseLCE.click();
    }

    public void saveAndContinue(){
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueButton,10);
        saveAndContinueButton.click();
    }

    public void goBack(){
        basicActions.waitForElementToBeClickable(goBackButton, 10);
        goBackButton.click();
    }

    //////////////////////////////////////////////VALIDATION METHODS//////////////////////////////////////////////////
    public void verifyHeadersEmploymentIncomePage(String language){
        switch (language){
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

    public void verifyHeadersEmploymentIncomePageEnglish(){
        basicActions.waitForElementToBePresent(hdr_Lce,15);
        softAssert.assertEquals(hdr_Lce.getText(), "Tell us about life changes");
        softAssert.assertEquals(hdr_LceText.getText(), "Select any Life Change Event you or someone in your household has experienced within the past 60 days. The loss of other health insurance can be reported up to 60 days before you lose the insurance.");
        softAssert.assertAll();
    }

    public void verifyHeadersEmploymentIncomePageSpanish(){
        basicActions.waitForElementToBePresent(hdr_Lce,15);
        softAssert.assertEquals(hdr_Lce.getText(), "Inf\u00F3rmenos sobre los cambios importantes en su vida");
        softAssert.assertEquals(hdr_LceText.getText(), "Seleccione los cambios de vida que usted o alguien de su familia haya tenido en los \u00FAltimos 60 d\u00EDas. La p\u00E9rdida de seguro de salud se puede reportar hasta 60 d\u00EDas antes de que alguien pierda su seguro.");
        softAssert.assertAll();
    }

    public void verifyLCECheckboxState(String LCEType,String Selection){
        basicActions.waitForElementToDisappear(spinner,20);
        switch (LCEType) {
            case "InsuranceLoss":
                basicActions.waitForElementToBePresent(insuranceLossLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(insuranceLossLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(insuranceLossLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "Birth":
                basicActions.waitForElementToBePresent(birthLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(birthLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(birthLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "Pregnancy":
                basicActions.waitForElementToBePresent(pregnancyLCEContainer,25);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(pregnancyLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(pregnancyLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "Marriage":
                basicActions.waitForElementToBePresent(marriageLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(marriageLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(marriageLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "Divorce":
                basicActions.waitForElementToBePresent(divorceLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(divorceLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(divorceLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "Death":
                basicActions.waitForElementToBePresent(deathLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(deathLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(deathLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "MoveToCO":
                basicActions.waitForElementToBePresent(addressChangeLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(addressChangeLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(addressChangeLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "NoneOfThese":
                basicActions.waitForElementToBePresent(noneOfTheseLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(noneOfTheseLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(noneOfTheseLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "AllSingle":
                basicActions.waitForElementToBePresent(insuranceLossLCEContainer,15);
                switch (Selection){
                    case "is":
                        softAssert.assertEquals(insuranceLossLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(birthLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(pregnancyLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(marriageLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(divorceLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(addressChangeLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(noneOfTheseLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(insuranceLossLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(birthLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(pregnancyLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(marriageLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(divorceLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(addressChangeLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(noneOfTheseLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "All":
                basicActions.waitForElementToBePresent(insuranceLossLCEContainer,15);
                switch (Selection){
                    case "is":
                        softAssert.assertEquals(insuranceLossLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(birthLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(pregnancyLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(marriageLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(divorceLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(deathLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(addressChangeLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(noneOfTheseLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(insuranceLossLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(birthLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(pregnancyLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(marriageLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(divorceLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(deathLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(addressChangeLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(noneOfTheseLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;

        }
    }
}
