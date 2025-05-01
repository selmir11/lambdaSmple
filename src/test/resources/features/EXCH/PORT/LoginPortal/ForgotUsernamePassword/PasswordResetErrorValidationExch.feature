@ForgotUsernamePassword
Feature:Password reset error validation English/Spanish

  @SLER-1801
  Scenario:Password reset error validation English/Spanish
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "testing.soukaina"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "Account Overview" page
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I click on Sign Out in the Header for "Portal"
    Then I wait for 1000 milliseconds
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
    And I switch to the tab number 1
    Then I validate create new password must contain at least 8 characters error message in "English"
    Then I validate create new password must contain 1 uppercase character error message in "English"
    Then I validate create new password must contain 1 lowercase character error message in "English"
    Then I validate create new password must contain 1 number error message in "English"
    Then I validate the password cannot contain part of the "username" error message in "English"
    Then I validate the password cannot contain part of the "previous password" error message in "English"
    Then I validate the password cannot contain part of the "first name" error message in "English"

    And I change the language from header to "Spanish Login"
    Then I validate create new password must contain at least 8 characters error message in "Spanish"
    Then I validate create new password must contain 1 uppercase character error message in "Spanish"
    Then I validate create new password must contain 1 lowercase character error message in "Spanish"
    Then I validate create new password must contain 1 number error message in "Spanish"
    Then I validate the password cannot contain part of the "username" error message in "Spanish"
    Then I validate the password cannot contain part of the "previous password" error message in "Spanish"
    Then I validate the password cannot contain part of the "first name" error message in "Spanish"

    And I change the language from header to "English"
    And I enter the new password in create new password page

    # bug 7331
    Then I validate I am on the "Login" page
    And  I login as individual with password reset code
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"