Feature: Seed02 - Coco

  Background: Seed 02 For Coco -  Husband+Wife with FA
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
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Given I set the dynamic policy, coverage and financial dates in coco
      | PolicyStartDate     | PolicyEndDate       | CoverageStartDate   | CoverageEndDate     | FinancialStartDate  | FinancialEndDate    |
      | First Of Next Month | First Of Next Month | First Of Next Month | First Of Next Month | First Of Next Month | First Of Next Month |
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
    And I click on Sign Out in the Header for "Elmo"

    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin dashboard" page
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    Then I click on "Manage Plans" user dashboard button
    Then I click Make Changes Medical button
    And I update the Coverage Start date of member on manage plan page
      | Primary:First Day Of Current Year |
      | Spouse:First Day Of Current Year |
    And I update the Financial Start date of member on manage plan page
      | Primary:First Day Of Current Year |
      | Spouse:First Day Of Current Year |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then I close current tab and switch back to previous tab
    And logout from Admin Portal
    And I validate "CANCELLED" Medical entities from COCO policy tables
    And I validate Medical entities from COCO pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code |addl_maint_reason  | sep_reason  |
      | 024                   | 024                | AI                    | CANCEL            |             |
    And I download the medical files from coco sftp server with location "/outboundedi/"
    And I validate the coco ob834 medical file data
    Given I set the dynamic policy, coverage and financial dates in coco
      | PolicyStartDate           | PolicyEndDate            | CoverageStartDate         | CoverageEndDate          | FinancialStartDate        | FinancialEndDate         |
      | First Day Of Current Year | Last Day Of Current Year | First Day Of Current Year | Last Day Of Current Year | First Day Of Current Year | Last Day Of Current Year |

    # UI Validation
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    Then I Validate the correct enrolled plans are displayed on coco welcome page
    And I click on "My Plans" link on welcome page
    And I validate enrolled medical plans details on my policies page coco
    And I click on Sign Out in the Header for "Elmo"

    # DB Validation
    And I validate "SUBMITTED" Medical entities from COCO policy tables
    And I validate Medical entities from COCO pre edi db tables
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code |addl_maint_reason  | sep_reason      |
      | 021                   | 021                | EC                    |                   | NEW_CO_RESIDENT |
    And I validate the coco ob834 medical file data that present in localPath or coco sftp server "/outboundedi/"

   @SLCR-787-WIP
  Scenario: CCRT-109 - ENR-COCO: AUTO PROCESS POLICY - REMOVE MEMBER (LCE: Death) DEATH OF SPOUSE
     Given I open the login page on the "login" portal
     And I validate I am on the "Login" page
     And I enter valid credentials to login
     Then I click continue signing in on the CAC Screener page
     Then I validate I am on the "CoCo Welcome" page
     And I click Make changes button on Welcome Page
     Then I validate I am on the "Find Expert Help" page
     And I click Continue on my own button from Manage who helps you page
     Then I validate I am on the "CoCo Family Overview" page
     Then I click EditUpdate on Family Overview page for "Spouse"
     And I update applying for coverage option to "No"
     And I click continue on Tell us about additional members of your household page
     And I click continue on the Additional information for additional member page
     And I click save and continue on the Race and Ethnicity page
     And I click continue on the Employment income page
     And I select continue on the Additional Income CoCO page
     And I select continue on the Deductions CoCo page
     And I select continue on the income Summary CoCo page
     And I select continue on the Family Overview page
     Then I validate I am on the "CoCo life change event" page
     And I select "Death:Spouse" life change event with event date of "Today"
     And I select continue on the LCE page
     Then I validate I am on the "CoCo Declarations and Signature" page
     And I enter a valid signature
     And I click Continue on the Declarations And Signature Page CoCo
     Then I validate I am on the "Application Results CoCo" page
     And I click on Sign Out in the Header for "Elmo"

   @SLCR-788-WIP
  Scenario: CCRT-116 - ENR-COCO: AUTO PROCESS POLICY - (LCE: Change in Permanent Residence) SAME RATING AREA
     Given I open the login page on the "login" portal
     And I validate I am on the "Login" page
     And I enter valid credentials to login
     Then I click continue signing in on the CAC Screener page
     Then I validate I am on the "CoCo Welcome" page
     And I click Make changes button on Welcome Page
     Then I validate I am on the "Find Expert Help" page
     And I click Continue on my own button from Manage who helps you page
     Then I validate I am on the "CoCo Family Overview" page
     Then I click EditUpdate on Family Overview page for "Primary"
     Then I click Save and Continue only on the tell us about yourself page
     Then I validate I am on the "CoCo Additional information for yourself" page
     And I update my residential address "101 New Drive", "Boulder", "CO", "80020", "BOULDER"
     And I select "No" for mailing address option
     And I enter my mailing address "PO BOX 4545", "Boulder", "CO", "80020", "BOULDER"
     And I click continue on the Add info for yourself page
     And I click save and continue on the Race and Ethnicity page
     And I click continue on the Employment income page
     And I select continue on the Additional Income CoCO page
     And I select continue on the Deductions CoCo page
     And I select continue on the income Summary CoCo page
     And I select continue on the Family Overview page
     Then I validate I am on the "CoCo life change event" page
     And I select "Move:Primary" life change event with event date of "Today"
     And I select continue on the LCE page
     Then I validate I am on the "CoCo Declarations and Signature" page
     And I enter a valid signature
     And I click Continue on the Declarations And Signature Page CoCo
     Then I validate I am on the "Application Results CoCo" page
     And I click on Sign Out in the Header for "Elmo"

    @SLCR-789-WIP
  Scenario: CCRT-446 - ENR-COCO: DEMOGRAPHIC CHANGE - AGENT BROKER INFO - REMOVE BROKER
      Given I open the login page on the "login" portal
      And I validate I am on the "Login" page
      And I enter valid credentials to login
      Then I click continue signing in on the CAC Screener page
      Then I validate I am on the "CoCo Welcome" page
      And I click Make changes button on Welcome Page
      Then I validate I am on the "Find Expert Help" page
      Then I Remove my current Broker
      Then I "Ok" my decision to remove my current broker
      Then I click Continue on my own button from Manage who helps you page
      And I select continue on the Family Overview page
      Then I validate I am on the "CoCo life change event" page
      And I check "None of these" life change event checkbox
      And I select continue on the LCE page
      Then I validate I am on the "CoCo Declarations and Signature" page
      And I enter a valid signature
      And I click Continue on the Declarations And Signature Page CoCo
      Then I validate I am on the "Application Results CoCo" page
      And I click on Sign Out in the Header for "Elmo"

