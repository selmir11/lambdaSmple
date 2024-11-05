@TAM @TamPdf @applicationSummaryESI
Feature: Tests related to the Application Summary/Detail for ESI

  Background: I go the login portal
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
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    Then I select "Yes" to Are You Applying
    Then I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    Then I select "Yes" for CO Resident option
    Then I select "No" for Federally Recognized Tribe option
    Then I select "No" for Hardship Exemption option
    Then I select "No" for Disability option
    Then I select "No" to the recently denied medicaid question
    Then I select "No" for Incarceration option
    Then I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    Then I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page

  @SLER-970
  Scenario: SLER-970 I want changes to my job's ESI information and see changes made to ESI information in the OBO Application Details
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "5160000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
#    Step 2
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "500.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "Yes" button on the ESI page
    Then I click continue on the ESI page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
#    Step 3
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click on Add job or self-employment on the Employment Summary Page
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "5160000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select the "1" employer for "Primary" member on the ESI page
    Then I select "No" for meet the Minimum Value Standard on the ESI page
    Then I enter "300.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Today" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    Then I click continue on the ESI page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Sign Out in the Header for "NonElmo"
#    Step 4
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I search for user and click email from search results
#    Step 5
    Then I verify Primary account holder and account number displays
    Then I verify the option in years displays
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
    Then I validate I am on the "Account Overview" page
    And I click on Find a Plan in the "NonElmo" Header
#    Step 6
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    Then I click on View Application Details
    Then I validate I am on the "Application Details" page
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Yellow" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "Employer Sponsored Insurance" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Job" highlight "Yellow" on Application Details with data of ""
    And I verify the OHC detail "Minimum Value Standard" highlight "Yellow" on Application Details with data of " No"
    And I verify the OHC detail "Lowest-Cost Monthly Individual Premium Amount" highlight "Yellow" on Application Details with data of " 300.0"
    And I verify the OHC detail "Currently enrolled" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Insurance ending in next 60 days" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "End date" highlight "Yellow" on Application Details with data of "Today"
    And I verify the OHC detail "Voluntarily ending insurance" highlight "Yellow" on Application Details with data of " No"
    Then I click on Download as PDF on Application Details
    Then I validate PDF OHC data "Other Health Coverage" in "English" with Min Value "No" Premium "300.0" Currently enrolled "Yes" "Insurance ending" "Yes" end date of "Today" "Voluntarily ending" "No"
#    Step 7
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select "No" for meet the Minimum Value Standard on the ESI page
    Then I enter "300.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I click continue on the ESI page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 8
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    Then I click on View Application Details
    Then I validate I am on the "Application Details" page
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Yellow" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "Employer Sponsored Insurance" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Job" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Minimum Value Standard" highlight "Plain" on Application Details with data of " No"
    And I verify the OHC detail "Lowest-Cost Monthly Individual Premium Amount" highlight "Plain" on Application Details with data of " 300.0"
    And I verify the OHC detail "Currently enrolled" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Insurance ending in next 60 days" highlight "Yellow" on Application Details with data of " No"
    And I verify the OHC detail "End date" highlight "Red" on Application Details with data of "None"
    And I verify the OHC detail "Voluntarily ending insurance" highlight "Red" on Application Details with data of ""
    Then I click on Download as PDF on Application Details
    Then I validate PDF OHC data "Other Health Coverage" in "English" with Min Value "No" Premium "300.0" Currently enrolled "Yes" "Insurance ending" "No" end date of "Today" "" ""
