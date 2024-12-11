@FindACertifiedBroker @port
Feature: Broker authorization modal Spanish validation on the Find a certified broker page

  @SLER-1795
  Scenario: Broker authorization modal Spanish validation
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

    And I click on Find a Broker

    Then I validate the Find a Certified Broker near you page title in "English"
    And I validate the have a "Exch" broker call you text in "English"
    Then I Search authorized Broker "Solomon Brandt"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click the Authorize broker button

    And I validate the text to authorize a new broker in "English"
    Then I click the "Cancel" button on the Authorize a broker modal
    Then I validate the Find a Certified Broker near you page title in "English"

    And I change the language from header to "Spanish ExpertHelp"

    Then I validate the Find a Certified Broker near you page title in "Spanish"
    And I validate the have a "Exch" broker call you text in "Spanish"
    Then I click the Authorize broker button

    And I validate the text to authorize a new broker in "Spanish"
    Then I click the "Authorize Broker" button on the Authorize a broker modal

    Then I click on change the existing broker

    Then I Search authorized Broker "Brandt Agency"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click the Authorize broker button

    And I validate the text to authorize a new broker "Del Mercer" with "Brandt Agency" or keep the same broker "Solomon Brandt" with "Brandt Agency" in "Spanish" for "Exch"
    Then I click on "Keep Current Broker" in the warning container to authorize new or keep the same broker
    Then I validate the Find a Certified Broker near you page title in "Spanish"

    And I change the language from header to "English ExpertHelp"
    Then I click the Authorize broker button

    And I validate the text to authorize a new broker "Del Mercer" with "Brandt Agency" or keep the same broker "Solomon Brandt" with "Brandt Agency" in "English" for "Exch"
    Then I click on "Authorize New Broker" in the warning container to authorize new or keep the same broker