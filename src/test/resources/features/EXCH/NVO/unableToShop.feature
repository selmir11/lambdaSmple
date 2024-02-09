Feature:  Unable to shop (not eligible for QHP)

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-28
  Scenario: Verify that user not able to shop (not Colorado resident)
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for 2024
    Then I select No Thanks option from guide you section
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Find Expert Help page
    And I enter details on tell us about yourself page and continue
    Then I enter Additional details and I'm not Co resident and click continue on add address page
    And I enter citizenship details and click continue
    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    And I Declare and sign
    And I wait for hold on content to disappear
    Then I click on view results and shop
    Then I verify text that the member don't qualify for a health plan on the app results page

  @SLER-29
  Scenario: Verify that user not able to shop (not applying for health insurance)
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for 2024
    Then I select No Thanks option from guide you section
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "LostCoverage" and click continue
    Then I select "member" from the who are you question
    And I am a member with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Find Expert Help page
    And I enter details and I'm not applying for insurance on tell us about yourself page and continue
    Then I enter Additional details for addresses, residency, federal tribe and click continue on add address page
    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select "LostCoverage" QLCE on tell us about life changes page
    Then I click on Save and Continue
    And I Declare and sign
    And I wait for hold on content to disappear
    Then I click on view results and shop
    Then I verify text that the member don't qualify for a health plan on the app results page