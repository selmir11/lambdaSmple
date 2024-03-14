package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OhiEmployerSponsoredHealthInsurancePage {
    private BasicActions basicActions;
    public OhiEmployerSponsoredHealthInsurancePage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(id = "ELIG-Ohi-Esi-GoBack")
    WebElement goBackButton;



    public void clickGoBack() {
        basicActions.click(goBackButton);
    }
}
