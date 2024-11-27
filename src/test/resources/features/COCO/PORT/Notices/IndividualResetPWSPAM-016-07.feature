@portNotice @SLCR-434
Feature: Trigger COCO IND Password reset and confirmation Notices AM-016-07 AND AM-016-08

    Scenario: Trigger COCO IND Password reset and confirmation Notices AM-016-07 AND AM-016-08 Spanish
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco Spanish" account creation with email "testing.soukaina"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "CAC Screener" page
    Then I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page
    Then I click create forgot "password"
    Then I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I validate I am on the "Forgot my password" page
    Then I enter valid email of the account created
    And I click submit button
    Then I verify notice is sent to the client text in "Spanish"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "Enlace para el restablecimiento de la contraseña" in "Spanish"
    And I verify the notice Text for "AM-016-07" in "Spanish" for "Coco"
    Then I click the password reset link
    Then I delete the open notice
    And I sign out of Outlook
    Then I switch to the tab number 1
    And I enter the new password in create new password page
    Then I validate I am on the "Login" page
    And  I login as individual with password reset code
    Then I validate I am on the "CAC Screener" page
    And I click on Sign Out in the Header for "Elmo"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "Confirmación: Restablecimiento de la contraseña de la cuenta" in "Spanish"
    And I verify the notice Text for "AM-016-08" in "Spanish" for "Coco"
    Then I delete the open notice
    And I sign out of Outlook