#    Step 9
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select the Are you currently enrolled "No" button on the ESI page
    Then I click continue on the ESI page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 10
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    Then I click on View Application Details
    Then I validate I am on the "Application Details" page
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Yellow" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "Employer Sponsored Insurance" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Job" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Minimum Value Standard" highlight "Plain" on Application Details with data of " No"
    And I verify the OHC detail "Lowest-Cost Monthly Individual Premium Amount" highlight "Plain" on Application Details with data of " 300.0"
    And I verify the OHC detail "Currently enrolled" highlight "Yellow" on Application Details with data of " No"
    And I verify the OHC detail "Insurance ending in next 60 days" highlight "Red" on Application Details with data of ""
    Then I click on Download as PDF on Application Details
    Then I validate PDF OHC data "Other Health Coverage" in "English" with Min Value "No" Premium "300.0" Currently enrolled "No" "" "" end date of "" "" ""

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal

  @SLER-973
  Scenario: SLER-973 I want changes to my job's ESI family information and see changes made to ESI information in the OBO Application Details
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "04161981", "Female" and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Kid", "08062022", "Female" and applying "Yes"
      | Primary:Daughter |
      | Spouse:Daughter  |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Kid"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Son", "08062024", "Male" and applying "Yes"
      | Primary:Son |
      | Spouse:Son  |
      | Kid:Brother |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Son"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
#    Step 2
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "15000000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "Yes" to claim dependents
    And I select the "2" option for Who Will Claim as Dependents
    And I select the "3" option for Who Will Claim as Dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
#    Step 3
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "500.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "Yes" button on the ESI page
    Then I click "Yes" for offer family plans question
    Then I enter "400.00" for offer family amount question
    Then I click enrollment status for the members
      |      Spouse:Enrolled    |
      |      Kid:TypeAccess     |
      |      Son:NoAccess       |
    Then I click continue on the ESI page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Forth" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
#    Step 4
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I enter "200.00" for offer family amount question
    Then I click enrollment status for the members
      |      Spouse:TypeAccess    |
      |      Kid:NoAccess         |
      |      Son:Enrolled         |
    Then I click continue on the ESI page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Forth" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 5
    And I click on Sign Out in the Header for "NonElmo"
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I search for user and click email from search results
#    Step 6
    Then I verify Primary account holder and account number displays
    Then I verify the option in years displays
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
    Then I validate I am on the "Account Overview" page
    And I click on Find a Plan in the "NonElmo" Header
#    Step 7
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    Then I click on View Application Details
    Then I validate I am on the "Application Details" page
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Yellow" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "Employer Sponsored Insurance" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Job" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Minimum Value Standard" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Individual Premium Amount" highlight "Plain" on Application Details with data of " 500.0"
    And I verify the OHC detail "Currently enrolled" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Insurance ending in next 60 days" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "End date" highlight "Plain" on Application Details with data of "Current Month"
    And I verify the OHC detail "Voluntarily ending insurance" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Family plan offered" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Family Premium Amount" highlight "Yellow" on Application Details with data of " 200.00"
    Then I verify the OHC detail family enrollment details on Application Details
      | Member3FullName:Enrolled:Yellow                        |
      | Member1FullName:Offered a plan but not enrolled:Yellow |
      | Member2FullName:No option to enroll:Yellow             |
    Then I click on Download as PDF on Application Details
    Then I validate PDF OHC data "Other Health Coverage" in "English" with Min Value "Yes" Premium "500.0" Currently enrolled "Yes" "Insurance ending" "Yes" end date of "Current Month" "Voluntarily ending" "Yes"
    Then I verify PDF OHC data for family with Family offered "Yes" and Premium "200.00"
      | Member3FullName:Enrolled                        |
      | Member1FullName:Offered a plan but not enrolled |
      | Member2FullName:No option to enroll             |
#    Step 8
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I click "No" for offer family plans question
    Then I click continue on the ESI page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Forth" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 9
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    Then I click on View Application Details
    Then I validate I am on the "Application Details" page
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Yellow" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "Employer Sponsored Insurance" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Job" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Minimum Value Standard" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Individual Premium Amount" highlight "Plain" on Application Details with data of " 500.0"
    And I verify the OHC detail "Currently enrolled" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Insurance ending in next 60 days" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "End date" highlight "Plain" on Application Details with data of "Current Month"
    And I verify the OHC detail "Voluntarily ending insurance" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Family plan offered" highlight "Yellow" on Application Details with data of " No"
    And I verify the OHC detail "Lowest-Cost Monthly Family Premium Amount" highlight "Red" on Application Details with data of ""
    Then I verify the OHC detail family enrollment details on Application Details
      | :Enrolled:Red                        |
      | :Offered a plan but not enrolled:Red |
      | :No option to enroll:Red             |
    Then I click on Download as PDF on Application Details
    Then I validate PDF OHC data "Other Health Coverage" in "English" with Min Value "Yes" Premium "500.0" Currently enrolled "Yes" "Insurance ending" "Yes" end date of "Current Month" "Voluntarily ending" "Yes"
    Then I verify PDF OHC data for family with Family offered "No" and Premium ""
      |  |
