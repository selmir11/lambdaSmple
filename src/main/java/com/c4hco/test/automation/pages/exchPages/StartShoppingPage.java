package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
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

    @FindBy(xpath = "//span[@class = 'button-text-unselected']")
    List<WebElement> tobaccoButton;

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
        softAssert.assertEquals( bodyText.get( 2 ), "Within the last 6 months, has any member of your household used tobacco products regularly" );
        softAssert.assertEquals( btnNoAndYes.get( 1 ), "No" );
        softAssert.assertEquals( btnNoAndYes.get( 2 ), "Yes" );
        softAssert.assertEquals( saveAndExitButton.getText(), "Save and Exit" );
        softAssert.assertEquals( btnContinue, "Continue" );
        softAssert.assertEquals( bodyText.get( 3 ), "Next, you'll set up your shopping groups." );
        softAssert.assertEquals( bodyText.get( 4 ), "Not ready to shop? Now's a good time to save your progress." );
        softAssert.assertAll();
    }

    public void iclickGoBack() {
        basicActions.waitForElementToDisappear( spinner, 30 );
        basicActions.waitForElementToBePresent( goBackbtn, 10 );
        basicActions.scrollToElement( goBackbtn );
        goBackbtn.click();
    }

    public void enterTobaccoUsageInfo(String tobaccoUsageDetails) {
        basicActions.waitForElementToDisappear( spinner, 20 );
        basicActions.waitForElementListToBePresent( btnNoAndYes, 10 );

        String[] nameDetails = tobaccoUsageDetails.split( "," );

        for (String name : nameDetails) {
            WebElement tobaccoUsageYes = basicActions.getDriver().findElement( By.xpath( "(//Strong[contains(text(),'" + name + "')]/parent::p/following-sibling::label)[1]" ) );
            tobaccoUsageYes.click();
            setTobaccoUser( name );
        }
    }

    private void setTobaccoUser(String name) {
        if (name.contains( "primary" )) {
            SharedData.getPrimaryMember().setTobacco_user( "Yes" );
        } else {
            List<MemberDetails> dependents = SharedData.getMembers();
            for (MemberDetails mem : dependents) {
                if (mem.getFirstName().contains( name )) {
                    mem.setTobacco_user( "Yes" );
                }
            }
        }
    }
    public void isTobaccoUser(String tobaccoUsageYesOrNo, String tobaccoUsageDetails) {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementListToBePresent(btnNoAndYes, 10);
        String[] nameDetails = tobaccoUsageDetails.split(",");
        for (String name : nameDetails) {
            switch (tobaccoUsageYesOrNo) {
                case "Yes":
                    WebElement tobaccoUsageYes = basicActions.getDriver().findElement(By.xpath("(//*[contains(text(),'" + name + "')]/parent::p/following-sibling::label)[1]"));
                    tobaccoUsageYes.click();
                    setTobaccoUser( name );
                    break;
                case "No":
                    WebElement tobaccoUsageNo = basicActions.getDriver().findElement(By.xpath("(//*[contains(text(),'" + name + "')]/parent::p/following-sibling::label)[2]"));
                    tobaccoUsageNo.click();
                    setTobaccoUserNo( name );
            }
        }
    }

    private void setTobaccoUserNo(String name) {
        if (name.contains( "primary" )) {
            SharedData.getPrimaryMember().setTobacco_user( "No" );
        } else {
            List<MemberDetails> dependents = SharedData.getMembers();
            for (MemberDetails mem : dependents) {
                    }
                if (mem.getFirstName().contains( name )) {
                    mem.setTobacco_user( "No" );
                }
            }
        }
    }

}

