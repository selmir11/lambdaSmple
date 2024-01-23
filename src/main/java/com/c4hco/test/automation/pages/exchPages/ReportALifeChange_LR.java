package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportALifeChange_LR {

    private BasicActions basicActions;

    public ReportALifeChange_LR() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }
    public BasicActions getDriver(){
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//*[@id='birthLce']")
    WebElement checkBirthLCE;
    @FindBy(xpath = "//*[@id='pregnancyLce']")
    WebElement checkPregnancyLCE;
    @FindBy(xpath = "//*[@id='marriageDivorceLce']")
    WebElement checkMarriageDivorceLCE;
    @FindBy(xpath = "//*[@id='lossEmpCovg']")
    WebElement checkLossOfCoverageLCE;
    @FindBy(xpath = "//*[@id='eligibleImmigrationStatus']")
    WebElement checkImmigrationStatusLCE;
    @FindBy(xpath = "//*[@id='gainOfAmericanIndianAlaskaNative']")
    WebElement checkAlaskaNativeLCE;
    @FindBy(xpath = "//*[@id='movedColorado']")
    WebElement checkMovedToColoradoLCE;
    @FindBy(xpath = "//*[@id='incarcerated']")
    WebElement checkIncarceratedStatusLCE;
    @FindBy(xpath = "//*[@id='other']")
    WebElement otherLCE;
    @FindBy(xpath = "//*[@id='noneOfThese']")
    WebElement noneOfThese;
    @FindBy(xpath = "//*[@id='continueButton']")
    WebElement btnContinue;




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
        btnContinue.click();
    }
}
