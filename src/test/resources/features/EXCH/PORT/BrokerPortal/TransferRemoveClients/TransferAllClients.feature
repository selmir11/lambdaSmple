@TransferRemove @port
Feature: Transfer all clients validation

  @SLER-1266
  Scenario: Transfer all clients validation
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I validate I am on the "Find Expert Help Exch" page
    And I click on Find a Broker
    Then I Search authorized Broker "TransferRemove One"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists

    And I click on Sign Out in the Header for "WhoHelpsYouPage"

    #Agency owner transferring all clients
    Then I validate I am on the "Login" page
    And I open the login page on the "broker" portal
    And I login as Broker User any environment "C4PortTesting+TransferSTG@outlook.com" password "ALaska12!" and "C4PortTesting+Transfer@outlook.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I wait for 1000 milliseconds
    Then I select all clients checkbox
    And I wait for 1000 milliseconds
    And I save the number of clients selected
    Then I click the Transfer All Clients button

    Then I validate the Agency Broker Transfer page title
    Then I search for a broker named "TransferRemoveAg" on the Agency Broker Transfer page
    And I validate the broker results match my broker named "TransferRemoveAg Two"
    Then I click the transfer link on the Agency Broker Transfer page

    And I verify the transfer all client message
    And I verify the total number of clients to transfer

    Then I click the Transfer Clients button on the Review Transfer page

    Then I validate I am on the "Broker Portal Your Clients" page
    And I validate the Client Transfer Successful message

    Then I click on broker userName and logout

    #Agency owner verifying the new clients
    Then I validate I am on the "Login" page
    And I open the login page on the "broker" portal
    And I login as Broker User any environment "C4PortTesting+TransferTwoSTG@outlook.com" password "ALaska12!" and "C4PortTesting+TransferTwo@outlook.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I search for clients
    Then I click on first client search result
    And I verify my client's name is displayed

    Then I click on broker userName and logout

    #Individual verifying the new broker
    Then I validate I am on the "Login" page
    And I open the login page on the "login" portal
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I validate I am on the "Find Expert Help Exch" page
    Then I verify Manage who helps you header text in "English"

    And I validate current Broker text exists
    And I validate my broker details in the current broker table are "TransferRemoveAg Two", "TransferRemove Two", "512365497", "80205", "303-153-8975", "BROKER", "Active"

    Then I validate the details in the Previous Broker Assister table are "TransferRemove One", "897531650", "80205", "303-145-9875", "Broker"

    Then I click on change the existing broker
    Then I Search authorized Broker "TransferRemove One"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click the Authorize broker button
    Then I click on "Authorize New Broker" in the warning container to authorize new or keep the same broker

    And I click on Sign Out in the Header for "WhoHelpsYouPage"