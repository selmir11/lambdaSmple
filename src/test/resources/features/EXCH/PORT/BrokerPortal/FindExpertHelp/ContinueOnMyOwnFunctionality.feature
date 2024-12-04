@FindExpertHelp @port
Feature: Continue on my own button functionality

  @SLER-1768
  Scenario: Continue on my own button functionality
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login

    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help Exch" page

    Then I verify Manage who helps you header text in "English"
    Then I verify the Enroll on my own section text in "English"
    Then I validate the Continue on my own button "is displayed"

    Then I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "Tell us about yourself" page
    Then I click Back on Tell us about yourself page
    Then I validate I am on the "Find Expert Help Exch" page

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

    Then I validate I am on the "Tell us about yourself" page
    Then I click Back on Tell us about yourself page
    Then I validate I am on the "Find Expert Help Exch" page

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
    Then I validate I am on the "Find Expert Help Exch" page

    And I click on Sign Out in the Header for "WhoHelpsYouPage"

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
    And I wait for 1000 milliseconds
    And I search for clients
    Then I click on first client search result
    Then I verify my client's name is displayed
    And I click "manage" the client

    Then I validate I am on the "Account Overview" page
    And I apply for the current year

    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue

    Then I validate I am on the "Find Expert Help Exch OBO" page
    Then I verify Manage who helps you header text in "English"
    Then I verify that the broker change and remove buttons are disabled
    Then I verify the Enroll on my own section text is not displayed
    Then I validate the Continue with my application button is displayed in "English"
    Then I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "Tell us about yourself" page
    Then I click Back on Tell us about yourself page
    Then I validate I am on the "Find Expert Help Exch OBO" page

    And I click on Sign Out in the Header for "WhoHelpsYouPage"