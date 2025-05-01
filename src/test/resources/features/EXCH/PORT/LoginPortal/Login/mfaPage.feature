@SLER-138 @LoginPortalLogin
Feature:Chat Widget in Login Portal
  @SLER-138
Scenario: MFA code
  Given I open the login page on the "broker" portal
  And I validate I am on the "Login" page
  When I login as Broker User "testing.soukaina+stgmfa2@outlook.com" password "ALaska12!"
  And  I validate I am on the "MFA" page
  Then I validate the verbiage of the MFA page
  And I enter Invalid Verification Code
  Then I validate the error message on the MFA page
  Then I click Didn't receive an email?
  And I verify request new option is displayed
  Then I click request new code
  And I enter Invalid Verification Code
  Then I validate the error message on the MFA page
  Then I click request new code
  Then I open outlook Tab
  And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
  Then I open the MFA notice
  And I get the MFA code
  And I delete the open notice
  Then I enter the MFA code and click Verify
  And I validate I am on the "Broker Dashboard" page






