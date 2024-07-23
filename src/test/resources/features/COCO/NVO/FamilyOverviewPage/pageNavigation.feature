Feature: Navigation - Family Overview page

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-47 @PageNavigationFamilyOverview @NVOCoCoRegression
  Scenario: Navigation on the Tell us about yourself page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click Primary EditUpdate on the Family Overview page
    And I click Go Back on the tell us about yourself page
    Then I validate I am on the "CoCo Family Overview" page
    And I verify button text Manage who helps you in "English"
    Then I click Manage who helps you on the Family Overview page
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    And I change the language from header to "Spanish"
    And I verify button text Manage who helps you in "Spanish"
    Then I click Manage who helps you on the Family Overview page
    Then I validate I am on the "Find Expert Help" page
    And I change the language from header to "English"
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "I prefer not to answer" ethnicity option
    And I select "I prefer not to answer" race option
    And I click continue on the Ethnicity and race page
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
    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page and continue with "Wife", "03051989", "Male" and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    Then I click Go Back on the Additional information for additional member page
    Then I validate I am on the "CoCo Tell us about additional members" page
    And I click Go Back on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Family Overview" page
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

