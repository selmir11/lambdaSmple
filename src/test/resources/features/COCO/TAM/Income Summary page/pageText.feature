@TAM @TamCoCo
Feature: Tests related to the Deductions page

  Background: I go to the login portal
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page

  @SLCR-65 @PageTextIncomeSummary
  Scenario: SLCR-65 I can see Income Summary's Header and footer - English
    Then I validate I am on the "CoCo Income Summary" page
    And I verify text on the "CoCo" "Header" in "English"
    And I verify text on the "CoCo" "Footer" in "English"

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "CoCo Income Summary" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Income Summary" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Income Summary" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Income Summary" page


    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-66 @PageTextIncomeSummary @TAMSmoke
  Scenario: SLCR-66 I can see Income Summary's Header and footer - Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I verify text on the "CoCo" "Header" in "Spanish"
    And I verify text on the "CoCo" "Footer" in "Spanish"

    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on Learn More in the Header
    And I validate I am on the "Faqs" page and close tab

    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I click Primary EditUpdate on the Family Overview page
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page

    And I validate I am on the "CoCo Income Summary" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I verify the header for Primary Member on the CoCo Income Summary page in "Spanish"
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Income Summary" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Income Summary" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Income Summary" page


    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-377
  Scenario: SLCR-377 I want to see a pencil icon rather than the Edit/Update link
    And I verify the header for Primary Member on the CoCo Income Summary page in "English"
    Then I verify the edit icon
    And I click on the edit "Income" icon on the Income Summary CoCo page
    Then I validate I am on the "CoCo Employment Income" page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page
    And I click on the edit "Deductions" icon on the Income Summary CoCo page
    Then I validate I am on the "CoCo Deductions" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page