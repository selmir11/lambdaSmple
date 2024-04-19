package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AddInfoForYourselfPage {
    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public AddInfoForYourselfPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "ELIG-Residential-AddressLine1")
    WebElement addressLine1Input;

    @FindBy(id = "ELIG-Residential-AddressCity")
    WebElement cityInput;

    @FindBy(id = "ELIG-Residential-AddressState")
    WebElement stateDropdown;

    @FindBy(xpath = "//*[@id='ELIG-Residential-AddressState']/option")
    List<WebElement> stateDropdownOptions;

    @FindBy(id = "ELIG-Residential-AddressZipCode")
    WebElement zipcodeInput;

    @FindBy(id = "ELIG-Residential-AddressCounty")
    WebElement countyDropdown;

    @FindBy(xpath = "//*[@id='ELIG-Residential-AddressCounty']/option")
    List<WebElement> countyDropdownOptions;

    @FindBy(id = "ELIG-Mailing-AddressLine1")
    WebElement mailingAddressLine1Input;

    @FindBy(id = "ELIG-Mailing-AddressCity")
    WebElement mailingCityInput;

    @FindBy(id = "ELIG-Mailing-AddressState")
    WebElement mailingStateDropdown;

    @FindBy(xpath = "//*[@id='ELIG-Mailing-AddressState']/option")
    List<WebElement> mailingStateDropdownOptions;

    @FindBy(id = "ELIG-Mailing-AddressZipCode")
    WebElement mailingZipcodeInput;

    @FindBy(id = "ELIG-Mailing-AddressCounty")
    WebElement mailingCountyDropdown;

    @FindBy(xpath = "//*[@id='ELIG-Mailing-AddressCounty']/option")
    List<WebElement> mailingCountyDropdownOptions;

    @FindBy(css = "[fieldname='mailingAddressSameAsResidence'] button")
    List<WebElement> mailingAddressButtons;

    @FindBy(css = "[fieldname='coloradoResident'] button")
    List<WebElement> liveInColoradoButtons;

    @FindBy(id = "ELIG-additionalInformation-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "ELIG-additionalInformation-GoBack")
    WebElement goBackButton;

    @FindBy(css = ".header-1")
    WebElement hdrAddInfoForYourself;

    @FindBy(css = ".body-text-1")
    List<WebElement> AddInfoForYourselfPageText;

    public void clickSaveAndContinueButton() {
        basicActions.scrollToElement(saveAndContinueButton);
        saveAndContinueButton.click();
    }

    public void mailingAddressSelection(String mailingAddress) {
        basicActions.waitForElementListToBePresent(mailingAddressButtons, 30);
        switch (mailingAddress) {
            case "Yes":
                mailingAddressButtons.get(0).click();
                break;
            case "No":
                mailingAddressButtons.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + mailingAddress);
        }
    }

    public void liveInColoradoSelection(String liveInColorado) {
        basicActions.waitForElementListToBePresent(liveInColoradoButtons, 30);
        switch (liveInColorado) {
            case "Yes":
                liveInColoradoButtons.get(0).click();
                break;
            case "No":
                liveInColoradoButtons.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + liveInColorado);

        }
    }

    public void memberResidentialAddressCoCo(String addressLine1, String city, String state, String zipcode, String county) {
        basicActions.waitForElementToBePresent(addressLine1Input, 30);
        addressLine1Input.sendKeys(addressLine1);

        basicActions.waitForElementToBePresent(cityInput, 30);
        cityInput.sendKeys(city);

        basicActions.waitForElementToBePresent(stateDropdown, 30);
        stateDropdown.click();
        basicActions.selectValueFromDropdown(stateDropdown, stateDropdownOptions, state);

        basicActions.waitForElementToBePresent(zipcodeInput, 30);
        zipcodeInput.sendKeys(zipcode);

        basicActions.waitForElementToBeClickable(countyDropdown, 30);
        countyDropdown.click();
        basicActions.selectValueFromDropdown(countyDropdown, countyDropdownOptions, county);
    }

    public void memberMailingAddressCoCo(String addressLine1, String city, String state, String zipcode, String county) {
        basicActions.waitForElementToBePresent(mailingAddressLine1Input, 30);
        mailingAddressLine1Input.sendKeys(addressLine1);

        basicActions.waitForElementToBePresent(mailingCityInput, 30);
        mailingCityInput.sendKeys(city);

        basicActions.waitForElementToBePresent(mailingStateDropdown, 30);
        mailingStateDropdown.click();
        basicActions.selectValueFromDropdown(mailingStateDropdown, mailingStateDropdownOptions, state);

        basicActions.waitForElementToBePresent(mailingZipcodeInput, 30);
        mailingZipcodeInput.sendKeys(zipcode);

        basicActions.waitForElementToBeClickable(mailingCountyDropdown, 30);
        mailingCountyDropdown.click();
        basicActions.selectValueFromDropdown(mailingCountyDropdown, mailingCountyDropdownOptions, county);
    }

    public void clickGoBackButton() {
        basicActions.waitForElementToBeClickable(goBackButton, 30);
        goBackButton.click();
    }

    public void verifyTextOnAddInfoForYourself(String language) {
        basicActions.waitForElementToBePresent(saveAndContinueButton, 10);
        switch (language) {
            case "English":
                verifyTextOnAddInfoForYourselfEnglish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }

    public void verifyTextOnAddInfoForYourselfEnglish() {
        softAssert.assertEquals(hdrAddInfoForYourself.getText(), "Additional information for yourself" );
        softAssert.assertEquals(AddInfoForYourselfPageText.get(0).getText(), "Enter your residential address");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(1).getText(), "Address line 1");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(2).getText(), "Address line 2");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(3).getText(), "City");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(4).getText(), "State");

        String[] expectedOptionsStates = {
                "Select Option", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS",
                "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY",
                "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV",
                "WI", "WY"
        };

        for (String option : expectedOptionsStates) {
            boolean optionExists = AddInfoForYourselfPageText.get(5).getText().contains(option);
            softAssert.assertTrue(optionExists, "Option '" + option + "' is not displayed in the dropdown.");
        }

        softAssert.assertEquals(AddInfoForYourselfPageText.get(6).getText(), "Zip code");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(7).getText(), "County");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(9).getText(), "Is your mailing address same as your residential address above?");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(10).getText(), "Enter your mailing address");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(11).getText(), "Address line 1");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(12).getText(), "Address line 2");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(13).getText(), "City");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(14).getText(), "State");

        String[] expectedOptionsStatesMailAddress = {
                "Select Option", "AL", "AK", "AZ", "AR", "CA", "CO", "CT", "DE", "FL", "GA", "HI", "ID", "IL", "IN", "IA", "KS",
                "KY", "LA", "ME", "MD", "MA", "MI", "MN", "MS", "MO", "MT", "NE", "NV", "NH", "NJ", "NM", "NY",
                "NC", "ND", "OH", "OK", "OR", "PA", "RI", "SC", "SD", "TN", "TX", "UT", "VT", "VA", "WA", "WV",
                "WI", "WY"
        };

        for (String option : expectedOptionsStatesMailAddress) {
            boolean optionExists = AddInfoForYourselfPageText.get(15).getText().contains(option);
            softAssert.assertTrue(optionExists, "Option '" + option + "' is not displayed in the dropdown.");
        }

        softAssert.assertEquals(AddInfoForYourselfPageText.get(16).getText(), "Zip code");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(17).getText(), "County");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(19).getText(), "Do you live in Colorado?");
        softAssert.assertEquals(goBackButton.getText(), " Go Back");
        softAssert.assertEquals(saveAndContinueButton.getText(), "Save and Continue");
        softAssert.assertAll();
    }

}
