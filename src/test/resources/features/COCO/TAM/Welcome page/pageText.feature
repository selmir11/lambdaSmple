@TAM @TamCoCo
Feature: Page Text-Welcome Page

  Background: I go the login portal
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page

  @SLCR-33 @PageTextWelcomePage @TAMSmoke
  Scenario: SLCR-33 Check Welcome Page Text in English
    Then I verify text on the Welcome page for first time signed into an account in "English"
    And I verify text on the "CoCo" "Header" in "English"
    And I verify text on the "CoCo" "Footer" in "English"

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page

    Then I validate I am on the "CoCo Welcome" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page

    Then I validate I am on the "CoCo Welcome" page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page

    Then I validate I am on the "CoCo Welcome" page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header

    Then I validate I am on the "CoCo Welcome" page
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "CoCo Welcome" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page

    Then I validate I am on the "CoCo Welcome" page
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page

    Then I validate I am on the "CoCo Welcome" page
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Welcome" page

    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
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
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    And I select continue on the Family Overview page
    And I select "InsuranceLoss" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on coco start shopping page
    And I select the first medical plan option CoCo
    And I click Continue on the Medical Plans Page CoCo
    And I click Continue button on the Medical Dental Page CoCo
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page

    And I select year "2025" from My Current Plan container
    Then I verify text on the Welcome page with policy "Cigna Connect Colorado Option Bronze" "Bronze/EPO" for $"333.88" in "English"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-39 @PageTextWelcomePage
  Scenario: SLCR-39 Check Welcome Page Text in Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I verify text on the Welcome page for first time signed into an account in "Spanish"
    And I validate I am on the "Spanish" page
    And I verify text on the "CoCo" "Header" in "Spanish"
    And I verify text on the "CoCo" "Footer" in "Spanish"

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "CoCo Welcome" page
    And I validate I am on the "Spanish" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "CoCo Welcome" page
    And I validate I am on the "Spanish" page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "CoCo Welcome" page
    And I validate I am on the "Spanish" page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "CoCo Welcome" page
    And I validate I am on the "Spanish" page
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "CoCo Welcome" page
    And I validate I am on the "Spanish" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page

    Then I validate I am on the "CoCo Welcome" page
    And I validate I am on the "Spanish" page
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page

    And I validate I am on the "CoCo Welcome" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Welcome" page

    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
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
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    And I select continue on the Family Overview page
    And I select "InsuranceLoss" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on coco start shopping page
    And I select the first medical plan option CoCo
    And I click Continue on the Medical Plans Page CoCo
    And I click Continue button on the Medical Dental Page CoCo
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I select year "Hacer cambios" from My Current Plan container
    Then I verify text on the Welcome page with policy "Cigna Connect Colorado Option Bronze" "Bronze/EPO" for $"333.88" in "Spanish"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-353 @PageTextWelcomePage
  Scenario: SLCR-353 I want to see the CAC Screener banner on the Welcome page - English/Spanish
    Then I validate CAC Screener banner text on welcome page in "English"
    And I select take a short quiz on welcome page
    Then I validate I am on the "CAC Screener" page
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I change the language from header to "Spanish"
    Then I validate CAC Screener banner text on welcome page in "Spanish"
    And I select take a short quiz on welcome page
    Then I validate I am on the "CAC Screener" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-707 @PageTextWelcomePage
  Scenario: SLCR-707 I want to verify the action link properties on the Welcome page
    Then I validate the action link properties on welcome page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate the action link properties on welcome page





