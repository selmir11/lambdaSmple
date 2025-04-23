@port @portNoticeLoginPortal
Feature: Trigger Notice IND_Welcome Message AM-001-01

  @SLER-791
  Scenario: Trigger Notice IND_Welcome Message AM-001-01
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "testing.soukaina"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "Account Overview" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "AM-001-01" in "English"
    And I verify the notice Text for "AM-001-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook

  @SLER-791
  Scenario: Trigger Notice IND_Welcome Message AM-001-01 Spanish
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange Spanish" account creation with email "testing.soukaina"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "Account Overview" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "AM-001-01" in "Spanish"
    And I verify the notice Text for "AM-001-01" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook