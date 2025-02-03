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

  @SLER-2091
  Scenario Outline: ELIG-Validate Success-FARS
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
    Then I select specific answers for Id proofing questions and click continue
      | CapGemini        |
      | Lakewood Address |
      | First Bank       |
    Then I validate I am on the "Upload Documents (RIDP)" page
    Then I click on Check Status button in Id proofing secondary request Page
    Then Validate congratulations message got displayed with expected text in both English and Spanish languages with "<messageOne>", "<messageTwo>" in "<Language>"
    Then I click on Sign Out in the Header for "NonElmo"
    Examples:
      | messageOne                                                              | messageTwo                                                                   | Language |
      | Congratulations!\nYou have successfully provided proof of identity for  | Now, you can start to browse for plans, or look for expert help in your area | English  |
      | ¡Felicidades!\nHa proporcionado correctamente la prueba de identidad de | Ya puede empezar a revisar los planes o a buscar ayuda experta en su zona    | Spanish  |

  @SLER-2094
  Scenario Outline: ELIG-Validate Failure-FARS
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
    Then I select specific answers for Id proofing questions and click continue
      | CapGemini         |
      | Littleton Address |
      | CHASE             |
    Then I validate I am on the "Upload Documents (RIDP)" page
    Then I validate error "<ErrorMessage>" text in Id proofing secondary request Page in "<language>"
    Then I click on Sign Out in the Header for "NonElmo"
    Examples:
      | ErrorMessage                                                                                                                                                                                                                                                           | language |
      | Please call Experian to unlock your account. 1 (866) 578-5409\nMake sure to provide your reference number: Farsd\nExperian hours of operation are Monday - Friday, 6:30am to 8pm MST; Saturday, 8am-6pm MST; Sunday, 9am-6pm MST.                                      | English  |
      | Por favor llame a Experian para desbloquear su cuenta. 1 (866) 578-5409\nSu número de referencia DSH es Farsd\nLas horas de operación de Experian son de lunes a viernes, de 6:30 a.m. a 8 p.m. MST; sábados, de 8 a.m. a 6 p.m. MST; domingo, de 9 a.m. a 6 p.m. MST. | Spanish  |



