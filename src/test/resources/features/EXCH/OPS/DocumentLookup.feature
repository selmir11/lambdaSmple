@OPS
Feature: Document Lookup page : Verify all data
  @SLER-277
  Scenario: SLER-277 Verify data for DLT page
#    TODO: There is existing bug OPS-2181 and OPS-2451(story) to address this bug.
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User
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
    Scenario: SLER-303 Verify sorting for advance search
      Given I open the login page on the "admin" portal
      And I refresh the page
      And I validate I am on the "Login" page
      When I login as Admin User
      And I validate I am on the "Admin search" page
      And I click "Document Lookup" from application links dropdown
      And I validate Document look Up page title is displaying on page
      And I click on Advanced search
      Then I select "Exchange" from advanced search dropdown options
      And I enter from and to dates
      Then I click on submit button
      Then I select "Document Type A to Z" from sort options
      Then I verify if DLT is sorted "asc" by "Document Type"
      Then I select "Document Type Z to A" from sort options
      Then I verify if DLT is sorted "desc" by "Document Type"
      Then I select "created date low to high" from sort options
      Then I verify if DLT is sorted "asc" by "Created Date"
      Then I select "created date high to low" from sort options
      Then I verify if DLT is sorted "desc" by "Created Date"
      Then logout from Admin Portal