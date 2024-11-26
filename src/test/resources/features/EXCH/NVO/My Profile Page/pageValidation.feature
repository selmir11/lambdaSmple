Feature: My profile page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-127 @NVOExchRegression
  Scenario: My Profile Save button-Page Validation
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I validate Email save changes on My Profile page
    Then I validate I am on the "My Profile" page
    And I validate phone number save changes on My Profile page
    Then I validate I am on the "My Profile" page
    And I validate Preferred Language save changes on My Profile page
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile Exch
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
    And I click on My Account in the "Elmo" Header
    And I click on the Username Link Exch
    Then I validate I am on the "My Profile" page
    And I validate Preferred Contact Method save changes on My Profile page


  @SLER-969 @NVOExchRegression
  Scenario: My Profile Email Error validation
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
    And I click on the Username in the "Exch" Header
    Then I validate I am on the "My Profile" page
    And I validate Email save changes on My Profile page
    And I wait for 9000 milliseconds
    And I validate Email error message in "English" on my Profile Page
    Then I validate initial email remains in the database
    Then I click on Go back to Welcome page Button on My Profile Exch
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Profile"
    And I change the language from header to "Spanish"
    And I validate Email error message in "Spanish" on my Profile Page

  @SLER-1267 @NVOExchRegression
  Scenario: My Profile edit fields-Page Validation
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I validate error messages "English" on My Profile page
    And I change the language from header to "Spanish"
    And I validate error messages "Spanish" on My Profile page
    And I change the language from header to "English"


