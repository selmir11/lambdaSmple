@PortCRM @port
Feature: CRM validation following client authorization and deauthorization

  @SLER-1852
  Scenario: CRM validation following client authorization and deauthorization
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "exchange" account creation
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

    And I click on Sign Out in the Header for "WhoHelpsYouPage"

    #Verifying the client's broker authorization in the CRM
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    And I verify the contact type is "Individual"

    Then I open the "Details" Tab on contact page
    And I verify the broker authorization start date is today
    And I verify that the broker authorization end date is blank

    Then I sign out of CRM

    #Individual deauthorizing their broker
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I verify Manage who helps you header text in "English"

    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker
    And I validate no broker is authorized

    And I click on Sign Out in the Header for "WhoHelpsYouPage"

    #Verifying the client's broker deauthorization in the CRM
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    And I verify the contact type is "Individual"

    Then I open the "Details" Tab on contact page
    And I verify the broker authorization start date is today
    And I verify the broker authorization end date is today

    Then I sign out of CRM