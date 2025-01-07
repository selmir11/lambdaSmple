@PortPEAK @port
Feature: Connect for Health Colorado account Single Sign On validation into PEAK
  #Note: The PEAK tests have been permanently suspended for QA

  @SLER-1913
  Scenario: Connect for Health Colorado account Single Sign On validation into PEAK
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "exchange" account creation

    And I validate I am on the "Login" page
    When I click on Sign in with PEAK on the login page
    And I wait for 2000 milliseconds
    Then I click Ok on the PEAK alert
    Then I click on the Sign in with Connect for Health Colorado button
    And  I enter valid credentials to login
    And I wait for 2000 milliseconds
    And I validate the PEAK welcome text
    Then I click on the PEAK Sign out button

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"