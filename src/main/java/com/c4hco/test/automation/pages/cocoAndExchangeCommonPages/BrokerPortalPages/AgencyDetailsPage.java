package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.Address;
import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class AgencyDetailsPage {
    SoftAssert softAssert = new SoftAssert();
    @FindBy(xpath = "//*[@id='elem']/app-agency-details/div/div")
    WebElement agencyDetailsTitle;

    @FindBy(xpath = "//label[@for='agencyName']")
    WebElement agencyNameLabel;

    @FindBy(xpath = "//input[@id='agencyName']")
    WebElement agencyName;

    @FindBy(xpath = "//span[@id='an-mf-error']")
    WebElement agencyNameErrorMessage;

    @FindBy(id = "sp-char-name")
    WebElement agencyNameSpecialCharErrorMessage;

    @FindBy(xpath = "//label[@for='agencyTin']")
    WebElement agencyTinLabel;

    @FindBy(xpath = "//input[@id='agencyTin']")
    WebElement agencyTin;

    @FindBy(id = "atin-mf-error")
    WebElement agencyTinErrorMessage;

    @FindBy(xpath = "//label[@for='agencyGroup']")
    WebElement agencyGroupLabel;

    @FindBy(xpath = "//select[@id='agencyGroup']")
    WebElement agencyGroupDropdown;

    @FindBy(xpath = "//span[@id='ag-mf-error']")
    WebElement agencyGroupErrorMessage;

    @FindBy(id = "l_mailingHeader")
    WebElement agencyAddress;

    @FindBy(xpath = "//label[@for='primaryAddressLine1']")
    WebElement addressLine1Label;

    @FindBy(xpath = "//input[@id='primaryAddressLine1']")
    WebElement addressLine1;

    @FindBy(xpath = "//span[@id='address-mf-error']")
    WebElement addressLine1ErrorMessage;

    @FindBy(id = "sp-char-addone")
    WebElement addressLine1SpecialCharErrorMessage;

    @FindBy(xpath = "//label[@for='primaryAddressLine2']")
    WebElement addressLine2Label;

    @FindBy(xpath = "//input[@id='primaryAddressLine2']")
    WebElement addressLine2;

    @FindBy(id = "sp-char-addtwo")
    WebElement addressLine2SpecialCharErrorMessage;

    @FindBy(xpath = "//label[@for='primaryCity']")
    WebElement cityLabel;

    @FindBy(xpath = "//input[@id='primaryCity']")
    WebElement cityField;

    @FindBy(xpath = "//span[@id='city-mf-error']")
    WebElement cityErrorMessage;

    @FindBy(id = "sp-char-city")
    WebElement citySpecialCharErrorMessage;

    @FindBy(xpath = "//label[@for='primaryState']")
    WebElement stateLabel;

    @FindBy(xpath = "//select[@id='primaryState']")
    WebElement stateDropdown;

    @FindBy(xpath = "//span[@id='state-mf-error']")
    WebElement stateErrorMessage;

    @FindBy(xpath = "//label[@for='primaryZipLbl']")
    WebElement zipCodeLabel;

    @FindBy(xpath = "//input[@id='primaryZip']")
    WebElement zipCodeField;

    @FindBy(xpath = "//span[@id='zc-mf-error']")
    WebElement zipCodeErrorMessage;

    @FindBy(id = "sp-char-zip")
    WebElement zipCodeSpecialCharErrorMessage;

    @FindBy(xpath = "//label[@for='primaryCounty']")
    WebElement countyLabel;

    @FindBy(xpath = "//select[@id='primaryCounty']")
    WebElement countyDropdown;

    @FindBy(xpath = "//span[@id='country-mf-error']")
    WebElement countyErrorMessage;

    @FindBy(id = "l_hideAddress")
    WebElement hideAddressLabel;

    @FindBy(id = "hideAddress-input")
    WebElement hideAddressCheckbox;

    @FindBy(id = "l_workingHours")
    WebElement workingHoursLabel;

    @FindBy(id = "input-working-from")
    WebElement workingHoursFrom;

    @FindBy(id = "input-working-to")
    WebElement workingHoursTo;

    @FindBy(id = "wh-mf-error")
    WebElement workingHoursErrorMessage;

    @FindBy(id = "both-wh-error")
    WebElement workingHoursFromToErrorMessage;

    @FindBy(id = "l_workingDays")
    WebElement workingDaysLabel;

    @FindBy(xpath = "//*[@id='input-working-days']/ng-select/div/div/div[2]/input")
    WebElement workingDaysDropdown;

    @FindBy(xpath = "//span[normalize-space()='Monday']")
    WebElement workingDaysDropdownOption;

    @FindBy(id = "wd-mf-error")
    WebElement workingDaysErrorMessage;

    @FindBy(id = "l_languages")
    WebElement languagesLabel;

    @FindBy(xpath = "//*[@id='input-languages']/ng-select/div/div/div[2]/input")
    WebElement languagesDropdown;

    @FindBy(xpath = "//span[@class='ng-option-label'][normalize-space()='English']")
    WebElement languagesOption;

    @FindBy(id = "lan-mf-error")
    WebElement languagesErrorMessage;

    @FindBy(xpath = "//label[@for='email']")
    WebElement emailLabel;

    @FindBy(xpath = "//input[@id='email']")
    WebElement emailField;

    @FindBy(xpath = "//span[@id='email-mf-error']")
    WebElement emailErrorMessage;

    @FindBy(xpath = "//label[@for='phoneNumber']")
    WebElement phoneNumberLabel;

    @FindBy(xpath = "//input[@id='phoneNumber']")
    WebElement phoneNumberField;

    @FindBy(id = "ph-mf-error")
    WebElement phoneNumberErrorMessage;

    @FindBy(id = "BP-AgencyDetails-GoBack")
    WebElement agencyDetailsGoBackButton;

    @FindBy(id = "continue-button")
    WebElement agencyDetailsContinueButton;

    @FindBy(xpath = "//label[@id='l_agencyGroup']//em[@class='fas fa-question-circle']")
    WebElement agencyGroupTooltip;

    @FindBy(id = "agencygroup_helptext")
    WebElement agencyGroupTooltipText;

    @FindBy(id = "agencyGroup")
    WebElement disabledAgencyGroup;

    @FindBy(id= "cancel-button")
    WebElement cancelAgencyDetails;

    @FindBy(id= "BP-AgencyDetails-SaveandSubmit")
    WebElement saveSubmitAgencyDetails;

    @FindBy(xpath = "//label[@id='l_hideAddress']//em[@class='fas fa-question-circle']")
    WebElement agencyHideAddressTooltip;

    @FindBy(id = "hideAddress_helptext")
    WebElement agencyHideAddressTooltipText;

    @FindBy(id = "BP-AgencyDetails-SaveAndFinishLater")
    WebElement agencyDetailsSaveFinishLaterButton;

    private BasicActions basicActions;
    Actions builder;
    public AgencyDetailsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        builder  = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickContinueAgencyDetailsPage(){
        basicActions.waitForElementToBePresent(agencyDetailsContinueButton,10);
        agencyDetailsContinueButton.click();
    }

    public void clickGoBackAgencyDetailsPage(){
        basicActions.waitForElementToBePresent(agencyDetailsGoBackButton,10);
        agencyDetailsGoBackButton.click();
    }

    public void validateAgencyDetailsPageTitle(){
        basicActions.waitForElementToBePresent(agencyDetailsTitle,10);
        softAssert.assertEquals(agencyDetailsTitle.getText(),"Agency Details");
        softAssert.assertAll();
    }

    public void validateFieldLabels(){
        basicActions.waitForElementToBePresent(agencyNameLabel,10);
        softAssert.assertEquals(agencyNameLabel.getText(),"Agency Name:");
        softAssert.assertEquals(agencyTinLabel.getText(),"Agency TIN:");
        softAssert.assertEquals(agencyGroupLabel.getText(),"Please select the option that best describes you or your Agency/Team:");
        softAssert.assertEquals(agencyAddress.getText(),"Agency Address");
        softAssert.assertEquals(addressLine1Label.getText(),"Address Line1:");
        softAssert.assertEquals(addressLine2Label.getText(),"Address Line2:");
        softAssert.assertEquals(cityLabel.getText(),"City:");
        softAssert.assertEquals(stateLabel.getText(),"State:");
        softAssert.assertEquals(zipCodeLabel.getText(),"Zip Code:");
        softAssert.assertEquals(countyLabel.getText(),"County:");
        softAssert.assertEquals(hideAddressLabel.getText(),"Hide This Address:");
        softAssert.assertEquals(workingHoursLabel.getText(),"Working Hours:");
        softAssert.assertEquals(workingDaysLabel.getText(),"Working Days:");
        softAssert.assertEquals(languagesLabel.getText(),"Languages:");
        softAssert.assertEquals(emailLabel.getText(),"Email:");
        softAssert.assertEquals(phoneNumberLabel.getText(),"Phone Number:");
        softAssert.assertAll();
    }

    public void validateMandatoryFieldErrorMessages(){
        basicActions.waitForElementToBePresent(agencyNameLabel,10);
        agencyDetailsContinueButton.click();

        softAssert.assertEquals(agencyNameErrorMessage.getText(),"Please enter Agency Name");
        softAssert.assertEquals(agencyTinErrorMessage.getText(),"Please enter Agency TIN");
        softAssert.assertEquals(agencyGroupErrorMessage.getText(),"Agency Group is required");
        softAssert.assertEquals(addressLine1ErrorMessage.getText(),"Please enter Address Line1");
        softAssert.assertEquals(cityErrorMessage.getText(),"Please enter City");
        softAssert.assertEquals(stateErrorMessage.getText(),"Please enter State");
        softAssert.assertEquals(zipCodeErrorMessage.getText(),"Please enter Zip Code");
        softAssert.assertEquals(countyErrorMessage.getText(),"Please enter County");
        softAssert.assertEquals(workingHoursErrorMessage.getText(),"Please enter your working hours");
        softAssert.assertEquals(workingDaysErrorMessage.getText(),"Please enter Working Days");
        softAssert.assertEquals(languagesErrorMessage.getText(),"Please enter language");
        softAssert.assertEquals(emailErrorMessage.getText(),"Please enter Email");
        softAssert.assertEquals(phoneNumberErrorMessage.getText(),"Please enter Phone Number");
        softAssert.assertAll();
    }

    public void validateAgencyNameMaxCharacters(){
        basicActions.waitForElementToBePresent(agencyName, 10);
        agencyName.clear();
        agencyName.sendKeys("43875643875683465873463c fuefgue fgvuergfnuvrhfvrfh fghv uhfvufv");

        softAssert.assertEquals(agencyName.getAttribute("value"), "43875643875683465873463c fuefgue fgvuergfnuvrhfvrfh fghv uhf");
        softAssert.assertAll();
    }

    public void validateLettersNotAllowsAgencyTin(){
        basicActions.waitForElementToBePresent(agencyTin, 10);
        agencyTin.clear();
        agencyTin.sendKeys("ABCDefghij");

        softAssert.assertEquals(agencyTin.getAttribute("value"), "");
        softAssert.assertAll();
    }

    public void validateAgencyTinMax(){
        basicActions.waitForElementToBePresent(agencyTin, 10);
        agencyTin.clear();
        agencyTin.sendKeys("6673376431");

        softAssert.assertEquals(agencyTin.getAttribute("value"), "66-7337643");
        softAssert.assertAll();
    }

    public void validateFieldSpecialCharacters(){
        agencyName.sendKeys("#$%!@&*()");
        addressLine1.sendKeys("#$%!@&*()");
        addressLine2.sendKeys("#$%!@&*()");
        cityField.sendKeys("#$%!@&*()");
        zipCodeField.sendKeys("#$%!@&*()");

        softAssert.assertEquals(agencyName.getAttribute("value"), "");
        softAssert.assertEquals(addressLine1.getAttribute("value"), "");
        softAssert.assertEquals(addressLine2.getAttribute("value"), "");
        softAssert.assertEquals(cityField.getAttribute("value"), "");
        softAssert.assertEquals(zipCodeField.getAttribute("value"), "");
        softAssert.assertAll();
    }

    public void validateAddressFieldsMaxCharacter(){
        addressLine1.sendKeys("438756438----7568ceygfueg3465873463c fuefgue fgvuergf nuvrhfvrfh fghv dhgfhgfh g fgfuguwe dfhdfhdfhjfdffiwf iwfi wiufhiueeuhweifh");
        addressLine2.sendKeys("438756438----7568ceygfueg3465873463c fuefgue fgvuergf nuvrhfvrfh fghv dhgfhgfh g fgfuguwe dfhdfhdfhjfdffiwf iwfi wiufhiueeuhweifh");

        softAssert.assertEquals(addressLine1.getAttribute("value"), "438756438----7568ceygfueg3465873463c fuefgue fgvuergf nuvrhfvrfh fghv dhgfhgfh g fgfuguwe dfhdfhdfhjfdffiwf iwfi wiufhiueeuhweif");
        softAssert.assertEquals(addressLine2.getAttribute("value"), "438756438----7568ceygfueg3465873463c fuefgue fgvuergf nuvrhfvrfh fghv dhgfhgfh g fgfuguwe dfhdfhdfhjfdffiwf iwfi wiufhiueeuhweif");
        softAssert.assertAll();
    }

    public void validateCityMaxCharacters(){
        basicActions.waitForElementToBePresent(cityField, 10);
        cityField.clear();
        cityField.sendKeys("Colorado Springs dgfd sdgfudsyfgusdfgduf guyfsdfdqh");

        softAssert.assertEquals(cityField.getAttribute("value"), "Colorado Springs dgfd sdgfudsyfgusdfgduf guyfsdfdq");
        softAssert.assertAll();
    }

    public void validateZipCodeMax(){
        basicActions.waitForElementToBePresent(zipCodeField, 10);
        zipCodeField.clear();
        zipCodeField.sendKeys("80134x600");

        softAssert.assertEquals(zipCodeField.getAttribute("value"), "80134");
        softAssert.assertAll();
    }

    public void validateEmailInvalidAddress(){
        basicActions.waitForElementToBePresent(emailField, 10);
        emailField.clear();
        emailField.sendKeys("abc@a---xctt3.");

        softAssert.assertEquals(emailErrorMessage.getText(),"Please enter Email");
        softAssert.assertAll();
    }

    public void validateEmailMaxCharacters(){
        basicActions.waitForElementToBePresent(emailField, 10);
        emailField.clear();
        emailField.sendKeys("abc@a---xctt3434344735472654762354735472357347234572634.net11");

        softAssert.assertEquals(emailField.getAttribute("value"), "abc@a---xctt3434344735472654762354735472357347234572634.net1");
        softAssert.assertAll();
    }

    public void validatePhoneNumberFormat(){
        basicActions.waitForElementToBePresent(phoneNumberField, 10);
        phoneNumberField.clear();
        phoneNumberField.sendKeys("1234567890123456");

        softAssert.assertEquals(phoneNumberField.getAttribute("value"), "123-456-7890 ext.12345");
        softAssert.assertAll();
    }

    public void validatePhoneFieldLettersNotAllowed(){
        basicActions.waitForElementToBePresent(phoneNumberField, 10);
        phoneNumberField.clear();
        phoneNumberField.sendKeys("ABCDefghij");

        softAssert.assertEquals(phoneNumberField.getAttribute("value"), "");
        softAssert.assertAll();
    }

    public void validateAgencyGroupTooltipText(){
        basicActions.waitForElementToBePresent(agencyGroupTooltip, 10);
        builder.moveToElement(agencyGroupTooltip).perform();

        softAssert.assertEquals(agencyGroupTooltipText.getText(), "Choose \u2018Broker\u2019 if you work independently and are potentially eligible for commissions. Choose \u2018Issuer Direct Sales Team\u2019 if you work for the Issuer, and you are NOT eligible for commission.");
        softAssert.assertAll();
    }

    public void verifyAgencyGroupDisabled(){
        basicActions.waitForElementToBePresent(disabledAgencyGroup, 10);
        softAssert.assertEquals(disabledAgencyGroup.getAttribute("class"), "dropdown-disable");
        softAssert.assertAll();
    }

    public void clickCancelAgencyDetails(){
        basicActions.waitForElementToBePresent(cancelAgencyDetails, 10);
        cancelAgencyDetails.click();
    }

    public void clickHideAddressCheckbox(){
        basicActions.waitForElementToBePresent(hideAddressCheckbox, 10);
        hideAddressCheckbox.click();
    }

    public void clickAgencyDetailsSaveSubmit(){
        basicActions.waitForElementToBePresent(saveSubmitAgencyDetails, 10);
        saveSubmitAgencyDetails.click();
    }

    public void validateAgencyHideAddressTooltipText(){
        basicActions.waitForElementToBePresent(agencyHideAddressTooltip, 10);
        builder.moveToElement(agencyHideAddressTooltip).perform();

        softAssert.assertEquals(agencyHideAddressTooltipText.getText(), "By default address lines 1 and 2 display in the search results on the \u2018Find a Certified Broker near you\u2019 page. If you do not want your address displayed to the public, please check the box here and only city, state and zip code will display for your location.");
        softAssert.assertAll();
    }

    public void validateFromToWorkingHoursError(){
        basicActions.waitForElementToBePresent(workingHoursLabel, 10);
        workingHoursTo.sendKeys("0500PM");

        basicActions.waitForElementToBePresentWithRetries(workingHoursFromToErrorMessage, 10);
        softAssert.assertEquals(workingHoursFromToErrorMessage.getText(), "Please enter both the To and From working hours");
        softAssert.assertAll();
    }

    public String generateAgencyTin(){
        Random rand = new Random();
        int num = 100000000 + rand.nextInt(900000000);
        return Integer.toString(num);
    }

    public void updateAgencyTin(){
        basicActions.waitForElementToBePresent(agencyTin, 10);
        String newAgencyTin = generateAgencyTin();

        BrokerDetails owner = new BrokerDetails();
        owner.setAgencyTin(newAgencyTin);
        SharedData.setAgencyOwner(owner);
        System.out.println("The agency TIN is " +SharedData.getAgencyOwner().getAgencyTin());
        agencyTin.clear();
        agencyTin.sendKeys(newAgencyTin);
    }

    public String generateAgencyAddress(){
        Random rand = new Random();
        int num = rand.nextInt(1000);
        return Integer.toString(num);
    }

    public void updateAgencyAddress(){
        basicActions.waitForElementToBePresent(addressLine1, 10);

        BrokerDetails owner = SharedData.getAgencyOwner();
        Address agencyAddress = new Address();
        agencyAddress.setAddressLine1(generateAgencyAddress() + " Deer Trail Dr");
        owner.setAgencyAddress(agencyAddress);
        SharedData.setAgencyOwner(owner);

        System.out.println("The new agency address is " + SharedData.getAgencyOwner().getAgencyAddress().getAddressLine1());
        addressLine1.clear();
        addressLine1.sendKeys(SharedData.getAgencyOwner().getAgencyAddress().getAddressLine1());
    }

    public void initializeAgencyDetails(){
        SharedData.getAgencyOwner().setAgencyName((basicActions.capitalizeFirstLetter(basicActions.getUniqueString(8))));
        SharedData.getAgencyOwner().setAgencyTin(generateAgencyTin());
        Address agencyAddress = new Address();
        agencyAddress.setAddressLine1(generateAgencyAddress() + " Deer Trail Dr");
        agencyAddress.setAddressCity("Denver");
        agencyAddress.setAddressZipcode("80205");
        SharedData.getAgencyOwner().setAgencyAddress(agencyAddress);
        SharedData.getAgencyOwner().setAgencyPhoneNumber((String) basicActions.generatePhoneNumber());
        SharedData.getAgencyOwner().setAgencyEmail(SharedData.getAgencyOwner().getEmail());
    }
    public void enterAgencyDetails(){
        basicActions.waitForElementToBePresent(agencyName, 10);
        initializeAgencyDetails();

        agencyName.sendKeys(SharedData.getAgencyOwner().getAgencyName());
        agencyTin.sendKeys(SharedData.getAgencyOwner().getAgencyTin());
        basicActions.waitForElementToBePresent(agencyGroupDropdown, 10);
        agencyGroupDropdown.click();
        Select groupDropdown = new Select(agencyGroupDropdown);
        groupDropdown.selectByVisibleText("Broker");

        addressLine1.sendKeys(SharedData.getAgencyOwner().getAgencyAddress().getAddressLine1());
        cityField.sendKeys(SharedData.getAgencyOwner().getAgencyAddress().getAddressCity());
        stateDropdown.click();
        Select stateOptions = new Select(stateDropdown);
        stateOptions.selectByVisibleText("Colorado");
        stateDropdown.click();

        zipCodeField.sendKeys(SharedData.getAgencyOwner().getAgencyAddress().getAddressZipcode());
        countyDropdown.click();
        countyDropdown.sendKeys(Keys.DOWN);
        countyDropdown.sendKeys(Keys.ENTER);

        workingHoursFrom.sendKeys("0800AM");
        workingHoursTo.sendKeys("0500PM");
        workingDaysDropdown.click();
        workingDaysDropdownOption.click();
        zipCodeField.click();

        languagesDropdown.click();
        languagesOption.click();
        zipCodeField.click();

        emailField.sendKeys(SharedData.getAgencyOwner().getAgencyEmail());
        phoneNumberField.sendKeys(SharedData.getAgencyOwner().getAgencyPhoneNumber());
    }

    public void validateSaveAndFinishLaterButton(){
        softAssert.assertFalse(basicActions.waitForElementPresence(agencyDetailsSaveFinishLaterButton,30));
        softAssert.assertAll();
    }
}
