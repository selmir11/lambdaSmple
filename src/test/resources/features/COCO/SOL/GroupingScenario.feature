@SOLRegression @COCO_SOL
Feature: UI Page Validation - Grouping Members (Medical)

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"


  @SLCR-161 @groupingbysiblingswithoutparents
  Scenario: Two members both siblings in the household, Parents not applying, one group should exist

    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "No"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "65,000.00" income amount
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
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Wife", "07081980", "Female", and applying "No"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Wife"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "60,000.00" income amount
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
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "SonOne", "01012010", "Male", and applying "Yes"
      |Primary:Child or Other dependent|
      |Wife:Child or Other dependent|
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "SonOne"
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
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "SonTwo", "03052012", "Male", and applying "Yes"
      |Primary:Child or Other dependent|
      |Wife:Child or Other dependent|
      |SonOne:Sibling                  |
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "SonTwo"
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

    Then I validate I am on the "Grouping Members Medical" page
    And I validate that there are 1 default groups in coco page

  @SLCR-331 @SLCR-333
  Scenario Outline: Validate default groups for major and minor step kids and with step parent
    Then I enter details on tell us about yourself page and continue with "01011980", "Male", and applying "Yes"
    And I enter my residential address "1234 Downing street", "Englewood", "CO", "80111", "Arapahoe"
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

    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
      #Step Daughter
    Then I enter details on tell us about additional members of your household page with "StepDaughter", "<Kid1Age>", "Female", and applying "Yes"
      | Primary:Stepchild |

    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Downing street", "Englewood", "CO", "80111", "Arapahoe"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "StepDaughter"
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
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "StepSon", "<Kid2Age>", "Male", and applying "Yes"
      | Primary:Stepchild |
      | StepDaughter:Sibling|
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "123 Downing", "Centennial", "CO", "80111", "Arapahoe"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "StepSon"
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
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on coco start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    And I validate that there are <expectedDefaultGroups> default groups in coco page
    Examples:
    |Kid1Age     |Kid2Age |expectedDefaultGroups|
    |01012007    |01012009|       1             |
    |01011997    |01011996|       3             |

    @SLCR-334
    Scenario: Validate siblings could be grouped together by editing when Step Parent and Step Kids in households.
      Then I enter details on tell us about yourself page and continue with "01011980", "Male", and applying "Yes"
      And I enter my residential address "1234 Downing street", "Englewood", "CO", "80111", "Arapahoe"
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

      And I select the No projected Income button on the Income Summary page
      And I select continue on the income Summary CoCo page

      Then I validate I am on the "CoCo Family Overview" page
      Then I select add another family member on the Family Overview page
      Then I validate I am on the "CoCo Tell us about additional members" page
      #Step Daughter
      Then I enter details on tell us about additional members of your household page with "StepDaughter", "01012007", "Female", and applying "Yes"
        | Primary:Stepchild |

      And I click continue on Tell us about additional members of your household page
      Then I validate I am on the "CoCo Additional info for additional member" page
      And I enter residential address details for additional member "1234 Downing street", "Englewood", "CO", "80111", "Arapahoe"
      And I select "Yes" for live in Colorado option for additional member
      And I click continue on the Additional information for additional member page
      Then I validate I am on the "Race and Ethnicity" page
      And I select "Prefer not to answer" for race and ethnicity option for "StepDaughter"
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
      Then I select add another family member on the Family Overview page
      Then I validate I am on the "CoCo Tell us about additional members" page
      Then I enter details on tell us about additional members of your household page with "StepSon", "01012009", "Male", and applying "Yes"
        | Primary:Stepchild |
        | StepDaughter:Sibling|
      And I click continue on Tell us about additional members of your household page
      Then I validate I am on the "CoCo Additional info for additional member" page
      And I enter residential address details for additional member "123 Downing", "Centennial", "CO", "80111", "Arapahoe"
      And I select "Yes" for live in Colorado option for additional member
      And I click continue on the Additional information for additional member page
      Then I validate I am on the "Race and Ethnicity" page
      And I select "Prefer not to answer" for race and ethnicity option for "StepSon"
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
      And I click Continue on the Application Results Page CoCo

      Then I validate I am on the "Start Shopping" page
      Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
      Then I click continue on coco start shopping page

      Then I validate I am on the "Grouping Members Medical" page
      And I validate that there are 1 default groups in coco page
      Then I click on edit enrollment groups link in coco page
      Then I validate I am on the "Edit Grouping Members Medical" page
      Then I create new group in edit medical grouping coco page and drag members to the new group
        |Primary:Group1|
        |StepSon,StepDaughter:Group2|
      Then I click save button to save the groups in CoCo Page
      And I validated message on success enrollment grouping pop-up in CoCo Page
      Then I click on continue button on success pop-up in CoCo Page
      Then I validate I am on the "Grouping Members Medical" page
      And I validate that there are 2 default groups in coco page
      Then I click continue on grouping Members Medical coco page
      Then I validate I am on the "Medical Plan Results" page

  @SLCR-335
  Scenario: Validate siblings could be grouped together by editing when Step Parent and Step Kids in household.
    Then I enter details on tell us about yourself page and continue with "01011980", "Male", and applying "Yes"
    And I enter my residential address "1234 Downing street", "Englewood", "CO", "80111", "Arapahoe"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "30,000" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page

    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
      #Step Daughter
    Then I enter details on tell us about additional members of your household page with "StepDaughter", "01012007", "Female", and applying "Yes"
      | Primary:Stepchild |

    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Downing street", "Englewood", "CO", "80111", "Arapahoe"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "StepDaughter"
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
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "StepSon", "01012009", "Male", and applying "Yes"
      | Primary:Stepchild |
      | StepDaughter:Sibling|
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "123 Downing", "Centennial", "CO", "80111", "Arapahoe"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "StepSon"
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
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on coco start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    And I validate that there are 1 default groups in coco page
    Then I click on edit enrollment groups link in coco page
    Then I validate I am on the "Edit Grouping Members Medical" page
    Then I create new group in edit medical grouping coco page and drag members to the new group
      |Primary,StepSon:Group1|
      |StepDaughter:Group2|
    Then I click save button to save the groups in CoCo Page
    And I validated message on success enrollment grouping pop-up in CoCo Page
    Then I click on continue button on success pop-up in CoCo Page
    Then I validate I am on the "Grouping Members Medical" page
    And I validate that there are 2 default groups in coco page
    Then I click continue on grouping Members Medical coco page
    Then I validate I am on the "Medical Plan Results" page