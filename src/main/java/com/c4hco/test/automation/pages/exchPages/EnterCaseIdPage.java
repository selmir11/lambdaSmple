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
    WebElement lastNamePlaceHolderTextEn;

    @FindBy(xpath = "//span[contains(text(),'Anote la siguiente')]")
    WebElement healthFirstColoradoDenialNoticeTextEs;

    @FindBy(xpath = "//span[contains(text(),'Identificaci')]")
    WebElement caseIDTextEs;

    @FindBy(id = "caseId")
    WebElement caseIDPlaceHolderTextEs;

    @FindBy(xpath = "//span[contains(text(),'digo postal')]")
    WebElement zipCodeTextEs;

    @FindBy(id = "zipCode")
    WebElement zipCodePlaceHolderTextEs;

    @FindBy(xpath = "//span[@class='c4BodyText1' and text()='Apellido(s)']")
    WebElement lastNameTextEs;

    @FindBy(id = "lastName")
    WebElement lastNamePlaceHolderTextEs;

    public void validateTheElementsOnEnterCaseIdPageEn() {
        basicActions.assertElementDisplayed(healthFirstColoradoDenialNoticeText);
        basicActions.assertElementDisplayed(caseIDText);
        basicActions.assertPlaceholderTextMatched(caseIDPlaceHolderText, "1BXXXXXX");
        basicActions.assertElementDisplayed(zipCodeText);
        basicActions.assertPlaceholderTextMatched(verifyZipCodePlaceHolderTextEn, "XXXXX");
        basicActions.assertElementDisplayed(lastNameText);
        basicActions.assertPlaceholderTextMatched(lastNamePlaceHolderTextEn, "");
    }

    public void validateTheElementsOnEnterCaseIdPageEs() {
        basicActions.assertElementDisplayed(healthFirstColoradoDenialNoticeTextEs);
        basicActions.assertElementDisplayed(caseIDTextEs);
        basicActions.assertPlaceholderTextMatched(caseIDPlaceHolderTextEs, "1BXXXXXX");
        basicActions.assertElementDisplayed(zipCodeTextEs);
        basicActions.assertPlaceholderTextMatched(zipCodePlaceHolderTextEs, "XXXXX");
        basicActions.assertElementDisplayed(lastNameTextEs);
        basicActions.assertPlaceholderTextMatched(lastNamePlaceHolderTextEs, "");
    }

}
