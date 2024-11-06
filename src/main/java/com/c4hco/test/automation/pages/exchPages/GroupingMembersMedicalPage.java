package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.ScenarioDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class GroupingMembersMedicalPage {
    @FindBy(id = "SOL-ViewGroupingMembers-MedicalEnrollmentTitle")
    WebElement medicalEnrollmentGroupPageTitle;
    @FindBy(id = "SOL-ViewGroupingMembers-GroupsMedicalTitle")
    WebElement medicalEnrollmentGroupTitle;
    @FindBy(id = "SOL-ViewGroupingMembers-EnrollmentGroups1stParagraph")
    WebElement groupingPagePara1;
    @FindBy(id = "SOL-ViewGroupingMembers-EnrollmentGroups2ndParagraph")
    WebElement groupingPagePara2;
    @FindBy(css = ".c4-type-header-sm")
    List<WebElement> medicalGroupTitle;
    @FindBy(css = "#SOL-ViewGroupingMembers-MedicalGroup")
    List<WebElement> noOfGroups;
    @FindBy(id="SOL-ViewGroupingMembers-EditMyEnrollmentGroups")
    WebElement editMyEnrollmentGroupsButton;
    @FindBy(id = "SOL-ViewGroupingMembers-Continue")
    WebElement continueButton;
    @FindBy(id = "SOL-ViewGroupingMembers-SaveAndExit")
    WebElement saveAndExitBtn;
    @FindBy(id = "globe-image")
    WebElement globeImageDropdown;
    @FindBy(css = ".mt-3 .table tbody")
    List<WebElement> membersInGroups;

    @FindBy(id = "SOL-ViewGroupingMembers-GoBack")
    WebElement goBackButton;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    private BasicActions basicActions;

    public GroupingMembersMedicalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    SoftAssert softAssert = new SoftAssert();

    public void clickContinue() {
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresent(continueButton, 20);
        basicActions.waitForElementToBeClickable(continueButton, 10);
        basicActions.scrollToElement( continueButton );
        basicActions.click(continueButton);
    }

    public void clickGoBackButton(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresent( goBackButton,20 );
        basicActions.scrollToElement( goBackButton );
        goBackButton.click();;
    }

    public void clickSaveAndExit(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresent( saveAndExitBtn,20 );
        basicActions.scrollToElement( saveAndExitBtn );
        saveAndExitBtn.click();;
    }

    public void clickOnEditMedicalGroupinglink() {
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresent(editMyEnrollmentGroupsButton, 10);
        basicActions.waitForElementToBeClickable(editMyEnrollmentGroupsButton, 50);
        editMyEnrollmentGroupsButton.click();
    }

    public void noOfMedicalGroups(int totalGroups) {
        basicActions.waitForElementToDisappear(spinner,20);
        basicActions.waitForElementListToBePresent(noOfGroups, 10);
        int groupsSize = noOfGroups.size();
        if(SharedData.getScenarioDetails()!=null){
            SharedData.getScenarioDetails().setTotalGroups(groupsSize);
        } else {
            ScenarioDetails scenarioDetails = new ScenarioDetails();
            scenarioDetails.setTotalGroups(groupsSize);
            SharedData.setScenarioDetails(scenarioDetails);
        }
        softAssert.assertEquals(groupsSize, totalGroups, "Total group size did not match");
        softAssert.assertAll();
    }

    public void getUniqueZipCodes(int expectedGroups) {
        Set<String> uniqueZipCodes = new HashSet<>();
        String primaryMemZipCode = SharedData.getPrimaryMember().getResAddress().getAddressZipcode();
        List<MemberDetails> members = SharedData.getMembers();

        uniqueZipCodes.add(primaryMemZipCode);
        members.forEach(member -> uniqueZipCodes.add(member.getResAddress().getAddressZipcode()));
        int actualUniqueZipCodes = uniqueZipCodes.size();
        softAssert.assertEquals(actualUniqueZipCodes, expectedGroups, "Expected Groups did not match with actual");
        softAssert.assertAll();
    }

    public HashMap<String, List<String>> getGroupsByZipcode() {
        HashMap<String, List<String>> membersByZipcode = new HashMap<>();
        List<MemberDetails> members = basicActions.addPrimaryMemToMembersListIfAbsent();

        for (MemberDetails memberDetails : members) {
            String zipcode = memberDetails.getResAddress().getAddressZipcode();

            if (membersByZipcode.containsKey(zipcode)) {
                List<String> fullName = membersByZipcode.get(zipcode);
                fullName.add(memberDetails.getFullName());
                membersByZipcode.put(zipcode, fullName);
            } else {
                List<String> fullName = new ArrayList<>();
                fullName.add(memberDetails.getFullName());
                membersByZipcode.put(zipcode, fullName);
            }
        }
        return membersByZipcode;
    }

    public Map<String, List<String>> getGroupsByZipByUI() {
        Map<String, List<String>> actualNamesInGroups = new HashMap<>();
        List<MemberDetails> members =  basicActions.addPrimaryMemToMembersListIfAbsent();
        String zipcode = "";

        basicActions.waitForElementListToBePresent(membersInGroups, 15);

        for (WebElement membersInGroup : membersInGroups) {
            String namesInput = membersInGroup.getText();
            List<String> namesList = parseNames(namesInput);
            Optional<MemberDetails> member = members.stream().filter(m -> !namesList.isEmpty() &&
                    m.getFullName().equals(namesList.get(0))).findFirst();
            if (member.isPresent()) {
                MemberDetails mem = member.get();
                zipcode = mem.getResAddress().getAddressZipcode();

            } else {
                Assert.fail(" Member searching for is not found");
            }
            actualNamesInGroups.put(zipcode, namesList);
        }
        return actualNamesInGroups;
    }


    public void compareLists(Map<String, List<String>> actualGroups, HashMap<String, List<String>> expectedGroups) {
        Assert.assertEquals(actualGroups.keySet(), expectedGroups.keySet());
        for (String key : actualGroups.keySet()) {
            List<String> list1 = actualGroups.get(key);
            List<String> list2 = expectedGroups.get(key);
            Collections.sort(list1);
            Collections.sort(list2);
            Assert.assertEquals(list1, list2);
        }
    }

    public static List<String> parseNames(String input) {
        // Split the input string into lines
        String[] lines = input.split("\n");

        // Create a new ArrayList to store the names
        List<String> namesList = new ArrayList<>();

        // Add each line as a separate string to the list
        for (String line : lines) {
            namesList.add(line);
        }

        return namesList;
    }

//--------------------------validations------------------------
    public void verifyMedicalGroupingPageVerbiage() {
        basicActions.waitForElementToBePresent(medicalEnrollmentGroupPageTitle, 10);
        softAssert.assertEquals(medicalEnrollmentGroupPageTitle.getText()+" "+medicalEnrollmentGroupTitle.getText(), "Medical Enrollment Groups");
        softAssert.assertEquals(groupingPagePara1.getText(), "Enrollment groups let you choose who enrolls in the same plan together. Remember that costs within a group count towards each group’s deductible and out-of-pocket maximum. In some cases, changing your enrollment groups may make coverage more affordable for your household.");
        softAssert.assertEquals(groupingPagePara2.getText(), "We\u2019ve set up suggested groups based on who is in your family, where they live, and what they\u2019re eligible for, but you can choose to move them into groups of your choice.");
        softAssert.assertEquals(medicalGroupTitle.get(0).getText(),"Medical Group #1");

        softAssert.assertEquals(editMyEnrollmentGroupsButton.getText(), "Edit my suggested groups");
        softAssert.assertEquals(goBackButton.getText(), "Go back");
        softAssert.assertEquals(saveAndExitBtn.getText(), "Save and Exit");
        softAssert.assertEquals(continueButton.getText(), "Continue");
        softAssert.assertTrue(globeImageDropdown.isEnabled());
        softAssert.assertAll();
    }

    public void verifyGroupingMembersWithZipcodes() {
        HashMap<String, List<String>> expectedMap = getGroupsByZipcode();
        Map<String, List<String>> actualMap = getGroupsByZipByUI();
        compareLists(actualMap, expectedMap);
    }



    public void setTheGroupDetails() {
        Map<String, List<String>> groupDetailsMap = new HashMap<>();
        basicActions.waitForElementListToBePresent(noOfGroups, 10);
        int groupsSize = noOfGroups.size();
        if(SharedData.getScenarioDetails()!=null){
            SharedData.getScenarioDetails().setTotalGroups(groupsSize);
        } else {
            ScenarioDetails scenarioDetails = new ScenarioDetails();
            scenarioDetails.setTotalGroups(groupsSize);
            SharedData.setScenarioDetails(scenarioDetails);
        }
        for (int i = 1; i <= groupsSize; i++) {
            List<WebElement> details = basicActions.getDriver().findElements(By.xpath("//th[contains(text(),'Medical Group # " + i + "')]/../../following-sibling::tbody//td"));
            List<String> newDetails = new ArrayList<>();

            for (WebElement detail : details) {
                newDetails.add(detail.getText());
            }
            groupDetailsMap.put("Medical Group # " + i, newDetails);
        }
        SharedData.setGroupingDetails(groupDetailsMap);
    }

}
