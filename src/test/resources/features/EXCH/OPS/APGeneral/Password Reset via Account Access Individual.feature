@OPS @APGeneral
Feature: OPS: IndDash: Password Reset via Account Access
  @SLER-2273
  Scenario:SLER-2273 : OPS: IndDash: Password Reset via Account Access
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Admin Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "1504077311" "9042860091" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Account Access" user dashboard button
    Then I verify Account Access details
    And I verify Account status is Password Reset
    When I check on Reset user's password checkbox and click on save
    Then I verify success message is displaying
    Then I close current tab and switch back to previous tab
    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    Then I verify "ID_PW_RESET_AP" and following events are displaying as "todays date within last 10 min timestamp" "C4test.aduser12.." "C4testaduser123.." "Password Reset via Admin .." "Response" "SUCCESS"
    Then I verify "UI_PASSWORD_RESETLIN.." and following events are displaying as "todays date within last 10 min timestamp" "EO_LOGIN_PORTAL" "EO_LOGIN_PORTAL" "User initiated Password R.." "UI_PASSWORD_RES.." "Password Reset"