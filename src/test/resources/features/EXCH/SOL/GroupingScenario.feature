Feature: UI Page Validation - Grouping Members (Medical)

  Background:
          Given I open the login page on the "login" portal
          And I validate I am on the "Login" page

  @SLER-54-WIP @GroupingScenario  @test
  Scenario: Validate text on Payment by check page
          When I click create a new account on login page
          Then I click create my account from pre-screen page
          And I enter general mandatory data for "exchange" account creation
          Then I validate I am on the "Login" page
          And  I enter valid credentials to login
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
          Then I enter generic mailing address details
          And I select "Yes" for CO Resident option
          And I select "No" for Federally Recognized Tribe option
          And I select "No" for Hardship Exemption option
          And I select "No" for Disability option
          And I select "No" to the recently denied medicaid question
          And I select "No" for Incarceration option
          And I click continue on the Add Address page
          Then I select "Yes" for Citizen option
          And I select "No" for Naturalized Immigrant option
          And I click continue on the Citizenship page

          Then I click Add Another Family Member
          Then I enter member details with "10101945" date of birth
          And I select "Female" as sex option
          And I mark the Additional member is pregnant as "No"
          And I select "Mother" as relationship option
          And I select "Yes" to Is Member Applying
          And I click continue on Tell us about additional members page
          Then I select "Household" for Residential Address
          And I select "Yes" for CO Resident option
          And I select "No" for Federally Recognized Tribe option
          And I select "No" for Hardship Exemption option
          And I select "No" for Disability option
          And I select "No" to the recently denied medicaid question
          And I select "No" for Incarceration option
          And I click continue on the Add Address page
          Then I select "Yes" for Citizen option
          And I select "No" for Naturalized Immigrant option
          And I click continue on the Citizenship page

          Then I click Add Another Family Member
          Then I enter member details with "10102001" date of birth
          And I select "Male" as sex option
#          And I mark the Additional member is pregnant as "No"
         #  And I select "Son" as relationship option
          And I select "Son" as relationship option
          And I select "Grandson" as relationship one option
          And I select "Yes" to Is Member Applying
          And I click continue on Tell us about additional members page
          Then I select "Household" for Residential Address
          And I select "Yes" for CO Resident option
          And I select "No" for Federally Recognized Tribe option
          And I select "No" for Hardship Exemption option
          And I select "No" for Disability option
          Then I select "No" for Foster care in state of Colorado
          And I select "No" to the recently denied medicaid question
          And I select "No" for Incarceration option
          And I click continue on the Add Address page
          Then I select "Yes" for Citizen option
          And I select "No" for Naturalized Immigrant option
          And I click continue on the Citizenship page


          Then I click Add Another Family Member
          Then I validate I am on the "Add Member" page
          Then I enter member details with "10102007" date of birth
          And I select "Male" as sex option
         # And I mark the Additional member is pregnant as "No"
          And I select "Son" as relationship option
          And I select "Grandson" as relationship one option
          And I select "Brother" as relationship two option
          And I select "Yes" to Is Member Applying

          And I click continue on Tell us about additional members page
          Then I select "Household" for Residential Address
          And I select "Yes" for CO Resident option
          And I select "No" for Federally Recognized Tribe option
          And I select "No" for Hardship Exemption option
          And I select "No" for Disability option
          # Then I select "No" for Foster care in state of Colorado
          And I select "No" to the recently denied medicaid question
          And I select "No" for Incarceration option
          And I click continue on the Add Address page
          Then I select "Yes" for Citizen option
          And I select "No" for Naturalized Immigrant option
          And I click continue on the Citizenship page

#          Then I click edit basic information icon for member 1
#          And I select "Mother" as relationship option
#          And I select "Grandmother" as relationship option
#          And I select "GrandMother" as relationship option
#          And I click continue on Tell us about additional members page
#          And I click continue on the Add Address page
#          And I click continue on the Citizenship page


          Then I click continue on family overview page
          And I Apply for no financial help
          Then I select "MoveToCO" QLCE on tell us about life changes page
          Then I click on Save and Continue
          Then I Declare as Tax Household 1
          And I click Continue on the Declarations And Signature Page
          And I wait for hold on content to disappear
          Then I click on view results and shop
          And I click continue on application results page
          And I wait for hold on content to disappear
          Then I validate I am on the "Start Shopping" page
#          Then I verify text on start shopping page
          Then I click continue on start shopping page
          Then I validate I am on the "Grouping Members Medical" page
#          And I verify text on Medical grouping page
          Then I click on edit enrollment groups link
          And I wait for hold on content to disappear
          Then I validate I am on the "Edit Grouping Members Medical" page
          And I count 3 medical groups on this page
          And I validate there is create new group link
          Then I drag and drop a member to make new group
          Then I validate I am on the "Edit Grouping Members Medical" page
          Then I click save button to save the groups
          Then I get error message as groups are invalid
#          And I click Cancel button on Edit Grouping Members Medical page
#          Then I validate I am on the "Grouping Members Medical" page