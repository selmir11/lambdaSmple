Feature: My Profile Page Coco

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-641 @NVOCoCoRegression
  Scenario: Timeout Session popup on my profile page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    And I validate timeout session popup "English" on My Profile page CoCo
    And I wait for 10000 milliseconds
    And I change the language from header to "Spanish"
    And I wait for 10000 milliseconds
    And I validate timeout session popup "Spanish" on My Profile page CoCo
    And I wait for 10000 milliseconds
    And I change the language from header to "English"
    Then I validate I am on the "Login" page

    ####Timeout Session Popup Admin Portal ####

  Scenario: Timeout Session popup on Admin Portal OBO
    And I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "coco" account creation
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    And I validate timeout session popup "English" on My Profile page CoCo
    And I wait for 10000 milliseconds
    And I change the language from header to "Spanish"
    And I wait for 10000 milliseconds
    And I validate timeout session popup "Spanish" on My Profile page CoCo
    And I wait for 10000 milliseconds
    And I change the language from header to "English"
    Then I validate I am on the "Login" page
