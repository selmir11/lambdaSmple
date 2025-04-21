@OPS
Feature: Agency
  @SLER-1782
  Scenario: SLER-1782  Agency: Search, sort, reset, and error
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
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
    Then I wait for 15000 milliseconds
    Then I validate message for over hundred records