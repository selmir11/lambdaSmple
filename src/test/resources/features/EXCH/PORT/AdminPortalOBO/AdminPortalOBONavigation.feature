@AdminPortalOBO @port
Feature: Admin Portal OBO navigation

  @SLER-1812
  Scenario: : Admin Portal OBO navigation
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I wait for 1000 milliseconds
    Then I enter an "Email" "AutomationUser" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I switch to the tab number 1

    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Eligibility"
    Then I validate I am on the "Application History" page
    And I click on the Colorado Connect or C4 Logo in the "NonElmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Plans"
    Then I validate I am on the "My Policies" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header

    Then I validate I am on the "My Account Overview" page
    And I change the language from header to "Spanish NonElmo"
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Eligibility"
    Then I validate I am on the "Application History" page
    And I click on the Colorado Connect or C4 Logo in the "NonElmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Plans"
    Then I validate I am on the "My Policies" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header