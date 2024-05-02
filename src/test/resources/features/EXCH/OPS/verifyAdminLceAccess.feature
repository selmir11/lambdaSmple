@OPS
@SLER-234

Feature: This scenario checks Admin LCE Access role positive and negative scenario

  Scenario: Verify admin LCE link and permission
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin any User "C4testadmlce@gmail.com" and "ALaska12!"
    And I validate I am on the "Admin Portal search" page
    Then I click "Admin LCE" from application links dropdown
    Then I validate I am on the "Admin LCE" page
    And I validate page title text
    And I validate  Account Number text displays
    And logout from Admin Portal
    And I validate I am on the "Login" page
    Then I login as Admin any User "C4test.sereport@gmail.com" and "ALaska12!"
    And I validate I am on the "Admin Portal search" page
    Then I validate "Admin LCE" application link not display
    And logout from Admin Portal