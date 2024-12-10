@port @Dashboard
Feature: Manage Authorized Users page validation and search functionality

  @SLER-1819
  Scenario: Manage Authorized Users page validation and search functionality
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "johnc4hcoautomation+1930stg1@gmail.com" password "ALaska13!" and "johnc4hcoautomation+1930qa1@gmail.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I click Agency Dashboard
    Then I click the Manage Users button

    Then I validate the Manage Authorized Users page title
    And I search for an authorized user "Active"
    Then I verify the expected number of rows displayed in the search results is 3

    And I clear the search box on the Manage Authorized Users page
    And I search for an authorized user "Pending Invite"
    Then I verify the expected number of rows displayed in the search results is 2

    And I clear the search box on the Manage Authorized Users page
    And I search for an authorized user "5"
    Then I verify the expected number of rows displayed in the search results is 1

    And I clear the search box on the Manage Authorized Users page
    And I search for an authorized user "Winter"
    Then I verify the expected number of rows displayed in the search results is 2

    And I clear the search box on the Manage Authorized Users page
    And I search for an authorized user "no rows"
    Then I verify the expected number of rows displayed in the search results is 0

    Then I click on broker userName and logout