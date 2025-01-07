@BrokerPortalDB @port
Feature: Verifying the Password Reset notice AM-016-07 is not being archived in the database

  @SLER-1960
  Scenario: : Verifying the Individual Password Reset notice AM-016-07 is not being archived in the database
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

    Then I click create forgot "password"
    And I validate I am on the "Forgot my password" page
    Then I enter valid email to any env QA "carrimautomation+RT2684IndvQA@gmail.com" STG "carrimautomation+RT2684IndvSTG@gmail.com"
    And I click submit button
    Then I verify notice is sent to the client text in "English"

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "Password Reset Link" in "English"
    Then I click the password reset link
    Then I delete the open notice
    And I sign out of Outlook

    Then I switch to the tab number 1
    And I enter the new password in create new password page
    Then I validate I am on the "Login" page

    And I verify the password reset notice is not being archived in the DB for account number STG "5590737940" QA "9062966019"

  Scenario: : Verifying the Broker Password Reset notice AM-016-07 is not being archived in the database
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

    Then I click create forgot "password"
    And I validate I am on the "Forgot my password" page
    Then I enter valid email to any env QA "carrimautomation+RT2684AgeQA@gmail.com" STG "carrimautomation+RT2684AgeSTG@gmail.com"
    And I click submit button
    Then I verify notice is sent to the client text in "English"

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "Password Reset Link" in "English"
    Then I click the password reset link
    Then I delete the open notice
    Then I sign out of Outlook
    Then I switch to the tab number 1
    And I enter the new password in create new password page
    Then I validate I am on the "Login" page

    And I verify the password reset notice is not being archived in the DB for account number STG "1909077535" QA "7662296009"