@TAM @pageNavigation @TamCoCo
Feature: Tests related to the Family Overview page

  Background: I go to the login portal
    Given I open the login page on the "login" portal

  @SLCR-149 @PageNavigationFamilyOverview @TAMSmoke
  Scenario: SLCR-149 The 'Find Expert Assistance' link stops working when navigate back to the error and unauthorized pages in Family Overview portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    #Step1
    Then I validate I am on the "CoCo Family Overview" page
    And I change the C4 url to "Family Overview portal Error CoCo"
    Then I validate I am on the "Error" page
    And I click Back to Welcome page Button on error CoCo page
    Then I click Go Back button from chrome browser
    And I verify User name Link is displayed in the "CoCo" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    #Step2
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    And I change the C4 url to "Family Overview portal Unauthorized CoCo"
    Then I validate I am on the "Unauthorized" page
    And I verify User name Link is displayed in the "CoCo" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page