Feature: Create an exchange account

  Background:
    Given I open the login page on the login portal
    Then I validate I am on the "Login" page

    @SLER-20-WIP
  Scenario: Validate text on tobacco usage page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
   Then I validate I am on the "Account Overview" page
    And I apply for 2024
    Then I select No Thanks option from guide you section
    And I click on save and continue button
    #  Then I validate before you begin page is loaded
    Then I click on continue with  application button on Before you begin page
      And I report "Birth" and click continue
      # TO DO:: Update the below step to have param to accept all options
    Then I select "member" from the who are you question
    And I enter the details of the member and continue
   Then I answer all Id proofing questions and click continue
   And I click continue button on Congratulations page
       Then I validate I am on the "Find Expert Help" page
 Then I click Continue on my own button from Find Expert Help page
     And I enter details on tell us about yourself page and continue
   Then I enter Additional details and click continue on add address page
    And I enter citizenship details and click continue
    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select birth QLCE on tell us about life changes page
    And I Declare and sign
      And I wait for hold on content to disappear
     Then I click on view results and shop
    And I click continue on application results page
      Then I validate I am on the "Start Shopping" page
    Then I verify text on tobacco usage page
    Then I choose no tobacco usage and click save and exit on start shopping page
#



