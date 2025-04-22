@port @APAccountActivityExch
Feature: Exchange individual password reset account activity code validation via Admin Portal

  @SLER-2334
  Scenario: Exchange individual password reset account activity code validation via Admin Portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "testing.soukaina"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "Account Overview" page
    Then I click on Sign Out in the Header for "NonElmo"

    And I validate I am on the "Login" page
    Then I click create forgot "password"
    And I validate I am on the "Forgot my password" page
    Then I enter valid email of the account created
    And I click submit button
    Then I verify notice is sent to the client text in "English"

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "Password Reset Link" in "English"
    Then I click the password reset link
    Then I delete the open notice
    And I sign out of Outlook
    Then I switch to the tab number 1
    And I enter the new password in create new password page

    #Admin Portal user verifying the customer's account activity
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I search for user and click email from search results
    Then I wait for 200 milliseconds
    Then I validate I am on the "Admin Portal individual dashboard" page
    Then I click on view button for "Account Activity" report
    And I switch to the tab number 2
    Then I validate I am on the "Account Activity" page
    Then I wait for 1000 milliseconds
    And I validate Account Activity title row
    Then I validate "UI_ACCT_CREATED" event code and description "Account created" in activity event report
    Then I validate "UI_PASSWORD_RESETLIN.." event code and description "User initiated Password R.." in activity event report
    Then I validate "UI_PASSWORD_CHANGED" event code and description "User has updated their Pa.." in activity event report
