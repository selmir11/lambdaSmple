@TAM @TamCoCo
Feature: Navigation-Welcome Page

  Background: I go the login portal
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CAC Screener" page
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page

    @SLCR-28 @PageNavigationWelcomePage @TAMSmoke
  Scenario: SLCR-28 I check navigation from CoCo Welcome page - English
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    Then I click the back button from Find Expert Help page
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
      And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Welcome" page
      And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Welcome" page

    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on Find a Plan in the "Elmo" Header
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
    And I click on Get Assistance in the "Exch" Header
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


  @SLCR-40 @PageNavigationWelcomePage @TAMSmoke
  Scenario: SLCR-40 I check navigation from CoCo Welcome page - Spanish
    Then I wait for 200 milliseconds
    And I change the language from header to "Spanish"
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page

    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    Then I validate I am on the "Spanish" page
    Then I click the back button from Find Expert Help page
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy in "Header Spanish"
    Then I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    And I change the language from header to "Spanish"
    Then I validate I am on the "Spanish" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy in "Header Spanish"
    Then I click on "Application Results" link on welcome page
    Then I validate I am on the "Application Results CoCo" page
    Then I verify the header in "Spanish" on the Application Results Page CoCo
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on "My Plans" link on welcome page
    Then I validate I am on the "My Plans CoCo" page
    Then I validate I am on the "Spanish" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I click on "My Documents and Letters" link on welcome page
    Then I validate I am on the "My Documents" page
    And I verify the page text in "Spanish Headers" on the My Documents Page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page

    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page

    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    Then I validate I am on the "Spanish" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    And I change the language from header to "Spanish"
    Then I validate I am on the "Spanish" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy in "Header Spanish"
    And I click on Learn More in the Header
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy in "Header Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    Then I validate I am on the "Spanish" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    And I change the language from header to "Spanish"
    Then I validate I am on the "Spanish" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy in "Header Spanish"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page


  @SLCR-148 @PageNavigationWelcomePage
  Scenario: SLCR-148 The 'Find Expert Assistance' link stops working when navigate back to the error and unauthorized pages in Welcome portal
    #Step1
    Then I wait for 200 milliseconds
    And I change the C4 url to "Welcome portal Error CoCo"
    Then I validate I am on the "Error" page
    And I click Back to Welcome page Button on error CoCo page
    Then I click Go Back button from chrome browser
    And I verify User name Link is displayed in the "CoCo" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    #Step2
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I change the C4 url to "Welcome portal Unauthorized CoCo"
    Then I validate I am on the "Unauthorized" page
    And I verify User name Link is displayed in the "CoCo" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page


