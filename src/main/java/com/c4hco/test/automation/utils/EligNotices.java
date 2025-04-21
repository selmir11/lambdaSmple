package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;


public class EligNotices {
    private BasicActions basicActions;
    public EligNotices(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    private static String getCurrentTimestamp(String language, BasicActions basicActions) {
        String todayDate = basicActions.getTodayDate();
        switch (language.toLowerCase()) {
            case "spanish":
                Locale spanishLocale = new Locale("es", "ES");
                return basicActions.changeDateFormat(todayDate, "MM/dd/yyyy", "d 'de' MMMM 'del' yyyy", spanishLocale);
            case "english":
                return basicActions.changeDateFormat(todayDate, "MM/dd/yyyy", "MMMM d, yyyy", Locale.ENGLISH);
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private static String getLceCloseDate(String language, String docType, BasicActions basicActions) {
        String futureDate = basicActions.getFutureDate(60);
        if (docType.equals("ANAI")) {
            futureDate = basicActions.getFutureDate(90);
        }
        switch (language.toLowerCase()) {
            case "spanish": {
                Locale spanishLocale = new Locale("es", "ES");
                return basicActions.changeDateFormat(futureDate, "MM/dd/yyyy", "d 'de' MMMM 'del' yyyy", spanishLocale);
            }
            case "english": {
                return basicActions.changeDateFormat(futureDate, "MM/dd/yyyy", "MMMM d, yyyy", Locale.ENGLISH);
            }
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private static String getFirstOfNextMonth(String language, BasicActions basicActions) {
        String futureDate = basicActions.firstDateOfNextMonth();
        switch (language.toLowerCase()) {
            case "spanish": {
                Locale spanishLocale = new Locale("es", "ES");
                return basicActions.changeDateFormat(futureDate, "yyyy-MM-dd", "d 'de' MMMM 'del' yyyy", spanishLocale);
            }
            case "english": {
                return basicActions.changeDateFormat(futureDate, "yyyy-MM-dd", "MMMM d, yyyy", Locale.ENGLISH);
            }
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    public static String getMailApplicationResults(String docType, String language, String memberNumber, BasicActions basicActions) {
        String timestamp = getCurrentTimestamp(language, basicActions);
        String pageTotal = "0";

        switch (docType) {
            case "Ineligible: Did Not Apply" -> {
                pageTotal = "7";
            }
            case "Ineligible: Not CO Resident" -> {
                pageTotal = "7";
            }
            case "Health First Colorado" -> {
                pageTotal = "8";
            }
            case "ANAI" -> {
                pageTotal = "10";
            }
            default -> throw new IllegalArgumentException("Invalid docType:" + docType);
        }


        return String.format("Page  of 1 "+pageTotal+" Questions? Call 855-752-6749\n" +
                "Connect for Health Colorado\n" +
                "4600 South Ulster Street Suite 300\n" +
                "Denver CO 80237\n" +
                SharedData.getPrimaryMember().getFullName()+"\n" +
                SharedData.getPrimaryMember().getMailingAddress().getAddressLine1()+"\n" +
                SharedData.getPrimaryMember().getMailingAddress().getAddressCity()+
                " "+SharedData.getPrimaryMember().getMailingAddress().getAddressState()+
                " "+SharedData.getPrimaryMember().getMailingAddress().getAddressZipcode()+"\n" +
                "NOTICEELG10101\n" +
                "ELG-101-01\n" +
                "Account Number: "+SharedData.getPrimaryMember().getAccount_id()+"\n" +
                timestamp+" at \n");
    }

    public static String getApplicationResults(String docType, String language, String memberNumber, BasicActions basicActions) {
        String timestamp = getCurrentTimestamp(language, basicActions);

        return String.format("ELG-101-01\n" +
            SharedData.getPrimaryMember().getEmailId()+"\n" +
            "Account Number: "+SharedData.getPrimaryMember().getAccount_id()+"\n" +
            timestamp+" at \n" +
            introParagraph(docType, language, basicActions) +
            resultsType(docType, language, memberNumber, basicActions) +
            "Reporting changes about your household:\n" +
            "If you have changes in your household after you enroll in a plan through Connect for Health Colorado, you should report \n" +
            "them to us within 30 days. Some changes, called \u201CQualified Life Change Events,\u201D may allow your household to shop for \n" +
            "a new plan through a Special Enrollment Period. If you choose to enroll in a new plan through a Special Enrollment \n" +
            "Period, you\u2019ll need to enroll within 60 days of your Qualified Life Change Event. Learn more about Qualified Life Change \n" +
            "Events by visiting ConnectforHealthCO.com/resources/before-you-buy/when-can-i-buy/.\n" +
            reportToPeak(docType, language)+
            "If you do not report changes about your household, you may have to pay back some or all of your Premium Tax Credit \n" +
            "to the IRS when you file your federal income tax return.\n" +
            additionalInformation(docType, language)+
            "Disagree with your determination:\n" +
            "If you disagree with your household's eligibility determination, you may file an appeal. You must request an appeal \n" +
            ". You can do this by requesting an informal of the results on this notice within 60 days from the date of this notice\n" +
            "resolution, a formal hearing or both. You may log into your Connect for Health Colorado\u00AE account to see a summary \n" +
            "of the information we used for your eligibility determination.\n" +
            "You can request an appeal in one of these four ways\n" +
            "1. Please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-695-5935) \n" +
            "Monday - Friday 8:00a.m. - 6:00p.m.\n" +
            "2. Visit  and go to \"Resources\" to download an Appeal Request form. You can upload the ConnectforHealthCO.com\n" +
            "completed Appeal Request form to your Connect for Health Colorado\u00AE account in \"My Documents.\"\n" +
            "3. Mail or bring your Appeal Request form to:\n" +
            "Office of Appeals\n" +
            "4600 South Ulster Street\n" +
            "Suite 300 \n" +
            "Denver CO 80237\n" +
            "4. Fax your Appeal Request Form to 303-322-4217.\n" +
            "You have the right to representation:\n" +
            "You can represent yourself, be represented by a lawyer, or be represented by another person of your choice, such as \n" +
            "a friend or family member.\n" +
            "An appeal decision for one household member may change eligibility for other household members.\n" +
            "Expedited Hearing:\n" +
            "If you think waiting for a hearing might jeopardize your life or health, you have the right to ask for an expedited (faster) \n" +
            "hearing. To request an expedited hearing, use the same process for a regular appeal and hearing, but say that you \n" +
            "want an  and explain why it should be expedited.\"expedited hearing\"\n" +
            "Other information:\n" +
            "The determinations or assessments in this letter were made based upon 45 CFR 155.335 and 45 CFR 155.305.\n" +
            "Connect for Health Colorado\u00AE does not discriminate on the basis of race, color, ethnic or national origin, \n" +
            "ancestry, age, sex, gender, gender identity and expression, sexual orientation, marital status, religion, creed, \n" +
            "political beliefs, or disability in any of its programs, services and activities.\n" +
            "Connect for Health Colorado\u00AE can provide aids and services to individuals with disabilities, and language \n" +
            "services to individuals whose first language is not English, when needed to ensure equal opportunity and \n" +
            "meaningful access to programs, services and activities. Examples of aids and services include, but are not limited \n" +
            "to, qualified sign language interpreters, information in other formats (including large print), foreign language \n" +
            "interpreters, and information translated into other languages. Aids and services can be provided in a timely \n" +
            "manner and free of charge.\n" +
            "To request free aids or services, please call the Connect for Health Colorado\u00AE Customer Service Center at 855-\n" +
            "752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m.\n" +
            "To file a discrimination complaint or learn more about this policy, please call 303-590-9640, fax us at 303-322-4217, or \n" +
            "contact us by mail at:\n" +
            "Connect for Health Colorado\n" +
            "General Counsel\n" +
            "4600 South Ulster Street\n" +
            "Suite 300 \n" +
            "Denver CO 80237\n" +
            "Civil rights complaints can also be filed with the U.S. Department of Health and Human Services Office for Civil Rights \n" +
            "electronically through the Office for Civil Rights Complaint Portal available at https://ocrportal.hhs.gov/ocr/cp\n" +
            " or by phone, fax or mail at:/complaint_frontpage.jsf\n" +
            "Telephone: 800-368-1019\n" +
            "Fax: 202-619-3818\n" +
            "TDD: 800-537-7697\n" +
            "1961 Stout Street Room 08-148\n" +
            "Suite 5000 \n" +
            "Denver CO 80294\n" +
            "Complaint forms are available at http://www.hhs.gov/civil-rights/filing-a-complaint/index.html\n" +
            "Sincerely,\n" +
            "Connect for Health Colorado\u00AE\n" +
            "You can get this letter in Spanish or in a large print copy or another way that's best for you. Call 855-752-6749 (TTY: \n" +
            "855-695-5935). Puede recibir esta carta en espa\u00F1ol o en copia impresa con letra grande o de cualquier otra manera que \n" +
            "le resulte conveniente. Llame al 855-752-6749 (TTY: 855-695-5935).\n" +
            "is Colorado\u2019s official health insurance marketplace. Our mission is to increase access, Connect for Health Colorado\u00AE \n" +
            "affordability and choice for individuals, families and small employers. Learn more at www.ConnectforHealthCO.com.\n" +
            " CONFIDENTIALITY NOTICE: This message and its contents are confidential and are intended only for the recipient(s). \n" +
            "If you are not an intended recipient and have received this message in error, you may not use, copy, reproduce or \n" +
            "further distribute the message. Please inform the sender and delete the message. Thank you.\n" +
            ": Protecting your privacy is very important to us. You can view our Privacy Policy at: Privacy Notice\n" +
            "https://connectforhealthco.com/privacy-policy/.\n" +
            " Additional Language Assistance\n" +
            " Additional Language Assistance");
    }

    public static String introParagraph(String docType, String language, BasicActions basicActions) {
        String timestamp = getCurrentTimestamp(language, basicActions);
        String lceCloseDate = getLceCloseDate(language, docType, basicActions);
        String inelig = "did not open a Special Enrollment Period";
        String ineligES = "familiar no permite un Per\u00EDodo de inscripci\u00F3n especial";

        if (docType.equals("Ineligible: Did Not Apply") || docType.equals("Ineligible: Not CO Resident")) {
            switch (language) {
                case "English" -> {
                    return String.format("Dear "+SharedData.getPrimaryMember().getFullName()+",\n" +
                            "We received new or updated information about your household on "+timestamp+". The change to your household\u2019s \n" +
                            "information for your household to enroll in a new health insurance plan. If "+inelig+"\n" +
                            "you disagree with this determination, including the ability to enroll in a new plan, you can appeal this decision following\n" +
                            "the steps in the Disagree with your determination section below.\n");
                }
                case "Spanish" -> {
                    return String.format("Recibimos informaci\u00F3n nueva o actualizada sobre su familia el "+getCurrentTimestamp(language, basicActions)+". El cambio a su informaci\u00F3n\n" +
                    "para que su familia se inscriba en un nuevo plan de seguro "+ineligES+"\n" +
                    "de salud. Si no est\u00E1 de acuerdo con tal determinaci\u00F3n, incluida la posibilidad de inscribirse en un nuevo plan, puede\n" +
                    "apelar contra esta decisi\u00F3n siguiendo los pasos que se indican en la secci\u00F3n siguiente No est\u00E1 de acuerdo con la\n" +
                    "determinaci\u00F3n.\n");
                }
                default -> throw new IllegalArgumentException("Invalid language: " + language);
            }
        } else if (docType.equals("ANAI")) {
            switch (language) {
                case "English" -> {
                    return String.format("Dear "+SharedData.getPrimaryMember().getFullName()+",\n" +
                    "We received new or updated information about your household on "+timestamp+". The change to your household\u2019 \n" +
                    "s information is considered a Qualified Life Change Event, which means you can enroll in a health insurance plan or\n" +
                    "make changes to your current plan through a Special Enrollment Period.\n" +
                    "You can enroll in a new plan or make changes to your current plan by December 31, 2024.\n");
                }
                case "Spanish" -> {
                    return String.format("Recibimos informaci\u00F3n nueva o actualizada sobre su familia el "+getCurrentTimestamp(language, basicActions)+". El cambio en la informaci\u00F3n de su\n" +
                            "familia se considera un Evento de vida calificado, lo que significa que usted puede inscribirse en un nuevo plan de\n" +
                            "seguro de salud o hacer cambios a su plan actual a trav\u00E9s de un Per\u00EDodo de inscripci\u00F3n especial.\n" +
                            "Puede inscribirse en un nuevo plan o hacer cambios en su plan actual antes del 31 de diciembre del 2024.\n");
                }
                default -> throw new IllegalArgumentException("Invalid language: " +language);
            }
        } else {
            switch (language) {
                case "English" -> {
                    return String.format("Dear "+SharedData.getPrimaryMember().getFullName()+",\n" +
                            "We received new or updated information about your household on "+timestamp+". The change to your household\u2019s \n" +
                            "information is considered a Qualified Life Change Event, which means you can enroll in a health insurance plan or make\n" +
                            "changes to your current plan through a Special Enrollment Period.\n" +
                            "You can enroll in a new plan or make changes to your current plan by "+lceCloseDate+".\n");
                }
                case "Spanish" -> {
                    return String.format("Recibimos informaci\u00F3n nueva o actualizada sobre su familia el "+timestamp+". El cambio en la informaci\u00F3n de su\n" +
                    "familia se considera un Evento de vida calificado, lo que significa que usted puede inscribirse en un nuevo plan de\n" +
                    "seguro de salud o hacer cambios a su plan actual a trav\u00E9s de un Per\u00EDodo de inscripci\u00F3n especial.\n" +
                    "Puede inscribirse en un nuevo plan o hacer cambios en su plan actual antes del "+lceCloseDate+".\n");
                }
                default -> throw new IllegalArgumentException("Invalid language: " + language);
            }
        }
    }
    
    public static String resultsType(String docType, String language, String memberNumber, BasicActions basicActions){
        return switch (docType) {
            case "Health First Colorado" -> healthFirstColorado(docType, language, memberNumber, basicActions);
            case "CHP" -> chpPlus(docType, language, memberNumber, basicActions);
            case "Cobra" -> cobra(docType, language, memberNumber, basicActions);
            case "Individual Insurance" -> individualInsurance(docType, language, memberNumber, basicActions);
            case "Ineligible: Did Not Apply" -> ineligDidNotApply(language, memberNumber, basicActions);
            case "Ineligible: Not CO Resident" -> ineligNotCORes(language, memberNumber, basicActions);
            case "ANAI" -> ANAIGain(docType, language, memberNumber, basicActions);
            case "QHP" -> QHP(docType, language, memberNumber, basicActions);
            case "Eligibile: APTC" -> premiumTaxCredits(docType, language, memberNumber, basicActions);
            case "No Cost Sharing Reduction" -> noCostSharingReduction(docType, language, memberNumber, basicActions);
            default -> throw new IllegalArgumentException("Invalid option: " + docType);
        };
    }

    public static String infoNeeded(String docType, String language, String memberNumber, BasicActions basicActions) {

        List<MemberDetails> memberList = SharedData.getMembers();
        String member0Name = (memberList != null && !memberList.isEmpty()) ? SharedData.getMembers().get(0).getFullName().replace(".",".\n") : "";

        return switch (memberNumber) {
            case "1" -> switch (language) {
                case "English" -> String.format(
                        "Who needs to provide\n" +
                                "information?\n" +
                                "What information is needed? When is the information due?\n" +
                                "%s Proof of your American Indian or\n" +
                                "Alaska Native status\n" +
                                getLceCloseDate(language, docType, basicActions)+"\n" +
                                "%s Proof of financial help eligibility\n" +
                                getLceCloseDate(language, docType, basicActions)+"\n",
                        SharedData.getPrimaryMember().getFullName(),
                        SharedData.getPrimaryMember().getFullName()
                );
                case "Spanish" -> String.format(
                        "\u00BFQui\u00E9n necesita proporcionar\n" +
                                "informaci\u00F3n?\n" +
                                "\u00BFQu\u00E9 informaci\u00F3n se necesita? \u00BFCu\u00E1ndo es la fecha l\u00EDmite para\n" +
                                "enviar la informaci\u00F3n?\n" +
                                "%s Comprobante de su estatus de\n" +
                                "ind\u00EDgena norteamericano o nativo de\n" +
                                "Alaska\n" +
                                getLceCloseDate(language, docType, basicActions)+"\n" +
                                "%s Comprobante de su elegibilidad para\n" +
                                "recibir ayuda financiera\n" +
                                getLceCloseDate(language, docType, basicActions)+"\n",
                        SharedData.getPrimaryMember().getFullName(),
                        SharedData.getPrimaryMember().getFullName()
                );
                default -> throw new IllegalArgumentException("Unexpected value: " + language);
            };
            case "2" -> switch (language) {
                case "English" -> String.format("Who needs to provide\n" +
                        "information?\n" +
                        "What information is needed? When is the information due?\n" +
                        "%s Proof of your American Indian or\n" +
                        "Alaska Native status\n" +
                        getLceCloseDate(language, docType, basicActions)+"\n" +
                        "%s Proof of financial help eligibility "+getLceCloseDate(language, docType, basicActions)+"\n" +
                        member0Name+"\n" +
                        "Proof of your American Indian or\n" +
                        "Alaska Native status\n" +
                        getLceCloseDate(language, docType, basicActions)+"\n" +
                        member0Name+"\n"+
                        "Proof of financial help eligibility "+getLceCloseDate(language, docType, basicActions)+"\n",
                        SharedData.getPrimaryMember().getFullName(),
                        SharedData.getPrimaryMember().getFullName());
                case "Spanish" -> String.format("Mensaje para el miembro 2 en espa\u00F1ol.");
                default -> throw new IllegalArgumentException("Unexpected value: " + language);
            };
            default -> throw new IllegalArgumentException("Unexpected value: " + memberNumber);
        };
    }

    public static String moreInformationNeeded(String docType, String language, String memberNumber, BasicActions basicActions) {

       switch (memberNumber) {
           case "1" -> {
               switch (language) {
                   case "English" -> {
                       return String.format("More information needed\n" +
                               "We\u2019re sorry, we were unable to verify everything you provided and need additional information. If you do not send the\n" +
                               "information by the due date listed below, you could lose your health insurance plan or the financial help you\u2019re getting to\n" +
                               "pay for your health insurance plan. Even if someone in your household is not applying through Connect for Health\n" +
                               "Colorado or may qualify for Health First Colorado or Child Health Plan Plus, we still need the information listed below.\n" +
                               "Please note you only have a few days to submit your documents by the due date!\n" +
                               infoNeeded(docType, language, memberNumber, basicActions) +
                               "Potential reasons we were unable to verify your eligibility for financial help:\n" +
                               "Advance payments of the premium tax credit were made to your health insurance company in a previous\n" +
                               "year to reduce your premium costs, and we cannot verify whether a federal income tax return was filed\n" +
                               "to reconcile the payments you received.\n" +
                               "You chose not to allow us to check income data, including information from tax returns, to determine\n" +
                               "your eligibility for financial help when you completed an application.\n" +
                               "We were unable to confirm the information you provided about household income against trusted data\n" +
                               "sources.\n" +
                               "If you would like to allow the Marketplace to use information from your tax returns for future applications and\n" +
                               "determinations of financial help, update your application to agree to have us check income data from federal sources.\n" +
                               "What are acceptable documents for verifying your eligibility for financial help?\n" +
                               "Provide at least one document from List A and one document from List B.\n" +
                               "List A:\n" +
                               "Pay stub/check\n" +
                               "Employer statement\n" +
                               "Self-employment ledger\n" +
                               "Last year's tax document\n" +
                               "Social Security income statement\n" +
                               "Retirement income statement\n" +
                               "Unemployment amount letter\n" +
                               "Investment income statement\n" +
                               "Other official income document\n" +
                               "For a complete list of acceptable documents, visit https://ConnectforHealthCo.com/find-answers/after-\n" +
                               "you-buy/submit-documents/\n" +
                               "Provide income documents that add up to the total household income that you listed on the application. The document\n" +
                               "(s) must include:\n" +
                               "Who is making each form of income;\n" +
                               "The source of each form of income;\n" +
                               "The specific amount for each source of income;\n" +
                               "The frequency of the income (weekly, monthly, annually) for each source of income.\n" +
                               "Potential updates to your financial help\n" +
                               "When we receive your documents, we will use the amount and frequency for each income source to calculate an\n" +
                               "annual total. We will then update the household annual income amount listed in your application with the new annual\n" +
                               "total. After, we will submit a new application to determine the financial help programs you could qualify for and amount\n" +
                               "of financial help (if any).\n" +
                               "List B:\n" +
                               "A copy of the Form 8962 you submitted with the federal income tax return you most recently filed.\n" +
                               "Visit  for directions on responding to this request if:http://connectforhealthco.com/acceptable-documents/\n" +
                               "You have not yet filed a tax return because you have an extension;\n" +
                               "You have not received Advance Payments of the Premium Tax Credits to lower your\n" +
                               "monthly payment in the past.\n" +
                               "Why you must reconcile tax credit\n" +
                               "The IRS requires you to file a federal income tax return using Form 8962, Premium Tax Credit (PTC), if you or\n" +
                               "someone in your household received any advance payments of the premium tax credit. Form 8962 determines how\n" +
                               "much tax credit you qualified for based on your actual income and household size as shown on your federal income\n" +
                               "tax return. If you don't file a tax return using Form 8962, your household will no longer qualify for Advance Payments\n" +
                               "of the Premium Tax Credit.\n" +
                               "What are acceptable documents for verifying American Indian or Alaska Native status?\n" +
                               "Tribal enrollment/membership document\n" +
                               "Bureau of Indian Affairs issued document\n" +
                               "Other official federally recognized tribal document\n" +
                               "For a complete list of acceptable documents, visit https://ConnectforHealthCo.com/find-answers/after-\n" +
                               "you-buy/submit-documents/\n" +
                               "Where do I send my documents?\n" +
                               "Please send a copy of your document(s) in one of the following ways. Do not send your original documents. Be\n" +
                               "sure to write your name and Connect for Health Colorado\u00AE account number on each page you send. Your\n" +
                               "account number can be found at the top of this letter.\n" +
                               "Upload a copy of your document to your Connect for Health Colorado\u00AE account.\n" +
                               "Fax a copy of your document to: 855-346-5175\n" +
                               "Mail a copy of your document to:\n" +
                               "Verifications\n" +
                               "Connect for Health Colorado\n" +
                               "4600 South Ulster Street Suite 300\n" +
                               "Denver CO 80237\n" +
                               "We will notify you once we review your document(s). If you have questions, believe you already provided the information\n" +
                               "listed above, or need more time to provide the requested information, please call the Connect for Health Colorado\u00AE\n" +
                               "Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m.\n");
                   }
                   case "Spanish" -> {
                       return String.format("Se requiere m\u00E1s informaci\u00F3n\n" +
                               "Lamentablemente, no pudimos confirmar todos los datos que proporcion\u00F3 y necesitamos m\u00E1s informaci\u00F3n. Si no env\u00EDa la\n" +
                               "informaci\u00F3n para la fecha l\u00EDmite abajo indicada, puede perder su plan de seguro de salud o la reducci\u00F3n de costos que\n" +
                               "obtiene para pagar su plan de seguro de salud. Necesitamos todas las verificaciones de la familia para tramitar la\n" +
                               "solicitud, aun cuando alguien de su familia no est\u00E9 solicitando seguro por medio de Connect for Health Colorado, o si\n" +
                               "califica para Health First Colorado o Child Health Plan Plus.\n" +
                               "\u00A1Tenga en cuenta que solo tiene pocos d\u00EDas para enviar sus documentos para la fecha l\u00EDmite!\n") +
                               infoNeeded(docType, language, memberNumber, basicActions) +
                               "Posibles motivos por lo que no pudimos verificar su elegibilidad para recibir ayuda financiera:\n" +
                               "Los pagos anticipados del cr\u00E9dito fiscal para la prima fueron pagados el a\u00F1o anterior a su compa\u00F1\u00EDa de\n" +
                               "seguros de salud para reducir los costos de su prima, y no podemos verificar si se present\u00F3 una\n" +
                               "declaraci\u00F3n de impuesto federal sobre los ingresos para conciliar los pagos que recibi\u00F3.\n" +
                               "Eligi\u00F3 no permitirnos revisar los datos de su ingreso, incluida la informaci\u00F3n de su declaraci\u00F3n de\n" +
                               "impuestos, para determinar su elegibilidad para recibir ayuda financiera cuando llen\u00F3 una solicitud.\n" +
                               "No pudimos confirmar la informaci\u00F3n proporcionada sobre su ingreso familiar con las fuentes de datos\n" +
                               "confiables.\n" +
                               "Si desea permitir al Mercado utilizar informaci\u00F3n sobre sus declaraciones de impuestos para futuras solicitudes y\n" +
                               "determinaciones sobre la ayuda financiera, actualice su solicitud para estar de acuerdo en que revisemos los datos\n" +
                               "de su ingreso con las fuentes federales.\n" +
                               "\u00BFQu\u00E9 documentos son aceptables para verificar su elegibilidad para recibir ayuda financiera?\n" +
                               "Proporcione por lo menos un documento de la lista A y un documento de la lista B.\n" +
                               "Lista A:\n" +
                               "Recibo de pago/cheque\n" +
                               "Declaraci\u00F3n del empleador\n" +
                               "Libro contable de trabajador independiente\n" +
                               "Documento de impuestos del a\u00F1o pasado\n" +
                               "Estado de cuenta del ingreso del seguro social\n" +
                               "Estado de cuenta de ingresos por jubilaci\u00F3n\n" +
                               "Carta de la cantidad por desempleo\n" +
                               "Estado de cuenta de ingresos por inversiones\n" +
                               "Otros documentos oficiales de ingresos\n" +
                               "Para obtener una lista completa de los documentos aceptables, visite https://connectforhealthco.com\n" +
                               "/es/encuentre-respuestas/despues-de-adquirir/enviar-documentos/\n" +
                               "Proporcione documentos sobre ingresos que sumen el ingreso familiar total que indic\u00F3 en la solicitud. Los\n" +
                               "documentos deben incluir:\n" +
                               "qui\u00E9n obtiene cada forma de ingresos;\n" +
                               "la fuente de cada forma de ingresos;\n" +
                               "la cantidad espec\u00EDfica de cada fuente de ingresos;\n" +
                               "frecuencia de los ingresos (semanal, mensual, anual) para cada fuente de ingresos.\n" +
                               "Posibles actualizaciones a su ayuda financiera\n" +
                               "Cuando recibamos sus documentos, utilizaremos la cantidad y frecuencia para cada fuente de ingresos para calcular\n" +
                               "un total anual. Luego actualizaremos la cantidad de su ingreso familiar anual indicada en su solicitud con el nuevo\n" +
                               "total anual. Despu\u00E9s, enviaremos una nueva solicitud para determinar los programas de ayuda financiera a los que\n" +
                               "podr\u00EDa calificar y la cantidad de ayuda financiera (si la hubiera).\n" +
                               "Lista B:\n" +
                               "Una copia del Formulario 8962 que envi\u00F3 con su m\u00E1s reciente declaraci\u00F3n del impuesto federal sobre\n" +
                               "los ingresos.\n" +
                               "Visite  https://connectforhealthco.com/es/encuentre-respuestas/despues-de-adquirir/enviar-documentos/\n" +
                               "para recibir instrucciones en c\u00F3mo responder a esta solicitud si usted:\n" +
                               "no ha presentado anteriormente su declaraci\u00F3n de impuestos porque tiene una extensi\u00F3n;\n" +
                               "no ha recibido anteriormente los pagos anticipados del cr\u00E9dito fiscal para la prima en el\n" +
                               "pasado.\n" +
                               "Por qu\u00E9 debe reconciliar su cr\u00E9dito fiscal\n" +
                               "El Servicio de Rentas Internas (IRS) le exige presentar su declaraci\u00F3n del impuesto federal sobre los ingresos\n" +
                               "utilizando el Formulario 8962 (Cr\u00E9dito fiscal para el pago de la prima) si usted o un miembro familiar recibi\u00F3 alg\u00FAn\n" +
                               "pago anticipado del cr\u00E9dito fiscal para el pago de la prima. El Formulario 8962 determina para cu\u00E1nto cr\u00E9dito fiscal\n" +
                               "calific\u00F3 basado en sus ingresos actuales y el tama\u00F1o de la familia como lo muestra su declaraci\u00F3n de impuesto\n" +
                               "federal sobre los ingresos. Si no presenta una declaraci\u00F3n de impuestos utilizando el Formulario 8962, su familia ya\n" +
                               "no calificar\u00E1 para el Pago anticipado del cr\u00E9dito fiscal para el pago de la prima.\n" +
                               "\u00BFQu\u00E9 documentos son aceptables para verificar el estatus de ind\u00EDgena norteamericano o nativo de Alaska?\n" +
                               "Documento de membres\u00EDa de inscripci\u00F3n tribal\n" +
                               "Documento emitido por la Oficina de Asuntos Ind\u00EDgenas\n" +
                               "Otro documento oficial tribal reconocido por las autoridades federales\n" +
                               "Para obtener una lista completa de los documentos aceptables, visite https://connectforhealthco.com\n" +
                               "/es/encuentre-respuestas/despues-de-adquirir/enviar-documentos/\n" +
                               "\u00BFA d\u00F3nde debo enviar mis documentos?\n" +
                               "Favor de enviar una copia de su(s) documento(s) por uno de los medios a continuaci\u00F3n. No env\u00EDe sus\n" +
                               "documentos originales. Aseg\u00FArese de escribir su nombre y su n\u00FAmero de cuenta de Connect for Health\n" +
                               "Colorado\u00AE en cada p\u00E1gina que env\u00EDe. Puede encontrar su n\u00FAmero de cuenta en la parte superior de esta carta.\n" +
                               "Suba una copia de su documento a su cuenta de Connect for Health Colorado\u00AE.\n" +
                               "Env\u00EDe por fax una copia de su documento a: 855-346-5175\n" +
                               "Env\u00EDe por correo una copia de su documento a:\n" +
                               "Verifications\n" +
                               "Connect for Health Colorado\n" +
                               "4600 South Ulster Street Suite 300\n" +
                               "Denver CO 80237\n" +
                               "Le notificaremos una vez que hayamos revisado su(s) documento(s). Si tiene alguna pregunta, si cree que ya\n" +
                               "proporcion\u00F3 la informaci\u00F3n anteriormente mencionada, o si necesita m\u00E1s tiempo para proporcionar la informaci\u00F3n\n" +
                               "requerida, llame al Centro de atenci\u00F3n al cliente de Connect for Health Colorado\u00AE al 855-752-6749 (TTY:855-695-5935)\n" +
                               "de lunes a viernes de 8:00 a.m. a 6:00 p.m.\n"
                               ;
                   }
                   default -> throw new IllegalArgumentException("Unexpected value: " + language);
               }
           }
           case "2" -> {
               switch (language) {
                   case "English" -> {
                       return String.format("More information needed\n" +
                               "We\u2019re sorry, we were unable to verify everything you provided and need additional information. If you do not send the\n" +
                               "information by the due date listed below, you could lose your health insurance plan or the financial help you\u2019re getting to\n" +
                               "pay for your health insurance plan. Even if someone in your household is not applying through Connect for Health\n" +
                               "Colorado or may qualify for Health First Colorado or Child Health Plan Plus, we still need the information listed below.\n" +
                               "Please note you only have a few days to submit your documents by the due date!\n" +
                               infoNeeded(docType, language, memberNumber, basicActions) +
                               "Potential reasons we were unable to verify your eligibility for financial help:\n" +
                               "Advance payments of the premium tax credit were made to your health insurance company in a previous\n" +
                               "year to reduce your premium costs, and we cannot verify whether a federal income tax return was filed\n" +
                               "to reconcile the payments you received.\n" +
                               "You chose not to allow us to check income data, including information from tax returns, to determine\n" +
                               "your eligibility for financial help when you completed an application.\n" +
                               "We were unable to confirm the information you provided about household income against trusted data\n" +
                               "sources.\n" +
                               "If you would like to allow the Marketplace to use information from your tax returns for future applications and\n" +
                               "determinations of financial help, update your application to agree to have us check income data from federal sources.\n" +
                               "What are acceptable documents for verifying your eligibility for financial help?\n" +
                               "Provide at least one document from List A and one document from List B.\n" +
                               "List A:\n" +
                               "Pay stub/check\n" +
                               "Employer statement\n" +
                               "Self-employment ledger\n" +
                               "Last year's tax document\n" +
                               "Social Security income statement\n" +
                               "Retirement income statement\n" +
                               "Unemployment amount letter\n" +
                               "Investment income statement\n" +
                               "Other official income document\n" +
                               "For a complete list of acceptable documents, visit https://ConnectforHealthCo.com/find-answers/after-\n" +
                               "you-buy/submit-documents/\n" +
                               "Provide income documents that add up to the total household income that you listed on the application. The document\n" +
                               "(s) must include:\n" +
                               "Who is making each form of income;\n" +
                               "The source of each form of income;\n" +
                               "The specific amount for each source of income;\n" +
                               "The frequency of the income (weekly, monthly, annually) for each source of income.\n" +
                               "Potential updates to your financial help\n" +
                               "When we receive your documents, we will use the amount and frequency for each income source to calculate an\n" +
                               "annual total. We will then update the household annual income amount listed in your application with the new annual\n" +
                               "total. After, we will submit a new application to determine the financial help programs you could qualify for and amount\n" +
                               "of financial help (if any).\n" +
                               "List B:\n" +
                               "A copy of the Form 8962 you submitted with the federal income tax return you most recently filed.\n" +
                               "Visit  for directions on responding to this request if:http://connectforhealthco.com/acceptable-documents/ \n" +
                               "You have not yet filed a tax return because you have an extension;\n" +
                               "You have not received Advance Payments of the Premium Tax Credits to lower your\n" +
                               "monthly payment in the past.\n" +
                               "Why you must reconcile tax credit\n" +
                               "The IRS requires you to file a federal income tax return using Form 8962, Premium Tax Credit (PTC), if you or\n" +
                               "someone in your household received any advance payments of the premium tax credit. Form 8962 determines how\n" +
                               "much tax credit you qualified for based on your actual income and household size as shown on your federal income\n" +
                               "tax return. If you don't file a tax return using Form 8962, your household will no longer qualify for Advance Payments\n" +
                               "of the Premium Tax Credit.\n" +
                               "What are acceptable documents for verifying American Indian or Alaska Native status?\n" +
                               "Tribal enrollment/membership document\n" +
                               "Bureau of Indian Affairs issued document\n" +
                               "Other official federally recognized tribal document\n" +
                               "For a complete list of acceptable documents, visit https://ConnectforHealthCo.com/find-answers/after-\n" +
                               "you-buy/submit-documents/\n" +
                               "Where do I send my documents?\n" +
                               "Please send a copy of your document(s) in one of the following ways. Do not send your original documents. Be\n" +
                               "sure to write your name and Connect for Health Colorado\u00AE account number on each page you send. Your\n" +
                               "account number can be found at the top of this letter.\n" +
                               "Upload a copy of your document to your Connect for Health Colorado\u00AE account.\n" +
                               "Fax a copy of your document to: 855-346-5175\n" +
                               "Mail a copy of your document to:\n" +
                               "Verifications\n" +
                               "Connect for Health Colorado\n" +
                               "4600 South Ulster Street Suite 300\n" +
                               "Denver CO 80237\n" +
                               "We will notify you once we review your document(s). If you have questions, believe you already provided the information\n" +
                               "listed above, or need more time to provide the requested information, please call the Connect for Health Colorado\u00AE\n" +
                               "Customer Service Center at 855-752-6749 (TTY:855-695-5935) Monday - Friday 8:00a.m. - 6:00p.m. and Dec 2nd - Dec 17th from 8:00a.m. to 8:00p.m.\n");
                   }
                   case "Spanish" -> {
                       return String.format("");
                   }
                   default -> throw new IllegalArgumentException("Unexpected value: " + language);
               }
           }
           default -> throw new IllegalArgumentException("Unexpected value: " + memberNumber);
       }
    }

    public static String QHP(String docType, String language, String memberNumber, BasicActions basicActions){
        String englishTemplate = ", starting as early as "+getFirstOfNextMonth(language, basicActions)+" you are approved for:"+SharedData.getPrimaryMember().getFullName()+"\n";
        String englishTemplate2 = "Enroll in a plan by "+getLceCloseDate(language, docType, basicActions)+".\n";
        String spanishTemplate = ", a partir del "+getFirstOfNextMonth(language, basicActions)+" usted est\u00E1 aprobado para:"+SharedData.getPrimaryMember().getFullName()+"\n";
        String spanishTemplate2 = "Inscr\u00EDbase en un plan antes del "+getLceCloseDate(language, docType, basicActions)+".\n";
        String atpc = "$295.29";
        String pct = "94";

        List<MemberDetails> memberList = SharedData.getMembers();
        String member0Name = (memberList != null && !memberList.isEmpty()) ? SharedData.getMembers().get(0).getFullName() : "";

        return switch (memberNumber) {
            case "1" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate +
                        "Premium\n" +
                        "Tax Credits\n" +
                        "for "+basicActions.getCurrYear()+"\n" +
                        "Your household qualifies to receive up to $295.29 a month to use towards\n" +
                        "lowering the cost of your monthly health insurance premiums when you\n" +
                        "enroll through Connect for Health Colorado. Based on your application,\n" +
                        "this applies to "+SharedData.getPrimaryMember().getFullName()+"\n" +
                        englishTemplate2 +
                        englishTemplate +
                        "Cost-Sharing\n" +
                        "Reduction for\n" +
                        basicActions.getCurrYear()+"\n"+
                        "You qualify for a reduction in your out-of-pocket costs, such as deductibles\n" +
                        "and copayments when you visit a doctor or fill a prescription. Your Cost-\n" +
                        "Sharing Reduction level is "+pct+". This is the average amount the health\n" +
                        "insurance company will pay over the course of a year.\n" +
                        "You must enroll in a Silver-level plan to receive these reductions in your outof-pocket costs.\n" +
                        englishTemplate2 +
                        "Health\n" +
                        "insurance\n" +
                        "plan for "+basicActions.getCurrYear()+"\n" +
                        "You can enroll in a health insurance plan for 2024 if you qualify for a Special Enrollment\n" +
                        "Period or if it\u2019s Open Enrollment.\n" +
                        englishTemplate2,
                        pct
                );
                case "Spanish" -> String.format(
                        spanishTemplate +
                        "Cr\u00E9ditos\n" +
                                "fiscales para\n" +
                                "el pago de la\n" +
                                "cuota para\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Su familia tiene derecho a recibir hasta $295.29 al mes para reducir el\n" +
                                "monto de las cuotas mensuales de su seguro de salud cuando se inscribe\n" +
                                "a trav\u00E9s de Connect for Health Colorado. De acuerdo con su solicitud,\n" +
                                "estos ahorros se aplican a: "+SharedData.getPrimaryMember().getFullName()+"\n" +
                                spanishTemplate2 +
                                spanishTemplate +
                                "Reducci\u00F3n\n" +
                                "de los costos\n" +
                                "compartidos\n" +
                                "para "+basicActions.getCurrYear()+"\n" +
                                "Usted califica para la reducci\u00F3n de sus costos de desembolso, como\n" +
                                "deducibles y copagos, cuando acuda al m\u00E9dico o surta una receta. Su nivel\n" +
                                "de reducci\u00F3n de los costos compartidos es de "+pct+". Es el importe promedio\n" +
                                "que la compa\u00F1\u00EDa de seguros m\u00E9dicos pagar\u00E1 en el transcurso de un a\u00F1o.\n" +
                                "Debe inscribirse en un plan de nivel Plata para recibir estas reducciones en\n" +
                                "sus costos de desembolso.\n" +
                                spanishTemplate2 +
                                spanishTemplate +
                                "Plan de\n" +
                                "seguro de\n" +
                                "salud para\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Puede inscribirse en un plan de seguro de salud para 2024 si califica para un per\u00EDodo\n" +
                                "de inscripci\u00F3n especial o si est\u00E1 activa la inscripci\u00F3n abierta.\n" +
                                spanishTemplate2
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            case "2" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate + englishTemplate2
                );
                case "Spanish" -> String.format(
                        spanishTemplate + spanishTemplate2
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            default -> throw new IllegalArgumentException("Invalid member number: " + memberNumber);
        };



    }

    public static String ANAIGain(String docType, String language, String memberNumber, BasicActions basicActions) {

        List<MemberDetails> memberList = SharedData.getMembers();
        String member0Name = (memberList != null && !memberList.isEmpty()) ? SharedData.getMembers().get(0).getFullName() : "";
        String englishTemplate = ", starting as early as "+getFirstOfNextMonth(language, basicActions)+" you are approved for:"+SharedData.getPrimaryMember().getFullName()+"\n";
        String englishTemplate2 = ", starting as early as "+getFirstOfNextMonth(language, basicActions)+" you are approved for:"+member0Name+"\n ";
        String englishTemplate3 = "Verification is\n"+"needed\n"+"We\u2019re missing some information!\n"+
                                    "You are temporarily approved for 90 days, but we need more information\n"+
                                    "from you to continue your coverage after the 90 days. Please see the\n"+
                                    "\u201cMore information needed\u201D section below for what is needed and next\n"+"steps.\n";
        String spanishTemplate = ", a partir del "+getFirstOfNextMonth(language, basicActions)+" usted est\u00E1 aprobado para:"+SharedData.getPrimaryMember().getFullName()+"\n";
        String spanishTemplate2 = "Se requiere\n" + "verificaci\u00F3n\n" + "Nos falta alguna informaci\u00F3n!\n" +
                                    "Ha sido aprobado provisionalmente por 90 d\u00EDas, pero necesitamos m\u00E1s\n" +
                                    "informaci\u00F3n para que su cobertura contin\u00FAe despu\u00E9s de esos 90 d\u00EDas. En\n" +
                                    "la secci\u00F3n \"Se requiere m\u00E1s informaci\u00F3n\" que aparece en seguida se\n" +
                                    "indica lo que se necesita y los pasos siguientes.\n";

        return switch (memberNumber) {
            case "1" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate +
                                "Premium Tax\n" +
                                "Credits for\n" +
                                basicActions.getCurrYear() + "\n" +
                                "Your household qualifies to receive up to $399.89 a month to use towards\n" +
                                "lowering the cost of your monthly health insurance premiums when you\n" +
                                "enroll through Connect for Health Colorado. Based on your application,\n" +
                                "this applies to "+SharedData.getPrimaryMember().getFullName()+"\n" +
                                "Enroll in a plan by December 31, 2024.\n" +
                                englishTemplate2 +
                                englishTemplate +
                                "Cost-Sharing\n" +
                                "Reduction for\n" +
                                basicActions.getCurrYear()+"\n" +
                                "You qualify for a Zero Cost-Sharing Reduction plan. This means you won\u2019t\n" +
                                "have to pay any out-of-pocket costs, such as deductibles and copayments\n" +
                                "when you visit a doctor or fill a prescription.\n" +
                                "You must enroll in a Silver-level plan to receive these reductions in your out-\n" +
                                "of-pocket costs.\n" +
                                "Enroll in a plan by December 31, 2024.\n" +
                                englishTemplate2 +
                                englishTemplate +
                                "Health\n" +
                                "insurance\n" +
                                "plan for "+basicActions.getCurrYear()+"\n" +
                                "You can enroll in a health insurance plan for 2024 if you qualify for a Special Enrollment\n" +
                                "Period or if it\u2019s Open Enrollment.\n" +
                                "Enroll in a plan by December 31, 2024.\n" +
                                englishTemplate2 +
                                moreInformationNeeded(docType, language, memberNumber, basicActions)
                );
                case "Spanish" -> String.format(
                        spanishTemplate +
                                "Cr\u00E9ditos\n" +
                                "fiscales para\n" +
                                "el pago de la\n" +
                                "cuota para\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Su familia tiene derecho a recibir hasta $399.89 al mes para reducir el\n" +
                                "monto de las cuotas mensuales de su seguro de salud cuando se inscribe\n" +
                                "a trav\u00E9s de Connect for Health Colorado. De acuerdo con su solicitud,\n" +
                                "estos ahorros se aplican a: "+SharedData.getPrimaryMember().getFullName()+"\n" +
                                "Inscr\u00EDbase en un plan antes del 31 de diciembre del 2024.\n" +
                                spanishTemplate2 +
                                spanishTemplate +
                                "Reducci\u00F3n\n" +
                                "de los costos\n" +
                                "compartidos\n" +
                                "para "+basicActions.getCurrYear()+"\n" +
                                "Usted califica para un plan de cero costos compartidos. Eso significa que no\n" +
                                "tendr\u00E1 que pagar costos de desembolso, como deducibles y copagos,\n" +
                                "cuando acuda al m\u00E9dico o surta una receta.\n" +
                                "Debe inscribirse en un plan de nivel Plata para recibir estas reducciones en\n" +
                                "sus costos de desembolso.\n" +
                                "Inscr\u00EDbase en un plan antes del 31 de diciembre del 2024.\n" +
                                spanishTemplate2 +
                                spanishTemplate +
                                "Plan de\n" +
                                "seguro de\n" +
                                "salud para\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Puede inscribirse en un plan de seguro de salud para 2024 si califica para un per\u00EDodo\n" +
                                "de inscripci\u00F3n especial o si est\u00E1 activa la inscripci\u00F3n abierta.\n" +
                                "Inscr\u00EDbase en un plan antes del 31 de diciembre del 2024.\n" +
                                spanishTemplate2 +
                                moreInformationNeeded(docType, language, memberNumber, basicActions)
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            case "2" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate +
                                "Premium Tax\n" +
                                "Credits for\n" +
                                basicActions.getCurrYear() + "\n" +
                                "Your household qualifies to receive up to $573.06 a month to use towards\n" +
                                "lowering the cost of your monthly health insurance premiums when you\n" +
                                "enroll through Connect for Health Colorado. Based on your application,\n" +
                                "this applies to "+SharedData.getPrimaryMember().getFullName()+"\n" +
                                "Enroll in a plan by December 31, 2024.\n" +
                                englishTemplate3 +
                                englishTemplate +
                                "Cost-Sharing\n" +
                                "Reduction for\n" +
                                basicActions.getCurrYear()+"\n" +
                                "You qualify for a Zero Cost-Sharing Reduction plan. This means you won\u2019t\n" +
                                "have to pay any out-of-pocket costs, such as deductibles and copayments\n" +
                                "when you visit a doctor or fill a prescription.\n" +
                                "You must enroll in a Silver-level plan to receive these reductions in your out-\n" +
                                "of-pocket costs.\n" +
                                "Enroll in a plan by December 31, 2024.\n" +
                                englishTemplate3 +
                                englishTemplate +
                                "Health\n" +
                                "insurance\n" +
                                "plan for "+basicActions.getCurrYear()+"\n" +
                                "You can enroll in a health insurance plan for 2024 if you qualify for a Special Enrollment\n" +
                                "Period or if it\u2019s Open Enrollment.\n" +
                                "Enroll in a plan by December 31, 2024.\n" +
                                englishTemplate3 +
                                englishTemplate2 +
                                "Premium Tax\n" +
                                "Credits for\n" +
                                basicActions.getCurrYear() + "\n" +
                                "Your household qualifies to receive up to $573.06 a month to use towards\n" +
                                "lowering the cost of your monthly health insurance premiums when you\n" +
                                "enroll through Connect for Health Colorado. Based on your application,\n" +
                                "this applies to "+member0Name+"\n" +
                                "Enroll in a plan by December 31, 2024.\n" +
                                englishTemplate3 +
                                englishTemplate2 +
                                "Cost-Sharing\n" +
                                "Reduction for\n" +
                                basicActions.getCurrYear()+"\n" +
                                "You qualify for a Zero Cost-Sharing Reduction plan. This means you won\u2019t\n" +
                                "have to pay any out-of-pocket costs, such as deductibles and copayments\n" +
                                "when you visit a doctor or fill a prescription.\n" +
                                "You must enroll in a Silver-level plan to receive these reductions in your out-\n" +
                                "of-pocket costs.\n" +
                                "Enroll in a plan by December 31, 2024.\n" +
                                englishTemplate3 +
                                englishTemplate2 +
                                "Health\n" +
                                "insurance\n" +
                                "plan for "+basicActions.getCurrYear()+"\n" +
                                "You can enroll in a health insurance plan for 2024 if you qualify for a Special Enrollment\n" +
                                "Period or if it\u2019s Open Enrollment.\n" +
                                "Enroll in a plan by December 31, 2024.\n" +
                                englishTemplate3 +
                                moreInformationNeeded(docType, language, memberNumber, basicActions)

                );
                case "Spanish" -> String.format(
                        spanishTemplate + spanishTemplate2
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            default -> throw new IllegalArgumentException("Invalid member number: " + memberNumber);
        };

    }

    public static String ineligNotCORes(String language, String memberNumber, BasicActions basicActions) {
        String englishTemplate = " , you do not qualify for the following:"+SharedData.getPrimaryMember().getFullName()+"\n";
        String englishTemplate2 = "You are not a Colorado resident\n";
        String spanishTemplate = " , no califica para lo siguiente:"+SharedData.getPrimaryMember().getFullName()+"\n";
        String spanishTemplate2 = "Usted no es residente de Colorado\n";

        List<MemberDetails> memberList = SharedData.getMembers();
        String member0Name = (memberList != null && !memberList.isEmpty()) ? SharedData.getMembers().get(0).getFullName() : "";

        return switch (memberNumber) {
            case "1" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate +
                        "Premium Tax\n" +
                        "Credits or\n" +
                        "Cost-Sharing\n" +
                        "Reduction for\n" +
                        basicActions.getCurrYear() + "\n" +
                        "You do not qualify for Premium Tax Credits or Cost-Sharing Reduction because: \n" +
                        englishTemplate2 +
                        englishTemplate +
                        "Health\n" +
                        "insurance\n" +
                        "plan for "+basicActions.getCurrYear()+"\n" +
                        "You do not qualify for a health insurance plan through Connect for Health Colorado\n" +
                        "because:\n" +
                        englishTemplate2
                );
                case "Spanish" -> String.format(
                        spanishTemplate +
                        "Cr\u00E9ditos\n" +
                        "fiscales para\n" +
                        "el pago de la\n" +
                        "cuota o\n" +
                        "reducci\u00F3n de\n" +
                        "los costos\n" +
                        "compartidos\n" +
                        "para "+basicActions.getCurrYear()+"\n"+
                        "No califica para obtener cr\u00E9ditos fiscales para el pago de la cuota ni reducci\u00F3n de los\n" +
                        "costos compartidos porque:\n" +
                        spanishTemplate2 +
                        spanishTemplate +
                        "Plan de\n" +
                        "seguro de\n" +
                        "salud para\n" +
                        basicActions.getCurrYear()+"\n"+
                        "No califica para adquirir un plan de seguro de salud a trav\u00E9s de Connect for Health\n" +
                        "Colorado porque:\n" +
                        spanishTemplate2
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            case "2" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate + englishTemplate2
                );
                case "Spanish" -> String.format(
                        spanishTemplate + spanishTemplate2
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            default -> throw new IllegalArgumentException("Invalid member number: " + memberNumber);
        };

    }

    public static String ineligDidNotApply(String language, String memberNumber, BasicActions basicActions) {
        String englishTemplate = ", you do not qualify for the following:"+SharedData.getPrimaryMember().getFullName()+"\n";
        String englishTemplate2 = "You did not apply for health insurance\n";
        String spanishTemplate = ", no califica para lo siguiente:"+SharedData.getPrimaryMember().getFullName()+"\n";
        String spanishTemplate2 = "Usted no solicit\u00F3 seguro de salud\n";

        List<MemberDetails> memberList = SharedData.getMembers();
        String member0Name = (memberList != null && !memberList.isEmpty()) ? SharedData.getMembers().get(0).getFullName() : "";

        return switch (memberNumber) {
            case "1" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate +
                        "Premium Tax\n" +
                        "Credits or\n" +
                        "Cost-Sharing\n" +
                        "Reduction for\n" +
                        basicActions.getCurrYear() + "\n" +
                        "You do not qualify for Premium Tax Credits or Cost-Sharing Reduction because: \n" +
                        englishTemplate2 +
                        englishTemplate +
                        "Health\n" +
                        "insurance\n" +
                        "plan for "+basicActions.getCurrYear()+"\n" +
                        "You do not qualify for a health insurance plan through Connect for Health Colorado\n" +
                        "because:\n" +
                        englishTemplate2
                );
                case "Spanish" -> String.format(
                        spanishTemplate +
                        "Cr\u00E9ditos\n" +
                        "fiscales para\n" +
                        "el pago de la\n" +
                        "cuota o\n" +
                        "reducci\u00F3n de\n" +
                        "los costos\n" +
                        "compartidos\n" +
                        "para "+basicActions.getCurrYear()+"\n" +
                        "No califica para obtener cr\u00E9ditos fiscales para el pago de la cuota ni reducci\u00F3n de los\n" +
                        "costos compartidos porque:\n"+
                        spanishTemplate2 +
                        spanishTemplate +
                        "Plan de\n" +
                        "seguro de\n" +
                        "salud para\n" +
                        basicActions.getCurrYear()+"\n" +
                        "No califica para adquirir un plan de seguro de salud a trav\u00E9s de Connect for Health\n" +
                        "Colorado porque:\n" +
                        spanishTemplate2
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            case "2" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate + englishTemplate2
                );
                case "Spanish" -> String.format(
                        spanishTemplate + spanishTemplate2
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            default -> throw new IllegalArgumentException("Invalid member number: " + memberNumber);
        };

    }

    public static String healthFirstColorado(String docType, String language, String memberNumber, BasicActions basicActions) {
        String firstOfNextMonth = getFirstOfNextMonth(language, basicActions);

        String englishTemplate = "%s, it looks like you may qualify for Health First Colorado (Colorado\u2019s Medicaid %s\n%s, starting as early as %s you are approved for:%s\n%s, you do not qualify for the following:%s\n%s";
        String englishTemplate2 = ", it looks like you may qualify for Health First Colorado (Colorado\u2019s Medicaid %s\n%s, starting as early as %s you are approved for:%s\n%s, you do not qualify for the following:%s\n%s";
        String spanishTemplate = "%s, por lo visto, podr\u00EDa calificar para Health First Colorado (el programa Medicaid de %s\n%s, a partir del %s usted est\u00E1 aprobado para:%s\n%s, no califica para lo siguiente:%s\n%s";
        String spanishTemplate2 = ", por lo visto, podr\u00EDa calificar para Health First Colorado (el programa %s\n%s, a partir del %s usted est\u00E1 aprobado para:%s\n%s, no califica para lo siguiente:%s\n%s";

        String primaryName = SharedData.getPrimaryMember().getFullName();
        List<MemberDetails> memberList = SharedData.getMembers();
        String member0Name = (memberList != null && !memberList.isEmpty()) ? SharedData.getMembers().get(0).getFullName() : "";

        return switch (memberNumber) {
            case "1" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate,
                        healthFirstChpData(language),
                        primaryName,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        primaryName,
                        healthPlanInfo(docType, language, basicActions),
                        primaryName,
                        taxCreditInfoMedicaid(language, basicActions)
                );
                case "Spanish" -> String.format(
                        spanishTemplate,
                        healthFirstChpData(language),
                        primaryName,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        primaryName,
                        healthPlanInfo(docType, language, basicActions),
                        primaryName,
                        taxCreditInfoMedicaid(language, basicActions)
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            case "2" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate + englishTemplate2,
                        healthFirstChpData(language),
                        primaryName,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        primaryName,
                        healthPlanInfo(docType, language, basicActions),
                        primaryName,
                        taxCreditInfoMedicaid(language, basicActions),
                        member0Name,
                        healthFirstInfoSecondary(language),
                        firstOfNextMonth,
                        member0Name,
                        healthPlanInfo(docType, language, basicActions),
                        member0Name,
                        taxCreditInfoMedicaidSecondary(language, basicActions)
                );
                case "Spanish" -> String.format(
                        spanishTemplate + spanishTemplate2,
                        healthFirstChpData(language),
                        primaryName,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        primaryName,
                        healthPlanInfo(docType, language, basicActions),
                        primaryName,
                        taxCreditInfoMedicaid(language, basicActions),
                        member0Name,
                        healthFirstInfoSecondary(language),
                        firstOfNextMonth,
                        member0Name,
                        healthPlanInfo(docType, language, basicActions),
                        member0Name,
                        taxCreditInfoMedicaidSecondary(language, basicActions)
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            default -> throw new IllegalArgumentException("Invalid member number: " + memberNumber);
        };
    }

    public static String healthFirstChpData (String language){
        return switch (language) {
            case "English"->
                    "This letter also includes information that members of your household may qualify for Health First Colorado (Colorado's \n" +
                    "Medicaid Program) or Child Health Plan Plus (CHP+). Members of your household who qualify for either of these \n" +
                    "programs will get a separate letter from the State of Colorado.\n";
            case "Spanish"->
                    "Esta carta informa tambi\u00E9n que uno o m\u00E1s miembros de su familia calificar\u00EDan para Health First Colorado (el programa\n" +
                    "Medicaid de Colorado) o para Child Health Plan Plus (CHP+). Los miembros de su familia que califiquen para alguno\n" +
                    "de estos programas recibir\u00E1n aparte una carta del Gobierno del estado de Colorado.\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String healthFirstInfo (String language){
        return switch (language) {
            case "English"->
                    "Program) or Child Health Plan Plus (CHP+).\n" +
                    "Information \n" +
                    "about Health \n" +
                    "First \n" +
                    "Colorado or \n" +
                    "CHP+\n" +
                    "You may qualify for Health First Colorado (Colorado\u2019s Medicaid program) \n" +
                    "or Child Health Plan Plus (CHP+). We have sent information from your \n" +
                    "application to the State of Colorado. They will officially determine if you \n" +
                    "qualify for Health First Colorado or CHP+ and send you a letter telling you \n" +
                    "if you qualify.\n" +
                    "If you have any questions about this, visit Health First Colorado \u2022 Connect \n" +
                    "for Health Colorado\n" +
                    "If you are not interested in Health First Colorado or CHP+ coverage, see \n" +
                    "the  section below.Additional information for your household\n";
            case "Spanish"->
                    "Colorado) o para Child Health Plan Plus (CHP+).\n" +
                    "Informaci\u00F3n\n" +
                    "acerca de\n" +
                    "Health First\n" +
                    "Colorado o\n" +
                    "CHP+\n" +
                    "Posiblemente califique para Health First Colorado (el programa Medicaid\n" +
                    "de Colorado) o para Child Health Plan Plus (CHP+). Hemos enviado\n" +
                    "informaci\u00F3n obtenida de su solicitud al Gobierno del estado de Colorado.\n" +
                    "Ellos determinar\u00E1n oficialmente si califica para Health First Colorado o\n" +
                    "para CHP+ y le enviar\u00E1n una carta para informarle su decisi\u00F3n.\n" +
                    "Si tiene alguna duda a este respecto, visite Health First Colorado \u2022\n" +
                    "Connect for Health Colorado\n" +
                    "Si no le interesa la cobertura de Health First Colorado ni de CHP+, revise\n" +
                    "a continuaci\u00F3n la secci\u00F3n Informaci\u00F3n adicional para su familia.\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String healthFirstInfoSecondary (String language){
        return switch (language) {
            case "English"->
                    "Program) or Child Health Plan Plus (CHP+).\n" +
                            "Information \n" +
                            "about Health \n" +
                            "First \n" +
                            "Colorado or \n" +
                            "CHP+\n" +
                            "You may qualify for Health First Colorado (Colorado\u2019s Medicaid program) \n" +
                            "or Child Health Plan Plus (CHP+). We have sent information from your \n" +
                            "application to the State of Colorado. They will officially determine if you \n" +
                            "qualify for Health First Colorado or CHP+ and send you a letter telling you \n" +
                            "if you qualify.\n" +
                            "If you have any questions about this, visit Health First Colorado \u2022 Connect \n" +
                            "for Health Colorado\n" +
                            "If you are not interested in Health First Colorado or CHP+ coverage, see \n" +
                            "the  section below.Additional information for your household\n";
            case "Spanish"->
                    "Medicaid de Colorado) o para Child Health Plan Plus (CHP+).\n" +
                            "Informaci\u00F3n\n" +
                            "acerca de\n" +
                            "Health First\n" +
                            "Colorado o\n" +
                            "CHP+\n" +
                            "Posiblemente califique para Health First Colorado (el programa Medicaid\n" +
                            "de Colorado) o para Child Health Plan Plus (CHP+). Hemos enviado\n" +
                            "informaci\u00F3n obtenida de su solicitud al Gobierno del estado de Colorado.\n" +
                            "Ellos determinar\u00E1n oficialmente si califica para Health First Colorado o\n" +
                            "para CHP+ y le enviar\u00E1n una carta para informarle su decisi\u00F3n.\n" +
                            "Si tiene alguna duda a este respecto, visite Health First Colorado \u2022\n" +
                            "Connect for Health Colorado\n" +
                            "Si no le interesa la cobertura de Health First Colorado ni de CHP+, revise\n" +
                            "a continuaci\u00F3n la secci\u00F3n Informaci\u00F3n adicional para su familia.\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String healthPlanInfo(String docType, String language, BasicActions basicActions){
        String lceCloseDate = getLceCloseDate(language, docType, basicActions);
        String currentYear = basicActions.getCurrYear();

        return switch (language) {
            case "English"->
                    "Health \n" +
                    "insurance \n" +
                    "plan for " + currentYear + "\n" +
                    "You can enroll in a health insurance plan for " + currentYear + " if you qualify for a Special Enrollment\n" +
                    "Period or if it\u2019s Open Enrollment.\n" +
                    "Enroll in a plan by " + lceCloseDate + ".\n";
            case "Spanish"->
                    "Plan de\n" +
                    "seguro de\n" +
                    "salud para\n" +
                    currentYear+"\n" +
                    "Puede inscribirse en un plan de seguro de salud para "+currentYear+" si califica para un per\u00EDodo\n" +
                    "de inscripci\u00F3n especial o si est\u00E1 activa la inscripci\u00F3n abierta.\n" +
                    "Inscr\u00EDbase en un plan antes del "+lceCloseDate+".\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String taxCreditInfoMedicaid(String language, BasicActions basicActions){
        String currentYear = basicActions.getCurrYear();

        return switch (language) {
            case "English"->
                    "Premium Tax \n" +
                     "Credits or \n" +
                     "Cost-Sharing \n" +
                     "Reduction for \n" +
                     currentYear + "\n" +
                     "You do not qualify for Premium Tax Credits or Cost-Sharing Reduction because:\n" +
                     "You told us you qualify for Health First Colorado or Child Health Plan Plus \n" +
                     "(CHP+)\n";
            case "Spanish"->
                    "Cr\u00E9ditos\n" +
                    "fiscales para\n" +
                    "el pago de la\n" +
                    "cuota o\n" +
                    "reducci\u00F3n de\n" +
                    "No califica para obtener cr\u00E9ditos fiscales para el pago de la cuota ni reducci\u00F3n de los\n" +
                    "costos compartidos porque:\n" +
                    "Nos dijo que califica para Health First Colorado o Child Health Plan Plus\n" +
                    "(CHP+)\n" +
                    "los costos\n" +
                    "compartidos\n" +
                    "para "+currentYear+"\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String taxCreditInfoMedicaidSecondary(String language, BasicActions basicActions){
        String currentYear = basicActions.getCurrYear();

        return switch (language) {
            case "English"->
                    "Premium Tax \n" +
                    "Credits or \n" +
                    "Cost-Sharing \n" +
                    "Reduction for \n" +
                    currentYear + "\n" +
                    "You do not qualify for Premium Tax Credits or Cost-Sharing Reduction because:\n" +
                    "You told us you qualify for Health First Colorado or Child Health Plan Plus \n" +
                    "(CHP+)\n";
            case "Spanish"->
                    "Cr\u00E9ditos\n" +
                    "fiscales para\n" +
                    "el pago de la\n" +
                    "cuota o\n" +
                    "reducci\u00F3n de\n" +
                    "los costos\n" +
                    "compartidos\n" +
                    "para "+currentYear+"\n" +
                    "No califica para obtener cr\u00E9ditos fiscales para el pago de la cuota ni reducci\u00F3n de los\n" +
                    "costos compartidos porque:\n" +
                    "Nos dijo que califica para Health First Colorado o Child Health Plan Plus\n" +
                    "(CHP+)\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String chpPlus(String docType, String language, String memberNumber, BasicActions basicActions) {
        String firstOfNextMonth = getFirstOfNextMonth(language, basicActions);

        String englishTemplate = "%s, it looks like you may qualify for Health First Colorado (Colorado\u2019s Medicaid %s\n%s, starting as early as %s you are approved for:%s\n%s, you do not qualify for the following:%s\n%s";
        String englishTemplate2 = ", it looks like you may qualify for Health First Colorado (Colorado\u2019s Medicaid %s\n%s, starting as early as %s you are approved for:%s\n%s, you do not qualify for the following:%s\n%s";
        String spanishTemplate = "%s, por lo visto, podr\u00EDa calificar para Health First Colorado (el programa Medicaid de %s\n%s, a partir del %s usted est\u00E1 aprobado para:%s\n%s, no califica para lo siguiente:%s\n%s";
        String spanishTemplate2 = ", por lo visto, podr\u00EDa calificar para Health First Colorado (el programa %s\n%s, a partir del %s usted est\u00E1 aprobado para:%s\n%s, no califica para lo siguiente:%s\n%s";

        String primaryName = SharedData.getPrimaryMember().getFullName();
        List<MemberDetails> memberList = SharedData.getMembers();
        String member0Name = (memberList != null && !memberList.isEmpty()) ? SharedData.getMembers().get(0).getFullName() : "";

        return switch (memberNumber) {
            case "1" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate,
                        healthFirstChpData(language),
                        primaryName,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        primaryName,
                        healthPlanInfo(docType, language, basicActions),
                        primaryName,
                        taxCreditInfoChp(language, basicActions)
                );
                case "Spanish" -> String.format(
                        spanishTemplate,
                        healthFirstChpData(language),
                        primaryName,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        primaryName,
                        healthPlanInfo(docType, language, basicActions),
                        primaryName,
                        taxCreditInfoChp(language, basicActions)
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            case "2" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate + englishTemplate2,
                        healthFirstChpData(language),
                        primaryName,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        primaryName,
                        healthPlanInfo(docType, language, basicActions),
                        primaryName,
                        taxCreditInfoChp(language, basicActions),
                        member0Name,
                        healthFirstInfoSecondary(language),
                        firstOfNextMonth,
                        member0Name,
                        healthPlanInfo(docType, language, basicActions),
                        member0Name,
                        taxCreditInfoChpSecondary(language, basicActions)
                );
                case "Spanish" -> String.format(
                        spanishTemplate + spanishTemplate2,
                        healthFirstChpData(language),
                        primaryName,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        primaryName,
                        healthPlanInfo(docType, language, basicActions),
                        primaryName,
                        taxCreditInfoChp(language, basicActions),
                        member0Name,
                        healthFirstInfoSecondary(language),
                        firstOfNextMonth,
                        member0Name,
                        healthPlanInfo(docType, language, basicActions),
                        member0Name,
                        taxCreditInfoChpSecondary(language, basicActions)
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            default -> throw new IllegalArgumentException("Invalid member number: " + memberNumber);
        };
    }

    public static String taxCreditInfoChp(String language, BasicActions basicActions){
        String currentYear = basicActions.getCurrYear();

        return switch (language) {
            case "English"->
                    "Premium Tax \n" +
                    "Credits or \n" +
                    "Cost-Sharing \n" +
                    "Reduction for \n" +
                    currentYear + "\n" +
                    "You do not qualify for Premium Tax Credits or Cost-Sharing Reduction because:\n" +
                    "You told us you qualify for Health First Colorado or Child Health Plan Plus \n" +
                    "(CHP+)\n" +
                    "Unless you have an exceptional circumstance, if you are married, you\n" +
                    "must file taxes as married filing jointly\n";
            case "Spanish"->
                    "Cr\u00E9ditos\n" +
                    "fiscales para\n" +
                    "el pago de la\n" +
                    "cuota o\n" +
                    "reducci\u00F3n de\n" +
                    "No califica para obtener cr\u00E9ditos fiscales para el pago de la cuota ni reducci\u00F3n de los\n" +
                    "costos compartidos porque:\n" +
                    "Nos dijo que califica para Health First Colorado o Child Health Plan Plus\n" +
                    "(CHP+)\n" +
                    "A menos que tenga una circunstancia excepcional, si es casado/a debe\n" +
                    "declarar impuestos como casado que presenta su declaraci\u00F3n en pareja\n" +
                    "los costos\n" +
                    "compartidos\n" +
                    "para "+currentYear+"\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String taxCreditInfoChpSecondary(String language, BasicActions basicActions){
        String currentYear = basicActions.getCurrYear();

        return switch (language) {
            case "English"->
                    "Premium Tax \n" +
                    "Credits or \n" +
                    "Cost-Sharing \n" +
                    "Reduction for \n" +
                    currentYear + "\n" +
                    "You do not qualify for Premium Tax Credits or Cost-Sharing Reduction because:\n" +
                    "You told us you qualify for Health First Colorado or Child Health Plan Plus \n" +
                    "(CHP+)\n" +
                    "Unless you have an exceptional circumstance, if you are married, you\n" +
                    "must file taxes as married filing jointly\n";
            case "Spanish"->
                    "Cr\u00E9ditos\n" +
                    "fiscales para\n" +
                    "el pago de la\n" +
                    "cuota o\n" +
                    "reducci\u00F3n de\n" +
                    "los costos\n" +
                    "compartidos\n" +
                    "para "+currentYear+"\n" +
                    "No califica para obtener cr\u00E9ditos fiscales para el pago de la cuota ni reducci\u00F3n de los\n" +
                    "costos compartidos porque:\n" +
                    "Nos dijo que califica para Health First Colorado o Child Health Plan Plus\n" +
                    "(CHP+)\n" +
                    "A menos que tenga una circunstancia excepcional, si es casado/a debe\n" +
                    "declarar impuestos como casado que presenta su declaraci\u00F3n en pareja\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String cobra(String docType, String language, String memberNumber, BasicActions basicActions) {
        String firstOfNextMonth = getFirstOfNextMonth(language, basicActions);

        String englishTemplate = ", starting as early as %s you are approved for:%s\n%s, you do not qualify for the following:%s\n%s";
        String spanishTemplate = ", a partir del %s usted est\u00E1 aprobado para:%s\n%s, no califica para lo siguiente:%s\n%s";

        String primaryName = SharedData.getPrimaryMember().getFullName();
        List<MemberDetails> memberList = SharedData.getMembers();
        String member0Name = (memberList != null && !memberList.isEmpty()) ? SharedData.getMembers().get(0).getFullName() : "";

        return switch (memberNumber) {
            case "1" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate,
                        firstOfNextMonth,
                        primaryName,
                        healthInsuranceInfo(docType, language, basicActions),
                        primaryName,
                        cobraInfo(language, basicActions),
                        primaryName
                );
                case "Spanish" -> String.format(
                        spanishTemplate,
                        firstOfNextMonth,
                        primaryName,
                        healthInsuranceInfo(docType, language, basicActions),
                        primaryName,
                        cobraInfo(language, basicActions),
                        primaryName
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            case "2" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate + englishTemplate,
                        firstOfNextMonth,
                        primaryName,
                        healthInsuranceInfo(docType, language, basicActions),
                        primaryName,
                        cobraInfo(language, basicActions),
                        primaryName,
                        member0Name,
                        healthInsuranceInfo(docType, language, basicActions),
                        firstOfNextMonth,
                        member0Name,
                        cobraInfo(language, basicActions),
                        member0Name
                );
                case "Spanish" -> String.format(
                        spanishTemplate + spanishTemplate,
                        firstOfNextMonth,
                        primaryName,
                        healthInsuranceInfo(docType, language, basicActions),
                        primaryName,
                        cobraInfo(language, basicActions),
                        primaryName,
                        member0Name,
                        healthInsuranceInfo(docType, language, basicActions),
                        firstOfNextMonth,
                        member0Name,
                        cobraInfo(language, basicActions),
                        member0Name
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            default -> throw new IllegalArgumentException("Invalid member number: " + memberNumber);
        };
    }

    public static String individualInsurance(String docType, String language, String memberNumber, BasicActions basicActions) {
        String firstOfNextMonth = getFirstOfNextMonth(language, basicActions);

        String englishTemplate = ", starting as early as %s you are approved for:%s\n%s, you do not qualify for the following:%s\n%s";
        String spanishTemplate = ", a partir del %s usted est\u00E1 aprobado para:%s\n%s, no califica para lo siguiente:%s\n%s";

        String primaryName = SharedData.getPrimaryMember().getFullName();
        List<MemberDetails> memberList = SharedData.getMembers();
        String member0Name = (memberList != null && !memberList.isEmpty()) ? SharedData.getMembers().get(0).getFullName() : "";

        return switch (memberNumber) {
            case "1" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate,
                        firstOfNextMonth,
                        primaryName,
                        healthInsuranceInfo(docType, language, basicActions),
                        primaryName,
                        IndividualInsuranceInfo(language, basicActions),
                        primaryName
                );
                case "Spanish" -> String.format(
                        spanishTemplate,
                        firstOfNextMonth,
                        primaryName,
                        healthInsuranceInfo(docType, language, basicActions),
                        primaryName,
                        IndividualInsuranceInfo(language, basicActions),
                        primaryName
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            case "2" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate + englishTemplate,
                        firstOfNextMonth,
                        primaryName,
                        healthInsuranceInfo(docType, language, basicActions),
                        primaryName,
                        IndividualInsuranceInfo(language, basicActions),
                        primaryName,
                        member0Name,
                        healthInsuranceInfo(docType, language, basicActions),
                        firstOfNextMonth,
                        member0Name,
                        IndividualInsuranceInfo(language, basicActions),
                        member0Name
                );
                case "Spanish" -> String.format(
                        spanishTemplate + spanishTemplate,
                        firstOfNextMonth,
                        primaryName,
                        healthInsuranceInfo(docType, language, basicActions),
                        primaryName,
                        IndividualInsuranceInfo(language, basicActions),
                        primaryName,
                        member0Name,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        member0Name,
                        IndividualInsuranceInfo(language, basicActions),
                        member0Name
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            default -> throw new IllegalArgumentException("Invalid member number: " + memberNumber);
        };
    }

    public static String healthInsuranceInfo(String docType, String language, BasicActions basicActions){
        String lceCloseDate = getLceCloseDate(language, docType, basicActions);
        String currentYear = basicActions.getCurrYear();

        return switch (language) {
            case "English"->
                    "Health\n" +
                    "insurance\n" +
                    "plan for "+currentYear+"\n" +
                    "You can enroll in a health insurance plan for "+currentYear+" if you qualify for a Special Enrollment\n" +
                    "Period or if it\u2019s Open Enrollment.\n" +
                    "Enroll in a plan by "+lceCloseDate+". \n";
            case "Spanish"->
                    "Plan de\n" +
                    "seguro de\n" +
                    "salud para\n" +
                    currentYear+"\n" +
                    "Puede inscribirse en un plan de seguro de salud para "+currentYear+" si califica para un per\u00EDodo\n" +
                    "de inscripci\u00F3n especial o si est\u00E1 activa la inscripci\u00F3n abierta.\n"+
                    "Inscr\u00EDbase en un plan antes del "+lceCloseDate+". \n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String cobraInfo(String language, BasicActions basicActions){
        String currentYear = basicActions.getCurrYear();

        return switch (language) {
            case "English"->
                    "Premium Tax \n" +
                            "Credits or \n" +
                            "Cost-Sharing \n" +
                            "Reduction for \n" +
                            currentYear + "\n" +
                            "You do not qualify for Premium Tax Credits or Cost-Sharing Reduction because:\n" +
                            "You are enrolled in a health plan through COBRA\n";
            case "Spanish"->
                    "Cr\u00E9ditos\n" +
                            "fiscales para\n" +
                            "el pago de la\n" +
                            "cuota o\n" +
                            "reducci\u00F3n de\n" +
                            "los costos\n" +
                            "compartidos\n" +
                            "para "+currentYear+"\n" +
                            "No califica para obtener cr\u00E9ditos fiscales para el pago de la cuota ni reducci\u00F3n de los\n" +
                            "costos compartidos porque:\n" +
                            "Est\u00E1 inscrito\u002Fa en un plan de salud a trav\u00E9s de COBRA\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String IndividualInsuranceInfo(String language, BasicActions basicActions){
        String currentYear = basicActions.getCurrYear();

        return switch (language) {
            case "English"->
                    "Premium Tax \n" +
                            "Credits or \n" +
                            "Cost-Sharing \n" +
                            "Reduction for \n" +
                            currentYear + "\n" +
                            "You do not qualify for Premium Tax Credits or Cost-Sharing Reduction because:\n" +
                            "You are enrolled in other health insurance\n";
            case "Spanish"->
                    "Cr\u00E9ditos\n" +
                            "fiscales para\n" +
                            "el pago de la\n" +
                            "cuota o\n" +
                            "reducci\u00F3n de\n" +
                            "los costos\n" +
                            "compartidos\n" +
                            "para "+currentYear+"\n" +
                            "No califica para obtener cr\u00E9ditos fiscales para el pago de la cuota ni reducci\u00F3n de los\n" +
                            "costos compartidos porque:\n" +
                            "Est\u00E1 inscrito\u002Fa en otro seguro de salud\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String reportToPeak (String docType,String language){
        if(docType.equals("CHP") || docType.equals("Health First Colorado")) {
            return switch (language) {
                case "English" ->
                        "To report changes, log into your PEAK account or call 855-752-6749 or TTY: 855-695-5935. If you do not have a PEAK \n" +
                        "account, you can create one at .Colorado.gov/PEAK\n";
                case "Spanish" ->
                        "Para informar de cambios, ingrese en su cuenta PEAK o llame al 855-752-6749 o TTY: 855-695-5935. Si no tiene\n" +
                        "cuenta PEAK, puede crear una en .Colorado.gov/PEAK\n";
                default -> throw new IllegalArgumentException("Invalid option: " + language);
            };
        }
        return "";
    }

    public static String additionalInformation (String docType,String language){
        if(docType.equals("CHP") || docType.equals("Health First Colorado")) {
            return switch (language) {
                case "English" ->
                        "Additional information for your household:\n" +
                        "If you apply for financial help through Connect for Health Colorado, we assess whether you or members of your \n" +
                        "household could qualify for Health First Colorado (Colorado\u2019s Medicaid Program) or the Child Health Plan Plus (CHP+) \n" +
                        "program. This letter informs you which members of your household may qualify for these programs based on our \n" +
                        "assessment. However, you or members of your household can request a full determination from the State of Colorado \n" +
                        "on whether they qualify for Health First Colorado or CHP+. Call 855-752-6749 or TTY: 855-695-5935 for questions \n" +
                        "about financial help available through Connect for Health Colorado.\n" +
                        "If members of your household qualify for Health First Colorado or CHP+, but you do not want that coverage, you may \n" +
                        "choose to enroll in a health insurance plan through Connect for Health Colorado.\n" +
                        "To see plans offered in your area, log into your Connect for Health Colorado account, click on your eligibility \n" +
                        "summary, and click continue to go to the shopping pages.\n";
                case "Spanish" ->
                        "Informaci\u00F3n adicional para su familia:\n" +
                        "Si solicita ayuda financiera a trav\u00E9s de Connect for Health Colorado, evaluamos si usted o los miembro de su familia\n" +
                        "podr\u00EDan calificar para Health First Colorado (Programa Medicaid de Colorado) o el programa de Child Health Plan Plus\n" +
                        "(CHP+). Esta carta le informa cu\u00E1les miembros de su familia pueden calificar para estos programas seg\u00FAn nuestra\n" +
                        "evaluaci\u00F3n. Sin embargo, usted o los miembros de su familia pueden solicitar una determinaci\u00F3n completa al Gobierno\n" +
                        "del estado de Colorado para ver si califican para Health First Colorado o CHP+. Llame al 855-752-6749 o TTY: 855-695-\n" +
                        "5935 para obtener respuestas a sus preguntas sobre ayuda financiera disponible a trav\u00E9s Connect for Health Colorado.\n" +
                        "Si los miembros de su familia califican para Health First Colorado o para CHP+ pero no desean esa cobertura, pueden\n" +
                        "optar por inscribirse en un plan de seguro de salud por medio de Connect for Health Colorado.\n" +
                        "Para ver los planes que se ofrecen en su zona, ingrese en su cuenta de Connect for Health Colorado, haga\n"+
                "clic en su resumen de elegibilidad y pulse en \u201Ccontinuar\u201D para ir a las p\u00E1ginas de adquisici\u00F3n.\n";
                default -> throw new IllegalArgumentException("Invalid option: " + language);
            };
        }
        return "";
    }

    public static String getApplicationResultsSpanish(String docType, String language, String memberNumber, BasicActions basicActions) {
        String timestamp = getCurrentTimestamp(language, basicActions);

        return String.format("ELG-101-01\n" +
                SharedData.getPrimaryMember().getEmailId()+"\n" +
                "N\u00FAmero de Cuenta: "+SharedData.getPrimaryMember().getAccount_id()+"\n" +
                timestamp+" a las \n" +
                "Apreciable "+SharedData.getPrimaryMember().getFullName()+",\n" +
                introParagraph(docType,language, basicActions) +
                resultsType(docType, language, memberNumber, basicActions)+
                "Informe de cambios en su situaci\u00F3n familiar:\n" +
                "Si ocurren cambios en su situaci\u00F3n familiar despu\u00E9s de haberse inscrito en un plan por medio de Connect for Health\n" +
                "Colorado, deber\u00E1 informarnos de ellos dentro de un plazo de 30 d\u00EDas. Algunos cambios, llamados \"eventos calificados\n" +
                "de vida\", pueden permitir que su familia adquiera un nuevo plan mediante un Per\u00EDodo de inscripci\u00F3n especial. Si decide\n" +
                "inscribirse en un nuevo plan mediante un Per\u00EDodo de inscripci\u00F3n especial, deber\u00E1 hacerlo en el transcurso de 60 d\u00EDas\n" +
                "de haber ocurrido su evento calificado de vida. Si quiere obtener m\u00E1s informaci\u00F3n sobre los eventos calificados de vida,\n" +
                "visite Es.ConnectForHealthCO.com/recursos/antes-compar/cuando-puedo-comprar/.\n" +
                reportToPeak(docType,language)+
                "Si no avisa de los cambios en su situaci\u00F3n familiar, es posible que deba devolver al Servicio de Rentas Internas (IRS\n" +
                "en ingl\u00E9s) todo o parte de su Cr\u00E9dito fiscal para el pago de la cuota, cuando presente su declaraci\u00F3n del impuesto\n" +
                "federal sobre los ingresos.\n" +
                additionalInformation(docType, language)+
                "No est\u00E1 de acuerdo con la determinaci\u00F3n:\n" +
                "Si no est\u00E1 de acuerdo con la determinaci\u00F3n sobre la elegibilidad de su familia, puede presentar una apelaci\u00F3n.\n" +
                "Debe solicitar una apelaci\u00F3n de los resultados que figuran en este aviso en los 60 d\u00EDas posteriores a la fecha\n" +
                "Para ello, puede solicitar una resoluci\u00F3n informal, una audiencia formal o ambas. Puede ingresar en su del mismo.\n" +
                "cuenta de Connect for Health Colorado para ver un resumen de la informaci\u00F3n que utilizamos para evaluar su\n" +
                "elegibilidad.\n" +
                "Puede solicitar una apelaci\u00F3n en una de estas cuatro formas:\n" +
                "1. Llame al Centro de atenci\u00F3n al cliente de Connect for Health Colorado\u00AE al 855-752-6749 (TTY:855-695-5935) de\n" +
                "lunes a viernes de 8:00 a.m. a 6:00 p.m.\n" +
                "2. Visite  para descargar un formulario de solicitud de apelaci\u00F3n. Puede llenar su Es.ConnectForHealthCO.com\n" +
                "solicitud de apelaci\u00F3n y subirla a su cuenta de Connect for Health Colorado en \u201CMis documentos\u201D.\n" +
                "3. Lleve o env\u00EDe por correo su Solicitud de apelaci\u00F3n a:\n" +
                "Office of Appeals\n" +
                "4600 South Ulster Street\n" +
                "Suite 300\n" +
                "Denver CO 80237\n" +
                "4. Env\u00EDe por fax su formulario de Solicitud de apelaci\u00F3n al 303-322-4217.\n" +
                "Tiene derecho a la representaci\u00F3n:\n" +
                "Puede representarse usted mismo o ser representado por un abogado o por otra persona que usted elija, como un\n" +
                "amigo o un familiar.\n" +
                "La decisi\u00F3n sobre la apelaci\u00F3n respecto a un miembro de la familia puede cambiar la elegibilidad de otros\n" +
                "miembros.\n" +
                "Audiencia agilizada:\n" +
                "Si considera que esperar una audiencia puede poner en peligro su vida o su salud, tiene derecho a pedir una\n" +
                "audiencia agilizada (audiencia r\u00E1pida). Para solicitar una audiencia agilizada, aplique el mismo proceso que para una\n" +
                "apelaci\u00F3n y audiencia regulares, pero indique que desea una \"audiencia agilizada\" y explique por qu\u00E9 debe ser\n" +
                "agilizada.\n" +
                "Otra informaci\u00F3n:\n" +
                "Las determinaciones o evaluaciones indicadas en esta carta se hicieron con fundamento en 45 CFR 155.335 y 45\n" +
                "CFR 155.305.\n" +
                "Connect for Health Colorado no discrimina por motivos de raza, color de piel, origen \u00E9tnico o nacional,\n" +
                "ascendencia, edad, sexo, g\u00E9nero, identidad y expresi\u00F3n de g\u00E9nero, orientaci\u00F3n sexual, estado civil, religi\u00F3n,\n" +
                "credo, creencias pol\u00EDticas o discapacidad en ninguno de sus programas, servicios y actividades.\n" +
                "Connect for Health Colorado puede brindar apoyos y servicios a personas con incapacidades, as\u00ED como servicios\n" +
                "de idioma a personas cuya lengua materna no sea el ingl\u00E9s, cuando as\u00ED se requiera para lograr igualdad de\n" +
                "oportunidades y acceso constructivo a programas, servicios y actividades. Algunos ejemplos de esos apoyos y\n" +
                "servicios son, entre otros: int\u00E9rpretes competentes de lenguaje de se\u00F1as, informaci\u00F3n en otros formatos (incluida\n" +
                "la impresi\u00F3n en letra grande), int\u00E9rpretes de idiomas extranjeros y traducci\u00F3n de informaci\u00F3n a otros idiomas. Los\n" +
                "apoyos y servicios pueden brindarse de manera oportuna y sin costo.\n" +
                "Para solicitar apoyos o servicios gratuitos, llame al Centro de atenci\u00F3n al cliente de Connect for Health\n" +
                "Colorado\u00AE al 855-752-6749 (TTY:855-695-5935) de lunes a viernes de 8:00 a.m. a 6:00 p.m.\n" +
                "Para presentar una denuncia de discriminaci\u00F3n o para conocer mejor esta pol\u00EDtica, llame al 303-590-9640, env\u00EDe un\n" +
                "fax al 303-322-4217, o escr\u00EDbanos por correo postal a:\n" +
                "Connect for Health Colorado\n" +
                "General Counsel\n" +
                "4600 South Ulster Street\n" +
                "Suite 300\n" +
                "Denver CO 80237\n" +
                "Las denuncias sobre derechos civiles tambi\u00E9n pueden presentarse ante la Oficina de Derechos Civiles del\n" +
                "Departamento de Salud y Servicios Humanos de EE.UU. por v\u00EDa electr\u00F3nica, a trav\u00E9s del Portal de quejas de la\n" +
                "Oficina de Derechos Civiles disponible en  o por tel\u00E9fono, fax o https://ocrportal.hhs.gov/ocr/cp/complaint_frontpage.jsf\n" +
                "correo postal en:\n" +
                "Tel\u00E9fono: 800-368-1019\n" +
                "Fax: 202-619-3818\n" +
                "TDD: 800-537-7697\n" +
                "1961 Stout Street Room 08-148\n" +
                "Suite 5000\n" +
                "Denver CO 80294\n" +
                "Los formularios para quejas pueden obtenerse en http://www.hhs.gov/civil-rights/filing-a-complaint/index.html\n" +
                "Atentamente,\n" +
                "Connect for Health Colorado\u00AE\n" +
                "Puede recibir esta carta en ingl\u00E9s o en copia impresa con letra grande o de cualquier otra manera que le resulte\n" +
                "conveniente. Llame al 855-752-6749. You can get this letter in English or in a large print copy or another way that's best\n" +
                "for you. Call 855-752-6749.\n" +
                "es el mercado oficial de seguros de salud de Colorado. Nuestra misi\u00F3n es aumentar la Connect for Health Colorado\u00AE\n" +
                "disponibilidad, la accesibilidad y la capacidad de elecci\u00F3n de las personas, familias y peque\u00F1as empresas. Para obtener\n" +
                "m\u00E1s informaci\u00F3n, visite Es.ConnectForHealthCO.com/.\n" +
                "AVISO DE CONFIDENCIALIDAD: este mensaje y su contenido son confidenciales y est\u00E1n dirigidos exclusivamente los\n" +
                "destinatarios. Si usted no es el destinatario previsto y recibe este mensaje por error, no deber\u00E1 utilizarlo, copiarlo,\n" +
                "reproducirlo ni distribuirlo. Notifique al remitente y elimine el mensaje. Muchas gracias.\n" +
                ": Su privacidad es importante para nosotros. Nuestra declaraci\u00F3n p\u00FAblica de privacidad est\u00E1 Aviso de privacidad\n" +
                "disponible en https://connectforhealthco.com/es/politica-de-privacidad/.\n" +
                "Ayuda Lengua Adicional");
    }
    public static String premiumTaxCredits(String docType, String language, String memberNumber, BasicActions basicActions) {
        String englishTemplate = ", starting as early as "+getFirstOfNextMonth(language, basicActions)+" you are approved for:";
        String englishTemplate2 = "Enroll in a plan by "+getLceCloseDate(language, docType, basicActions)+".\n";
        String englishTemplate3 = ", you do not qualify for the following:";
        String englishTemplate4 = "Verification is\n"+"needed\n"+"We\u2019re missing some information!\n"+
                "You are temporarily approved for 90 days, but we need more information\n"+
                "from you to continue your coverage after the 90 days. Please see the\n"+
                "\u201cMore information needed\u201D section below for what is needed and next\n"+"steps.\n";
        String spanishTemplate = ", a partir del "+getFirstOfNextMonth(language, basicActions)+" usted est\u00E1 aprobado para:";
        String spanishTemplate2 = "Inscr\u00EDbase en un plan antes del "+getLceCloseDate(language, docType, basicActions)+".\n";
        String spanishTemplate3 = ", no califica para lo siguiente:";
        String spanishTemplate4 = "Se requiere\n" + "verificaci\u00F3n\n" + "Nos falta alguna informaci\u00F3n!\n" +
                "Ha sido aprobado provisionalmente por 90 d\u00EDas, pero necesitamos m\u00E1s\n" +
                "informaci\u00F3n para que su cobertura contin\u00FAe despu\u00E9s de esos 90 d\u00EDas. En\n" +
                "la secci\u00F3n \"Se requiere m\u00E1s informaci\u00F3n\" que aparece en seguida se\n" +
                "indica lo que se necesita y los pasos siguientes.\n";

        String primaryName = SharedData.getPrimaryMember().getFullName();
        List<MemberDetails> memberList = SharedData.getMembers();
        String member0Name = (memberList != null && !memberList.isEmpty()) ? SharedData.getMembers().get(0).getFullName() : "";

        return switch (memberNumber) {
            case "1" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate +primaryName+"\n" +
                                "Premium\n" +
                                "Tax Credits\n" +
                                "for "+basicActions.getCurrYear()+"\n" +
                                "Your household qualifies to receive up to $178.11 a month to use towards\n" +
                                "lowering the cost of your monthly health insurance premiums when you\n" +
                                "enroll through Connect for Health Colorado. Based on your application,\n" +
                                "this applies to "+primaryName+"\n" +
                                englishTemplate2 +
                                englishTemplate +primaryName+"\n" +
                                "Health\n" +
                                "insurance\n" +
                                "plan for "+basicActions.getCurrYear()+"\n" +
                                "You can enroll in a health insurance plan for 2025 if you qualify for a Special Enrollment \n" +
                                "Period or if it\u2019s Open Enrollment.\n" +
                                englishTemplate2 +
                                englishTemplate3 +primaryName+"\n" +
                                "Cost-Sharing\n" +
                                "Reduction for\n" +
                                basicActions.getCurrYear()+"\n"+
                                "You do not qualify for Cost-Sharing Reduction because:\n" +
                                "Your household's income is too high\n"
                );
                case "Spanish" -> String.format(
                        spanishTemplate +primaryName+"\n" +
                                "Cr\u00E9ditos\n" +
                                "fiscales para\n" +
                                "el pago de la\n" +
                                "cuota para\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Su familia tiene derecho a recibir hasta $178.11 al mes para reducir el\n" +
                                "monto de las cuotas mensuales de su seguro de salud cuando se inscribe\n" +
                                "a trav\u00E9s de Connect for Health Colorado. De acuerdo con su solicitud,\n" +
                                "estos ahorros se aplican a: "+primaryName+"\n" +
                                spanishTemplate2 +
                                spanishTemplate +primaryName+"\n" +
                                "Plan de\n" +
                                "seguro de\n" +
                                "salud para\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Puede inscribirse en un plan de seguro de salud para 2025 si califica para un per\u00EDodo\n" +
                                "de inscripci\u00F3n especial o si est\u00E1 activa la inscripci\u00F3n abierta.\n" +
                                spanishTemplate2 +
                                spanishTemplate3 +primaryName+"\n" +
                                "Reducci\u00F3n\n" +
                                "de los costos\n" +
                                "compartidos\n" +
                                "para "+ basicActions.getCurrYear()+"\n" +
                                "Reducci\u00F3n de los costos compartidos no califica para lo siguiente:\n" +
                                "Sus ingresos familiares son demasiado altos\n"
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            case "2" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate +primaryName+"\n" +
                                "Premium Tax\n" +
                                "Credits for\n" +
                                 basicActions.getCurrYear()+"\n" +
                                "Your household qualifies to receive up to $712.11 a month to use towards\n" +
                                "lowering the cost of your monthly health insurance premiums when you\n" +
                                "enroll through Connect for Health Colorado. Based on your application,\n" +
                                "this applies to "+primaryName+"\n" +
                                englishTemplate2 +
                                englishTemplate4 +
                                englishTemplate +primaryName+"\n" +
                                "Health\n" +
                                "insurance\n" +
                                "plan for "+basicActions.getCurrYear()+"\n" +
                                "You can enroll in a health insurance plan for 2025 if you qualify for a Special Enrollment \n" +
                                "Period or if it\u2019s Open Enrollment.\n" +
                                englishTemplate2 +
                                englishTemplate4 +
                                englishTemplate3 +primaryName+"\n" +
                                "Cost-Sharing\n" +
                                "Reduction for\n" +
                                basicActions.getCurrYear()+"\n"+
                                "You do not qualify for Cost-Sharing Reduction because:\n" +
                                "Your household's income is too high\n" +

                                englishTemplate +member0Name+"\n" +
                                "Premium Tax\n" +
                                "Credits for\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Your household qualifies to receive up to $712.11 a month to use towards\n" +
                                "lowering the cost of your monthly health insurance premiums when you\n" +
                                "enroll through Connect for Health Colorado. Based on your application,\n" +
                                "this applies to "+member0Name+"\n" +
                                englishTemplate2 +
                                englishTemplate4 +
                                englishTemplate +member0Name+"\n" +
                                "Health\n" +
                                "insurance\n" +
                                "plan for "+basicActions.getCurrYear()+"\n" +
                                "You can enroll in a health insurance plan for 2025 if you qualify for a Special Enrollment \n" +
                                "Period or if it\u2019s Open Enrollment.\n" +
                                englishTemplate2 +
                                englishTemplate4 +
                                englishTemplate3 +member0Name+"\n" +
                                "Cost-Sharing\n" +
                                "Reduction for\n" +
                                basicActions.getCurrYear()+"\n"+
                                "You do not qualify for Cost-Sharing Reduction because:\n" +
                                "Your household's income is too high\n" +
                        moreInformationNeededForPremiumTaxCredit(docType, language, memberNumber, basicActions)
                );
                case "Spanish" -> String.format(
                        spanishTemplate +primaryName+"\n" +
                                "Cr\u00E9ditos\n" +
                                "fiscales para\n" +
                                "el pago de la\n" +
                                "cuota para\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Su familia tiene derecho a recibir hasta $712.11 al mes para reducir el\n" +
                                "monto de las cuotas mensuales de su seguro de salud cuando se inscribe\n" +
                                "a trav\u00E9s de Connect for Health Colorado. De acuerdo con su solicitud,\n" +
                                "estos ahorros se aplican a: "+primaryName+"\n" +
                                spanishTemplate2 +
                                spanishTemplate4 +
                                spanishTemplate +primaryName+"\n" +
                                "Plan de\n" +
                                "seguro de\n" +
                                "salud para\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Puede inscribirse en un plan de seguro de salud para 2025 si califica para un per\u00EDodo\n" +
                                "de inscripci\u00F3n especial o si est\u00E1 activa la inscripci\u00F3n abierta.\n" +
                                spanishTemplate2 +
                                spanishTemplate4 +
                                spanishTemplate3 +primaryName+"\n" +
                                "Reducci\u00F3n\n" +
                                "de los costos\n" +
                                "compartidos\n" +
                                "para "+ basicActions.getCurrYear()+"\n" +
                                "Reducci\u00F3n de los costos compartidos no califica para lo siguiente:\n" +
                                "Sus ingresos familiares son demasiado altos\n" +

                                spanishTemplate +member0Name+"\n" +
                                "Cr\u00E9ditos\n" +
                                "fiscales para\n" +
                                "el pago de la\n" +
                                "cuota para\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Su familia tiene derecho a recibir hasta $712.11 al mes para reducir el\n" +
                                "monto de las cuotas mensuales de su seguro de salud cuando se inscribe\n" +
                                "a trav\u00E9s de Connect for Health Colorado. De acuerdo con su solicitud,\n" +
                                "estos ahorros se aplican a: "+member0Name+"\n" +
                                spanishTemplate2 +
                                spanishTemplate4 +
                                spanishTemplate +member0Name+"\n" +
                                "Plan de\n" +
                                "seguro de\n" +
                                "salud para\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Puede inscribirse en un plan de seguro de salud para 2025 si califica para un per\u00EDodo\n" +
                                "de inscripci\u00F3n especial o si est\u00E1 activa la inscripci\u00F3n abierta.\n" +
                                spanishTemplate2 +
                                spanishTemplate4 +
                                spanishTemplate3 +member0Name+"\n" +
                                "Reducci\u00F3n\n" +
                                "de los costos\n" +
                                "compartidos\n" +
                                "para "+ basicActions.getCurrYear()+"\n" +
                                "Reducci\u00F3n de los costos compartidos no califica para lo siguiente:\n" +
                                "Sus ingresos familiares son demasiado altos\n" +
                                moreInformationNeededForPremiumTaxCredit(docType, language, memberNumber, basicActions)
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            default -> throw new IllegalArgumentException("Invalid member number: " + memberNumber);
        };

    }
    public static String moreInformationNeededForPremiumTaxCredit(String docType, String language, String memberNumber, BasicActions basicActions) {

        switch (memberNumber) {
            case "2" -> {
                switch (language) {
                    case "English" -> {
                        return String.format("More information needed\n" +
                                "1.\n"+
                                "2.\n"+
                                "We were unable to verify some of the information you provided and need you to log into your account to verify some\n" +
                                "details.\n" +
                                infoNeededForPremiumTaxCredit(docType, language, memberNumber, basicActions) +
                                "\u002A If you don\u2019t provide the missing information by this due date, you could lose your health insurance plan or the financial\n" +
                                "help you\u2019re getting to pay for your health insurance plan.\n" +
                                "Proof of Financial Help Eligibility\n" +
                                "We were unable to verify some of the information on your last Connect for Health Colorado application. As soon as\n" +
                                "possible, please  to your account to verify this information. See Next Steps below.log in\n" +
                                "Next Steps:\n" +
                                "Log in to your Connect for Health Colorado account.\n" +
                                "Depending on the information we need to verify, you may have the option to do this by answering some\n" +
                                "questions in your account. Click \"Verify My Information.\" \n" +
                                "If you\u2019ve already done that, you may need to submit documents instead. To learn more about how to submit\n" +
                                "documents, and which documents are appropriate, please visit: https://connectforhealthco.com/find-answers/after-you-\n" +
                                ".buy/submit-documents/\n" +
                                "Potential reasons we were unable to verify your eligibility for financial help:\n" +
                                "We were unable to confirm that you filed your taxes last year.\n" +
                                "If you receive advance payments of the premium tax credit, you must file Form 8962 with\n" +
                                "your federal income taxes. By following these steps, the IRS can make sure that you got\n" +
                                "the right amount of tax credit applied to your monthly premium \u2013 not too little and not too\n" +
                                "much. Visit  for more information.irs.gov\n" +
                                "We were unable to confirm the information you provided about your household\u2019s income.\n" +
                                "You or the person who completed your application selected not to allow us to compare your application \n" +
                                "information with our data sources.\n" +
                                "If you would like to allow us to compare your application information with our data sources in the future, \n" +
                                "you can update your application by clicking on the \u201CMake Changes\u201D button.\n" +
                                "How to get more information about this notice\n" +
                                "For more information please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-\n" +
                                "695-5935) Monday - Friday 8:00a.m. - 6:00p.m.\n" +
                                "Free help is also available with certified enrollment Brokers and Assisters. To connect with a local Broker or Assister, \n" +
                                "visit .https://connectforhealthco.com/we-can-help/\n" +
                                "To learn more about how to submit documents, and which documents are appropriate, please visit \n" +
                                ".https://connectforhealthco.com/find-answers/after-you-buy/submit-documents/\n");
                    }
                    case "Spanish" -> {
                        return String.format(
                                "1.\n"+
                                        "2.\n"+
                                        "Se necesita m\u00E1s informaci\u00F3n\n" +
                                        "No pudimos verificar parte de la informaci\u00F3n que nos proporcion\u00F3, es necesario que inicie sesi\u00F3n en su cuenta para\n" +
                                        "verificar algunos detalles.\n" +
                                        infoNeededForPremiumTaxCredit(docType, language, memberNumber, basicActions) +
                                        "\u002A Si no env\u00EDa la informaci\u00F3n faltante antes de la fecha l\u00EDmite, puede perder su plan de seguro de salud o la ayuda \n" +
                                        "financiera que obtiene para pagar su plan de seguro de salud.\n" +
                                        "Comprobante De Elegibilidad Para Ayuda Financiera\n" +
                                        "No pudimos verificar parte de la informaci\u00F3n en su \u00FAltima solicitud para Connect for Health Colorado. Inicie sesi\u00F3n con \n" +
                                        "su cuenta lo antes posible para verificar su informaci\u00F3n. Consulte los pasos siguientes a continuaci\u00F3n.\n" +
                                        "Pasos siguientes:\n" +
                                        "Inicie sesi\u00F3n con su cuenta de Connect for Health Colorado.\n" +
                                        "Dependiendo de la informaci\u00F3n que necesitemos, es posible que tenga la opci\u00F3n de verificarla respondiendo \n" +
                                        "algunas preguntas en su cuenta. Haga clic en \"Verify My Information\" (Verificar mi informaci\u00F3n).\n" +
                                        "Si ya lo hizo, es posible que deba presentar documentos. Para obtener m\u00E1s informaci\u00F3n acerca de c\u00F3mo enviar sus\n" +
                                        "documentos y cu\u00E1les documentos son adecuados, visite: https://connectforhealthco.com/es/encuentre-respuestas\n" +
                                        "./despues-de-adquirir/enviar-documentos/\n" +
                                        "Posibles motivos por lo que no pudimos verificar su elegibilidad para recibir ayuda financiera:\n" +
                                        "No pudimos confirmar que present\u00F3 sus declaraciones fiscales.\n" +
                                        "Si usted recibe pagos anticipados del cr\u00E9dito fiscal para el pago de la prima, debe \n" +
                                        "presentar el Formulario 8962 con su declaraci\u00F3n de impuestos federales. Al seguir estos\n" +
                                        "pasos, el Servicio de Rentas Internas (IRS) puede asegurarse de que usted recibi\u00F3 la\n" +
                                        "cantidad correcta del cr\u00E9dito fiscal que se aplica a su prima mensual, es decir, la cantidad\n" +
                                        "justa. Visite  para obtener m\u00E1s informaci\u00F3n.irs.gov\n" +
                                        "No pudimos confirmar la informaci\u00F3n proporcionada sobre su ingreso familiar con las fuentes de datos\n" +
                                        "confiables.\n" +
                                        "Usted no nos permiti\u00F3 comparar su solicitud con la informaci\u00F3n federal para determinar su elegibilidad \n" +
                                        "para recibir ayuda financiera cuando llen\u00F3 la solicitud.\n" +
                                        "Si desea permitirnos revisar los datos de sus ingresos en el futuro, h\u00E1ganoslo saber actualizando su \n" +
                                        "solicitud.\n" +
                                        "C\u00F3mo obtener m\u00E1s informaci\u00F3n sobre este aviso\n" +
                                        "Para m\u00E1s informaci\u00F3n llame al Centro de atenci\u00F3n al cliente de Connect for Health Colorado\u00AE al 855-752-6749 (TTY:\n" +
                                        "855-695-5935) de lunes a viernes de 8:00 a.m. a 6:00 p.m.\n" +
                                        "Tambi\u00E9n puede obtener ayuda gratuita con agentes y asistentes de inscripci\u00F3n certificados. Para contactar a un agente \n" +
                                        "o asistente local, visite .https://connectforhealthco.com/we-can-help\n" +
                                        "Para obtener m\u00E1s informaci\u00F3n acerca de c\u00F3mo enviar sus documentos y cu\u00E1les documentos son adecuados, visite\n" +
                                        ".https://connectforhealthco.com/es/encuentre-respuestas/despues-de-adquirir/enviar-documentos/\n"
                        );
                    }
                    default -> throw new IllegalArgumentException("Unexpected value: " + language);
                }
            }
            case "3" -> {
                switch (language) {
                    case "English" -> {
                        return String.format("");
                    }
                    case "Spanish" -> {
                        return String.format("");
                    }
                    default -> throw new IllegalArgumentException("Unexpected value: " + language);
                }
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + memberNumber);
        }
    }
    public static String infoNeededForPremiumTaxCredit(String docType, String language, String memberNumber, BasicActions basicActions) {
        String futureDate = basicActions.getFutureDate(90);
        String informationDueDate = basicActions.changeDateFormat(futureDate, "MM/dd/yyyy", "MMMM d, yyyy", Locale.ENGLISH);

        Locale spanishLocale = new Locale("es", "ES");
        String informationDueDateSpanish = basicActions.changeDateFormat(futureDate, "MM/dd/yyyy", "d 'de' MMMM 'del' yyyy", spanishLocale);

        List<MemberDetails> memberList = SharedData.getMembers();
        String member0Name = (memberList != null && !memberList.isEmpty()) ? SharedData.getMembers().get(0).getFullName() : "";

        return switch (memberNumber) {
            case "2" -> switch (language) {
                case "English" -> String.format("Who needs to provide\n" +
                                "information?\n" +
                                "What information is needed? When is the information due?\n" +
                                SharedData.getPrimaryMember().getFullName() +
                                " Proof of financial help eligibility "+informationDueDate+"\n" +
                                member0Name +
                                " Proof of financial help eligibility "+informationDueDate+"\n");

                case "Spanish" -> String.format("\u00BFQui\u00E9n necesita proporcionar\n" +
                        "informaci\u00F3n?\n" +
                        "\u00BFQu\u00E9 informaci\u00F3n se necesita? \u00BFCu\u00E1ndo es la fecha l\u00EDmite para\n" +
                        "enviar la informaci\u00F3n?\n" +
                        SharedData.getPrimaryMember().getFullName() +
                        " Comprobante de su elegibilidad para\n" +
                        "recibir ayuda financiera\n" +informationDueDateSpanish+"\n" +
                        member0Name +
                        " Comprobante de su elegibilidad para\n" +
                        "recibir ayuda financiera\n" +informationDueDateSpanish+"\n");
                default -> throw new IllegalArgumentException("Unexpected value: " + language);
            };
            default -> throw new IllegalArgumentException("Unexpected value: " + memberNumber);
        };
    }

    public static String noCostSharingReduction(String docType, String language, String memberNumber, BasicActions basicActions) {

        String lceCloseDate = getLceCloseDate(language, docType, basicActions);
        String englishTemplate = ", starting as early as "+getFirstOfNextMonth(language, basicActions)+" you are approved for:"+SharedData.getPrimaryMember().getFullName()+"\n";
        String englishTemplate2 = "Enroll in a plan by "+lceCloseDate+".\n";
        String englishTemplate3 = ", you do not qualify for the following:"+SharedData.getPrimaryMember().getFullName()+"\n";

        String spanishTemplate = ", a partir del "+getFirstOfNextMonth(language, basicActions)+" usted est\u00E1 aprobado para:"+SharedData.getPrimaryMember().getFullName()+"\n";
        String spanishTemplate2 = "Inscr\u00EDbase en un plan antes del "+getLceCloseDate(language, docType, basicActions)+".\n";
        String spanishTemplate3 = ", no califica para lo siguiente:"+SharedData.getPrimaryMember().getFullName()+"\n";

        String qualifierAmt = "$0";

        List<MemberDetails> memberList = SharedData.getMembers();
        String member0Name = (memberList != null && !memberList.isEmpty()) ? SharedData.getMembers().get(0).getFullName() : "";

        return switch (memberNumber) {
            case "1" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate +
                                "Premium\n" +
                                "Tax Credits\n" +
                                "for "+basicActions.getCurrYear()+"\n" +
                                "While you qualify for Premium Tax Credits, the amount you qualify for is \n"+
                                qualifierAmt+" because of your income and the health insurance plans available in\n" +
                                "your area\n" +
                                englishTemplate +
                                "Health\n" +
                                "insurance\n" +
                                "plan for "+basicActions.getCurrYear()+"\n" +
                                "You can enroll in a health insurance plan for 2025 if you qualify for a Special Enrollment \n" +
                                "Period or if it\u2019s Open Enrollment.\n" +
                                englishTemplate2+
                                englishTemplate3 +
                                "Cost-Sharing\n" +
                                "Reduction for\n" +
                                basicActions.getCurrYear()+"\n"+
                                "You do not qualify for Cost-Sharing Reduction because:\n" +
                                "Your household's income is too high\n"
                );

                case "Spanish" -> String.format(
                        spanishTemplate +
                                "Cr\u00E9ditos\n" +
                                "fiscales para\n" +
                                "el pago de la\n" +
                                "cuota para\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Aunque califica para cr\u00E9dito fiscal para el pago de la cuota, la cantidad\n" +
                                "que le han autorizado es de "+qualifierAmt+" luego de considerar sus ingresos y los\n" +
                                "planes de seguro de salud disponibles en su zona\n" +
                                spanishTemplate+
                                "Plan de\n" +
                                "seguro de\n" +
                                "salud para\n" +
                                basicActions.getCurrYear()+"\n" +
                                "Puede inscribirse en un plan de seguro de salud para 2025 si califica para un per\u00EDodo\n" +
                                "de inscripci\u00F3n especial o si est\u00E1 activa la inscripci\u00F3n abierta.\n" +
                                spanishTemplate2 +
                                spanishTemplate3 +
                                "Reducci\u00F3n\n" +
                                "de los costos\n" +
                                "compartidos\n" +
                                "para "+ basicActions.getCurrYear()+"\n" +
                                "Reducci\u00F3n de los costos compartidos no califica para lo siguiente:\n" +
                                "Sus ingresos familiares son demasiado altos\n"
                );

                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            case "2" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate + englishTemplate2 + englishTemplate3
                );
                case "Spanish" -> String.format(
                        spanishTemplate + spanishTemplate2 + spanishTemplate3
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            default -> throw new IllegalArgumentException("Invalid member number: " + memberNumber);
        };
    }

    }
