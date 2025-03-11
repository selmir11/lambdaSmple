@BrokerPortalCreateAccount @port
Feature: Full agency creation from end to end

  @SLER-2295
  Scenario: Broker account creation
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

  @SLER-2295
  Scenario: Agency owner account creation
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
    And I verify the Agency Dashboard button is displayed
    Then I validate the dashboard displays my "Agency Owner Completed Profile" name
    Then I validate the current agency certification status is "NOT APPROVED"

    Then I click Agency Dashboard
    Then I click the Manage Brokers button
    Then I click the Add New Broker Link

    Then I search for the new broker
    And I validate the broker results match my broker's details
    Then I click the Add link on the Add a Broker page
    And I validate the Invitation Sent text
    Then I click on broker userName and logout

  @SLER-2295
  Scenario: Verifying that the agency owner and the broker can't be found on the Find a Broker page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    Then I search for the new "Agency Owner" account on the Find a Certified Broker page
    And I click on Search button in find certified broker page
    Then I verify that a total of "0" results displays in "English"

    Then I clear the broker search box
    Then I search for the new "Broker" account on the Find a Certified Broker page
    And I click on Search button in find certified broker page
    Then I verify that a total of "0" results displays in "English"

  @SLER-2295
  Scenario: Broker approves an invite to a new agency
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I log into my "Broker" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4BrokerTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I click the My Agency View link
    Then I approve the agency invite
    And I wait for 2000 milliseconds
    Then I click on broker userName and logout

  @SLER-2295
  Scenario: Agency owner and broker certification via Admin Portal
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I wait for 5000 milliseconds
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I search for the "Agency" generated
    And I select the first broker record from the search results
    Then I validate I am on the "AP Broker dashboard" page
    And I click Manage Certification button
    Then I change the certification status to "approved"
    And I wait for 300 milliseconds
    Then I validate the status certification is "APPROVED"

    And I click Go Back on admin portal broker dashboard
    And I validate I am on the "Admin search" page
    When I click on reset button on admin portal search page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I search for the "Broker" generated
    And I select the first broker record from the search results
    Then I validate I am on the "AP Broker dashboard" page
    And I click Manage Certification button
    Then I change the certification status to "approved"
    And I wait for 300 milliseconds
    Then I validate the status certification is "APPROVED"
    And I logout from Admin Portal

  @SLER-2295
  Scenario: Individual account creation and agency owner authorization
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I verify Find Expert Help header Text in "English"

    And I click on Find a Broker

    Then I search for the new "Agency Owner" account on the Find a Certified Broker page
    And I click on Search button in find certified broker page
    And I click more details on the first broker result
    And I click Authorized broker
    And I validate current Broker text exists

    And I click on Sign Out in the Header for "Elmo"

  @SLER-2295
  Scenario: Individual account creation and broker authorization
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I verify Find Expert Help header Text in "English"

    And I click on Find a Broker

    Then I search for the new "Broker" account on the Find a Certified Broker page
    And I click on Search button in find certified broker page
    And I click more details on the first broker result
    And I click Authorized broker
    And I validate current Broker text exists

    And I click on Sign Out in the Header for "Elmo"