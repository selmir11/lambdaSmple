@LawfulPresenceRules
Feature: Determine lawful presence/eligible immigration status

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page

  @SLER-1282 @NVOExchRegression
  Scenario Outline: Verify that combinations of codes EAD, ESC do not open a Lawful Presence MVR (VLP responses listed in Table 3 - MVR lawful presence rules)
    And I enter first name "<firstName>", middle name "<middleName>", last name "<lastName>" and general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "LostCoverage" and click continue
    Then I validate I am on the "Who Are You" page
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01/01/1985" in county "Denver" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    And I answer all Id proofing questions and click continue
    Then I validate I am on the "Identify Proofing - Congratulations" page
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help Exch" page
    And I click Continue on my own button from Manage who helps you page
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
    And I select "Prefer not to answer" for race and ethnicity for "lpautomation"
    Then I click continue on the Race and Ethnicity page
    Then I select "No" for Citizen option
    Then I select "Yes" for Eligible Immigration Status option
    Then I select "I-551 Permanent Resident Card" as Document type
    Then I enter A-Number USCIS number for "NonCitizen" on Lawful Presence page
    And I enter Card Number
    Then I select "None of the above" active-duty members of the military or honorably discharged veterans
    Then I select "Yes" for name matching the document
    And I click continue on the Citizenship page
    Then I select "No" for Lawful Permanent Resident
    Then I select "Deferred Action Status (including DACA)" for immigration status
    Then I click continue on the Immigration Status page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "3600000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page

    Then I validate I am on the "Other Health Coverage" page
    Then I select "None of these" as health coverage option
    Then I click continue on the health coverage page
    Then I click continue on family overview page
    Then I select "Birth" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I validate MVR details for account
      | manual_verification_type | manual_verif_status |
      | Lawful Presence          | Canceled                |
    And I click on Sign Out in the Header for "NonElmo"
    Then I validate I am on the "Login" page

    Examples:
      | firstName    | middleName    | lastName           |
      | lpautomation | vlpcnone      | vlponeeighteight   |
      | lpautomation | vlpcnone      | vlpthreeeightseven |
      | lpautomation | vlpaonefour   | vlpten             |
      | lpautomation | vlpcthreefive | vlpten             |
      | lpautomation | vlpcthreesix  | vlpten             |
      | lpautomation | vlpaonefour   | vlponetwoeight     |
      | lpautomation | vlpcthreefive | vlponetwoeight     |
      | lpautomation | vlpcthreesix  | vlponetwoeight     |
      | lpautomation | vlpcnone      | vlpthreesixeight   |
      | lpautomation | vlpaonefour   | vlptenp            |
      | lpautomation | vlpcthreefive | vlptenp            |
      | lpautomation | vlpcthreesix  | vlptenp            |
      | lpautomation | vlpcnone      | vlpthreesixeightp  |
      | lpautomation | vlpcnone      | vlpthreesevenzero  |
      | lpautomation | vlpcnone      | vlptwotwoeight     |