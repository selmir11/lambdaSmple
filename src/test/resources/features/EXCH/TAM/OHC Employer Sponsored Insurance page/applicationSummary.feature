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
    Then I select "Yes" for Citizen option
    Then I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
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

  @SLER-970
  Scenario: SLER-970 I want changes to my job's ESI information and see changes made to ESI information in the OBO Application Summary
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
    Then I click continue on the Citizenship page
    And I click on the table dropdown 1
    And I click the edit income 1
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
    And I verify the OHC header highlight on Application Details
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
    Then I validate PDF OHC data "Added Job" in "English" with Premium "300.0" Currently enrolled "Yes" "Insurance ending" "Yes" "Voluntarily ending" "No"
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
    Then I click continue on the Citizenship page
    And I click on the table dropdown 1
    And I click the edit income 1
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
    And I verify the OHC header highlight on Application Details
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
    Then I validate PDF OHC data "Added Job" in "English" with Premium "300.0" Currently enrolled "Yes" "Insurance ending" "No" "" ""
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
    Then I click continue on the Citizenship page
    And I click on the table dropdown 1
    And I click the edit income 1
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
    And I verify the OHC header highlight on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the OHC detail "Employer Sponsored Insurance" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Job" highlight "Plain" on Application Details with data of ""
    And I verify the OHC detail "Minimum Value Standard" highlight "Plain" on Application Details with data of " No"
    And I verify the OHC detail "Lowest-Cost Monthly Individual Premium Amount" highlight "Plain" on Application Details with data of " 300.0"
    And I verify the OHC detail "Currently enrolled" highlight "Yellow" on Application Details with data of " No"
    And I verify the OHC detail "Insurance ending in next 60 days" highlight "Red" on Application Details with data of ""
    Then I click on Download as PDF on Application Details
    Then I validate PDF OHC data "Added Job" in "English" with Premium "300.0" Currently enrolled "No" "" "No" "" ""

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal

