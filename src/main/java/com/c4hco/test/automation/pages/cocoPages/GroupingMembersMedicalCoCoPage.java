package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GroupingMembersMedicalCoCoPage {

    private BasicActions basicActions;

    @FindBy(id = "SHP-MedicalGroupingMembers-Continue")
    WebElement continueButton;

    public GroupingMembersMedicalCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickContinue() {
        basicActions.waitForElementToBePresent(continueButton, 10);
        basicActions.waitForElementToBeClickable(continueButton, 30);
        continueButton.click();
    }
}
