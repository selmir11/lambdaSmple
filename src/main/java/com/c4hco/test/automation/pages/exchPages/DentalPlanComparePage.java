package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.Optional;

public class DentalPlanComparePage {

    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();
    private Optional<Integer> optionalInt;

    public DentalPlanComparePage(WebDriver webDriver) {
        basicActions = new BasicActions( webDriver );
        PageFactory.initElements( basicActions.getDriver(), this );
    }

    @FindBy(id = "SHP-DentalComparePlans-GoBacktoPlans")
    WebElement goBackCompare;

    public void clickGoBackCompare() {
        basicActions.waitForElementToBeClickable( goBackCompare, 15 );
        goBackCompare.click();

    }
}
