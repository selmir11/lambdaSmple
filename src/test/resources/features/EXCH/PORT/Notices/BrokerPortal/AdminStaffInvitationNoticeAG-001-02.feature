@port @portNoticeBrokerPortal
Feature:  Admin staff invitation notice validation - AG-001-02

  @SLER-2472
  Scenario: Creating a new admin staff account to invite to an agency
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    Then I enter mandatory data for "Admin Staff" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page

  #Agency Owner sends an invite to new admin staff
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "NoahTrujilloAgencySTG@agency.com" password "ALaska15!" and "NoahTrujilloAgency@agency.com" password "ALaska14!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I wait for 2000 milliseconds

    Then I click Agency Dashboard
    Then I click the Manage Users button

    Then I click the Add Authorized User link
    And I enter the email address for the new admin staff
    Then I click Save and Submit on the Add Authorized Users page
    Then I click on broker userName and logout

  #Verifying the admin staff invitation notice
    Given I open the login page on the "broker" portal

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "AG-001-02" in "English"
    Then I save the invitation code for the new admin staff account
    And I verify the notice Text for "AG-001-02" in "English" for "Broker"
    Then I delete the open notice
    And I sign out of Outlook