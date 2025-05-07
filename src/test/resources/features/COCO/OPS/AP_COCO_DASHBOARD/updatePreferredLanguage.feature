@OPS @COCO @UserDashboard
Feature: OPS: CoCo: IndDash: Update Preferred Lang
  @SLCR-736
  Scenario:SLCR-736:OPS: CoCo: IndDash: Update Preferred Lang
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "2611002376" "6701940086" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    Then I click on "Manage Account Details" user dashboard button
    Then I validate I am on the "account details" page
    Then I click on Edit Fields via OBO button on the account details page
    Then I switch to the tab number 2
    Then I validate default language is displaying as "English" for admin portal
    And I click on Make Changes Button in CoCo
    And I change Preferred Language Contact Method to "AdminPortalSpanish" in CoCo
    Then I click on save changes button on my profile page in Coco for admin portal
    Then I validate default language is displaying as "Spanish" for admin portal
    And I click on Make Changes Button in CoCo
    And I change Preferred Language Contact Method to "AdminPortalEnglish" in CoCo
    Then I click on save changes button on my profile page in Coco for admin portal
    Then I validate default language is displaying as "English" for admin portal
    Then I logout from Admin Portal