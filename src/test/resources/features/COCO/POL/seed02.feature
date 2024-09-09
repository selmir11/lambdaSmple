Feature: Seed02 - Coco
    
  Background: Seed 02 For Coco-
      Given I open the login page on the "login" portal
      And I validate I am on the "Login" page
      When I click create a new account on login page
      Then I click create my account from pre-screen page
      And I enter general mandatory data for "coco" account creation
      Then I validate I am on the "Login" page
      And I enter valid credentials to login
      Then I validate I am on the "CoCo Welcome" page
      And I apply for the current year in CoCo
      Then I validate I am on the "Find Expert Help" page
      And I click on Find a Broker
      Then I Search authorized Broker "Mister Broker"
      And I click on Search button in find certified broker page
      And I click more details from the first broker result container
      Then I click Authorized broker