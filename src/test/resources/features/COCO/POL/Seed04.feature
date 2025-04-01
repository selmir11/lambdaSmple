 @SLCR-140
Feature: Regression Tests that require Seed 4
# verification WIP
  Background: Seed 04 For COCO - Minor only Applicant with Responsible Person Income of $35k
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "09052000", "Female", and applying "No"
    And I enter my residential address "104 Coco Drive", "Colorado Springs", "CO", "80919", "El Paso"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
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
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Daughter", "05052019", "Female", and applying "Yes"
      | Primary:Child or Other dependent |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "104 COCO DRIVE", "Colorado Springs", "CO", "80919", "El Paso"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Daughter"
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
    Then I click continue on coco start shopping page
    Then I validate I am on the "Medical Plan Results" page
    And I select or skip the medical plans for groups on medical plan page
      | Group 1:KP Colorado Option Bronze |
    Then I validate I am on the "planSummaryMedicalDental" page
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
    And I update the Coverage Start date of member
      |1:01012025|
    And I update the Financial Start date of member
      |1:01012025|
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then I close current tab and switch back to previous tab
    And logout from Admin Portal

     @SLCR-826-WIP-R4V
  Scenario: CCRT-128 - ENR-COCO: AUTO PROCESS POLICY - (LCE: Change in Permanent Residence) DIFFERENT RATING AREA
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
     And I update my residential address "700 NEW DRIVE", "Englewood", "CO", "80113", "ARAPAHOE"
     And I select "Yes" for mailing address option
     And I click continue on the Add info for yourself page
     And I click save and continue on the Race and Ethnicity page
     And I click continue on the Employment income page
     And I select continue on the Additional Income CoCO page
     And I select continue on the Deductions CoCo page
     And I select continue on the income Summary CoCo page
     Then I click EditUpdate on Family Overview page for "Daughter"
     And I click continue on Tell us about additional members of your household page
     And I update my residential address "700 NEW DRIVE", "Englewood", "CO", "80113", "ARAPAHOE"
     And I click continue on the Additional information for additional member page
     And I click save and continue on the Race and Ethnicity page
     And I click continue on the Employment income page
     And I select continue on the Additional Income CoCO page
     And I select continue on the Deductions CoCo page
     And I select continue on the income Summary CoCo page
     And I select continue on the Family Overview page
     Then I validate I am on the "CoCo life change event" page
     And I select "Move:Daughter" life change event with event date of "Today"
     And I select continue on the LCE page
     Then I validate I am on the "CoCo Declarations and Signature" page
     And I enter a valid signature
     And I click Continue on the Declarations And Signature Page CoCo
     Then I validate I am on the "Application Results CoCo" page
     And I click on Sign Out in the Header for "Elmo"

   @SLCR-827-WIP-R4V
  Scenario: CCRT-380 - ENR-COCO: ADD DEPENDENT (LCE: Marriage) - SAME PLANS
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
     And I update applying for coverage to "Yes" in coco
     Then I click Save and Continue only on the tell us about yourself page
     And I click continue on the Add info for yourself page
     And I click save and continue on the Race and Ethnicity page
     And I click continue on the Employment income page
     And I select continue on the Additional Income CoCO page
     And I select continue on the Deductions CoCo page
     And I select continue on the income Summary CoCo page
     Then I select add another family member on the Family Overview page
     Then I enter details on tell us about additional members of your household page with "Spouse", "11281998", "Male", and applying "Yes"
       | Primary:Spouse |
       | Daughter:Stepparent |
     And I click continue on Tell us about additional members of your household page
     And I enter residential address details for additional member "104 COCO DRIVE", "Colorado Springs", "CO", "80919", "EL PASO"
     And I select "Yes" for live in Colorado option for additional member
     And I click continue on the Additional information for additional member page
     Then I validate I am on the "Race and Ethnicity" page
     And I select "Prefer not to answer" for race and ethnicity option for "Spouse"
     And I click save and continue on the Race and Ethnicity page
     And I select "No" employment option
     And I click continue on the Employment income page
     And I select None of these as additional income option
     And I select continue on the Additional Income CoCO page
     And I select "None of these" as deductions option
     And I select continue on the Deductions CoCo page
     And I select the projected income option "No" on Income Summary CoCo page
     And I select continue on the income Summary CoCo page
     Then I validate I am on the "CoCo Family Overview" page
     And I select continue on the Family Overview page
     Then I validate I am on the "CoCo life change event" page
     And I select "Marriage:Primary,Spouse" life change event with event date of "Today"
     And I select continue on the LCE page
     Then I validate I am on the "CoCo Declarations and Signature" page
     And I enter a valid signature
     And I click Continue on the Declarations And Signature Page CoCo
     Then I validate I am on the "Application Results CoCo" page
     And I click Continue on the Application Results Page CoCo
     Then I validate I am on the "Start Shopping" page
     Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse" coco
     Then I click continue on coco start shopping page
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

   @SLCR-828-WIP-R4V
  Scenario: CCRT-381 - ENR-COCO: ADD DEPENDENT (LCE: Loss of MEC) - DIFFERENT PLANS
     Given I open the login page on the "login" portal
     And I validate I am on the "Login" page
     And I enter valid credentials to login
     Then I click continue signing in on the CAC Screener page
     Then I validate I am on the "CoCo Welcome" page
     And I click Make changes button on Welcome Page
     Then I validate I am on the "Find Expert Help" page
     And I click Continue on my own button from Manage who helps you page
     Then I validate I am on the "CoCo Family Overview" page
     Then I select add another family member on the Family Overview page
     Then I enter details on tell us about additional members of your household page with "Son", "07272021", "Male", and applying "Yes"
       | Primary:Child or Other dependent |
       | Daughter:Sibling |
     And I click continue on Tell us about additional members of your household page
     And I enter residential address details for additional member "104 COCO DRIVE", "Colorado Springs", "CO", "80919", "EL PASO"
     And I select "Yes" for live in Colorado option for additional member
     And I click continue on the Additional information for additional member page
     Then I validate I am on the "Race and Ethnicity" page
     And I select "Prefer not to answer" for race and ethnicity option for "Son"
     And I click save and continue on the Race and Ethnicity page
     And I select "No" employment option
     And I click continue on the Employment income page
     And I select None of these as additional income option
     And I select continue on the Additional Income CoCO page
     And I select "None of these" as deductions option
     And I select continue on the Deductions CoCo page
     And I select the projected income option "No" on Income Summary CoCo page
     And I select continue on the income Summary CoCo page
     Then I validate I am on the "CoCo Family Overview" page
     And I select continue on the Family Overview page
     Then I validate I am on the "CoCo life change event" page
     And I select "InsuranceLoss:Son" life change event with event date of "Today"
     And I select continue on the LCE page
     Then I validate I am on the "CoCo Declarations and Signature" page
     And I enter a valid signature
     And I click Continue on the Declarations And Signature Page CoCo
     Then I validate I am on the "Application Results CoCo" page
     And I click Continue on the Application Results Page CoCo
     Then I validate I am on the "Start Shopping" page
     Then I click continue on coco start shopping page
     Then I validate I am on the "Grouping Members Medical" page
     And I click continue on coco medical grouping page
#     Then I click continue on grouping Members Medical coco page
     Then I validate I am on the "Medical Plan Results" page
     And I select or skip the medical plans for groups on medical plan page
       | Group 1:Cigna Connect Colorado Option Bronze |
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

  @SLCR-848-WIP
  Scenario: CCRT-117 - ENR-COCO: DEMOGRAPHIC CHANGE - CHANGE RESPONSIBLE PERSON IDENTIFYING DATA (FNAME, LNAME, MAILING ADDRESS)
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click make Changes button on welcome page
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I click EditUpdate on Family Overview page for "Primary"
    And I enter new first name and last name on Tell Us About Yourself Page Coco
    And I click Save and Continue only on the tell us about yourself page
    And I select "No" for mailing address option
    And I enter my mailing address "PO BOX 8585", "Englewood", "CO", "80113", "ARAPAHOE"
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I check "None of these" life change event checkbox
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click on Sign Out in the Header for "Elmo"


  @SLCR-849-WIP
  Scenario: CCRT-118 - ENR-COCO: DEMOGRAPHIC CHANGE - CHANGE RESPONSIBLE PERSON CONTACT INFORMATION (PRIMARY PHONE, ALTERNATE PHONE, EMAIL, LANGUAGE)
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Profile" link on welcome page
    And I click on Make Changes Button in CoCo
    And I update the contact email address on my profile page in coco
    And I update the contact home phone number on profile page in coco
    And I update the contact mobile phone number on profile page in coco
    And I change Preferred Language Contact Method to "Spanish" in CoCo
    And I click on Save Button on My profile CoCo
    And I click on Sign Out in the Header for "Elmo"
