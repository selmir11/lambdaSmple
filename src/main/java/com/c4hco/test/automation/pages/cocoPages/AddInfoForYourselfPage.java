package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.Address;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class AddInfoForYourselfPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    public AddInfoForYourselfPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "ELIG-Residential-AddressLine1")
    WebElement addressLine1Input;

    @FindBy(id = "ELIG-Residential-AddressLine2")
    WebElement addressLine2Input;

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

    @FindBy(id = "ELIG-Mailing-AddressLine2")
    WebElement mailingAddressLine2Input;

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

    @FindBy(css = ".required")
    List<WebElement> errorMessages;

    @FindBy(css = ".svg-inline--fa.fa-exclamation-circle")
    List<WebElement> exclamationMarkIcon;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBePresentWithRetries(hdrAddInfoForYourself, 90);
        basicActions.waitForElementListToBePresent(liveInColoradoButtons, 90);
        basicActions.waitForElementListToBePresent(stateDropdownOptions, 90);
        basicActions.waitForElementListToBePresentWithRetries(AddInfoForYourselfPageText, 90);
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 90);
        basicActions.waitForElementToBePresentWithRetries(saveAndContinueButton, 150);
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueButton, 150);
        basicActions.scrollToElement(saveAndContinueButton);
        saveAndContinueButton.click();
    }

    public void mailingAddressSelection(String mailingAddress) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
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
        subscriber.setMailingAddress(subscriber.getResAddress());
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
        MemberDetails subscriber = SharedData.getPrimaryMember();
        Address address = new Address();
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

        address.setAddressLine1(addressLine1);
        address.setAddressCity(city);
        address.setAddressState(state);
        address.setAddressZipcode(zipcode);
        address.setAddressCounty(county);
        subscriber.setResAddress(address);
    }

    public void memberMailingAddressCoCo(String addressLine1, String city, String state, String zipcode, String county) {
        MemberDetails subscriber = SharedData.getPrimaryMember();
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
        Address mailinglAddress = new Address();
        mailinglAddress.setAddressLine1(addressLine1);
        mailinglAddress.setAddressCity(city);
        mailinglAddress.setAddressState(state);
        mailinglAddress.setAddressZipcode(zipcode);
        mailinglAddress.setAddressCounty(county);
        subscriber.setMailingAddress(mailinglAddress);
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
            case "Spanish":
                verifyTextOnAddInfoForYourselfSpanish();
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
                "Select Option", "AA", "AE", "AP", "AK", "AL", "AR", "AS", "AZ", "CO", "CT", "DE", "FL", "FM", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS",
                "KY", "LA", "MA", "MD", "ME", "MH", "MI", "MN", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY",
                "OH", "OK", "OR", "PA", "PR", "PW", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV",
                "WY"
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
                "Select Option", "AA", "AE", "AP", "AK", "AL", "AR", "AS", "AZ", "CO", "CT", "DE", "FL", "FM", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS",
                "KY", "LA", "MA", "MD", "ME", "MH", "MI", "MN", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY",
                "OH", "OK", "OR", "PA", "PR", "PW", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV",
                "WY"
        };

        for (String option : expectedOptionsStatesMailAddress) {
            boolean optionExists = AddInfoForYourselfPageText.get(15).getText().contains(option);
            softAssert.assertTrue(optionExists, "Option '" + option + "' is not displayed in the dropdown.");
        }

        softAssert.assertEquals(AddInfoForYourselfPageText.get(16).getText(), "Zip code");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(17).getText(), "County");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(19).getText(), "Do you live in Colorado?");
        softAssert.assertEquals(goBackButton.getText(), " Go Back");
        softAssert.assertEquals(saveAndContinueButton.getText(), "Save and continue");
        softAssert.assertAll();
    }

    public void verifyTextOnAddInfoForYourselfSpanish() {
        softAssert.assertEquals(hdrAddInfoForYourself.getText(), "Informaci\u00F3n adicional sobre usted" );
        softAssert.assertEquals(AddInfoForYourselfPageText.get(0).getText(), "Ingrese su domicilio particular");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(1).getText(), "Domicilio 1");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(2).getText(), "Domicilio 2");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(3).getText(), "Ciudad");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(4).getText(), "Estado");

        String[] expectedOptionsStates = {
                "Seleccione", "AA", "AE", "AP", "AK", "AL", "AR", "AS", "AZ", "CO", "CT", "DE", "FL", "FM", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS",
                "KY", "LA", "MA", "MD", "ME", "MH", "MI", "MN", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR",
                "PW", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"
        };

        for (String option : expectedOptionsStates) {
            boolean optionExists = AddInfoForYourselfPageText.get(5).getText().contains(option);
            softAssert.assertTrue(optionExists, "Option '" + option + "' is not displayed in the dropdown.");
            softAssert.assertAll();
        }

        softAssert.assertEquals(AddInfoForYourselfPageText.get(6).getText(), "C\u00F3digo postal");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(7).getText(), "Condado");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(9).getText(), "\u00BFSu domicilio postal es el mismo que el domicilio residencial que se especifica arriba?");
        softAssert.assertEquals(mailingAddressButtons.get(0).getText(), "Si");
        softAssert.assertEquals(mailingAddressButtons.get(1).getText(), "  No");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(10).getText(), "\u00BFCu\u00E1l es su direcci\u00F3n postal?");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(11).getText(), "Domicilio 1");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(12).getText(), "Domicilio 2");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(13).getText(), "Ciudad");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(14).getText(), "Estado");

        String[] expectedOptionsStatesMailAddress = {
                "Seleccione", "AA", "AE", "AP", "AK", "AL", "AR", "AS", "AZ", "CO", "CT", "DE", "FL", "FM", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS",
                "KY", "LA", "MA", "MD", "ME", "MH", "MI", "MN", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR",
                "PW", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"
        };

        for (String option : expectedOptionsStatesMailAddress) {
            boolean optionExists = AddInfoForYourselfPageText.get(15).getText().contains(option);
            softAssert.assertTrue(optionExists, "Option '" + option + "' is not displayed in the dropdown.");
            softAssert.assertAll();
        }

        softAssert.assertEquals(AddInfoForYourselfPageText.get(16).getText(), "C\u00F3digo postal");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(17).getText(), "Condado");
        softAssert.assertEquals(AddInfoForYourselfPageText.get(19).getText(), "\u00BFVive usted en Colorado?");
        softAssert.assertEquals(liveInColoradoButtons.get(0).getText(), "Si");
        softAssert.assertEquals(liveInColoradoButtons.get(1).getText(), "No");
        softAssert.assertEquals(goBackButton.getText(), " Volver");
        softAssert.assertEquals(saveAndContinueButton.getText(), "Guardar y continuar");
        softAssert.assertAll();
    }

    public void verifyErrorMessagesAddInfoForYourself(String language) {
        basicActions.waitForElementToBePresent(saveAndContinueButton, 10);
        switch (language) {
            case "English":
                verifyErrorMessagesOnAddInfoForYourselfEnglish();
                break;
            case "Spanish":
                verifyErrorMessagesOnAddInfoForYourselfSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }

    public void verifyErrorMessagesOnAddInfoForYourselfEnglish() {
        softAssert.assertEquals(errorMessages.get(0).getText(), "Address line 1 is required");
        softAssert.assertTrue(exclamationMarkIcon.get(0).isDisplayed());
        softAssert.assertEquals(errorMessages.get(1).getText(), "City is required");
        softAssert.assertTrue(exclamationMarkIcon.get(1).isDisplayed());
        softAssert.assertEquals(errorMessages.get(2).getText(), "State is required");
        softAssert.assertTrue(exclamationMarkIcon.get(2).isDisplayed());
        softAssert.assertEquals(errorMessages.get(3).getText(), "Zip code is required");
        softAssert.assertTrue(exclamationMarkIcon.get(3).isDisplayed());
        softAssert.assertEquals(errorMessages.get(4).getText(), "County is required");
        softAssert.assertTrue(exclamationMarkIcon.get(4).isDisplayed());
        softAssert.assertEquals(errorMessages.get(5).getText(), "Please select one of the options below");
        mailingAddressButtons.get(1).click();
        softAssert.assertEquals(errorMessages.get(5).getText(), "Address line 1 is required");
        softAssert.assertTrue(exclamationMarkIcon.get(5).isDisplayed());
        softAssert.assertEquals(errorMessages.get(6).getText(), "City is required");
        softAssert.assertTrue(exclamationMarkIcon.get(6).isDisplayed());
        softAssert.assertEquals(errorMessages.get(7).getText(), "State is required");
        softAssert.assertTrue(exclamationMarkIcon.get(7).isDisplayed());
        softAssert.assertEquals(errorMessages.get(8).getText(), "Zip code is required");
        softAssert.assertTrue(exclamationMarkIcon.get(8).isDisplayed());
        softAssert.assertEquals(errorMessages.get(9).getText(), "County is required");
        softAssert.assertTrue(exclamationMarkIcon.get(9).isDisplayed());
        softAssert.assertEquals(errorMessages.get(10).getText(), "Please select one of the options below");
        addressLine1Input.sendKeys("Word");
        softAssert.assertEquals(errorMessages.get(0).getText(), "Address line 1 must be at least 5 characters long");
        addressLine1Input.sendKeys("$");
        softAssert.assertEquals(errorMessages.get(0).getText(), "Special character is not allowed");
        addressLine2Input.sendKeys("Word");
        softAssert.assertEquals(errorMessages.get(1).getText(), "Address line 2 must be at least 5 characters long");
        addressLine2Input.sendKeys("$");
        softAssert.assertEquals(errorMessages.get(1).getText(), "Special character is not allowed");
        cityInput.sendKeys("W");
        softAssert.assertEquals(errorMessages.get(2).getText(), "City must be at least 2 characters long");
        zipcodeInput.sendKeys("1234");
        softAssert.assertEquals(errorMessages.get(4).getText(), "Zip code must be 5 numbers");
        mailingAddressLine1Input.sendKeys("Word");
        softAssert.assertEquals(errorMessages.get(6).getText(), "Address line 1 must be at least 5 characters long");
        mailingAddressLine1Input.sendKeys("$");
        softAssert.assertEquals(errorMessages.get(6).getText(), "Special character is not allowed");
        mailingAddressLine2Input.sendKeys("Word");
        softAssert.assertEquals(errorMessages.get(7).getText(), "Address line 2 must be at least 5 characters long");
        mailingAddressLine2Input.sendKeys("$");
        softAssert.assertEquals(errorMessages.get(7).getText(), "Special character is not allowed");
        mailingCityInput.sendKeys("W");
        softAssert.assertEquals(errorMessages.get(8).getText(), "City must be at least 2 characters long");
        mailingZipcodeInput.sendKeys("1234");
        softAssert.assertEquals(errorMessages.get(10).getText(), "Zip code must be 5 numbers");
        softAssert.assertAll();
    }

    public void verifyErrorMessagesOnAddInfoForYourselfSpanish() {
        softAssert.assertEquals(errorMessages.get(0).getText(), "Domicilio 1 obligatorio");
        softAssert.assertTrue(exclamationMarkIcon.get(0).isDisplayed());
        softAssert.assertEquals(errorMessages.get(1).getText(), "El ciudad es requerido");
        softAssert.assertTrue(exclamationMarkIcon.get(1).isDisplayed());
        softAssert.assertEquals(errorMessages.get(2).getText(), "Estado es obligatorio");
        softAssert.assertTrue(exclamationMarkIcon.get(2).isDisplayed());
        softAssert.assertEquals(errorMessages.get(3).getText(), "C\u00F3digo postal es requerido");
        softAssert.assertTrue(exclamationMarkIcon.get(3).isDisplayed());
        softAssert.assertEquals(errorMessages.get(4).getText(), "Condado es requerido");
        softAssert.assertTrue(exclamationMarkIcon.get(4).isDisplayed());
        softAssert.assertEquals(errorMessages.get(5).getText(), "Seleccione una de las siguientes opciones");
        mailingAddressButtons.get(1).click();
        softAssert.assertEquals(errorMessages.get(5).getText(), "Domicilio 1 obligatorio");
        softAssert.assertTrue(exclamationMarkIcon.get(5).isDisplayed());
        softAssert.assertEquals(errorMessages.get(6).getText(), "El ciudad es requerido");
        softAssert.assertTrue(exclamationMarkIcon.get(6).isDisplayed());
        softAssert.assertEquals(errorMessages.get(7).getText(), "Estado es obligatorio");
        softAssert.assertTrue(exclamationMarkIcon.get(7).isDisplayed());
        softAssert.assertEquals(errorMessages.get(8).getText(), "C\u00F3digo postal es requerido");
        softAssert.assertTrue(exclamationMarkIcon.get(8).isDisplayed());
        softAssert.assertEquals(errorMessages.get(9).getText(), "Condado es requerido");
        softAssert.assertTrue(exclamationMarkIcon.get(9).isDisplayed());
        softAssert.assertEquals(errorMessages.get(10).getText(), "Seleccione una de las siguientes opciones");
        addressLine1Input.sendKeys("Word");
        softAssert.assertEquals(errorMessages.get(0).getText(), "El domicilio 1 debe tener al menos 5 caracteres");
        addressLine1Input.sendKeys("$");
        softAssert.assertEquals(errorMessages.get(0).getText(), "Los caracteres especiales no est\u00E1n permitidos");
        addressLine2Input.sendKeys("Word");
        softAssert.assertEquals(errorMessages.get(1).getText(), "El domicilio 2 debe tener al menos 5 caracteres");
        addressLine2Input.sendKeys("$");
        softAssert.assertEquals(errorMessages.get(1).getText(), "Los caracteres especiales no est\u00E1n permitidos");
        cityInput.sendKeys("W");
        softAssert.assertEquals(errorMessages.get(2).getText(), "El nombre de la ciudad debe de tener al menos 2 caracteres de largo");
        zipcodeInput.sendKeys("1234");
        softAssert.assertEquals(errorMessages.get(4).getText(), "C\u00F3digo postal debe de tener 5 numeros");
        mailingAddressLine1Input.sendKeys("Word");
        softAssert.assertEquals(errorMessages.get(6).getText(), "El domicilio 1 debe tener al menos 5 caracteres");
        mailingAddressLine1Input.sendKeys("$");
        softAssert.assertEquals(errorMessages.get(6).getText(), "Los caracteres especiales no est\u00E1n permitidos");
        mailingAddressLine2Input.sendKeys("Word");
        softAssert.assertEquals(errorMessages.get(7).getText(), "El domicilio 2 debe tener al menos 5 caracteres");
        mailingAddressLine2Input.sendKeys("$");
        softAssert.assertEquals(errorMessages.get(7).getText(), "Los caracteres especiales no est\u00E1n permitidos");
        mailingCityInput.sendKeys("W");
        softAssert.assertEquals(errorMessages.get(8).getText(), "El nombre de la ciudad debe de tener al menos 2 caracteres de largo");
        mailingZipcodeInput.sendKeys("1234");
        softAssert.assertEquals(errorMessages.get(10).getText(), "C\u00F3digo postal debe de tener 5 numeros");
        softAssert.assertAll();
    }

    public void validateCounties(String counties){
       List<String> expectedCounties = Arrays.asList(counties.split(","));
        basicActions.waitForElementToBeClickable(countyDropdown, 30);
        countyDropdown.click();
        basicActions.waitForElementListToBePresent(countyDropdownOptions, 10);
        List<String> countyOptionsFromDropdown = countyDropdownOptions.stream().map(WebElement::getText).collect(Collectors.toList());
        countyOptionsFromDropdown.remove("Select Option");
        softAssert.assertEquals(new HashSet<>(expectedCounties), new HashSet<>(countyOptionsFromDropdown), "Available county options did not match");
        softAssert.assertAll();
    }

    public void updateStateAndZip(String state, String zipcode){
        basicActions.waitForElementToBePresent(stateDropdown, 30);
        stateDropdown.click();
        basicActions.selectValueFromDropdown(stateDropdown, stateDropdownOptions, state);

        basicActions.waitForElementToBePresent(zipcodeInput, 30);
        Assert.assertTrue(basicActions.clearElementWithRetries(zipcodeInput));
        zipcodeInput.sendKeys(zipcode);
    }

    public void validateCountyField(){
           basicActions.waitForElementToBePresent(countyDropdown, 30);
           softAssert.assertFalse(countyDropdown.isEnabled(), "Dropdown field is not disabled");
           softAssert.assertAll();
    }

}
