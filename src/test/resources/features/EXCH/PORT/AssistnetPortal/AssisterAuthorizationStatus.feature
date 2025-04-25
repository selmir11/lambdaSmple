@AssistNet @port
Feature: Assister authorization and deauthorization functionality

  @SLER-1178
  Scenario: : Exchange individual account creation and Assister authorization
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I validate I am on the "Find Expert Help Exch" page

    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page
    And I click on Sign Out in the Header for "Elmo"

  #Assister verifying client authorization
    Given I open the login page on the "assistNet" portal
    And I validate I am on the "Login" page
    When I login as Assistnet User any environment "C4PortTesting+BlueRiverSTG@outlook.com" password "ALaska12!" and "C4PortTesting+BlueRiver@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I validate I am on the "assistnet dashboard" page
    And I click on view My Clients button
    And I search for clients
    And I click on first client search result
    And I verify my client's name is displayed
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard

  #Exchange individual revoking assister authorization
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I validate I am on the "Find Expert Help Exch" page
    Then I verify Manage who helps you header text in "English"

    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker
    Then I verify Find Expert Help header Text in "English"

    And I validate the Previous Broker Assister text
    And I validate the Previous Broker Assister table header labels
    Then I validate the Assister details in the Previous Broker Assister table are "Blue River Assisters", "Ucr14", or "8Gvzo", "80205", "720-894-1592", Assister

    And I click on Sign Out in the Header for "Elmo"

  #Assister verifying the client no longer displays in their client list
    Given I open the login page on the "assistNet" portal
    And I validate I am on the "Login" page
    When I login as Assistnet User any environment "C4PortTesting+BlueRiverSTG@outlook.com" password "ALaska12!" and "C4PortTesting+BlueRiver@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "assistnet dashboard" page
    And I click on view My Clients button
    And I search for clients
    Then I validate The Client is removed successfully from assistnet Portal

    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard
