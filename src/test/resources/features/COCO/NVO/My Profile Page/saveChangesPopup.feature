Feature: My Profile Page Coco

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-183
  Scenario: Save Changes Popup on My Profile page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    Then I verify Password Popup text on My profile page CoCo "English"
    And I change the language from header to "Spanish"
    Then I verify Password Popup text on My profile page CoCo "Spanish"
