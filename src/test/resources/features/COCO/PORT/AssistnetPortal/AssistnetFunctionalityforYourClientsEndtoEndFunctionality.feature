@portCOCO @SLCR-364
Feature: Assistnet_Functionality for Your Clients -End to End functionality

Scenario: Authorizing an assister for an individual account
  Given I open the login page on the "login" portal
  And I validate I am on the "Login" page
  When I click create a new account on login page
  And I click create my account from pre-screen page
  Then I validate I am on the "Create Account" page
  And I enter general mandatory data for "coco" account creation
  Then I validate I am on the "Login" page
  And  I enter valid credentials to login
  And I click continue signing in on the CAC Screener page
  And I validate I am on the "CoCo Welcome" page
  Then I click on Get Assistance in the "Exch" Header
  And I click on Find Expert Assistance in the "CoCo" Header
  Then I verify Find Expert Help header Text in "English"
  Then I verify Find Expert Help page "CoCo" title Text in "English"

  And I click the Authorize Assister Organization button
  Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
  And I validate the authorization success message
  Then I click Go Back on the Authorize Assister Organization page
  Then I validate the Continue on my own button "is not displayed"

  And I validate the current assister text exists
  And I validate the current assister table header labels

  And I validate my assister details in the current assister table are "Blue River Assisters", "Ucr14" or "8Gvzo", "80205", "720-894-1592", Assister, Approved
  Then I Remove my current Assister
  And I "Ok" my decision to remove my current assister
  And I validate no assister is authorized

  And I validate the Previous Broker Assister text
  And I validate the Previous Broker Assister table header labels
  Then I validate the Assister details in the Previous Broker Assister table are "Blue River Assisters", "Ucr14", or "8Gvzo", "80205", "720-894-1592", Assister
  Then I validate the Continue on my own button "is not displayed"

  And I click the Authorize Assister Organization button
  Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
  And I validate the authorization success message
  Then I click Go Back on the Authorize Assister Organization page

  And I validate the Previous Broker Assister table is not displayed
  And I validate my assister details in the current assister table are "Blue River Assisters", "Ucr14" or "8Gvzo", "80205", "720-894-1592", Assister, Approved
  Then I Remove my current Assister
  And I "Ok" my decision to remove my current assister
  And I validate no assister is authorized
  Then I validate the Continue on my own button "is not displayed"

  Then I click on the Colorado Connect or C4 Logo in the "ExpertHelp" Header
  And I validate I am on the "CoCo Welcome" page
  And I apply for the current year in CoCo
  Then I validate I am on the "Find Expert Help" page
  And I click the Authorize Assister Organization button
  Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
  And I validate the authorization success message
  Then I click Go Back on the Authorize Assister Organization page
  Then I validate I am on the "Find Expert Help" page
  And I wait for 600 milliseconds
  Then I validate the Continue with my application button is displayed in "English"
  And I wait for 200 milliseconds
  Then I click on Sign Out in the Header for "Elmo"


  Scenario: Verifying client appear in your client page
    Given I open the login page on the "assistNet" portal
    And I validate I am on the "Login" page
    When I login as Assistnet User any environment "C4PortTesting+BlueRiverSTG@outlook.com" password "ALaska12!" and "C4PortTesting+BlueRiver@outlook.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I validate I am on the "assistnet dashboard" page
    And I click on view My Clients button
    And I click on "colorado Connect" tab
    Then I search for clients
    And I click on first client search result
    Then I verify my client's name is displayed
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard

  Scenario: Remove an assister for an individual account
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I click continue signing in on the CAC Screener page
    And I validate I am on the "CoCo Welcome" page
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I verify Find Expert Help header Text in "English"
    Then I verify Find Expert Help page "CoCo" title Text in "English"
    Then I Remove my current Assister
    And I "Ok" my decision to remove my current assister
    And I validate no assister is authorized

    And I validate the Previous Broker Assister text
    And I validate the Previous Broker Assister table header labels
    And I wait for 200 milliseconds
    Then I click on Sign Out in the Header for "Elmo"

  Scenario: Verifying client disappear in your client page
    Given I open the login page on the "assistNet" portal
    And I validate I am on the "Login" page
    When I login as Assistnet User any environment "C4PortTesting+BlueRiverSTG@outlook.com" password "ALaska12!" and "C4PortTesting+BlueRiver@outlook.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I validate I am on the "assistnet dashboard" page
    And I click on view My Clients button
    And I click on "colorado Connect" tab
    Then I search for clients
    Then I validate The Client is removed successfully from assistnet Portal
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard



  

