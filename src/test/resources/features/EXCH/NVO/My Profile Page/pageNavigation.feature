Feature: My profile page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-51  @NVOExchRegression
  Scenario: My Profile Page Navigation
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click on ClickHere link for "My Profile"
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile Exch
    Then I validate I am on the "My Account Overview" page
    And I click on the Username Link Exch
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    And I click on Save Button
    And  I validate chat widget is present

    #Footer - English
    Then I validate I am on the "My Profile" page
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "My Profile" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "My Profile" page
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "My Profile" page
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    Then I validate I am on the "My Profile" page
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    Then I validate I am on the "My Profile" page
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    Then I validate I am on the "My Profile" page
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    Then I validate I am on the "My Profile" page
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    Then I validate I am on the "My Profile" page
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    Then I validate I am on the "My Profile" page

    #Footer - Spanish
    Then I validate I am on the "My Profile" page
    And I change the language from header to "Spanish"
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "My Profile" page
    And I verify text on My profile page "Spanish"
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "My Profile" page
    And I verify text on My profile page "Spanish"
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "My Profile" page
    And I verify text on My profile page "Spanish"
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    Then I validate I am on the "My Profile" page
    And I verify text on My profile page "Spanish"
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    Then I validate I am on the "My Profile" page
    And I verify text on My profile page "Spanish"
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    Then I validate I am on the "My Profile" page
    And I verify text on My profile page "Spanish"
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    Then I validate I am on the "My Profile" page
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    Then I validate I am on the "My Profile" page
    And I verify text on My profile page "Spanish"
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    Then I validate I am on the "My Profile" page
    And I change the language from header to "English"

    #Header
    And I verify text on the "Exch" "Header" in "English"
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Profile"

    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Profile"

    Then I validate I am on the "My Profile" page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Profile"

    Then I validate I am on the "My Profile" page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Profile"

    Then I validate I am on the "My Profile" page
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "My Profile" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Contact Us in the Header
    And I validate I am on the "Customer Service" page and close tab

    Then I validate I am on the "My Profile" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "ExpertHelp" Header
    Then I validate I am on the "My Account Overview" page
    Then I click on ClickHere link for "My Profile"

    Then I validate I am on the "My Profile" page
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"
    Then I validate I am on the "Login" page