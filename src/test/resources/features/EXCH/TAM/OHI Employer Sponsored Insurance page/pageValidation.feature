@TAM
Feature: Page Text-Other Health Insurance Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-239 @PageTextOtherHealthInsurancePage
  Scenario: SLER-239 I Validate saved data on the ESI page for multiple members
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
    And I get the Primary Member ID
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter member details with "10101975" date of birth
    And I select "Female" as sex option
    And I mark the Additional member is pregnant as "No"
    And I select "Spouse" as relationship option
    And I select "Yes" to Is Member Applying
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
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter member details with "10102001" date of birth
    And I select "Male" as sex option
    And I select "Son" as relationship option
    And I select "Son" as relationship one option
    And I select "Yes" to Is Member Applying
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    Then I select "No" for Foster care in state of Colorado
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "2500000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
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
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    Then I select "Yes" to claim dependents
    And I select the "2" option for Who Will Claim as Dependents
    And I click save and continue on tax status page
    Then I select "ESI" as health insurance option and continue
    Then I select the employer on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "250.00" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as the last day of the current month on the ESI page
    Then I select the Are you voluntarily ending "Yes" button on the ESI page
    Then I click "No" for offer family plans question
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    And I click on Apply for Coverage in the "NonElmo" Header

    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Find Expert Help page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Citizenship page
    Then I edit income for Primary member
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    And I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    And I validate I am on the "Tax status" page
    And I click save and continue on tax status page
    Then I click continue on the Other Health Insurance page
#Step 1
    And I validate I am on the "ESI" page
    And I verify offer family health plans is "No" on the ESI page
#Step 2
    Then I click continue on the ESI page
#Step 3
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as health insurance option
#Step 4
    Then I click Go Back on the Other Health Insurance page
    Then I click continue on the Other Health Insurance page
    And I validate I am on the "ESI" page
    And I verify offer family health plans is "No" on the ESI page
    Then I click "Yes" for offer family plans question
    Then I enter "650.00" for offer family amount question
    Then I click enrollment status for the members
      |   enrollmentStatus    |
      |      Enrolled         |
      |      Offered          |
#Step 5
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as health insurance option
#Step 6
    Then I click Go Back on the Other Health Insurance page
    Then I click continue on the Other Health Insurance page
    And I validate I am on the "ESI" page
    And I verify offer family health plans is "Yes" on the ESI page
    And I verify offered family amount is "650.00" on the ESI page
    Then I verify enrollment status for the members
      |   enrollmentStatus    |
      |      Enrolled         |
      |      Offered          |
#Step 7
    Then I enter "800.00" for offer family amount question
    Then I click enrollment status for the members
      |   enrollmentStatus    |
      |      Offered          |
      |      No Option        |
    Then I click continue on the ESI page
    And I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as health insurance option
    Then I click Go Back on the Other Health Insurance page
    Then I click continue on the Other Health Insurance page
    And I validate I am on the "ESI" page
    And I verify offer family health plans is "Yes" on the ESI page
    And I verify offered family amount is "800.00" on the ESI page
    Then I verify enrollment status for the members
      |   enrollmentStatus    |
      |      Offered          |
      |      No Option        |

    And I click on Sign Out in the Header for "Elmo"




