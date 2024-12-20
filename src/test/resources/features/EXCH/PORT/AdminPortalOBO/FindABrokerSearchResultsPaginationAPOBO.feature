@FindACertifiedBroker @port
Feature: Tests broker search results pagination on the Find a Certified Broker page via Admin Portal OBO

  @SLER-399
  Scenario: Verifies search results pagination on the Find a Certified Broker page for Admin User
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I enter an "Email" "johnc4hcoautomation+" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    And I click on Find a Broker
    Then I enter "Denver" into the broker location search box
    And I click on Search button in find certified broker page
    Then I verify the over 50 search results error is displayed in "English"
    And I click the right pagination arrow button 3 times
    And I wait for 100 milliseconds
    Then I verify the current result page is "5"
    And I click the left pagination arrow button 4 times
    And I wait for 100 milliseconds
    Then I verify the current result page is "1"