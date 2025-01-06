@PortPEAK @port
Feature: Connect for Health Colorado connection to PEAK redirection URL validation from the LUGY
  #Note: The PEAK tests have been permanently suspended for QA
  #Note: The PEAK URL changes every few months

  @SLER-1925
  Scenario: Connect for Health Colorado connection to PEAK redirection URL validation from the LUGY
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click on Help me understand what I qualify for button
    And I validate I am on the "LUGY" page
    Then I select Tell us about your household "65 or older" option in Let us guide you Page
    Then I select continue on Let us guide you Page
    And I validate I am on the "LUGY Prescreener Result" page
    Then I click Apply for Health First Colorado in Let us guide you Page
    And I wait for 2000 milliseconds
    Then I click Ok on the PEAK alert
    Then I validate the current PEAK connection URL is "https://peak--peaksit02.sandbox.my.site.com/peak/s/user-login?language=en_US"
    #This is the correct URL per PORT-7316 as of December 2024