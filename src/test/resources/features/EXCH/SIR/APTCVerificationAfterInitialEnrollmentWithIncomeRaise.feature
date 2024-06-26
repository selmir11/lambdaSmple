@APTC,@APTC-SIR
Feature: UI Tests related to APTC after second enrollment change

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    When I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    When I apply for the current year
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    When I click on Before you begin continue with application button
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    #This will be updated in the tests
    And I am a member with City "Denver" in State "CO" with dob "01011981" in county "TELLER" with zipcode "80863"
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
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "1000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue

    Then I validate I am on the "Income Summary" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I select "None of these" as health insurance option and continue
    Then I validate I am on the "Family Overview" page

  @SLER-131
  Scenario: ELIG-APTC Eligible over 400% FPL-APTCRules - formerly RT-2349 - 40 year old
    When I click edit basic information icon for member 0
    Then I validate I am on the "Tell us about yourself - Edit" page
    #update dob
    When I update DOB to new DOB of "01011981"
    When I save and continue from tell us about yourself editing
    Then I validate I am on the "Additional information for yourself" page
    When I select "New" for Residential Address
    And I enter the new residential address details address line 1 "1234 Road", city "Denver", state "CO", zip "80863", county "Teller", member dob "01011981"
    And I save and continue from tell us about yourself editing
    Then I validate I am on the "Citizenship" page
    When I click continue on the Citizenship page
    Then I validate I am on the "Family overview" page
    When I click continue on family overview page
    And I select "MovedToColorado" QLCE on tell us about life changes page
    And I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    When I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    Then I wait for hold on content to disappear
    And I validate I am on the "Good News" page
    When I click on No Thanks on good news page
    Then I validate I am on the "Application History" page
    When I click on view results and shop
    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    When I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    When I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    And I validate there is no APTC credit "0.00" on the first plan
    When I select the first medical plan
    And I click continue on medical plan results page
    Then I validate I am on the "Dental Plan Results" page
    When I select first dental plan
    And I click continue on dental plan results page
    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "$0.00"
    When I click continue on plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    When I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page
    Then I validate I am on the "Initial Payment" page

    When I select make payment button to pay the premium
    Then I validate I am on the "Payment Selection" page

    When I select the Money Order button
    And I click continue on payment selection page
    Then I validate I am on the "Initial Payment" page

    When I click continue on initial payment page
    Then I validate I am on the "Congratulations - What's Next?" page

    When I click on Go To Welcome Page Button on whats next page
    Then I validate I am on the "Account Overview" page

    When I click on make changes button
    Then I validate I am on the "Let us guide you" page

    When I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page

    When I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page

    When I report "LostCoverage" and click continue
    Then I validate I am on the "Find Expert Help" page

    When I click Continue on my own button from Manage who helps you page
    And I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page

    When I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Citizenship" page

    When I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page

    When I click on the table dropdown
    And I click on the Member Row 1
    Then I validate I am on the "Application Summary" page

    When I select the Edit Income link
    Then I validate I am on the "Employment Info" page

    When I click Edit on Income Summary row 1
    Then I validate I am on the "Employment Info" page

    When I edit the income level to ""
    And I edit the income level to "5160000"
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page

    When I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page

    When I click continue on the Additional Income page
    Then I validate I am on the "Deductions" page

    When I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page

    When I click the save and continue button on the Income Summary Detail page
    Then I validate I am on the "Tax status" page

    When I click save and continue on tax status page
    Then I validate I am on the "Other Health Insurance" page

    When I click continue on the Other Health Insurance page
    Then I validate I am on the "Family Overview" page

    When I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page

    When  I select "LostCoverage" QLCE on tell us about life changes page
    And I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page

    When I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page

    When I click on view results and shop
    Then I validate I am on the "Application Results" page
    And I validate that my Tax Household's APTC value is "$139.14/mo"

    When I click continue on application results page
    Then I validate I am on the "Start Shopping" page

    When I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    And I validate the APTC credit on the first plan is "$139.14 tax credit"

    When I select the first medical plan
    And I click continue on medical plan results page
    Then I validate I am on the "Dental Plan Results" page

    When I select first dental plan
    And I click continue on dental plan results page
    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "-$139.14"

    When I click continue on plan summary page
    Then I validate I am on the "Financial Help Agreements" page

    When I click on Sign Out in the Header for "Payment"

  @SLER-322
  Scenario: ELIG-APTC Eligible over 400% FPL-APTCRules - formerly RT-2350 - 40 year old
    When I click edit basic information icon for member 0
    Then I validate I am on the "Tell us about yourself - Edit" page
    #update dob
    When I update DOB to new DOB of "01011971"
    When I save and continue from tell us about yourself editing
    Then I validate I am on the "Additional information for yourself" page
    When I select "New" for Residential Address
    And I enter the new residential address details address line 1 "1234 Road", city "Denver", state "CO", zip "80220", county "Denver", member dob "01011971"
    And I save and continue from tell us about yourself editing
    Then I validate I am on the "Citizenship" page
    When I click continue on the Citizenship page
    Then I validate I am on the "Family overview" page
    When I click continue on family overview page
    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    And I click on No Thanks on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate there is no APTC credit "0.00" on the first plan
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I validate I am on the "Initial Payment" page
    Then I select make payment button to pay the premium

    Then I validate I am on the "Payment Selection" page
    And I select the Money Order button
    And I click continue on payment selection page

    Then I validate I am on the "Initial Payment" page
    And I click continue on initial payment page

    Then I validate I am on the "Congratulations - What's Next?" page
    And I click on Go To Welcome Page Button on whats next page

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue


    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
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

    Then I validate I am on the "Family Overview" page
    And I click on the table dropdown
    Then I click on the Member Row 1

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Summary" page
    Then I click Edit on Income Summary row 1

    Then I validate I am on the "Employment Info" page
    And I edit the income level to ""
    And I edit the income level to "5742000"
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I validate I am on the "Tax status" page
    Then I click save and continue on tax status page

    Then I validate I am on the "Other Health Insurance" page
    Then I click continue on the Other Health Insurance page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's APTC value is "$265.98/mo"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the APTC credit on the first plan is "$265.98 tax credit"
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "-$265.98"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I validate I am on the "Initial Payment" page
    Then I select make payment button to pay the premium
    And I click on Sign Out in the Header for "Payment"

  @SLER-319
  Scenario: ELIG-APTC Eligible over 400% FPL-APTCRules - formerly RT-2351 - 60 year old
    When I click on Before you begin continue with application button
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Example" in State "CO" with dob "01011961" in county "Lake" with zipcode "80461"
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
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "1000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue

    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue

    Then I validate I am on the "Income Summary" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    Then I select "None of these" as health insurance option and continue
    Then I click continue on family overview page

    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    And I click on No Thanks on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate there is no APTC credit "0.00" on the first plan
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I validate I am on the "Initial Payment" page
    Then I select make payment button to pay the premium

    Then I validate I am on the "Payment Selection" page
    And I select the Money Order button
    And I click continue on payment selection page

    Then I validate I am on the "Initial Payment" page
    And I click continue on initial payment page

    Then I validate I am on the "Congratulations - What's Next?" page
    And I click on Go To Welcome Page Button on whats next page

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue


    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
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

    Then I validate I am on the "Family Overview" page
    And I click on the table dropdown
    Then I click on the Member Row 1

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Summary" page
    Then I click Edit on Income Summary row 1

    Then I validate I am on the "Employment Info" page
    And I edit the income level to ""
    And I edit the income level to "5796000"
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I validate I am on the "Tax status" page
    Then I click save and continue on tax status page

    Then I validate I am on the "Other Health Insurance" page
    Then I click continue on the Other Health Insurance page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's APTC value is "$837.85/mo"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the APTC credit on the first plan is "$837.85tax credit"
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "-$837.85"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Payment"

  @SLER-320
  Scenario: ELIG-APTC Eligible over 400% FPL-APTCRules - formerly RT-2352 - 62 year old
    When I click edit basic information icon for member 0
    Then I validate I am on the "Tell us about yourself - Edit" page
    #update dob
    When I update DOB to new DOB of "01011959"
    When I save and continue from tell us about yourself editing
    Then I validate I am on the "Additional information for yourself" page
    When I select "New" for Residential Address
    And I enter the new residential address details address line 1 "1234 Road", city "Example", state "CO", zip "81650", county "Garfield", member dob "01011959"
    And I save and continue from tell us about yourself editing
    Then I validate I am on the "Citizenship" page
    When I click continue on the Citizenship page
    Then I validate I am on the "Family overview" page
    When I click continue on family overview page

    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    And I click on No Thanks on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate there is no APTC credit "0.00" on the first plan
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I validate I am on the "Initial Payment" page
    Then I select make payment button to pay the premium

    Then I validate I am on the "Payment Selection" page
    And I select the Money Order button
    And I click continue on payment selection page

    Then I validate I am on the "Initial Payment" page
    And I click continue on initial payment page

    Then I validate I am on the "Congratulations - What's Next?" page
    And I click on Go To Welcome Page Button on whats next page

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
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

    Then I validate I am on the "Family Overview" page
    And I click on the table dropdown
    Then I click on the Member Row 1

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Summary" page
    Then I click Edit on Income Summary row 1

    Then I validate I am on the "Employment Info" page
    And I edit the income level to ""
    And I edit the income level to "6118000"
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I validate I am on the "Tax status" page
    Then I click save and continue on tax status page

    Then I validate I am on the "Other Health Insurance" page
    Then I click continue on the Other Health Insurance page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's APTC value is "$944.39/mo"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the APTC credit on the first plan is "$944.39tax credit"
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "-$944.39"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Payment"

  @SLER-321
  Scenario: ELIG-APTC Eligible over 400% FPL-APTCRules - formerly RT-2353 - 50 year old
    When I click edit basic information icon for member 0
    Then I validate I am on the "Tell us about yourself - Edit" page
    #update dob
    When I update DOB to new DOB of "01011972"
    When I save and continue from tell us about yourself editing
    Then I validate I am on the "Additional information for yourself" page
    When I select "New" for Residential Address
    And I enter the new residential address details address line 1 "1234 Road", city "Example", state "CO", zip "80487", county "Routt", member dob "01011972"
    And I save and continue from tell us about yourself editing
    Then I validate I am on the "Citizenship" page
    When I click continue on the Citizenship page
    Then I validate I am on the "Family overview" page
    When I click continue on family overview page

    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    And I click on No Thanks on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate there is no APTC credit "0.00" on the first plan
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I validate I am on the "Initial Payment" page
    Then I select make payment button to pay the premium

    Then I validate I am on the "Payment Selection" page
    And I select the Money Order button
    And I click continue on payment selection page

    Then I validate I am on the "Initial Payment" page
    And I click continue on initial payment page

    Then I validate I am on the "Congratulations - What's Next?" page
    And I click on Go To Welcome Page Button on whats next page

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
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

    Then I validate I am on the "Family Overview" page
    And I click on the table dropdown
    Then I click on the Member Row 1

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Summary" page
    Then I click Edit on Income Summary row 1

    Then I validate I am on the "Employment Info" page
    And I edit the income level to ""
    And I edit the income level to "4330000"
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I validate I am on the "Tax status" page
    Then I click save and continue on tax status page

    Then I validate I am on the "Other Health Insurance" page
    Then I click continue on the Other Health Insurance page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's APTC value is "$646.42/mo"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the APTC credit on the first plan is "$646.42tax credit"
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "-$642.40"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Payment"

  @SLER-323
  Scenario: ELIG-APTC Eligible over 400% FPL-APTCRules - formerly RT-2354 - 40 year old //born in 1976
    When I click edit basic information icon for member 0
    Then I validate I am on the "Tell us about yourself - Edit" page
    #update dob
    When I update DOB to new DOB of "01011976"
    When I save and continue from tell us about yourself editing
    Then I validate I am on the "Additional information for yourself" page
    When I select "New" for Residential Address
    And I enter the new residential address details address line 1 "1234 Road", city "Example", state "CO", zip "80470", county "Park", member dob "01011976"
    And I save and continue from tell us about yourself editing
    Then I validate I am on the "Citizenship" page
    When I click continue on the Citizenship page
    Then I validate I am on the "Family overview" page
    When I click continue on family overview page

    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    And I click on No Thanks on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate there is no APTC credit "0.00" on the first plan
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I validate I am on the "Initial Payment" page
    Then I select make payment button to pay the premium

    Then I validate I am on the "Payment Selection" page
    And I select the Money Order button
    And I click continue on payment selection page

    Then I validate I am on the "Initial Payment" page
    And I click continue on initial payment page

    Then I validate I am on the "Congratulations - What's Next?" page
    And I click on Go To Welcome Page Button on whats next page

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue

    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
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

    Then I validate I am on the "Family Overview" page
    And I click on the table dropdown
    Then I click on the Member Row 1

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Summary" page
    Then I click Edit on Income Summary row 1

    Then I validate I am on the "Employment Info" page
    And I edit the income level to ""
    And I edit the income level to "3875000"
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I validate I am on the "Tax status" page
    Then I click save and continue on tax status page

    Then I validate I am on the "Other Health Insurance" page
    Then I click continue on the Other Health Insurance page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's APTC value is "$384.17/mo"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the APTC credit on the first plan is "$379.36tax credit"
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "-$379.36"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Payment"

  @SLER-375
  Scenario: ELIG-APTC Eligible over 400% FPL-APTCRules - formerly RT-2355 - 40 year old
    When I click edit basic information icon for member 0
    Then I validate I am on the "Tell us about yourself - Edit" page
    #update dob
    When I update DOB to new DOB of "01011962"
    When I save and continue from tell us about yourself editing
    Then I validate I am on the "Additional information for yourself" page
    When I select "New" for Residential Address
    And I enter the new residential address details address line 1 "1234 Road", city "Example", state "CO", zip "81504", county "Mesa", member dob "01011962"
    And I save and continue from tell us about yourself editing
    Then I validate I am on the "Citizenship" page
    When I click continue on the Citizenship page
    Then I validate I am on the "Family overview" page
    When I click continue on family overview page

    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    And I click on No Thanks on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate there is no APTC credit "0.00" on the first plan
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I validate I am on the "Initial Payment" page
    Then I select make payment button to pay the premium

    Then I validate I am on the "Payment Selection" page
    And I select the Money Order button
    And I click continue on payment selection page

    Then I validate I am on the "Initial Payment" page
    And I click continue on initial payment page

    Then I validate I am on the "Congratulations - What's Next?" page
    And I click on Go To Welcome Page Button on whats next page

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue


    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
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

    Then I validate I am on the "Family Overview" page
    And I click on the table dropdown
    Then I click on the Member Row 1

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Summary" page
    Then I click Edit on Income Summary row 1

    Then I validate I am on the "Employment Info" page
    And I edit the income level to ""
    And I edit the income level to "5000000"
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I validate I am on the "Tax status" page
    Then I click save and continue on tax status page

    Then I validate I am on the "Other Health Insurance" page
    Then I click continue on the Other Health Insurance page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's APTC value is "$727.71/mo"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the APTC credit on the first plan is "$717.10tax credit"
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "-$717.10"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Payment"

  @SLER-324
  Scenario: ELIG-APTC Eligible over 400% FPL-APTCRules - formerly RT-2356 - 65 year old
    When I click edit basic information icon for member 0
    Then I validate I am on the "Tell us about yourself - Edit" page
    #update dob
    When I update DOB to new DOB of "01011958"
    When I save and continue from tell us about yourself editing
    Then I validate I am on the "Additional information for yourself" page
    When I select "New" for Residential Address
    And I enter the new residential address details address line 1 "1234 Road", city "Example", state "CO", zip "81144", county "Rio Grande", member dob "01011958"
    And I save and continue from tell us about yourself editing
    Then I validate I am on the "Citizenship" page
    When I click continue on the Citizenship page
    Then I validate I am on the "Family overview" page
    When I click continue on family overview page

    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    And I click on No Thanks on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate there is no APTC credit "0.00" on the first plan
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I validate I am on the "Initial Payment" page
    Then I select make payment button to pay the premium

    Then I validate I am on the "Payment Selection" page
    And I select the Money Order button
    And I click continue on payment selection page

    Then I validate I am on the "Initial Payment" page
    And I click continue on initial payment page

    Then I validate I am on the "Congratulations - What's Next?" page
    And I click on Go To Welcome Page Button on whats next page

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue


    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
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

    Then I validate I am on the "Family Overview" page
    And I click on the table dropdown
    Then I click on the Member Row 1

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Summary" page
    Then I click Edit on Income Summary row 1

    Then I validate I am on the "Employment Info" page
    And I edit the income level to ""
    And I edit the income level to "5152000"
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I validate I am on the "Tax status" page
    Then I click save and continue on tax status page

    Then I validate I am on the "Other Health Insurance" page
    Then I click continue on the Other Health Insurance page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's APTC value is "$1134.70/mo"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the APTC credit on the first plan is "$1,028.25tax credit"
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "-$1,028.25"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Payment"

  @SLER-325
  Scenario: ELIG-APTC Eligible over 400% FPL-APTCRules - formerly RT-2397 - born 1982 and 2011
    When I click edit basic information icon for member 0
    Then I validate I am on the "Tell us about yourself - Edit" page
    #update dob
    When I update DOB to new DOB of "01011958"
    When I save and continue from tell us about yourself editing
    Then I validate I am on the "Additional information for yourself" page
    When I select "New" for Residential Address
    And I enter the new residential address details address line 1 "1234 Road", city "Example", state "CO", zip "81144", county "Rio Grande", member dob "01011958"
    And I save and continue from tell us about yourself editing
    Then I validate I am on the "Citizenship" page
    When I click continue on the Citizenship page
    Then I validate I am on the "Family overview" page
    When I click continue on family overview page

    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    And I click on No Thanks on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate there is no APTC credit "0.00" on the first plan
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I validate I am on the "Initial Payment" page
    Then I select make payment button to pay the premium

    Then I validate I am on the "Payment Selection" page
    And I select the Money Order button
    And I click continue on payment selection page

    Then I validate I am on the "Initial Payment" page
    And I click continue on initial payment page

    Then I validate I am on the "Congratulations - What's Next?" page
    And I click on Go To Welcome Page Button on whats next page

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue


    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
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

    Then I validate I am on the "Family Overview" page
    And I click on the table dropdown
    Then I click on the Member Row 1

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Summary" page
    Then I click Edit on Income Summary row 1

    Then I validate I am on the "Employment Info" page
    And I edit the income level to ""
    And I edit the income level to "5152000"
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I validate I am on the "Tax status" page
    Then I click save and continue on tax status page

    Then I validate I am on the "Other Health Insurance" page
    Then I click continue on the Other Health Insurance page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's APTC value is "$1134.70/mo"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the APTC credit on the first plan is "$1,028.25tax credit"
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "-$1,028.25"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Payment"

  @SLER-691
  Scenario: ELIG-APTC Eligible-APTCRules - formerly RT-2340 - income change from 10K to 100K
    When I click edit basic information icon for member 0
    Then I validate I am on the "Tell us about yourself - Edit" page
    #update dob
    When I update DOB to new DOB of "01011981"
    When I save and continue from tell us about yourself editing
    Then I validate I am on the "Additional information for yourself" page
    When I select "New" for Residential Address
    And I enter the new residential address details address line 1 "1234 Road", city "Denver", state "CO", zip "80863", county "TELLER", member dob "01011981"
    And I save and continue from tell us about yourself editing
    Then I validate I am on the "Citizenship" page
    When I click continue on the Citizenship page
    Then I validate I am on the "Family overview" page
    When I click continue on family overview page

    Then I select "Marriage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Good News" page
    And I click on No Thanks on good news page

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    And I verify that the APTC amount does not appear on the app results page
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate there is no APTC credit "0.00" on the first plan
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I validate I am on the "Initial Payment" page
    Then I select make payment button to pay the premium

    Then I validate I am on the "Payment Selection" page
    And I select the Money Order button
    And I click continue on payment selection page

    Then I validate I am on the "Initial Payment" page
    And I click continue on initial payment page

    Then I validate I am on the "Congratulations - What's Next?" page
    And I click on Go To Welcome Page Button on whats next page

    Then I validate I am on the "Account Overview" page
    Then I click on make changes button

    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button

    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page

    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue


    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page

    Then I validate I am on the "Add Address" page
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

    Then I validate I am on the "Family Overview" page
    And I click on the table dropdown
    Then I click on the Member Row 1

    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link

    Then I validate I am on the "Employment Info" page
    Then I click Edit on Income Summary row 1

    Then I validate I am on the "Employment Info" page
    And I edit the income level to ""
    And I edit the income level to "10000000"
    And I click continue on the Employment Info Page

    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page

    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page

    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page

    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page

    Then I validate I am on the "Tax status" page
    Then I click save and continue on tax status page

    Then I validate I am on the "Other Health Insurance" page
    Then I click continue on the Other Health Insurance page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I validate I am on the "Tell us about life changes" page
    And  I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop

    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's APTC value is "$0.00/mo"
    Then I click continue on application results page

    Then I validate I am on the "Start Shopping" page
    And I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate there is no APTC credit "0.00" on the first plan
    And I select the first medical plan
    And I click continue on medical plan results page

    Then I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page

    Then I validate I am on the "Plan Summary" page
    And I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page

    Then I validate I am on the "Financial Help Agreements" page
    And I click on Sign Out in the Header for "Payment"
