@port @portNoticeBrokerPortal
Feature: Trigger the exchange individual notices for broker authorization/deauthorization by changing the broker - BN-002A-01 and BN-002A-02

  @SLER-1873
  Scenario: Creating a new exchange individual account and authorizing then changing their broker
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
    Then I Search authorized Broker "Preston Saunders"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists

    And I click on Sign Out in the Header for "Portal"

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    #There should be 2 authorization notices since the associated broker was chosen by the client - 1 for the owner and 1 for the broker
    Then I open the notice "BN-002A-01" in "English"
    Then I delete the open notice
    Then I open the notice "BN-002A-01" in "English"
    Then I delete the open notice
    And I sign out of Outlook
    Then I switch to the tab number 0

    #Individual changing their broker authorization
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I verify Manage who helps you header text in "English"

    Then I click on change the existing broker
    Then I Search authorized Broker "Maggie Walker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click the Authorize broker button
    Then I click on "Authorize New Broker" in the warning container to authorize new or keep the same broker
    And I validate current Broker text exists
    And I save the broker's details

    And I click on Sign Out in the Header for "Portal"

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "BN-002A-01" in "English"
    And I verify the notice Text for "BN-002A-01 Exch" in "English" for "Broker"
    Then I delete the open notice
    Then I open the notice "BN-002A-02" in "English"
    And I verify the notice Text for "BN-002A-02 Exch" in "English" for "Broker"
    Then I delete the open notice
    And I sign out of Outlook