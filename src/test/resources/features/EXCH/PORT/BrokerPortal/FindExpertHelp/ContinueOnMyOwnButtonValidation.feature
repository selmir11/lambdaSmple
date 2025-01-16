@FindExpertHelp @port
Feature: Continue with my application/Continue on my own button on the Find expert help/Manage who helps you page

  @SLER-474
  Scenario: Verifies the Continue on my own button on the Find expert help page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I verify Find Expert Help header Text in "English"
    Then I verify Find Expert Help page "Exch" title Text in "English"
    Then I validate the Continue on my own button "is not displayed"

    Then I click the back button from Find Expert Help page

    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011983" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page

    Then I verify Manage who helps you header text in "English"
    Then I validate the Continue on my own button "is displayed"

    And I change the language from header to "Spanish ExpertHelp"
    Then I verify Manage who helps you header text in "Spanish"
    Then I verify the Enroll on my own section text in "Spanish"

    And I click on Sign Out in the Header for "WhoHelpsYouPage"

  @SLER-474
  Scenario: Verifies the Continue with my application button on the Manage who helps you page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I verify Find Expert Help header Text in "English"
    Then I verify Find Expert Help page "Exch" title Text in "English"
    Then I validate the Continue on my own button "is not displayed"

    And I click on Find a Broker
    Then I Search authorized Broker "Kellogg"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click Authorized broker
    And I validate the current broker table header labels
    And I validate my broker details in the current broker table are "Margie Kellogg", "AAA Best Agency", "159753456", "80205", "303-123-7895", "BROKER", "Active"

    Then I verify Manage who helps you header text in "English"
    Then I validate the Continue on my own button "is not displayed"

    Then I click the back button from Find Expert Help page
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue

    Then I verify Manage who helps you header text in "English"
    Then I verify the Enroll on my own section text is not displayed
    Then I validate the Continue with my application button is displayed in "English"

    And I change the language from header to "Spanish ExpertHelp"
    Then I verify the Enroll on my own section text is not displayed
    Then I verify Manage who helps you header text in "Spanish"
    Then I validate the Continue with my application button is displayed in "Spanish"

    And I click on Sign Out in the Header for "WhoHelpsYouPage"