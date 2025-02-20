@TAM @TamPdf @applicationSummaryMedicare
Feature: Tests related to the Application Summary/Detail for Medicare

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

  @SLER-1982
  Scenario: SLER-1982 I want changes to my Medicare information and see changes made to Medicare information in the OBO Application Details
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status Elmo page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status Elmo page
    Then I select "Medicare" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Ohc Medicare" page
#    Step 2
    Then I click "No" for currently eligible in Medicare question
    Then I click continue on the Elmo OHC Medicare page
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
    Then I click Save and Continue on Tax Status Elmo page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Ohc Medicare" page
    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    Then I enter Part A amount of "75.00"
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    Then I enter end date of "Today" for Medicare part "A"
    Then I check checkbox for Part "B"
    Then I click "Yes" for Part "B" insurance ending in 60 days in Medicare question
    Then I enter end date of "Today" for Medicare part "B"
    Then I click continue on the Elmo OHC Medicare page
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
    And I verify the Medicare OHC details on Application Details
      |   OHC Type  |Type Highlight|Currently Eligible|Currently Eligible Highlight|Enrolled|Enrolled Highlight|A Premium|A Premium Highlight|A Ending|A Ending Highlight| A End Date  |A End Date Highlight|B Ending|B Ending Highlight| B End Date  |B End Date Highlight|
      |   Medicare  |     Plain    |        Yes       |           Yellow           |   Yes  |      Green       |   75    |       Green       |   Yes  |      Green       |    Today    |       Green        |  Yes   |       Green      |    Today    |       Green        |
    Then I click on Download as PDF on Application Details
    And I wait for 3000 milliseconds
    Then I validate Medicare PDF OHC data on Application Details in "English"
      |   OHC Type  |Premium Free|Enrolled|Part A Premium|Part A Ending|Part A End Date|Part B Ending|Part B End Date|
      |   Medicare  |    Yes     |  Yes   |     75       |     Yes     |     Today     |     Yes     |     Today     |
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
    Then I click Save and Continue on Tax Status Elmo page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Ohc Medicare" page
    Then I enter Part A amount of "150.00"
    Then I enter end date of "Current Month" for Medicare part "A"
    Then I enter end date of "Current Month" for Medicare part "B"
    Then I click continue on the Elmo OHC Medicare page
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
    And I verify the Medicare OHC details on Application Details
      |   OHC Type  |Type Highlight|Currently Eligible|Currently Eligible Highlight|Enrolled|Enrolled Highlight|A Premium|A Premium Highlight|A Ending|A Ending Highlight| A End Date  |A End Date Highlight|B Ending|B Ending Highlight| B End Date  |B End Date Highlight|
      |   Medicare  |     Plain    |       Yes        |           Plain            |   Yes  |      Plain       |  150    |       Yellow      |   Yes  |      Plain       |Current Month|       Yellow       |  Yes   |       Plain      |Current Month|       Yellow       |
    Then I click on Download as PDF on Application Details
    And I wait for 3000 milliseconds
    Then I validate Medicare PDF OHC data on Application Details in "English"
      |   OHC Type  |Premium Free|Enrolled|Part A Premium|Part A Ending|Part A End Date|Part B Ending|Part B End Date|
      |   Medicare  |    Yes     |  Yes   |    150       |     Yes     | Current Month |     Yes     | Current Month |
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
    Then I click Save and Continue on Tax Status Elmo page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Ohc Medicare" page
    Then I check checkbox for Part "A Don't Pay"
    Then I click "No" for Part "A" insurance ending in 60 days in Medicare question
    Then I click "No" for Part "B" insurance ending in 60 days in Medicare question
    Then I click continue on the Elmo OHC Medicare page
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
    And I verify the Medicare OHC details on Application Details
      |   OHC Type  |Type Highlight|Currently Eligible|Currently Eligible Highlight|Enrolled|Enrolled Highlight|A Premium|A Premium Highlight|A Ending|A Ending Highlight| A End Date  |A End Date Highlight|B Ending|B Ending Highlight| B End Date  |B End Date Highlight|
      |   Medicare  |     Plain    |       Yes        |           Plain            |   Yes  |      Plain       |  None   |        Red        |   No   |      Yellow      |    None     |        Red         |  No    |      Yellow      |    None     |         Red        |
    Then I click on Download as PDF on Application Details
    And I wait for 3000 milliseconds
    Then I validate Medicare PDF OHC data on Application Details in "English"
      |   OHC Type  |Premium Free|Enrolled|Part A Premium|Part A Ending|Part A End Date|Part B Ending|Part B End Date|
      |   Medicare  |    Yes     |  Yes   |              |     No      |               |     No      |               |
#    Step 11
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
    Then I click Save and Continue on Tax Status Elmo page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Ohc Medicare" page
    Then I check checkbox for Part "A"
    Then I check checkbox for Part "B"
    Then I click continue on the Elmo OHC Medicare page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
