Feature: As a Coco user on the “Tell us about yourself” page

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-663
  Scenario: ELIG-As a Coco user on the “Tell us about yourself” page I need to select a Relationship type for members on the account as well as have a relationship type automatically populate on additional pages in the application.[CCRT-62]
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "103 COCO DRIVE", "DENVER", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "103 COCO DRIVE", "DENVER", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Asian or Asian American" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
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
    Then I enter details on tell us about additional members of your household page with "Spouse", "03051989", "Female", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "103 COCO DRIVE", "DENVER", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Asian or Asian American" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
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
    Then I enter details on tell us about additional members of your household page with "DaughterOne", "04212013", "Female", and applying "Yes"
      | Primary:Child or Other dependent |
      | Spouse:Child or Other dependent |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "103 COCO DRIVE", "DENVER", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Asian or Asian American" for race and ethnicity for "DaughterOne"
    And I click continue on the Race and Ethnicity page
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

    Then I enter details on tell us about additional members of your household page with "DaughterTwo", "12222013", "Female", and applying "Yes"
      | Primary:Child or Other dependent |
      | Spouse:Child or Other dependent |
      |DaughterOne:Sibling             |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "103 COCO DRIVE", "DENVER", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Asian or Asian American" for race and ethnicity for "DaughterTwo"
    And I click continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I validate the auto-populated option in the relationship dropdown field on the Tell us About Yourself page
      | Spouse:Spouse |
      | DaughterOne:Parent or Guardian |
      | DaughterTwo:Parent or Guardian |


