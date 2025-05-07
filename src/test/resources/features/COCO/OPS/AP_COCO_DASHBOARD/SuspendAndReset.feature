@OPS @COCO @UserDashboard
Feature: OPS: IndDash: Account Access details and password reset
  @SLCR-649
  Scenario:SLCR-649:OPS: IndDash: Account Access details and password reset
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "2611002376" "6701940086" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on "Manage Account Access" user dashboard button
    Then I verify Account Access details
    When I check on checkbox account and click on save
    Then I verify success message is displaying
    Then I close current tab and switch back to previous tab
    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    Then I verify "BE_SUSPEND_USER_ACCE.." and following events are displaying as "todays date within last 10 min timestamp" "C4test.aduser12.." "C4testaduser123.." "Suspend User Access" "Response" "SUCCESS"
    Then I close current tab and switch back to previous tab
    Then I click on "Manage Account Access" user dashboard button
    When I check on checkbox account and click on save
    Then I verify success message is displaying
    Then I close current tab and switch back to previous tab
    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    Then I verify "BE_ACTIVATE_USER_ACC.." and following events are displaying as "todays date within last 10 min timestamp" "C4test.aduser12.." "C4testaduser123.." "Activate User Access" "Response" "SUCCESS"
    Then I close current tab and switch back to previous tab
    Then I click on "Manage Account Access" user dashboard button
    When I check on Reset user's password checkbox and click on save
    Then I verify success message is displaying
    Then I close current tab and switch back to previous tab
    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    Then I verify "ID_PW_RESET_AP" and following events are displaying as "todays date within last 10 min timestamp" "C4test.aduser12.." "C4testaduser123.." "Password Reset via Admin .." "Response" "SUCCESS"