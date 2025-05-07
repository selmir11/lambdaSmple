@OPS @Exch @IndiviualDashboard
Feature: This scenario checks Access Denied for other users that should not use the portal : positive and negative scenario
  @SLER-225
  Scenario:SLER-225: Verify Individual user has no permission to login into Admin Portal
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as "MGC4testing+dotwgpkaiTest@outlook.com" and "ALaska13!" individual existing user
    Then I see new alarming page
  @SLER-225
  Scenario:SLER-225 Verify Broker user has no permission to login into Admin Portal
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as "Amethyst.Broker@invalid.com" and "ALaska13!" individual existing user
    Then I see new alarming page
  @SLER-225
  Scenario:SLER-225 Verify Program Manager user has no permission to login into Admin Portal
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as "Amethyst.Broker@invalid.com" and "ALaska13!" individual existing user
    Then I see new alarming page
  @SLER-225
  Scenario:SLER-225 Verify admin permission in Admin Portal
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I logout from Admin Portal

