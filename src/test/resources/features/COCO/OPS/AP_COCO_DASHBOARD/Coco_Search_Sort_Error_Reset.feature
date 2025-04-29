@OPS @COCO
Feature: Coco Dashboard
  @SLCR-638
  Scenario: SLCR-638 OPS: Coco: IndDash: Search, sort, error, and reset
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I click on Search button in AP dashboard page
    Then I verify error for required at least one search criteria on admin portal search page
    When I enter the following data for QA or STG:
      | FieldName           | QA Value                 | STG Value       |
      | accountID           | 2008008265               | 6703170627      |
      | FirstName           | Betty                    | apeliznjsxs     |
      | LastName            | Bertha                   | apindaikibrk    |
      | Email               | tspellnoticetesting      | MGC4Test+apindaikibrkapeliz@gmail.com|
      | PrimaryPhoneNumber  | 719-555-1212             | 374-649-8737    |
      | DOB                 | 03/05/1989               | 02/01/1983      |
    Then I click on Search button in AP dashboard page
    Then I verify account results for "coco" on admin portal search page
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
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an "FirstName" in any env "a" "a" to search user
    Then I click on Search button in AP dashboard page
    Then I wait for 1000 milliseconds
    Then I validate message for over hundred records

  @SLCR-940
  Scenario: verify all search type options with sort [CCRT-134]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I click on Search button in AP dashboard page
    When I enter the following data for QA or STG:
      | FieldName           | QA Value                 | STG Value       |
      | accountID           | 9083564085               | 9083564085      |
      | FirstName           | Jack                     | Jack            |
      | LastName            | sprat                    | sprat           |
      | Email               | jack.Sprat@invalid.com   | jack.Sprat@invalid.com|
      | PrimaryPhoneNumber  | 567-898-7654             | 567-898-7654    |
      | DOB                 | 03/01/1990               | 01/13/2020      |
    Then I click on Search button in AP dashboard page
    Then I wait for 100 milliseconds
    Then I verify search results for "individual" on admin portal search page
      | FieldName           |          QA Value               | STG Value           |
      | accountID           | 9083564085                      | 9083564085          |
      | FirstName           | Jack                            | Jack                |
      | LastName            | Sprat                            | Sprat               |
      |Primary HolderName   | Jack Sprat                       | Jack Sprat          |
      | DOB                 | 03/01/1990                       | 01/13/2020           |
      | Email               | Jack.Sprat@invali..             | Jack.Sprat@invali..   |
      | PrimaryPhoneNumber  | 567-898-7654                    | 567-898-7654          |
      |Broker Association   | Diamond Broker..                | Diamond Broker..      |
    Then I verify default value in sort by filter dropdown
  |Sort by: First name A to Z|
    And I verify Sort By field values
    |Sort by: First name A to Z|
    |Sort by: First name Z to A |
    |Sort by: Last name A to Z  |
    |Sort by: Last name Z to A  |
    |Sort by: Account ID Low to High |
    |Sort by: Account ID High to Low  |
   Then I click on Reset button in AP dashboard page
    Then I enter an "FirstName" in any env "PrimaryMemberyzvdvkqx" "jack" to search user
    Then I click on Search button in AP dashboard page
    Then I wait for 1000 milliseconds
    Then I validate the list is sorted by account ID in "asc" order
    Then I click on Reset button in AP dashboard page
    Then I wait for 1000 milliseconds
    Then I enter an "FirstName" in any env "a" "a" to search user
    Then I click on Search button in AP dashboard page
    Then I wait for 3000 milliseconds
    Then I validate message for over hundred records
    When I select "Sort by: Account ID High to Low"
    Then I validate the list is sorted in order by "Account ID" and "desc"
    #Broker
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I click on Search button in AP dashboard page
    When I enter the following data for QA or STG:
      | FieldName           | QA Value                 | STG Value       |
      | accountID           | 8510935600               | 8510935600      |
      | FirstName           | Amethyst                 | Amethyst        |
      | LastName            | Broker                   | Broker          |
      | PrimaryPhone        | 432-432-5555             | 432-432-5555    |
      | LicenseNumber       | 456787654                | 456787654       |
    Then I click on Search button in AP dashboard page
    Then I verify search results for "Broker" on admin portal search page
      | FieldName              |          QA Value             | STG Value              |
      | accountID              | 8510935600                    | 8510935600             |
      | FirstName              | Amethyst                      | Amethyst               |
      | LastName               | Broker                        | Broker                 |
      | Email                  |accts.forc4.test.i.n..         | ops.testing+Dsvsp@ou.. |
      | PrimaryPhoneNumber     | 432-432-5555                  | 432-432-5555           |
      |Colorado License Number |     456787654                 | 456787654              |
    |User Type                 |      OWNER                     | OWNER                   |
    Then I verify default value in sort by filter dropdown
      |Sort by: First name A to Z|
    And I verify Sort By field values
      |Sort by: First name A to Z|
      |Sort by: First name Z to A |
      |Sort by: Last name A to Z  |
      |Sort by: Last name Z to A  |
      |Sort by: Account ID Low to High |
      |Sort by: Account ID High to Low  |
    Then I click on Reset button in AP dashboard page
    Then I enter an "FirstName" in any env "bobby" "a" to search user
    Then I click on Search button in AP dashboard page
    Then I validate the list is sorted in order by "Account ID" and "asc" for duplicate matches
    Then I click on Reset button in AP dashboard page
    Then I enter an "FirstName" in any env "a" "a" to search user
    Then I click on Search button in AP dashboard page
    Then I wait for 3000 milliseconds
    # Then I validate message for over hundred records OPS-6314
    When I select "Sort by: Account ID High to Low"
    Then I validate the list is sorted by account ID in "desc" order
    #Program Manager
    And I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I click on Search button in AP dashboard page
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
    Then I verify search results for "Program Manager" on admin portal search page
      | FieldName           |          QA Value           | STG Value               |
      | accountID           | 2640006565                  | 9005375045             |
      | FirstName           | John                        | adszcnkgvl             |
      | LastName            | Winterhouse                 | adsdzazuqql            |
      | Email               | johnc4hcoautomation+..      | c4assistorportal+Rqn..  |
      | PrimaryPhoneNumber  | 760-579-8438                | 333-328-9892             |
      | Organization Name   | Twoeightsevennine           | apifwjbuifspducrphut..   |
      | Site ID             | jrzvp                       | eNrQP                    |
      | User Type           | PROGRAM_MANAGER             | PROGRAM_MANAGER          |
    Then I verify default value in sort by filter dropdown
      |Sort by: First name A to Z|
    And I verify Sort By field values
      |Sort by: First name A to Z|
      |Sort by: First name Z to A |
      |Sort by: Last name A to Z  |
      |Sort by: Last name Z to A  |
      |Sort by: Account ID Low to High |
      |Sort by: Account ID High to Low  |
    Then I click on Reset button in AP dashboard page
    Then I enter an "LastName" in any env "winterhouse" "a" to search user
    Then I click on Search button in AP dashboard page
    Then I validate the list is sorted in order by "Account ID" and "asc" for duplicate matches
    Then I click on Reset button in AP dashboard page
    Then I enter an "FirstName" in any env "ad" "ad" to search user
    Then I click on Search button in AP dashboard page
    Then I wait for 3000 milliseconds
    Then I validate message for over hundred records
    When I select option as "Sort by: Account ID High to Low"
    Then I validate the list is sorted by account ID in "desc" order
    #Agency
    Then I refresh the page
    And I select "Agency" checkbox on Admin Portal Dashboard
    When I enter the following data for QA or STG:
      | FieldName                   | QA Value                 | STG Value       |
      | AgencyName                  | Quantum Gemerald Agency  | Quantum Gemerald Agency |
      | StateLicenseNumber          | 3453534543543            | 798567889      |
      | AgencyEmail                 | Gem.Agency@invalid.com   | Gem.Agency@invalid.com|
      | BusinessAddressCity         | Denver                   | Denver          |
      | BusinessAddressZipCode      | 80222                    | 80222            |
    Then I click on Search button in AP dashboard page
    Then I verify search results for "Agency" on admin portal search page
      | FieldName               |     QA Value              | STG Value                |
      | Agency Name             |  Quantum Gemerald Age..   | Quantum Gemerald Age..   |
      | Agent                   |  Gem Agency               | Gem Agency               |
      | Business Address City    | Denver                    | Denver                  |
      | Colorado License Number  | 3453534543543            | 798567889               |
    Then I verify default value in sort by filter dropdown
    |Sort by: Agency name A to Z|
    And I verify Sort By field values
      |Sort by: Agency name A to Z|
      |Sort by: Agency name Z to A |
      |Sort by: Agent A to Z  |
      |Sort by: Agent Z to A  |
    Then I click on Reset button in AP dashboard page
    Then I enter an "AgencyName" in any env "co brokerage firm" "1234567890" to search user
    Then I click on Search button in AP dashboard page
    Then I validate the list is sorted in order by "Agent" and "asc" for duplicate matches
    Then I click on Reset button in AP dashboard page
    Then I enter an "AgencyName" in any env "broker" "agency" to search user
    Then I click on Search button in AP dashboard page
    Then I wait for 15000 milliseconds
    Then I validate message for over hundred records
    When I select option as "Sort by: Agent A to Z"
    Then I wait for 100 milliseconds
    Then I validate the list is sorted by account ID in "asc" order
    #Coco
    Then I refresh the page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I click on Search button in AP dashboard page
    When I enter the following data for QA or STG:
      | FieldName           | QA Value                 | STG Value       |
      | accountID           | 2008008265               | 6703170627      |
      | FirstName           | Betty                    | apeliznjsxs     |
      | LastName            | Bertha                   | apindaikibrk    |
      | Email               | tspellnoticetesting      | MGC4Test+apindaikibrkapeliz@gmail.com|
      | PrimaryPhoneNumber  | 719-555-1212             | 374-649-8737    |
      | DOB                 | 03/05/1989               | 02/01/1983      |
    Then I click on Search button in AP dashboard page
    Then I verify search results for "coco" on admin portal search page
      | FieldName           |          QA Value               | STG Value       |
      | accountID           | 2008008265                      | 6703170627      |
      | FirstName           | Betty                           | apeliznjsxs     |
      | LastName            | Bertha                          | apindaikibrk    |
      |Primary HolderName   | Betty Bertha                    |apeliznjsxs ap..|
      | DOB                 | 03/05/1989                      | 02/01/1983      |
      | Email               | tspellnoticetesti..             | MGC4Test+apindaik..|
      | PrimaryPhoneNumber  | 719-555-1212                    | 374-649-8737    |
      |Broker Association   |                                  |                 |
    Then I verify default value in sort by filter dropdown
      |Sort by: First name A to Z|
    And I verify Sort By field values
      |Sort by: First name A to Z|
      |Sort by: First name Z to A |
      |Sort by: Last name A to Z  |
      |Sort by: Last name Z to A  |
      |Sort by: Account ID Low to High |
      |Sort by: Account ID High to Low  |
    Then I click on Reset button in AP dashboard page
    Then I enter an "FirstName" in any env "PrimaryMember" "PrimaryMember" to search user
    Then I click on Search button in AP dashboard page
    Then I validate the list is sorted by account ID in "asc" order
    Then I click on Reset button in AP dashboard page
    Then I enter an "FirstName" in any env "a" "a" to search user
    Then I click on Search button in AP dashboard page
    Then I wait for 1000 milliseconds
    Then I validate message for over hundred records
    When I select "Sort by: Account ID High to Low"
    Then I validate the list is sorted in order by "Account ID" and "desc"

