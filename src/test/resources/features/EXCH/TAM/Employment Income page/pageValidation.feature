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

  @SLER-2339
  Scenario: SLER-2339-ELIG-Self-employment income-Page Validation-English (RT-1202)
    Then I Verify the page text on Employment Income page, which is in initial state
      | Income:                                          |
      | Employment Income                                |
      | Do you have a job or are you currently employed? |
      | Yes                                              |
      | No                                               |
      | Go back                                          |
      | Save and continue                                |
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    Then I click on company Name input field and click out of it
    Then I verify the company name error message "Employer name is required"
    And I refresh the page
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    And I click continue on the Employment Info Page
    Then I verify the company name error message "Employer name is required"
    Then I enter the value "s" in company name input field
    Then I verify the company name error message "Employer name must be at least 2 characters long"
    Then I enter the value of 110 characters in Company Name Input field and validate that it does not accept the characters more than 100
    Then I enter the value "Rockwell Ltd" in company name input field
    And I verify no errors show for company name field
    And I refresh the page
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    Then I click on company Name input field and click out of it
    Then I click on enter profit input field and click out of it
    Then I verify the Enter profit amount error message "Amount is required"
    And I refresh the page
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    Then I click on company Name input field and click out of it
    Then I click on enter profit input field and click out of it
    And I click continue on the Employment Info Page
    Then I verify the Enter profit amount error message "Amount is required"
    And I edit the income level to "3249587435348754394.987324"
    Then I verify the Enter profit amount error message "Amount is required"
    And I edit the income level to "324958SAD@"
    Then I verify the income gets converted to "3,249.58"
    And I edit the income level to "561332.78"
    And I verify no errors show for Enter profit Income field
    Then I enter the value "Rockwell Ltd" in company name input field
    And I click continue on the Employment Info Page
    Then I verify the income frequency type error message "Please select one of the options below"
    Then I verify the Income same or Lower question error message "Please select one of the options below"
    And I enter self-employment details with "101.58" income at "Weekly" frequency and "No" to same or lower
    And I verify no errors show for Income frequency field and Income same or lower question field
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2342
  Scenario: SLER-2342-ELIG-Self-employment income-Page Validation-Spanish (RT-1202)
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I Verify the page text on Employment Income page, which is in initial state
      | Ingresos:                               |
      | Ingresos por empleo                     |
      | ¿Tiene un trabajo o empleo actualmente? |
      | Sí                                      |
      | No                                      |
      | Volver                                  |
      | Guardar y continuar                     |
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    Then I click on company Name input field and click out of it
    Then I verify the company name error message "Se requiere el nombre del empleador"
    And I refresh the page
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    And I click continue on the Employment Info Page
    Then I verify the company name error message "Se requiere el nombre del empleador"
    Then I enter the value "s" in company name input field
    Then I verify the company name error message "El nombre del empleador debe tener al menos 2 caracteres"
    Then I enter the value of 110 characters in Company Name Input field and validate that it does not accept the characters more than 100
    Then I enter the value "Rockwell Ltd" in company name input field
    And I verify no errors show for company name field
    And I refresh the page
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    Then I click on company Name input field and click out of it
    Then I click on enter profit input field and click out of it
    Then I verify the Enter profit amount error message "Esta cantidad es obligatoria"
    And I refresh the page
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    Then I click on company Name input field and click out of it
    Then I click on enter profit input field and click out of it
    And I click continue on the Employment Info Page
    Then I verify the Enter profit amount error message "Esta cantidad es obligatoria"
    And I edit the income level to "3249587435348754394.987324"
    Then I verify the Enter profit amount error message "Esta cantidad es obligatoria"
    And I edit the income level to "324958SAD@"
    Then I verify the income gets converted to "3,249.58"
    And I edit the income level to "561332.78"
    And I verify no errors show for Enter profit Income field
    Then I enter the value "Rockwell Ltd" in company name input field
    And I click continue on the Employment Info Page
    Then I verify the income frequency type error message "Seleccione una de las siguientes opciones"
    Then I verify the Income same or Lower question error message "Seleccione una de las siguientes opciones"
    And I enter self-employment details with "101.58" income at "Semanalmente" frequency and "No" to same or lower
    And I verify no errors show for Income frequency field and Income same or lower question field
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2341
  Scenario: SLER-2341 ELIG-Employment Income-Page Validation (not self-employment)
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I click continue on the Employment Info Page
    Then I verify page header in English in Employment Income page
      |Income: |
      |Employment Income|
    Then I validate All error message colour and text in Employment Income page
      |Employer name is required|
      |Street address is required|
      |City is required|
      |State is required|
      |ZIP Code is required|
      |Amount is required|
      |Please select one of the options below|
    Then I validate max length of each text field in Employment Income page
    #And I select the option "Yes" to self employment
    #And I select the option "No" to self employment
    And I refresh the page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I validate zip code and include commission text box field
    Then I verify the income frequency dropdown allows single selection
    Then I validate functionality of "Is this income part of seasonal" question
    Then I validate functionality of "Will this income be the same" question