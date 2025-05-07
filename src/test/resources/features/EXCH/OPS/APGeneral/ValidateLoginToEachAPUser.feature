@APGeneral
Feature: APGeneral- Log into each AP User

  Background:
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
  @SLER-493
  Scenario Outline:SLER-493:OPS- APGeneral: Login into Admin Portal Super User
    When I login as Admin User any environment "<APUserSTG>" password "<PWSTG>" and "<APUserQA>" password "<PWQA>"
    Then I validate I am on the "Admin dashboard" page
    And I logout from Admin Portal
    Examples:
      | APUserSTG                           | PWSTG                               | APUserQA                           | PWQA                               |
      | adminPortalADUser_UN_STG            | adminPortalADUser_PW_STG            | adminPortalADUser_UN_QA            | adminPortalADUser_PW_QA            |
      | adminPortalAdminLCE_UN_STG          | adminPortalAdminLCE_PW_STG          | adminPortalAdminLCE_UN_QA          | adminPortalAdminLCE_PW_QA          |
      | adminPortalDLT_UN_STG               | adminPortalDLT_PW_STG               | adminPortalDLT_UN_QA               | adminPortalDLT_PW_QA               |
      | adminPortalAccountManagement_UN_STG | adminPortalAccountManagement_PW_STG | adminPortalAccountManagement_UN_QA | adminPortalAccountManagement_PW_QA |
      | adminPortalCancelEnrollment_UN_STG  | adminPortalCancelEnrollment_PW_STG  | adminPortalCancelEnrollment_UN_QA  | adminPortalCancelEnrollment_PW_QA  |
      | adminPortalSEReport_UN_STG          | adminPortalSEReport_PW_STG          | adminPortalSEReport_UN_QA          | adminPortalSEReport_PW_QA          |
      | adminPortalEditEnrollment_UN_STG    | adminPortalEditEnrollment_PW_STG    | adminPortalEditEnrollment_UN_QA    | adminPortalEditEnrollment_PW_QA    |
      | adminPortalProgramManager_UN_STG    | adminPortalProgramManager_PW_STG    | adminPortalProgramManager_UN_QA    | adminPortalProgramManager_PW_QA    |

