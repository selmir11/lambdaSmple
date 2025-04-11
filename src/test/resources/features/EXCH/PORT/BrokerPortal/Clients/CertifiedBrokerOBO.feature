@BrokerPortalClients @port
Feature:  Certify broker able to work obo and not certify broker cannot work on obo

  @SLER-2311
  Scenario:  Certify broker able to work obo and not certify broker cannot work on obo
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "cmtzynss@test.com" password "ALaska12!" and "a.c.ct.sfo.rc4.testin.g@gmail.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Portal Your Clients" page
    Then I click Broker Dashboard
    And I validate the current broker certification status is "APPROVED"
    Then I click View Your Clients button
    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the MVR container text in the dashboard Page
    And I wait for 500 milliseconds
    And I search for a client named for staging "ssen" or for QA "ssen"
    And I wait for 500 milliseconds
    And I click on the first client in my list
    Then I verify that my client's current status is "NO ELIGIBILITY"
    And I click "manage" the client

    Then I validate I am on the "Account Overview" page
    Then I click on the Colorado Connect or C4 Logo in the "NonElmo" Header
    And I validate I am on the "Broker Portal Your Clients" page
    Then I click on broker userName and logout
    And I close current tab and switch back to previous tab


    #Updating the broker certification status to NOT APPROVED
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "6809760956" "9066471088" to search user
    Then I click on Search button in AP dashboard page
    And I select the first broker record from the search results
    Then I validate I am on the "AP Broker dashboard" page
    And I click Manage Certification button
    Then I change the certification status to "not approved"
    And I wait for 500 milliseconds
    Then I validate the status certification is "NOT APPROVED"
    And I logout from Admin Portal


    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "cmtzynss@test.com" password "ALaska12!" and "a.c.ct.sfo.rc4.testin.g@gmail.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I validate I am on the "Broker Portal Your Clients" page
    Then I click Broker Dashboard
    And I validate the current broker certification status is "NOT APPROVED"
    Then I click View Your Clients button
    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the MVR container text in the dashboard Page
    And I wait for 1000 milliseconds
    And I search for a client named for staging "ssen" or for QA "ssen"
    And I wait for 1000 milliseconds
    Then I validate The Client is removed successfully
    Then I click on broker userName and logout
    And I close current tab and switch back to previous tab

#Updating the broker certification status to APPROVED
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "6809760956" "9066471088" to search user
    Then I click on Search button in AP dashboard page
    And I select the first broker record from the search results
    Then I validate I am on the "AP Broker dashboard" page
    And I click Manage Certification button
    Then I change the certification status to "approved"
    And I wait for 500 milliseconds
    Then I validate the status certification is "APPROVED"
    And I logout from Admin Portal
