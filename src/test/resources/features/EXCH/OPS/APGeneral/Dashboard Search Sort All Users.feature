@OPS
Feature: Dashboard Search Sort All Users
  @SLER-2359
  Scenario: SLER-2359 OPS: IndDash: Search, sort, error, and reset
    Given I open the login page on the "admin" portal
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I click on Search button in AP dashboard page
    Then I verify error for required at least one search criteria on admin portal search page
    Then I wait for 1000 milliseconds
    When I click on reset button on admin portal search page
    When I enter the following data for QA or STG:
      | FieldName           | QA Value                 | STG Value       |
      | accountID           | 9083564085               | 9083564085      |
      | FirstName           | Jack                     | Jack            |
      | LastName            | sprat                    | sprat           |
      | Email               | jack.Sprat@invalid.com   | jack.Sprat@invalid.com|
      | PrimaryPhoneNumber  | 567-898-7654             | 567-898-7654    |
      | DOB                 | 03/01/1990               | 01/13/2020      |
    Then I click on Search button in AP dashboard page
    Then I wait for 1000 milliseconds
    Then I verify account results for "indiviual" on admin portal search page
    When I click on reset button on admin portal search page
    Then I verify data in the fields on the admin portal search page should be blank
      | accountID        |
      | FirstName        |
      | LastName         |
      | Email            |
      | DOB              |
      | PrimaryPhoneNumber|
    Then I enter an "FirstName" in any env "apelizng" "apelizaa" to search user
    Then I wait for 5000 milliseconds
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
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "FirstName" in any env "a" "a" to search user
    Then I click on Search button in AP dashboard page
    Then I wait for 5000 milliseconds
    Then I validate message for over hundred records
    When I click on reset button on admin portal search page
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
  Scenario: SLER-2359  Agency: Search, sort, reset, and error
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Agency" checkbox on Admin Portal Dashboard
    Then I click on Search button in AP dashboard page
    Then I verify error for required at least one search criteria on admin portal search page
    When I enter the following data for QA or STG:
      | FieldName                   | QA Value                 | STG Value       |
      | AgencyName                  | Quantum Gemerald Agency  | Quantum Gemerald Agency |
      | StateLicenseNumber          | 3453534543543            | 798567889      |
      | AgencyEmail                 | Gem.Agency@invalid.com   | Gem.Agency@invalid.com|
      | BusinessAddressCity         | Denver                   | Denver          |
      | BusinessAddressZipCode      | 80222                    | 80222            |
    Then I click on Search button in AP dashboard page
    Then I verify account results for "Agency" on admin portal search page
    When I click on reset button on admin portal search page
    Then I verify data in the fields on the admin portal search page should be blank
      | AgencyName        |
      | StateLicenseNumber|
      | AgencyEmail             |
      | BusinessAddressCity |
      | BusinessAddressZipCode |
    Then I enter an "StateLicenseNumber" in any env "1234567890" "1234567890" to search user
    Then I wait for 5000 milliseconds
    Then I click on Search button in AP dashboard page
    When I select "Sort by: Agency name A to Z"
    Then I validate the list is sorted in order by "Agency Name" and "asc"
    When I select "Sort by: Agency name Z to A"
    Then I validate the list is sorted in order by "Agency Name" and "desc"
    When I select "Sort by: Agent A to Z"
    Then I validate the list is sorted in order by "Agent" and "asc"
    When I select "Sort by: Agent Z to A"
    Then I validate the list is sorted in order by "Agent" and "desc"
    Then I refresh the page
    And I select "Agency" checkbox on Admin Portal Dashboard
    Then I enter an "AgencyName" in any env "a" "agency" to search user
    Then I click on Search button in AP dashboard page
    Then I wait for 20000 milliseconds
    Then I validate message for over hundred records
    When I click on reset button on admin portal search page
  Scenario: SLER-2359  Program Manager dashboard: Search, sort, reset, and error
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
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
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Program Manager dashboard" page


