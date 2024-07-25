Feature: Seed02 w/exception - Exchange

  Background: Seed 02 w/exception For Exchange- Single Applicant with FA
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "03051989" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "P.O. BOX 1454" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "4000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "None of these" as health insurance option and continue
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I set data from application history page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I click continue on start shopping page
    And I validate I am on the "Medical Plan Results" page
    And I select "Elevate Health Plans Colorado Option Bronze" medical plan
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    And I select "Delta Dental of Colorado Family Basic Plan" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I continue on plan summary page
    And I select the terms and agreements checkbox
    And I enter householder signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

 #   Then I click all done from payment portal page

    Then I select make payment button to pay the premium
    And I click continue on payment selection page
    And I select second make payment button to pay the premium
    And I click continue on payment selection page
    And I click continue on initial payment page
    And I click on Go To Welcome Page Button on whats next page
    Then I validate I am on the "Account Overview" page
    And I Validate the correct enrolled plans are displayed on account overview page
    Then I click on ClickHere link for "My Plans"
    Then I validate I am on the "My Policies" page
    And I validate medical plan details from my policies page
      |PolicyStartDate| PolicyEndDate| FinancialStartDate |FinancialEndDate|
      | 01/01/2024    | 12/31/2024   | 01/01/2024         | 12/31/2024     |
    And I validate dental plan details from my policies page
      |PolicyStartDate| PolicyEndDate| FinancialStartDate |FinancialEndDate|
      | 01/01/2024    | 12/31/2024   | 01/01/2024         | 12/31/2024     |
    And I click View Plan History link from medical plan card
    And I validate medical plan details from plan history
    And I click on to Back to Current Plan Details button
    And I click View Plan History link from dental plan card
    And I validate dental plan details from plan history
    And I click on Sign Out in the Header for "Elmo"
    And I validate the member details from policy tables
    And I validate member details from ob834_details table
      | maintenance_type_code | hd_maint_type_code  | maintenance_reas_code| addl_maint_reason  | sep_reason|
      | 021                   | 021                 | EC                   |                    | ADMIN_LCE |
      | 021                   | 021                 | EC                   |                    | ADMIN_LCE |
    And I download the files from sftp server with location "/outboundedi/"
    And I validate the ob834 files should not be empty
    And I validate the ob834 files should have the values
      | maintenance_type_code | hd_maint_type_code  | maintenance_reas_code| addl_maint_reason  | sep_reason|
      | 021                   | 021                 | EC                   |                    | ADMIN_LCE |
      | 021                   | 021                 | EC                   |                    | ADMIN_LCE |
    And I validate the REF and LX segments in EDI file
      | LX | N1 75              | REF       |
      | 1  | PRE AMT 1          | 291.02    |
      | 2  | APTC AMT           | 0.00      |
      | 3  | CSR AMT            | 0.00      |
      | 4  | RATING AREA        | 3         |
      | 5  | SOURCE EXCHANGE ID | COHBE     |
      | 6  | TOT RES AMT        | 291.02    |
      | 7  | PRE AMT TOT        | 291.02    |
      | 8  | SEP REASON         | ADMIN_LCE |
    And I verify the policy data quality check
  #  And I verify the data from book of business queue table
