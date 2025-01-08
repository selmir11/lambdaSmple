package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.LoginPortalPages;

import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.LoginCredentials;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CreateAccountPage {
    SoftAssert softAssert = new SoftAssert();

    @FindBy(css = " a > label")
    WebElement helpIcon;

    @FindBy(css = ".drawer-contents .drawer-body .drawer-text-content p")
    List<WebElement> helpDrawerText;

    @FindBy(xpath="//a[contains(@class, 'btn')]")
    WebElement closeHelpIcon;

    @FindBy(xpath = "//p[contains(text(),'Connect for Health Colorado es el mercado oficial ')]")
     WebElement helpDrawerTextSP;

    @FindBy(xpath = "//em[@class='fas fa-question-circle']")
     WebElement helpDrawerButton;

    @FindBy(css = ".boot-input-group .help-label")
    WebElement helpLabel;

    @FindBy(xpath = "//input[@id='fn']")
     WebElement firstName;

    @FindBy(id = "fn-label")
     WebElement firstNameText;

    @FindBy(xpath = "//lib-input-error[@uniqueerrorid='fn-mf-error']")
    WebElement firstNameErrorMessage;
    @FindBy(id = "fn-error")
    WebElement firstNameErrorMessageAssistNet;

    @FindBy(id = "mn-label")
     WebElement middleNameText;

    @FindBy(xpath = "//input[@id='mn']")
    WebElement middleName;

    @FindBy(xpath = "//span[@id='mn-error']")
    WebElement middleNameErrorMessage;
    @FindBy(id = "mn-error")
    WebElement middleNameErrorMessageAssistNet;

    @FindBy(xpath = "//input[@id='ln']")
     WebElement lastName;

    @FindBy(css = "div:nth-child(4) > label:nth-child(1)")
     WebElement lastNameText;

    @FindBy(xpath = "//lib-input-error[@uniqueerrorid='ln-mf-error']")
    WebElement lastNameErrorMessage;
    @FindBy(id = "ln-error")
    WebElement lastNameErrorMessageAssistNet;

    @FindBy(id = "email")
     WebElement email;
    @FindBy(id = "email-label")
     WebElement emailText;

    @FindBy(xpath = "//lib-input-error[@uniqueerrorid='em-mf-error']")
    WebElement emailErrorMessage;
    @FindBy(id = "em-error")
    WebElement emailErrorMessageAssistNet;

    @FindBy(id = "phone")
     WebElement phoneNumber;
    @FindBy(id = "phone-label")
     WebElement phoneNumberTxt;

    @FindBy(xpath = "//lib-input-error[@uniqueerrorid='ph-mf-error']")
    WebElement phoneNumberErrorMessage;
    @FindBy(id = "ph-error")
    WebElement phoneNumberErrorMessageAssistNet;

    @FindBy(id = "password")
     WebElement password;
    @FindBy(id = "password-label")
     WebElement passwordText;

    @FindBy(xpath = "//lib-input-error[@uniqueerrorid='pw-mf-error']")
    WebElement passwordErrorMessage;

    @FindBy(id = "confirm-password")
     WebElement confirmPassword;
    @FindBy(id = "confirm-password-label")
     WebElement confirmPasswordTxt;

    @FindBy(xpath = "//lib-input-error[@uniqueerrorid='cp-mf-error']")
    WebElement confirmPasswordErrorMessage;
    @FindBy(id = "cp-error")
    WebElement confirmPasswordErrorMessageAssistNet;

    @FindBy(xpath = "//span[@id='ls-mf-error']")
    WebElement languageErrorMessage;

    @FindBy(id = "English")
     WebElement preferredLanguageButtonEnglish;
    @FindBy(id = "Spanish")
     WebElement preferredLanguageButtonSpanish;

    @FindBy(xpath = "//lib-list-error[@uniqueerrorid='ahp-mf-error']")
    WebElement accountHolderPreferencesErrorMessage;

    @FindBy(id = "pu-input")
     WebElement primaryUserCheckbox;

    @FindBy(id = "rr-input")
    WebElement onBehalfOfPrimaryUserCheckbox;

    @FindBy(xpath = "//lib-list-error[@uniqueerrorid='miso-mf-error']")
    WebElement informationSharingOptionsErrorMessage;

    @FindBy(id = "cocoUser-input")
     WebElement cocoTermsOfUseCheckbox;

    @FindBy(id = "exchUser-input")
     WebElement exchangeTermsOfUseCheckbox;

    @FindBy(id = "submit-button")
     WebElement submitButton;
    @FindBy(css = " div.forgot-email-header")
     WebElement headerCreateAccount;
    @FindBy(xpath = "//*[@class='input-label form-label']//span")
     WebElement preferredLanguageTxt;
    @FindBy(xpath = "(//label[@class='mdc-label'])[1]")
     WebElement primaryAccountHolderTxt;
    @FindBy(xpath= "(//label[@class='mdc-label'])[2]")
     WebElement cSRTxt;
    @FindBy(xpath= "(//span[@class='body-text-2'])[2]")
     WebElement headerTxt;
    @FindBy(xpath= "//span[@class='body-text-1']")
     WebElement optionTxt;
    @FindBy(xpath= "(//label[@class='mdc-label'])[3]")
     WebElement c4OptionTxt;
    @FindBy(xpath= "(//label[@class='mdc-label'])[4]")
     WebElement cocoOptionTxt;

    @FindBy(xpath = "//span[@class='banner-error-message']")
    WebElement bannerErrorMessage;

    @FindBy(id = "role")
    WebElement roleDropdown;
    @FindBy(xpath = "//select[@id='role']/option[2]")
    WebElement assistNetOption;

    @FindBy(xpath = "//select[@id='role']/option[2]")
    WebElement certifiedBrokerRole;

    @FindBy(xpath = "//*[@id='role']/app-option-select-dropdown/div/div[2]/div[2]")
    WebElement adminStaffRole;

    @FindBy(xpath = "//span[@id='role-dropdown-mf-error']")
    WebElement roleDropdownErrorMessage;

    @FindBy(id = "loginPortal-createAccount-indicatePrimary")
    WebElement primaryUserErrorMessage;

    @FindBy(id = "mat-mdc-checkbox-2-input")
    WebElement termsOfUseCheckbox;

    @FindBy(id = "loginPortal-createAccount-termsRead")
    WebElement termsOfUseErrorMessage;
    @FindBy(xpath = "//lib-input[@id='invitation']//span")
    WebElement invitationErrorMsg;
    @FindBy(xpath = "//*[@id=\"x_programManagerActivateAccountNoticeBody\"]/p[3]/span")
    WebElement invitationPMCode;
    @FindBy(xpath = "//input[@id='invitation']")
    WebElement invitationCodeInput;



    private BasicActions basicActions;
    public CreateAccountPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void clickHelpIcon(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(helpIcon, 20));
        basicActions.waitForElementToBeClickable(helpIcon, 20);
        helpIcon.click();
        basicActions.waitForElementToDisappear(helpIcon, 10);
    }

    public void closeHelpIcon(){
       softAssert.assertTrue(basicActions.waitForElementToBePresent(closeHelpIcon, 20));
        basicActions.waitForElementToBePresent(closeHelpIcon, 60);
        basicActions.waitForElementToBeClickable(closeHelpIcon, 60);
        closeHelpIcon.click();
        basicActions.waitForElementToBePresent(helpLabel, 60);
    }

    public void clickHelpIconButton(){
        basicActions.waitForElementToBeClickable(helpDrawerButton,1000);
        helpDrawerButton.click();
    }

    public static CharSequence generatePhoneNumber(){
        Random rand = new Random();
        int num1 = (rand.nextInt(7)+1)*100;
        int num2 = rand.nextInt(743);
        int num3 = rand.nextInt(10000);
        DecimalFormat df3 = new DecimalFormat("000");
        DecimalFormat df4 = new DecimalFormat("0000");
        String phoneNumber = df3.format(num1) + "-" + df3.format(num2) + "-" + df4.format(num3);
        return phoneNumber;
    }

    public void createGeneralAccount(String appType){
        addDetails();
        selectBasedOnApp(appType);
    }

    public void createAccountForScript(String appType, String script){
        addDetailsForScript(script);
        selectBasedOnApp(appType);
    }

    public void createSpecificAccount(String fName, String mName, String lName, String appType){
        addSpecificDetails(fName, mName, lName);
        selectBasedOnApp(appType);
    }

    public void createGeneralAccountOutlook(String appType, String emailBase){
        addDetailsOutlook(emailBase);
        selectBasedOnApp(appType);
    }

    private void selectBasedOnApp(String appType){
        SharedData.setAppType(appType);
        basicActions.waitForElementToBePresent(cocoTermsOfUseCheckbox,10);
        switch(appType){
            case "coco":
                cocoTermsOfUseCheckbox.click();
                break;
            case "exchange":
                exchangeTermsOfUseCheckbox.click();
                break;
            case "exchange Spanish":
            exchangeTermsOfUseCheckbox.click();
            preferredLanguageButtonSpanish.click();
            break;
            case "Admin exchange":
                onBehalfOfPrimaryUserCheckbox.click();
                exchangeTermsOfUseCheckbox.click();
                break;
            case "Admin coco":
                onBehalfOfPrimaryUserCheckbox.click();
                cocoTermsOfUseCheckbox.click();
                break;
            case "coco Spanish":
                cocoTermsOfUseCheckbox.click();
                preferredLanguageButtonSpanish.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + appType);
        }
        submitButton.click();
    }


    public void initializeData(){
        MemberDetails subscriber = new MemberDetails();
        subscriber.setFirstName("PrimaryMember"+basicActions.getUniqueString(8));
        subscriber.setLastName(basicActions.capitalizeFirstLetter(basicActions.getUniqueString(8)+"Test"));
        subscriber.setEmailId("AutomationUser."+subscriber.getLastName()+"@test.com");
        subscriber.setPhoneNumber((String) generatePhoneNumber());
        subscriber.setIsSubscriber("Y");
        SharedData.setPrimaryMember(subscriber);
    }


    public void initializeDataOutlook(String emailBase){
        MemberDetails subscriber = new MemberDetails();
        subscriber.setFirstName("Primary"+ basicActions.getUniqueString(6));
        subscriber.setLastName(basicActions.capitalizeFirstLetter(basicActions.getUniqueString(7)+"Test"));
        subscriber.setEmailId(emailBase+"+"+subscriber.getLastName()+"@outlook.com");
        subscriber.setPhoneNumber((String) generatePhoneNumber());
        subscriber.setIsSubscriber("Y");
        SharedData.setPrimaryMember(subscriber);
    }
    public void initializeDataGmail(String emailBase){
        MemberDetails subscriber = new MemberDetails();
        subscriber.setFirstName(basicActions.capitalizeFirstLetter(basicActions.getUniqueString(10)+"TestMember"));
        subscriber.setLastName(basicActions.capitalizeFirstLetter(basicActions.getUniqueString(10)+"Test"));
        subscriber.setEmailId(emailBase+"+"+subscriber.getLastName()+"@gmail.com");
        subscriber.setPhoneNumber((String) generatePhoneNumber());
        subscriber.setIsSubscriber("Y");
        SharedData.setPrimaryMember(subscriber);
    }

    public void initializeSpecificData(String fName, String mName, String lName){
        MemberDetails subscriber = new MemberDetails();
        List<MemberDetails> allMembersList = new ArrayList<>();
        subscriber.setFirstName(fName);
        subscriber.setMiddleName(mName);
        subscriber.setLastName(lName);
        subscriber.setEmailId("AutomationUser."+subscriber.getLastName()+"."+basicActions.getUniqueString(6)+"@test.com");
        subscriber.setPhoneNumber((String) generatePhoneNumber());
        subscriber.setIsSubscriber("Y");
        SharedData.setPrimaryMember(subscriber);
        allMembersList.add(subscriber);
        SharedData.setAllMembers(allMembersList);
    }

    private void addDetailsForScript(String scriptNum){
        initializeDataForScript(scriptNum);
        sendDetails();
    }

    private void initializeDataForScript(String scriptNum){
        LoginCredentials.setScriptBasedDetails(scriptNum);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setEmailId("AutomationUser."+basicActions.getUniqueString(8)+"@test.com");
        subscriber.setPhoneNumber((String) generatePhoneNumber());
        subscriber.setIsSubscriber("Y");
        SharedData.setPrimaryMember(subscriber);
    }

    public void addDetails(){
        initializeData();
        sendDetails();
    }

    public void sendDetails(){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        basicActions.waitForElementToBePresent(firstName, 60);
        basicActions.waitForElementToBePresent(phoneNumber, 60);
        firstName.sendKeys(subscriber.getFirstName());
        lastName.sendKeys(subscriber.getLastName());
        email.sendKeys(subscriber.getEmailId());
        phoneNumber.sendKeys(subscriber.getPhoneNumber());
        String primaryPhone = subscriber.getPhoneNumber().replaceAll("-", "");
        subscriber.setPhoneNumber(primaryPhone);
        password.sendKeys(subscriber.getPassword());
        confirmPassword.sendKeys(subscriber.getPassword());
        subscriber.setSignature(subscriber.getFirstName()+" "+subscriber.getLastName());
        subscriber.setFullName(subscriber.getFirstName()+" "+subscriber.getLastName());
        subscriber.setCompleteFullName(subscriber.getFirstName()+" "+subscriber.getLastName()); // WIP
        preferredLanguageButtonEnglish.click();
        subscriber.setSpokenLanguage("English");
        subscriber.setWrittenLanguage("English");
        subscriber.setRelation_to_subscriber("SELF");
        primaryUserCheckbox.click();
        SharedData.setPrimaryMember(subscriber);
    }

    public void addDetailsOutlook(String emailBase){
        initializeDataOutlook(emailBase);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        basicActions.waitForElementToBePresent(firstName, 60);
        firstName.sendKeys(subscriber.getFirstName());
        lastName.sendKeys(subscriber.getLastName());
        email.sendKeys(subscriber.getEmailId());
        phoneNumber.sendKeys(subscriber.getPhoneNumber());
        String primaryPhone = subscriber.getPhoneNumber().replaceAll("-", "");
        subscriber.setPhoneNumber(primaryPhone);
        password.sendKeys(subscriber.getPassword());
        confirmPassword.sendKeys(subscriber.getPassword());
        subscriber.setSignature(subscriber.getFirstName()+" "+subscriber.getLastName());
        subscriber.setFullName(subscriber.getFirstName()+" "+subscriber.getLastName());
        subscriber.setCompleteFullName(subscriber.getFirstName()+" "+subscriber.getLastName()); // WIP
        preferredLanguageButtonEnglish.click();
        subscriber.setSpokenLanguage("English");
        subscriber.setWrittenLanguage("English");
        primaryUserCheckbox.click();
        subscriber.setRelation_to_subscriber("SELF");
        SharedData.setPrimaryMember(subscriber);
    }

    public void addSpecificDetails(String fName, String mName, String lName){
        initializeSpecificData(fName, mName, lName);
        MemberDetails subscriber = SharedData.getPrimaryMember();
        basicActions.waitForElementToBePresent(firstName, 60);
        firstName.sendKeys(subscriber.getFirstName());
        middleName.sendKeys(subscriber.getMiddleName());
        lastName.sendKeys(subscriber.getLastName());
        email.sendKeys(subscriber.getEmailId());
        phoneNumber.sendKeys(subscriber.getPhoneNumber());
        password.sendKeys(subscriber.getPassword());
        confirmPassword.sendKeys(subscriber.getPassword());
        subscriber.setSignature(subscriber.getFirstName()+" "+subscriber.getLastName());
        subscriber.setFullName(subscriber.getFirstName()+" "+subscriber.getLastName());
        subscriber.setCompleteFullName(subscriber.getFirstName()+" "+subscriber.getLastName()); // WIP
        preferredLanguageButtonEnglish.click();

        primaryUserCheckbox.click();
        subscriber.setRelation_to_subscriber("SELF");
        SharedData.setPrimaryMember(subscriber);
    }

    public void createGeneralAccountGmail(String appType, String emailBase){
        // Creates the primary user/Account holder
        addGmailDetails(emailBase);
        selectBasedOnApp(appType);
    }
    public void addGmailDetails(String emailBase){
            initializeDataGmail(emailBase);
            sendDetails();
    }

    public void createBrokerAccount(String accountType, String emailBase){
        // Creates a Broker Portal account
        initializeBrokerData(accountType, emailBase);
        BrokerDetails user;
        roleDropdown.click();
        switch(accountType){
            case "Agency Owner":
                user = SharedData.getAgencyOwner();
                certifiedBrokerRole.click();
                addBrokerDetails(user);
                break;
            case "Broker":
                user = SharedData.getBroker();
                certifiedBrokerRole.click();
                addBrokerDetails(user);
                break;
            case "Admin Staff":
                user = SharedData.getAdminStaff();
                adminStaffRole.click();
                addBrokerDetails(user);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + accountType);
        }
        submitButton.click();
    }

    public static CharSequence generateBrokerLicense(){
        Random rand = new Random();
        int num = rand.nextInt(10000);
        DecimalFormat df4 = new DecimalFormat("00000000");
        return df4.format(num);
    }

    public void initializeBrokerData(String accountType, String emailBase){
        BrokerDetails user = new BrokerDetails();
        user.setFirstName(basicActions.capitalizeFirstLetter(basicActions.getUniqueString(8)+"TestBroker"));
        user.setLastName(basicActions.capitalizeFirstLetter(basicActions.getUniqueString(8)+"Test"));
        user.setEmail(emailBase+"+"+user.getLastName()+"@outlook.com");
        user.setPhoneNumber((String) generatePhoneNumber());
        user.setLicense((String) generateBrokerLicense());
        switch(accountType){
            case "Agency Owner":
                SharedData.setAgencyOwner(user);
                break;
            case "Broker":
                SharedData.setBroker(user);
                break;
            case "Admin Staff":
                SharedData.setAdminStaff(user);
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + accountType);
        }
    }

    public void addBrokerDetails(BrokerDetails user){
        basicActions.waitForElementToBePresent(firstName, 60);
        firstName.sendKeys(user.getFirstName());
        lastName.sendKeys(user.getLastName());
        email.sendKeys(user.getEmail());
        phoneNumber.sendKeys(user.getPhoneNumber());
        password.sendKeys(user.getPassword());
        confirmPassword.sendKeys(user.getPassword());
        primaryUserCheckbox.click();
        termsOfUseCheckbox.click();
    }

    public void validateHelpText(String language){
        switch(language) {
        case "English":
            validateHelpVerbiage();
            break;
        case "Spanish":
            validateHelpVerbiageSP();
            break;
        default:
            throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    // ############################## VALIDATION METHODS #########################

    public void validateHelpVerbiage(){
        basicActions.waitForElementToBePresent(helpDrawerText.get(0), 30);
        softAssert.assertEquals(helpDrawerText.get(0).getText(), "Connect for Health Colorado and Colorado Connect are committed to protecting your privacy and will keep the information you provide private as required by law.");
        softAssert.assertEquals(helpDrawerText.get(1).getText(), "Connect for Health Colorado");
        softAssert.assertEquals(helpDrawerText.get(3).getText(), "Customers who apply through Connect for Health Colorado may be subject to eligibility verification, including information matching with state and federal partners. Personal information, including information about immigration status, cannot be used for immigration enforcement.");
        softAssert.assertEquals(helpDrawerText.get(4).getText(), "Colorado Connect");
        softAssert.assertEquals(helpDrawerText.get(5).getText(), "Colorado Connect was created by Connect for Health Colorado to help more Coloradans enroll in health insurance. Starting in 2023, people who are undocumented can access health insurance through Colorado Connect. Financial help is also available for those who qualify. Personal information of customers who choose to share information only with Colorado Connect is stored separately from Connect for Health Colorado. Your personal information is not shared with federal partners for any purpose and cannot be used for immigration enforcement.");
        softAssert.assertAll();
    }

    public void validateHelpVerbiageSP() {
        basicActions.waitForElementToBePresent(helpDrawerTextSP, 60);
        softAssert.assertEquals(helpDrawerTextSP.getText(),"Connect for Health Colorado es el mercado oficial de seguros de salud de Colorado. Desde 2013, Connect for Health ha estado ayudando a individuos, familias, y peque\u00f1as empresas a comparar planes, solicitar ayuda financiera y adquirir seguros de salud.");
        softAssert.assertAll();
    }

    public void verifyCreateYourAccountHeader(String language) {
        basicActions.waitForElementToBePresent(headerCreateAccount,30);
        switch (language){
            case "English":
                softAssert.assertEquals(headerCreateAccount.getText(),"Create your Account");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(headerCreateAccount.getText(),"Crear su cuenta");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }


    public void verifyFieldHeaders(String language) {
        switch(language){
            case "English":
                softAssert.assertEquals(firstNameText.getText(),"First Name");
                softAssert.assertEquals(middleNameText.getText(),"Middle Name");
                softAssert.assertEquals(lastNameText.getText(),"Last Name");
                softAssert.assertEquals(emailText.getText(),"Email (This will be your Username)");
                softAssert.assertEquals(phoneNumberTxt.getText(),"Phone Number");
                softAssert.assertEquals(passwordText.getText(),"Password");
                softAssert.assertEquals(confirmPasswordTxt.getText(),"Confirm Password");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(firstNameText.getText(),"Nombre");
                softAssert.assertEquals(middleNameText.getText(),"Segundo nombre");
                softAssert.assertEquals(lastNameText.getText(),"Apellido");
                softAssert.assertEquals(emailText.getText(),"Correo electr\u00F3nico (Este ser\u00E1 su nombre de usuario)");
                softAssert.assertEquals(phoneNumberTxt.getText(),"Tel\u00E9fono");
                softAssert.assertEquals(passwordText.getText(),"Contrase\u00F1a");
                softAssert.assertEquals(confirmPasswordTxt.getText(),"Confirmar contrase\u00F1a");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyAccountHolderPreferences(String language) {
        basicActions.waitForElementToBePresent(preferredLanguageTxt,30);
        switch(language){
                case "English":
                    softAssert.assertEquals(preferredLanguageTxt.getText(),"Preferred Written Language");
                    softAssert.assertEquals(primaryAccountHolderTxt.getText(),"I am the primary user/account holder");
                    softAssert.assertEquals(cSRTxt.getText(),"I am a registered Customer Service Center Representative or Authorized Representative and have the authority to act on behalf on this individual");
                    softAssert.assertAll();
                    break;
                case "Spanish":
                    softAssert.assertEquals(preferredLanguageTxt.getText(),"Idioma escrito que prefiere");
                    softAssert.assertEquals(primaryAccountHolderTxt.getText(),"Soy el usuario principal/titular de la cuenta");
                    softAssert.assertEquals(cSRTxt.getText(),"Soy un representante registrado del Centro de atenci\u00F3n al cliente o representante autorizado y tengo la autoridad para actuar en nombre de esta persona");
                    softAssert.assertAll();
                    break;
                default:
                    throw new IllegalArgumentException("Invalid option: " + language);
            }
    }
    public void verifyInformationSharingOptions(String language) {
        switch(language){
            case "English":
                softAssert.assertEquals(headerTxt.getText(),"My Information Sharing Options");
                softAssert.assertEquals(optionTxt.getText(),"Please select one of the options below");
                softAssert.assertEquals(c4OptionTxt.getText(),"I want to share my information with Connect for Health Colorado, Colorado's official Affordable Care Act Marketplace. I agree to the Connect for Health Colorado Terms of Use and Privacy Policy. (This is the right choice for most customers.)");
                softAssert.assertEquals(cocoOptionTxt.getText(),"I want to share my information with Colorado Connect, a partner of Connect for Health Colorado that provides health insurance options for people who are undocumented. I agree to the Colorado Connect Terms of Use and Privacy Policy.");
                softAssert.assertAll();
                break;

            case "Spanish":
                softAssert.assertEquals(headerTxt.getText(),"Opciones para compartir mi informaci\u00F3n");
                softAssert.assertEquals(optionTxt.getText(),"Seleccione una de las siguientes opciones");
                softAssert.assertEquals(c4OptionTxt.getText(),"Deseo compartir mi informaci\u00F3n con Connect for Health Colorado, el Mercado oficial de la Ley del Cuidado de Salud a Bajo Precio (ACA) en Colorado. Acepto los T\u00E9rminos de uso y la Pol\u00EDtica de privacidad de Connect for Health Colorado. (Esta es la opci\u00F3n correcta para la mayor\u00EDa de nuestros clientes.)");
                softAssert.assertEquals(cocoOptionTxt.getText(),"Deseo compartir mi informaci\u00F3n con Colorado Connect, socio de Connect for Health Colorado que proporciona opciones de seguro de salud para personas indocumentadas. Acepto los T\u00E9rminos de uso y la Pol\u00EDtica de privacidad de Connect for Health Colorado.");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);}
    }

    public void duplicateAccWithNewEmail(String appType){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        basicActions.waitForElementToBePresent(firstName, 10);
        firstName.sendKeys(subscriber.getFirstName());
        lastName.sendKeys(subscriber.getLastName());
        subscriber.setIncorrectEmail(subscriber.getEmailId());
        String newEmail = basicActions.getUniqueString(8)+"oldMem@test.com";
        SharedData.setOldAccountId(subscriber.getAccount_id());
        subscriber.setEmailId(newEmail);
        email.sendKeys(newEmail);
        phoneNumber.sendKeys(subscriber.getPhoneNumber());
        password.sendKeys(subscriber.getPassword());
        confirmPassword.sendKeys(subscriber.getPassword());
        preferredLanguageButtonEnglish.click();
        primaryUserCheckbox.click();
        SharedData.setPrimaryMember(subscriber);
        selectBasedOnApp(appType);
    }

    public void enterDuplicateAccountCreationData(String appType){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        basicActions.waitForElementToBePresent(firstName, 10);
        firstName.sendKeys(subscriber.getFirstName());
        lastName.sendKeys(subscriber.getLastName());
        email.sendKeys(subscriber.getEmailId());
        phoneNumber.sendKeys(subscriber.getPhoneNumber());
        password.sendKeys(subscriber.getPassword());
        confirmPassword.sendKeys(subscriber.getPassword());
        preferredLanguageButtonEnglish.click();
        primaryUserCheckbox.click();
        selectBasedOnApp(appType);
    }

    public void enterDuplicateBrokerAccountCreationData(){
        BrokerDetails agencyOwner = SharedData.getAgencyOwner();
        basicActions.waitForElementToBePresent(firstName, 10);
        roleDropdown.click();
        certifiedBrokerRole.click();
        firstName.sendKeys(agencyOwner.getFirstName());
        lastName.sendKeys(agencyOwner.getLastName());
        email.sendKeys(agencyOwner.getEmail());
        phoneNumber.sendKeys(agencyOwner.getPhoneNumber());
        password.sendKeys(agencyOwner.getPassword());
        confirmPassword.sendKeys(agencyOwner.getPassword());
        primaryUserCheckbox.click();
        termsOfUseCheckbox.click();

        submitButton.click();
    }

    public void validateAccountExistsErrorMessage(String language){
        basicActions.waitForElementToBePresent(bannerErrorMessage, 10);
        switch(language){
            case "English":
                softAssert.assertEquals(bannerErrorMessage.getText(),"Sorry, we're unable to proceed with this email. Please double-check and try again.");
                softAssert.assertAll();
                break;
            case "Spanish":
                softAssert.assertEquals(bannerErrorMessage.getText(),"Lo sentimos, no se puede proceder con este correo electr\u00F3nico. Verif\u00EDquelo y vuelva a intentarlo.");
                softAssert.assertAll();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void validateMandatoryFieldErrorMessages(String language){
        basicActions.waitForElementToBePresentWithRetries(submitButton, 10);
        submitButton.click();

        switch(language){
            case "English":
                softAssert.assertEquals(firstNameErrorMessage.getText(),"First Name is required");
                softAssert.assertEquals(lastNameErrorMessage.getText(), "Last Name is required");
                softAssert.assertEquals(emailErrorMessage.getText(), "Email is required");
                softAssert.assertEquals(phoneNumberErrorMessage.getText(), "Phone number is required");
                softAssert.assertEquals(passwordErrorMessage.getText(), "Password is required");
                softAssert.assertEquals(confirmPasswordErrorMessage.getText(), "Please Confirm Password");
                break;
            case "Spanish":
                softAssert.assertEquals(firstNameErrorMessage.getText(),"El nombre es obligatorio");
                softAssert.assertEquals(lastNameErrorMessage.getText(), "El apellido es obligatorio");
                softAssert.assertEquals(emailErrorMessage.getText(), "El correo electr\u00F3nico es obligatorio");
                softAssert.assertEquals(phoneNumberErrorMessage.getText(), "El n\u00FAmero de tel\u00E9fono es obligatorio");
                softAssert.assertEquals(passwordErrorMessage.getText(), "Se requiere su contrase\u00F1a");
                softAssert.assertEquals(confirmPasswordErrorMessage.getText(), "Favor de confirmar contrase\u00F1a");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validateMandatoryOptionsErrorMessages(String language){
        basicActions.waitForElementToBePresent(submitButton, 10);
        submitButton.click();

        switch(language){
            case "English":
                softAssert.assertEquals(languageErrorMessage.getText(), "Preferred written language is required");
                softAssert.assertEquals(accountHolderPreferencesErrorMessage.getText(), "Please select one of the options below");
                softAssert.assertEquals(informationSharingOptionsErrorMessage.getText(), "Please select one of the options below");
                break;
            case "Spanish":
                softAssert.assertEquals(languageErrorMessage.getText(), "El Idioma escrito que prefiere es obligatorio");
                softAssert.assertEquals(accountHolderPreferencesErrorMessage.getText(), "Seleccione una de las siguientes opciones.");
                softAssert.assertEquals(informationSharingOptionsErrorMessage.getText(), "Seleccione una de las siguientes opciones.");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validatePhoneFieldLettersNotAllowed(){
        basicActions.waitForElementToBePresent(phoneNumber, 10);
        phoneNumber.clear();
        phoneNumber.sendKeys("ABCDefghij");

        softAssert.assertEquals(phoneNumber.getAttribute("value"), "(");
        softAssert.assertAll();
    }

    public void validateSpecialCharactersErrorMessage(String language){
        basicActions.waitForElementToBePresent(firstName, 10);
        firstName.sendKeys("12345-ABCD-!@#$");
        middleName.sendKeys("12345-ABCD-!@#$");
        lastName.sendKeys("12345-ABCD-!@#$");
        email.sendKeys("12345-ABCD-!@#$");
        phoneNumber.sendKeys("2");
        confirmPassword.sendKeys("ALaka12!");

        switch(language){
            case "English":
                softAssert.assertEquals(firstNameErrorMessage.getText(),"First Name cannot contain special characters");
                softAssert.assertEquals(middleNameErrorMessage.getText(),"Middle Name cannot contain special characters");
                softAssert.assertEquals(lastNameErrorMessage.getText(), "Last Name cannot contain special characters");
                softAssert.assertEquals(emailErrorMessage.getText(), "A valid Email is required");
                softAssert.assertEquals(phoneNumberErrorMessage.getText(), "Please enter valid phone number");
                softAssert.assertEquals(confirmPasswordErrorMessage.getText(), "Password does not match");
                break;
            case "Spanish":
                softAssert.assertEquals(firstNameErrorMessage.getText(),"El nombre no puede incluir caracteres especiales");
                softAssert.assertEquals(middleNameErrorMessage.getText(),"El segundo nombre no puede incluir caracteres especiales");
                softAssert.assertEquals(lastNameErrorMessage.getText(), "El apellido no puede incluir caracteres especiales");
                softAssert.assertEquals(emailErrorMessage.getText(), "Es obligatorio un correo electr\u00F3nico v\u00E1lido");
                softAssert.assertEquals(phoneNumberErrorMessage.getText(), "Ingrese un n\u00FAmero de tel\u00E9fono v\u00E1lido");
                softAssert.assertEquals(confirmPasswordErrorMessage.getText(), "La contrase\u00F1a no coincide");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validateSpecialCharactersErrorAssistNetMessage(String language){
        basicActions.waitForElementToBePresent(firstName, 10);
        firstName.sendKeys("12345-ABCD-!@#$");
        middleName.sendKeys("12345-ABCD-!@#$");
        lastName.sendKeys("12345-ABCD-!@#$");
        email.sendKeys("12345-ABCD-!@#$");
        phoneNumber.sendKeys("2");
        confirmPassword.sendKeys("ALaka12!");

        switch(language){
            case "English":
                softAssert.assertEquals(firstNameErrorMessageAssistNet.getText(),"First Name cannot contain special characters");
                softAssert.assertEquals(middleNameErrorMessageAssistNet.getText(),"Middle Name cannot contain special characters");
                softAssert.assertEquals(lastNameErrorMessageAssistNet.getText(), "Last Name cannot contain special characters");
                softAssert.assertEquals(emailErrorMessageAssistNet.getText(), "A valid Email is required");
                softAssert.assertEquals(phoneNumberErrorMessageAssistNet.getText(), "Please enter valid phone number");
                softAssert.assertEquals(confirmPasswordErrorMessageAssistNet.getText(), "Password does not match");
                break;
            case "Spanish":
                softAssert.assertEquals(firstNameErrorMessageAssistNet.getText(),"El nombre no puede incluir caracteres especiales");
                softAssert.assertEquals(middleNameErrorMessageAssistNet.getText(),"El segundo nombre no puede incluir caracteres especiales");
                softAssert.assertEquals(lastNameErrorMessageAssistNet.getText(), "El apellido no puede incluir caracteres especiales");
                softAssert.assertEquals(emailErrorMessageAssistNet.getText(), "Es obligatorio un correo electr\u00F3nico v\u00E1lido");
                softAssert.assertEquals(phoneNumberErrorMessageAssistNet.getText(), "Ingrese un n\u00FAmero de tel\u00E9fono v\u00E1lido");
                softAssert.assertEquals(confirmPasswordErrorMessageAssistNet.getText(), "La contrase\u00F1a no coincide");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validatePasswordMinimumCharacterErrorMessage(String language){
        basicActions.waitForElementToBePresent(password, 10);
        password.clear();
        password.sendKeys("Aa1");

        switch(language){
            case "English":
                softAssert.assertEquals(passwordErrorMessage.getText(),"Password must have at least 8 characters");
                break;
            case "Spanish":
                softAssert.assertEquals(passwordErrorMessage.getText(),"La contrase\u00F1a debe tener al menos 8 caracteres");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validatePasswordUppercaseErrorMessage(String language){
        basicActions.waitForElementToBePresent(password, 10);
        password.clear();
        password.sendKeys("12345678");

        switch(language){
            case "English":
                softAssert.assertEquals(passwordErrorMessage.getText(),"Password must have at least 1 uppercase");
                break;
            case "Spanish":
                softAssert.assertEquals(passwordErrorMessage.getText(),"La contrase\u00F1a debe tener al menos una may\u00FAscula");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validatePasswordLowercaseErrorMessage(String language){
        basicActions.waitForElementToBePresent(password, 10);
        password.clear();
        password.sendKeys("ABCDEFGH1");

        switch(language){
            case "English":
                softAssert.assertEquals(passwordErrorMessage.getText(),"Password must have at least 1 lowercase");
                break;
            case "Spanish":
                softAssert.assertEquals(passwordErrorMessage.getText(),"La contrase\u00F1a debe tener al menos una min\u00FAscula");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validatePasswordNumberErrorMessage(String language){
        basicActions.waitForElementToBePresent(password, 10);
        password.clear();
        password.sendKeys("abcdefgh");

        switch(language){
            case "English":
                softAssert.assertEquals(passwordErrorMessage.getText(),"Password must have at least 1 number");
                break;
            case "Spanish":
                softAssert.assertEquals(passwordErrorMessage.getText(),"La contrase\u00F1a debe tener al menos 1 n\u00FAmero");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validatePasswordUsernameErrorMessage(String language){
        basicActions.waitForElementToBePresent(password, 10);
        email.clear();
        password.clear();
        email.sendKeys("test@test.com");
        password.sendKeys("AA1test!aa");

        switch(language){
            case "English":
                softAssert.assertEquals(passwordErrorMessage.getText(),"Password cannot contain 4 or more consecutive characters of your username");
                break;
            case "Spanish":
                softAssert.assertEquals(passwordErrorMessage.getText(),"La contrase\u00F1a no puede contener 4 o m\u00E1s caracteres consecutivos de su nombre de usuario");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validatePasswordFirstNameErrorMessage(String language){
        basicActions.waitForElementToBePresent(password, 10);
        firstName.clear();
        password.clear();
        firstName.sendKeys("FirstName");
        password.sendKeys("FirstName1");

        switch(language){
            case "English":
                softAssert.assertEquals(passwordErrorMessage.getText(),"Password cannot contain first name");
                break;
            case "Spanish":
                softAssert.assertEquals(passwordErrorMessage.getText(),"La contrase\u00F1a no puede incluir el nombre");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validateMandatoryCheckboxErrorMessages(String language){
        basicActions.waitForElementToBePresent(submitButton, 10);
        submitButton.click();

        switch(language){
            case "English":
                softAssert.assertEquals(primaryUserErrorMessage.getText(), "Please indicate you are the primary user");
                softAssert.assertEquals(termsOfUseErrorMessage.getText(), "Please read the terms of use and select the checkbox to agree");
                break;
            case "Spanish":
                softAssert.assertEquals(primaryUserErrorMessage.getText(), "Por favor indique que es el usuario principal");
                softAssert.assertEquals(termsOfUseErrorMessage.getText(), "Lea los T\u00E9rminos de uso y marque la casilla para aceptarlas");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validateMandatoryBrokerRoleErrorMessage(String language){
        basicActions.waitForElementToBePresent(submitButton, 10);
        submitButton.click();

        switch(language){
            case "English":
                softAssert.assertEquals(roleDropdownErrorMessage.getText(), "Role is required");
                break;
            case "Spanish":
                softAssert.assertEquals(roleDropdownErrorMessage.getText(), "La funci\u00F3n que desempe\u00F1a es obligatoria");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void EnterPasswordInCreateAccountPage() {
        password.sendKeys("ALaska12!");
        confirmPassword.sendKeys("ALaska12!");
    }

    public void validateTheInvitationCodeErrorMessageOnAssistNetPageIn(String language) {
        switch (language){
            case "English":
                softAssert.assertEquals(invitationErrorMsg.getText(),"Invitation code is required");
                break;
                case "Spanish":
                softAssert.assertEquals(invitationErrorMsg.getText(),"El C\u00F3digo de invitaci\u00F3n es obligatorio");
                break;
        }

    }

    public void completeMandatoryDataForProgramManagerAccountCreation() {
        basicActions.waitForElementToBePresentWithRetries(roleDropdown,30);
        roleDropdown.click();
        assistNetOption.click();
        basicActions.waitForElementToBePresent(invitationCodeInput,30);
        invitationCodeInput.sendKeys(SharedData.getAssisterDetails().getProgramManagerInviteCode());
        firstName.sendKeys(SharedData.getAssisterDetails().getFirstName());
        lastName.sendKeys(SharedData.getAssisterDetails().getLastName());
        email.sendKeys(SharedData.getAssisterDetails().getEmail());
        phoneNumber.sendKeys(SharedData.getAssisterDetails().getPhoneNumber());
        password.sendKeys(SharedData.getAssisterDetails().getPassword());
        confirmPassword.sendKeys(SharedData.getAssisterDetails().getPassword());
        primaryUserCheckbox.click();
        termsOfUseCheckbox.click();
        submitButton.click();


    }

    public void savedTheInvitationCodeForTheNewProgramManagerAccount() {
        basicActions.waitForElementToBePresentWithRetries(invitationPMCode,30);
        SharedData.getAssisterDetails().setProgramManagerInviteCode( invitationPMCode.getText());
    }

    public void enterDuplicateDataForProgramManagerAccountCreation() {
        basicActions.waitForElementToBePresentWithRetries(roleDropdown,30);
        roleDropdown.click();
        assistNetOption.click();
        basicActions.waitForElementToBePresent(invitationCodeInput,30);
        invitationCodeInput.sendKeys(SharedData.getAssisterDetails().getProgramManagerInviteCode());
        firstName.sendKeys(SharedData.getAssisterDetails().getFirstName());
        lastName.sendKeys(SharedData.getAssisterDetails().getLastName());
        email.sendKeys(SharedData.getAssisterDetails().getEmail());
        phoneNumber.sendKeys(SharedData.getAssisterDetails().getPhoneNumber());
        password.sendKeys(SharedData.getAssisterDetails().getPassword());
        confirmPassword.sendKeys(SharedData.getAssisterDetails().getPassword());
        primaryUserCheckbox.click();
        termsOfUseCheckbox.click();
        submitButton.click();
    }
}
