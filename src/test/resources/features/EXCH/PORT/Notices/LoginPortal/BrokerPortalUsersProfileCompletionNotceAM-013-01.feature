@port @portNoticeLoginPortal
Feature: Verify the Broker Portal profile completion notice AM-013-01

  @SLER-2274
  Scenario: Agency owner account with a book of business
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

    Then I click on broker userName and logout

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4AgencyTesting@outlook.com" and "ALaska12!"
    Then I open the notice "Confirmation: Connect for Health Colorado Broker Profile Completed (AM-013-01)" in "English"
    And I verify the notice Text for "AM-013-01 Agency" in "English" for "Broker"
    Then I delete the open notice
    And I sign out of Outlook
    Then I switch to the tab number 0

  Scenario: Broker account with no book of business
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

    Then I click the checkbox to agree to the Broker Portal Terms and Conditions
    Then I click Submit on the Broker Portal Terms page
    Then I click Go to my Dashboard

    Then I click on broker userName and logout

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4BrokerTesting@outlook.com" and "ALaska12!"
    Then I open the notice "Confirmation: Connect for Health Colorado Broker Profile Completed (AM-013-01)" in "English"
    And I verify the notice Text for "AM-013-01 Broker" in "English" for "Broker"
    Then I delete the open notice
    And I sign out of Outlook
    Then I switch to the tab number 0

  Scenario: Creating an Admin Staff account with no book of business
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    Then I enter mandatory data for "Admin Staff" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page

    And I log into my "Admin Staff" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Agency Dashboard" page
    Then I validate the dashboard displays my "Admin Staff" name

    And I click Agency Complete Profile
    Then I validate the Your Information page title

    And I click No to the Book of Business question
    Then I click the checkbox for I do not have a code
    Then I click Continue on the Your Information page

    Then I click Continue on the Communication Preferences page

    Then I click the checkbox to agree to the Broker Portal Terms and Conditions
    Then I click Submit on the Broker Portal Terms page
    Then I click Go to my Dashboard

    Then I click on broker userName and logout

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "Confirmation: Connect for Health Colorado Broker Profile Completed (AM-013-01)" in "English"
    And I verify the notice Text for "AM-013-01 Admin Staff" in "English" for "Broker"
    Then I delete the open notice
    And I sign out of Outlook