package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AddInfoForYourselfPage {
    private BasicActions basicActions;

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

    @FindBy(css = "[fieldname='mailingAddressSameAsResidence'] button")
    List<WebElement> mailingAddressButtons;

    @FindBy(css = "[fieldname='coloradoResident'] button")
    List<WebElement> liveInColoradoButtons;

    @FindBy(id = "ELIG-additionalInformation-SaveAndContinue")
    WebElement saveAndContinueButton;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
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

        basicActions.waitForElementToBePresent(countyDropdown, 30);
        countyDropdown.click();
        basicActions.selectValueFromDropdown(countyDropdown, countyDropdownOptions, county);
    }

}
