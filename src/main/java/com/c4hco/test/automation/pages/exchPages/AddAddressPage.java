package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAddressPage {
    private BasicActions basicActions;
    public AddAddressPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id = "retrieveResidentialAddress")
    WebElement rdobtnHouseholdResidentialAddress;

    @FindBy(id = "typeResidentialAddress")
    WebElement rdobtnDifferentResidentialAddress;

    @FindBy(id = "newResidentialAddress.addressLine1")
    WebElement txtNewAddressLine1;

    @FindBy(id = "newResidentialAddress.addressLine2")
    WebElement txtNewAddressLine2;

    @FindBy(id = "newResidentialAddress.city")
    WebElement txtNewAddressCity;

    @FindBy(id = "residentialAddrState")
    WebElement selectNewAddressState;

    @FindBy(id = "residentialAddrZip")
    WebElement txtNewAddressZip;

    @FindBy(id = "residentialAddrCounty")
    WebElement selectNewAddressCounty;

    @FindBy(id = "mailingAddrLine1")
    WebElement txtMailingAddrLine1;

    @FindBy(id = "mailingAddrLine2")
    WebElement txtMailingAddrLine2;

    @FindBy(id = "mailingAddrCity")
    WebElement txtMailingCity;

    @FindBy(id = "mailingAddrState")
    WebElement selectMailingState;

    @FindBy(id="mailingAddrCounty")
    WebElement selectMailingCounty;

    @FindBy(id = "mailingAddrZip")
    WebElement txtMailingZip;

    @FindBy(id = "coResidentYes")
    WebElement rdobtnIsColoradoResidentYes;
    @FindBy(id = "coResidentNo")
    WebElement rdobtnIsColoradoResidentNo;

    @FindBy(id = "tribeYes")
    WebElement rdobtnPartOfTribeYes;
    @FindBy(id = "tribeNo")
    WebElement rdobtnPartOfTribeNo;

    @FindBy(id = "hardshipExemptionYes")
    WebElement rdobtnHardshipExemptionYes;
    @FindBy(id = "hardshipExemptionNo")
    WebElement rdobtnHardshipExemptionNo;

    @FindBy(id = "areYouDisabilityYes")
    WebElement rdobtnDisabilityYes;
    @FindBy(id = "areYouDisabilityNo")
    WebElement rdobtnDisabilityNo;

    @FindBy(id = "medicaidOrChpDeniedYes")
    WebElement rdobtnMedicaidDeniedYes;
    @FindBy(id = "medicaidOrChpDeniedNo")
    WebElement rdobtnMedicaidDeniedNo;

    @FindBy(id = "areYouIncarceratedYes")
    WebElement rdobtnIncraceratedYes;
    @FindBy(id="areYouIncarceratedNo")
    WebElement rdobtnIncarceratedNo;
    @FindBy(name = "saveAndContinue")
    WebElement btnSaveContinue;

    public void selectHouseholdAddress(){
        rdobtnHouseholdResidentialAddress.click();
    }

    public void selectResidentialAddress(String Index){
        switch(Index){
            case "Household":
                rdobtnHouseholdResidentialAddress.click();
                break;
            case "New":
                rdobtnDifferentResidentialAddress.click();
                break;
        }

    }

    public void residentialAddress(){
        txtNewAddressLine1.sendKeys("1234 New Road");
        txtNewAddressLine2.sendKeys("Apt 1234567890");
        txtNewAddressCity.sendKeys("Denver");
        selectNewAddressState.sendKeys("CO");
        txtNewAddressZip.sendKeys("80205");

        selectNewAddressCounty.click();
        Select dropdown = new Select(selectNewAddressCounty);
        dropdown.selectByValue("DENVER");
    }

    public void mailingAddress(){
        txtMailingAddrLine1.sendKeys("1234 Road");
        txtMailingAddrLine2.sendKeys("Unit ABCD1234");
        txtMailingCity.sendKeys("Denver");
        selectMailingState.sendKeys("CO");
        txtMailingZip.sendKeys("80205");

        selectMailingCounty.click();
        Select dropdown = new Select(selectMailingCounty);
        dropdown.selectByValue("DENVER");
    }

    public void isColoradoResident(String YNCOResident){
        switch (YNCOResident){
            case "Yes":
                rdobtnIsColoradoResidentYes.click();
                break;
            case "No":
                rdobtnIsColoradoResidentNo.click();
                break;
        }
    }

    public void isFederallyRecognizedTribe(String YNTribe){
        switch(YNTribe){
            case "Yes":
                rdobtnPartOfTribeYes.click();
                break;
            case "No":
                rdobtnPartOfTribeNo.click();
                break;
        }
    }

    public void isMemberHardshipExempt(String YNExempt){
        switch(YNExempt){
            case "Yes":
                rdobtnHardshipExemptionYes.click();
                break;
            case "No":
                rdobtnHardshipExemptionNo.click();
                break;
        }
    }

    public void isMemberDisabled(String YNDisabled){
        switch(YNDisabled){
            case "Yes":
                rdobtnDisabilityYes.click();
                break;
            case "No":
                rdobtnDisabilityNo.click();
                break;
        }
    }

    public void hasUserBeenDeniedMedicaid(String YNDenied){
        switch(YNDenied){
            case "Yes":
                rdobtnMedicaidDeniedYes.click();
                break;
            case "No":
                rdobtnMedicaidDeniedNo.click();
                break;
        }
    }

    public void isUserIncarcerated(String YNIncarcerated){
        switch(YNIncarcerated){
            case "Yes":
                rdobtnIncraceratedYes.click();
                break;
            case "No":
                rdobtnIncarceratedNo.click();
                break;
        }
    }

    public void saveContinue(){btnSaveContinue.click();}
}

