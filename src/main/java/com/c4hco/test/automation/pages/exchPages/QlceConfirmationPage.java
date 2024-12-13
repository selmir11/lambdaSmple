package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class QlceConfirmationPage {

    private BasicActions basicActions;

    public QlceConfirmationPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "birth")
    WebElement birthQLCE;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    List<WebElement> allmembersBirthcheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    List<WebElement> birthEventDate;

    //Marriage
    @FindBy(id = "marriage")
    WebElement marriageLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'Marriage')]")
    List<WebElement> allmemberMarriagecheckbox;

    @FindBy(xpath = "//input[@type='date'and contains(@id,'Marriage')]")
    List<WebElement> marriageEventDate;

    //Divorce
    @FindBy(id = "divorce")
    WebElement divorceLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'Divorce')]")
    List<WebElement> allmemberDivorcecheckbox;

    @FindBy(xpath = "//input[@type='date'and contains(@id,'Divorce')]")
    List<WebElement> divorceEventDate;

    //Death
    @FindBy(id = "death")
    WebElement deathLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'Death')]")
    List<WebElement> allmemberDeathcheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'Death')]")
    List<WebElement> deathEventDate;
    //Moved to Colorado
    @FindBy(id = "changeOfAddress")
    WebElement addressChangeLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'ChangeOfResidence')]")
    List<WebElement> memberCheckboxChangeOfAddress;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'ChangeOfResidence')]")
    List<WebElement> changeOfAddressEventDate;

    @FindBy(xpath = "//*[@type='checkbox' and contains(@id, 'movedToColorado')]")
    List<WebElement> movedToColoradoCheckbox;

    //Gain Lawful Immigration Status
    @FindBy(id = "gainedLawfulPresence")
    WebElement LawfulPresenceLCE;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'lceMembersForGainedLawfulPresence')]")
    List<WebElement> allmemberLawfulPresencecheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'lceMembersForGainedLawfulPresence')]")
    List<WebElement> LawfulPresenceEventDate;

    //Lost Coverage
    @FindBy(id = "loseOrLostHealthInsurance")
    WebElement lostCoverageLCE;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'lceMembersForLoseOrLostHealthInsurance')]")
    List<WebElement> allMemberLostCoverageCheckbox;
    @FindBy(xpath = "//input[@type='date' and contains(@id,'lceMembersForLoseOrLostHealthInsurance')]")
    List<WebElement> lostCoverageEventDate;

    @FindBy(id = "gainOfAIANStatus")
    WebElement tribalStatusLCE;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id, 'lceMembersForGainOfTribalStatus')]")
    List<WebElement> allMembersGainedTribalStatusCheckbox;
    @FindBy(xpath = "//input[@type='date' and contains(@id,'lceMembersForGainOfTribalStatus')]")
    List<WebElement> tribalStatusEventDate;

    //None of These
    @FindBy(id = "noneOfThese")
    WebElement noneOfTheseLCE;
    @FindBy(xpath = "//*[@id='continueButton']")
    WebElement saveAndContinue;

    public String getCurrentDate() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate currentDate = LocalDate.now();
        // Now format the date
        return dateFormat.format(currentDate);
    }

    public void selectQLCE(String QLCEType) {
        switch (QLCEType) {
            case "Birth":
                basicActions.waitForElementToBeClickable(birthQLCE, 10);
                birthQLCE.click();
                for (var i = 0; i < allmembersBirthcheckbox.size(); i++) {
                    allmembersBirthcheckbox.get(i).click();
                    birthEventDate.get(i).click();
                    birthEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "Marriage":
                basicActions.waitForElementToBeClickable(marriageLce, 10);
                marriageLce.click();
                for (var i = 0; i < allmemberMarriagecheckbox.size(); i++) {
                    allmemberMarriagecheckbox.get(i).click();
                    marriageEventDate.get(i).click();
                    marriageEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "MoveToCO":
                basicActions.waitForElementToBeClickable(addressChangeLce, 10);
                addressChangeLce.click();
                for (var i = 0; i < memberCheckboxChangeOfAddress.size(); i++) {
                    memberCheckboxChangeOfAddress.get(i).click();
                    changeOfAddressEventDate.get(i).click();
                    changeOfAddressEventDate.get(i).sendKeys(getCurrentDate());
                    movedToColoradoCheckbox.get(i).click();
                }
                break;
            case "ChangePrimaryResidence":
                basicActions.waitForElementToBeClickable(addressChangeLce, 10);
                addressChangeLce.click();
                for (var i = 0; i < memberCheckboxChangeOfAddress.size(); i++) {
                    memberCheckboxChangeOfAddress.get(i).click();
                    changeOfAddressEventDate.get(i).click();
                    changeOfAddressEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "GainedLawfulPresence":
                basicActions.waitForElementToBeClickable(LawfulPresenceLCE, 10);
                LawfulPresenceLCE.click();
                for (var i = 0; i < allmemberLawfulPresencecheckbox.size(); i++) {
                    allmemberLawfulPresencecheckbox.get(i).click();
                    LawfulPresenceEventDate.get(i).click();
                    LawfulPresenceEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "LostCoverage":
                basicActions.waitForElementToBeClickable(lostCoverageLCE, 10);
                lostCoverageLCE.click();
                for (var i = 0; i < allMemberLostCoverageCheckbox.size(); i++) {
                    allMemberLostCoverageCheckbox.get(i).click();
                    lostCoverageEventDate.get(i).click();
                    lostCoverageEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "GainOfTribalStatus":
                basicActions.waitForElementToBeClickable(tribalStatusLCE, 10);
                tribalStatusLCE.click();
                for (var i = 0; i < allMembersGainedTribalStatusCheckbox.size(); i++) {
                    allMembersGainedTribalStatusCheckbox.get(i).click();
                    tribalStatusEventDate.get(i).click();
                    tribalStatusEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "Death":
                basicActions.waitForElementToBeClickable(deathLce, 10);
                deathLce.click();
                for (var i = 0; i < allmemberDeathcheckbox.size(); i++) {
                    allmemberDeathcheckbox.get(i).click();
                    deathEventDate.get(i).click();
                    deathEventDate.get(i).sendKeys(getCurrentDate());

                }
                break;
            case "NoneOfThese":
                basicActions.waitForElementToBeClickable(noneOfTheseLCE, 10);
                noneOfTheseLCE.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + QLCEType);
        }
    }
    public void selectBirthLCE(){
        basicActions.waitForElementToBeClickable(birthQLCE, 10);
        String newbornFullName =basicActions.getFullNameWithPrefix(SharedData.getBirthLceIndividual());
        birthQLCE.click();
        WebElement birthLceMemCheckbox = basicActions.getDriver().findElement(By.xpath( "//span[contains(text(),'"+newbornFullName+"')]/parent::label/preceding-sibling::input[contains(@class,'checkbox')and contains(@id,'BirthAdoptionOrPlacementForAdoption')]"));
        birthLceMemCheckbox.click();
        birthEventDate.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(eventDateElement -> eventDateElement.sendKeys(SharedData.getCalculatedDob().get(SharedData.getBirthLceIndividual())));
    }



    public void saveAndContinue() {
        saveAndContinue.click();
    }

}