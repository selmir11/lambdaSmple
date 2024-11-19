@BrokerPortalClients @port @SLER-916
Feature: Broker Portal OBO - Submit NFA Application and enroll in a plan

  @SLER-916
  Scenario: : Individual account creation and broker authorization
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011983" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    And I click on Find a Broker
    Then I Search authorized Broker "Amethyst"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I click on Sign Out in the Header for "WhoHelpsYouPage"
  @SLER-916
  Scenario: : Agency owner working OBO to submit an NFA application and enroll in a plan
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I login as Broker User "Amethyst.Broker@invalid.com" password "ALaska13!"

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

    Then I validate I am on the "Add Address" page
    And I enter member with address line1 "1234 Road " in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    Then I select "No" for Hardship Exemption option
    Then I select "No" for Disability option
    Then I select "No" to the recently denied medicaid question
    Then I select "No" for Incarceration option
    And I click continue on the Add Address page

    Then I validate I am on the "Ethnicity and Race" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
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

    Then I click on the Colorado Connect or C4 Logo in the "NonElmo" Header
    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I search for clients
    And I click on first client search result
    Then I verify that my client's current status is "ELIGIBILITY ONLY"
    And I click "manage" the client

    Then I validate I am on the "Account Overview" page
    And I click on Find a Plan in the "NonElmo" Header
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I click continue on start shopping page
    And I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    Then I select first dental plan
    Then I click continue on dental plan results page
   Then I validate I am on the "planSummaryMedicalDental" page
    And I set "Medical" Plans premium amount
    And I set "Dental" Plans premium amount
    And I click continue on plan summary page

    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox

    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page

    Then I click all done from payment portal page OBO

    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I search for clients
    And I click on first client search result
    Then I verify that my client's current status is "POLICY SUBMITTED"
    Then I validate the premium amount displayed for my client