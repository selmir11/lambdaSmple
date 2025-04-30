@OPS @Exch @MyDocs
Feature: My documents Indiviual porter Header , Footer, Title and dropdown display validation
  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-700
  Scenario: My documents Indiviual porter Header , Footer, Title and dropdown display validation
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
#    Then I validate I am on the "My Documents"
    And I select year "All" in plan year
    And I verify the page text in "English" on the My Documents Page
#    Verify Footer and welcome back navigate button
    Then I validate Welcome back button navigates to welcome page
    Then I click link my docs on accountOverview page
#    Then I validate I am on the "My Documents" page
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I verify text on the "Exch" "Footer" in "English"
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
#    Verify Header and sign out
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click link my docs on accountOverview page
    And I click on Learn More in the Header
    And I validate I am on the "Contact Us" page and close tab
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click link my docs on accountOverview page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click link my docs on accountOverview page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "ExpertHelp in community" Header
    And I go to the previous browser page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application History" page
    And I go to the previous browser page

  @SLER-703
  Scenario: My documents Indiviual porter upload doc modal text for English/Spanish
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I verify the page text in "English" on the My Documents Page
    And I click on upload another document
    And I validate Modal texts on upload document pop up
    And I close button to close modal
    And I change the language from header to "Spanish"
    And I verify the page text in "Spanish Headers" on the My Documents Page
    And I click on upload another document in spanish
    And I validate upload another document modal texts in spanish
    And I close button to close modal

  @SLER-708
  Scenario: Verify user can select each category from category dropdown
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I click on upload another document
    And I verify user can select each type from type dropdown

