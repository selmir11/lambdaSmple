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
    WebElement immigrationStatus;

    @FindBy(name = "saveAndContinue")
    WebElement saveContinue;

    public void isMemberLawfulPermanentResident(String YNLawfulPermanentResident){
        switch(YNLawfulPermanentResident){
            case "Yes":
                rdobtnLprYes.click();
                break;
            case "No":
                rdobtnLprNo.click();
        }
    }

    public void selectImmigrationStatus(String selectImmigrationStatus){
        basicActions.waitForElementToBePresent(immigrationStatus, 15);

        Select dropdown = new Select(immigrationStatus);
        dropdown.selectByVisibleText(selectImmigrationStatus);
    }

    public  void clickContinue(){saveContinue.click();}
}
