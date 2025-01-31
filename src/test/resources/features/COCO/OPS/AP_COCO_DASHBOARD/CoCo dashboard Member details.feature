@OPS
Feature: CoCo dashboard: Member details
  @SLCR-742
  Scenario: CoCo dashboard: Member details
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "6907300947" "" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
   # Then I validate Selected Member data on the far left side
  And I validate CoCo Selected Member data on the far left side
  |   Full Name   |   User Name   |

  
   # And logout from Admin Portal