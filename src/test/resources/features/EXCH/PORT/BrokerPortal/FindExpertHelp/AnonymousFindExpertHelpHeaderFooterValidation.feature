@FindExpertHelp @port
Feature: Anonymous Find Expert Help page header and footer validation

  @SLER-2146
  Scenario: Anonymous Find Expert Help page header and footer validation
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I verify Find Expert Help header Text in "English"
    Then I validate I am on the "LUGY Find expert help" page

    And I verify text on the "Exch" "Anonymous Find Expert Help" in "English"

    Then I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "Login" page
    And I wait for 2000 milliseconds
    And I click Go Back button from chrome browser
    Then I validate I am on the "LUGY Find expert help" page

    Then I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "Login" page
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "LUGY Find expert help" page

    Then I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Login" page
    And I wait for 2000 milliseconds
    And I click Go Back button from chrome browser
    Then I validate I am on the "LUGY Find expert help" page

    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "Login" page
    And I wait for 2000 milliseconds
    And I click Go Back button from chrome browser
    Then I validate I am on the "LUGY Find expert help" page

    And I click on Learn More in the Header
    Then I validate I am on the "Faqs" page and close tab
    Then I validate I am on the "LUGY Find expert help" page

    And I click on Get Assistance in the "Exch" Header
    Then I click on Find Expert Assistance in the "Exch" Header
    Then I verify Find Expert Help header Text in "English"
    Then I validate I am on the "LUGY Find expert help" page

    And I click on Get Assistance in the "Exch" Header
    Then I click on Contact Us in the Header
    And I validate I am on the "Customer Service" page and close tab

    And I verify text on the "Exch" "Footer" in "English"
    Then I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
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

    Then I change the language from header to "Spanish"
    And I wait for 2000 milliseconds
    And I verify text on the "Exch" "Anonymous Find Expert Help" in "Spanish"

    Then I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "Login" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "LUGY Find expert help" page

    Then I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "Login" page
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "LUGY Find expert help" page

    Then I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Login" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "LUGY Find expert help" page

    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "Login" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "LUGY Find expert help" page

    And I click on Learn More in the Header
    Then I validate I am on the "Faqs" page and close tab
    Then I validate I am on the "LUGY Find expert help" page

    And I click on Get Assistance in the "Exch" Header
    Then I click on Find Expert Assistance in the "Exch" Header
    Then I verify Find Expert Help header Text in "Spanish"
    Then I validate I am on the "LUGY Find expert help" page

    And I click on Get Assistance in the "Exch" Header
    Then I click on Contact Us in the Header
    And I validate I am on the "Customer Service" page and close tab

    And I verify text on the "Exch" "Footer" in "Spanish"
    Then I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
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