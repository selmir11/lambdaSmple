@TAM @pageValidation @TamCoCo
Feature: Tests related to the Employment Income page

  Background: I go to the login portal
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page

  @SLCR-781
  Scenario: SLCR-781 As a CoCo user on the Employment Income page, I want to save dynamic data so that I can verify my employment information
    # Scenario 1
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select Go Back on the Additional Income CoCo page
    Then I validate I am on the "CoCo Employment Income" page
    Then I validate the Individual Income Opt Out in DB is "1"
    # Scenario 5
    And I select "Yes" employment option
    And I enter "8244.88" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "Yes" income changes option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select Go Back on the Additional Income CoCo page
    Then I validate I am on the "CoCo Employment Income" page
    Then I validate the Individual Income Opt Out in DB is "0"
    Then I validate the CoCo Individual Income values in DB
      |  amount   |   period   | season_comm_tip_ind  |season_comm_tip_samelower_ind|
      |  8244.88  |  Annually  |          0           |             1               |
    # Scenario 3
    And I enter "824.48" income amount
    And I select "Monthly" income frequency option
    And I select "Yes" income seasonal option
    And I select "Yes" income changes option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select Go Back on the Additional Income CoCo page
    Then I validate I am on the "CoCo Employment Income" page
    Then I validate the Individual Income Opt Out in DB is "0"
    Then I validate the CoCo Individual Income values in DB
      |  amount   |   period   | season_comm_tip_ind  |season_comm_tip_samelower_ind|
      |  824.48   |  Monthly   |          1           |             1               |
    # Scenario 4
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select Go Back on the Additional Income CoCo page
    Then I validate I am on the "CoCo Employment Income" page
    Then I validate the Individual Income Opt Out in DB is "1"
    # Scenario 2
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I select "Yes" employment option
    And I enter "824.48" income amount
    And I select "Monthly" income frequency option
    And I select "Yes" income seasonal option
    And I select "Yes" income changes option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select Go Back on the Additional Income CoCo page
    Then I validate I am on the "CoCo Employment Income" page
    Then I validate the Individual Income Opt Out in DB is "0"
    Then I validate the CoCo Individual Income values in DB
      |  amount   |   period   | season_comm_tip_ind  |season_comm_tip_samelower_ind|
      |  824.48   |  Monthly   |          1           |             1               |

  @SLCR-871
  Scenario: SLCR-871 As a CoCo user on the Employment Income details page, I want to be able to save, update and remove my employment income details so that my employment income info is available and accurate
#    Step 3
    And I select "No" employment option
    And I click continue on the Employment income page
#    Step 4
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    And I select Go Back on the Additional Income CoCo page
    And I verify the header for Primary Member on the CoCo Employment income page in "English"
    Then I validate "No" job option is selected on the Employment income page
#    Step 5
    And I select "Yes" employment option
    And I enter "2000000" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
#    Step 6
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    And I select Go Back on the Additional Income CoCo page
    And I verify the header for Primary Member on the CoCo Employment income page in "English"
    And I verify selected data on the CoCo Employment Income data
      |HaveJob|IncomeAmt|IncomeFrequency|Seasonal|IncomeChange|
      |Yes    |20,000.00|1: Annually    |No      |No          |
#    Step 7
    And I enter "100000" income amount
    And I select "Monthly" income frequency option
    And I select "Yes" income seasonal option
    And I select "Yes" income changes option
    And I click continue on the Employment income page
#    Step 8
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for Primary Member on the CoCo Additional Income page in "English"
    And I select Go Back on the Additional Income CoCo page
    And I verify the header for Primary Member on the CoCo Employment income page in "English"
    And I verify selected data on the CoCo Employment Income data
      |HaveJob|IncomeAmt|IncomeFrequency|Seasonal|IncomeChange|
      |Yes    |1,000.00 |3: Monthly     |Yes     |Yes         |
    And I click continue on the Employment income page
#    Step 9
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Spouse", "03051989", "Male", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Wife"
    And I click save and continue on the Race and Ethnicity page
#    Step 10
    Then I verify the header for additional member on the CoCo Employment income page in "English"
    Then I validate "Do you have a job" option has no selection on the Employment income page
#    Step 11
    And I select "Yes" employment option
    Then I validate "total income" option has no selection on the Employment income page
    Then I validate "seasonal" option has no selection on the Employment income page
    Then I validate "income change" option has no selection on the Employment income page
    And I enter "2585000" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "Yes" income changes option
    And I click continue on the Employment income page
#    Step 12
    Then I validate I am on the "CoCo Additional Income" page
    And I verify the header for additional member on the CoCo Additional Income page in "English"
    And I select Go Back on the Additional Income CoCo page
    Then I validate I am on the "CoCo Employment Income" page
    And I verify the header for additional member on the CoCo Employment income page in "English"
    And I verify selected data on the CoCo Employment Income data
      |HaveJob|IncomeAmt|IncomeFrequency|Seasonal|IncomeChange|
      |Yes    |25,850.00|1: Annually    |No      |Yes         |

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page