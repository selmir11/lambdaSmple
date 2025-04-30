package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class DeclarationsAndSignaturePage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public DeclarationsAndSignaturePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".container h1")
    WebElement hdrDeclarations;

    @FindBy(name = "continue")
    WebElement submitContinue;

    @FindBy(id = "holdon-content")
    WebElement holdOnEllipsis;

    @FindBy(xpath = "//*[@class='container']/h1")
    WebElement textPageHeader;

    @FindBy(xpath = "//*[@class='c4PageTitle']")
    List<WebElement> textPageTitles;

    @FindBy(xpath ="//*[@id='primaryCopyContainer']/p")
    List<WebElement> textPrimaryCopyContainer;

    @FindBy(xpath ="//*[@id='voterRegistrationContainer']/p")
    List<WebElement> textVoterRegistrationContainer;

    @FindBy(xpath ="(//*[@id='noticeOfAppealRightsContainer'])[1]/p")
    List<WebElement> textNoticeOfAppealRightsContainer;

    @FindBy(xpath ="(//div[@id='noticeOfAppealRightsContainer'])[1]/ol/li")
    List<WebElement> textRequestAnAppeal;

    @FindBy(xpath ="//*[@id='appealMailAddressList']")
    WebElement textAppealMailAddressList;

    @FindBy(xpath ="(//*[@id='noticeOfAppealRightsContainer'])[2]/p")
    List<WebElement> textOtherInfoContainer;

    @FindBy(xpath ="(//*[@id='noticeOfAppealRightsContainer'])[2]/ul/li")
    List<WebElement> textFileDiscriminationAndCivilRightsComplaintDetails;

    @FindBy(xpath ="//*[@id='dataProtectionContainer']/p")
    List<WebElement> textDataProtectionContainer;

    @FindBy(xpath ="//*[@id='incomeCheckContainer']/p")
    List<WebElement> textIncomeCheckContainer;

    @FindBy(xpath ="//*[@class='label-checkbox']/span")
    List<WebElement> textLabelCheckBox;

    @FindBy(xpath ="//*[@class='label-checkbox']/following::p")
    List<WebElement> textLabelCheckBoxP;

    @FindBy(xpath ="//*[@class='control-label']/b")
    List<WebElement> textControlLabel;

    @FindBy(id = "submitButton")
    WebElement buttonBackDeclarationAndSignature;

    @FindBy(xpath ="//*[@name='continue']")
    WebElement buttonContinueDeclarationAndSignature;





    public void enterSignature(int index){
        basicActions.waitForElementToBePresent(hdrDeclarations,20);
        basicActions.waitForElementToBePresent(submitContinue,20);
        String namePath = "(//div/label/b[1])["+index+"]";
        String signature = basicActions.getDriver().findElement(By.xpath(namePath)).getText();

        index = index-1;

        String signBoxPath = "signeeList"+index+".signature";
        WebElement signatureBox =  basicActions.getDriver().findElement(By.id(signBoxPath));
        signatureBox.click();
        signatureBox.sendKeys(signature);
        List<MemberDetails> members = basicActions.getAllMem();
        for(MemberDetails member: members){
            if(signature.contains(member.getFirstName())){
                member.setIsSubscriber("Y");
            }
        }
    }

    public void submitApplication()  {
        basicActions.waitForElementToBePresent(submitContinue, 30);
        submitContinue.click();
        basicActions.wait(15000);
    }

    public void waitForHoldOnContentToDisappear(){
        basicActions.waitForElementToDisappear(holdOnEllipsis, 120);
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

        softAssert.assertEquals(textPageHeader.getText(), "Declarations and Signature");
        softAssert.assertEquals(textPageTitles.get(0).getText(), "Voter Registration");
        softAssert.assertEquals(textPageTitles.get(1).getText(), "Notice of Appeal Rights");
        softAssert.assertEquals(textPageTitles.get(2).getText(), "Other Information");
        softAssert.assertEquals(textPageTitles.get(3).getText(), "Protection of Your Data");
        softAssert.assertEquals(textPrimaryCopyContainer.get(0).getText(), "Connect for Health Colorado (\u201Cthe Marketplace\u201D) and the Colorado Department of Health Care Policy and Financing will keep the information you provide private, as required by law. However, if you chose to apply for assistance, the Marketplace and Colorado Department of Health Care Policy and Financing can use or share your household information with other program(s). The information can only be used for purposes of insurance coverage, treatment, payment, determining eligibility, and other program and administrative operations or other purposes permitted by law. Assistance programs will check your answers using information in our electronic databases and the databases of partner agencies. If the information does not match, we may ask you to send us proof.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(1).getText(), "Free or low-cost public health insurance from Health First Colorado (Colorado\u2019s Medicaid Program) or the Child Health Plan Plus (CHP+) program administered by the Colorado Department of Health Care Policy and Financing.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(2).getText(), "You will be asked to provide only the minimum information necessary to determine eligibility for assistance and relevant health plan options, as applicable. As part of the process, we will communicate with you or your authorized representative, and then provide the information to the health plan you select so that they can enroll those who are eligible in a qualified health plan or an insurance affordability program.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(3).getText(), "Demographic information on race and ethnicity will be shared with health insurance carriers by the Marketplace only for the purpose of determining your eligibility for benefits that are applicable to certain ethnic groups.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(4).getText(), "Health insurance carriers can no longer deny coverage based on your health status. If you are seeking assistance, we may ask you screening questions about your medical history to help us determine which assistance programs you are eligible for. This information is not used to determine your insurance rates. Household members who do not want insurance will not be asked questions about citizenship or immigration status.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(5).getText(), "Important: The Marketplace and the Colorado Department of Health Care Policy and Financing are authorized to collect information on the application, including Social Security numbers, and will confirm information that may affect initial or ongoing eligibility for all persons listed on your application. You are allowing the Marketplace and the Colorado Department of Health Care Policy and Financing to use Social Security numbers and other information from your application to request and receive information or records to confirm the information in your application; if you apply for other public assistance programs, the Department of Human Services may use this information as well. You release the Marketplace and the Colorado Department of Health Care Policy and Financing from all liability for sharing this information with other agencies for this purpose. For example, the Marketplace and the Colorado Department of Health Care Policy and Financing may receive from and/or share your information with any of the following agencies: Social Security Administration; Internal Revenue Service; United States Customs and Immigration Services; Department of Homeland Security; Centers for Medicare and Medicaid Services; Colorado Department of Labor and Employment; Financial institutions (banks, savings and loans, credit unions, insurance companies, etc.); child support enforcement agencies; employers; courts; and other federal or state agencies. We need this information to check your eligibility for health insurance or help paying for health insurance and to give you the best service possible if you choose to apply.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(6).getText(), "The Marketplace and the Colorado Department of Health Care Policy and Financing will also use the information you provide as part of the ongoing operation of both agencies, including activities such as reporting on and managing the insurance affordability programs for eligible individuals, performing oversight and quality control activities, combatting fraud, and responding to any concerns about the security or confidentiality of the information. We will use the information you provide for our internal business purposes only, and we will not sell or trade it.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(7).getText(), "You have the right to see certain information we have about you. You may also have the right to have this information corrected if we have any incorrect information on file.");
        softAssert.assertEquals(textVoterRegistrationContainer.get(0).getText(), "Do you need to register to vote at your current address? Click here for more information on how to register.");
        softAssert.assertEquals(textVoterRegistrationContainer.get(1).getText(), "Registering to vote will not affect the amount of assistance that you may be eligible to receive.");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(0).getText(),"If you disagree with your household\u2019s eligibility determination, you may file an appeal. You must request an appeal of the results of your eligibility within 60 days of your determination. You can do this by requesting an informal resolution, a formal hearing or both. You may log into your Connect for Health Colorado account to see a summary of the information we used for your eligibility determination.");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(1).getText(),"You can request an appeal in one of these four ways:");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(2).getText(),"You have the right to representation:");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(3).getText(),"You can represent yourself, be represented by a lawyer, or be represented by another person of your choice, such as a friend or family member.");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(4).getText(),"An appeal decision for one household member may change eligibility for other household members.");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(5).getText(),"Expedited Hearing:");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(6).getText(),"If you think waiting for a hearing might jeopardize your life or health, you have the right to ask for an expedited (faster) hearing. To request an expedited hearing, use the same process for a regular appeal and hearing, but say that you want an \u201Cexpedited hearing\u201D and explain why it should be expedited.");
        softAssert.assertEquals(textRequestAnAppeal.get(0).getText(),"Call 1-855-PLANS-4-YOU or TTY: 855-346-3432.");
        softAssert.assertEquals(textRequestAnAppeal.get(1).getText(),"Visit ConnectForHealthCO.com and go to \u201CResources\u201D to download an Appeal Request form. You can upload the completed Appeal Request form to your Connect for Health Colorado account in \u201CMy Documents.\u201D");
        softAssert.assertEquals(textRequestAnAppeal.get(2).getText(),"Mail or bring your Appeal Request form to:");
        softAssert.assertEquals(textRequestAnAppeal.get(3).getText(),"Fax your Appeal Request Form to 303-322-4217.");
        softAssert.assertEquals(textAppealMailAddressList.getText(), """
                        Office of Conflict Resolution and Appeals
                        4600 South Ulster Street, Suite 300
                        Denver, CO 80237""");
        softAssert.assertEquals(textOtherInfoContainer.get(0).getText(),"Connect for Health Colorado does not discriminate on the basis of race, color, ethnic or national origin, ancestry, age, sex, gender, gender identity and expression, sexual orientation, marital status, religion, creed, political beliefs, or disability in any of its programs, services and activities.");
        softAssert.assertEquals(textOtherInfoContainer.get(1).getText(),"Connect for Health Colorado can provide aids and services to individuals with disabilities, and language services to individuals whose first language is not English, when needed to ensure equal opportunity and meaningful access to programs, services and activities. Examples of aids and services include, but are not limited to, qualified sign language interpreters, information in other formats (including large print), foreign language interpreters, and information translated into other languages. Aids and services can be provided in a timely manner and free of charge.");
        softAssert.assertEquals(textOtherInfoContainer.get(2).getText(),"To request free aids or services, contact Connect for Health Colorado at 855-PLANS-4-YOU (855-752-6749) or TTY: 855-346-3432.");
        softAssert.assertEquals(textOtherInfoContainer.get(3).getText(),"To file a discrimination complaint or learn more about this policy, please call 303-590-9640, fax us at 303-322-4217, or contact us by mail at:");
        softAssert.assertEquals(textOtherInfoContainer.get(4).getText(),"Civil rights complaints can also be filed with the U.S. Department of Health and Human Services Office for Civil Rights electronically through the Office for Civil Rights Complaint Portal available at https://ocrportal.hhs.gov/ocr/cp/complaint_frontpage.jsf ; or by phone, fax or mail at:");
        softAssert.assertEquals(textOtherInfoContainer.get(5).getText(),"Complaint forms are available at http://www.hhs.gov/civil-rights/filing-a-complaint/index.html");
        softAssert.assertEquals(textOtherInfoContainer.get(6).getText(),"Domestic violence information and services are available to me. If I ever feel I am in immediate danger I will call 911. If I would like to receive information regarding safety and services in Colorado, I will call the Colorado Coalition Against Domestic Violence at 303-831-9632 or toll free at 1-888-778-7091. I may also find the location of services near me by going to https://www.colorado.gov/cdhs/dvp. The National Domestic Violence Hotline at 1-800-799-SAFE (7233) or TTY 1-800-787-3224 or ndvh.org can also provide information. If I am a survivor of domestic violence, sexual assault, or stalking the Address Confidentiality Program (ACP) can provide me with a legal substitute address to use instead of my real address for use with state and local government agencies. I can find out more about ACP at https://www.colorado.gov/dcs/acp. If I need or receive either of these services, I should tell my department worker or Connect for Health Colorado representative because it will allow him or her to provide better service and assistance to me.");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(0).getText(),"Connect for Health Colorado");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(1).getText(),"General Counsel");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(2).getText(),"4600 South Ulster Street, Suite 300");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(3).getText(),"Denver, CO 80237");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(4).getText(),"Telephone: 800-368-1019");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(5).getText(),"Fax: 202-619-3818");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(6).getText(),"TDD: 800-537-7697");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(7).getText(),"1961 Stout Street Room 08-148");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(8).getText(),"Denver, CO 80294");
        softAssert.assertEquals(textDataProtectionContainer.get(0).getText(),"Connect for Health Colorado and the Colorado Department of Health Care Policy and Financing have significant protections in place to ensure the privacy of your personal information.");
        softAssert.assertEquals(textDataProtectionContainer.get(1).getText(),"To review the full privacy policy for Connect for Health Colorado please visit:");
        softAssert.assertEquals(textDataProtectionContainer.get(2).getText(),"http://connectforhealthco.com/site-information/privacy-policy/");
        softAssert.assertEquals(textDataProtectionContainer.get(3).getText(),"To review the full privacy policy for Colorado Department of Health Care Policy and Financing please visit:");
        softAssert.assertEquals(textDataProtectionContainer.get(4).getText(),"https://www.colorado.gov/pacific/hcpf/health-insurance-portability-and-accountability-act-hipaa-0");
        softAssert.assertEquals(textIncomeCheckContainer.get(0).getText(),"To make it easier to determine my eligibility for help paying for health insurance in future years, I agree to allow Connect for Health Colorado to use computer sources, such as the IRS, to check my income. Connect for Health Colorado will check to make sure I\u2019m still eligible, and may ask me to provide proof of my income to ensure I still qualify. I can opt out of this at any time. I understand that if I choose not to allow Connect for Health Colorado to use computer sources, I must complete a renewal application every 12 months in order to continue my health insurance.");
        softAssert.assertEquals(textIncomeCheckContainer.get(1).getText(),"Allow Connect for Health Colorado to check my eligibility for:");
        softAssert.assertEquals(textLabelCheckBox.get(0).getText(),"Years");
        softAssert.assertEquals(textLabelCheckBox.get(1).getText(),"Years");
        softAssert.assertEquals(textLabelCheckBox.get(2).getText(),"Years");
        softAssert.assertEquals(textLabelCheckBox.get(3).getText(),"Years");
        softAssert.assertEquals(textLabelCheckBox.get(4).getText(),"Year");
        softAssert.assertEquals(textLabelCheckBox.get(5).getText(),"I do not want Connect for Health Colorado to check my tax returns at renewal.");
        softAssert.assertEquals(textLabelCheckBoxP.get(0).getText(),"I\u2019m signing this application under penalty of perjury, which means I\u2019ve provided true answers to all of the questions to the best of my knowledge. I know that I may be subject to penalties under federal law if I intentionally provide false or untrue information.");
        softAssert.assertEquals(textLabelCheckBoxP.get(1).getText(),"I know that I must tell the program I\u2019ll be enrolled in if information I listed on this application changes. I understand that a change in my information could affect my eligibility for member(s) of my household.");
        softAssert.assertEquals(textLabelCheckBoxP.get(2).getText(),"I understand that my electronic signature has the same legal effect and can be enforced in the same way as a written signature. I also understand that I am signing this application on behalf of all members of the household on this application.");
        softAssert.assertTrue(textLabelCheckBoxP.get(3).getText().contains("Date of Submission:"));
        softAssert.assertTrue(textControlLabel.get(0).getText().contains("PrimaryMember"));
        softAssert.assertEquals(textControlLabel.get(1).getText(),"Electronic Signature:");
        softAssert.assertEquals(buttonBackDeclarationAndSignature.getAttribute("value"),"< Back");
        softAssert.assertEquals(buttonContinueDeclarationAndSignature.getAttribute("value"),"Continue");
        softAssert.assertAll();
    }

    private void verifySpanishText_DAS_Page(){

        softAssert.assertEquals(textPageHeader.getText(), "Declaraciones y firma");
        softAssert.assertEquals(textPageTitles.get(0).getText(), "Registro electoral");
        softAssert.assertEquals(textPageTitles.get(1).getText(), "Aviso sobre derechos de apelación");
        softAssert.assertEquals(textPageTitles.get(2).getText(), "Otra información");
        softAssert.assertEquals(textPageTitles.get(3).getText(), "Protección de sus datos");
        softAssert.assertEquals(textPrimaryCopyContainer.get(0).getText(), "Connect for Health Colorado (\u201Cel Mercado\u201D) y el Colorado Department of Health Care Policy and Financing protegerán la privacidad de su información como lo exige la ley. Sin embargo, si decidió solicitar asistencia, el Colorado Department of Health Care Policy and Financing puede utilizar o compartir información sobre su familia con otro(s) programa(s). La información solo puede utilizarse para efectos relacionados con la cobertura de seguro, el tratamiento, el pago, la determinación de elegibilidad y otras operaciones administrativas y del programa, u otros fines que la ley permita. Los programas de asistencia verificarán sus respuestas con la información disponible en nuestras bases de datos electrónicas y en las bases de datos de agencias asociadas. Si la información no coincide, podríamos pedirle comprobantes.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(1).getText(), "Seguro de salud pública gratuito o de bajo costo de Health First Colorado (programa de Medicaid de Colorado) o el programa Child Health Plan Plus (CHP+) administrado por Colorado Department of Health Care Policy and Financing.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(2).getText(), "Se le pedirá proporcionar solamente la información mínima necesaria para determinar su elegibilidad para la asistencia y las opciones de plan de salud pertinentes, según corresponda. Como parte del proceso, nos comunicaremos con usted o con su representante autorizado, y luego proporcionaremos la información al plan de salud que elija para que puedan inscribir a las personas elegibles en un plan de salud calificado o en un programa de accesibilidad al seguro.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(3).getText(), "El Mercado compartirá información demográfica sobre raza y origen étncio con las compañías de seguros de salud, con el único fin de determinar su elegibilidad para beneficios que son aplicables a ciertos grupos étncios.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(4).getText(), "Las compañías de seguros de salud ya no pueden negar la cobertura sobre la base de su estado de salud. Si solicita asistencia, es posible que le hagamos preguntas de evaluación sobre su historial médico que nos ayudarán a determinar para quá programas de asistencia será elegible. Esta información no se utiliza para determinar las tarifas de su seguro. A los integrantes de la familia que no deseen seguro no se les harán preguntas sobre la ciudadanía o el estatus migratorio.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(5).getText(), "Importante: El Mercado y el Colorado Department of Health Care Policy and están autorizados para reunir información sobre la solicitud, incluidos los números de Seguro Social, y confirmarán la información que pueda afectar la elegibilidad inicial o en curso de todas las personas incluidas en su solicitud. Por este medio permite que el Mercado y el Colorado Department of Health Care Policy and Financing utilicen los números de Seguro Social y otra información de su solicitud para pedir y recibir información o registros que confirmen la información de su solicitud; si solicita otros programas de asistencia pública, también podrá utilizar esta información el Departamento de Servicios Humanos. Usted exonera al Mercado y al Colorado Department of Health Care Policy and Financing de toda responsabilidad por compartir esta información con otras agencias con este fin. Por ejemplo, el Mercado y el Colorado Department of Health Care Policy and Financing pueden recibir información sobre usted a cualquiera de las siguientes agencias y también compartirla con ellas: Administración del Seguro Social; Servicio de Impuestos Internos; Servicio de Inmigración y Control de Aduanas de Estados Unidos; Departamento de Seguridad Nacional; Centros de Servicios de Medicare y Medicaid; Departamento de Trabajo y Empleo de Colorado; instituciones financieras (bancos, ahorros y prástamos, uniones de crádito, compañías de seguros, etc.); agencias de cumplimiento de la manutención infantil; empleadores; tribunales; y otras agencias federales o estatales. Necesitamos esta información para verificar su elegibilidad para el seguro de salud o la ayuda para pagarlo si decide presentar su solicitud, y brindarle el mejor servicio posible.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(6).getText(), "El Mercado y el Colorado Department of Health Care Policy and Financing también utilizarán la información que proporcione como parte de la operación continua de ambas agencias, lo que incluye actividades como la provisión de informes y la administración de programas de accesibilidad al seguro para las personas elegibles, actividades de supervisión y control de calidad, combate al fraude y respuesta ante cualquier inquietud de seguridad o de confidencialidad de la información. Utilizaremos la información que proporcione solamente para fines internos de nuestro negocio, y no la vendemos ni negociamos.");
        softAssert.assertEquals(textPrimaryCopyContainer.get(7).getText(), "Tiene derecho a mirar cierta información que tengamos sobre usted. También puede tener derecho a hacer que esa información se corrija si tenemos algún dato incorrecto en el archivo.");
        softAssert.assertEquals(textVoterRegistrationContainer.get(0).getText(), "¿Necesita registrarse para votar con su domicilio actual? Haga clic aquí si desea más información sobre cómo registrarse.");
        softAssert.assertEquals(textVoterRegistrationContainer.get(1).getText(), "Registrarse para votar no afectará la cantidad de ayuda para la que sea elegible.");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(0).getText(),"Si no está de acuerdo con la determinación sobre la elegibilidad de su familia, puede presentar una apelación. Debe solicitar una apelación de sus resultados de elegibilidad en los 60 días posteriores a la determinación. Para ello, puede solicitar una resolución informal, una audiencia formal o ambas. Puede ingresar en su cuenta de Connect for Health Colorado para ver un resumen de la información que utilizamos para evaluar su elegibilidad.");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(1).getText(),"Puede solicitar una apelación en una de estas cuatro formas:");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(2).getText(),"Tiene derecho a la representación:");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(3).getText(),"Puede representarse usted mismo o ser representado por un abogado o por otra persona que usted elija, como un amigo o un familiar.");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(4).getText(),"La decisión sobre la apelación respecto a un miembro de la familia puede cambiar la elegibilidad de otros miembros.");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(5).getText(),"Audiencia agilizada:");
        softAssert.assertEquals(textNoticeOfAppealRightsContainer.get(6).getText(),"Si considera que esperar una audiencia puede poner en peligro su vida o su salud, tiene derecho a pedir una audiencia agilizada (más rápida). Para solicitar una audiencia agilizada, aplique el mismo proceso que para una apelación y audiencia regulares, pero indique que desea una \u201Caudiencia agilizada\u201D y explique por qué debe ser agilizada.");
        softAssert.assertEquals(textRequestAnAppeal.get(0).getText(),"Llame al 1-855-PLANS-4-YOU (855-752-6749) o al TTY: 855-346-3432");
        softAssert.assertEquals(textRequestAnAppeal.get(1).getText(),"Visite es.ConnectforHealthCO.com y vaya a \u201CRecursos\u201D, para descargar un formulario de Solicitud de apelación.  Puede llenar su Solicitud de apelación y subirla a su cuenta de Connect for Health Colorado en \u201CMis documentos\u201D.");
        softAssert.assertEquals(textRequestAnAppeal.get(2).getText(),"Lleve o envíe por correo su Solicitud de apelación a:");
        softAssert.assertEquals(textRequestAnAppeal.get(3).getText(),"Envíe por fax su formulario de Solicitud de apelación al 303-322-4217.");
        softAssert.assertEquals(textAppealMailAddressList.getText(), """
                        Office of Conflict Resolution and Appeals
                        4600 South Ulster Street, Suite 300
                        Denver, CO 80237""");
        softAssert.assertEquals(textOtherInfoContainer.get(0).getText(),"Connect for Health Colorado no discrimina por motivos de raza, color de piel, origen étnico o nacional, ascendencia, edad, sexo, género, identidad y expresión de género, orientación sexual, estado civil, religión, credo, creencias políticas o discapacidad en ninguno de sus programas, servicios y actividades.");
        softAssert.assertEquals(textOtherInfoContainer.get(1).getText(),"Connect for Health Colorado puede brindar apoyos y servicios a personas con discapacidades, así como servicios de idioma a personas cuya lengua materna no sea el inglés, cuando así se requiera para lograr igualdad de oportunidades y acceso constructivo a programas, servicios y actividades. Algunos ejemplos de esos apoyos y servicios son, entre otros: intérpretes competentes de lenguaje de señas, información en otros formatos (incluida la impresión en letra grande), intérpretes de idiomas extranjeros y traducción de información a otras idiomas. Los apoyos y servicios pueden brindarse de manera oportuna y sin costo.");
        softAssert.assertEquals(textOtherInfoContainer.get(2).getText(),"Para solicitar ayuda o servicios gratuitos, comuníquese a Connect for Health Colorado llamando al 855-PLAN-4-YOU (855-752-6749) o TTY: 855-346-3432.");
        softAssert.assertEquals(textOtherInfoContainer.get(3).getText(),"Para presentar una denuncia de discriminación o para conocer mejor esta política, llame al 303-590-9640, envíe un fax al 303-322-4217 o escríbanos por correo postal a:");
        softAssert.assertEquals(textOtherInfoContainer.get(4).getText(),"También se puede presentar una queja de derechos civiles ante la Oficina de Derechos Civiles del Departamento de Salud y Servicios Humanos por vía electrónica a través del Portal para Quejas de la Oficina de Derechos Civiles en https://ocrportal.hhs.gov/ocr/cp/complaint_frontpage.jsf o por teléfono, por fax o por correo postal en:");
        softAssert.assertEquals(textOtherInfoContainer.get(5).getText(),"Los formularios de quejas están disponibles en http://www.hhs.gov/civil-rights/filing-a-complaint/index.html");
        softAssert.assertEquals(textOtherInfoContainer.get(6).getText(),"Yo puedo obtener información y servicios sobre violencia doméstica. Si en cualquier momento me siento que estoy en peligro inmediato, voy a llamar al 911. Si quiero recibir información sobre seguridad y servicios en Colorado voy a llamar a la Colorado Coalition Against Domestic Violence al 303-831-9632 o a la línea gratuita 1-888-778-7091. También puedo encontrar lugares de servicios cerca de mi hogar en el sitio web colorado.gov/cdhs/dvp. También la Línea Directa Nacional de Violencia Doméstica puede proveer información al 1-800-799-SAFE (7233) o TTY 1-800-787-3224 o ndvh.org. Si yo soy un sobreviviente de violencia doméstica, abuso sexual, o amenazas, el Programa de Dirección Confidencial (ACP – Address Confidentiality Program) me puede dar una dirección sustituta legal para mi uso con el gobierno estatal y local en lugar de mi dirección real. Puedo encontrar más información sobre ACP en acp.colorado.gov. Si necesito o recibir cualquiera de estos servicios, debo decirle a mi departamento trabajador o Connect for Health Colorado Representante porque le va a permitir ofrecer un mejor servicio y ayuda para mí.");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(0).getText(),"Connect for Health Colorado");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(1).getText(),"General Counsel");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(2).getText(),"4600 South Ulster Street, Suite 300");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(3).getText(),"Denver, CO 80237");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(4).getText(),"Telephone: 800-368-1019");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(5).getText(),"Fax: 202-619-3818");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(6).getText(),"TDD: 800-537-7697");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(7).getText(),"1961 Stout Street Room 08-148");
        softAssert.assertEquals(textFileDiscriminationAndCivilRightsComplaintDetails.get(8).getText(),"Denver, CO 80294");
        softAssert.assertEquals(textDataProtectionContainer.get(0).getText(),"Connect for Health Colorado y el Colorado Department of Health Care Policy and Financing han establecido protecciones importantes para garantizar la privacidad de su información personal.");
        softAssert.assertEquals(textDataProtectionContainer.get(1).getText(),"Si desea revisar la política completa de privacidad de Connect for Health Colorado, visite:");
        softAssert.assertEquals(textDataProtectionContainer.get(2).getText(),"http://connectforhealthco.com/site-information/privacy-policy/");
        softAssert.assertEquals(textDataProtectionContainer.get(3).getText(),"Si desea revisar la política completa de privacidad del Colorado Department of Health Care Policy and Financing, visite:");
        softAssert.assertEquals(textDataProtectionContainer.get(4).getText(),"https://www.colorado.gov/pacific/hcpf/health-insurance-portability-and-accountability-act-hipaa-0");
        softAssert.assertEquals(textIncomeCheckContainer.get(0).getText(),"A fin de facilitar la determinación de mi elegibilidad para obtener ayuda para pagar el seguro de salud en el futuro, autorizo que Connect for Health Colorado consulte fuentes informáticas, como el Servicio de Impuestos Internos (IRS), para verificar mis ingresos. Connect for Health Colorado verificará que sigo siendo elegible y puede pedirme que proporcione comprobantes de mis ingresos para confirmar que aún califico. Puedo revocar esta autorización en cualquier momento. Entiendo que si decido no permitir que Connect for Health Colorado consulte fuentes informáticas, deberá presentar una solicitud de renovación cada 12 meses para continuar con mi seguro de salud.");
        softAssert.assertEquals(textIncomeCheckContainer.get(1).getText(),"Permitir que Connect for Health Colorado verifique mi elegibilidad para:");
        softAssert.assertEquals(textLabelCheckBox.get(0).getText(),"Años");
        softAssert.assertEquals(textLabelCheckBox.get(1).getText(),"Años");
        softAssert.assertEquals(textLabelCheckBox.get(2).getText(),"Años");
        softAssert.assertEquals(textLabelCheckBox.get(3).getText(),"Años");
        softAssert.assertEquals(textLabelCheckBox.get(4).getText(),"Año");
        softAssert.assertEquals(textLabelCheckBox.get(5).getText(),"Deseo que Connect for Health Colorado no revise mis declaraciones de impuestos al momento de la renovación.");
        softAssert.assertEquals(textLabelCheckBoxP.get(0).getText(),"Firmo esta solicitud bajo pena de falso testimonio, lo que significa que he proporcionado respuestas verdaderas a todas las preguntas conforme a mi leal saber y entender. Sé que puedo verme sujeto a sanciones según las leyes federales si intencionalmente proporciono información falsa o engañosa.");
        softAssert.assertEquals(textLabelCheckBoxP.get(1).getText(),"Estoy consciente de que debo informar al programa en que estaré inscrito cualquier cambio relacionado con los datos de esta solicitud. Comprendo que un cambio en mi información podría afectar mi elegibilidad y la de los integrantes de mi familia.");
        softAssert.assertEquals(textLabelCheckBoxP.get(2).getText(),"Comprendo que una firma electrónica tiene el mismo efecto legal y puede hacerse cumplir de la misma manera que una firma escrita. Entiendo también que estoy firmando esta solicitud a nombre de todos los miembros de mi familia relacionados.");
        softAssert.assertTrue(textLabelCheckBoxP.get(3).getText().contains("Fecha de envío:"));
        softAssert.assertTrue(textControlLabel.get(0).getText().contains("PrimaryMember"));
        softAssert.assertEquals(textControlLabel.get(1).getText(),"Firma electrónica de:");
        softAssert.assertEquals(buttonBackDeclarationAndSignature.getAttribute("value"),"< Atrás");
        softAssert.assertEquals(buttonContinueDeclarationAndSignature.getAttribute("value"),"Continuar");
        softAssert.assertAll();
    }
    public void clickBackButton(){
        basicActions.waitForElementToBeClickable(buttonBackDeclarationAndSignature, 20);
        buttonBackDeclarationAndSignature.click();
    }
}
