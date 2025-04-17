package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.*;
import java.util.stream.Collectors;

public class TaxStatusPage {
    private BasicActions basicActions;
    Actions action;
    public TaxStatusPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        action = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    Actions actions = new Actions(WebDriverManager.getDriver());

    SoftAssert softAssert = new SoftAssert();

    @FindBy(css = ".container .header-1")
    WebElement existingTaxStatusHeader;

    @FindBy(css = ".header-3.text-center.content-center.ng-star-inserted a")
    WebElement helpTaxStatusHeader;

    @FindBy(css = "lib-checkbox-control label")
    List<WebElement> checkboxContainersTax;

    @FindBy(css = "lib-checkbox-control button")
    List<WebElement> checkboxesTax;

    @FindBy(xpath = "//span[contains(text(), 'Please select one of the options below')]")
    WebElement englishErrorTxt;

    @FindBy(xpath = "//span[contains(text(), 'Seleccione una de las opciones siguientes')]")
    WebElement spanishErrorTxt;

    @FindBy(xpath = "//lib-input-error/lib-error-msg/div/span")
    WebElement someoneElseErrorTxt;

    @FindBy(css = "#ELIG-taxStatus-claimedAsDependent-container span")
    WebElement claimedAsDependentTxt;

    @FindBy(css = "#ELIG-taxStatus-claimedAsDependent-container .row.error-row span")
    WebElement claimedAsDependentsErrorTxt;

    @FindBy(css = "#ELIG-taxStatus-claimedAsDependent-help")
    WebElement claimedAsDependentHlpIcon;

    @FindBy(id = "ELIG-taxStatus-claimedAsDependent-yesButton")
    WebElement claimedAsDependentYes;

    @FindBy(xpath = "//*[@id='ELIG-taxStatus-claimedAsDependent-container']//lib-option-radio-buttons//label[1]")
    WebElement claimedAsDependentYesTxt;

    @FindBy(id = "ELIG-taxStatus-claimedAsDependent-noButton")
    WebElement claimedAsDependentNo;

    @FindBy(xpath = "//*[@id='ELIG-taxStatus-claimedAsDependent-container']//lib-option-radio-buttons//label[2]")
    WebElement claimedAsDependentNoTxt;

    @FindBy(css = "#ELIG-taxStatus-willFile-container span")
    WebElement willFileTaxReturnTxt;

    @FindBy(css = "#ELIG-taxStatus-willFile-container .row.error-row span")
    WebElement willFileTaxReturnErrorTxt;

    @FindBy(id = "ELIG-taxStatus-willFile-yesButton")
    WebElement willFileTaxReturnYes;

    @FindBy(xpath = "//*[@id='ELIG-taxStatus-willFile-container']//lib-option-radio-buttons//label[1]")
    WebElement willFileTaxReturnYesTxt;

    @FindBy(id = "ELIG-taxStatus-willFile-noButton")
    WebElement willFileTaxReturnNo;

    @FindBy(xpath = "//*[@id='ELIG-taxStatus-willFile-container']//lib-option-radio-buttons//label[2]")
    WebElement willFileTaxReturnNoTxt;

    @FindBy(css = "#ELIG-taxStatus-taxFilingStatus-container label")
    WebElement filingStatusTxt;

    @FindBy(css = "#ELIG-taxStatus-taxFilingStatus-container .row.error-row span")
    WebElement filingStatusErrorTxt;

    @FindBy(css = "#ELIG-taxStatus-taxFilingStatus")
    WebElement filingStatusDpdTxt;

    @FindBy(css = ".c4-input select option")
    List<WebElement> filingStatusDpd;

    @FindBy(css = "#ELIG-taxStatus-exceptional-container label")
    WebElement exceptionalCircumstancesTxt;

    @FindBy(css = "#ELIG-taxStatus-exceptional-help")
    WebElement exceptionalCircumstancesHlpIcon;

    @FindBy(css = "#ELIG-taxStatus-willClaimDependents-container span")
    WebElement willClaimDependentsTxt;

    @FindBy(css = "#ELIG-taxStatus-willClaimDependents-container .row.error-row span")
    WebElement willClaimDependentsErrorTxt;

    @FindBy(css = "#ELIG-taxStatus-willClaimDependents-help")
    WebElement claimingDependentHlpIcon;

    @FindBy(id = "ELIG-taxStatus-willClaimDependents-yesButton")
    WebElement willClaimDependentsYes;

    @FindBy(xpath = "//*[@id='ELIG-taxStatus-willClaimDependents-container']//lib-option-radio-buttons//label[1]")
    WebElement willClaimDependentsYesTxt;

    @FindBy(id = "ELIG-taxStatus-willClaimDependents-noButton")
    WebElement willClaimDependentsNo;

    @FindBy(xpath = "//*[@id='ELIG-taxStatus-willClaimDependents-container']//lib-option-radio-buttons//label[2]")
    WebElement willClaimDependentsNoTxt;
    
    @FindBy(css = "app-member-multi-select > div > div > span")
    WebElement whoClaimedTxt;

    @FindBy(css = "app-member-multi-select > lib-list-error lib-error-msg span")
    WebElement whoClaimedErrorTxt;

    @FindBy(css = "#-container button")
    List<WebElement> whoClaimedBtn;

    @FindBy(css = "#-container span")
    List<WebElement> whoClaimedMemNameTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-container span")
    WebElement filingJointlyWithTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-container .row.error-row span")
    WebElement filingJointlyWithErrorTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-container label")
    List<WebElement> filingJointlyWithRadioTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-container input")
    List<WebElement> filingJointlyWithRadio;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-container .row.label-row label")
    WebElement whoClaimedAsDependentsTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-container .row.error-row span")
    WebElement whoClaimedAsDependentsErrorTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-container .row.input-row label")
    List<WebElement> whoClaimedAsDependentsRadioTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-container .row.input-row label input")
    List<WebElement> whoClaimedAsDependentsRadio;

    @FindBy(css = "app-new-member span")
    WebElement enterNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-firstName-container label")
    WebElement claimFirstNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-firstName")
    WebElement claimFirstNameInput;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-firstName-container .row.error-row lib-error-msg span")
    WebElement claimFirstNameError;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-middleName-container label")
    WebElement claimMiddleNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-middleName")
    WebElement claimMiddleNameInput;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-lastName-container label")
    WebElement claimLastNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-lastName")
    WebElement claimLastNameInput;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-lastName-container .row.error-row lib-error-msg span")
    WebElement claimLastNameError;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-suffix-container label")
    WebElement claimSuffixNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-suffix")
    WebElement claimSuffixNameDpd;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-dob-container label")
    WebElement claimDobNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-dob")
    WebElement claimDobNameInput;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-dob-container .row.error-row lib-error-msg span")
    WebElement claimDobNameError;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-firstName-container label")
    WebElement filingFirstNameTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-firstName")
    WebElement filingFirstNameInput;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-firstName-container .row.error-row lib-error-msg span")
    WebElement filingFirstNameError;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-middleName-container label")
    WebElement filingMiddleNameTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-middleName")
    WebElement filingMiddleNameInput;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-lastName-container label")
    WebElement filingLastNameTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-lastName")
    WebElement filingLastNameInput;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-lastName-container .row.error-row lib-error-msg span")
    WebElement filingLastNameError;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-suffix-container label")
    WebElement filingSuffixNameTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-suffix")
    WebElement filingSuffixNameDpd;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-dob-container label")
    WebElement filingDobNameTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-dob")
    WebElement filingDobNameInput;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-dob-container .row.error-row lib-error-msg span")
    WebElement filingDobNameError;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-firstName-container label")
    WebElement claimedFirstNameTxt;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-firstName")
    WebElement claimedFirstNameInput;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-firstName-container .row.error-row lib-error-msg span")
    WebElement claimedFirstNameError;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-middleName-container label")
    WebElement claimedMiddleNameTxt;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-middleName")
    WebElement claimedMiddleNameInput;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-lastName-container label")
    WebElement claimedLastNameTxt;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-lastName")
    WebElement claimedLastNameInput;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-lastName-container .row.error-row lib-error-msg span")
    WebElement claimedLastNameError;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-suffix-container label")
    WebElement claimedSuffixNameTxt;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-suffix")
    WebElement claimedSuffixNameDpd;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-dob-container label")
    WebElement claimedDobNameTxt;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-dob")
    WebElement claimedDobNameInput;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-dob-container .row.error-row lib-error-msg span")
    WebElement claimedDobNameError;

    @FindBy(id = "ELIG-taxStatus-nav-GoBack")
    WebElement goBackBtn;

    @FindBy(id = "ELIG-taxStatus-nav-SaveAndContinue")
    WebElement saveAndContinueBtn;

    @FindBy(css = "#Help\\.Button")
    WebElement sideHelpBtn;

    @FindBy(css = ".desktop-help .header-close-link")
    WebElement closeHelpBtn;

    @FindBy(css = ".desktop-help .c4-text-body-200")
    WebElement helpHdr;

    @FindBy(css = ".desktop-help .title.c4-type-header-sm")
    WebElement helpSubHdr;

    @FindBy(css = ".help-main-content strong")
    List<WebElement> helpContentHdr;

    @FindBy(css = ".help-main-content p")
    List<WebElement> helpContentTxt;

    @FindBy(css = ".help-footer")
    WebElement helpFooterTxt;

    @FindBy(css = ".help-footer a")
    WebElement helpFooterLnk;

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinnerOverlay;

    public void selectClaimedAsDependent(String claimedAsDependent){
        basicActions.waitForElementToBeClickable(helpTaxStatusHeader, 20);
        switch (claimedAsDependent) {
            case "Yes":
                basicActions.waitForElementToBeClickable(claimedAsDependentYes, 20);
                basicActions.click(claimedAsDependentYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(claimedAsDependentNo, 20);
                basicActions.click(claimedAsDependentNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + claimedAsDependent);
        }
    }

    public void selectWillFileTaxReturn(String willFile){
        basicActions.wait(50);
        switch (willFile) {
            case "Yes":
                basicActions.waitForElementToBeClickable(willFileTaxReturnYes, 20);
                basicActions.click(willFileTaxReturnYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(willFileTaxReturnNo, 20);
                basicActions.click(willFileTaxReturnNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + willFile);
        }
    }

    public void selectFilingStatus(String option) {
        basicActions.wait(50);
        basicActions.waitForElementListToBePresent(filingStatusDpd, 50);

        switch (option) {
            case "Select Option":
                filingStatusDpd.get(0).click();
                break;
            case "Married filing jointly":
                filingStatusDpd.get(1).click();
                break;
            case "Married filing single":
                filingStatusDpd.get(2).click();
                break;
            case "Head of household":
                filingStatusDpd.get(3).click();
                break;
            case "Single":
                filingStatusDpd.get(4).click();
                break;
            case "Qualified widow(er)":
                filingStatusDpd.get(5).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + option);
        }
    }

    public void selectFilingJointlyWithOption(String filingJointlyOption) {
        basicActions.waitForElementToDisappear( spinner,50 );
        basicActions.wait(50);
        basicActions.waitForElementListToBePresentWithRetries(filingJointlyWithRadio, 50);
        boolean optionSelected = false;
        for (int i = 0; i < filingJointlyWithRadio.size(); i++) {
            int adjustedIndex = i + 1;
            if (adjustedIndex >= filingJointlyWithRadioTxt.size()) {
                throw new IndexOutOfBoundsException("Adjusted index " + adjustedIndex + " out of bounds for filingJointlyWithRadioTxt size " + filingJointlyWithRadioTxt.size());
            }
            String radioText = filingJointlyWithRadioTxt.get(adjustedIndex).getText().trim();
            if (radioText.toLowerCase().startsWith(filingJointlyOption.toLowerCase())) {
                filingJointlyWithRadio.get(i).click();
                optionSelected = true;
                break;
            }
        }
        if (!optionSelected) {
            throw new IllegalArgumentException("Invalid option or option not found: " + filingJointlyOption);
        }
    }

    public void enterFilingJointlyWithEnterTheNameQuestion(List<Map<String, String>> nameData) {
        filingFirstNameInput.sendKeys(nameData.get(0).get("First Name"));
        String middleName = nameData.get(0).get("Middle Name");
        if (middleName != null && !middleName.isEmpty()) {
            filingMiddleNameInput.sendKeys(middleName);
        }
        filingLastNameInput.sendKeys(nameData.get(0).get("Last Name"));
        String suffix = nameData.get(0).get("Suffix");
        if (suffix != null && !suffix.isEmpty()) {
            filingSuffixNameDpd.sendKeys(suffix);
        }
        filingDobNameInput.sendKeys(nameData.get(0).get("DOB"));
    }

    public void selectWillClaimDependents(String willFile){
        basicActions.wait(50);
        switch (willFile) {
            case "Yes":
                basicActions.waitForElementToBeClickable(willClaimDependentsYes, 20);
                basicActions.click(willClaimDependentsYes);
                break;
            case "No":
                basicActions.waitForElementToBeClickable(willClaimDependentsNo, 20);
                basicActions.click(willClaimDependentsNo);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + willFile);
        }
    }

    public void selectWhoWillClaimYou(String memPrefix) {
        basicActions.wait(50);
        WebElement selectMember = basicActions.getDriver().findElement(By.xpath("//*[contains(text(), '" + memPrefix + "')]/input"));
        selectMember.click();
    }

    public void clickSaveAndContinue(){
        basicActions.wait(250);
        basicActions.waitForElementToDisappear(spinner,60);
        basicActions.waitForElementToDisappear(spinnerOverlay,60);
        basicActions.waitForElementToBePresentWithRetries(existingTaxStatusHeader, 60);
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueBtn, 60);
        basicActions.scrollToElement(saveAndContinueBtn);
        saveAndContinueBtn.click();
    }

    public void clickGoBack(){
        basicActions.waitForElementToBePresentWithRetries(existingTaxStatusHeader, 40);
        basicActions.waitForElementToBeClickableWithRetries(goBackBtn, 20);
        basicActions.scrollToElement(goBackBtn);
        goBackBtn.click();
    }

    public void enterDataEnterTheNameQuestion(List<Map<String, String>> nameData) {
        claimFirstNameInput.sendKeys(nameData.get(0).get("First Name"));
        String middleName = nameData.get(0).get("Middle Name");
        if (middleName != null && !middleName.isEmpty()) {
            claimMiddleNameInput.sendKeys(middleName);
        }
        claimLastNameInput.sendKeys(nameData.get(0).get("Last Name"));
        String suffix = nameData.get(0).get("Suffix");
        if (suffix != null && !suffix.isEmpty()) {
            claimSuffixNameDpd.sendKeys(suffix);
        }
        claimDobNameInput.sendKeys(nameData.get(0).get("DOB"));
    }

    public void selectWhoWillBeClaimed(String memPrefix) {
        basicActions.waitForElementToDisappear( spinner, 40);
        WebElement selectMember = basicActions.getDriver().findElement(By.xpath("//span[contains(text(), '" + memPrefix + "')]"));
        selectMember.click();
    }

    public void checkExceptionalCircumstances() {
        basicActions.waitForElementToBePresent(exceptionalCircumstancesTxt,10);
        exceptionalCircumstancesTxt.click();
    }

    public void enterWhoWillBeClaimedDataEnterTheNameQuestion(List<Map<String, String>> nameData) {
        claimedFirstNameInput.sendKeys(nameData.get(0).get("First Name"));
        String middleName = nameData.get(0).get("Middle Name");
        if (middleName != null && !middleName.isEmpty()) {
            claimedMiddleNameInput.sendKeys(middleName);
        }
        claimedLastNameInput.sendKeys(nameData.get(0).get("Last Name"));
        String suffix = nameData.get(0).get("Suffix");
        if (suffix != null && !suffix.isEmpty()) {
            claimedSuffixNameDpd.sendKeys(suffix);
        }
        claimedDobNameInput.sendKeys(nameData.get(0).get("DOB"));
    }

    public void enterDobForSomeoneElse(String dobDate) {
        basicActions.wait(50);
        WebElement dobInput = basicActions.getDriver().findElement(By.xpath("//input[@type='date']"));
        basicActions.waitForElementToBePresent(dobInput,10);
        String dateValue = "";
        if ("Partial".equalsIgnoreCase(dobDate)) {
            dateValue = "0615"+Keys.DELETE;
        }
        else {
            dateValue = basicActions.getDateBasedOnRequirement(dobDate);
        }
        dobInput.sendKeys(dateValue);
    }

    public void clickHelp(String helpBtn) {
        switch (helpBtn){
            case "Header":
                basicActions.waitForElementToBePresent(helpTaxStatusHeader,10);
                helpTaxStatusHeader.click();
                break;
            case "Side":
                basicActions.waitForElementToBePresent(sideHelpBtn,10);
                sideHelpBtn.click();
                break;
            case "Close":
                basicActions.waitForElementToBePresent(closeHelpBtn,10);
                closeHelpBtn.click();
                break;
            case "Claimed as Dependent":
                basicActions.waitForElementToBePresent(claimedAsDependentHlpIcon,10);
                claimedAsDependentHlpIcon.click();
                break;
            case "Exceptional Circumstances":
                basicActions.waitForElementToBePresent(exceptionalCircumstancesHlpIcon,10);
                exceptionalCircumstancesHlpIcon.click();
                break;
            case "Claiming Dependent":
                basicActions.waitForElementToBePresent(claimingDependentHlpIcon,10);
                claimingDependentHlpIcon.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + helpBtn);
        }
    }

    public void clickHelpContactUs() {
        basicActions.waitForElementToBePresent(helpFooterLnk,10);
        basicActions.scrollToElement(helpFooterLnk);
        helpFooterLnk.click();
    }


    /////////////////////////////////// Validation methods ///////////////////////////////////

    public void verifyTaxCheckboxes(String state){
        switch (state){
            case "Selected":
                verifySelectedStateOfCheckboxes();
                break;
            case "Hover":
                verifyHoverStateOfCheckboxes();
                break;
            case "Focus":
                verifyFocusStateOfCheckboxes();
                break;
            case "Not Selected":
                verifyNotSelectedStateOfCheckboxesCOCO();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + state);
        }
    }

    public void verifyNotSelectedStateOfCheckboxesCOCO() {
        basicActions.waitForElementListToBePresent(checkboxesTax, 15);
        for (int i = 0; i < checkboxesTax.size(); i++) {
            WebElement element1 = checkboxesTax.get(i);
            WebElement element2 = checkboxContainersTax.get(i);
            basicActions.wait(100);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container"));
            softAssert.assertEquals(element1.getCssValue("width"), "32px");
            softAssert.assertEquals(element1.getCssValue("height"), "32px");
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

    public void verifyFocusStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(checkboxesTax, 15);
        for (int i = 0; i < checkboxesTax.size(); i++) {
            WebElement element = checkboxesTax.get(i);
            element.sendKeys(Keys.SHIFT);
            basicActions.wait(200);
            softAssert.assertEquals(element.getCssValue("width"), "32px");
            softAssert.assertEquals(element.getCssValue("height"), "32px");
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

    public void verifyHoverStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(checkboxesTax, 15);
        for (int i = 0; i < checkboxesTax.size(); i++) {
            WebElement element = checkboxesTax.get(i);
            actions.moveToElement(element).perform();
            basicActions.wait(300);
            softAssert.assertEquals(element.getCssValue("width"), "32px");
            softAssert.assertEquals(element.getCssValue("height"), "32px");
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

    public void verifySelectedStateOfCheckboxes() {
        basicActions.waitForElementListToBePresent(checkboxesTax, 15);
        for (int i = 0; i < checkboxesTax.size(); i++) {
            WebElement element1 = checkboxesTax.get(i);
            WebElement element2 = checkboxContainersTax.get(i);
            element1.click();
            basicActions.wait(200);
            softAssert.assertTrue(element2.getAttribute("class").equals("checkbox-container checked"));
            softAssert.assertEquals(element1.getCssValue("width"), "32px");
            softAssert.assertEquals(element1.getCssValue("height"), "32px");
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

    public void verifyHeadersTaxStatusPage(String memPrefix, String language) {
        basicActions.wait(500);
        basicActions.waitForElementToBePresentWithRetries(existingTaxStatusHeader, 60);
        basicActions.waitForElementToBePresent(saveAndContinueBtn, 60);

        String expectedTextHeader = "";
        String expectedTextHelp = "";
        switch (language) {
            case "English":
                expectedTextHeader = "Tax Status: ";
                expectedTextHelp = "Help me understand this page";
                break;
            case "Spanish":
                expectedTextHeader = "Situaci\u00F3n fiscal: ";
                expectedTextHelp = "Ayuda para entender esta p\u00E1gina";
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }

        String member = basicActions.getFullNameWithPrefix(memPrefix);
        expectedTextHeader += member;

        softAssert.assertTrue(existingTaxStatusHeader.getText().equalsIgnoreCase(expectedTextHeader), "The text does not match! Expected: " + expectedTextHeader + " but found: " + existingTaxStatusHeader.getText());
        softAssert.assertTrue(helpTaxStatusHeader.getText().equals(expectedTextHelp), "The text does not match! Expected: " + expectedTextHelp + " but found: " + helpTaxStatusHeader.getText());
        softAssert.assertAll();
    }

    public void verifyWillYouBeClaimedAsDependentQuestion(String memPrefix, String language) {
        basicActions.waitForElementToBePresent(claimedAsDependentTxt, 15);

        String expectedQuestionText = "";
        if ("primary".equalsIgnoreCase(memPrefix)) {
            expectedQuestionText = language.equalsIgnoreCase("English")
                    ? "Will you be claimed as a dependent on someone else's tax return next year?"
                    : "\u00BFSe presentar\u00E1 a como dependiente en la declaraci\u00F3n de impuestos de otra persona el pr\u00F3ximo a\u00F1o?";
        } else {
            expectedQuestionText = language.equalsIgnoreCase("English")
                    ? "Will "+basicActions.getMemFirstNames(memPrefix)+" be claimed as a dependent on someone else's tax return next year?"
                    : "\u00BFSe presentar\u00E1 a como dependiente en la declaraci\u00F3n de impuestos de otra persona el pr\u00F3ximo a\u00F1o?";
        }
        softAssert.assertEquals(claimedAsDependentTxt.getText(), expectedQuestionText, "Mismatch in claimed as dependent question text.");
        switch (language) {
            case "English":
                softAssert.assertTrue(claimedAsDependentHlpIcon.getAttribute("class").contains("help-icon"), "Found: " + claimedAsDependentHlpIcon.getAttribute("class"));
                softAssert.assertEquals(claimedAsDependentYesTxt.getText(), "Yes");
                softAssert.assertEquals(claimedAsDependentNoTxt.getText(), "No");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertTrue(claimedAsDependentHlpIcon.getAttribute("class").contains("help-icon"), "Found: " + claimedAsDependentHlpIcon.getAttribute("class"));
                softAssert.assertEquals(claimedAsDependentYesTxt.getText(), "S\u00ED");
                softAssert.assertEquals(claimedAsDependentNoTxt.getText(), "No");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyWillYouBeClaimedAsDependentAnswers(String yesStatus, String noStatus){
        basicActions.waitForElementToBePresent(claimedAsDependentYes,20);
        switch (yesStatus){
            case "is":
                softAssert.assertTrue(claimedAsDependentYes.isSelected());
                softAssert.assertAll();
                break;
            case "is not":
                softAssert.assertFalse(claimedAsDependentYes.isSelected());
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + yesStatus);
        }
        switch (noStatus){
            case "is":
                softAssert.assertTrue(claimedAsDependentNo.isSelected());
                softAssert.assertAll();
                break;
            case "is not":
                softAssert.assertFalse(claimedAsDependentNo.isSelected());
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + noStatus);
        }
    }

    public void verifyClaimedDependentErrors(String memPrefix, String language) {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(claimedAsDependentTxt,10);

        String questionTxt;
        String errorTxt;
        String yesTxt;
        String noTxt;
        switch (language) {
            case "English":
                if (memPrefix.equals("Primary")) {
                    questionTxt = "Will you be claimed as a dependent on someone else's tax return next year?";
                } else {
                    questionTxt = "Will "+basicActions.getMemFirstNames(memPrefix)+" be claimed as a dependent on someone else's tax return next year?";
                }
                errorTxt = "Please select one of the options below";
                yesTxt = "Yes";
                noTxt = "No";
                break;
            case "Spanish":
                questionTxt = "\u00BFSe presentar\u00E1 a como dependiente en la declaraci\u00F3n de impuestos de otra persona el pr\u00F3ximo a\u00F1o?";
                errorTxt = "Seleccione una de las opciones siguientes";
                yesTxt = "S\u00ED";
                noTxt = "No";
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
        softAssert.assertEquals(claimedAsDependentTxt.getText(), questionTxt);
        softAssert.assertEquals(claimedAsDependentTxt.getCssValue("font-weight"), "700","Question Text is not as expected");
        softAssert.assertEquals(claimedAsDependentTxt.getCssValue("font-size"), "16px","Question Text is not as expected");
        softAssert.assertEquals(claimedAsDependentTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Question Text is not as expected");
        softAssert.assertEquals(claimedAsDependentTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Question Text is not as expected");
        softAssert.assertEquals(claimedAsDependentsErrorTxt.getText(), errorTxt);
        softAssert.assertEquals(claimedAsDependentsErrorTxt.getCssValue("font-weight"), "400","Error Text is not as expected");
        softAssert.assertEquals(claimedAsDependentsErrorTxt.getCssValue("font-size"), "14px","Error Text is not as expected");
        softAssert.assertEquals(claimedAsDependentsErrorTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Error Text is not as expected");
        softAssert.assertEquals(claimedAsDependentsErrorTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Error Text is not as expected");
        softAssert.assertEquals(claimedAsDependentYesTxt.getText(), yesTxt);
        softAssert.assertEquals(claimedAsDependentYesTxt.getCssValue("font-weight"), "700","Yes Text is not as expected");
        softAssert.assertEquals(claimedAsDependentYesTxt.getCssValue("font-size"), "16px","Yes Text is not as expected");
        softAssert.assertEquals(claimedAsDependentYesTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Yes Text is not as expected");
        softAssert.assertEquals(claimedAsDependentYesTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Yes Text is not as expected");
        softAssert.assertEquals(claimedAsDependentNoTxt.getText(), noTxt);
        softAssert.assertEquals(claimedAsDependentNoTxt.getCssValue("font-weight"), "700","No Text is not as expected");
        softAssert.assertEquals(claimedAsDependentNoTxt.getCssValue("font-size"), "16px","No Text is not as expected");
        softAssert.assertEquals(claimedAsDependentNoTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","No Text is not as expected");
        softAssert.assertEquals(claimedAsDependentNoTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","No Text is not as expected");
        softAssert.assertAll();
    }

    public void verifyFileTaxReturnQuestion(String memPrefix,String language){
        basicActions.waitForElementToBePresent(willFileTaxReturnTxt, 15);
        String expectedQuestionText = "";
        if ("primary".equalsIgnoreCase(memPrefix)) {
            expectedQuestionText = language.equalsIgnoreCase("English")
                    ? "Will you file a federal income tax return next year?"
                    : "\u00BFPresentar\u00E1 una declaraci\u00F3n de impuesto federal sobre los ingresos el pr\u00F3ximo a\u00F1o?";
        } else {
            expectedQuestionText = language.equalsIgnoreCase("English")
                    ? "Will "+basicActions.getMemFirstNames(memPrefix)+" file a federal income tax return next year?"
                    : "\u00BF" + basicActions.getMemFirstNames(memPrefix) +" presentar\u00E1 una declaraci\u00F3n de impuesto federal sobre los ingresos el pr\u00F3ximo a\u00F1o?";
        }
        softAssert.assertEquals(willFileTaxReturnTxt.getText(), expectedQuestionText);
        switch (language) {
            case "English":
                softAssert.assertEquals(willFileTaxReturnYesTxt.getText(), "Yes");
                softAssert.assertEquals(willFileTaxReturnNoTxt.getText(), "No");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(willFileTaxReturnYesTxt.getText(), "S\u00ED");
                softAssert.assertEquals(willFileTaxReturnNoTxt.getText(), "No");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyFileTaxReturnErrors(String memPrefix, String language) {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(willFileTaxReturnTxt,10);

        String questionTxt;
        String errorTxt;
        String yesTxt;
        String noTxt;
        switch (language) {
            case "English":
                if (memPrefix.equals("Primary")) {
                    questionTxt = "Will you file a federal income tax return next year?";
                } else {
                    questionTxt = "Will "+basicActions.getMemFirstNames(memPrefix)+" file a federal income tax return next year?";
                }
                errorTxt = "Please select one of the options below";
                yesTxt = "Yes";
                noTxt = "No";
                break;
            case "Spanish":
                if (memPrefix.equals("Primary")) {
                    questionTxt = "\u00BFPresentar\u00E1 una declaraci\u00F3n de impuesto federal sobre los ingresos el pr\u00F3ximo a\u00F1o?";
                } else {
                    questionTxt = "\u00BF" + basicActions.getMemFirstNames(memPrefix) +" presentar\u00E1 una declaraci\u00F3n de impuesto federal sobre los ingresos el pr\u00F3ximo a\u00F1o?";
                }
                errorTxt = "Seleccione una de las opciones siguientes";
                yesTxt = "S\u00ED";
                noTxt = "No";
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
        softAssert.assertEquals(willFileTaxReturnTxt.getText(), questionTxt);
        softAssert.assertEquals(willFileTaxReturnTxt.getCssValue("font-weight"), "700","Question Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnTxt.getCssValue("font-size"), "16px","Question Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Question Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Question Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnErrorTxt.getText(), errorTxt);
        softAssert.assertEquals(willFileTaxReturnErrorTxt.getCssValue("font-weight"), "400","Error Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnErrorTxt.getCssValue("font-size"), "14px","Error Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnErrorTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Error Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnErrorTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Error Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnYesTxt.getText(), yesTxt);
        softAssert.assertEquals(willFileTaxReturnYesTxt.getCssValue("font-weight"), "700","Yes Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnYesTxt.getCssValue("font-size"), "16px","Yes Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnYesTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Yes Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnYesTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Yes Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnNoTxt.getText(), noTxt);
        softAssert.assertEquals(willFileTaxReturnNoTxt.getCssValue("font-weight"), "700","No Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnNoTxt.getCssValue("font-size"), "16px","No Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnNoTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","No Text is not as expected");
        softAssert.assertEquals(willFileTaxReturnNoTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","No Text is not as expected");
        softAssert.assertAll();
    }

    public void verifyFileTaxReturnAnswers(String yesStatus, String noStatus){
        basicActions.waitForElementToBePresent(willFileTaxReturnYes,20);
        switch (yesStatus){
            case "is":
                softAssert.assertTrue(willFileTaxReturnYes.isSelected());
                softAssert.assertAll();
                break;
            case "is not":
                softAssert.assertFalse(willFileTaxReturnYes.isSelected());
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + yesStatus);
        }
        switch (noStatus){
            case "is":
                softAssert.assertTrue(willFileTaxReturnNo.isSelected());
                softAssert.assertAll();
                break;
            case "is not":
                softAssert.assertFalse(willFileTaxReturnNo.isSelected());
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + noStatus);
        }
    }

    public void verifyWhoWillClaimYouQuestion(String memPrefix, String language) {
        basicActions.waitForElementToBePresent(whoClaimedAsDependentsTxt, 15);
        List<String> allMemNames = basicActions.getAllMemNames();
        List<String> filteredMemNames = allMemNames.stream().filter(name -> !name.startsWith(memPrefix)).toList();

        String expectedQuestionText = "";
        String someoneElseText = "";

        if ("primary".equalsIgnoreCase(memPrefix)) {
            switch (language) {
                case "English":
                    expectedQuestionText = "Who will claim you as a dependent?";
                    someoneElseText = "Someone else";
                    break;
                case "Spanish":
                    expectedQuestionText = "\u00BFQui\u00E9n reclamar\u00E1 a como dependiente?";
                    someoneElseText = "Otra persona";
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported language: " + language);
            }
        } else {
            switch (language) {
                case "English":
                    expectedQuestionText = "Who will claim "+basicActions.getMemFirstNames(memPrefix)+" as a dependent?";
                    someoneElseText = "Someone else";
                    break;
                case "Spanish":
                    expectedQuestionText = "\u00BFA qui\u00E9n reclamar\u00E1 como dependientes?";
                    someoneElseText = "Otra persona";
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported language: " + language);
            }
        }
        softAssert.assertEquals(whoClaimedAsDependentsTxt.getText(), expectedQuestionText, "The question text does not match the expected value.");
        List<String> actualMemNames = whoClaimedAsDependentsRadioTxt.stream().map(WebElement::getText).collect(Collectors.toList());
        int startIndex = -1;
        for (int i = 0; i < actualMemNames.size(); i++) {
            if (filteredMemNames.contains(actualMemNames.get(i))) {
                startIndex = i;
                break;
            }
        }
        if (startIndex != -1) {
            actualMemNames = actualMemNames.subList(startIndex, actualMemNames.size());
        } else {
            throw new AssertionError("No expected member names found in the radio options.");
        }
        softAssert.assertEquals(actualMemNames.get(actualMemNames.size() - 1), someoneElseText, "'Someone else' option text does not match.");
        Set<String> expectedSet = new HashSet<>(filteredMemNames);
        Set<String> actualSet = new HashSet<>(actualMemNames.subList(0, actualMemNames.size() - 1));
        softAssert.assertEquals(actualSet, expectedSet, "Mismatch in radio button member names (order ignored).");
        softAssert.assertAll();
    }

    public void verifyOnlyMemPrefixSelected(String memPrefix) {
        boolean isMemPrefixSelected = false;
        for (int i = 0; i < whoClaimedAsDependentsRadio.size(); i++) {
            WebElement radioButton = whoClaimedAsDependentsRadio.get(i);
            String radioText = whoClaimedAsDependentsRadioTxt.get(i).getText().trim();
            boolean isChecked = radioButton.isSelected();
            if (memPrefix != null && !memPrefix.isEmpty() && radioText.startsWith(memPrefix.trim())) {
                softAssert.assertTrue(isChecked, "Radio button with " + memPrefix + " is not selected.");
                isMemPrefixSelected = true;
            } else {
                softAssert.assertFalse(isChecked, "Radio button at index " + i + " is unexpectedly selected.");
            }
        }
        if (memPrefix != null && !memPrefix.isEmpty()) {
            softAssert.assertTrue(isMemPrefixSelected, "No radio button with memPrefix was selected.");
        }
        softAssert.assertAll();
    }

    public void verifyEnterTheNameQuestion(String memPrefix,String language){
        basicActions.waitForElementToBePresent(enterNameTxt, 15);
        String expectedQuestionText = "";
        if ("primary".equalsIgnoreCase(memPrefix)) {
            expectedQuestionText = language.equalsIgnoreCase("English")
                    ? "Enter the name of who will claim you as a dependent:"
                    : "Ingrese el nombre de la persona que le registrar\u00E1 como dependiente:";
        } else {
            expectedQuestionText = language.equalsIgnoreCase("English")
                    ? "Enter the name of who will claim "+basicActions.getMemFirstNames(memPrefix)+" as a dependent:"
                    : "Ingrese el nombre de la persona que registrar\u00E1 a "+basicActions.getMemFirstNames(memPrefix)+" como dependiente";
        }
        softAssert.assertEquals(enterNameTxt.getText(), expectedQuestionText);
        switch (language) {
            case "English":
                softAssert.assertEquals(claimFirstNameTxt.getText(), "First name");
                softAssert.assertEquals(claimMiddleNameTxt.getText(), "Middle name or initial");
                softAssert.assertEquals(claimLastNameTxt.getText(), "Last name");
                softAssert.assertEquals(claimSuffixNameTxt.getText(), "Suffix");
                softAssert.assertEquals(claimSuffixNameDpd.getText(), "Select Option\n" + "Jr.\n" + "Sr.\n" + "III\n" + "IV");
                softAssert.assertEquals(claimDobNameTxt.getText(), "Date of birth");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(claimFirstNameTxt.getText(), "Nombre");
                softAssert.assertEquals(claimMiddleNameTxt.getText(), "Segundo nombre o inicial");
                softAssert.assertEquals(claimLastNameTxt.getText(), "Apellido(s)");
                softAssert.assertEquals(claimSuffixNameTxt.getText(), "Titulo o tratamiento");
                softAssert.assertEquals(claimSuffixNameDpd.getText(), "Seleccione\n" + "Jr.\n" + "Sr.\n" + "III\n" + "IV");
                softAssert.assertEquals(claimDobNameTxt.getText(), "Fecha de nacimiento");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyWhoWillClaimYouErrors(String memPrefix, String language) {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(whoClaimedAsDependentsTxt,10);
        List<String> allMemNames = basicActions.getAllMemNames();
        List<String> filteredMemNames = allMemNames.stream().filter(name -> !name.startsWith(memPrefix)).toList();

        String questionTxt;
        String errorTxt;
        String someoneElseText;
        switch (language) {
            case "English":
                if (memPrefix.equals("Primary")) {
                    questionTxt = "Who will claim you as a dependent?";
                } else {
                    questionTxt = "Who will claim "+basicActions.getMemFirstNames(memPrefix)+" as a dependent?";
                }
                errorTxt = "Please select one of the options below";
                someoneElseText = "Someone else";
                break;
            case "Spanish":
                if (memPrefix.equals("Primary")) {
                    questionTxt = "\u00BFQui\u00E9n reclamar\u00E1 a como dependiente?";
                } else {
                    questionTxt = "\u00BFA qui\u00E9n reclamar\u00E1 como dependientes?";
                }
                errorTxt = "Seleccione una de las opciones siguientes";
                someoneElseText = "Otra persona";
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
        softAssert.assertEquals(whoClaimedAsDependentsTxt.getText(), questionTxt);
        softAssert.assertEquals(whoClaimedAsDependentsTxt.getCssValue("font-weight"), "700","Question Text is not as expected");
        softAssert.assertEquals(whoClaimedAsDependentsTxt.getCssValue("font-size"), "16px","Question Text is not as expected");
        softAssert.assertEquals(whoClaimedAsDependentsTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Question Text is not as expected");
        softAssert.assertEquals(whoClaimedAsDependentsTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Question Text is not as expected");
        softAssert.assertEquals(whoClaimedAsDependentsErrorTxt.getText(), errorTxt);
        softAssert.assertEquals(whoClaimedAsDependentsErrorTxt.getCssValue("font-weight"), "400","Error Text is not as expected");
        softAssert.assertEquals(whoClaimedAsDependentsErrorTxt.getCssValue("font-size"), "14px","Error Text is not as expected");
        softAssert.assertEquals(whoClaimedAsDependentsErrorTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Error Text is not as expected");
        softAssert.assertEquals(whoClaimedAsDependentsErrorTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Error Text is not as expected");
        for (int i = 0; i < filteredMemNames.size(); i++) {
            softAssert.assertEquals(whoClaimedAsDependentsRadioTxt.get(i).getText(), filteredMemNames.get(i), "Mismatch at radio index: " + (i + 1));
            softAssert.assertEquals(whoClaimedAsDependentsRadioTxt.get(i).getCssValue("font-weight"), "700", "Mismatch at radio index: " + (i + 1));
            softAssert.assertEquals(whoClaimedAsDependentsRadioTxt.get(i).getCssValue("font-size"), "16px", "Mismatch at radio index: " + (i + 1));
            softAssert.assertEquals(whoClaimedAsDependentsRadioTxt.get(i).getCssValue("color"), "rgba(150, 0, 0, 1)", "Mismatch at radio index: " + (i + 1));
            softAssert.assertEquals(whoClaimedAsDependentsRadioTxt.get(i).getCssValue("font-family"), "\"PT Sans\", sans-serif", "Mismatch at radio index: " + (i + 1));
        }
        int someoneElseIndex = filteredMemNames.size();
        if (someoneElseIndex < whoClaimedAsDependentsRadioTxt.size()) {
            softAssert.assertEquals(whoClaimedAsDependentsRadioTxt.get(someoneElseIndex).getText(), someoneElseText, "'Someone else' option text does not match.");
            softAssert.assertEquals(whoClaimedAsDependentsRadioTxt.get(someoneElseIndex).getCssValue("font-weight"), "700", "'Someone else' option mismatch");
            softAssert.assertEquals(whoClaimedAsDependentsRadioTxt.get(someoneElseIndex).getCssValue("font-size"), "16px", "'Someone else' option mismatch");
            softAssert.assertEquals(whoClaimedAsDependentsRadioTxt.get(someoneElseIndex).getCssValue("color"), "rgba(150, 0, 0, 1)", "'Someone else' option mismatch");
            softAssert.assertEquals(whoClaimedAsDependentsRadioTxt.get(someoneElseIndex).getCssValue("font-family"), "\"PT Sans\", sans-serif", "'Someone else' option mismatch");
        } else {
            throw new AssertionError("'Someone else' option is missing in the radio list.");
        }
        softAssert.assertAll();
    }

    public void verifyEnterTheNameAnswers(List<Map<String, String>> nameData) {
        String firstName = nameData.get(0).get("First Name");
        String middleName = nameData.get(0).get("Middle Name");
        String lastName = nameData.get(0).get("Last Name");
        String suffix = nameData.get(0).get("Suffix");
        String dob = nameData.get(0).get("DOB");
        firstName = (firstName != null && !firstName.trim().isEmpty()) ? firstName : null;
        middleName = (middleName != null && !middleName.trim().isEmpty()) ? middleName : null;
        lastName = (lastName != null && !lastName.trim().isEmpty()) ? lastName : null;
        suffix = (suffix != null && !suffix.trim().isEmpty()) ? suffix : null;
        dob = (dob != null && !dob.trim().isEmpty()) ? dob : null;

        softAssert.assertEquals(claimFirstNameInput.getAttribute("value").trim().isEmpty() ? null : claimFirstNameInput.getAttribute("value"), firstName);
        softAssert.assertEquals(claimMiddleNameInput.getAttribute("value").trim().isEmpty() ? null : claimMiddleNameInput.getAttribute("value"), middleName);
        softAssert.assertEquals(claimLastNameInput.getAttribute("value").trim().isEmpty() ? null : claimLastNameInput.getAttribute("value"), lastName);
        softAssert.assertEquals(claimSuffixNameDpd.getAttribute("value").trim().isEmpty() || "0: null".equals(claimSuffixNameDpd.getAttribute("value")) ? null : claimSuffixNameDpd.getAttribute("value"), suffix);
        softAssert.assertEquals(claimDobNameInput.getAttribute("value").trim().isEmpty() ? null : claimDobNameInput.getAttribute("value"), dob);
        softAssert.assertAll();
    }

    public void verifyEnterTheNameErrors(String dateError, String language) {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(claimFirstNameError,10);

        String firstNameErrorTxt;
        String lastNameErrorTxt;
        String dobErrorTxt;
        String firstNameTxt;
        String lastNameTxt;
        String dobTxt;
        switch (language) {
            case "English":
                firstNameErrorTxt = "First name is required";
                lastNameErrorTxt = "Last name is required";
                firstNameTxt = "First name";
                lastNameTxt = "Last name";
                dobTxt = "Date of birth";
                if ("not valid".equals(dateError)) {
                    dobErrorTxt = "Date is not valid";
                } else if ("required".equals(dateError)) {
                    dobErrorTxt = "Date of birth is required";
                } else {
                    throw new IllegalArgumentException("Invalid dateError option: " + dateError);
                }
                break;
            case "Spanish":
                firstNameErrorTxt = "El primer nombre es obligatorio";
                lastNameErrorTxt = "El apellido es obligatorio";
                firstNameTxt = "Nombre";
                lastNameTxt = "Apellido(s)";
                dobTxt = "Fecha de nacimiento";
                if ("not valid".equals(dateError)) {
                    dobErrorTxt = "La fecha no es v\u00E1lida";
                } else if ("required".equals(dateError)) {
                    dobErrorTxt = "La fecha de nacimiento es obligatoria";
                } else {
                    throw new IllegalArgumentException("Invalid dateError option: " + dateError);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
        softAssert.assertEquals(claimFirstNameError.getText(), firstNameErrorTxt);
        softAssert.assertEquals(claimFirstNameError.getCssValue("font-weight"), "400");
        softAssert.assertEquals(claimFirstNameError.getCssValue("font-size"), "14px");
        softAssert.assertEquals(claimFirstNameError.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(claimFirstNameError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(claimLastNameError.getText(), lastNameErrorTxt);
        softAssert.assertEquals(claimLastNameError.getCssValue("font-weight"), "400");
        softAssert.assertEquals(claimLastNameError.getCssValue("font-size"), "14px");
        softAssert.assertEquals(claimLastNameError.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(claimLastNameError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(claimDobNameError.getText(), dobErrorTxt);
        softAssert.assertEquals(claimDobNameError.getCssValue("font-weight"), "400");
        softAssert.assertEquals(claimDobNameError.getCssValue("font-size"), "14px");
        softAssert.assertEquals(claimDobNameError.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(claimDobNameError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(claimFirstNameTxt.getText(), firstNameTxt);
        softAssert.assertEquals(claimFirstNameTxt.getCssValue("font-weight"), "700");
        softAssert.assertEquals(claimFirstNameTxt.getCssValue("font-size"), "16px");
        softAssert.assertEquals(claimFirstNameTxt.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(claimFirstNameTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(claimLastNameTxt.getText(), lastNameTxt);
        softAssert.assertEquals(claimLastNameTxt.getCssValue("font-weight"), "700");
        softAssert.assertEquals(claimLastNameTxt.getCssValue("font-size"), "16px");
        softAssert.assertEquals(claimLastNameTxt.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(claimLastNameTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(claimDobNameTxt.getText(), dobTxt);
        softAssert.assertEquals(claimDobNameTxt.getCssValue("font-weight"), "700");
        softAssert.assertEquals(claimDobNameTxt.getCssValue("font-size"), "16px");
        softAssert.assertEquals(claimDobNameTxt.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(claimDobNameTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
    }

    public void verifySaveBackBtns(String language){
        basicActions.waitForElementToBePresent(enterNameTxt, 15);
        switch (language) {
            case "English":
                verifyContinueAndgoBackBtnsEnglish();
                break;
            case "Spanish":
                verifyContinueAndgoBackBtnsSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyContinueAndgoBackBtnsEnglish() {
        softAssert.assertEquals(goBackBtn.getText(), "Go back");
        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif","Go back font-family");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px","Go back font-size");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700","Go back font-weight");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)","Go back color");
        softAssert.assertEquals(goBackBtn.getCssValue("background-color"), "rgba(252, 252, 252, 1)","Go back background");
        action.moveToElement(goBackBtn).pause(1000L).build().perform();
        softAssert.assertEquals(goBackBtn.getText(), "Go back");
        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif","Go back hover font-family");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px","Go back hover font-size");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700","Go back hover font-weight");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)","Go back hover color");
        softAssert.assertEquals(goBackBtn.getCssValue("background-color"), "rgba(226, 241, 248, 1)","Go back hover background");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif","Save and continue font-family");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px","Save and continue font-size");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700","Save and continue font-weight");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)","Save and continue color");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(26, 112, 179, 1)","Save and continue background");
        action.moveToElement(saveAndContinueBtn).pause(1000L).build().perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif","Save and continue hover font-family");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px","Save and continue hover font-size");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700","Save and continue hover font-weight");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)","Save and continue hover color");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(22, 156, 216, 1)","Save and continue hover background");
        softAssert.assertAll();
    }

    public void verifyContinueAndgoBackBtnsSpanish() {
        softAssert.assertEquals(goBackBtn.getText(), "Volver");
        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif","Go back font-family");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px","Go back font-size");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700","Go back font-weight");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)","Go back color");
        softAssert.assertEquals(goBackBtn.getCssValue("background-color"), "rgba(252, 252, 252, 1)","Go back background");
        action.moveToElement(goBackBtn).pause(1000L).build().perform();
        softAssert.assertEquals(goBackBtn.getText(), "Volver");
        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif","Go back hover font-family");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px","Go back hover font-size");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700","Go back hover font-weight");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)","Go back hover color");
        softAssert.assertEquals(goBackBtn.getCssValue("background-color"), "rgba(226, 241, 248, 1)","Go back hover background");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif","Save and continue font-family");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px","Save and continue font-size");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700","Save and continue font-weight");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)","Save and continue color");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(26, 112, 179, 1)","Save and continue background");
        action.moveToElement(saveAndContinueBtn).pause(1000L).build().perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif","Save and continue hover font-family");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px","Save and continue hover font-size");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700","Save and continue hover font-weight");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(252, 252, 252, 1)","Save and continue hover color");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background-color"), "rgba(22, 156, 216, 1)","Save and continue hover background");
        softAssert.assertAll();
    }

    public void verifySelectTaxFilingStatusQuestion(String language) {
        basicActions.waitForElementToBePresent(filingStatusTxt, 15);
        switch (language) {
            case "English":
                softAssert.assertEquals(filingStatusTxt.getText(), "Select tax filing status");
                softAssert.assertEquals(filingStatusDpd.get(0).getText(), "Select Option");
                softAssert.assertEquals(filingStatusDpd.get(1).getText(), "Married filing jointly");
                softAssert.assertEquals(filingStatusDpd.get(2).getText(), "Married filing separately");
                softAssert.assertEquals(filingStatusDpd.get(3).getText(), "Head of household");
                softAssert.assertEquals(filingStatusDpd.get(5).getText(), "Qualified widow(er) with dependent(s)");
                softAssert.assertEquals(filingStatusDpd.get(4).getText(), "Single");
                softAssert.assertEquals(exceptionalCircumstancesTxt.getText(), "Exceptional circumstances?");
                softAssert.assertTrue(exceptionalCircumstancesHlpIcon.getAttribute("class").contains("help-icon"), "Found "+exceptionalCircumstancesHlpIcon.getAttribute("class"));
                break;
            case "Spanish":
                softAssert.assertEquals(filingStatusTxt.getText(), "Seleccione su estatus de declaraci\u00F3n de impuestos");
                softAssert.assertEquals(filingStatusDpd.get(0).getText(), "Seleccione");
                softAssert.assertEquals(filingStatusDpd.get(1).getText(), "Casados que declaran juntos");
                softAssert.assertEquals(filingStatusDpd.get(2).getText(), "Casados que declaran por separado");
                softAssert.assertEquals(filingStatusDpd.get(3).getText(), "Jefe/a de hogar");
                softAssert.assertEquals(filingStatusDpd.get(4).getText(), "Soltero/a");
                softAssert.assertEquals(filingStatusDpd.get(5).getText(), "Viudo/a calificado con dependiente");
                softAssert.assertEquals(exceptionalCircumstancesTxt.getText(), "Circunstancias excepcionales");
                softAssert.assertTrue(exceptionalCircumstancesHlpIcon.getAttribute("class").contains("help-icon"), "Found "+exceptionalCircumstancesHlpIcon.getAttribute("class"));
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
        softAssert.assertAll();
    }

    public void verifySelectTaxFilingStatusErrors(String language) {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(filingStatusTxt,10);

        String questionTxt;
        String errorTxt;
        String option;
        String option2;
        String option3;
        String option4;
        String option5;
        String option6;
        switch (language) {
            case "English":
                questionTxt = "Select tax filing status";
                errorTxt = "Please select one of the options below";
                option = "Select Option";
                option2 = "Married filing jointly";
                option3 = "Married filing separately";
                option4 = "Head of household";
                option5 = "Single";
                option6 = "Qualified widow(er) with dependent(s)";
                break;
            case "Spanish":
                questionTxt = "Seleccione su estatus de declaraci\u00F3n de impuestos";
                errorTxt = "Seleccione una de las opciones siguientes";
                option = "Seleccione";
                option2 = "Casados que declaran juntos";
                option3 = "Casados que declaran por separado";
                option4 = "Jefe/a de hogar";
                option5 = "Soltero/a";
                option6 = "Viudo/a calificado con dependiente";
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
        softAssert.assertEquals(filingStatusTxt.getText(), questionTxt);
        softAssert.assertEquals(filingStatusTxt.getCssValue("font-weight"), "700","Question Text is not as expected");
        softAssert.assertEquals(filingStatusTxt.getCssValue("font-size"), "16px","Question Text is not as expected");
        softAssert.assertEquals(filingStatusTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Question Text is not as expected");
        softAssert.assertEquals(filingStatusTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Question Text is not as expected");
        softAssert.assertEquals(filingStatusErrorTxt.getText(), errorTxt);
        softAssert.assertEquals(filingStatusErrorTxt.getCssValue("font-weight"), "400","Error Text is not as expected");
        softAssert.assertEquals(filingStatusErrorTxt.getCssValue("font-size"), "14px","Error Text is not as expected");
        softAssert.assertEquals(filingStatusErrorTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Error Text is not as expected");
        softAssert.assertEquals(filingStatusErrorTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Error Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(0).getText(), option);
        softAssert.assertEquals(filingStatusDpd.get(0).getCssValue("font-weight"), "400",option+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(0).getCssValue("font-size"), "16px",option+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(0).getCssValue("color"), "rgba(150, 0, 0, 1)",option+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(0).getCssValue("font-family"), "\"PT Sans\", sans-serif",option+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(1).getText(), option2);
        softAssert.assertEquals(filingStatusDpd.get(1).getCssValue("font-weight"), "400",option2+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(1).getCssValue("font-size"), "16px",option2+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(1).getCssValue("color"), "rgba(150, 0, 0, 1)",option2+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(1).getCssValue("font-family"), "\"PT Sans\", sans-serif",option2+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(2).getText(), option3);
        softAssert.assertEquals(filingStatusDpd.get(2).getCssValue("font-weight"), "400",option3+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(2).getCssValue("font-size"), "16px",option3+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(2).getCssValue("color"), "rgba(150, 0, 0, 1)",option3+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(2).getCssValue("font-family"), "\"PT Sans\", sans-serif",option3+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(3).getText(), option4);
        softAssert.assertEquals(filingStatusDpd.get(3).getCssValue("font-weight"), "400",option4+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(3).getCssValue("font-size"), "16px",option4+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(3).getCssValue("color"), "rgba(150, 0, 0, 1)",option4+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(3).getCssValue("font-family"), "\"PT Sans\", sans-serif",option4+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(4).getText(), option5);
        softAssert.assertEquals(filingStatusDpd.get(4).getCssValue("font-weight"), "400",option5+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(4).getCssValue("font-size"), "16px",option5+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(4).getCssValue("color"), "rgba(150, 0, 0, 1)",option5+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(4).getCssValue("font-family"), "\"PT Sans\", sans-serif",option5+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(5).getText(), option6);
        softAssert.assertEquals(filingStatusDpd.get(5).getCssValue("font-weight"), "400",option6+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(5).getCssValue("font-size"), "16px",option6+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(5).getCssValue("color"), "rgba(150, 0, 0, 1)",option6+" Text is not as expected");
        softAssert.assertEquals(filingStatusDpd.get(5).getCssValue("font-family"), "\"PT Sans\", sans-serif",option6+" Text is not as expected");
        softAssert.assertAll();
    }

    public void verifyFilingJointlyWithQuestion(String memPrefix,String language,List<Map<String, String>> expectedMembers) {
        basicActions.waitForElementToBePresent(filingJointlyWithTxt, 15);
        List<String> expectedMembersList = expectedMembers.stream().map(map -> map.get("ExpectedMembers")).filter(Objects::nonNull).map(basicActions::getMemFirstLastNames).collect(Collectors.toList());
        String expectedQuestionText = "";
        String someoneElseText = "";
        if ("primary".equalsIgnoreCase(memPrefix)) {
            expectedQuestionText = language.equalsIgnoreCase("English")
                    ? "Who will you be filing jointly with?"
                    : "\u00BFCon qui\u00E9n declarar\u00E1 impuestos en conjunto?";
            someoneElseText = language.equalsIgnoreCase("English")
                    ? "Someone else"
                    : "Otra persona";
        } else {
            expectedQuestionText = language.equalsIgnoreCase("English")
                    ? "Who will "+basicActions.getMemFirstNames(memPrefix)+" be filing jointly with?"
                    : "\u00BFCon qui\u00E9n declarar\u00E1 impuestos en conjunto "+basicActions.getMemFirstNames(memPrefix)+"?";
            someoneElseText = language.equalsIgnoreCase("English")
                    ? "Someone else"
                    : "Otra persona";
        }
        softAssert.assertEquals(filingJointlyWithTxt.getText(), expectedQuestionText, "The question text does not match.");
        List<String> actualMemNames = filingJointlyWithRadioTxt.stream().map(WebElement::getText).collect(Collectors.toList());
        int startIndex = -1;
        for (int i = 0; i < actualMemNames.size(); i++) {
            if (expectedMembersList.contains(actualMemNames.get(i))) {
                startIndex = i;
                break;
            }
        }
        if (startIndex != -1) {
            actualMemNames = actualMemNames.subList(startIndex, actualMemNames.size());
        } else {
            throw new AssertionError("No expected member names found in the radio options.");
        }
        softAssert.assertEquals(actualMemNames.get(actualMemNames.size() - 1), someoneElseText, "'Someone else' option is not at the correct position.");
        Set<String> expectedSet = new HashSet<>(expectedMembersList);
        Set<String> actualSet = new HashSet<>(actualMemNames.subList(0, actualMemNames.size() - 1));
        softAssert.assertEquals(actualSet, expectedSet, "Mismatch in radio button member names (order ignored).");
        softAssert.assertAll();
    }

    public void verifyFilingJointlyWithErrors(String memPrefix, String language) {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(filingJointlyWithTxt,10);
        List<String> allMemNames = basicActions.getAllMemNames();
        List<String> filteredMemNames = allMemNames.stream().filter(name -> !name.startsWith(memPrefix)).toList();

        String questionTxt;
        String errorTxt;
        String someoneElseText;
        switch (language) {
            case "English":
                if (memPrefix.equals("Primary")) {
                    questionTxt = "Who will you be filing jointly with?";
                } else {
                    questionTxt = "Who will "+basicActions.getMemFirstNames(memPrefix)+" be filing jointly with?";
                }
                errorTxt = "Please select one of the options below";
                someoneElseText = "Someone else";
                break;
            case "Spanish":
                if (memPrefix.equals("Primary")) {
                    questionTxt = "\u00BFCon qui\u00E9n declarar\u00E1 impuestos en conjunto?";
                } else {
                    questionTxt = "\u00BFCon qui\u00E9n declarar\u00E1 impuestos en conjunto "+basicActions.getMemFirstNames(memPrefix)+"?";
                }
                errorTxt = "Seleccione una de las opciones siguientes";
                someoneElseText = "Otra persona";
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
        softAssert.assertEquals(filingJointlyWithTxt.getText(), questionTxt);
        softAssert.assertEquals(filingJointlyWithTxt.getCssValue("font-weight"), "700","Question Text is not as expected");
        softAssert.assertEquals(filingJointlyWithTxt.getCssValue("font-size"), "16px","Question Text is not as expected");
        softAssert.assertEquals(filingJointlyWithTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Question Text is not as expected");
        softAssert.assertEquals(filingJointlyWithTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Question Text is not as expected");
        softAssert.assertEquals(filingJointlyWithErrorTxt.getText(), errorTxt);
        softAssert.assertEquals(filingJointlyWithErrorTxt.getCssValue("font-weight"), "400","Error Text is not as expected");
        softAssert.assertEquals(filingJointlyWithErrorTxt.getCssValue("font-size"), "14px","Error Text is not as expected");
        softAssert.assertEquals(filingJointlyWithErrorTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Error Text is not as expected");
        softAssert.assertEquals(filingJointlyWithErrorTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Error Text is not as expected");
        for (int i = 0; i < filteredMemNames.size(); i++) {
            int adjustedIndex = i + 1;
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(adjustedIndex).getText(), filteredMemNames.get(i), "Mismatch at radio index: " + (i + 1));
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(adjustedIndex).getCssValue("font-weight"), "700", "Mismatch at radio index: " + (i + 1));
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(adjustedIndex).getCssValue("font-size"), "16px", "Mismatch at radio index: " + (i + 1));
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(adjustedIndex).getCssValue("color"), "rgba(150, 0, 0, 1)", "Mismatch at radio index: " + (i + 1));
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(adjustedIndex).getCssValue("font-family"), "\"PT Sans\", sans-serif", "Mismatch at radio index: " + (i + 1));
        }
        int someoneElseIndex = filteredMemNames.size() + 1;
        if (someoneElseIndex < filingJointlyWithRadioTxt.size()) {
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(someoneElseIndex).getText(), someoneElseText, "'Someone else' option text does not match.");
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(someoneElseIndex).getCssValue("font-weight"), "700", "'Someone else' option mismatch");
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(someoneElseIndex).getCssValue("font-size"), "16px", "'Someone else' option mismatch");
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(someoneElseIndex).getCssValue("color"), "rgba(150, 0, 0, 1)", "'Someone else' option mismatch");
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(someoneElseIndex).getCssValue("font-family"), "\"PT Sans\", sans-serif", "'Someone else' option mismatch");
        } else {
            throw new AssertionError("'Someone else' option is missing in the radio list.");
        }
        softAssert.assertAll();
    }

    public void verifyFilingJointlyWithAnswers(String memOption, String language, List<Map<String, String>> expectedMembers) {
        basicActions.waitForElementToBePresent(filingJointlyWithTxt, 15);
        List<String> expectedMembersList = expectedMembers.stream().map(map -> map.get("ExpectedMembers")).filter(Objects::nonNull).map(basicActions::getMemFirstLastNames).collect(Collectors.toList());
        List<String> actualMemNames = filingJointlyWithRadioTxt.stream().map(WebElement::getText).collect(Collectors.toList());

        if (actualMemNames.size() > 1) {
            actualMemNames.remove(0); // Remove first occurrence of "Who will you be filing jointly with?"
        }
        softAssert.assertEquals(actualMemNames.size(), expectedMembersList.size() + 1, "The actual number of radio button options does not match the expected count.");
        for (String expectedName : expectedMembersList) {
            softAssert.assertTrue(actualMemNames.contains(expectedName), "Expected member not found in actual radio buttons: " + expectedName);
        }

        String someoneElseText = language.equalsIgnoreCase("Spanish") ? "Otra persona" : "Someone else";
        int someoneElseIndex = actualMemNames.size() - 1; // 'Someone else' should always be the last option
        softAssert.assertEquals(actualMemNames.get(someoneElseIndex), someoneElseText, "'" + someoneElseText + "' option text does not match.");
        if (memOption == null || memOption.isEmpty()) {
            softAssert.assertFalse(filingJointlyWithRadio.get(someoneElseIndex).isSelected(), "'" + someoneElseText + "' radio button is unexpectedly selected when memOption is empty.");
        } else if (someoneElseText.toLowerCase().startsWith(memOption.toLowerCase())) {
            softAssert.assertTrue(filingJointlyWithRadio.get(someoneElseIndex).isSelected(), "'" + someoneElseText + "' radio button is not selected as memOption.");
        } else {
            boolean memOptionMatched = false;
            for (int i = 0; i < expectedMembersList.size(); i++) {
                if (actualMemNames.get(i).toLowerCase().startsWith(memOption.toLowerCase())) {
                    memOptionMatched = true;
                    softAssert.assertTrue(filingJointlyWithRadio.get(i).isSelected(),
                            "Radio button for " + actualMemNames.get(i) + " is not selected as memOption.");
                    break;
                }
            }
            if (!memOptionMatched) {
                softAssert.fail("No radio button matched the provided memOption: " + memOption);
            }
        }
        softAssert.assertAll();
    }

    public void verifyFilingJointlyWithEnterTheNameQuestion(String language) {
        basicActions.waitForElementToBePresent(enterNameTxt, 15);
        switch (language) {
            case "English":
                softAssert.assertEquals(enterNameTxt.getText(), "Enter name of spouse:");
                softAssert.assertEquals(filingFirstNameTxt.getText(), "First name");
                softAssert.assertEquals(filingMiddleNameTxt.getText(), "Middle name or initial");
                softAssert.assertEquals(filingLastNameTxt.getText(), "Last name");
                softAssert.assertEquals(filingSuffixNameTxt.getText(), "Suffix");
                softAssert.assertEquals(filingSuffixNameDpd.getText(), "Select Option\n" + "Jr.\n" + "Sr.\n" + "III\n" + "IV");
                softAssert.assertEquals(filingDobNameTxt.getText(), "Date of birth");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(enterNameTxt.getText(), "Escriba el nombre del spouse");
                softAssert.assertEquals(filingFirstNameTxt.getText(), "Nombre");
                softAssert.assertEquals(filingMiddleNameTxt.getText(), "Segundo nombre o inicial");
                softAssert.assertEquals(filingLastNameTxt.getText(), "Apellido(s)");
                softAssert.assertEquals(filingSuffixNameTxt.getText(), "Titulo o tratamiento");
                softAssert.assertEquals(filingSuffixNameDpd.getText(), "Seleccione\n" + "Jr.\n" + "Sr.\n" + "III\n" + "IV");
                softAssert.assertEquals(filingDobNameTxt.getText(), "Fecha de nacimiento");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyFilingJointlyWithNameErrors(String dateError, String language) {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(filingFirstNameError,10);

        String firstNameErrorTxt;
        String lastNameErrorTxt;
        String dobErrorTxt;
        String firstNameTxt;
        String lastNameTxt;
        String dobTxt;
        switch (language) {
            case "English":
                firstNameErrorTxt = "First name is required";
                lastNameErrorTxt = "Last name is required";
                firstNameTxt = "First name";
                lastNameTxt = "Last name";
                dobTxt = "Date of birth";
                if ("not valid".equals(dateError)) {
                    dobErrorTxt = "Date is not valid";
                } else if ("required".equals(dateError)) {
                    dobErrorTxt = "Date of birth is required";
                } else {
                    throw new IllegalArgumentException("Invalid dateError option: " + dateError);
                }
                break;
            case "Spanish":
                firstNameErrorTxt = "El primer nombre es obligatorio";
                lastNameErrorTxt = "El apellido es obligatorio";
                firstNameTxt = "Nombre";
                lastNameTxt = "Apellido(s)";
                dobTxt = "Fecha de nacimiento";
                if ("not valid".equals(dateError)) {
                    dobErrorTxt = "La fecha no es v\u00E1lida";
                } else if ("required".equals(dateError)) {
                    dobErrorTxt = "La fecha de nacimiento es obligatoria";
                } else {
                    throw new IllegalArgumentException("Invalid dateError option: " + dateError);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
        softAssert.assertEquals(filingFirstNameError.getText(), firstNameErrorTxt);
        softAssert.assertEquals(filingFirstNameError.getCssValue("font-weight"), "400");
        softAssert.assertEquals(filingFirstNameError.getCssValue("font-size"), "14px");
        softAssert.assertEquals(filingFirstNameError.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(filingFirstNameError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(filingLastNameError.getText(), lastNameErrorTxt);
        softAssert.assertEquals(filingLastNameError.getCssValue("font-weight"), "400");
        softAssert.assertEquals(filingLastNameError.getCssValue("font-size"), "14px");
        softAssert.assertEquals(filingLastNameError.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(filingLastNameError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(filingDobNameError.getText(), dobErrorTxt);
        softAssert.assertEquals(filingDobNameError.getCssValue("font-weight"), "400");
        softAssert.assertEquals(filingDobNameError.getCssValue("font-size"), "14px");
        softAssert.assertEquals(filingDobNameError.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(filingDobNameError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(filingFirstNameTxt.getText(), firstNameTxt);
        softAssert.assertEquals(filingFirstNameTxt.getCssValue("font-weight"), "700");
        softAssert.assertEquals(filingFirstNameTxt.getCssValue("font-size"), "16px");
        softAssert.assertEquals(filingFirstNameTxt.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(filingFirstNameTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(filingLastNameTxt.getText(), lastNameTxt);
        softAssert.assertEquals(filingLastNameTxt.getCssValue("font-weight"), "700");
        softAssert.assertEquals(filingLastNameTxt.getCssValue("font-size"), "16px");
        softAssert.assertEquals(filingLastNameTxt.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(filingLastNameTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(filingDobNameTxt.getText(), dobTxt);
        softAssert.assertEquals(filingDobNameTxt.getCssValue("font-weight"), "700");
        softAssert.assertEquals(filingDobNameTxt.getCssValue("font-size"), "16px");
        softAssert.assertEquals(filingDobNameTxt.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(filingDobNameTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
    }

    public void verifyWillYouClaimDependentsQuestion(String memPrefix,String language){
        basicActions.waitForElementToBePresent(willClaimDependentsTxt, 15);
        String expectedQuestionText = "";
        if ("primary".equalsIgnoreCase(memPrefix)) {
            expectedQuestionText = language.equalsIgnoreCase("English")
                    ? "Will you be claiming dependents on your tax return next year?"
                    : "\u00BFRegistrar\u00E1 alg\u00FAn dependiente en su declaraci\u00F3n de impuestos el pr\u00F3ximo a\u00F1o?";
        } else {
            expectedQuestionText = language.equalsIgnoreCase("English")
                    ? "Will "+basicActions.getMemFirstNames(memPrefix)+" be claiming dependents on your tax return next year?"
                    : "\u00BF"+basicActions.getMemFirstNames(memPrefix)+" registrar\u00E1 alg\u00FAn dependiente en su declaraci\u00F3n de impuestos el pr\u00F3ximo a\u00F1o?";
        }
        softAssert.assertEquals(willClaimDependentsTxt.getText(), expectedQuestionText);
        switch (language) {
            case "English":
                softAssert.assertEquals(willClaimDependentsYesTxt.getText(), "Yes");
                softAssert.assertEquals(willClaimDependentsNoTxt.getText(), "No");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(willClaimDependentsYesTxt.getText(), "S\u00ED");
                softAssert.assertEquals(willClaimDependentsNoTxt.getText(), "No");
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
        softAssert.assertAll();
    }

    public void verifyWillYouClaimDependentsErrors(String memPrefix, String language) {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(willClaimDependentsTxt,10);

        String questionTxt;
        String errorTxt;
        String yesTxt;
        String noTxt;
        switch (language) {
            case "English":
                if (memPrefix.equals("Primary")) {
                    questionTxt = "Will you be claiming dependents on your tax return next year?";
                } else {
                    questionTxt = "Will "+basicActions.getMemFirstNames(memPrefix)+" be claiming dependents on your tax return next year?";
                }
                errorTxt = "Please select one of the options below";
                yesTxt = "Yes";
                noTxt = "No";
                break;
            case "Spanish":
                if (memPrefix.equals("Primary")) {
                    questionTxt = "\u00BFRegistrar\u00E1 alg\u00FAn dependiente en su declaraci\u00F3n de impuestos el pr\u00F3ximo a\u00F1o?";
                } else {
                    questionTxt = "\u00BF"+basicActions.getMemFirstNames(memPrefix)+" registrar\u00E1 alg\u00FAn dependiente en su declaraci\u00F3n de impuestos el pr\u00F3ximo a\u00F1o?";
                }
                errorTxt = "Seleccione una de las opciones siguientes";
                yesTxt = "S\u00ED";
                noTxt = "No";
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
        softAssert.assertEquals(willClaimDependentsTxt.getText(), questionTxt);
        softAssert.assertEquals(willClaimDependentsTxt.getCssValue("font-weight"), "700","Question Text is not as expected");
        softAssert.assertEquals(willClaimDependentsTxt.getCssValue("font-size"), "16px","Question Text is not as expected");
        softAssert.assertEquals(willClaimDependentsTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Question Text is not as expected");
        softAssert.assertEquals(willClaimDependentsTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Question Text is not as expected");
        softAssert.assertTrue(claimingDependentHlpIcon.getAttribute("class").contains("help-icon"), "Found "+claimingDependentHlpIcon.getAttribute("class"));
        softAssert.assertEquals(willClaimDependentsErrorTxt.getText(), errorTxt);
        softAssert.assertEquals(willClaimDependentsErrorTxt.getCssValue("font-weight"), "400","Error Text is not as expected");
        softAssert.assertEquals(willClaimDependentsErrorTxt.getCssValue("font-size"), "14px","Error Text is not as expected");
        softAssert.assertEquals(willClaimDependentsErrorTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Error Text is not as expected");
        softAssert.assertEquals(willClaimDependentsErrorTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Error Text is not as expected");
        softAssert.assertEquals(willClaimDependentsYesTxt.getText(), yesTxt);
        softAssert.assertEquals(willClaimDependentsYesTxt.getCssValue("font-weight"), "700","Yes Text is not as expected");
        softAssert.assertEquals(willClaimDependentsYesTxt.getCssValue("font-size"), "16px","Yes Text is not as expected");
        softAssert.assertEquals(willClaimDependentsYesTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Yes Text is not as expected");
        softAssert.assertEquals(willClaimDependentsYesTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Yes Text is not as expected");
        softAssert.assertEquals(willClaimDependentsNoTxt.getText(), noTxt);
        softAssert.assertEquals(willClaimDependentsNoTxt.getCssValue("font-weight"), "700","No Text is not as expected");
        softAssert.assertEquals(willClaimDependentsNoTxt.getCssValue("font-size"), "16px","No Text is not as expected");
        softAssert.assertEquals(willClaimDependentsNoTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","No Text is not as expected");
        softAssert.assertEquals(willClaimDependentsNoTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","No Text is not as expected");
        softAssert.assertAll();
    }

    public void verifyWillYouClaimDependentsAnswers(String yesStatus, String noStatus){
        basicActions.waitForElementToBePresent(willClaimDependentsYes,20);
        switch (yesStatus){
            case "is":
                softAssert.assertTrue(willClaimDependentsYes.isSelected());
                softAssert.assertAll();
                break;
            case "is not":
                softAssert.assertFalse(willClaimDependentsYes.isSelected());
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + yesStatus);
        }
        switch (noStatus){
            case "is":
                softAssert.assertTrue(willClaimDependentsNo.isSelected());
                softAssert.assertAll();
                break;
            case "is not":
                softAssert.assertFalse(willClaimDependentsNo.isSelected());
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + noStatus);
        }
    }
    public void verifyWhoClaimedQuestion(String memPrefix, String language) {
        basicActions.waitForElementToBePresent(whoClaimedAsDependentsTxt, 15);
        List<String> allMemNames = basicActions.getAllMemNames();
        List<String> filteredMemNames = allMemNames.stream().filter(name -> !name.startsWith(memPrefix)).toList();

        switch (language) {
            case "English":
                softAssert.assertEquals(whoClaimedTxt.getText(), "Who will be claimed as dependents?");
                break;
            case "Spanish":
                softAssert.assertEquals(whoClaimedTxt.getText(), "\u00BFA qui\u00E9n registrar\u00E1 como dependientes?");
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
        Set<String> filteredSet = new HashSet<>(filteredMemNames);
        Set<String> displayedSet = new HashSet<>();
        for (WebElement element : whoClaimedMemNameTxt) {
            displayedSet.add(element.getText());
        }
        softAssert.assertTrue(displayedSet.containsAll(filteredSet), "Mismatch in claimed dependent names.");

        int someoneElseIndex = filteredMemNames.size();
        if (someoneElseIndex < whoClaimedBtn.size()) {
            String someoneElseText = language.equalsIgnoreCase("Spanish") ? "Otra persona" : "Someone else";
            softAssert.assertEquals(whoClaimedMemNameTxt.get(someoneElseIndex).getText(), someoneElseText, "'" + someoneElseText + "' option text does not match.");
        } else {
            throw new AssertionError("'Someone else' option is missing in the button list.");
        }

        softAssert.assertAll();
    }

    public void verifyWhoClaimedErrors(String memPrefix, String language) {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(whoClaimedTxt,10);
        List<String> allMemNames = basicActions.getAllMemNames();
        List<String> filteredMemNames = allMemNames.stream().filter(name -> !name.startsWith(memPrefix)).toList();

        String questionTxt;
        String errorTxt;
        String someoneElseText;
        switch (language) {
            case "English":
                questionTxt = "Who will be claimed as dependents?";
                errorTxt = "Please select one or more of the options below";
                someoneElseText = "Someone else";
                break;
            case "Spanish":
                questionTxt = "\u00BFA qui\u00E9n registrar\u00E1 como dependientes?";
                errorTxt = "Seleccione una o m\u00E1s de las siguientes opciones";
                someoneElseText = "Otra persona";
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
        softAssert.assertEquals(whoClaimedTxt.getText(), questionTxt);
        softAssert.assertEquals(whoClaimedTxt.getCssValue("font-weight"), "700","Question Text is not as expected");
        softAssert.assertEquals(whoClaimedTxt.getCssValue("font-size"), "16px","Question Text is not as expected");
        softAssert.assertEquals(whoClaimedTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Question Text is not as expected");
        softAssert.assertEquals(whoClaimedTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Question Text is not as expected");
        softAssert.assertEquals(whoClaimedErrorTxt.getText(), errorTxt);
        softAssert.assertEquals(whoClaimedErrorTxt.getCssValue("font-weight"), "700","Error Text is not as expected");
        softAssert.assertEquals(whoClaimedErrorTxt.getCssValue("font-size"), "16px","Error Text is not as expected");
        softAssert.assertEquals(whoClaimedErrorTxt.getCssValue("color"), "rgba(150, 0, 0, 1)","Error Text is not as expected");
        softAssert.assertEquals(whoClaimedErrorTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif","Error Text is not as expected");
        for (int i = 0; i < filteredMemNames.size(); i++) {
            softAssert.assertEquals(whoClaimedMemNameTxt.get(i).getText(), filteredMemNames.get(i), "Mismatch at radio index: " + (i + 1));
            softAssert.assertEquals(whoClaimedMemNameTxt.get(i).getCssValue("font-weight"), "700", "Mismatch at radio index: " + (i + 1));
            softAssert.assertEquals(whoClaimedMemNameTxt.get(i).getCssValue("font-size"), "16px", "Mismatch at radio index: " + (i + 1));
            softAssert.assertEquals(whoClaimedMemNameTxt.get(i).getCssValue("color"), "rgba(150, 0, 0, 1)", "Mismatch at radio index: " + (i + 1));
            softAssert.assertEquals(whoClaimedMemNameTxt.get(i).getCssValue("font-family"), "\"PT Sans\", sans-serif", "Mismatch at radio index: " + (i + 1));
        }
        int someoneElseIndex = filteredMemNames.size();
        if (someoneElseIndex < whoClaimedMemNameTxt.size()) {
            softAssert.assertEquals(whoClaimedMemNameTxt.get(someoneElseIndex).getText(), someoneElseText, "'Someone else' option text does not match.");
            softAssert.assertEquals(whoClaimedMemNameTxt.get(someoneElseIndex).getCssValue("font-weight"), "700", "'Someone else' option mismatch");
            softAssert.assertEquals(whoClaimedMemNameTxt.get(someoneElseIndex).getCssValue("font-size"), "16px", "'Someone else' option mismatch");
            softAssert.assertEquals(whoClaimedMemNameTxt.get(someoneElseIndex).getCssValue("color"), "rgba(150, 0, 0, 1)", "'Someone else' option mismatch");
            softAssert.assertEquals(whoClaimedMemNameTxt.get(someoneElseIndex).getCssValue("font-family"), "\"PT Sans\", sans-serif", "'Someone else' option mismatch");
        } else {
            throw new AssertionError("'Someone else' option is missing in the radio list.");
        }
        softAssert.assertAll();
    }

    public void verifyWhoClaimedWithEnterTheNameQuestion(String language) {
        basicActions.waitForElementToBePresent(enterNameTxt, 15);
        switch (language) {
            case "English":
                softAssert.assertEquals(enterNameTxt.getText(), "Enter name of dependent:");
                softAssert.assertEquals(claimedFirstNameTxt.getText(), "First name");
                softAssert.assertEquals(claimedMiddleNameTxt.getText(), "Middle name or initial");
                softAssert.assertEquals(claimedLastNameTxt.getText(), "Last name");
                softAssert.assertEquals(claimedSuffixNameTxt.getText(), "Suffix");
                softAssert.assertEquals(claimedSuffixNameDpd.getText(), "Select Option\n" + "Jr.\n" + "Sr.\n" + "III\n" + "IV");
                softAssert.assertEquals(claimedDobNameTxt.getText(), "Date of birth");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(enterNameTxt.getText(), "Escriba el nombre del dependiente:");
                softAssert.assertEquals(claimedFirstNameTxt.getText(), "Nombre");
                softAssert.assertEquals(claimedMiddleNameTxt.getText(), "Segundo nombre o inicial");
                softAssert.assertEquals(claimedLastNameTxt.getText(), "Apellido(s)");
                softAssert.assertEquals(claimedSuffixNameTxt.getText(), "Titulo o tratamiento");
                softAssert.assertEquals(claimedSuffixNameDpd.getText(), "Seleccione\n" + "Jr.\n" + "Sr.\n" + "III\n" + "IV");
                softAssert.assertEquals(claimedDobNameTxt.getText(), "Fecha de nacimiento");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyWhoClaimedWithNameErrors(String dateError, String language) {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(claimedFirstNameError,10);

        String firstNameErrorTxt;
        String lastNameErrorTxt;
        String dobErrorTxt;
        String firstNameTxt;
        String lastNameTxt;
        String dobTxt;
        switch (language) {
            case "English":
                firstNameErrorTxt = "First name is required";
                lastNameErrorTxt = "Last name is required";
                firstNameTxt = "First name";
                lastNameTxt = "Last name";
                dobTxt = "Date of birth";
                if ("not valid".equals(dateError)) {
                    dobErrorTxt = "Date is not valid";
                } else if ("required".equals(dateError)) {
                    dobErrorTxt = "Date of birth is required";
                } else {
                    throw new IllegalArgumentException("Invalid dateError option: " + dateError);
                }
                break;
            case "Spanish":
                firstNameErrorTxt = "El primer nombre es obligatorio";
                lastNameErrorTxt = "El apellido es obligatorio";
                firstNameTxt = "Nombre";
                lastNameTxt = "Apellido(s)";
                dobTxt = "Fecha de nacimiento";
                if ("not valid".equals(dateError)) {
                    dobErrorTxt = "La fecha no es v\u00E1lida";
                } else if ("required".equals(dateError)) {
                    dobErrorTxt = "La fecha de nacimiento es obligatoria";
                } else {
                    throw new IllegalArgumentException("Invalid dateError option: " + dateError);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid language option: " + language);
        }
        softAssert.assertEquals(claimedFirstNameError.getText(), firstNameErrorTxt);
        softAssert.assertEquals(claimedFirstNameError.getCssValue("font-weight"), "400");
        softAssert.assertEquals(claimedFirstNameError.getCssValue("font-size"), "14px");
        softAssert.assertEquals(claimedFirstNameError.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(claimedFirstNameError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(claimedLastNameError.getText(), lastNameErrorTxt);
        softAssert.assertEquals(claimedLastNameError.getCssValue("font-weight"), "400");
        softAssert.assertEquals(claimedLastNameError.getCssValue("font-size"), "14px");
        softAssert.assertEquals(claimedLastNameError.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(claimedLastNameError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(claimedDobNameError.getText(), dobErrorTxt);
        softAssert.assertEquals(claimedDobNameError.getCssValue("font-weight"), "400");
        softAssert.assertEquals(claimedDobNameError.getCssValue("font-size"), "14px");
        softAssert.assertEquals(claimedDobNameError.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(claimedDobNameError.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(claimedFirstNameTxt.getText(), firstNameTxt);
        softAssert.assertEquals(claimedFirstNameTxt.getCssValue("font-weight"), "700");
        softAssert.assertEquals(claimedFirstNameTxt.getCssValue("font-size"), "16px");
        softAssert.assertEquals(claimedFirstNameTxt.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(claimedFirstNameTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(claimedLastNameTxt.getText(), lastNameTxt);
        softAssert.assertEquals(claimedLastNameTxt.getCssValue("font-weight"), "700");
        softAssert.assertEquals(claimedLastNameTxt.getCssValue("font-size"), "16px");
        softAssert.assertEquals(claimedLastNameTxt.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(claimedLastNameTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(claimedDobNameTxt.getText(), dobTxt);
        softAssert.assertEquals(claimedDobNameTxt.getCssValue("font-weight"), "700");
        softAssert.assertEquals(claimedDobNameTxt.getCssValue("font-size"), "16px");
        softAssert.assertEquals(claimedDobNameTxt.getCssValue("color"), "rgba(150, 0, 0, 1)");
        softAssert.assertEquals(claimedDobNameTxt.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertAll();
    }

    public void verifySelectTaxFilingStatusAnswer(String option){
        basicActions.waitForElementToBePresent(filingStatusDpdTxt,15);
        softAssert.assertTrue(filingStatusDpdTxt.getAttribute("value").equals(option));
        softAssert.assertAll();
    }

    public void verifyWhoClaimedNoEnterTheNameQuestion() {
        softAssert.assertFalse(basicActions.isElementDisplayed(claimedFirstNameTxt, 10));
        softAssert.assertFalse(basicActions.isElementDisplayed(claimedMiddleNameTxt, 10));
        softAssert.assertFalse(basicActions.isElementDisplayed(claimedLastNameTxt, 10));
        softAssert.assertFalse(basicActions.isElementDisplayed(claimedSuffixNameTxt, 10));
        softAssert.assertFalse(basicActions.isElementDisplayed(claimedSuffixNameDpd, 10));
        softAssert.assertFalse(basicActions.isElementDisplayed(claimedDobNameTxt, 10));
        softAssert.assertAll();
    }

    public void verifyWhoClaimedEnterTheNameAnswers(List<Map<String, String>> nameData) {
        String firstName = nameData.get(0).get("First Name");
        String middleName = nameData.get(0).get("Middle Name");
        String lastName = nameData.get(0).get("Last Name");
        String suffix = nameData.get(0).get("Suffix");
        String dob = nameData.get(0).get("DOB");
        firstName = (firstName != null && !firstName.trim().isEmpty()) ? firstName : null;
        middleName = (middleName != null && !middleName.trim().isEmpty()) ? middleName : null;
        lastName = (lastName != null && !lastName.trim().isEmpty()) ? lastName : null;
        suffix = (suffix != null && !suffix.trim().isEmpty()) ? suffix : null;
        dob = (dob != null && !dob.trim().isEmpty()) ? dob : null;

        softAssert.assertEquals(claimedFirstNameInput.getAttribute("value").trim().isEmpty() ? null : claimedFirstNameInput.getAttribute("value"), firstName);
        softAssert.assertEquals(claimedMiddleNameInput.getAttribute("value").trim().isEmpty() ? null : claimedMiddleNameInput.getAttribute("value"), middleName);
        softAssert.assertEquals(claimedLastNameInput.getAttribute("value").trim().isEmpty() ? null : claimedLastNameInput.getAttribute("value"), lastName);
        softAssert.assertEquals(claimedSuffixNameDpd.getAttribute("value").trim().isEmpty() || "0: null".equals(claimedSuffixNameDpd.getAttribute("value")) ? null : claimedSuffixNameDpd.getAttribute("value"), suffix);
        softAssert.assertEquals(claimedDobNameInput.getAttribute("value").trim().isEmpty() ? null : claimedDobNameInput.getAttribute("value"), dob);
        softAssert.assertAll();
    }

    public void verifyExceptionalCircumstancesCheck(String status){
        basicActions.waitForElementToBePresent(exceptionalCircumstancesTxt,20);
        switch (status){
            case "is":
                softAssert.assertEquals(exceptionalCircumstancesTxt.getAttribute("class"), "checkbox-container checked");
                softAssert.assertAll();
                break;
            case "is not":
                softAssert.assertEquals(exceptionalCircumstancesTxt.getAttribute("class"), "checkbox-container");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + status);
        }
    }

    public void verifyFilingJointlyWithEnterTheNameAnswers(List<Map<String, String>> nameData) {
        String firstName = nameData.get(0).get("First Name");
        String middleName = nameData.get(0).get("Middle Name");
        String lastName = nameData.get(0).get("Last Name");
        String suffix = nameData.get(0).get("Suffix");
        String dob = nameData.get(0).get("DOB");
        firstName = (firstName != null && !firstName.trim().isEmpty()) ? firstName : null;
        middleName = (middleName != null && !middleName.trim().isEmpty()) ? middleName : null;
        lastName = (lastName != null && !lastName.trim().isEmpty()) ? lastName : null;
        suffix = (suffix != null && !suffix.trim().isEmpty()) ? suffix : null;
        dob = (dob != null && !dob.trim().isEmpty()) ? dob : null;

        softAssert.assertEquals(filingFirstNameInput.getAttribute("value").trim().isEmpty() ? null : filingFirstNameInput.getAttribute("value"), firstName);
        softAssert.assertEquals(filingMiddleNameInput.getAttribute("value").trim().isEmpty() ? null : filingMiddleNameInput.getAttribute("value"), middleName);
        softAssert.assertEquals(filingLastNameInput.getAttribute("value").trim().isEmpty() ? null : filingLastNameInput.getAttribute("value"), lastName);
        softAssert.assertEquals(filingSuffixNameDpd.getAttribute("value").trim().isEmpty() || "0: null".equals(filingSuffixNameDpd.getAttribute("value")) ? null : filingSuffixNameDpd.getAttribute("value"), suffix);
        softAssert.assertEquals(filingDobNameInput.getAttribute("value").trim().isEmpty() ? null : filingDobNameInput.getAttribute("value"), dob);
        softAssert.assertAll();
    }

    public void verifyTaxReturnId(String matchType, String memPrefix) {
        List<String> taxReturnIds = getTaxReturnIds(memPrefix);

        if (taxReturnIds == null || taxReturnIds.isEmpty()) {
            throw new IllegalStateException("No tax_return_id entries found for member: " + memPrefix);
        }
        if (taxReturnIds.size() == 1) {
            System.out.println("Only one tax_return_id entry available for member " + memPrefix + ": " + taxReturnIds.get(0) + ". Skipping verification.");
            return;
        }

        String lastTaxReturnId = taxReturnIds.get(taxReturnIds.size() - 1);
        String secondLastTaxReturnId = taxReturnIds.get(taxReturnIds.size() - 2);
        try {
            switch (matchType) {
                case "Same":
                    if (lastTaxReturnId.equals(secondLastTaxReturnId)) {
                        System.out.println("The last two tax_return_id entries for " + memPrefix + " are the same: Last tax_return_id: " + lastTaxReturnId + ", Second to last tax_return_id: " + secondLastTaxReturnId);
                    } else {
                        softAssert.fail("The last two tax_return_id entries for " + memPrefix + " are different. Expected them to be the same: Last tax_return_id: " + lastTaxReturnId + ", Second to last tax_return_id: " + secondLastTaxReturnId);
                    }
                    break;
                case "Different":
                    if (!lastTaxReturnId.equals(secondLastTaxReturnId)) {
                        System.out.println("The last two tax_return_id entries for " + memPrefix + " are different: Last tax_return_id: " + lastTaxReturnId + ", Second to last tax_return_id: " + secondLastTaxReturnId);
                    } else {
                        softAssert.fail("The last two tax_return_id entries for " + memPrefix + " are the same. Expected them to be different: Last tax_return_id: " + lastTaxReturnId + ", Second to last tax_return_id: " + secondLastTaxReturnId);
                    }
                    break;
                default:
                    System.out.println("Invalid matchType. Please provide 'Same' or 'Different'.");
                    break;
            }
            softAssert.assertAll();
        } catch (Exception e) {
            System.out.println("An error occurred while verifying tax_return_id: " + e.getMessage());
        }
    }

    public void compareTaxReturnId(String memPrefix, String matchType, String memPrefix2) {
        List<String> taxReturnIds = getTaxReturnIds(memPrefix);
        List<String> taxReturnIds2 = getTaxReturnIds(memPrefix2);

        if (taxReturnIds == null || taxReturnIds.isEmpty() || taxReturnIds2 == null || taxReturnIds2.isEmpty()) {
            softAssert.fail("One or both member tax return ID lists are null or have no entries.");
        }

        String mem1TaxReturnId = taxReturnIds.get(taxReturnIds.size() - 1);
        String mem2TaxReturnId = taxReturnIds2.get(taxReturnIds2.size() - 1);

        switch (matchType) {
            case "Same":
                if (mem1TaxReturnId.equals(mem2TaxReturnId)) {
                    System.out.println("The tax_return_id entries for " + memPrefix + " and " + memPrefix2 + " are the same: " + memPrefix + " tax_return_id: " + mem1TaxReturnId + ", " + memPrefix2 + " tax_return_id: " + mem2TaxReturnId);
                } else {
                    softAssert.fail("The tax_return_id entries for " + memPrefix + " and " + memPrefix2 + " are different. " + "Expected them to be the same: " + memPrefix + " tax_return_id: " + mem1TaxReturnId + ", " + memPrefix2 + " tax_return_id: " + mem2TaxReturnId);
                }
                break;
            case "Different":
                if (!mem1TaxReturnId.equals(mem2TaxReturnId)) {
                    System.out.println("The tax_return_id entries for " + memPrefix + " and " + memPrefix2 + " are different: " + memPrefix + " tax_return_id: " + mem1TaxReturnId + ", " + memPrefix2 + " tax_return_id: " + mem2TaxReturnId);
                } else {
                    softAssert.fail("The tax_return_id entries for " + memPrefix + " and " + memPrefix2 + " are the same. Expected them to be different: " + memPrefix + " tax_return_id: " + mem1TaxReturnId + ", " + memPrefix2 + " tax_return_id: " + mem2TaxReturnId);
                }
                break;
            default:
                System.out.println("Invalid matchType. Please provide 'Same' or 'Different'.");
                break;
        }
        softAssert.assertAll();
    }

    private List<String> getTaxReturnIds(String memPrefix) {
        if ("Primary".equals(memPrefix)) {
            return SharedData.getPrimaryMember().getTaxReturnId();
        } else {
            List<MemberDetails> members = SharedData.getMembers();
            for (MemberDetails mem : members) {
                if (mem.getFirstName().contains(memPrefix)) {
                    return mem.getTaxReturnId();
                }
            }
        }
        System.out.println("No tax return IDs found for prefix: " + memPrefix);
        return null;
    }

    public void verifyNoErrors() {
        basicActions.wait(50);
        basicActions.waitForElementToBePresent(existingTaxStatusHeader,10);
        softAssert.assertFalse(basicActions.waitForElementPresence(englishErrorTxt,10));
        softAssert.assertFalse(basicActions.waitForElementPresence(spanishErrorTxt,10));
        softAssert.assertFalse(basicActions.waitForElementPresence(someoneElseErrorTxt,10));
        softAssert.assertAll();
    }

    public void verifyHelpDrawerTxt(String helpTxt) {
        switch (helpTxt) {
            case "Full:English":
                verifyHelpDrawerTxtEnglish();
                break;
            case "Full:Spanish":
                verifyHelpDrawerTxtSpanish();
                break;
            case "Claim:English":
                verifyHelpDrawerClaimedTxtEnglish();
                break;
            case "Claim:Spanish":
                verifyHelpDrawerClaimedTxtSpanish();
                break;
            case "Exceptional Circumstances:English":
                verifyHelpDrawerExceptionalTxtEnglish();
                break;
            case "Exceptional Circumstances:Spanish":
                verifyHelpDrawerExceptionalTxtSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + helpTxt);
        }
    }

    public void verifyHelpDrawerTxtEnglish() {
        basicActions.waitForElementToBePresent(helpHdr,60);
        softAssert.assertEquals(helpHdr.getText(), "Help");
        softAssert.assertEquals(helpSubHdr.getText(), "Tax Status");
        softAssert.assertEquals(helpContentHdr.get(0).getText(), "Overview");
        softAssert.assertEquals(helpContentTxt.get(0).getText(), "You are only eligible for help paying for health insurance if you file a federal tax return.");
        softAssert.assertEquals(helpContentHdr.get(1).getText(), "Dependents");
        softAssert.assertEquals(helpContentTxt.get(1).getText(), "Dependents are children or any others this person is responsible for taking care of financially.");
        softAssert.assertEquals(helpContentHdr.get(2).getText(), "Exceptional Circumstances");
        softAssert.assertEquals(helpContentTxt.get(2).getText(), "If you have been a victim of domestic violence, are still married to the perpetrator, and unable to file a joint tax return, please select 'Married Filing Separately' as your tax filing status and check the 'Exceptional circumstances' box.");
        softAssert.assertEquals(helpFooterTxt.getText(), "Need more help?\nContact us");
        softAssert.assertEquals(helpFooterLnk.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerTxtSpanish() {
        basicActions.waitForElementToBePresent(helpHdr,60);
        softAssert.assertEquals(helpHdr.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHdr.getText(), "Situaci\u00F3n fiscal");
        softAssert.assertEquals(helpContentHdr.get(0).getText(), "Resumen");
        softAssert.assertEquals(helpContentTxt.get(0).getText(), "Tendr\u00E1 derecho a ayuda para pagar el seguro de salud solamente si presenta declaraci\u00F3n de impuestos federal.");
        softAssert.assertEquals(helpContentHdr.get(1).getText(), "Dependientes");
        softAssert.assertEquals(helpContentTxt.get(1).getText(), "Los dependientes son hijos u otros individuos que la persona tenga a su cargo en cuesti\u00F3n financiera.");
        softAssert.assertEquals(helpContentHdr.get(2).getText(), "Circunstancias excepcionales");
        softAssert.assertEquals(helpContentTxt.get(2).getText(), "Si ha sido v\u00EDctima de violencia dom\u00E9stica, sigue casado con la persona que ejerce violencia y no puede presentar una declaraci\u00F3n conjunta de impuestos, seleccione \"Married Filing Separately\" (Casado que declara por separado) como su estatus de declaraci\u00F3n de impuestos y marque la casilla \"Exceptional circumstances\" (Circunstancias excepcionales).");
        softAssert.assertEquals(helpFooterTxt.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertEquals(helpFooterLnk.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerClaimedTxtEnglish() {
        basicActions.waitForElementToBePresent(helpHdr,60);
        softAssert.assertEquals(helpHdr.getText(), "Help");
        softAssert.assertEquals(helpSubHdr.getText(), "Tax Status");
        softAssert.assertEquals(helpContentHdr.get(0).getText(), "Dependents");
        softAssert.assertEquals(helpContentTxt.get(0).getText(), "Dependents are children or any others this person is responsible for taking care of financially.");
        softAssert.assertEquals(helpFooterTxt.getText(), "Need more help?\nContact us");
        softAssert.assertEquals(helpFooterLnk.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerClaimedTxtSpanish() {
        basicActions.waitForElementToBePresent(helpHdr,60);
        softAssert.assertEquals(helpHdr.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHdr.getText(), "Situaci\u00F3n fiscal");
        softAssert.assertEquals(helpContentHdr.get(0).getText(), "Dependientes");
        softAssert.assertEquals(helpContentTxt.get(0).getText(), "Los dependientes son hijos u otros individuos que la persona tenga a su cargo en cuesti\u00F3n financiera.");
        softAssert.assertEquals(helpFooterTxt.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertEquals(helpFooterLnk.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerExceptionalTxtEnglish() {
        basicActions.waitForElementToBePresent(helpHdr,60);
        softAssert.assertEquals(helpHdr.getText(), "Help");
        softAssert.assertEquals(helpSubHdr.getText(), "Tax Status");
        softAssert.assertEquals(helpContentHdr.get(0).getText(), "Exceptional Circumstances");
        softAssert.assertEquals(helpContentTxt.get(0).getText(), "If you have been a victim of domestic violence, are still married to the perpetrator, and unable to file a joint tax return, please select 'Married Filing Separately' as your tax filing status and check the 'Exceptional circumstances' box.");
        softAssert.assertEquals(helpFooterTxt.getText(), "Need more help?\nContact us");
        softAssert.assertEquals(helpFooterLnk.getText(), "Contact us");
        softAssert.assertAll();
    }

    public void verifyHelpDrawerExceptionalTxtSpanish() {
        basicActions.waitForElementToBePresent(helpHdr,60);
        softAssert.assertEquals(helpHdr.getText(), "Ayuda");
        softAssert.assertEquals(helpSubHdr.getText(), "Situaci\u00F3n fiscal");
        softAssert.assertEquals(helpContentHdr.get(0).getText(), "Circunstancias excepcionales");
        softAssert.assertEquals(helpContentTxt.get(0).getText(), "Si ha sido v\u00EDctima de violencia dom\u00E9stica, sigue casado con la persona que ejerce violencia y no puede presentar una declaraci\u00F3n conjunta de impuestos, seleccione \"Married Filing Separately\" (Casado que declara por separado) como su estatus de declaraci\u00F3n de impuestos y marque la casilla \"Exceptional circumstances\" (Circunstancias excepcionales).");
        softAssert.assertEquals(helpFooterTxt.getText(), "\u00BFNecesitas m\u00E1s ayuda?\nCont\u00E1ctenos");
        softAssert.assertEquals(helpFooterLnk.getText(), "Cont\u00E1ctenos");
        softAssert.assertAll();
    }



}