@port @portNoticeBrokerPortal
Feature: Verify the client's deauthorize broker notice BN-002-04 email and My Docs

  @SLER-1930
  Scenario: Verify the client's deauthorize broker notice BN-002-04 email and My Docs
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation with email "C4PortTesting"@outlook.com
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I click on Find a Broker
    Then I validate the Find a Certified Broker near you page title in "English"
    Then I Search authorized Broker "Margie Kellogg"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists

    Then I click remove my current Broker
    And I "Ok" my decision to remove my current broker
    Then I verify Find Expert Help header Text in "English"
    And I validate the Previous Broker Assister text

    Then I click on the Colorado Connect or C4 Logo in the "ExpertHelp" Header
    And I click link my docs on accountOverview page
    And I validate I am on the "My Documents" page
    Then I validate the notice "IND_Notify Client of Broker De-Authorization (BN-002A-04)" exist in my document letter Containers

    Then I click on Sign Out in the Header for "Elmo"

    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the notice "BN-002A-04" in "English"
    And I verify the notice Text for "BN-002A-04" in "English" for "Exch"
    Then I delete the open notice
    And I sign out of Outlook