@TAM @pageNavigation @TamCoCo
Feature: Tests related to the Family Overview page

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

  @SLCR-149 @PageNavigationFamilyOverview @TAMSmokeCoCo
  Scenario: SLCR-149 The 'Find Expert Assistance' link stops working when navigate back to the error and unauthorized pages in Family Overview portal
    #Step1
    Then I validate I am on the "CoCo Family Overview" page
    And I change the C4 url to "Family Overview portal Error CoCo"
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
    And I change the C4 url to "Family Overview portal Unauthorized CoCo"
    Then I validate I am on the "Unauthorized" page
    And I verify User name Link is displayed in the "CoCo" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-436 @PageNavigationFamilyOverview
  Scenario: SLCR-436 My session is invalidated when I log out in Welcome Portal, COCO
    #step1
    Then I open current page in new tab
    Then I validate I am on the "CoCo Family Overview" page
    And I switch to the tab number 0
    Then I validate I am on the "CoCo Family Overview" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page
    #step2
    And I switch to the tab number 1
    Then I validate I am on the "CoCo Family Overview" page
    And I refresh the page
    And I validate I am on the "Login" page
    And I close current tab and switch back to previous tab
    #step3
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I open current page in new tab
    Then I validate I am on the "CoCo Family Overview" page
    And I switch to the tab number 0
    Then I validate I am on the "CoCo Family Overview" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page
    #step4
    And I switch to the tab number 1
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    And I validate I am on the "Login" page

  @SLCR-767
  Scenario: SLCR-767 Page Navigation-Family Overview Page
    Then I validate I am on the "CoCo Family Overview" page
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
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select Go Back on the LCE page
    Then I validate I am on the "CoCo Family Overview" page
    And I click Manage who helps you on the Family Overview page
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page

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
    And I validate I am on the "CoCo Family Overview" page
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click the back button from Find Expert Help page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    #Navigate to Sign In Page
    Then I validate I am on the "CoCo Family Overview" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page

  @SLCR-821
  Scenario: TAM- Member ID in CoCo URLs only allows CoCo inter-household Member IDs(CCRT-220)
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    And I retrieve the memberId of primary member from url
    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "34,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Spouse", "03021995", "Female", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I click on Sign Out in the Header for "Elmo"

   #Exchange account creation
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "Tell us about yourself" page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I retrieve the memberId of primary member from url
    And I click on Sign Out in the Header for "Elmo"

    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "102 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "34,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Spouse", "03021995", "Female", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "103 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "spouse"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "Employment Income" page

    #Validation Part
    Then I validate CoCo URL to reflect a Member ID of a CoCo member within or without the current household for "Employment Info" page
    And I select "Yes" employment option
    And I enter "49,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    Then I validate CoCo URL to reflect a Member ID of a CoCo member within or without the current household for "Additional Income" page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    Then I validate CoCo URL to reflect a Member ID of a CoCo member within or without the current household for "Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate CoCo URL to reflect a Member ID of a CoCo member within or without the current household for "Summary Details" page
