@sampleTest
Feature: sample test

  @n1 @CCRT-14
  Scenario: Sample test to open the page and login - ccrt-14 -sample
    When I open the sample page
    And I create a new account
    And I click on help icon
   # And I validate the help drawer is open
    Then I validate the default verbiage on help icon
