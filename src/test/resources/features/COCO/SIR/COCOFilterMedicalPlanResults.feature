@@SIR @COCO @COCOMedicalResults
Feature: Verify COCO Medical Plan results

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @COCOFilterMedicalResults_NoSilver @SLCR-84
  Scenario Outline: SLCR-84 - This will verify the COCO filters provide a correct medical plan result - this is a merge of CCRT-389 to SCLR-84
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

    And I select "I prefer not to answer" ethnicity option
    And I select "I prefer not to answer" race option
    And I click continue on the Ethnicity and race page

    And I select "Yes" employment option
    And I enter "30,000.00" income amount
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
    And I select the COCO Insurance Company dropdown
    And I select "<carrierOption>" to filter for desired COCO plan provider
    And I validate the COCO plan option 1 has text "<planText>"
    And I click on Sign Out in the Header for "Elmo"
    Examples:
      | carrierOption               | planText                                                                  |
      | Anthem                      | Anthem Colorado Option Silver Enhanced 94% Pathway Essentials Std         |
      | Cigna                       | Cigna Connect Colorado Option Silver Enhanced Off Exchange                |
      | Denver Health               | Elevate Health Plans Colorado Option Silver Enhanced Off Exchange         |
      | Kaiser Permanente           | KP Colorado Option Silver Enhanced 94% AV                                 |
      | Rocky Mountain Health Plan  | RMHP Colorado Doctors Plan Colorado Option Silver Enhanced 94%            |
      | Select Health               | Select Health Value Colorado Option Silver Enhanced 94% Off Exchange      |

  @SLCR-284 @CoCo_RegressionTest
  Scenario: This will verify the hyperlink text in COCO Medical plan page
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

    And I select "I prefer not to answer" ethnicity option
    And I select "I prefer not to answer" race option
    And I click continue on the Ethnicity and race page

    And I select "Yes" employment option
    And I enter "30,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select None of these as deductions option
    And I select continue on the Deductions CoCo page

    And I select the No projected Income button on the Income Summary page
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
    And Verify "Learn more about these ratings." hyperlink present in coco Medical Plan Results page and navigates to "https://www.healthcare.gov/quality-ratings/"
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And Verify "Obtenga más información sobre estas calificaciones." hyperlink present in coco Medical Plan Results page and navigates to "https://www.cuidadodesalud.gov/es/quality-ratings/"
    And I click on Sign Out in the Header for "Elmo"







