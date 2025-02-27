package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ManageAuthorizedUsersPage {
    SoftAssert softAssert = new SoftAssert();

    @FindBy(xpath = "//*[@id='elem']/app-agency-manage-authorized-users/div/div/div[1]/div/div[2]")
    WebElement manageAuthorizedUsersPageTitle ;

    @FindBy(id = "search")
    WebElement manageAuthorizedUsersSearchField ;

    @FindBy(id = "add-authorized-user-link")
    WebElement addAuthorizedUserLink ;

    @FindBy(xpath = "//*[@id='elem']/app-agency-manage-authorized-users/div/div/div[3]/div/table/tbody/tr")
    WebElement searchResultsTable ;

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
}
