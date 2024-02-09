Feature: SLCR-28: TAM-Page Navigation-Welcome Page

  Background: I go the login portal
    Given I open the login page on the "login" portal

  Scenario: Create CoCo Account and Login
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the welcome page

    And I apply for 2024 CoCo
    Then I validate I am on the "Find Expert Help" page
    Then I click the back button from Find Expert Help page
    Then I validate I am on the welcome page
    Then I click on My Profile Button CoCo
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the welcome page
    Then I click on Application Results Button CoCo
    Then I validate I am on the "Application Results" page
    And I click on Apply for Coverage in the Header
    Then I validate I am on the welcome page
    Then I click on My Documents and Letters Button CoCo
    Then I validate I am on the "My Documents" page
    And I click on Apply for Coverage in the Header
    Then I validate I am on the welcome page

    And I click on Privacy Policy in the Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the welcome page
    And I click on Terms Of Use in the Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the welcome page
    And I click on Contact Us in the Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the welcome page

    And I click on the Colorado Connect or C4 Logo in the Header
    Then I validate I am on the welcome page
    And I click on Apply for Coverage in the Header
    Then I validate I am on the welcome page
    And I click on Find a Plan in the Header
    Then I validate I am on the "Application Results" page
    And I click on Apply for Coverage in the Header
    Then I validate I am on the welcome page
    And I click on My Account in the Header
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the welcome page
    And I click on Learn More in the Header
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the welcome page
    And I click on Get Assistance in the Header
    And I click on Find Expert Assistance in the Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the Header
    Then I validate I am on the welcome page




