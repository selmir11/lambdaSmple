package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.HashMap;
import java.util.Map;

import java.time.LocalDate;
import java.util.List;

public class LifeChangeEventsCoCoPage {

    private BasicActions basicActions;

    Actions actions = new Actions(WebDriverManager.getDriver());

    SoftAssert softAssert = new SoftAssert();

    public LifeChangeEventsCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".header-1")
    WebElement hdr_Lce;

    @FindBy(css = ".page-header")
    WebElement hdr_LceText;
    @FindBy(css = "lib-error-msg > div")
    List<WebElement> hdrError;
    @FindBy(className = "error-message")
    WebElement selectLCEError;
    @FindBy(css = "#ELIG-LceOption-LOSS_OF_MEC_OTHER-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement insuranceLossLCEContainer;
    @FindBy(id = "ELIG-LceOption-LOSS_OF_MEC_OTHER-checkBoxButton")
    WebElement insuranceLossLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-LOSS_OF_MEC_OTHER')]")
    List<WebElement> allMemberInsuranceLossCheckbox;
    @FindBy (xpath = "//input[contains(@id, 'ELIG-LceMember-LOSS_OF_MEC_OTHER')]")
    List<WebElement> insuranceLossEventDate;
    @FindBy(css = "#ELIG-LceOption-BIRTH_ADOPTION_OR_PLACEMENT_FOR_ADOPTION-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement birthLCEContainer;
    @FindBy(id = "ELIG-LceOption-BIRTH_ADOPTION_OR_PLACEMENT_FOR_ADOPTION-checkBoxButton")
    WebElement birthLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-BIRTH')]")
    List<WebElement> allMembersBirthCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-BIRTH')]")
    List<WebElement> birthEventDate;
    @FindBy(css = "#ELIG-LceOption-PREGNANCY-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement pregnancyLCEContainer;
    @FindBy(id = "ELIG-LceOption-PREGNANCY-checkBoxButton")
    WebElement pregnancyLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-PREGNANCY')]")
    List<WebElement> allMembersPregnancyCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-PREGNANCY')]")
    List<WebElement> pregnancyEventDate;
    @FindBy(css = "#ELIG-LceOption-MARRIAGE_CIVILUNION_OR_DOMESTIC_PARTNER-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement marriageLCEContainer;
    @FindBy(id ="ELIG-LceOption-MARRIAGE_CIVILUNION_OR_DOMESTIC_PARTNER-checkBoxButton")
    WebElement marriageLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-MARRIAGE')]")
    List<WebElement> allMembersMarriageCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-MARRIAGE')]")
    List<WebElement> marriageEventDate;
    @FindBy(css = "#ELIG-LceOption-DIVORCE_ANNULMENT_OR_SEPARATION-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement divorceLCEContainer;
    @FindBy(id ="ELIG-LceOption-DIVORCE_ANNULMENT_OR_SEPARATION-checkBoxButton")
    WebElement divorceLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-DIVORCE')]")
    List<WebElement> allMembersDivorceCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-DIVORCE')]")
    List<WebElement> divorceEventDate;
    @FindBy(css = "#ELIG-LceOption-DEATH-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement deathLCEContainer;
    @FindBy(id ="ELIG-LceOption-DEATH-checkBoxButton")
    WebElement deathLCE;
    @FindBy(xpath = "//button[contains(@id, 'ELIG-LceMember-DEATH')]")
    List<WebElement> allMembersDeathCheckbox;
    @FindBy(xpath = "//input[contains(@id, 'ELIG-LceMember-DEATH')]")
    List<WebElement> deathEventDate;
    @FindBy(css = "#ELIG-LceOption-CHANGE_OF_RESIDENCE-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement addressChangeLCEContainer;
    @FindBy(id="ELIG-LceOption-CHANGE_OF_RESIDENCE-checkBoxButton")
    WebElement addressChangeLCE; //Moved to Colorado
    @FindBy(css=".c4-input [id^='ELIG-LceMember-CHANGE_OF_RESIDENCE-Member'][role='checkbox']")
    List<WebElement> qamemberChangeOfAddressCheckbox;

    @FindBy(css=".checkbox-description [id^='ELIG-LceMember-CHANGE']")
    List<WebElement> stgmemberChangeOfAddressCheckbox;

    @FindBy(css = ".c4-input [id^='ELIG-LceMember-CHANGE_OF_RESIDENCE-Member'][type='date']")
    List<WebElement> qachangeOfAddressEventDate;

    @FindBy(css = ".col [id^='ELIG-LceMember-CHANGE']")
    List<WebElement> stgchangeOfAddressEventDate;

    @FindBy(xpath = "//button[contains(@id,'movedToColorado-checkBoxButton')]")
    List<WebElement> movedToColoradoCheckbox;
    @FindBy(css = "#ELIG-LceOption-noneOfThese-checkBoxButton-container > div.row.input-row > div > lib-checkbox-control > label")
    //@FindBy(css = "#-container > div.row.input-row > div > lib-checkbox-control > label")
    WebElement noneOfTheseLCEContainer;
    @FindBy(id ="ELIG-LceOption-noneOfThese-checkBoxButton")
    WebElement noneOfTheseLCE;
    @FindBy(id = "LceOverview-SaveAndContinue")
    WebElement saveAndContinueButton;
    @FindBy(id = "LceOverview-GoBack")
    WebElement goBackButton;

    @FindBy(css = "lib-checkbox-control label")
    List<WebElement> boxesLCE;

    @FindBy(css = "label button")
    List<WebElement> checkboxesLCE;

    //lib-checkbox-control label
    @FindBy(css = "lib-checkbox-control label span")
    List<WebElement> checkboxesLabelsLCE;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void selectLCE(String LCEType, String dateType) {
        basicActions.waitForElementToDisappear(spinner, 20);
        String[] parts = LCEType.split(":");
        String type = parts[0];
        switch (type) {
            case "InsuranceLoss", "Pregnancy", "Birth", "Marriage", "Divorce", "Death", "Move", "BirthLceIndividual":
                selectLCECheckbox(LCEType);
                selectMemberForLCE(LCEType);
                setDateForLCE(LCEType, dateType);
                break;
            case "MoveToCO":
                selectLCECheckbox(LCEType);
                selectMemberForLCE(LCEType);
                setDateForLCE(LCEType, dateType);
                clickMoveToCO();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + type);
        }
    }

    private void clickMoveToCO() {
        basicActions.waitForElementToBeClickable(addressChangeLCE, 10);
        for (WebElement toColoradoCheckbox : movedToColoradoCheckbox) {
            basicActions.waitForElementToBeClickable(toColoradoCheckbox, 10);
            toColoradoCheckbox.click();
        }
    }

    public void selectLCECheckbox(String LCEType) {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(addressChangeLCE,20);
        String[] parts = LCEType.split(":");
        String type = parts[0];
        switch (type) {
            case "InsuranceLoss":
                insuranceLossLCE.click();
                break;
            case "Birth", "BirthLceIndividual":
                birthLCE.click();
                break;
            case "Pregnancy":
                pregnancyLCE.click();
                break;
            case "Marriage":
                marriageLCE.click();
                break;
            case "Divorce":
                divorceLCE.click();
                break;
            case "Death":
                deathLCE.click();
                break;
            case "Move", "MoveToCO":
                addressChangeLCE.click();
                break;
            case "None of these":
                noneOfTheseLCE.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + type);
        }
    }

    public void selectMemberForLCE(String LCEType) {
        basicActions.waitForElementToDisappear(spinner, 20);

        String[] parts = LCEType.split(":");
        String type = parts[0];
        String member = parts.length > 1 ? parts[1] : null;

        if (member != null) {
            clickOneMemberLCE(type, member);
        } else {
            clickAllMembersLCE(type);
        }
    }

    private static final Map<String, String> LCE_TYPE_MAP = new HashMap<>();

    static {
        LCE_TYPE_MAP.put("InsuranceLoss", "ELIG-LceMember-LOSS_OF_MEC_OTHER");
        LCE_TYPE_MAP.put("Birth", "ELIG-LceMember-BIRTH");
        LCE_TYPE_MAP.put("Pregnancy", "ELIG-LceMember-PREGNANCY");
        LCE_TYPE_MAP.put("Marriage", "ELIG-LceMember-MARRIAGE");
        LCE_TYPE_MAP.put("Divorce", "ELIG-LceMember-DIVORCE");
        LCE_TYPE_MAP.put("Death", "ELIG-LceMember-DEATH");
        LCE_TYPE_MAP.put("Move", "ELIG-LceMember-CHANGE_OF_RESIDENCE-Member");
        LCE_TYPE_MAP.put("MoveToCO", "ELIG-LceMember-CHANGE_OF_RESIDENCE-Member");
    }

    private void clickOneMemberLCE(String type, String member) {
        String element = LCE_TYPE_MAP.get(type);
        if (element == null) {
            throw new IllegalArgumentException("Invalid option: " + type);
        }
        clickOneMember(member, element);
    }

    private void clickAllMembersLCE(String type) {
        switch (type) {
            case "InsuranceLoss":
                clickAllMembers(allMemberInsuranceLossCheckbox);
                break;
            case "Birth":
                clickAllMembers(allMembersBirthCheckbox);
                break;
            case "Pregnancy":
                clickAllMembers(allMembersPregnancyCheckbox);
                break;
            case "Marriage":
                clickAllMembers(allMembersMarriageCheckbox);
                break;
            case "Divorce":
                clickAllMembers(allMembersDivorceCheckbox);
                break;
            case "Death":
                clickAllMembers(allMembersDeathCheckbox);
                break;
            case "Move", "MoveToCO":
                clickAllMembers(qamemberChangeOfAddressCheckbox);
                break;
            case "BirthLceIndividual":
                clickBirthLceIndividual();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + type);
        }
    }

    private void clickAllMembers(List<WebElement> checkboxes) {
        for (WebElement checkbox : checkboxes) {
            basicActions.waitForElementToBeClickable(checkbox, 10);
            checkbox.click();
        }
    }

    private void clickBirthLceIndividual() {
        String newbornFullName =basicActions.getCompleteFullNameWithPrefix(SharedData.getBirthLceIndividual());
        WebElement birthLceMemCheckbox = basicActions.getDriver().findElement(By.xpath( "//span[contains(text(),'" + newbornFullName + "')]/parent::label//button[contains(@class,'checkbox')and contains(@id,'ELIG-LceMember-BIRTH')]"));
        basicActions.waitForElementToBeClickable(birthLceMemCheckbox, 90);
        basicActions.scrollToElement(birthLceMemCheckbox);
        birthLceMemCheckbox.click();
    }

    private void clickOneMember(String member,String checkboxes) {
        WebElement lceMemCheckbox = basicActions.getDriver().findElement(By.xpath( "//span[contains(text(),'" + member + "')]/parent::label//button[contains(@class,'checkbox')and contains(@id,'"+checkboxes+"')]"));
        basicActions.waitForElementToBeClickable(lceMemCheckbox, 90);
        basicActions.scrollToElement(lceMemCheckbox);
        lceMemCheckbox.click();
    }

    public void setDateForLCE(String LCEType, String dateType) {
        String[] parts = LCEType.split(":");
        String type = parts[0];
        switch (type) {
            case "InsuranceLoss":
                setDateForInsuranceLossCheckboxes(insuranceLossEventDate, dateType);
                break;
            case "Birth", "BirthLceIndividual":
                setDateForCheckboxes(LCEType, birthEventDate, dateType);
                break;
            case "Pregnancy":
                setDateForCheckboxes(LCEType, pregnancyEventDate, dateType);
                break;
            case "Marriage":
                setDateForCheckboxes(LCEType, marriageEventDate, dateType);
                break;
            case "Divorce":
                setDateForCheckboxes(LCEType, divorceEventDate, dateType);
                break;
            case "Death":
                setDateForCheckboxes(LCEType, deathEventDate, dateType);
                break;
            case "Move", "MoveToCO":
                setDateForCheckboxes(LCEType, stgchangeOfAddressEventDate, dateType);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + type);
        }
    }

    private void setDateForCheckboxes(String LCEType, List<WebElement> eventDates, String dateType) {
        String dateValue = basicActions.getDateBasedOnRequirement(dateType);
        if (LCEType.equals("BirthLceIndividual")) {
            dateValue = basicActions.changeDateFormat(dateValue, "yyyy-MM-dd", "MM/dd/yyyy");
        }
        if (isWithin60DaysAfterStartOfYear()) {
            dateValue = basicActions.changeDateFormat(dateValue, "MM/dd/yyyy", "MM/dd/yyyy");
        } else {
            dateValue = basicActions.changeDateFormat(dateValue, "MM/dd/yyyy", "MM/dd");
        }

        selectLceDate(LCEType, dateValue, eventDates);
    }

    private void selectLceDate(String LCEType, String dateValue, List<WebElement> eventDates){
        if (LCEType.equals("BirthLceIndividual")) {
            birthEventDate.stream()
                    .filter(WebElement::isEnabled)
                    .findFirst()
                    .ifPresent(eventDateElement -> eventDateElement.sendKeys(dateValue));
        } else {
            List<WebElement> clickableEventDates = eventDates.stream()
                    .filter(eventDate -> basicActions.isElementClickable(eventDate, 10))
                    .toList();
            for (WebElement eventDate : clickableEventDates) {
                eventDate.sendKeys(dateValue);
            }
        }
    }

    private boolean isWithin60DaysAfterStartOfYear() {
        LocalDate today = LocalDate.now();
        LocalDate startOfYear = LocalDate.of(today.getYear(), 1, 1);

        return today.isBefore(startOfYear.plusDays(60));
    }

    private void setDateForInsuranceLossCheckboxes(List<WebElement> eventDates, String dateType) {
        String dateValue = basicActions.getDateBasedOnRequirement(dateType);
        if (isWithin60DaysOfYearEndOrStart()) {
            dateValue = basicActions.changeDateFormat(dateValue, "MM/dd/yyyy", "MM/dd/yyyy");
        } else {
            dateValue = basicActions.changeDateFormat(dateValue, "MM/dd/yyyy", "MM/dd");
        }
        List<WebElement> clickableEventDates = eventDates.stream()
                .filter(eventDate -> basicActions.isElementClickable(eventDate, 10))
                .toList();
        for (WebElement eventDate : clickableEventDates) {
            eventDate.sendKeys(dateValue);
        }
    }

    private boolean isWithin60DaysOfYearEndOrStart() {
        LocalDate today = LocalDate.now();
        LocalDate startOfYear = LocalDate.of(today.getYear(), 1, 1);
        LocalDate endOfYear = LocalDate.of(today.getYear(), 12, 31);

        return today.isBefore(startOfYear.plusDays(60)) || today.isAfter(endOfYear.minusDays(60));
    }

    public void saveAndContinue(){
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueButton,10);
        saveAndContinueButton.click();
    }

    public void goBack(){
        basicActions.waitForElementToBeClickable(goBackButton, 10);
        goBackButton.click();
    }

    //////////////////////////////////////////////VALIDATION METHODS//////////////////////////////////////////////////
    public void verifyHeadersEmploymentIncomePage(String language){
        switch (language){
            case "English":
                verifyHeadersEmploymentIncomePageEnglish();
                break;
            case "Spanish":
                verifyHeadersEmploymentIncomePageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersEmploymentIncomePageEnglish(){
        basicActions.waitForElementToBePresent(hdr_Lce,15);
        softAssert.assertEquals(hdr_Lce.getText(), "Tell us about life changes");
        softAssert.assertEquals(hdr_LceText.getText(), "Select any Life Change Event you or someone in your household has experienced within the past 60 days. The loss of other health insurance can be reported up to 60 days before you lose the insurance.");
        softAssert.assertAll();
    }

    public void verifyHeadersEmploymentIncomePageSpanish(){
        basicActions.waitForElementToBePresent(hdr_Lce,15);
        softAssert.assertEquals(hdr_Lce.getText(), "Inf\u00F3rmenos sobre los cambios importantes en su vida");
        softAssert.assertEquals(hdr_LceText.getText(), "Seleccione los cambios de vida que usted o alguien de su familia haya tenido en los \u00FAltimos 60 d\u00EDas. La p\u00E9rdida de seguro de salud se puede reportar hasta 60 d\u00EDas antes de que alguien pierda su seguro.");
        softAssert.assertAll();
    }

    public void verifyLCECheckboxState(String LCEType,String Selection){
        basicActions.waitForElementToDisappear(spinner,20);
        switch (LCEType) {
            case "InsuranceLoss":
                basicActions.waitForElementToBePresent(insuranceLossLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(insuranceLossLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(insuranceLossLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "Birth":
                basicActions.waitForElementToBePresent(birthLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(birthLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(birthLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "Pregnancy":
                basicActions.waitForElementToBePresent(pregnancyLCEContainer,25);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(pregnancyLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(pregnancyLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "Marriage":
                basicActions.waitForElementToBePresent(marriageLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(marriageLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(marriageLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "Divorce":
                basicActions.waitForElementToBePresent(divorceLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(divorceLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(divorceLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "Death":
                basicActions.waitForElementToBePresent(deathLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(deathLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(deathLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "MoveToCO":
                basicActions.waitForElementToBePresent(addressChangeLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(addressChangeLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(addressChangeLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "NoneOfThese":
                basicActions.waitForElementToBePresent(noneOfTheseLCEContainer,15);
                switch (Selection) {
                    case "is":
                        softAssert.assertEquals(noneOfTheseLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(noneOfTheseLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "AllSingle":
                basicActions.waitForElementToBePresent(insuranceLossLCEContainer,15);
                switch (Selection){
                    case "is":
                        softAssert.assertEquals(insuranceLossLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(birthLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(pregnancyLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(marriageLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(divorceLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(addressChangeLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(noneOfTheseLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(insuranceLossLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(birthLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(pregnancyLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(marriageLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(divorceLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(addressChangeLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(noneOfTheseLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;
            case "All":
                basicActions.waitForElementToBePresent(insuranceLossLCEContainer,15);
                switch (Selection){
                    case "is":
                        softAssert.assertEquals(insuranceLossLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(birthLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(pregnancyLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(marriageLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(divorceLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(deathLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(addressChangeLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertEquals(noneOfTheseLCEContainer.getAttribute("className"), "checkbox-container checked");
                        softAssert.assertAll();
                        break;
                    case "is not":
                        softAssert.assertEquals(insuranceLossLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(birthLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(pregnancyLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(marriageLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(divorceLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(deathLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(addressChangeLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertEquals(noneOfTheseLCEContainer.getAttribute("className"), "checkbox-container");
                        softAssert.assertAll();
                        break;
                }
                break;

        }
    }

    public void verifyNoErrorMessage(String errorType, String language) {
        switch (errorType) {
            case "Please select option":
                verifySelectOptionErrorNotPresent(language);
                break;
            case "Please select member":
                verifyLCEMemberErrorNotPresent(language);
                break;
            case "Event date":
                verifySelectDateErrorNotPresent(language);
                break;
            case "Event date Past":
                verifySelectDateErrorNotPresent(language);
                break;
            case "Event date Future":
                verifySelectDateErrorNotPresent(language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
        }
    }

    public void verifyErrorMessage(String errorType, String language) {
        switch (errorType) {
            case "Please select option":
                basicActions.waitForElementPresence(selectLCEError, 1);
                verifyLCEError(language);
                break;
            case "Please select member":
                basicActions.waitForElementPresence(selectLCEError, 1);
                verifyLCEMemberError(language);
                break;
            case "Event date":
                verifyLCEDateError(language);
                break;
            case "Event date Past":
                verifyLCEDatePastError(language);
                break;
            case "Event date Future":
                verifyLCEDateFutureError(language);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + errorType);
        }
    }

    public void verifySelectOptionErrorNotPresent(String language){
        // Check if there are any error messages on page.  Return if there aren't any.
        if (!basicActions.waitForElementToBePresent(selectLCEError,1)){
            return;
        }
        switch (language){
            case "English":
                softAssert.assertNotEquals(selectLCEError.getText(), "Please select one or more of the options below:");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertNotEquals(selectLCEError.getText(), "Seleccione una o m\u00E1s de las siguientes opciones:");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyLCEError(String language){
        switch (language) {
            case "English":
                softAssert.assertEquals(selectLCEError.getText(), "Please select one or more of the options below:");
                softAssert.assertEquals(selectLCEError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(selectLCEError.getCssValue("font-size"), "16px");
                softAssert.assertEquals(selectLCEError.getCssValue("font-weight"), "700");
                softAssert.assertEquals(selectLCEError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(selectLCEError.getText(), "Seleccione una o m\u00E1s de las siguientes opciones:");
                softAssert.assertEquals(selectLCEError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(selectLCEError.getCssValue("font-size"), "16px");
                softAssert.assertEquals(selectLCEError.getCssValue("font-weight"), "700");
                softAssert.assertEquals(selectLCEError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyLCEMemberError(String language){
        switch (language) {
            case "English":
                softAssert.assertEquals(selectLCEError.getText(), "Please select who this change applies to:");
                softAssert.assertEquals(selectLCEError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(selectLCEError.getCssValue("font-size"), "16px");
                softAssert.assertEquals(selectLCEError.getCssValue("font-weight"), "700");
                softAssert.assertEquals(selectLCEError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(selectLCEError.getText(), "Seleccione la persona a quien aplica este cambio:");
                softAssert.assertEquals(selectLCEError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(selectLCEError.getCssValue("font-size"), "16px");
                softAssert.assertEquals(selectLCEError.getCssValue("font-weight"), "700");
                softAssert.assertEquals(selectLCEError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyLCEMemberErrorNotPresent(String language){
        // Check if there are any error messages on page.  Return if there aren't any.
        if (!basicActions.waitForElementToBePresent(selectLCEError,1)){
            return;
        }
        switch (language){
            case "English":
                softAssert.assertNotEquals(selectLCEError.getText(), "Please select who this change applies to:");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertNotEquals(selectLCEError.getText(), "Seleccione la persona a quien aplica este cambio:");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifySelectDateErrorNotPresent(String language){
        // Check if there are any error messages on page.  Return if there aren't any.
        if (!basicActions.waitForElementToBePresent(selectLCEError,1)){
            return;
        }
        switch (language){
            case "English":
                softAssert.assertNotEquals(selectLCEError.getText(), "Event date required");
                softAssert.assertNotEquals(selectLCEError.getText(), "This event cannot be reported in the future");
                softAssert.assertNotEquals(selectLCEError.getText(), "Date cannot be more than 60 days in the past");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertNotEquals(selectLCEError.getText(), "La fecha del evento es obligatoria");
                softAssert.assertNotEquals(selectLCEError.getText(), "No se podr\u00E1 reportar este evento en el futuro");
                softAssert.assertNotEquals(selectLCEError.getText(), "La fecha a seleccionar no puede ser 60 d\u00EDas previos a la fecha actual");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyLCEDateError(String language){
        switch (language) {
            case "English":
                softAssert.assertEquals(selectLCEError.getText(), "Event date required");
                softAssert.assertEquals(selectLCEError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(selectLCEError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(selectLCEError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(selectLCEError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(selectLCEError.getText(), "La fecha del evento es obligatoria");
                softAssert.assertEquals(selectLCEError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(selectLCEError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(selectLCEError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(selectLCEError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyLCEDateFutureError(String language){
        switch (language) {
            case "English":
                softAssert.assertEquals(selectLCEError.getText(), "This event cannot be reported in the future");
                softAssert.assertEquals(selectLCEError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(selectLCEError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(selectLCEError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(selectLCEError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(selectLCEError.getText(), "No se podr\u00E1 reportar este evento en el futuro");
                softAssert.assertEquals(selectLCEError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(selectLCEError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(selectLCEError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(selectLCEError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyLCEDatePastError(String language){
        switch (language) {
            case "English":
                softAssert.assertEquals(selectLCEError.getText(), "Date cannot be more than 60 days in the past");
                softAssert.assertEquals(selectLCEError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(selectLCEError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(selectLCEError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(selectLCEError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(selectLCEError.getText(), "La fecha a seleccionar no puede ser 60 d\u00EDas previos a la fecha actual");
                softAssert.assertEquals(selectLCEError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
                softAssert.assertEquals(selectLCEError.getCssValue("font-size"), "14px");
                softAssert.assertEquals(selectLCEError.getCssValue("font-weight"), "400");
                softAssert.assertEquals(selectLCEError.getCssValue("color"), "rgba(150, 0, 0, 1)");
                softAssert.assertEquals(hdrError.get(0).getCssValue("margin"), "2px 0px 4px");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyLCECheckboxesCOCO(String state){
        switch (state){
            case "Selected":
                verifySelectedStateOfCheckboxesCOCO();
                break;
            case "Hover":
                verifyHoverStateOfCheckboxesCOCO();
                break;
            case "Focus":
                verifyFocusStateOfCheckboxesCOCO();
                break;
            case "Not Selected":
                verifyNotSelectedStateOfCheckboxesCOCO();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + state);
        }
    }

    public void verifyNotSelectedStateOfCheckboxesCOCO() {
        basicActions.waitForElementListToBePresent(checkboxesLCE, 15);
        for (int i = 0; i < checkboxesLCE.size(); i++) {
            WebElement element1 = checkboxesLCE.get(i);
            WebElement element2 = boxesLCE.get(i);
            //basicActions.wait(100);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container"));
            //softAssert.assertEquals(element1.getCssValue("width"), "40px");
            //softAssert.assertEquals(element1.getCssValue("height"), "40px");
            softAssert.assertEquals(element1.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element1.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element1.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element1.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element1.getCssValue("border"), "1px solid rgb(55, 55, 55)");
            softAssert.assertAll();
            element1.click();
            basicActions.wait(100);
        }
    }

    public void verifyFocusStateOfCheckboxesCOCO() {
        basicActions.waitForElementListToBePresent(checkboxesLCE, 15);
        for (int i = 0; i < checkboxesLCE.size(); i++) {
            WebElement element = checkboxesLCE.get(i);
            element.sendKeys(Keys.SHIFT);
            basicActions.wait(200);
            //softAssert.assertEquals(element.getCssValue("width"), "40px");
            //softAssert.assertEquals(element.getCssValue("height"), "40px");
            softAssert.assertEquals(element.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertEquals(element.getCssValue("box-shadow"), "rgb(112, 163, 0) 0px 0px 7px 3px");
            softAssert.assertAll();
            element.click();
            basicActions.wait(200);
        }
    }

    public void verifyHoverStateOfCheckboxesCOCO() {
        basicActions.waitForElementListToBePresent(checkboxesLCE, 15);
        for (int i = 0; i < checkboxesLCE.size(); i++) {
            WebElement element = checkboxesLCE.get(i);
            actions.moveToElement(element).perform();
            basicActions.wait(300);
            //softAssert.assertEquals(element.getCssValue("width"), "40px");
            //softAssert.assertEquals(element.getCssValue("height"), "40px");
            softAssert.assertEquals(element.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element.getCssValue("background-color"), "rgba(0, 0, 0, 0)");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertAll();
            element.click();
            basicActions.wait(300);
        }
    }

    public void verifySelectedStateOfCheckboxesCOCO() {
        basicActions.waitForElementListToBePresent(checkboxesLCE, 15);
        for (int i = 0; i < checkboxesLCE.size(); i++) {
            WebElement element1 = checkboxesLCE.get(i);
            WebElement element2 = boxesLCE.get(i);
            element1.click();
            basicActions.wait(200);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container checked"));
            //softAssert.assertEquals(element1.getCssValue("width"), "40px");
            //softAssert.assertEquals(element1.getCssValue("height"), "40px");
            softAssert.assertEquals(element1.getCssValue("font-size"), "20px");
            softAssert.assertEquals(element1.getCssValue("border-radius"), "4px");
            softAssert.assertEquals(element1.getCssValue("border-color"), "rgb(112, 163, 0)");
            softAssert.assertEquals(element1.getCssValue("background-color"), "rgba(112, 163, 0, 1)");
            softAssert.assertEquals(element1.getCssValue("color"), "rgba(255, 255, 255, 1)");
            softAssert.assertEquals(element1.getCssValue("border"), "1px solid rgb(112, 163, 0)");
            softAssert.assertAll();
            basicActions.wait(200);
        }
    }
}