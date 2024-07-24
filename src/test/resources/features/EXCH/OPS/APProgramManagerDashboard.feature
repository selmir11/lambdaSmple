@OPS
Feature: Program Manager Dashboard- Verify program manager data
  @SLER-710
  Scenario: Verify Program Manager Dashboard
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I select "Program Manager" checkbox on Admin Portal Dashboard
    And I enter an "Email" in any env "profile@test.com" "editprofiletest@c4.com" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Program Manager" page
    Then I verify Primary account holder and account number displays
    And I verify Program Manager information Account Summary
    And I validate all program manager dashboard container titles are displayed
    And I verify Program Manager contract status
    And I verify Program Manager Account Activity Container
    And I Verify Program Manager Client Information : "There is no client information."
    And I click Go Back on admin portal program manager dashboard
    Then I validate I am on the "Admin search" page
    Then I logout from Admin Portal