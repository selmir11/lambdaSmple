package com.c4hco.test.automation.pages.exchPages;

import com.beust.jcommander.converters.CommaParameterSplitter;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class TellUsAboutAdditionalMemberPage {

    private BasicActions basicActions;

    public TellUsAboutAdditionalMemberPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(css = "c4PageHeader")
    WebElement txtheader;

    @FindBy(id = "firstName")
    WebElement txtfirstName;

    @FindBy(id = "middleName")
    WebElement txtmiddleName;

    @FindBy(id = "lastName")
    WebElement txtlastName;

    @FindBy(id = "dateOfBirth")
    WebElement txtdateOfBirth;

    @FindBy(id = "genderFemale")
    WebElement rdobtngenderFemale;
    @FindBy(id = "isPregnantFalse")
    WebElement IsPersonPregnentNo;
    @FindBy(id = "isPregnantTrue")
    WebElement IsPersonPregnentYes;
    @FindBy(id = "genderMale")
    WebElement rdobtngenderMale;

    @FindBy(id = "memberRelationship0")
    WebElement selectRelationship;
    @FindBy(id = "memberRelationship1")
    WebElement selectRelationship1;
    @FindBy(id = "memberRelationship2")
    WebElement selectRelationship2;
    @FindBy(id = "memberRelationship3")
    WebElement selectRelationship3;

    @FindBy(id = "coverageYes")
    WebElement rdobtnIsMemberApplingYes;

    @FindBy(id = "coverageNo")
    WebElement rdobtnIsMemberApplyingNo;

    @FindBy(id = "ssn")
    WebElement txtSSN;

    @FindBy(id = "haveAppliedForSSNYes")
    WebElement rdbhaveAppliedForSSNYes;

    @FindBy(id = "haveSsn")
    WebElement rdbhaveSsn;

    @FindBy(xpath = "//*[@id='continueButton']")
    WebElement btnsaveAndContinue;
    @FindBy(xpath = "//*[@id='backButton']")
    WebElement btnBack;

    @FindBy(id = "totalBabiesExpected")
    WebElement selecttotalBabiesExpected;

    @FindBy(id = "expectedDueDate")
    WebElement expectedDueDate;



    SoftAssert softAssert = new SoftAssert();

    public static String getUniqueString(int length) {
        return RandomStringUtils.random(length, "abcdefghijklmnopqrstuvwxyz");
    }


    public void enterMemberDetails(String DOB){
        String frstName = basicActions.capitalizeFirstLetter(getUniqueString(20));
        String mdlName = basicActions.capitalizeFirstLetter(getUniqueString(8));
        String lastName = basicActions.capitalizeFirstLetter(getUniqueString(13));
        basicActions.waitForElementToBePresent(txtheader, 1);
        basicActions.waitForElementToBePresent(txtfirstName, 30);
        txtfirstName.sendKeys(frstName);
        txtmiddleName.sendKeys(mdlName);
        txtlastName.sendKeys(lastName);
        txtdateOfBirth.sendKeys(DOB);
        txtSSN.sendKeys("653035280");
        List<MemberDetails> memberList = SharedData.getMembers();
        if (memberList == null) {
            memberList = new ArrayList<>();
        }
        MemberDetails member = new MemberDetails();
        member.setFirstName(frstName);
        member.setLastName(lastName);
        member.setMiddleName(mdlName);
        member.setDob(DOB);
        member.setSignature(frstName + " " + lastName);
        member.setFullName(frstName + " " + mdlName.charAt(0) + ". " + lastName);
        member.setCompleteFullName(frstName + " " + mdlName + " " + lastName);
        memberList.add(member);

        SharedData.setMembers(memberList);
    }

    public void selectNoSSn(String memberPrefix) {
        List<MemberDetails> members = SharedData.getMembers();
        basicActions.waitForElementToBePresent(rdbhaveSsn, 1);
        rdbhaveSsn.click();
        basicActions.waitForElementToBePresent(rdbhaveAppliedForSSNYes, 1);
        rdbhaveAppliedForSSNYes.click();
        members.stream().filter(member -> member.getFirstName().contains(memberPrefix)).findFirst().ifPresent(member -> member.setSsn(null));
    }

    public void selectSex(String Sex) {
        switch (Sex) {
            case "Female":
                rdobtngenderFemale.click();
                break;
            case "Male":
                rdobtngenderMale.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + Sex);
        }
    }
    public void selectIsPersonPregnant(String pregnant) {
        switch (pregnant) {
            case "Yes":
                IsPersonPregnentYes.click();
                break;
            case "No":
                IsPersonPregnentNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + pregnant);
        }
    }

    public void setSelectRelationship(String Relation) {
        basicActions.waitForElementToBePresent(selectRelationship, 15);
        Select dropdown = new Select(selectRelationship);
        dropdown.selectByVisibleText(Relation);
        List<MemberDetails> memberList = SharedData.getMembers();
        memberList.get(memberList.size() - 1).setRelation_to_subscriber(Relation);
    }
    public void selectNewRelationship(String Relation){
        basicActions.waitForElementToBePresent(selectRelationship, 15);
        basicActions.waitForElementToBeClickable(selectRelationship, 15);
        Select dropdown = new Select(selectRelationship);
        dropdown.selectByVisibleText(Relation);
    }

    public void setSelectRelationship1(String Relation) {
        basicActions.waitForElementToBePresent(selectRelationship1, 15);

        Select dropdown = new Select(selectRelationship1);
        dropdown.selectByVisibleText(Relation);
    }

    public void setSelectRelationship2(String Relation) {
        basicActions.waitForElementToBePresent(selectRelationship2, 15);

        Select dropdown = new Select(selectRelationship2);
        dropdown.selectByVisibleText(Relation);
    }

    public void setSelectRelationship3(String Relation) {
        basicActions.waitForElementToBePresent(selectRelationship3, 15);

        Select dropdown = new Select(selectRelationship3);
        dropdown.selectByVisibleText(Relation);
    }

    public void isMemberApplyingForInsurance(String Applying) {
        switch (Applying) {
            case "Yes":
                rdobtnIsMemberApplingYes.click();
                break;
            case "No":
                rdobtnIsMemberApplyingNo.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + Applying);
        }
    }

    public void clickSaveAndContinue()    {
        basicActions.waitForElementToBePresent(btnsaveAndContinue,90);
        basicActions.scrollToElement(btnsaveAndContinue);
        btnsaveAndContinue.click();
    }

    public void clickBackButton()    {
        basicActions.waitForElementToBePresent(btnBack,20);
        basicActions.scrollToElement(btnBack);
        btnBack.click();
    }
    public void memberDetailswithAge(int Age) {
        LocalDate currentDate = LocalDate.now();
        LocalDate DOBCalculate = currentDate.minusYears(Age);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        String actualdob = dateFormat.format(DOBCalculate);
        enterMemberDetails(actualdob);
    }

    public void getDob(String namePrefix, String dob) {
        basicActions.getDob(namePrefix, dob);
    }

    public void specificAdditionalMemberDetailsExch(String name, String dob, String gender, List<String> relations, String applying) {
        String frstName = name + getUniqueString(8);
        String mdlName = basicActions.capitalizeFirstLetter(getUniqueString(8));
        String lastName = basicActions.capitalizeFirstLetter(getUniqueString(13));
        basicActions.waitForElementToBePresent(txtheader, 1);
        basicActions.waitForElementToBePresent(txtfirstName, 30);
        txtfirstName.sendKeys(frstName);
        txtmiddleName.sendKeys(mdlName);
        txtlastName.sendKeys(lastName);
        if (dob.equals("getFromSharedData")) {
            dob = SharedData.getCalculatedDob().get(name);
            dob = basicActions.changeDateFormat(dob, "MM/dd/yyyy", "MMddyyyy");
        } else if (dob.contains("Age")) {
            memberDetailswithAge(Integer.parseInt(dob.replaceAll("\\D", "")));
        }
        txtdateOfBirth.sendKeys(dob);
        txtSSN.sendKeys("653035280");
        selectSex(gender);

        if (IsPersonPregnentNo.isDisplayed()) {
            selectIsPersonPregnant("No");
        }
        setMember(frstName, lastName, mdlName, dob, gender);

        for (String Relation : relations) {
            selectRelationship(Relation);
        }
        isMemberApplyingForInsurance(applying);
    }

    private void setMember(String frstName, String lastName, String mdlName, String dob, String gender) {
        List<MemberDetails> memberList = SharedData.getMembers();
        if (memberList == null) {
            memberList = new ArrayList<>();
        }
        MemberDetails member = new MemberDetails();
        member.setFirstName(frstName);
        member.setLastName(lastName);
        member.setMiddleName(mdlName);
        member.setDob(dob);
        member.setGender(gender);
        member.setSignature(frstName + " " + lastName);
        member.setFullName(frstName + " " + mdlName.charAt(0) + ". " + lastName);
        member.setCompleteFullName(frstName + " " + mdlName + " " + lastName);
        member.setSsn("653035280");
        member.setEmailId(SharedData.getPrimaryMember().getEmailId());
        member.setPhoneNumber(SharedData.getPrimaryMember().getPhoneNumber());
        member.setAlternatePhNum(SharedData.getPrimaryMember().getAlternatePhNum());
        member.setSpokenLanguage("English");
        member.setWrittenLanguage("English");
        memberList.add(member);
        SharedData.setMembers(memberList);
    }

    public void selectRelationship(String Relationship) {
        String[] parts = Relationship.split(":");
        String Name = parts[0];  // "Primary"
        String Relation = parts[1]; // "Spouse"

        try {
            List<MemberDetails> members = SharedData.getMembers();

            basicActions.waitForElementToBePresent(selectRelationship, 40);
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
    public void updateMemSSN(String memprefix, String updatedSSN) {
        List<MemberDetails> members = SharedData.getMembers();
        basicActions.waitForElementToBePresent(txtSSN, 20);
        for(MemberDetails member: members){
            if(member.getFirstName().contains(memprefix)){
                String oldSSN = member.getSsn();
                System.out.println("Old SSN:: "+oldSSN);
                member.setSsn(updatedSSN);
                member.setHasIncorrectEntities(true);
                member.setIncorrectEntityTypeQualifier("1");
                member.setIncorrectEntityIdCode("70");
                member.setIncorrectIdCodeQualifier("34");
                member.setIncorrect_first_name(member.getFirstName());
                member.setIncorrect_last_name(member.getLastName());
                member.setIncorrectIdCode(oldSSN);
                System.out.println("SSN updated successfully for :: "+ member.getFirstName());
            }
        }
        txtSSN.clear();
        txtSSN.sendKeys(updatedSSN);
        txtSSN.sendKeys(Keys.TAB);
    }

    public void additionalMemberDetailsSameAsPrimary(String memberCondition,List<String> relations) {
        basicActions.waitForElementToBePresent(txtheader, 1);
        basicActions.waitForElementToBePresent(txtfirstName, 30);
        String[] details = getMemberDetailsBasedOnCondition(memberCondition);
        String firstName = details[0];
        String middleName = details[1];
        String lastName = details[2];
        String ssn = details[3];
        String dob = SharedData.getPrimaryMember().getDob();
        String gender = SharedData.getPrimaryMember().getGender();
        txtfirstName.sendKeys(firstName);
        txtmiddleName.sendKeys(middleName);
        txtlastName.sendKeys(lastName);
        txtdateOfBirth.sendKeys(dob);
        txtSSN.sendKeys(ssn);
        selectSex(gender);
        if (IsPersonPregnentNo.isDisplayed()) {
            selectIsPersonPregnant("No");
        }
        setMember(firstName, lastName, middleName, dob, gender);
        for (String relation : relations) {
            selectRelationship(relation);
        }
        isMemberApplyingForInsurance("Yes");
    }


    private  String[] getMemberDetailsBasedOnCondition(String memberCondition) {
        String firstName =null;
        String middleName =null;
        String lastName =null;
        String ssn =null;
        switch (memberCondition.toLowerCase()) {
            case "sameasprimarymember":
                 firstName = SharedData.getPrimaryMember().getFirstName();
                 middleName = SharedData.getPrimaryMember().getMiddleName();
                 lastName = SharedData.getPrimaryMember().getLastName();
                 ssn = SharedData.getPrimaryMember().getSsn();
                break;
            case "uniquefirstnameandmiddle":
                firstName = getUniqueString(10);
                middleName = getUniqueString(10);
                 lastName = SharedData.getPrimaryMember().getLastName();
                 ssn = SharedData.getPrimaryMember().getSsn();
                break;
            case "uniquessn":
                firstName = SharedData.getPrimaryMember().getFirstName();
                 middleName = SharedData.getPrimaryMember().getMiddleName();
                 lastName = SharedData.getPrimaryMember().getLastName();
                ssn = basicActions.getUniqueNumber(9);
                break;
            default:
                throw new IllegalArgumentException("Invalid member condition: " + memberCondition);
        }
         String[] nameInfo = {firstName,middleName,lastName,ssn};
        return nameInfo;
    }

    public void selectTotalBabiesAndSetDueDate(int totalBabies, String expectedDate) {
        basicActions.waitForElementToBePresent(selecttotalBabiesExpected, 1);
        selecttotalBabiesExpected.sendKeys(String.valueOf(totalBabies));
        String resolvedDate = basicActions.getDateBasedOnRequirement(expectedDate);
        String formattedDate = basicActions.changeDateFormat(resolvedDate, "yyyy-MM-dd", "MM/dd/yyyy");
        expectedDueDate.sendKeys(formattedDate);
    }
    public void updateMemberFullName() {
        basicActions.waitForElementToBePresent(txtfirstName, 50);
        txtfirstName.clear();
        String newFirstName = "UPDfirst" + basicActions.getUniqueString(5);
        txtfirstName.sendKeys(newFirstName);
        System.out.println("First Name updated to "+newFirstName);

        txtmiddleName.clear();
        String newMiddleName = "UPDmiddle"+basicActions.getUniqueString(5);
        txtmiddleName.sendKeys(newMiddleName);
        System.out.println("Middle Name updated to "+newMiddleName);

        txtlastName.clear();
        String newLastName = "UPDlast"+basicActions.getUniqueString(5);
        txtlastName.sendKeys(newLastName);
        System.out.println("Last Name updated to "+newLastName);
       }
    public void updateMemberDOB(String memPrefix, String newDOB){
        basicActions.waitForElementToBeClickable(txtdateOfBirth,50);
        txtdateOfBirth.clear();
        txtdateOfBirth.sendKeys(newDOB);
    }
}
