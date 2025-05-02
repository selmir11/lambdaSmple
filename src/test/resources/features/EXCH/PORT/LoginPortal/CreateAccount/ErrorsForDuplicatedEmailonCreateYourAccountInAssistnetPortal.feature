@CreateAccount @port
Feature:  As a Program Manager user, I must see updated text in AM-004-01 notice, so that I get correct information in the notice

  @SLER-1972 @SLER-1975
  Scenario:  As a Program Manager user, I must see updated text in AM-004-01 notice, so that I get correct information in the notice
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I click create account on admin portal
    Then I validate I am on the "Admin Program manager account creation" page
    Then I create program manger profile on admin portal "c4assistorportal"
    And I validate the success message for Profile creation is displayed
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "c4assistorportal@outlook.com" and "ALaska12!"
    And I wait for 200 milliseconds
    Then I open the notice "AM-004-01" in "English"
    And I verify the notice Text for "AM-004-01" in "English" for "Program Manager"
    Then I saved the invitation code for the new program manager account
    Then I delete the open notice
    And I sign out of Outlook
    Then I logout from Admin Portal

    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Program Manager Account" requested
    And I validate I am on the "Program Manager Login" page
    Then I click create a new account on login page
    And I validate I am on the "Create Account" page
    Then I complete mandatory data for program manager account creation
    Then I validate I am on the "Login" page
    And I log into my Program Manager account
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "c4assistorportal@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click on broker userName and logout

  @SLER-1972
  Scenario: Validate the program manager account exists error message in English on the Create your Account page
    Given I open the login page on the "assistNet" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    And I enter duplicate data for Program Manager account creation
    Then I validate the We're unable to proceed with this email error message in "English"

  @SLER-1975
  Scenario: Validate the broker account exists error message in Spanish on the Create your Account page
    Given I open the login page on the "assistNet" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    And I change the language from header to "Spanish"
    And I enter duplicate data for Program Manager account creation
    Then I validate the We're unable to proceed with this email error message in "Spanish"