@NVOCoCoRegression
Feature: Coco user on the Application results page - Open Enrollment SES Eligibility
  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page

@SLCR-682
Scenario: Scenario 1- ELIG-NVO Validate 2025 SES Reached limit with no LCE during SES limited (2025 SES eligible during open enrollment)
And I apply for the current year in CoCo
Then I validate I am on the "Find Expert Help" page
And I click Continue on my own button from Manage who helps you page
Then I click EditUpdate on Family Overview page for "Primary"
And I enter details on tell us about yourself page and continue with "01011991", "Female", and applying "Yes"
And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
And I select "Yes" for mailing address option
And I select "Yes" for live in Colorado option
And I click continue on the Add info for yourself page
Then I validate I am on the "Elmo Race and Ethnicity" page
And I select "Prefer not to answer" for race and ethnicity option for "Primary"
And I click save and continue on the Race and Ethnicity page
And I select "Yes" employment option
And I enter "19,500.00" income amount
And I select "Annually" income frequency option
And I select "No" income seasonal option
And I select "No" income changes option
And I click continue on the Employment income page
And I select None of these as additional income option
And I select continue on the Additional Income CoCO page
Then I validate I am on the "CoCo Deductions" page
And I select "None of these" as deductions option
And I select continue on the Deductions CoCo page
Then I select the projected income option "No" on Income Summary CoCo page
And I select continue on the income Summary CoCo page
Then I validate I am on the "CoCo Family Overview" page
And I wait for 9000 milliseconds
And I select continue on the Family Overview page
And  I check "None of these" life change event checkbox
And I select continue on the LCE page
Then I validate I am on the "CoCo Declarations and Signature" page
And I enter a valid signature
And I click Continue on the Declarations And Signature Page CoCo
Then I validate I am on the "Application Results CoCo" page
Then I verify text that the member qualifies for SES and no spots are available in "English" on the App Results Page CoCo
And I verify the application result details in DB as "ELIGIBLE_FOR_HP2_LIMITED" for "Primary"
And I click on Sign Out in the Header for "Elmo"

@SLCR-682
Scenario: scenario 2- User submits 2025 application with no LCE during open enrollment and able to shop
And I apply for the current year in CoCo
Then I validate I am on the "Find Expert Help" page
And I click Continue on my own button from Manage who helps you page
Then I click EditUpdate on Family Overview page for "Primary"
And I get the memberId of primary member from url
And I enter details on tell us about yourself page and continue with "01011991", "Female", and applying "Yes"
And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
And I select "Yes" for mailing address option
And I select "Yes" for live in Colorado option
And I click continue on the Add info for yourself page
Then I validate I am on the "Elmo Race and Ethnicity" page
And I select "Prefer not to answer" for race and ethnicity option for "Primary"
And I click save and continue on the Race and Ethnicity page
And I select "Yes" employment option
And I enter "19,500.00" income amount
And I select "Annually" income frequency option
And I select "No" income seasonal option
And I select "No" income changes option
And I click continue on the Employment income page
And I select None of these as additional income option
And I select continue on the Additional Income CoCO page
Then I validate I am on the "CoCo Deductions" page
And I select "None of these" as deductions option
And I select continue on the Deductions CoCo page
Then I select the projected income option "No" on Income Summary CoCo page
And I select continue on the income Summary CoCo page
Then I validate I am on the "CoCo Family Overview" page
And I wait for 9000 milliseconds
And I select continue on the Family Overview page
And  I check "None of these" life change event checkbox
And I select continue on the LCE page
Then I validate I am on the "CoCo Declarations and Signature" page
And I enter a valid signature
And I click Continue on the Declarations And Signature Page CoCo
And I verify the application result details in DB as "ELIGIBLE_FOR_HP2_LIMITED" for "getFromSharedData"
Then I validate I am on the "Application Results CoCo" page
Then I verify text that the member qualifies for SES and no spots are available in "English" on the App Results Page CoCo
And I click Continue on the Application Results Page CoCo
Then I validate I am on the "Start Shopping" page
Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
Then I click continue on start shopping page
Then I validate I am on the "Medical Plan Results" page

@SLCR-682 @SLCR-697
Scenario: scenario3-SLCR-682 and Scenario1-SLCR-697:: User submits Next year application with LCE during OE and able to shop
And I apply for the current year in CoCo
Then I validate I am on the "Find Expert Help" page
And I click Continue on my own button from Manage who helps you page
Then I click EditUpdate on Family Overview page for "Primary"
And I get the memberId of primary member from url
And I enter details on tell us about yourself page and continue with "01011991", "Female", and applying "Yes"
And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
And I select "Yes" for mailing address option
And I select "Yes" for live in Colorado option
And I click continue on the Add info for yourself page
Then I validate I am on the "Elmo Race and Ethnicity" page
And I select "Prefer not to answer" for race and ethnicity option for "Primary"
And I click save and continue on the Race and Ethnicity page
And I select "Yes" employment option
And I enter "19,500.00" income amount
And I select "Annually" income frequency option
And I select "No" income seasonal option
And I select "No" income changes option
And I click continue on the Employment income page
And I select None of these as additional income option
And I select continue on the Additional Income CoCO page
Then I validate I am on the "CoCo Deductions" page
And I select "None of these" as deductions option
And I select continue on the Deductions CoCo page
Then I select the projected income option "No" on Income Summary CoCo page
And I select continue on the income Summary CoCo page
Then I validate I am on the "CoCo Family Overview" page
And I wait for 9000 milliseconds
And I select continue on the Family Overview page
Then I validate I am on the "CoCo life change event" page
And I select "MoveToCO" life change event with event date of "Today"
And I select continue on the LCE page
Then I validate I am on the "CoCo Declarations and Signature" page
And I enter a valid signature
And I click Continue on the Declarations And Signature Page CoCo
Then I validate I am on the "Application Results CoCo" page
Then I verify text that the member qualifies for SES and no spots are available in "English" on the App Results Page CoCo
And I click Continue on the Application Results Page CoCo

Then I validate I am on the "Start Shopping" page
Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
Then I click continue on start shopping page

Then I validate I am on the "Medical Plan Results" page
And I verify the application result details in DB as "ELIGIBLE_FOR_HP2_LIMITED" for "getFromSharedData"