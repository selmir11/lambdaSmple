@TAM @TamExch
Feature: Page Navigation-Tax Status Elmo Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
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
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I get the Primary Member ID
    And I click continue on the Citizenship page

  @SLER-1775 @PageNavigationTaxStatusElmoPage @TAMSmokeExch
  Scenario: SLER-1775 My session is invalidated when I log out in Tax Return Portal, Exchange
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status Elmo" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    #step1
    Then I open current page in new tab
    Then I validate I am on the "Tax status Elmo" page
    And I switch to the tab number 0
    Then I validate I am on the "Tax status Elmo" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page
    #step2
    And I switch to the tab number 1
    Then I validate I am on the "Tax status Elmo" page
    And I refresh the page
    And I validate I am on the "Login" page
    And I close current tab and switch back to previous tab
    #step3
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click on "Primary" to edit information from household page
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I click the save and continue button on the Income Summary Detail page

    Then I validate I am on the "Tax status Elmo" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    Then I open current page in new tab
    Then I validate I am on the "Tax status Elmo" page
    And I switch to the tab number 0
    Then I validate I am on the "Tax status Elmo" page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page
    #step4
    And I switch to the tab number 1
    Then I validate I am on the "Tax status Elmo" page
    Then I select "No" for will you be claimed as dependent question
    Then I select "No" for will file tax return question
    Then I click Save and Continue on Tax Status page
    And I validate I am on the "Login" page

  @SLER-1776 @PageNavigationTaxStatusElmoPage @TAMSmokeExch
  Scenario: SLER-1776 The 'Find Expert Assistance' link stops working when navigate back to the error and unauthorized pages in Tax Return Portal, Exchange
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status Elmo" page
    And I verify the header for "Primary" Member on the Tax Status page in "English"
    #Step1
    And I change the C4 url to "Tax Return portal Error Exch"
    Then I validate I am on the "Error" page
    And I click Back to Welcome page Button on error Exch page
    Then I click Go Back button from chrome browser
    And I verify User name Link is displayed in the "Exch" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page
    #Step2
    And I click on Apply for Coverage in the "ExpertHelp" Header
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click on "Primary" to edit information from household page
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    And I click continue on the Employment Info Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I click the save and continue button on the Income Summary Detail page

    And I verify the header for "Primary" Member on the Tax Status page in "English"
    And I change the C4 url to "Tax Return portal Unauthorized Exch"
    And I click on Apply for Coverage in the "Elmo" Header
    Then I click Go Back button from chrome browser
    And I verify User name Link is displayed in the "Exch" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I validate I am on the "Find Expert Help" page

    And I click on Sign Out in the Header for "WhoHelpsYouPage"
    Then I validate I am on the "Login" page

    @SLER-2236 @PageNavigationTaxStatusElmoPage @TAMSmokeExch
    Scenario: SLER-2236 Navigation works as expected when tax filing status is changed from a filer to a dependent in Tax Return Portal, Exchange
      #step2 - add a family member
      Then I click Add Another Family Member
      Then I validate I am on the "Add Member" page
      Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Female" and applying "Yes"
        | Primary:Spouse |
      And I click continue on Tell us about additional members page
      Then I validate I am on the "Add Address" page
      Then I select "Household" for Residential Address
      And I select "Yes" for CO Resident option
      And I select "No" for Federally Recognized Tribe option
      And I select "No" for Hardship Exemption option
      And I select "No" for Disability option
      And I select "No" to the recently denied medicaid question
      And I select "No" for Incarceration option
      And I click continue on the Add Address page
      And I select "Prefer not to answer" for race and ethnicity for "Spouse"
      And I click continue on the Race and Ethnicity page
      Then I validate I am on the "Citizenship" page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page
      #step3 - navigate to ELMO Tax Status page
      Then I click continue on family overview page
      And I Apply for financial help
      Then I select the option "No" to employment
      And I click continue on the Employment Info Page
      Then I click None of these as additional income option and continue
      Then I click None of these as deduction option and continue
      Then I select the projected income option "No" and continue
      Then I select the option "No" to employment
      And I click continue on the Employment Info Page
      Then I click None of these as additional income option and continue
      Then I click None of these as deduction option and continue
      Then I select the projected income option "No" and continue
      Then I validate I am on the "Tax status Elmo" page
      #step4 - provide filer tax information for account holder
      And I verify the header for "Primary" Member on the Tax Status page in "English"
      Then I select "No" for will you be claimed as dependent question
      Then I select "Yes" for will file tax return question
      Then I select the "Head of household" tax filing option on the Tax Status page
      Then I select "Yes" for will claim dependents question
      Then I select "Spouse" for who will be claimed as dependent question on the Tax Status page
      Then I click Save and Continue on Tax Status page
      Then I select "None of these" as health coverage option
      Then I click continue on the health coverage page
      And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
      Then I select "None of these" as health coverage option
      Then I click continue on the health coverage page
      #step5 - navigate back to ELMO Tax Status page
      And I validate I am on the "Family Overview" page
      And I click plus icon next to member on household page for "Primary"
      And I click View Details under member on household page for "Primary"
      Then I select the Edit Income link
      And I click continue on the Employment Info Page
      Then I click continue on the Additional Income page
      Then I click continue on the Deductions page
      Then I click the save and continue button on the Income Summary Detail page
      Then I validate I am on the "Tax status Elmo" page
      #step6 - change from filer to dependent
      Then I select "Yes" for will you be claimed as dependent question
      Then I select "Spouse" for who will claim as dependent question
      Then I click Save and Continue on Tax Status page
      And I validate I am on the "Elmo Other Health Coverage" page
      Then I click continue on the health coverage page
      And I verify the header for "Secondary" Member on the Other Health Coverage page in "English"
      Then I click continue on the health coverage page
      And I validate I am on the "Family Overview" page

      And I click on Sign Out in the Header for "NonElmo"