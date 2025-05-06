@OPS @COCO
Feature: CoCo Password Reset Via Account Access - CCRT-516
  @SLCR-777
  Scenario: CoCo Account Access details tab Reset Password with Outlook
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "6903960637" "5290277200" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click "Manage Account Access" from account summary container
    Then I verify Account Access details
    And I verify Account status is Password Reset
    When I check on Reset user's password checkbox and click on save
    Then I verify success message is displaying
    And I close current tab and switch back to previous tab
    And I logout from Admin Portal
    And I validate I am on the "Login" page
  @SLCR-777
  Scenario: Reset Password with Outlook
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "Password Reset Link" in "English"
    Then I click the password reset link
    Then I delete the open notice
    And I sign out of Outlook
  @SLCR-777
  Scenario: CoCo Reset Password and check Activity log
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "6903960637" "5290277200" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    Then I verify "ID_PW_RESET_AP" and following events are displaying as "todays date within last 10 min timestamp" "C4test.aduser12.." "C4testaduser123.." "Password Reset via Admin .." "Response" "SUCCESS"
    And I logout from Admin Portal
    And I validate I am on the "Login" page

