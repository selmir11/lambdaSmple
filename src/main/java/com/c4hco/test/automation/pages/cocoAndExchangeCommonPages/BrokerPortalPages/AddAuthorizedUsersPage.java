package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AddAuthorizedUsersPage {
    SoftAssert softAssert = new SoftAssert();

    @FindBy(id = "input-email-addAuthUsers")
    WebElement adminStaffEmailField ;

    @FindBy(id = "BP-AddAuthorizedUsers-SaveAndSubmit")
    WebElement addAuthorizedUsersSaveSubmitButton ;

    private BasicActions basicActions;
    public AddAuthorizedUsersPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void enterAdminStaffEmail(){
        basicActions.waitForElementToBePresent(adminStaffEmailField,10);
        adminStaffEmailField.sendKeys(SharedData.getAdminStaff().getEmail());
    }

    public void clickSaveSubmitAddAuthorizedUsersPage(){
        basicActions.waitForElementToBePresent(addAuthorizedUsersSaveSubmitButton,10);
        addAuthorizedUsersSaveSubmitButton.click();
    }
}
