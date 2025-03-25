@TAM @TamExch
Feature: Page Text-Income Opt Out Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
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
    And I validate I am on the "Employment Income" page
    Then I select the option "No" to employment

  @SLER-2348
  Scenario: As an Exchange user,I want to see my Income and Deductions so that I can review my financial information[RT-2607]
    And I click continue on the Employment Info Page
    And I select None of these as additional income option
    And I click continue on the Additional Income page
    And I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I verify page Header text in income summary page
    Then I validate font colour height and format of text in income summary page
    And I click on Go Back on income summary page
    When I click on Go Back button in deductions page
    And I select "Cash Support" as additional income option with "45.02" amount at "Annually" frequency
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I verify added income name "Cash Support" and amount "$45.02" in income summary page
    When I click on "edit_income_button" in income summary page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "101 park street" and city as "Denver" and state as "CO" and zipcode as "80205" and income "1250000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    Then I validate income amounts "$12,500.00" and "$45.02" in income summary page
    When I click on "edit_income_button" in income summary page
    Then I click on Add job or self-employment on the Employment Summary Page
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "102 park street" and city as "Denver" and state as "CO" and zipcode as "80205" and income "1842500" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I click continue on the Employment Summary Page
    And I click continue on the Additional Income page
    And I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    Then I validate income amounts "$12,500.00" "$18,425.00" and "$45.02" in income summary page
    When I click on "edit_deductions_button" in income summary page
    And I select "Alimony" as deduction option with "485.00" amount at "Annually" frequency
    And I click continue on the Deductions page
    Then I validate deduction amount "$485.00" along with income amounts "$12,500.00" "$18,425.00" and "$45.02"
    Then I validate income and deduction calculations
    And I click on Go Back on income summary page
    When I click on Go Back button in deductions page
    Then I click on the Back button on the Additionalincomepage
    When I click on Go Back button in employment summary page
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "09051959", "Female" and applying "No"
      |Primary:Spouse|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Spouse"
    And I click the edit income icon on household page for "Spouse"
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    And I select None of these as additional income option
    And I click continue on the Additional Income page
    And I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I verify spouse name in income summary page
    Then I validate font colour height and format of text in income summary page
