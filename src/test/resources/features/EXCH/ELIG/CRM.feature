@CRM
Feature: Testing Manual Verification Requests (MVRs) and CRM (MD365)

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page

  @SLER-1220
  Scenario: SLER-1220 Correctable Error Count-SSA
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with SSN "012123456" City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help Exch" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    And I validate SSA Error on Tell us about yourself page
    And I click continue on Tell us about yourself page
    And I validate SSA Error on Tell us about yourself page
    And I click continue on Tell us about yourself page
    Then I enter member with address line1 "1234 Street" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    Then I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for no financial help
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    And I validate MVR details for account
      |manual_verification_type|manual_verif_status|manual_verif_date_set|manual_verif_due_date|manual_verif_date_expired|manual_verif_date_closed|
      |SSN                     |Open               |         0           |         90          |          105            |                        |
      |Citizenship             |Open               |         0           |         90          |          105            |                        |
    And I validate the SSA response code is "HE030004" in the DB for "Primary"
    And I click on Sign Out in the Header for "NonElmo"
    Then I validate I am on the "Login" page

    And I wait for 70000 milliseconds
    Then I log into the CRM system
    Then I search for user's Email
    Then I handle the search results page
    Then I open the MVRDVR Tab on contact page
    Then I open the "SSN" MVR
    Then I check the "SSN" MVR title for "Primary"
    Then I check that the MVR has a status of "Open"
    Then I click the Go Back arrow in CRM
    Then I open the "Citizenship" MVR
    Then I check the "Citizenship" MVR title for "Primary"
    Then I check that the MVR has a status of "Open"
    Then I sign out of CRM