@port @Dashboard
Feature: Agency owner/associated broker license and profile update verification

  @SLER-1832
  Scenario: Agency owner license and profile update verification
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

    Then I click on broker userName and logout

    #Verifying the new agency details are displayed on the Find a Certified Broker page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker

    Then I enter the new agency license number into the Find a Broker search
    And I click on Search button in find certified broker page

    Then I validate broker name is "Augusta Morse"
    Then I validate agency name is "Augusta Morse Agency"
    Then I validate the new agency address

  Scenario: Broker license and profile update verification
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "C4PortTesting+StellaSTG@outlook.com" password "ALaska12!" and "C4PortTesting+Stella@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    Then I click Broker Dashboard

    And I click Complete Profile
    And I update my "Broker" license and effective dates
    Then I click Continue on the Your Information page
    Then I click Continue on the Communication Preferences page

    Then I click Go to my Dashboard

    Then I click on broker userName and logout

    #Verifying the new details are displayed on the Find a Certified Broker page
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "Exch" Header
    And I click on Find a Broker

    Then I Search authorized Broker "Stella Santos"
    And I click on Search button in find certified broker page

    Then I validate broker name is "Stella Santos"
    Then I validate agency name is "Augusta Morse Agency"
    Then I validate the new agency address
    And I click more details from the first broker result container
    Then I validate the new agency details "AugustaMorseAgency@Agency.com", "719-326-5891", "Monday", "08:00 AM to 05:00 PM", "English"