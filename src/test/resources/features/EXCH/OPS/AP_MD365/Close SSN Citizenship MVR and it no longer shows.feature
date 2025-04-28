@OPS @Exch @MD365
Feature: OPS: MD365: Create then Close SSN/Citizenship MVRs and they no longer show in My Docs [RT-2000]
 @SLER-2370
  Scenario:SLER-2370 Create and Close SSN/Citizenship MVRs and no longer showed in My Docs
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "Admin exchange" account creation
    And I validate I am on the "Admin search" page
    Then I search for user and click email from search results
    Then I validate I am on the "Admin Portal individual dashboard" page
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I switch to the tab number 1
    And I validate I am on the "Account Overview" page
    And I apply for the current year

    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "11281990" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    Then I click I don't have a Social Security Number box and "Yes" on Tell us about yourself page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I enter member with address line1 "P.O.BOX 1454" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "Yes" for Naturalized Immigrant option
    Then I enter A-Number USCIS number for "Citizen" on Lawful Presence page
    Then I select "Citizenship Certificate" as Document type on Lawful Presence page
    Then I enter Document Number on Lawful Presence page
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for no financial help
    Then I validate I am on the "Tell us about life changes" page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on My Account in the "NonElmo" Header
    Then I validate I am on the "Account Overview" page

    Then I click link my docs on accountOverview page
    And I wait for 5000 milliseconds
    Then I upload MVR doc for "Social Security Number" on the My Documents page
    And I wait for 5000 milliseconds
    Then I upload MVR doc for "US Citizenship" on the My Documents page
    And I wait for 7000 milliseconds

    Then I log into the CRM system
    Then I search for user's Email
   And I click on popup Work smarter with AI to close it
   And I wait for 70000 milliseconds
   Then I handle the search results page
    Then I open the "MVRDVR" Tab on contact page
    And I wait for 5000 milliseconds
    Then I open the "Citizenship" MVR
    And I wait for 7000 milliseconds
   # And I click on popup Work smarter with AI to close it

    Then I click Deactivate button in CRM
    And I wait for 7000 milliseconds
    Then I click the Go Back arrow in CRM
    And I wait for 7000 milliseconds
    Then I open the "SSN" MVR
    And I wait for 7000 milliseconds
    Then I click Deactivate button in CRM
    And I wait for 7000 milliseconds
   Then I sign out of CRM
   Then I close current tab and switch back to previous tab

   Then I validate I am on the "Admin Portal individual dashboard" page
   Then I validate "Admin Portal Text Display" for Admin Portal
   And I click "On Behalf Of (OBO)" from application links dropdown
   Then I switch to the tab number 1
   And I validate I am on the "Account Overview" page
   Then I click link my docs on accountOverview page
   And I wait for 5000 milliseconds
   Then I verify message You don't need to upload any documents at this time displays




