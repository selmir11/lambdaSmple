@PortPEAK @port
Feature: Connect for Health Colorado connection to PEAK redirection URL validation
  #Note: The PEAK tests have been permanently suspended for QA
  #Note: These PEAK URLs change every few months

  @SLER-1920
  Scenario: Connect for Health Colorado connection to PEAK redirection URL validation
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click on Sign in with PEAK on the login page
    And I wait for 2000 milliseconds
    Then I click Ok on the PEAK alert
    Then I validate the current PEAK connection URL is "https://peak--peaksit01.sandbox.my.site.com/peak/s/user-login?language=en_US&spInitSso=Y&sp=c4hco"

    Then I click on the Sign in with Connect for Health Colorado button
    And I change the language from header to "Spanish Login"
    When I click on Sign in with PEAK on the login page
    And I wait for 2000 milliseconds
    Then I click Ok on the PEAK alert
    Then I validate the current PEAK connection URL is "https://peak--peaksit01.sandbox.my.site.com/peak/s/user-login?language=es&spInitSso=Y&sp=c4hco"
    #These are the correct URLs per PORT-7511 as of February 2025