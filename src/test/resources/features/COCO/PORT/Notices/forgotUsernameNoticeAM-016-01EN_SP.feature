@SLCR-158 @portNoticeCoco @portCOCO
Feature: CoCo Forgot Username Notice (AM-016-01) in DocGen

  @SLCR-158
  Scenario: Verify CoCo Forgot Username Notice (AM-016-01) in English
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click create forgot "username"
    And I validate I am on the "forgotUsername" page
    Then I enter information's for Forgot username in STG Firsname "candy" LastName "SpanishSTG" phone "111-111-1112" accountType "Customer" or QA Firsname "erty" LastName "el" phone "123-456-7890"
    And I validate notice sent successful msg is displayed
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "AM-016-01" in "English"
    And I verify the notice Text for AM-016-01 coco in "English"
    Then I delete the open notice
    And I sign out of Outlook

  @SLCR-158
  Scenario: Verify CoCo Forgot Username Notice (AM-016-01) in Spanish
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    Then I click create forgot "username"
    And I validate I am on the "forgotUsername" page
    Then I enter information's for Forgot username in STG Firsname "Primary" LastName "Tucker" phone "111-111-1112" accountType "Customer" or QA Firsname "candy" LastName "SpanishQA" phone "111-111-1112"
    And I validate notice sent successful msg is displayed
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "AM-016-01" in "Spanish"
    And I verify the notice Text for AM-016-01 coco in "Spanish"
    Then I delete the open notice
    And I sign out of Outlook





