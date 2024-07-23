@SOLRegression
Feature: Tests related to What's Next Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

@SLCR-181
Scenario: Page validation - Validate the text on the page and text on buttons on the page
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
Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
And I select "Yes" for mailing address option
And I select "Yes" for live in Colorado option
And I click continue on the Add info for yourself page
And I select "I prefer not to answer" ethnicity option
And I select "I prefer not to answer" race option
And I click continue on the Ethnicity and race page
And I select "No" employment option
And I click continue on the Employment income page
And I select None of these as additional income option
And I select continue on the Additional Income CoCO page
Then I validate I am on the "CoCo Deductions" page
And I select None of these as deductions option
And I select continue on the Deductions CoCo page
And I select the No projected Income button on the Income Summary page
And I select continue on the income Summary CoCo page
Then I validate I am on the "CoCo Family Overview" page
And I select continue on the Family Overview page
Then I validate I am on the "CoCo life change event" page
And I select "MoveToCO" life change event
And I select continue on the LCE page
Then I validate I am on the "CoCo Declarations and Signature" page
And I enter a valid signature
And I click Continue on the Declarations And Signature Page CoCo
Then I validate I am on the "Application Results CoCo" page
And I click Continue on the Application Results Page CoCo
Then I validate I am on the "Start Shopping" page
Then I click continue on coco start shopping page
Then I validate I am on the "Medical Plan Results" page
And I select the first medical plan option CoCo
And I click Continue on the Medical Plans Page CoCo
Then I validate I am on the "Plan Summary" page
And I click Continue button on the Medical Dental Page CoCo
And I select "Terms of Use" agreement checkbox CoCo
And I select "Privacy Policy" agreement checkbox CoCo
And I select "Dental Coverage" agreement checkbox CoCo
And I enter householder signature on the Enrollment Agreements page CoCo
And I select continue button on the Enrollment Agreements CoCo page
And I select make payment button to pay the premium CoCo
And I select Continue button on the Payment Selection CoCo page
And I select continue button on the Initial Payment CoCo page
Then I validate I am on the "Congratulations - What's Next?" page



