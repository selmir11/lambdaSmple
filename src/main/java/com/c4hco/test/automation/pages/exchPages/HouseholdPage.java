package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HouseholdPage {
    // Family Overview Page
    private BasicActions basicActions;
    public HouseholdPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    // update locators to ids and rename methods
    @FindBy(id = "submitButton_ContinueIncome")
    WebElement saveAndContinue;

    @FindBy(id = "submitButton_AddMember")
    WebElement addAdditionalMember;
    @FindBy(css = ".memberBasicRow  #editBasicInfo")
    List<WebElement> memberBasicInformation;

    public void clickAddMember(){addAdditionalMember.click();}
    public void clickContinue(){
        saveAndContinue.click();
    }
    public void clickBasicInfoMember1Button(int member){
        memberBasicInformation.get(member).click();
    }
}
