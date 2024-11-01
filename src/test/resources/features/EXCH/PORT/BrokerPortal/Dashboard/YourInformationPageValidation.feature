@BrokerPortalProfile @port @Dashboard
Feature: Verify the Your Information page of Broker Portal

  @SLER-593
  Scenario: Verify the Your Information page
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    Then I enter mandatory data for "Admin Staff" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page
    And I log into my "Admin Staff" account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I enter the MFA code and click Verify
    Then I click Agency Dashboard
    And I click Agency Complete Profile

    Then I validate the Your Information page title
    And I validate the First Name field shows my name
    And I validate the Last Name field shows my name
    Then I validate the First Name mandatory field error message
    Then I validate the Last Name mandatory field error message
    Then I click the license match checkbox
    Then I validate the First Name on license error message
    Then I validate the Last Name on license error message
    Then I validate the license field error message
    Then I validate the maximum character limit for the license field
    Then I validate the license valid from field error message
    Then I validate the license valid to field error message
    Then I validate the Book of Business error message
    And I click No to the Book of Business question
    Then I validate the no invitation code checkbox error message
    Then I validate the invitation code error message
    Then I validate the error message for the license expiration date
    Then I click Go Back on the Your Information page
    And I click Agency Complete Profile
    And I click Yes to the Book of Business question
    Then I validate the license required error message