@APAccountActivityExch @port @BrokerPortalCreateAccount
Feature: Broker account creation and account activity code verification

  @SLER-2305
  Scenario: Broker account creation and account activity code verification
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

    #Agency owner inviting the new broker
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "johnc4hcoautomation+stg1908@gmail.com" password "ALaska13!" and "johnc4hcoautomation+qa1908@gmail.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I click Agency Dashboard
    Then I click the Manage Brokers button
    Then I click the Add New Broker Link

    Then I search for the new broker
    And I validate the broker results match my broker's details
    Then I click the Add link on the Add a Broker page
    And I validate the Invitation Sent text
    Then I click on broker userName and logout

    #Broker accepts the invite and completes their profile
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

    And I validate I am on the "Broker Dashboard" page

    Then I click the My Agency View link
    Then I approve the agency invite
    And I wait for 2000 milliseconds
    Then I click on broker userName and logout

    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I wait for 5000 milliseconds
    And I validate I am on the "Admin search" page
    When I click on reset button on admin portal search page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I search for the "Broker" generated
    And I select the first broker record from the search results
    Then I validate I am on the "AP Broker dashboard" page
    And I click Manage Certification button
    Then I change the certification status to "approved"
    And I wait for 3000 milliseconds
    Then I validate the status certification is "APPROVED"

    Then I click "View Report" on Account Summary container AP Broker dashboard page
    Then I switch to the tab number 1
    And I validate Account Activity title row
    Then I validate "UI_ACCT_CREATED" event code and description "Account created" in activity event report
    Then I validate "BP_ASSIGNED_ROLE" event code and description "Role Assigned" in activity event report
    Then I validate "UI_PROFILE_COMPLETED" event code and description "Profile Complete" in activity event report
    Then I validate "SP_BROKER_CERTIFIED" event code and description "Broker certified" in activity event report
    And I logout from Admin Portal