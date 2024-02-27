package com.c4hco.test.automation.stepDefinitions.exchSteps;
import com.c4hco.test.automation.pages.exchPages.EditGroupingMembersMedicalPage;
import com.c4hco.test.automation.utils.WebDriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

public class EditGroupingMembersMedicalPageSteps {
    EditGroupingMembersMedicalPage editGroupingMembersMedicalPage = new EditGroupingMembersMedicalPage(WebDriverManager.getDriver());

    @And("I click Cancel button on Edit Grouping Members Medical page")
    public void editGroupingMedicalPage(){
        editGroupingMembersMedicalPage.cancelEditGroupingMembers();
    }
}
