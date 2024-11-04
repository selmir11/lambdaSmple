Feature: Spanish- Tell us about yourself page

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-89 @NVOCoCoRegression
  Scenario: Spanish Text navigation Validation on the Tell us about yourself page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    And  I change the language from header to "Spanish"
    Then I validate errors are displaying on Tell Us About Yourself Page CoCo "Spanish"
    Then I enter first name and last name on Tell Us About Yourself Page Coco
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option
    And I click save and continue on the Race and Ethnicity page
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
    And I change the language from header to "English"
    And I select continue on the income Summary CoCo page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Wife", "03051989", "Male", and applying "Yes"
      | Primary:Spouse |
    And I change the language from header to "Spanish"
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I validate I am on the "CoCo Tell us about yourself" page
    And I validate the page text on Tell us about Yourself "Spanish"
    Then I click Save and Continue only on the tell us about yourself page
    Then I validate I am on the "CoCo Additional information for yourself" page
    Then I click Go Back on the additional information for yourself page

 
