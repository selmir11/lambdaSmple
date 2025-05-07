@OPS @Exch @DLT
Feature: Document Lookup page : Verify all data
  @SLER-277
  Scenario: SLER-277 Verify data for DLT page
#    TODO: There is existing bug OPS-2181 and OPS-2451(story) to address this bug.
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I click "Document Lookup" from application links dropdown
    And I validate Document look Up page title is displaying on page
    And I click on Advanced search
    And I verify error message for Advanced search on DLT page
    Then I validate if I can select and unselect all checkboxes and verify their text
    Then I verify advance search criteria from DLT page
    Then I verify Admin search results table columns
    Then I search with Document Handle Number
    Then I verify Admin search results table columns
    Then I verify Document Handle search result table columns
    Then logout from Admin Portal

    @SLER-303
    Scenario: SLER-303 Verify sorting for advance search in DLT
      Given I open the login page on the "admin" portal
      And I refresh the page
      And I validate I am on the "Login" page
      When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
      And I validate I am on the "Admin search" page
      And I click "Document Lookup" from application links dropdown
      And I validate Document look Up page title is displaying on page
      And I click on Advanced search
      Then I select "Exchange" from advanced search dropdown options
      And I enter from and to dates
      Then I click on submit button
      Then I validate Default entry selection is twenty entries
      And I wait for 500 milliseconds
      Then I validate next button and previous button functionality
      Then I select dropdown entry option and validate 10 rows are displaying
      Then I select dropdown entry option and validate 20 rows are displaying
      Then I select dropdown entry option and validate 50 rows are displaying
      Then I select dropdown entry option and validate 100 rows are displaying
      Then logout from Admin Portal

    @SLER-814
  Scenario:SLER-814:Verify DLT: Sort Results
      Given I open the login page on the "admin" portal
      And I refresh the page
      And I validate I am on the "Login" page
      When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
      And I validate I am on the "Admin search" page
      And I click "Document Lookup" from application links dropdown
      And I validate Document look Up page title is displaying on page
      And I click on Advanced search
      Then I select "Exchange" from advanced search dropdown options
      And I enter from and to dates
      Then I click on submit button
      Then I select "Document Type A to Z" from sort options
      And I wait for 1500 milliseconds
      Then I verify if DLT is sorted "asc" by "Document Type"
      Then I select "Document Type Z to A" from sort options
      And I wait for 500 milliseconds
      Then I verify if DLT is sorted "desc" by "Document Type"
      Then I select "created date low to high" from sort options
      And I wait for 500 milliseconds
      Then I verify if DLT is sorted "asc" by "Created Date"
      Then I select "created date high to low" from sort options
      And I wait for 500 milliseconds
      Then I verify if DLT is sorted "desc" by "Created Date"

    @SLER-2122
  Scenario:SLER-2122:Verify DLT: Verify when user deletes document from DLT it doesnt display on my document page
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page

    Then I click create account on admin portal
    Then I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    Then I search for user and click email from search results
    Then I validate I am on the "Admin Portal individual dashboard" page
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
      And I wait for 2000 milliseconds
    And I refresh the page
    Then I validate all uploaded documents or notices loaded for my account start with "IND"
      |IND_Welcome Message (AM-001-01)|
    And I close current tab and switch back to previous tab
    And I click "Document Lookup" from application links dropdown
    And I validate Document look Up page title is displaying on page
    And I click on Advanced search
    Then I select "Individual" from advanced search dropdown options
    And I enter the account number
    And I wait for 4000 milliseconds
    Then I click on submit button
    Then I verify Delete button is displaying on document lookup page
    Then I click on Delete button on document lookup page
    Then I click on No Go Back button on document lookup page
    Then I verify Delete button is displaying on document lookup page
    Then I click on Delete button on document lookup page
    And I click on yes delete button from confirmation modal
    And I wait for 4000 milliseconds
    And I verify Document is deleted from document loopup page
    And I switch to the tab number 0
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
      Then I validate no document message
        |You do not have any Documents or Letters at this time |
