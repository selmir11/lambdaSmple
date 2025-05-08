@OPS @COCO @UserDashboard
Feature: AP Create account - Application Links, Admin Portal user creation
  @SLCR-709
  Scenario:SLCR-709:Admin Portal - Architecture user creates Admin Portal account with already used email to check error message then create unique A P user
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalAccountManagement_UN_STG" password "adminPortalAccountManagement_PW_STG" and "AdminPortalAccountManagement_UN_QA" password "AdminPortalAccountManagement_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I click "AP Account Creation" from application links dropdown
    And I enter my Admin Portal user data with email that is already in use
    And I wait for 200 milliseconds
    Then I validate the expected error message is displayed as expected
    Then I click "AP Account Creation" from application links dropdown
    And I enter general data to create admin account with email "MGC4testing"
    And I wait for 200 milliseconds
    Then I validate the Success message is displayed
    And I logout from Admin Portal
  @SLCR-709
  Scenario:SLCR-709:Admin Portal - Not architecture user have no link for AP Create Account, negative check
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I open the login page on the "admin" portal
    Then I login as Admin User any environment "adminPortalDLT_UN_STG" password "adminPortalDLT_PW_STG" and "adminPortalSEReport_UN_QA" password "adminPortalSEReport_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I validate "AP Account Creation" application link not display
    And I logout from Admin Portal

  @SLCR-911
  Scenario:SLCR-911:Admin Portal - OPS: CoCo: IndDash: Create account[CCRT-230]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Admin Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I click create account on admin portal
    And I enter general mandatory data for "coco" account creation
    Then I verify account created successfully message displays
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    Then I validate user name on Selected Member data on the far left side
    And I logout from Admin Portal

  @SLCR-912
  Scenario:SLCR-912:Verify coco account created and able to access by OBO [CCRT-228]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Admin Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I click create account on admin portal
    And I enter general mandatory data for "coco" account creation
    Then I verify account created successfully message displays
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    Then I validate user name on Selected Member data on the far left side
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I switch to the tab number 1
    Then I validate welcome page title for coco
    Then I close current tab and switch back to previous tab
    And I logout from Admin Portal

