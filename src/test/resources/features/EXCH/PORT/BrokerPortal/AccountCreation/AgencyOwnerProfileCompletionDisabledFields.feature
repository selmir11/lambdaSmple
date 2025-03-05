@BrokerPortalCreateAccount @port
Feature: Verify agency owner profile completion and disabled fields

  @SLER-2292
  Scenario: Verify agency owner profile completion and disabled fields
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    Then I enter mandatory data for "Agency Owner" account creation with email "C4AgencyTesting"@outlook.com
    Then I validate I am on the "Login" page

    And I log into my "Agency Owner" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4AgencyTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Dashboard" page
    Then I validate the dashboard displays my "Agency Owner" name
    And I validate that the broker certification is not displayed
    And I verify the Broker Dashboard button is displayed

    And I click Complete Profile
    Then I validate the Your Information page title
    Then I enter my "Agency Owner" license number and dates
    And I click Yes to the Book of Business question
    Then I click Continue on the Your Information page

    Then I click Go Back on the Communication Preferences page
    Then I validate the Your Information page title
    Then I verify the Book of Business buttons are disabled
    Then I click Continue on the Your Information page

    Then I click Continue on the Communication Preferences page

    Then I enter the mandatory information on the Agency Details page
    Then I click Continue on the Agency Details page

    Then I click the checkbox to agree to the Broker Portal Terms and Conditions
    Then I click Submit on the Broker Portal Terms page
    Then I click Go to my Dashboard

    And I validate I am on the "Agency Dashboard" page
    Then I validate the dashboard displays my "Agency Owner Completed Profile" name

    Then I click the Edit Agency Information link
    Then I verify the Agency Group field is disabled

    Then I click on broker userName and logout