@TAM
Feature: TAM Chat Widget

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page


  @SLER-101 @ChatWidget
  Scenario: SLER-101 I Navigate to the TAM pages and verify the Chat Widget
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    And I Apply for financial help
    Then I validate I am on the "Employment Income" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "2500000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I validate I am on the "Other Health Insurance" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I open on chat widget
    Then I minimize the chat window

    Then I select "ESI" as health insurance option and continue
    Then I validate I am on the "ESI" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I open on chat widget
    Then I minimize the chat window

    Then I select the Go Back button on the ESI page
    Then I select "None of these" as health insurance option
    Then I select "HRA" as health insurance option and continue
    Then I validate I am on the "HRA" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I open on chat widget
    Then I minimize the chat window

    Then I select the Go Back button on the HRA page
    Then I select "None of these" as health insurance option
    Then I select "Medicare" as health insurance option and continue
    Then I validate I am on the "Medicare" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I open on chat widget
    Then I minimize the chat window

    Then I select the Go Back button on the Medicare page
    Then I select "None of these" as health insurance option
    Then I select "VA Healthcare" as health insurance option and continue
    Then I validate I am on the "VA Healthcare" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I open on chat widget
    Then I minimize the chat window

    Then I select the Go Back button on the VA Healthcare page
    Then I select "None of these" as health insurance option
    Then I select "COBRA" as health insurance option and continue
    Then I validate I am on the "COBRA" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I open on chat widget
    Then I minimize the chat window

    Then I select the Go Back button on the COBRA page
    Then I select "None of these" as health insurance option
    Then I select "Retiree Health Plan" as health insurance option and continue
    Then I validate I am on the "Retiree Health Plan" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I open on chat widget
    Then I minimize the chat window

    Then I select the Go Back button on the Retiree Health Plan page
    Then I select "None of these" as health insurance option
    Then I select "TRICARE" as health insurance option and continue
    Then I validate I am on the "TRICARE" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I open on chat widget
    Then I minimize the chat window

    Then I select the Go Back button on the TRICARE page
    Then I select "None of these" as health insurance option
    Then I select "Peace Corps" as health insurance option and continue
    Then I validate I am on the "Peace Corps" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I open on chat widget
    Then I minimize the chat window

    Then I select the Go Back button on the Peace Corps page
    Then I select "None of these" as health insurance option
    Then I select "Individual Insurance" as health insurance option and continue
    Then I validate I am on the "Individual Insurance" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I open on chat widget
    Then I minimize the chat window

    Then I select the Go Back button on the Individual Insurance page
    And I click on Sign Out in the Header for "NonElmo"
    Then I validate I am on the "Login" page




