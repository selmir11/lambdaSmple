package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EditGroupingMembersDentalPage {

    @FindBy(css = ".container div:nth-child(2) div span u")
    WebElement whatWorksBestLink;

    @FindBy(css = "ngb-tooltip-window .tooltip-inner")
    WebElement tootlTip;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(id ="SHP-EditDentalGroupingMembers-CreateANewGroup")
    WebElement createNewGroupLink;

    @FindBy(xpath = "//div[@class='dragHere']/parent::div")
    List<WebElement> dragAMemberHere;

    @FindBy(id ="SHP-EditDentalGroupingMembers-Save")
    WebElement saveButtonOnEditDentalGroupingPage;

    @FindBy(id = "SHP-EditDentalGroupingMembers-Continue")
    WebElement ctnBtnSuccessModal;

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();
    Actions builder;

    public EditGroupingMembersDentalPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        builder  = new Actions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
        Assert.assertTrue(basicActions.waitForAngular(10), "page did not load in 10 seconds");    }

    public void validateToolTipText(){
        String expectedToolTipText = "Household members can only be grouped together if they are all immediate family members who live in the same rating area and could be covered by a single insurance plan. Immediate family members include spouses, children under the age of 26, and collateral dependents (non-married, disabled tax dependents of a group member). Frequently, \"living in the same rating area\" means that all of the individuals live at the same physical address or within the same zip code. You might not be able to group members of your household if they are not considered immediate family members. For assistance, please call our Service Center at 855-752-6749.";
        basicActions.waitForElementToBePresent(whatWorksBestLink, 10);
        softAssert.assertEquals(whatWorksBestLink.getText(), "what works best for you.");
        builder.moveToElement(whatWorksBestLink).perform();
        softAssert.assertEquals(tootlTip.getText(), expectedToolTipText, "Actual Text::"+tootlTip.getText()+"::did not match");
        softAssert.assertAll();
    }

    public void createNewDentalGroups(List<String> groupingList) {
        basicActions.waitForElementToDisappear(spinner, 20);
        for(String group: groupingList){
            createNewGroupLink.click();
            basicActions.scrollToElement(createNewGroupLink);
            String[] groupDetail =  group.split(":");
            String[] Names = groupDetail[0].split(",");
            for(String Name: Names){
                WebElement dragElement = basicActions.getDriver().findElement(By.xpath("//div[contains(text(),'" + Name + "')]"));
                WebElement dropElement = dragAMemberHere.get(dragAMemberHere.size()-1);
                basicActions.wait(3000);
                basicActions.scrollToElement(dragElement);
                // Scroll the drop element into view
                basicActions.scrollToElement(dropElement);
                // Perform drag and drop using JavaScript
                builder.clickAndHold(dragElement)
                        .moveToElement(dropElement)
                        .release(dropElement).build()
                        .perform();
                basicActions.wait(3000);
            }
        }
    }

    public void iClickSaveButton(){
        softAssert.assertTrue(saveButtonOnEditDentalGroupingPage.isEnabled());
        basicActions.waitForElementToBePresent(saveButtonOnEditDentalGroupingPage,20);
        basicActions.scrollToElement(saveButtonOnEditDentalGroupingPage);
        saveButtonOnEditDentalGroupingPage.click();
    }

    public void iClickContinueOnSuccessPopup(){
        basicActions.waitForElementToBePresent(ctnBtnSuccessModal, 20);
        ctnBtnSuccessModal.click();
    }
}

