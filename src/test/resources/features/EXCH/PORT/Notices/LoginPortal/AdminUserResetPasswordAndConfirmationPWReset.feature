@port @portNoticeLoginPortal
Feature: Trigger Admin user Password reset and confirmation Notices AM-016-07 AND AM-016-08

  @SLER-1022
  Scenario: Trigger Admin user Password reset and confirmation Notices AM-016-07 AND AM-016-08 English
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I click create forgot "password"
    And I validate I am on the "Forgot my password" page
    Then I enter valid email to any env QA "testing.reset+adminrestqa@outlook.com" STG "testing.reset+adminreststg@outlook.com"
    And I click submit button
    Then I verify notice is sent to the client text in "English"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.reset@outlook.com" and "ALaska12!"
    Then I open the notice "Password Reset Link" in "English"
    And I verify the notice Text for "AM-016-07" in "English" for "Broker"
    Then I click the password reset link
    Then I delete the open notice
    Then I switch to the tab number 3
    And I enter the new password in create new password page
    Then I validate I am on the "Login" page
    And I close current tab and switch back to previous tab
    Then I switch to the tab number 2
    Then I open the notice "Confirmation: Account Password Reset" in "English"
    And I verify the notice Text for "AM-016-08" in "English" for "Broker"
    Then I delete the open notice
    And I sign out of Outlook