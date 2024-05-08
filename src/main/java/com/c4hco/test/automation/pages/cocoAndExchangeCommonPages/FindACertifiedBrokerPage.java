package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class FindACertifiedBrokerPage {
    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    public FindACertifiedBrokerPage(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id ="findBroker-brokerName-agency-license-input")
    WebElement searchContainer;

    @FindBy(id ="findBroker-city-state-zip-input")
    WebElement searchBrokerLocation;

    @FindBy(xpath ="//input[@aria-autocomplete='list']")
    WebElement searchBrokerLanguage;

    @FindBy(id ="findBroker-searchBroker-btn")
    WebElement searchButton;

    @FindBy(xpath ="//mat-panel-title[.=' More Details ']")
    WebElement moreDetails;
    
    @FindBy(xpath ="//*[@id='agency-manage-account-button']")
    WebElement authorizeBrokerButton;

    @FindBy(css =".p-4")
    WebElement over50SearchResultsError;

    @FindBy(id ="total-record-count")
    WebElement totalResultCount;

    public void searchForBrokerName(String brokerName) {
        basicActions.waitForElementToBePresent(searchContainer,60);
        searchContainer.sendKeys(brokerName);
    }

    public void clearSearchForBroker() {
        basicActions.waitForElementToBePresent(searchContainer,60);
        searchContainer.clear();
    }

    public void searchForBrokerLocation(String location) {
        basicActions.waitForElementToBePresent(searchBrokerLocation,60);
        searchBrokerLocation.sendKeys(location);
    }

    public void searchForBrokerLanguage(String language) {
        basicActions.waitForElementToBePresent(searchBrokerLanguage,60);
        searchBrokerLanguage.sendKeys(language);
        searchBrokerLanguage.sendKeys(Keys.DOWN);
        searchBrokerLanguage.sendKeys(Keys.ENTER);
    }

    public void clearSearchForBrokerLocation() {
        basicActions.waitForElementToBePresent(searchBrokerLocation,60);
        searchBrokerLocation.clear();
    }

    public void clickSearchButton() {
        basicActions.waitForElementToBePresent(searchButton,100);
        searchButton.click();
    }

    public void clickMoreDetailsInTheBrokerContainer() {
        basicActions.waitForElementToBePresent(moreDetails,10);
        moreDetails.click();
    }

    public void clickAuthorizedBroker() {
        basicActions.waitForElementToBePresent(authorizeBrokerButton,60);
        authorizeBrokerButton.click();
        basicActions.getDriver().findElement(By.id("client-information-table"));
        WebElement test1 = basicActions.getDriver().findElement(By.id("terms-checkbox-input"));
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()",test1 );

        WebElement test2 = basicActions.getDriver().findElement(By.xpath("//span[.='Authorize Broker']"));
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()",test2 );
    }

    public void validateOver50SearchResultsErrorExists(String language){
        String ExpectedText = switch (language) {
            case "English" ->
                    "More than 50 search results were found and only the first 50 are shown. Please enter more specific search criteria if your desired result is not included.";
            case "Spanish" ->
                    "Se encontraron m\u00E1s de 50 resultados en la b\u00FAsqueda y solo se muestran los primeros 50. Si los resultados deseados no han sido incluidos, por favor ingrese criterios de b\u00FAsqueda m\u00E1s espec\u00EDficos.";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };

        basicActions.waitForElementToBePresent(over50SearchResultsError,30);
        softAssert.assertEquals(over50SearchResultsError.getText(), ExpectedText);
        softAssert.assertAll();
    }

    public void validateOver50SearchResultsErrorDoesNotExist(){
        softAssert.assertFalse(basicActions.waitForElementPresence(over50SearchResultsError,20));
        softAssert.assertAll();
    }

    public void validateTotalBrokerResultCountExists(String expectedCount, String language){
        String englishText = " Agencies or Brokers found";
        String spanishText = " agencias o agentes";

        if(expectedCount.equals("1")){
            englishText = " Agency or Broker found";
            spanishText = " agencia o agente";
        }

        String ExpectedText = switch (language) {
            case "English" ->
                    expectedCount + englishText;
            case "Spanish" ->
                    "Se encontraron " + expectedCount + spanishText;
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };

        basicActions.waitForElementToBePresent(totalResultCount,30);
        softAssert.assertEquals(totalResultCount.getText(), ExpectedText);
        softAssert.assertAll();
    }
}
