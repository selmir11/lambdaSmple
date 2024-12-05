@BrokerPortalClients @port
Feature: Agency owner OBO navigation

  @SLER-1810
  Scenario: : Agency owner OBO navigation
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+MWalkerSTG@outlook.com" password "ALaska12!" and "C4PortTesting+MaggieWalker@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I validate the Your Clients page title

    And I click on the first client in my list
    And I click "manage" the client

    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I validate the Your Clients page title
    And I click on the first client in my list
    And I click "manage" the client

    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Eligibility"
    Then I validate I am on the "Application History" page
    And I click on the Colorado Connect or C4 Logo in the "NonElmo" Header

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I validate the Your Clients page title
    And I click on the first client in my list
    And I click "manage" the client

    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I validate the Your Clients page title
    And I click on the first client in my list
    And I click "manage" the client

    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Plans"
    Then I validate I am on the "My Policies" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I validate the Your Clients page title
    And I click on the first client in my list
    And I click "manage" the client

    Then I validate I am on the "Account Overview" page
    And I change the language from header to "Spanish NonElmo"
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I validate the Your Clients page title
    And I click on the first client in my list
    And I click "manage" the client

    Then I validate I am on the "Account Overview" page
    And I change the language from header to "Spanish NonElmo"
    Then I click on ClickHere link for "My Eligibility"
    Then I validate I am on the "Application History" page
    And I click on the Colorado Connect or C4 Logo in the "NonElmo" Header

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I validate the Your Clients page title
    And I click on the first client in my list
    And I click "manage" the client

    Then I validate I am on the "Account Overview" page
    And I change the language from header to "Spanish NonElmo"
    Then I click on ClickHere link for "My Documents"
    Then I validate I am on the "My Documents" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I validate the Your Clients page title
    And I click on the first client in my list
    And I click "manage" the client

    Then I validate I am on the "Account Overview" page
    And I change the language from header to "Spanish NonElmo"
    Then I click on ClickHere link for "My Plans"
    Then I validate I am on the "My Policies" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header

    Then I click on broker userName and logout