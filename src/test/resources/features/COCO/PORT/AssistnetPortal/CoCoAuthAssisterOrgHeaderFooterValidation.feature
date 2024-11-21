@AssistNetCoCo @portCOCO
Feature: CoCo Authorize Assister Organization page header and footer validation

  @SLCR-427
  Scenario: : CoCo Authorize Assister Organization page header and footer validation
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click the Authorize Assister Organization button
    Then I validate I am on the "Authorize Assister Organization" page

    Then I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "Authorize Assister Organization" page

    Then I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I wait for 1000 milliseconds
    And I click the Authorize Assister Organization button
    Then I validate I am on the "Authorize Assister Organization" page

    Then I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    And I wait for 1000 milliseconds
    And I click the Authorize Assister Organization button
    Then I validate I am on the "Authorize Assister Organization" page

    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "Authorize Assister Organization" page

    And I click on Learn More in the Header
    Then I validate I am on the "Faqs" page and close tab
    Then I validate I am on the "Authorize Assister Organization" page

    And I click on Get Assistance in the "Exch" Header
    Then I click on Find Expert Assistance in the "CoCo" Header
    And I wait for 1000 milliseconds
    And I click the Authorize Assister Organization button
    Then I validate I am on the "Authorize Assister Organization" page

    And I verify text on the "CoCo" "Footer" in "English"
    Then I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab


    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page

    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I wait for 1000 milliseconds
    And I click the Authorize Assister Organization button
    Then I validate I am on the "Authorize Assister Organization" page

    Then I change the language from header to "Spanish"

    Then I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "Authorize Assister Organization" page

    Then I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I wait for 1000 milliseconds
    And I click the Authorize Assister Organization button
    Then I validate I am on the "Authorize Assister Organization" page

    Then I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    And I wait for 1000 milliseconds
    And I click the Authorize Assister Organization button
    Then I validate I am on the "Authorize Assister Organization" page

    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "Authorize Assister Organization" page

    And I click on Learn More in the Header
    Then I validate I am on the "Faqs" page and close tab

    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click Go Back button from chrome browser

    And I verify text on the "CoCo" "Footer" in "Spanish"
    Then I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab

    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page