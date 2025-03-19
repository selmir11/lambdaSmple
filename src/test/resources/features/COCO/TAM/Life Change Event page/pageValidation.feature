@TAM @pageVal @TamCoCo
Feature: Page validation - Life Change Event page

  Background: I go to the login portal
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "30,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Wife", "03051989", "Male", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Wife"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Kid", "06032022", "Male", and applying "Yes"
      | Primary:Child or Other dependent |
      | Wife:Child or Other dependent    |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Kid"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page

  @SLCR-271
  Scenario: SLCR-271 Verify initial state of LCE choices
    Then I verify "AllSingle" life change event "is not" selected
    #Then I verify "NoneOfThese" life change event "is" selected
    And I select "Divorce" life change event with event date of "Today"
    And I select continue on the LCE page
    And I select Go Back on the Declarations and Signature page
    And I verify "Divorce" life change event "is" selected
    And I check "None of these" life change event checkbox
    And I select continue on the LCE page
    And I select Go Back on the Declarations and Signature page
    Then I verify "NoneOfThese" life change event "is" selected
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    And I select continue on the Family Overview page
    Then I verify "AllSingle" life change event "is not" selected
    #Then I verify "NoneOfThese" life change event "is" selected
    And I select "InsuranceLoss" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    And I select continue on the Family Overview page
    Then I verify "AllSingle" life change event "is not" selected
    #Then I verify "NoneOfThese" life change event "is" selected

  @SLCR-330
  Scenario: SLCR-330 Verify error states of LCE page.
    Then I verify "AllSingle" life change event "is not" selected
    Then I verify "Please select option" error does not exist in "English"
    And I select continue on the LCE page
    Then I verify "Please select option" error does exist in "English"
    # Insurance loss check
    And I check "InsuranceLoss" life change event checkbox
    Then I verify "Please select member" error does not exist in "English"
    And I select continue on the LCE page
    Then I verify "Please select member" error does exist in "English"
    Then I verify "Event date" error does not exist in "English"
    And I select all members of "InsuranceLoss" Life Change Event
    And I select continue on the LCE page
    Then I verify "Event date" error does exist in "English"
    And I check "InsuranceLoss" life change event checkbox
    Then I verify "Please select option" error does not exist in "English"
    # Birth check
    And I check "Birth" life change event checkbox
    Then I verify "Please select member" error does not exist in "English"
    And I select continue on the LCE page
    Then I verify "Please select member" error does exist in "English"
    Then I verify "Event date" error does not exist in "English"
    And I select all members of "Birth" Life Change Event
    And I select continue on the LCE page
    Then I verify "Event date" error does exist in "English"
    And I check "Birth" life change event checkbox
    Then I verify "Please select option" error does not exist in "English"
    # Pregnancy check
    And I check "Pregnancy" life change event checkbox
    Then I verify "Please select member" error does not exist in "English"
    And I select continue on the LCE page
    Then I verify "Please select member" error does exist in "English"
    Then I verify "Event date" error does not exist in "English"
    And I select all members of "Pregnancy" Life Change Event
    And I select continue on the LCE page
    Then I verify "Event date" error does exist in "English"
    And I check "Pregnancy" life change event checkbox
    Then I verify "Please select option" error does not exist in "English"
    # Marriage check
    And I check "Marriage" life change event checkbox
    Then I verify "Please select member" error does not exist in "English"
    And I select continue on the LCE page
    Then I verify "Please select member" error does exist in "English"
    Then I verify "Event date" error does not exist in "English"
    And I select all members of "Marriage" Life Change Event
    And I select continue on the LCE page
    Then I verify "Event date" error does exist in "English"
    And I check "Marriage" life change event checkbox
    Then I verify "Please select option" error does not exist in "English"
    # Divorce check
    And I check "Divorce" life change event checkbox
    Then I verify "Please select member" error does not exist in "English"
    And I select continue on the LCE page
    Then I verify "Please select member" error does exist in "English"
    Then I verify "Event date" error does not exist in "English"
    And I select all members of "Divorce" Life Change Event
    And I select continue on the LCE page
    Then I verify "Event date" error does exist in "English"
    And I check "Divorce" life change event checkbox
    Then I verify "Please select option" error does not exist in "English"
    # Move check
    And I check "Move" life change event checkbox
    Then I verify "Please select member" error does not exist in "English"
    And I select continue on the LCE page
    Then I verify "Please select member" error does exist in "English"
    Then I verify "Event date" error does not exist in "English"
    And I select all members of "Move" Life Change Event
    And I select continue on the LCE page
    Then I verify "Event date" error does exist in "English"
    And I check "Move" life change event checkbox
    Then I verify "Please select option" error does not exist in "English"

  @SLCR-359
  Scenario: SLCR-359 Verify error states of LCE page in Spanish.
    And I change the language from header to "Spanish"
    Then I verify "AllSingle" life change event "is not" selected
    Then I verify "Please select option" error does not exist in "Spanish"
    And I select continue on the LCE page
    Then I verify "Please select option" error does exist in "Spanish"
    # Insurance loss check
    And I check "InsuranceLoss" life change event checkbox
    Then I verify "Please select member" error does not exist in "Spanish"
    And I select continue on the LCE page
    Then I verify "Please select member" error does exist in "Spanish"
    Then I verify "Event date" error does not exist in "Spanish"
    And I select all members of "InsuranceLoss" Life Change Event
    And I select continue on the LCE page
    Then I verify "Event date" error does exist in "Spanish"
    And I check "InsuranceLoss" life change event checkbox
    Then I verify "Please select option" error does not exist in "Spanish"
    # Birth check
    And I check "Birth" life change event checkbox
    Then I verify "Please select member" error does not exist in "Spanish"
    And I select continue on the LCE page
    Then I verify "Please select member" error does exist in "Spanish"
    Then I verify "Event date" error does not exist in "Spanish"
    And I select all members of "Birth" Life Change Event
    And I select continue on the LCE page
    Then I verify "Event date" error does exist in "Spanish"
    And I check "Birth" life change event checkbox
    Then I verify "Please select option" error does not exist in "Spanish"
    # Pregnancy check
    And I check "Pregnancy" life change event checkbox
    Then I verify "Please select member" error does not exist in "Spanish"
    And I select continue on the LCE page
    Then I verify "Please select member" error does exist in "Spanish"
    Then I verify "Event date" error does not exist in "Spanish"
    And I select all members of "Pregnancy" Life Change Event
    And I select continue on the LCE page
    Then I verify "Event date" error does exist in "Spanish"
    And I check "Pregnancy" life change event checkbox
    Then I verify "Please select option" error does not exist in "Spanish"
    # Marriage check
    And I check "Marriage" life change event checkbox
    Then I verify "Please select member" error does not exist in "Spanish"
    And I select continue on the LCE page
    Then I verify "Please select member" error does exist in "Spanish"
    Then I verify "Event date" error does not exist in "Spanish"
    And I select all members of "Marriage" Life Change Event
    And I select continue on the LCE page
    Then I verify "Event date" error does exist in "Spanish"
    And I check "Marriage" life change event checkbox
    Then I verify "Please select option" error does not exist in "Spanish"
    # Divorce check
    And I check "Divorce" life change event checkbox
    Then I verify "Please select member" error does not exist in "Spanish"
    And I select continue on the LCE page
    Then I verify "Please select member" error does exist in "Spanish"
    Then I verify "Event date" error does not exist in "Spanish"
    And I select all members of "Divorce" Life Change Event
    And I select continue on the LCE page
    Then I verify "Event date" error does exist in "Spanish"
    And I check "Divorce" life change event checkbox
    Then I verify "Please select option" error does not exist in "Spanish"
    # Move check
    And I check "Move" life change event checkbox
    Then I verify "Please select member" error does not exist in "Spanish"
    And I select continue on the LCE page
    Then I verify "Please select member" error does exist in "Spanish"
    Then I verify "Event date" error does not exist in "Spanish"
    And I select all members of "Move" Life Change Event
    And I select continue on the LCE page
    Then I verify "Event date" error does exist in "Spanish"
    And I check "Move" life change event checkbox
    Then I verify "Please select option" error does not exist in "Spanish"

  @SLCR-352
  Scenario: SLCR-352 LCE page saves "None of these" after saving previous entry
    And I select "Divorce" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I select Go Back on the Declarations and Signature page
    Then I verify "Divorce" life change event "is" selected
    And I check "None of these" life change event checkbox
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I select Go Back on the Declarations and Signature page
    Then I verify "NoneOfThese" life change event "is" selected

  @SLCR-380
  Scenario: SLCR-380 I want to see standard errors on the LCE page so that errors are displayed consistently - English
    #Step2
    And I select continue on the LCE page
    Then I validate I am on the "CoCo life change event" page
    Then I verify "Please select option" error does exist in "English"
    #Step3
    And I check "Marriage" life change event checkbox
    And I select continue on the LCE page
    Then I validate I am on the "CoCo life change event" page
    Then I verify "Please select option" error does not exist in "English"
    Then I verify "Please select member" error does exist in "English"
    #Step4
    And I select all members of "Marriage" Life Change Event
    And I select continue on the LCE page
    Then I validate I am on the "CoCo life change event" page
    Then I verify "Please select option" error does not exist in "English"
    Then I verify "Please select member" error does not exist in "English"
    Then I verify "Event date" error does exist in "English"
    #Step5
    Then I set date for all members of "Marriage" Life Change Event to event date of "Past 61"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo life change event" page
    Then I verify "Event date Past" error does exist in "English"
    #Step6
    Then I set date for all members of "Marriage" Life Change Event to event date of "Future 1"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo life change event" page
    Then I verify "Event date Future" error does exist in "English"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-382
  Scenario: SLCR-382 I want to see standard errors on the LCE page so that errors are displayed consistently - Spanish
    And I change the language from header to "Spanish"
    #Step2
    And I select continue on the LCE page
    Then I validate I am on the "CoCo life change event" page
    Then I verify "Please select option" error does exist in "Spanish"
    #Step3
    And I check "Marriage" life change event checkbox
    And I select continue on the LCE page
    Then I validate I am on the "CoCo life change event" page
    Then I verify "Please select option" error does not exist in "Spanish"
    Then I verify "Please select member" error does exist in "Spanish"
    #Step4
    And I select all members of "Marriage" Life Change Event
    And I select continue on the LCE page
    Then I validate I am on the "CoCo life change event" page
    Then I verify "Please select option" error does not exist in "Spanish"
    Then I verify "Please select member" error does not exist in "Spanish"
    Then I verify "Event date" error does exist in "Spanish"
    #Step5
    Then I set date for all members of "Marriage" Life Change Event to event date of "Past 61"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo life change event" page
    Then I verify "Event date Past" error does exist in "Spanish"
    #Step6
    Then I set date for all members of "Marriage" Life Change Event to event date of "Future 1"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo life change event" page
    Then I verify "Event date Future" error does exist in "Spanish"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-398
  Scenario: SLCR-398 I verify that income-portal-ui uses common components from ng-common on the LCE page in COCO
    Then I verify LCE checkbox COCO in "Not Selected" state
    And I refresh the page
    Then I verify LCE checkbox COCO in "Selected" state
    And I refresh the page
    Then I verify LCE checkbox COCO in "Focus" state
    And I refresh the page
    Then I verify LCE checkbox COCO in "Hover" state

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-824
  Scenario: ELIG-As a CoCo user,
  I want to see the Tell us about life changes page in English or Spanish
  so that I can review the life change events for my application [CCRT-395]
    And I change the language from header to "English"
    Then I verify that the text format follows either the English or Spanish format listed below
      | English:                                                                                                                                                                                               |
      | Tell us about life changes                                                                                                                                                                             |
      | Select any Life Change Event you or someone in your household has experienced within the past 60 days. The loss of other health insurance can be reported up to 60 days before you lose the insurance. |
      | Please select one or more of the options below:                                                                                                                                                        |
      | Will lose/lost health insurance                                                                                                                                                                        |
      | Birth/Adoption/Foster Care/Court Order                                                                                                                                                                 |
      | Please select who this change applies to:                                                                                                                                                              |
      | Pregnancy                                                                                                                                                                                              |
      | Marriage                                                                                                                                                                                               |
      | Divorce                                                                                                                                                                                                |
      | Death                                                                                                                                                                                                  |
      | Change of primary residence                                                                                                                                                                            |
      | None of these                                                                                                                                                                                          |
      | Go back                                                                                                                                                                                                |
      | Save and continue                                                                                                                                                                                      |
    Then I change the language from header to "Spanish"
    And I verify that the text format follows either the English or Spanish format listed below
      | Spanish:                                                                                                                                                                                                  |
      | Infórmenos sobre los cambios importantes en su vida                                                                                                                                                       |
      | Seleccione los cambios de vida que usted o alguien de su familia haya tenido en los últimos 60 días. La pérdida de seguro de salud se puede reportar hasta 60 días antes de que alguien pierda su seguro. |
      | Seleccione la persona a quien aplica este cambio:                                                                                                                                                          |
      | Perderá o ha perdido el seguro de salud                                                                                                                                                                   |
      | Nacimiento/Adopción/Colocación familiar/Mandato judicial                                                                                                                                                  |
      | Seleccione una o más de las siguientes opciones:                                                                                                                                                        |
      | Embarazo                                                                                                                                                                                                  |
      | Matrimonio                                                                                                                                                                                                |
      | Divorcio                                                                                                                                                                                                  |
      | Defunción                                                                                                                                                                                                 |
      | Cambio de residencia principal                                                                                                                                                                            |
      | Ninguna de las anteriores                                                                                                                                                                                 |
      | Volver                                                                                                                                                                                                    |
      | Guardar y continuar                                                                                                                                                                                       |
