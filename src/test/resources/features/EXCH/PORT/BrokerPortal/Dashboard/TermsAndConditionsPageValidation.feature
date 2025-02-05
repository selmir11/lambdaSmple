@BrokerPortalProfile @port @Dashboard
Feature: Verify the Terms and Conditions page of Broker Portal

  @SLER-2099
  Scenario: Verify the Terms and Conditions page of Broker Portal
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    Then I enter mandatory data for "Broker" account creation with email "C4BrokerTesting"@outlook.com
    Then I validate I am on the "Login" page

    And I log into my "Broker" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4BrokerTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Dashboard" page
    Then I validate the dashboard displays my "Broker" name

    And I click Complete Profile
    Then I validate the Your Information page title
    Then I enter my "Broker" license number and dates
    And I click No to the Book of Business question
    Then I click Continue on the Your Information page
    Then I click Continue on the Communication Preferences page

    Then I validate the Terms and Conditions page title
    Then I click Go Back on the Terms and Conditions page
    And I wait for 1000 milliseconds
    Then I validate the Communication Preferences page title
    Then I click Continue on the Communication Preferences page

    Then I validate the Terms and Conditions page title
    And I validate the Terms and Conditions text
    And I validate the Submit button is disabled
    And I validate the Term and Conditions checkbox text
    Then I click the checkbox to agree to the Broker Portal Terms and Conditions
    And I wait for 1000 milliseconds
    Then I click the checkbox to agree to the Broker Portal Terms and Conditions
    And I validate the error message text for the mandatory terms and conditions agreement

    Then I click the checkbox to agree to the Broker Portal Terms and Conditions
    Then I click Submit on the Broker Portal Terms page
    Then I click Go to my Dashboard
    And I wait for 1000 milliseconds
    Then I validate the dashboard displays my "Broker" name
    Then I click on broker userName and logout