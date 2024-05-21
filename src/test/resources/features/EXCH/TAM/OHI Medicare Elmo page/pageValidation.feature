@TAM
Feature: Page Validation-OHI Medicare Elmo Page

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
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Single" tax filing status
    And I select "No" to claim dependents
    And I click save and continue on tax status page
    And I change the C4 url to "Elmo Other Health Insurance Page"
    Then I select "Medicare" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    And I validate I am on the "Elmo Ohi Medicare" page

  @SLER-329 @PageValidationOhiMedicareElmo
  Scenario: SLER-329 I can see Medicare's standard errors consistently - English
    And I verify the "First Section" Medicare page data in "English"
    Then I click continue on the Elmo OHI Medicare page
    And I verify "Currently Eligible" error in "English" on the Medicare page
    Then I click "No" for currently eligible in Medicare question
    And I verify "Currently Eligible" error does not show for Medicare page

    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    And I verify the "Part A Section" Medicare page data in "English"
    Then I click continue on the Elmo OHI Medicare page
    And I verify "Part A Amount Required" error in "English" on the Medicare page
    And I verify "Part A" error in "English" on the Medicare page
    Then I enter Part A amount of "150.00"
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    And I verify "Part A" error does not show for Medicare page
    Then I enter Part A amount of "del"
    Then I click continue on the Elmo OHI Medicare page
    And I verify "Part A Amount Required" error in "English" on the Medicare page
    And I verify "Part A Date" error in "English" on the Medicare page
    Then I check checkbox for Part "A Don't Pay"
    Then I enter end date of end of current month for Medicare part "A"
    And I verify "Part A Amount Required" error does not show for Medicare page
    And I verify "Part A Date" error does not show for Medicare page

    Then I check checkbox for Part "A"
    Then I check checkbox for Part "B"
    And I verify the "Part B Section" Medicare page data in "English"
    Then I click continue on the Elmo OHI Medicare page
    And I verify "Part B" error in "English" on the Medicare page
    Then I click "Yes" for Part "B" insurance ending in 60 days in Medicare question
    And I verify "Part B" error does not show for Medicare page
    Then I click continue on the Elmo OHI Medicare page
    And I verify "Part B Date" error in "English" on the Medicare page
    Then I enter end date of end of current month for Medicare part "B"
    And I verify "Part B Date" error does not show for Medicare page

    And I click on Sign Out in the Header for "Elmo"


  @SLER-330 @PageValidationOhiMedicareElmo
  Scenario: SLER-330 I can see Medicare's standard errors consistently - Spanish
    And I change the language from header to "Spanish"
    And I validate I am on the "Spanish" page
    And I verify the "First Section" Medicare page data in "Spanish"
    Then I click continue on the Elmo OHI Medicare page
    And I verify "Currently Eligible" error in "Spanish" on the Medicare page
    Then I click "No" for currently eligible in Medicare question
    And I verify "Currently Eligible" error does not show for Medicare page

    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    And I verify the "Part A Section" Medicare page data in "Spanish"
    Then I click continue on the Elmo OHI Medicare page
    And I verify "Part A Amount Required" error in "Spanish" on the Medicare page
    And I verify "Part A" error in "Spanish" on the Medicare page
    Then I enter Part A amount of "150.00"
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    And I verify "Part A" error does not show for Medicare page
    Then I enter Part A amount of "del"
    Then I click continue on the Elmo OHI Medicare page
    And I verify "Part A Amount Required" error in "Spanish" on the Medicare page
    And I verify "Part A Date" error in "Spanish" on the Medicare page
    Then I check checkbox for Part "A Don't Pay"
    Then I enter end date of end of current month for Medicare part "A"
    And I verify "Part A Amount Required" error does not show for Medicare page
    And I verify "Part A Date" error does not show for Medicare page

    Then I check checkbox for Part "A"
    Then I check checkbox for Part "B"
    And I verify the "Part B Section" Medicare page data in "Spanish"
    Then I click continue on the Elmo OHI Medicare page
    And I verify "Part B" error in "Spanish" on the Medicare page
    Then I click "Yes" for Part "B" insurance ending in 60 days in Medicare question
    And I verify "Part B" error does not show for Medicare page
    Then I click continue on the Elmo OHI Medicare page
    And I verify "Part B Date" error in "Spanish" on the Medicare page
    Then I enter end date of end of current month for Medicare part "B"
    And I verify "Part B Date" error does not show for Medicare page


    And I click on Sign Out in the Header for "Elmo"
