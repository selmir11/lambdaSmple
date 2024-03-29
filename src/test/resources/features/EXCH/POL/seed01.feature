Feature: Seed01 - Exchange

  Background: Seed 01 For Exchange
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
    And I am a member with City "Denver" in State "CO" with dob "10011975" in county "DENVER" with zipcode "80205"
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
    Then I set data from application history page
    Then I click on view results and shop
    Then I validate I am on the "Application Results" page
    Then I click continue on application results page
    Then I click continue on start shopping page
    And I validate I am on the "Medical Plan Results" page
    And I select "Elevate Health Plans Colorado Option Bronze" medical plan
    Then I click continue on medical plan results page
    And I validate I am on the "Dental Plan Results" page
    And I select "Delta Dental of Colorado Family Basic Plan"
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I continue on plan summary page
    Then I select make payment button to pay the premium
    And I click continue on payment selection page
    And I select second make payment button to pay the premium
    And I click continue on payment selection page
    And I click continue on initial payment page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page
    And I click on Go To Welcome Page Button on whats next page
    Then I validate I am on the "Account Overview" page
   # And I Validate the correct enrolled plans are displayed on account overview page (not covered by orion)
    Then I click on ClickHere link for "My Plans"
    Then I validate I am on the "My Policies" page

    And I validate medical plan details from my policies page
    And I validate dental plan details from my policies page
    And I click View Plan History link from medical plan card
    And I validate medical plan details from plan history
    And I click on to Back to Current Plan Details button
    And I click View Plan History link from dental plan card
    And I validate dental plan details from plan history
    And I click on Sign Out in the Header for "Elmo"

    @RT-2246
    Scenario:ENR-EXCH: DEMOGRAPHIC CHANGE (SUBSCRIBER) - IDENTIFYING DETAILS - SSN
      And I validate the member details from few tables
      And I validate member details from ob834_details table
  # Any validations needed from both the above tables as well as the SFTP File here? #
     # And I validate file exists on sftp server with location "/outboundedi"
      # And I validate the contents of the file
       Given I open the login page on the "login" portal
        And I validate I am on the "Login" page
        And I enter valid credentials to login
        Then I validate I am on the "Account Overview" page
          Then I click on make changes button
        Then I select "No" option on the Let us guide you page
        And I click on save and continue button
       Then I click on continue with  application button on Before you begin page
       And I report "MovedToColorado" and click continue
       Then I validate I am on the "Find Expert Help" page
       Then I click Continue on my own button from Find Expert Help page
      Then I update SSN number to new SSN number
      Then I click continue on Tell us about yourself page
      Then I click continue on the Add Address page
      Then I click continue on the Citizenship page
      Then I validate I am on the "Family Overview" page
      Then I verify the family overview table is present
      Then I click continue on family overview page
      Then I validate I am on the "Tell us about life changes" page
      Then I select "MoveToCO" QLCE on tell us about life changes page
      Then I click on Save and Continue
      Then I validate I am on the "EXCH Declarations and Signature" page
      Then I Declare as Tax Household 1
      And I click Continue on the Declarations And Signature Page
      And I wait for hold on content to disappear
##      When member records are processed by OB834 EDI process
##      Then member policy record for plan "Elevate Health Plans Colorado Option Bronze" should have values:
##        | firstNamePrefix | lastNamePrefix | policy_status | policy_start_date | policy_end_date  | member_financial_start_date | member_financial_end_date |
##        | TestSubscriber  | User           | SUBMITTED     | [PLANYEAR-01-01]  | [PLANYEAR-12-31] | [PLANYEAR-01-01]            | [PLANYEAR-12-31]          |
##      And member policy record for plan "Delta Dental of Colorado Family Basic Plan" should have values:
##        | firstNamePrefix | lastNamePrefix | policy_status | policy_start_date | policy_end_date  | member_financial_start_date | member_financial_end_date |
##        | TestSubscriber  | User           | SUBMITTED     | [PLANYEAR-01-01]  | [PLANYEAR-12-31] | [PLANYEAR-01-01]            | [PLANYEAR-12-31]          |
##      And member PRE-EDI (OB834) record for plan "Elevate Health Plans Colorado Option Bronze" should have values:
##        | firstNamePrefix | lastNamePrefix | edi_status   | maintenance_type_code | benefit_begin_date | benefit_end_date | financial_effective_date | hd_maint_type_code  | maintenance_reas_code | sponsor_id | member_ssn | incorrect_entity_id_code | incorrect_id_code_qualifier | incorrect_id_code | addl_maint_reason  |
##        | TestSubscriber  | User           | EDI_COMPLETE | 001                   | [PLANYEAR-01-01]   | [PLANYEAR-12-31] | [PLANYEAR-01-01]         | 001                 | 25                    | 123456789  | 123456789  | 70                       | 34                          | 879654321         | DEMOGRAPHIC CHANGE |
##      And member PRE-EDI (OB834) record for plan "Delta Dental of Colorado Family Basic Plan" should have values:
##        | firstNamePrefix | lastNamePrefix | edi_status   | maintenance_type_code | benefit_begin_date | benefit_end_date | financial_effective_date | hd_maint_type_code  | maintenance_reas_code | sponsor_id | member_ssn | incorrect_entity_id_code | incorrect_id_code_qualifier | incorrect_id_code | addl_maint_reason  |
##        | TestSubscriber  | User           | EDI_COMPLETE | 001                   | [PLANYEAR-01-01]   | [PLANYEAR-12-31] | [PLANYEAR-01-01]         | 001                 | 25                    | 123456789  | 123456789  | 70                       | 34                          | 879654321         | DEMOGRAPHIC CHANGE |
##      And member's OB834 files should be valid
##      And log out of application
#
