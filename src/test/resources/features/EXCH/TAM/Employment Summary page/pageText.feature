@TAM @TamExch
Feature: Page Text-Income Opt Out Page

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
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "4500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page

  @SLER-243 @PageTextEmploymentSummary
  Scenario: SLER-243 I can see Employment Summary's Header and footer - English
    And I validate I am on the "Employment Summary" page
    And I verify text on the "Exch" "Header" in "English"
    And I verify text on the "Exch" "Footer" in "English"

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
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

    Then I validate I am on the "Employment Summary" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
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

    Then I validate I am on the "Employment Summary" page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
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

    Then I validate I am on the "Employment Summary" page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
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

    Then I validate I am on the "Employment Summary" page
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "Employment Summary" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Contact Us in the Header
    And I validate I am on the "Customer Service" page and close tab

    Then I validate I am on the "Employment Summary" page
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

    Then I validate I am on the "Employment Summary" page
    And I click on the Username in the "Exch" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
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

    Then I validate I am on the "Employment Summary" page
#    And I set the browser resolution to 1200 x 800
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    Then I validate I am on the "Employment Summary" page


    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-244 @PageTextEmploymentSummary @TAMSmokeExch
  Scenario: SLER-244 I can see Employment Summary's Header and footer - Spanish
    And I validate I am on the "Employment Summary" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
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

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
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

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
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

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
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

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Contact Us in the Header
    And I validate I am on the "Customer Service" page and close tab

    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
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

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on the Username in the "Exch" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
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

    And I validate I am on the "Employment Summary" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
#    And I set the browser resolution to 1200 x 800
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    Then I validate I am on the "Employment Summary" page
    And I verify the header for Primary Member on the Employment Summary page in "Spanish"


    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2327
  Scenario: SLER-2327 ELIG-As an Exchange User on Employment Summary page, I want the ability to see the page in English or Spanish so that I can review and update the income information]
    And I validate I am on the "Employment Summary" page
    Then I validate Employment Summary text in "English"
    And I validate I am on the "Employment Summary" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate Employment Summary text in "Spanish"
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2333
  Scenario: SLER-2333 As a Exch user on the Employment Summary page, I want to see the structure of the page so that I can review and update basic employment information
    And I validate I am on the "Employment Summary" page
    Then I validate Employment Summary text in "English"
    And I validate I am on the "Employment Summary" page
    Then I validate Employment Summary bold text in Employment Summary Page
    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
      | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook          | facebook.com                          |
      | xIcon          | X                 | x.com                                 |
      | YouTubeIcon    | YouTube           | youtube.com                           |
      | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
      | InstagramIcon  | instagram         | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.com                           |
    And I click on Sign Out in the Header for "Elmo"


  @SLER-2372
  Scenario: SLER-2372 [Automate navigation on the ELMO Employment Summary Income Page in EXCH]
    And I validate I am on the "Employment Summary" page
    Then I click on Back button on the Employment Summary Page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    Then I click on the Back button on the Additionalincomepage
    And I validate I am on the "Employment Summary" page
    Then I click Edit on Income Summary row 1
    And I validate I am on the "Employment Income" page
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page
    Then I click on Add job or self-employment on the Employment Summary Page
    And I validate I am on the "Employment Income" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "4500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page

    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
      | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook          | facebook.com                          |
      | xIcon          | X                 | x.com                                 |
      | YouTubeIcon    | YouTube           | youtube.com                           |
      | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
      | InstagramIcon  | instagram         | instagram.com                         |
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
    And I validate I am on the "Employment Summary" page

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
    And I validate I am on the "Employment Summary" page

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
    And I validate I am on the "Employment Summary" page

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
    And I validate I am on the "Employment Summary" page

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
    And I validate I am on the "Employment Summary" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I click on Sign Out in the Header for "Elmo"






    
    
    
    
    
    
    
    
    
    
    
    
    