@SLER-314
Feature:Verify the navigation from get assistance from my documents page and my profile page in both English and Spanish
@SLER-314
  Scenario: Verify the navigation from get assistance from my documents page in both English and Spanish
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click link my docs on accountOverview page
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help Exch" page
    And I click the back button from Find Expert Help page
    Then I click link my docs on accountOverview page
    And I change the language from header to "Spanish"
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help Exch Spanish" page
    And I click the back button from Find Expert Help page
    Then I validate I am on the "Account Overview" page

  @SLER-314
  Scenario: Verify the navigation from get assistance from my profile page in both English and Spanish
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help Exch" page






