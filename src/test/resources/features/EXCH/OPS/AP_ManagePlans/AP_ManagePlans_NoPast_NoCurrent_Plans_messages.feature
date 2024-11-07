@OPS
Feature: Manage Plans: Current Med only container verification (order) RT_2090
  @SLER-979
  Scenario: Verify Manage Plans page when medical only is displayed
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "4007126206" "9079864029" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page
    Then I check default year displays
    Then I verify both buttons Medical and Dental is checked
    And I check for Previous Medical container display
    And I check for Previous Dental container display
    Then I verify Years in dropdown starting from "2019" as expected



    #Then I close current tab and switch back to previous tab

  @SLER-979
  Scenario: Verify Manage Plans page when 2022 when No current No Past periods
    Given I open the login page on the "admin" portal
   # And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
#    And I click Search button in AP blue header
#    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "9093569055" "9062666029" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I select the "2022" plan year on manage plan


#    And I validate I am on the "Manage Plans" page
#    Then I validate title and labels on Manage page
#    And I check default year displays
#    Then I verify Years in dropdown starting from "2022" as expected
#    And I select the "2022" plan year on manage plan
  #  And I select year "2022" from Manage Plan container on Individual dashboard
   # And I check default year displays
   # Then I click Manage Plans button
   # And I validate I am on the "Manage Plans" page
    #And I check default year displays
    #And I select the "2022" plan year on manage plan
#Then I select year "2022" from My Current Plan container






 #   Then I click on "Manage Plans" user dashboard button
#    And I validate I am on the "Manage Plans" page
#    Then I validate title and labels on Manage page

   # And I click Go Back on medical plan Cancellation Page
#
#    Then I check default year displays
#    And I validate title and labels on Manage page
#    And I check for Previous Medical container display
#
#    And I click on Privacy Policy in the "Admin Portal" Footer
#    And I validate I am on the "Privacy Policy" page and close tab
#    And I click on Terms Of Use in the "Admin Portal" Footer
#    And I validate I am on the "Terms Of Use" page and close tab
#    And I click on Contact Us in the "Admin Portal" Footer
#    And I validate I am on the "Contact Us" page and close tab
#    Then I logout from Admin Portal
  @SLER-979
  Scenario: Verify Manage Plans page when Dental only is displayed
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "4007126206" "9079864029" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    Then I validate blue bar on Manage page
    Then I verify Primary account holder and account number displays
    And I validate title and labels on Manage page
    Then I check default year displays
    Then I verify both buttons Medical and Dental is checked
    Then I inspect and click Medical button
    Then I check default year displays
    And I validate title and labels on Manage page
    And I check for Previous Dental container display
    Then I verify member details table
    And I verify coverage details table
    Then I verify financial table Start End Date, premium and APTC for current policy
    Then I logout from Admin Portal