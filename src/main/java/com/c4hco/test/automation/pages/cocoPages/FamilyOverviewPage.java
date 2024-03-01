package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FamilyOverviewPage {
    @FindBy(xpath = "//h1[contains(text(), 'Family Overview: Here’s what you’ve told us so far')]")
    WebElement familyOverviewHeader;

    @FindBy (css = "app-family-member-overview a.edit-update-btn")
    List<WebElement> editUpdateLink;

    @FindBy(id = "familyOverview-SaveAndContinue")
    WebElement continueButton;

    private BasicActions basicActions;

    public FamilyOverviewPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickPrimaryEditUpdateLink() {
        basicActions.waitForElementListToBePresent(editUpdateLink, 30);
        editUpdateLink.get(0).click();
    }

    public void clickContinueButton() {
        basicActions.waitForElementToBeClickable(continueButton, 30);
        continueButton.click();
    }

}
