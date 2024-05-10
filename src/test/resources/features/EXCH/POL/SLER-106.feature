Feature: Admin Portal OBO - Create Account & Submit FA Application & Enroll in a plan
  @SLER-106
  Scenario: Create Account & Submit FA Application & Enroll in a plan
    Given I open the login page on the "admin" portal
    Then I login as Admin any User "C4testadmlce@gmail.com" and "ALaska12!"
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation

