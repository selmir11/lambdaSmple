@SIR

Feature: Individual adult - End to End Test

  Background: I go the login portal
    Given I open the login page on the "login" portal
    
  @SLCR-189 @Failing-Bug-SOL-3758
  Scenario: This will create Individual adult with Broker assistance
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
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
    And I validate I am on the "Broker Dashboard" page

    And I click on "colorado Connect" tab
    And I search for clients
    And I click on first client search result
    And I click "manage" the client

    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help Exch OBO" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click Primary EditUpdate on the Family Overview page


    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    And I select "I prefer not to answer" ethnicity option
    And I select "I prefer not to answer" race option
    And I click continue on the Ethnicity and race page

    And I select "Yes" employment option
    And I enter "40,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select None of these as deductions option
    And I select continue on the Deductions CoCo page

    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a OBO signature on the Declarations And Signature Page CoCo
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click continue on coco start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select "Anthem Colorado Option Silver Pathway Essentials Std" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page
    Then I validate I am on the "Enrollment Agreements" page
    And I select "Terms of Use" agreement checkbox CoCo
    And I select "Privacy Policy" agreement checkbox CoCo
    And I select "Dental Coverage" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select continue button on the Enrollment Agreements CoCo page
    Then I click all done obo from payment portal page coco
  #uncomment the below lines and test after the bug is fixed.
    #Then I validate I am on the "CoCo Welcome" page
    #And I click on Sign Out in the Header for "Elmo"