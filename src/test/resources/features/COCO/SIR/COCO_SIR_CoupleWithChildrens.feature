@COCOSIR @SIR-COCO3
  #SLCR-279, SLCR-264, SLCR-280, SLCR-281, SLCR-337
Feature: CoupleWithChildrens - End to End Test

  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-279
  Scenario: SLCR-279 - This will create Family of 4 members, Couple and their children with multiple groups
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

    Then I enter details on tell us about yourself page and continue with "01161988", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "10,000.00" income amount
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
    Then I enter details on tell us about additional members of your household page with "Wife", "03051989", "Female", and applying "Yes"
    |Primary:Spouse|
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Wife"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "10,000.00" income amount
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
    Then I enter details on tell us about additional members of your household page with "Daughter", "04212013", "Female", and applying "Yes"
    |Primary:Child or Other dependent|
    |Wife:Child or Other dependent|
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Daughter"
    And I click save and continue on the Race and Ethnicity page

    And I select "No" employment option
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
    Then I enter details on tell us about additional members of your household page with "Son", "01012010", "Male", and applying "Yes"
    |Primary:Child or Other dependent|
    |Wife:Child or Other dependent|
    |Daughter:Sibling             |
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Son"
    And I click save and continue on the Race and Ethnicity page

    And I select "No" employment option
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
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Wife" coco
    Then I click continue on coco start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click on edit enrollment groups link in coco page
    Then I create new group in edit medical grouping coco page and drag members to the new group
    |Primary:Group1|
    |Wife:Group2|
    |Daughter:Group3|
    |Son:Group4|
    Then I click save button to save the groups in CoCo Page
    And I validated message on success enrollment grouping pop-up in CoCo Page
    Then I click on continue button on success pop-up in CoCo Page

    Then I validate I am on the "Grouping Members Medical" page
    #And I validate that there are 4 default groups in coco page
    Then I click continue on grouping Members Medical coco page

    Then I validate I am on the "Medical Plan Results" page
    And I select "KP Colorado Option Silver X" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "RMHP Colorado Doctors Plan Colorado Option Gold" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "Select Health Value Colorado Option Gold" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "Cigna Connect Colorado Option Bronze" coco medical plan

    Then I click Continue on the Medical Plans Page CoCo
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page

    Then I click all done from payment portal page coco
    And I click on Sign Out in the Header for "Elmo"

  @SLCR-280 @EndToEndTest
  Scenario: SLCR-280 - This will create Family of 4 members Couple and their children with multiple groups with income as 35k
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

    Then I enter details on tell us about yourself page and continue with "01161988", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "35,000.00" income amount
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
    Then I enter details on tell us about additional members of your household page with "Wife", "03051989", "Female", and applying "Yes"
      |Primary:Spouse|
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Wife"
    And I click save and continue on the Race and Ethnicity page

    And I select "No" employment option
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
    Then I enter details on tell us about additional members of your household page with "Daughter", "04122013", "Female", and applying "Yes"
      |Primary:Child or Other dependent|
      |Wife:Child or Other dependent|
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Daughter"
    And I click save and continue on the Race and Ethnicity page

    And I select "No" employment option
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
    Then I enter details on tell us about additional members of your household page with "Son", "12222016", "Male", and applying "Yes"
      |Primary:Child or Other dependent|
      |Wife:Child or Other dependent|
      |Daughter:Sibling             |
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Son"
    And I click save and continue on the Race and Ethnicity page

    And I select "No" employment option
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
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Wife" coco
    Then I click continue on coco start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click on edit enrollment groups link in coco page
    Then I create new group in edit medical grouping coco page and drag members to the new group
      |Primary:Group1|
      |Wife:Group2|
      |Daughter:Group3|
      |Son:Group4|
    Then I click save button to save the groups in CoCo Page
    And I validated message on success enrollment grouping pop-up in CoCo Page
    Then I click on continue button on success pop-up in CoCo Page

    Then I validate I am on the "Grouping Members Medical" page
    #And I validate that there are 4 default groups in coco page
    Then I click continue on grouping Members Medical coco page

    Then I validate I am on the "Medical Plan Results" page
    And I select "KP Colorado Option Silver X" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "KP Colorado Option Silver X" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "KP Colorado Option Silver X" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "KP Colorado Option Silver X" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page

    Then I click all done from payment portal page coco
    And I click on Sign Out in the Header for "Elmo"

  @SLCR-264 @EndToEndTest
  Scenario: SLCR-264 - This will create Family of 4 members Couple and their children with single groups with high income
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

    Then I enter details on tell us about yourself page and continue with "01161988", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "60,000.00" income amount
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
    Then I enter details on tell us about additional members of your household page with "Wife", "03051989", "Female", and applying "Yes"
      |Primary:Spouse|
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Wife"
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
    Then I select add another family member on the Family Overview page

    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Daughter", "04122015", "Female", and applying "Yes"
      |Primary:Child or Other dependent|
      |Wife:Child or Other dependent|
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Daughter"
    And I click save and continue on the Race and Ethnicity page

    And I select "No" employment option
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
    Then I enter details on tell us about additional members of your household page with "Son", "12222015", "Male", and applying "Yes"
      |Primary:Child or Other dependent|
      |Wife:Child or Other dependent|
      |Daughter:Sibling             |
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Son"
    And I click save and continue on the Race and Ethnicity page

    And I select "No" employment option
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
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Wife" coco
    Then I click continue on coco start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    #And I validate that there are 1 default groups in coco page
    Then I click continue on grouping Members Medical coco page

    Then I validate I am on the "Medical Plan Results" page
    And I select "RMHP Colorado Doctors Plan Colorado Option Gold" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page

    Then I click all done from payment portal page coco
    And I click on Sign Out in the Header for "Elmo"


  @SLCR-281 @EndToEndTest
  Scenario: SLCR-281 - This will create Family of 4 members Couple and their children with multiple groups $0 income
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

    Then I enter details on tell us about yourself page and continue with "01161988", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "10,000.00" income amount
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
    Then I enter details on tell us about additional members of your household page with "Daughter", "04122013", "Female", and applying "Yes"
      |Primary:Child or Other dependent|
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Daughter"
    And I click save and continue on the Race and Ethnicity page

    And I select "No" employment option
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
    Then I enter details on tell us about additional members of your household page with "Son", "12222016", "Male", and applying "Yes"
      |Primary:Child or Other dependent|
      |Daughter:Sibling             |
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Son"
    And I click save and continue on the Race and Ethnicity page

    And I select "No" employment option
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
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on coco start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click on edit enrollment groups link in coco page
    Then I create new group in edit medical grouping coco page and drag members to the new group
      |Primary:Group1|
      |Daughter:Group2|
      |Son:Group3|
    Then I click save button to save the groups in CoCo Page
    And I validated message on success enrollment grouping pop-up in CoCo Page
    Then I click on continue button on success pop-up in CoCo Page

    Then I validate I am on the "Grouping Members Medical" page
    #And I validate that there are 3 default groups in coco page
    Then I click continue on grouping Members Medical coco page

    Then I validate I am on the "Medical Plan Results" page
    And I select "KP Colorado Option Silver X" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "RMHP Colorado Doctors Plan Colorado Option Silver" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "Anthem Colorado Option Silver Pathway Essentials Std" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page

    Then I click all done from payment portal page coco
    And I click on Sign Out in the Header for "Elmo"

  @SLCR-337 @EndToEndTest
  Scenario: SLCR-337 - This will create 3 groups - 2 couples 1 adult (SES plan not viewable)
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
    And I select "RMHP Colorado Doctors Plan Colorado Option Gold" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "KP Colorado Option Silver X" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "Select Health Value Colorado Option Gold" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page

    Then I click all done from payment portal page coco
    And I click on Sign Out in the Header for "Elmo"