#   Step 10
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I click "Yes" for offer family plans question
    Then I enter "300.00" for offer family amount question
    Then I click enrollment status for the members
      |      Spouse:Enrolled    |
      |      Kid:TypeAccess     |
      |      Son:NoAccess       |
    Then I click continue on the ESI page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Forth" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 11
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    Then I click on View Application Details
    Then I validate I am on the "Application Details" page
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Yellow" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "Employer Sponsored Insurance" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Job" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Minimum Value Standard" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Individual Premium Amount" highlight "Plain" on Application Details with data of " 500.0"
    And I verify the OHC detail "Currently enrolled" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Insurance ending in next 60 days" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "End date" highlight "Plain" on Application Details with data of "Current Month"
    And I verify the OHC detail "Voluntarily ending insurance" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Family plan offered" highlight "Yellow" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Family Premium Amount" highlight "Green" on Application Details with data of " 300.00"
    Then I verify the OHC detail family enrollment details on Application Details
      | Member1FullName:Enrolled:Green                        |
      | Member2FullName:Offered a plan but not enrolled:Green |
      | Member3FullName:No option to enroll:Green             |
    Then I click on Download as PDF on Application Details
    Then I validate PDF OHC data "Other Health Coverage" in "English" with Min Value "Yes" Premium "500.0" Currently enrolled "Yes" "Insurance ending" "Yes" end date of "Current Month" "Voluntarily ending" "Yes"
    Then I verify PDF OHC data for family with Family offered "Yes" and Premium "300.00"
      | Member1FullName:Enrolled                        |
      | Member2FullName:Offered a plan but not enrolled |
      | Member3FullName:No option to enroll             |
#    Step 12
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I click "Yes" for offer family plans question
    Then I enter "300.00" for offer family amount question
    Then I click enrollment status for the members
      |      Spouse:Enrolled    |
      |      Kid:Enrolled       |
      |      Son:Enrolled       |
    Then I click continue on the ESI page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Forth" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 13
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    Then I click on View Application Details
    Then I validate I am on the "Application Details" page
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Yellow" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "Employer Sponsored Insurance" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Job" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Minimum Value Standard" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Individual Premium Amount" highlight "Plain" on Application Details with data of " 500.0"
    And I verify the OHC detail "Currently enrolled" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Insurance ending in next 60 days" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "End date" highlight "Plain" on Application Details with data of "Current Month"
    And I verify the OHC detail "Voluntarily ending insurance" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Family plan offered" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Family Premium Amount" highlight "Plain" on Application Details with data of " 300.00"
    Then I verify the OHC detail family enrollment details on Application Details
      | Member1FullName:Enrolled:Yellow      |
      | Member2FullName:Enrolled:Yellow      |
      | Member3FullName:Enrolled:Yellow      |
      | :Offered a plan but not enrolled:Red |
      | :No option to enroll:Red             |
    Then I click on Download as PDF on Application Details
    Then I validate PDF OHC data "Other Health Coverage" in "English" with Min Value "Yes" Premium "500.0" Currently enrolled "Yes" "Insurance ending" "Yes" end date of "Current Month" "Voluntarily ending" "Yes"
    Then I verify PDF OHC data for family with Family offered "Yes" and Premium "300.00"
      | Member1FullName:Enrolled |
      | Member2FullName:Enrolled |
      | Member3FullName:Enrolled |

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal


  @SLER-1014
  Scenario: SLER-1014 I want to verify OHC header on Application Summary and Application Details
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "5160000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "500.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "Yes" button on the ESI page
    Then I click continue on the ESI page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
