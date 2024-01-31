package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.RandomDynamicData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class QlceConfirmationPage {

    private BasicActions basicActions;

    public QlceConfirmationPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public BasicActions getDriver() {
        return BasicActions.getInstance();
    }

    @FindBy(id="birth")
    WebElement birthQLCE;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    List<WebElement> allmembersBirthcheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    WebElement birthEventDate;

    //Marriage
    @FindBy(id ="marriage")
    WebElement marriageLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'Marriage')]")
    List<WebElement> allmemberMarriagecheckbox;

    @FindBy(xpath = "//input[@type='date'and contains(@id,'Marriage')]")
    WebElement marriageEventDate;

    //Divorce
    @FindBy(id ="divorce")
    WebElement divorceLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'Divorce')]")
    List<WebElement> allmemberDivorcecheckbox;

    @FindBy(xpath = "//input[@type='date'and contains(@id,'Divorce')]")
    WebElement divorceEventDate;

    //Death
    @FindBy(id ="death")
    WebElement deathLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'Death')]")
    List<WebElement> allmemberDeathcheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'Death')]")
    WebElement deathEventDate;

    @FindBy(xpath = "//*[@id='continueButton']")
    WebElement saveAndContinue;

    public String getCurrentDate(){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
        Date date = new Date();
        // Now format the date
        return dateFormat.format(date);
    }

    public void selectLCE(String QLCEType) {

        switch (QLCEType) {
            case "Birth":
                birthQLCE.click();
                for (var mc = 0; mc < allmembersBirthcheckbox.size(); mc++) {
                    allmembersBirthcheckbox.get(mc).click();
                    birthEventDate.click();
                    birthEventDate.sendKeys(getCurrentDate());
                }
                break;
            case "Marriage":
                marriageLce.click();
                for (var mc = 0; mc < allmemberMarriagecheckbox.size(); mc++) {
                    allmemberMarriagecheckbox.get(mc).click();
                    marriageEventDate.click();
                    marriageEventDate.sendKeys(getCurrentDate());
                }
                break;
            case "Divorce":
                divorceLce.click();
                for (var mc = 0; mc < allmemberDivorcecheckbox.size(); mc++) {
                    allmemberDivorcecheckbox.get(mc).click();
                    divorceEventDate.click();
                    divorceEventDate.sendKeys(getCurrentDate());
                }
                break;
            case "Death":
                deathLce.click();
                for (var mc = 0; mc < allmemberDeathcheckbox.size(); mc++) {
                    allmemberDeathcheckbox.get(mc).click();
                    deathEventDate.click();
                    deathEventDate.sendKeys(getCurrentDate());
                }
                break;

        }
    }

    public void saveNContinue(){
        saveAndContinue.click();
    }
}