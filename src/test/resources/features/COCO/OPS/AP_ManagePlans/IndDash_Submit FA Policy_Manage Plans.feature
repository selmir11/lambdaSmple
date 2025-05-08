@OPS @COCO @ManagePlansCoco
Feature: IndDash: Submit FA Policy/Manage Plans
  @OPS @SLCR-915
  Scenario:SLCR-915 : Submit FA Policy/Manage Plans(CCRT-212)
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

  @SLCR-943
  Scenario: SLCR-943: OPS: MP: Verify Person ID for Son in manage plan for FA [CCRT-354]
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
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11281994", "Male", and applying "Yes"
    And I enter my residential address "102 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "80,000.00" income amount
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
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Spouse", "03051995", "Female", and applying "No"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "102 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Spouse"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Son", "12222020", "Male", and applying "Yes"
      |Primary:Child or Other dependent|
      |Spouse:Child or Other dependent|
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "102 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Son"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "Birth" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    Then I enter a OBO signature on the Declarations And Signature Page CoCo
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    Then I click continue on coco start shopping page
    Then I validate I am on the "Start Shopping" page
    And I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    And I get the application id from the url from tobacco page coco
    Then I click continue on coco start shopping page

    Then I validate I am on the "CoCo Grouping Members Medical" page
    And I click continue on coco medical grouping page
    Then I validate I am on the "CoCo Medical Plan Results" page
    And I select or skip the medical plans for groups on medical plan page
      | Group 1:Select Health Value Colorado Option Bronze |
    Then I validate I am on the "Coco Plan Summary" page
    And I click continue on coco plan summary page
    Then I validate I am on the "CoCo Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page
    #    Verify Manage Plans
    And I close current tab and switch back to previous tab
    Then I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I wait for 500 milliseconds
    Then I set the Person IDs on manage plan page
    #Change date for Son
    Then I click Make Changes Medical button
    And I update the Coverage Start date of member
      | 1:First Day Of Current Year |
      | 2:First Day Of Current Year |
    And I update the Financial Start date of member
      | 1:First Day Of Current Year |
      | 2:First Day Of Current Year |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    And I wait for 1000 milliseconds
    And I select Plans Med Active Policy
    Then I validate current "Medical" all details table in DB for 2 members on AP Manage Plans
    Then I set the Person IDs on manage plan page

#    Complete 2nd Application/Enrollment with Primary and Spouse
    And I close current tab and switch back to previous tab
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
    Then I validate I am on the "Account Overview" page
    And I click make Changes button on welcome page
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    And I click EditUpdate on Family Overview page for "Spouse"
    And I update applying for coverage option to "Yes"
    And I click continue on Tell us about additional members of your household page
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "Birth" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    Then I enter a OBO signature on the Declarations And Signature Page CoCo
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "CoCo Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse" coco
    Then I click continue on coco start shopping page
    Then I validate that there are 1 default groups in coco page
    Then I click continue on grouping Members Medical coco page
    Then I validate I am on the "Medical Plan Results" page
    Then I click continue on medical plan results page
    And I click continue on coco plan summary page
    Then I validate I am on the "CoCo Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page

#    Verify Manage Plans
    And I close current tab and switch back to previous tab
    And I refresh the page
    Then I click on "Manage Plans" user dashboard button
    And I switch to the tab number 1
    And I validate I am on the "Manage Plans" page
    Then I select Plans Med Active Policy
    Then I validate current "Medical" all details table in DB for 3 members on AP Manage Plans
    Then I validate the Person ID didn't change on manage plan page
    Then I validate current "Medical" all details table in DB for 3 members "Birth" LCE on AP Manage Plans
    And I close current tab and switch back to previous tab
    Then logout from Admin Portal