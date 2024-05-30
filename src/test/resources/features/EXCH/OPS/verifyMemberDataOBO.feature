@SLER-312
@OPS

Feature: Admin Portal as OBO verify member data on the left

  Scenario: Verify member data
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User
    And I validate I am on the "Admin search" page
    Then I enter an accountId in any Env "QA" "2425005563" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I validate selected Member data on the left side
    And logout from Admin Portal
    