@BrokerPortalDashboard @port @Dashboard @SLER-2336
Feature: As a non- certified Broker working for carrier agency, my certification status must be set to approved, so that I can work on behalf of agency customers in hCentive

  @SLER-2336
  Scenario: agency sent invite to non certified broker
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "color@agency.com" password "ALaska13!" and "color@agencyqa.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Portal Your Clients" page
    Then I wait for 500 milliseconds
    Then I validate I am on the "Agency Dashboard" page
    Then I click Agency Dashboard
    And I click the Manage Brokers button
    Then I send the invite to join my agency
    Then I click on broker userName and logout

  @SLER-2336
  Scenario: broker accept invite of the agency and check the certification status
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "broker@white.com" password "ALaska13!" and "vsibfiss@test.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Portal Your Clients" page
    And I validate the current broker certification status is "NOT APPROVED"
    Then I click the My Agency View link
    Then I approve the agency invite
    Then I click Broker Dashboard
    And I validate I am on the "Broker Portal Your Clients" page
    And I validate the current broker certification status is "APPROVED"
    Then I click on broker userName and logout

  @SLER-2336
  Scenario: validate the certification status of broker in admin portal
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "1900026629" "6803810976" to search user
    Then I click on Search button in AP dashboard page
    And I select the first broker record from the search results
    Then I validate I am on the "AP Broker dashboard" page
    And I wait for 500 milliseconds
    Then I validate the status certification is "APPROVED"
    And I logout from Admin Portal

  @SLER-2336
  Scenario: broker denied the invite of the agency
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "broker@white.com" password "ALaska13!" and "vsibfiss@test.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Portal Your Clients" page
    Then I wait for 500 milliseconds
    Then I click Broker Dashboard
    And I validate the current broker certification status is "APPROVED"
    Then I click the My Agency View link
    Then I deny the agency invite
    Then I click Broker Dashboard
    Then I wait for 1000 milliseconds
    And I validate I am on the "Broker Portal Your Clients" page
    And I validate the current broker certification status is "NOT APPROVED"
    Then I click on broker userName and logout

  @SLER-2336
  Scenario:Admin validate the certification status not approved
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "1900026629" "6803810976" to search user
    Then I click on Search button in AP dashboard page
    And I select the first broker record from the search results
    Then I validate I am on the "AP Broker dashboard" page
    And I wait for 500 milliseconds
    Then I validate the status certification is "NOT APPROVED"
    And I logout from Admin Portal

  @SLER-2336
  Scenario: agency send an invite to the broker
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "color@agency.com" password "ALaska13!" and "color@agencyqa.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Portal Your Clients" page
    Then I wait for 500 milliseconds
    Then I click Agency Dashboard
    Then I validate I am on the "Agency Dashboard" page
    And I click the Manage Brokers button
    Then I send the invite to join my agency
    Then I click on broker userName and logout

  @SLER-2336
  Scenario: broker accept the invite and validate the certification status
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "broker@white.com" password "ALaska13!" and "vsibfiss@test.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Portal Your Clients" page
    And I validate the current broker certification status is "NOT APPROVED"
    Then I click the My Agency View link
    Then I approve the agency invite
    Then I click Broker Dashboard
    And I validate I am on the "Broker Portal Your Clients" page
    And I validate the current broker certification status is "APPROVED"
    Then I click on broker userName and logout

  @SLER-2336
  Scenario: agency remove broker from the list
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "color@agency.com" password "ALaska13!" and "color@agencyqa.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Portal Your Clients" page
    Then I wait for 500 milliseconds
    Then I click Agency Dashboard
    Then I validate I am on the "Agency Dashboard" page
    And I click the Manage Brokers button
    Then I remove the broker from my agency
    Then I click on broker userName and logout

  @SLER-2336
  Scenario: Validate the broker is not certified and certification status is updated
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "broker@white.com" password "ALaska13!" and "vsibfiss@test.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Portal Your Clients" page
    Then I click Broker Dashboard
    And I validate the current broker certification status is "NOT APPROVED"
    Then I click on broker userName and logout

  @SLER-2336
  Scenario: Admin validate the certification status not approved
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "1900026629" "6803810976" to search user
    Then I click on Search button in AP dashboard page
    And I select the first broker record from the search results
    Then I validate I am on the "AP Broker dashboard" page
    And I wait for 500 milliseconds
    Then I validate the status certification is "NOT APPROVED"
    And I logout from Admin Portal




