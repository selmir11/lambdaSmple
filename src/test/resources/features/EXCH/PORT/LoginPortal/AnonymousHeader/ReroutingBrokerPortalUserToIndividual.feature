@SLER-1126  @LoginPortalAnonymousHeader
Feature: Rerouting Broker Portal Users to Individual sign in page when they sign out and they can see the dropdown options


  Scenario: Broker Portal user should be able to click ‘Admin Portal’ option and navigate to the admin portal (English)
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I login as Broker User "Amethyst.Broker@invalid.com" password "ALaska13!"
    And I validate I am on the "Broker Portal Your Clients" page
    And I click on broker userName and logout
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Admin Portal" requested
    And I validate I am on the "Admin Login" page


  Scenario: Broker Portal user should be able to click ‘Program Manager Account’ option and navigate to the assistnet portal (English)
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I login as Broker User "Amethyst.Broker@invalid.com" password "ALaska13!"
    And I validate I am on the "Broker Portal Your Clients" page
    And I click on broker userName and logout
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Program Manager Account" requested
    And I validate I am on the "Program Manager Login" page

  Scenario: Broker Portal user should be able to click ‘Broker Login’ option and navigate to the individual login portal (English)
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    When I login as Broker User "Amethyst.Broker@invalid.com" password "ALaska13!"
    And I validate I am on the "Broker Portal Your Clients" page
    And I click on broker userName and logout
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Broker Portal" requested
    And I validate I am on the "Broker Portal Login" page


  Scenario:Broker Portal user should be able to click ‘Portal del administrador’ option and navigate to the admin portal (Spanish)
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I change the language from header to "Spanish Login"
    When I login as Broker User "Amethyst.Broker@invalid.com" password "ALaska13!"
    And I validate I am on the "Broker Portal Your Clients" page
    And I click on broker userName and logout
    Then I validate I am on the "Login" page
    And I click user type icon "Ind Portal SP" and validate the options text in the login page
    Then I click the option "Portal del administrador" requested
    And I validate I am on the "Admin Login" page

  Scenario:Broker Portal user should be able to click ‘Cuenta del gerente de programa’ option and navigate to the assistnet portal (Spanish)
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I change the language from header to "Spanish Login"
    When I login as Broker User "Amethyst.Broker@invalid.com" password "ALaska13!"
    And I validate I am on the "Broker Portal Your Clients" page
    And I click on broker userName and logout
    Then I validate I am on the "Login" page
    And I change the language from header to "Spanish Login"
    And I click user type icon "Ind Portal SP" and validate the options text in the login page
    Then I click the option "Cuenta del gerente de programa" requested
    And I validate I am on the "Program Manager Login" page

  Scenario: Broker Portal user should be able to click Portal del agente’ option and navigate to the broker portal login portal (Spanish)
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I change the language from header to "Spanish Login"
    When I login as Broker User "Amethyst.Broker@invalid.com" password "ALaska13!"
    And I validate I am on the "Broker Portal Your Clients" page
    And I click on broker userName and logout
    Then I validate I am on the "Login" page
    And I change the language from header to "Spanish Login"
    And I click user type icon "Ind Portal SP" and validate the options text in the login page
    Then I click the option "Portal del agente" requested
    And I validate I am on the "Broker Portal Login" page
