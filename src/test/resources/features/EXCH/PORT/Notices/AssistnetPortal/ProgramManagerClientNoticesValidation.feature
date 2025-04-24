@port @portNoticeAssistnetPortal
Feature:  As a program manager, I do not want to receive any notices when my client triggers one for their account

  @SLER-1981
  Scenario:  Triggering client notices and verifying they are not being sent to the authorized assister
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "exchange" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "K84VV" or "iaEou"
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header

    And I click on the Username Link Exch
    Then I validate I am on the "My Profile" page
    And I click on Make Changes Button
    And I update the contact email address on profile page
    And I click on Save Button
    And I click on Sign Out in the Header for "Elmo"

    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click create forgot "username"
    And I validate I am on the "forgotUsername" page
    Then I enter information's for Forgot username in STG Firsname "cmlvuwgrc" LastName "cmqpxlofkc" phone "3861629568" accountType "Customer" or QA Firsname "cmwmymnzt" LastName "cmgxfzfjav" phone "3886534824"
    And I validate notice sent successful msg is displayed

    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click create forgot "password"
    And I validate I am on the "Forgot my password" page
    Then I enter valid email to any env QA "carrimautomation+NoFfkmy65@gmail.com" STG "carrimautomation+n607Ymtnk@gmail.com"
    And I click submit button
    Then I verify notice is sent to the client text in "English"

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "AM-011-02" in "English"
    Then I delete the open notice
    Then I open the notice "AM-016-01" in "English"
    Then I delete the open notice
    Then I open the notice "Password Reset Link" in "English"
    Then I click the password reset link
    Then I delete the open notice

    Then I switch to the tab number 3
    And I enter the new password in create new password page
    Then I validate I am on the "Login" page
    And I login as individual with password reset code to any env QA "carrimautomation+NoFfkmy65@gmail.com" STG "carrimautomation+n607Ymtnk@gmail.com"
    Then I validate I am on the "Account Overview" page
    And I click on Sign Out in the Header for "NonElmo"
    And I close current tab and switch back to previous tab
    Then I switch to the tab number 2
    And I sign out of Outlook

    Then I switch to the tab number 0
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "c4assistorportal@outlook.com" and "ALaska12!"
    Then I verify the notice "AM-011-02" doesn't appear
    Then I verify the notice "AM-016-01" doesn't appear
    Then I verify the notice "Password Reset Link" doesn't appear
    And I sign out of Outlook