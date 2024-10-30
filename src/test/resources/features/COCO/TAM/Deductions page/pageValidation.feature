@TAM @pageText @TamCoCo
Feature: Tests related to the Deductions page

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
    Then I click EditUpdate on Family Overview page for "Primay"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page

  @SLCR-378
  Scenario: SLCR-378 I want amount and frequency errors cleared on the Deductions page so that I don't see errors when I select an option - English
    #Step3
    And I select "Alimony" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "English" CoCo page
    Then I verify error for Deductions option with no frequency in "English" CoCo page
    #Step4
    Then I select "None of these" as deductions option
    And I select "Alimony" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step5
    And I select "Self-employment tax" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "English" CoCo page
    Then I verify error for Deductions option with no frequency in "English" CoCo page
    #Step6
    And I select "Self-employment tax" as deductions option
    And I select "Alimony" as deductions option
    And I select "Self-employment tax" as deductions option
    And I select "Alimony" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step7
    Then I select "None of these" as deductions option
    Then I select "Student loan" as deductions option
    And I select "Domestic production" as deduction option with "200.00" amount at "Monthly" frequency
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "English" CoCo page
    Then I verify error for Deductions option with no frequency in "English" CoCo page
    #Step8
    Then I select "None of these" as deductions option
    Then I select "Student loan" as deductions option
    Then I select "Domestic production" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Domestic production" as Deductions option with "200.00" amount at "3: Monthly" frequency CoCo page
    #Step9
    Then I select "None of these" as deductions option
    Then I select "Moving expenses" as deductions option
    And I select "School tuition" as deduction option with "1500.00" amount at "Annually" frequency
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "English" CoCo page
    Then I verify error for Deductions option with no frequency in "English" CoCo page
    Then I select "None of these" as deductions option
    Then I select "Moving expenses" as deductions option
    Then I select "School tuition" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "School tuition" as Deductions option with "1,500.00" amount at "1: Annually" frequency CoCo page
    #Step10
    Then I select "Moving expenses" as deductions option
    Then I select "School tuition" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step11
    Then I select "None of these" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    Then I select "None of these" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step12
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions no option in "English" CoCo page
    #Step13
    Then I select "HSA" as deductions option
    Then I verify no errors show for Deductions options CoCo page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-378
  Scenario: SLCR-378 I want amount and frequency errors cleared on the Deductions page so that I don't see errors when I select an option - Spanish
    And I change the language from header to "Spanish"
    #Step3
    And I select "Alimony" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "Spanish" CoCo page
    Then I verify error for Deductions option with no frequency in "Spanish" CoCo page
    #Step4
    Then I select "None of these" as deductions option
    And I select "Alimony" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step5
    And I select "Self-employment tax" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "Spanish" CoCo page
    Then I verify error for Deductions option with no frequency in "Spanish" CoCo page
    #Step6
    And I select "Self-employment tax" as deductions option
    And I select "Alimony" as deductions option
    And I select "Self-employment tax" as deductions option
    And I select "Alimony" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step7
    Then I select "None of these" as deductions option
    Then I select "Student loan" as deductions option
    And I select "Domestic production" as deduction option with "200.00" amount at "Mensualmente" frequency
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "Spanish" CoCo page
    Then I verify error for Deductions option with no frequency in "Spanish" CoCo page
    #Step8
    Then I select "None of these" as deductions option
    Then I select "Student loan" as deductions option
    Then I select "Domestic production" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Domestic production" as Deductions option with "200.00" amount at "3: Monthly" frequency CoCo page
    #Step9
    Then I select "None of these" as deductions option
    Then I select "Moving expenses" as deductions option
    And I select "School tuition" as deduction option with "1500.00" amount at "Anualmente" frequency
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "Spanish" CoCo page
    Then I verify error for Deductions option with no frequency in "Spanish" CoCo page
    Then I select "None of these" as deductions option
    Then I select "Moving expenses" as deductions option
    Then I select "School tuition" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "School tuition" as Deductions option with "1,500.00" amount at "1: Annually" frequency CoCo page
    #Step10
    Then I select "Moving expenses" as deductions option
    Then I select "School tuition" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step11
    Then I select "None of these" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    Then I select "None of these" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step12
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions no option in "Spanish" CoCo page
    #Step13
    Then I select "HSA" as deductions option
    Then I verify no errors show for Deductions options CoCo page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-387
  Scenario: SLCR-387 I want amount and frequency errors cleared on the Deductions page so that I don't see errors when I select an option - English
    #Step3
    Then I select "Self-employment retirement" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "English" CoCo page
    Then I verify error for Deductions option with no frequency in "English" CoCo page
    #Step4
    Then I select "None of these" as deductions option
    Then I select "Self-employment retirement" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step5
    Then I select "School tuition" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "English" CoCo page
    Then I verify error for Deductions option with no frequency in "English" CoCo page
    #Step6
    Then I select "School tuition" as deductions option
    Then I select "Self-employment retirement" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step7
    Then I select "None of these" as deductions option
    Then I select "Student loan" as deduction option with "2500.00" amount at "Annually" frequency
    Then I select "Alimony" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "English" CoCo page
    Then I verify error for Deductions option with no frequency in "English" CoCo page
    #Step8
    Then I select "None of these" as deductions option
    Then I select "Student loan" as deductions option
    Then I select "Alimony" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Student loan" as Deductions option with "2,500.00" amount at "1: Annually" frequency CoCo page
    #Step9
    Then I select "None of these" as deductions option
    Then I select "Pre-tax retirement" as deduction option with "25.00" amount at "Weekly" frequency
    Then I select "Domestic production" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "English" CoCo page
    Then I verify error for Deductions option with no frequency in "English" CoCo page
    Then I select "Pre-tax retirement" as deductions option
    Then I select "Domestic production" as deductions option
    Then I select "Pre-tax retirement" as deductions option
    Then I select "Domestic production" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Pre-tax retirement" as Deductions option with "25.00" amount at "5: Weekly" frequency CoCo page
    #Step10
    Then I select "Pre-tax retirement" as deductions option
    Then I select "Domestic production" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions no option in "English" CoCo page
    #Step11
    Then I select "None of these" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    Then I select "None of these" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step12
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions no option in "English" CoCo page
    #Step13
    Then I select "None of these" as deductions option
    Then I verify no errors show for Deductions options CoCo page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-388
  Scenario: SLCR-388 I want amount and frequency errors cleared on the Deductions page so that I don't see errors when I select an option - Spanish
    And I change the language from header to "Spanish"
    #Step3
    Then I select "Self-employment retirement" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "Spanish" CoCo page
    Then I verify error for Deductions option with no frequency in "Spanish" CoCo page
    #Step4
    Then I select "None of these" as deductions option
    Then I select "Self-employment retirement" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step5
    Then I select "School tuition" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "Spanish" CoCo page
    Then I verify error for Deductions option with no frequency in "Spanish" CoCo page
    #Step6
    Then I select "School tuition" as deductions option
    Then I select "Self-employment retirement" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step7
    Then I select "None of these" as deductions option
    Then I select "Student loan" as deduction option with "2500.00" amount at "Anualmente" frequency
    Then I select "Alimony" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "Spanish" CoCo page
    Then I verify error for Deductions option with no frequency in "Spanish" CoCo page
    #Step8
    Then I select "None of these" as deductions option
    Then I select "Student loan" as deductions option
    Then I select "Alimony" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Student loan" as Deductions option with "2,500.00" amount at "1: Annually" frequency CoCo page
    #Step9
    Then I select "None of these" as deductions option
    Then I select "Pre-tax retirement" as deduction option with "25.00" amount at "Semanalmente" frequency
    Then I select "Domestic production" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions option with no amount in "Spanish" CoCo page
    Then I verify error for Deductions option with no frequency in "Spanish" CoCo page
    Then I select "Pre-tax retirement" as deductions option
    Then I select "Domestic production" as deductions option
    Then I select "Pre-tax retirement" as deductions option
    Then I select "Domestic production" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Pre-tax retirement" as Deductions option with "25.00" amount at "5: Weekly" frequency CoCo page
    #Step10
    Then I select "Pre-tax retirement" as deductions option
    Then I select "Domestic production" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions no option in "Spanish" CoCo page
    #Step11
    Then I select "None of these" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    Then I select "None of these" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    #Step12
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Deductions" page
    Then I verify error for Deductions no option in "Spanish" CoCo page
    #Step13
    Then I select "None of these" as deductions option
    Then I verify no errors show for Deductions options CoCo page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page