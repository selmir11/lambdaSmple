@AssistNet @port
Feature: Add new Assister organization functionality in the AssistNet Portal

  @SLER-1791
  Scenario: Creating a new assister organization
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
    Then I enter organization details and submit
    Then I validate I am on the "assistnet dashboard" page
    And I wait for 2000 milliseconds
    And I click the edit button for my organization

    Then I validate the Organization Details page title
    Then I update the new organization name and submit

    Then I validate I am on the "assistnet dashboard" page
    And I wait for 2000 milliseconds
    And I validate the updated organization name is listed

    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard