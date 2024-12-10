package com.c4hco.test.automation.pages.exchPages;

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

public class TaxStatusPage_Elmo {
    private BasicActions basicActions;
    public TaxStatusPage_Elmo(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
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

    @FindBy(css = ".c4-input select option")
    List<WebElement> filingStatusDpd;

    @FindBy(css = "#ELIG-taxStatus-exceptional-container span")
    WebElement exceptionalCircumstancesTxt;

    @FindBy(css = "#ELIG-taxStatus-willClaimDependents-container span")
    WebElement willClaimDependentsTxt;

    @FindBy(id = "ELIG-taxStatus-willClaimDependents-yesButton")
    WebElement willClaimDependentsYes;

    @FindBy(id = "ELIG-taxStatus-willClaimDependents-noButton")
    WebElement willClaimDependentsNo;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-container span")
    WebElement filingJointlyWithTxt;

    @FindBy(css = "#ELIG-taxStatus-filingJointlyWith-container input")
    List<WebElement> filingJointlyWithRadio;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-container .row.label-row label")
    WebElement whoClaimedAsDependentsTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-container .row.input-row label")
    List<WebElement> whoClaimedAsDependentsRadioTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-container .row.input-row label input")
    List<WebElement> whoClaimedAsDependentsRadio;

    @FindBy(css = "app-member-select app-new-member span")
    WebElement enterNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-firstName-container label")
    WebElement firstNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-firstName")
    WebElement firstNameInput;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-middleName-container label")
    WebElement middleNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-middleName")
    WebElement middleNameInput;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-lastName-container label")
    WebElement lastNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-lastName")
    WebElement lastNameInput;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-suffix-container label")
    WebElement suffixNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-suffix")
    WebElement suffixNameDpd;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-dob-container label")
    WebElement dobNameTxt;

    @FindBy(css = "#ELIG-taxStatus-whoWillClaim-newMember-dob")
    WebElement dobNameInput;



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

        switch (filingJointlyOption) {
            case "Spouse":
                filingJointlyWithRadio.get(0).click();
                break;
            case "Someone else":
                filingJointlyWithRadio.get(1).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + filingJointlyOption);
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
        firstNameInput.sendKeys(nameData.get(0).get("First Name"));
        middleNameInput.sendKeys(nameData.get(0).get("Middle Name"));
        lastNameInput.sendKeys(nameData.get(0).get("Last Name"));
        suffixNameDpd.sendKeys(nameData.get(0).get("Suffix"));
        dobNameInput.sendKeys(nameData.get(0).get("DOB"));
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

    public void verifyWillYouBeClaimedAsDependentQuestion(String language){
        basicActions.waitForElementToBePresent(claimedAsDependentTxt, 15);
        switch (language) {
            case "English":
                softAssert.assertEquals(claimedAsDependentTxt.getText(), "Will you be claimed as a dependent on someone else's tax return next year?");
                softAssert.assertTrue(claimedAsDependentHlpIcon.getAttribute("class").contains("help-icon"), "Found "+claimedAsDependentHlpIcon.getAttribute("class"));
                softAssert.assertEquals(claimedAsDependentYesTxt.getText(), "Yes");
                softAssert.assertEquals(claimedAsDependentNoTxt.getText(), "No");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(claimedAsDependentTxt.getText(), "\u00BFSe presentar\u00E1 a como dependiente en la declaraci\u00F3n de impuestos de otra persona el pró\u00F3ximo a\u00F1o?");
                softAssert.assertTrue(claimedAsDependentHlpIcon.getAttribute("class").equals("help-icon"), "Found "+claimedAsDependentHlpIcon.getAttribute("class"));
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

    public void verifyFileTaxReturnQuestion(String language){
        basicActions.waitForElementToBePresent(willFileTaxReturnTxt, 15);
        switch (language) {
            case "English":
                softAssert.assertEquals(willFileTaxReturnTxt.getText(), "Will you file a federal income tax return next year?");
                softAssert.assertEquals(willFileTaxReturnYesTxt.getText(), "Yes");
                softAssert.assertEquals(willFileTaxReturnNoTxt.getText(), "No");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(willFileTaxReturnTxt.getText(), "\u00BFPresentar\u00E1 una declaraci\u00F3n de impuesto federal sobre los ingresos el pr\u00F3ximo a\u00F1o?");
                softAssert.assertEquals(willFileTaxReturnYesTxt.getText(), "S\u00ED");
                softAssert.assertEquals(willFileTaxReturnNoTxt.getText(), "No");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyFileTaxReturnAnswers(String yesStatus, String noStatus){
        basicActions.waitForElementToBePresent(claimedAsDependentYes,20);
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

        String expectedQuestionText;
        String someoneElseText;
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

    public void verifyEnterTheNameQuestion(String language){
        basicActions.waitForElementToBePresent(enterNameTxt, 15);
        switch (language) {
            case "English":
                softAssert.assertEquals(enterNameTxt.getText(), "Enter the name of who will claim you as a dependent:");
                softAssert.assertEquals(firstNameTxt.getText(), "First name");
                softAssert.assertEquals(middleNameTxt.getText(), "Middle name or initial");
                softAssert.assertEquals(lastNameTxt.getText(), "Last name");
                softAssert.assertEquals(suffixNameTxt.getText(), "Suffix");
                softAssert.assertEquals(suffixNameDpd.getText(), "Select Option\n" + "Jr.\n" + "Sr.\n" + "III\n" + "IV");
                softAssert.assertEquals(dobNameTxt.getText(), "Date of birth");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(enterNameTxt.getText(), "Ingrese el nombre de la persona que le registrará como dependiente:");
                softAssert.assertEquals(firstNameTxt.getText(), "Nombre");
                softAssert.assertEquals(middleNameTxt.getText(), "Segundo nombre o inicial");
                softAssert.assertEquals(lastNameTxt.getText(), "Apellido(s)");
                softAssert.assertEquals(suffixNameTxt.getText(), "Titulo o tratamiento");
                softAssert.assertEquals(suffixNameDpd.getText(), "Seleccione\n" + "Jr.\n" + "Sr.\n" + "III\n" + "IV");
                softAssert.assertEquals(dobNameTxt.getText(), "Date of birth");
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

        softAssert.assertEquals(firstNameInput.getAttribute("value").trim().isEmpty() ? null : firstNameInput.getAttribute("value"), firstName);
        softAssert.assertEquals(middleNameInput.getAttribute("value").trim().isEmpty() ? null : middleNameInput.getAttribute("value"), middleName);
        softAssert.assertEquals(lastNameInput.getAttribute("value").trim().isEmpty() ? null : lastNameInput.getAttribute("value"), lastName);
        softAssert.assertEquals(suffixNameDpd.getAttribute("value").trim().isEmpty() || "0: null".equals(suffixNameDpd.getAttribute("value")) ? null : suffixNameDpd.getAttribute("value"), suffix);
        softAssert.assertEquals(dobNameInput.getAttribute("value").trim().isEmpty() ? null : dobNameInput.getAttribute("value"), dob);
        softAssert.assertAll();
    }



}
