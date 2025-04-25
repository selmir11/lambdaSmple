package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class QlceConfirmationPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public QlceConfirmationPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    //Birth
    @FindBy(id = "birth")
    WebElement birthQLCE;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    List<WebElement> allmembersBirthcheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    List<WebElement> birthEventDate;

    // Pregnancy

    @FindBy(xpath = "//*[@id = 'pregnancyStatus']")
    WebElement pregnancyQLCE;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'pregnancyChkbxWrapper')]")
    List<WebElement> allmembersPregnancycheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'lceMembersForPregnancyStatus0.lceEventDate')]")
    List<WebElement> pregnancyEventDate;

    @FindBy(xpath = "//*[@id = 'pregnancyStatusRetainCoverage']")
    WebElement retainPregnancyCoverageLce;

    @FindBy(xpath = "//input[@id = 'pregnancyStatusRetainCoverageYes']")
    WebElement yesRetainPrgnancyCoverage;

    @FindBy(xpath = "//input[@id = 'pregnancyStatusRetainCoverageYes']")
    WebElement pregnancyStatusRetainCoverageYes;

    @FindBy(xpath = "//input[@id = 'pregnancyStatusRetainCoverageNo']")
    WebElement pregnancyStatusRetainCoverageNo;

    @FindBy(xpath = "//input[@id = 'pregnancyStatusRetainCoverageNone']")
    WebElement pregnancyStatusRetainCoverageNone;

    //Marriage
    @FindBy(id = "marriage")
    WebElement marriageLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'Marriage')]")
    List<WebElement> allmemberMarriagecheckbox;

    @FindBy(xpath = "//input[@type='date'and contains(@id,'Marriage')]")
    List<WebElement> marriageEventDate;

    //Divorce
    @FindBy(id = "divorce")
    WebElement divorceLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'Divorce')]")
    List<WebElement> allmemberDivorcecheckbox;

    @FindBy(xpath = "//input[@type='date'and contains(@id,'Divorce')]")
    List<WebElement> divorceEventDate;

    // Incarceration
    @FindBy(xpath = "//*[@id = 'changeOnIncarcerationStatus']")
    WebElement changeOnIncarcerationStatusLce;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'lceMembersForIncarcerationStatus0.lceEventStatus1')]")
    List<WebElement> allmemberIncarcerationcheckbox;

    @FindBy(xpath = "//input[@type='date'and contains(@id,'lceMembersForIncarcerationStatus0.lceEventDate')]")
    List<WebElement> incarcerationEventDate;


    //Death
    @FindBy(id = "death")
    WebElement deathLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'Death')]")
    List<WebElement> allmemberDeathcheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'Death')]")
    List<WebElement> deathEventDate;

    //Moved to Colorado
    @FindBy(id = "changeOfAddress")
    WebElement addressChangeLce;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'ChangeOfResidence')]")
    List<WebElement> memberCheckboxChangeOfAddress;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'ChangeOfResidence')]")
    List<WebElement> changeOfAddressEventDate;

    @FindBy(xpath = "//*[@type='checkbox' and contains(@id, 'movedToColorado')]")
    List<WebElement> movedToColoradoCheckbox;

    //Gain Lawful Immigration Status
    @FindBy(id = "gainedLawfulPresence")
    WebElement LawfulPresenceLCE;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'lceMembersForGainedLawfulPresence')]")
    List<WebElement> allmemberLawfulPresencecheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'lceMembersForGainedLawfulPresence')]")
    List<WebElement> LawfulPresenceEventDate;

    //Lost Coverage
    @FindBy(id = "loseOrLostHealthInsurance")
    WebElement lostCoverageLCE;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'lceMembersForLoseOrLostHealthInsurance')]")
    List<WebElement> allMemberLostCoverageCheckbox;
    @FindBy(xpath = "//input[@type='date' and contains(@id,'lceMembersForLoseOrLostHealthInsurance')]")
    List<WebElement> lostCoverageEventDate;

    //Gain Tribal Status
    @FindBy(id = "gainOfAIANStatus")
    WebElement tribalStatusLCE;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id, 'lceMembersForGainOfTribalStatus')]")
    List<WebElement> allMembersGainedTribalStatusCheckbox;
    @FindBy(xpath = "//input[@type='date' and contains(@id,'lceMembersForGainOfTribalStatus')]")
    List<WebElement> tribalStatusEventDate;

    //changeOfIncomeOrJob
    @FindBy(id = "changeOfIncomeOrJob")
    WebElement changeOfIncomeOrJobLCE;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id, 'lceMembersForChangeOfIncomeOrJob0.lceEventStatus1')]")
    List<WebElement> allMemberschangeOfIncomeOrJobCheckbox;
    @FindBy(xpath = "//input[@type='date' and contains(@id,'lceMembersForChangeOfIncomeOrJob0.lceEventDate')]")
    List<WebElement> changeOfIncomeOrJobEventDate;

    // Future or Existing health insurance
    @FindBy(id = "enrollmentUpdate")
    WebElement changeOfHealthCoverageLCE;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id, 'lceMembersForEnrollmentInFutureOrExistingHealthInsurance0.lceEventStatus1')]")
    List<WebElement> allMemberschangeOfHealthCoverageCheckbox;
    @FindBy(xpath = "//input[@type='date' and contains(@id,'lceMembersForEnrollmentInFutureOrExistingHealthInsurance0.lceEventDate')]")
    List<WebElement> changeOfHealthCoverageEventDate;

    //Tax Time Enrollment
    @FindBy(id = "taxTimeEnrollmentPeriod")
    WebElement taxTimeEnrollmentPeriod;

    //None of These
    @FindBy(id = "noneOfThese")
    WebElement noneOfTheseLCE;
    @FindBy(id = "continueButton")
    WebElement saveAndContinue;
    @FindBy(xpath = "//*[@id='submitButton']")
    WebElement btnBack;

    @FindBy(css = "h1.c4PageHeader")
    WebElement textReportLifeChangeHeader;

    @FindBy(css = "h1.c4PageSubTitle")
    WebElement textLifeChangeSubTitle;

    @FindBy(css = "#overviewButton")
    WebElement lnkHelpLink;

    @FindBy(css = ".drawer-heading h4")
    WebElement textHelpDrawerHeader;


    @FindBy(xpath = "//span[contains(@class,'c4BodyText1')]")
    List<WebElement> textLceLable;

    @FindBy(xpath = "//*[@class='pregnancyStatus row form-group']//span[1]")
    List<WebElement> PregancyText;

    @FindBy(xpath = "//*[@class='death row form-group']//span")
    List<WebElement> DeathText;

    @FindBy(xpath = "//*[@class='divorce row form-group']//span")
    List<WebElement> DivorceText;

    @FindBy(xpath = "//*[@class='changeOfAddress row form-group']//span")
    List<WebElement> changeOfAddressText;

    @FindBy(xpath = "//*[@class='changeOfIncomeOrJob row form-group']//span")
    List<WebElement> changeOfIncomeOrJobText;

    @FindBy(xpath = "//*[@class='enrollmentUpdate row form-group']//span")
    List<WebElement> GainofCoverage;

    @FindBy(xpath = "//*[@class='loseOrLostHealthInsurance row form-group']//span")
    List<WebElement> loseOrLostHealthInsuranceText;

    @FindBy(xpath = "//*[@class='gainedLawfulPresence row form-group']//span")
    List<WebElement> gainedLawfulPresenceText;

    @FindBy(xpath = "//*[@class='changeOnIncarcerationStatus row form-group']//span")
    List<WebElement> changeOnIncarcerationStatus;

    @FindBy(xpath = "//*[@class='gainOfAIANStatus row form-group']//span")
    List<WebElement> gainOfAIANStatusText;

    @FindBy(xpath = "//*[@class='taxTimeEnrollmentPeriod row form-group']//span")
    List<WebElement> taxTimeEnrollmentPeriodText;

    @FindBy(xpath = "//*[@class='noneOfThese row form-group']//span")
    List<WebElement> noneOfTheseText;

    @FindBy(xpath = "//*[@class='marriage row form-group']//span")
    List<WebElement> MarriageText;

    @FindBy(xpath = "//*[@class='birth row form-group']//span")
    List<WebElement> BirthText;

    @FindBy(xpath = " //input[contains(@class,'input-checkbox')]")
    List<WebElement> AllcheckboxQLCE;

    @FindBy(xpath = " //*[@class='form-control eventDate']")
    List<WebElement> EventDateQLCE;

    @FindBy(xpath = " //*[@class='form-control day60Date']")
    List<WebElement> EventDateQLCELossorChangeIncar;

   @FindBy(xpath = " //p[@class='c4BodyText2']")
    List<WebElement> PregancyImportantTitle;

    @FindBy(xpath = "//p[@class='c4BodyText1']")
    List<WebElement> PregancyAddtionalText;

    @FindBy(xpath = "//*[@id='lceMembersForPregnancyStatus0.lceEventDate']")
    WebElement eventDatePregnancy;





    public String getCurrentDate() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate currentDate = LocalDate.now();
        // Now format the date
        return dateFormat.format(currentDate);
    }

    public void selectQLCE(String QLCEType) {
        basicActions.wait(50);
        switch (QLCEType) {
            case "Birth":
                basicActions.waitForElementToBeClickable(birthQLCE, 10);
                birthQLCE.click();
                for (var i = 0; i < allmembersBirthcheckbox.size(); i++) {
                    allmembersBirthcheckbox.get(i).click();
                    birthEventDate.get(i).click();
                    birthEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "Marriage":
                basicActions.waitForElementToBeClickable(marriageLce, 10);
                marriageLce.click();
                for (var i = 0; i < allmemberMarriagecheckbox.size(); i++) {
                    allmemberMarriagecheckbox.get(i).click();
                    marriageEventDate.get(i).click();
                    marriageEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "MoveToCO":
                basicActions.waitForElementToBeClickable(addressChangeLce, 10);
                addressChangeLce.click();
                for (var i = 0; i < memberCheckboxChangeOfAddress.size(); i++) {
                    memberCheckboxChangeOfAddress.get(i).click();
                    changeOfAddressEventDate.get(i).click();
                    changeOfAddressEventDate.get(i).sendKeys(getCurrentDate());
                    movedToColoradoCheckbox.get(i).click();
                }
                break;
            case "ChangePrimaryResidence":
                basicActions.waitForElementToBeClickable(addressChangeLce, 10);
                addressChangeLce.click();
                for (var i = 0; i < memberCheckboxChangeOfAddress.size(); i++) {
                    memberCheckboxChangeOfAddress.get(i).click();
                    changeOfAddressEventDate.get(i).click();
                    changeOfAddressEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "GainedLawfulPresence":
                basicActions.waitForElementToBeClickable(LawfulPresenceLCE, 10);
                LawfulPresenceLCE.click();
                for (var i = 0; i < allmemberLawfulPresencecheckbox.size(); i++) {
                    allmemberLawfulPresencecheckbox.get(i).click();
                    LawfulPresenceEventDate.get(i).click();
                    LawfulPresenceEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "LostCoverage":
                basicActions.waitForElementToBeClickable(lostCoverageLCE, 10);
                lostCoverageLCE.click();
                for (var i = 0; i < allMemberLostCoverageCheckbox.size(); i++) {
                    allMemberLostCoverageCheckbox.get(i).click();
                    lostCoverageEventDate.get(i).click();
                    lostCoverageEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "GainOfTribalStatus":
                basicActions.waitForElementToBeClickable(tribalStatusLCE, 10);
                tribalStatusLCE.click();
                for (var i = 0; i < allMembersGainedTribalStatusCheckbox.size(); i++) {
                    allMembersGainedTribalStatusCheckbox.get(i).click();
                    tribalStatusEventDate.get(i).click();
                    tribalStatusEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "Death":
                basicActions.waitForElementToBeClickable(deathLce, 10);
                deathLce.click();
                for (var i = 0; i < allmemberDeathcheckbox.size(); i++) {
                    allmemberDeathcheckbox.get(i).click();
                    deathEventDate.get(i).click();
                    deathEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "Divorce":
                basicActions.waitForElementToBeClickable(divorceLce, 10);
                divorceLce.click();
                for (var i = 0; i < allmemberDivorcecheckbox.size(); i++) {
                    allmemberDivorcecheckbox.get(i).click();
                    divorceEventDate.get(i).click();
                    divorceEventDate.get(i).sendKeys(getCurrentDate());
                }
                break;
            case "Pregnancy":
                basicActions.waitForElementToDisappear( spinner, 30 );
                basicActions.waitForElementToBePresentWithRetries(pregnancyQLCE, 20);
                pregnancyQLCE.click();
                for (var i = 0; i < allmembersPregnancycheckbox.size(); i++) {
                    allmembersPregnancycheckbox.get( i ).click();
                    pregnancyEventDate.get( i ).click();
                    pregnancyEventDate.get( i ).sendKeys( getCurrentDate() );
                }
                yesRetainPrgnancyCoverage.click();
                 break;
            case "Incarceration":
                basicActions.waitForElementToDisappear( spinner, 30 );
                basicActions.waitForElementToBePresentWithRetries( changeOnIncarcerationStatusLce,30 );
                changeOnIncarcerationStatusLce.click();
                for (var i = 0; i < allmemberIncarcerationcheckbox.size(); i++) {
                    allmemberIncarcerationcheckbox.get( i ).click();
                    incarcerationEventDate.get( i ).click();
                    incarcerationEventDate.get( i ).sendKeys( getCurrentDate() );
                }
                break;
            case "IncomeJobChange":
                basicActions.waitForElementToDisappear( spinner, 30 );
                basicActions.waitForElementToBePresentWithRetries( changeOfIncomeOrJobLCE,30 );
                changeOfIncomeOrJobLCE.click();
                for (var i = 0; i < allMemberschangeOfIncomeOrJobCheckbox.size(); i++) {
                    allMemberschangeOfIncomeOrJobCheckbox.get( i ).click();
                    changeOfIncomeOrJobEventDate.get( i ).click();
                    changeOfIncomeOrJobEventDate.get( i ).sendKeys( getCurrentDate() );
                }
                break;
            case "HealthCoverageChange":
                basicActions.waitForElementToDisappear( spinner, 30 );
                basicActions.waitForElementToBePresentWithRetries( changeOfHealthCoverageLCE,30 );
                changeOfHealthCoverageLCE.click();
                for (var i = 0; i < allMemberschangeOfHealthCoverageCheckbox.size(); i++) {
                    allMemberschangeOfHealthCoverageCheckbox.get( i ).click();
                    changeOfHealthCoverageEventDate.get( i ).click();
                    changeOfHealthCoverageEventDate.get( i ).sendKeys( getCurrentDate() );
                }
                break;
            case "TaxTimeEnrollmentPeriod":
                basicActions.waitForElementToBeClickable(taxTimeEnrollmentPeriod, 10);
                taxTimeEnrollmentPeriod.click();
                break;

            case "NoneOfThese":
                basicActions.waitForElementToBeClickable(noneOfTheseLCE, 10);
                noneOfTheseLCE.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + QLCEType);
        }
    }
    public void selectQLCEforMember(String QLCEType, String selectMember) {
        switch (QLCEType) {
            case "ChangeOnIncarcerationStatus":
                basicActions.waitForElementToBeClickable(changeOnIncarcerationStatusLce, 10);
                changeOnIncarcerationStatusLce.click();
                WebElement incarcerationMemCheckbox = basicActions.getDriver().findElement(By.xpath( "//div[@class='col-sm-4 incarcerationMemberWrapper']//span[contains(text(),'"+selectMember+"')]/preceding::input[2]"));
                WebElement incarcerationMemEventDate = basicActions.getDriver().findElement(By.xpath( "//div[@class='col-sm-4 incarcerationMemberWrapper']//span[contains(text(),'"+selectMember+"')]/following::input[1]"));
                incarcerationMemCheckbox.click();
                incarcerationMemEventDate.sendKeys(getCurrentDate());
                break;
            case "Divorce":
                basicActions.waitForElementToBeClickable(divorceLce, 10);
                divorceLce.click();
                WebElement divorceMemCheckbox = basicActions.getDriver().findElement(By.xpath( "//div[@class='col-sm-4 divorceMemberWrapper']//span[contains(text(),'"+selectMember+"')]/preceding::input[2]"));
                WebElement divorceMemEventDate = basicActions.getDriver().findElement(By.xpath( "//div[@class='col-sm-4 divorceMemberWrapper']//span[contains(text(),'"+selectMember+"')]/following::input[1]"));
                divorceMemCheckbox.click();
                divorceMemEventDate.sendKeys(getCurrentDate());
                break;
            case "Death":
                basicActions.waitForElementToBeClickable(deathLce, 10);
                deathLce.click();
                WebElement deathMemCheckbox = basicActions.getDriver().findElement(By.xpath( "//div[@class='col-sm-4 deathMemberWrapper']//span[contains(text(),'"+selectMember+"')]/preceding::input[2]"));
                WebElement deathMemEventDate = basicActions.getDriver().findElement(By.xpath( "//div[@class='col-sm-4 deathMemberWrapper']//span[contains(text(),'"+selectMember+"')]/following::input[1]"));
                deathMemCheckbox.click();
                deathMemEventDate.sendKeys(getCurrentDate());
                break;
            case "Lost Coverage":
                basicActions.waitForElementToBeClickable(lostCoverageLCE, 10);
                lostCoverageLCE.click();
                WebElement lostCoverageMemCheckbox = basicActions.getDriver().findElement(By.xpath( "//div[@class='col-sm-4 insuranceMemberWrapper']//span[contains(text(),'"+selectMember+"')]/preceding::input[2]"));
                WebElement lostCoverageEventDate = basicActions.getDriver().findElement(By.xpath( "//div[@class='col-sm-4 insuranceMemberWrapper']//span[contains(text(),'"+selectMember+"')]/following::input[1]"));
                lostCoverageMemCheckbox.click();
                String date = basicActions.getDateBasedOnRequirement("Last Day Of Current Month");
                String endDate = basicActions.changeDateFormat(date, "yyyy-MM-dd", "MM/dd/yyyy");
                lostCoverageEventDate.sendKeys(endDate);
                break;
            case "Change Income or Job":
                basicActions.waitForElementToBeClickable(changeOfIncomeOrJobLCE, 10);
                changeOfIncomeOrJobLCE.click();
                WebElement changeOfIncomeOrJobLCEMemCheckbox = basicActions.getDriver().findElement(By.xpath( "//div[@class='col-sm-4 incomeMemberWrapper']//span[contains(text(),'"+selectMember+"')]/preceding::input[2]"));
                WebElement changeOfIncomeOrJobLCEMemEventDate = basicActions.getDriver().findElement(By.xpath( "//div[@class='col-sm-4 incomeMemberWrapper']//span[contains(text(),'"+selectMember+"')]/following::input[1]"));
                changeOfIncomeOrJobLCEMemCheckbox.click();
                changeOfIncomeOrJobLCEMemEventDate.sendKeys(getCurrentDate());
                break;
            case "Gain Lawful Presence":
                basicActions.waitForElementToBeClickable(LawfulPresenceLCE, 10);
                LawfulPresenceLCE.click();
                WebElement LawfulPresenceLCEMemCheckbox = basicActions.getDriver().findElement(By.xpath( "//div[@class='col-sm-4 lawfulPresenceMemberWrapper']//span[contains(text(),'"+selectMember+"')]/preceding::input[2]"));
                WebElement LawfulPresenceLCEMemEventDate = basicActions.getDriver().findElement(By.xpath( "//div[@class='col-sm-4 lawfulPresenceMemberWrapper']//span[contains(text(),'"+selectMember+"')]/following::input[1]"));
                LawfulPresenceLCEMemCheckbox.click();
                LawfulPresenceLCEMemEventDate.sendKeys(getCurrentDate());
                break;

            default:
                throw new IllegalArgumentException("Invalid option: " + QLCEType);
        }
    }


    public void selectBirthLCE() {
        basicActions.waitForElementToBeClickable(birthQLCE, 10);
        String newbornFullName = basicActions.getFullNameWithPrefix(SharedData.getBirthLceIndividual());
        birthQLCE.click();
        WebElement birthLceMemCheckbox = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),'" + newbornFullName + "')]/parent::label/preceding-sibling::input[contains(@class,'checkbox')and contains(@id,'BirthAdoptionOrPlacementForAdoption')]"));
        birthLceMemCheckbox.click();
        birthEventDate.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(eventDateElement -> eventDateElement.sendKeys(SharedData.getCalculatedDob().get(SharedData.getBirthLceIndividual())));
    }


    public void saveAndContinue() {
        basicActions.waitForElementToBePresent( saveAndContinue,10 );
        basicActions.scrollToElement( saveAndContinue);
        saveAndContinue.click();
    }
    public void clickBackButton() {
        btnBack.click();
    }

    public void validateTheVerbiageOnTellUsAboutLifeChangesPage(List<String> data) {
        softAssert.assertEquals(textReportLifeChangeHeader.getText(), data.get(0), "Qlce header text mismatch");
        softAssert.assertEquals(textLifeChangeSubTitle.getText(), data.get(1), "Life change subtitle text mismatch");
        softAssert.assertEquals(lnkHelpLink.getText(), data.get(2), "Help me understand this page link text mismatch");
        //Selecting all checkboxes on the page
        for (int Clickcheckbox = 0; Clickcheckbox < AllcheckboxQLCE.size() - 1; Clickcheckbox++) {
            WebElement CheckBox = AllcheckboxQLCE.get(Clickcheckbox);
            CheckBox.click();
        }
        validateEachQLCEVerbiage(data); //Calling each LCE Types
    }

    void validateEachQLCEVerbiage(List<String> data) {
        BirthTextValidate(data);
        PregnancyTextValidate(data);
        MarriageTextValidate(data);
        DivorceTextValidate(data);
        DeathTextValidate(data);
        ChangeofprimaryresidenceTextValidate(data);
        ChangeofincomeorjobTextValidate(data);
        EnrollmentfutureExistingHealthInsuranceTextValidate(data);
        LossOfCoverageTextValidate(data);
        GainedEligibleImmigrationstatusTextValidate(data);
        ChangeIncarcerationStatusTextValidate(data);
        GainofAmericanIndianAlaskanNativeTextValidate(data);
        TaxTimeEnrollmentPeriodTextValidate(data);
        softAssert.assertEquals(noneOfTheseText.get(0).getText(),data.get(16), "None of these text not match");
        softAssert.assertAll();
    }
    void subcontentTextValidate(List<WebElement> Name,List<String>data) {
        softAssert.assertEquals(Name.get(1).getText(), data.get(17),"Who does this change apply to? Text not match");
        softAssert.assertEquals(Name.get(2).getText(), "" + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(Name.get(3).getText(), data.get(18),"Event Date text not match");
    }

    void BirthTextValidate(List<String>data) {
        softAssert.assertEquals(BirthText.get(0).getText(), data.get(3),"BirthText not match");
        subcontentTextValidate(BirthText,data);
        softAssert.assertEquals(EventDateQLCE.get(0).getAttribute("placeholder"), "mm/dd/yyyy","Placeholer Text not match");
    }

    void PregnancyTextValidate(List<String>data) {
        softAssert.assertEquals(PregancyText.get(0).getText(),  data.get(4),"Pregnancy Text not match");
        softAssert.assertEquals(PregancyText.get(1).getText(), data.get(17),"who does this change text not match");
        softAssert.assertEquals(PregancyImportantTitle.get(0).getText(),data.get(21),"IMPORTANT Text not match");
        softAssert.assertEquals(PregancyAddtionalText.get(0).getText(),data.get(22),"Text not macth");
        softAssert.assertEquals(PregancyAddtionalText.get(1).getText(), data.get(23),"Text not macth");
     }

    void MarriageTextValidate(List<String> data) {
        softAssert.assertEquals(MarriageText.get(0).getText(),data.get(5),"Marriage Text not match");
        subcontentTextValidate(MarriageText,data);
        softAssert.assertEquals(EventDateQLCE.get(1).getAttribute("placeholder"), "mm/dd/yyyy","Placeholer Text not match");
     }

    void DivorceTextValidate(List<String> data) {
        softAssert.assertEquals(DivorceText.get(0).getText(), data.get(6),"Divorce Text not match");
        subcontentTextValidate(DivorceText,data);
        softAssert.assertEquals(EventDateQLCE.get(2).getAttribute("placeholder"), "mm/dd/yyyy","Placeholer Text not match");
      }

    void DeathTextValidate(List<String> data) {
        softAssert.assertEquals(DeathText.get(0).getText(),data.get(7),"Death Text not match");
        softAssert.assertEquals(DeathText.get(1).getText(), data.get(17),"who does this change text not match");
      }
    void ChangeofprimaryresidenceTextValidate(List<String>data) {
         softAssert.assertEquals(changeOfAddressText.get(0).getText(),data.get(8),"Change of primary residence Text not match");
        subcontentTextValidate(changeOfAddressText,data);
        softAssert.assertEquals(changeOfAddressText.get(5).getText(), data.get(20),"Move to Colorado Text not match");
        softAssert.assertEquals(EventDateQLCE.get(3).getAttribute("placeholder"), "mm/dd/yyyy","Placeholer Text not match");
      }

    void ChangeofincomeorjobTextValidate(List<String>data) {

        softAssert.assertEquals(changeOfIncomeOrJobText.get(0).getText(),data.get(9), "Change of income or job Text not match");
        subcontentTextValidate(changeOfIncomeOrJobText,data);
        softAssert.assertEquals(EventDateQLCE.get(4).getAttribute("placeholder"), "mm/dd/yyyy","Placeholer Text not match");
       }

    void EnrollmentfutureExistingHealthInsuranceTextValidate(List<String>data) {

        softAssert.assertEquals(GainofCoverage.get(0).getText(),data.get(10), "Enrollment in future or existing health insurance Text not match");
        subcontentTextValidate(GainofCoverage,data);
        softAssert.assertEquals(EventDateQLCE.get(5).getAttribute("placeholder"), "mm/dd/yyyy","Placeholder Text not match");
      }
    void LossOfCoverageTextValidate(List<String>data) {

        softAssert.assertEquals(loseOrLostHealthInsuranceText.get(0).getText(),data.get(11), "Lost Health insurance Text not match");
        softAssert.assertEquals(loseOrLostHealthInsuranceText.get(1).getText(),data.get(17));
        softAssert.assertEquals(loseOrLostHealthInsuranceText.get(2).getText(), "" + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
        softAssert.assertEquals(loseOrLostHealthInsuranceText.get(3).getText(),data.get(19),"Event Date Text not match");
        softAssert.assertEquals(EventDateQLCELossorChangeIncar.get(0).getAttribute("placeholder"), "mm/dd/yyyy","Placeholder Text not match");
      }
    void GainedEligibleImmigrationstatusTextValidate(List<String>data) {

        softAssert.assertEquals(gainedLawfulPresenceText.get(0).getText(),data.get(12), "Gained Eligible Immigration status Text not match");
        subcontentTextValidate(gainedLawfulPresenceText,data);
        softAssert.assertEquals(EventDateQLCE.get(6).getAttribute("placeholder"), "mm/dd/yyyy","Placeholder Text not match");
       }
    void ChangeIncarcerationStatusTextValidate(List<String>data) {

        softAssert.assertEquals(changeOnIncarcerationStatus.get(0).getText(),data.get(13), "Incarceration text  not match");
        subcontentTextValidate(changeOnIncarcerationStatus,data);
        softAssert.assertEquals(EventDateQLCELossorChangeIncar.get(1).getAttribute("placeholder"), "mm/dd/yyyy","Placeholder Text not match");
     }
    void GainofAmericanIndianAlaskanNativeTextValidate(List<String>data) {

        softAssert.assertEquals(gainOfAIANStatusText.get(0).getText(),data.get(14), "American Indian/Alaskan Native Text  not match");
        subcontentTextValidate(gainOfAIANStatusText,data);
        softAssert.assertEquals(EventDateQLCE.get(7).getAttribute("placeholder"), "mm/dd/yyyy","Placeholder Text not match");
     }
    void TaxTimeEnrollmentPeriodTextValidate(List<String>data) {
        softAssert.assertEquals(taxTimeEnrollmentPeriodText.get(0).getText(),data.get(15), "American Indian/Alaskan Native Text not match");
     }

    public void setPregnancyEventDate(String eventDateType) {
        String resolvedDate = basicActions.getDateBasedOnRequirement(eventDateType);
        String formattedDate = basicActions.changeDateFormat(resolvedDate, "yyyy-MM-dd", "MM/dd/yyyy");
        pregnancyEventDate.get(0).sendKeys(formattedDate);
        pregnancyStatusRetainCoverageYes.click();
    }


    public void selectBirthOptionWithEventDate(String firstDateOfCurrentMonth){
        basicActions.waitForElementToBeClickable(birthQLCE, 10);
        birthQLCE.click();
        for (var i = 0; i < allmembersBirthcheckbox.size(); i++) {
            allmembersBirthcheckbox.get(i).click();
            birthEventDate.get(i).click();
            String requiredDate = basicActions.getDateBasedOnRequirement(firstDateOfCurrentMonth);
            String formattedDate = basicActions.changeDateFormat(requiredDate, "yyyy-MM-dd", "MM/dd/yyyy");
            birthEventDate.get(i).sendKeys(formattedDate);
        }
    }

    public void selectElgibilityPregnancyCoverage(String elgibility) {
        switch (elgibility) {
            case "Yes":
                pregnancyStatusRetainCoverageYes.click();
                break;
            case "No":
                pregnancyStatusRetainCoverageNo.click();
                break;
            case "None":
                pregnancyStatusRetainCoverageNone.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + elgibility);
        }
    }

    public void setFutureBirthEventDate(String eventDateType) {
        basicActions.waitForElementListToBePresent(pregnancyEventDate, 20);
        pregnancyEventDate.clear();
        pregnancyEventDate.get(0).click();
        switch (eventDateType) {
            case "First Date of Current Month":
                pregnancyEventDate.get(0).sendKeys(getFirstDateOfCurrentMonth());
                break;
            case "Last Date of Current Month":
                pregnancyEventDate.get(0).sendKeys(getLastDateOfCurrentMonth());
                break;
            case "Future Date":
                pregnancyEventDate.get(0).sendKeys(getFutureDate());
                break;
            case "Current Date":
                pregnancyEventDate.get(0).sendKeys(getCurrentDate());
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + eventDateType);
        }
    }
    public String getFirstDateOfCurrentMonth() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate firstDate = LocalDate.now().withDayOfMonth(1);
        return dateFormat.format(firstDate);
    }
    public String getLastDateOfCurrentMonth() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate lastDate = LocalDate.now().withDayOfMonth(LocalDate.now().lengthOfMonth());
        return dateFormat.format(lastDate);
    }
    public String getFutureDate() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate futureDate = LocalDate.now().plus(1, ChronoUnit.MONTHS);
        return dateFormat.format(futureDate);
    }


    public void selectElgibilityPregnancyCoverageForMember(String eventDateType, String selectMember) {
        String resolvedDate = basicActions.getDateBasedOnRequirement(eventDateType);
        String formattedDate = basicActions.changeDateFormat(resolvedDate, "yyyy-MM-dd", "MM/dd/yyyy");
        WebElement pregnancyMemCheckbox = basicActions.getDriver().findElement(By.xpath("//div[@class='col-sm-4 pregnancyMemberWrapper']//span[contains(text(),'" + selectMember + "')]/preceding::input[2]"));
        WebElement pregnancyMemEventDate = basicActions.getDriver().findElement(By.xpath("//div[@class='col-sm-4 pregnancyMemberWrapper']//span[contains(text(),'" + selectMember + "')]/following::input[1]"));
        pregnancyMemCheckbox.click();
        pregnancyMemEventDate.sendKeys(formattedDate);
    }



}

