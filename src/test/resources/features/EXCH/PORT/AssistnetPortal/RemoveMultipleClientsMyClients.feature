@AssistNet @port
Feature: Remove multiple clients from My Clients list in the AssistNet Portal

  @SLER-1780
  Scenario: Remove multiple clients from My Clients list
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
    Then I authorize my assister's site ID "iadO7" or "yx85M"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page

    Then I verify Manage who helps you header text in "English"
    And I validate my assister details in the current assister table are "Remove Transfer", "iadO7" or "yx85M", "80205", "303-127-9642", Assister, Approved

    And I click on Sign Out in the Header for "WhoHelpsYouPage"

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

    Then I select all clients checkbox
    And I select the "Remove Selected Clients" option from the header of the broker container
    Then I click "ok" remove client
    And I wait for 1000 milliseconds

    Then I validate The Client is removed successfully from assistnet Portal

    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard

    #Exch individual verifying their previous assister
    Then I validate I am on the "Login" page
    And I open the login page on the "login" portal
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I validate I am on the "Find Expert Help Exch" page
    Then I verify Find Expert Help header Text in "English"

    Then I validate the Assister details in the Previous Broker Assister table are "Remove Transfer", "iadO7", or "yx85M", "80205", "303-127-9642", Assister

    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "iadO7" or "yx85M"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page

    And I click on Sign Out in the Header for "WhoHelpsYouPage"