@OPS @Exch @IndiviualDashboard
Feature: OPS: IndDash: Create account
  @SLER-1269
  Scenario:SLER-1269:OPS: IndDash: Create account
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
   Then I verify account created successfully message displays
    And I search for user and click email from search results