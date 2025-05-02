@SLER-92 @LoginPortalAnonymousHeader
Feature:Chat Widget in Login Portal

  @SLER-92
  Scenario: Validate Chat Widget in Account Creation page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    And I validate I am on the "Create Account" page
    Then I validate chat widget is present
    And I open on chat widget
    Then I minimize the chat window

  @SLER-92
  Scenario: Validate Chat Widget in Forgot Password page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create forgot "password"
    And I validate I am on the "forgotPassword" page
    Then I validate chat widget is present
    And I open on chat widget
    Then I minimize the chat window

  @SLER-92
  Scenario: Validate Chat Widget in Forgot Username page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create forgot "username"
    And I validate I am on the "forgotUsername" page
    Then I validate chat widget is present
    And I open on chat widget
    Then I minimize the chat window

  @SLER-92
  Scenario: Validate Chat Widget in Login Page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I validate chat widget is present
    And I open on chat widget
    Then I minimize the chat window

  @SLER-92
  Scenario: Validate Chat Widget in MFA page
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I login as Broker User "testing.soukaina+stgmfa2@outlook.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I validate chat widget is present
    And I open on chat widget
    Then I minimize the chat window








