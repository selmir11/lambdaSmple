package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages;

import com.c4hco.test.automation.Dto.AssisterDetails;
import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AdminPortalProgramManagerAccountCreationPage {
    private BasicActions basicActions;
    static SoftAssert softAssert = new SoftAssert();

    public AdminPortalProgramManagerAccountCreationPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "create-firstname")
    WebElement firstName;
    @FindBy(id = "create-lastname")
    WebElement lastName;
    @FindBy(id = "create-email")
    WebElement email;
    @FindBy(id = "create-organizationName")
    WebElement organizationName;
    @FindBy(id = "btn-create")
    WebElement createAccountBtn;
    @FindBy(xpath = "//p[@class='body-text-1 success']")
    List<WebElement> successMessage;

    @FindBy(xpath = "//div[contains(text(),'First Name is required')]")
    WebElement firstNameErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Last Name is required')]")
    WebElement lastNameErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Email Address is required')]")
    WebElement emailErrorMessage;

    @FindBy(xpath = "//div[contains(text(),'Organization Group Name is required')]")
    WebElement organizationGroupErrorMessage;
    AssisterDetails assister = new AssisterDetails();
    public void initializeProgramManagerInAdminPortal(String emailBase){
        assister.setFirstName(basicActions.capitalizeFirstLetter(basicActions.getUniqueString(8)+"TestAssister"));
        assister.setLastName(basicActions.capitalizeFirstLetter(basicActions.getUniqueString(8)+"Test"));
        assister.setEmail(emailBase+"+"+assister.getLastName()+"@outlook.com");
        assister.setOrganizationGroupName("AP"+basicActions.capitalizeFirstLetter(basicActions.getUniqueString(4)));
        assister.setPhoneNumber((String) basicActions.generatePhoneNumber());
        SharedData.setAssisterDetails(assister);
    }


    public void createProgramMangerProfileOnAdminPortal(String emailBase) {
        basicActions.waitForElementToBePresentWithRetries(firstName,30);
       initializeProgramManagerInAdminPortal(emailBase);
       firstName.sendKeys(assister.getFirstName());
       lastName.sendKeys(assister.getLastName());
       email.sendKeys(assister.getEmail());
       organizationName.sendKeys(assister.getOrganizationGroupName());
       createAccountBtn.click();
    }

    public void validateTheSuccessMessageForProfileCreationIsDisplayed() {
        basicActions.waitForElementListToBePresentWithRetries(successMessage,100);
        basicActions.waitForElementToBePresentWithRetries(successMessage.get(0),50);
        softAssert.assertEquals(successMessage.get(0).getText(),"Profile creation request submitted successfully.");
        softAssert.assertEquals(successMessage.get(1).getText(),"Please note that the account will not be created until the user follows the instructions in the invitation email.");
        softAssert.assertAll();
    }

    public void clickCreateProfile(){
        basicActions.waitForElementToBePresent(createAccountBtn, 60);
        createAccountBtn.click();
    }

    public void validateErrors(){
        softAssert.assertTrue(firstNameErrorMessage.isDisplayed(),"Did notdisplay first name error message");
        softAssert.assertTrue(lastNameErrorMessage.isDisplayed(),"Did notdisplay last name error message");
        softAssert.assertTrue(emailErrorMessage.isDisplayed(),"Did not display email error message");
        softAssert.assertTrue(organizationGroupErrorMessage.isDisplayed(),"Did not display organization name error message");
        softAssert.assertAll();
    }

}
