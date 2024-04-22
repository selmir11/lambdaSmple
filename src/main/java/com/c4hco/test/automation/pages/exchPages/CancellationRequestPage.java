package com.c4hco.test.automation.pages.exchPages;


import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.nio.charset.StandardCharsets;
import java.util.List;

public class CancellationRequestPage {


    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;
    public CancellationRequestPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container > div")
    WebElement planCancellationpageHeader;

    @FindBy(xpath = "//div[@class='container']/div")
    List<WebElement> planCancellationPageTextDetails;

    @FindBy(xpath = "//table[@summary='Plan Details']/tr/th")
    List<WebElement> planCancellationPagePlanHeaderDetails;

    @FindBy(css="input[type='text']")
    WebElement placeHoldertxt;

    @FindBy(id="goBackButton")
    WebElement goBackbtn;

    @FindBy(id = "continueButton")
    WebElement continuebtn;

    @FindBy(css=".mdc-checkbox__native-control")
    WebElement decCheckBox;

    @FindBy(css=".requiredfield.ps-5")
    WebElement validationMessagecheckBox;

    @FindBy(css=".row.ps-3>div>span.requiredfield")
    WebElement validationMessageTextBox;

    public void ValidateCancellationPageText(String language, List<String> data){
        switch (language){
            case "English", "Spanish":
                ValidateCancellationPageText(data);
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private void ValidateCancellationPageText(List<String> data){
        basicActions.waitForElementToBePresent(planCancellationpageHeader, 20);
        softAssert.assertEquals(planCancellationpageHeader.getText(), data.get(0));
        softAssert.assertEquals(planCancellationPageTextDetails.get(1).getText(),data.get(1));
        softAssert.assertEquals(planCancellationPageTextDetails.get(2).getText(),data.get(2));
        softAssert.assertEquals(planCancellationPageTextDetails.get(3).getText(),data.get(3));
        softAssert.assertEquals(planCancellationPagePlanHeaderDetails.get(0).getText(),data.get(4));
        softAssert.assertEquals(planCancellationPagePlanHeaderDetails.get(1).getText(),data.get(5));
        softAssert.assertEquals(planCancellationPagePlanHeaderDetails.get(2).getText(),data.get(6));
        softAssert.assertEquals(planCancellationPagePlanHeaderDetails.get(3).getText(),data.get(7));
        softAssert.assertEquals(planCancellationPageTextDetails.get(5).getText(),data.get(8));
        softAssert.assertTrue(planCancellationPageTextDetails.get(7).getText().contains(data.get(9)));
        softAssert.assertEquals(placeHoldertxt.getAttribute("placeholder"),data.get(10));
        softAssert.assertEquals(goBackbtn.getText(),data.get(11));
        softAssert.assertEquals(continuebtn.getText(),data.get(12));
        softAssert.assertAll();
    }

    public void clickGoBackbtn(){
        basicActions.waitForElementToBePresent(goBackbtn,10);
        goBackbtn.click();
    }

    public void clickContinuebtn(){
        basicActions.waitForElementToBePresent(continuebtn,10);
        basicActions.scrollToElement(continuebtn);
        continuebtn.click();
    }

    public void verifyValidationMessageText(List<String> data){
        basicActions.waitForElementToBePresent(validationMessagecheckBox,10);
        softAssert.assertEquals(validationMessagecheckBox.getText(), data.get(0));
        softAssert.assertEquals(validationMessageTextBox.getText(), data.get(1));
        basicActions.scrollToElement(decCheckBox); decCheckBox.click();
        String PrimaryMemberFirstName = SharedData.getPrimaryMember().getFirstName();
        placeHoldertxt.sendKeys(PrimaryMemberFirstName);
        clickContinuebtn();
        softAssert.assertEquals(validationMessageTextBox.getText(), data.get(2));
        softAssert.assertAll();
        basicActions.refreshPage();
        basicActions.waitForElementToBePresent(continuebtn,10);
        clickContinuebtn();
    }

    public void cancelActivePlan(){
        basicActions.scrollToElement(decCheckBox);
        decCheckBox.click();
        String PrimaryMemberFullName = SharedData.getPrimaryMember().getFullName();
        placeHoldertxt.sendKeys(PrimaryMemberFullName);
        clickContinuebtn();
    }
}
