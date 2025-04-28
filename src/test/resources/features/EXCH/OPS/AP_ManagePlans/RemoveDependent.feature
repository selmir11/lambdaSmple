@OPS @Exch @manageplans
Feature: OPS: Create individual account with 2 members and enroll in Medical/Dental

  Background:
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    Then I verify account created successfully message displays
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "12021990" in county "DENVER" with zipcode "80205"
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
    Then I validate I am on the "Family Overview" page
    And I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "12261991", "Female" and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    And I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    And I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    Then I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

  @SLER-2381
  Scenario: SLER-2381 OPS: MP: FA Removing Dependent from policy
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "55000.00" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Married filing jointly" tax filing option on the Tax Status page
    Then I select "Spouse" as filing jointly with option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    And I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page
    Then I validate I am on the "Medical Plan Results" page
    Then I select "KP Select CO Silver 4500/30 RX Copay" medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    And I validate I am on the "Dental Plan Results" page
    And I select "Anthem Dental Family" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    And I select the terms and agreements checkbox
    And I enter householder signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I close current tab and switch back to previous tab
#    Manage Plans Change Start Dates to 1/1
    Then I click on manage plan button on admin portal Individual dashboard
    Then I click Make Changes Medical button
    And I update the Coverage Start date of member
      | 1:First Day Of Current Year |
      | 2:First Day Of Current Year |
    And I update the Financial Start date of member
      | 1:First Day Of Current Year |
      | 2:First Day Of Current Year |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then I click Make Changes Dental button
    And I update the Coverage Start date of member
      | 1:First Day Of Current Year |
      | 2:First Day Of Current Year |
    And I update the Financial Start date of member
      | 1:First Day Of Current Year |
      | 2:First Day Of Current Year |
    And I click Save Button Dental
    And I select the reason to confirm the changes
    And I wait for 1000 milliseconds
    And I select Plans Med Active Policy
    And I select Plans Dental Active Policy
    Then I verify current plan data for "Medical" on Manage Plans page
      |no|coverageStart            |financialStart           |
      |1 |First Day Of Current Year|First Day Of Current Year|
      |2 |First Day Of Current Year|First Day Of Current Year|
    Then I verify current plan data for "Dental" on Manage Plans page
      |no|coverageStart            |financialStart           |
      |1 |First Day Of Current Year|First Day Of Current Year|
      |2 |First Day Of Current Year|First Day Of Current Year|
    And I close current tab and switch back to previous tab
#    OBO Remove member
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
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
#    not applying for spouse but not sure on LCE
    Then I click plus icon next to member on household page for "Spouse"
    Then I click edit basic information icon on household page for "Spouse"
    And I update member applying for coverage to "No"
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I click continue on the Immigration Status page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "Death" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    Then I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    Then I wait for 4500 milliseconds
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    Then I wait for 4500 milliseconds
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    And I select the terms and agreements checkbox
    And I enter householder signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I close current tab and switch back to previous tab
#    Manage Plans verify against DB
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    And I select Plans Med Active Policy
    And I select Plans Dental Active Policy
    Then I validate current "Medical" all details table in DB for 1 members on AP Manage Plans
    Then I validate current "Dental" all details table in DB for 1 members on AP Manage Plans
    Then I validate previous "Medical" all details table in DB for 2 members on policy "1" for DB row 2 on AP Manage Plans
    Then I validate previous "Dental" all details table in DB for 2 members on policy "1" for DB row 0 on AP Manage Plans

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal

  @SLER-2463
  Scenario: SLER-2463 OPS: MP: NFA Removing Dependent from policy[RT-2424]
    And I Apply for no financial help
    Then I select the option "Yes" to employment

    Then I validate I am on the "Tell us about life changes" page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I select the option "Yes" to employment
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear

    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse"
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page
    Then I validate I am on the "Medical Plan Results" page
    Then I select "KP Select CO Silver 4500/30 RX Copay" medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    And I validate I am on the "Dental Plan Results" page
    And I select "Anthem Dental Family" plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I close current tab and switch back to previous tab
#    Manage Plans Change Start Dates to 1/1
    Then I click on manage plan button on admin portal Individual dashboard
    Then I click Make Changes Medical button
    And I update the Coverage Start date of member
      | 1:First Day Of Current Year |
      | 2:First Day Of Current Year |
    And I update the Financial Start date of member
      | 1:First Day Of Current Year |
      | 2:First Day Of Current Year |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then I click Make Changes Dental button
    And I update the Coverage Start date of member
      | 1:First Day Of Current Year |
      | 2:First Day Of Current Year |
    And I update the Financial Start date of member
      | 1:First Day Of Current Year |
      | 2:First Day Of Current Year |
    And I click Save Button Dental
    And I select the reason to confirm the changes
    And I wait for 1000 milliseconds
    And I select Plans Med Active Policy
    And I select Plans Dental Active Policy
    Then I verify current plan data for "Medical" on Manage Plans page
      |no|coverageStart            |financialStart           |
      |1 |First Day Of Current Year|First Day Of Current Year|
      |2 |First Day Of Current Year|First Day Of Current Year|
    Then I verify current plan data for "Dental" on Manage Plans page
      |no|coverageStart            |financialStart           |
      |1 |First Day Of Current Year|First Day Of Current Year|
      |2 |First Day Of Current Year|First Day Of Current Year|
    And I close current tab and switch back to previous tab
#    OBO Remove member
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
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
#    not applying for spouse but not sure on LCE
    Then I click plus icon next to member on household page for "Spouse"
    Then I click edit basic information icon on household page for "Spouse"
    And I update member applying for coverage to "No"
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I click continue on the Immigration Status page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "Death" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    Then I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    Then I wait for 4500 milliseconds
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    Then I wait for 4500 milliseconds
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I click all done from payment portal page
    Then I validate I am on the "Account Overview" page
    And I close current tab and switch back to previous tab
#    Manage Plans verify against DB
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    And I select Plans Med Active Policy
    And I select Plans Dental Active Policy
    Then I validate current "Medical" all details table in DB for 1 members on AP Manage Plans
    Then I validate current "Dental" all details table in DB for 1 members on AP Manage Plans
    Then I validate previous "Medical" all details table in DB for 2 members on policy "1" for DB row 2 on AP Manage Plans
    Then I validate previous "Dental" all details table in DB for 2 members on policy "1" for DB row 0 on AP Manage Plans
    And I close current tab and switch back to previous tab
    Then logout from Admin Portal




