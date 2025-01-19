@AssistNet @port
Feature:update Assister communications preferences email

  @SLER-1976
  Scenario:update Assister communications preferences email
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I validate I am on the "Admin search" page
    And I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "3581900680" "3891706740" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first broker record from the search results
    Then I validate I am on the "Program Manager" page
    And I click the "Edit Profile" on the AP program manager dashboard
    Then I update the email adresse "c4assistorportal" @outlook.com of the program manager
    Then I click the save options "Save" on the AP program manager dashboard
    And I validate the Update successful text is displayed
    Then I logout from Admin Portal

    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Program Manager Account" requested
    And I validate I am on the "Program Manager Login" page
    Then I login as Assistnet User any environment "c4assistorportal+qMBc9KLIz@gmail.com" password "ALaska12!" and "c4assistorportal+5Vi2AIfry@gmail.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "c4assistorportal@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I validate I am on the "assistnet dashboard" page
    Then I validate the email is updated correctly
    And I click on broker userName and logout