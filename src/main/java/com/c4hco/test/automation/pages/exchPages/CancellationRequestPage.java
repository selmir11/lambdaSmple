package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

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

    public void ValidateCancellationPageText(String pageDetail,String language){
        switch (language){
            case "English":
                ValidateCancellationPageEnglishText();
                break;
            case "Spanish":
                ValidateCancellationPageSpanishText();
                break;
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private void ValidateCancellationPageSpanishText(){
        basicActions.waitForElementToBePresent(planCancellationpageHeader, 10);
        softAssert.assertEquals(planCancellationpageHeader.getText(), "Solicitud de cancelación");
        softAssert.assertEquals(planCancellationPageTextDetails.get(1).getText(), "Para cancelar o terminar su(s) plan(es), revise y confirme la siguiente información. Esto cancelará los planes para todas las personas en la lista de abajo. Si desea quitar a una persona de sus planes, vuelva a My Account (Mi cuenta) y haga clic en el botón Make changes (Hacer cambios).");
        softAssert.assertAll();
    }

    private void ValidateCancellationPageEnglishText(){
        basicActions.waitForElementToBePresent(planCancellationpageHeader, 10);
        softAssert.assertEquals(planCancellationpageHeader.getText(), "Cancellation Request");
        softAssert.assertEquals(planCancellationPageTextDetails.get(1).getText(), "To cancel or terminate your plan(s), please review and confirm the information below. This will cancel the plan(s) for all of the people listed below. If you would like to remove one person from your plan(s), please return to My Account and click the Make changes button.");
        softAssert.assertAll();
    }

}
