@OPS @Exch @IndiviualDashboard
Feature: verify Activity Report data on Admin portal

@SLER-2356
Scenario: Verify Activity Header, table names and event code with description [RT-1076]
Given I open the login page on the "admin" portal
And I refresh the page
And I validate I am on the "Login" page
When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
And I validate I am on the "Admin search" page
And I select "individual" checkbox on Admin Portal Dashboard
Then I enter an accountId in any Env "4006908635" "3676508660" to search user
And I click on Search button in AP dashboard page
And I click acct first row from Search Results table in admin portal
And I validate I am on the "Admin Portal individual dashboard" page
Then I click on view button for "Account Activity" report
And I switch to the tab number 1
Then I validate I am on the "Account Activity" page
    And I wait for 3000 milliseconds
Then I verify Primary account holder and account number displays on activity report
And I validate Account Activity title
Then I verify Activity report table column names
Then I validate description are listed in activity report table
    | Purchased and enrolled in.. |
    | Questions and Answers req.. |
    | Shared Eligibility Servic.. |
    | Account created             |
    | Contact Upsert              |
    | ID Proofing requested via.. |
Then I close current tab and switch back to previous tab
And I logout from Admin Portal
 