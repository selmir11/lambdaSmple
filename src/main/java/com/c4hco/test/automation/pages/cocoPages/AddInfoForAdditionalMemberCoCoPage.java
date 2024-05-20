package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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
        softAssert.assertEquals(saveAndContinueButton.getText(), "Save and Continue");
        softAssert.assertAll();
    }

}
