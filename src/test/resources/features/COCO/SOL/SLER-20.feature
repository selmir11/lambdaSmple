Feature: Create an exchange account

  Background:
    Given I open the login page on the login portal

  Scenario: Validate text on tobacco usage page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter the member details
    Then I click on submit button
    Then I enter user name
    And I enter password
    Then I Click Sign In
    Then I Verify the header on myAccountOverview page
    And I apply for 2024
    Then I select No Thanks
    And I click on save and continue
    Then I click on continue with  application on Before you begin page
    And I report a QLCE - birth and click continue
    Then I check who are you question
    And I enter the details of the member and continue
    Then I answer all Id proofing questions and click continue
    And I continue on Congratulations page
    Then I select Continue on my own
    And I enter details on tell us about yourself page and continue
    Then I enter Additional details and click continue
    And I enter citizenship details and click continue
    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select birth QLCE on tell us about life changes page
    And I Declare and sign
    Then I click on view results and shop
    And I click continue on application results page
    Then I verify text on tobacco usage page
    Then I choose no tobacco usage and click save and exit on start shopping page
#



