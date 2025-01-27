@AssistNet @port
Feature: Create a new Program Manager account

  @SLER-2044
  Scenario: Creating a new Program Manager account
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I click create account on admin portal
    Then I validate I am on the "Admin Program manager account creation" page
    Then I create program manger profile on admin portal "c4assistorportal"
    And I validate the success message for Profile creation is displayed
    Then I logout from Admin Portal

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "c4assistorportal@outlook.com" and "ALaska12!"
    And I wait for 200 milliseconds
    Then I open the notice "AM-004-01" in "English"
    Then I saved the invitation code for the new program manager account
    Then I delete the open notice

    Then I switch to the tab number 0
    Given I open the login page on the "assistNet" portal
    And I validate I am on the "Login" page
    Then I click create a new account on login page
    And I validate I am on the "Create Account" page
    Then I complete mandatory data for program manager account creation
    Then I validate I am on the "Login" page
    And I log into my Program Manager account

    Then I switch to the tab number 2
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook

    Then I enter the MFA code and click Verify
    And I validate I am on the "assistnet dashboard" page
    And I verify the Program Manager Dashboard welcome text
    Then I verify the program manager certification status is "Not Approved"

    Then I click Complete Profile on assistnet dashboard page
    Then I click save and continue on my information assistnet Page
    And I click go back to my dashboard button from assistNet Dashboared Page

    And I wait for 1000 milliseconds
    And I validate I am on the "assistnet dashboard" page
    Then I verify the program manager certification status is "Approved"
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard