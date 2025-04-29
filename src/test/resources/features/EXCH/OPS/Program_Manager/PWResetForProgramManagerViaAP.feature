@OPS @Exch @ProgramManager
@SLER-2383
Feature: Activate, suspend and reset password for program manger via admin Portal

  @SLER-2383
  Scenario: Activate, suspend and reset password for program manger via admin Portal
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "7765564002" "3269503660" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I click the "Manage Account Access" on the AP program manager dashboard

#  Suspend Account
    And I switch to the tab number 1
    Then I check on checkbox account and click on save
    Then I verify success message is displaying
    Then I wait for 500 milliseconds
    And I validate the account Status is "Suspended" in AP program manager page

# Activate Account
    Then I check on checkbox account and click on save
    Then I verify success message is displaying
    Then I wait for 500 milliseconds
    And I validate the account Status is "Active" in AP program manager page

# Reset Password
    When I check on Reset user's password checkbox and click on save
    Then I verify success message is displaying
    And I close current tab and switch back to previous tab
    And I logout from Admin Portal
    Then I open outlook Tab
    Then I switch to the tab number 0

    And I close current tab and switch back to previous tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "Password Reset Link" in "English"
    Then I click the password reset link
    Then I delete the open notice
    And I switch to the tab number 2
    And I enter the new password in create new password page
    Then I validate I am on the "Login" page
    And  I login as individual with password reset code to any env QA "ajmalhsn@test.com" STG "carrimautomation+AssistersInc@gmail.com"
    And  I validate I am on the "MFA" page
    Then I switch to the tab number 1
    And I wait for 500 milliseconds
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I switch to the tab number 1

    Then I enter the MFA code and click Verify
    Then I validate I am on the "assistnet dashboard" page
    Then I click on broker userName and logout

    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "7765564002" "3269503660" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I click View Reports button
    And I switch to the tab number 3
    And I validate I am on the "Account Activity" page
    Then I validate the name in QA "Ajmal Hussain" or stg "Assisters Incorporated" exist in the header of activity report Page
    And I validate the accountID in QA "3269503660" or stg "7765564002" and userType is "PROGRAM_MANAGER"
    And I wait for 500 milliseconds
    Then I verify "ID_PW_RESET_AP" and following events are displaying as "todays date within last 10 min timestamp" "C4test.aduser12.." "C4testaduser123.." "Password Reset via Admin .." "Response" "SUCCESS"
    Then I verify "UI_PASSWORD_RESETLIN.." and following events are displaying as "todays date within last 10 min timestamp" "EO_LOGIN_PORTAL" "EO_LOGIN_PORTAL" "User initiated Password R.." "UI_PASSWORD_RES.." "Password Reset"
    Then I verify "UI_PASSWORD_CHANGED" and following events are displaying as "todays date within last 10 min timestamp" "EO_LOGIN_PORTAL" "EO_LOGIN_PORTAL" "User has updated their Pa.." "UI_PASSWORD_CHA.." "Password Changed"











