package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ReviewTransferPage {
    @FindBy(xpath = "//*[@id='elem']/app-review-transfer/div/div[1]")
    WebElement reviewTransferPageTitle;

    @FindBy(id = "transfer-brokerName-label")
    WebElement newBrokerFieldLabel;

    @FindBy(id = "transfer-brokerName")
    WebElement newBrokerField;

    @FindBy(id = "transfer-agencyName-label")
    WebElement newAgencyNameFieldLabel;

    @FindBy(id = "transfer-agencyName")
    WebElement newAgencyNameField;

    @FindBy(id = "transfer-brokerAddress-label")
    WebElement newBrokerAddressFieldLabel;

    @FindBy(id = "transfer-brokerAddress")
    WebElement newBrokerAddressField;

    @FindBy(id = "transfer-brokerEmail-label")
    WebElement newBrokerEmailFieldLabel;

    @FindBy(id = "transfer-brokerEmail")
    WebElement newBrokerEmailField;

    @FindBy(id = "transfer-fullName")
    WebElement transferResultsClientName;

    @FindBy(id = "transfer-confirm-msg")
    WebElement transferConfirmationText;

    @FindBy(xpath = "//*[@id='elem']/app-review-transfer/div/div[2]/div[4]")
    WebElement transferWarningText;

    @FindBy(xpath = "//button[normalize-space()='Transfer Clients']")
    WebElement transferClientsButton;

    @FindBy(xpath = "//*[@id='transfer-action']/a")
    WebElement removeFromTransferLink;

    @FindBy(xpath = "//div[@class='remove-sure']")
    WebElement areYouSureConfirmationText;

    @FindBy(id = "transfer-no")
    WebElement areYouSureConfirmationNo;

    @FindBy(id = "transfer-yes")
    WebElement areYouSureConfirmationYes;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    WebElement transferClientsCancelButton;

    @FindBy(xpath = "//*[@id='elem']/app-review-transfer/div/div[2]/div[2]")
    WebElement transferClientCount;

    @FindBy(xpath = "//td[contains(text(),'You have selected all of your clients')]")
    WebElement transferAllClientMessage;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public ReviewTransferPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void validateReviewTransferPageTitle(){
        basicActions.waitForElementToBePresent(reviewTransferPageTitle,10);
        softAssert.assertEquals(reviewTransferPageTitle.getText(), "Review Transfer");
        softAssert.assertAll();
    }

    public void validateNewBrokerFieldLabels(){
        basicActions.waitForElementToBePresent(newBrokerFieldLabel,10);
        softAssert.assertEquals(newBrokerFieldLabel.getText(), "Broker Name:");
        softAssert.assertEquals(newAgencyNameFieldLabel.getText(), "Agency Name:");
        softAssert.assertEquals(newBrokerAddressFieldLabel.getText(), "Agency Address:");
        softAssert.assertEquals(newBrokerEmailFieldLabel.getText(), "Email Address:");
        softAssert.assertAll();
    }

    public void validateNewBrokerTransferDetails(String brokerName, String agencyName, String brokerAddress, String brokerEmailSTG, String brokerEmailQA){
        basicActions.waitForElementToBePresent(newBrokerField,10);
        softAssert.assertEquals(newBrokerField.getText(), brokerName);
        softAssert.assertEquals(newAgencyNameField.getText(), agencyName);
        softAssert.assertEquals(newBrokerAddressField.getText(), brokerAddress);
        if(SharedData.getEnv().equals("staging")){
            softAssert.assertEquals(newBrokerEmailField.getText(), brokerEmailSTG);
        } else{
            softAssert.assertEquals(newBrokerEmailField.getText(), brokerEmailQA);
        }
        softAssert.assertAll();
    }

    public void validateTransferConfirmationText(String brokerName, String agencyName){
        basicActions.waitForElementToBePresent(transferConfirmationText,10);
        softAssert.assertEquals(transferConfirmationText.getText(), "The following client(s) will be transferred to " + brokerName + " within " + agencyName);
        softAssert.assertAll();
    }

    public void validateReviewTransferButtons(){
        basicActions.waitForElementToBePresent(transferClientsButton,10);
        softAssert.assertEquals(transferClientsButton.getText(), "Transfer Clients");
        softAssert.assertEquals(transferClientsCancelButton.getText(), "Cancel");
        softAssert.assertAll();
    }

    public void validateTransferWarningText(){
        basicActions.waitForElementToBePresent(transferWarningText,10);
        softAssert.assertEquals(transferWarningText.getText(), "By Selecting \"Transfer Clients\" below, the client(s) will no longer appear in your client list and you will not be able to work on their behalf.");
        softAssert.assertAll();
    }

    public void validateClientNameDisplayed(){
        basicActions.waitForElementToBePresent(transferResultsClientName,10);
        softAssert.assertEquals(transferResultsClientName.getText(), SharedData.getPrimaryMember().getFullName());
        softAssert.assertAll();
    }

    public void verifyClientTransferCount(String expectedCount){
        basicActions.waitForElementToBePresent(transferClientCount,10);
        softAssert.assertEquals(transferClientCount.getText(), "Transferring a total of " + expectedCount + " clients(s)");
        softAssert.assertAll();
    }

    public void clickTransferClients(){
        basicActions.waitForElementToBePresent(transferClientsButton,10);
        transferClientsButton.click();
    }

    public void clickRemoveFromTranfer(){
        basicActions.waitForElementToBePresent(removeFromTransferLink,10);
        removeFromTransferLink.click();
    }

    public void removeClientConfirmation(String confirmation){
        basicActions.waitForElementToBePresent(areYouSureConfirmationText,10);
        softAssert.assertEquals(areYouSureConfirmationText.getText(), "Are you sure?");
        switch (confirmation) {
            case "No":
                softAssert.assertEquals(areYouSureConfirmationNo.getText(),"No");
                areYouSureConfirmationNo.click();
                break;
            case "Yes":
                softAssert.assertEquals(areYouSureConfirmationYes.getText(),"Yes");
                areYouSureConfirmationYes.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + confirmation);
        }
        softAssert.assertAll();
    }

    public void verifyRemoveFromTransferLinkDisabled(){
        basicActions.waitForElementToBePresent(removeFromTransferLink,10);
        softAssert.assertEquals(removeFromTransferLink.getAttribute("class"),"remove-transfer disabled");
        softAssert.assertAll();
    }

    public void clickCancelTransferClients(){
        basicActions.waitForElementToBePresent(transferClientsCancelButton,10);
        transferClientsCancelButton.click();
    }

    public void verifyTransferAllClientsMessage(){
        basicActions.waitForElementToBePresent(transferAllClientMessage,10);
        softAssert.assertEquals(transferAllClientMessage.getText(), "You have selected all of your clients to transfer to the above Broker");
        softAssert.assertAll();
    }

    public void totalClientNumber(){
        basicActions.waitForElementToBePresent(transferClientCount,10);
        softAssert.assertEquals(transferClientCount.getText(), "Transferring a total of " + SharedData.getAgencyOwner().getAgencyClientCount() + " clients(s)");
        softAssert.assertAll();
    }

}
