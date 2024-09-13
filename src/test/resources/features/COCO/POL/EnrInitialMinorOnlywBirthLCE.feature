Feature: Initial Application Minor only with Birth LCE(Admin OBO)
  @SLCR-299
  Scenario: Minor only with Birth LCE(Admin OBO)

    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "Admin coco" account creation with email "MGC4testing"@outlook.com
    And I search for user and click email from search results
    


