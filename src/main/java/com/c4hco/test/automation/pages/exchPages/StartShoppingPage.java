package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
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
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "SHP-StartShop-Continue")
    WebElement btnContinue;

    @FindBy(css = ".container .radio-button")
    List<WebElement> btnNoAndYes;

    @FindBy(id = "SHP-StartShop-SaveAndExit")
    WebElement saveAndExitButton;

    @FindBy(css = ".container .header-1")
    WebElement headerText;
    @FindBy(css = ".container .body-text-1")
    List<WebElement> bodyText;

    public void clickBtnSaveNExit(){
        saveAndExitButton.click();
    }
    public void iclickContinue(){
        basicActions.waitForElementListToBePresent(btnNoAndYes,10);
        softAssert.assertTrue(basicActions.waitForElementToBePresent(btnContinue, 30));
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", btnContinue);
        btnContinue.click();
    }

    public void isMemberTobaccoUser(String member, String YNTobaccoUser) {
        basicActions.waitForElementListToBePresent(btnNoAndYes,20);
        String tobaccoCode;
        if (YNTobaccoUser.equalsIgnoreCase("Yes")){ tobaccoCode = "T";}
        else {tobaccoCode = "N";}
        MemberDetails subscriber = SharedData.getPrimaryMember();
        List<MemberDetails> memberList = SharedData.getMembers();
        switch (member) {
            case "member1":
                switch (YNTobaccoUser) {
                    case "Yes":
                        btnNoAndYes.get(0).click();
                        break;
                    case "No":
                        btnNoAndYes.get(1).click();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + YNTobaccoUser);
                }
                subscriber.setTobacco_user(tobaccoCode);
                break;
            case "member2":
                switch (YNTobaccoUser) {
                    case "Yes":
                        btnNoAndYes.get(2).click();
                        break;
                    case "No":
                        btnNoAndYes.get(3).click();
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid option: " + YNTobaccoUser);
                }
                memberList.get(memberList.size()-1).setTobacco_user(tobaccoCode);
                break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + member);
        }
    }


    //-----------------------Validations------------------------//
    public void verifyTextOnTobaccoPage(){ 
        basicActions.waitForElementToBePresent(headerText,10);
        softAssert.assertEquals(headerText.getText(), "It's almost time to start shopping for a health insurance plan!");
        softAssert.assertEquals(bodyText.get(1), "First, we need to ask you about tobacco usage.");
        softAssert.assertEquals(bodyText.get(2),"Within the last 6 months, has any member of your household used tobacco products regularly");
        softAssert.assertEquals(btnNoAndYes.get(1), "No");
        softAssert.assertEquals(btnNoAndYes.get(2), "Yes");
        softAssert.assertEquals(saveAndExitButton.getText(), "Save and Exit");
        softAssert.assertEquals(btnContinue, "Continue");
        softAssert.assertEquals(bodyText.get(3), "Next, you'll set up your shopping groups.");
        softAssert.assertEquals(bodyText.get(4), "Not ready to shop? Now's a good time to save your progress.");
        softAssert.assertAll();
    }
}
