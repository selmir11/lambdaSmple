package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LawfulPresencePage {
    private BasicActions basicActions;

    public LawfulPresencePage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(id = "usCitizenYes")
    WebElement rdobtnCitizenYes;

    @FindBy(id = "usCitizenNo")
    WebElement rdobtnCitizenNo;

    @FindBy(id = "naturalizedCitizenYes")
    WebElement rdobtnNaturalizedYes;
    @FindBy(id = "naturalizedCitizenNo")
    WebElement rdobtnnaturalizedNo;

    @FindBy(id = "nonCitizenYes")
    WebElement rdobtnEligibleImmigrantYes;

    @FindBy(id = "nonCitzenNo")
    WebElement rdobtnEligibleImmigrantNo;

    @FindBy(id = "documentType")
    WebElement selectDocType;

    @FindBy(name = "saveAndContinue")
    WebElement saveContinue;

    public void isMemberCitizen(String YNCitizen){
        switch(YNCitizen){
            case "Yes":
                rdobtnCitizenYes.click();
                break;
            case "No":
                rdobtnCitizenNo.click();
        }
    }

    public void isMemberNaturalized(String YNNaturalized){
        switch(YNNaturalized){
            case "Yes":
                rdobtnNaturalizedYes.click();
                break;
            case "No":
                rdobtnnaturalizedNo.click();
                break;
        }
    }
    public  void clickContinue(){saveContinue.click();}
}
