@FindExpertHelpCoCo @portCOCO
Feature: CoCo Find expert help page header and footer validation via Admin Portal OBO

  @SLCR-763
  Scenario: : CoCo Find expert help page header and footer validation for Admin User
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an "Email" "AutomationUser" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I switch to the tab number 1
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help Exch OBO" page

    And I verify text on the "CoCo" "Admin portal OBO Header" in "English"

    Then I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "Find Expert Help Exch OBO" page

    Then I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help Exch OBO" page

    Then I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "Find Expert Help Exch OBO" page

    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "Find Expert Help Exch OBO" page

    And I click on Learn More in the Header
    Then I validate I am on the "Faqs" page and close tab
    Then I validate I am on the "Find Expert Help Exch OBO" page

    And I click on Get Assistance in the "Exch" Header
    Then I click on Find Expert Assistance in the "ExpertHelp in community" Header
    Then I verify Find Expert Help header Text in "English"

    And I verify text on the "CoCo" "Footer" in "English"
    Then I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab

    And I click on Sign Out in the Header for "Portal"
    And I close current tab and switch back to previous tab

    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an "Email" "AutomationUser" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I switch to the tab number 1
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help Exch OBO" page

    Then I change the language from header to "Spanish"
    And I verify text on the "CoCo" "Admin portal OBO Header" in "Spanish"

    Then I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "Find Expert Help Exch OBO" page

    Then I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "Find Expert Help Exch OBO" page

    Then I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "Find Expert Help Exch OBO" page

    Then I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    And I click Go Back button from chrome browser
    Then I validate I am on the "Find Expert Help Exch OBO" page

    And I click on Learn More in the Header
    Then I validate I am on the "Faqs" page and close tab
    Then I validate I am on the "Find Expert Help Exch OBO" page

    And I click on Get Assistance in the "Exch" Header
    Then I click on Find Expert Assistance in the "ExpertHelp in community" Header
    Then I verify Find Expert Help header Text in "Spanish"

    And I verify text on the "CoCo" "Footer" in "Spanish"
    Then I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab

    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page