@Dashboard @port
Feature: Admin staff management - resending invites and removing staff members

  @SLER-2320
  Scenario: Admin staff management
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

    #Verifying the ability to resend an admin staff invitation
    Then I validate the Manage Authorized Users page title
    Then I click the Resend Invite link
    And I verify the Invite Sent confirmation message

    Then I click on broker userName and logout

    #Admin staff accepting the invite and completing their profile
    Given I open the login page on the "broker" portal
    And I log into my "Admin Staff" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "AG-001-02" in "English"
    And I delete the open notice
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
    Then I enter the admin staff invitation code on the Your Information page
    Then I click Continue on the Your Information page
    Then I click Continue on the Communication Preferences page
    Then I click the checkbox to agree to the Broker Portal Terms and Conditions
    Then I click Submit on the Broker Portal Terms page
    Then I click Go to my Dashboard
    And I wait for 1000 milliseconds
    And I verify the new Agency Information displays
    And I click on broker userName and logout

    #Verifying the agency owner's ability to remove admin staff
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I log into my "Agency Owner" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4AgencyTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Agency Dashboard" page
    Then I click the Manage Users button
    Then I validate the Manage Authorized Users page title
    And I verify the admin staff details displayed
    Then I click the Remove link for admin staff
    And I wait for 2000 milliseconds
    And I verify the admin staff invite is removed
    And I click on broker userName and logout

    #Admin staff verifying they can no longer see the agency details
    Given I open the login page on the "broker" portal
    And I log into my "Admin Staff" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I verify the Complete your profile button displays
    And I verify the Agency Information does not display
    And I click on broker userName and logout