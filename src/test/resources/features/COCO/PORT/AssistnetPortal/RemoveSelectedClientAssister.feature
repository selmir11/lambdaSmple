@coocassistnet @portCOCO
Feature: Remove a selected CoCo client from the My Clients list in the AssistNet Portal

  @SLCR-372
  Scenario: verifying the removal of a selected client
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header

    Then I validate I am on the "FindExpertHelpCoco" page
    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "iadO7" or "yx85M"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page

    Then I verify Manage who helps you header text in "English"
    And I validate my assister details in the current assister table are "Remove Transfer", "iadO7" or "yx85M", "80205", "303-127-9642", Assister, Approved

    And I click on Sign Out in the Header for "Elmo"

    #Assister removing a selected client
    Then I validate I am on the "Login" page
    And I open the login page on the "assistNet" portal
    When I login as Assistnet User any environment "c4assistorportal+9zOUaW7Rp@gmail.com" password "ALaska12!" and "c4assistorportal+Tj3gQX6US@gmail.com" password "ALaska12!"
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
    Then I click on "colorado Connect" tab
    And I search for clients
    Then I click on first client search result
    Then I verify my client's name is displayed

    Then I select the client searched
    And I select the "Remove Selected Clients" option from the header of the broker container
    Then I click "ok" remove client

    Then I click on "colorado Connect" tab
    And I search for clients
    Then I validate The Client is removed successfully from assistnet Portal

    Then I click on broker userName and logout

    #CoCo individual verifying their previous assister
    Then I validate I am on the "Login" page
    And I open the login page on the "login" portal
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header

    Then I validate I am on the "FindExpertHelpCoco" page
    Then I verify Find Expert Help header Text in "English"
    Then I validate the Assister details in the Previous Broker Assister table are "Remove Transfer", "iadO7", or "yx85M", "80205", "303-127-9642", Assister

    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "iadO7" or "yx85M"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page

    And I click on Sign Out in the Header for "Elmo"