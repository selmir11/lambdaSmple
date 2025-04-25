Feature: My Profile Page Coco

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-644 @NVOCoCoRegression
  Scenario: My Profile Save button-Page Validation Coco
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    And I wait for 2000 milliseconds
    And I validate Email save changes on My Profile page CoCo
    And I wait for 2000 milliseconds
    Then I validate I am on the "My Profile" page
    And I wait for 2000 milliseconds
    And I validate phone number save changes on My Profile page CoCo
    Then I validate I am on the "My Profile" page
    And I wait for 3000 milliseconds
    And I validate Preferred Language save changes on My Profile page CoCo
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo

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
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
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
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    And I select "Birth" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page

    And I wait for 3000 milliseconds
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    And I validate Preferred Contact Method save changes on My Profile page CoCo

    #Email error validation
    Then I validate I am on the "My Profile" page
    And I wait for 5000 milliseconds
    And I validate Email error message in "English" on my Profile Page CoCo
    And I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    And I change the language from header to "Spanish"
    And I validate Email error message in "Spanish" on my Profile Page CoCo
    And I click on Sign Out in the Header for "Elmo"


  @SLCR-646 @NVOCoCoRegression
  Scenario: My Profile edit fields-Page Validation Coco
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    And I validate error messages "English" on My Profile page CoCo
    And I change the language from header to "Spanish"
    And I validate error messages "Spanish" on My Profile page CoCo
    And I change the language from header to "English"
    And I click on Sign Out in the Header for "Elmo"
