@AssistNet @port
Feature: Organization Details page validation in the AssistNet Portal

  @SLER-1787
  Scenario: Organization Details page validation
    Given I open the login page on the "assistNet" portal
    And I validate I am on the "Login" page
    When I login as Assistnet User any environment "c4assistorportal+aUnIb26ho@gmail.com" password "ALaska12!" and "c4assistorportal+e1kKkYVvM@gmail.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I validate I am on the "assistnet dashboard" page

    And I click on Add New Organization button

    Then I validate the Organization Details page title
    And I validate the field labels on the Organization Details page
    Then I validate the mandatory field error messages on the Organization Details page
    And I validate the buttons on the Organization Details page
    Then I validate the working hours from error message on the Organization Details page
    Then I click the Go Back button on the Organization Details page
    And I click on Add New Organization button
    Then I validate the working hours to error message on the Organization Details page

    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard