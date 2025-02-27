@TAM @TamCoCo
Feature: Navigation-Declarations and Signature Page

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
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
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
    And I check "None of these" life change event checkbox
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page

  @SLCR-151 @PageNavigationD&SPage @TAMSmoke
  Scenario: SLCR-151 The 'Find Expert Assistance' link stops working when navigate back to the error and unauthorized pages in D&S portal
    #Step1
    And I change the C4 url to "Declarations and Signature portal Error CoCo"
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
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I change the C4 url to "Declarations and Signature portal Unauthorized CoCo"
    Then I validate I am on the "Unauthorized" page
    And I verify User name Link is displayed in the "CoCo" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-727 @PageNavigationD&SPage @TAMSmoke
  Scenario: SLCR-727 Verify you see the warning banner
    #Step 4
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I verify the header for Primary Member on the CoCo Declarations And Signature page in "English"
    And I right click on Apply for Coverage to open in new tab in the ELMO Header
    #Step 5
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I wait for 250 milliseconds
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    #Step 6
    And I validate notification banner on welcome page in "English"
    And I change the language from header to "Spanish"
    And I validate notification banner on welcome page in "Spanish"
    And I change the language from header to "English"
    #Step 7
    And I switch to the tab number 1
    And I validate no notification banner on welcome page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-770
  Scenario: SLCR-770 Page Navigation-Declarations and Signature
    And I validate page Navigation works for Header and Footer hyperlink text
      | HyperLinkText      | ExpectedPageTitle        | ContainsUrl                                      |
      | Privacy Policy     | Privacy Policy           | coco/InformationPortal/privacyPolicy             |
      | Terms Of Use       | Terms of Use             | coco/InformationPortal/termsOfUse                |
      | Contact Us         | Contact Us               | coco/InformationPortal/contactUs                 |
      | Learn More         | Contact Us               | coco/InformationPortal/contactUs                 |
      | Apply for Coverage | Welcome                  | coco/WelcomePortal/welcome                       |
      | Find a Plan        | ApplicationResultsPortal | coco/ApplicationResultsPortal/applicationResults |
      | My Account         | User Profile             | coco/UserProfileAdmin/profile                    |
      | CoCo Logo          | Welcome                  | coco/WelcomePortal/welcome                       |
      | UserName           | User Profile             | coco/UserProfileAdmin/profile                    |

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click the back button from Find Expert Help page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I select Go Back on the Declarations and Signature page
    And I validate I am on the "CoCo life change event" page
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    And I validate I am on the "Application Results CoCo" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    And I check "None of these" life change event checkbox
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I select Go Back on the Declarations and Signature page
    And I validate I am on the "CoCo life change event" page
    And I select continue on the LCE page

    #Navigate to Sign In Page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page