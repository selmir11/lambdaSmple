package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class MyProfilePage {


    @FindBy(id = "preferredLanguage")
    WebElement  PreferredLanguageDrpCoCo;

    @FindBy(css = "#preferredLanguage option")
    List<WebElement> LanguageDrpOptionsCoCo; //// Select option, English, Spanish

    @FindBy(id = "preferredContactMethod")
    WebElement   PreferredContactDrpCoCo;

    @FindBy(css = "#preferredContactMethod option")
    List<WebElement>  PreferredContactDrpOptionsCoCo; // Select option, Email, Mail
    @FindBy(xpath = "//button[contains(@class,'back-to-welcome')]")
    public WebElement backToWelcomeButton;

    @FindBy(css = ".bottom_buttons_container button")
    List<WebElement> MyProfileButtonCoCo; /// Go back, Make changes, Save buttons

    @FindBy(css = "#userPassword")
    WebElement PasswordInputCoCo;

    @FindBy(css = ".password-button")
    WebElement PasswordSaveChangesCoCo;

    private BasicActions basicActions;
    public MyProfilePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public void backToWelcomeButton() {
        basicActions.waitForElementToBeClickable(backToWelcomeButton, 5);
        backToWelcomeButton.click();
    }

    public void clickMakeChangesButtonCoCo() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 60);
        MyProfileButtonCoCo.get(1).click();
    }

    public void clickSaveButtonCoCo() {
        basicActions.waitForElementListToBePresent(MyProfileButtonCoCo, 40);
        MyProfileButtonCoCo.get(1).click();
        basicActions.waitForElementToBePresent(PasswordInputCoCo,40);
        PasswordInputCoCo.sendKeys(SharedData.getPrimaryMember().getPassword());
        basicActions.waitForElementToBePresent(PasswordSaveChangesCoCo,40);
        PasswordSaveChangesCoCo.click();

    }


    public void clickPreferredLanguageDrpCoCo() {
        basicActions.waitForElementToBePresent(PreferredLanguageDrpCoCo, 60);
        PreferredLanguageDrpCoCo.click();
    }


    public void clickPreferredContactDrpCoCo() {
        basicActions.waitForElementToBePresent(PreferredContactDrpCoCo, 60);
        PreferredContactDrpCoCo.click();
    }


    public void PreferredContactMethod(String contactPrefrences) {
        clickPreferredContactDrpCoCo();
        switch (contactPrefrences){
            case "Email":
                PreferredContactDrpOptionsCoCo.get(1).click();
                break;
            case "Mail":
                PreferredContactDrpOptionsCoCo.get(2).click();
        }
    }

    public void PreferredContactLanguageMethod(String langContactPreferred) {
        clickPreferredLanguageDrpCoCo();
        switch (langContactPreferred){
            case "English":
                LanguageDrpOptionsCoCo.get(1).click();
                break;
            case "Spanish":
                LanguageDrpOptionsCoCo.get(2).click();
        }
    }

}
