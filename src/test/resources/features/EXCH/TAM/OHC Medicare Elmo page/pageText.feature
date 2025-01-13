@TAM @TamExch
Feature: Page Text-OHI Medicare Elmo Page

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
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "Medicare" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Medicare" page

  @SLER-271 @PageTextOhiMedicareElmo
  Scenario: SLER-271 I can see Medicare's Header and footer - English
    Then I validate I am on the "Elmo Ohi Medicare" page
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
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page

    Then I validate I am on the "Elmo Ohi Medicare" page
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
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page

    Then I validate I am on the "Elmo Ohi Medicare" page
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
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page

    Then I validate I am on the "Elmo Ohi Medicare" page
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
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page

    Then I validate I am on the "Elmo Ohi Medicare" page
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "Elmo Ohi Medicare" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Contact Us in the Header
    And I validate I am on the "Customer Service" page and close tab

    Then I validate I am on the "Elmo Ohi Medicare" page
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
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page

    Then I validate I am on the "Elmo Ohi Medicare" page
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
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page

    And I validate I am on the "Elmo Ohi Medicare" page
#    And I set the browser resolution to 1200 x 800
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page


    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-272 @PageTextOhiMedicareElmo
  Scenario: SLER-272 I can see Medicare's Header and footer - Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
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
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
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
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
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
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
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
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Contact Us in the Header
    And I validate I am on the "Customer Service" page and close tab

    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
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
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
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
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
#    And I set the browser resolution to 1200 x 800
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    Then I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "Spanish"


    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page


  @SLER-295 @PageVerificationMedicarePage @TAMSmoke
  Scenario: SLER-295 I Validate the saved options persist on the Medicare page
#Step3
    And I verify the header for "Primary" Member on the Medicare page in "English"
    And I verify initial questions on the Medicare page in "English"
    And I verify Part A "is not" and Part B "is not" checked on the Medicare page
#Step4
    And I click on Apply for Coverage in the "Elmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    Then I update Full Name to new Name
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Medicare" page
    And I verify the header for "Primary" Member on the Medicare page in "English"
    And I verify Part A "is not" and Part B "is not" checked on the Medicare page
#Step5
    Then I click "No" for currently eligible in Medicare question
    Then I click continue on the Elmo OHC Medicare page
#Step6
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Medicare" page
    And I verify Currently eligible is "No" on the Medicare page
    And I verify Part A "is not" and Part B "is not" checked on the Medicare page
#Step7
    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    Then I enter Part A amount of "500.00"
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    Then I enter end date of "Current Month" for Medicare part "A"
    Then I click continue on the Elmo OHC Medicare page
#Step8
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Medicare" page
    And I verify Currently eligible is "Yes" on the Medicare page
    And I verify Part A "is" and Part B "is not" checked on the Medicare page
    Then I verify Part A amount of "500.00"
    And I verify Part "A" Insurance Ending in 60 days is "Yes" on the Medicare page
    And I verify Part "A" end date is the last day of the month on the Medicare page
#Step9
    Then I check checkbox for Part "A"
    Then I check checkbox for Part "B"
    Then I click "Yes" for Part "B" insurance ending in 60 days in Medicare question
    Then I enter end date of "Current Month" for Medicare part "B"
    Then I click continue on the Elmo OHC Medicare page
#Step10
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Medicare" page
    And I verify Currently eligible is "Yes" on the Medicare page
    And I verify Part A "is not" and Part B "is" checked on the Medicare page
    And I verify Part "B" Insurance Ending in 60 days is "Yes" on the Medicare page
    And I verify Part "B" end date is the last day of the month on the Medicare page
#Step11
    Then I check checkbox for Part "A"
    Then I check checkbox for Part "A Don't Pay"
    And I click "No" for Part "A" insurance ending in 60 days in Medicare question
    And I click "No" for Part "B" insurance ending in 60 days in Medicare question
    Then I click continue on the Elmo OHC Medicare page
#Step12
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohi Medicare" page
    And I verify Currently eligible is "Yes" on the Medicare page
    And I verify Part A "is" and Part B "is" checked on the Medicare page
    And I verify Part "B" Insurance Ending in 60 days is "No" on the Medicare page
    And I verify Part "B" Insurance Ending in 60 days is "No" on the Medicare page

    And I click on Sign Out in the Header for "Elmo"
    
