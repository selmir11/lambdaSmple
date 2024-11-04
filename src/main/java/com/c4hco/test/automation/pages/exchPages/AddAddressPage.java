package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.Address;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;
import java.util.Map;
import java.util.Optional;


public class AddAddressPage {
    private BasicActions basicActions;
    public AddAddressPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(css = ".container > div:nth-child(1)")
    WebElement headerAdditionalInfo;

    @FindBy(css = ".addressradioGrp #retrieveResidentialAddress")
    List<WebElement> rdobtnHouseholdResidentialAddress;

    @FindBy(id = "typeResidentialAddress")
    WebElement rdobtnDifferentResidentialAddress;

    @FindBy(css = ".input-group #mailingAddrLine1")
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
    @FindBy(id = "newResidentialAddress.addressLine1")
    WebElement newResidentialAddressline1;
    @FindBy(id = "newResidentialAddress.city")
    WebElement newResidentialAdressCity;
    @FindBy(id = "residentialAddrState")
    WebElement newResidentialAddressState;
    @FindBy(id = "residentialAddrZip")
    WebElement newResidentialAddressZip;
    @FindBy(id = "residentialAddrCounty")
    WebElement newResidentialAddressCounty;
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

    @FindBy(id = "fullTimeStudentNoYes")
    WebElement rdobtnStudentYes;
    @FindBy(id = "fullTimeStudentNo")
    WebElement rdobtnStudentNo;


    @FindBy(id = "livedinFosterCareYes")
    WebElement rdobtnFosterCareYes;
    @FindBy(id="livedinFosterCareNo")
    WebElement rdobtnFosterCareNo;

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

    @FindBy(css = ".c4PageHeader1")
    WebElement getNameFromHeader;

    @FindBy(id = "tribeState")
    WebElement tribestate;
    @FindBy(id = "tribeName")
    WebElement tribeName;


    public void selectResidentialAddress(String index){
        basicActions.waitForElementListToBePresent(rdobtnHouseholdResidentialAddress, 10);
        switch(index){
            case "Household":
                // selects same residential address as primary person
                rdobtnHouseholdResidentialAddress.get(0).click();
                break;
            case "New":
                rdobtnDifferentResidentialAddress.click();
                break;
            case "recent option":
                WebElement recentAddressSelection = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),'"+SharedData.getMembers().get(SharedData.getMembers().size()-2).getResAddress().getAddressZipcode()+"')]/ancestor::div[@class='form-check'] //input[@id='retrieveResidentialAddress']"));
                recentAddressSelection.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + index);
        }

    }

    private String getMemberName(){
        String getHeader = getNameFromHeader.getText();
        String[] memNameSubstring = getHeader.split(" ");
        String memFName = memNameSubstring[memNameSubstring.length-1];
        return memFName;
    }

    // WIP - should be removed.
    public void mailingAddress(){
        // Should not use this method anymore- should use genericMailingAddress method
        basicActions.waitForElementToBePresent(headerAdditionalInfo,50);
        basicActions.waitForElementToBePresent(txtMailingAddrLine1, 50);
        basicActions.waitForElementToBePresent(txtMailingAddrLine2, 50);
        basicActions.waitForElementToBePresent(txtMailingCity, 50);
        txtMailingAddrLine1.sendKeys("1234 Road");
        txtMailingAddrLine2.sendKeys("Unit ABCD1234");
        txtMailingCity.sendKeys("Denver");
        selectMailingState.sendKeys("CO");
        txtMailingZip.sendKeys("80205");

        basicActions.waitForElementToBeClickable(selectMailingCounty, 10);
        selectMailingCounty.click();
        Select dropdown = new Select(selectMailingCounty);
        dropdown.selectByValue("DENVER");
    }

    public void Addtribedetails(){
        basicActions.waitForElementToBePresent(tribestate,20);
        basicActions.waitForElementToBePresent(tribeName, 20);
        tribestate.sendKeys("Colorado");
        tribeName.sendKeys("Southern Ute Indian Tribe of the Southern Ute Reservation");

    }

    public void newMailingAddress(String city, String state, String zipcode, String county){
        basicActions.waitForElementToBePresent(newResidentialAddressline1, 10);
        newResidentialAddressline1.sendKeys("1234 Road");
        newResidentialAdressCity.sendKeys(city);
        newResidentialAddressState.sendKeys(state);
        newResidentialAddressZip.sendKeys(zipcode);

        newResidentialAddressCounty.click();
        Select dropdown = new Select(newResidentialAddressCounty);
        dropdown.selectByValue(county);
    }

    public void newResidentialAddress(String city, String state, String zipcode, String county){
        basicActions.waitForElementToBePresent(newResidentialAddressline1, 10);
        newResidentialAddressline1.sendKeys("1234 Road");
        newResidentialAdressCity.sendKeys(city);
        newResidentialAddressState.sendKeys(state);
        newResidentialAddressZip.sendKeys(zipcode);

        newResidentialAddressCounty.click();
        Select dropdown = new Select(newResidentialAddressCounty);
        dropdown.selectByValue(county);
    }

    public void specificMailingAddress(String AddrLine1, String city, String state, String zipcode, String county){
        // Mailing Address - Only for primary member
        basicActions.waitForElementToBePresent(headerAdditionalInfo,1);
        basicActions.waitForElementToBePresent(txtMailingAddrLine1, 40);
        txtMailingAddrLine1.sendKeys(AddrLine1);
        txtMailingCity.sendKeys(city);
        selectMailingState.sendKeys(state);
        txtMailingZip.sendKeys(zipcode);

        basicActions.waitForElementToBeClickable(selectMailingCounty, 10);
        selectMailingCounty.click();
        Select dropdown = new Select(selectMailingCounty);
        dropdown.selectByValue(county);

        Address mailinglAddress = new Address();
        mailinglAddress.setAddressLine1(AddrLine1);
        mailinglAddress.setAddressCity(city);
        mailinglAddress.setAddressState(state);
        mailinglAddress.setAddressZipcode(zipcode);
        mailinglAddress.setAddressCounty(county);

        SharedData.getPrimaryMember().setMailingAddress(mailinglAddress);
    }

    public void addNewResidentialAddress(List<Map<String, String>> addDetails){
        basicActions.waitForElementToBePresent(newResidentialAddressline1, 10);
        String addressLine1 = addDetails.get(0).get("addressLine1");
        String city = addDetails.get(0).get("city");
        String state = addDetails.get(0).get("state");
        String zipcode = addDetails.get(0).get("zipcode");
        String county = addDetails.get(0).get("county");
        String dob =addDetails.get(0).get("dob");

        newResidentialAddressline1.sendKeys(addressLine1);
        newResidentialAdressCity.sendKeys(city);
        newResidentialAddressState.sendKeys(state);
        newResidentialAddressZip.sendKeys(zipcode);
        newResidentialAddressCounty.click();
        Select dropdown = new Select(newResidentialAddressCounty);
        dropdown.selectByValue(county);
        setNewResidentialAddress(addressLine1,city,state,zipcode,county,dob);
    }

    public void setNewResidentialAddress(String addressLine1, String city, String state, String zipcode, String county, String dob){
        String getHeader = getNameFromHeader.getText();
        String name = getMemberName();

        List<MemberDetails> membersList = SharedData.getMembers();
        MemberDetails subscriber = SharedData.getPrimaryMember();

        if (getHeader.contains("Yourself")) {
            //set data for subscriber
        }else{
           // filter by dob as it is unique
            Optional<MemberDetails> requiredMem =  membersList.stream().filter(mem -> mem.getDob().equals(dob) &&
                    mem.getSignature().contains(name)
            ).findFirst();


            if(requiredMem.isPresent()){
                MemberDetails member =  (MemberDetails) requiredMem.get();
                // To DO::Set other fields of residential address here - Need to add them to PolicyMem - addLine1, Line2 etc
                Address residentialAddress = new Address();
                residentialAddress.setAddressLine1(addressLine1);
                residentialAddress.setAddressCity(city);
                residentialAddress.setAddressState(state);
                residentialAddress.setAddressZipcode(zipcode);
                residentialAddress.setAddressCounty(county);
                member.setResAddress(residentialAddress);
            }
            else{
                Assert.fail("Member with this dob and name is not found!!");
            }
        }
    }

    public void isColoradoResident(String YNCOResident){
        switch (YNCOResident){
            case "Yes":
                basicActions.scrollToElement(rdobtnIsColoradoResidentYes);
                rdobtnIsColoradoResidentYes.click();
                break;
            case "No":
                rdobtnIsColoradoResidentNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNCOResident);
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
            default:
                throw new IllegalArgumentException("Invalid option: " + YNTribe);
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
            default:
                throw new IllegalArgumentException("Invalid option: " + YNExempt);
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
            default:
                throw new IllegalArgumentException("Invalid option: " + YNDisabled);
        }
    }

    public void isMemberStudent(String YNStudent){
        switch(YNStudent){
            case "Yes":
                rdobtnStudentYes.click();
                break;
            case "No":
                rdobtnStudentNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNStudent);
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
            default:
                throw new IllegalArgumentException("Invalid option: " + YNDenied);
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
            default:
                throw new IllegalArgumentException("Invalid option: " + YNIncarcerated);
        }
    }

    public void isUserInFosterCare(String YNFosterCare){
        switch(YNFosterCare){
            case "Yes":
                rdobtnFosterCareYes.click();
                break;
            case "No":
                rdobtnFosterCareNo.click();
                break;
        }
    }

    public void saveContinue(){btnSaveContinue.click();}

}



