package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class StartShoppingCoCoPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();


    public StartShoppingCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SOL-StartShop-Continue")
    WebElement continueBtn;

    @FindBy(css = ".container .radio-button")
    List<WebElement> btnNoAndYes;

    @FindBy(id = "SOL-StartShop-SaveAndExit")
    WebElement saveAndExitButton;

    @FindBy(css = ".container .header-1")
    WebElement headerText;
    @FindBy(css = ".container .body-text-1")
    List<WebElement> bodyText;

    @FindBy(css=".c4-type-body-md")
    WebElement tobaccoUsageTxt;

    @FindBy(id = "SOL-StartShop-GoBack")
    WebElement backButton;

    @FindBy(css="#loader-icon .fa-spinner")
    WebElement spinner;

    public void clickSaveAndExit(){
        basicActions.waitForElementToDisappear(spinner, 10);
        basicActions.waitForElementToBePresent(saveAndExitButton, 10);
        saveAndExitButton.click();
    }

    public void iclickContinue() {
        basicActions.waitForElementToDisappear( spinner,40 );
        softAssert.assertTrue(basicActions.waitForElementToBePresent(continueBtn, 30));
        basicActions.waitForElementToBeClickableWithRetries(continueBtn, 30);
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", continueBtn);
        basicActions.clickElementWithRetries(continueBtn, 10);
    }

    public void tobaccoPage(String tobaccoUsageDetails) {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementListToBePresent(btnNoAndYes, 10);

        String[] NameDetails = tobaccoUsageDetails.split(",");

        for (String Name : NameDetails) {
            WebElement tobaccoUsageYes = basicActions.getDriver().findElement(By.xpath("(//Strong[contains(text(),'" + Name + "')]/parent::p/following-sibling::label)[1]"));
            tobaccoUsageYes.click();
        }

    }


    public void validateBtnTxt(String goBackTxt, String saveExitTxt, String continueBtnTxt){
        basicActions.waitForElementToBePresent(backButton, 10);
        basicActions.waitForElementToBePresent(saveAndExitButton, 10);
        basicActions.waitForElementToBePresent(continueBtn, 10);
        softAssert.assertEquals(backButton.getText(), goBackTxt);
        softAssert.assertEquals(saveAndExitButton.getText(), saveExitTxt);
        softAssert.assertEquals(continueBtn.getText(), continueBtnTxt);
        softAssert.assertAll();
    }

    public void verifyTextOnTobaccoPage() {
        basicActions.waitForElementToDisappear(spinner, 10);
        basicActions.waitForElementToBePresent(headerText, 10);
        softAssert.assertEquals(headerText.getText(), "It's almost time to start shopping for a health insurance plan!");
        softAssert.assertEquals(tobaccoUsageTxt.getText(), "First, we need to ask you about tobacco usage.");
        softAssert.assertEquals(bodyText.get(0).getText(), "Within the last 6 months, has any member of your household used tobacco products regularly (on average 4+ times per week)?");
        softAssert.assertEquals(btnNoAndYes.get(0).getText(), "Yes");
        softAssert.assertEquals(btnNoAndYes.get(1).getText(), "No");
        softAssert.assertEquals(saveAndExitButton.getText(), "Save and Exit");
        softAssert.assertEquals(continueBtn.getText(), "Continue");
        softAssert.assertEquals(bodyText.get(1).getText(), "Next, you'll review your plan options and pick an insurance plan that fits your needs.");
        softAssert.assertEquals(bodyText.get(2).getText(), "Not ready to shop? Now's a good time to save your progress.");
        softAssert.assertAll();
    }

    public void clickBackBtn(){
        basicActions.waitForElementToDisappear(spinner, 10);
        basicActions.waitForElementToBePresent(backButton, 10);
        backButton.click();
    }

    public void selectTobaccoUsagecoco(String tobaccoUsageYesOrNo, String tobaccoUsageDetails) {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementListToBePresent(btnNoAndYes, 10);
        String[] nameDetails = tobaccoUsageDetails.split(",");
        for (String name : nameDetails) {
            clickTobaccoUsage(tobaccoUsageYesOrNo, name);
        }
    }

    private void clickTobaccoUsage(String tobaccoUsageYesOrNo, String namePrefix){
        switch (tobaccoUsageYesOrNo) {
            case "Yes":
                WebElement tobaccoUsageYes = basicActions.getDriver().findElement(By.xpath("(//*[contains(text(),'" + namePrefix + "')]/parent::p/following-sibling::label)[1]"));
                tobaccoUsageYes.click();
                break;
            case "No":
                WebElement tobaccoUsageNo = basicActions.getDriver().findElement(By.xpath("(//*[contains(text(),'" + namePrefix + "')]/parent::p/following-sibling::label)[2]"));
                tobaccoUsageNo.click();
                break;
            default:
                Assert.fail("Invalid argument passed!!");
        }
        setTobaccoUsage(tobaccoUsageYesOrNo, namePrefix);
    }

    private void setTobaccoUsage(String tobaccoUsageYesOrNo, String namePrefix){
        List<MemberDetails> allMemList = basicActions.getAllMem();
        allMemList.stream().filter(mem -> mem.getFirstName().contains(namePrefix)).findFirst().ifPresent(mem -> mem.setTobacco_user(tobaccoUsageYesOrNo));
    }


}
