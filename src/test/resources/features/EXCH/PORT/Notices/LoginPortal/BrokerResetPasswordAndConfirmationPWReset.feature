@port @portNoticeLoginPortal
Feature: Trigger Broker Password reset and confirmation Notices AM-016-07 AND AM-016-08

  @SLER-1010 @SLER-1019 @SLER-1020 @SLER-1021
  Scenario Outline: Trigger IND Password reset Notice AM-016-07
    Given I open the login page on the "<portal>" portal
    When I validate I am on the "Login" page
    Then I click create forgot "password"
    And I validate I am on the "Forgot my password" page
    Then I enter valid email to any env QA "<qaEmail>" STG "<stgEmail>"
    And I click submit button
    Then I verify notice is sent to the client text in "English"
    Then I open outlook Tab
    Then I switch to the tab number 0
    And I close current tab and switch back to previous tab
    And I sign in to outlook with Valid Credentials "testing.reset@outlook.com" and "ALaska12!"
    Then I open the notice "Password Reset Link" in "English"
    And I verify the notice Text for "AM-016-07" in "English" for "Broker"
    Then I click the password reset link
    Then I delete the open notice
    Then I switch to the tab number 2
    And I enter the new password in create new password page
    Then I validate I am on the "Login" page
    And I login as individual with password reset code to any env QA "<qaEmail>" STG "<stgEmail>"
    Then I switch to the tab number 1
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I switch to the tab number 2
    Then I enter the MFA code and click Verify
    And I validate I am on the "<pages>" page

    Then I click on broker userName and logout
    Then I switch to the tab number 1
    Then I open the notice "Confirmation: Account Password Reset" in "English"
    And I verify the notice Text for "AM-016-08" in "English" for "Broker"
    And I delete the open notice
    Then I sign out of Outlook
    Then I switch to the tab number 0
    Examples:
      | portal    | qaEmail                                | stgEmail                                | pages                      |
      | broker    | testing.reset+brokerrestqa@outlook.com | testing.reset+brokerrestSTG@outlook.com | Broker Portal Your Clients |
      | broker    | testing.reset+agencyrestqa@outlook.com | testing.reset+agencyrestSTG@outlook.com | Broker Portal Your Clients |
      | broker    | acctsforc4testing+Xeic30vJA@gmail.com  | acctsforc4testing+bKOpMbLst@gmail.com   | Agency Dashboard           |
      | assistNet | c4assistorportal+H0jNbeEEi@gmail.com   | c4assistorportal+iFvfwfHMx@gmail.com    | assistnet dashboard        |

