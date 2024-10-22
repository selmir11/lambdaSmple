@BrokerPortalProfile @port @Dashboard
Feature: Verify the agency owner's ability to hide their address on the Find a Certified Broker page

  @SLER-712
  Scenario: Verify agency address is displayed with agency details on the Find a Certified Broker page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    Then I Search authorized Broker "998125"
    And I click on Search button in find certified broker page
    Then I validate broker name is "Agency addressline"
    Then I validate agency address is "16th Street Mall"
    Then I validate agency city state and zip is "Denver, CO 80228"
    Then I clear the broker search box
    Then I Search authorized Broker "998126"
    And I click on Search button in find certified broker page
    Then I verify that a total of "1" results displays in "English"
    Then I validate broker name is "Addressline Broker"
    Then I validate agency address is "16th Street Mall"
    Then I validate agency city state and zip is "Denver, CO 80228"

  @SLER-712
  Scenario: Verify the Agency Owner's ability to hide their agency address
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "stggagency@addressline.com" password "ALaska12!" and "qaagency@addressline.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click Agency Dashboard
    Then I click the Edit Agency Information link
    And I click the Hide This Address checkbox
    And I click the Save and Submit button on the Agency Details page
    Then I click the Manage Brokers button
    Then I click on broker userName and logout
    And I validate I am on the "Login" page

  @SLER-712
  Scenario: Verify agency address is hidden on the Find a Certified Broker page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    Then I Search authorized Broker "998125"
    And I click on Search button in find certified broker page
    Then I validate broker name is "Agency addressline"
    Then I validate agency address is hidden
    Then I validate agency city state and zip is "Denver, CO 80228"
    Then I clear the broker search box

    Then I Search authorized Broker "998126"
    And I click on Search button in find certified broker page
    Then I verify that a total of "1" results displays in "English"
    Then I validate broker name is "Addressline Broker"
    Then I validate agency address is hidden
    Then I validate agency city state and zip is "Denver, CO 80228"

  @SLER-712
  Scenario: Verify the Agency Owner's ability to un-hide their agency address and reset the account
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "stggagency@addressline.com" password "ALaska12!" and "qaagency@addressline.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click Agency Dashboard
    Then I click the Edit Agency Information link
    And I click the Hide This Address checkbox
    And I click the Save and Submit button on the Agency Details page
    Then I click the Manage Brokers button
    Then I click on broker userName and logout