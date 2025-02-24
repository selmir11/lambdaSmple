package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.math.BigDecimal;
import java.util.List;

public class ApplicationHistoryPage {

    SoftAssert softAssert = new SoftAssert();
    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;

    @FindBy(xpath = "//h1[normalize-space()='Current Application']")
    WebElement currentAppText;

    @FindBy(xpath = "//h1[normalize-space()='Solicitud actual']")
    WebElement currentAppTextSP;

    @FindBy(xpath = "//h2[normalize-space()='Previous Applications']")
    WebElement previousAppText;

    @FindBy(xpath = "//h2[normalize-space()='Solicitudes anteriores']")
    WebElement previousAppTextSP;

    @FindBy(xpath = "//h3[normalize-space()='Application Summary']")
    WebElement previousAppSummaryText;

    @FindBy(xpath = "//h3[normalize-space()='Resumen de la solicitud']")
    WebElement previousAppSummaryTextSP;

    @FindBy(xpath ="//html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[1]/td[1]")
    WebElement applicationIDText;

    @FindBy(xpath ="//html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[2]/td[1]")
    WebElement coverageYearText;

    @FindBy(xpath ="//html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[3]/td[1]")
    WebElement submittedText;

    @FindBy(xpath ="//html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[1]")
    WebElement appPurposeText;

    @FindBy(xpath = "//html[1]/body[1]/div[1]/div[2]/div[2]/div[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/table[1]/tbody[1]/tr[4]/td[2]")
    WebElement QLCEText;

    @FindBy(xpath = "//span[@id='congratsMsg']")
    WebElement congratsText;

    @FindBy(xpath =  "//h3[normalize-space()='Results Summary']")
    WebElement resultsAppSummaryText;

    @FindBy(xpath =  "//h3[normalize-space()='Resultados del resumen']")
    WebElement resultsAppSummaryTextSP;

    @FindBy(xpath =  "//li[normalize-space()='Premium Tax Credit']")
    WebElement premiumTaxText;

    @FindBy(xpath =  "//li[normalize-space()='Cr\u00E9dito fiscal para el pago de la prima']")
    WebElement premiumTaxTextSP;

    @FindBy(xpath =  "//li[normalize-space()='Qualified Health Plan']")
    WebElement qualifiedHealthText;

    @FindBy(xpath =  "//li[normalize-space()='Plan de salud calificado']")
    WebElement qualifiedHealthTextSP;

    @FindBy(xpath =  "//td[@id='total-savings']")
    WebElement totalSavingsText;

    @FindBy(xpath = "//li[normalize-space()='Health First Colorado or CHP+, if the State of Colorado determines you qualify']")
    WebElement healthFirstText;
    @FindBy(xpath = "//li[normalize-space()='Health First Colorado o CHP+, si el Gobierno del estado de Colorado decide que usted califica']")
    WebElement healthFirstTextSP;



    @FindBy(xpath =  "//button[@name='viewResults']")
    WebElement viewResultsText;

    @FindBy(id = "month-pay")
    WebElement lblAPTCValue;
    @FindBy(xpath = "//button[@name= 'viewResults']")
    WebElement viewResultsAndShop;
    @FindBy(id = "price-background")
    WebElement aptcSection;
    @FindBy(css = "table tbody  #align-right")
    List<WebElement> applicationSummary;
    @FindBy(css=".self-attestation-title")
    WebElement mvrPopUp;
    @FindBy(css= ".no-self-attestation-btn")
    WebElement noBtnMvrPopUp;
    @FindBy(css = ".verify-myinfo-btn")
    WebElement yesBtnMvrPopUp;
    @FindBy(xpath = "//button[text()='Back to Welcome Page']")
    WebElement goBackToWelcomePage;
    @FindBy(css = "div.not-qualified-div")
    WebElement taxHouseholdNotQualify;

    @FindBy(xpath = "//div[@id='current-app']/h1")
    List<WebElement> currentApplication ;


    private BasicActions basicActions;

    public ApplicationHistoryPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickViewResults(){
        setApplicationId();
        if(mvrPopUp.isDisplayed()){
            noBtnMvrPopUp.click();
        }
        basicActions.waitForElementToBeClickable(viewResultsAndShop, 10);
        basicActions.clickElementWithRetries(viewResultsAndShop, 10);
    }

    private void setApplicationId(){
        basicActions.waitForElementListToBePresent(applicationSummary, 10);
        String applicationid = applicationSummary.get(0).getText();
        SharedData.getPrimaryMember().setApplication_id(applicationid);
        System.out.println("Application Id : "+ applicationid);
    }

