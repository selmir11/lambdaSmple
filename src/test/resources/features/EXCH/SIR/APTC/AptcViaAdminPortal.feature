@SIRRegression
Feature:APTC tests by enrolling in a plan through Admin Portal "OBO"

  @SLER-778-WIP @RT-1618
  Scenario: Account creation, shopping, enrolling in a plan through Admin Portal "OBO" and validating the aptc and APTC Re-calculating with family of 4 and Primary person income changed
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
  #Husband
    And I am a member with City "Denver" in State "CO" with dob "01011991" in county "DENVER" with zipcode "80205"
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
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
  #Wife
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011985", "Female" and applying "Yes"
      | Primary:Spouse |
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
  #Son
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Son", "12312021", "Male" and applying "Yes"
      | Primary:Son |
      | Spouse:Son  |
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
  #Daughter
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "05152017", "Female" and applying "Yes"
      | Primary:Daughter |
      | Spouse:Daughter  |
      | Son:Sister       |
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
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Financial Help" page
    And I Apply for financial help
    Then I validate I am on the "Employment Info" page
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "3500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Employment Info" page
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I validate I am on the "Tax status" page
    And I select the option "No" to claim as dependent
    And I select the option "Yes" to file federal income tax return next year
    And I select "Married filing jointly" tax filing status
    And I select spouse to file taxes jointly
    And I select "Yes" to claim dependents
    And I select the first dependent
    And I select the second dependent
    And I select the third dependent
    And I click save and continue on tax status page
# ohi
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on No Thanks on good news page
    Then I validate I am on the "Application History" page
    Then I validate the aptc section doesn't exist on the application history page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page
    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    Then I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    Then I click continue on dental plan results page
    Then I validate I am on the "Plan Summary" page
    Then I validate the APTC Credit on the Summary page is "$0.00"
    And I click continue on plan summary page
    And I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page
#  #QA Only Step
#  Then I click all done from payment portal page
    Then I validate I am on the "Initial Payment" page
    Then I select make payment button to pay the premium
    Then I validate I am on the "Payment Selection" page
    And I select the Money Order button
    And I click continue on payment selection page
    Then I validate I am on the "Initial Payment" page
    Then I select make payment button to pay the premium
    Then I validate I am on the "Payment Selection" page
    And I select the Money Order button
    And I click continue on payment selection page
    Then I validate I am on the "Initial Payment" page
    And I click continue on initial payment page
    Then I validate I am on the "Congratulations - What's Next?" page
    And I click on Go To Welcome Page Button on whats next page
    Then I validate I am on the "Account Overview" page
    Then I click on make changes button
    Then I validate I am on the "Let us guide you" page
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "MovedToColorado" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    And I click continue on the Add Address page
    Then I validate I am on the "Citizenship" page
    And I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    And I click on the Member Row 1
    Then I validate I am on the "Application Summary" page
    Then I select the Edit Income link
    Then I validate I am on the "Employment Summary" page
    Then I click Edit on Income Summary row 1
    Then I validate I am on the "Employment Info" page
    And I edit the income level to "4500000"
    And I click continue on the Employment Info Page
    Then I validate I am on the "Employment Summary" page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    Then I click continue on the Additional Income page
    Then I validate I am on the "Deductions" page
    Then I click continue on the Deductions page
    Then I validate I am on the "Income Summary" page
    Then I click the save and continue button on the Income Summary Detail page
    Then I validate I am on the "Tax status" page
    And I select the first dependent
    Then I click save and continue on tax status page
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Elmo Other Health Insurance" page
    Then I select "None of these" as ELMO health insurance option
    Then I select "None of these" as ELMO health insurance option
    Then I click continue on the ELMO health insurance page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I validate I am on the "Tell us about life changes" page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on No Thanks on good news page
    Then I validate I am on the "Application History" page
    Then I validate that my APTC value is "$802.29/mo"
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I validate that my Tax Household's APTC value is "$802.29/mo"
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical page
    Then I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    Then I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    Then I click continue on dental plan results page
    Then I validate I am on the "Plan Summary" page
    Then I validate the APTC Credit on the Summary page is "-$802.29"
    And I click on Sign Out in the Header for "Elmo"