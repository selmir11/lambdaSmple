@port @APAccountActivityExch @FindExpertHelp
Feature: Admin Portal user authorizing and deauthorizing a customer's broker and verifying the account activity codes

  @SLER-1803
  Scenario: Admin Portal user authorizing and deauthorizing a customer's broker and verifying the account activity codes
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I validate I am on the "Create Account" page
    Then I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Admin search" page
    And  I search for user and click email from search results
    Then I validate I am on the "Admin Portal individual dashboard" page
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I switch to the tab number 1
    And I validate I am on the "Account Overview" page

    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I verify Find Expert Help header Text in "English"

    And I click on Find a Broker
    Then I Search authorized Broker "Preston Saunders"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I validate my broker details in the current broker table are "Preston Saunders", "Bright Sky Agency", "88564585", "80205", "303-898-6427", "BROKER", "Active"

    Then I verify Manage who helps you header text in "English"
    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker
    Then I verify Find Expert Help header Text in "English"
    And I validate the Previous Broker Assister text
    Then I validate the details in the Previous Broker Assister table are "Maggie Walker", "8895237", "80205", "303-898-6426", "Broker"

    And I close current tab and switch back to previous tab

    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    And I wait for 1000 milliseconds
    Then I validate "UI_BROKER_AUTHORIZED" event code and description "Broker Authorized" in activity event report
    Then I validate "UI_BROKER_REVOKED" event code and description "Broker Revoked" in activity event report