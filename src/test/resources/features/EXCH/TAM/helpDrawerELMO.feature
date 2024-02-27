@helpDrawer
Feature: Tests related to the help drawer on ELMO pages

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-60
  Scenario: Validate help drawer text on the ELMO Employment Income Details page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Find Expert Help page
    Then I select "Male" as sex option
    Then I select "Yes" to Are You Applying
    Then I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    Then I select "Yes" for CO Resident option
    Then I select "No" for Federally Recognized Tribe option
    Then I select "No" for Hardship Exemption option
    Then I select "No" for Disability option
    Then I select "No" to the recently denied medicaid question
    Then I select "No" for Incarceration option
    Then I click continue on the Add Address page
    Then I select "Yes" for Citizen option
    Then I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select "General help" icon on the Employment Info Page
    Then I validate help drawer header verbiage in "English"
    Then I validate general help drawer body verbiage in "English"
    Then I validate help drawer footer verbiage in "English"
    And I click Contact Us link in help drawer footer
    And I validate I am on the "We Can Help" page and close tab
    Then I validate help drawer header verbiage in "Spanish"
    Then I validate general help drawer body verbiage in "Spanish"
    Then I validate help drawer footer verbiage in "Spanish"
    And I click Contact Us link in help drawer footer
    And I validate I am on the "Podemos ayudar" page and close tab
    And I select "Do you have job" icon on the Employment Info Page
    Then I validate job question verbiage in "English"
    Then I validate job question verbiage in "Spanish"
    And I select "Is it self-employment" icon on the Employment Info Page
    Then I validate job question verbiage in "Spanish"
    Then I validate job question verbiage in "English"


