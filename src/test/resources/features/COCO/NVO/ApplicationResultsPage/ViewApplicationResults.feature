@NVOCoCoRegression
Feature: Coco user on the Application results page
  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page

  @SLCR-651
  Scenario:  ELIG-As a Coco user viewing the application results page I need to see only the latest application results so that I don't see any outdated/historical information on the page[CCRT-56]
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11282015", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "Employment Income" page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
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
    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "InsuranceLoss" life change event with event date of "Today"
    And I select continue on the LCE page


    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    And I get the application id from the url from tobacco page coco
    Then I validate the application id from the db
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-651
  Scenario:  ELIG-As a Coco user viewing the application results page I need to see only the latest application results so that I don't see any outdated/historical information on the page[CCRT-56]
    And I click on "Application Results" link on welcome page
    Then I validate I am on the "Application Results CoCo" page
    Then I validate the Application Results page text in "English" when no application is submitted
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-661
    Scenario: ELIG-As a Coco user on the Application Results page, I need an ENR endpoint called for me so that I know if I can continue to shopping[CCRT-58]
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    And I get the memberId of primary member from url
    Then I enter details on tell us about yourself page and continue with "11282015", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "Employment Income" page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
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
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "InsuranceLoss" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I wait for 5000 milliseconds
    And I verify the application result details in DB as "OFF_EXCHANGE_ELIGIBLE" for "getFromSharedData"
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-661
  Scenario:  Scenario 2 - User clicks on the Save and Continue button on the Application results page user is not able to shop[CCRT-58]
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    And I get the memberId of primary member from url
    Then I enter details on tell us about yourself page and continue with "11282000", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "Employment Income" page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
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
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "InsuranceLoss" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I wait for 10000 milliseconds
    And I verify the application result details in DB as "OFF_EXCHANGE_ELIGIBLE" for "Primary"
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    And I select "Anthem Colorado Option Silver Pathway Essentials Std" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page
    And I click on "Application Results" link on welcome page
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    Then I validate open enrollment ended pop up in "English"
    And I click close on open enrollment ended pop up modal
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-661
    Scenario:  Scenario 3 -  User is not eligible for anything - do not call the ENR endpoint[CCRT-58]
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    And I get the memberId of primary member from url
    Then I enter details on tell us about yourself page and continue with "11282015", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Los ANgeles", "CA", "90005", "LOS ANGELES"
    And I select "No" for mailing address option
    And I enter my mailing address "101 Coco Drive", "Los Angeles", "CA", "90005", "LOS ANGELES"
    And I select "No" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "Employment Income" page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
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
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "InsuranceLoss" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I wait for 10000 milliseconds
    And I verify the application result details in DB as "OFF_EXCHANGE_NOT_ELIGIBLE" for "getFromSharedData"
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-678
  Scenario: Validate the page in Spanish when navigated without submitting an application
    And I click on "Application Results" link on welcome page
    Then I validate I am on the "Application Results CoCo" page
    And I change the language from header to "Spanish"
    Then I verify the header in "Spanish" on the Application Results Page CoCo
    Then I validate the Application Results page text in "Spanish" when no application is submitted
    And I click on Sign Out in the Header for "Elmo"

    @SLCR-680
    Scenario: ELIG-As a Coco user on the application results page, I need to see my results information when I do not qualify for any benefit [CCRT-248]
      And I apply for the current year in CoCo
      Then I validate I am on the "Find Expert Help" page
      And I click Continue on my own button from Manage who helps you page
      Then I validate I am on the "CoCo Family Overview" page
      Then I click EditUpdate on Family Overview page for "Primary"
      Then I enter details on tell us about yourself page and continue with "11282015", "Male", and applying "Yes"
      And I enter my residential address "1234 Road", "Los Angeles", "CA", "90005", "LOS ANGELES"
      And I select "No" for mailing address option
      And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
      And I select "No" for live in Colorado option
      And I click continue on the Add info for yourself page
      Then I validate I am on the "Race and Ethnicity" page
      And I select "Prefer not to answer" for race and ethnicity option for "Primary"
      And I click save and continue on the Race and Ethnicity page
      Then I validate I am on the "Employment Income" page
      And I select "Yes" employment option
      And I enter "30,000.00" income amount
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
      And I select continue on the Family Overview page
      Then I validate I am on the "CoCo life change event" page
      And I check "None of these" life change event checkbox
      And I select continue on the LCE page
      Then I validate I am on the "CoCo Declarations and Signature" page
      And I enter a valid signature
      And I click Continue on the Declarations And Signature Page CoCo
      Then I validate I am on the "Application Results CoCo" page
      Then I validate the text on the application results page coco
      And I click on Sign Out in the Header for "Elmo"
      Then I validate I am on the "Login" page

  @SLCR-669
  Scenario: ELIG-NVO E2E members able to shop for Current Year with valid QLCE (CE)
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    And I get the memberId of primary member from url
    Then I enter details on tell us about yourself page and continue with "11282015", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "Employment Income" page
    And I select "Yes" employment option
    And I enter "18,000.00" income amount
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
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I wait for 3000 milliseconds
    And I verify the application result details in DB as "OFF_EXCHANGE_ELIGIBLE" for "getFromSharedData"
    And I verify the application result details in DB as "ELIGIBLE_FOR_HP2_LIMITED" for "getFromSharedData"
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

