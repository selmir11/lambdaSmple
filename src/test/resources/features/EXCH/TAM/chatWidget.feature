@TAM @TAMSmokeExch @TamExch
Feature: TAM Chat Widget

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
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
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page

  @SLER-101 @ChatWidget
  Scenario: SLER-101 I Navigate to the TAM pages and verify the Chat Widget
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
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "2500000" at frequency "Annually"
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
    Then I validate I am on the "Tax status" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    And I validate I am on the "Other Health Coverage" page
    And I verify the header for "Primary" Member on the Other Health Coverage page in "English"
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I select "job" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Ohc ESI" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I select the Go Back button on the ESI page
    Then I select "None of these" as health coverage option
    Then I select "HRA" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "HRA" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I click Go Back on the OHC HRA page
    Then I select "None of these" as health coverage option
    Then I select "Medicare" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Ohc Medicare" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I click Go Back on the OHC Medicare page
    Then I select "None of these" as health coverage option
    Then I select "VA Health Care" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Ohc VA Healthcare" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I click Go Back on the OHC VA Healthcare page
    Then I select "None of these" as health coverage option
    Then I select "COBRA" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Ohc COBRA" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I click Go Back on the OHC Cobra page
    Then I select "None of these" as health coverage option
    Then I select "Retiree Health Plan" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Ohc Retiree" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I click Go Back on the OHC Retiree page
    Then I select "None of these" as health coverage option
    Then I select "TRICARE" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Ohc Tricare" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I click Go Back on the OHC Tricare page
    Then I select "None of these" as health coverage option
    Then I select "Peace Corps" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Ohc Peace Corps" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I click Go Back on the OHC Peace Corps page
    Then I select "None of these" as health coverage option
    Then I select "Other" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Ohc Individual Insurance" page
    Then I validate chat widget is present
    Then I open on chat widget
    Then I minimize the chat window

    Then I click Go Back on the OHC Individual Insurance page
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page




