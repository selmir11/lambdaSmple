@SLER-779 @BrokerPortalBOB
Feature: Update book of business householdContactUpdate flow to also change householdContactInd

  @BOB  @SLER-779
  Scenario: Update book of business householdContactUpdate flow to also change householdContactInd
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
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
    Then I validate the Find a Certified Broker near you page title in "English"
    Then I Search authorized Broker "Maggie Walker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
    And I validate current Broker text exists
    And I click on Sign Out in the Header for "WhoHelpsYouPage"

#Agency owner working OBO to submit an FA application and enroll in a plan
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+MWalkerSTG@outlook.com" password "ALaska12!" and "C4PortTesting+MaggieWalker@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I search for clients
    And I click on first client search result
    Then I verify that my client's current status is "NO ELIGIBILITY"
    And I click "manage" the client
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page

    And I report "Birth" and click continue

    Then I verify Manage who helps you header text in "English"
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
    And I get the Primary Member ID
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "01011980", "Female" and applying "Yes"
      |Primary:Spouse|
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
    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
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
    And I select "Yes" to claim dependents
    And I select the "1" option for Who Will Claim as Dependents
    And I click save and continue on tax status page
    And I validate I am on the "Elmo Other Health Coverage" page
    Then I select "None of these" as ELMO health coverage option
    And I click continue on the ELMO health coverage page
    Then I select "None of these" as ELMO health coverage option
    And I click continue on the ELMO health coverage page
    Then I validate I am on the "Family Overview" page
    Then I click continue on family overview page
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I validate I am on the "EXCH Declarations and Signature" page
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I validate I am on the "Good News" page
    Then I click on "No Thanks" on good news page
    Then I validate I am on the "Application History" page
    And I click on view results and shop
    Then I validate I am on the "Application Results" page
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click "No" to the Tobacco usage question on start shopping page for "Spouse" coco
    And I click continue on start shopping page

    Then I validate I am on the "Medical Enrollment Groups" page
    And I click continue on grouping Members Medical page
    And I select the first medical plan
    And I click continue on medical plan results page
    Then I validate I am on the "Medical Enrollment Groups" page
    Then I click continue on grouping Members Dental page
    And I validate I am on the "Dental Plan Results" page
    And I select first dental plan
    And I click continue on dental plan results page
    Then I validate I am on the "Plan Summary" page
    And I click continue on plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page
    Then I validate I am on the "Pay now" page
    Then I click all done from payment portal page OBO
    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I wait for 9000 milliseconds
    And I search for clients
    And I click on first client search result
    Then I verify that my client's current status is "POLICY SUBMITTED"
    And I click "manage" the client
    Then I validate I am on the "Account Overview" page
    And I click on the Username Link Exch
    Then I validate I am on the "My Profile" page
    And I click change primary contact on my profile page
    Then I update "Spouse" as primary member
    Then I validate I am on the "My Profile" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I search for clients
    And I click on first client search result
    Then I verify that the client name match the primary contact
    And I verify the account holder Name in BOB DB










