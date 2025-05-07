@ExchBroker
Feature: OPS: Broker Dashboard: Broker Account Access details and Password Reset - [RT-2728]
  @SLER-2281
  Scenario: SLER-2281 Broker Account Access details tab Reset Password
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    And I refresh the page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "1309040327" "1309007409" to search user
    Then I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "AP Broker dashboard" page
    Then I click on "Manage Account Access" user dashboard button
    Then I verify Account Access details
    And I verify Account status is Password Reset
    When I check on Reset user's password checkbox and click on save
    Then I verify success message is displaying
    And I close current tab and switch back to previous tab
    And I click View Reports button
    Then I wait for 2000 milliseconds
    And I validate Account Activity title row
    Then I verify "ID_PW_RESET_AP" and following events are displaying as "todays date within last 10 min timestamp" "C4test.aduser12.." "C4testaduser123.." "Password Reset via Admin .." "Response" "SUCCESS"
    And I logout from Admin Portal
    Given I open outlook Tab
    Then I sign in to outlook with Valid Credentials "mftestxbzxuvztest@outlook.com" and "ALaska12!"
    Then I open the notice "Password Reset Link" in "English"
    And I verify the notice Text for "AM-016-07" in "English" for "Broker"
    Then I click the password reset link
    Then I delete the open notice
    And I sign out of Outlook