#    Step 12
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
    Then I validate I am on the "Application Summary Completed" page
    Then I click on View Application Details
    Then I validate I am on the "Application Details" page
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Yellow" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the Medicare OHC details on Application Details
      |   OHC Type  |Type Highlight|Currently Eligible|Currently Eligible Highlight|Enrolled|Enrolled Highlight|A Premium|A Premium Highlight|A Ending|A Ending Highlight| A End Date  |A End Date Highlight|B Ending|B Ending Highlight| B End Date  |B End Date Highlight|
      |   Medicare  |     Plain    |       Yes        |           Plain            |   No   |      Yellow      |         |                   |  None  |       Red        |             |                    |  None  |        Red       |             |                    |
    Then I click on Download as PDF on Application Details
    And I wait for 3000 milliseconds
    Then I validate Medicare PDF OHC data on Application Details in "English"
      |   OHC Type  |Premium Free|Enrolled|Part A Premium|Part A Ending|Part A End Date|Part B Ending|Part B End Date|
      |   Medicare  |    Yes     |   No   |              |             |               |             |               |

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal


  @SLER-1983
  Scenario: SLER-1983 I want to verify OHC header on Application Summary and Application Details
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status Elmo page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status Elmo page
    Then I select "Medicare" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Ohc Medicare" page
    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    Then I enter Part A amount of "150.00"
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    Then I enter end date of "Current Month" for Medicare part "A"
    Then I check checkbox for Part "B"
    Then I click "Yes" for Part "B" insurance ending in 60 days in Medicare question
    Then I enter end date of "Current Month" for Medicare part "B"
    Then I click continue on the Elmo OHC Medicare page
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
    And I wait for 3000 milliseconds
    Then I validate PDF "Other Health Coverage" Header in "English"
    And I change the language from header to "Spanish NonElmo"
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Download as PDF on Application Summary
    And I wait for 3000 milliseconds
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
    And I verify the OHC header highlight "Plain header" on Application Details
    Then I click on Download as PDF on Application Details
    And I wait for 3000 milliseconds
    Then I validate Medicare PDF OHC data on Application Details in "English"
      |   OHC Type  |Premium Free|Enrolled|Part A Premium|Part A Ending|Part A End Date|Part B Ending|Part B End Date|
      |   Medicare  |    Yes     |  Yes   |    150       |     Yes     | Current Month |     Yes     | Current Month |
    And I change the language from header to "Spanish NonElmo"
    Then I click on Download as PDF on Application Details
    And I wait for 3000 milliseconds
    Then I validate Medicare PDF OHC data on Application Details in "Spanish"
      |   OHC Type  |Premium Free|Enrolled|Part A Premium|Part A Ending|Part A End Date|Part B Ending|Part B End Date|
      |   Medicare  |    Yes     |  Yes   |    150       |     Yes     | Current Month |     Yes     | Current Month |

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal

  @SLER-1984
  Scenario: SLER-1984 I want to show and hide changes for Medicare information in the OBO Application Details Single Members
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
    Then I select "Medicare" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Ohc Medicare" page
    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    Then I enter Part A amount of "300.00"
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    Then I enter end date of "Current Month" for Medicare part "A"
    Then I check checkbox for Part "B"
    Then I click "Yes" for Part "B" insurance ending in 60 days in Medicare question
    Then I enter end date of "Current Month" for Medicare part "B"
    Then I click continue on the Elmo OHC Medicare page
    And I click plus icon next to member on household page for "Primary"
    And I click View Details under member on household page for "Primary"
    And I verify Existing health insurance is "Medicare" on the Application Summary page in "English"
    And I change the language from header to "Spanish NonElmo"
    And I verify Existing health insurance is "MEDICARE" on the Application Summary page in "Spanish"
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
    And I verify the Medicare OHC details on Application Details
      |   OHC Type  |Type Highlight|Currently Eligible|Currently Eligible Highlight|Enrolled|Enrolled Highlight|A Premium|A Premium Highlight|A Ending|A Ending Highlight| A End Date  |A End Date Highlight|B Ending|B Ending Highlight| B End Date  |B End Date Highlight|
      |   Medicare  |     Green    |        Yes       |           Green            |   Yes  |      Green       |  300    |       Green       |   Yes  |      Green       |Current Month|       Green        |  Yes   |       Green      |Current Month|       Green        |
