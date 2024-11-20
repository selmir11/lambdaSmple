@PersonId
Feature: Verify Navigation to the ELIG Pages

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-975
  Scenario: SLER-975 PersonID Multiple Matches with the same Person ID-PersonID
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter first name "bccstpeyk", middle name "mname", last name "bcmcgssoqj" and general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with SSN "102410498" City "Denver" in State "CO" with dob "02171962" in county "MESA" with zipcode "81643"
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
    And I select "Prefer not to answer" for race and ethnicity for "bccstpeyk"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I verify Person ID is unique in the DB
    And I verify Person ID review status is Manual Review Required

    And I click on Sign Out in the Header for "Elmo"

