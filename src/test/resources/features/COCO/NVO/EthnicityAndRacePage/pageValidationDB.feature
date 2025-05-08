Feature: Page Validation Database - Race And Ethnicity page

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-252 @PageValidationDBRaceAndEthnicity @NVOCoCoRegression
  Scenario: Database validation for Race And Ethnicity Page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    And I enter details on tell us about yourself page and continue with "01011991", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select Not listed for race and ethnicity option and enter "Mixed Race" in the text box for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I validate "Other" race and "Mixed Race" other text in the database
    Then I click EditUpdate on Family Overview page for "Primary"
    And I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Not listed" for race and ethnicity option for "Primary"
    And I select "Indigenous or Native American" for race and ethnicity option for "Primary"
    And I select "Native Hawaiian or Pacific Islander" for race and ethnicity option for "Primary"
    And I select Not listed for race and ethnicity option and enter "Multiracial" in the text box for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I wait for 5000 milliseconds
    And I validate "American_Indian_Alaskan_Native,Native_Hawaiian_Pacific_Islander,Other" race and "Multiracial" other text in the database
    And I click Go back on the Employment income page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click Go Back on the Race and Ethnicity page
    Then I validate I am on the "CoCo Additional information for yourself" page
    And I validate "American_Indian_Alaskan_Native,Native_Hawaiian_Pacific_Islander,Other" race and "Multiracial" other text in the database
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I wait for 3000 milliseconds
    And I validate "Prefer_No_Answer" race and "null" other text in the database
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page