package com.c4hco.test.automation.pages.cocoPages;

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

public class StartShoppingCoCoPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();


    public StartShoppingCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
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

    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    public void clickBtnSaveNExit(){
        saveAndExitButton.click();
    }
    public void iclickContinue(){
        basicActions.waitForElementListToBePresent(btnNoAndYes,10);
        softAssert.assertTrue(basicActions.waitForElementToBePresent(btnContinue, 30));
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].scrollIntoView(true);", btnContinue);
        btnContinue.click();
    }
    public void memberTobaccoUser(String member, String YNTobaccoUser) {
        basicActions.waitForElementListToBePresent(btnNoAndYes,20);
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
                subscriber.setTobacco_user(YNTobaccoUser);
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
                memberList.get(memberList.size()-1).setTobacco_user(YNTobaccoUser);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + member);
        }
    }

    public void tobaccoPage(List<String> tobaccoUsageDetails) {
        basicActions.waitForElementToDisappear(spinner,20);
        basicActions.waitForElementListToBePresent(btnNoAndYes,10);
        for (int i = 0; i < tobaccoUsageDetails.size(); i++) {
            String[] groupDetail = tobaccoUsageDetails.get(i).split(":");
            String[] Names = groupDetail[0].split(",");

            for (String Name : Names) {
                WebElement yesBtn = basicActions.getDriver().findElement(By.xpath("(//Strong[contains(text(),'"+Name+"')]/parent::p/following-sibling::label)[1]"));
                yesBtn.click();
            }
        }
    }

}
