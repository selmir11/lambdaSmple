@BrokerPortalProfile @port @Dashboard
Feature: Verify the Agency Details page of Broker Portal

  @SLER-623
  Scenario: Verify the Agency Details page
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    Then I enter mandatory data for "Agency Owner" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page
    And I log into my "Agency Owner" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click Broker Dashboard
    And I click Complete Profile
    Then I enter my "Agency Owner" license number and dates
    And I click Yes to the Book of Business question
    Then I click Continue on the Your Information page
    Then I click Continue on the Communication Preferences page

    Then I validate the Agency Details page title
    And I validate the field labels on the Agency Details page
    Then I validate the mandatory field error messages
    Then I validate the fields cannot contain special characters
    Then I validate the agency name maximum character limit
    And I validate letters are not allowed in the Agency TIN field
    Then I validate the Agency TIN field maximum limit
    And I validate the agency group tooltip text
    Then I validate the address fields maximum character limit
    Then I validate the city field maximum character limit
    Then I validate the zip code field maximum limit
    Then I validate the agency hide address tooltip text
    Then I validate the error message to enter both to and from working hours
    Then I validate the email field will not allow an invalid address
    Then I validate the email field maximum character limit
    Then I validate the phone number field formatting
    And I validate letters are not allowed in the phone field
    And I validate the Save and Finish Later button is not displayed

    Then I click Go Back on the Agency Details page
    Then I validate the Communication Preferences page title