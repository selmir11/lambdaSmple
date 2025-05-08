@OPS @COCO @UserDashboard
Feature: OPS: IndDash: CoCo Account Access details and Password Reset - CCRT-135
  @SLCR-748
  Scenario:SLCR-748:CoCo Account Access details tab Reset Password
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Admin Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "coco" account creation
    Then I verify account created successfully message displays
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    Then I click "Manage Account Access" from account summary container
    Then I verify Account Access details
    And I verify Account status is active
    When I check on checkbox account and click on save
    Then I verify success message is displaying
    When I check on checkbox account and click on save
    Then I verify Account status is suspended
    When I check on Reset user's password checkbox and click on save
    Then I verify success message is displaying
    And I close current tab and switch back to previous tab
    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    Then I verify "ID_PW_RESET_AP" and following events are displaying as "todays date within last 10 min timestamp" "C4test.aduser12.." "C4testaduser123.." "Password Reset via Admin .." "Response" "SUCCESS"
    And I logout from Admin Portal


