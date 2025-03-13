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
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    And I enter details on tell us about yourself page and continue with "01011991", "Female", and applying "Yes"
    Then I validate I am on the "CoCo Additional information for yourself" page
    And I select "No" for mailing address option
    Then I verify text on the Additional information for yourself page in "English"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I enter my mailing address "4321 Road", "Colorado Springs", "CO", "80916", "EL PASO"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-686
  Scenario: Verify to save and view data entered Additional information for yourself page
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
    Then I enter details on tell us about yourself page and continue with "05101994", "Male", and applying "Yes"
    And I enter complete residential address details for additional member addressLine1 "12345 Road",addressLine2 "12345 Road",city "Denver",state "CO",zipcode "80205",county "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate complete residential address details for "Primary" member in DB addressLine1 "12345 Road",addressLine2 "12345 Road",city "Denver",state "CO",zipcode "80205",county "DENVER"
    Then I validate mailing address details for "Primary" member in DB addressLine1 "P. O. Box 1454",city "Denver",state "CO",zipcode "80205",county "DENVER"
    Then I validate state details for "Primary" member in DB 1
    And I click Go Back on the Race and Ethnicity page
    And I update the AddressLine1 and AddressLine2 to "12345 testRoad" and "12345 testarea" for additional member
    And I select "No" for mailing address option
    And I enter my mailing address "11", "City", "CO", "80205", "DENVER"
    And I select "No" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    Then I validate complete residential address details for "Primary" member in DB addressLine1 "12345 testRoad",addressLine2 "12345 testarea",city "Denver",state "CO",zipcode "80205",county "DENVER"
    Then I validate mailing address details for "Primary" member in DB addressLine1 "P. O. Box 145411",city "DenverCity",state "CO",zipcode "80205",county "DENVER"
    Then I validate state details for "Primary" member in DB 0
    And I click on Sign Out in the Header for "Elmo"
