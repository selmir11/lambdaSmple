package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FindACertifiedBrokerPage {
    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    public FindACertifiedBrokerPage(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id ="findBroker-city-state-zip-input")
    WebElement searchBrokerLocation;

    @FindBy(css =".p-4")
    WebElement over50SearchResultsError;

    @FindBy(xpath ="//input[@aria-autocomplete='list']")
    WebElement searchBrokerLanguage;

    public void searchForBrokerLocation(String location) {
        basicActions.waitForElementToBePresent(searchBrokerLocation,60);
        searchBrokerLocation.sendKeys(location);
    }

    public void searchForBrokerLanguage(String language) {
        basicActions.waitForElementToBePresent(searchBrokerLanguage,60);
        searchBrokerLanguage.sendKeys(language);
        searchBrokerLanguage.sendKeys(Keys.TAB);
    }

    public void clearSearchForBrokerLocation() {
        basicActions.waitForElementToBePresent(searchBrokerLocation,60);
        searchBrokerLocation.clear();
    }

    public void validateOver50SearchResultsErrorExists(String expectedState, String language){
        String ExpectedText = "";

        switch (expectedState) {
            case "is":
                ExpectedText = switch (language) {
                    case "English" ->
                            "More than 50 search results were found and only the first 50 are shown. Please enter more specific search criteria if your desired result is not included.";
                    case "Spanish" ->
                            "Se encontraron m\u00E1s de 50 resultados en la b\u00FAsqueda y solo se muestran los primeros 50. Si los resultados deseados no han sido incluidos, por favor ingrese criterios de b\u00FAsqueda m\u00E1s espec\u00EDficos.";
                    default -> throw new IllegalArgumentException("Invalid option: " + language);
                };

                basicActions.waitForElementToBePresent(over50SearchResultsError,30);
                softAssert.assertEquals(over50SearchResultsError.getText(), ExpectedText);
                break;
            case "is not":
                softAssert.assertFalse(basicActions.waitForElementPresence(over50SearchResultsError,20));
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }
}
