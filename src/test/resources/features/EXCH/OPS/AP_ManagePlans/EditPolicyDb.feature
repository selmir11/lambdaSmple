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
    Then I click continue on family overview page

  @SLER-2445
  Scenario: SLER-2445 OPS: MP: Change Enrollment data and verify in Account Activity and DB
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "$35000.00" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
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
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary"
    Then I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    Then I select "Select Health Value Bronze $6900 Medical Deductible" medical plan
    Then I click continue on medical plan results page
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
    Then I wait for 50 milliseconds
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    Then I validate current "Medical" all details table in DB for 1 members on AP Manage Plans
    Then I validate current "Dental" all details table in DB for 1 members on AP Manage Plans
#Manage Plans - Effective Dates, Premium, APTC Change, terminate and term reason
    Then I click Make Changes Medical button
    And I update the Coverage Start date of member on manage plan page
      | Primary:First Day Of Current Year |
    And I update the Coverage End date of member on manage plan page for "Medical"
      | Primary:End of May Current Year |
    And I update the Termination Reason value
      |1:No_Reason|
    And I update the Financial Start date of member on manage plan page
      | Primary:First Day Of Current Year |
    And I update the Financial End date of member on manage plan page
      | Primary:End of May Current Year |
    Then I update the premium value for
      | 1:400.00 |
    Then I update the APTC value for
      | 1:200.00 |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then I click Make Changes Dental button
    And I update the Coverage Start date of member on manage plan page
      | Primary:First Day Of Current Year |
    And I update the Coverage End date of member on manage plan page for "Dental"
      | Primary:End of May Current Year |
    And I update the Termination Reason value
      |1:Non_Payment|
    And I update the Financial Start date of member on manage plan page
      | Primary:First Day Of Current Year |
    And I update the Financial End date of member on manage plan page
      | Primary:End of May Current Year |
    Then I update the premium value for
      | 1:10.00 |
    Then I update the APTC value for
      | 1:10.00 |
    And I click Save Button Dental
    And I select the reason to confirm the changes
    And I select Plans Med Active Policy
    And I select Plans Dental Active Policy
    Then I validate current "Medical" all details table in DB for 1 members on AP Manage Plans
    Then I verify current plan data for "Medical" on Manage Plans page
      |no|coverageStart            |coverageEnd              |terminationReason  |financialStart           |financialEnd           |premium  |aptc     |
      |1 |First Day Of Current Year|End of May Current Year  |No_reason          |First Day Of Current Year|End of May Current Year|$400.00  |$200.00  |
    Then I validate current "Dental" all details table in DB for 1 members on AP Manage Plans
    Then I verify current plan data for "Dental" on Manage Plans page
      |no|coverageStart            |coverageEnd              |terminationReason  |financialStart           |financialEnd           |premium  |aptc     |
      |1 |First Day Of Current Year|End of May Current Year  |Non_payment        |First Day Of Current Year|End of May Current Year|$10.00   |$10.00   |
#Reinstate plan
    Then I click Make Changes Medical button
    And I update the Coverage End date of member on manage plan page for "Medical"
      | Primary:Last Day Of Current Year |
    And I update the Financial End date of member on manage plan page
      | Primary:Last Day Of Current Year |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    And I select Plans Dental Active Policy
    Then I click Make Changes Dental button
    And I update the Coverage End date of member on manage plan page for "Dental"
      | Primary:Last Day Of Current Year |
    And I update the Financial End date of member on manage plan page
      | Primary:Last Day Of Current Year |
    And I click Save Button Dental
    And I select the reason to confirm the changes
    And I select Plans Med Active Policy
    And I select Plans Dental Active Policy
    Then I validate current "Medical" all details table in DB for 1 members on AP Manage Plans
    Then I verify current plan data for "Medical" on Manage Plans page
      |no|coverageStart            |coverageEnd              |terminationReason  |financialStart           |financialEnd            |premium  |aptc     |
      |1 |First Day Of Current Year|Last Day Of Current Year |                   |First Day Of Current Year|Last Day Of Current Year|$400.00  |$200.00  |
    Then I validate current "Dental" all details table in DB for 1 members on AP Manage Plans
    Then I verify current plan data for "Dental" on Manage Plans page
      |no|coverageStart            |coverageEnd              |terminationReason  |financialStart           |financialEnd            |premium  |aptc     |
      |1 |First Day Of Current Year|Last Day Of Current Year |                   |First Day Of Current Year|Last Day Of Current Year|$10.00   |$10.00   |

    And I close current tab and switch back to previous tab
    Then logout from Admin Portal