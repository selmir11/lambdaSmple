@portNotice @portCOCO
Feature: CoCo broker deauthorization notice BN-002A-02 sent to the broker

  @SLCR-418
  Scenario: Broker deauthorization notice BN-002A-02
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "CAC Screener" page
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header

    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Find a Broker
    Then I Search authorized Broker "Maggie Walker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker

    And I validate current Broker text exists
    And I validate my broker details in the current broker table are "Maggie Walker", "Bright Sky Agency", "8895237", "80205", "303-898-6426", "BROKER", "Active"
    And I save the broker's details

    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "BN-002A-02" in "English"
    And I verify the notice Text for "BN-002A-02" in "English" for "Broker"
    Then I delete the open notice
    And I sign out of Outlook
