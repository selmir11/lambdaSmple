Feature: Admin Portal OBO - Create Account & Submit FA Application & Enroll in a plan
  @SLER-106_WIP
  Scenario: Create Account & Submit FA Application & Enroll in a plan
    Given I open the login page on the "admin" portal
    Then I login as Admin any User "C4testadmlce@gmail.com" and "ALaska12!"
    Then I click create account on admin portal
    And I enter general mandatory data for "Admin exchange" account creation
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown

