@OPS @Exch @IndiviualDashboard
Feature: OPS: IndDash: Account Access details and password reset
  @SLER-1794
  Scenario:SLER-1794 : OPS: IndDash: Account Access details and password reset
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    Then I verify account created successfully message displays
    And I search for user and click email from search results
    Then I click on "Manage Account Access" user dashboard button
    Then I verify Account Access details
    And I verify Account status is active
    When I check on Reset user's password checkbox and click on save
    Then I verify success message is displaying
    Then I close current tab and switch back to previous tab
    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    Then I verify "ID_PW_RESET_AP" and following events are displaying as "todays date within last 10 min timestamp" "C4test.aduser12.." "C4testaduser123.." "Password Reset via Admin .." "Response" "SUCCESS"
