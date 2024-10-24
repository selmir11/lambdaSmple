@SLCR-137
Feature: Regression Tests that require Seed 1
# verification WIP @test
  Scenario:Seed 01 For COCO- Single Applicant with Income of $19k

    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click Primary EditUpdate on the Family Overview page
    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "101 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "No" for mailing address option
    And I enter my mailing address "P. O. Box 1454", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select None of these as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    Then I click continue on coco start shopping page
    Then I validate I am on the "Medical Plan Results" page
    And I select "Cigna Connect Colorado Option Bronze" coco medical plan
    And I click Continue on the Medical Plans Page CoCo
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page
    And I click on Sign Out in the Header for "Elmo"

    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin dashboard" page
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    Then I click on "Manage Plans" user dashboard button
    Then I click Make Changes Medical button
    And I update the Coverage Start date of member
      | 1:01012024 |
    And I update the Financial Start date of member
      | 1:01012024 |
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then I close current tab and switch back to previous tab
    And logout from Admin Portal

    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "CoCo Welcome" page
   # And I click on "My Plans" link on welcome page
   # Then I validate I am on the "My Policies" page
   # And Validate selected medical plan for "Primary" is "Cigna Connect Colorado Option Bronze"

    And I validate the member details from policy tables
    And I validate member details from ob834_details table
      | maintenance_type_code | hd_maint_type_code | maintenance_reas_code | addl_maint_reason | sep_reason |
      | 021                   | 021                | EC                    |                   |  NEW_CO_RESIDENT |
    And I download the files from sftp server with location "/outboundedi/"
    And I validate the ob834 files should not be empty
    And I validate the ob834 files should have the values
      | LX | N1 75              | REF       |
      | 1  | PRE AMT 1          | 322.00    |
      | 2  | CSR AMT            | 0.00      |
      | 3  | RATING AREA        | 3         |
      | 4  | SOURCE EXCHANGE ID | COHBE     |
      | 5  | TOT RES AMT        | 322.00    |
      | 6  | PRE AMT TOT        | 322.00    |

    And I verify the policy data quality check with Policy Ah keyset size 2
    And I verify the data from book of business queue table with "POLICY_SUBMISSION" as event type

#  Then I select year "2024" from My Current Plan container
#  And I Validate the correct enrolled plans are displayed on account overview page
#  Then I click on ClickHere link for "My Plans"
#  Then I validate I am on the "My Policies" page
