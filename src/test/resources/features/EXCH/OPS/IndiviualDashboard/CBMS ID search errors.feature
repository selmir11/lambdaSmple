@OPS @Exch @IndiviualDashboard @CBMS
Feature: CBMS : search errors
  @SLER-2365
  Scenario:SLER-2365 CBMS: Error Messages
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I click "CBMS Case ID Search" from application links dropdown
    Then I verify Title for CBMS page
    And I validate CBMS ID search labels are displayed as expected
    Then I click on Search button in CBMS Case ID Search page
    And I validate errors for required fields are displayed
    Then I click on Reset button in CBMS Case ID Search page
    And I wait for 1000 milliseconds
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "ELIG Contact Us" page and close tab
    Then I verify text "Copy Rights" in the Header or in the Footer
