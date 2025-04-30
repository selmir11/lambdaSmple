@port @portNoticeLoginPortal
Feature: Trigger IND Password reset and confirmation Notices AM-016-07 AND AM-016-08
  @SLER-827
  Scenario: Trigger IND Password reset and confirmation Notices AM-016-07 AND AM-016-08 English
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click create forgot "password"
    And I validate I am on the "Forgot my password" page
    Then I enter valid email to any env QA "testing.reset+obfcjxalgTest@outlook.com" STG "testing.reset+jtjnlxektTest@outlook.com"
    And I click submit button
    Then I verify notice is sent to the client text in "English"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.reset@outlook.com" and "ALaska12!"
    Then I open the notice "Password Reset Link" in "English"
    And I verify the notice Text for "AM-016-07" in "English" for "Exch"
    Then I click the password reset link
    Then I delete the open notice
    Then I switch to the tab number 3
    And I enter the new password in create new password page
    Then I validate I am on the "Login" page
    And I login as individual with password reset code to any env QA "testing.reset+obfcjxalgTest@outlook.com" STG "testing.reset+jtjnlxektTest@outlook.com"
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"
    And I close current tab and switch back to previous tab
    Then I switch to the tab number 2
    Then I open the notice "Confirmation: Account Password Reset" in "English"
    And I verify the notice Text for "AM-016-08" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    
    @SLER-1009
  Scenario: Trigger IND Password reset and confirmation Notices AM-016-07 AND AM-016-08 Spanish
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click create forgot "password"
    And I validate I am on the "Forgot my password" page
    Then I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I enter valid email to any env QA "testing.soukaina+hpjwlmcTest@outlook.com" STG "AutomationUser.gabmbhgpTest@test.com"
    And I click submit button
    Then I verify notice is sent to the client text in "Spanish"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.reset@outlook.com" and "ALaska12!"
    Then I open the notice "Enlace para el restablecimiento de la contraseña" in "Spanish"
    And I verify the notice Text for "AM-016-07" in "Spanish" for "Exch"
    Then I click the password reset link
    Then I delete the open notice
    Then I switch to the tab number 3
    And I enter the new password in create new password page
    Then I validate I am on the "Login" page
    And I login as individual with password reset code to any env QA "testing.soukaina+hpjwlmcTest@outlook.com" STG "AutomationUser.gabmbhgpTest@test.com"
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"
    And I close current tab and switch back to previous tab
    Then I switch to the tab number 2
    Then I open the notice "Confirmación: Restablecimiento de la contraseña de la cuenta" in "Spanish"
    And I verify the notice Text for "AM-016-08" in "Spanish" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook


