Feature: Broker Dashboard- Change license and certification statuses

  @SLER-748
  Scenario: Verify Broker Dashboard in Admin Portal -  Change license and certification statuses
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "4007335519" "5110437090" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I click Manage Certification button
    And I validate current Broker License Status: "APPROVED" and License Expiration Date: "" with Certification Status: "APPROVED"
    Then I change statuses and click Save button in manage certification container
    Then I click Manage Certification button
    And I validate current Broker License Status: "Not Approved" and License Expiration Date: "" with Certification Status: "Not Approved"
    Then I click Cancel button
    Then I click Manage Certification button
    Then I change statuses back and click Save
    And I logout from Admin Portal

  @SLER-748
  Scenario: Verify in Broker portal status is Approved
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "acctsforc4testing+peF8qXUj3@gmail.com" password "ALaska12!" and "acctsforc4testing+dnROHtlJu@gmail.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "eluniaxm@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click Agency Dashboard
    And I validate in Broker portal Certification Status: "APPROVED"
    Then I click on broker userName and logout
