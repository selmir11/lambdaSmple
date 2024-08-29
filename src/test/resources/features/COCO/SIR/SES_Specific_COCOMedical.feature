@COCOMedicalResults
Feature: Verify COCO Medical Plan results

  Background: I go the login portal
    Given I open the login page on the "login" portal

@COCOFilterMedicalResultsWithSilverEnhanced @SLCR-85
Scenario Outline: This will verify the existence of the COCO Silver Enhanced metal filter and related medical plan results - SLCR-85
  # Only available during SES Open Enrollment - 2023 had this option available for 1 week due to enrollment max limits reached
  # SES plans appear when the income total is below 20K for each individual - or 10K if its a couple
  When I click create a new account on login page
  Then I click create my account from pre-screen page
  And I enter general mandatory data for "coco" account creation

  Then I validate I am on the "Login" page
  And  I enter valid credentials to login
  And I apply for the current year in CoCo

  Then I validate I am on the "Find Expert Help" page
  And I click Continue on my own button from Manage who helps you page

  Then I validate I am on the "CoCo Family Overview" page
  Then I click Primary EditUpdate on the Family Overview page
  And I click Go Back on the tell us about yourself page

  Then I validate I am on the "CoCo Family Overview" page
  And I verify button text Manage who helps you in "English"
  Then I click Manage who helps you on the Family Overview page

  Then I validate I am on the "Find Expert Help" page
  And I click Continue on my own button from Manage who helps you page

  Then I click Primary EditUpdate on the Family Overview page
  Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
  And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
  And I select "Yes" for mailing address option
  And I select "Yes" for live in Colorado option
  And I click continue on the Add info for yourself page
  And I select "I prefer not to answer" ethnicity option
  And I select "I prefer not to answer" race option
  And I click continue on the Ethnicity and race page
  And I select "Yes" employment option
  And I enter "1000000" income amount
  And I select "Annually" income frequency option
  And I select "No" income seasonal option
  And I select "No" income changes option
  And I click continue on the Employment income page
  And I select None of these as additional income option
  And I select continue on the Additional Income CoCO page

  Then I validate I am on the "CoCo Deductions" page
  And I select None of these as deductions option
  And I select continue on the Deductions CoCo page
  Then I select the projected income option "No" on Income Summary CoCo page
  And I select continue on the income Summary CoCo page

  Then I validate I am on the "CoCo Family Overview" page
  And I select continue on the Family Overview page

  Then I validate I am on the "CoCo life change event" page
  And I select "MoveToCO" life change event
  And I select continue on the LCE page

  Then I validate I am on the "CoCo Declarations and Signature" page
  And I enter a valid signature
  And I click Continue on the Declarations And Signature Page CoCo

  Then I validate I am on the "Application Results CoCo" page
  And I click Continue on the Application Results Page CoCo

  Then I validate I am on the "Start Shopping" page
  Then I click continue on start shopping page

  Then I validate I am on the "Medical Plan Results" page
  And I select the COCO Metal Tier dropdown
  And I select "<metalOption>" to filter for a  COCO Metal Tier plan
  And I validate the COCO plan option 1 has text "<metalPlanText>"
  And I click on Sign Out in the Header for "Elmo"
  Examples:
  |metalOption      |metalPlanText                                                       |
  |Silver Enhanced  |Anthem Colorado Option Silver Enhanced 94% Pathway Essentials Std   |
  |Bronze           |Elevate Health Plans Colorado Option Bronze                         |
  |Silver           |Elevate Health Plans Colorado Option Silver Off Exchange            |
  |Gold             |Elevate Health Plans Colorado Option Gold                           |



  @COCOFilterMedicalResults_SilverEnhanced_Only @SLCR-278
  Scenario Outline: This will validate the different SES carrier plan results after COCO filters are set for Silver Enhanced
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click Primary EditUpdate on the Family Overview page

    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "CoCo Ethnicity and Race" page
    And I select "I prefer not to answer" ethnicity option
    And I select "I prefer not to answer" race option
    And I click continue on the Ethnicity and race page

    Then I validate I am on the "CoCo Employment Income" page
    And I select "Yes" employment option
    And I enter "1000000" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select None of these as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "Marriage" life change event
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the COCO Metal Tier dropdown
    And I select Silver Enhanced option
    And I select the COCO Insurance Company dropdown
    And I select "<carrierOption>" to filter for desired COCO plan provider
    And I validate the COCO plan option 1 has text "<planText>"
    And I click on Sign Out in the Header for "Elmo"

    Examples:
      | carrierOption               | planText                                                                  |
      | Anthem                      | Anthem Colorado Option Silver Enhanced 94% Pathway Essentials Std         |
      | Cigna                       | Cigna Colorado Option Silver Enhanced 94%                                 |
      | Denver Health               | Elevate Health Plans Colorado Option Silver Off Exchange                  |
      | Kaiser Permanente           | KP Colorado Option Silver Enhanced 94% AV                                 |
      | Rocky Mountain Health Plan  | RMHP Colorado Doctors Plan Colorado Option Silver Enhanced 94% AV         |
      | Select Health               | Select Health Value Colorado Option Silver Off Exchange                   |

  @COCOVerifyPlanTotalSilverEnhanced @SLCR-273
  Scenario: This will verify the existence of the COCO Silver Enhanced metal filter and verify total available SES plans in area - CCRT-630
  # Only available during SES Open Enrollment - 2023 had this option available for 1 week due to enrollment max limits reached
  # Once established only a filter change like due to a filter change will change the result
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click Primary EditUpdate on the Family Overview page
    And I click Go Back on the tell us about yourself page

    Then I validate I am on the "CoCo Family Overview" page
    And I verify button text Manage who helps you in "English"
    Then I click Manage who helps you on the Family Overview page

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I click Primary EditUpdate on the Family Overview page
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "I prefer not to answer" ethnicity option
    And I select "I prefer not to answer" race option
    And I click continue on the Ethnicity and race page
    And I select "Yes" employment option
    And I enter "1000000" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select None of these as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate the plan totals are "24" on the COCO Medical Plan Results page
    And I select the COCO Metal Tier dropdown
    And I select Silver Enhanced option
    And I validate the SES plan totals are "6" on the COCO Medical Plan Results page
    Then I click on Sign Out in the Header for "Elmo"




