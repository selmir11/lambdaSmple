package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminPage {
    private BasicActions basicActions;
    public AdminPage(){
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//div[@class='form-btn-group big-screen']//button[@id='create-individual-account']")
    public WebElement createAccountAdmin;

    @FindBy(xpath = "//body//app-root//span[3]")
    public WebElement dropdownArrow;

    @FindBy(xpath = "//div[@id='logout-link']")
    public WebElement logoutAdmin;

    public void logoutFromAdmin() {
        navigateToPreviousPage();
        basicActions.waitForElementToBePresent(dropdownArrow,100);
        dropdownArrow.click();
        basicActions.waitForElementToBePresent(logoutAdmin,100);
        logoutAdmin.click();
    }

    public void navigateToPreviousPage(){
        basicActions.getDriver().navigate().back();
    }


    public void clickCreateAccount(){
        basicActions.waitForElementToBePresent(createAccountAdmin,10);
        createAccountAdmin.click();
    }
}
