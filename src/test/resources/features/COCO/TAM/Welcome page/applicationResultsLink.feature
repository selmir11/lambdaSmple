@applicationResultsLink
Feature: Tests related to the Application Results link

  Background: I go to the login portal
    Given I open the login page on the "login" portal

  @SLCR-25
  Scenario: Validate Action links navigation and text
    When I click create a new account on login page
    Then I validate I am on the "Prescreen" page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CoCo Welcome" page
    And I change the language from header to "Spanish"
    And I click on "Application Results" link on welcome page
    Then I validate I am on the "Application Results CoCo" page
    And I click on Go back to Welcome page Button on Application Results page CoCo
    And I click on "My Documents and Letters" link on welcome page
    Then I validate I am on the "My Documents" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate action link text on welcome page in "Spanish"
    And I change the language from header to "English"
    And I click on "Application Results" link on welcome page
    Then I validate I am on the "Application Results CoCo" page
    And I click on Go back to Welcome page Button on Application Results page CoCo
    And I click on "My Documents and Letters" link on welcome page
    Then I validate I am on the "My Documents" page
    And I click on the Colorado Connect or C4 Logo in the Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate action link text on welcome page in "English"
      # Enroll into a plan
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    And I click Primary EditUpdate on the Family Overview page
    And I enter details on tell us about yourself page and continue with "01011991", "Female", and applying "Yes"
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
    And I enter a valid signature in "English"
    And I click Continue on the Declarations And Signature Page CoCo
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    And I click Continue on the Tobacco Usage Page CoCo
    And I select the first medical plan option CoCo
    And I click Continue on the Medical Plans Page CoCo
    And I click Continue button on the Medical Dental Page CoCo
    And I select make payment button to pay the premium CoCo
    And I select Continue button on the Payment Selection CoCo page
    And I select continue button on the Initial Payment CoCo page
    And I select "Terms of Use" agreement checkbox CoCo
    And I select "Privacy Policy" agreement checkbox CoCo
    And I select "Dental Coverage" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select continue button on the Enrollment Agreements CoCo page
    And I click continue button on Congratulations page CoCo
    Then I validate I am on the "CoCo Welcome" page
    And I change the language from header to "Spanish"
    And I click on "Application Results" link on welcome page
    Then I validate I am on the "Application Results CoCo" page
    And I click on the Colorado Connect or C4 Logo in the Header
    And I click on "My Documents and Letters" link on welcome page
    Then I validate I am on the "My Documents" page
    And I click on the Colorado Connect or C4 Logo in the Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate action link text on welcome page in "Spanish"
    And I change the language from header to "English"
    And I click on "Application Results" link on welcome page
    Then I validate I am on the "Application Results CoCo" page
    And I click on the Colorado Connect or C4 Logo in the Header
    And I click on "My Documents and Letters" link on welcome page
    Then I validate I am on the "My Documents" page
    And I click on the Colorado Connect or C4 Logo in the Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate action link text on welcome page in "English"