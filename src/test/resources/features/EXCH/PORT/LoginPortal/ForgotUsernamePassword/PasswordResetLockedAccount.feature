@ForgotUsernamePassword @port
Feature: Password reset verification when an individual's account is locked

  @SLER-1933
  Scenario: Password reset verification when an individual's account is locked
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page

    Then I enter invalid credentials
    And I verify the invalid login error text
    Then I enter invalid credentials
    And I verify the invalid login error text
    Then I enter invalid credentials
    Then I validate account is locked message on the Login page

    Then I click create forgot "password"
    And I validate I am on the "Forgot my password" page
    Then I enter valid email of the account created
    And I click submit button
    Then I verify notice is sent to the client text in "English"

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "Password Reset Link" in "English"
    Then I click the password reset link
    Then I delete the open notice
    And I sign out of Outlook

    Then I switch to the tab number 1
    And I enter the new password in create new password page
    Then I validate I am on the "Login" page
    And  I login as individual with password reset code
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"
