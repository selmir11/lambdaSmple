@portNoticeBrokerPortal @port
Feature:verify deauthorize broker notice Spanish Mail prefrences BN-002-04
  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    
  @SLER-481
  Scenario: verify deauthorize broker notice Spanish with Mail preference BN-002-04
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
    And I click on Find a Broker
    Then I Search authorized Broker "soukaina agency"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
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
    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click on the Username in the "Exch NonElmo" Header
    And I click on Make Changes Button
    And I change the Preferred Contact Method to "Mail"
    Then I click on Save Button
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker
    Then I validate I am on the "Find Expert Help Exch" page
    And I validate no broker is authorized
    Then I click on the Colorado Connect or C4 Logo in the "ExpertHelp" Header
    And I click link my docs on accountOverview page
    And I validate I am on the "My Documents" page
    Then I validate the notice "IND_Notify Client of Broker De-Authorization (BN-002A-04)" exist in my document letter Containers

@SLER-485
  Scenario: verify deauthorize broker notice Spanish with Mail and Spanish preference BN-002-04
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
    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click on the Username in the "Exch NonElmo" Header
    And I click on Make Changes Button
    And I change the Preferred Contact Method to "Mail"
    And I change Preferred Language Contact Method to "Spanish"
    Then I click on Save Button
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker
    Then I Search authorized Broker "soukaina agency"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker
    And I validate no broker is authorized
    Then I click on the Colorado Connect or C4 Logo in the "ExpertHelp" Header
    And I click link my docs on accountOverview page
    And I validate I am on the "My Documents" page
    Then I validate the notice "IND_Notify Client of Broker De-Authorization (BN-002A-04)" exist in my document letter Containers







