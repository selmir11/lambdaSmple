package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class TellUsAboutLifeChanges_LR {

    private BasicActions basicActions;

    public TellUsAboutLifeChanges_LR() {
        this.basicActions = BasicActions.getInstance();
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public BasicActions getDriver() {
        return BasicActions.getInstance();
    }

    @FindBy(xpath = "//*[@id='birth']")
    WebElement birthQLCE;

    @FindBy(xpath = "//input[contains(@class,'checkbox')and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    List<WebElement> allmembersBirthcheckbox;
    @FindBy(xpath = "//input[@type='date'and contains(@id,'BirthAdoptionOrPlacementForAdoption')]")
    WebElement eventDate;
    @FindBy(xpath = "//*[@id='continueButton']")
            WebElement saveAndContinue;

    // Create object of SimpleDateFormat class and decide the format
    DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");

    //get current date time with Date()
    Date date = new Date();

    // Now format the date
   String date1 = dateFormat.format(date);

    public void selectLCE(String LCEtype) {

        switch (LCEtype) {
            case "Birth":
                birthQLCE.click();
                for (var mc = 0; mc < allmembersBirthcheckbox.size(); mc++) {
                    allmembersBirthcheckbox.get(mc).click();
                    eventDate.click();
                    eventDate.sendKeys(date1);
                    // Print the Date
                    System.out.println(date1);
                    break;
                }


        }
    }
    public void saveNContinue(){
        saveAndContinue.click();
    }
}