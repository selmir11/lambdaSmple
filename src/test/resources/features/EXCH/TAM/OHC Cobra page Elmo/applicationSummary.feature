@TAM @TamPdf @applicationSummaryCobra
Feature: Tests related to the Application Summary/Detail for Cobra

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

  @SLER-1947
  Scenario: SLER-1947 I want to verify OHC header on Application Summary and Application Details
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
    Then I select "COBRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click "Yes" for currently enrolled in COBRA question
    Then I click "Yes" for insurance ending in 60 days in COBRA question
    Then I enter the end date as "Current Month" on the Cobra page
    Then I click "Yes" for insurance ending voluntary for COBRA question
    Then I click continue on the Elmo OHC Cobra page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click View Application Summary link
#    Steps 1 & 2
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "English"
    Then I click on Download as PDF on Application Summary
    And I wait for 500 milliseconds
    Then I validate PDF "Other Health Coverage" Header in "English"
    And I change the language from header to "Spanish NonElmo"
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Download as PDF on Application Summary
    Then I wait for 2500 milliseconds
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
    Then I wait for 2000 milliseconds
    Then I validate basic PDF OHC data on Application Details in "English"
      |Coverage Type|Currently Enrolled|Insurance Ending|   End date  |Voluntarily ending insurance|
      |    COBRA    |       Yes        |      Yes       |Current Month|         Yes                |
    And I change the language from header to "Spanish NonElmo"
    Then I click on Download as PDF on Application Details
    Then I wait for 2000 milliseconds
    Then I validate basic PDF OHC data on Application Details in "Spanish"
      |Coverage Type|Currently Enrolled|Insurance Ending|   End date  |Voluntarily ending insurance|
      |    COBRA    |       Yes        |      Yes       |Current Month|         Yes                |

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal

  @SLER-1948
  Scenario: SLER-1948 I want changes to Cobra information and see changes made to Cobra information in the Application Summary
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
    Then I select "COBRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo COBRA" page
#    Step 2
    Then I click "Yes" for currently enrolled in COBRA question
    Then I click "Yes" for insurance ending in 60 days in COBRA question
    Then I enter the end date as "Current Month" on the Cobra page
    Then I click "Yes" for insurance ending voluntary for COBRA question
    Then I click continue on the Elmo OHC Cobra page
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
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status Elmo page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo COBRA" page
    Then I click "No" for insurance ending in 60 days in COBRA question
    Then I click continue on the Elmo OHC Cobra page
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
    And I verify the OHC detail on Application Summary in "English"
      |   OHC Type  |Currently Enrolled|   End date  |
      |    COBRA    |       Yes        |             |
    Then I click on Download as PDF on Application Summary
    Then I wait for 2000 milliseconds
    Then I validate PDF OHC data on Application Summary in "English"
      |Coverage Type|Currently Enrolled|Insurance Ending|   End date  |Voluntarily ending insurance|
      |    COBRA    |       Yes        |                |             |                            |
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary in "Spanish"
      |   OHC Type  |Currently Enrolled|   End date  |
      |    COBRA    |        Sí        |             |
    Then I click on Download as PDF on Application Summary
    Then I wait for 2000 milliseconds
    Then I validate PDF OHC data on Application Summary in "Spanish"
      |Coverage Type|Currently Enrolled|Insurance Ending|   End date  |Voluntarily ending insurance|
      |    COBRA    |       Sí         |                |             |                            |
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
    Then I validate I am on the "Elmo COBRA" page
    Then I click "Yes" for insurance ending in 60 days in COBRA question
    Then I enter the end date as "Current Month" on the Cobra page
    Then I click "Yes" for insurance ending voluntary for COBRA question
    Then I click continue on the Elmo OHC Cobra page
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
    And I verify the OHC detail on Application Summary in "English"
      |   OHC Type  |Currently Enrolled|     End date     |
      |    COBRA    |       Yes        |Last Current Month|
    Then I click on Download as PDF on Application Summary
    Then I wait for 2000 milliseconds
    Then I validate PDF OHC data on Application Summary in "English"
      |Coverage Type|Currently Enrolled|Insurance Ending|     End date     |Voluntarily ending insurance|
      |    COBRA    |       Yes        |      Yes       |Last Current Month|           Yes              |
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary in "Spanish"
      |   OHC Type  |Currently Enrolled|     End date     |
      |    COBRA    |        Sí        |Last Current Month|
    Then I click on Download as PDF on Application Summary
    Then I wait for 2000 milliseconds
    Then I validate PDF OHC data on Application Summary in "Spanish"
      |Coverage Type|Currently Enrolled|Insurance Ending|     End date     |Voluntarily ending insurance|
      |    COBRA    |       Sí         |      Sí        |Last Current Month|           Sí               |
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
    Then I validate I am on the "Elmo COBRA" page
    Then I click "No" for currently enrolled in COBRA question
    Then I click continue on the Elmo OHC Cobra page
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
    And I verify the OHC detail on Application Summary in "English"
      |   OHC Type  |Currently Enrolled|     End date     |
      |    COBRA    |        No        |                  |
    Then I click on Download as PDF on Application Summary
    Then I wait for 2000 milliseconds
    Then I validate PDF OHC data on Application Summary in "English"
      |Coverage Type|Currently Enrolled|Insurance Ending|   End date  |Voluntarily ending insurance|
      |    COBRA    |       No         |                |             |                            |
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Application Summary Completed" page
    And I verify the OHC header on Application Summary in "Spanish"
    Then I click on Other Health Coverage on Application Summary
    And I verify the OHC detail on Application Summary in "Spanish"
      |   OHC Type  |Currently Enrolled|     End date     |
      |    COBRA    |        No        |                  |
    Then I click on Download as PDF on Application Summary
    Then I wait for 2000 milliseconds
    Then I validate PDF OHC data on Application Summary in "Spanish"
      |Coverage Type|Currently Enrolled|Insurance Ending|   End date  |Voluntarily ending insurance|
      |    COBRA    |       No         |                |             |                            |

    And I click on Sign Out in the Header for "NonElmo"

  @SLER-1949
  Scenario: SLER-1949 I want changes to my Cobra information and see changes made to Cobra information in the OBO Application Details
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
    Then I select "COBRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo COBRA" page
