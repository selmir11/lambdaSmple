package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.ResidentialAddress;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.*;

public class GroupingMembersMedicalPage {
    @FindBy(css = ".container .header-1")
    WebElement medicalEnrollmentGroupPageTitle;
    @FindBy(css = ".container .body-text-1")
    List<WebElement> groupingPageText;
    @FindBy(css = ".th-title")
    WebElement medicalGroup1;
    @FindBy(css = "th.th-title")
    List<WebElement> noOfGroups;
    @FindBy(id = "SHP-MedicalGroupingMembers-EditMyEnrollmentGroups")
    WebElement editMyEnrollmentGroupsButton;
    @FindBy(css = ".row .btn-secondary")
    List<WebElement> backAndSaveAndExitButtons;
    @FindBy(id = "SHP-MedicalGroupingMembers-Continue")
    WebElement continueButton;
    @FindBy(id = "globe-image")
    WebElement glodeImageDropdown;
    @FindBy(css = ".mt-3 .table tbody")
    List<WebElement> memberNameInSecondGroup;

    private BasicActions basicActions;
    public GroupingMembersMedicalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    SoftAssert softAssert = new SoftAssert();
    public void clickContinue(){
        basicActions.waitForElementToBePresent(continueButton,10);
        basicActions.waitForElementToBeClickable(continueButton,30);
        continueButton.click();
    }
    
    public void clickOnEditMedicalGroupinglink(){
        basicActions.waitForElementToBePresent(editMyEnrollmentGroupsButton,10);
        basicActions.waitForElementToBeClickable(editMyEnrollmentGroupsButton,30);
        editMyEnrollmentGroupsButton.click();
    }
    public void noOfMedicalGroups(){
        basicActions.waitForElementListToBePresent(noOfGroups,10);
        int groupsSize = noOfGroups.size();
        softAssert.assertEquals(groupsSize,2, "There are 2 groups");
        softAssert.assertAll();
    }
    public void getGroupsByUniqueZipCodes(int expectedGroups){
        Set<String> uniqueZipCodes = new HashSet<>();
        String primaryMemZipCode = SharedData.getPrimaryMember().getResAddress().getResidentialAddressZipcode();
        List<MemberDetails> members = SharedData.getMembers();

        uniqueZipCodes.add(primaryMemZipCode);
        members.forEach(member -> uniqueZipCodes.add(member.getResAddress().getResidentialAddressZipcode()));
        int actualUniqueZipCodes = uniqueZipCodes.size();
        softAssert.assertEquals(actualUniqueZipCodes, expectedGroups, "Expected Groups did not match with actual");
        softAssert.assertAll();
        SharedData.setUniqueZipcodes(uniqueZipCodes);
    }

    public  String getFirstNameByZipcode(){
       List<MemberDetails> members = SharedData.getMembers();
        String firstName = null;

        for (MemberDetails member : members) {
            if (member.getResAddress().getResidentialAddressZipcode().equals("80305")) {
                firstName = member.getFirstName();
                break;
            }
        }
        return firstName;
    }

    public void getGroupsByZipcode(){
        HashMap<String, List<String>> membersByZipcode = new HashMap<>();
        List<MemberDetails> members = SharedData.getMembers();

        MemberDetails primaryMem = SharedData.getPrimaryMember();
        members.add(primaryMem);

        for(MemberDetails memberDetails:members){
            String zipcode = memberDetails.getResAddress().getResidentialAddressZipcode();

            if(membersByZipcode.containsKey(zipcode)){
                List<String> fullName = membersByZipcode.get(zipcode);
                fullName.add(memberDetails.getSignature());
                membersByZipcode.put(zipcode, fullName);
            } else{
                List<String> fullName = new ArrayList<>();
                fullName.add(memberDetails.getSignature());
                membersByZipcode.put(zipcode, fullName);
            }
        }
        SharedData.setGroupsByZipcode(membersByZipcode);
    }

    //--------------------------validations------------------------
    public void verifyMedicalGroupingPageVerbiage(){
        basicActions.waitForElementToBePresent(medicalEnrollmentGroupPageTitle,10);
        softAssert.assertEquals(medicalEnrollmentGroupPageTitle.getText(), "Medical Enrollment Groups");
        softAssert.assertEquals(groupingPageText.get(0).getText(),"It may be cheaper to separate your household into groups and enroll in different plans. We suggest the following groups, but you can use what works best for you.");
        softAssert.assertEquals(groupingPageText.get(1).getText(),"Remember: Costs within a group count towards each group's deductible and out of pocket maximum.");
       // softAssert.assertEquals(medicalGroup1.getText(),"Medical Group # 1");
        softAssert.assertEquals(editMyEnrollmentGroupsButton,"Edit my enrollment groups");
        softAssert.assertEquals(backAndSaveAndExitButtons.get(0).getText(),"Go Back");
        softAssert.assertEquals(backAndSaveAndExitButtons.get(1).getText(),"Save and Exit");
        softAssert.assertEquals(continueButton.getText(),"Continue");
        softAssert.assertTrue(glodeImageDropdown.isEnabled());
        softAssert.assertAll();
    }

    public void verifyGroupingMembersWithDifferentZipcode(String zipcode){
        getGroupsByZipcode();

        String firstname = getFirstNameByZipcode();
        basicActions.waitForElementListToBePresent(memberNameInSecondGroup,10);
        List<String> namesFromUI = new ArrayList<>();
        String groupTwoMemberNameUI = memberNameInSecondGroup.get(1).getText();

        ArrayList<String> groupOneMembers = new ArrayList<>();

// Get text from each WebElement and add to ArrayList
        for (WebElement element : memberNameInSecondGroup) {
            groupOneMembers.add(memberNameInSecondGroup.get(0).getText());
        }
        System.out.println("Group1 "+groupOneMembers);

        System.out.println("Group2 "+groupTwoMemberNameUI);
        namesFromUI.add(groupTwoMemberNameUI);

        HashMap<String, List<String>> groups = SharedData.getGroupsByZipcode();
        Set<String> uniqueZipcodes = SharedData.getUniqueZipcodes();
        List<String> expectedNAmes = groups.get(zipcode);
//
//        HashMap<String, List<String>> groups1 = uniqueZipcodes.stream().filter(groups::containsKey).collect(HashMap::new, (map, zipCode) -> map.put(zipCode, groups.get(zipCode)), HashMap::putAll);
//        groups1.forEach((zip, name)->
//        {
//            softAssert.assertEquals(name, namesFromUI );
//
//        });

        softAssert.assertTrue(groupTwoMemberNameUI.contains(firstname),"Member with different zipcode is in separate group");
        softAssert.assertAll();
    }

    public void getActualNamesFromUI(){
        String firstname = getFirstNameByZipcode();
        basicActions.waitForElementListToBePresent(memberNameInSecondGroup,10);
        List<String> namesFromUI = new ArrayList<>();
        String groupTwoMemberNameUI = memberNameInSecondGroup.get(1).getText();
        System.out.println(groupTwoMemberNameUI);
        namesFromUI.add(groupTwoMemberNameUI);
    }
}
