@FindExpertHelp @port
Feature: Tests the Previous Brokers/Assisters table for Assisters on the Find expert help/Manage who helps you page

  @SLER-857
  Scenario: Verifies the Previous Brokers/Assisters table for Assisters on the Find expert help/Manage who helps you page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    Then I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I verify Find Expert Help header Text in "English"
    Then I verify Find Expert Help page "Exch" title Text in "English"

    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page
    Then I validate the Continue on my own button "is not displayed"

    And I validate the current assister text exists
    And I validate the current assister table header labels

    And I validate my assister details in the current assister table are "Blue River Assisters", "Ucr14" or "8Gvzo", "80205", "720-894-1592", Assister, Approved
    Then I Remove my current Assister
    And I "Ok" my decision to remove my current assister
    And I validate no assister is authorized

    And I validate the Previous Broker Assister text
    And I validate the Previous Broker Assister table header labels
    Then I validate the Assister details in the Previous Broker Assister table are "Blue River Assisters", "Ucr14", or "8Gvzo", "80205", "720-894-1592", Assister
    Then I validate the Continue on my own button "is not displayed"

    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page

    And I validate the Previous Broker Assister table is not displayed
    And I validate my assister details in the current assister table are "Blue River Assisters", "Ucr14" or "8Gvzo", "80205", "720-894-1592", Assister, Approved
    Then I Remove my current Assister
    And I "Ok" my decision to remove my current assister
    And I validate no assister is authorized
    Then I validate the Continue on my own button "is not displayed"


    Then I click on the Colorado Connect or C4 Logo in the "ExpertHelp" Header
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
    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page
    Then I validate I am on the "Find Expert Help" page
    Then I verify the Enroll on my own section text is not displayed
    Then I validate the Continue with my application button is displayed in "English"


