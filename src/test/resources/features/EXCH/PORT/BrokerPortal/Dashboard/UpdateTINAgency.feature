@port @Dashboard
Feature: Broker associated with an Independent Broker's Agency, my TIN number must be updated with the Agency TIN in hCentive DB, so that I can be certified from Admin Portal

  @SLER-1936
  Scenario: Broker associated with an Independent Broker's Agency, my TIN number must be updated with the Agency TIN in hCentive DB, so that I can be certified from Admin Portal

#  Login to independent broker(agency) and invite a broker, broker signs in and accepts invitation
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "Agent.Vinod" password "ALaska13!" and "Agent.Vinod" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I click Agency Dashboard
    And I click the Manage Brokers button
    Then I validate I am on the "Associated Brokers" page
    And I search for a broker named "vasaupj"
    And I validate the broker results match my broker named "vasaupj vasaslp" on associated brokers
    And I wait for 500 milliseconds
    Then I validate the broker status invite is on the right action
    Then I click on broker userName and logout
    And I validate I am on the "Login" page
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Broker Portal" requested
    And I validate I am on the "Broker Portal Login" page
    And I login as Broker User any environment "vaskihsss@test.com" password "ALaska13!" and "vassjiqss@test.com" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I click the My Agency View link
    Then I validate I am on the "my agency" page
    And I approve the agency invite
    Then I click on broker userName and logout

#  Login to Admin Portal and verify broker tin is copied from independent broker TIN and certify the broker
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Admin Portal" requested
    And I validate I am on the "Admin Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "9026567025" "4006916995" to search user
#    Then I enter an "accountID" "4006916995" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first broker record from the search results
    Then I validate the agency TIN in STG "11-9298384" and QA "11-9298384"
    Then logout from Admin Portal

#  Login to independent broker(agency) and remove  the broker
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Broker Portal" requested
    And I validate I am on the "Broker Portal Login" page
    And I login as Broker User any environment "Agent.Vinod" password "ALaska13!" and "Agent.Vinod" password "ALaska13!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And I click Agency Dashboard
    And I click the Manage Brokers button
    Then I validate I am on the "Associated Brokers" page
    And I search for a broker named "vasaupj"
    And I validate the broker results match my broker named "vasaupj vasaslp" on associated brokers
    Then I remove the broker from my agency
    Then I click on broker userName and logout
    And I validate I am on the "Login" page

#  Login to admin portal and verify the tin # is removed and broker is decertified
    And I click user type icon "Ind Portal" and validate the options text in the login page
    Then I click the option "Admin Portal" requested
    And I validate I am on the "Admin Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "9026567025" "4006916995" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first broker record from the search results
    Then I validate the agency TIN in STG "" and QA ""
    And I validate the status certification is "NOT APPROVED"




