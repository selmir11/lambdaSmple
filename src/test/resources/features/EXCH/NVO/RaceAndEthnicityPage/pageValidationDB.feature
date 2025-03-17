Feature: Page Validation Database - Race And Ethnicity page

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-900 @PageValidationDBRaceAndEthnicity @NVOExchRegression
  Scenario: Database validation for Race And Ethnicity Page
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
    And I report "LostCoverage" and click continue
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
    Then I validate I am on the "Race and Ethnicity" page
    And I select Not listed for race and ethnicity and enter "MixedRace" in the text box
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    And I validate "Other" race and "MixedRace" other text in the database
    And I validate I am on the "Employment Income" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I select "Not listed" for race and ethnicity for "Primary"
    And I select "Indigenous or Native American" for race and ethnicity for "Primary"
    And I select "Native Hawaiian or Pacific Islander" for race and ethnicity for "Primary"
    And I select Not listed for race and ethnicity and enter "Multiracial" in the text box
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I wait for 1000 milliseconds
    And I validate "American_Indian_Alaskan_Native,Native_Hawaiian_Pacific_Islander,Other" race and "Multiracial" other text in the database
    Then I click Go back on the Citizenship page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click Go back on the Race and Ethnicity page
    Then I validate I am on the "Additional Information for Yourself" page
    And I validate "American_Indian_Alaskan_Native,Native_Hawaiian_Pacific_Islander,Other" race and "Multiracial" other text in the database
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I validate I am on the "Family Overview" page
    And I validate "Prefer_No_Answer" race and "null" other text in the database
    And I click on Sign Out in the Header for "NonElmo"
    Then I validate I am on the "Login" page