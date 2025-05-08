@SLER-318 @LoginPortalLogin
Feature:RT-2452 - Update Legal Notice language on Individual Login Portal page

#  @SLER-318
#  Scenario: Login page text validation in English
#    Given I open the login page on the "login" portal
#    And I validate I am on the "Login" page
#    Then I validate the title of the page in "English"
#    And I validate the username and password text in the login page in "English"
#    Then I validate PEAK Text in "English"
#    And I validate legal notice text in "English"
#
#  @SLER-318
#  Scenario: Login page text validation in Spanish
#    Given I open the login page on the "login" portal
#    Then I change the language from header to "Spanish Login"
#    And I validate I am on the "Login" page
#    Then I validate the title of the page in "Spanish"
#    And I validate the username and password text in the login page in "Spanish"
#    Then I validate PEAK Text in "Spanish"
#    And I validate legal notice text in "Spanish"
#    Then I change the language from header to "English Login"
#
#
#  @SLER-318
#  Scenario: expired password text validation
#    Given I open the login page on the "broker" portal
#    And I validate I am on the "Login" page
#    And I login as Broker User any environment "cmijpmlpqjCM@test.com" password "ALaska12!" and "cmjsgljdsvCM@test.com" password "ALaska12!"
#    Then I verify Expired Password error message in "English"
#    And I change the language from header to "Spanish Login"
#    Then I verify Expired Password error message in "Spanish"

    @SLER-2289
  Scenario: validate the error for missing username and password in English
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click on sign in on login page
    And I validate the error msg username and password required in "English"
    Then I change the language from header to "Spanish Login"
    And I validate the error msg username and password required in "Spanish"


