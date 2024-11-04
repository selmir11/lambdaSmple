Feature: My Profile Page Coco

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-183 @NVOCoCoRegression
  Scenario: Save Changes Popup on My Profile page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    Then I verify Password Popup text on My profile page CoCo "English"
    And I change the language from header to "Spanish"
    Then I verify Password Popup text on My profile page CoCo "Spanish"


  @SLCR-190 @NVOCoCoRegression
  Scenario: Validation of password Popup on My profile page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    Then I verify Password Popup text on My profile page CoCo "English"
    And I change the language from header to "Spanish"
    Then I verify Password Popup text on My profile page CoCo "Spanish"
    Then I validate I am on the "My Profile" page

    And I validate the functionality of the Cancel link on My profile page CoCo "Spanish"
    And I change the language from header to "English"
    And I validate the functionality of the Cancel link on My profile page CoCo "English"
    Then I Validate the error message when no password in provided on the password popup on My profile page in CoCo "English"
    And I change the language from header to "Spanish"
    Then I Validate the error message when no password in provided on the password popup on My profile page in CoCo "Spanish"
    And I validate the incorrect password error message on My profile page in CoCo "Spanish"
    And I change the language from header to "English"
    And I validate the incorrect password error message on My profile page in CoCo "English"
    Then I validate member is logged out of account after third incorrect attempt on password popup CoCo
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Login" page
    Then I validate account is locked message on the Login page