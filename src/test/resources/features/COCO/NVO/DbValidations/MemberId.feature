@NVOCoCoRegression
Feature: Coco user - Db Validations related to member id

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page

  @SLCR-701
    Scenario: Validate exch_person_id related details in DB for an individual after navigating past tell us about yourself page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    And I get the account Id from my profile page coco
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11282015", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate the exch_person_id related fields from db for a new member after tell us about yourself page
    And I click on Sign Out in the Header for "Elmo"

  @SLCR-702
  Scenario: Validate exch_person_id related details in DB for an existing individual after navigating past tell us about yourself page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    And I get the account Id from my profile page coco
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11282015", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I click on Sign Out in the Header for "Elmo"

    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter duplicate data for account creation for "coco" with new email
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    And I get the account Id from my profile page coco
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11282015", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate the exch_person_id related fields from db for a duplicate member after tell us about yourself page
    And I click on Sign Out in the Header for "Elmo"

  @SLCR-703
  Scenario: Validate exch_person_id related details in DB for an individual right after creating an account
    Then I validate the exch_person_id related fields to be null
    And I click on Sign Out in the Header for "Elmo"

  @SLCR-704
  Scenario: Validate exch_person_id related details for specific individual after navigating past tell us about yourself page
    And I enter general mandatory data for "coco" account creation for the script "SLCR-704"
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    And I get the account Id from my profile page coco
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "getFromSharedData"
    Then I enter details on tell us about yourself page and continue with "getFromSharedData", "getFromSharedData", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate the exch_person_id related fields from db for a specific member after tell us about yourself page
    And I click on Sign Out in the Header for "Elmo"
