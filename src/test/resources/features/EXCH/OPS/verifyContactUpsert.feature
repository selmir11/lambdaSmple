@OPS
Feature: Ind Dash: Reports: Verify Contact Sophpo scan Coverage Upsert
  @SLER-157 @Upserts
  Scenario: Ind Dash: Verify Contact upsert
    Given I open the login page on the "admin" portal
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I enter an accountId in any Env "4006908635" "4006215397" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I verify "Reports" container title
    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    Then I validate "BE_ATL_CONTACT_UPSER.." "" "2022-10-20T17:12:05" "Customer record is transf.." in account activity table
    Then I validate "SOPHOS_INTELLIX_SCAN" "C4test.aduser12.." "2022-05-13T12:42:16" "" in account activity table
    Then I validate "BE_ATL_DOC_VERIFY_UP.." "" "2022-05-13T12:42:16" "CRM Upsert Document Verif.." in account activity table
    And I logout from Admin Portal