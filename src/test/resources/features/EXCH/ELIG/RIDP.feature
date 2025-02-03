Feature: RIDP related test

  @SLER-2080
  Scenario Outline: ELIG - Validate Success RIDP
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "09051959" in county "DENVER" with zipcode "80205"
    Then I validate I am on the "Identity Proofing - Initial Questions" page
    Then I answer all Id proofing questions and click continue
    Then Validate congratulations message got displayed with expected text in both English and Spanish languages with "<messageOne>", "<messageTwo>" in "<Language>"
    Then I click on Sign Out in the Header for "NonElmo"
    Examples:
      | messageOne                                                              | messageTwo                                                                   | Language |
      | Congratulations!\nYou have successfully provided proof of identity for  | Now, you can start to browse for plans, or look for expert help in your area | English  |
      | ¡Felicidades!\nHa proporcionado correctamente la prueba de identidad de | Ya puede empezar a revisar los planes o a buscar ayuda experta en su zona    | Spanish  |