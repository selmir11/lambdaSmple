@PortPEAK @port
Feature: Existing PEAK user logging into C4 using PEAK credentials that has a CBMS case ID attached
  #Note: The PEAK tests have been permanently suspended for QA

  @SLER-1928
  Scenario: PEAK account Single Sign On validation into Connect for Health Colorado
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click on Sign in with PEAK on the login page
    And I wait for 2000 milliseconds
    Then I click Ok on the PEAK alert
    When I login as PEAK User "peakteststg1@test.com" password "ALaska12!"
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I save my new Connect for Health Colorado username and account number
    And I click on Sign Out in the Header for "Elmo"

    #Signing in a second time to verify the new C4 account details are not changed
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click on Sign in with PEAK on the login page
    And I wait for 2000 milliseconds
    Then I click Ok on the PEAK alert
    And I wait for 3000 milliseconds
    Then I click Ok on the PEAK alert
    When I login as PEAK User "peakteststg1@test.com" password "ALaska12!"
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    And I verify my new Connect for Health Colorado username and account number
    And I click on Sign Out in the Header for "Elmo"