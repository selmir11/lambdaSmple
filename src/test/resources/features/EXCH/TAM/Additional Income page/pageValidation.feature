@TAM @TamExch
Feature: Page Verification-Additional Income Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
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
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page

  @SLER-141 @PageVerificationAdditionalIncomePage @TAMSmokeExch
  Scenario: SLER-141 I see the Errors Cleared on the Additional Income page - English
    Then I click "Alimony Received" as additional income option
    Then I click continue on the Additional Income page
    Then I validate I am on the "Additional income" page
    Then I verify error for additional income option with no amount in "English"
    Then I verify error for additional income option with no frequency in "English"

    Then I click "None of these" as additional income option
    Then I click "Alimony Received" as additional income option
    Then I verify no errors show for additional income options
    Then I click "Alimony Received" as additional income option

    Then I click "Capital Gains" as additional income option
    Then I click "Income from rental property" as additional income option with "500.00" amount at "Annually" frequency
    Then I click continue on the Additional Income page
    Then I validate I am on the "Additional income" page
    Then I verify error for additional income option with no amount in "English"
    Then I verify error for additional income option with no frequency in "English"

    Then I click "Capital Gains" as additional income option
    Then I click "Capital Gains" as additional income option
    Then I verify no errors show for additional income options
    Then I click "Capital Gains" as additional income option
    Then I click "Income from rental property" as additional income option

    Then I click "Pension" as additional income option
    Then I click "Private Retirement income" as additional income option with "25.00" amount at "Monthly" frequency
    Then I click continue on the Additional Income page
    Then I validate I am on the "Additional income" page
    Then I verify error for additional income option with no amount in "English"
    Then I verify error for additional income option with no frequency in "English"

    Then I click "None of these" as additional income option
    Then I click "Pension" as additional income option
    Then I click "Private Retirement income" as additional income option
    Then I verify no errors show for additional income options
    Then I verify "Private Retirement income" as additional income option with "25.00" amount at "3: Monthly" frequency

    Then I click "Private Retirement income" as additional income option
    Then I click "Private Retirement income" as additional income option
    Then I verify no errors show for additional income options
    Then I verify "Private Retirement income" as additional income option with "25.00" amount at "3: Monthly" frequency

    Then I click "Pension" as additional income option
    Then I click "Private Retirement income" as additional income option
    Then I verify no error shows for additional income page

    Then I click "None of these" as additional income option
    Then I verify no error shows for additional income page
    Then I verify no errors show for additional income options
    Then I click "None of these" as additional income option
    Then I verify no error shows for additional income page
    Then I verify no errors show for additional income options

    Then I click continue on the Additional Income page
    Then I validate I am on the "Additional income" page
    Then I verify "English" error shows for additional income page

    Then I click "None of these" as additional income option
    Then I verify no error shows for additional income page
    Then I verify no errors show for additional income options

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page



  @SLER-155 @PageVerificationAdditionalIncomePage
  Scenario: SLER-155 I see the Errors Cleared on the Additional Income page - Spanish
    Then I change the language from header to "Spanish"
    Then I click "Alimony Received" as additional income option
    Then I click continue on the Additional Income page
    Then I validate I am on the "Additional income" page
    Then I verify error for additional income option with no amount in "Spanish"
    Then I verify error for additional income option with no frequency in "Spanish"

    Then I click "None of these" as additional income option
    Then I click "Alimony Received" as additional income option
    Then I verify no errors show for additional income options
    Then I click "Alimony Received" as additional income option

    Then I click "Capital Gains" as additional income option
    Then I click "Income from rental property" as additional income option with "500.00" amount at "Anualmente" frequency
    Then I click continue on the Additional Income page
    Then I validate I am on the "Additional income" page
    Then I verify error for additional income option with no amount in "Spanish"
    Then I verify error for additional income option with no frequency in "Spanish"

    Then I click "Capital Gains" as additional income option
    Then I click "Capital Gains" as additional income option
    Then I verify no errors show for additional income options
    Then I click "Capital Gains" as additional income option
    Then I click "Income from rental property" as additional income option

    Then I click "Pension" as additional income option
    Then I click "Private Retirement income" as additional income option with "25.00" amount at "Mensualmente" frequency
    Then I click continue on the Additional Income page
    Then I validate I am on the "Additional income" page
    Then I verify error for additional income option with no amount in "Spanish"
    Then I verify error for additional income option with no frequency in "Spanish"

    Then I click "None of these" as additional income option
    Then I click "Pension" as additional income option
    Then I click "Private Retirement income" as additional income option
    Then I verify no errors show for additional income options
    Then I verify "Private Retirement income" as additional income option with "25.00" amount at "3: Monthly" frequency

    Then I click "Private Retirement income" as additional income option
    Then I click "Private Retirement income" as additional income option
    Then I verify no errors show for additional income options
    Then I verify "Private Retirement income" as additional income option with "25.00" amount at "3: Monthly" frequency

    Then I click "Pension" as additional income option
    Then I click "Private Retirement income" as additional income option
    Then I verify no error shows for additional income page

    Then I click "None of these" as additional income option
    Then I verify no error shows for additional income page
    Then I verify no errors show for additional income options
    Then I click "None of these" as additional income option
    Then I verify no error shows for additional income page
    Then I verify no errors show for additional income options

    Then I click continue on the Additional Income page
    Then I validate I am on the "Additional income" page
    Then I verify "Spanish" error shows for additional income page

    Then I click "None of these" as additional income option
    Then I verify no error shows for additional income page
    Then I verify no errors show for additional income options

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-1206 @PageVerificationAdditionalIncomePage
  Scenario: SLER-1206 I verify that income-portal-ui uses common components from ng-common on the Additional Income page in EXCH
    Then I verify Additional Income checkbox in "Not Selected" state
    Then I verify Additional Income checkbox in "Selected" state
    Then I verify Additional Income checkbox in "Focus" state
    Then I verify Additional Income checkbox in "Hover" state

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2352
  Scenario: SLER-2352 Automate navigation on the ELMO Additional Income Sources Page in EXCH
    Then I validate I am on the "Additional income" page
    Then I click on the Back button on the Additionalincomepage
    Then I validate I am on the "Income Summary" page
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page
    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
      | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook          | facebook.com                          |
      | xIcon          | X                 | x.com                                 |
      | YouTubeIcon    | YouTube           | youtube.com                           |
      | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
      | InstagramIcon  | Login • Instagram | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.com                           |
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I validate I am on the "Income Summary" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I validate I am on the "Income Summary" page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I validate I am on the "Income Summary" page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I validate I am on the "Income Summary" page
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab
    Then I validate I am on the "Income Summary" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "ExpertHelp" Header

    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I validate I am on the "Income Summary" page

    Then I validate I am on the "Additional income" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Contact Us in the Header
    And I validate I am on the "Customer Service" page and close tab

    And I click on the Username in the "Exch" Header
    Then I validate I am on the "My Profile" page

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I validate I am on the "Income Summary" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I click on Sign Out in the Header for "Elmo"

  @SLER-2304
  Scenario: SLER-2304 As an Exchange account user on the Additional Income Sources page, I want the fields validated so my information is formatted correctly to meet the standards required for my application-English Validations(RT-2595)
    And I click continue on the Additional Income page
    Then I verify "English" error shows for additional income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                           | fontSize | fontFamily            | fontWeight | color              |
      | Please select one or more of the options below | 16px     | "PT Sans", sans-serif | 700        | rgba(150, 0, 0, 1) |
    Then I click "Alimony Received" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Alimony Received" as additional income option
    Then I click "Alimony Received" as additional income option with "48.91" amount at "Weekly" frequency
    And I verify no errors show for additional income options
    Then I click "Alimony Received" as additional income option
    Then I click "Alimony Received" as additional income option with "111111111.11" amount at "Weekly" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Alimony Received" as additional income option
    And I verify no error shows for additional income page
    Then I click "Capital Gains" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Capital Gains" as additional income option
    Then I click "Capital Gains" as additional income option with "48.91" amount at "Weekly" frequency
    And I verify no errors show for additional income options
    Then I click "Capital Gains" as additional income option
    Then I click "Capital Gains" as additional income option with "111111111.11" amount at "Weekly" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Capital Gains" as additional income option
    And I verify no error shows for additional income page
    Then I click "Income from rental property" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Income from rental property" as additional income option
    Then I click "Income from rental property" as additional income option with "48.91" amount at "Weekly" frequency
    And I verify no errors show for additional income options
    Then I click "Income from rental property" as additional income option
    Then I click "Income from rental property" as additional income option with "111111111.11" amount at "Weekly" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Income from rental property" as additional income option
    And I verify no error shows for additional income page
    Then I click "Pension" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Pension" as additional income option
    Then I click "Pension" as additional income option with "48.91" amount at "Weekly" frequency
    And I verify no errors show for additional income options
    Then I click "Pension" as additional income option
    Then I click "Pension" as additional income option with "111111111.11" amount at "Weekly" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Pension" as additional income option
    And I verify no error shows for additional income page
    Then I click "Private Retirement income" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Private Retirement income" as additional income option
    Then I click "Private Retirement Income" as additional income option with "48.91" amount at "Weekly" frequency
    And I verify no errors show for additional income options
    Then I click "Private Retirement income" as additional income option
    Then I click "Private Retirement Income" as additional income option with "111111111.11" amount at "Weekly" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Private Retirement income" as additional income option
    And I verify no error shows for additional income page
    Then I click "Income from Social Security" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Income from Social Security" as additional income option
    Then I click "Income from Social Security" as additional income option with "48.91" amount at "Weekly" frequency
    And I verify no errors show for additional income options
    Then I click "Income from Social Security" as additional income option
    Then I click "Income from Social Security" as additional income option with "111111111.11" amount at "Weekly" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Income from Social Security" as additional income option
    And I verify no error shows for additional income page
    Then I click "Unemployment insurance benefit" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Unemployment insurance benefit" as additional income option
    Then I click "Unemployment insurance benefit" as additional income option with "48.91" amount at "Weekly" frequency
    And I verify no errors show for additional income options
    Then I click "Unemployment insurance benefit" as additional income option
    Then I click "Unemployment insurance benefit" as additional income option with "111111111.11" amount at "Weekly" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Unemployment insurance benefit" as additional income option
    And I verify no error shows for additional income page
    Then I click "Investment Income" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Investment Income" as additional income option
    Then I click "Investment Income" as additional income option with "48.91" amount at "Weekly" frequency
    And I verify no errors show for additional income options
    Then I click "Investment Income" as additional income option
    Then I click "Investment Income" as additional income option with "111111111.11" amount at "Weekly" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Investment Income" as additional income option
    And I verify no error shows for additional income page
    Then I click "Cash Support" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Cash Support" as additional income option
    Then I click "Cash Support" as additional income option with "48.91" amount at "Weekly" frequency
    And I verify no errors show for additional income options
    Then I click "Cash Support" as additional income option
    Then I click "Cash Support" as additional income option with "111111111.11" amount at "Weekly" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Cash Support" as additional income option
    And I verify no error shows for additional income page
    Then I click "Untaxed foreign income" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Untaxed foreign income" as additional income option
    Then I click "Untaxed foreign income" as additional income option with "48.91" amount at "Weekly" frequency
    And I verify no errors show for additional income options
    Then I click "Untaxed foreign income" as additional income option
    Then I click "Untaxed foreign income" as additional income option with "111111111.11" amount at "Weekly" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Untaxed foreign income" as additional income option
    And I verify no error shows for additional income page
    Then I click "Royalty income" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Royalty income" as additional income option
    Then I click "Royalty income" as additional income option with "48.91" amount at "Weekly" frequency
    And I verify no errors show for additional income options
    Then I click "Royalty income" as additional income option
    Then I click "Royalty income" as additional income option with "111111111.11" amount at "Weekly" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Royalty income" as additional income option
    And I verify no error shows for additional income page
    Then I click "Taxable income from Tribal Sources" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color              |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Taxable income from Tribal Sources" as additional income option
    Then I click "Taxable income from Tribal Sources" as additional income option with "48.91" amount at "Weekly" frequency
    And I verify no errors show for additional income options
    Then I click "Taxable income from Tribal Sources" as additional income option
    Then I click "Taxable income from Tribal Sources" as additional income option with "111111111.11" amount at "Weekly" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Amount is required"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Taxable income from Tribal Sources" as additional income option
    And I verify no error shows for additional income page
    Then I click "Taxable income from Tribal Sources" as additional income option
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I click continue on the Additional Income page
    Then I click go back button on the Deductions page
    Then I validate I am on the "Additional income" page
    Then I verify "Taxable income from Tribal Sources" as additional income option with "4,398,573.45" amount at "5: Weekly" frequency
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2374
  Scenario: SLER-2374 As an Exchange account user on the Additional Income Sources page, I want the fields validated so my information is formatted correctly to meet the standards required for my application-Spanish Validations(RT-2595 Spanish)
    Then I change the language from header to "Spanish"
    And I click continue on the Additional Income page
    Then I verify "Spanish" error shows for additional income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                            | fontSize | fontFamily            | fontWeight | color              |
      | Seleccione una o más de las siguientes opciones | 16px     | "PT Sans", sans-serif | 700        | rgba(150, 0, 0, 1) |
    Then I click "Alimony Received" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                      | fontSize | fontFamily            | fontWeight | color              |
      | Esta cantidad es obligatoria              | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Seleccione una de las siguientes opciones | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Alimony Received" as additional income option
    Then I click "Alimony Received" as additional income option with "48.91" amount at "Semanalmente" frequency
    And I verify no errors show for additional income options
    Then I click "Alimony Received" as additional income option
    Then I click "Alimony Received" as additional income option with "111111111.11" amount at "Semanalmente" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Alimony Received" as additional income option
    And I verify no error shows for additional income page
    Then I click "Capital Gains" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                      | fontSize | fontFamily            | fontWeight | color              |
      | Esta cantidad es obligatoria              | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Seleccione una de las siguientes opciones | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Capital Gains" as additional income option
    Then I click "Capital Gains" as additional income option with "48.91" amount at "Semanalmente" frequency
    And I verify no errors show for additional income options
    Then I click "Capital Gains" as additional income option
    Then I click "Capital Gains" as additional income option with "111111111.11" amount at "Semanalmente" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Capital Gains" as additional income option
    And I verify no error shows for additional income page
    Then I click "Income from rental property" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                      | fontSize | fontFamily            | fontWeight | color              |
      | Esta cantidad es obligatoria              | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Seleccione una de las siguientes opciones | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Income from rental property" as additional income option
    Then I click "Income from rental property" as additional income option with "48.91" amount at "Semanalmente" frequency
    And I verify no errors show for additional income options
    Then I click "Income from rental property" as additional income option
    Then I click "Income from rental property" as additional income option with "111111111.11" amount at "Semanalmente" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Income from rental property" as additional income option
    And I verify no error shows for additional income page
    Then I click "Pension" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                      | fontSize | fontFamily            | fontWeight | color              |
      | Esta cantidad es obligatoria              | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Seleccione una de las siguientes opciones | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Pension" as additional income option
    Then I click "Pension" as additional income option with "48.91" amount at "Semanalmente" frequency
    And I verify no errors show for additional income options
    Then I click "Pension" as additional income option
    Then I click "Pension" as additional income option with "111111111.11" amount at "Semanalmente" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Pension" as additional income option
    And I verify no error shows for additional income page
    Then I click "Private Retirement income" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                      | fontSize | fontFamily            | fontWeight | color              |
      | Esta cantidad es obligatoria              | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Seleccione una de las siguientes opciones | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Private Retirement income" as additional income option
    Then I click "Private Retirement Income" as additional income option with "48.91" amount at "Semanalmente" frequency
    And I verify no errors show for additional income options
    Then I click "Private Retirement income" as additional income option
    Then I click "Private Retirement Income" as additional income option with "111111111.11" amount at "Semanalmente" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Private Retirement income" as additional income option
    And I verify no error shows for additional income page
    Then I click "Income from Social Security" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                      | fontSize | fontFamily            | fontWeight | color              |
      | Esta cantidad es obligatoria              | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Seleccione una de las siguientes opciones | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Income from Social Security" as additional income option
    Then I click "Income from Social Security" as additional income option with "48.91" amount at "Semanalmente" frequency
    And I verify no errors show for additional income options
    Then I click "Income from Social Security" as additional income option
    Then I click "Income from Social Security" as additional income option with "111111111.11" amount at "Semanalmente" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Income from Social Security" as additional income option
    And I verify no error shows for additional income page
    Then I click "Unemployment insurance benefit" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                      | fontSize | fontFamily            | fontWeight | color              |
      | Esta cantidad es obligatoria              | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Seleccione una de las siguientes opciones | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Unemployment insurance benefit" as additional income option
    Then I click "Unemployment insurance benefit" as additional income option with "48.91" amount at "Semanalmente" frequency
    And I verify no errors show for additional income options
    Then I click "Unemployment insurance benefit" as additional income option
    Then I click "Unemployment insurance benefit" as additional income option with "111111111.11" amount at "Semanalmente" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Unemployment insurance benefit" as additional income option
    And I verify no error shows for additional income page
    Then I click "Investment Income" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                      | fontSize | fontFamily            | fontWeight | color              |
      | Esta cantidad es obligatoria              | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Seleccione una de las siguientes opciones | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Investment Income" as additional income option
    Then I click "Investment Income" as additional income option with "48.91" amount at "Semanalmente" frequency
    And I verify no errors show for additional income options
    Then I click "Investment Income" as additional income option
    Then I click "Investment Income" as additional income option with "111111111.11" amount at "Semanalmente" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Investment Income" as additional income option
    And I verify no error shows for additional income page
    Then I click "Cash Support" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                      | fontSize | fontFamily            | fontWeight | color              |
      | Esta cantidad es obligatoria              | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Seleccione una de las siguientes opciones | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Cash Support" as additional income option
    Then I click "Cash Support" as additional income option with "48.91" amount at "Semanalmente" frequency
    And I verify no errors show for additional income options
    Then I click "Cash Support" as additional income option
    Then I click "Cash Support" as additional income option with "111111111.11" amount at "Semanalmente" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Cash Support" as additional income option
    And I verify no error shows for additional income page
    Then I click "Untaxed foreign income" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                      | fontSize | fontFamily            | fontWeight | color              |
      | Esta cantidad es obligatoria              | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Seleccione una de las siguientes opciones | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Untaxed foreign income" as additional income option
    Then I click "Untaxed foreign income" as additional income option with "48.91" amount at "Semanalmente" frequency
    And I verify no errors show for additional income options
    Then I click "Untaxed foreign income" as additional income option
    Then I click "Untaxed foreign income" as additional income option with "111111111.11" amount at "Semanalmente" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Untaxed foreign income" as additional income option
    And I verify no error shows for additional income page
    Then I click "Royalty income" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                      | fontSize | fontFamily            | fontWeight | color              |
      | Esta cantidad es obligatoria              | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Seleccione una de las siguientes opciones | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Royalty income" as additional income option
    Then I click "Royalty income" as additional income option with "48.91" amount at "Semanalmente" frequency
    And I verify no errors show for additional income options
    Then I click "Royalty income" as additional income option
    Then I click "Royalty income" as additional income option with "111111111.11" amount at "Semanalmente" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Royalty income" as additional income option
    And I verify no error shows for additional income page
    Then I click "Taxable income from Tribal Sources" as additional income option
    And I click continue on the Additional Income page
    And I validate the error text with its properties and the error icon on the Additional Income page
      | Text                                      | fontSize | fontFamily            | fontWeight | color              |
      | Esta cantidad es obligatoria              | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
      | Seleccione una de las siguientes opciones | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I click "Taxable income from Tribal Sources" as additional income option
    Then I click "Taxable income from Tribal Sources" as additional income option with "48.91" amount at "Semanalmente" frequency
    And I verify no errors show for additional income options
    Then I click "Taxable income from Tribal Sources" as additional income option
    Then I click "Taxable income from Tribal Sources" as additional income option with "111111111.11" amount at "Semanalmente" frequency
    And I click continue on the Additional Income page
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "-324Ab4@_ 5465746547623454" and verify that the value is converted to "324,454,657.46"
    Then I verify the Active Error message as "Esta cantidad es obligatoria"
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I verify no error shows for additional income page
    Then I click "Taxable income from Tribal Sources" as additional income option
    And I verify no error shows for additional income page
    Then I click "Taxable income from Tribal Sources" as additional income option
    Then I enter the value "439857345" and verify that the value is converted to "4,398,573.45"
    And I click continue on the Additional Income page
    Then I click go back button on the Deductions page
    Then I validate I am on the "Additional income" page
    Then I verify "Taxable income from Tribal Sources" as additional income option with "4,398,573.45" amount at "5: Weekly" frequency
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2409
  Scenario: SLER-2409 As an Exch user, want to see the Additional income sources page so that I can enter my additional income information in English[RT-2610]
    Then I verify color font border of the header and other page texts other than check boxes for AI page
      | Income:                                                         |
      | Additional income sources                                       |
      | Did you receive any of the following income?                    |
      | Select all that apply, and enter the amount of income received. |
    Then I verify all add income options color size format text and view order
      | Alimony Received                   |
      | Capital Gains                      |
      | Income from rental property        |
      | Pension                            |
      | Private Retirement income          |
      | Income from Social Security        |
      | Unemployment insurance benefit     |
      | Investment Income                  |
      | Cash Support                       |
      | Untaxed foreign income             |
      | Royalty income                     |
      | Taxable income from Tribal Sources |
      | None of these                      |
    Then I verify page text of Go_Back as "Go back" and Save_And_Continue as "Save and continue" in AI page
    When I click on Alimony Received check box
    Then I verify default property of amount box and dropdown in AI page for "English"
      | Select Option |
      | Annually      |
      | Every 2 weeks |
      | Monthly       |
      | Twice a month |
      | Weekly        |
    When I click on Alimony Received check box
    Then I click "Alimony Received" as additional income option with "400.00" amount at "Annually" frequency
    Then I verify amount "400.00" and frequency "Annually" is selected in AI page
    Then I verify when None_of_these selected Other checkboxes not selected in AI page
    Then I verify font color size of back and save button in AI page when mouse_Hover is "Off"
    Then I verify font color size of back and save button in AI page when mouse_Hover is "On"

  @SLER-2411
  Scenario: SLER-2411 As an Exch user, want to see the Additional income sources page so that I can enter my additional income information in Spanish[RT-2610]
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I verify color font border of the header and other page texts other than check boxes for AI page
      | Ingresos:                                                                        |
      | Otras fuentes de ingreso                                                         |
      | ¿Recibió alguno de los ingresos siguientes?                                      |
      | Seleccione todo lo que corresponda y registre la cantidad de ingreso que recibe. |
    Then I verify all add income options color size format text and view order
      | Pensión alimenticia recibida                    |
      | Ganancias de capital                            |
      | Ingresos por renta de propiedades               |
      | Pensión                                         |
      | Ingresos privados por retiro                    |
      | Ingresos por el Seguro Social                   |
      | Beneficio del seguro de desempleo               |
      | Ingresos derivados de inversiones               |
      | Apoyo en efectivo                               |
      | Ingresos obtenidos en el extranjero no gravados |
      | Ingresos por regalías                           |
      | Ingresos gravables de origen tribal             |
      | Ninguna de las anteriores                       |
    Then I verify page text of Go_Back as "Volver" and Save_And_Continue as "Guardar y continuar" in AI page
    When I click on Alimony Received check box
    Then I verify default property of amount box and dropdown in AI page for "Spanish"
      | Seleccionar opción |
      | Anualmente         |
      | Cada dos semanas   |
      | Mensualmente       |
      | Dos veces por mes  |
      | Semanalmente       |
    When I click on Alimony Received check box
    Then I click "Alimony Received" as additional income option with "300.00" amount at "Anualmente" frequency
    Then I verify amount "300.00" and frequency "Anualmente" is selected in AI page
    Then I verify when None_of_these selected Other checkboxes not selected in AI page
    Then I verify font color size of back and save button in AI page when mouse_Hover is "Off"
    Then I verify font color size of back and save button in AI page when mouse_Hover is "On"