#    Step 2
    Then I click "Yes" for currently enrolled in COBRA question
    Then I click "Yes" for insurance ending in 60 days in COBRA question
    Then I enter the end date as "Current Month" on the Cobra page
    Then I click "Yes" for insurance ending voluntary for COBRA question
    Then I click continue on the Elmo OHC Cobra page
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
    Then I validate I am on the "Family Overview" page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status Elmo page
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo COBRA" page
    Then I enter the end date as "Future Day:3" on the Cobra page
    Then I click "No" for insurance ending voluntary for COBRA question
    Then I click continue on the Elmo OHC Cobra page
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
    And I verify the basic OHC detail on Application Details
      |   OHC Type  |Type Highlight|Currently enrolled|Enrolled Highlight|Insurance ending|Ending Highlight|  End date  |Date Highlight|Voluntarily ending|Voluntarily Highlight|
      |    COBRA    |     Plain    |       Yes        |      Plain       |      Yes       |     Plain      |Future Day:3|    Yellow    |        No        |       Yellow        |
    Then I click on Download as PDF on Application Details
    Then I wait for 2000 milliseconds
    Then I validate basic PDF OHC data on Application Details in "English"
      |Coverage Type|Currently Enrolled|Insurance Ending|   End date  |Voluntarily ending insurance|
      |    COBRA    |       Yes        |      Yes       | Future Day:3|           Yes              |
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
    Then I validate I am on the "Elmo COBRA" page
    Then I click "No" for currently enrolled in COBRA question
    Then I click continue on the Elmo OHC Cobra page
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
    And I verify the basic OHC detail on Application Details
      |   OHC Type  |Type Highlight|Currently enrolled|Enrolled Highlight|Insurance ending|Ending Highlight|  End date   |Date Highlight|Voluntarily ending|Voluntarily Highlight|
      |    COBRA    |     Plain    |       No         |      Yellow      |                |      Red       |             |     Red      |                  |        Red          |
    Then I click on Download as PDF on Application Details
    Then I wait for 2000 milliseconds
    Then I validate basic PDF OHC data on Application Details in "English"
      |Coverage Type|Currently Enrolled|Insurance Ending|   End date  |Voluntarily ending insurance|
      |    COBRA    |        No        |                |             |                            |

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal

  @SLER-1950
  Scenario: SLER-1950 I want to show and hide changes for Cobra information in the OBO Application Details Single Members
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
    Then I select "COBRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I validate I am on the "Elmo COBRA" page
    Then I click "Yes" for currently enrolled in COBRA question
    Then I click "Yes" for insurance ending in 60 days in COBRA question
    Then I enter the end date as "Current Month" on the Cobra page
    Then I click "Yes" for insurance ending voluntary for COBRA question
    Then I click continue on the Elmo OHC Cobra page
    And I click plus icon next to member on household page for "Primary"
    And I click View Details under member on household page for "Primary"
    And I verify Existing health insurance is "COBRA" on the Application Summary page in "English"
    And I change the language from header to "Spanish NonElmo"
    And I verify Existing health insurance is "COBRA" on the Application Summary page in "Spanish"
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
    And I verify the basic OHC detail on Application Details
      |   OHC Type  |Type Highlight|Currently enrolled|Enrolled Highlight|Insurance ending|Ending Highlight|  End date   |Date Highlight|Voluntarily ending|Voluntarily Highlight|
      |    COBRA    |     Green    |       Yes        |      Green       |      Yes       |     Green      |Current Month|     Green    |       Yes        |       Green         |
#    Step 4
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Plain header" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify the basic OHC detail on Application Details
      |   OHC Type  |Type Highlight|Currently enrolled|Enrolled Highlight|Insurance ending|Ending Highlight|  End date   |Date Highlight|Voluntarily ending|Voluntarily Highlight|
      |    COBRA    |     Plain    |       Yes        |      Plain       |      Yes       |     Plain      |Current Month|     Plain    |       Yes        |       Plain         |
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
      |     Green    |   1   |      Red        |
    Then I click on Show Changes on Application Details
    And I verify the OHC header highlight "Plain header" on Application Details
    Then I click on "Other Health Coverage" on Application Details
    And I verify None OHC detail on Application Details
      |None Highlight|Removed|Removed Highlight|
      |     Plain    |       |                 |

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal