@TAM @PageNavigationDeductions @TamCoCo
Feature: Tests related to the Deductions page

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

  @SLCR-740
  Scenario: SLCR-740 Income Service Doesn't Fail Gracefully During Attempt To Delete Non-Existent Income
    And I select "School tuition" as deduction option with "1500.00" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "English"
    And I select go back on the income summary CoCo page
    Then I validate I am on the "CoCo Deductions" page
    And I verify the header for Primary Member on the CoCo Deductions page in "English"
    Then I verify "School tuition" as Deductions option with "1,500.00" amount at "1: Annually" frequency CoCo page
    Then I open current page in new tab
    And I switch to the tab number 0
    Then I validate I am on the "CoCo Deductions" page
    And I verify the header for Primary Member on the CoCo Deductions page in "English"
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page
    And I switch to the tab number 1
    Then I validate I am on the "CoCo Deductions" page
    And I verify the header for Primary Member on the CoCo Deductions page in "English"
    And I select continue on the Deductions CoCo page
    Then I verify the error banner at the top of the page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-757
  Scenario: SLCR-757 Page Navigation - Additional Member Deductions CoCo page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Spouse", "08111990", "Male", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    And I select "Prefer not to answer" for race and ethnicity option for "Spouse"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page

    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page
    And I select go back on the income summary CoCo page
    Then I validate I am on the "CoCo Deductions" page
    And I select Back on the Deductions CoCo page
    Then I validate I am on the "CoCo Additional Income" page
    And I select continue on the Additional Income CoCO page

    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Spouse"
    And I click continue on Tell us about additional members of your household page
    And I click continue on the Additional information for additional member page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page

    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    And I click on Apply for Coverage in the "Elmo" Header
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Spouse"
    And I click continue on Tell us about additional members of your household page
    And I click continue on the Additional information for additional member page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page

    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Spouse"
    And I click continue on Tell us about additional members of your household page
    And I click continue on the Additional information for additional member page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page

    And I click on Learn More in the Header
    And I validate I am on the "Contact Us" page and close tab
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "Elmo" Header
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Spouse"
    And I click continue on Tell us about additional members of your household page
    And I click continue on the Additional information for additional member page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page

    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Spouse"
    And I click continue on Tell us about additional members of your household page
    And I click continue on the Additional information for additional member page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page

    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Deductions" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Deductions" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Deductions" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

    @SLCR-759
    Scenario: SLCR-759 Page Navigation - Member Deductions CoCo page
      Then I validate I am on the "CoCo Deductions" page
      And I select "None of these" as deductions option
      And I select continue on the Deductions CoCo page
      And I validate I am on the "CoCo Income Summary" page
      And I select go back on the income summary CoCo page
      Then I validate I am on the "CoCo Deductions" page
      And I select Back on the Deductions CoCo page
      And I select continue on the Additional Income CoCO page
      And I validate I am on the "CoCo Deductions" page
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

    #Navigate to Find Expert Assistance page
      And I validate I am on the "CoCo Deductions" page
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

    #Navigate to Sign In Page
      And I validate I am on the "CoCo Deductions" page
      And I click on Sign Out in the Header for "Elmo"
      And I validate I am on the "Login" page
