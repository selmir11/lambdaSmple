Feature: Verify all English and Spanish Text on ELIG pages

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-38 @PageText
  Scenario: Verify all English and Spanish Text on the Let us guide you page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for 2024
    Then I should see the header text "Let us guide you" on Let us guide you page
    And I should see the enrollment info message "If you have never enrolled with us before but have completed an application for Health First Colorado (Colorado's Medicaid Program) or Child Health Plan Plus (CHP+), we can save you time and pull the information you submitted previously. You will have a chance to review and change your information as needed. Would you like to search for a previously completed application?"
    And I should see the case ID info message "You will need your Case ID, which can be found on your Health First Colorado eligibility notice."
    And I should see the yes radio button text "Yes, I’m new to Connect for Health Colorado and I have completed an application for Health First Colorado or Child Health Plan Plus"
    And I should see the no radio button text "No thanks, take me to the application"
    And I should see the text on the Back button "< Back"
    And I should see the text on the Continue button "Save and Continue"

    When I switch to "Spanish"
    Then I should see the header text "Permítanos guiarlo"
    And I should see the enrollment info message in Spanish "Si nunca se ha inscrito con nosotros antes pero ya presentó una solicitud para Health First Colorado (el programa Medicaid de Colorado) o Child Health Plan Plus (CHP+), podemos ahorrarle tiempo y extraer la información que envió antes. Usted tendrá la oportunidad de revisar y cambiar su información según sea necesario. ¿Desea buscar una solicitud previamente completada?"
    And I should see the case ID info message in Spanish "Necesitará su identificación del caso que aparece en su aviso de elegibilidad de Health First Colorado."
    And I should see the yes radio button text in Spanish "Sí, soy nuevo a Connect for Health Colorado y ya presenté una solicitud Health First Colorado or Child Health Plan Plus"
    And I should see the no radio button in Spanish "No gracias, lléveme a la aplicación"
    And I should see the text on the back button in Spanish "< Atrás"
    And I should see the text on the Continue button in Spanish "Guardar y Continuar"


