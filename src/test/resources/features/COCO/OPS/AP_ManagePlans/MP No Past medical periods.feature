@OPS @COCO @manageplan
Feature: Manage Plans: No Past medical periods //CCRT-234
@SLCR-741
  Scenario: Verify Manage Plans page when No Previous Financial Periods current year
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "5010518090" "4006533799" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I validate title and labels on Manage page Coco account
    Then I check default year displays
    And I check for Previous Medical container message display
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I logout from Admin Portal
  @SLCR-741
  Scenario: Verify Manage Plans page when No Previous Financial Periods previous year
    Given I open the login page on the "admin" portal
    And I validate I am on the "Admin Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "4007588927" "" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Plans" user dashboard button
    And I validate I am on the "Manage Plans" page
    And I validate title and labels on Manage page Coco account
    Then I check default year displays
    And I select the "2024" plan year on manage plan
    And I validate I am on the "Manage Plans" page
    And I check for Previous Medical container message display
    And I click Go Back button on Manage Plan page
    And I wait for 300 milliseconds
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
#    And I validate I am on the "Admin Portal individual dashboard" page
    Then I logout from Admin Portal