#    Steps 1 & 2
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "English"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF "Other Health Coverage" Header in "English"
    And I change the language from header to "Spanish NonElmo"
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF "Other Health Coverage" Header in "Spanish"
#    Steps 3 & 4
    And I change the language from header to "English NonElmo"
    And I click on Sign Out in the Header for "NonElmo"
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I search for user and click email from search results
    Then I verify Primary account holder and account number displays
    Then I verify the option in years displays
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
    Then I validate I am on the "Account Overview" page
    And I click on Find a Plan in the "NonElmo" Header
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    Then I click on View Application Details
    Then I validate I am on the "Application Details" page
    And I verify the OHC header highlight "Plain" on Application Details
    Then I click on Download as PDF on Application Details
    Then I validate PDF OHC data "Other Health Coverage" in "English" with Min Value "Yes" Premium "500.0" Currently enrolled "Yes" "Yes" "Current Month" end date of "" "" ""
    And I change the language from header to "Spanish NonElmo"
    Then I click on Download as PDF on Application Details
    Then I validate PDF OHC data "Other Health Coverage" in "Spanish" with Min Value "Yes" Premium "500.0" Currently enrolled "Yes" "Yes" "Current Month" end date of "" "" ""

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal

  @SLER-1017
  Scenario: SLER-1017 I want to show and hide changes for ESI information in the OBO Application Details Single Members
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "5160000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "300.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Today" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    Then I click continue on the ESI page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Sign Out in the Header for "NonElmo"
#    Step 2
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I search for user and click email from search results
    Then I verify Primary account holder and account number displays
    Then I verify the option in years displays
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
    Then I validate I am on the "Account Overview" page
#    Step 3
    And I click on Find a Plan in the "NonElmo" Header
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    Then I click on View Application Details
    Then I validate I am on the "Application Details" page
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Yellow" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "Employer Sponsored Insurance" highlight "Green" on Application Details with data of ""
    And I verify the OHC detail "Job" highlight "Green" on Application Details with data of ""
    And I verify the OHC detail "Minimum Value Standard" highlight "Green" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Individual Premium Amount" highlight "Green" on Application Details with data of " 300.0"
    And I verify the OHC detail "Currently enrolled" highlight "Green" on Application Details with data of " Yes"
    And I verify the OHC detail "Insurance ending in next 60 days" highlight "Green" on Application Details with data of " Yes"
    And I verify the OHC detail "End date" highlight "Green" on Application Details with data of "Today"
    And I verify the OHC detail "Voluntarily ending insurance" highlight "Green" on Application Details with data of " No"
#    Step 4
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Plain" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "Employer Sponsored Insurance" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Job" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Minimum Value Standard" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Individual Premium Amount" highlight "Plain" on Application Details with data of " 300.0"
    And I verify the OHC detail "Currently enrolled" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Insurance ending in next 60 days" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "End date" highlight "Plain" on Application Details with data of "Today"
    And I verify the OHC detail "Voluntarily ending insurance" highlight "Plain" on Application Details with data of " No"
