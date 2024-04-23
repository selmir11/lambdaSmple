@OPS @SLER-277
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
    When I click on dropdown options for advanced search
    Then I select all dropdown options
    Then I verify Admin Table columns
    Then I search with Document Handle Number
    Then I verify Document Handle search columns





