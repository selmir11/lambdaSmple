@BrokerPortalCreateAccount @port
Feature: Verify broker new account profile completion

  @SLER-2098
  Scenario: Verify broker profile completion
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
    And I validate that the broker certification is not displayed
    And I verify the Broker Dashboard button is displayed
    And I verify the broker Complete Profile button is displayed

    And I click Complete Profile
    Then I validate the Your Information page title
    Then I click Go Back on the Your Information page
    And I click Complete Profile
    Then I validate the Your Information page title
    And I verify the Broker Dashboard button is displayed
    Then I enter my "Broker" license number and dates
    And I click No to the Book of Business question
    And I verify the Broker Dashboard button is displayed
    Then I click Continue on the Your Information page
    And I verify the Broker Dashboard button is displayed
    Then I click Continue on the Communication Preferences page
    And I verify the Broker Dashboard button is displayed
    Then I click the checkbox to agree to the Broker Portal Terms and Conditions
    Then I click Submit on the Broker Portal Terms page
    And I verify the Broker Dashboard button is displayed
    Then I click Go to my Dashboard

    And I verify the Broker Dashboard button is displayed
    And I verify the broker profile Edit button is displayed
    Then I validate the dashboard displays my "Broker" name
    Then I validate the current broker certification status is "NOT APPROVED"

    Then I click on broker userName and logout