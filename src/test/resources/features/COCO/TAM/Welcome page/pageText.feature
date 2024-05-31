@TAM
Feature: Page Text-Welcome Page

  Background: I go the login portal
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page

  @SLCR-33 @PageTextWelcomePage
  Scenario: SLCR-33 Check Welcome Page Text in English
    When I click create a new account on login page
    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CoCo Welcome" page

    Then I verify text on the Welcome page for first time signed into an account in "English"
    Then I verify text on the "CoCo" "Header" in "English"
    Then I verify text on the "CoCo" "Footer" in "English"
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy in "English"

    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
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
    And I select continue on the Family Overview page
    And I select "InsuranceLoss" life change event
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    And I click Continue on the Tobacco Usage Page CoCo
    And I select the first medical plan option CoCo
    And I click Continue on the Medical Plans Page CoCo
    And I click Continue button on the Medical Dental Page CoCo
    And I select "Terms of Use" agreement checkbox CoCo
    And I select "Privacy Policy" agreement checkbox CoCo
    And I select "Dental Coverage" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select continue button on the Enrollment Agreements CoCo page
    And I select make payment button to pay the premium CoCo
    And I select Continue button on the Payment Selection CoCo page
    And I select continue button on the Initial Payment CoCo page
    And I click continue button on Congratulations page CoCo
    Then I validate I am on the "CoCo Welcome" page

    Then I verify text on the Welcome page with policy "Elevate Health Plans Colorado Option Bronze" "Bronze/HMO" for $"285.37" in "English"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-39 @PageTextWelcomePage
  Scenario: SLCR-39 Check Welcome Page Text in Spanish
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CoCo Welcome" page
    And I change the language from header to "Spanish"

    Then I verify text on the Welcome page for first time signed into an account in "Spanish"
    Then I verify text on the "CoCo" "Header" in "Spanish"
    Then I verify text on the "CoCo" "Footer" in "Spanish"
    And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy in "Spanish"

    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
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
    And I select continue on the Family Overview page
    And I select "InsuranceLoss" life change event
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    And I click Continue on the Tobacco Usage Page CoCo
    And I select the first medical plan option CoCo
    And I click Continue on the Medical Plans Page CoCo
    And I click Continue button on the Medical Dental Page CoCo
    And I select "Terms of Use" agreement checkbox CoCo
    And I select "Privacy Policy" agreement checkbox CoCo
    And I select "Dental Coverage" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select continue button on the Enrollment Agreements CoCo page
    And I select make payment button to pay the premium CoCo
    And I select Continue button on the Payment Selection CoCo page
    And I select continue button on the Initial Payment CoCo page
    And I click continue button on Congratulations page CoCo
    Then I validate I am on the "CoCo Welcome" page

    And I change the language from header to "Spanish"
    Then I verify text on the Welcome page with policy "Elevate Health Plans Colorado Option Bronze" "Bronze/HMO" for $"285.37" in "Spanish"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page









