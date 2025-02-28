package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.List;

public class FiveYearBarPage {

    private BasicActions basicActions;
    public FiveYearBarPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    SoftAssert softAssert = new SoftAssert();

    @FindBy(css = "#overview")
    WebElement linkHelpMeUnderstand;

    @FindBy(xpath = "//*[@class='drawer-title text-color-light-blue']")
    WebElement textLawfulPresence;

    @FindBy(xpath = "//li[@id]/b")
    List<WebElement> textLawfulPresenceAllHeadings;

    public void clickHelpMeUnderstandLink(){
        basicActions.waitForElementToBePresent(linkHelpMeUnderstand,10);
        linkHelpMeUnderstand.click();
    }

    public void validatePageTextEnglishAndSpanish(List<String> languageText){
        basicActions.waitForElementToBePresent(textLawfulPresence,10);
        softAssert.assertEquals(textLawfulPresence.getText(),languageText.get(0));
        for (int i=0;i<textLawfulPresenceAllHeadings.size();i++){
            softAssert.assertEquals(textLawfulPresenceAllHeadings.get(i).getText(),languageText.get(i+1));
        }
        softAssert.assertAll();
    }
}
