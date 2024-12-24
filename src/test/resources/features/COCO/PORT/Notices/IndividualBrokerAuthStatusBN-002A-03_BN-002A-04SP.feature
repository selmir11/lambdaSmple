@portNoticeCoco @portCOCO
Feature: CoCo broker authorization status notices BN-0024-03 and BN-002A-04 sent to the individual in Spanish

  @SLCR-416
  Scenario: Broker authorization status notices BN-0024-03 and BN-002A-04 in Spanish
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco Spanish" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "CAC Screener" page
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header

    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Find a Broker
    Then I Search authorized Broker "Margie Kellogg"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I save the broker's details

    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "BN-002A-03" in "Spanish"
    And I verify the notice Text for "BN-002A-03" in "Spanish" for "Coco"
    Then I delete the open notice
    Then I open the notice "BN-002A-04" in "Spanish"
    And I verify the notice Text for "BN-002A-04" in "Spanish" for "Coco"
    Then I delete the open notice
    And I sign out of Outlook