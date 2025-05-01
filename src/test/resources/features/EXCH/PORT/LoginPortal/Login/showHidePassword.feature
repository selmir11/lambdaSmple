@SLER-592 @LoginPortalLogin
Feature:Implement 'show/hide password' on password field in login portal

  @SLER-592
  Scenario Outline:Login Portal UI
    Given I open the login page on the "<Portal>" portal
    And I validate I am on the "Login" page
    Then I validate Show button is displayed and enabled in "login portal"
    And I enter valid credential STG username "<usernameSTG>" PW "<PWQA>" QA username "<usernameQA>" PW "<PWQA>" for individual user without sign in any env
    Then I validate when show password is displayed as "Show" the code is encrypted in "login page" Page
    And I click on show button in "login page"
    Then I validate when show password is displayed as "Hide" the code is encrypted in "login page" Page

    And I click on show button in "login page"
    And I change the language from header to "Spanish Login"

    Then I validate Show button is displayed and enabled in "login portal Spanish"
    Then I validate when show password is displayed as "OCULTAR" the code is encrypted in "login page" Page
    And I click on show button in "login page"
    Then I validate when show password is displayed as "MOSTRAR" the code is encrypted in "login page" Page

    And I change the language from header to "English Login"
    Examples:
      | Portal    | usernameSTG                          | PWQA      | usernameQA                           | PWQA      |
      | login     | soukainatesting+headerstg@gmail.com  | ALaska12! | AutomationUser.bweczfgtTest@test.com | ALaska12! |
      | broker    | soukainatesting+agencySTG@gmail.com  | ALaska12! | soukainatesting+agencyQA@gmail.com   | ALaska12! |
      | assistNet | c4assistorportal+3WFw8G3J6@gmail.com | ALaska12! | c4assistorportal+POqRdhnqW@gmail.com | ALaska12! |
      | admin     | C4testaduser123@gmail.com            | ALaska13! | C4test.aduser123@gmail.com           | ALaska12! |


  @SLER-592
  Scenario: Account creation page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter password in Create Account Page
    Then I validate Show button is displayed and enabled in "create account"
    Then I validate when show password is displayed as "Show" the code is encrypted in "create account" Page
    And I click on show button in "create account"
    Then I validate when show password is displayed as "Hide" the code is encrypted in "create account" Page

    And I click on show button in "create account"
    And I change the language from header to "Spanish Login"

    Then I validate Show button is displayed and enabled in "create account Spanish"
    Then I validate when show password is displayed as "Show" the code is encrypted in "create account" Page
    And I click on show button in "create account"
    Then I validate when show password is displayed as "Hide" the code is encrypted in "create account" Page

  @SLER-592
  Scenario Outline: Account creation page broker/assistNet
    Given I open the login page on the "<Portal>" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Create Account" page
    And I enter password in Create Account Page
    Then I validate Show button is displayed and enabled in "create account"
    Then I validate when show password is displayed as "Show" the code is encrypted in "create account" Page
    And I click on show button in "create account"
    Then I validate when show password is displayed as "Hide" the code is encrypted in "create account" Page

    And I click on show button in "create account"
    And I change the language from header to "Spanish Login"

    Then I validate Show button is displayed and enabled in "create account Spanish"
    Then I validate when show password is displayed as "OCULTAR" the code is encrypted in "create account" Page
    And I click on show button in "create account"
    Then I validate when show password is displayed as "MOSTRAR" the code is encrypted in "create account" Page
    And I change the language from header to "English Login"
    Examples:
      | Portal    |
      | broker    |
      | assistNet |


  @SLER-592
  Scenario: Entering a new password on the Forgot Password page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create forgot "password"
    Then I verify enter your password text is displayed in "English"
    And I click submit button
    Then I verify error username required text is displayed in "English"
    And I enter valid email "testing.soukaina+random@outlook.com"
    And I click submit button
    #TODO: I am using this function below until we fix the issue with receiving notices in outlook
    Then I open Password Reset Tab
    And I enter password in Create Account Page
    Then I validate Show button is displayed and enabled in "create account"
    Then I validate when show password is displayed as "Show" the code is encrypted in "create account" Page
    And I click on show button in "create account"
    Then I validate when show password is displayed as "Hide" the code is encrypted in "create account" Page

    And I click on show button in "create account"
    And I change the language from header to "Spanish Login"

    Then I validate Show button is displayed and enabled in "create account Spanish"
    Then I validate when show password is displayed as "OCULTAR" the code is encrypted in "create account" Page
    And I click on show button in "create account"
    Then I validate when show password is displayed as "MOSTRAR" the code is encrypted in "create account" Page







