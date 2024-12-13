@PortCRM @port
Feature: CRM validation following the agency owner's license update via Broker Portal

  @SLER-1833
  Scenario: CRM validation following the agency owner's license update via Broker Portal
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "carrimautomation+AugustaSTG@gmail.com" password "ALaska12!" and "carrimautomation+Augusta@gmail.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click Agency Dashboard

    Then I click Edit in Account Summary
    And I update my "Agency Owner" license and effective dates
    Then I click Continue on the Your Information page
    Then I click Continue on the Communication Preferences page

    And I update my agency address on the Agency Details page
    Then I click Continue on the Agency Details page
    Then I click Go to my Dashboard
    And I save the agency details

    Then I click on broker userName and logout

    #Verifying license update in the CRM
    Then I log into the CRM system
    Then I search for "Agency Owner" name
    And I wait for 2000 milliseconds
    Then I handle the search results page for "Agency Owner"
    And I verify the contact type is "Broker"

    Then I open the "Details" Tab on contact page
    And I verify the new license number and effective dates

    Then I sign out of CRM