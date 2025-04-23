@port @portNoticeBrokerPortal
Feature: Trigger the exchange individual's notice for broker authorization - BN-002A-03

  @SLER-1862
  Scenario: Creating a new exchange individual account and authorizing the broker
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    Then I enter general mandatory data for "exchange" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I verify Find Expert Help header Text in "English"

    And I click on Find a Broker
    Then I Search authorized Broker "Maggie Walker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I save the broker's details

    And I click on Sign Out in the Header for "Elmo"

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "BN-002A-03" in "English"
    And I verify the notice Text for "BN-002A-03" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook