package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class CRMDVRPage {

    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public CRMDVRPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//*[contains(@id, 'formHeaderTitle_')]")
    WebElement DVRNameHeader;

    @FindBy(xpath = "//*[contains(@data-id, 'entity_name_span')]")
    WebElement DVRTitle;

    @FindBy(xpath = "//*[contains(@data-id, 'c4hco_name.fieldControl-text-box-text')]")
    WebElement DVRNameInput;

    @FindBy(xpath = "//*[contains(@data-id, 'c4hco_doctype.fieldControl-text-box-text')]")
    WebElement DVRDocTypeInput;

    @FindBy(xpath = "//*[contains(@aria-label, 'Date of Date Created')]")
    WebElement DVRDateCreated;

    @FindBy(xpath = "//*[contains(@aria-label, 'Time of Date Created')]")
    WebElement DVRTimeCreated;
    @FindBy(xpath = "//span[contains(@class,'pa')][normalize-space()='Deactivate']")
    WebElement btnDeactivate;
    @FindBy(css = "#id-e2da2808-5912-4b2b-a68b-5f4552c0ff74-6")
    WebElement btnDeactivateConfirmation;


    public void checkDVRTitle(String dvrType){
        basicActions.wait(1000);
        basicActions.waitForElementToBePresent(DVRNameHeader, 30);

        softAssert.assertEquals(DVRNameHeader.getText(),dvrType+"- Saved");
        softAssert.assertEquals(DVRTitle.getText(),"Document Verification Record");
        softAssert.assertAll();
    }

    public void checkDVRNameDocType(String dvrType){
        basicActions.waitForElementToBePresent(DVRNameInput, 30);

        softAssert.assertEquals(DVRNameInput.getAttribute("defaultValue"),dvrType);
        softAssert.assertEquals(DVRDocTypeInput.getAttribute("defaultValue"),dvrType);
        softAssert.assertAll();
    }

    public void getDvrTimeDate() {
        basicActions.waitForElementToBePresent(DVRDateCreated, 30);

        String dateText = DVRDateCreated.getAttribute("value");
        String timeText = DVRTimeCreated.getAttribute("value");
        String dvrDateTime = dateText + " " + timeText;

        List<String> savedDvrDateTimes = SharedData.getDvrDateTime();
        if (savedDvrDateTimes == null) {
            savedDvrDateTimes = new ArrayList<>();
        }
        savedDvrDateTimes.add(dvrDateTime);
        SharedData.setDvrDateTime(savedDvrDateTimes);
        List<String> updatedList = SharedData.getDvrDateTime();
        String formattedList = String.join(", ", updatedList);
        System.out.println("DVR Date and Time entries in SharedData: " + formattedList);
    }

    public void compareLastTwoDvrDateTimes(String matchType) {
        List<String> savedDvrDateTimes = SharedData.getDvrDateTime();
        if (savedDvrDateTimes == null || savedDvrDateTimes.size() < 2) {
            System.out.println("Not enough DVR Date and Time entries to compare.");
            return;
        }

        String lastDvrDateTime = savedDvrDateTimes.get(savedDvrDateTimes.size() - 1);
        String secondLastDvrDateTime = savedDvrDateTimes.get(savedDvrDateTimes.size() - 2);
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm a");
        try {
            Date lastDate = dateFormat.parse(lastDvrDateTime);
            Date secondLastDate = dateFormat.parse(secondLastDvrDateTime);
            switch (matchType) {
                case "Same":
                    if (lastDate.equals(secondLastDate)) {
                        System.out.println("The last two DVR Date and Time entries are the same: Last DVR: "+lastDvrDateTime+" Second to last DVR: "+secondLastDvrDateTime);
                    } else {
                        softAssert.fail("The last two DVR Date and Time entries are different. Expected them to be the same: Last DVR: "+lastDvrDateTime+" Second to last DVR: "+secondLastDvrDateTime);
                    }
                    break;
                case "Newer":
                    if (lastDate.after(secondLastDate)) {
                        System.out.println("The last DVR Date and Time entry is more recent: Last DVR: "+lastDvrDateTime+" Second to last DVR: "+secondLastDvrDateTime);
                    } else {
                        softAssert.fail("The second last DVR Date and Time entry is more recent than the last one. Expected the last to be newer: Last DVR: "+lastDvrDateTime+" Second to last DVR: "+secondLastDvrDateTime);
                    }
                    break;
                default:
                    System.out.println("Invalid matchType. Please provide 'Same' or 'Newer'.");
                    break;
            }
        } catch (ParseException e) {
            System.out.println("Error parsing date-time: " + e.getMessage());
        }
        softAssert.assertAll();
    }
    public void clickDeactivateButtonInCRM(){
        basicActions.waitForElementToBePresentWithRetries(btnDeactivate, 90);
        btnDeactivate.click();
        basicActions.wait(2000);
        basicActions.waitForElementToBePresentWithRetries(btnDeactivateConfirmation, 60);
        btnDeactivateConfirmation.click();
}



}
