@TAM @TamExch
Feature: Page Text-Deductions Page

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
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page

  @SLER-930 @HelpDrawerDeductionsPage
  Scenario: SLER-930 Validate help drawer text on the Deductions page - English
    And I set the browser resolution to 1536 x 864
    And I select "Help me understand" icon on the Deductions Page
    Then I validate Deductions help drawer "Full" verbiage in "English"
    Then I click on "Alimony paid out" link in Help Drawer on the Deductions page
    And I validate I am on the "Alimony paid out" page and close tab
    Then I click on "Domestic production activities" link in Help Drawer on the Deductions page
    And I validate I am on the "Domestic production activities" page and close tab
    Then I click on "Pre-tax retirement contribution" link in Help Drawer on the Deductions page
    And I validate I am on the "Pre-tax retirement contribution" page and close tab
    Then I click on "School tuition" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition" page and close tab
    Then I click on "School tuition: Self-Employed 1" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Self-Employed 1" page and close tab
    Then I click on "School tuition: Self-Employed 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Self-Employed 2" page and close tab
    Then I click on "School tuition: Armed Forces 1" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Armed Forces 1" page and close tab
    Then I click on "School tuition: Armed Forces 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Armed Forces 2" page and close tab
    Then I click on "School tuition: Disability 1" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Disability 1" page and close tab
    Then I click on "School tuition: Disability 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Disability 2" page and close tab
    Then I click on "Self-employment tax" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-employment tax" page and close tab
    Then I click on "Student Loan Interest" link in Help Drawer on the Deductions page
    And I validate I am on the "Student Loan Interest" page and close tab
    Then I click on "Self-employment Health Insurance" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-employment Health Insurance" page and close tab
    Then I click on "Self-Employment Retirement Plan" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-Employment Retirement Plan" page and close tab
    Then I click on "Moving Expenses" link in Help Drawer on the Deductions page
    And I validate I am on the "Moving Expenses" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Help me understand" icon on the Deductions Page

    And I select "side help" icon on the Deductions Page
    Then I validate Deductions help drawer "Full" verbiage in "English"
    Then I click on "Alimony paid out" link in Help Drawer on the Deductions page
    And I validate I am on the "Alimony paid out" page and close tab
    Then I click on "Domestic production activities" link in Help Drawer on the Deductions page
    And I validate I am on the "Domestic production activities" page and close tab
    Then I click on "Pre-tax retirement contribution" link in Help Drawer on the Deductions page
    And I validate I am on the "Pre-tax retirement contribution" page and close tab
    Then I click on "School tuition" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition" page and close tab
    Then I click on "School tuition: Self-Employed 1" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Self-Employed 1" page and close tab
    Then I click on "School tuition: Self-Employed 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Self-Employed 2" page and close tab
    Then I click on "School tuition: Armed Forces 1" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Armed Forces 1" page and close tab
    Then I click on "School tuition: Armed Forces 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Armed Forces 2" page and close tab
    Then I click on "School tuition: Disability 1" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Disability 1" page and close tab
    Then I click on "School tuition: Disability 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Disability 2" page and close tab
    Then I click on "Self-employment tax" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-employment tax" page and close tab
    Then I click on "Student Loan Interest" link in Help Drawer on the Deductions page
    And I validate I am on the "Student Loan Interest" page and close tab
    Then I click on "Self-employment Health Insurance" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-employment Health Insurance" page and close tab
    Then I click on "Self-Employment Retirement Plan" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-Employment Retirement Plan" page and close tab
    Then I click on "Moving Expenses" link in Help Drawer on the Deductions page
    And I validate I am on the "Moving Expenses" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "close help" icon on the Deductions Page

    And I select "Alimony paid out" icon on the Deductions Page
    Then I validate Deductions help drawer "Alimony paid out" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Alimony paid out" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Alimony paid out" icon on the Deductions Page

    And I select "Domestic production activities" icon on the Deductions Page
    Then I validate Deductions help drawer "Domestic production activities" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Domestic production activities" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Domestic production activities" icon on the Deductions Page

    And I select "Health Savings Account contribution" icon on the Deductions Page
    Then I validate Deductions help drawer "Health Savings Account contribution" verbiage in "English"
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Health Savings Account contribution" icon on the Deductions Page

    And I select "Pre-tax retirement contribution" icon on the Deductions Page
    Then I validate Deductions help drawer "Pre-tax retirement contribution" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Pre-tax retirement contribution" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Pre-tax retirement contribution" icon on the Deductions Page

    And I select "School tuition" icon on the Deductions Page
    Then I validate Deductions help drawer "School tuition" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition" page and close tab
    Then I click on "Item 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Self-Employed 1" page and close tab
    Then I click on "Item 3" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Self-Employed 2" page and close tab
    Then I click on "Item 4" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Armed Forces 1" page and close tab
    And I set the browser resolution to Maximized
    Then I click on "Item 5" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Armed Forces 2" page and close tab
    Then I click on "Item 6" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Disability 1" page and close tab
    Then I click on "Item 7" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Disability 2" page and close tab
    And I set the browser resolution to 1536 x 864
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "School tuition" icon on the Deductions Page

    And I select "Self-employment tax" icon on the Deductions Page
    Then I validate Deductions help drawer "Self-employment tax" verbiage in "English"
    And I set the browser resolution to Maximized
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-employment tax" page and close tab
    And I set the browser resolution to 1536 x 864
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Self-employment tax" icon on the Deductions Page

    And I select "Student Loan Interest" icon on the Deductions Page
    Then I validate Deductions help drawer "Student Loan Interest" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Student Loan Interest" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Student Loan Interest" icon on the Deductions Page

    And I select "Self-employment Health Insurance" icon on the Deductions Page
    Then I validate Deductions help drawer "Self-employment Health Insurance" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-employment Health Insurance" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Self-employment Health Insurance" icon on the Deductions Page

    And I select "Self-employment Retirement Plan" icon on the Deductions Page
    Then I validate Deductions help drawer "Self-employment Retirement Plan" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-Employment Retirement Plan" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Self-employment Retirement Plan" icon on the Deductions Page

    And I select "Moving Expenses" icon on the Deductions Page
    Then I validate Deductions help drawer "Moving Expenses" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Moving Expenses" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Moving Expenses" icon on the Deductions Page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-931 @HelpDrawerDeductionsPage
  Scenario: SLER-931 Validate help drawer text on the Deductions page - Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I validate I am on the "Spanish" page
    And I select "Help me understand" icon on the Deductions Page
    Then I validate Deductions help drawer "Full" verbiage in "Spanish"
    Then I click on "Alimony paid out" link in Help Drawer on the Deductions page
    And I validate I am on the "Alimony paid out" page and close tab
    Then I click on "Domestic production activities" link in Help Drawer on the Deductions page
    And I validate I am on the "Domestic production activities" page and close tab
    Then I click on "Pre-tax retirement contribution" link in Help Drawer on the Deductions page
    And I validate I am on the "Pre-tax retirement contribution" page and close tab
    Then I click on "School tuition" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition" page and close tab
    Then I click on "School tuition: Self-Employed 1" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Self-Employed 1" page and close tab
    Then I click on "School tuition: Self-Employed 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Self-Employed 2" page and close tab
    Then I click on "School tuition: Armed Forces 1" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Armed Forces 1" page and close tab
    Then I click on "School tuition: Armed Forces 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Armed Forces 2" page and close tab
    Then I click on "School tuition: Disability 1" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Disability 1" page and close tab
    Then I click on "School tuition: Disability 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Disability 2" page and close tab
    Then I click on "Self-employment tax" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-employment tax" page and close tab
    Then I click on "Student Loan Interest" link in Help Drawer on the Deductions page
    And I validate I am on the "Student Loan Interest" page and close tab
    Then I click on "Self-employment Health Insurance" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-employment Health Insurance" page and close tab
    Then I click on "Self-Employment Retirement Plan" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-Employment Retirement Plan" page and close tab
    Then I click on "Moving Expenses" link in Help Drawer on the Deductions page
    And I validate I am on the "Moving Expenses" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Help me understand" icon on the Deductions Page

    And I select "side help" icon on the Deductions Page
    Then I validate Deductions help drawer "Full" verbiage in "Spanish"
    Then I click on "Alimony paid out" link in Help Drawer on the Deductions page
    And I validate I am on the "Alimony paid out" page and close tab
    Then I click on "Domestic production activities" link in Help Drawer on the Deductions page
    And I validate I am on the "Domestic production activities" page and close tab
    Then I click on "Pre-tax retirement contribution" link in Help Drawer on the Deductions page
    And I validate I am on the "Pre-tax retirement contribution" page and close tab
    Then I click on "School tuition" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition" page and close tab
    Then I click on "School tuition: Self-Employed 1" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Self-Employed 1" page and close tab
    Then I click on "School tuition: Self-Employed 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Self-Employed 2" page and close tab
    Then I click on "School tuition: Armed Forces 1" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Armed Forces 1" page and close tab
    Then I click on "School tuition: Armed Forces 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Armed Forces 2" page and close tab
    Then I click on "School tuition: Disability 1" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Disability 1" page and close tab
    Then I click on "School tuition: Disability 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Disability 2" page and close tab
    Then I click on "Self-employment tax" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-employment tax" page and close tab
    Then I click on "Student Loan Interest" link in Help Drawer on the Deductions page
    And I validate I am on the "Student Loan Interest" page and close tab
    Then I click on "Self-employment Health Insurance" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-employment Health Insurance" page and close tab
    Then I click on "Self-Employment Retirement Plan" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-Employment Retirement Plan" page and close tab
    Then I click on "Moving Expenses" link in Help Drawer on the Deductions page
    And I validate I am on the "Moving Expenses" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "close help" icon on the Deductions Page

    And I select "Alimony paid out" icon on the Deductions Page
    Then I validate Deductions help drawer "Alimony paid out" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Alimony paid out" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Alimony paid out" icon on the Deductions Page

    And I select "Domestic production activities" icon on the Deductions Page
    Then I validate Deductions help drawer "Domestic production activities" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Domestic production activities" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Domestic production activities" icon on the Deductions Page

    And I select "Health Savings Account contribution" icon on the Deductions Page
    Then I validate Deductions help drawer "Health Savings Account contribution" verbiage in "Spanish"
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Health Savings Account contribution" icon on the Deductions Page

    And I select "Pre-tax retirement contribution" icon on the Deductions Page
    Then I validate Deductions help drawer "Pre-tax retirement contribution" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Pre-tax retirement contribution" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Pre-tax retirement contribution" icon on the Deductions Page

    And I select "School tuition" icon on the Deductions Page
    Then I validate Deductions help drawer "School tuition" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition" page and close tab
    Then I click on "Item 2" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Self-Employed 1" page and close tab
    Then I click on "Item 3" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Self-Employed 2" page and close tab
    Then I click on "Item 4" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Armed Forces 1" page and close tab
    Then I click on "Item 5" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Armed Forces 2" page and close tab
    Then I click on "Item 6" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Disability 1" page and close tab
    Then I click on "Item 7" link in Help Drawer on the Deductions page
    And I validate I am on the "School tuition: Disability 2" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "School tuition" icon on the Deductions Page

    And I select "Self-employment tax" icon on the Deductions Page
    Then I validate Deductions help drawer "Self-employment tax" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-employment tax" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Self-employment tax" icon on the Deductions Page

    And I select "Student Loan Interest" icon on the Deductions Page
    Then I validate Deductions help drawer "Student Loan Interest" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Student Loan Interest" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Student Loan Interest" icon on the Deductions Page

    And I select "Self-employment Health Insurance" icon on the Deductions Page
    Then I validate Deductions help drawer "Self-employment Health Insurance" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-employment Health Insurance" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Self-employment Health Insurance" icon on the Deductions Page

    And I select "Self-employment Retirement Plan" icon on the Deductions Page
    Then I validate Deductions help drawer "Self-employment Retirement Plan" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Self-Employment Retirement Plan" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Self-employment Retirement Plan" icon on the Deductions Page

    And I select "Moving Expenses" icon on the Deductions Page
    Then I validate Deductions help drawer "Moving Expenses" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Deductions page
    And I validate I am on the "Moving Expenses" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Deductions page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Moving Expenses" icon on the Deductions Page

    And I click on Sign Out in the Header for "Elmo"









