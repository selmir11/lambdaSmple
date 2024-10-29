package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages;

import com.c4hco.test.automation.Dto.BrokerDetails;
import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class FindACertifiedBrokerPage {
    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;

    public FindACertifiedBrokerPage(WebDriver webDriver){
        this.basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath ="//h2[@class='row justify-content-center broker-title header-2']")
    WebElement pageTitle;

    @FindBy(id ="findBroker-brokerName-agency-license-input")
    WebElement searchContainer;

    @FindBy(id ="findBroker-city-state-zip-input")
    WebElement searchBrokerLocation;

    @FindBy(xpath ="//input[@aria-autocomplete='list']")
    WebElement searchBrokerLanguage;

    @FindBy(xpath ="//div[contains(text(), 'Preferred Spoken Language')]")
    WebElement searchBrokerLanguageText;

    @FindBy(id ="findBroker-searchBroker-btn")
    WebElement searchButton;

    @FindBy(xpath ="//*[contains(@id, 'mat-expansion-panel-header')]/span/mat-panel-title")
    WebElement moreDetails;

    @FindBy(xpath ="//*[@id='mat-expansion-panel-header-0']/span/mat-panel-title")
    WebElement hideDetails;

    @FindBy(xpath ="//*[@id='agency-manage-account-button']")
    WebElement authorizeBrokerButton;

    @FindBy(id ="terms-checkbox-input")
    WebElement authorizeBrokerTermsCheckbox;

    @FindBy(css =".p-4")
    WebElement over50SearchResultsError;

    @FindBy(id ="total-record-count")
    WebElement totalResultCount;

    @FindBy(xpath ="//div[@class='drop-down-select']")
    WebElement sortDropdown;

    @FindBy(id ="findBroker.option.brokerA_Z-option")
    WebElement sortResultsAZ;

    @FindBy(id ="findBroker.option.brokerZ_A-option")
    WebElement sortResultsZA;

    @FindBy(id ="person-name")
    WebElement brokerDisplayedName;

    @FindBy(id ="agency-name")
    WebElement agencyDisplayedName;

    @FindBy(id ="business-address")
    WebElement agencyAddress;

    @FindBy(id ="broker-business-city-state-zip")
    WebElement agencyCityStateZip;

    @FindBy(id ="email-label")
    WebElement emailLabel;

    @FindBy(xpath ="//*[@id='broker-email']/a")
    WebElement agencyEmail;

    @FindBy(id ="broker-phone-number-label")
    WebElement phoneNumberLabel;

    @FindBy(id ="broker-phone-number")
    WebElement phoneNumber;

    @FindBy(id ="days-available-label")
    WebElement availablityLabel;

    @FindBy(xpath="//*[@id='broker-days-availability']/span")
    WebElement availablityDays;

    @FindBy(id ="hours-label")
    WebElement hoursLabel;

    @FindBy(id ="broker-hours-available")
    WebElement availablityHours;

    @FindBy(id ="license-number-label")
    WebElement licenseNumberLabel;

    @FindBy(id ="broker-license-number")
    WebElement licenseNumber;

    @FindBy(id ="language-label")
    WebElement languageLabel;

    @FindBy(id ="broker-languages-available")
    WebElement availableLanguages;

    @FindBy(id ="findBroker-pageRight-btn")
    WebElement findBrokerPaginationRight;

    @FindBy(id ="findBroker-pageLeft-btn")
    WebElement findBrokerPaginationLeft;

    @FindBy(id ="current-page-num")
    WebElement findBrokerCurrentPage;

    @FindBy(xpath ="//*[@id='findBroker-contact-you']/span[1]")
    WebElement findBrokerContactYouTitle;

    @FindBy(id ="contact-by-broker-link")
    WebElement findBrokerFillOutFormText;

    @FindBy(xpath ="//*[@id='findBroker-contact-you']/span[3]")
    WebElement findBrokerContactYouText;

    @FindBy(id = "BP-FindaCertifiedBrokernearyou-GoBack")
    WebElement findBrokerGoBack;

    @FindBy (id = "broker-organizationName")
    WebElement currentBrokerName;

    @FindBy (id = "broker-license")
    WebElement currentBrokerLicenceNumber;

    @FindBy (id = "broker-exchangeId")
    WebElement currentAgencyName;

    @FindBy(id= "container dashboard-card")
    WebElement changeBrokerContainer;

    @FindBy(xpath= "//div[@class='row justify-content-center header-2 mb-2']")
    WebElement changeBrokerContainerTitle;

    @FindBy(xpath= "//div[@class='mb-4 me-auto ms-auto ng-star-inserted']")
    WebElement changeBrokerContainerWarningText;

    @FindBy(xpath= "//div[@id='client-information-table']/div[2]")
    WebElement brokerPermissionWarningText;

    @FindBy(id= "terms-check-label")
    WebElement brokerAuthorizationTermsText;

    @FindBy(xpath= "//button[@class='col-lg-3 secondary-action-button m-2']")
    WebElement keepCurrentBrokerBtn;

    @FindBy(xpath= "//button[@class='btn col-lg-3 primary-action-button m-2']")
    WebElement authorizeNewBrokerBtn;

    @FindBy (xpath = "//button[.='Continue with my application']")
    WebElement continueWithMyOwn;


    public void FindABrokerPageTitle(String language){
        String ExpectedText = switch (language) {
            case "English" ->
                    "Find a Certified Broker near you";
            case "Spanish" ->
                    "Encuentre un agente certificado cerca de usted";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };

        basicActions.waitForElementToBePresent(pageTitle,30);
        softAssert.assertEquals(pageTitle.getText(), ExpectedText);
        softAssert.assertAll();
    }

    public void searchForBrokerName(String brokerName) {
        basicActions.waitForElementToBePresent(searchContainer,60);
        searchContainer.sendKeys(brokerName);
    }

    public void clearSearchForBroker() {
        basicActions.waitForElementToBePresent(searchContainer,60);
        searchContainer.clear();
    }

    public void searchForBrokerLocation(String location) {
        basicActions.waitForElementToBePresent(searchBrokerLocation,60);
        searchBrokerLocation.sendKeys(location);
    }

    public void searchForBrokerLanguage(String language) {
        basicActions.waitForElementToBePresent(searchBrokerLanguage,60);
        searchBrokerLanguage.sendKeys(language);
        searchBrokerLanguage.sendKeys(Keys.DOWN);
        searchBrokerLanguage.sendKeys(Keys.ENTER);
    }

    public void clearSearchForBrokerLocation() {
        basicActions.waitForElementToBePresent(searchBrokerLocation,60);
        searchBrokerLocation.clear();
    }

    public void clickSearchButton() {
        basicActions.waitForElementToBePresent(searchButton,100);
        searchButton.click();
    }

    public void clickGoBackButton(){
        basicActions.waitForElementToBePresent(findBrokerGoBack, 10);
        findBrokerGoBack.click();
    }

    public void clickMoreDetailsInTheBrokerContainer() {
        basicActions.waitForElementToBePresent(moreDetails,10);
        moreDetails.click();
    }

    public void clickHideDetails() {
        basicActions.waitForElementToBePresent(hideDetails,10);
        hideDetails.click();
    }

    public void clickAuthorizedBroker() {
        SharedData.setHasBroker(true);
        basicActions.waitForElementToBePresent(authorizeBrokerButton,60);
        authorizeBrokerButton.click();
        basicActions.getDriver().findElement(By.id("client-information-table"));
        WebElement test1 = basicActions.getDriver().findElement(By.id("terms-checkbox-input"));
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()",test1 );

        WebElement test2 = basicActions.getDriver().findElement(By.xpath("//span[.='Authorize Broker']"));
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()",test2 );
    }

    public void clickResultsSort(String sortOption) {
        basicActions.waitForElementToBePresent(sortDropdown,100);
        sortDropdown.click();

        switch (sortOption) {
            case "A-Z":
                basicActions.waitForElementToBePresent(sortResultsAZ,100);
                softAssert.assertEquals(sortResultsAZ.getText(),"Name A-Z");
                sortResultsAZ.click();
                break;
            case "Z-A":
                basicActions.waitForElementToBePresent(sortResultsZA,100);
                softAssert.assertEquals(sortResultsZA.getText(),"Name Z-A");
                sortResultsZA.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + sortOption);
        }
    }

    public void validateBrokerDisplayedName(String brokerName){
        basicActions.wait(10);
        basicActions.waitForElementToBePresent(brokerDisplayedName,100);
        softAssert.assertEquals(brokerDisplayedName.getText(),brokerName);
        softAssert.assertAll();
    }

    public void validateAgencyDisplayedName(String agencyName){
        basicActions.wait(10);
        basicActions.waitForElementToBePresent(agencyDisplayedName,100);
        softAssert.assertEquals(agencyDisplayedName.getText(),agencyName);
        softAssert.assertAll();
    }

    public void validateAgencyAddress(String agencyStreetAddress){
        basicActions.waitForElementToBePresent(agencyAddress,100);
        softAssert.assertEquals(agencyAddress.getText(),agencyStreetAddress);
        softAssert.assertAll();
    }

    public void validateAgencyAddressHidden(){
        softAssert.assertFalse(agencyAddress.isDisplayed());
        softAssert.assertAll();
    }

    public void validateAgencyCityStateZip(String cityStateZip){
        basicActions.waitForElementToBePresent(agencyCityStateZip,100);
        softAssert.assertEquals(agencyCityStateZip.getText(),cityStateZip);
        softAssert.assertAll();
    }

    public void validateAgencyDetailsLabels(String language){
        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(emailLabel,100);
                softAssert.assertEquals(emailLabel.getText(),"Email:");
                softAssert.assertEquals(phoneNumberLabel.getText(),"Phone Number:");
                softAssert.assertEquals(availablityLabel.getText(),"Available:");
                softAssert.assertEquals(hoursLabel.getText(),"Hours:");
                softAssert.assertEquals(licenseNumberLabel.getText(),"Colorado License Number:");
                softAssert.assertEquals(languageLabel.getText(),"Languages:");
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(emailLabel,100);
                softAssert.assertEquals(emailLabel.getText(),"Correo electr\u00F3nico:");
                softAssert.assertEquals(phoneNumberLabel.getText(),"Tel\u00E9fono");
                softAssert.assertEquals(availablityLabel.getText(),"Disponible:");
                softAssert.assertEquals(hoursLabel.getText(),"Hours:");
                softAssert.assertEquals(licenseNumberLabel.getText(),"N\u00FAmero de licencia de Colorado:");
                softAssert.assertEquals(languageLabel.getText(),"Idiomas:");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validateAgencyDetails(String emailAddress, String expectedPhoneNumber, String availability, String officeHours, String expectedLicenseNumber, String agencyLanguage){
        basicActions.waitForElementToBePresent(emailLabel,100);
        softAssert.assertEquals(agencyEmail.getText(),emailAddress);
        softAssert.assertEquals(phoneNumber.getText(),expectedPhoneNumber);
        softAssert.assertEquals(availablityDays.getText(),availability);
        softAssert.assertEquals(availablityHours.getText(),officeHours);
        softAssert.assertEquals(licenseNumber.getText(),expectedLicenseNumber);
        softAssert.assertEquals(availableLanguages.getText(),agencyLanguage);
        softAssert.assertAll();
    }

    public void validateAgencyDetailsHidden(){
        String agencyDetailsContainer = basicActions.getDriver().findElement(By.id("cdk-accordion-child-0")).getAttribute("style");
        softAssert.assertEquals(agencyDetailsContainer, "height: 0px; visibility: hidden;");
        softAssert.assertAll();
    }

    public void validateOver50SearchResultsErrorExists(String language){
        String ExpectedText = switch (language) {
            case "English" ->
                    "More than 50 search results were found and only the first 50 are shown. Please enter more specific search criteria if your desired result is not included.";
            case "Spanish" ->
                    "Se encontraron m\u00E1s de 50 resultados en la b\u00FAsqueda y solo se muestran los primeros 50. Si los resultados deseados no han sido incluidos, por favor ingrese criterios de b\u00FAsqueda m\u00E1s espec\u00EDficos.";
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };

        basicActions.waitForElementToBePresent(over50SearchResultsError,30);
        softAssert.assertEquals(over50SearchResultsError.getText(), ExpectedText);
        softAssert.assertAll();
    }

    public void validateOver50SearchResultsErrorDoesNotExist(){
        softAssert.assertFalse(basicActions.waitForElementPresence(over50SearchResultsError,20));
        softAssert.assertAll();
    }

    public void validateTotalBrokerResultCountExists(String expectedCount, String language){
        String englishText = " Agencies or Brokers found";
        String spanishText = " agencias o agentes";

        if(expectedCount.equals("1")){
            englishText = " Agency or Broker found";
            spanishText = " agencia o agente";
        }

        String ExpectedText = switch (language) {
            case "English" ->
                    expectedCount + englishText;
            case "Spanish" ->
                    "Se encontraron " + expectedCount + spanishText;
            default -> throw new IllegalArgumentException("Invalid option: " + language);
        };

        basicActions.waitForElementToBePresent(totalResultCount,30);
        softAssert.assertEquals(totalResultCount.getText(), ExpectedText);
        softAssert.assertAll();
    }

    public void clickRightPaginationArrowButtonFindBroker(int numberTimes){
        basicActions.waitForElementToBePresent(findBrokerPaginationRight,30);
        for(int i=0; i<=numberTimes; i++){
            basicActions.waitForElementToBeClickable(findBrokerPaginationRight,10);
            findBrokerPaginationRight.click();
            basicActions.wait(10);
        }
    }

    public void clickLeftPaginationArrowButtonFindBroker(int numberTimes){
        basicActions.waitForElementToBePresent(findBrokerPaginationLeft,30);
        for(int i=0; i<numberTimes; i++){
            basicActions.waitForElementToBeClickable(findBrokerPaginationLeft,10);
            findBrokerPaginationLeft.click();
            basicActions.wait(10);
        }
    }

    public void verifyCurrentBrokerResultsPage(String currentPage){
        basicActions.waitForElementToBePresent(findBrokerCurrentPage,30);
        basicActions.waitForElementToBeClickable(findBrokerCurrentPage,10);
        softAssert.assertEquals(findBrokerCurrentPage.getText(), currentPage);
        softAssert.assertAll();
    }

    public void validateBrokerContactYouText(String marketplace, String language){
        String market = "";

        switch (marketplace) {
            case "Exch":
                market = "Connect for Health Colorado";
                break;
            case "CoCo":
                market = "Colorado Connect";
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + marketplace);
        }

        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(findBrokerContactYouTitle,100);
                softAssert.assertEquals(findBrokerContactYouTitle.getText(),"Would you rather have a broker contact you instead?");
                softAssert.assertEquals(findBrokerFillOutFormText.getText(),"Fill out this form to have a certified Broker call you within 60 minutes.");
                softAssert.assertEquals(findBrokerContactYouText.getText(),"We will now direct you to our partner website to complete your request to be contacted by one of " + market +"'s certified Brokers.");
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(findBrokerContactYouTitle,100);
                softAssert.assertEquals(findBrokerContactYouTitle.getText(),"\u00BFPrefiere que se comunique con usted un agente certificado?");
                softAssert.assertEquals(findBrokerFillOutFormText.getText(),"Llene este formulario para solicitar que le llame un agente certificado en un plazo de 60 minutos.");
                softAssert.assertEquals(findBrokerContactYouText.getText(),"Le dirigiremos ahora al sitio web de nuestros socios para completar su petici\u00F3n de solicitar que le llame uno de los Asistentes certificados de Connect for Health Colorado");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }

    public void validateButtonAndFieldText(String language){
        switch (language) {
            case "English":
                basicActions.waitForElementToBePresent(searchContainer,30);
                softAssert.assertEquals(searchContainer.getAttribute("placeholder"),"Broker Name, Agency or License # (Optional)");
                softAssert.assertEquals(searchBrokerLocation.getAttribute("placeholder"),"City or State or Zip Code");
                softAssert.assertEquals(searchBrokerLanguageText.getText(),"Preferred Spoken Language(s) (Optional)");
                softAssert.assertEquals(findBrokerGoBack.getText(),"Go Back");
                softAssert.assertEquals(searchButton.getText(),"Search for Broker");
                break;
            case "Spanish":
                basicActions.waitForElementToBePresent(searchContainer,30);
                softAssert.assertEquals(searchContainer.getAttribute("placeholder"),"Nombre, agencia o n\u00FAmero de licencia (Opcional)");
                softAssert.assertEquals(searchBrokerLocation.getAttribute("placeholder"),"Ciudad o estado o c\u00F3digo postal");
                softAssert.assertEquals(searchBrokerLanguageText.getText(),"Preferred Spoken Language(s) (Optional)");
                softAssert.assertEquals(findBrokerGoBack.getText(),"Volver");
                softAssert.assertEquals(searchButton.getText(),"Buscar un agente");
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
        softAssert.assertAll();
    }
    public void setCurrentBrokerContainerDetails (){
        basicActions.waitForElementToBePresent(currentBrokerName,10);
        basicActions.waitForElementToBePresent(currentBrokerLicenceNumber,10);
        basicActions.waitForElementToBePresent(currentAgencyName,10);
        BrokerDetails broker = new BrokerDetails();
        broker.setBroker_name(currentBrokerName.getText());
        broker.setBroker_lic_num(currentBrokerLicenceNumber.getText());
        broker.setAgencyName(currentAgencyName.getText());
        SharedData.setBroker(broker);
    }

    public void clickAuthorizeBrokerButton(){
        basicActions.waitForElementToBePresent(authorizeBrokerButton,60);
        authorizeBrokerButton.click();
    }

    public void validateChangeBrokerText (String newBrokerName, String newBrokerAgency, String currentBrokerName, String currentBrokerAgency){
        basicActions.waitForElementToBePresent(changeBrokerContainer,10);
        basicActions.waitForElementToBePresent(changeBrokerContainerWarningText,60);
        softAssert.assertEquals(changeBrokerContainerTitle.getText(),"Interested in this Broker?");
        softAssert.assertEquals(changeBrokerContainerWarningText.getText(),"By selecting Authorize New Broker, your current broker, " + currentBrokerName + " with " + currentBrokerAgency + " will be deauthorized and " + newBrokerName + " with " + newBrokerAgency + " will be authorized as your new broker.");
        softAssert.assertEquals(brokerPermissionWarningText.getText(),"You need to grant permission before this broker can act on your behalf or access your information.");
        softAssert.assertEquals(brokerAuthorizationTermsText.getText(),"I authorize this broker to have full access to my Colorado Connect accounts");
        softAssert.assertEquals(keepCurrentBrokerBtn.getText(),"Keep Current Broker");
        softAssert.assertEquals(authorizeNewBrokerBtn.getText(),"Authorize New Broker");
        softAssert.assertTrue(keepCurrentBrokerBtn.isEnabled());
        softAssert.assertFalse(authorizeNewBrokerBtn.isEnabled());
        softAssert.assertAll();
    }

    public void clickChangeBrokerOption(String changeBrokerOption) {
        basicActions.waitForElementToBePresent(changeBrokerContainer,10);
        basicActions.waitForElementToBePresent(changeBrokerContainerWarningText,60);
        authorizeBrokerTermsCheckbox.click();
        
        switch (changeBrokerOption){
            case "Keep Current Broker" :
                keepCurrentBrokerBtn.click();
                break;
            case "Authorize New Broker" :
                authorizeNewBrokerBtn.click();
                break;
        }
    }

    public void ClickContinueWithMyApplication() {
        basicActions.waitForElementToBePresent(continueWithMyOwn,30);
        continueWithMyOwn.click();

    }
}
