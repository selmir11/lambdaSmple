package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddAddressPage {
    private BasicActions basicActions;
    public AddAddressPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    // update locators to have ids

@FindBy(xpath = "//*[@id='mailingAddrLine1']")
    WebElement AddrLine1;

    @FindBy(xpath = "//*[@id='mailingAddrCity']")
    WebElement city;

    @FindBy(xpath = "//*[@id='mailingAddrState']")
    WebElement state;

    @FindBy(xpath = "//*[@id='mailingAddrCounty']")
    WebElement county;

    @FindBy(xpath = "//*[@id='mailingAddrZip']")
    WebElement zip;

    @FindBy(xpath = "//*[@id='coResidentYes']")
    WebElement coloradoResidentYes;
    @FindBy(xpath = "//*[@id='tribeNo']")
    WebElement tribeNo;
    @FindBy(xpath = "//*[@id='hardshipExemptionNo']")
    WebElement hardshipExemptionNo;
    @FindBy(xpath = "//*[@id='areYouDisabilityNo']")
    WebElement disabilityNo;
    @FindBy(xpath = "//*[@id='medicaidOrChpDeniedNo']")
    WebElement medicaidDenied;
    @FindBy(xpath = "//*[@id='areYouIncarceratedNo']")
    WebElement notIncarcerated;
    @FindBy(xpath = "//*[@value='Save and Continue']")
    WebElement saveContinue;

    private String mailingLine1= "1234 Road";
    private String mailingCity ="Denver";
    private String mailingState = "CO";
    private String mailingZip = "80205";
    private String mailingCounty = "DENVER";


    public void mailingAddress()  {
        AddrLine1.sendKeys(mailingLine1);
        city.sendKeys(mailingCity);
        state.sendKeys(mailingState);
        zip.sendKeys(mailingZip);
    }
    public void selectCounty(){
        county.click();
        Select dropdown = new Select(county);
        dropdown.selectByValue(mailingCounty);
    }
    public void coloradoResidentYes(){
        coloradoResidentYes.click();
    }

    public void tribeNo(){
        tribeNo.click();
    }
    public void hardshipExempNo(){
        hardshipExemptionNo.click();
    }
    public void noDisability(){
        disabilityNo.click();
    }
    public void deniedMedicaid(){
        medicaidDenied.click();
    }
    public void notIncarcerated(){
        notIncarcerated.click();
    }
    public void saveContinue(){
        saveContinue.click();
    }



}
