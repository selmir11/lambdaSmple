package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.actions.ClickAction;
import com.c4hco.test.automation.actions.ScrollAction;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class SelfAttestationPage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public SelfAttestationPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements((basicActions.getDriver()), this);
    }

    private boolean taxNoFlag = false;

    String expectedActionReq =
            "Action Required: Additional Information Needed\n" +
            "\n" +
            "Thank you for verifying your information. Unfortunately, we still need additional documentation to confirm the details you provided. This step ensures you receive the correct financial assistance. If you received premium tax credits but did not report them, you must first file and reconcile past credits with the IRS.\n" +
            "\n" +
            "Next Steps:\n" +
            "File an amended return with the IRS to correct your tax information.\n" +
            "Submit documents to confirm that: (a) you have now filed federal income taxes and reported the premium tax credit that you received and (b) your income is correct.\n" +
            "For more details, please review the information here, contact our support team at 855-752-6749, or get help from an Expert.\n" +
            "Remember:The documents you submit must confirm both your household income and that you have appropriately filed a federal income tax return and reported the premium tax credits you received. You may lose the financial help you\u2019re receiving if you do not provide us with both documents.";

    String expectedActionReqSpanish =
            "Acci\u00F3n requerida: Se necesita m\u00e1s informaci\u00F3n\n" +
            "\n" +
            "Gracias por verificar su informaci\u00F3n. Lamentablemente, todav\u00eda necesitamos documentaci\u00F3n adicional para confirmar los detalles que proporcion\u00F3. Este paso nos permite garantizar que reciba la ayuda financiera correcta.\n"+
            "\n" +
            "Pasos siguientes:\n" +
            "Presentar una declaraci\u00F3n enmendada al IRS para corregir su Informaci\u00F3n sobre los impuestos.\n" +
            "Presentar documentos para confirmar lo siguiente: (a) usted declar\u00F3 impuestos federales sobre el ingreso, declar\u00F3 el cr\u00e9dito fiscal para el pago de la prima que recibi\u00F3 y (b) su ingreso es correcto.\n" +
            "Para obtener m\u00e1s detalles, revise la informaci\u00F3n que se muestra aqu\u00ed, comun\u00edquese con nuestro equipo de soporte llamando al 855-752-6749 o busque la ayuda de un experto.\n" +
            "Recuerde:En los documentos que presente, se deben confirmar tanto su ingreso familiar como su presentaci\u00F3n apropiada de una declaraci\u00F3n de impuestos federales sobre el ingreso y el informe de los cr\u00e9ditos fiscales para el pago de la prima que recibi\u00F3. Es posible que pierda la ayuda financiera que est\u00e1 recibiendo si no nos proporciona ambos documentos.";

   String expectedUpdateText =
           "It looks like we need updated information about what your household income will be for 2025. Please go here to submit a new application.\n" +
           "\n" +
           "Need more help?   Contact our support team at 855-752-6749 or find an expert near you.";

   String expectedUpdateTextSpanish =
           "Parece que necesitamos informaci\u00F3n actualizada sobre su ingreso familiar previsto para el 2025. Entre aqu\u00ed para enviar una solicitud nueva.\n" +
           "\n" +
           "\u00BFNecesita m\u00e1s ayuda?   Comun\u00edquese con nuestro equipo de soporte llamando al 855-752-6749 o busque a un experto cerca de usted.";

   String expectedSuccess =
           "Your income and tax filing information were successfully confirmed.";

   String expectedSuccessSpanish =
           "Su informaci\u00F3n relativa a su ingreso y a la declaraci\u00F3n de impuestos se confirm\u00F3 con \u00e9xito.";


    @FindBy(id ="household_income-MVR.HOUSEHOLD_INCOME.YESButton")
    WebElement householdIncomeYes;

    @FindBy(id = "household_income-MVR.HOUSEHOLD_INCOME.NOButton")
    WebElement householdIncomeNo;

    @FindBy(id = "federal_income-MVR.FEDERAL_INCOME.YESButton")
    WebElement federalIncomeYes;

    @FindBy(id = "federal_income-MVR.FEDERAL_INCOME.NOButton")
    WebElement federalIncomeNo;

    @FindBy(id = "federal_history-MVR.FEDERAL_HISTORY.FH_YESButton")
    WebElement taxYes;

    @FindBy(id = "federal_history-MVR.FEDERAL_HISTORY.NO_PLANButton")
    WebElement taxNoWillFile;

    @FindBy(id = "federal_history-MVR.FEDERAL_HISTORY.FH_NOButton")
    WebElement taxNo;

    @FindBy(id = "Attestation-SaveAndContinue")
    WebElement submit;

    @FindBy(xpath = "/html/body/app-root/lib-base-layout/div/main/div/app-post-attestation/app-container/div/div/div[2]/p")
    WebElement pageText;

    @FindBy(xpath = "/html/body/app-root/lib-base-layout/div/main/div/app-post-attestation/app-container/div/div/div[2]/section")
    WebElement pageText1;

    @FindBy(id = "PostAttestation-SaveAndContinue")
    WebElement finish;

    @FindBy(xpath = "//button[text()='here']")
    WebElement btnClickHereToUpdateApp;

    @FindBy(xpath = "//a[text()='find an expert near you']")
    WebElement btnFindExpertHelp;


    @FindBy(xpath = "//div[@class='container']")
    List <WebElement> txtSelfAttestBodyText;
    //WebElement txtSelfAttestBodyText;

    @FindBy(xpath = "//div[@class='header-1 text-center ng-star-inserted']")
    WebElement txtHeader1;

    @FindBy(xpath = "//a[@class='clickable c4-type-links-lg']")
    WebElement txtHeader2;

    @FindBy(xpath = "//div[@class='p-5 ng-untouched ng-pristine ng-invalid']/p")
    List <WebElement> txtSelfAttestBodyParagraphs;

    @FindBy(xpath = "//div[@class='p-5 ng-untouched ng-pristine ng-invalid']/h5")
    List <WebElement> txtSelfAttestBodyHeaders;

    @FindBy(xpath = "//span[@class='ng-star-inserted']")
    List <WebElement> txtQuestions;

    @FindBy(xpath = "//label[@class='fit-content ng-star-inserted']")
    List <WebElement> txtAnswers;

    @FindBy(xpath = "//div[text()='\u00A1Gracias!']")
    WebElement lblSpanishHeader;

    public void clickHousehold(String householdIncome) {
        basicActions.waitForElementToBeClickable(householdIncomeYes, 10);

        switch (householdIncome) {
            case "Yes":
                householdIncomeYes.click();
                break;
            case "No":
                householdIncomeNo.click();
                break;
            default:
                System.out.println("Unexpected value: " + householdIncome);
                break;
        }
    }

    public void clickFederal(String federalIncome) {
        basicActions.waitForElementToBeClickable(federalIncomeYes, 10);

        switch (federalIncome) {
            case "Yes":
                federalIncomeYes.click();
                break;
            case "No":
                federalIncomeNo.click();
                break;
            default:
                System.out.println("Unexpected value for federalIncome: " + federalIncome);
                break;
        }
    }

    public void clickTax(String taxFiling) {
        basicActions.waitForElementToBeClickable(taxYes, 10);

        switch (taxFiling) {
            case "Yes":
                taxYes.click();
                break;
            case "NoWillFile":
                taxNoWillFile.click();
                break;
            default:
                taxNo.click();
                taxNoFlag = true;
                break;
        }
    }

    public void clickSubmit() {
        basicActions.waitForElementToBeClickable(submit, 10);
        ScrollAction.scrollToElement(submit);
        submit.click();
    }

    public void checkText(String scenario){
        basicActions.waitForElementToBePresent(pageText, 10);
        switch(scenario){
            case "Success":
                softAssert.assertEquals(pageText.getText(), expectedSuccess);
                break;
            case "Action Required":
                softAssert.assertEquals(pageText1.getText(), expectedActionReq);
                break;
            case "Update Application":
                softAssert.assertEquals(pageText1.getText(), expectedUpdateText);
                break;
        }
        softAssert.assertAll();
    }

    public void checkTextSpanish(String scenario){
        basicActions.waitForElementToBePresent(lblSpanishHeader,10);
        switch(scenario){
            case "Success":
                softAssert.assertEquals(pageText.getText(), expectedSuccessSpanish);
                break;
            case "Action Required":
                softAssert.assertEquals(pageText1.getText(), expectedActionReqSpanish);
                break;
            case "Update Application":
                softAssert.assertEquals(pageText1.getText(), expectedUpdateTextSpanish);
                break;
        }
        softAssert.assertAll();
    }

    public void clickFinish() {
        basicActions.waitForElementToBeClickable(finish, 10);
        ScrollAction.scrollToElement(finish);
        finish.click();
    }

    public void clickHereToUpdate(){
        basicActions.waitForElementToBeClickable(btnClickHereToUpdateApp, 10);
        ScrollAction.scrollToElement(btnClickHereToUpdateApp);
        btnClickHereToUpdateApp.click();
    }

    public void clickExpertHelp(){
        basicActions.waitForElementToBeClickable(btnFindExpertHelp, 10);
        ScrollAction.scrollToElement(btnFindExpertHelp);
        btnFindExpertHelp.click();
    }

    public void verifySelfAttestationBodyText(String language){
        basicActions.waitForElementToBePresent(txtHeader1, 15);

        switch(language){
            case "English":
                softAssert.assertEquals(txtHeader1.getText(), "Looks like we need some information");
                softAssert.assertEquals(txtHeader2.getText(), "Help me understand this page");

                softAssert.assertEquals(txtSelfAttestBodyParagraphs.get(0).getText(),"We attempted to verify your application information but need you to confirm a few things.");
                softAssert.assertEquals(txtSelfAttestBodyHeaders.get(0).getText(),"Household Income");
                softAssert.assertEquals(txtQuestions.get(0).getText(),"On your last application, you estimated that your annual household income is $90,000.00. Is this a good estimate of your expected 2025 income?");
                softAssert.assertEquals(txtAnswers.get(0).getText(), "Yes, $90,000.00 is an accurate estimate for my household in 2025.");
                softAssert.assertEquals(txtAnswers.get(1).getText(), "No, my household income has changed and I need to update it.");
                softAssert.assertEquals(txtSelfAttestBodyParagraphs.get(1).getText(), "Remember: You may have to pay back some or all of the financial help you receive if your estimated household income is different than what you report to the IRS when you file taxes. If your household\u2019s income changes later this year, come back to update your application.");
                softAssert.assertEquals(txtSelfAttestBodyHeaders.get(1).getText(),"Filing Federal Income Taxes");
                softAssert.assertEquals(txtSelfAttestBodyParagraphs.get(2).getText(), "People who receive premium tax credits must file federal income taxes for the year they were received. If you received a premium tax credit and did not file your taxes for that year, you will not be eligible for a premium tax credit until you have filed your taxes and reported the amount you received.");
                softAssert.assertEquals(txtQuestions.get(1).getText(),"Did you receive a premium tax credit in the past to help pay for your health insurance premium(s)?");
                softAssert.assertEquals(txtAnswers.get(2).getText(), "Yes");
                softAssert.assertEquals(txtAnswers.get(3).getText(), "No");
                softAssert.assertEquals(txtSelfAttestBodyParagraphs.get(3).getText(), "By clicking \u201cSubmit\u201d, you attest under penalty of perjury by the State of Colorado that the information you\u2019ve provided here is accurate.");

                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(txtHeader1.getText(), "Parece que necesitamos un poco de informaci\u00F3n");
                softAssert.assertEquals(txtHeader2.getText(), "Ayuda para entender esta p\u00e1gina");

                softAssert.assertEquals(txtSelfAttestBodyParagraphs.get(0).getText(),"Intentamos verificar su informaci\u00F3n de solicitud, pero necesitamos que confirme algunas cosas.");
                softAssert.assertEquals(txtSelfAttestBodyHeaders.get(0).getText(),"Ingreso familiar");
                softAssert.assertEquals(txtQuestions.get(0).getText(),"En su \u00FAltima solicitud, usted calcul\u00F3 que su ingreso familiar anual es de $90,000.00. \u00BFEste es un buen c\u00e1lculo de su ingreso previsto para el 2025?");
                softAssert.assertEquals(txtAnswers.get(0).getText(), "S\u00ed, $90,000.00 es un c\u00e1lculo preciso de mi ingreso en 2025.");
                softAssert.assertEquals(txtAnswers.get(1).getText(), "No, mi ingreso familiar ha cambiado y necesito actualizarlo.");
                softAssert.assertEquals(txtSelfAttestBodyParagraphs.get(1).getText(), "Recuerde: Es posible que tenga que devolver la totalidad o parte de la ayuda financiera que reciba si su ingreso familiar calculado difiere del monto que declare al Servicio de Rentas Internas (IRS) cuando declare impuestos. Si su ingreso familiar cambia m\u00e1s adelante durante este a\u00f1o, vuelva para actualizar su solicitud.");
                softAssert.assertEquals(txtSelfAttestBodyHeaders.get(1).getText(),"Declaraci\u00F3n de impuestos federales sobre el ingreso");
                softAssert.assertEquals(txtSelfAttestBodyParagraphs.get(2).getText(), "Las personas que reciban cr\u00e9ditos fiscales para el pago de la prima deben declarar impuestos federales correspondientes al a\u00f1o en que los recibieron. Si recibi\u00F3 un cr\u00e9dito fiscal para el pago de la prima y no declar\u00F3 los impuestos correspondientes a ese a\u00f1o, no ser\u00e1 elegible para recibir un cr\u00e9dito fiscal para el pago de la prima hasta que haya declarado sus impuestos y el monto que recibi\u00F3.");
                softAssert.assertEquals(txtQuestions.get(1).getText(),"En el pasado, \u00BFrecibi\u00F3 un cr\u00e9dito fiscal para el pago de la prima como un medio de ayuda para pagar sus primas de seguro de salud? ");
                softAssert.assertEquals(txtAnswers.get(2).getText(), "S\u00ed");
                softAssert.assertEquals(txtAnswers.get(3).getText(), "No");
                softAssert.assertEquals(txtSelfAttestBodyParagraphs.get(3).getText(), "Al hacer clic en \"Enviar\", usted ratifica bajo pena de falso testimonio por el gobierno del estado de Colorado que la informaci\u00F3n que ha proporcionado mediante el presente es precisa.");


                softAssert.assertAll();
                break;
        }
    }
}