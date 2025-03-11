@BrokerPortalCreateAccount @port
Feature: Admin staff account creation where the invite code is entered in Agency Information

  @SLER-2321
  Scenario: Admin staff account creation
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    Then I enter mandatory data for "Admin Staff" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page

    #Agency account created to invite admin staff
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

    And I click Complete Profile
    Then I validate the Your Information page title
    Then I enter my "Agency Owner" license number and dates
    And I click Yes to the Book of Business question
    Then I click Continue on the Your Information page

    Then I click Continue on the Communication Preferences page

    Then I enter the mandatory information on the Agency Details page
    Then I click Continue on the Agency Details page

    Then I click the checkbox to agree to the Broker Portal Terms and Conditions
    Then I click Submit on the Broker Portal Terms page
    Then I click Go to my Dashboard

    And I validate I am on the "Agency Dashboard" page
    Then I click the Manage Users button

    Then I click the Add Authorized User link
    And I enter the email address for the new admin staff
    Then I click Save and Submit on the Add Authorized Users page
    Then I click on broker userName and logout

    #Admin staff accepting the invite and completing their profile
    Given I open the login page on the "broker" portal
    And I log into my "Admin Staff" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "AG-001-02" in "English"
    Then I save the invitation code for the new admin staff account
    Then I delete the open notice
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Agency Dashboard" page
    Then I validate the dashboard displays my "Admin Staff" name
    And I verify the Agency Dashboard button is displayed
    And I click Agency Complete Profile

    Then I validate the Your Information page title
    And I click No to the Book of Business question
    Then I click the checkbox for I do not have a code
    Then I click Continue on the Your Information page
    Then I click Continue on the Communication Preferences page
    Then I click the checkbox to agree to the Broker Portal Terms and Conditions
    Then I click Submit on the Broker Portal Terms page
    Then I click Go to my Dashboard

    And I wait for 2000 milliseconds
    Then I verify the Enter Agency invitation code field is displayed
    And I verify the Enter Agency invitation code error message
    Then I enter the admin staff invitation code under Agency Information
    And I wait for 1000 milliseconds
    And I verify the new Agency Information displays
    And I click on broker userName and logout