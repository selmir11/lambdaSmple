package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class YourClientsPage {
    public BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public YourClientsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "print-link")
    WebElement printBtn;
    @FindBy(xpath = "//a[@id='ngb-nav-0']")
    WebElement connectForHealthColoradoTab;
    @FindBy(xpath= "//a[.='Colorado Connect']")
    WebElement coloradoConnectTab;
    @FindBy(id = "clientSearchBox")
    WebElement searchClient;
    @FindBy(id = "remove-client-link")
    WebElement removeClient;
    @FindBy(id = "transfer-link")
    WebElement transferClient;
    @FindBy(id = "manage-button")
    WebElement manageClient;
    @FindBy(xpath = "//button[.='Ok']")
    WebElement okBtn;
    @FindBy(xpath = "//button[.='Cancel']")
    WebElement cancelBtn;
    @FindBy(xpath = "//*[@id='client-information-table']/app-view-clients-table/div[2]")
    WebElement emptyTable;
    @FindBy(xpath = "//*[@id='clientCheck-checkAll']")
    WebElement allClientsCheckBox;
    @FindBy(xpath = "//a[normalize-space()='Remove Selected Clients']")
    WebElement removedSelectedClients;
    @FindBy(xpath = "//span[normalize-space()='Transfer Selected Clients']")
    WebElement TransferSelectedClients;
    @FindBy(id = "user-first-name")
    WebElement brokerUserName;
    @FindBy(id = "logout-link")
    WebElement logout;

    @FindBy(id = "client-data-title-row")
    WebElement clientRow;

    @FindBy(css = ".mat-content #client-data-title-row")
    List<WebElement> clientsList;

    @FindBy(xpath = "//div[@id='client-data-title-row']/span[@class='col-2 body-text-1 text-align-center ow']")
    List<WebElement> clientNamesList;

    @FindBy(xpath = "(//mat-expansion-panel-header[contains(@id, 'mat-expansion-panel-header')])[2]")
    WebElement clientSecondRow;

    @FindBy(id = "status0")
    WebElement clientStatus;

    @FindBy(id = "status")
    WebElement secondClientStatus;

    @FindBy(id = "fullName0")
    WebElement secondClientFullName;

    @FindBy(xpath = "(//span[@id='fullName0'])[2]")
    WebElement thirdClientFullName;

    @FindBy(xpath = "(//span[@id='status'])[2]")
    WebElement thirdClientStatus;

    @FindBy(id = "premium-amount")
    WebElement clientPremium;

    @FindBy(xpath = "//*[@id='client-data-title-row']/span[1]")
    WebElement clientFullName;
    @FindBy(xpath = "//*[@id='elem']/app-view-clients/div/div[1]")
    WebElement yourClientsTitle;

    @FindBy(id = "pagination-curr-page")
    WebElement yourClientCurrentPage;

    @FindBy(id = "pagination-next-page-btn")
    WebElement yourClientNextPage;

    @FindBy(id = "pagination-prev-page-btn")
    WebElement yourClientPreviousPage;

    public void validateYourClientsPageTitle(){
        basicActions.waitForElementToBePresent(yourClientsTitle, 10);
        softAssert.assertEquals(yourClientsTitle.getText(),"Your Clients");
        softAssert.assertAll();
    }

    public void clickUserTab(String userTab) {
        switch (userTab){
            case "connect For Health Colorado" :
                connectForHealthColoradoTab.click();
                break;
            case "colorado Connect" :
                basicActions.wait(3000);
                Actions actions = new Actions(basicActions.getDriver());
                actions.click(coloradoConnectTab).perform();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + userTab);
        }
    }
    public void verifyPrintButtonIsDisplayed() {
        basicActions.waitForElementToBePresent(printBtn,10);
        softAssert.assertTrue(printBtn.isDisplayed());
        softAssert.assertTrue(printBtn.isEnabled());
        softAssert.assertAll();}

    public void clickPrintButton() {
        basicActions.waitForElementToBePresent(printBtn, 10);
        printBtn.click();
    }

    public void searchForClient(){
        basicActions.waitForElementListToBePresent(clientsList, 1000);
        basicActions.waitForElementToBePresent(searchClient, 1000);
        String firstName =SharedData.getPrimaryMember().getFirstName();
        searchClient.sendKeys(firstName);
        searchClient.sendKeys(Keys.ENTER);
    }

    public void searchForTheSecondaryClient(){
        basicActions.waitForElementToBePresent(searchClient, 1000);
        String firstName =SharedData.getMembers().get(0).getFirstName();
        searchClient.sendKeys(firstName);
        searchClient.sendKeys(Keys.ENTER);
    }


    public void clickClientResult() {
        basicActions.waitForElementToDisappear(clientSecondRow, 10);
        basicActions.waitForElementToBePresent(clientRow,10);
        Actions actions = new Actions(basicActions.getDriver());
        WebElement firstClientResult = basicActions.getDriver().findElement(By.xpath("//*[@id='plan-year']"));
        basicActions.waitForElementToBePresent(firstClientResult,100);
        actions.click(firstClientResult).perform();
    }

    public void clickFirstClient() {
        basicActions.waitForElementToBePresent(clientRow,10);
        Actions actions = new Actions(basicActions.getDriver());
        WebElement firstClientResult = basicActions.getDriver().findElement(By.xpath("//*[@id='plan-year']"));
        basicActions.waitForElementToBePresent(firstClientResult,100);
        actions.click(firstClientResult).perform();
    }

    public void searchClientNamed(String clientName) {
        basicActions.waitForElementListToBePresentWithRetries(clientsList, 1000);
        basicActions.waitForElementToBePresentWithRetries(searchClient, 1000);

        searchClient.sendKeys(clientName);
        searchClient.sendKeys(Keys.ENTER);
    }

    public void resetClientSearchBox() {
        basicActions.waitForElementListToBePresent(clientsList, 1000);
        basicActions.waitForElementToBePresent(searchClient, 1000);

        searchClient.clear();
        searchClient.sendKeys(" ");
        searchClient.sendKeys(Keys.ENTER);
    }

    public void verifyCurrentClientStatus(String expectedClientStatus){
        basicActions.waitForElementToBePresent(clientRow,10);
        switch (expectedClientStatus){
            case "NO ELIGIBILITY":
                softAssert.assertEquals(clientStatus.getText(), "NO ELIGIBILITY");
                break;
            case "ELIGIBILITY ONLY":
                softAssert.assertEquals(clientStatus.getText(), "ELIGIBILITY ONLY");
                break;
            case "POLICY SUBMITTED":
                softAssert.assertEquals(clientStatus.getText(), "POLICY SUBMITTED");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + expectedClientStatus);
        }
        softAssert.assertAll();
    }

    public void verifyClientFullName(){
        basicActions.waitForElementToBePresent(clientRow,10);
        basicActions.waitForElementToBePresent(clientFullName, 200);
        softAssert.assertEquals(clientFullName.getText(),SharedData.getPrimaryMember().getFullName());
        softAssert.assertAll();
    }

    public void verifySecondSubscriberName(){
        basicActions.waitForElementToBePresent(clientRow,10);
        basicActions.waitForElementToBePresent(secondClientFullName,10);
        String clientName = SharedData.getMembers().get(0).getFirstName() + " " + SharedData.getMembers().get(0).getLastName();
        softAssert.assertEquals(secondClientFullName.getText(), clientName);
        softAssert.assertAll();
    }

    public void verifySecondClientStatus(){
        basicActions.waitForElementToBePresent(clientRow,10);
        basicActions.waitForElementToBePresent(secondClientStatus,10);
        softAssert.assertEquals(secondClientStatus.getText(), "POLICY SUBMITTED");
        softAssert.assertAll();
    }

    public void verifyThirdSubscriberName(){
        basicActions.waitForElementToBePresent(clientRow,10);
        basicActions.waitForElementToBePresent(thirdClientFullName,10);
        String clientName = SharedData.getMembers().get(1).getFirstName() + " " + SharedData.getMembers().get(1).getLastName();
        softAssert.assertEquals(thirdClientFullName.getText(), clientName);
        softAssert.assertAll();
    }

    public void verifyThirdClientStatus(){
        basicActions.waitForElementToBePresent(clientRow,10);
        basicActions.waitForElementToBePresent(thirdClientStatus,10);
        softAssert.assertEquals(thirdClientStatus.getText(), "POLICY SUBMITTED");
        softAssert.assertAll();

    }

    public void clickOptionToHandelClient(String option) {
        basicActions.waitForElementToBePresent(clientRow,100);

        switch (option){
            case "remove Client":
                basicActions.waitForElementToBePresent(removeClient,100);
                removeClient.click();
                break;
            case "transfer":
                transferClient.click();
                break;
            case "manage":
                basicActions.scrollToElement(manageClient);
                manageClient.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
    }

    public void clickPOPUPOption(String popupBtn) {
        basicActions.waitForElementToBePresent(okBtn,5000);
        basicActions.waitForElementToBePresent(cancelBtn,5000);
        switch (popupBtn){
            case "ok":
                basicActions.waitForElementToBeClickable(okBtn,100);
                okBtn.click();
                break;
            case "cancel":
                basicActions.waitForElementToBeClickable(cancelBtn,100);
                cancelBtn.click();
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + popupBtn);
        }
    }

    public void validateClientIsRemoved() {
        softAssert.assertTrue(emptyTable.isDisplayed());
        softAssert.assertAll();
    }

    public void selectTheClient() {
        Actions actions = new Actions(basicActions.getDriver());
        WebElement selectOneElement =  basicActions.getDriver().findElement(By.id("clientCheck-0-input"));
        actions.click(selectOneElement).perform();
    }

    public void selectOptionFromBrokerContainer(String optionSelected) {
        basicActions.waitForElementToBePresent( removedSelectedClients,100);
        switch (optionSelected){
            case "Remove Selected Clients":
                removedSelectedClients.click();
                break;
            case "Transfer Selected Clients":
                TransferSelectedClients.click();
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + optionSelected);
        }

    }

    public void logoutFromBrokerAccount() {
        basicActions.waitForElementToBePresent(brokerUserName,10);
        brokerUserName.click();
        basicActions.waitForElementToBePresent(logout,10);
        logout.click();
    }

    public void selectAllTheClientsCheckBox() {
        basicActions.waitForElementToBePresent(allClientsCheckBox, 200);
        basicActions.waitForElementToBeClickable(allClientsCheckBox, 200);
        allClientsCheckBox.click();
    }

    public void validateClientPremiumAmount(){
        String premiumAmt =SharedData.getPrimaryMember().getMedicalPremiumAmt();
        String clientName =SharedData.getPrimaryMember().getFullName();
        basicActions.waitForElementToBePresent(clientRow, 200);

        basicActions.waitForElementToBePresent(clientFullName, 200);
        softAssert.assertEquals(clientFullName.getText(),clientName);

        basicActions.waitForElementToBePresent(clientPremium, 200);
        softAssert.assertEquals((clientPremium.getText().replace("$", "")), premiumAmt);
        softAssert.assertAll();
    }

    public void verifyClientNameAsPrimary() {
        basicActions.waitForElementToBePresent(clientFullName,20);
        softAssert.assertTrue(clientFullName.getText().contains(SharedData.getMembers().get(0).getFirstName()));
        softAssert.assertAll();
    }

    public void validateSearchBoxSpecialCharacters() {
        basicActions.waitForElementToBePresent(searchClient,20);
        searchClient.sendKeys("#$%!@&*()");
        softAssert.assertEquals(searchClient.getAttribute("value"), "");
        softAssert.assertAll();
    }

    public void validateNumbersNotAllowedSearchBox() {
        basicActions.waitForElementToBePresent(searchClient,20);
        searchClient.sendKeys("0123456789");
        softAssert.assertEquals(searchClient.getAttribute("value"), "");
        softAssert.assertAll();
    }

    public void validateSpacesNotAllowedSearchBox() {
        basicActions.waitForElementToBePresent(searchClient,20);
        searchClient.sendKeys("FirstName LastName");
        softAssert.assertEquals(searchClient.getAttribute("value"), "FirstNameLastName");
        softAssert.assertAll();
    }

    public void verifyCurrentClientListPage(String currentPage) {
        basicActions.waitForElementToBePresent(yourClientCurrentPage,30);
        softAssert.assertEquals(yourClientCurrentPage.getText(), currentPage);
        softAssert.assertAll();
    }

    public void clickRightPaginationArrowButton() {
        basicActions.waitForElementToBePresent(yourClientNextPage,30);
        yourClientNextPage.click();
    }

    public void verifyClientsAlphabeticalOrder() {
        basicActions.waitForElementListToBePresentWithRetries(clientNamesList, 1000);

        List<String> originalList = new ArrayList<>();
        System.out.println("The following list of clients was found");
        for(WebElement clientName : clientNamesList){
            System.out.println(clientName.getText());
            originalList.add(clientName.getText());
        }

        List<String> sortedList = new ArrayList<>(originalList);
        Collections.sort(sortedList);

        softAssert.assertEquals(sortedList,originalList);
        softAssert.assertAll();
    }

    public void clickLeftPaginationArrowButton() {
        basicActions.waitForElementToBePresent(yourClientPreviousPage,30);
        yourClientPreviousPage.click();
    }

    public void validateClientOptionsDisplayed(String clientOption){
        basicActions.waitForElementToBePresent(clientRow,100);

        switch (clientOption) {
            case "Remove Client":
                basicActions.waitForElementToBePresent(removeClient,100);
                softAssert.assertEquals(removeClient.getText(),"Remove Client");
                break;
            case "Transfer":
                basicActions.waitForElementToBePresent(transferClient,100);
                softAssert.assertEquals(transferClient.getText(),"Transfer");
                break;
            case "Manage":
                basicActions.waitForElementToBePresent(manageClient,100);
                softAssert.assertEquals(manageClient.getText(),"Manage");
                break;
        }
        softAssert.assertAll();
    }

    public void validateClientOptionsNotDisplayed(String clientOption){
        basicActions.waitForElementToBePresent(clientRow,100);

        switch (clientOption) {
            case "Remove Client":
                softAssert.assertFalse(basicActions.waitForElementPresence(removeClient,30));
                break;
            case "Transfer":
                softAssert.assertFalse(basicActions.waitForElementPresence(transferClient,30));
                break;
            case "Manage":
                softAssert.assertFalse(basicActions.waitForElementPresence(manageClient,30));
                break;
        }
        softAssert.assertAll();
    }
}
