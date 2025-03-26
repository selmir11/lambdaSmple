package com.c4hco.test.automation.pages.cocoPages;


import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Set;

public class CancellationRequestPageCoCo {


    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;
    public CancellationRequestPageCoCo(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }


    @FindBy(css="input[type='text']")
    WebElement placeHoldertxtCoCo;

    @FindBy(id="goBackButton")
    WebElement goBackbtnCoCo;

    @FindBy(id = "continueButton")
    WebElement continuebtnCoCo;

    @FindBy(css=".mdc-checkbox__native-control")
    WebElement decCheckBoxCoCo;

    @FindBy(id="mat-mdc-checkbox-0-input")
    WebElement understandCheckBoxCoCo;

    @FindBy(css=".modal-content")
    WebElement popUpCancellationPageCoCo;

    @FindBy(id="okayButton")
    WebElement okaybtnCoCo;

    @FindBy(css=".modal-content>div>div")
    WebElement popUpheaderCoCo;

    @FindBy(css=".modal-content>div>div>div>span")
    WebElement popUpcontentinfoCoCo;

    @FindBy(css=".modal-content>div>div>div>button")
    WebElement popUpOkbtnCoCo;



    public void clickGoBackbtnCoCo(){
        basicActions.waitForElementToBePresent(goBackbtnCoCo,10);
        goBackbtnCoCo.click();
    }

    public void clickContinuebtnCoCo(){
        basicActions.waitForElementToBePresent(continuebtnCoCo,10);
        basicActions.scrollToElement(continuebtnCoCo);
        continuebtnCoCo.click();
    }


    public void cancelActivePlanCoCo(){
        basicActions.scrollToElement(decCheckBoxCoCo);
        decCheckBoxCoCo.click();
        String PrimaryMemberFullName = SharedData.getPrimaryMember().getFullName();
        placeHoldertxtCoCo.sendKeys(PrimaryMemberFullName);
    }

    public void cancelPlanCoCo() {
        basicActions.scrollToElement(understandCheckBoxCoCo);
        understandCheckBoxCoCo.click();
        String PrimaryMemberFullName = SharedData.getPrimaryMember().getFullName();
        placeHoldertxtCoCo.sendKeys(PrimaryMemberFullName);
    }

    public void  okaybtn(){
        basicActions.waitForElementToBePresent(okaybtnCoCo,10);
        okaybtnCoCo.click();
    }

    public void cancellationPlanPoupMessage(List<String> data) throws InterruptedException {
        basicActions.waitForElementToBePresent(popUpCancellationPageCoCo, 10);
        String parentWindowHandle = basicActions.getDriver().getWindowHandle();
        Set<String> allWindowHandles = basicActions.getDriver().getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(parentWindowHandle)) {
                basicActions.getDriver().switchTo().window(handle);
                break;
            }

        }
        softAssert.assertEquals(popUpheaderCoCo.getText(), data.get(0));
        softAssert.assertEquals(popUpcontentinfoCoCo.getText(), data.get(1));
        softAssert.assertTrue(popUpcontentinfoCoCo.getText().contains(data.get(1)));
        softAssert.assertEquals(popUpOkbtnCoCo.getText(), data.get(2));
        softAssert.assertAll();
        popUpOkbtnCoCo.click();
        basicActions.getDriver().switchTo().window(parentWindowHandle);
        basicActions.switchToParentPage("Enrollment Portal");
    }
}
