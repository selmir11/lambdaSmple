@TAM @TamPdf @applicationSummaryHra
Feature: Tests related to the Application Summary/Detail for HRA

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

  @SLER-2000
  Scenario: SLER-2000 I want to show and hide changes for HRA information in the OBO Application Details Single Members
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "3500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status Elmo page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status Elmo page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I click plus icon next to member on household page for "Primary"
    And I click View Details under member on household page for "Primary"
    And I verify Existing health insurance is "No" on the Application Summary page in "English"
    And I change the language from header to "Spanish NonElmo"
    And I verify Existing health insurance is "No" on the Application Summary page in "Spanish"
    And I change the language from header to "English NonElmo"
    Then I back button on the Application Summary page
    Then I validate I am on the "Family Overview" page
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
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status Elmo page
    Then I select "HRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo HRA" page
    Then I select Current Year year dropdown on the Elmo OHC HRA page
    Then I enter "175.00" amount on the Elmo OHC HRA page
    Then I select "QSEHRA" for HRA type
    Then I click continue on the Elmo OHC HRA page
    And I click plus icon next to member on household page for "Primary"
    And I click View Details under member on household page for "Primary"
    And I verify Existing health insurance is "Health Reimbursement Arrangement" on the Application Summary page in "English"
    And I change the language from header to "Spanish NonElmo"
    And I verify Existing health insurance is "Health Reimbursement Arrangement" on the Application Summary page in "Spanish"
    And I change the language from header to "English NonElmo"
    Then I back button on the Application Summary page
    Then I validate I am on the "Family Overview" page
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
#    And I verify the HRA OHC details on Application Details TAM-4078
#      |   OHC Type  |Type Highlight|Currently Eligible|Currently Eligible Highlight|Enrolled|Enrolled Highlight|A Premium|A Premium Highlight|A Ending|A Ending Highlight| A End Date  |A End Date Highlight|B Ending|B Ending Highlight| B End Date  |B End Date Highlight|
#      |   HRA  |     Green    |        Yes       |           Green            |   Yes  |      Green       |  300.0  |       Green       |   Yes  |      Green       |Current Month|       Green        |  Yes   |       Green      |Current Month|       Green        |
#    Step 4
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Plain header" on Application Details
    Then I click on "Other Health Coverage" on Application Details
#    And I verify the HRA OHC details on Application Details TAM-4078
#      |   OHC Type  |Type Highlight|Currently Eligible|Currently Eligible Highlight|Enrolled|Enrolled Highlight|A Premium|A Premium Highlight|A Ending|A Ending Highlight| A End Date  |A End Date Highlight|B Ending|B Ending Highlight| B End Date  |B End Date Highlight|
#      |   HRA  |     Plain    |        Yes       |           Plain            |   Yes  |      Plain       |  300.0  |       Plain       |   Yes  |      Plain       |Current Month|       Plain        |  Yes   |       Plain      |Current Month|       Plain        |
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
    Then I click Save and Continue on Tax Status Elmo page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I click plus icon next to member on household page for "Primary"
    And I click View Details under member on household page for "Primary"
    And I verify Existing health insurance is "No" on the Application Summary page in "English"
    And I change the language from header to "Spanish NonElmo"
    And I verify Existing health insurance is "No" on the Application Summary page in "Spanish"
    And I change the language from header to "English NonElmo"
    Then I back button on the Application Summary page
    Then I validate I am on the "Family Overview" page
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
#    And I verify None OHC detail on Application Details TAM-4078
#      |None Highlight|Removed|Removed Highlight|
#      |     Green    |       |                 |
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Plain header" on Application Details
    Then I click on "Other Health Coverage" on Application Details
#    And I verify None OHC detail on Application Details TAM-4078
#      |None Highlight|Removed|Removed Highlight|
#      |     Plain    |       |                 |

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal