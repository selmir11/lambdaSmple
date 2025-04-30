@SLER-1033 @LoginPortalAnonymousHeader
Feature: Rerouting Admin Users to Individual sign in page when they sign out and they can see the dropdown options

  @SLER-1033
  Scenario: Admin user should be able to click ‘Admin Portal’ option and navigate to the admin portal login page (English)
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    Then I validate I am on the "Admin search" page
    And I logout from Admin Portal
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Admin Portal" requested
    And I validate I am on the "Admin Login" page

    @SLER-1033
  Scenario: Admin user should be able to click ‘Program Manager Account’ option and navigate to the assistnet portal (English)
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    Then I validate I am on the "Admin search" page
    And I logout from Admin Portal
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Program Manager Account" requested
    And I validate I am on the "Program Manager Login" page

  @SLER-1033
  Scenario: Admin user should be able to click ‘Program Manager Account’ option and navigate to the assistnet portal (English)
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    Then I validate I am on the "Admin search" page
    And I logout from Admin Portal
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Broker Portal" requested
    And I validate I am on the "Broker Portal Login" page

  @SLER-1033
  Scenario: Admin user should be able to click ‘Admin Portal’ option and navigate to the admin portal login page (Spanish)
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    And I change the language from header to "Spanish Login"
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    Then I validate I am on the "Admin search" page
    And I logout from Admin Portal
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal SP" and validate the options text in the login page
    Then I click the option "Portal del administrador" requested
    And I validate I am on the "Admin Login" page

  @SLER-1033
  Scenario: Admin user should be able to click ‘Cuenta del gerente de programa’ option and navigate to the assistnet portal (Spanish)
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    And I change the language from header to "Spanish Login"
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    Then I validate I am on the "Admin search" page
    And I logout from Admin Portal
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal SP" and validate the options text in the login page
    Then I click the option "Cuenta del gerente de programa" requested
    And I validate I am on the "Program Manager Login" page

  @SLER-1033
  Scenario: Admin user should be able to click ‘Portal del agente’ option and navigate to the broker portal (Spanish)
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    And I change the language from header to "Spanish Login"
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    Then I validate I am on the "Admin search" page
    And I logout from Admin Portal
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal SP" and validate the options text in the login page
    Then I click the option "Portal del agente" requested
    And I validate I am on the "Broker Portal Login" page
    