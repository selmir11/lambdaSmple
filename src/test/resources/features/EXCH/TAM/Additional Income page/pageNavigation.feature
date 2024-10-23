@TAM @TamExch
Feature: Page Navigation-Additional Income Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-686 @PageNavigationAdditionalIncomePage @TAMSmoke
  Scenario: SLER-686 The 'Find Expert Assistance' link stops working when navigate back to the error and unauthorized pages in Income Portal, Exchange
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
    #Step1
    Then I validate I am on the "Additional income" page
    And I change the C4 url to "Income portal Error Exch"
    Then I validate I am on the "Error" page
    And I click Back to Welcome page Button on error Exch page
    Then I click Go Back button from chrome browser
    And I verify User name Link is displayed in the "Exch" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page
    #Step2
    And I click on Apply for Coverage in the "ExpertHelp" Header
    Then I validate I am on the "Account Overview" page
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
    Then I click on the Member Row 0
    Then I select the Edit Income link
    And I click continue on the Employment Info Page

    Then I validate I am on the "Additional income" page
    And I change the C4 url to "Income portal Unauthorized Exch"
    And I click on Apply for Coverage in the "Elmo" Header
    Then I click Go Back button from chrome browser
    And I verify User name Link is displayed in the "Exch" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page

    And I click on Sign Out in the Header for "WhoHelpsYouPage"
    Then I validate I am on the "Login" page