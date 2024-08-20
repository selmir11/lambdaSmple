package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class GroupingMembersDentalPage {

    @FindBy(id = "SHP-DentalGroupingMembers-EditMyEnrollmentGroups")
    WebElement editMyEnrollmentGroupsLink;

    @FindBy(id = "SHP-DentalGroupingMembers-Continue")
    WebElement continueButton;

    @FindBy(id = "SHP-DentalGroupingMembers-GoBack")
    WebElement goBackButton;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(css = "table .th-title")
    List<WebElement> groupTitle;

    private BasicActions basicActions;

    public GroupingMembersDentalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
        Assert.assertTrue(basicActions.waitForAngular(10), "page did not load in 10 seconds");
    }

    public void clickContinue()  {
        basicActions.waitForElementToDisappear(spinner,15);
        basicActions.waitForElementToBePresent(continueButton, 10);
        basicActions.waitForElementToBeClickable(continueButton, 10);
        basicActions.scrollToElement(continueButton);
        continueButton.click();
    }

    public void clickGoBack() {
        basicActions.waitForElementToDisappear(spinner,15);
        basicActions.scrollToElement( goBackButton);
        basicActions.waitForElementToBeClickable( goBackButton,15 );
        goBackButton.click();

    }

    public void clickOnEditDentalGroupinglink() {
        basicActions.waitForElementToBePresent(editMyEnrollmentGroupsLink, 10);
        basicActions.waitForElementToBeClickable(editMyEnrollmentGroupsLink, 30);
        editMyEnrollmentGroupsLink.click();
    }

    public void validateDefaultDentalGroups(int defaultExpectedGroups){
        basicActions.waitForElementListToBePresent(groupTitle, 10);
        Assert.assertEquals(groupTitle.size(), defaultExpectedGroups, "Group size did not match!!");
    }
}




