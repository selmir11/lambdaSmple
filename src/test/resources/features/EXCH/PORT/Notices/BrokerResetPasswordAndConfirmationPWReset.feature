@SLER-1010
Feature: Trigger Broker Password reset and confirmation Notices AM-016-07 AND AM-016-08

  @SLER-1010
  Scenario: Trigger IND Password reset Notice AM-016-07
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    Then I click create forgot "password"
    And I validate I am on the "Forgot my password" page
    Then I enter valid email to any env QA "testing.reset+brokerrestqa@outlook.com" STG "testing.reset+brokerrestSTG@outlook.com"
    And I click submit button
    Then I verify notice is sent to the client text in "English"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.reset@outlook.com" and "ALaska12!"
    Then I open the notice "Password Reset Link" in "English"
    And I verify the notice Text for "AM-016-07" in "English" for "Broker"
    Then I click the password reset link
    Then I delete the open notice
    And I sign out of Outlook
    And I enter the new password in create new password page
    Then I validate I am on the "Login" page
    And I login as individual with password reset code to any env QA "testing.reset+brokerrestqa@outlook.com" STG "testing.reset+brokerrestSTG@outlook.com"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.reset@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I switch to the tab number 3
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Portal Your Clients" page
    Then I click on broker userName and logout
    Then I switch to the tab number 3
    Then I open the notice "Confirmation: Account Password Reset" in "English"
    And I verify the notice Text for "AM-016-08" in "English" for "Broker"
    Then I delete the open notice
    And I sign out of Outlook