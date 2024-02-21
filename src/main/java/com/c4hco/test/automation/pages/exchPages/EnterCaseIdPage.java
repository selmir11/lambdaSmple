package com.c4hco.test.automation.pages.exchPages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.c4hco.test.automation.utils.BasicActions;

public class EnterCaseIdPage {
    private BasicActions basicActions;
    public EnterCaseIdPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);

    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Please fill out the following information found on your Health First Colorado denial notice']")
    WebElement healthFirstColoradoDenialNoticeText;

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Case ID']")
    WebElement caseIDText;

    @FindBy(xpath = "//input[@id='caseId' and @class='form-control' and @type='text' and @maxlength='8' and @placeholder='1BXXXXXX' and @name='caseId']") //
    WebElement caseIDPlaceHolderText;

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Zip Code']")
    WebElement zipCodeText;

    @FindBy(id = "zipCode")
    WebElement verifyZipCodePlaceHolderTextEn;

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Last Name']")
    WebElement lastNameText;

    @FindBy(id = "lastName")
    WebElement LastNamePlaceHolderTextEn;

    @FindBy(xpath = "//span[contains(text(),'Anote la siguiente')]")
    WebElement healthFirstColoradoDenialNoticeTextEs;

    @FindBy(xpath = "//span[contains(text(),'Identificaci')]")
    WebElement caseIDTextEs;

    @FindBy(id = "caseId")
    WebElement caseIDPlaceHolderTextEs;

    @FindBy(xpath = "//span[contains(text(),'digo postal')]")
    WebElement zipCodeTextEs;

    @FindBy(id = "zipCode")
    WebElement verifyZipCodePlaceHolderTextEs;

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Apellido(s)']")
    WebElement lastNameTextEs;

    @FindBy(id = "lastName")
    WebElement LastNamePlaceHolderTextEs;

    public void validateTheElementsOnEnterCaseIdPageEn() {
        basicActions.assertElementTextMatched(healthFirstColoradoDenialNoticeText, "Please fill out the following information found on your Health First Colorado denial notice");
        basicActions.assertElementTextMatched(caseIDText, "Case ID");
        basicActions.assertPlaceholderTextMatched(caseIDPlaceHolderText, "1BXXXXXX");
        basicActions.assertElementTextMatched(zipCodeText, "Zip Code");
        basicActions.assertPlaceholderTextMatched(verifyZipCodePlaceHolderTextEn, "XXXXX");
        basicActions.assertElementTextMatched(lastNameText, "Last Name");
        basicActions.assertPlaceholderTextMatched(LastNamePlaceHolderTextEn, "");

    }

    public void validateTheElementsOnEnterCaseIdPageEs() {
        basicActions.assertElementTextMatched(healthFirstColoradoDenialNoticeTextEs, "Anote la siguiente informaci");
        basicActions.assertElementTextMatched(caseIDTextEs, "del caso");
        basicActions.assertPlaceholderTextMatched(caseIDPlaceHolderTextEs, "1BXXXXXX");
        basicActions.assertElementTextMatched(zipCodeTextEs, "digo postal");
        basicActions.assertPlaceholderTextMatched(verifyZipCodePlaceHolderTextEs, "XXXXX");
        basicActions.assertElementTextMatched(lastNameTextEs, "Apellido(s)");
        basicActions.assertPlaceholderTextMatched(LastNamePlaceHolderTextEs, "");
    }
}
