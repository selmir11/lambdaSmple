@portCOCO @FindExpertHelpCoCo
Feature: Continue on my own button functionality

  @SLCR-430
  Scenario: Continue on my own button functionality
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I verify Manage who helps you header text in "English"
    Then I verify the Enroll on my own section text in "English"
    Then I validate the Continue on my own button "is displayed"

    Then I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click Manage who helps you on the Family Overview page
    Then I validate I am on the "FindExpertHelpCoco" page

    And I click on Find a Broker
    Then I Search authorized Broker "Maggie Walker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I validate my broker details in the current broker table are "Maggie Walker", "Bright Sky Agency", "8895237", "80205", "303-898-6426", "BROKER", "Active"

    Then I verify Manage who helps you header text in "English"
    Then I validate the Continue with my application button is displayed in "English"
    Then I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click Manage who helps you on the Family Overview page
    Then I validate I am on the "FindExpertHelpCoco" page

    And I click on Sign Out in the Header for "Elmo"

    #Agency owner working OBO for the client
    Then I validate I am on the "Login" page
    And I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+MWalkerSTG@outlook.com" password "ALaska12!" and "C4PortTesting+MaggieWalker@outlook.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    Then I click on "colorado Connect" tab
    And I wait for 1000 milliseconds
    And I search for clients
    Then I click on first client search result
    Then I verify my client's name is displayed
    And I click "manage" the client

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I verify Manage who helps you header text in "English"
    Then I verify that the broker change and remove buttons are disabled
    Then I verify the Enroll on my own section text is not displayed
    Then I validate the Continue with my application button is displayed in "English"
    Then I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click Manage who helps you on the Family Overview page
    Then I validate I am on the "Find Expert Help Exch OBO" page

    And I click on Sign Out in the Header for "Elmo"