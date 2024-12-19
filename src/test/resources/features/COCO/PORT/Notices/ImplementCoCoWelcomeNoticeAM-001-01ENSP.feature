@SLCR-366 @portNoticeCoco @portCOCO
Feature: Implement CoCo Welcome Notice (AM-001-01) in DocGen

  Scenario: Trigger Notice IND_Welcome Message AM-001-01 English
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation with email "testing.soukaina"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "CAC Screener" page
    Then I click on Sign Out in the Header for "Elmo"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "AM-001-01" in "English"
    And I verify the notice Text for "AM-001-01" in "English" for "Coco"
    Then I delete the open notice
    And I sign out of Outlook

  Scenario: Trigger Notice IND_Welcome Message AM-001-01 Spanish
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco Spanish" account creation with email "testing.soukaina"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    And I validate I am on the "CAC Screener" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "testing.soukaina@outlook.com" and "ALaska12!"
    Then I open the notice "¡Se ha creado su cuenta de Colorado Connect®! (AM-001-01)" in "Spanish"
    And I verify the notice Text for "AM-001-01" in "Spanish" for "Coco"
    Then I delete the open notice
    And I sign out of Outlook

