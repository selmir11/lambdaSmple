Feature: Navigation - Additional information for yourself page

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-51 @PageNavigationAddInfoForYourself @NVOCoCoRegression
  Scenario: Navigation on the Additional information for yourself page
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
    Then I validate I am on the "CoCo Additional information for yourself" page
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I click Go Back on the Race and Ethnicity page
    Then I validate I am on the "CoCo Additional information for yourself" page
    Then I click Go Back on the additional information for yourself page
    Then I validate I am on the "CoCo Tell us about yourself" page
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page
