@SLER-351 @FindExpertHelp
Feature:Verify the navigation from get assistance from LUGY Pages
  @SLER-351
  Scenario: Verify the navigation from get assistance from LUGY Pages
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I verify sign in button is displayed
    And I click on Get Assistance in the "Exch NonElmo" Header
    Then I click on Find Expert Assistance in the "Lugy Page" Header
    And I validate I am on the "LUGY Find expert help" page
  @SLER-351
  Scenario: Verify the navigation from get assistance from letUsGuideYou/household page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click on Help me understand what I qualify for button
    And I verify sign in button is displayed
    And I click on Get Assistance in the "Exch NonElmo" Header
    Then I click on Find Expert Assistance in the "Lugy Page" Header
    And I validate I am on the "LUGY Find expert help" page
