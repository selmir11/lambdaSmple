@SLER-698  @portNotice
Feature: Exch Forgot Username Notice (AM-016-01) in DocGen

  @SLER-698
  Scenario: Verify Exch Forgot Username Notice (AM-016-01) in English individual user
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click create forgot "username"
    And I validate I am on the "forgotUsername" page
    Then I enter information's for Forgot username in STG Firsname "orange" LastName "strawberry" phone "111-111-2345" accountType "Customer" or QA Firsname "banana" LastName "rep" phone "987-654-3210"
    And I validate notice sent successful msg is displayed
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "AM-016-01" in "English"
    And I verify the notice Text for "AM-016-01" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook



