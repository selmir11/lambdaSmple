@PortPEAK @port
Feature: A skeleton error page will be displayed when there is no CBMS ID or create account service fails for any other reason
  #Note: The PEAK tests have been permanently suspended for QA

  @SLER-1912
  Scenario: PEAK account Single Sign On skeleton error message validation when there is no CBMS case ID attached to the account
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click on Sign in with PEAK on the login page
    And I wait for 2000 milliseconds
    Then I click Ok on the PEAK alert
    When I login as PEAK User "PEAKStagingNoCaseID@test.com" password "ALaska12!"
    And I validate I am on the "PEAK skeleton error message" page
    And I validate the PEAK skeleton error message text