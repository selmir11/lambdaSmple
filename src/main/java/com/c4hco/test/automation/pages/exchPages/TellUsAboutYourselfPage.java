package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.NoSuchElementException;

import static com.c4hco.test.automation.utils.Race.getCodeForRace;


public class TellUsAboutYourselfPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();


    public TellUsAboutYourselfPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "firstName")
    WebElement txtFirstName;

    @FindBy(id = "middleName")
    WebElement txtMiddleName;

    @FindBy(id = "lastName")
    WebElement txtLastName;

    @FindBy(id = "nameSuffix")
    WebElement selectSuffix;

    @FindBy(css = "#nameSuffix > option")
    List<WebElement> suffixDropdownOptions;

    @FindBy(id = "dateOfBirth")
    WebElement dob;

    @FindBy(id = "genderFemale")
    WebElement rdobtnSexFemale;

    @FindBy(id = "genderMale")
    WebElement rdobtnSexMale;

    @FindBy(id = "coverageYes")
    WebElement rdobtnApplyingYes;

    @FindBy(id = "coverageNo")
    WebElement rdobtnApplyingNo;

    @FindBy(id = "ssn")
    WebElement ssn;

    @FindBy(css = "#haveSsn")
    WebElement checkboxNoSsn;

    @FindBy(id = "haveAppliedForSSNYes")
    WebElement rdobtnAppliedYes;

    @FindBy(id = "haveAppliedForSSNNo")
    WebElement rdobtnAppliedNo;

    @FindBy(css = "#addMember #continueButton")
    WebElement btnSaveAndContinue;

    @FindBy(id = "isPregnantFalse" )
    WebElement rdobtnPregnantNo;

    @FindBy(id = "isPregnantTrue")
    WebElement rdobtnPregnantYes;

    @FindBy(css = "div:nth-child(5) p")
    WebElement hdrSsaError;

    @FindBy(id = "backButton" )
    WebElement btnBack;
    @FindBy(css = "div.modal-body p")
    List<WebElement> restrictMultipleEditsPopUp;

    @FindBy(css ="div.modal-body span")
    List<WebElement> restrictMultipleEditsPopUpPart;
    @FindBy(xpath = "//button[text()='Close']")
    WebElement closeRestrictedEditsPopupEnglish;
    @FindBy(xpath = "//button[text()='Cerrar']")
    WebElement closeRestrictedEditsPopupSpanish;
    @FindBy(css = "input.linkButton.redirect-link")
    WebElement primaryContactChangeLink;
    @FindBy(xpath = "//*[@id='restrictMultipleEdits']/div/div/div[1]/label[2]/input")
    WebElement linkToAddNewPerson;

    @FindBy(id = "memberRelationship0")
    WebElement drpdwnRealtionship;


    @FindBy(xpath = "//*[@class = 'form-control']")
    List<WebElement> drpdwnExpected;

    @FindBy(xpath = "//*[@id='expectedDueDate']")
    WebElement expectedDOB;

    @FindBy(id="totalBabiesExpected")
    WebElement babiesExpected;

    public void userSexQuestion(String Sex) {
        MemberDetails acctHolder = SharedData.getPrimaryMember();
        acctHolder.setGender(Sex);
        SharedData.setPrimaryMember(acctHolder);
        switch (Sex) {
            case "Female":
                rdobtnSexFemale.click();
                break;
            case "Male":
                rdobtnSexMale.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + Sex);
        }
    }

    public void isUserApplyingForHealthInsurance(String YNApplying){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        switch(YNApplying){
            case "Yes":
                rdobtnApplyingYes.click();
                break;
            case "No":
                rdobtnApplyingNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + YNApplying);
        }
        subscriber.setApplyingforCov(YNApplying);
    }

    public void saveAndContinue(){
        basicActions.waitForElementToBePresent(btnSaveAndContinue, 20);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", btnSaveAndContinue);
        basicActions.waitForElementToDisappear(btnSaveAndContinue, 5);
    }

    public void iUpdateSSN(String newSsn){
        basicActions.waitForElementToBePresent(ssn, 20);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        String oldSsn = subscriber.getSsn();
        System.out.println("Old ssn: " + oldSsn);
        subscriber.setOldSsn(oldSsn);
        ssn.clear();
        ssn.sendKeys(newSsn);
        subscriber.setSsn(newSsn);
        System.out.println("ssn updated");
        subscriber.setHasIncorrectEntities(true);
        subscriber.setIncorrectEntityTypeQualifier("1");
        subscriber.setIncorrectIdCodeQualifier("34");
        subscriber.setIncorrectIdCode(oldSsn);
        subscriber.setIncorrectEntityIdCode("70");
        subscriber.setIncorrect_first_name(subscriber.getFirstName());
        subscriber.setIncorrect_middle_name(subscriber.getMiddleName());
        subscriber.setIncorrect_last_name(subscriber.getLastName());
        SharedData.setPrimaryMember(subscriber);
    }

   public void updateFullName(String namePrefix){
        List<MemberDetails> membersList = basicActions.getAllMem();
        for(MemberDetails member: membersList){
            if(member.getFirstName().contains(namePrefix)){
                String oldFirstName = member.getFirstName();
                String oldMiddleName = member.getMiddleName()!=null ? member.getMiddleName() : "";
                String oldLastName = member.getLastName();
                member.setHasIncorrectEntities(true);

                String newFirstName = namePrefix+basicActions.getUniqueString(8);
                String newMiddleName = "Test";
                String newLastName = "update"+ member.getLastName();

                member.setIncorrectEntityTypeQualifier("1");
                member.setIncorrectEntityIdCode("70");
                member.setIncorrect_first_name(oldFirstName);
                member.setIncorrect_middle_name(oldMiddleName);
                member.setIncorrect_last_name(oldLastName);
             //   member.setIncorrectIdCodeQualifier("34"); - WIP - POL-9151

                member.setFirstName(newFirstName);
                member.setMiddleName(newMiddleName);
                member.setLastName(newLastName);
                member.setSignature(newFirstName+" "+newLastName);
                member.setFullName(newFirstName+" "+newMiddleName.toUpperCase().charAt(0)+". "+newLastName);
                member.setCompleteFullName(newFirstName+" "+newMiddleName+" "+newLastName);

                basicActions.waitForElementToBePresent(txtFirstName, 50);
                basicActions.clearElementWithRetries(txtFirstName);
                txtFirstName.sendKeys(newFirstName);
                basicActions.clearElementWithRetries(txtMiddleName);
                txtMiddleName.sendKeys(newMiddleName);
                basicActions.clearElementWithRetries(txtLastName);
                txtLastName.sendKeys(newLastName);
                break;
            }
        }
    }

    public void updateName(){
        MemberDetails subscriber = new MemberDetails();
        basicActions.waitForElementToBePresent(txtFirstName, 50);
        txtFirstName.clear();
        String newFirstName = "PrimaryAmend";
        txtFirstName.sendKeys(newFirstName);
        subscriber.setFirstName(newFirstName);
        System.out.println("First Name updated to "+newFirstName);

        txtMiddleName.clear();
        String newMiddleName = "Revise";
        txtMiddleName.sendKeys(newMiddleName);
        subscriber.setMiddleName(newMiddleName);
        subscriber.setMiddleInitial("R.");
        System.out.println("Middle Name updated to "+newMiddleName);

        txtLastName.clear();
        String newLastName = "Improve";
        txtLastName.sendKeys(newLastName);
        subscriber.setLastName(newLastName);
        System.out.println("Last Name updated to "+newLastName);

        String newSuffix = "Sr.";
        selectSuffix.click();
        basicActions.selectValueFromDropdown(selectSuffix, suffixDropdownOptions, newSuffix);
        subscriber.setSuffix(newSuffix);
        System.out.println("Suffix updated to "+newSuffix);

        subscriber.setFullName(subscriber.getFirstName()+" "+subscriber.getMiddleInitial()+" "+subscriber.getLastName()+" "+subscriber.getSuffix());
        subscriber.setSignature(subscriber.getFirstName()+" "+subscriber.getLastName());
        SharedData.setPrimaryMember(subscriber);
    }

    public void updateDOB(String newDob){
        basicActions.waitForElementToBePresent(dob, 20);
        dob.clear();
        dob.sendKeys(newDob);
        SharedData.getPrimaryMember().setDob(newDob);
        System.out.println("dob updated");
    }

    public void validateSsaError(String SSN){
        basicActions.waitForElementToBePresent(hdrSsaError, 20);

        switch(SSN){
            case "012123456":
                softAssert.assertEquals(hdrSsaError.getText(), "Make sure the name and the Social Security number you entered match your Social Security card and try again.");
                break;
            case "890901235":
                softAssert.assertEquals(hdrSsaError.getText(), "Make sure the date of birth and the Social Security number you entered are correct and try again.");
                break;
            case "890901234":
                softAssert.assertEquals(hdrSsaError.getText(), "Make sure the name, date of birth and the Social Security number you entered match your Social Security card and try again.");
                break;
            case "789890123":
                softAssert.assertEquals(hdrSsaError.getText(), "Make sure that the Social Security number you entered is correct and try again.");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + SSN);
        }

        softAssert.assertAll();
    }

    public void clickNoSsnBox(String applied){
        basicActions.waitForElementToBePresent(checkboxNoSsn, 20);
        checkboxNoSsn.click();
        switch (applied){
            case "Yes":
                rdobtnAppliedYes.click();
                break;
            case "No":
                rdobtnAppliedNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + applied);
        }
    }

    public void clickBackButton(){
        basicActions.waitForElementToBePresent(btnBack, 20);
        btnBack.click();
    }
    public void validateRestrictMultipleFieldEditsError(List<String> textToVerify) {
        basicActions.waitForElementToBePresent(restrictMultipleEditsPopUp.get(0), 20);
        softAssert.assertEquals(restrictMultipleEditsPopUp.get(0).getText(), textToVerify.get(0) );
        softAssert.assertEquals(restrictMultipleEditsPopUp.get(1).getText(), textToVerify.get(1));
        softAssert.assertEquals(restrictMultipleEditsPopUpPart.get(0).getText(), textToVerify.get(2));
        softAssert.assertEquals(restrictMultipleEditsPopUp.get(2).getText(), textToVerify.get(3));
        softAssert.assertEquals(restrictMultipleEditsPopUpPart.get(1).getText(), textToVerify.get(4));
        softAssert.assertAll();
    }

    public void selectNewRelationship(List <String > relationship) {
        String relationshipString = relationship.get(0);
        String[] parts = relationshipString.split(":");
        String Name = parts[0];  // "Primary"
        String Relation = parts[1]; // "Spouse"

        try {
            List<MemberDetails> members = SharedData.getMembers();

            basicActions.waitForElementToBePresent(drpdwnRealtionship, 40);
            WebElement element = basicActions.getDriver().findElement(By.xpath("//*[contains(text(),'" + Name + "')]/ancestor-or-self::label/parent::div //select"));
            basicActions.waitForElementToBePresent(element, 10);
            basicActions.scrollToElement(element);
            basicActions.waitForElementToBeClickableWithRetries(element, 10);

            // Perform actions on the element
            Select dropdown = new Select(element);
            dropdown.selectByVisibleText(Relation);
            softAssert.assertTrue(dropdown.getFirstSelectedOption().getText().equals(Relation));
            softAssert.assertAll();

            for (MemberDetails member : members) {
                if (member.getFirstName().contains(Relation)) {
                    if (Relation.equals("Spouse") && member.getGender().equals("Female")) {
                        Relation = "Wife";
                    } else if (Relation.equals("Spouse") && member.getGender().equals("Male")) {
                        Relation = "Husband";
                    }
                    member.setRelation_to_subscriber(Relation.toUpperCase());
                    break;
                }
            }
            SharedData.setMembers(members);
        } catch (NoSuchElementException e) {
            System.out.println("Element not found: " + e.getMessage());
            // Handle the exception as needed
        }
    }
        public void closeRestrictMultipleFieldEditsErrorPopup(String language){
        basicActions.waitForElementToBePresent(closeRestrictedEditsPopupEnglish, 20);
        switch (language) {
            case ("English"):
                basicActions.click(closeRestrictedEditsPopupEnglish);
                break;
            case ("Spanish"):
                basicActions.click(closeRestrictedEditsPopupSpanish);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void iClickPrimaryContactChangeLink(){
        basicActions.waitForElementToBeClickable(primaryContactChangeLink, 20);
        basicActions.click(primaryContactChangeLink);
    }
    public void iClickLinkToAddNewPerson(){
        basicActions.waitForElementToBePresent(linkToAddNewPerson, 20);
        basicActions.click(linkToAddNewPerson);
    }

    public void iSetIncorrectentities(List<String> demographicMaps) {
        for(String demoMap : demographicMaps){
            String[] demographicChanges = demoMap.split(":");
            String[] demoFields = demographicChanges[0].split(",");
            String memPrefix = demographicChanges[1];

                List<MemberDetails> members = basicActions.getAllMem();
                for(MemberDetails member: members){
                    if(member.getFirstName().contains(memPrefix)){
                        member.setHasIncorrectEntities(true);
                        member.setIncorrectEntityTypeQualifier("1");
                        member.setIncorrectEntityIdCode("70");
                        member.setIncorrect_first_name(member.getFirstName());
                        member.setIncorrect_last_name(member.getLastName());
                        for (String changedField : demoFields) {
                            switch(changedField){
                                case "Gender":
                                    member.setIncorrect_gender(member.getGender().substring(0,1));
                                    break;
                                case "Race":
                                    member.setIncorrect_race(getCodeForRace(member.getRace()));
                                    break;
                                case "DOB":
                                    member.setIncorrect_dob(member.getDob());
                                    break;
                            }
                        }
                    }
            }
        }
    }

    public void userPregnantQuestion(String Pregnant) {
        switch (Pregnant){
            case "No":
                rdobtnPregnantNo.click();
                break;
            case "Yes":
                rdobtnPregnantYes.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + Pregnant);

        }

    }

    public void iSelectNumberOfBabies(String babiesDue){
        Select selectBabiesCount = new Select(babiesExpected);
        selectBabiesCount.selectByVisibleText(babiesDue);
    }


    public void setPregnancyEventDate(String eventDateType) {
        basicActions.waitForElementToBePresent(expectedDOB, 20);
        expectedDOB.clear();
        expectedDOB.click();
        switch (eventDateType) {
            case "First Date of Current Month":
                expectedDOB.sendKeys(getFirstDateOfCurrentMonth());
                break;
            case "Last Date of Current Month":
                expectedDOB.sendKeys(getLastDateOfCurrentMonth());
                break;
            case "Future Date":
                expectedDOB.sendKeys(getFutureDate());
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

}
