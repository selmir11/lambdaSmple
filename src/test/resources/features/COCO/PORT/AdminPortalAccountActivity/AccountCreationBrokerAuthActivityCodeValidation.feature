@portCOCO @FindExpertHelpCoCo @APAccountActivity
Feature: CoCo account creation and broker authorization status account activity codes in Admin Portal

  @SLCR-432
  Scenario: CoCo account creation and broker authorization status account activity codes in Admin Portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header

    And I click on Find a Broker
    Then I Search authorized Broker "Maggie Walker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I validate my broker details in the current broker table are "Maggie Walker", "Bright Sky Agency", "8895237", "80205", "303-898-6426", "BROKER", "Active"

    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker
    And I validate no broker is authorized

    And I click on Sign Out in the Header for "Elmo"

    #Admin Portal user verifying the customer's account activity
    And I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results

    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    Then I wait for 200 milliseconds
    Then I validate "UI_ACCT_CREATED" event code and description "Account created" in activity event report
    Then I validate "UI_BROKER_AUTHORIZED" event code and description "Broker Authorized" in activity event report
    Then I validate "UI_BROKER_REVOKED" event code and description "Broker Revoked" in activity event report