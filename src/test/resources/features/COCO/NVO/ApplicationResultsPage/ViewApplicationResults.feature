
#SLCR-651,SLCR-661
Feature: Coco user on the Application results page

  Background: I go the login portal
    Given I open the login page on the "login" portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page


  @SLCR-651 #WIP
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
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
    #DB STEP WIP

  @SLCR-661
    Scenario: ELIG-As a Coco user on the Application Results page, I need an ENR endpoint called for me so that I know if I can continue to shopping[CCRT-58]
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
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
    #DB STEP WIP
    And I verify the application result details in DB for "OFF_EXCHANGE_ELIGIBLE"

  @SLCR-661
  Scenario:  Scenario 2 - User clicks on the Save and Continue button on the Application results page user is not able to shop[CCRT-58]
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
    Then I validate I am on the "Elmo Race and Ethnicity" page
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
    #DB STEP
    And I verify the application result details in DB for "OFF_EXCHANGE_ELIGIBLE"

  @SLCR-661
    Scenario:  Scenario 3 -  User is not eligible for anything - do not call the ENR endpoint[CCRT-58]
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11282015", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Los ANgeles", "CA", "90005", "LOS ANGELES"
    And I select "No" for mailing address option
    And I enter my mailing address "101 Coco Drive", "Los ANgeles", "CA", "90005", "LOS ANGELES"
    And I select "No" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
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
    #DBSTEP
    And I verify the application result details in DB for "OFF_EXCHANGE_NOT_ELIGIBLE"

  @SLCR-678
  Scenario: Validate the page in Spanish when navigated without submitting an application
    And I click on "Application Results" link on welcome page
    Then I validate I am on the "Application Results CoCo" page
    And I change the language from header to "Spanish"
    Then I verify the header in "Spanish" on the Application Results Page CoCo
    Then I validate the Application Results page text in "Spanish" when no application is submitted
    And I click on Sign Out in the Header for "Elmo"


    @SLCR-680  #WIP
    Scenario: ELIG-As a Coco user on the application results page, I need to see my results information when I do not qualify for any benefit [CCRT-248]
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
      Then I validate I am on the "Elmo Race and Ethnicity" page
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
      #WIP FINAL STEP