    public void setUpdatedPremiums(){
        basicActions.waitForElementToBePresent(lblAPTCValue, 10);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        String medAPTCAmt = lblAPTCValue.getText().replace("$", "").replace("/mo", "");
        subscriber.setMedicalAptcAmt(medAPTCAmt);

        String totalMedPremiumAfterReduction =  String.format("%.2f",Float.parseFloat(SharedData.getPrimaryMember().getMedicalPremiumAmt()) - Float.parseFloat(SharedData.getPrimaryMember().getMedicalAptcAmt()));
        subscriber.setTotalMedAmtAfterReduction(totalMedPremiumAfterReduction);

        BigDecimal bigDecimalmedPremiumMinusAPTC = new BigDecimal(totalMedPremiumAfterReduction);
        BigDecimal bigDecimalmedAPTCAmt = new BigDecimal(medAPTCAmt);

        BigDecimal totalMedicalPremium = bigDecimalmedPremiumMinusAPTC.add( bigDecimalmedAPTCAmt );
        subscriber.setMedicalPremiumAmt( String.valueOf( totalMedicalPremium ) );
    }

    public void validateAPTC(String expectedAPTC){
        basicActions.waitForElementToBePresent(lblAPTCValue, 30);
        String APTC = lblAPTCValue.getText();
        Assert.assertTrue(APTC.contains(expectedAPTC),"Incorrected APTC Amount! Expected "+expectedAPTC+" but "+APTC+" displayed.");
    }

    public void validateTextOnPage(String Text){
        basicActions.waitForElementToBePresent(lblAPTCValue, 15);

        basicActions.waitForElementToBePresent(basicActions.getDriver().findElement(By.xpath("//*[text()='"+Text+"']")), 15);
    }

    public void backToWelcomePage(){
        goBackToWelcomePage.click();
    }

    public void validateTextDoesNotExistOnPage(String Text){
        basicActions.waitForElementToBePresent(viewResultsAndShop, 15);
        Assert.assertEquals(0, basicActions.getDriver().findElements(By.xpath("//*[text()='"+Text+"']")).size());
    }

    public void validateAptcSectionDoesntExist(){
        basicActions.waitForElementToBePresent(viewResultsAndShop, 10);
        Assert.assertFalse(basicActions.isElementDisplayed(aptcSection, 3));
    }

