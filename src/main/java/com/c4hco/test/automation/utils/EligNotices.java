package com.c4hco.test.automation.utils;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class EligNotices {
    private static String getCurrentTimestamp(String language) {
        Locale locale;

        switch (language.toLowerCase()) {
            case "spanish":
                locale = new Locale("es", "ES");
                return new SimpleDateFormat("d 'de' MMMM 'del' yyyy", locale).format(new Date());
            case "english":
                locale = Locale.ENGLISH;
                return new SimpleDateFormat("MMMM d, yyyy", locale).format(new Date());
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private static String getLceCloseDate(String language) {
        Locale locale;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 60);

        switch (language.toLowerCase()) {
            case "spanish":
                locale = new Locale("es", "ES");
                return new SimpleDateFormat("d 'de' MMMM 'del' yyyy", locale).format(calendar.getTime());
            case "english":
                locale = Locale.ENGLISH;
                return new SimpleDateFormat("MMMM d, yyyy", locale).format(calendar.getTime());
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private static String getFirstOfNextMonth(String language) {
        Locale locale;
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.MONTH, 1); // Add one month
        calendar.set(Calendar.DAY_OF_MONTH, 1); // Set to the first day of the month

        switch (language.toLowerCase()) {
            case "spanish":
                locale = new Locale("es", "ES");
                return new SimpleDateFormat("d 'de' MMMM 'del' yyyy", locale).format(calendar.getTime());
            case "english":
                locale = Locale.ENGLISH;
                return new SimpleDateFormat("MMMM d, yyyy", locale).format(calendar.getTime());
            default:
                throw new IllegalArgumentException("Unsupported language: " + language);
        }
    }

    private static String getCurrentYear() {
        Calendar calendar = Calendar.getInstance();
        return new SimpleDateFormat("yyyy").format(calendar.getTime());
    }

    public static String getApplicationResults(String docType, String language, String memberNumber) {
        String timestamp = getCurrentTimestamp(language);
        String lceCloseDate = getLceCloseDate(language);

        return String.format("ELG-101-01\n" +
            SharedData.getPrimaryMember().getEmailId()+"\n" +
            "Account Number: "+SharedData.getPrimaryMember().getAccount_id()+"\n" +
            timestamp+" at \n" +
            "Dear "+SharedData.getPrimaryMember().getFullName()+",\n" +
            "We received new or updated information about your household on "+timestamp+". The change to your household\u2019s \n" +
            "information is considered a Qualified Life Change Event, which means you can enroll in a health insurance plan or make \n" +
            "changes to your current plan through a Special Enrollment Period.\n" +
            "You can enroll in a new plan or make changes to your current plan by "+lceCloseDate+".\n" +
            resultsType(docType, language, memberNumber)+
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
            "1. Please call the Connect for Health Colorado\u00AE Customer Service Center at 855-752-6749 (TTY:855-346-3432) \n" +
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
            "752-6749 (TTY:855-346-3432) Monday - Friday 8:00a.m. - 6:00p.m.\n" +
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
            "855-346-3432). Puede recibir esta carta en espa\u00F1ol o en copia impresa con letra grande o de cualquier otra manera que \n" +
            "le resulte conveniente. Llame al 855-752-6749 (TTY: 855-346-3432).\n" +
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
    
    public static String resultsType(String docType, String language, String memberNumber){
        return switch (docType) {
            case "Health First Colorado" -> healthFirstColorado(language, memberNumber);
            case "CHP" -> chpPlus(language, memberNumber);
            case "Cobra" -> cobra(language, memberNumber);
            default -> throw new IllegalArgumentException("Invalid option: " + docType);
        };
    }

    public static String healthFirstColorado(String language, String memberNumber) {
        String firstOfNextMonth = getFirstOfNextMonth(language);

        String englishTemplate = "%s, it looks like you may qualify for Health First Colorado (Colorado\u2019s %s\n%s, starting as early as %s you are approved for:%s\n%s, you do not qualify for the following:%s\n%s";
        String englishTemplate2 = ", it looks like you may qualify for Health First Colorado (Colorado\u2019s %s\n%s, starting as early as %s you are approved for:%s\n%s, you do not qualify for the following:%s\n%s";
        String spanishTemplate = "%s, por lo visto, podr\u00EDa calificar para Health First Colorado (el programa %s\n%s, a partir del %s usted est\u00E1 aprobado para:%s\n%s, no califica para lo siguiente:%s\n%s";
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
                        healthPlanInfo(language),
                        primaryName,
                        taxCreditInfoMedicaid(language)
                );
                case "Spanish" -> String.format(
                        spanishTemplate,
                        healthFirstChpData(language),
                        primaryName,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        primaryName,
                        healthPlanInfo(language),
                        primaryName,
                        taxCreditInfoMedicaid(language)
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
                        healthPlanInfo(language),
                        primaryName,
                        taxCreditInfoMedicaid(language),
                        member0Name,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        member0Name,
                        healthPlanInfo(language),
                        member0Name,
                        taxCreditInfoMedicaidSecondary(language)
                );
                case "Spanish" -> String.format(
                        spanishTemplate + spanishTemplate2,
                        healthFirstChpData(language),
                        primaryName,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        primaryName,
                        healthPlanInfo(language),
                        primaryName,
                        taxCreditInfoMedicaid(language),
                        member0Name,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        member0Name,
                        healthPlanInfo(language),
                        member0Name,
                        taxCreditInfoMedicaidSecondary(language)
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
                    "Medicaid Program) or Child Health Plan Plus (CHP+).\n" +
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

    public static String healthPlanInfo(String language){
        String lceCloseDate = getLceCloseDate(language);
        String currentYear = getCurrentYear();

        return switch (language) {
            case "English"->
                    "Health \n" +
                    "insurance \n" +
                    "plan for " + currentYear + "\n" +
                    "You can purchase a health insurance plan for " + currentYear + ". Log into your Connect for Health \n" +
                    "Colorado account and select a plan that fits your needs.\n" +
                    "Enroll in a plan by " + lceCloseDate + ".\n";
            case "Spanish"->
                    "Plan de\n" +
                    "seguro de\n" +
                    "salud para\n" +
                    currentYear+"\n" +
                    "Puede adquirir un plan de seguro de salud para "+currentYear+". Inicie sesi\u00F3n con su cuenta de\n" +
                    "Connect for Health Colorado y seleccione un plan que se ajuste a sus necesidades.\n" +
                    "Inscr\u00EDbase en un plan antes del "+lceCloseDate+".\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String taxCreditInfoMedicaid(String language){
        String currentYear = getCurrentYear();

        return switch (language) {
            case "English"->
                    "Premium Tax \n" +
                     "Credits or \n" +
                     "You do not qualify for Premium Tax Credits or Cost-Sharing Reduction because:\n" +
                     "You told us you qualify for Health First Colorado or Child Health Plan Plus \n" +
                     "(CHP+)\n" +
                     "Cost-Sharing \n" +
                     "Reduction for \n" +
                     currentYear + "\n";
            case "Spanish"->
                    "Cr\u00E9ditos\n" +
                    "fiscales para\n" +
                    "el pago de la\n" +
                    "cuota o\n" +
                    "No califica para obtener cr\u00E9ditos fiscales para el pago de la cuota ni reducci\u00F3n de los\n" +
                    "costos compartidos porque:\n" +
                    "reducci\u00F3n de\n" +
                    "los costos\n" +
                    "compartidos\n" +
                    "para "+currentYear+"\n" +
                    "Nos dijo que califica para Health First Colorado o Child Health Plan Plus\n" +
                    "(CHP+)\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String taxCreditInfoMedicaidSecondary(String language){
        String currentYear = getCurrentYear();

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

    public static String chpPlus(String language, String memberNumber) {
        String firstOfNextMonth = getFirstOfNextMonth(language);

        String englishTemplate = "%s, it looks like you may qualify for Health First Colorado (Colorado\u2019s %s\n%s, starting as early as %s you are approved for:%s\n%s, you do not qualify for the following:%s\n%s";
        String englishTemplate2 = ", it looks like you may qualify for Health First Colorado (Colorado\u2019s %s\n%s, starting as early as %s you are approved for:%s\n%s, you do not qualify for the following:%s\n%s";
        String spanishTemplate = "%s, por lo visto, podr\u00EDa calificar para Health First Colorado (el programa %s\n%s, a partir del %s usted est\u00E1 aprobado para:%s\n%s, no califica para lo siguiente:%s\n%s";
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
                        healthPlanInfo(language),
                        primaryName,
                        taxCreditInfoChp(language)
                );
                case "Spanish" -> String.format(
                        spanishTemplate,
                        healthFirstChpData(language),
                        primaryName,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        primaryName,
                        healthPlanInfo(language),
                        primaryName,
                        taxCreditInfoChp(language)
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
                        healthPlanInfo(language),
                        primaryName,
                        taxCreditInfoChp(language),
                        member0Name,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        member0Name,
                        healthPlanInfo(language),
                        member0Name,
                        taxCreditInfoChpSecondary(language)
                );
                case "Spanish" -> String.format(
                        spanishTemplate + spanishTemplate2,
                        healthFirstChpData(language),
                        primaryName,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        primaryName,
                        healthPlanInfo(language),
                        primaryName,
                        taxCreditInfoChp(language),
                        member0Name,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        member0Name,
                        healthPlanInfo(language),
                        member0Name,
                        taxCreditInfoChpSecondary(language)
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            default -> throw new IllegalArgumentException("Invalid member number: " + memberNumber);
        };
    }

    public static String taxCreditInfoChp(String language){
        String currentYear = getCurrentYear();

        return switch (language) {
            case "English"->
                    "Premium Tax \n" +
                    "Credits or \n" +
                    "You do not qualify for Premium Tax Credits or Cost-Sharing Reduction because:\n" +
                    "You told us you qualify for Health First Colorado or Child Health Plan Plus \n" +
                    "(CHP+)\n" +
                    "Cost-Sharing \n" +
                    "Reduction for \n" +
                    currentYear + "\n" +
                    "Unless you have an exceptional circumstance, if you are married, you\n" +
                    "must file taxes as married filing jointly\n";
            case "Spanish"->
                    "Cr\u00E9ditos\n" +
                    "fiscales para\n" +
                    "el pago de la\n" +
                    "cuota o\n" +
                    "No califica para obtener cr\u00E9ditos fiscales para el pago de la cuota ni reducci\u00F3n de los\n" +
                    "costos compartidos porque:\n" +
                    "reducci\u00F3n de\n" +
                    "los costos\n" +
                    "compartidos\n" +
                    "para "+currentYear+"\n" +
                    "Nos dijo que califica para Health First Colorado o Child Health Plan Plus\n" +
                    "(CHP+)\n" +
                    "A menos que tenga una circunstancia excepcional, si es casado/a debe\n" +
                    "declarar impuestos como casado que presenta su declaraci\u00F3n en pareja\n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String taxCreditInfoChpSecondary(String language){
        String currentYear = getCurrentYear();

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

    public static String cobra(String language, String memberNumber) {
        String firstOfNextMonth = getFirstOfNextMonth(language);

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
                        healthInsuranceInfo(language),
                        primaryName,
                        cobraInfo(language),
                        primaryName
                );
                case "Spanish" -> String.format(
                        spanishTemplate,
                        firstOfNextMonth,
                        primaryName,
                        healthInsuranceInfo(language),
                        primaryName,
                        cobraInfo(language),
                        primaryName
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            case "2" -> switch (language) {
                case "English" -> String.format(
                        englishTemplate + englishTemplate,
                        firstOfNextMonth,
                        primaryName,
                        healthInsuranceInfo(language),
                        primaryName,
                        cobraInfo(language),
                        primaryName,
                        member0Name,
                        healthInsuranceInfo(language),
                        firstOfNextMonth,
                        member0Name,
                        healthPlanInfo(language),
                        member0Name
                );
                case "Spanish" -> String.format(
                        spanishTemplate + spanishTemplate,
                        firstOfNextMonth,
                        primaryName,
                        healthInsuranceInfo(language),
                        primaryName,
                        cobraInfo(language),
                        primaryName,
                        member0Name,
                        healthFirstInfo(language),
                        firstOfNextMonth,
                        member0Name,
                        healthInsuranceInfo(language),
                        member0Name
                );
                default -> throw new IllegalArgumentException("Invalid language option: " + language);
            };
            default -> throw new IllegalArgumentException("Invalid member number: " + memberNumber);
        };
    }

    public static String healthInsuranceInfo(String language){
        String lceCloseDate = getLceCloseDate(language);
        String currentYear = getCurrentYear();

        return switch (language) {
            case "English"->
                    "Health\n" +
                    "insurance\n" +
                    "plan for "+currentYear+"\n" +
                    "You can purchase a health insurance plan for "+currentYear+". Log into your Connect for Health\n" +
                    "Colorado account and select a plan that fits your needs.\n" +
                    "Enroll in a plan by "+lceCloseDate+". \n";
            case "Spanish"->
                    "Plan de\n" +
                    "seguro de\n" +
                    "salud para\n" +
                    currentYear+"\n" +
                    "Puede adquirir un plan de seguro de salud para "+currentYear+". Inicie sesi\u00F3n con su cuenta de\n" +
                    "Connect for Health Colorado y seleccione un plan que se ajuste a sus necesidades.\n"+
                    "Inscr\u00EDbase en un plan antes del "+lceCloseDate+". \n";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };
    }

    public static String cobraInfo(String language){
        String currentYear = getCurrentYear();

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

    public static String reportToPeak (String docType,String language){
        if(docType.equals("CHP") || docType.equals("Health First Colorado")) {
            return switch (language) {
                case "English" ->
                        "To report changes, log into your PEAK account or call 855-752-6749 or TTY: 855-346-3432. If you do not have a PEAK \n" +
                        "account, you can create one at .Colorado.gov/PEAK\n";
                case "Spanish" ->
                        "Para informar de cambios, ingrese en su cuenta PEAK o llame al 855-752-6749 o TTY: 855-346-3432. Si no tiene\n" +
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
                        "on whether they qualify for Health First Colorado or CHP+. Call 855-752-6749 or TTY: 855-346-3432 for questions \n" +
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
                        "del estado de Colorado para ver si califican para Health First Colorado o CHP+. Llame al 855-752-6749 o TTY: 855-346-\n" +
                        "3432 para obtener respuestas a sus preguntas sobre ayuda financiera disponible a trav\u00E9s Connect for Health Colorado.\n" +
                        "Si los miembros de su familia califican para Health First Colorado o para CHP+ pero no desean esa cobertura, pueden\n" +
                        "optar por inscribirse en un plan de seguro de salud por medio de Connect for Health Colorado.\n" +
                        "Para ver los planes que se ofrecen en su zona, ingrese en su cuenta de Connect for Health Colorado, haga\n"+
                "clic en su resumen de elegibilidad y pulse en \u201Ccontinuar\u201D para ir a las p\u00E1ginas de adquisici\u00F3n.\n";
                default -> throw new IllegalArgumentException("Invalid option: " + language);
            };
        }
        return "";
    }

    public static String getApplicationResultsSpanish(String docType, String language, String memberNumber) {
        String timestamp = getCurrentTimestamp(language);
        String lceCloseDate = getLceCloseDate(language);

        return String.format("ELG-101-01\n" +
                SharedData.getPrimaryMember().getEmailId()+"\n" +
                "N\u00FAmero de Cuenta: "+SharedData.getPrimaryMember().getAccount_id()+"\n" +
                timestamp+" a las \n" +
                "Apreciable "+SharedData.getPrimaryMember().getFullName()+",\n" +
                "Recibimos informaci\u00F3n nueva o actualizada sobre su familia el "+timestamp+". El cambio en la informaci\u00F3n de su\n" +
                "familia se considera un Evento de vida calificado, lo que significa que usted puede inscribirse en un nuevo plan de\n" +
                "seguro de salud o hacer cambios a su plan actual a trav\u00E9s de un Per\u00EDodo de inscripci\u00F3n especial.\n" +
                "Puede inscribirse en un nuevo plan o hacer cambios en su plan actual antes del "+lceCloseDate+".\n" +
                resultsType(docType, language, memberNumber)+
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
                "1. Llame al Centro de atenci\u00F3n al cliente de Connect for Health Colorado\u00AE al 855-752-6749 (TTY:855-346-3432) de\n" +
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
                "Colorado\u00AE al 855-752-6749 (TTY:855-346-3432) de lunes a viernes de 8:00 a.m. a 6:00 p.m.\n" +
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
}
