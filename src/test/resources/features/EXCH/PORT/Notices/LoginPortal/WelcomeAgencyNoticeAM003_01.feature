@port @portNoticeLoginPortal
Feature:Agency Welcome notice AM-003-01
  @SLER-1923
  Scenario: Agency Welcome notice AM-003-01
    Given I open the login page on the "broker" portal
    Then I validate I am on the "Login" page
    When I click create a new account on login page
    And I enter mandatory data for "Agency Owner" account creation with email "testing.soukaina"@outlook.com
    Then I validate I am on the "Login" page
    And I log into my "Agency Owner" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click on broker userName and logout
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "Your Connect for Health Colorado Broker Account is Created! (AM-003-01)" in "English"
    And I verify the notice Text for "AM-003-01 Agency" in "English" for "Broker"
    Then I delete the open notice
    And I sign out of Outlook