package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class TaxStatusPage_Elmo {
    private BasicActions basicActions;
    Actions action;
    public TaxStatusPage_Elmo(WebDriver webDriver){
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

    @FindBy(css = "#ELIG-taxStatus-claimedAsDependent-container span")
    WebElement claimedAsDependentTxt;

    @FindBy(css = "#ELIG-taxStatus-claimedAsDependent-help")
    WebElement claimedAsDependentHlpIcon;

    @FindBy(id = "ELIG-taxStatus-claimedAsDependent-yesButton")
    WebElement claimedAsDependentYes;

    @FindBy(xpath = "//*[@id='ELIG-taxStatus-claimedAsDependent-container']//label[2]")
    WebElement claimedAsDependentYesTxt;

    @FindBy(id = "ELIG-taxStatus-claimedAsDependent-noButton")
    WebElement claimedAsDependentNo;

    @FindBy(xpath = "//*[@id='ELIG-taxStatus-claimedAsDependent-container']//label[3]")
    WebElement claimedAsDependentNoTxt;

    @FindBy(css = "#ELIG-taxStatus-willFile-container span")
    WebElement willFileTaxReturnTxt;

    @FindBy(id = "ELIG-taxStatus-willFile-yesButton")
    WebElement willFileTaxReturnYes;

    @FindBy(xpath = "//*[@id='ELIG-taxStatus-willFile-container']//label[2]")
    WebElement willFileTaxReturnYesTxt;

    @FindBy(id = "ELIG-taxStatus-willFile-noButton")
    WebElement willFileTaxReturnNo;

    @FindBy(xpath = "//*[@id='ELIG-taxStatus-willFile-container']//label[3]")
    WebElement willFileTaxReturnNoTxt;

    @FindBy(css = "#ELIG-taxStatus-taxFilingStatus-container label")
    WebElement filingStatusTxt;

    @FindBy(css = "#ELIG-taxStatus-taxFilingStatus-help")
    WebElement filingStatusHelp;

    @FindBy(css = "#ELIG-taxStatus-taxFilingStatus")
    WebElement filingStatusDpdTxt;

    @FindBy(css = ".c4-input select option")
    List<WebElement> filingStatusDpd;

    @FindBy(css = "#ELIG-taxStatus-exceptional-container label")
    WebElement exceptionalCircumstancesTxt;

    @FindBy(css = "#ELIG-taxStatus-willClaimDependents-container span")
    WebElement willClaimDependentsTxt;

    @FindBy(id = "ELIG-taxStatus-willClaimDependents-yesButton")
    WebElement willClaimDependentsYes;

    @FindBy(xpath = "//*[@id='ELIG-taxStatus-willClaimDependents-container']//label[2]")
    WebElement willClaimDependentsYesTxt;

    @FindBy(id = "ELIG-taxStatus-willClaimDependents-noButton")
    WebElement willClaimDependentsNo;

    @FindBy(xpath = "//*[@id='ELIG-taxStatus-willClaimDependents-container']//label[3]")
    WebElement willClaimDependentsNoTxt;
    
    @FindBy(css = "app-member-multi-select > div > div > span")
    WebElement whoClaimedTxt;

    @FindBy(css = "#-container button")
    List<WebElement> whoClaimedBtn;

    @FindBy(css = "#-container span")
    List<WebElement> whoClaimedMemNameTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-container span")
    WebElement filingJointlyWithTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-container label")
    List<WebElement> filingJointlyWithRadioTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-container input")
    List<WebElement> filingJointlyWithRadio;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-container .row.label-row label")
    WebElement whoClaimedAsDependentsTxt;

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

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-middleName-container label")
    WebElement claimMiddleNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-middleName")
    WebElement claimMiddleNameInput;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-lastName-container label")
    WebElement claimLastNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-lastName")
    WebElement claimLastNameInput;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-suffix-container label")
    WebElement claimSuffixNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-suffix")
    WebElement claimSuffixNameDpd;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-dob-container label")
    WebElement claimDobNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-dob")
    WebElement claimDobNameInput;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-firstName-container label")
    WebElement filingFirstNameTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-firstName")
    WebElement filingFirstNameInput;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-middleName-container label")
    WebElement filingMiddleNameTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-middleName")
    WebElement filingMiddleNameInput;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-lastName-container label")
    WebElement filingLastNameTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-lastName")
    WebElement filingLastNameInput;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-suffix-container label")
    WebElement filingSuffixNameTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-suffix")
    WebElement filingSuffixNameDpd;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-dob-container label")
    WebElement filingDobNameTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-newMember-dob")
    WebElement filingDobNameInput;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-firstName-container label")
    WebElement claimedFirstNameTxt;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-firstName")
    WebElement claimedFirstNameInput;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-middleName-container label")
    WebElement claimedMiddleNameTxt;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-middleName")
    WebElement claimedMiddleNameInput;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-lastName-container label")
    WebElement claimedLastNameTxt;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-lastName")
    WebElement claimedLastNameInput;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-suffix-container label")
    WebElement claimedSuffixNameTxt;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-suffix")
    WebElement claimedSuffixNameDpd;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-dob-container label")
    WebElement claimedDobNameTxt;

    @FindBy(css = "#ELIG-taxStatus-dependentName-newMember-dob")
    WebElement claimedDobNameInput;

    @FindBy(id = "ELIG-taxStatus-nav-GoBack")
    WebElement goBackBtn;

    @FindBy(id = "ELIG-taxStatus-nav-SaveAndContinue")
    WebElement saveAndContinueBtn;

    public void selectClaimedAsDependent(String claimedAsDependent){
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
        basicActions.waitForElementListToBePresent(filingJointlyWithRadio, 50);
        boolean optionSelected = false;
        for (int i = 0; i < filingJointlyWithRadio.size(); i++) {
            int adjustedIndex = i + 2;
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

    public void selectWillClaimDependents(String willFile){
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
        WebElement selectMember = basicActions.getDriver().findElement(By.xpath("//*[contains(text(), '" + memPrefix + "')]/input"));
        selectMember.click();
    }

    public void clickSaveAndContinue(){
        basicActions.waitForElementToBePresentWithRetries(existingTaxStatusHeader, 40);
        basicActions.waitForElementToBeClickableWithRetries(saveAndContinueBtn, 20);
        basicActions.scrollToElement(saveAndContinueBtn);
        saveAndContinueBtn.click();
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
        basicActions.waitForElementToBePresent(existingTaxStatusHeader, 15);
        basicActions.waitForElementToBePresent(saveAndContinueBtn, 15);

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
        for (int i = 0; i < filteredMemNames.size(); i++) {
            int adjustedIndex = i + 1;
            softAssert.assertEquals(whoClaimedAsDependentsRadioTxt.get(adjustedIndex).getText(), filteredMemNames.get(i), "Mismatch at radio index: " + (i + 1));
        }
        int someoneElseIndex = filteredMemNames.size() + 1;
        if (someoneElseIndex < whoClaimedAsDependentsRadioTxt.size()) {
            softAssert.assertEquals(whoClaimedAsDependentsRadioTxt.get(someoneElseIndex).getText(), someoneElseText, "'Someone else' option text does not match.");
        } else {
            throw new AssertionError("'Someone else' option is missing in the radio list.");
        }
        softAssert.assertAll();
    }

    public void verifyOnlyMemPrefixSelected(String memPrefix) {
        boolean isMemPrefixSelected = false;
        for (int i = 0; i < whoClaimedAsDependentsRadio.size(); i++) {
            int adjustedIndex = i + 1;
            WebElement radioButton = whoClaimedAsDependentsRadio.get(i);
            String radioText = whoClaimedAsDependentsRadioTxt.get(adjustedIndex).getText().trim();
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
                if (SharedData.getEnv().equals("qa")) {//bug TAM-4947
                    softAssert.assertEquals(claimDobNameTxt.getText(), "Date of birth");
                } else {
                    softAssert.assertEquals(claimDobNameTxt.getText(), "Fecha de nacimiento");
                }
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
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
//        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif"); //bug TAM-4929
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)");
//        softAssert.assertEquals(goBackBtn.getCssValue("background"), "rgb(255, 255, 255) none repeat scroll 0% 0% / auto padding-box border-box");
        action.moveToElement(goBackBtn).pause(1000L).build().perform();
        softAssert.assertEquals(goBackBtn.getText(), "Go back");
//        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)");
//        softAssert.assertEquals(goBackBtn.getCssValue("background"), "rgb(227, 246, 255) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
//        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
//        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(255, 255, 255, 1)");
//        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background"), "rgb(26, 112, 179) none repeat scroll 0% 0% / auto padding-box border-box");
        action.moveToElement(saveAndContinueBtn).pause(1000L).build().perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Save and continue");
//        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
//        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(255, 255, 255, 1)");
//        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background"), "rgb(22, 156, 216) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertAll();
    }

    public void verifyContinueAndgoBackBtnsSpanish() {
        softAssert.assertEquals(goBackBtn.getText(), "Volver");
//        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif"); //bug TAM-4929
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)");
//        softAssert.assertEquals(goBackBtn.getCssValue("background"), "rgb(255, 255, 255) none repeat scroll 0% 0% / auto padding-box border-box");
        action.moveToElement(goBackBtn).pause(1000L).build().perform();
        softAssert.assertEquals(goBackBtn.getText(), "Volver");
//        softAssert.assertEquals(goBackBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(goBackBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(goBackBtn.getCssValue("font-weight"), "700");
        softAssert.assertEquals(goBackBtn.getCssValue("color"), "rgba(26, 112, 179, 1)");
//        softAssert.assertEquals(goBackBtn.getCssValue("background"), "rgb(227, 246, 255) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
//        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
//        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(255, 255, 255, 1)");
//        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background"), "rgb(26, 112, 179) none repeat scroll 0% 0% / auto padding-box border-box");
        action.moveToElement(saveAndContinueBtn).pause(1000L).build().perform();
        softAssert.assertEquals(saveAndContinueBtn.getText(), "Guardar y continuar");
//        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-family"), "\"PT Sans\", sans-serif");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-size"), "20px");
        softAssert.assertEquals(saveAndContinueBtn.getCssValue("font-weight"), "700");
//        softAssert.assertEquals(saveAndContinueBtn.getCssValue("color"), "rgba(255, 255, 255, 1)");
//        softAssert.assertEquals(saveAndContinueBtn.getCssValue("background"), "rgb(22, 156, 216) none repeat scroll 0% 0% / auto padding-box border-box");
        softAssert.assertAll();
    }

    public void verifySelectTaxFilingStatusQuestion(String language) {
        basicActions.waitForElementToBePresent(filingStatusTxt, 15);
        switch (language) {
            case "English":
                softAssert.assertEquals(filingStatusTxt.getText(), "Select tax filing status");
                softAssert.assertTrue(filingStatusHelp.getAttribute("class").contains("help-icon"), "Found "+filingStatusHelp.getAttribute("class"));
                softAssert.assertEquals(filingStatusDpd.get(0).getText(), "Select Option");
                softAssert.assertEquals(filingStatusDpd.get(1).getText(), "Married filing jointly");
                if (SharedData.getEnv().equals("qa")) {//bug TAM-4903 (will go into Staging with next release)
                    softAssert.assertEquals(filingStatusDpd.get(5).getText(), "Qualified widow(er) with dependent(s)");
                    softAssert.assertEquals(filingStatusDpd.get(2).getText(), "Married filing separately");
                    softAssert.assertEquals(filingStatusDpd.get(3).getText(), "Head of household");
                } else {
                    softAssert.assertEquals(filingStatusDpd.get(2).getText(), "Qualified widow(er) with dependent(s)");
                    softAssert.assertEquals(filingStatusDpd.get(3).getText(), "Married filing single");
                    softAssert.assertEquals(filingStatusDpd.get(5).getText(), "Head of household");
                }
                softAssert.assertEquals(filingStatusDpd.get(4).getText(), "Single");
                softAssert.assertEquals(exceptionalCircumstancesTxt.getText(), "Exceptional circumstances?");
                break;
            case "Spanish":
                if (SharedData.getEnv().equals("qa")) {//bug TAM-4903 (will go into Staging with next release)
                    softAssert.assertEquals(filingStatusTxt.getText(), "Seleccione su estatus de declaraci\u00F3n de impuestos");
                    softAssert.assertTrue(filingStatusHelp.getAttribute("class").contains("help-icon"), "Found "+filingStatusHelp.getAttribute("class"));
                    softAssert.assertEquals(filingStatusDpd.get(0).getText(), "Seleccione");
                    softAssert.assertEquals(filingStatusDpd.get(1).getText(), "Casados que declaran juntos");
                    softAssert.assertEquals(filingStatusDpd.get(2).getText(), "Casados que declaran por separado");
                    softAssert.assertEquals(filingStatusDpd.get(3).getText(), "Jefe/a de hogar");
                    softAssert.assertEquals(filingStatusDpd.get(4).getText(), "Soltero/a");
                    softAssert.assertEquals(filingStatusDpd.get(5).getText(), "Viudo/a calificado con dependiente");
                    softAssert.assertEquals(exceptionalCircumstancesTxt.getText(), "Circunstancias excepcionales");
                } else {
                    softAssert.assertEquals(filingStatusTxt.getText(), "Seleccione su estatus de declaraci\u00F3n de impuestos");
                    softAssert.assertTrue(filingStatusHelp.getAttribute("class").contains("help-icon"), "Found "+filingStatusHelp.getAttribute("class"));
                    softAssert.assertEquals(filingStatusDpd.get(0).getText(), "Seleccione");
                    softAssert.assertEquals(filingStatusDpd.get(1).getText(), "Married filing jointly");
                    softAssert.assertEquals(filingStatusDpd.get(2).getText(), "Qualified widow(er) with dependent(s)");
                    softAssert.assertEquals(filingStatusDpd.get(3).getText(), "Married filing single");
                    softAssert.assertEquals(filingStatusDpd.get(4).getText(), "Single");
                    softAssert.assertEquals(filingStatusDpd.get(5).getText(), "Head of household");
                    softAssert.assertEquals(exceptionalCircumstancesTxt.getText(), "Circunstancias excepcionales");
        }
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
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
            if (SharedData.getEnv().equals("qa")) {//bug TAM-4900 (will go into Staging with next release)
                expectedQuestionText = language.equalsIgnoreCase("English")
                        ? "Who will "+basicActions.getMemFirstNames(memPrefix)+" be filing jointly with?"
                        : "\u00BFCon qui\u00E9n declarar\u00E1 impuestos en conjunto "+basicActions.getMemFirstNames(memPrefix)+"?";
            } else {
                expectedQuestionText = language.equalsIgnoreCase("English")
                        ? "Who will "+basicActions.getMemFirstNames(memPrefix)+" you be filing jointly with?"
                        : "\u00BFCon qui\u00E9n declarar\u00E1 impuestos en conjunto "+basicActions.getMemFirstNames(memPrefix)+"?";
            }
            someoneElseText = language.equalsIgnoreCase("English")
                    ? "Someone else"
                    : "Otra persona";
        }
        softAssert.assertEquals(filingJointlyWithTxt.getText(), expectedQuestionText);
        for (int i = 0; i < expectedMembersList.size(); i++) {
            int adjustedIndex = i + 2;
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(adjustedIndex).getText(), expectedMembersList.get(i), "Mismatch at radio index: " + adjustedIndex);
        }
        int someoneElseIndex = expectedMembersList.size() + 2;
        if (someoneElseIndex < filingJointlyWithRadioTxt.size()) {
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(someoneElseIndex).getText(), someoneElseText, "'Someone else' option text does not match.");
        }
        softAssert.assertAll();
    }

    public void verifyFilingJointlyWithAnswers(String memOption, String language,List<Map<String, String>> expectedMembers) {
        basicActions.waitForElementToBePresent(filingJointlyWithTxt, 15);
        List<String> expectedMembersList = expectedMembers.stream().map(map -> map.get("ExpectedMembers")).filter(Objects::nonNull).map(basicActions::getMemFirstLastNames).collect(Collectors.toList());
        boolean memOptionMatched = false;

        for (int i = 0; i < expectedMembersList.size(); i++) {
            int adjustedIndex = i + 2;
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(adjustedIndex).getText(), expectedMembersList.get(i), "Mismatch at radio index (text): " + adjustedIndex);
            if (memOption != null && !memOption.isEmpty() && expectedMembersList.get(i).toLowerCase().startsWith(memOption.toLowerCase())) {
                memOptionMatched = true;
                softAssert.assertTrue(filingJointlyWithRadio.get(i).isSelected(), "Radio button for " + expectedMembersList.get(i) + " is not selected as memOption.");
            } else {
                softAssert.assertFalse(filingJointlyWithRadio.get(i).isSelected(), "Radio button for " + expectedMembersList.get(i) + " is unexpectedly selected.");
            }
        }

        String someoneElseText = language.equalsIgnoreCase("Spanish") ? "Otra persona" : "Someone else";
        int someoneElseIndex = expectedMembersList.size() + 2;

        if (someoneElseIndex < filingJointlyWithRadioTxt.size()) {
            softAssert.assertEquals(filingJointlyWithRadioTxt.get(someoneElseIndex).getText(), someoneElseText, "'" + someoneElseText + "' option text does not match.");
            if (memOption == null || memOption.isEmpty()) {
                softAssert.assertFalse(filingJointlyWithRadio.get(expectedMembersList.size()).isSelected(), "'" + someoneElseText + "' radio button is unexpectedly selected when memOption is empty.");
            } else if (someoneElseText.toLowerCase().startsWith(memOption.toLowerCase())) {
                memOptionMatched = true;
                softAssert.assertTrue(filingJointlyWithRadio.get(expectedMembersList.size()).isSelected(), "'" + someoneElseText + "' radio button is not selected as memOption.");
            } else {
                softAssert.assertFalse(filingJointlyWithRadio.get(expectedMembersList.size()).isSelected(), "'" + someoneElseText + "' radio button should not be selected.");
            }
        }

        if (memOption == null || memOption.isEmpty()) {
            for (int i = 0; i < filingJointlyWithRadio.size(); i++) {
                softAssert.assertFalse(filingJointlyWithRadio.get(i).isSelected(), "Unexpected radio button selected at index: " + i);
            }
        } else if (!memOptionMatched) {
            softAssert.fail("No radio button matched the provided memOption: " + memOption);
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
                if (SharedData.getEnv().equals("qa")) {//bug ???
                    softAssert.assertEquals(filingDobNameTxt.getText(), "Date of birth");
                } else {
                    softAssert.assertEquals(filingDobNameTxt.getText(), "Fecha de nacimiento");
                }
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
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

    public void verifyWhoClaimedQuestion(String memPrefix,String language) {
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
        for (int i = 0; i < filteredMemNames.size(); i++) {
            softAssert.assertEquals(whoClaimedMemNameTxt.get(i).getText(), filteredMemNames.get(i), "Mismatch at radio index: " + i);
        }
        int someoneElseIndex = filteredMemNames.size();
        if (someoneElseIndex < whoClaimedBtn.size()) {
            String someoneElseText = language.equalsIgnoreCase("Spanish") ? "Otra persona" : "Someone else";
            softAssert.assertEquals(whoClaimedMemNameTxt.get(someoneElseIndex).getText(), someoneElseText, "'" + someoneElseText + "' option text does not match.");
        } else {
            throw new AssertionError("'Someone else' option is missing in the button list.");
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
                if (SharedData.getEnv().equals("qa")) {//bug ???
                    softAssert.assertEquals(claimedDobNameTxt.getText(), "Date of birth");
                } else {
                    softAssert.assertEquals(claimedDobNameTxt.getText(), "Fecha de nacimiento");
                }
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
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
        List<String> taxReturnIds = null;

        if (memPrefix.equals("Primary")) {
            taxReturnIds = SharedData.getPrimaryMember().getTaxReturnId();
            System.out.println("Primary Tax Return ID is "+taxReturnIds);
        } else {
            List<MemberDetails> members = SharedData.getMembers();
            for (MemberDetails mem : members) {
                if (mem.getFirstName().contains(memPrefix)) {
                    taxReturnIds = mem.getTaxReturnId();
                    System.out.println(memPrefix+" Tax Return ID is "+taxReturnIds);
                    break;
                }
            }
        }
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
            System.out.println("An error occurred while verifying tax_return_id for member " + memPrefix + ": " + e.getMessage());
        }
    }


}