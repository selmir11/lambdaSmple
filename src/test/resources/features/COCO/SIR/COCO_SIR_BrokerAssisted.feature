@COCOSIR @SIR-COCO1
#contains SLCR-908, SLCR-909, SLCR-910
Feature: Broker Assisted - End to End Test  - Closed Enrollment
#Failing-general progression issues in Admin area - not a clean line of functions to test out the SIR pages
  Background: I go the login portal
    Given I open the login page on the "login" portal

  @SLCR-908
  Scenario: SLCR-908 - This will create couple with children with Broker assistance for COCO closed enrollment
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click on Find a Broker
    Then I Search authorized Broker "EnrIntial Broker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I click on Sign Out in the Header for "Elmo"

    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "enrintialtest@outlook.com" password "ALaska12!" and "enrintialtest@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "enrintialtest@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    And I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Agency Dashboard" page
    And I click on "colorado Connect" tab
    And I search for clients
    And I click on first client search result
    And I click "manage" the client

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
    And I enter "10000.00" income amount
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
    And I enter a OBO signature on the Declarations And Signature Page CoCo
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
    And I validate that there are 4 default groups in coco page
    Then I click continue on grouping Members Medical coco page

    Then I validate I am on the "Medical Plan Results" page
    And I select "KP Colorado Option Silver X" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "Cigna Connect Colorado Option Bronze" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "Elevate Health Plans Colorado Option Bronze" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "KP Colorado Option Bronze" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page

    And I validate I am on the "Pay now" page
    Then I click all done obo from payment portal page coco

    And I validate I am on the "Agency Dashboard" page
    And I click on broker userName and logout


  @SLCR-909
  Scenario: SLCR-909 - This will create 2 couples/ 2 different plans with Broker assistance for COCO closed enrollment
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click on Find a Broker
    Then I Search authorized Broker "EnrIntial Broker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I click on Sign Out in the Header for "Elmo"

    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "enrintialtest@outlook.com" password "ALaska12!" and "enrintialtest@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "enrintialtest@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    And I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Agency Dashboard" page
    And I click on "colorado Connect" tab
    And I search for clients
    And I click on first client search result
    And I click "manage" the client

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help Exch OBO" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"

    Then I enter details on tell us about yourself page and continue with "09051959", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "45000.00" income amount
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
    Then I enter details on tell us about additional members of your household page with "Wife", "07271963", "Female", and applying "Yes"
      | Primary:Spouse |
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
    Then I enter details on tell us about additional members of your household page with "Son", "08281999", "Male", and applying "Yes"
      | Primary:Child or Other dependent |
      | Wife:Child or Other dependent    |
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Son"
    And I click save and continue on the Race and Ethnicity page

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
    Then I select add another family member on the Family Overview page

    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "DaughterInLaw", "05052001", "Female", and applying "Yes"
      | Primary:Other Relative |
      | Wife:Other Relative    |
      | Son:Spouse             |
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "DaughterInLaw"
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
    And I enter a OBO signature on the Declarations And Signature Page CoCo
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Wife,Son,DaughterInLaw" coco
    Then I click continue on coco start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click on edit enrollment groups link in coco page
    Then I create new group in edit medical grouping coco page and drag members to the new group
      |Primary,Wife:Group1|
      |Son,DaughterInLaw:Group2|
    Then I click save button to save the groups in CoCo Page
    And I validated message on success enrollment grouping pop-up in CoCo Page
    Then I click on continue button on success pop-up in CoCo Page
    Then I validate I am on the "Grouping Members Medical" page
    And I validate that there are 2 default groups in coco page
    Then I click continue on grouping Members Medical coco page

    Then I validate I am on the "Medical Plan Results" page
    And I select "Cigna Connect Colorado Option Bronze" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I select "Elevate Health Plans Colorado Option Bronze" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page

    And I validate I am on the "Pay now" page
    Then I click all done obo from payment portal page coco

    And I validate I am on the "Agency Dashboard" page
    And I click on broker userName and logout


  @SLCR-910
  Scenario: SLCR-910 - This will create Individual adult with Broker assistance for COCO closed enrollment
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click on Find a Broker
    Then I Search authorized Broker "EnrIntial Broker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I click on Sign Out in the Header for "Elmo"

    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "enrintialtest@outlook.com" password "ALaska12!" and "enrintialtest@outlook.com" password "ALaska12!"

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "enrintialtest@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    And I sign out of Outlook

    Then I enter the MFA code and click Verify

    And I validate I am on the "Agency Dashboard" page
    And I click on "colorado Connect" tab
    And I search for clients
    And I click on first client search result
    And I click "manage" the client

    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help Exch OBO" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"

    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

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
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a OBO signature on the Declarations And Signature Page CoCo
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on coco start shopping page

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

    And I validate I am on the "Pay now" page
    Then I click all done obo from payment portal page coco

    And I validate I am on the "Agency Dashboard" page
    And I click on broker userName and logout

