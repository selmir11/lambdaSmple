package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.Address;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class AddInfoForAdditionalMemberCoCoPage {

    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public AddInfoForAdditionalMemberCoCoPage(WebDriver webDriver) {
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

    @FindBy(css = "[fieldname='coloradoResident'] button")
    List<WebElement> liveInColoradoButtons;

    @FindBy(id = "ELIG-additionalInformation-SaveAndContinue")
    WebElement saveAndContinueButton;

    @FindBy(id = "ELIG-additionalInformation-GoBack")
    WebElement goBackButton;

    @FindBy(css = ".header-1")
    WebElement hdrAddInfoForAddMember;

    @FindBy(css = ".body-text-1")
    List<WebElement> AddInfoForAddMemberPageText;

    @FindBy(css = ".required")
    List<WebElement> errorMessages;

    @FindBy(css = ".svg-inline--fa.fa-exclamation-circle")
    List<WebElement> exclamationMarkIcon;

    public void clickSaveAndContinueButton() {
        basicActions.waitForElementToBeClickable(saveAndContinueButton, 30);
        basicActions.scrollToElement(saveAndContinueButton);
        saveAndContinueButton.click();
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

    public void addMemberResidentialAddressCoCo(String addressLine1, String city, String state, String zipcode, String county) {
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
        List<MemberDetails> memberList=basicActions.getAllMem();
        String actualMemberInfo = hdrAddInfoForAddMember.getText().replace("Additional information for ","");
        for(MemberDetails actualMember : memberList) {
            if(actualMemberInfo.contains(actualMember.getFirstName())) {
                Address address = new Address();
                address.setAddressLine1(addressLine1);
                address.setAddressCity(city);
                address.setAddressState(state);
                address.setAddressZipcode(zipcode);
                address.setAddressCounty(county);
                actualMember.setResAddress(address);
                break;
            }
        }
    }
    public void addMemberCompleteResidentialAddressCoCo(String addressLine1, String addressLine2, String city, String state, String zipcode, String county) {
        basicActions.waitForElementToBePresent(addressLine1Input, 30);
        addressLine1Input.sendKeys(addressLine1);

        basicActions.waitForElementToBePresent(addressLine2Input, 30);
        addressLine2Input.sendKeys(addressLine2);

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
    public void clickGoBackButton() {
        basicActions.waitForElementToBeClickable(goBackButton, 30);
        goBackButton.click();
    }

    public void verifyTextOnAdditionalInformationForAdditionalMemberPage(String language) {
        basicActions.waitForElementToBePresent(saveAndContinueButton, 10);
        switch (language) {
            case "English":
                verifyTextOnAdditionalInfoForAddMemberEnglish();
                break;
            case "Spanish":
                verifyTextOnAdditionalInfoForAddMemberSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }

    public void verifyTextOnAdditionalInfoForAddMemberEnglish() {
        softAssert.assertEquals(hdrAddInfoForAddMember.getText(), "Additional information for " + Character.toUpperCase(SharedData.getMembers().get(0).getFirstName().charAt(0)) + SharedData.getMembers().get(0).getFirstName().substring(1) + " " + Character.toUpperCase(SharedData.getMembers().get(0).getMiddleName().charAt(0)) + ". " + Character.toUpperCase(SharedData.getMembers().get(0).getLastName().charAt(0)) + SharedData.getMembers().get(0).getLastName().substring(1));
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(0).getText(), "Enter "+ Character.toUpperCase(SharedData.getMembers().get(0).getFirstName().charAt(0)) + SharedData.getMembers().get(0).getFirstName().substring(1) + "'s residential address");
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(1).getText(), "Address line 1");
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(2).getText(), "Address line 2");
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(3).getText(), "City");
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(4).getText(), "State");

        String[] expectedOptionsStates = {
                "Select Option", "AA", "AE", "AP", "AK", "AL", "AR", "AS", "AZ", "CO", "CT", "DE", "FL", "FM", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS",
                "KY", "LA", "MA", "MD", "ME", "MH", "MI", "MN", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY",
                "OH", "OK", "OR", "PA", "PR", "PW", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV",
                "WY"
        };

        for (String option : expectedOptionsStates) {
            boolean optionExists = AddInfoForAddMemberPageText.get(5).getText().contains(option);
            softAssert.assertTrue(optionExists, "Option '" + option + "' is not displayed in the dropdown.");
        }

        softAssert.assertEquals(AddInfoForAddMemberPageText.get(6).getText(), "Zip code");
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(7).getText(), "County");
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(9).getText(), "Does " + Character.toUpperCase(SharedData.getMembers().get(0).getFirstName().charAt(0)) + SharedData.getMembers().get(0).getFirstName().substring(1) + " live in Colorado?");
        softAssert.assertEquals(liveInColoradoButtons.get(0).getText(), "Yes");
        softAssert.assertEquals(liveInColoradoButtons.get(1).getText(), "No");
        softAssert.assertEquals(goBackButton.getText(), " Go Back");
        softAssert.assertEquals(saveAndContinueButton.getText(), "Save and continue");
        softAssert.assertAll();
    }

    public void verifyTextOnAdditionalInfoForAddMemberSpanish() {
        softAssert.assertEquals(hdrAddInfoForAddMember.getText(), "Informaci\u00F3n adicional para " + Character.toUpperCase(SharedData.getMembers().get(0).getFirstName().charAt(0)) + SharedData.getMembers().get(0).getFirstName().substring(1) + " " + Character.toUpperCase(SharedData.getMembers().get(0).getMiddleName().charAt(0)) + ". " + Character.toUpperCase(SharedData.getMembers().get(0).getLastName().charAt(0)) + SharedData.getMembers().get(0).getLastName().substring(1));
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(0).getText(), "Ingrese el domicilio particular de " + Character.toUpperCase(SharedData.getMembers().get(0).getFirstName().charAt(0)) + SharedData.getMembers().get(0).getFirstName().substring(1));
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(1).getText(), "Domicilio 1");
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(2).getText(), "Domicilio 2");
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(3).getText(), "Ciudad");
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(4).getText(), "Estado");

        String[] expectedOptionsStates = {
                "Seleccione", "AA", "AE", "AP", "AK", "AL", "AR", "AS", "AZ", "CO", "CT", "DE", "FL", "FM", "GA", "GU", "HI", "IA", "ID", "IL", "IN", "KS",
                "KY", "LA", "MA", "MD", "ME", "MH", "MI", "MN", "MS", "MT", "NC", "ND", "NE", "NH", "NJ", "NM", "NV", "NY", "OH", "OK", "OR", "PA", "PR",
                "PW", "RI", "SC", "SD", "TN", "TX", "UT", "VA", "VT", "WA", "WI", "WV", "WY"
        };

        for (String option : expectedOptionsStates) {
            boolean optionExists = AddInfoForAddMemberPageText.get(5).getText().contains(option);
            softAssert.assertTrue(optionExists, "Option '" + option + "' is not displayed in the dropdown.");
            softAssert.assertAll();
        }

        softAssert.assertEquals(AddInfoForAddMemberPageText.get(6).getText(), "C\u00F3digo postal");
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(7).getText(), "Condado");
        softAssert.assertEquals(AddInfoForAddMemberPageText.get(9).getText(), "\u00BF" + Character.toUpperCase(SharedData.getMembers().get(0).getFirstName().charAt(0)) + SharedData.getMembers().get(0).getFirstName().substring(1) + " vive en Colorado?");
        softAssert.assertEquals(liveInColoradoButtons.get(0).getText(), "S\u00ED");
        softAssert.assertEquals(liveInColoradoButtons.get(1).getText(), "No");
        softAssert.assertEquals(goBackButton.getText(), " Volver");
        softAssert.assertEquals(saveAndContinueButton.getText(), "Guardar y continuar");
        softAssert.assertAll();
    }


    public void verifyErrorMessagesAddInfoForAddMember(String language) {
        basicActions.waitForElementToBePresent(saveAndContinueButton, 10);
        switch (language) {
            case "English":
                verifyErrorMessagesAddInfoForAddMemberEnglish();
                break;
            case "Spanish":
                verifyErrorMessagesAddInfoForAddMemberSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }

    public void verifyErrorMessagesAddInfoForAddMemberEnglish() {
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
        softAssert.assertAll();
    }

    public void verifyErrorMessagesAddInfoForAddMemberSpanish() {
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
        softAssert.assertAll();
    }

    public void updateStateAndZipAddtlMem(String state, String zipcode){
        basicActions.waitForElementToBePresent(stateDropdown, 30);
        stateDropdown.click();
        basicActions.selectValueFromDropdown(stateDropdown, stateDropdownOptions, state);

        basicActions.waitForElementToBePresent(zipcodeInput, 30);
        Assert.assertTrue(basicActions.clearElementWithRetries(zipcodeInput));
        zipcodeInput.sendKeys(zipcode);
    }

    public void validateCountyFieldAddtlMem(){
        basicActions.waitForElementToBePresent(countyDropdown, 30);
        softAssert.assertFalse(countyDropdown.isEnabled(), "Dropdown field is not disabled");
        softAssert.assertAll();
    }

    public void validateAddMemberCompleteResidentialAddressCoCo(String addressLine1, String addressLine2, String city, String state, String zipcode, String county) {
        basicActions.waitForElementToBePresent(addressLine1Input, 30);
        softAssert.assertEquals(addressLine1Input.getAttribute("value"),addressLine1);
        softAssert.assertEquals(addressLine2Input.getAttribute("value"),addressLine2);
        softAssert.assertEquals(cityInput.getAttribute("value"),city);
        softAssert.assertEquals(stateDropdown.getAttribute("value"),state);
        softAssert.assertEquals(zipcodeInput.getAttribute("value"),zipcode);
        softAssert.assertEquals(countyDropdown.getAttribute("value"),county);
        softAssert.assertAll();
    }

    public void validateColoradoOption(String liveInColoradoButton){
        basicActions.waitForElementListToBePresent(liveInColoradoButtons, 10);
        switch (liveInColoradoButton) {
            case "Yes":
                // if the Yes option is selected
                boolean isYesSelected = liveInColoradoButtons.get(0).getAttribute("class").contains("option-button-selected");
                softAssert.assertTrue(isYesSelected);
                break;
            case "No":
                // if the No option is selected
                boolean isNoSelected = liveInColoradoButtons.get(1).getAttribute("class").contains("option-button-selected");
                softAssert.assertTrue(isNoSelected);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + liveInColoradoButton);
        }
        softAssert.assertAll();
    }

    public void updateAddressLine1AndAddressLine2AddtlMem(String addressLine1, String addressLine2){
        basicActions.waitForElementToBePresent(addressLine1Input, 30);
        addressLine1Input.click();
        addressLine1Input.sendKeys(Keys.CONTROL + "a");
        addressLine1Input.sendKeys(addressLine1);
        addressLine2Input.click();
        addressLine2Input.sendKeys(Keys.CONTROL + "a");
        addressLine2Input.sendKeys(addressLine2);
        List<MemberDetails> memberList=basicActions.getAllMem();
        String actualMemberInfo = hdrAddInfoForAddMember.getText().replace("Additional information for ","");
        for(MemberDetails actualMember : memberList) {
            if(actualMemberInfo.contains(actualMember.getFirstName())) {
                Address address = new Address();
                address.setAddressLine1(addressLine1);
                address.setAddressLine2(addressLine2);
                actualMember.setResAddress(address);
                break;
            }
        }
    }
    public void updateResidentialAddressAddlMem(String memPrefix, String addressLine1, String addressLine2,String city, String state, String zipcode,String county ){
        basicActions.waitForElementToBePresent(addressLine1Input, 30);
        addressLine1Input.click();
        addressLine1Input.clear();
        addressLine1Input.sendKeys(addressLine1);
        addressLine2Input.click();
        addressLine2Input.clear();
        addressLine2Input.sendKeys(addressLine2);
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
        stateDropdown.click();
        basicActions.selectValueFromDropdown(stateDropdown, stateDropdownOptions, state);
        zipcodeInput.click();
        zipcodeInput.clear();
        zipcodeInput.sendKeys(zipcode);
        countyDropdown.click();
        basicActions.selectValueFromDropdown(countyDropdown, countyDropdownOptions, county);
    }
}
