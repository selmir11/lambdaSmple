Feature: Seed02 with exception - Coco

  Scenario: Seed 02 For Coco -  Husband+Wife with FA

    Given I set the test scenario details in coco
      | totalGroups | totalMembers | total_subscribers | total_dependents | total_enrollees |
      | 1           | 2            | 1                 | 1                |   2             |
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "coco" account creation with email "MGC4testing"@outlook.com
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Given I set the dynamic policy, coverage and financial dates in coco
      | PolicyStartDate     | PolicyEndDate            | CoverageStartDate   | CoverageEndDate          | FinancialStartDate  | FinancialEndDate         |
      | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year |
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click on Find a Broker
    Then I Search authorized Broker "ENR Agency"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
    Then I click Continue with my application
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11181993", "Male", and applying "Yes"
    And I enter my residential address "102 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "35,000.00" income amount
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
    Then I enter details on tell us about additional members of your household page with "Spouse", "03021995", "Female", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "102 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
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
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    And I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse" coco
    And I get the application id from the url from tobacco page coco
    Then I click continue on coco start shopping page
    Then I validate that there are 1 default groups in coco page
    Then I click continue on grouping Members Medical coco page
    Then I validate I am on the "Medical Plan Results" page
    And I select or skip the medical plans for groups on medical plan page
      | Group 1:KP Colorado Option Bronze |
    Then I validate I am on the "planSummaryMedicalDental" page
    And I set medical premium amount
    And I click continue on coco plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page

  #UI Validation
    And I select year "2025" from My Current Plan container
    And I Validate the correct enrolled plans are displayed on coco welcome page
    And I click on "My Plans" link on welcome page
    And I validate enrolled medical plans details on my policies page coco

  # DB Validation
    And I validate "SUBMITTED" Medical entities from COCO policy tables
      | PolicyStartDate     | PolicyEndDate            | CoverageStartDate   | CoverageEndDate          | FinancialStartDate  | FinancialEndDate         | PolicyMemberCoverageStatus |
      | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | First Of Next Month | Last Day Of Current Year | SUBMITTED                  |
    And I validate Current Medical entities from COCO pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | PolicyStartDate     | PolicyEndDate            | FinancialStartDate  |addl_maint_reason  | sep_reason      |
      | 021                   | 021                | EC                    | First Of Next Month | Last Day Of Current Year | First Of Next Month |                   | NEW_CO_RESIDENT |
    And I download the medical files from coco sftp server with location "/outboundedi/"
    And I validate the coco ob834 medical file data