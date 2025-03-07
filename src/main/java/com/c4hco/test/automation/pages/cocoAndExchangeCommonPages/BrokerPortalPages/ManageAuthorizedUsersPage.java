package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ManageAuthorizedUsersPage {
    SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath = "//*[@id='elem']/app-agency-manage-authorized-users/div/div/div[1]/div/div[2]")
    WebElement manageAuthorizedUsersPageTitle ;

    @FindBy(id = "search")
    WebElement manageAuthorizedUsersSearchField ;

    @FindBy(id = "add-authorized-user-link")
    WebElement addAuthorizedUserLink ;

    @FindBy(id = "action-link")
    WebElement resendInviteLink ;

    @FindBy(xpath = "//*[@id='elem']/app-agency-manage-authorized-users/div/div/div[3]/div/table/tbody/tr")
    WebElement searchResultsTable ;

    @FindBy(xpath = "//span[normalize-space()='Invite Sent']")
    WebElement inviteSentMessage ;

    @FindBy(xpath = "//table[@class='table table-sm table-striped']//tr/td")
    List<WebElement> adminStaffRow ;

    @FindBy(id = "action-link")
    WebElement removeLink ;

    private BasicActions basicActions;
    public ManageAuthorizedUsersPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void validateManageAuthorizedUsersPageTitle(){
        basicActions.waitForElementToBePresent(manageAuthorizedUsersPageTitle,10);
        softAssert.assertEquals(manageAuthorizedUsersPageTitle.getText(), "Manage Authorized Users");
        softAssert.assertAll();
    }

    public void clickAddAuthorizedUserLink(){
        basicActions.waitForElementToBePresent(addAuthorizedUserLink,10);
        addAuthorizedUserLink.click();
    }

    public void clickResendInviteLink(){
        basicActions.waitForElementToBePresent(resendInviteLink,10);
        softAssert.assertEquals(resendInviteLink.getText(), "Resend Invite");
        softAssert.assertAll();
        resendInviteLink.click();
    }

    public void verifyInviteSentMessage(){
        basicActions.waitForElementToBePresent(inviteSentMessage,10);
        softAssert.assertEquals(inviteSentMessage.getText(), "Invite Sent");
        softAssert.assertAll();
    }

    public void searchForAuthorizedUserNamed(String authorizedUserName){
        basicActions.waitForElementToBePresent(manageAuthorizedUsersSearchField,10);
        manageAuthorizedUsersSearchField.sendKeys(authorizedUserName);
    }

    public void verifySearchResultsRowCount(int expectedRowCount){
        basicActions.waitForElementToBePresent(searchResultsTable,10);
        int rows = basicActions.getDriver().findElements(By.xpath("//*[@id='elem']/app-agency-manage-authorized-users/div/div/div[3]/div/table/tbody/tr")).size();
        softAssert.assertEquals(rows, expectedRowCount);
        softAssert.assertAll();
    }

    public void clearSearchBox(){
        basicActions.waitForElementToBePresent(manageAuthorizedUsersSearchField,10);
        manageAuthorizedUsersSearchField.clear();
    }

    public void verifyAdminStaffDetails(){
        basicActions.waitForElementListToBePresentWithRetries(adminStaffRow,10);
        softAssert.assertEquals(adminStaffRow.get(0).getText(), SharedData.getAdminStaff().getFirstName() + " " + SharedData.getAdminStaff().getLastName());
        softAssert.assertEquals(adminStaffRow.get(1).getText(), SharedData.getAdminStaff().getEmail());
        softAssert.assertEquals(adminStaffRow.get(2).getText(), "Active");
        softAssert.assertEquals(adminStaffRow.get(3).getText(), "Remove");
        softAssert.assertAll();
    }

    public void clickRemoveLinkAdminStaff(){
        basicActions.waitForElementListToBePresentWithRetries(adminStaffRow,10);
        removeLink.click();
    }

    public void verifyAdminStaffRemoved(){
        softAssert.assertFalse(basicActions.waitForElementListToBePresent(adminStaffRow,10));
        softAssert.assertAll();
    }
}
