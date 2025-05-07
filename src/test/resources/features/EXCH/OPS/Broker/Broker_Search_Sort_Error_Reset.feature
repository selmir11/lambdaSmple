@OPS @ExchBroker
Feature: Broker
  @SLER-1180
  Scenario: SLER-1180  Broker: Search, sort, reset, and error
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I click on Search button in AP dashboard page
    Then I verify error for required at least one search criteria on admin portal search page
    When I enter the following data for QA or STG:
      | FieldName           | QA Value                 | STG Value       |
      | accountID           | 8510935600               | 8510935600      |
      | FirstName           | Amethyst                 | Amethyst        |
      | LastName            | Broker                   | Broker          |
      | PrimaryPhone        | 432-432-5555             | 432-432-5555    |
      | LicenseNumber       | 456787654                | 456787654       |
    Then I click on Search button in AP dashboard page
    Then I verify account results for "Broker" on admin portal search page
    When I click on reset button on admin portal search page
    Then I verify data in the fields on the admin portal search page should be blank
      | accountID        |
      | FirstName        |
      | LastName         |
      | Email            |
      | PrimaryPhone     |
      | License Number  |
    Then I enter an "FirstName" in any env "dst" "adstn" to search user
    Then I wait for 2000 milliseconds
    Then I click on Search button in AP dashboard page
    When I select "Sort by: First Name A to Z"
    Then I validate the list is sorted in order by "First Name" and "asc"
    When I select "Sort by: First name Z to A"
    Then I validate the list is sorted in order by "First Name" and "desc"
    When I select "Sort by: Last name A to Z"
    Then I validate the list is sorted in order by "Last Name" and "asc"
    When I select "Sort by: Last name Z to A"
    Then I validate the list is sorted in order by "Last Name" and "desc"
    When I select "Sort by: Account ID Low to High"
    Then I validate the list is sorted in order by "Account ID" and "asc"
    When I select "Sort by: Account ID High to Low"
    Then I validate the list is sorted in order by "Account ID" and "desc"
    Then I refresh the page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an "FirstName" in any env "a" "a" to search user
    Then I click on Search button in AP dashboard page
    Then I wait for 1000 milliseconds
#    Then I validate message for over hundred records OPS 6314