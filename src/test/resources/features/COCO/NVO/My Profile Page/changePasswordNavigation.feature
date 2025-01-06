Feature: My Profile Page Coco


  Background: I go the login portal
    Given I open the login page on the "login" portal


@SLCR-647 @NVOCoCoRegression
  Scenario: English Change password on My Profile coco
  When I click create a new account on login page
  Then I click create my account from pre-screen page
  And I enter general mandatory data for "coco" account creation
  Then I validate I am on the "Login" page
  And  I enter valid credentials to login
  Then I click continue signing in on the CAC Screener page
  Then I validate I am on the "CoCo Welcome" page
  And I click on "My Profile" link on welcome page
  Then I validate I am on the "My Profile" page
  And I click on Make Changes Button in CoCo
  And I wait for 10000 milliseconds
  Then I verify Password text on My profile page "English" coco
  And I wait for 10000 milliseconds
  And I click the Change Password Button
  Then I validate I am on the "Forgot my password" page
  Then I validate the Forgot my password page title in "English"


  @SLCR-648 @NVOCoCoRegression
  Scenario: Spanish Change password on My Profile coco
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    And I change the language from header to "Spanish"
    And I click on Make Changes Button in CoCo
    And I wait for 10000 milliseconds
    Then I verify Password text on My profile page "Spanish" coco
    And I wait for 10000 milliseconds
    And I click the Change Password Button
    Then I validate I am on the "Forgot my password" page
    Then I validate the Forgot my password page title in "Spanish"