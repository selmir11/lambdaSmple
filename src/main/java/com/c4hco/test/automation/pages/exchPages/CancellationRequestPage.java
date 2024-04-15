package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
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

    public void ValidateCancellationPageText(String language, List<String> data){
        switch (language){
            case "English":
                ValidateCancellationPageEnglishText(data);
                break;
            case "Spanish":
                ValidateCancellationPageSpanishText(data);
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private void ValidateCancellationPageSpanishText(List<String> data){
        basicActions.waitForElementToBePresent(planCancellationpageHeader, 10);
        softAssert.assertEquals(planCancellationpageHeader.getText(), data.get(0));
        System.out.println(planCancellationPageTextDetails.size());
        softAssert.assertEquals(planCancellationPageTextDetails.get(1).getText(),data.get(1));
        softAssert.assertEquals(planCancellationPageTextDetails.get(2).getText(),data.get(2));
        softAssert.assertEquals(planCancellationPageTextDetails.get(3).getText(),data.get(3));
        //softAssert.assertEquals(planCancellationPageTextDetails.get(4).getText(),data.get(4));
        softAssert.assertEquals(planCancellationPageTextDetails.get(5).getText(),data.get(5));
        //softAssert.assertEquals(planCancellationPageTextDetails.get(6).getText(),data.get(5));
        //softAssert.assertEquals(planCancellationPageTextDetails.get(7).getText(),data.get(7));
        softAssert.assertAll();
    }

    private void ValidateCancellationPageEnglishText(List<String> data){
        basicActions.waitForElementToBePresent(planCancellationpageHeader, 10);
        softAssert.assertEquals(planCancellationpageHeader.getText(), "Cancellation Request");
        softAssert.assertEquals(planCancellationPageTextDetails.get(1).getText(), "To cancel or terminate your plan(s), please review and confirm the information below. This will cancel the plan(s) for all of the people listed below. If you would like to remove one person from your plan(s), please return to My Account and click the Make changes button.");
        softAssert.assertAll();
    }

}
