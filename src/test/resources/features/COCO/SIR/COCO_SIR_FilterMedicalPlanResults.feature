@COCOSIR @SIR-COCO4 @COCOMedicalResults
  # SLCR-84, SLCR-272, SLCR-284, SLCR-338, SLCR-339,
Feature: Verify COCO Medical Plan results

  Background: I go the login portal
    Given I open the login page on the "login" portal

   @SLCR-84 @COCOFilterMedicalResults_NoSilver
  Scenario Outline: SLCR-84 - This will verify the COCO filters provide a correct medical plan result
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"

    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
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

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "Marriage" life change event with event date of "Today"
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the COCO Insurance Company dropdown
    And I select "<carrierOption>" to filter for desired COCO plan provider
    And I validate the COCO plan option 1 has text "<planText>"
    And I click on Sign Out in the Header for "Elmo"
    Examples:
      | carrierOption                       | planText                                                             |
      | Anthem                              | Anthem Colorado Option Silver Enhanced 94% Pathway Essentials Std    |
      | Cigna Healthcare                    | Cigna Connect Colorado Option Silver Enhanced Off Exchange           |
      | Denver Health                       | Elevate Health Plans Colorado Option Silver Enhanced Off Exchange    |
      | Kaiser Permanente                   | KP Colorado Option Silver Enhanced 94% AV                            |
      | Rocky Mountain Health Plans / UHC   | RMHP Colorado Doctors Plan Colorado Option Silver Enhanced 94%       |
      | Select Health                       | Select Health Value Colorado Option Silver Enhanced 94% Off Exchange |

  @SLCR-272
  Scenario: SLCR-272  Adult - Verify top sorting tool for premium and deductible
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"

    Then I enter details on tell us about yourself page and continue with "01161995", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Native Hawaiian or Pacific Islander" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

    Then I validate I am on the "Employment Income" page
    And I select "Yes" employment option
    And I enter "40,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page

    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "Move" life change event with event date of "Past 1"
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select the sorting "Monthly Premium- Low to High" option in coco medical page
    Then I validate sorting based on "Monthly Premium- Low to High" in coco medical page
    And I select the sorting "Monthly Premium- High to Low" option in coco medical page
    Then I validate sorting based on "Monthly Premium- High to Low" in coco medical page
    And I select the sorting "Annual Deductible- Low to High" option in coco medical page
    Then I validate sorting based on "Annual Deductible- Low to High" in coco medical page
    And I select the sorting "Annual Deductible- High to Low" option in coco medical page
    Then I validate sorting based on "Annual Deductible- High to Low" in coco medical page

    And I click on Sign Out in the Header for "Elmo"

  @SLCR-284 @CoCo_RegressionTest
  Scenario: SLCR-284 - This will verify the hyperlink text in COCO Medical plan page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"

    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
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

    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And Verify "Learn more about these ratings." hyperlink present in coco Medical Plan Results page and navigates to "https://www.healthcare.gov/quality-ratings/"
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And Verify "Obtenga más información sobre estas calificaciones." hyperlink present in coco Medical Plan Results page and navigates to "https://www.cuidadodesalud.gov/es/quality-ratings/"
    And I click on Sign Out in the Header for "Elmo"

  @SLCR-339 @CoCo_RegressionTest
  Scenario: SLCR-339 - This will verify Spanish Text on Select Plan Results page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"

    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
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

    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    Then I validate text on coco medical plan page
      | See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information.                                                           |
      | Narrow your results                                                                                                                                                                          |
      | Monthly Premium                                                                                                                                                                              |
      | Individual Deductible                                                                                                                                                                        |
      | Family Deductible                                                                                                                                                                            |
      | Insurance Company                                                                                                                                                                            |
      | Metal Tier                                                                                                                                                                                   |
      | Reset Filters                                                                                                                                                                                |
      | Monthly Premium- Low to High                                                                                                                                                                 |
      | Monthly Premium- High to Low                                                                                                                                                                 |
      | Annual Deductible- Low to High                                                                                                                                                               |
      | Annual Deductible- High to Low                                                                                                                                                               |
      | Compare                                                                                                                                                                                      |
      | Plan Details                                                                                                                                                                                 |
      | Select this Plan                                                                                                                                                                             |
      | Go Back                                                                                                                                                                                      |
      | Save and Exit                                                                                                                                                                                |
      | Skip                                                                                                                                                                                         |
      | Continue                                                                                                                                                                                     |
      | Plan quality ratings and enrollee survey results are calculated by CMS using data provided by health plans in 2024. The ratings are being displayed for health plans for the 2025 plan year. |
      | Learn more about these ratings.                                                                                                                                                              |
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate text on coco medical plan page
      | Es posible que algunos detalles y documentos del plan no estén disponibles en español. Vea los detalles del plan y el resumen de beneficios y cobertura para obtener la información más completa y precisa.                                                       |
      | Acotar sus resultados                                                                                                                                                                                                                                             |
      | Prima mensual                                                                                                                                                                                                                                                     |
      | Deducible individual                                                                                                                                                                                                                                              |
      | Deducible familiar                                                                                                                                                                                                                                                |
      | Compañía de seguros                                                                                                                                                                                                                                               |
      | Nivel de metal                                                                                                                                                                                                                                                    |
      | Restablecer los filtros                                                                                                                                                                                                                                           |
      | Prima mensual- Baja a alta                                                                                                                                                                                                                                        |
      | Prima mensual- Alta a baja                                                                                                                                                                                                                                        |
      | Deducible anual- Bajo a alto                                                                                                                                                                                                                                      |
      | Deducible anual- Alto a bajo                                                                                                                                                                                                                                      |
      | Comparar                                                                                                                                                                                                                                                          |
      | Detalles Del Plan                                                                                                                                                                                                                                                 |
      | Seleccione este Plan                                                                                                                                                                                                                                              |
      | Volver                                                                                                                                                                                                                                                            |
      | Guardar y Salir                                                                                                                                                                                                                                                   |
      | Omitir                                                                                                                                                                                                                                                            |
      | Continuar                                                                                                                                                                                                                                                         |
      | CMS calculan las calificaciones de la calidad del plan y los resultados de la encuesta del asegurado con base en los datos que proporcionaron los planes de salud en 2024. Se muestran las calificaciones de los planes de salud referentes al año del plan 2025. |
      | Obtenga más información sobre estas calificaciones.                                                                                                                                                                                                               |
    And I click on Sign Out in the Header for "Elmo"

  @SLCR-338
  Scenario: SLCR-338 - This will verify Spanish-English Text changes for Plan Selection - family
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"

    Then I enter details on tell us about yourself page and continue with "05101977", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "20,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page

    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page

    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Wife", "07081980", "Female", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Wife"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "50,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page

    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page

    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "UnrelatedOne", "07081995", "Male", and applying "Yes"
      | Primary:Other Relative |
      | Wife:Other Relative    |
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "UnrelatedOne"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "50,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page

    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page

    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "UnrelatedTwo", "07081995", "Female", and applying "Yes"
      | Primary:Unrelated   |
      | Wife:Unrelated      |
      | UnrelatedOne:Spouse |
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "UnrelatedTwo"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "50,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page

    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page

    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "UnrelatedThree", "07081950", "Female", and applying "Yes"
      | Primary:Unrelated   |
      | Wife:Unrelated      |
      | UnrelatedOne:Unrelated |
      | UnrelatedTwo:Unrelated |
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "UnrelatedThree"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "50,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page

    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Wife,UnrelatedOne,UnrelatedTwo,UnrelatedThree" coco
    Then I click continue on coco start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    And I validate that there are 3 default groups in coco page
    Then I click continue on grouping Members Medical coco page

    Then I validate I am on the "Medical Plan Results" page
    Then I change the language from header to "Spanish"
    Then I validate text on coco medical plan page
      | Es posible que algunos detalles y documentos del plan no estén disponibles en español. Vea los detalles del plan y el resumen de beneficios y cobertura para obtener la información más completa y precisa.                                                       |
      | Acotar sus resultados                                                                                                                                                                                                                                             |
      | Prima mensual                                                                                                                                                                                                                                                     |
      | Deducible individual                                                                                                                                                                                                                                              |
      | Deducible familiar                                                                                                                                                                                                                                                |
      | Compañía de seguros                                                                                                                                                                                                                                               |
      | Nivel de metal                                                                                                                                                                                                                                                    |
      | Restablecer los filtros                                                                                                                                                                                                                                           |
      | Prima mensual- Baja a alta                                                                                                                                                                                                                                        |
      | Prima mensual- Alta a baja                                                                                                                                                                                                                                        |
      | Deducible anual- Bajo a alto                                                                                                                                                                                                                                      |
      | Deducible anual- Alto a bajo                                                                                                                                                                                                                                      |
      | Comparar                                                                                                                                                                                                                                                          |
      | Detalles Del Plan                                                                                                                                                                                                                                                 |
      | Seleccione este Plan                                                                                                                                                                                                                                              |
      | Volver                                                                                                                                                                                                                                                            |
      | Guardar y Salir                                                                                                                                                                                                                                                   |
      | Omitir                                                                                                                                                                                                                                                            |
      | Continuar                                                                                                                                                                                                                                                         |
      | CMS calculan las calificaciones de la calidad del plan y los resultados de la encuesta del asegurado con base en los datos que proporcionaron los planes de salud en 2024. Se muestran las calificaciones de los planes de salud referentes al año del plan 2025. |
      | Obtenga más información sobre estas calificaciones.                                                                                                                                                                                                               |
    Then I change the language from header to "English"
    Then I validate text on coco medical plan page
      | See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information.                                                           |
      | Narrow your results                                                                                                                                                                          |
      | Monthly Premium                                                                                                                                                                              |
      | Individual Deductible                                                                                                                                                                        |
      | Family Deductible                                                                                                                                                                            |
      | Insurance Company                                                                                                                                                                            |
      | Metal Tier                                                                                                                                                                                   |
      | Reset Filters                                                                                                                                                                                |
      | Monthly Premium- Low to High                                                                                                                                                                 |
      | Monthly Premium- High to Low                                                                                                                                                                 |
      | Annual Deductible- Low to High                                                                                                                                                               |
      | Annual Deductible- High to Low                                                                                                                                                               |
      | Compare                                                                                                                                                                                      |
      | Plan Details                                                                                                                                                                                 |
      | Select this Plan                                                                                                                                                                             |
      | Go Back                                                                                                                                                                                      |
      | Save and Exit                                                                                                                                                                                |
      | Skip                                                                                                                                                                                         |
      | Continue                                                                                                                                                                                     |
      | Plan quality ratings and enrollee survey results are calculated by CMS using data provided by health plans in 2024. The ratings are being displayed for health plans for the 2025 plan year. |
      | Learn more about these ratings.                                                                                                                                                              |
    And I select "Anthem Colorado Option Gold Pathway Essentials Std" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "KP Colorado Option Silver X" coco medical plan
    Then I validate text on coco medical plan page
      | See the Plan Details and review the Summary of Benefits and Coverage document for the most comprehensive and accurate information.                                                           |
      | Narrow your results                                                                                                                                                                          |
      | Monthly Premium                                                                                                                                                                              |
      | Individual Deductible                                                                                                                                                                        |
      | Family Deductible                                                                                                                                                                            |
      | Insurance Company                                                                                                                                                                            |
      | Metal Tier                                                                                                                                                                                   |
      | Reset Filters                                                                                                                                                                                |
      | Monthly Premium- Low to High                                                                                                                                                                 |
      | Monthly Premium- High to Low                                                                                                                                                                 |
      | Annual Deductible- Low to High                                                                                                                                                               |
      | Annual Deductible- High to Low                                                                                                                                                               |
      | Compare                                                                                                                                                                                      |
      | Plan Details                                                                                                                                                                                 |
      | Select this Plan                                                                                                                                                                             |
      | Go Back                                                                                                                                                                                      |
      | Save and Exit                                                                                                                                                                                |
      | Skip                                                                                                                                                                                         |
      | Continue                                                                                                                                                                                     |
      | Plan quality ratings and enrollee survey results are calculated by CMS using data provided by health plans in 2024. The ratings are being displayed for health plans for the 2025 plan year. |
      | Learn more about these ratings.                                                                                                                                                              |
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate text on coco medical plan page
      | Es posible que algunos detalles y documentos del plan no estén disponibles en español. Vea los detalles del plan y el resumen de beneficios y cobertura para obtener la información más completa y precisa.                                                       |
      | Acotar sus resultados                                                                                                                                                                                                                                             |
      | Prima mensual                                                                                                                                                                                                                                                     |
      | Deducible individual                                                                                                                                                                                                                                              |
      | Deducible familiar                                                                                                                                                                                                                                                |
      | Compañía de seguros                                                                                                                                                                                                                                               |
      | Nivel de metal                                                                                                                                                                                                                                                    |
      | Restablecer los filtros                                                                                                                                                                                                                                           |
      | Prima mensual- Baja a alta                                                                                                                                                                                                                                        |
      | Prima mensual- Alta a baja                                                                                                                                                                                                                                        |
      | Deducible anual- Bajo a alto                                                                                                                                                                                                                                      |
      | Deducible anual- Alto a bajo                                                                                                                                                                                                                                      |
      | Comparar                                                                                                                                                                                                                                                          |
      | Detalles Del Plan                                                                                                                                                                                                                                                 |
      | Seleccione este Plan                                                                                                                                                                                                                                              |
      | Volver                                                                                                                                                                                                                                                            |
      | Guardar y Salir                                                                                                                                                                                                                                                   |
      | Omitir                                                                                                                                                                                                                                                            |
      | Continuar                                                                                                                                                                                                                                                         |
      | CMS calculan las calificaciones de la calidad del plan y los resultados de la encuesta del asegurado con base en los datos que proporcionaron los planes de salud en 2024. Se muestran las calificaciones de los planes de salud referentes al año del plan 2025. |
      | Obtenga más información sobre estas calificaciones.                                                                                                                                                                                                               |
    And I click on Sign Out in the Header for "Elmo"








