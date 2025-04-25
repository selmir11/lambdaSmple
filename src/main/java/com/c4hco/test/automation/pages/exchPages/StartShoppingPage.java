package com.c4hco.test.automation.pages.exchPages;

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

public class StartShoppingPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();


    public StartShoppingPage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );
    }

    @FindBy(id = "SOL-StartShop-Continue")
    WebElement btnContinue;

    @FindBy(css = ".container .radio-button")
    List<WebElement> btnNoAndYes;

    @FindBy(id = "SOL-StartShop-SaveAndExit")
    WebElement saveAndExitButton;

    @FindBy(css = ".container .header-1")
    WebElement headerText;
    @FindBy(css = ".container .body-text-1")
    List<WebElement> bodyText;

    @FindBy(id = "SOL-StartShop-GoBack")
    WebElement goBackbtn;

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void clickBtnSaveNExit() {
        saveAndExitButton.click();
    }

    public void iclickContinue() {
        basicActions.waitForElementListToBePresent( btnNoAndYes, 10 );
        softAssert.assertTrue( basicActions.waitForElementToBePresent( btnContinue, 30 ) );
        ((JavascriptExecutor) basicActions.getDriver()).executeScript( "arguments[0].scrollIntoView(true);", btnContinue );
        btnContinue.click();
    }

    //-----------------------Validations------------------------//
    public void verifyTextOnTobaccoPage() {
        basicActions.waitForElementToBePresent( headerText, 10 );
        softAssert.assertEquals( headerText.getText(), "It's almost time to start shopping for a health insurance plan!" );
        softAssert.assertEquals( bodyText.get( 1 ), "First, we need to ask you about tobacco usage." );
        softAssert.assertEquals( bodyText.get( 2 ), "Within the last 6 months, has any member of your household used tobacco products regularly (on average 4+ times per week)?" );
        softAssert.assertEquals( btnNoAndYes.get( 1 ), "No" );
        softAssert.assertEquals( btnNoAndYes.get( 2 ), "Yes" );
        softAssert.assertEquals( saveAndExitButton.getText(), "Save and Exit" );
        softAssert.assertEquals( btnContinue, "Continue" );
        softAssert.assertEquals( bodyText.get( 3 ), "Next, you'll review your plan options and pick an insurance plan that fits your needs." );
        softAssert.assertEquals( bodyText.get( 4 ), "Not ready to shop? Now's a good time to save your progress." );
        softAssert.assertAll();
    }

    public void iclickGoBack() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent( goBackbtn, 10 );
        basicActions.scrollToElement( goBackbtn );
        goBackbtn.click();
    }
    public void selectTobaccoUsage(String tobaccoUsageYesOrNo, String tobaccoUsageDetails) {
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