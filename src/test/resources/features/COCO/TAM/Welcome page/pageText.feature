Feature: Page Text-Welcome Page

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-33-WIP @PageTextWelcomePageEnglish
  Scenario: Create CoCo Account and Login
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CoCo Welcome" page

    Then I verify text on the Welcome page for first time signed into an account in "English"
    Then I verify text on the "CoCo" "Header" in "English"
    Then I verify text on the "CoCo" "Footer" in "English"
    Then I click on My Profile Button CoCo
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy

    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

  @SLCR-33-WIP @PageTextWelcomePageSpanish
  Scenario: Create CoCo Account and Login
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CoCo Welcome" page
    And I change the language from header to "Spanish"

    Then I verify text on the Welcome page for first time signed into an account in "Spanish"
    Then I verify text on the "CoCo" "Header" in "Spanish"
    Then I verify text on the "CoCo" "Footer" in "Spanish"











