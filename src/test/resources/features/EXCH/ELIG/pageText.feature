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
    Then I validate I am on the "Let us guide you" page
    And I should see the following text on the Let us guide you page "Let us guide you"
    And I should see the following text on the Let us guide you page "If you have never enrolled with us before"
    And I should see the following text on the Let us guide you page "You will need your Case ID, which can be found on your Health First Colorado eligibility notice."
    And I should see the following text on the Let us guide you page "I have completed an application for Health First Colorado or Child Health Plan Plus"
    And I should see the following text on the Let us guide you page "No thanks, take me to the application"
    And I should see the following text on the Let us guide you page "< Back"
    And I should see the following text on the Let us guide you page "Save and Continue"

    When I switch to "Spanish"
    And I validate I am on the "Spanish" page
    And I should see the following text on the Let us guide you page "guiarlo"
    And I should see the following text on the Let us guide you page "Si nunca se ha inscrito con nosotros antes pero ya"
    And I should see the following text on the Let us guide you page "Necesitar"
    And I should see the following text on the Let us guide you page "soy nuevo a Connect for Health Colorado y ya"
    And I should see the following text on the Let us guide you page "No gracias"
    And I should see the following text on the Let us guide you page "< Atr"
    And I should see the following text on the Let us guide you page "Guardar y Continuar"

  @SLER-47 @PageText
  Scenario: Verify all English and Spanish Text on Enter Case Info page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for 2024
    Then I validate I am on the "Let us guide you" page
    And I select Yes, I'm new to Connect for Health Colorado option
    And I click on save and continue button
    Then I validate I am on the "Enter Case ID" page
    And I should see the following text on the Enter Case ID page "Please fill out the following information found on your Health First Colorado denial notice"
    And I should see the following text on the Enter Case ID page "Case ID"
    And I should see the following text on the Enter Case ID page "1BXXXXXX"
    And I should see the following text on the Enter Case ID page "Zip Code"
    And I should see the following text on the Enter Case ID page "XXXXX"
    And I should see the following text on the Enter Case ID page "Last Name"
    And I should see the following text on the Enter Case ID page ""
    And I should see the following text on the Enter Case ID page "< Back"
    And I should see the following text on the Enter Case ID page "Save and Continue"

    When I switch to "Spanish"
    Then I validate I am on the "Spanish" page
    And I should see the following text on the Enter Case ID page "Anote la siguiente"
    And I should see the following text on the Enter Case ID page "Identificaci"
    And I should see the following text on the Enter Case ID page "1BXXXXXX"
    And I should see the following text on the Enter Case ID page "XXXXX"
    And I should see the following text on the Enter Case ID page "Apellido(s)"
    And I should see the following text on the Enter Case ID page "digo postal"
    And I should see the following text on the Enter Case ID page ""
    And I should see the following text on the Enter Case ID page "< Atr"
    And I should see the following text on the Enter Case ID page "Guardar y Continuar"
