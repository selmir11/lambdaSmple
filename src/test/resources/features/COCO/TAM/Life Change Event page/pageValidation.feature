@TAM @pageVal @TamCoCo
Feature: Page validation - Life Change Event page

  Background: I go to the login portal
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select None of these as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    
  @SLCR-271
  Scenario: SLCR-271 Verify initial state of LCE choices
    Then I verify "AllSingle" life change event "is not" selected
    #Then I verify "NoneOfThese" life change event "is" selected
    And I select "Divorce" life change event
    And I select continue on the LCE page
    And I select Go Back on the Declarations and Signature page
    And I verify "Divorce" life change event "is" selected
    And I select None of these life change event
    And I select continue on the LCE page
    And I select Go Back on the Declarations and Signature page
    Then I verify "NoneOfThese" life change event "is" selected
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    And I select continue on the Family Overview page
    Then I verify "AllSingle" life change event "is not" selected
    #Then I verify "NoneOfThese" life change event "is" selected
    And I select "InsuranceLoss" life change event
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    And I select continue on the Family Overview page
    Then I verify "AllSingle" life change event "is not" selected
    #Then I verify "NoneOfThese" life change event "is" selected