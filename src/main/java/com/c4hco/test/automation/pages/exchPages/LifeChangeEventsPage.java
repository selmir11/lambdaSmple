package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LifeChangeEventsPage {

    private BasicActions basicActions;

    public LifeChangeEventsPage() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    // TO-DO :: Have a list Element for all the LCE's
    @FindBy(id ="birthLce")
    WebElement checkBirthLCE;
    @FindBy(id = "pregnancyLce")
    WebElement checkPregnancyLCE;
    @FindBy(id = "marriageDivorceLce")
    WebElement checkMarriageDivorceLCE;
    @FindBy(id = "lossEmpCovg")
    WebElement checkLossOfCoverageLCE;
    @FindBy(id = "eligibleImmigrationStatus")
    WebElement checkImmigrationStatusLCE;
    @FindBy(id = "gainOfAmericanIndianAlaskaNative")
    WebElement checkAlaskaNativeLCE;
    @FindBy(id = "movedColorado")
    WebElement checkMovedToColoradoLCE;
    @FindBy(id = "incarcerated")
    WebElement checkIncarceratedStatusLCE;
    @FindBy(id = "other")
    WebElement otherLCE;
    @FindBy(id = "noneOfThese")
    WebElement noneOfThese;
    @FindBy(id = "continueButton")
    WebElement saveAndContinueButton;


    public void birthLCE(){
        checkBirthLCE.click();
    }
    public void pregnancyLCE(){
        checkPregnancyLCE.click();
    }
    public void marriageLCE(){
        checkMarriageDivorceLCE.click();
    }
    public void lossOfCoverageLCE(){
        checkLossOfCoverageLCE.click();
    }
    public void immigrationLCE(){
        checkImmigrationStatusLCE.click();
    }
    public void alaskaNativeLCE(){
        checkAlaskaNativeLCE.click();
    }
    public void movedToCOLCE(){
        checkMovedToColoradoLCE.click();
    }
    public void incarcerationStatus(){
        checkIncarceratedStatusLCE.click();
    }
    public void other(){
        otherLCE.click();
    }
    public void none(){
        noneOfThese.click();
    }
    public void clickContinue(){
        saveAndContinueButton.click();
    }
}
