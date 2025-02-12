@TransferRemove @port
Feature: Remove a single client validation

  @SLER-1263
  Scenario: Remove a selected client validation
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

    And I click on Sign Out in the Header for "Elmo"

    #Agency owner removing a single client
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
    And I search for clients
    Then I select the client searched
    Then I click on first client search result
    Then I verify my client's name is displayed

    And I click "remove Client" the client
    Then I click "ok" remove client
    And I wait for 1000 milliseconds

    And I search for clients
    Then I validate The Client is removed successfully

    Then I click on broker userName and logout

    #Exch individual verifying their previous broker
    Then I validate I am on the "Login" page
    And I open the login page on the "login" portal
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I validate I am on the "Find Expert Help Exch" page
    Then I verify Find Expert Help header Text in "English"

    Then I validate the details in the Previous Broker Assister table are "TransferRemove One", "897531650", "80205", "303-145-9875", "Broker"

    And I click on Sign Out in the Header for "Elmo"
