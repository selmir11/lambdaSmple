@TAM @TamCoCo
Feature: Navigation-Life Change Event Page

  Background: I go the login portal
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primay"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page

  @SLCR-44 @PageNavigationLCEPage @TAMSmoke
  Scenario: SLCR-44 Navigate to and from LCE page
    And I select Go Back on the LCE page
    And I select continue on the Family Overview page
    # Test footer links
    Then I validate I am on the "CoCo life change event" page
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo life change event" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo life change event" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo life change event" page

    # Open enrollment test
    #And I check "None of these" life change event checkbox
    # Closed enrollment test
    And I select "InsuranceLoss" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I select Go Back on the Declarations and Signature page
    Then I validate I am on the "CoCo life change event" page

    # Test header links
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "FindExpertHelpCoco" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page

    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "FindExpertHelpCoco" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page

    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "FindExpertHelpCoco" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page

    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "FindExpertHelpCoco" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page

    And I click on Learn More in the Header
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo life change event" page

    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "FindExpertHelpCoco" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page

    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    And I apply for the current year in CoCo
    Then I validate I am on the "FindExpertHelpCoco" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-150 @PageNavigationLCEPage
  Scenario: SLCR-150 The 'Find Expert Assistance' link stops working when navigate back to the error and unauthorized pages in LCE portal
    #Step1
    And I change the C4 url to "LCE portal Error CoCo"
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
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I change the C4 url to "LCE portal Unauthorized CoCo"
    Then I validate I am on the "Unauthorized" page
    And I verify User name Link is displayed in the "CoCo" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page