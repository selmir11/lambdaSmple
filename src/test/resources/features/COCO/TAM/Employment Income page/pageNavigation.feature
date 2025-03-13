@TAM @pageNavigation @TamCoCo
Feature: Tests related to the Employment Income page

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

  @SLCR-46 @PageNavigationEmploymentIncome @TAMSmokeCoCo
  Scenario: SLCR-46 I can navigate to and from Employment Income page with no errors
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    #Step1
    Then I validate I am on the "CoCo Employment Income" page
    And I select "Yes" employment option
    And I enter "2000000" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    #Step2
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    And I select Go Back on the Additional Income CoCo page
    And I verify the header for Primary Member on the CoCo Employment income page in "English"
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    Then I validate no error banner is displayed at the top of the page
    And I select Go Back on the Additional Income CoCo page
    And I verify the header for Primary Member on the CoCo Employment income page in "English"
    Then I validate no errors are displayed on the Employment income page
    Then I validate "No" job option is selected on the Employment income page
    #Step3
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-639 @PageNavigationEmploymentIncome @TAMSmokeCoCo
  Scenario: SLCR-639 I can navigate to and from Employment Income additional member page with no errors
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Spouse", "08111990", "Male", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    And I select "Prefer not to answer" for race and ethnicity option for "Spouse"
    And I click save and continue on the Race and Ethnicity page
    #Step1
    Then I validate I am on the "CoCo Employment Income" page
    And I select "Yes" employment option
    And I enter "2000000" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    #Step2
    And I select Go Back on the Additional Income CoCo page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I verify the header for additional member on the CoCo Additional Income page in "English"
    Then I validate no error banner is displayed at the top of the page
    And I select Go Back on the Additional Income CoCo page
    And I verify the header for additional member on the CoCo Employment income page in "English"
    Then I validate no errors are displayed on the Employment income page
    Then I validate "No" job option is selected on the Employment income page
    #Step3
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-732
  Scenario: SLCR-732 I want to be directed to the unauthorized page so that I know I have tried to access a page I am not authorized to access
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
#    check in English and change to Spanish
    Then I validate I am on the "CoCo Employment Income" page
    And I verify the header for Primary Member on the CoCo Employment income page in "English"
    And I change the C4 url to "Employment Income Unauthorized CoCo"
    Then I validate I am on the "Unauthorized" page
    Then I verify unauthorized text in "English"
    And I verify text on the "CoCo" "Header" in "English"
    And I verify text on the "CoCo" "Footer" in "English"
    And I change the language from header to "Spanish"
    Then I verify unauthorized text in "Spanish"
    And I verify text on the "CoCo" "Header" in "Spanish"
    And I verify text on the "CoCo" "Footer" in "Spanish"
#    check in Spanish and change to English
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I verify the header for Primary Member on the CoCo Employment income page in "Spanish"
    And I change the C4 url to "Employment Income Unauthorized CoCo"
    Then I validate I am on the "Unauthorized" page
    Then I verify unauthorized text in "Spanish"
    And I verify text on the "CoCo" "Header" in "Spanish"
    And I verify text on the "CoCo" "Footer" in "Spanish"
    And I change the language from header to "English"
    Then I verify unauthorized text in "English"
    And I verify text on the "CoCo" "Header" in "English"
    And I verify text on the "CoCo" "Footer" in "English"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-751
  Scenario: SLCR-751 Page Navigation-Employment Income
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

    #Navigate to Back Page
    And I click Go back on the Employment income page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I click save and continue on the Race and Ethnicity page

    #Navigate to Next Page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

    And I select Go Back on the Additional Income CoCo page
    And I verify the header for Primary Member on the CoCo Employment income page in "English"
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
    And I validate I am on the "Employment Income" page
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

    #Navigate to Sign In Page
    And I validate I am on the "Employment Income" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page


  @SLCR-768
  Scenario: SLCR-768 Page Navigation-Additional Member Employment Income
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
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
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Spouse", "08111990", "Male", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    And I select "Prefer not to answer" for race and ethnicity option for "Spouse"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    #Navigate to Next Page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select Go Back on the Additional Income CoCo page
    #Navigate to Back Page
    Then I validate I am on the "CoCo Employment Income" page
    And I click Go back on the Employment income page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I click save and continue on the Race and Ethnicity page

    Then I validate I am on the "CoCo Employment Income" page
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

    Then I validate I am on the "CoCo Employment Income" page
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click the back button from Find Expert Help page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Spouse"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I click save and continue on the Race and Ethnicity page

    #Navigate to Sign In Page
    And I validate I am on the "CoCo Employment Income" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page