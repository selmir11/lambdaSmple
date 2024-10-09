@BrokerPortalCoCoClients @port @portCOCO
Feature: CoCo Your Clients search box validation

  @SLCR-354
  Scenario: : Your Clients page search box validation
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
    Then I validate the Your Clients page title
    And I click on "colorado Connect" tab

    Then I validate the search box cannot contain special characters
    And I validate numbers are not allowed in the search box
    And I validate spaces are not allowed in the search box

    Then I click on broker userName and logout