#    Step 5
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 7
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    Then I click on View Application Details
    Then I validate I am on the "Application Details" page
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Yellow" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "None" highlight "Green" on Application Details with data of ""
    And I verify the OHC detail "1 Removed" highlight "Red" on Application Details with data of ""
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Plain" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "None" highlight "Plain" on Application Details with data of ""

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal

  @SLER-1018
  Scenario: SLER-1018 I want to show and hide changes for ESI information in the OBO Application Details Multi Members
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "04161981", "Female" and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "15000000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "500.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "Yes" button on the ESI page
    Then I click "Yes" for offer family plans question
    Then I enter "400.00" for offer family amount question
    Then I click enrollment status for the members
      |      Spouse:Enrolled    |
    Then I click continue on the ESI page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Spouse"
    Then I click on Remove this Member
    Then I click on "OK" in the Remove Member frame
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I click continue on the ESI page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Sign Out in the Header for "NonElmo"
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I search for user and click email from search results
    Then I verify Primary account holder and account number displays
    Then I verify the option in years displays
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
    Then I validate I am on the "Account Overview" page
    And I click on Find a Plan in the "NonElmo" Header
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    Then I click on View Application Details
    Then I validate I am on the "Application Details" page
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Yellow" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "Employer Sponsored Insurance" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Job" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Minimum Value Standard" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Individual Premium Amount" highlight "Plain" on Application Details with data of " 500.0"
    And I verify the OHC detail "Currently enrolled" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Insurance ending in next 60 days" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "End date" highlight "Plain" on Application Details with data of "Current Month"
    And I verify the OHC detail "Voluntarily ending insurance" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Family plan offered" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Family Premium Amount" highlight "Plain" on Application Details with data of " 400.00"
    Then I verify the OHC detail family enrollment details on Application Details
      | :Enrolled:Red      |
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Plain" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "Employer Sponsored Insurance" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Job" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Minimum Value Standard" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Individual Premium Amount" highlight "Plain" on Application Details with data of " 500.0"
    And I verify the OHC detail "Currently enrolled" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Insurance ending in next 60 days" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "End date" highlight "Plain" on Application Details with data of "Current Month"
    And I verify the OHC detail "Voluntarily ending insurance" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Family plan offered" highlight "Plain" on Application Details with data of " Yes"
    And I verify the OHC detail "Lowest-Cost Monthly Family Premium Amount" highlight "Plain" on Application Details with data of " 400.00"

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal

  @SLER-1023
  Scenario: SLER-1023 I want changes to my job's ESI information and see changes made to ESI information in the Application Summary
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "5160000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
#    Step 2
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "500.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "Yes" button on the ESI page
    Then I click continue on the ESI page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
#    Step 3
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click on Add job or self-employment on the Employment Summary Page
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "5160000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select the "1" employer for "Primary" member on the ESI page
    Then I select "No" for meet the Minimum Value Standard on the ESI page
    Then I enter "300.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Today" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    Then I click continue on the ESI page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 4
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "English"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " Yes" in "English"
    And I verify the OHC detail on Application Summary "End date" with data of "Today" in "English"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF OHC on Application Summary with data "Other Health Coverage" in "English" for "Employer Sponsored Insurance" with Currently enrolled "Yes" end date of "Today"
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " Sí" in "Spanish"
    And I verify the OHC detail on Application Summary "End date" with data of "Today" in "Spanish"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF OHC on Application Summary with data "Other Health Coverage" in "Spanish" for "Employer Sponsored Insurance" with Currently enrolled "Sí" end date of "Today"
    And I change the language from header to "English NonElmo"
#    Step 5
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select "No" for meet the Minimum Value Standard on the ESI page
    Then I enter "300.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I click continue on the ESI page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 6
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "English"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " Yes" in "English"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF OHC on Application Summary with data "Other Health Coverage" in "English" for "Employer Sponsored Insurance" with Currently enrolled "Yes" end date of ""
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " Sí" in "Spanish"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF OHC on Application Summary with data "Other Health Coverage" in "Spanish" for "Employer Sponsored Insurance" with Currently enrolled "Sí" end date of ""
    And I change the language from header to "English NonElmo"
#    Step 7
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select the Are you currently enrolled "No" button on the ESI page
    Then I click continue on the ESI page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 8
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "English"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " No" in "English"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF OHC on Application Summary with data "Other Health Coverage" in "English" for "Employer Sponsored Insurance" with Currently enrolled "No" end date of ""
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " No" in "Spanish"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF OHC on Application Summary with data "Other Health Coverage" in "Spanish" for "Employer Sponsored Insurance" with Currently enrolled "No" end date of ""

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-1029
  Scenario: SLER-1029 I want changes to my job's ESI family information and see changes made to ESI information in the Application Summary
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "04161981", "Female" and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Kid", "08062022", "Female" and applying "Yes"
      | Primary:Daughter |
      | Spouse:Daughter  |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Kid"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Son", "08062024", "Male" and applying "Yes"
      | Primary:Son |
      | Spouse:Son  |
      | Kid:Brother |
    And I click continue on Tell us about additional members page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Son"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
