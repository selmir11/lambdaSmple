Feature: Page text, navigation, validation - Race And Ethnicity in Spanish

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-903 @SpanishRaceAndEthnicity @NVOExchRegression
  Scenario: Check Race And Ethnicity Page in Spanish
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
    And I report "LostCoverage" and click continue
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
    Then I validate I am on the "Race and Ethnicity" page
    And I change the language from header to "Spanish"
    And I select "Not listed" for race and ethnicity for "Primary"
    Then I verify text on the Race and Ethnicity page in "Spanish"
    And I select "Not listed" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate the error messages on the Race and Ethnicity in "Spanish"
    Then I validate the text box input and checkbox selection
    And I select "Native Hawaiian or Pacific Islander" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I click Go back on the Citizenship page
    Then I validate I am on the "Race and Ethnicity" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I click Go back on the Race and Ethnicity page
    Then I validate I am on the "Additional Information for Yourself" page
    And I click continue on the Add Address page

    And I validate I am on the "Race and Ethnicity" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "Race and Ethnicity" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "Race and Ethnicity" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "Race and Ethnicity" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    Then I validate I am on the "Race and Ethnicity" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    Then I validate I am on the "Race and Ethnicity" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    Then I validate I am on the "Race and Ethnicity" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    Then I validate I am on the "Race and Ethnicity" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    Then I validate I am on the "Race and Ethnicity" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    Then I validate I am on the "Race and Ethnicity" page

    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Son", "10101945", "Female" and applying "Yes"
      | Primary:Spouse |
    And I mark the Additional member is pregnant as "No"
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
    Then I validate I am on the "Race and Ethnicity" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I click Go back on the Race and Ethnicity page
    Then I validate I am on the "Additional Information for Yourself" page
    And I click continue on the Add Address page
    And I select "White or European" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I click Go back on the Citizenship page
    Then I validate I am on the "Race and Ethnicity" page
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I select "Native Hawaiian or Pacific Islander" for race and ethnicity for "Spouse"
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page