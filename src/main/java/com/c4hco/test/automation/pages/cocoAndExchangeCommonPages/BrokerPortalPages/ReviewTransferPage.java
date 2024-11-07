package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class ReviewTransferPage {
    @FindBy(id = "transfer-fullName")
    WebElement transferResultsClientName;

    @FindBy(xpath = "//button[normalize-space()='Transfer Clients']")
    WebElement transferClientsButton;

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
