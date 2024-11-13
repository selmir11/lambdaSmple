package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ImmigrationStatusPage {

    private BasicActions basicActions;
    public ImmigrationStatusPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "lprYes")
    WebElement rdobtnLprYes;

    @FindBy(id = "lprNo")
    WebElement rdobtnLprNo;

    @FindBy(id = "lprNoDropdown")
    WebElement immigrationStatusLPRNo;

    @FindBy(id = "lprYesDropdown")
    WebElement immigrationStatusLPRYes;

    @FindBy(name = "saveAndContinue")
    WebElement saveContinue;

    public void isMemberLawfulPermanentResident(String YNLawfulPermanentResident){
        switch(YNLawfulPermanentResident){
            case "Yes":
                rdobtnLprYes.click();
                break;
            case "No":
                rdobtnLprNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNLawfulPermanentResident);
        }
    }

    public void selectImmigrationStatus(String selectImmigrationStatus){
        if (rdobtnLprYes.isSelected()){
             Select dropdown = new Select(immigrationStatusLPRYes);
             dropdown.selectByVisibleText(selectImmigrationStatus);
        } else if (rdobtnLprNo.isSelected()) {
            Select dropdown = new Select(immigrationStatusLPRNo);
            dropdown.selectByVisibleText(selectImmigrationStatus);
        }else {
            throw new IllegalStateException("Neither 'Yes' nor 'No' option is selected for Lawful Permanent Resident.");
        }
    }

    public  void clickContinue(){
        basicActions.waitForElementToBePresent(saveContinue, 10);
        saveContinue.click();
    }
}
