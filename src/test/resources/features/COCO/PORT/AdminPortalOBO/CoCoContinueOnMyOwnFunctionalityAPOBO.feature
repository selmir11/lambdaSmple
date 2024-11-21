@portCOCO @FindExpertHelpCoCo
Feature: Continue on my own button functionality via Admin Portal

  @SLCR-431
  Scenario: Continue on my own button functionality via Admin Portal
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

    And I click on Sign Out in the Header for "Elmo"

    #Admin Portal user working OBO for the customer
    And I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I switch to the tab number 1

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I verify Manage who helps you header text in "English"
    Then I verify the Enroll on my own section text is not displayed
    Then I validate the Continue with my application button is displayed in "English"
    Then I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click Manage who helps you on the Family Overview page
    Then I validate I am on the "Find Expert Help Exch OBO" page

    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker
    And I validate no broker is authorized

    Then I verify Manage who helps you header text in "English"
    Then I verify the Enroll on my own section text in "English"
    Then I validate the Continue on my own button "is displayed"
    Then I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click Manage who helps you on the Family Overview page
    Then I validate I am on the "Find Expert Help Exch OBO" page

    And I click on Sign Out in the Header for "Elmo"