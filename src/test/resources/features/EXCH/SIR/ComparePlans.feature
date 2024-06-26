Feature: Medical Plan Results page related tests

  Background:
    When I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    When  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    When I apply for the current year
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    When I click on Before you begin continue with application button
    Then I select "MovedToColorado"
    And I click Continue button on Report a Life Change Page
    Then I validate I am on the "Who Are You" page
    When I select "member" from the who are you question
    And I enter details with city "Denver", state "CO", dob "10011980", county "DENVER" and zipcode "80205"
    And I click the who are you save and continue button
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    When I select first option to all Id proofing questions
    And I click Member ID Proofing continue button
    Then I validate I am on the "Identify Proofing - Congratulations" page
    When I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    When I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "Tell us about yourself" page
    When I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    When I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Citizenship" page
    When I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    When I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    When I continue without financial help
    Then I validate I am on the "Tell us about life changes" page
    When I select "Birth" QLCE on tell us about life changes page
    And I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    When I sign as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    Then I validate I am on the "Application History" page
    And I wait for hold on content to disappear
    When I click on view results and shop
    Then I validate I am on the "Application Results" page
    When I click continue on application results page
    Then I validate I am on the "Start Shopping" page

  @SLER-80 @CompareDentalPlansLink
  Scenario: Validate the Navigation and Functionality of Compare Plans Link (Dental)
    When I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    When I select the first medical plan
    And I click continue on medical plan results page
    Then I validate I am on the "Dental Plan Results" page
    When I click on the compare links on the first 2 dental plans
    And I click on the compare dental button
    Then I validate I am on the "dentalCompare" page

  @SLER-46 @CompareMedicalPlansLink
  Scenario: Validate the Navigation and Functionality of Compare Plans Link (Medical)
    When I click continue on start shopping page
    Then I validate I am on the "Medical Plan Results" page
    And I click on the compare links on the first 2 medical plans
    Then I click on the compare button
    Then I validate I am on the "Compare" page
