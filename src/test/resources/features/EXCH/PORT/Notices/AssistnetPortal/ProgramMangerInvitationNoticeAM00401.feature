@port @portNoticeAssistnetPortal
Feature:  As a Program Manager user, I must see updated text in AM-004-01 notice, so that I get correct information in the notice

  @SLER-1961
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
    Then I delete the open notice
    And I sign out of Outlook
