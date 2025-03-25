package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.Dto.SharedData;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.Map;

public class DeclarationsAndSignaturePageCoCo {

    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public DeclarationsAndSignaturePageCoCo(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".header-1")
    WebElement hdr_DeclarationsAndSignature;

    @FindBy(css = ".input-label")
    WebElement signatureLabel;

    @FindBy(xpath = "//div[@id='ELIG-DeclarationsAndSignature-signatureBox-container']//div[3]//input")
    WebElement signatureInputField;

    @FindBy(id = "DeclarationsAndSignature-GoBack")
    WebElement goBackButton;

    @FindBy(id = "DeclarationsAndSignature-SaveAndContinue")
    WebElement continueButton;

    @FindBy(xpath="//label[@class='input-label form-label ng-star-inserted']")
    WebElement getSignature;

    @FindBy(css = ".error-message")
    WebElement ErrorMessage;

    @FindBy(css = ".input-error-message .error-icon")
    WebElement ErrorIcon;

    @FindBy(xpath =  "//div/div[1]/p[1]")
    WebElement coloradoConnectWillParagraph;

    @FindBy(xpath =  "//div/div[1]/p[2]")
    WebElement youWillBeAskedParagraph;

    @FindBy(xpath =  "//div/div[1]/p[3]")
    WebElement youHaveTheRightParagraph;

    @FindBy(xpath =  "//div/div[1]/p[4]")
    WebElement voterRegistrationParagraph;

    @FindBy(xpath =  "//div/div[1]/p[5]")
    WebElement otherInformationParagraph;

    @FindBy(xpath =  "//div[1]/p[6]")
    WebElement domesticViolenceParagraph;

    @FindBy(xpath =  "//div[1]/p[7]")
    WebElement protectionOfYourDataParagraph;

    @FindBy(xpath =  "//div[2]/p[1]")
    WebElement imSigningParagraph;

    @FindBy(xpath =  "//div[2]/p[2]")
    WebElement iKnowParagraph;

    @FindBy(css =  ".dns-declarations-signing-details > div")
    WebElement electronicSignatureTxt;

    @FindBy(xpath =  "//div[3]/p[1]")
    WebElement iUnderstandParagraph;

    @FindBy(css =  ".dns-declarations-signing-details > p:nth-child(4)")
    WebElement dateOfSubmissionTxt;

    public void enterSignatureinCoCo(){
        basicActions.waitForElementToBePresent(signatureInputField, 20);
        signatureInputField.sendKeys(SharedData.getPrimaryMember().getCompleteFullName());
    }
    public void goBack() {
        basicActions.waitForElementToBeClickable(goBackButton,10);
        goBackButton.click();
    }

    public void submitApplicationCoCo()  {
        basicActions.waitForElementToBeClickableWithRetries(continueButton,20);
        basicActions.click(continueButton);
    }

    public void enterOBOSignature(){
        basicActions.waitForElementToBeClickable(signatureInputField, 100);
        basicActions.waitForElementToBeClickable(signatureInputField, 50);
        // Extract the text from the element
        String originalText = getSignature.getText();

        // Remove "Electronic Signature:" from the text
        String modifiedText = originalText.replace(" Electronic Signature:", "");
        signatureInputField.sendKeys(modifiedText);
    }

