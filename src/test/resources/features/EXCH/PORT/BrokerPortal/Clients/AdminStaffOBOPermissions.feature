@BrokerPortalClients @port
Feature: Admin staff should not have the Manage option displayed when they view the agency client list

  @SLER-1806
  Scenario: : Admin staff should not have the Manage option displayed when they view the agency client list
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+MPhillipsSTG@outlook.com" password "ALaska12!" and "C4PortTesting+MPhillips@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I click View Your Clients button

    And I validate I am on the "Broker Portal Your Clients" page
    And I validate I am on the "Agency Dashboard" page
    Then I validate the Your Clients page title

    And I click on the first client in my list
    Then I validate the "Manage" option is not displayed
    Then I validate the "Remove Client" option is displayed
    Then I validate the "Transfer" option is displayed

    Then I click on broker userName and logout