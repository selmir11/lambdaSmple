@FindExpertHelp @port
Feature: Continue on my own button functionality via Admin Portal

  @SLER-1769
  Scenario: Continue on my own button functionality via Admin Portal
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    And I click on Find a Broker
    Then I Search authorized Broker "Maggie Walker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I validate my broker details in the current broker table are "Maggie Walker", "Bright Sky Agency", "8895237", "80205", "303-898-6426", "BROKER", "Active"

    And I click on Sign Out in the Header for "WhoHelpsYouPage"

    #Admin Portal user working OBO for the customer
    And I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I switch to the tab number 1

    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue

    Then I verify Manage who helps you header text in "English"
    Then I verify the Enroll on my own section text is not displayed
    Then I validate the Continue with my application button is displayed in "English"
    Then I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "Tell us about yourself" page
    Then I click Back on Tell us about yourself page
    Then I validate I am on the "Find Expert Help Exch OBO" page

    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page

    Then I verify Manage who helps you header text in "English"
    Then I verify the Enroll on my own section text is not displayed
    Then I validate the Continue with my application button is displayed in "English"
    Then I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "Tell us about yourself" page
    Then I click Back on Tell us about yourself page
    Then I validate I am on the "Find Expert Help Exch OBO" page

    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker
    And I validate no broker is authorized

    Then I Remove my current Assister
    And I "Ok" my decision to remove my current assister
    And I validate no assister is authorized

    Then I verify Manage who helps you header text in "English"
    Then I verify the Enroll on my own section text in "English"
    Then I validate the Continue on my own button "is displayed"
    Then I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "Tell us about yourself" page
    Then I click Back on Tell us about yourself page
    Then I validate I am on the "Find Expert Help Exch OBO" page

    And I click on Sign Out in the Header for "WhoHelpsYouPage"