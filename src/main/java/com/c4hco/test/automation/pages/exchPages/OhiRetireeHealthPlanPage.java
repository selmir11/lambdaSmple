package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class OhiRetireeHealthPlanPage {
    private BasicActions basicActions;
    public OhiRetireeHealthPlanPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "submitButton")
    List<WebElement> goBackBtn;



    public void clickGoBack() {
        basicActions.click(goBackBtn.get(0));
    }
    
    
    
}
