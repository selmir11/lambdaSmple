 @LoginPortalAnonymousHeader @SLER-1127
Feature: Rerouting Program Managers to Individual sign in page when they sign out and they can see the dropdown options

  Scenario:Program Manager should be able to click ‘Admin Portal’ option and navigate to the admin portal (English)
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
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Admin Portal" requested
    And I validate I am on the "Admin Login" page

  Scenario:Program Manager should be able to click ‘Broker Portal’ option and navigate to the broker portal(English)
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
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Broker Portal" requested
    And I validate I am on the "Broker Portal Login" page

  Scenario:Program Manager should be able to click ‘Program Manager Account’ option and navigate to the assistnet portal login page(English)
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
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Program Manager Account" requested
    And I validate I am on the "Program Manager Login" page

  Scenario:Broker Portal user should be able to click ‘Portal del administrador' option and navigate to the admin portal (Spanish)
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
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard
    Then I validate I am on the "Login" page
    And I change the language from header to "Spanish Login"
    And I click user type icon "Ind Portal SP" and validate the options text in the login page
    Then I click the option "Portal del administrador" requested
    And I validate I am on the "Admin Login" page

  Scenario:Program Manager should be able to click ‘Portal del agente’ option and navigate to the broker portal (Spanish)
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
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard
    Then I validate I am on the "Login" page
    And I change the language from header to "Spanish Login"
    And I click user type icon "Ind Portal SP" and validate the options text in the login page
    Then I click the option "Cuenta del gerente de programa" requested
    And I validate I am on the "Program Manager Login" page

  Scenario: Program Manager should be able to click ‘Portal del agente’ option and navigate to the broker portal (Spanish)
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
    And I click on username dropdown
    Then I click sign out from the assistnet Dashboard
    Then I validate I am on the "Login" page
    And I change the language from header to "Spanish Login"
    And I click user type icon "Ind Portal SP" and validate the options text in the login page
    Then I click the option "Portal del agente" requested
    And I validate I am on the "Broker Portal Login" page