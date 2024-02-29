Feature: Page Text-Income Opt Out Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-57 @PageTextIncomeOptOutPage
  Scenario: I can review and update the income information in English and Spanish
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
    And I am a member with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Find Expert Help page
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
    And I click continue on the Citizenship page
    Then I click continue on family overview page

    And I verify text on the "Exch" "Header" in "English"
    And I verify the "English" text on the Income Opt Out page
    And I click on financial help link within text
    And I validate I am on the "Financial Help" page and close tab
    And I verify text on the "Exch" "Footer" in "English"
    And I change the language from header to "Spanish"
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify the "Spanish" text on the Income Opt Out page
    And I click on financial help link within text
    And I validate I am on the "Financial Help" page and close tab
    And I verify text on the "Exch" "Footer" in "Spanish"

    And I click on Sign Out in the Header
    Then I validate I am on the "Login" page