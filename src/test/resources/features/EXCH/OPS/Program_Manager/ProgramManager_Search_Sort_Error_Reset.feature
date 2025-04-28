@OPS @Exch @ProgramManager
Feature: Programme Manager
  @SLER-1031
  Scenario: SLER-1031  PMDash: Search, sort, reset, and error
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I click on Search button in AP dashboard page
    Then I verify error for required at least one search criteria on admin portal search page
    When I enter the following data for QA or STG:
      | FieldName           | QA Value                 | STG Value       |
      | accountID           | 2640006565               | 9005375045      |
      | FirstName           | John                     | adszcnkgvl      |
      | LastName            | Winterhouse              | adsdzazuqql     |
      | Email               | johnc4hcoautomation+     | c4assistorportal|
      | PrimaryPhone        | 760-579-8438             | 333-328-9892    |
      | OrganisationName    | Organ                    | stg             |
      | siteID              | jrzvp                    | eNrQp           |
    Then I click on Search button in AP dashboard page
    Then I verify account results for "Program Manager" on admin portal search page
    When I click on reset button on admin portal search page
    Then I verify data in the fields on the admin portal search page should be blank
      | accountID        |
      | FirstName        |
      | LastName         |
      | Email            |
      | PrimaryPhone     |
      | OrganisationName |
      | siteID           |
    Then I enter an "FirstName" in any env "adst" "adst" to search user
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
    And I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I enter an "FirstName" in any env "ad" "ad" to search user
    Then I click on Search button in AP dashboard page
    Then I wait for 1000 milliseconds
    Then I validate message for over hundred records