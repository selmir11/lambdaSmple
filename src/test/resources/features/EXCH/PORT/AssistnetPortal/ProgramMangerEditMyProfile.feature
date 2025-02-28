@SLER-622
Feature: As a Program Manager user, I must see an 'Edit' button under account summary container, so that I can edit my Profile Information

  @SLER-622
  Scenario: validate assistnet can edit my Profile Information
    Given I open the login page on the "assistNet" portal
    And I validate I am on the "Login" page
    When I login as Assistnet User any environment "c4assistorportal+vttSQiwuF@gmail.com" password "ALaska12!" and "c4assistorportal+gu21djeMX@gmail.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook

    Then I enter the MFA code and click Verify
    Then I validate I am on the "assistnet dashboard" page
    And I click Edit button on assistnet dashboard Page
    Then I Verify Username is not Editable
    And I edit basic details information "TestFirstName" "test@test.com"
    Then I click cancel button in AP dashboard
    Then I verify the first Name "assistnetAP" AP
    And I click Edit button on assistnet dashboard Page
    And I edit basic details information "assistnetAP" "testing.soukaina+APeditbutton@outlook.com"
    Then I click save button in AP dashboard
    Then I verify the first Name "assistnetAP" AP
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard






