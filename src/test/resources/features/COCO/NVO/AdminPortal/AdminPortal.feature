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
      Then I validate the account activity record for "Account Creation"

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
      Then I validate the account activity record for "Email Update"
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
      Then I validate the account activity record for "Info update"
      Then logout from Admin Portal



