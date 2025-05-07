@OPS @COCO @UserDashboard
Feature: CoCo dashboard: Member details
  @SLCR-710
  Scenario:SLCR-710:CoCo dashboard: Member details
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "6907300947" "1108066870" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Individual CoCo" page
    Then I verify Primary account holder and account number displays
    And I validate CoCo Selected Member data on the far left side
  |staging full name    |   staging user name      |     staging member phone| staging member email  |staging member dob| staging member address| qa full name |   qa user name      | qa member phone| qa member email  | qa member dob| qa member address|
  |apelizadjji apindyvfzbme | MGC4Test+apindyvfzbmeapeliz@gmail.com|369-553-0494 | MGC4Test+apindyvfzbmeapeliz@gmail.com   |09/05/2000 |Residential Address:\n\n104 COCO Drive\nBOULDER, CO 80020   | apelizabrqg apindlkluita |MGC4Test+apindlkluitaapeliz@gmail.com |319-163-3560 |MGC4Test+apindlkluitaapeliz@gmail.com | 02/01/1983 |Residential Address:\n1234 Road\nDenver, CO 80205    |
    And logout from Admin Portal
