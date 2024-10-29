@BrokerPortalProfile @port @Dashboard
Feature: Verify the Communication Preferences page of Broker Portal

  @SLER-613
  Scenario: Verify the Communication Preferences page
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    Then I enter mandatory data for "Broker" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page
    And I log into my "Broker" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I enter the MFA code and click Verify
    Then I click Broker Dashboard
    And I click Complete Profile
    Then I enter my "Broker" license number and dates
    And I click No to the Book of Business question
    Then I click Continue on the Your Information page

    Then I validate the Communication Preferences page title
    And I validate the field labels on the Communication Preferences page
    And I validate the email field shows my email
    And I validate the phone number field shows my phone number
    Then I validate the required fields error messages

    Then I click Go Back on the Communication Preferences page
    Then I click Continue on the Your Information page
    Then I validate the Communication Preferences page title