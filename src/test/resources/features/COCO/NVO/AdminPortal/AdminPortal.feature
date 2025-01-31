@NVOCoCoRegression
Feature: Admin Portal Validations

  Background: I go the login portal
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page


    @SLCR-670
    Scenario: Admin portal validations for account creation in coco
      And I click on Sign Out in the Header for "Elmo"

      And I open the login page on the "admin" portal
      And I refresh the page
      And I validate I am on the "Login" page
      When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
      And I validate I am on the "Admin search" page
      And I select "coco" checkbox on Admin Portal Dashboard
      And I search for user and click email from search results
      Then I click on view button for "Account Activity" report
      Then I validate I am on the "Account Activity" page
      Then I validate the account activity record for "Account Creation" for "adminportal"

    @SLCR-671
    Scenario: Admin portal validations for primary person information update
      And I apply for the current year in CoCo
      Then I validate I am on the "Find Expert Help" page
      And I click Continue on my own button from Manage who helps you page
      Then I click EditUpdate on Family Overview page for "Primary"
      And I enter details on tell us about yourself page and continue with "01011991", "Female", and applying "Yes"
      And I enter my residential address "1234 Road", "Denver", "CO", "80205", "Denver"
      And I select "Yes" for mailing address option
      And I select "Yes" for live in Colorado option
      And I click continue on the Add info for yourself page
      Then I validate I am on the "Elmo Race and Ethnicity" page
      And I click on the Username in the "CoCo" Header
      Then I validate I am on the "My Profile" page
      And I click on Make Changes Button in CoCo
      And I update the contact email address on my profile page in coco
      And I click on Save Button on My profile CoCo
      And I wait for hold on content to disappear
      Then I validate I am on the "My Profile" page
      And I click on Sign Out in the Header for "Elmo"

      Given I open the login page on the "admin" portal
      And I validate I am on the "Login" page
      When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
      And I validate I am on the "Admin search" page
      And I select "coco" checkbox on Admin Portal Dashboard
      And I search for user and click email from search results
      Then I click on view button for "Account Activity" report
      Then I validate I am on the "Account Activity" page
      Then I validate the account activity record for "Email Update" for "adminportal"
      And I close current tab and switch back to previous tab
      Then logout from Admin Portal

      Given I open the login page on the "login" portal
      And I validate I am on the "Login" page
      And I enter valid credentials to login
      Then I click continue signing in on the CAC Screener page
      Then I validate I am on the "CoCo Welcome" page
      And I click on the Username in the "CoCo" Header
      Then I validate I am on the "My Profile" page
      And I click on Make Changes Button in CoCo
      And I update the contact home phone number on profile page in coco
      And I update the contact mobile phone number on profile page in coco
      And I change the Preferred Contact Method to "Mail" in CoCo
      And I change Preferred Language Contact Method to "Spanish" in CoCo
      And I click on Save Button on My profile CoCo
      And I wait for hold on content to disappear
      Then I validate I am on the "My Profile" page
      And I click on Sign Out in the Header for "Elmo"

      Given I open the login page on the "admin" portal
      And I validate I am on the "Login" page
      When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
      And I validate I am on the "Admin search" page
      And I select "coco" checkbox on Admin Portal Dashboard
      And I search for user and click email from search results
      Then I click on view button for "Account Activity" report
      Then I validate I am on the "Account Activity" page
      Then I validate the account activity record for "Info update" for "adminportal"
      Then logout from Admin Portal

  @SLCR-718
  Scenario:ELIG-As a system in CoCo, I should record in the audit event log when an account's primary contact is changed[CCRT-437]
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    And I enter details on tell us about yourself page and continue with "01011991", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
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
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Spouse", "03051989", "Female", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "103 COCO DRIVE", "DENVER", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Asian or Asian American" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Son", "04212013", "Female", and applying "Yes"
      | Primary:Child or Other dependent |
      | Spouse:Child or Other dependent |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "103 COCO DRIVE", "DENVER", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Asian or Asian American" for race and ethnicity for "Son"
    And I click continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "Birth" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page

    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    And I click change primary contact on my profile page
    Then I update "Spouse" as primary member coco
    And I wait for hold on content to disappear
    Then I validate I am on the "My Profile" page
    And I click on Sign Out in the Header for "Elmo"

  #ADMIN portal
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results

    And I click "Manage Account Details" from account summary container
    Then I validate I am on the "account details" page
    Then I validate the primary member details on the account details page
    And I close current tab and switch back to previous tab
    And I click on view button for "Account Activity" report
    Then I validate I am on the "Account Activity" page
    Then I validate the account activity record for "primary person change" for "adminportal"
    Then I validate the account activity record for "primary person change" for "individualportal"
    Then I validate member id of all members
    Then logout from Admin Portal



