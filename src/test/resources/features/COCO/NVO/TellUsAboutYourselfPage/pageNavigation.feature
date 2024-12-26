Feature: Navigation - Tell us about yourself page

  Background: I go the login portal
    Given I open the login page on the "login" portal
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

  @SLCR-37 @PageNavigationTellUsAboutYourself @NVOCoCoRegression
  Scenario: Navigation on the Tell us about yourself page
    And I enter details on tell us about yourself page and continue with "01011991", "Female", and applying "Yes"
    Then I validate I am on the "CoCo Additional information for yourself" page
    Then I click Go Back on the additional information for yourself page
    And I click Go Back on the tell us about yourself page
    Then I validate I am on the "CoCo Family Overview" page

  @SLCR-664
  Scenario: Validate the data is saved on tell us about yourself page for new account - coco
    And I enter the primary member middle name on tell us about yourself page coco
    And I enter the primary member suffix as "Sr." on tell us about yourself page coco
    And I enter details on tell us about yourself page with dob "01011991", gender "Female", and applying "Yes"
    Then I click Save and Continue only on the tell us about yourself page
    Then I validate I am on the "CoCo Additional information for yourself" page
    Then I click Go Back on the additional information for yourself page
    Then I validate I am on the "CoCo Tell us about yourself" page
    Then I validate the data entered is saved on tell us about yourself page
    Then I validate the data entered on tell us about yourself page is saved in DB
    And I click on Sign Out in the Header for "Elmo"

  @SLCR-666
  Scenario: Validate the data is saved on tell us about yourself page for existing account - coco
    Then I validate I am on the "CoCo Tell us about yourself" page
    And I enter the primary member middle name on tell us about yourself page coco
    And I enter the primary member suffix as "Sr." on tell us about yourself page coco
    And I enter details on tell us about yourself page with dob "01011991", gender "Female", and applying "Yes"
    Then I click Save and Continue only on the tell us about yourself page
    And I click on Sign Out in the Header for "Elmo"

    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I validate I am on the "CoCo Tell us about yourself" page
    Then I enter new first name and last name on Tell Us About Yourself Page Coco
    And I enter the primary member new middle name on tell us about yourself page coco
    And I enter the primary member suffix as "Jr." on tell us about yourself page coco
    And I enter details on tell us about yourself page with dob "08171987", gender "Male", and applying "No"
    Then I click Save and Continue only on the tell us about yourself page
    Then I validate I am on the "CoCo Additional information for yourself" page
    Then I click Go Back on the additional information for yourself page
    Then I validate I am on the "CoCo Tell us about yourself" page
    Then I validate the data entered is saved on tell us about yourself page
    Then I validate the data entered on tell us about yourself page is saved in DB
    And I click on Sign Out in the Header for "Elmo"






