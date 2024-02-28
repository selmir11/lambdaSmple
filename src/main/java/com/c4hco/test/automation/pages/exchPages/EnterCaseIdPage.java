package com.c4hco.test.automation.pages.exchPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.c4hco.test.automation.utils.BasicActions;

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
        basicActions.waitForElementToBePresent(bodyText.get(0), 30);
        basicActions.assertContainsText(bodyText.get(0).getText(), "Please fill out the following information found on your Health First Colorado denial notice");
        basicActions.assertContainsText(bodyText.get(1).getText(), "Case ID");
        basicActions.assertContainsText(bodyText.get(2).getText(), "Zip Code");
        basicActions.assertContainsText(bodyText.get(3).getText(), "Last Name");
        basicActions.assertPlaceholderTextMatched(caseIDPlaceHolderText, "1BXXXXXX");
        basicActions.assertPlaceholderTextMatched(zipCodePlaceHolderText, "XXXXX");
        basicActions.assertPlaceholderTextMatched(lastNamePlaceHolderText, "");
    }

    public void validateTheVerbiageEs() {
        basicActions.assertContainsText(bodyText.get(0).getText(), "Anote la siguiente informaci");
        basicActions.assertContainsText(bodyText.get(1).getText(), "Identificaci");
        basicActions.assertContainsText(bodyText.get(2).getText(), "digo postal");
        basicActions.assertContainsText(bodyText.get(3).getText(), "Apellido(s)");
        basicActions.assertPlaceholderTextMatched(caseIDPlaceHolderText, "1BXXXXXX");
        basicActions.assertPlaceholderTextMatched(zipCodePlaceHolderText, "XXXXX");
        basicActions.assertPlaceholderTextMatched(lastNamePlaceHolderText, "");
    }
}
