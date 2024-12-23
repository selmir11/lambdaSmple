@FindACertifiedBroker @port
Feature: Tests broker search details on the anonymous Find a Certified Broker page

  @SLER-377
  Scenario: Validating broker results details
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    Then I validate the Find a Certified Broker near you page title in "English"
    Then I Search authorized Broker "Noah Trujillo"
    And I click on Search button in find certified broker page
    Then I verify that a total of "1" results displays in "English"
    Then I validate broker name is "Noah Trujillo"
    Then I validate agency name is "Arrow Head Agency"
    Then I validate agency address is "1234 Road, 1234 Road"
    Then I validate agency city state and zip is "Denver, CO 80205"
    And I click more details from the first broker result container
    Then I validate the agency details field labels in "English"
    Then I validate the agency details "ArrowHeadAgency@agency.com", "720-789-6532", "Monday", "07:00 AM to 05:00 PM", "983624175862", "English"
    And I click hide details
    Then I validate broker name is "Noah Trujillo"
    Then I validate agency name is "Arrow Head Agency"
    Then I validate agency address is "1234 Road, 1234 Road"
    Then I validate agency city state and zip is "Denver, CO 80205"
    And I validate the agency details are hidden

  @SLER-380
  Scenario: Search by Broker's Full Name in anonymous Find a Certified Broker page
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Find a Broker
    And I Search authorized Broker "soukaina agency"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I validate the agency details "soukainatesting+agencystg@gmail.com", "371-195-9846", "Monday", "08:00 AM to 05:00 PM", "376946", "English"

  @SLER-380
  Scenario: Search by Broker's Full Name for Individual User
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Find a Broker
    And I Search authorized Broker "soukaina agency"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I validate the agency details "soukainatesting+agencystg@gmail.com", "371-195-9846", "Monday", "08:00 AM to 05:00 PM", "376946", "English"
    And I click on Sign Out in the Header for "WhoHelpsYouPage"

  @SLER-380
  Scenario: Search by Broker's Full Name for Admin User
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I enter an "Email" "johnc4hcoautomation+" to search user
    And I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I switch to the tab number 1
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Find a Broker
    And I Search authorized Broker "soukaina agency"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I validate the agency details "soukainatesting+agencystg@gmail.com", "371-195-9846", "Monday", "08:00 AM to 05:00 PM", "376946", "English"






