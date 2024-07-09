@MedicalPlans
  Feature: Tests related to medical plans

    Scenario: Validate medical plans count
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
      And I am a member with City "Denver" in State "CO" with dob "11281986" in county "DENVER" with zipcode "80205"
      Then I answer all Id proofing questions and click continue
      And I click continue button on Congratulations page
      Then I validate I am on the "Find Expert Help" page
      Then I click Continue on my own button from Manage who helps you page
      Then I select "Male" as sex option
      And I select "Yes" to Are You Applying
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
      Then I validate I am on the "Citizenship" page
      Then I select "Yes" for Citizen option
      And I select "No" for Naturalized Immigrant option
      And I click continue on the Citizenship page
      Then I click continue on family overview page
      Then I validate I am on the "Financial Help" page
      And I Apply for no financial help
      Then I validate I am on the "Tell us about life changes" page
      Then I select "Birth" QLCE on tell us about life changes page
      Then I click on Save and Continue
      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear
      Then I click on view results and shop
      Then I validate I am on the "Application Results" page
      Then I click continue on application results page
      Then I click continue on start shopping page
      And I validate I am on the "Medical Plan Results" page
      Then I validate the medical plans count to be "83"



