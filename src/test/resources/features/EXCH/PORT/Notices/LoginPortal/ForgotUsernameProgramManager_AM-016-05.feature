@port @portNoticeLoginPortal
Feature: Exch Forgot Username Notice (AM-016-01) in DocGen

@SLER-732
Scenario: Verify Exch Forgot Username Notice (AM-016-05) in English Program Manager
Given I open the login page on the "broker" portal
And I validate I am on the "Login" page
Then I click create forgot "username"
And I validate I am on the "forgotUsername" page
Then I enter information's for Forgot username in STG Firsname "assistnetAP" LastName "outlook" phone "383-027-3043" accountType "Program Manager" or QA Firsname "assistnetAPQA" LastName "port" phone "391-480-0117"
And I validate notice sent successful msg is displayed
Then I open outlook Tab
And I sign in to outlook with Valid Credentials "Assistnetport@outlook.com" and "ALaska12!"
Then I open the notice "Login Reminder" in "English"
And I verify the notice Text for "AM-016-05" in "English" for "Exch"
Then I delete the open notice
And I sign out of Outlook