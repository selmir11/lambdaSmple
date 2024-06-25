@SLCR-158
Feature: CoCo Forgot Username Notice (AM-016-01) in DocGen

  @SLCR-158
  Scenario: Verify CoCo Forgot Username Notice (AM-016-01) in English
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click create forgot "username"
    And I validate I am on the "forgotUsername" page
    Then I enter information's for Forgot username in "English"
    And I validate notice sent successful msg is displayed
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "AM-016-01" in "English"
    And I verify the notice Text for "AM-016-01" in "English"
    Then I delete the open notice
    And I sign out of Outlook

  @SLCR-158
  Scenario: Verify CoCo Forgot Username Notice (AM-016-01) in Spanish
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click create forgot "username"
    And I validate I am on the "forgotUsername" page
    Then I enter information's for Forgot username in "Spanish"
    And I validate notice sent successful msg is displayed
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "AM-016-01" in "Spanish"
    And I verify the notice Text for "AM-016-01" in "Spanish"
    Then I delete the open notice
    And I sign out of Outlook





