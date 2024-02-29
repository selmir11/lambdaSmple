package com.c4hco.test.automation.pages.exchPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.c4hco.test.automation.utils.BasicActions;
import org.testng.asserts.SoftAssert;


import java.util.List;

public class EnterCaseIdPage {
    private BasicActions basicActions;
    public EnterCaseIdPage(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);

    }

    @FindBy(css = ".c4BodyText1")
    List <WebElement> bodyText;

    @FindBy(css = "input#caseId.form-control[type='text']")
    WebElement caseIDPlaceHolderText;

    @FindBy(id = "zipCode")
    WebElement zipCodePlaceHolderText;

    @FindBy(id = "lastName")
    WebElement lastNamePlaceHolderText;

    public void validateTheVerbiageOnEnterCaseIdPage(String language){
        switch (language){
            case "English":
                validateTheVerbiageEn();
                break;
            case "Spanish":
                validateTheVerbiageEs();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }
    public void validateTheVerbiageEn() {
        SoftAssert softAssert = new SoftAssert();
        basicActions.waitForElementToBePresent(bodyText.get(0), 30);
        softAssert.assertEquals(bodyText.get(0).getText(), "Please fill out the following information found on your Health First Colorado denial notice", "Text not found: Please fill out the following information found on your Health First Colorado denial notice");
        softAssert.assertEquals(bodyText.get(1).getText(), "Case ID", "Text not found: Case ID");
        softAssert.assertEquals(bodyText.get(2).getText(), "Zip Code", "Text not found: Zip Code");
        softAssert.assertEquals(bodyText.get(3).getText(), "Last Name", "Text not found: Last Name");
        basicActions.assertPlaceholderTextMatched(caseIDPlaceHolderText, "1BXXXXXX");
        basicActions.assertPlaceholderTextMatched(zipCodePlaceHolderText, "XXXXX");
        basicActions.assertPlaceholderTextMatched(lastNamePlaceHolderText, "");
        softAssert.assertAll();
    }

    public void validateTheVerbiageEs() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(bodyText.get(0).getText(), "Anote la siguiente informaci\u00f3n que aparece en su aviso de negaci\u00f3n de Health First Colorado", "Text not found: Anote la siguiente informaci\u00f3n que aparece en su aviso de negaci\u00f3n de Health First Colorado");
        softAssert.assertEquals(bodyText.get(1).getText(), "Identificaci\u00f3n del caso", "Text not found: Identificaci\u00f3n del caso");
        softAssert.assertEquals(bodyText.get(2).getText(), "C\u00f3digo postal", "Text not found: C\u00f3digo postal");
        softAssert.assertEquals(bodyText.get(3).getText(), "Apellido(s)", "Text not found: Apellido(s)");
        basicActions.assertPlaceholderTextMatched(caseIDPlaceHolderText, "1BXXXXXX");
        basicActions.assertPlaceholderTextMatched(zipCodePlaceHolderText, "XXXXX");
        basicActions.assertPlaceholderTextMatched(lastNamePlaceHolderText, "");
        softAssert.assertAll();
    }

}
