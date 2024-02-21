package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class QlceConfirmationPage {

    private BasicActions basicActions;

    public QlceConfirmationPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id="birth")
    WebElement birthQLCE;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    List<WebElement> allmembersBirthcheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    List<WebElement> birthEventDate;

    //Marriage
    @FindBy(id ="marriage")
    WebElement marriageLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'Marriage')]")
    List<WebElement> allmemberMarriagecheckbox;

    @FindBy(xpath = "//input[@type='date'and contains(@id,'Marriage')]")
    List<WebElement> marriageEventDate;

    //Divorce
    @FindBy(id ="divorce")
    WebElement divorceLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'Divorce')]")
    List<WebElement> allmemberDivorcecheckbox;

    @FindBy(xpath = "//input[@type='date'and contains(@id,'Divorce')]")
    List<WebElement> divorceEventDate;

    //Death
    @FindBy(id ="death")
    WebElement deathLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'Death')]")
    List<WebElement> allmemberDeathcheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'Death')]")
    WebElement deathEventDate;
    //Moved to Colorado
    @FindBy(id="changeOfAddress")
    WebElement addressChangeLce;
    @FindBy(xpath="//input[contains(@class,'checkbox')and contains(@id,'ChangeOfResidence')]")
    List<WebElement> memberCheckboxChangeOfAddress;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'ChangeOfResidence')]")
    List<WebElement> changeOfAddressEventDate;

    @FindBy(xpath = "//*[@type='checkbox' and contains(@id, 'movedToColorado')]")
    List<WebElement> movedToColoradoCheckbox;

    //Gain Lawful Immigration Status
    @FindBy(id= "gainedLawfulPresence")
    WebElement LawfulPresenceLCE;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'lceMembersForGainedLawfulPresence')]")
    List<WebElement> allmemberLawfulPresencecheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'lceMembersForGainedLawfulPresence')]")
    List<WebElement>  LawfulPresenceEventDate;

    //Lost Coverage
    @FindBy(id ="loseOrLostHealthInsurance")
    WebElement lostCoverageLCE;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'lceMembersForLoseOrLostHealthInsurance')]")
    List<WebElement> allMemberLostCoverageCheckbox;
    @FindBy(xpath = "//input[@type='date' and contains(@id,'lceMembersForLoseOrLostHealthInsurance')]")
    List<WebElement> lostCoverageEventDate;
    //None of These
    @FindBy(id ="noneOfThese")
    WebElement noneOfTheseLCE;
    @FindBy(xpath = "//*[@id='continueButton']")
    WebElement saveAndContinue;

    public String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
        Date date = new Date();
        // Now format the date
        return dateFormat.format(date);
    }

    public void selectQLCE(String QLCEType) {
        switch (QLCEType) {
            case "Birth":
                basicActions.waitForElementToBeClickable(birthQLCE,10);
                birthQLCE.click();
                for (var i = 0; i < allmembersBirthcheckbox.size(); i++) {
                    allmembersBirthcheckbox.get(i).click();
                    birthEventDate.get(i).click();
                    birthEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "Marriage":
                basicActions.waitForElementToBeClickable(marriageLce,10);
                marriageLce.click();
                for (var i = 0; i < allmemberMarriagecheckbox.size(); i++) {
                    allmemberMarriagecheckbox.get(i).click();
                    marriageEventDate.get(i).click();
                    marriageEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "MoveToCO":
                basicActions.waitForElementToBeClickable(addressChangeLce,10);
                addressChangeLce.click();
                for (var i = 0; i < memberCheckboxChangeOfAddress.size(); i++) {
                    memberCheckboxChangeOfAddress.get(i).click();
                    changeOfAddressEventDate.get(i).click();
                    changeOfAddressEventDate.get(i).sendKeys(getCurrentDate());
                    movedToColoradoCheckbox.get(i).click();

                }
                break;
            case "GainedLawfulPresence":
                basicActions.waitForElementToBeClickable(LawfulPresenceLCE,10);
                LawfulPresenceLCE.click();
                for (var i = 0; i < allmemberLawfulPresencecheckbox.size(); i++) {
                    allmemberLawfulPresencecheckbox.get(i).click();
                    LawfulPresenceEventDate.get(i).click();
                    LawfulPresenceEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "LostCoverage":
                basicActions.waitForElementToBeClickable(lostCoverageLCE,10);
                lostCoverageLCE.click();
                for (var i = 0; i < allMemberLostCoverageCheckbox.size(); i++) {
                    allMemberLostCoverageCheckbox.get(i).click();
                    lostCoverageEventDate.get(i).click();
                    lostCoverageEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "NoneOfThese":
                basicActions.waitForElementToBeClickable(noneOfTheseLCE,10);
                noneOfTheseLCE.click();
                break;
        }
    }

    public void saveAndContinue(){
        saveAndContinue.click();
    }
}