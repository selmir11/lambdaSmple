package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class LifeChangeEventsCoCoPage {

    private BasicActions basicActions;

    public LifeChangeEventsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    //Health Loss
    @FindBy(id = "ELIG-LceOption-LOSS_OF_MEC_OTHER-checkBoxButton")
    WebElement insuranceLossLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-LOSS_OF_MEC_OTHER')]")
    List<WebElement> allMemberInsuranceLossCheckbox;
    @FindBy (xpath = "//input[contains(@id, 'ELIG-LceMember-LOSS_OF_MEC_OTHER')]")
    List<WebElement> insuranceLossEventDate;

    //Birth
    @FindBy(id = "ELIG-LceOption-BIRTH_ADOPTION_OR_PLACEMENT_FOR_ADOPTION-checkBoxButton")
    WebElement birthLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-BIRTH')]")
    List<WebElement> allMembersBirthCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-BIRTH')]")
    List<WebElement> birthEventDate;

    //Pregnancy
    @FindBy(id = "ELIG-LceOption-PREGNANCY-checkBoxButton")
    WebElement pregnancyLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-PREGNANCY')]")
    List<WebElement> allMembersPregnancyCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-PREGNANCY')]")
    List<WebElement> pregnancyEventDate;

    //Marriage
    @FindBy(id ="ELIG-LceOption-MARRIAGE_CIVILUNION_OR_DOMESTIC_PARTNER-checkBoxButton")
    WebElement marriageLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-MARRIAGE')]")
    List<WebElement> allMembersMarriageCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-MARRIAGE')]")
    List<WebElement> marriageEventDate;

    //Divorce
    @FindBy(id ="ELIG-LceOption-DIVORCE_ANNULMENT_OR_SEPARATION-checkBoxButton")
    WebElement divorceLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-DIVORCE')]")
    List<WebElement> allMembersDivorceCheckbox;

    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-DIVORCE')]")
    List<WebElement> divorceEventDate;

    //Death
    @FindBy(id ="ELIG-LceOption-DEATH-checkBoxButton")
    WebElement deathLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-DEATH')]")
    List<WebElement> allMembersDeathCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-DEATH')]")
    List<WebElement> deathEventDate;

    //Moved to Colorado
    @FindBy(id="ELIG-LceOption-CHANGE_OF_RESIDENCE-checkBoxButton")
    WebElement addressChangeLCE;
    @FindBy(css=".checkbox-description [id^='ELIG-LceMember-CHANGE']")
    List<WebElement> memberChangeOfAddressCheckbox;
    @FindBy(css = ".col [id^='ELIG-LceMember-CHANGE']")
    List<WebElement> changeOfAddressEventDate;
    @FindBy(css = "[style^='margin-top'] [id^='ELIG-LceMember-CHANGE']")
    List<WebElement> movedToColoradoCheckbox;

    //None of These
    @FindBy(id ="ELIG-LceOption-noneOfThese-checkBoxButton")
    WebElement noneOfTheseLCE;

    //Save and Continue
    @FindBy(id = "LceOverview-SaveAndContinue")
    WebElement saveAndContinueButton;

    //Go Back
    @FindBy(id = "LceOverview-GoBack")
    WebElement goBackButton;

    public String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        // Now format the date
        return dateFormat.format(date);
    }

    public void selectLCE(String LCEType) {
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
                for (var i = 0; i < memberChangeOfAddressCheckbox.size(); i++) {
                    memberChangeOfAddressCheckbox.get(i).click();
                    changeOfAddressEventDate.get(i).sendKeys(getCurrentDate());
                    movedToColoradoCheckbox.get(i).click();
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + LCEType);
        }
    }

    public void selectNoneOfThese(){
        basicActions.waitForElementToBeClickable(noneOfTheseLCE,10);
        noneOfTheseLCE.click();
    }

    public void saveAndContinue(){
        basicActions.waitForElementToBeClickable(saveAndContinueButton,10);
        saveAndContinueButton.click();
    }

    public void goBack(){
        basicActions.waitForElementToBeClickable(goBackButton, 10);
        goBackButton.click();
    }
}
