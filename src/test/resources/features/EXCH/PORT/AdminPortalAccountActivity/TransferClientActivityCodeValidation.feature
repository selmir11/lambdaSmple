@TransferRemove @port @APAccountActivityExch
Feature: Client transfer account activity code validation in Admin Portal

  @SLER-1773
  Scenario: Transfer a single client from one agency to another
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I validate I am on the "Find Expert Help Exch" page
    And I click on Find a Broker
    Then I Search authorized Broker "TransferRemove One"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    And I click Authorized broker
    And I validate current Broker text exists

    And I click on Sign Out in the Header for "Elmo"

    #Agency owner transferring a single client
    Then I validate I am on the "Login" page
    And I open the login page on the "broker" portal
    And I login as Broker User any environment "C4PortTesting+TransferSTG@outlook.com" password "ALaska12!" and "C4PortTesting+Transfer@outlook.com" password "ALaska12!"
    And  I validate I am on the "MFA" page
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify

    Then I validate I am on the "Broker Portal Your Clients" page
    Then I validate the Your Clients page title
    And I search for clients
    Then I click on first client search result
    Then I verify my client's name is displayed

    And I click "transfer" the client
    Then I validate the Agency Broker Transfer page title
    Then I search for a broker named "TransferRemoveAg" on the Agency Broker Transfer page
    And I validate the broker results match my broker named "TransferRemoveAg Two"

    Then I click the transfer link on the Agency Broker Transfer page

    And I validate the client name is displayed on the Review Transfer page
    And I verify the number of clients to transfer is "1"
    Then I click the Transfer Clients button on the Review Transfer page

    And I wait for 1000 milliseconds
    And I validate the Client Transfer Successful message

    Then I click on broker userName and logout

    #Admin Portal user verifying the customer's account activity
    And I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I search for user and click email from search results

    Then I click on view button for "Account Activity" report
    And I validate Account Activity title row
    And I wait for 1000 milliseconds
    Then I validate "UI_ACCT_CREATED" event code and description "Account created" in activity event report
    Then I validate "UI_BROKER_AUTHORIZED" event code and description "Broker Authorized" in activity event report
    Then I validate "UI_ACCT_TRANSFERED" event code and description "Customer record is transf.." in activity event report