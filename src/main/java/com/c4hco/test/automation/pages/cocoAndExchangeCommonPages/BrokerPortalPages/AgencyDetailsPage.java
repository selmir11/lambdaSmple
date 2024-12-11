package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.Dto.Address;
import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.Random;

public class AgencyDetailsPage {
    SoftAssert softAssert = new SoftAssert();
    @FindBy(xpath = "//*[@id='elem']/app-agency-details/div/div")
    WebElement agencyDetailsTitle;

    @FindBy(id = "l_agencyName")
    WebElement agencyNameLabel;

    @FindBy(id = "agencyName")
    WebElement agencyName;

    @FindBy(xpath = "//div[contains(text(),'Please enter Agency Name')]")
    WebElement agencyNameErrorMessage;

    @FindBy(id = "l_agencyTin")
    WebElement agencyTinLabel;

    @FindBy(id = "agencyTin")
    WebElement agencyTin;

    @FindBy(xpath = "//div[contains(text(),'Please enter Agency TIN')]")
    WebElement agencyTinErrorMessage;

    @FindBy(id = "l_agencyGroup")
    WebElement agencyGroupLabel;

    @FindBy(id = "error_message_required")
    WebElement agencyGroupErrorMessage;

    @FindBy(id = "l_mailingHeader")
    WebElement agencyAddress;

    @FindBy(id = "l_primaryAddressLine1")
    WebElement addressLine1Label;

    @FindBy(id = "primaryAddressLine1")
    WebElement addressLine1;

    @FindBy(xpath = "//div[contains(text(),'Please enter Address Line1')]")
    WebElement addressLine1ErrorMessage;

    @FindBy(id = "l_primaryAddressLine2")
    WebElement addressLine2Label;

    @FindBy(id = "primaryAddressLine2")
    WebElement addressLine2;

    @FindBy(id = "l_primaryCity")
    WebElement cityLabel;

    @FindBy(id = "primaryCity")
    WebElement cityField;

    @FindBy(xpath = "//div[contains(text(),'Please enter City')]")
    WebElement cityErrorMessage;

    @FindBy(id = "l_primaryState")
    WebElement stateLabel;

    @FindBy(xpath = "//div[normalize-space()='Please enter State']")
    WebElement stateErrorMessage;

    @FindBy(id = "l_primaryZip")
    WebElement zipCodeLabel;

    @FindBy(id = "primaryZip")
    WebElement zipCodeField;

    @FindBy(xpath = "//div[contains(text(),'Please enter Zip Code')]")
    WebElement zipCodeErrorMessage;

    @FindBy(id = "l_primaryCounty")
    WebElement countyLabel;

    @FindBy(xpath = "//div[contains(text(),'Please enter County')]")
    WebElement countyErrorMessage;

    @FindBy(id = "l_hideAddress")
    WebElement hideAddressLabel;

    @FindBy(id = "hideAddress-input")
    WebElement hideAddressCheckbox;

    @FindBy(id = "l_workingHours")
    WebElement workingHoursLabel;

    @FindBy(xpath = "//div[normalize-space()='Please enter your working hours']")
    WebElement workingHoursErrorMessage;

    @FindBy(id = "l_workingDays")
    WebElement workingDaysLabel;

    @FindBy(xpath = "//div[contains(text(),'Please enter Working Days')]")
    WebElement workingDaysErrorMessage;

    @FindBy(id = "l_areaOfExpertise")
    WebElement areaOfExpertiseLabel;

    @FindBy(xpath = "//div[contains(text(),'Please enter area of expertise')]")
    WebElement areaOfExpertiseErrorMessage;

    @FindBy(id = "l_languages")
    WebElement languagesLabel;

    @FindBy(xpath = "//div[contains(text(),'Please enter language')]")
    WebElement languagesErrorMessage;

    @FindBy(id = "l_email")
    WebElement emailLabel;

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(xpath = "//div[contains(text(),'Please enter Email')]")
    WebElement emailErrorMessage;

    @FindBy(id = "l_phoneNumber")
    WebElement phoneNumberLabel;

    @FindBy(id = "phoneNumber")
    WebElement phoneNumberField;

    @FindBy(xpath = "//div[contains(text(),'Please enter Phone Number')]")
    WebElement phoneNumberErrorMessage;

    @FindBy(id = "BP-AgencyDetails-GoBack")
    WebElement agencyDetailsGoBackButton;

    @FindBy(id = "continue-button")
    WebElement agencyDetailsContinueButton;

    @FindBy(xpath = "//label[@id='l_agencyGroup']//em[@class='fas fa-question-circle']")
    WebElement agencyGroupTooltip;

    @FindBy(id = "agencygroup_helptext")
    WebElement agencyGroupTooltipText;

    @FindBy(xpath = "//div[contains(@class, 'dropdown-disable')]")
    WebElement disabledAgencyGroup;

    @FindBy(id= "cancel-button")
    WebElement cancelAgencyDetails;

    @FindBy(id= "BP-AgencyDetails-SaveandSubmit")
    WebElement saveSubmitAgencyDetails;

    @FindBy(xpath = "//label[@id='l_hideAddress']//em[@class='fas fa-question-circle']")
    WebElement agencyHideAddressTooltip;

    @FindBy(id = "hideAddress_helptext")
    WebElement agencyHideAddressTooltipText;

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
        softAssert.assertEquals(areaOfExpertiseLabel.getText(),"Area of Expertise:");
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
        softAssert.assertEquals(areaOfExpertiseErrorMessage.getText(),"Please enter area of expertise");
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
        zipCodeField.sendKeys("8013x4x600");

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

        softAssert.assertEquals(phoneNumberField.getAttribute("value"), "123-456-7890 ext.");
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
        softAssert.assertEquals(disabledAgencyGroup.getAttribute("class"), "d-inline-flex w-100 dropdown-disable");
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

}
