package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.Utils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FamilyOverviewPage {

    @FindBy (xpath = "//a[text()='Edit/Update']")
    WebElement editUpdateLink;


    private BasicActions basicActions;

    public FamilyOverviewPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickEditUpdateLink() {
        basicActions.waitForElementToBeClickable(editUpdateLink, 30);
        editUpdateLink.click();
    }



}
