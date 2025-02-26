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

  @SLER-1903 @PageNavigationEmploymentIncome @TAMSmoke
  Scenario: SLER-1903 NR Bug (exch): TypeError
#    Step 1
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    And I enter self-employment details with "54000.00" income at "Annually" frequency and "Yes" to same or lower
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page
#    Step 2
    Then I click Edit on Income Summary row 1
    And I select the option "No" to self employment
    And I enter employment details with "1300000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page
#    Step 3
    Then I click Edit on Income Summary row 1
    And I select the option "Yes" to self employment
    And I enter self-employment details with "54000.00" income at "Annually" frequency and "Yes" to same or lower
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2065
  Scenario: SLER-2065 I want to be directed to the unauthorized page so that I know I have tried to access a page I am not authorized to access
#    check in English and change to Spanish
    Then I validate Employment Info Page header in "English"
    And I change the C4 url to "Employment Income Unauthorized Exch"
    Then I validate I am on the "Unauthorized" page
    Then I verify unauthorized text in "English"
    And I verify text on the "Exch" "Header" in "English"
    And I verify text on the "Exch" "Footer" in "English"
    And I set the browser resolution to 1200 x 800
    And I change the language from header to "Spanish"
    And I set the browser resolution to Maximized
    Then I wait for 50 milliseconds
    Then I verify unauthorized text in "Spanish"
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
#    check in Spanish and change to English
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I validate I am on the "Employment Income" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate Employment Info Page header in "Spanish"
    And I change the C4 url to "Employment Income Unauthorized Exch"
    Then I validate I am on the "Unauthorized" page
    Then I verify unauthorized text in "Spanish"
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I set the browser resolution to 1200 x 800
    And I change the language from header to "English"
    And I set the browser resolution to Maximized
    Then I wait for 50 milliseconds
    Then I verify unauthorized text in "English"
    And I verify text on the "Exch" "Header" in "English"
    And I verify text on the "Exch" "Footer" in "English"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page


  @SLER-2076
  Scenario Outline: SLER-2076 ELIG-Self-employment income-Page Text [RT-997]
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    And I change the language from Elmo header to "<Language>" if it isn't already in that language
    Then I validate the Net Income Frequency Dropdown Menu in "<Language>"
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

    Examples:
    |Language|
    |English|
    |Spanish|