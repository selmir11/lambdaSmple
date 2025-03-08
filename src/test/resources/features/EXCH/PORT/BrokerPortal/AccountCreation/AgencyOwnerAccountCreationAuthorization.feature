@BrokerPortalCreateAccount @port
Feature: Verify agency owner new account creation and individual authorization

  @SLER-2291
  Scenario: Verify agency owner new account creation and individual authorization
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
    And I verify the Broker Dashboard button is displayed
    Then I enter my "Agency Owner" license number and dates
    And I click Yes to the Book of Business question
    Then I click Continue on the Your Information page

    And I verify the Broker Dashboard button is displayed
    Then I click Continue on the Communication Preferences page

    And I verify the Broker Dashboard button is displayed
    Then I enter the mandatory information on the Agency Details page
    Then I click Continue on the Agency Details page

    And I verify the Broker Dashboard button is displayed
    Then I click the checkbox to agree to the Broker Portal Terms and Conditions
    Then I click Submit on the Broker Portal Terms page
    And I verify the Broker Dashboard button is displayed
    Then I click Go to my Dashboard

    And I validate I am on the "Agency Dashboard" page
    And I verify the Agency Dashboard button is displayed
    Then I validate the dashboard displays my "Agency Owner Completed Profile" name
    And I verify the new agency owner Account Summary details
    Then I validate the current agency certification status is "NOT APPROVED"
    Then I click on broker userName and logout

    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I search for the "Agency" generated
    And I select the first broker record from the search results
    Then I validate I am on the "AP Broker dashboard" page
    And I click Manage Certification button
    Then I change the certification status to "approved"
    And I wait for 300 milliseconds
    Then I validate the status certification is "APPROVED"
    And I logout from Admin Portal

    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I validate I am on the "Find Expert Help Exch" page
    And I click on Find a Broker

    Then I search for the new "Agency Owner" account on the Find a Certified Broker page
    And I click on Search button in find certified broker page
    And I click more details on the first broker result
    Then I validate the newly created agency details
    Then I click Authorized broker
    And I click on Sign Out in the Header for "Elmo"

    Given I open the login page on the "broker" portal
    And I log into my "Agency Owner" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4AgencyTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I search for clients
    And I wait for 1000 milliseconds
    And I click on first client search result
    And I verify my client's name is displayed

    Then I click Agency Dashboard
    And I validate I am on the "Agency Dashboard" page
    And I verify the Agency Dashboard button is displayed
    Then I validate the dashboard displays my "Agency Owner Completed Profile" name
    And I verify the new agency owner Account Summary details
    Then I validate the current agency certification status is "APPROVED"
    Then I click on broker userName and logout