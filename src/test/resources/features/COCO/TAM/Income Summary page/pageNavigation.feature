@TAM
Feature: Tests related to the Income Summary page

  Background: I go to the login portal
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I validate I am on the "CoCo Income Summary" page

    @SLCR-760
    Scenario: Page Navigation - Income Summary CoCo page
      And I select go back on the income summary CoCo page
      Then I validate I am on the "CoCo Deductions" page
      And I select continue on the Deductions CoCo page
      And I validate I am on the "CoCo Income Summary" page
      And I select the No projected Income button on the Income Summary page
      And I select continue on the income Summary CoCo page
      Then I validate I am on the "CoCo Family Overview" page
      And I click EditUpdate on Family Overview page for "Primary"
      Then I click Save and Continue only on the tell us about yourself page
      And I click continue on the Add info for yourself page
      Then I validate I am on the "Elmo Race and Ethnicity" page
      And I click save and continue on the Race and Ethnicity page
      And I validate I am on the "Employment Income" page
      And I click continue on the Employment income page
      Then I validate I am on the "CoCo Additional Income" page
      And I select continue on the Additional Income CoCO page
      Then I validate I am on the "CoCo Deductions" page
      And I select continue on the Deductions CoCo page
      And I validate I am on the "CoCo Income Summary" page
      And I validate page Navigation works for Header and Footer hyperlink text
        | HyperLinkText      | ExpectedPageTitle        | ContainsUrl                                      |
        | Privacy Policy     | Privacy Policy           | coco/InformationPortal/privacyPolicy             |
        | Terms Of Use       | Terms of Use             | coco/InformationPortal/termsOfUse                |
        | Contact Us         | Contact Us               | coco/InformationPortal/contactUs                 |
        | Learn More         | Contact Us               | coco/InformationPortal/contactUs                 |
        | Apply for Coverage | Welcome Portal           | coco/WelcomePortal/welcome                       |
        | Find a Plan        | ApplicationResultsPortal | coco/ApplicationResultsPortal/applicationResults |
        | My Account         | User Profile             | coco/UserProfileAdmin/profile                    |
        | CoCo Logo          | Welcome Portal           | coco/WelcomePortal/welcome                       |
        | UserName           | User Profile             | coco/UserProfileAdmin/profile                    |

    #Navigate to Find Expert Assistance page
      And I validate I am on the "CoCo Income Summary" page
      And I click on Find Expert Assistance in the "CoCo" Header
      Then I validate I am on the "Find Expert Help" page
      And I click the back button from Find Expert Help page
      And I apply for the current year in CoCo
      Then I validate I am on the "Find Expert Help" page
      And I click Continue on my own button from Manage who helps you page
      Then I validate I am on the "CoCo Family Overview" page
      Then I click EditUpdate on Family Overview page for "Primary"
      Then I click Save and Continue only on the tell us about yourself page
      And I click continue on the Add info for yourself page
      Then I validate I am on the "Elmo Race and Ethnicity" page
      And I click save and continue on the Race and Ethnicity page
      And I validate I am on the "Employment Income" page
      And I click continue on the Employment income page
      Then I validate I am on the "CoCo Additional Income" page
      And I select continue on the Additional Income CoCO page
      Then I validate I am on the "CoCo Deductions" page
      And I select continue on the Deductions CoCo page

    #Navigate to Sign In Page
      And I validate I am on the "CoCo Income Summary" page
      And I click on Sign Out in the Header for "Elmo"
      And I validate I am on the "Login" page
