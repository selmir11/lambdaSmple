@SLER-157
# Tags: optional

Feature: Ind Dash: Verify Contact and Coverage Upserts

  Scenario: Ind Dash: Verify Contact
    Given I open the login page on the "admin" portal
    Then I login as Admin User
    And I validate I am on the "Admin dashboard" page
    And I enter specific "4006215397 " account number
    Then I click search button on admin portal
    And I click acct in Search Results table on admin portal
