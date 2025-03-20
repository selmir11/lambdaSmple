@NVOExchRegression

Feature: Invalid Member ID in URL redirects to Error Page

  Background: I go the login portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-2344
  Scenario: Ensure Error Page loads when Member ID is invalid for account
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
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011986", "Female" and applying "Yes"
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
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    And I click plus icon next to member on household page for "Primary"
    Then I click edit basic information icon on household page for "Primary"
    Then I validate I am on the "Member" page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I navigate to the same page with a random member ID
    Then I validate I am on the "Error" page
    And I click Back to Welcome page Button on error Exch page
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
    Then I validate I am on the "Family Overview" page
    And I click plus icon next to member on household page for "Spouse"
    Then I click edit basic information icon on household page for "Spouse"
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    And I click continue on the Add Address page
    Then I validate I am on the "Race and Ethnicity" page
    And I navigate to the same page with a random member ID
    Then I validate I am on the "Error" page
    And I click Back to Welcome page Button on error Exch page
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"
    Then I validate I am on the "Login" page