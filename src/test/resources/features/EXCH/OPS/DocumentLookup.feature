@OPS @SLER-277 @SLER-300
Feature: Document Lookup page : Verify all data
  @SLER-277
  Scenario: Verify data
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User
    And I validate I am on the "Admin search" page
    And I click "Document Lookup" from application links dropdown
    And I validate Document look Up page title is displaying on page
    And I click on Advanced search
    Then I select Document Type Group dropdown options
    Then I verify Admin search results table columns
    Then I search with Document Handle Number
    Then I verify Admin search results table columns
    Then I verify Document Handle search result table columns

    @SLER-300
    Scenario: Verify sorting for advance search
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