#    Step 4
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Plain header" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the Medicare OHC details on Application Details
      |   OHC Type  |Type Highlight|Currently Eligible|Currently Eligible Highlight|Enrolled|Enrolled Highlight|A Premium|A Premium Highlight|A Ending|A Ending Highlight| A End Date  |A End Date Highlight|B Ending|B Ending Highlight| B End Date  |B End Date Highlight|
      |   Medicare  |     Plain    |        Yes       |           Plain            |   Yes  |      Plain       |  300    |       Plain       |   Yes  |      Plain       |Current Month|       Plain        |  Yes   |       Plain      |Current Month|       Plain        |
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
    And I verify None OHC detail on Application Details
      |None Highlight|Removed|Removed Highlight|
      |     Green    |       |                 |
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Plain header" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify None OHC detail on Application Details
      |None Highlight|Removed|Removed Highlight|
      |     Plain    |       |                 |

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal

  @SLER-1985
  Scenario: SLER-1985 I want changes to my Medicare information and see changes made to Medicare information in the Application Summary
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
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status Elmo page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status Elmo page
    Then I select "Medicare" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Ohc Medicare" page
#    Step 2
    Then I click "No" for currently eligible in Medicare question
    Then I click continue on the Elmo OHC Medicare page
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
    Then I click Save and Continue on Tax Status Elmo page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Ohc Medicare" page
    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    Then I enter Part A amount of "75.00"
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    Then I enter end date of "Today" for Medicare part "A"
    Then I check checkbox for Part "B"
    Then I click "Yes" for Part "B" insurance ending in 60 days in Medicare question
    Then I enter end date of "Today" for Medicare part "B"
    Then I click continue on the Elmo OHC Medicare page
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
    And I verify the Medicare OHC detail on Application Summary in "English"
      |   OHC Type  |Part A End Date|Part B End Date|
      |   Medicare  |     Today     |     Today     |
    Then I click on Download as PDF on Application Summary
    And I wait for 3000 milliseconds
    Then I validate PDF Medicare OHC data on Application Summary in "English"
      |   OHC Type  |Part A End Date|Part B End Date|
      |   Medicare  |     Today     |     Today     |
    And I change the language from header to "Spanish NonElmo"
    Then I wait for 50 milliseconds
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the Medicare OHC detail on Application Summary in "Spanish"
      |   OHC Type  |Part A End Date|Part B End Date|
      |   Medicare  |     Today     |     Today     |
    Then I click on Download as PDF on Application Summary
    And I wait for 3000 milliseconds
    Then I validate PDF Medicare OHC data on Application Summary in "Spanish"
      |   OHC Type  |Part A End Date|Part B End Date|
      |   Medicare  |     Today     |     Today     |
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
    Then I click Save and Continue on Tax Status Elmo page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Ohc Medicare" page
    Then I click "No" for currently eligible in Medicare question
    Then I enter end date of "Current Month" for Medicare part "A"
    Then I enter end date of "Current Month" for Medicare part "B"
    Then I click continue on the Elmo OHC Medicare page
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
    And I verify the Medicare OHC detail on Application Summary in "English"
      |   OHC Type  | Part A End Date  |  Part B End Date |
      |   Medicare  |Last Current Month|Last Current Month|
    Then I click on Download as PDF on Application Summary
    And I wait for 3000 milliseconds
    Then I validate PDF Medicare OHC data on Application Summary in "English"
      |   OHC Type  | Part A End Date  |  Part B End Date |
      |   Medicare  |Last Current Month|Last Current Month|
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the Medicare OHC detail on Application Summary in "Spanish"
      |   OHC Type  | Part A End Date  |  Part B End Date |
      |   Medicare  |Last Current Month|Last Current Month|
    Then I click on Download as PDF on Application Summary
    And I wait for 3000 milliseconds
    Then I validate PDF Medicare OHC data on Application Summary in "Spanish"
      |   OHC Type  | Part A End Date  |  Part B End Date |
      |   Medicare  |Last Current Month|Last Current Month|
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
    Then I click Save and Continue on Tax Status Elmo page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo Ohc Medicare" page
    Then I check checkbox for Part "A"
    Then I check checkbox for Part "B"
    Then I click continue on the Elmo OHC Medicare page
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
    And I verify the Medicare OHC detail on Application Summary in "English"
      |   OHC Type  |Part A End Date|Part B End Date|
      |   Medicare  |               |               |
    Then I click on Download as PDF on Application Summary
    And I wait for 3000 milliseconds
    Then I validate PDF Medicare OHC data on Application Summary in "English"
      |   OHC Type  |Part A End Date|Part B End Date|
      |   Medicare  |               |               |
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the Medicare OHC detail on Application Summary in "Spanish"
      |   OHC Type  |Part A End Date|Part B End Date|
      |   Medicare  |               |               |
    Then I click on Download as PDF on Application Summary
    And I wait for 3000 milliseconds
    Then I validate PDF Medicare OHC data on Application Summary in "Spanish"
      |   OHC Type  |Part A End Date|Part B End Date|
      |   Medicare  |               |               |

    And I click on Sign Out in the Header for "NonElmo"
