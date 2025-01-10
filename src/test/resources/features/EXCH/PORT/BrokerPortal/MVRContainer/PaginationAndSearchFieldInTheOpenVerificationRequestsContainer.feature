@port @MVRContainer
Feature:Pagination and Search Field in the Open Verification Requests container
@SLER-1990
  Scenario:validate error msg for MVR search
  Given I open the login page on the "broker" portal
  Then I validate I am on the "Login" page
  When I open the login page on the "broker" portal
  And I login as Broker User any environment "Amethyst.Broker@invalid.com" password "ALaska13!" and "Amethyst.Broker@invalid.com" password "ALaska13!"
  And  I validate I am on the "Agency Dashboard" page
  Then I click Agency Dashboard
  And  I validate I am on the "Agency Dashboard" page 
  Then I wait for 100 milliseconds
  And I validate the MVR container text in the dashboard Page
  Then I search for "!" in search mvr container
  Then I validate the I can't search for special characters on Search Bar
  And I clear the MVR search box in broker dashboard page
  And I click the right pagination arrow button 3 times in mvr container
  Then I verify the current result page is "5" in mvr container
  And I click the left pagination arrow button 4 times in mvr container
  Then I verify the current result page is "1" in mvr container
  And I wait for 500 milliseconds
  Then I search for "tr" in search mvr container
  And I wait for 300 milliseconds
  And I validate the result contains "tr"

  @SLER-1990
  Scenario: Admin Staff should not be able to see the MVR container
    Given I open the login page on the "broker" portal
    Then I validate I am on the "Login" page
    When I open the login page on the "broker" portal
    And I login as Broker User any environment "" password "ALaska12!" and "carrimautomation+HaroldPottermore@gmail.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I click Broker Dashboard
    Then I validate the mvr container is not displayed