    public void clickVerifyMyInfoText(String popUpOption){
        switch (popUpOption){
            case "Verify My Information":
                basicActions.waitForElementToBePresent(yesBtnMvrPopUp,10);
                yesBtnMvrPopUp.click();
                break;
            case "No":
                basicActions.waitForElementToBePresent(noBtnMvrPopUp,10);
                noBtnMvrPopUp.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + popUpOption);
        }
    }
    public void validateMemberEligibilityForMA() {
    Assert.assertEquals(taxHouseholdNotQualify.getText(), "Based on the information listed in your application, you do not qualify for a health plan at this time.");
    }

    public void iValidateApplicationHistoryText(String language){
            basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
            switch (language) {
                case "EnglishQHP":
                    validateApplciationHistoryPageEnglish();
                    break;
                case "SpanishQHP":
                    validateApplciationHistoryPageSpanish();
                    break;
                case "EnglishNonQHP":
                    validateApplciationHistoryPageEnglish2();
                    break;
                case "SpanishNonQHP":
                    validateApplciationHistoryPageSpanish2();
                    break;

                default:
                    throw new IllegalArgumentException( "Invalid option: " + language );
            }
        }



    public void validateApplciationHistoryPageEnglish(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.waitForElementToBePresent(currentAppText,20  );
        softAssert.assertEquals( currentAppText.getText(), "Current Application" );
        softAssert.assertEquals( previousAppText.getText(), "Previous Applications" );

        softAssert.assertEquals( previousAppSummaryText.getText(), "Application Summary" );
        softAssert.assertEquals( applicationIDText.getText(),"Application ID" );
        softAssert.assertEquals( coverageYearText.getText(), "Coverage Year" );
        softAssert.assertEquals( submittedText.getText(),"Submitted on" );
        softAssert.assertEquals( appPurposeText.getText(),"Application Purpose" );
        softAssert.assertEquals( QLCEText.getText(),"Qualified Life Change Event" );
        softAssert.assertEquals( congratsText.getText(),"Congratulations! You and/or members of your household qualify for the following:" );

        softAssert.assertEquals( resultsAppSummaryText.getText(),"Results Summary" );
        softAssert.assertEquals( qualifiedHealthText.getText(),"Qualified Health Plan" );
        softAssert.assertEquals( healthFirstText.getText(), "Health First Colorado or CHP+, if the State of Colorado determines you qualify" );
        softAssert.assertEquals( viewResultsText.getText(),"View Results and Shop" );
        softAssert.assertAll();
    }

    public void validateApplciationHistoryPageSpanish(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.waitForElementToBePresent(currentAppText,20  );
        softAssert.assertEquals( currentAppTextSP.getText(), "Solicitud actual" );
        softAssert.assertEquals( previousAppTextSP.getText(), "Solicitudes anteriores" );

        softAssert.assertEquals( previousAppSummaryTextSP.getText(), "Resumen de la solicitud" );
        softAssert.assertEquals( applicationIDText.getText(),"Identificaci\u00F3n de solicitud" );
        softAssert.assertEquals( coverageYearText.getText(), "A\u00F1o de cobertura" );
        softAssert.assertEquals( submittedText.getText(),"Enviado el" );
        softAssert.assertEquals( appPurposeText.getText(),"Prop\u00F3sito de la solicitud" );
        softAssert.assertEquals( QLCEText.getText(),"Evento de vida calificado" );

        softAssert.assertEquals( resultsAppSummaryTextSP.getText(),"Resultados del resumen" );
        softAssert.assertEquals( congratsText.getText(),"\u00A1Felicitaciones! Usted y sus familiares califican para lo siguiente:" );
        softAssert.assertEquals( qualifiedHealthTextSP.getText(),"Plan de salud calificado" );

        softAssert.assertEquals( healthFirstTextSP.getText(), "Health First Colorado o CHP+, si el Gobierno del estado de Colorado decide que usted califica" );
        softAssert.assertEquals( viewResultsText.getText(),"Ver resultados y comprar" );
        softAssert.assertAll();
    }
    public void validateApplciationHistoryPageEnglish2(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.waitForElementToBePresent(currentAppText,20  );
        softAssert.assertEquals( currentAppText.getText(), "Current Application" );
        softAssert.assertEquals( previousAppText.getText(), "Previous Applications" );

        softAssert.assertEquals( previousAppSummaryText.getText(), "Application Summary" );
        softAssert.assertEquals( applicationIDText.getText(),"Application ID" );
        softAssert.assertEquals( coverageYearText.getText(), "Coverage Year" );
        softAssert.assertEquals( submittedText.getText(),"Submitted on" );
        softAssert.assertEquals( appPurposeText.getText(),"Application Purpose" );
        softAssert.assertEquals( QLCEText.getText(),"Qualified Life Change Event" );
        softAssert.assertEquals( congratsText.getText(),"Congratulations! You and/or members of your household qualify for the following:" );

        softAssert.assertEquals( resultsAppSummaryText.getText(),"Results Summary" );
        softAssert.assertEquals( premiumTaxText.getText(),"Premium Tax Credit" );
        softAssert.assertEquals( qualifiedHealthText.getText(),"Qualified Health Plan" );
        softAssert.assertEquals( totalSavingsText.getText(),"Total Savings" );
        softAssert.assertEquals( viewResultsText.getText(),"View Results and Shop" );
        softAssert.assertAll();
    }

    public void validateApplciationHistoryPageSpanish2(){
        basicActions.waitForElementToBePresentWithRetries( spinner, 30 );
        basicActions.waitForElementToBePresent(currentAppText,20  );
        softAssert.assertEquals( currentAppTextSP.getText(), "Solicitud actual" );
        softAssert.assertEquals( previousAppTextSP.getText(), "Solicitudes anteriores" );

        softAssert.assertEquals( previousAppSummaryTextSP.getText(), "Resumen de la solicitud" );
        softAssert.assertEquals( applicationIDText.getText(),"Identificaci\u00F3n de solicitud" );
        softAssert.assertEquals( coverageYearText.getText(), "A\u00F1o de cobertura" );
        softAssert.assertEquals( submittedText.getText(),"Enviado el" );
        softAssert.assertEquals( appPurposeText.getText(),"Prop\u00F3sito de la solicitud" );
        softAssert.assertEquals( QLCEText.getText(),"Evento de vida calificado" );

        softAssert.assertEquals( resultsAppSummaryTextSP.getText(),"Resultados del resumen" );
        softAssert.assertEquals( congratsText.getText(),"\u00A1Felicitaciones! Usted y sus familiares califican para lo siguiente:" );
        softAssert.assertEquals( premiumTaxTextSP.getText(),"Cr\u00E9dito fiscal para el pago de la prima" );
        softAssert.assertEquals( qualifiedHealthTextSP.getText(),"Plan de salud calificado" );
        softAssert.assertEquals( totalSavingsText.getText(),"Total de ahorros" );
        softAssert.assertEquals( viewResultsText.getText(),"Ver resultados y comprar" );
        softAssert.assertAll();
    }


    public void validatetextWithNoPolicy(String text) {
        basicActions.waitForElementListToBePresent(currentApplication, 40);
        System.out.println(currentApplication.get(0).getText());
        Assert.assertEquals(currentApplication.get(0).getText(), "Solicitud actual" , text + "Not Found");

    }
}
