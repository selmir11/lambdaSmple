@OPS @Exch @ProgramManager
Feature: Program Manager Dashboard- Verify program manager data
  @SLER-710
  Scenario:SLER-710:Verify Program Manager Dashboard
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I select "Program Manager" checkbox on Admin Portal Dashboard
    And I enter an "Email" in any env "profile@test.com" "editprofiletest@c4.com" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Program Manager" page
    Then I verify Primary account holder and account number displays
    And I verify Program Manager information Account Summary
    And I validate all program manager dashboard container titles are displayed
    And I verify Program Manager contract status
    And I verify Program Manager Account Activity Container
    And I Verify Program Manager Client Information : "There is no client information."
    Then I Verify organization Information Container "75509083" "130474819" or "aphsccbfxfotjudmvlafzowdjfb" "profiletest"
    And I click Go Back on admin portal program manager dashboard
    Then I validate I am on the "Admin search" page
    Then I logout from Admin Portal
  @SLER-710
  Scenario:SLER-710:IndDash: PM dashboard verify data
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "2813006563" "7765564002" to search user
    Then I click on Search button in AP dashboard page
    And I validate I am on the "Admin search" page
    Then I click acct first row from Search Results table in admin portal
    And I validate I am on the "Program Manager" page
    And I wait for 2000 milliseconds
    And I validate individual dashboard container titles: "Profile Summary" "Contract Information" "Account Activity Report" "Client Information" "Organization Information" are displayed
    And I verify Program Manager contract status
    And I verify Program Manager Account Activity Container
    Then I validate Client Information title row "First Name" "Last Name" "Email" "Phone Number"
    And I validate "Client Information" first row - first client data "Second IndividualS.. secondIndST.. 303-159-753.." or "Testa Individual Testa1@indi.. 432-453-245.."
    And I validate "Client Information" second row - first client data "cmhnoogwp cmyunagryk cmyunagrykC.. 360-819-427.." or "cmhxtldhz cmcqpqjjhn cmcqpqjjhnC.. 340-668-906.."
    Then I logout from Admin Portal
