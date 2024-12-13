package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages;

import com.c4hco.test.automation.Dto.AdminDetails;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class AdminPortalAccountCreationPages {
    public BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public AdminPortalAccountCreationPages(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(id = "create-firstname")
    WebElement firstName;
    @FindBy(id = "create-lastname")
    WebElement lastName;
    @FindBy(id = "create-email")
    WebElement email;
    @FindBy(id = "btn-create")
    WebElement createBtn;
    @FindBy(xpath = "//*[@id='create-account-page']/form/div[1]/div[2]/p[1]")
    WebElement successTitleText;
    @FindBy(xpath = "//*[@id='create-account-page']/form/div[1]/div[2]/p[2]")
    WebElement successBodyText;


    public void enterValidDataToCreateAdminAccount(String emailBase) {
        basicActions.waitForElementToBePresent(firstName,30);
        AdminDetails adminUser = new AdminDetails();
        adminUser.setFirstName("Primary"+ basicActions.getUniqueString(6));
        adminUser.setLastName(basicActions.capitalizeFirstLetter(basicActions.getUniqueString(7)+"Test"));
        adminUser.setEmail(emailBase+"+"+adminUser.getLastName()+"@outlook.com");
        SharedData.setAdminDetails(adminUser);
        firstName.sendKeys(SharedData.getAdminDetails().getFirstName());
        lastName.sendKeys(SharedData.getAdminDetails().getLastName());
        email.sendKeys(SharedData.getAdminDetails().getEmail());
        createBtn.click();

    }

    public void validateTheSuccessMessageIsDisplayed() {
        basicActions.waitForElementToBePresentWithRetries(successTitleText,30);
        basicActions.waitForElementToBePresentWithRetries(successBodyText,30);
        softAssert.assertEquals(successTitleText.getText(), "Success!");
        softAssert.assertEquals(successBodyText.getText(), "New user was created. Please check the provided email for further instructions.");

    }
}
