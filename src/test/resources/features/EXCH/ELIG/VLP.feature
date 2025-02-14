Feature: ELIG - VLP related scenarios

  @SLER-2101_WIP
  Scenario: verify system functionality for receiving successful response from VLP
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10101980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "No" for Citizen option
    Then I select "Yes" for Eligible Immigration Status option
    Then I select "I-327 Reentry Permit" as Document type
    Then I enter A-Number USCIS number for "NonCitizen" on Lawful Presence page
    Then I select "None of the above" active-duty members of the military or honorably discharged veterans
    Then I select "Yes" for name matching the document
    And I click continue on the Citizenship page
    Then I select "No" for Lawful Permanent Resident
    Then I select "Administrative order staying removal" for immigration status
    Then I click continue on the Immigration Status page
    Then I click continue on family overview page
    Then I click on Sign Out in the Header for "Elmo"
    Then I Validate VLP response code as "HS000000"

  @SLER-2107_WIP
  Scenario: verify system functionality for receiving successful response from VLP
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10101980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "No" for Citizen option
    Then I select "Yes" for Eligible Immigration Status option
    Then I select "I-327 Reentry Permit" as Document type
    Then I enter A-Number USCIS number for "NonCitizen" on Lawful Presence page
    Then I select "None of the above" active-duty members of the military or honorably discharged veterans
    Then I select "Yes" for name matching the document
    And I click continue on the Citizenship page
    Then I select "No" for Lawful Permanent Resident
    Then I select "Administrative order staying removal" for immigration status
    Then I click continue on the Immigration Status page
    Then I click continue on family overview page
    Then I click on Sign Out in the Header for "Elmo"
    Then I Validate VLP response code as "HX009000"
    Then I Validate VLP retry type as "VLP_INITIAL" and VLP retry status as "NEW"
