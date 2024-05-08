@OPS

Feature: This scenario checks Admin LCE Access role positive and negative scenario
  @SLER-234 @AdminLCE
  Scenario: Verify admin LCE link and permission
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin any User "C4testadmlce@gmail.com" and "ALaska12!"
    And I validate I am on the "Admin Portal search" page
    Then I click "Admin LCE" from application links dropdown
    And I initiate incoming page
    Then I validate I am on the "Admin LCE" page
    And I validate Admin Lce container title text
    And I logout from Admin Portal LCE
    And I validate I am on the "Login" page
    Then I login as Admin any User "C4test.sereport@gmail.com" and "ALaska12!"
    And I validate I am on the "Admin Portal search" page
    Then I validate "Admin LCE" application link not display
    And I logout from Admin Portal LCE