@SLCR-684
Scenario: scenario 1 ELIG-Verify the Spanish text on the Application Results page (eligible Spanish text)
  And I apply for the current year in CoCo
  Then I validate I am on the "Find Expert Help" page
  And I click Continue on my own button from Manage who helps you page
  Then I click EditUpdate on Family Overview page for "Primary"
  And I enter details on tell us about yourself page and continue with "01011988", "Male", and applying "Yes"
  And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
  And I select "Yes" for mailing address option
  And I select "Yes" for live in Colorado option
  And I click continue on the Add info for yourself page
  Then I validate I am on the "Race and Ethnicity" page
  And I select "Prefer not to answer" for race and ethnicity option for "Primary"
  And I click save and continue on the Race and Ethnicity page
  And I select "Yes" employment option
  And I enter "45,000.00" income amount
  And I select "Annually" income frequency option
  And I select "No" income seasonal option
  And I select "No" income changes option
  And I click continue on the Employment income page
  And I select None of these as additional income option
  And I select continue on the Additional Income CoCO page
  Then I validate I am on the "CoCo Deductions" page
  And I select "None of these" as deductions option
  And I select continue on the Deductions CoCo page
  Then I select the projected income option "No" on Income Summary CoCo page
  And I select continue on the income Summary CoCo page
  Then I validate I am on the "CoCo Family Overview" page
  And I wait for 9000 milliseconds

  Then I select add another family member on the Family Overview page
  Then I validate I am on the "CoCo Tell us about additional members" page
  Then I enter details on tell us about additional members of your household page with "Wife", "03051989", "Female", and applying "Yes"
    | Primary:Spouse |
  And I click continue on Tell us about additional members of your household page
  Then I validate I am on the "CoCo Additional info for additional member" page
  And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
  And I select "Yes" for live in Colorado option for additional member
  And I click continue on the Additional information for additional member page
  Then I validate I am on the "Race and Ethnicity" page
  And I select "Prefer not to answer" for race and ethnicity option for "Wife"
  And I click save and continue on the Race and Ethnicity page
  And I select "No" employment option
  And I click continue on the Employment income page
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
  And I change the language from header to "Spanish"
  Then I validate eligible members list
  Then I validate the text in Spanish on the application results page coco

  @SLCR-684
  Scenario: scenario 2 ELIG-Verify the Spanish text on the Application Results page (not eligible Spanish text)
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    And I enter details on tell us about yourself page and continue with "01011991", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Los Angeles", "CA", "90005", "LOS ANGELES"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I wait for 9000 milliseconds
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I check "None of these" life change event checkbox

    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I change the language from header to "Spanish"
    Then I validate text in Spanish on the application results page when not eligible

  @SLCR-688
    Scenario: scenario 2 ELIG-As a CoCo user on the Application results page, I need to view my real results in the left container after application submission and eligibility determination.
      And I apply for the current year in CoCo
      Then I validate I am on the "Find Expert Help" page
      And I click Continue on my own button from Manage who helps you page
      Then I click EditUpdate on Family Overview page for "Primary"
      And I get the memberId of primary member from url
      And I enter details on tell us about yourself page and continue with "01011991", "Male", and applying "Yes"
      And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
      And I select "Yes" for mailing address option
      And I select "Yes" for live in Colorado option
      And I click continue on the Add info for yourself page
      Then I validate I am on the "Race and Ethnicity" page
      And I select "Prefer not to answer" for race and ethnicity option for "Primary"
      And I click save and continue on the Race and Ethnicity page
      And I select "Yes" employment option
      And I enter "30,000.00" income amount
      And I select "Annually" income frequency option
      And I select "No" income seasonal option
      And I select "No" income changes option
      And I click continue on the Employment income page
      And I select None of these as additional income option
      And I select continue on the Additional Income CoCO page
      Then I validate I am on the "CoCo Deductions" page
      And I select "None of these" as deductions option
      And I select continue on the Deductions CoCo page
      Then I select the projected income option "No" on Income Summary CoCo page
      And I select continue on the income Summary CoCo page
      Then I validate I am on the "CoCo Family Overview" page
      And I wait for 9000 milliseconds
      Then I validate I am on the "CoCo Family Overview" page
      And I select continue on the Family Overview page
      Then I validate I am on the "CoCo life change event" page
      And I select "MoveToCO" life change event with event date of "Today"
      And I select continue on the LCE page
      Then I validate I am on the "CoCo Declarations and Signature" page
      And I enter a valid signature
      And I click Continue on the Declarations And Signature Page CoCo
      Then I validate I am on the "Application Results CoCo" page
      Then I validate the text on the application results page coco
      And I click Continue on the Application Results Page CoCo
      And I verify the application result details in DB as "OFF_EXCHANGE_ELIGIBLE" for "getFromSharedData"
      And I click on Sign Out in the Header for "Elmo"
      Then I validate I am on the "Login" page

  @SLCR-679
  Scenario Outline: Validate text application result
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    And I get the memberId of primary member from url
    Then I enter details on tell us about yourself page and continue with "11281992", "Male", and applying "<isApplying>"
    And I enter my residential address "101 Coco Drive", "<city>", "<state>", "<zipcode>", "<county>"
    And I select "Yes" for mailing address option
    And I select "<isCoResident>" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "Employment Income" page
    And I select "Yes" employment option
    And I enter "27,000.00" income amount
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
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "InsuranceLoss" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    Then I validate the text on the application results page coco
    And I click on Sign Out in the Header for "Elmo"
    Examples:
      | city        | state | zipcode | county      | isApplying | isCoResident |
      | Denver      | CO    | 80205   | DENVER      | Yes        | Yes          |
      | Los Angeles | CA    | 90005   | LOS ANGELES | Yes        | No           |
