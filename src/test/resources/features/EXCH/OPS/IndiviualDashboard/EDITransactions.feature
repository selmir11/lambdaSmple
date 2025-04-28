@OPS @Exch @IndiviualDashboard
Feature: EDI Detailed Outbound Transactions : Verify all data
  @SLER-976
  Scenario: SLER-976 IndDash: Verify Detailed EDI Report Page
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I enter an accountId in any Env "2002009179" "1103056956" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I click on view button for "EDI Transactions" report
    Then I validate I am on the "EDI Transactions" page
    Then I wait for 1000 milliseconds
    And I verify EDI Transactions headers data
    Then I select "2025" to search EDI transactions
    Then I select "MEDICAL" coverage type dropdown
    Then I validate only "medical" records present for the user
    Then I select "DENTAL" coverage type dropdown
    Then I validate only "dental" records present for the user
    Then I select "BOTH" coverage type dropdown
    Then I validate "Outbound Header" transactions present for the user
    Then I validate "Inbound headers" transactions present for the user
    Then I validate "outboundfirstRow" transactions present for the user
    Then I validate "outboundsecondRow" transactions present for the user
    Then I validate "InboundfirstRow" transactions present for the user
    Then I validate "InboundsecondRow" transactions present for the user
