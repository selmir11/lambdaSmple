@BrokerPortalCoCoClients @port @portCOCO
Feature: Broker Portal CoCo client OBO navigation for owners and brokers

  @SLCR-274
  Scenario: Agency owner OBO navigation
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
    And I click on "colorado Connect" tab
    And I click on the first client in my list
    And I click "manage" the client
    Then I validate I am on the "CoCo Welcome" page

    Then I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I click on broker userName and logout

  Scenario: Broker OBO navigation
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+PrestonSaunders@outlook.com" password "ALaska12!" and "C4PortTesting+PSaundersQA@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Broker Dashboard" page
    And I click on "colorado Connect" tab
    And I click on the first client in my list
    And I click "manage" the client
    Then I validate I am on the "CoCo Welcome" page

    Then I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Broker Dashboard" page
    Then I click on broker userName and logout