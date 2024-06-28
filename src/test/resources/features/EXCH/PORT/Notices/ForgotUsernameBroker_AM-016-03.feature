@portNotice
Feature: Exch Forgot Username Notice (AM-016-01) in DocGen

@SLER-730
Scenario: Verify Exch Forgot Username Notice (AM-016-03) in English Agency
Given I open the login page on the "broker" portal
And I validate I am on the "Login" page
Then I click create forgot "username"
And I validate I am on the "forgotUsername" page
Then I enter information's for Forgot username in "English" "Administrative Staff"
And I validate notice sent successful msg is displayed
Then I open outlook Tab
And I sign in to outlook with Valid Credentials "automationtestport@outlook.com" and "ALaska12!"
Then I open the notice "Broker Login Reminder" in "English"
And I verify the notice Text for "AM-016-03" in "English" for "Exch"
Then I delete the open notice
And I sign out of Outlook

@SLER-729
Scenario: Verify Exch Forgot Username Notice (AM-016-03) in English Broker
Given I open the login page on the "broker" portal
And I validate I am on the "Login" page
Then I click create forgot "username"
And I validate I am on the "forgotUsername" page
Then I enter information's for Forgot username in "English" "Certified Broker"
And I validate notice sent successful msg is displayed
Then I open outlook Tab
And I sign in to outlook with Valid Credentials "automationtestport@outlook.com" and "ALaska12!"
Then I open the notice "Broker Login Reminder" in "English"
And I verify the notice Text for "AM-016-03" in "English" for "Exch"
Then I delete the open notice
And I sign out of Outlook

@SLER-731
Scenario: Verify Exch Forgot Username Notice (AM-016-03) in English Administrative Staff
Given I open the login page on the "broker" portal
And I validate I am on the "Login" page
Then I click create forgot "username"
And I validate I am on the "forgotUsername" page
Then I enter information's for Forgot username in "English" "Administrative Staff"
And I validate notice sent successful msg is displayed
Then I open outlook Tab
And I sign in to outlook with Valid Credentials "automationtestport@outlook.com" and "ALaska12!"
Then I open the notice "Broker Login Reminder" in "English"
And I verify the notice Text for "AM-016-03" in "English" for "Exch"
Then I delete the open notice
And I sign out of Outlook