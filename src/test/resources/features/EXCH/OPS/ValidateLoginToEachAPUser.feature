@SLER-493
Feature: APGeneral- Log into each AP User

  Background:
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
  @SLER-493
  Scenario: OPS- APGeneral: Login into Admin Portal Super User
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    Then I validate I am on the "Admin dashboard" page
    And I logout from Admin Portal

  @SLER-493
  Scenario: OPS- APGeneral: Login into Admin Portal LCE
    And I login as Admin User any environment "adminPortalAdminLCE_UN_STG" password "adminPortalAdminLCE_PW_STG" and "adminPortalAdminLCE_UN_QA" password "adminPortalAdminLCE_PW_QA"
    Then I validate I am on the "Admin dashboard" page
    And I logout from Admin Portal

  @SLER-493
  Scenario: OPS- APGeneral: Login into Admin Portal DLT
    And I login as Admin User any environment "adminPortalDLT_UN_STG" password "adminPortalDLT_PW_STG" and "adminPortalDLT_UN_QA" password "adminPortalDLT_PW_QA"
    Then I validate I am on the "Admin dashboard" page
    And I logout from Admin Portal

  @SLER-493
  Scenario: OPS- APGeneral: Login into AdminPortal Account Management
    And I login as Admin User any environment "adminPortalAccountManagement_UN_STG" password "adminPortalAccountManagement_PW_STG" and "adminPortalAccountManagement_UN_QA" password "adminPortalAccountManagement_PW_QA"
    Then I validate I am on the "Admin dashboard" page
    And I logout from Admin Portal

  @SLER-493
  Scenario: OPS- APGeneral: Login into Admin Portal Cancel
    And I login as Admin User any environment "adminPortalCancelEnrollment_UN_STG" password "adminPortalCancelEnrollment_PW_STG" and "adminPortalCancelEnrollment_UN_QA" password "adminPortalCancelEnrollment_PW_QA"
    Then I validate I am on the "Admin dashboard" page
    And I logout from Admin Portal

  @SLER-493
  Scenario: OPS- APGeneral: Login into Admin Portal SE Reports
    And I login as Admin User any environment "adminPortalSEReport_UN_STG" password "adminPortalSEReport_PW_STG" and "adminPortalSEReport_UN_QA" password "adminPortalSEReport_PW_QA"
    Then I validate I am on the "Admin dashboard" page
    And I logout from Admin Portal

  Scenario: OPS- APGeneral: Login into Admin Portal Edit Enrollment
    And I login as Admin User any environment "adminPortalEditEnrollment_UN_STG" password "adminPortalEditEnrollment_PW_STG" and "adminPortalEditEnrollment_UN_QA" password "adminPortalEditEnrollment_PW_QA"
    Then I validate I am on the "Admin dashboard" page
    And I logout from Admin Portal

  @SLER-493
  Scenario: OPS- APGeneral: Login into Admin Portal Program Manager
    And I login as Admin User any environment "adminPortalProgramManager_UN_STG" password "adminPortalProgramManager_PW_STG" and "adminPortalProgramManager_UN_QA" password "adminPortalProgramManager_PW_QA"
    Then I validate I am on the "Admin dashboard" page
    And I logout from Admin Portal