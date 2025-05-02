@OPS @Exch @IndiviualDashboard
Feature: Ind Dash: Reports: Verify Contact Sophpo scan Coverage Upsert
  @SLER-157
  Scenario: Ind Dash: Verify Contact upsert
    Given I open the login page on the "admin" portal
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I enter an accountId in any Env "4006908635" "4006215397" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I verify Reports container title
    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    Then I verify "BE_ATL_CONTACT_UPSER.." and following events are displaying as "2021-09-30T09:19:25" "" "" "Contact Upsert" "response" "SUCCESS"
    Then I verify "SE_ENRLLMT_SUBMITTED.." and following events are displaying as "2021-11-19T14:04:50" "unknown" "unknown" "Purchased and enrolled in.." "APTC (appliedTo.." ""
    Then I verify "BE_ATL_DOC_VERIFY_UP.." and following events are displaying as "2020-10-19T08:48:19" "" "" "CRM Upsert Document Verif.." "response" "SUCCESS"
    And I logout from Admin Portal