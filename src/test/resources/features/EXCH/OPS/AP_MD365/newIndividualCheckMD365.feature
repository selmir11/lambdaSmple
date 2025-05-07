@OPS @Exch @MD365
Feature: OPS: Create individual account and verify that can be found in MD365
  @SLER-1872
  Scenario:SLER-1872:OPS: IndDash: Create individual account
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    Then I verify account created successfully message displays
    And I search for user and click email from search results
    And I wait for 70000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
    Then I sign out of CRM
    And I validate I am on the "MD365 Login" page

