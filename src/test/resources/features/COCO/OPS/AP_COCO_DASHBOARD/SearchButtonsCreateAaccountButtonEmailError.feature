@OPS @COCO @UserDashboard
Feature: OPS: COCO: Search buttons Create account button - CCRT-138
  @SLCR-756
  Scenario:SLCR-756:OPS: COCO: Create account
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I validate the buttons on the Individual Search page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I click create account on admin portal
    And I wait for 300 milliseconds
    And I enter duplicate email data for account creation for "coco"
    Then I validate the error messages in "coco" for email already exists
    And I click on Submit button to see the error as A valid Email is required
    And I validate I am on the "Create Account" page
