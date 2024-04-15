Feature: Cancel Plans Spanish Translation

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-232-WIP @CancelPlanPageSpanish
  Scenario: Validate Spanish text on Cancel Plan Page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "MovedToColorado" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Find Expert Help page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for no financial help
    Then I select "MoveToCO" QLCE on tell us about life changes page
    Then I click on Save and Continue
    Then I Declare as Tax Household 1
    And I click Continue on the Declarations And Signature Page
    And I wait for hold on content to disappear
    Then I click on view results and shop
    And I click continue on application results page
    Then I validate I am on the "Start Shopping" page
    Then I click continue on start shopping page
    And I select "Elevate Health Plans Colorado Option Bronze" medical plan
    Then I click continue on medical plan results page
    And I select "Anthem Dental Family Value"
    Then I click continue on dental plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I continue on plan summary page
    Then I select make payment button to pay the premium
    And I click continue on payment selection page
    And I select second make payment button to pay the premium
    And I select the Money Order button
    And I click continue on payment selection page
    And I click continue on initial payment page
    And I select "Terms of Use" agreement checkbox
    And I select "Privacy Policy" agreement checkbox
    And I select "Understand Law" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click continue on Enrollment Agreements page
    And I click on Go To Welcome Page Button on whats next page
    Then I validate I am on the "Account Overview" page
    And I click on ClickHere link for "My Plans"
    And I click on "Cancel Medical Plan" button
    And I change the language from header to "Spanish"
    Then Validate text in the Cancellation Page in "Spanish" Language
    |Solicitud de cancelación|
    |Para cancelar o terminar su(s) plan(es), revise y confirme la siguiente información. Esto cancelará los planes para todas las personas en la lista de abajo. Si desea quitar a una persona de sus planes, vuelva a My Account (Mi cuenta) y haga clic en el botón Make changes (Hacer cambios).|
    |Asegúrese de reportar cualquier cambio en su cuenta antes de cancelar su plan.|
    |Importante: usted es responsable de pagar la prima completa del plan por el resto del mes, aunque haga su cancelación a principios de mes.|
    |Nombre del plan Miembros inscritos Prima del plan Fecha de entrada en vigor de la cancelación|
    |Si desea seleccionar un plan nuevo, solo podrá inscribirse durante el período de inscripción abierta anual o si tiene un evento de vida calificado como matrimonio o el nacimiento de un bebé. Consulte https://connectforhealthco.com/get-started/when-can-i-buy-insurance/ para más información sobre cómo puede inscribirse.\nEntiendo que al tomar esta acción, ya no tendré cobertura a través de Connect for Health Colorado.*\nEntiendo que una firma electrónica tiene el mismo efecto legal y puede hacerse cumplir de la misma manera que una firma escrita. Entiendo también que estoy firmando esta solicitud a nombre de todos los miembros de mi familia. Se requiere la firma del solicitante principal.|


    #And I click on Sign Out in the Header for "Elmo"