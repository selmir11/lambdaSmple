Feature: Page Text-Additional information for yourself page

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-52 @PageTextAddInfoForYourself @NVOCoCoRegression
  Scenario: Verify Additional information for yourself Page Text in English
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    And I click Primary EditUpdate on the Family Overview page
    And I enter details on tell us about yourself page and continue with "01011991", "Female", and applying "Yes"
    Then I validate I am on the "CoCo Additional information for yourself" page
    And I select "No" for mailing address option
    Then I verify text on the Additional information for yourself page in "English"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I enter my mailing address "4321 Road", "Colorado Springs", "CO", "80916", "EL PASO"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "CoCo Ethnicity and Race" page
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page