@TAM @pageNavigation @TamCoCo
Feature: Tests related to the Additional Income page

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
    And I select "Yes" employment option
    And I enter "2000000" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

  @SLCR-133 @PageNavigationAdditionalIncome @TAMSmokeCoCo
  Scenario: SLCR-133 There is "None of these" option is selected on the Additional Income page in the first tab after changes are made in the second tab
    #Step1
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    And I select "Cash Support" as additional income option with "1000" amount at "Annually" frequency
    And I select "Untaxed Foreign Income" as additional income option with "100" amount at "Monthly" frequency
    And I select continue on the Additional Income CoCO page
    And I verify the header for Primary Member on the CoCo Deductions page in "English"
    And I select Back on the Deductions CoCo page
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    #Step2
    Then I open current page in new tab
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    And I switch to the tab number 0
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    And I unselect "Cash Support" option on the Additional Income CoCo page
    And I unselect "Untaxed Foreign Income" option on the Additional Income CoCo page
    And I select "Royalty Income" as additional income option with "5000" amount at "Monthly" frequency
    And I select continue on the Additional Income CoCO page
    #Step3
    And I switch to the tab number 1
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    And I select continue on the Additional Income CoCO page
    Then I verify the error banner at the top of the page
    #Step4
    And I switch to the tab number 0
    Then I validate I am on the "CoCo Deductions" page
    And I verify the header for Primary Member on the CoCo Deductions page in "English"
    And I refresh the page
    And I verify the header for Primary Member on the CoCo Deductions page in "English"
    And I select Back on the Deductions CoCo page
    #And I unselect "None of these" option on the Additional Income CoCo page
    Then I validate no error banner is displayed at the top of the page
    Then I validate "None of these" option is selected on the Additional Income CoCo page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-136 @PageNavigationAdditionalIncome
  Scenario: SLCR-136 The 'Find Expert Assistance' link stops working when navigate back to the error and unauthorized pages
    #Step1
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    And I change the C4 url to "Income portal Error CoCo"
    Then I validate I am on the "Error" page
    And I click Back to Welcome page Button on error CoCo page
    Then I click Go Back button from chrome browser
    And I verify User name Link is displayed in the "CoCo" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    #Step2
    And I click on Apply for Coverage in the "Elmo" Header
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    And I change the C4 url to "Income portal Unauthorized CoCo"
    Then I validate I am on the "Unauthorized" page
    And I verify User name Link is displayed in the "CoCo" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-435 @PageNavigationAdditionalIncome
  Scenario: SLCR-435 My session is invalidated when I log out in Income Portal, COCO
    #step1
    Then I validate I am on the "CoCo Additional Income" page
    Then I open current page in new tab
    Then I validate I am on the "CoCo Additional Income" page
    And I switch to the tab number 0
    Then I validate I am on the "CoCo Additional Income" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page
    #step2
    And I switch to the tab number 1
    Then I validate I am on the "CoCo Additional Income" page
    And I refresh the page
    And I validate I am on the "Login" page
    And I close current tab and switch back to previous tab
    #step3
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page

    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    Then I open current page in new tab
    Then I validate I am on the "CoCo Additional Income" page
    And I switch to the tab number 0
    Then I validate I am on the "CoCo Additional Income" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page
    #step4
    And I switch to the tab number 1
    Then I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I validate I am on the "Login" page

  @SLCR-726
  Scenario: SLCR-726 Page Navigation - Additional Member Additional Income CoCo page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
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

    Then I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select Back on the Deductions CoCo page
    Then I validate I am on the "CoCo Additional Income" page
    Then I select Go Back on the Additional Income CoCo page
    Then I validate I am on the "CoCo Employment Income" page

    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Spouse"
    And I click continue on Tell us about additional members of your household page
    And I click continue on the Additional information for additional member page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page

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
    Then I validate I am on the "CoCo Additional Income" page

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
    Then I validate I am on the "CoCo Additional Income" page

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
    Then I validate I am on the "CoCo Additional Income" page

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
    Then I validate I am on the "CoCo Additional Income" page

    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Additional Income" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Additional Income" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Additional Income" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-758
  Scenario: SLCR-758 Page Navigation - Additional Income CoCo page
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I validate I am on the "CoCo Deductions" page
    And I verify the header for Primary Member on the CoCo Deductions page in "English"
    And I select Back on the Deductions CoCo page
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    And I select Go Back on the Additional Income CoCo page
    And I validate I am on the "Employment Income" page
    And I verify the header for Primary Member on the CoCo Employment income page in "English"
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
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
    And I validate I am on the "CoCo Additional Income" page
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
    Then I validate I am on the "Race and Ethnicity" page
    And I click save and continue on the Race and Ethnicity page
    And I validate I am on the "Employment Income" page
    And I click continue on the Employment income page

    #Navigate to Sign In Page
    Then I validate I am on the "CoCo Additional Income" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page