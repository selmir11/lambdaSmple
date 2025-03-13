@OPS
Feature: This scenario checks Admin LCE Access role positive and negative scenario
  @SLER-234 @AdminLCE
  Scenario: Verify admin LCE link and permission
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I click "Admin LCE" from application links dropdown
    And I initiate incoming page
    Then I validate I am on the "Admin LCE" page
    And I validate Admin Lce container title text
    And I logout from Admin Portal LCE
    And I close current tab and switch back to previous tab
    And I validate I am on the "Login" page
    Then I open the login page on the "admin" portal
    Then I login as Admin User any environment "adminPortalSEReport_UN_STG" password "adminPortalSEReport_PW_STG" and "adminPortalSEReport_UN_QA" password "adminPortalSEReport_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I validate "Admin LCE" application link not display
    And I logout from Admin Portal LCE