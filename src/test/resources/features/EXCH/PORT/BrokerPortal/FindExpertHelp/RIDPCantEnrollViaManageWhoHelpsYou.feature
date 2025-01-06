@port @FindExpertHelp
Feature:Failed RIDP individual can't continue with enrollment via Manage Who Helps You page

  @SLER-1937
  Scenario:Failed RIDP individual can't continue with enrollment via Manage Who Helps You page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011983" in county "DENVER" with zipcode "80205"
    Then I answer the wrong Id proofing answers and click continue
    And I validate the id proofing error message is displayed
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header
    Then I validate I am on the "Find Expert Help" page
    And I validate the Continue on my own button "is not displayed"
