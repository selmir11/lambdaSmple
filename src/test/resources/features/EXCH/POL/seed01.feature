Feature: Seed01 - Exchange --- WIP---WIP---WIP---WIP

  Scenario: Seed 01 For Exchange
    Given I set the total members for the test as 1
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
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with dob "10011975" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Find Expert Help page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter generic mailing address details
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
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Application History" page
    And I click on Sign Out in the Header for "NonElmo"

    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User
    And I validate I am on the "Admin dashboard" page

    And I search for user and click email from search results
    And I click "Admin LCE" from application links dropdown

    And I look up with account id on admin tool page
    And I change effective date to "0101" of current year from admin portal

    Then logout from Admin Portal

    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page

    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page

    Then I click on ClickHere link for "My Eligibility"
    Then I validate I am on the "Application History" page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I click continue on start shopping page

 #    # test step - below
  #  And I select "Elevate Health Plans Colorado Option Bronze" medical plan

     And I select the first medical plan
     Then I click continue on medical plan results page
#    # select Delta Dental of Colorado Family Basic Plan
     Then I select first dental plan
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I continue on plan summary page

    Then I select make payment button to pay the premium
    And I click continue on payment selection page
    And I click continue on initial payment page

    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    And I click on Go To Welcome Page Button on whats next page
    Then I validate I am on the "Account Overview" page
   # And I Validate the correct enrolled plans are displayed on account overview page
    Then I click on ClickHere link for "My Plans"
    Then I validate I am on the "My Policies" page
    And I validate medical plan details from my policies page
    And I validate dental plan details from my policies page
    And I click view plan details link from medical plan card
  #  And I validate I am on the "" page
#    And I validate medical plan details from this page
#    And I click on to go back to my policies page
#    And I click view plan details from dental plan card
#    And I validate I am on the "" page
   # And I validate dental plan details from this page
    And I click on Sign Out in the Header for "Elmo"