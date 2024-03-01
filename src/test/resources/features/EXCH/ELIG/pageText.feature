Feature: Verify all English and Spanish Text on ELIG pages

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-38 @PageText
  Scenario: Verify all English and Spanish Text on the Let us guide you page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I validate the verbiage on Let us guide you page in "English"
    When I switch to "Spanish"
    And I validate I am on the "Spanish" page
    And I validate the verbiage on Let us guide you page in "Spanish"


  @SLER-47 @PageText
  Scenario: Verify all English and Spanish Text on Enter Case Info page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "Yes" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Enter Case ID" page
    And I validate the verbiage on the Enter Case ID page in "English"
    When I switch to "Spanish"
    Then I validate I am on the "Spanish" page
    And I validate the verbiage on the Enter Case ID page in "Spanish"

  @SLER-58 @PageText
  Scenario: Verify all English and Spanish Text on the Before you begin page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I validate the verbiage on the Before you begin page in "English"
    When I switch to "Spanish"
    Then I validate I am on the "Spanish" page
    And I validate the verbiage on the Before you begin page in "Spanish"

  @SLER-66 @PageText
  Scenario: Verify all English and Spanish Text on the Report a life change (Initial) page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    Then I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I validate the verbiage on the Report a life change page in "English"
    When I switch to "Spanish"
    Then I validate I am on the "Spanish" page
    And I validate the verbiage on the Report a life change page in "Spanish"

  @SLER-79 @PageText
  Scenario: Verify all English and Spanish Text on the Congratulations! (RIDP) page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    Then I validate I am on the "RIDP - Congratulations" page
    And I validate the verbiage on the RIDP - Congratulations page in "English"
    When I switch to "Spanish"
    Then I validate I am on the "Spanish" page
    And I validate the verbiage on the RIDP - Congratulations page in "Spanish"