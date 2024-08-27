Feature: Enroll a in a plan 8 HH
  @SLER-832  
  Scenario: : EXCH intial application
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "MGC4testing"@outlook.com
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "07271963" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    And I click on Find a Broker
    Then I Search authorized Broker "EnrIntial Broker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page

    Then I select "Female" as sex option
    And I select "No" as pregnancy option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "PO Box 1545" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
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

    #1Member

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011983", "Male" and applying "No"
      |Primary:Spouse|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "New" for Residential Address
    And I enter the new residential address details
      | addressLine1           | addressLine2 | city    | state | zipcode | county  | dob |
      | 501 DIFF Drive         | Unit 23      | Boulder | CO    | 80020   | BOULDER |01011983 |
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I click continue on the Add Address page


    #2Member (spouse)
    Then I click Add Another Family Member
    Then I enter details on tell us about additional members of your household exch page and continue with "SonOne", "06281996", "Male" and applying "Yes"
      |Primary:Son|
      |Spouse:Son |
    And I click continue on Tell us about additional members page

    Then I validate I am on the "Add Address" page
    Then I select "New" for Residential Address
    And I enter the new residential address details
      | addressLine1           | addressLine2 | city    | state | zipcode | county  | dob |
      | 900 Jailhouse Rock     | Unit 23      | Denver  | CO    | 80205   | DENVER  |06281996 |

    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "Yes" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    #member3

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "SonTwo", "03052010", "Male" and applying "Yes"
      |Primary:Son|
      |Spouse:Son |
      |SonOne:Brother|
    And I click continue on Tell us about additional members page

    Then I validate I am on the "Add Address" page
    Then I select "501 DIFF Drive" specific Address
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

    #member 4

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Daughter", "12142001", "Female" and applying "Yes"
      |Primary:Daughter|
      |Spouse:Daughter |
      |SonOne:Sister|
      |SonTwo:Sister|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "1234 Road" specific Address
    And I select "Yes" for CO Resident option
    And I select "Yes" for Federally Recognized Tribe option
#Tribe Selection to be added
    Then I add the tribe details
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" for Foster care in state of Colorado
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page

    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page

    #Member 5

    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Nephew", "0151995", "Male" and applying "Yes"
      |Primary:Nephew|
      |Spouse:Nephew |
      |SonOne:Cousin|
      |SonTwo:Cousin|
      |Daughter:Cousin|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "1234 Road" specific Address
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

    #member6


    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Niece", "05051993", "Female" and applying "Yes"
      |Primary:Niece|
      |Spouse:Niece |
      |SonOne:Cousin|
      |SonTwo:Cousin|
      |Daughter:Cousin|
      |Nephew:Sister|
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "1234 Road" specific Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "Yes" for Disability option
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
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "47000.00" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue

    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "1234 town" and city as "Denver" and state as "CO" and zipcode as "80205" and income "600000.00" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I select the projected income option "No" and continue

    #Mem3
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue


  #Mem4
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue

    #Mem5
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue

     #Mem6
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue

     #Mem7
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I click None of these as additional income option and continue
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
    And I select the fourth dependent
    And I select the fifth dependent
    And I select the sixth dependent
    And I click save and continue on tax status page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page

    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page

    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue

    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on No Thanks on good news page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I select "member1" "Yes" for Tobacco Use
    Then I click continue on start shopping page
    Then I validate I am on the "Grouping Members Medical" page
    And  I get the details of medical group Members
    Then I click continue on grouping Members Medical page
    And I validate I am on the "Medical Plan Results" page
    And  I select the "Cigna Connect Colorado Option Bronze" medical plan but skip for "Daughter"
    And  I select the "Cigna Connect Colorado Option Bronze" medical plan but skip for "Daughter"
    And  I select the "Cigna Connect Colorado Option Bronze" medical plan but skip for "Daughter"
    And  I select the "Cigna Connect Colorado Option Bronze" medical plan but skip for "Daughter"
    Then I validate I am on the "Grouping Members Dental" page
    Then I click continue on grouping Members Dental page
    And  I select the "Anthem Dental Family" Dental plan but skip for "Daughter"
    And  I select the "Anthem Dental Family" Dental plan but skip for "Daughter"
    And  I select the "Anthem Dental Family" Dental plan but skip for "Daughter"
    And  I select the "Anthem Dental Family" Dental plan but skip for "Daughter"
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on plan summary page
    And I validate I am on the "Financial Help Agreements" page
    And I select the terms and agreements checkbox
    And I enter householder signature on the Financial Help Agreements page
    And I click continue on Financial Help Agreements page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page

    Then I click all done from payment portal page

    Then I validate I am on the "Account Overview" page
    And I click on ClickHere link for "My Documents"
    And I click on download enrolment document
    Then I click on the Colorado Connect or C4 Logo in the "My Policies" Header
    Then I validate I am on the "My Account Overview" page
    And I Validate the correct enrolled plans are displayed on account overview page
    

    #Gmail Verification
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "MGC4testing@outlook.com" and "ALaska12!"
    Then I open the notice "(EN-002-04)" in "English"
    And I verify the notice Text for "EN-002-04" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook
    And I switch to the tab number 0

    #DbVerification

    And I verify the policy data quality check
    And I verify the data from book of business queue table


















