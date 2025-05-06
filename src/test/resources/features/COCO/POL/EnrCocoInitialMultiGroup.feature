Feature: Coco Initial Application Multi group
  @SLCR-146
  Scenario: CCRT-94 COCO Initial Application - MULTI-GROUP (Husband+wife & Son+DIL)

    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Given I set the dynamic policy, coverage and financial dates in coco
      | PolicyStartDate     | PolicyEndDate            | CoverageStartDate   | CoverageEndDate          | FinancialStartDate  | FinancialEndDate         |
      | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year |
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "09051959", "Male", and applying "Yes"
    And I enter my residential address "105 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Native Hawaiian or Pacific Islander" for race and ethnicity option for "Primary"
    And I click continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "20,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
#    Spouse
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Spouse", "07271963", "Female", and applying "Yes"
      |Primary:Spouse|
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "105 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Native Hawaiian or Pacific Islander" for race and ethnicity option for "Spouse"
    And I click continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
#    Son
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Son", "08281999", "Male", and applying "Yes"
      | Primary:Child or Other dependent |
      | Spouse:Child or Other dependent       |
  And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "500 Diff Drive", "Colorado Springs", "CO", "80919", "EL PASO"

    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select Not listed for race and ethnicity option and enter "Kitsune" in the text box for "Son"
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "20,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
#    Daughter In-Law
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "DIL", "05052001", "Female", and applying "Yes"
      | Primary:Other Relative |
      | Spouse:Other Relative       |
      | Son:Spouse             |
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "500 Diff Drive", "Colorado Springs", "CO", "80919", "EL PASO"

    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select Not listed for race and ethnicity option and enter "Kitsune" in the text box for "DIL"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "CoCo Start Shopping" page
    Then I click "Yes" to the Tobacco usage question on start shopping page for "Primary,Spouse" coco
    Then I click "No" to the Tobacco usage question on start shopping page for "Son,DIL" coco
    And I get the application id from the url from tobacco page coco
    Then I click continue on coco start shopping page
    Then I validate I am on the "CoCo Grouping Members Medical" page
    Then I validate that there are 2 default groups in coco page
    And  I click on edit enrollment groups link in coco page
    And I create new group in edit medical grouping coco page and drag members to the new group
      | Primary,Spouse:Group1 |
      | Son,DIL:Group2        |
    Then I click save button to save the groups in CoCo Page
    Then I click on continue button on success pop-up in CoCo Page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical coco page
    Then I validate I am on the "CoCo Medical Plan Results" page
    And I select or skip the medical plans for groups on medical plan page
      | Group 1:Anthem Colorado Option Bronze Pathway Essentials Std |
      | Group 2:RMHP Colorado Doctors Plan Colorado Option Bronze |
    Then I validate I am on the "Coco Plan Summary" page
    And I set "Medical" Plans premium amount
    And I redifine the relationships based on groups
      | DIL:SPOUSE |
    And I click continue on coco plan summary page
    Then I validate I am on the "CoCo Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page
#    And I click on "My Documents and Letters" link on welcome page
#    And I click on download "EN-002-04" document
#    Then I validate "EN-002-04 English" notice content
#    And I click on Sign Out in the Header for "Elmo"
#
#    Then I open outlook Tab
#    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
#    Then I open the notice "(EN-002-04)" in "English"
#    And I verify the notice Text for "EN-002-04" in "English" for "Coco"
#    Then I delete the open notice
#    And I sign out of Outlook
#    And I switch to the tab number 0

    And I validate "SUBMITTED" policy table entities for groups in COCO
    And I verify the policy data quality check with Policy Ah keyset size 2
    And I validate Medical entities for groups from COCO pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code |addl_maint_reason  | sep_reason      |
      | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
    And I download the medical and dental files from sftp server with location "/outboundedi/"
    And I validate different issuer medical files in coco
    And I upload coco files on to sftp server location "/outboundedi/mockediresponse/genEff834"

   # Ib999 DB Validation
    And I validate coco entities from ib999_details db table
    And I download the "medical" ib999 files from sftp server with location "/archive/INBOUND999/"
    And I validate the COCO ib999 file data
