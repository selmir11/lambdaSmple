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
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
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

  @SLCR-379
  Scenario: SLCR-379 I want amount and frequency errors cleared on the Deductions page so that I don't see errors when I select an option - Spanish
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

  @SLCR-395
  Scenario: SLCR-395 I verify that income-portal-ui uses common components from ng-common on the Deductions page in COCO
    Then I verify Deductions checkbox COCO in "Not Selected" state
    Then I verify Deductions checkbox COCO in "Selected" state
    Then I verify Deductions checkbox COCO in "Focus" state
    Then I verify Deductions checkbox COCO in "Hover" state

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

    @SLCR-799
  Scenario: SLCR-799 - As CoCo user on the ELMO Income pages, I verify errors cleared on the Deductions page so that I don't see errors when I select an option[CCRT-728]
    And I select continue on the Deductions CoCo page
    Then I verify error for Deductions no option in "English" CoCo page
    And I select "Alimony" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    And I select "Alimony" as deductions option
    And I select continue on the Deductions CoCo page
    Then I verify error for Deductions no option in "English" CoCo page
    Then I select "None of these" as deductions option
    Then I verify no errors show for Deductions options CoCo page
    And I select "Domestic production" as deductions option
    And I select continue on the Deductions CoCo page
    Then I verify error for Deductions option with no amount in "English" CoCo page
    Then I verify error for Deductions option with no frequency in "English" CoCo page
    And I select "Domestic production" as deductions option
    And I select "Domestic production" as deduction option with "200.00" amount at "Monthly" frequency
    And I select "School tuition" as deduction option with "1500.00" amount at "Annually" frequency
    Then I select "Student loan" as deduction option with "2500.00" amount at "Annually" frequency
    Then I verify no errors show for Deductions options CoCo page
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-819 
  Scenario: SLCR-819 As COCO user, I want to see the ELMO Deductions page
  so that I can enter my deduction information [CCRT-537]
    #Step1
    And I select continue on the Deductions CoCo page
    Then I verify the header for Primary Member on the CoCo Deductions page in "English"
    Then I verify User name Link is displayed in the "CoCo" Header
    And I verify text on the "CoCo" "Header" in "English"
    Then I validate I am on the "CoCo Deductions" page
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page
    #Step2
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    And  I click on Go Back on income summary page
    Then I validate I am on the "Deductions" page
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page
    #Step3
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
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
