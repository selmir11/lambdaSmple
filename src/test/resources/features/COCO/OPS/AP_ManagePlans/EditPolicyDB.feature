@OPS @COCO @ManagePlansCoco
Feature: OPS: CoCo: MP: Change Enrollment data and verify in Account Activity and DB

  @SLCR-941 @OPS @ManagePlansCoco
  Scenario: SLCR-941 OPS: CoCo: MP: Change Enrollment data and verify in Account Activity and DB (CCRT-243)
  Given I open the login page on the "admin" portal
  And I validate I am on the "Login" page
  When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
  And I validate I am on the "Admin search" page
  Then I click create account on admin portal
  And I enter general mandatory data for "Admin coco" account creation
  And I validate I am on the "Admin search" page
  And I click Colorado Connect to search user
  And I search for user and click email from search results
  Then I validate I am on the "Admin Portal individual dashboard" page
  Then I validate "Admin Portal Text Display" for Admin Portal
  And I click "On Behalf Of (OBO)" from application links dropdown
  Then I switch to the tab number 1
  And I validate I am on the "Account Overview" page
  And I apply for the current year in CoCo
  And I click on Find a Broker
  Then I Search authorized Broker "Maggie Walker"
  And I click on Search button in find certified broker page
  And I click more details from the first broker result container
  And I click Authorized broker
  And I validate current Broker text exists
  Then I click Continue on my own button from Manage who helps you page
  And I select continue on the Family Overview page
  Then I click EditUpdate on Family Overview page for "Primary"
  Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
  And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
  And I select "Yes" for mailing address option
  And I select "Yes" for live in Colorado option
  And I click continue on the Add info for yourself page
  Then I validate I am on the "Race and Ethnicity" page
  And I select "Prefer not to answer" for race and ethnicity option for "Primary"
  And I click save and continue on the Race and Ethnicity page
  And I select "Yes" employment option
  And I enter "50,000.00" income amount
  And I select "Annually" income frequency option
  And I select "No" income seasonal option
  And I select "No" income changes option
  And I click continue on the Employment income page
  And I select None of these as additional income option
  And I select continue on the Additional Income CoCO page
  And I select "None of these" as deductions option
  And I select continue on the Deductions CoCo page
  Then I select the projected income option "No" on Income Summary CoCo page
  And I select continue on the income Summary CoCo page
  Then I validate I am on the "CoCo Family Overview" page

  And I select continue on the Family Overview page

  And I select "Birth" life change event with event date of "Today"
  And I select continue on the LCE page
  Then I validate I am on the "CoCo Declarations and Signature" page
  Then I enter a OBO signature on the Declarations And Signature Page CoCo
  And I click Continue on the Declarations And Signature Page CoCo
  Then I validate I am on the "Application Results CoCo" page

  And I click Continue on the Application Results Page CoCo
  Then I validate I am on the "Start Shopping" page
  And I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
  And I get the application id from the url from tobacco page coco
  Then I click continue on coco start shopping page
  Then I validate I am on the "Medical Plan Results" page
  And I select "Cigna Connect Colorado Option Bronze" coco medical plan
  Then I click Continue on the Medical Plans Page CoCo
  Then I validate I am on the "planSummaryMedicalDental" page
  And I set medical premium amount
  And I click continue on coco plan summary page
  Then I validate I am on the "Enrollment Agreements" page
  And I select "Acknowledgement" agreement checkbox CoCo
  And I select "Submit" agreement checkbox CoCo
  And I enter householder signature on the Enrollment Agreements page CoCo
  And I select submit enrollment button on the Enrollment Agreements CoCo page
  And I validate I am on the "Pay now" page
  Then I click all done from payment portal page OBO
  And I close current tab and switch back to previous tab
  Then I refresh the page
  Then I click on "Manage Plans" user dashboard button
  And I switch to the tab number 1
  And I validate I am on the "Manage Plans" page
  And I select Plans Med Active Policy
  Then I validate current "Medical" all details table in DB for 1 members on AP Manage Plans
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
    And I select Plans Med Active Policy
    Then I validate current "Medical" all details table in DB for 1 members on AP Manage Plans
    Then I verify current plan data for "Medical" on Manage Plans page
      |no|coverageStart            |coverageEnd              |terminationReason  |financialStart           |financialEnd           |premium  |aptc     |
      |1 |First Day Of Current Year|End of May Current Year  |No_reason          |First Day Of Current Year|End of May Current Year|$400.00  |$200.00  |
  #Reinstate plan
    Then I click Make Changes Medical button
    And I update the Coverage End date of member on manage plan page for "Medical"
      | Primary:Last Day Of Current Year |
    And I update the Financial End date of member on manage plan page
      | Primary:Last Day Of Current Year |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    And I select Plans Med Active Policy
    Then I validate current "Medical" all details table in DB for 1 members on AP Manage Plans
    Then I verify current plan data for "Medical" on Manage Plans page
      |no|coverageStart            |coverageEnd              |terminationReason  |financialStart           |financialEnd            |premium  |aptc     |
      |1 |First Day Of Current Year|Last Day Of Current Year |                   |First Day Of Current Year|Last Day Of Current Year|$400.00  |$200.00  |
    And I close current tab and switch back to previous tab
    Then logout from Admin Portal
