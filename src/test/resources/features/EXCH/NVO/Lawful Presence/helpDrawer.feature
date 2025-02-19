Feature: Verify the help text in the help drawer

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

@SLER-1889 @NVOExchRegression
Scenario: Verify the help text in the help drawer on the Citizenship and Five-Year Bar Immigration status page English and Spanish
When I click create a new account on login page
Then I click create my account from pre-screen page
And I enter general mandatory data for "exchange" account creation
Then I validate I am on the "Login" page
And  I enter valid credentials to login
Then I apply for the current year
Then I select "No" option on the Let us guide you page
And I click on save and continue button
Then I click on continue with  application button on Before you begin page
And I report "Birth" and click continue
Then I select "member" from the who are you question
And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
Then I answer all Id proofing questions and click continue
And I click continue button on Congratulations page
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
Then I validate I am on the "Citizenship" page
Then I select "No" for Citizen option
Then I select "Yes" for Eligible Immigration Status option
Then I select "I-551 Permanent Resident Card" as Document type
Then I validate I am on the "Citizenship" page
And I select "Help me understand" icon on the Citizenship and Immigration Status page
Then I validate Lawful Presence help drawer "Eligible Immigration Status" verbiage in "English"
Then I validate Lawful Presence help drawer "Document Type" verbiage in "English"
Then I validate Lawful Presence help drawer "Active Duty Military Members or Honorably Discharged Veterans" verbiage in "English"
And I select "Help me understand" icon on the Citizenship and Immigration Status page
Then I validate I am on the "Citizenship" page
When I change the language from header to "Spanish NonElmo"
  And I wait for 9000 milliseconds
Then I validate I am on the "Spanish" page
Then I validate I am on the "Citizenship" page
And I select "Help me understand" icon on the Citizenship and Immigration Status page
Then I validate Lawful Presence help drawer "Eligible Immigration Status" verbiage in "Spanish"
Then I validate Lawful Presence help drawer "Document Type" verbiage in "Spanish"
Then I validate Lawful Presence help drawer "Active Duty Military Members or Honorably Discharged Veterans" verbiage in "Spanish"
And I select "Help me understand" icon on the Citizenship and Immigration Status page
When I change the language from header to "English NonElmo"
Then I select "No" for Citizen option
Then I select "Yes" for Eligible Immigration Status option
Then I select "I-551 Permanent Resident Card" as Document type
Then I enter A-Number USCIS number for "NonCitizen" on Lawful Presence page
And I enter Card Number
Then I select "None of the above" active-duty members of the military or honorably discharged veterans
Then I select "Yes" for name matching the document
And I click continue on the Citizenship page
And I select "Help me understand" icon on the Five-Year Bar Immigration Status page
Then I validate Lawful Presence help drawer Five-Year Bar page "Lived in the U.S. since 1996" verbiage in "English"
And I select "Help me understand" icon on the Five-Year Bar Immigration Status page
When I change the language from header to "Spanish NonElmo"
Then I validate I am on the "Spanish" page
And I select "Help me understand" icon on the Five-Year Bar Immigration Status page
Then I validate Lawful Presence help drawer Five-Year Bar page "Lived in the U.S. since 1996" verbiage in "Spanish"
When I change the language from header to "English NonElmo"
And I click on Sign Out in the Header for "NonElmo"
Then I validate I am on the "Login" page