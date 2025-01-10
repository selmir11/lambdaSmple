Feature: My Profile Page Coco

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-716 @NVOCoCoRegression
  Scenario: My Profile Text English and Spanish page Coco
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    And I verify text on My profile page Coco "English"
    And I change the language from header to "Spanish"
    And I verify text on My profile page Coco "Spanish"
    And I click on Make Changes Button in CoCo
    Then I verify Password text on My profile page Coco "Spanish"
    And I change the language from header to "English"
    Then I verify Password text on My profile page Coco "English"
    Then I click on Save Button on My profile CoCo