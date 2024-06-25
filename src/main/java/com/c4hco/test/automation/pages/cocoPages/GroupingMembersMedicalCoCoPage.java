package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class GroupingMembersMedicalCoCoPage {

    private BasicActions basicActions;

    @FindBy(id = "SHP-MedicalGroupingMembers-Continue")
    WebElement continueButton;

    @FindBy(css = "th.th-title")
    List<WebElement> noOfGroups;

    SoftAssert softAssert = new SoftAssert();

    public GroupingMembersMedicalCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickContinue() {
        basicActions.waitForElementToBePresent(continueButton, 10);
        basicActions.waitForElementToBeClickable(continueButton, 30);
        continueButton.click();
    }

    public void noOfMedicalGroups(int totalGroups) {
        basicActions.waitForElementListToBePresent(noOfGroups, 10);
        int groupsSize = noOfGroups.size();
        softAssert.assertEquals(groupsSize, totalGroups, "There are 2 groups");
        softAssert.assertAll();
        SharedData.setTotalGroups(groupsSize);
    }
}