#    Step 2
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "15000000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "Yes" to claim dependents
    And I select the "2" option for Who Will Claim as Dependents
    And I select the "3" option for Who Will Claim as Dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
#    Step 3
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "500.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "Yes" button on the ESI page
    Then I click "Yes" for offer family plans question
    Then I enter "400.00" for offer family amount question
    Then I click enrollment status for the members
      |      Spouse:Enrolled    |
      |      Kid:TypeAccess     |
      |      Son:NoAccess       |
    Then I click continue on the ESI page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Forth" Member on the Other Health Coverage page in "English"
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
#    Step 4
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select the Are you currently enrolled "No" button on the ESI page
    Then I click continue on the ESI page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Forth" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 5
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "English"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " No" in "English"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF Family OHC on Application Summary with data "Other Health Coverage" in "English" for "Employer Sponsored Insurance" with Currently enrolled "No" end date of ""
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " No" in "Spanish"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF Family OHC on Application Summary with data "Other Health Coverage" in "Spanish" for "Employer Sponsored Insurance" with Currently enrolled "No" end date of ""
    And I change the language from header to "English NonElmo"
#    Step 6
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select "No" for meet the Minimum Value Standard on the ESI page
    Then I enter "300.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "No" button on the ESI page
    Then I enter "200.00" for offer family amount question
    Then I click enrollment status for the members
      |      Spouse:TypeAccess    |
      |      Kid:NoAccess         |
      |      Son:Enrolled         |
    Then I click continue on the ESI page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Forth" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 7
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "English"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " Yes" in "English"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF Family OHC on Application Summary with data "Other Health Coverage" in "English" for "Employer Sponsored Insurance" with Currently enrolled "Yes" end date of ""
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " Sí" in "Spanish"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF Family OHC on Application Summary with data "Other Health Coverage" in "Spanish" for "Employer Sponsored Insurance" with Currently enrolled "Sí" end date of ""
    And I change the language from header to "English NonElmo"
#   Step 8
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Today" on the ESI page
    Then I select the Are you voluntarily ending "No" button on the ESI page
    Then I enter "300.00" for offer family amount question
    Then I click enrollment status for the members
      |      Spouse:Enrolled    |
      |      Kid:TypeAccess     |
      |      Son:NoAccess       |
    Then I click continue on the ESI page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Forth" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 9
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "English"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " Yes" in "English"
    And I verify the OHC detail on Application Summary "End date" with data of "Today" in "English"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF Family OHC on Application Summary with data "Other Health Coverage" in "English" for "Employer Sponsored Insurance" with Currently enrolled "Yes" end date of "Today"
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " Sí" in "Spanish"
    And I verify the OHC detail on Application Summary "End date" with data of "Today" in "Spanish"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF Family OHC on Application Summary with data "Other Health Coverage" in "Spanish" for "Employer Sponsored Insurance" with Currently enrolled "Sí" end date of "Today"
    And I change the language from header to "English NonElmo"
#    Step 10
    And I click on Apply for Coverage in the "NonElmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I click continue on Tell us about yourself page
    Then I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    Then I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I click save and continue on tax status page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "ESI" page
    Then I select the Are you currently enrolled "No" button on the ESI page
    Then I click continue on the ESI page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Third" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Other Health Coverage" page
    And I verify the header for "Forth" Member on the Other Health Coverage page in "English"
    Then I click continue on the ELMO health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 11
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "English"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "English"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " No" in "English"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF Family OHC on Application Summary with data "Other Health Coverage" in "English" for "Employer Sponsored Insurance" with Currently enrolled "No" end date of ""
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary "Name" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Employer Sponsored Insurance" with data of "" in "Spanish"
    And I verify the OHC detail on Application Summary "Currently enrolled" with data of " No" in "Spanish"
    Then I click on Download as PDF on Application Summary
    Then I validate PDF Family OHC on Application Summary with data "Other Health Coverage" in "Spanish" for "Employer Sponsored Insurance" with Currently enrolled "Sí" end date of ""
    And I change the language from header to "English NonElmo"

    And I click on Sign Out in the Header for "NonElmo"

