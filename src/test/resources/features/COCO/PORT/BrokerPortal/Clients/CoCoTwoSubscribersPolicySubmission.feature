@BrokerPortalCoCoClients @port @portCOCO
Feature: End to end agency owner CoCo policy submission for two subscribers

  @SLCR-349
  Scenario: : CoCo individual account creation and broker authorization
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    Then I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click on Find a Broker
    Then I Search authorized Broker "Maggie Walker"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists
    And I click on Sign Out in the Header for "Elmo"

  #Agency owner submitting an application and enrolling two subscribers
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+MWalkerSTG@outlook.com" password "ALaska12!" and "C4PortTesting+MaggieWalker@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I click on "colorado Connect" tab
    And I search for clients
    And I click on first client search result
    Then I verify that my client's current status is "NO ELIGIBILITY"
    And I click "manage" the client

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I verify Manage who helps you header text in "English"
    Then I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"

    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "4000000" income amount
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
    Then I enter details on tell us about additional members of your household page with "Wife", "07271986", "Female", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    And I select "Prefer not to answer" for race and ethnicity option for "Wife"
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

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a OBO signature on the Declarations And Signature Page CoCo
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page

    Then I click on the Colorado Connect or C4 Logo in the "ExpertHelp" Header
    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I click on "colorado Connect" tab
    And I search for clients
    And I click on first client search result
    Then I verify that my client's current status is "ELIGIBILITY ONLY"
    And I click "manage" the client

    Then I validate I am on the "CoCo Welcome" page
    And I click on Find a Plan in the "Elmo" Header

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Wife" coco
    Then I click continue on coco start shopping page

    Then I click continue on grouping Members Medical coco page

    And I validate I am on the "Medical Plan Results" page
    And I select the first medical plan
    Then I click continue on medical plan results page
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox
    And I select "Submit" agreement checkbox
    And I enter householder signature on the Enrollment Agreements page
    And I click submit enrollment on Enrollment Agreements page

    And I validate I am on the "Pay now" page
    Then I click all done from payment portal page OBO

    And I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I click on "colorado Connect" tab
    And I search for clients
    And I click on first client search result
    And I verify my client's name is displayed
    Then I verify that my client's current status is "POLICY SUBMITTED"