package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class EthnicityAndRacePage {
    private BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public EthnicityAndRacePage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = "button[role='checkbox'].checkbox-mark")
    List<WebElement> raceEthnicityButton;

    @FindBy(id = "saveAndContinue")
    WebElement saveAndContinue_Button;

    @FindBy(id = "Race Ethnicity-GoBack")
    WebElement goBackButton;

    @FindBy(id = "raceEthnicityTitle")
    WebElement hdrRaceAndEthnicity;

    @FindBy(id = "selectingThisPerson")
    WebElement subHdrRaceAndEthnicity;

    @FindBy(id = "selectAll")
    WebElement selectAllThatApplyText;

    @FindBy(css = ".checkbox-label")
    List<WebElement> RaceAndEthnicityTypesText;

    @FindBy(css = ".subheading-labels")
    List<WebElement> RaceAndEthnicityExamplesText;

    @FindBy(css = "input#notListedReason")
    WebElement notListedReason;

    @FindBy(css = ".error-message")
    WebElement errorMessage;

    @FindBy(css = "svg.feather.feather-alert-circle")
    WebElement alertCircleIcon;

    @FindBy(css = ".checkbox-container")
    List<WebElement> checkboxContainer;

    public void clickGoBackButton() {
        basicActions.waitForElementToBeClickable(goBackButton, 30);
        goBackButton.click();
    }


    public void verifyTextOnEthnicityAndRace(String language) {
        basicActions.waitForElementToBePresent(saveAndContinue_Button, 10);
        switch (language) {
            case "English":
                verifyTextOnEthnicityAndRaceEnglish();
                break;
            case "Spanish":
                verifyTextOnEthnicityAndRaceSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " +language );
        }
    }

    public void verifyErrorMessagesEthnicityAndRace(String language) {
        basicActions.waitForElementToBePresent(errorMessage, 10);
        switch (language) {
            case "English":
                verifyErrorMessagesEthnicityAndRaceEnglish();
                break;
            case "Spanish":
                verifyErrorMessagesEthnicityAndRaceSpanish();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + language);
        }
    }

    public void verifyTextOnEthnicityAndRaceEnglish() {
            softAssert.assertEquals(hdrRaceAndEthnicity.getText(), "Race and Ethnicity: " +
                    Character.toUpperCase(SharedData.getPrimaryMember().getFirstName().charAt(0)) + SharedData.getPrimaryMember().getFirstName().substring(1) + " " +
                    Character.toUpperCase(SharedData.getPrimaryMember().getLastName().charAt(0)) + SharedData.getPrimaryMember().getLastName().substring(1));
            softAssert.assertEquals(hdrRaceAndEthnicity.getCssValue("font-size"), "36px");
            softAssert.assertEquals(hdrRaceAndEthnicity.getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(subHdrRaceAndEthnicity.getText(), "Selecting this person's race and ethnicity helps us improve service to all Coloradans. We use this information to make sure everyone gets fair access to coverage. Providing this information will not impact eligibility, plan options, or costs.");
            softAssert.assertEquals(subHdrRaceAndEthnicity.getCssValue("font-size"), "16px");
            softAssert.assertEquals(subHdrRaceAndEthnicity.getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(selectAllThatApplyText.getText(), "Select all that apply");
            softAssert.assertEquals(selectAllThatApplyText.getCssValue("font-size"), "14px");
            softAssert.assertEquals(selectAllThatApplyText.getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(0).getText(), "Asian or Asian American");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(0).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(1).getText(), "Black or African American");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(1).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(2).getText(), "Hispanic or Latino");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(2).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(3).getText(), "Indigenous or Native American");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(3).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(4).getText(), "Middle Eastern or North African");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(4).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(5).getText(), "Native Hawaiian or Pacific Islander");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(5).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(6).getText(), "White or European");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(6).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(7).getText(), "Not listed");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(7).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(8).getText(), "Prefer not to answer");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(8).getCssValue("font-size"), "20px");
            softAssert.assertEquals(RaceAndEthnicityTypesText.get(8).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(notListedReason.getAttribute("placeholder"), "Your race and ethnicity");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(0).getText(), "Examples: Chinese, Filipino, Japanese, Korean, South Asian, Vietnamese, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(0).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(1).getText(), "Examples: Ethiopian, Haitian, Nigerian, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(1).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(2).getText(), "Examples: Colombian, Cuban, Mexican, Puerto Rican, Salvadoran, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(2).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(3).getText(), "Examples: Alaskan Natives, Blackfeet Tribe, Inupiat Traditional Government, Navajo Nation, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(3).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(4).getText(), "Examples: Egyptian, Iranian, Israeli, Lebanese, Moroccan, Palestinian, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(4).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(5).getText(), "Examples: Chamorro, Guamanian, Samoan, Tongan, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(5).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(6).getText(), "Examples: English, French, German, Irish, Italian, Polish, etc.");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(6).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(7).getText(), "Please fill in the blank with your race and ethnicity");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(7).getCssValue("font-size"), "14px");
            softAssert.assertEquals(RaceAndEthnicityExamplesText.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
            softAssert.assertEquals(goBackButton.getText(), "Go back");
            softAssert.assertEquals(saveAndContinue_Button.getText(), "Save and continue");
            softAssert.assertAll();
        }

    public void verifyTextOnEthnicityAndRaceSpanish() {
        softAssert.assertEquals(hdrRaceAndEthnicity.getText(), "Origen \u00E9tnico y raza: " +
                Character.toUpperCase(SharedData.getPrimaryMember().getFirstName().charAt(0)) + SharedData.getPrimaryMember().getFirstName().substring(1) + " " +
                Character.toUpperCase(SharedData.getPrimaryMember().getLastName().charAt(0)) + SharedData.getPrimaryMember().getLastName().substring(1));
        softAssert.assertEquals(hdrRaceAndEthnicity.getCssValue("font-size"), "36px");
        softAssert.assertEquals(hdrRaceAndEthnicity.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(subHdrRaceAndEthnicity.getText(), "Al seleccionar la raza y el origen \u00E9tnico de esta persona nos ayuda a mejorar el servicio para todos los habitantes de Colorado. Usamos esta informaci\u00F3n para garantizar que todos reciban un acceso justo a la cobertura. Al brindar esta informaci\u00F3n, usted no se ver\u00E1 afectado en cuanto a la elegibilidad, las opciones de los planes o los costos.");
        softAssert.assertEquals(subHdrRaceAndEthnicity.getCssValue("font-size"), "16px");
        softAssert.assertEquals(subHdrRaceAndEthnicity.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(selectAllThatApplyText.getText(), "Seleccione todas las que correspondan");
        softAssert.assertEquals(selectAllThatApplyText.getCssValue("font-size"), "14px");
        softAssert.assertEquals(selectAllThatApplyText.getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(0).getText(), "Asi\u00E1tico o asi\u00E1tico americano");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(0).getCssValue("font-size"), "20px");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(1).getText(), "Raza negra o afroamericano");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(1).getCssValue("font-size"), "20px");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(2).getText(), "Hispano o latino");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(2).getCssValue("font-size"), "20px");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(3).getText(), "Ind\u00EDgena o nativo norteamericano");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(3).getCssValue("font-size"), "20px");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(4).getText(), "del Medio Oriente o del norte de \u00C1frica");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(4).getCssValue("font-size"), "20px");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(5).getText(), "Nativo de Haw\u00E1i u otras islas del Pac\u00EDfico");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(5).getCssValue("font-size"), "20px");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(6).getText(), "Raza blanca o europeo");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(6).getCssValue("font-size"), "20px");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(7).getText(), "No est\u00E1 en la lista");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(7).getCssValue("font-size"), "20px");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(8).getText(), "Prefiero no responder");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(8).getCssValue("font-size"), "20px");
        softAssert.assertEquals(RaceAndEthnicityTypesText.get(8).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(notListedReason.getAttribute("placeholder"), "Su raza y origen \u00E9tnico");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(0).getText(), "Ejemplos: chino, filipino, japon\u00E9s, coreano, del sur de Asia, vietnamita, etc.");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(0).getCssValue("font-size"), "14px");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(0).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(1).getText(), "Ejemplos: et\u00EDope, haitiano, nigeriano, etc.");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(1).getCssValue("font-size"), "14px");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(1).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(2).getText(), "Ejemplos: colombiano, cubano, mexicano, puertorrique\u00F1o, salvadore\u00F1o, etc.");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(2).getCssValue("font-size"), "14px");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(2).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(3).getText(), "Ejemplos: nativos de Alaska, tribu Blackfeet, Gobierno Tradicional Inupiat, Naci\u00F3n Navajo, etc.");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(3).getCssValue("font-size"), "14px");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(3).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(4).getText(), "Ejemplos: egipcio, iran\u00ED, israel\u00ED, liban\u00E9s, marroqu\u00ED, palestino, etc.");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(4).getCssValue("font-size"), "14px");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(4).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(5).getText(), "Ejemplos: chamorro, guame\u00F1o, samoano, tongano, etc.");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(5).getCssValue("font-size"), "14px");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(5).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(6).getText(), "Ejemplos: ingl\u00E9s, franc\u00E9s, alem\u00E1n, irland\u00E9s, italiano, polaco, etc.");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(6).getCssValue("font-size"), "14px");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(6).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(7).getText(), "Complete el espacio en blanco con su raza y origen \u00E9tnico");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(7).getCssValue("font-size"), "14px");
        softAssert.assertEquals(RaceAndEthnicityExamplesText.get(7).getCssValue("color"), "rgba(43, 49, 60, 1)");
        softAssert.assertEquals(goBackButton.getText(), "Volver");
        softAssert.assertEquals(saveAndContinue_Button.getText(), "Guardar y continuar");
        softAssert.assertAll();
    }

    public void verifyErrorMessagesEthnicityAndRaceEnglish() {
        softAssert.assertEquals(errorMessage.getText(), "Please select one or more of the options below");
        softAssert.assertTrue(alertCircleIcon.isDisplayed());
        raceEthnicityButton.get(7).click();
        saveAndContinue_Button.click();
        softAssert.assertEquals(errorMessage.getText(), "Please enter your race and ethnicity");
        softAssert.assertTrue(alertCircleIcon.isDisplayed());
        raceEthnicityButton.get(7).click();
        softAssert.assertAll();
    }

    public void verifyErrorMessagesEthnicityAndRaceSpanish() {
        softAssert.assertEquals(errorMessage.getText(), "Seleccione una o m\u00E1s de las opciones siguientes");
        softAssert.assertTrue(alertCircleIcon.isDisplayed());
        raceEthnicityButton.get(7).click();
        saveAndContinue_Button.click();
        softAssert.assertEquals(errorMessage.getText(), "Por favor ingrese/indique su raza y origen \u00E9tnico");
        softAssert.assertTrue(alertCircleIcon.isDisplayed());
        raceEthnicityButton.get(7).click();
        softAssert.assertAll();
    }

    public void validateTextBoxInputAndCheckboxSelection() {
        for (int i = 0; i < 8; i++) {
            raceEthnicityButton.get(i).click();
        }

        //More than 1 option can be selected (up to 8), except 'Prefer not to answer'
        //If 'Prefer not to answer' is selected, then all other options will be unselected
        for (int i = 0; i < 8; i++) {
            if (!checkboxContainer.get(i).getAttribute("class").contains("checked")) {
                throw new AssertionError("Race and Ethnicity option " + (i + 1) + " is not selected.");
            }
        }

        raceEthnicityButton.get(8).click();

        if (!checkboxContainer.get(8).getAttribute("class").contains("checked")) {
            throw new AssertionError("Prefer not to answer option 7 is not selected.");
        }

        for (int i = 0; i < 8; i++) {
            if (checkboxContainer.get(i).getAttribute("class").contains("checked")) {
                throw new AssertionError("Race and Ethnicity option " + (i + 1) + " is selected, but it shouldn't be.");
            }
        }
        //Text box accepts up to 50 characters. Allowing commas, hyphens, slashes, and spaces
        raceEthnicityButton.get(7).click();
        notListedReason.sendKeys("user,- /input");
        softAssert.assertEquals(notListedReason.getAttribute("value"), "user,- /input");
        notListedReason.clear();
        notListedReason.sendKeys("user$5@1-input");
        softAssert.assertEquals(notListedReason.getAttribute("value"), "user-input");
        notListedReason.clear();
        notListedReason.sendKeys("characterscharacterscharacterscharacterscharacterscharacters");
        softAssert.assertEquals(notListedReason.getAttribute("value"), "characterscharacterscharacterscharacterscharacters");
        notListedReason.clear();
        raceEthnicityButton.get(7).click();
        softAssert.assertAll();
    }

    public void clickSaveAndContinue() {
        basicActions.waitForElementToBeClickable(saveAndContinue_Button, 30);
        saveAndContinue_Button.click();
    }

    public void selectNotListedAndEnterCustomText(String customText) {
        basicActions.waitForElementListToBePresent(raceEthnicityButton, 10);
        raceEthnicityButton.get(7).click();
        basicActions.waitForElementToBePresent(notListedReason, 10);
        notListedReason.sendKeys(customText);
    }



    public void raceEthnicitySelectionMembers(String raceEthnicity, String memPrefix){
        basicActions.waitForElementListToBePresent(raceEthnicityButton, 40);
        switch (raceEthnicity) {
            case "Asian or Asian American":
                raceEthnicityButton.get(0).click();
                break;
            case "Black or African American":
                raceEthnicityButton.get(1).click();
                break;
            case "Hispanic or Latino":
                raceEthnicityButton.get(2).click();
                break;
            case "Indigenous or Native American":
                raceEthnicityButton.get(3).click();
                break;
            case "Middle Eastern or North African":
                raceEthnicityButton.get(4).click();
                break;
            case "Native Hawaiian or Pacific Islander":
                raceEthnicityButton.get(5).click();
                break;
            case "White or European":
                raceEthnicityButton.get(6).click();
                break;
            case "Not listed":
                raceEthnicityButton.get(7).click();
                break;
            case "Prefer not to answer":
                raceEthnicityButton.get(8).click();
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + raceEthnicity);
        }
        setRaceAndEthnicity(raceEthnicity, memPrefix);
        setMemberID();
    }
    private void setRaceAndEthnicity(String raceEthnicity, String memPrefix){
          List<MemberDetails> members = basicActions.getAllMem();
          members.stream().filter(member -> member.getFirstName().contains(memPrefix)).findFirst().ifPresent(member-> member.setRace(raceEthnicity));
        }

    private void setMemberID() {
        List<MemberDetails> memberDetailsList = SharedData.getMembers();
        MemberDetails subscriber = SharedData.getPrimaryMember();

        String currentUrl = basicActions.getCurrentUrl();
        String headerText = hdrRaceAndEthnicity.getText();
        String nameFromHeader = headerText.substring(headerText.indexOf(':') + 1).trim();
        String memberId = currentUrl.substring(currentUrl.lastIndexOf('/') + 1);
        if (nameFromHeader.equals(SharedData.getPrimaryMember().getFullName())) {
            SharedData.setPrimaryMemberId(memberId);
            subscriber.setMemberId(memberId);
        }
        if (memberDetailsList != null && !memberDetailsList.isEmpty()) {
            for (MemberDetails member : memberDetailsList) {
                if (nameFromHeader.equals(member.getFullName())) {
                    member.setMemberId(memberId);
                    break;
                }
            }
            SharedData.setMembers(memberDetailsList);
        }
    }

    }