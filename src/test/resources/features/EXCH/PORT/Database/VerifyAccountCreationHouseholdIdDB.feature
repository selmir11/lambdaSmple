@BrokerPortalDB @port
Feature: Exchange individual account creation household ID

  @SLER-1121
  Scenario: : Individual account creation and household ID verification in the database
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"

    And I verify the new Exchange individual account's household ID in the database