    public void enterInvalidSignatureName() {
        basicActions.waitForElementToBePresent(signatureInputField, 15);
        signatureInputField.sendKeys("sakjchfdgldj");
    }
    //////////////////////////////////////////////VALIDATION METHODS//////////////////////////////////////////////////
    public void verifyHeadersDeclarationsAndSignaturePage(String language){
        switch (language){
            case "English":
                verifyHeadersDeclarationsAndSignaturePageEnglish();
                break;
            case "Spanish":
                verifyHeadersDeclarationsAndSignaturePageSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyHeadersDeclarationsAndSignaturePageEnglish(){
        basicActions.wait(250);
        basicActions.waitForElementToBePresentWithRetries(hdr_DeclarationsAndSignature,120);
        softAssert.assertEquals(hdr_DeclarationsAndSignature.getText(), "Declarations and Signature");
        softAssert.assertAll();
    }

    public void verifyHeadersDeclarationsAndSignaturePageSpanish(){
        basicActions.wait(250);
        basicActions.waitForElementToBePresentWithRetries(hdr_DeclarationsAndSignature,60);
        softAssert.assertEquals(hdr_DeclarationsAndSignature.getText(), "Declaraciones y firma");
        softAssert.assertAll();
    }

    public void verifyErrorFormat() {
        basicActions.waitForElementToBePresent(signatureInputField, 15);
        verifyElementStyles(signatureInputField);
        softAssert.assertAll();
    }

    public void verifyElementStyles(WebElement element) {
        softAssert.assertEquals(element.getCssValue("border-radius"), "6px", element + " Border radius mismatch");
        softAssert.assertEquals(element.getCssValue("border-color"), "rgb(150, 0, 0)", element + " Border color mismatch");
        softAssert.assertEquals(element.getCssValue("background-color"), "rgba(255, 255, 255, 1)", element + " Background color mismatch");
        softAssert.assertEquals(element.getCssValue("color"), "rgba(150, 0, 0, 1)", element + " Text color mismatch");
        softAssert.assertEquals(element.getCssValue("border"), "1px solid rgb(150, 0, 0)", element + " Border mismatch");
    }

    public void verifyElectronicSignatureLabelAndInputBox(String language) {
        basicActions.waitForElementToBePresent(signatureLabel, 15);
        basicActions.waitForElementToBePresent(signatureInputField, 15);
        switch (language){
            case "English":
                softAssert.assertEquals(signatureLabel.getText(), SharedData.getPrimaryMember().getCompleteFullName() + " Electronic Signature:");
                softAssert.assertTrue(signatureInputField.isDisplayed(), "Electronic signature input field is not visible");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(signatureLabel.getText(), SharedData.getPrimaryMember().getCompleteFullName() + " Firma electr\u00F3nica:");
                softAssert.assertTrue(signatureInputField.isDisplayed(), "Electronic signature input field is not visible");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyErrorMessageWithoutEnteringAnythingInInputSignatureBox(String expectedErrorMsg) {
        basicActions.waitForElementToBePresent(ErrorMessage, 15);
        softAssert.assertEquals(ErrorMessage.getText(),expectedErrorMsg);
        softAssert.assertAll();
    }

    public void validateErrorMessageAndStyleProp(DataTable dataTable){
        basicActions.waitForElementToBePresent(ErrorIcon,20);
        basicActions.waitForElementToBePresent(ErrorMessage,10);

        List<Map<String,String>> data = dataTable.asMaps();
                softAssert.assertTrue(ErrorIcon.isDisplayed(),"Error Icon is not visible in the page");
                softAssert.assertTrue(ErrorMessage.isDisplayed(),"Error Message is not visible in the page");
                softAssert.assertEquals(ErrorMessage.getText(), data.get(0).get("Text"));
                softAssert.assertEquals(ErrorMessage.getCssValue("font-size"), data.get(0).get("fontSize"));
                softAssert.assertEquals(ErrorMessage.getCssValue("font-family"), data.get(0).get("fontFamily"));
                softAssert.assertEquals(ErrorMessage.getCssValue("font-weight"), data.get(0).get("fontWeight"));
                softAssert.assertEquals(ErrorMessage.getCssValue("color"), data.get(0).get("color"));
                softAssert.assertEquals(ErrorMessage.getCssValue("line-height"), data.get(0).get("lineHeight"));
                softAssert.assertEquals(ErrorMessage.getCssValue("text-align"), data.get(0).get("textAlign"));
                softAssert.assertAll();
    }

    public void validateLabelTextAndStyleProp(DataTable dataTable){
        basicActions.waitForElementToBePresent(signatureLabel,10);

        List<Map<String,String>> data = dataTable.asMaps();
        softAssert.assertTrue(signatureLabel.isDisplayed(),"Username Electronic signature label not visible");
        softAssert.assertEquals(signatureLabel.getCssValue("font-size"), data.get(0).get("fontSize"));
        softAssert.assertEquals(signatureLabel.getCssValue("font-family"), data.get(0).get("fontFamily"));
        softAssert.assertEquals(signatureLabel.getCssValue("font-weight"), data.get(0).get("fontWeight"));
        softAssert.assertEquals(signatureLabel.getCssValue("color"), data.get(0).get("color"));
        softAssert.assertEquals(signatureLabel.getCssValue("line-height"), data.get(0).get("lineHeight"));
        softAssert.assertEquals(signatureLabel.getCssValue("text-align"), data.get(0).get("textAlign"));
        softAssert.assertAll();
    }

    public void verifyTextEnglishAndSpanishInDASPage(String languageOption){
        switch (languageOption){
            case "English":
                verifyEnglishText_DAS_Page();
                break;
            case "Spanish":
                verifySpanishText_DAS_Page();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + languageOption);
        }
    }

    private void verifyEnglishText_DAS_Page(){
        softAssert.assertEquals(hdr_DeclarationsAndSignature.getText(), "Declarations and Signature");
        softAssert.assertEquals(coloradoConnectWillParagraph.getText(), "Colorado Connect will keep the information you provide private, as required by law. However, you may also choose to share your information with Connect for Health Colorado, our partner. Information that is shared with Connect for Health Colorado is subject to Connect for Health Colorado\u2019s privacy policy: https://connectforhealthco.com/privacy-policy/.");
        softAssert.assertEquals(youWillBeAskedParagraph.getText(), "You will be asked to provide only the minimum information necessary to determine eligibility for relevant health plan options and assistance, as applicable. As part of the process, we will communicate with you or your authorized representative, and then provide the information to the health insurance company you select so that they can enroll anyone who is eligible in either a health plan or a state-subsidized individual health coverage affordability program.");
        softAssert.assertEquals(youHaveTheRightParagraph.getText(), "You have the right to see certain information we have about you. You may also have the right to have this information corrected if we have any incorrect information on file.");
        softAssert.assertEquals(voterRegistrationParagraph.getText(), "Voter Registration\nDo you need to register to vote at your current address? Click here for more information on how to register. Registering to vote will not affect the amount of assistance that you may be eligible to receive.");
        softAssert.assertEquals(otherInformationParagraph.getText(), "1. Other Information\nColorado Connect does not discriminate on the basis of race, color, ethnic or national origin, ancestry, age, sex, gender, gender identity and expression, sexual orientation, marital status, religion, creed, political beliefs, or disability in any of its programs, services and activities. When needed, Colorado Connect can provide aids and services to individuals with disabilities, and language services to individuals whose first language is not English to ensure equal opportunity and meaningful access to programs, services and activities. Examples of aids and services include, but are not limited to, qualified sign language interpreters, information in other formats (including large print), foreign language interpreters, and information translated into other languages. Aids and services can be provided in a timely manner and free of charge. To request free aids or services, contact Colorado Connect at 855-675-2626. To file a discrimination complaint or learn more about this policy, please call 303-590-9640, fax us at 303-322-4217, or contact us by mail at:\n" +
                "Colorado Connect\n" +
                "c/o Connect for Health Colorado\n" +
                "General Counsel\n" +
                "4600 South Ulster Street, Suite 300\n" +
                "Denver, CO 80237");
        softAssert.assertEquals(domesticViolenceParagraph.getText(), "Domestic violence information and services are available to me. If I ever feel I am in immediate danger I will call 911. If I would like to receive information regarding safety and services in Colorado, I will call the Colorado Coalition Against Domestic Violence at 303-831-9632 or toll free at 1-888-778-7091. I may also find the location of services near me by going to https://www.colorado.gov/cdhs/dvp. The National Domestic Violence Hotline at 1-800-799-SAFE (7233) or TTY 1-800-787-3224 or http://ndvh.org/ can also provide information. If I am a survivor of domestic violence, sexual assault, or stalking the Address Confidentiality Program (ACP) can provide me with a legal substitute address to use instead of my real address for use with state and local government agencies. I can find out more about ACP at https://www.colorado.gov/dcs/acp. If I need or receive either of these services, I should tell my department worker or Colorado Connect representative because it will allow him or her to provide better service and assistance to me.");
        softAssert.assertEquals(protectionOfYourDataParagraph.getText(), "Protection of Your Data\nColorado Connect and Connect for Health Colorado have significant protections in place to ensure the privacy of your personal information. To review the full privacy policy for Colorado Connect please visit: https://" + SharedData.getEnv() + "-aws.connectforhealthco.com/coco/InformationPortal/privacyPolicy. To review the full privacy policy for Connect for Health Colorado please visit: http://connectforhealthco.com/site-information/privacy-policy.");
        softAssert.assertEquals(imSigningParagraph.getText(), "I\u2019m signing this application under penalty of perjury, which means I\u2019ve provided true answers to all of the questions to the best of my knowledge. I know that I may be subject to penalties if I intentionally provide false or untrue information.");
        softAssert.assertEquals(iKnowParagraph.getText(), "I know that I must tell the program I\u2019ll be enrolled in if information I listed on this application changes. I understand that a change in my information could affect my eligibility for health insurance plans and financial assistance for me and/or member(s) of my household.");
        softAssert.assertEquals(electronicSignatureTxt.getText(), "Electronic Signature");
        softAssert.assertEquals(iUnderstandParagraph.getText(), "I understand that my electronic signature has the same legal effect and can be enforced in the same way as a written signature. I also understand that I am signing this application on behalf of all members of the household on this application.");
        softAssert.assertEquals(signatureLabel.getText(), basicActions.getMemFirstLastNames("Primary") + " Electronic Signature:");
        softAssert.assertEquals(dateOfSubmissionTxt.getText(), "Date of Submission: " + basicActions.getTodayDate());
        softAssert.assertEquals(goBackButton.getText(),"Go back");
        softAssert.assertEquals(continueButton.getText(),"Continue");
        softAssert.assertAll();
    }

    private void verifySpanishText_DAS_Page(){
        softAssert.assertEquals(hdr_DeclarationsAndSignature.getText(), "Declaraciones y firma");
        softAssert.assertEquals(coloradoConnectWillParagraph.getText(), "Connect for Health Colorado proteger\u00E1 la privacidad de la informaci\u00F3n que usted proporcione, como lo exige la ley. No obstante, usted tambi\u00E9n puede decidir compartir su informaci\u00F3n con nuestro socio, Connect for Health Colorado. La informaci\u00F3n compartida con Connect for Health Colorado est\u00E1 sujeta a la pol\u00EDtica de privacidad de Connect for Health Colorado: https://connectforhealthco.com/es/politica-de-privacidad/.");
        softAssert.assertEquals(youWillBeAskedParagraph.getText(), "Se le pedir\u00E1 proporcionar solamente la informaci\u00F3n m\u00EDnima necesaria para determinar su elegibilidad para las opciones de plan de salud y asistencia pertinentes, seg\u00FAn corresponda. Como parte del proceso, nos comunicaremos con usted o con su representante autorizado y luego proporcionaremos la informaci\u00F3n a la compa\u00F1\u00EDa de seguros de salud que elija para que puedan inscribir a las personas elegibles en un plan de salud calificado o en un programa individual de accesibilidad al seguro subsidiado por el estado.");
        softAssert.assertEquals(youHaveTheRightParagraph.getText(), "Tiene derecho a ver cierta informaci\u00F3n que tenemos sobre usted. Tambi\u00E9n puede tener derecho a solicitar que esa informaci\u00F3n se corrija si tenemos alg\u00FAn dato incorrecto en el archivo.");
        softAssert.assertEquals(voterRegistrationParagraph.getText(), "Registro electoral\n\u00BFNecesita registrarse para votar con su domicilio actual? Haga clic aqu\u00ED si desea m\u00E1s informaci\u00F3n sobre c\u00F3mo registrarse. Registrarse para votar no afectar\u00E1 la cantidad de ayuda para la que sea elegible.");
        softAssert.assertEquals(otherInformationParagraph.getText(), "1. M\u00E1s informaci\u00F3n\nColorado Connect no discrimina por motivos de raza, color, origen \u00E9tnico o nacional, ascendencia, edad, sexo, g\u00E9nero, identidad y expresi\u00F3n de g\u00E9nero, orientaci\u00F3n sexual, estado civil, religi\u00F3n, credo, creencias pol\u00EDticas o discapacidad en ninguno de sus programas, servicios y actividades. Cuando as\u00ED se requiera, Colorado Connect puede brindar apoyos y servicios a personas con discapacidades, as\u00ED como servicios de idioma a personas cuya lengua materna no sea el ingl\u00E9s, para lograr igualdad de oportunidades y acceso constructivo a programas, servicios y actividades. Algunos ejemplos de esos apoyos y servicios son, entre otros: int\u00E9rpretes competentes de lengua de se\u00F1as, informaci\u00F3n en otros formatos (incluida la impresi\u00F3n en letra grande), int\u00E9rpretes de idiomas extranjeros y traducci\u00F3n de informaci\u00F3n a otros idiomas. Los apoyos y servicios pueden brindarse de manera oportuna y sin costo. Para solicitar ayuda o servicios gratuitos, comun\u00EDquese a Colorado llamando al 855-675-2626. Para presentar una denuncia de discriminaci\u00F3n o para conocer mejor esta pol\u00EDtica, llame al 303-590-9640, env\u00EDe un fax al 303-322-4217 o escr\u00EDbanos por correo postal a:\n" +
                "Colorado Connect\n" +
                "c/o Connect for Health Colorado\n" +
                "General Counsel\n" +
                "4600 South Ulster Street, Suite 300\n" +
                "Denver, CO 80237");
        softAssert.assertEquals(domesticViolenceParagraph.getText(), "Tengo a mi disposici\u00F3n informaci\u00F3n y servicios sobre violencia dom\u00E9stica. Si alguna vez me siento en peligro inminente, llamar\u00E9 al 911. Si quisiera recibir informaci\u00F3n sobre seguridad y servicios en Colorado, llamar\u00E9 a la Coalici\u00F3n de Colorado contra la Violencia Dom\u00E9stica al 303-831-9632 o a la l\u00EDnea gratuita al 1- 888-778-7091. Tambi\u00E9n puedo encontrar la ubicaci\u00F3n de servicios cerca de m\u00ED entrando a https://www.colorado.gov/cdhs/dvp La L\u00EDnea Nacional sobre Violencia Dom\u00E9stica tambi\u00E9n puede brindarme informaci\u00F3n llamando al 1-800-799-SAFE (7233) o TTY 1-800-787-3224 o entrando a https://espanol.thehotline.org/ . Si soy superviviente de violencia dom\u00E9stica, agresi\u00F3n sexual o acoso, el Programa de confidencialidad de domicilio (ACP) puede proporcionarme un sustituto legal de mi domicilio para usarlo en vez de mi direcci\u00F3n real con las agencias del gobierno estatal y local. Puedo encontrar m\u00E1s informaci\u00F3n sobre ACP en https://www.colorado.gov/dcs/acp. Si necesito o recibo alguno de estos servicios, debo inform\u00E1rselo al trabajador o trabajadora social o al representante de Colorado Connect, ya que esto le permitir\u00E1 brindarme mejor servicio y asistencia.");
        softAssert.assertEquals(protectionOfYourDataParagraph.getText(), "Protecci\u00F3n de sus datos\nColorado Connect y Connect for Health Colorado han establecido protecciones significativos para garantizar la privacidad de su informaci\u00F3n personal. Si desea revisar la pol\u00EDtica completa de privacidad de Colorado Connect, visite: https://" + SharedData.getEnv() + "-aws.connectforhealthco.com/coco/InformationPortal/privacyPolicy. Si desea revisar la pol\u00EDtica completa de privacidad de Connect for Health Colorado, visite: https://connectforhealthco.com/es/politica-de-privacidad/.");
        softAssert.assertEquals(imSigningParagraph.getText(), "Firmo esta solicitud bajo pena de falso testimonio, lo que significa que he proporcionado respuestas verdaderas a todas las preguntas conforme a mi leal saber y entender. S\u00E9 que puedo verme sujeto a sanciones seg\u00FAn las leyes federales si intencionalmente proporciono informaci\u00F3n falsa o enga\u00F1osa.");
        softAssert.assertEquals(iKnowParagraph.getText(), "Estoy consciente de que debo informar al programa en que estar\u00E9 inscrito cualquier cambio relacionado con los datos de esta solicitud. Comprendo que un cambio en mi informaci\u00F3n podr\u00EDa afectar mi elegibilidad y la elegibilidad de los integrantes de mi familia para planes de seguro de salud y ayuda financiera.");
        softAssert.assertEquals(electronicSignatureTxt.getText(), "Firma Electr\u00F3nica");
        softAssert.assertEquals(iUnderstandParagraph.getText(), "Entiendo que una firma electr\u00F3nica tiene el mismo efecto legal y puede hacerse cumplir de la misma manera que una firma escrita. Entiendo tambi\u00E9n que estoy firmando esta solicitud a nombre de todos los miembros de mi familia relacionados.");
        softAssert.assertEquals(signatureLabel.getText(), basicActions.getMemFirstLastNames("Primary") + " Firma electr\u00F3nica:");
        softAssert.assertEquals(dateOfSubmissionTxt.getText(), "Fecha de env\u00EDo: " + basicActions.getTodayDate());
        softAssert.assertEquals(goBackButton.getText(),"Volver");
        softAssert.assertEquals(continueButton.getText(),"Continuar");
        softAssert.assertAll();
    }

}
