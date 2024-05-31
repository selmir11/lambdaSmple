@SLER-534
@OPS @RT-1087

Feature: Admin Portal agency verify data

  Scenario: Verify agency data
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
  And I select "Agency" checkbox on Admin Portal Dashboard
  



  # Then I enter an accountId in any Env "2425005563" "2425005563" to search user
  #  And I click on Search button in AP dashboard page
#    And I click acct first row from Search Results table in admin portal
#    And I validate I am on the "Admin Portal individual dashboard" page
#    Then I verify Primary account holder and account number displays
#    Then I validate selected Member data on the left side
#    And logout from Admin Portal