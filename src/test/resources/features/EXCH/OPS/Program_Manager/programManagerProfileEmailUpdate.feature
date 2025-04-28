@OPS @Exch @ProgramManager
Feature: Activate, suspend and reset password for program manger via admin Portal

  @SLER-2430
  Scenario: Activate, suspend and reset password for program manger via admin Portal
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "6203570527" "2813006563" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I click the "Edit Profile" on the AP program manager dashboard
    And I validate the button save and cancel are displayed in AP program manager dashboard
    Then I validate the error message for empty email is displayed in AP program manager dashboard
    Then I click the "Edit Profile" on the AP program manager dashboard
    Then I update the email adresse "c4assistorportal" @outlook.com of the program manager
    Then I click the save options "Save" on the AP program manager dashboard
    And I validate the Update successful text is displayed
    Then I set the email value for program manager STG "6203570527" QA "2813006563"
    Then I validate the assistnet email in DB
    Then I logout from Admin Portal

