Feature: Navigation-Welcome Page

  Background: I go the login portal
    Given I open the login page on the "login" portal

    @SLCR-28 @PageNavigationWelcomePage
  Scenario: Create CoCo Account and Login
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CoCo Welcome" page

    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    Then I click the back button from Manage who helps you page
    Then I validate I am on the "CoCo Welcome" page
      And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
      And I click on "Application Results" link on welcome page
    Then I validate I am on the "Application Results CoCo" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
      And I click on "My Plans" link on welcome page
      Then I validate I am on the "My Plans CoCo" page
      And I click on Apply for Coverage in the "Elmo" Header
      Then I validate I am on the "CoCo Welcome" page
      And I click on "My Documents and Letters" link on welcome page
    Then I validate I am on the "My Documents" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page

      And I click on Privacy Policy in the Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Welcome" page
      And I click on Terms Of Use in the Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Welcome" page

    And I click on the Colorado Connect or C4 Logo in the Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on Find a Plan in the Header
    Then I validate I am on the "Application Results CoCo" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    And I click on Learn More in the Header
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    And I click on Get Assistance in the Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page
