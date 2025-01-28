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
import java.util.List;

public class QlceConfirmationPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public QlceConfirmationPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "birth")
    WebElement birthQLCE;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    List<WebElement> allmembersBirthcheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    List<WebElement> birthEventDate;

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

    @FindBy(id = "taxTimeEnrollmentPeriod")
    WebElement taxTimeEnrollmentPeriod;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'lceMembersForLoseOrLostHealthInsurance')]")
    List<WebElement> allMemberLostCoverageCheckbox;
    @FindBy(xpath = "//input[@type='date' and contains(@id,'lceMembersForLoseOrLostHealthInsurance')]")
    List<WebElement> lostCoverageEventDate;

    @FindBy(id = "gainOfAIANStatus")
    WebElement tribalStatusLCE;
    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id, 'lceMembersForGainOfTribalStatus')]")
    List<WebElement> allMembersGainedTribalStatusCheckbox;
    @FindBy(xpath = "//input[@type='date' and contains(@id,'lceMembersForGainOfTribalStatus')]")
    List<WebElement> tribalStatusEventDate;

    //None of These
    @FindBy(id = "noneOfThese")
    WebElement noneOfTheseLCE;
    @FindBy(xpath = "//*[@id='continueButton']")
    WebElement saveAndContinue;

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

    @FindBy(xpath = " //input[contains(@class,'input-checkbox')]")
    List<WebElement> checkboxQLCE;

    @FindBy(xpath = " //input[contains(@class,'form-control eventDate')]")
    List<WebElement> EventDateQLCE;

    @FindBy(xpath = " //p[@class='c4BodyText2']")
    List<WebElement> PregancyImportantTitle;

    @FindBy(xpath = "//p[@class='c4BodyText1']")
    List<WebElement> PregancyAddtionalText;


    public String getCurrentDate() {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        LocalDate currentDate = LocalDate.now();
        // Now format the date
        return dateFormat.format(currentDate);
    }

    public void selectQLCE(String QLCEType) {
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
            case "NoneOfThese":
                basicActions.waitForElementToBeClickable(noneOfTheseLCE, 10);
                noneOfTheseLCE.click();
                break;
            case "TaxTimeEnrollmentPeriod":
                basicActions.waitForElementToBeClickable(taxTimeEnrollmentPeriod, 10);
                taxTimeEnrollmentPeriod.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + QLCEType);
        }
    }

    public void selectBirthLCE() {
        basicActions.waitForElementToBeClickable(birthQLCE, 10);
        String newbornFullName = basicActions.getFullNameWithPrefix(SharedData.getBirthLceIndividual());
        birthQLCE.click();
        WebElement birthLceMemCheckbox = basicActions.getDriver().findElement(By.xpath("//span[contains(text(),'"+newbornFullName + "')]/parent::label/preceding-sibling::input[contains(@class,'checkbox')and contains(@id,'BirthAdoptionOrPlacementForAdoption')]"));
        birthLceMemCheckbox.click();
        birthEventDate.stream()
                .filter(WebElement::isDisplayed)
                .findFirst()
                .ifPresent(eventDateElement -> eventDateElement.sendKeys(SharedData.getCalculatedDob().get(SharedData.getBirthLceIndividual())));
    }


    public void saveAndContinue() {
        saveAndContinue.click();
    }
    public void validateTheVerbiageOnTellUsAboutLifeChangesPage(String Language, List<String> data) {
        switch (Language) {
            case "English":
                validateTheVerbiageEn(data);
                break;
            case "Spanish":
                validateTheVerbiageEs(data);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + Language);
        }
    }
    public void validateTheVerbiageEn(List<String> data) {

        softAssert.assertEquals(textReportLifeChangeHeader.getText(), data.get(0), "Qlce header text mismatch");
        softAssert.assertEquals(textLifeChangeSubTitle.getText(), data.get(1), "Life change subtitle text mismatch");
        softAssert.assertEquals(lnkHelpLink.getText(), data.get(2), "Help me understand this page link text mismatch");
        for (int Clickcheckbox = 0; Clickcheckbox < checkboxQLCE.size() - 1; Clickcheckbox++) {
            WebElement CheckBox = checkboxQLCE.get(Clickcheckbox);
            CheckBox.click();
        }
        int LabelText = 0, EventDatePlaceholderText =0;
         for(int QLCELabelCount=3;QLCELabelCount< data.size();QLCELabelCount++) {
            if( LabelText < textLceLable.size()) {
                softAssert.assertEquals(textLceLable.get(LabelText).getText(), data.get(QLCELabelCount));
                LabelText++;
                if (LabelText == 6 || LabelText == 16) continue;
                if (LabelText ==  textLceLable.size())
                    break;
                softAssert.assertEquals(textLceLable.get(LabelText).getText(), "Who does this change apply to?");
                LabelText++;

                if (LabelText == 6 || LabelText == 16) continue; // Position value of QLCE label list
                if (LabelText ==  textLceLable.size()) break;
                softAssert.assertEquals(textLceLable.get(LabelText).getText(), "" + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
                LabelText++;
                if (LabelText ==  textLceLable.size()) break;

                if (LabelText == 32){ // Position value 32 to check loss of event label
                    softAssert.assertEquals(textLceLable.get(LabelText).getText(), "Event Date: If you are losing Health First Colorado or CHP+ coverage, enter the date coverage ends. If it has already ended, enter today's date. If you are losing other coverage, please enter the last day of the month that you are covered.");
                    softAssert.assertEquals(EventDateQLCE.get(EventDatePlaceholderText).getAttribute("placeholder"), "mm/dd/yyyy");
                    LabelText++;
                    continue;
                }
                softAssert.assertEquals(textLceLable.get(LabelText).getText(), "Event Date");
                LabelText++;
                if (EventDatePlaceholderText == 8) break; //Position value to check event date placeholder
                softAssert.assertEquals(EventDateQLCE.get(EventDatePlaceholderText).getAttribute("placeholder"), "mm/dd/yyyy");
                 EventDatePlaceholderText++;
                if (LabelText == 20){ //Position value to check move to colorado text
                    softAssert.assertEquals(textLceLable.get(LabelText).getText(), "Moved to Colorado");
                    LabelText++;
                }

            }
        }
         softAssert.assertEquals(textLceLable.get(45).getText(), data.get(15));
         softAssert.assertEquals(textLceLable.get(46).getText(), data.get(16));
         softAssert.assertEquals(PregancyImportantTitle.get(0).getText(), "IMPORTANT");
         softAssert.assertEquals(PregancyAddtionalText.get(0).getText(), "When you become pregnant, you can enroll in a health insurance plan. Your coverage can start as early as the month in which a health care provider certified your pregnancy, or it can start on the first day of the month after you choose a plan.");
         softAssert.assertEquals(PregancyAddtionalText.get(1).getText(), "To enroll and choose the start date for your plan, call our Customer Service Center at 855-752-6749. You cannot enroll through your online account.");
         softAssert.assertAll();
    }

    public void validateTheVerbiageEs(List<String> data) {

        softAssert.assertEquals(textReportLifeChangeHeader.getText(), data.get(0));
        softAssert.assertEquals(textLifeChangeSubTitle.getText(), data.get(1));
        softAssert.assertEquals(lnkHelpLink.getText(), data.get(2));
        for (int Clickcheckbox = 0; Clickcheckbox < checkboxQLCE.size() - 1; Clickcheckbox++) {
            WebElement CheckBox = checkboxQLCE.get(Clickcheckbox);
            CheckBox.click();
        }
        int LabelText = 0, EventDatePlaceholderText =0;
        for(int QLCELabelCount=3;QLCELabelCount< data.size();QLCELabelCount++) {
            if( LabelText < textLceLable.size()) {
                softAssert.assertEquals(textLceLable.get(LabelText).getText(), data.get(QLCELabelCount));
                LabelText++;
                if (LabelText == 6 || LabelText == 16) continue;
                if (LabelText ==  textLceLable.size())
                    break;
                softAssert.assertEquals(textLceLable.get(LabelText).getText(), "¿A quién aplica este cambio?");
                LabelText++;

                if (LabelText == 6 || LabelText == 16) continue; // Position value of QLCE label list
                if (LabelText ==  textLceLable.size()) break;
                softAssert.assertEquals(textLceLable.get(LabelText).getText(), "" + SharedData.getPrimaryMember().getFirstName() + " " + SharedData.getPrimaryMember().getLastName());
                LabelText++;
                if (LabelText ==  textLceLable.size()) break;

                if (LabelText == 32){ // Position value 32 to check loss of event label
                    softAssert.assertEquals(textLceLable.get(LabelText).getText(), "Fecha del evento: (Si usted va a perder la cobertura de Health First Colorado o CHP+, ingrese la fecha en que terminará. Si ya terminó, ingrese la fecha de hoy). Si va a perder otra cobertura, ingrese el último día del mes en que estará cubierto.");
                    softAssert.assertEquals(EventDateQLCE.get(EventDatePlaceholderText).getAttribute("placeholder"), "mm/dd/yyyy");
                    LabelText++;
                    continue;
                }
                softAssert.assertEquals(textLceLable.get(LabelText).getText(), "Fecha del evento");
                LabelText++;
                if (EventDatePlaceholderText == 8) break; //Position value to check event date placeholder
                softAssert.assertEquals(EventDateQLCE.get(EventDatePlaceholderText).getAttribute("placeholder"), "mm/dd/yyyy");
                EventDatePlaceholderText++;
                if (LabelText == 20){ //Position value to check move to colorado text
                    softAssert.assertEquals(textLceLable.get(LabelText).getText(), "Mudanza a Colorado");
                    LabelText++;
                }

            }
        }
        softAssert.assertEquals(textLceLable.get(45).getText(), data.get(15));
        softAssert.assertEquals(textLceLable.get(46).getText(), data.get(16));
        softAssert.assertEquals(PregancyImportantTitle.get(0).getText(), "IMPORTANTE");
        softAssert.assertEquals(PregancyAddtionalText.get(0).getText(), "Cuando se embaraza, usted puede inscribirse en un plan de seguro de salud. La cobertura puede comenzar el mes en que un proveedor de atención médica dé constancia del embarazo; o bien, puede comenzar el primer día del mes luego de que usted elija un plan.");
        softAssert.assertEquals(PregancyAddtionalText.get(1).getText(), "Para inscribirse y elegir la fecha de inicio de su plan, llame a nuestro Centro de atención al cliente al 855-752-6749. No puede inscribirse a través de su cuenta en línea.");
        softAssert.assertAll();

    }
}