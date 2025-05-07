@OPS @APGeneral
Feature: AP Individual dashboard - Eligibility data
  @SLER-709
  Scenario:SLER-709:Admin Portal dashboard Eligibility container with 2 households
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    Then I enter an accountId in any Env "7746317007" "7634740008" to search user
    And I click on Search button in AP dashboard page
    And I wait for 2000 milliseconds
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I validate individual dashboard container titles: "Plans" "Account Summary" "Eligibility" "Renewals" "Reports" "Payloads" are displayed
    And I click View Detailed Eligibility button on Individual dashboard
    And I check "Household level application and eligibility data" table data
    And I check "Member level eligibility data" columns "Member" "CSR" "Relationship to the Primary Account Holder" "Tax Filer Status"
    And I check "John Lee" "SELF" "MFJ" or "Fernando Konopelski" "SELF" "QWD"
    And I check "Life change events" columns "Life Change Event" "Impacted Members" "Date of Event"
    And I logout from Admin Portal
  @SLER-709
  Scenario:SLER-709:Admin Portal dashboard Eligibility container no eligibility data
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I wait for 1000 milliseconds
    Then I enter an accountId in any Env "4007901519" "8780994000" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I validate individual dashboard container titles: "Plans" "Account Summary" "Eligibility" "Renewals" "Reports" "Payloads" are displayed
    Then I check message "There is no eligibility data" is displayed
    And I logout from Admin Portal
  @SLER-709
  Scenario:SLER-709:Admin Portal dashboard Eligibility container past year 2023
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I wait for 1000 milliseconds
    Then I enter an accountId in any Env "4007800744" "1106017043" to search user
    And I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I verify Primary account holder and account number displays
    And I validate individual dashboard container titles: "Plans" "Account Summary" "Eligibility" "Renewals" "Reports" "Payloads" are displayed
    And I click View Detailed Eligibility button on Individual dashboard
    Then I select tax household
    And I check Household level application and eligibility data table
    And I check "Member level eligibility data" columns "Member" "CSR" "Relationship to the Primary Account Holder" "Tax Filer Status"
    And I check "Elizabeth Simmons" "SISTER" "HOH" or "Cousin Bear" "SON" "SNGL"
    And I check "Life change events" columns "Life Change Event" "Impacted Members" "Date of Event"
    And I check "LOSS_OF_MEC_OTHER" "2023-04-30" or "BIRTH_ADOPTION_OR_PLACEMENT_FOR_ADOPTION" "2021-04-17"
    And I logout from Admin Portal

  @SLER-2435
  Scenario:SLER-2435:OPS: IndDash: Validate detailed eligibility for current and previous applications [RT-2576]
    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    Then I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an accountId in any Env "6709690007" "3767502650" to search user
    And I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click View Detailed Eligibility button on Individual dashboard
    And I validate primary holder name and account ID on view details eligibility
      | FieldName                     | qa                     | staging       |
      | Primary Account Holder        | Clark Kent             | Albus Dumbledore      |
      | Account ID                    | 3767502650             |  6709690007     |

    Then I validate Detailed Eligibility header
    Then I validate Household level application and eligibility data header
    And I validate Household level container label name and details on detailed eligibility
      |Env      | Application ID:  |      Submitted on:      |      Application Purpose:         |      Total APTC:    | ARP Eligibility:    | Quick Submit:   |
      |qa       | 129699130        |   05/10/2021 12:00 AM   |    QUALIFIED_LIFE_CHANGE_EVENT    |       N/A           |       No            |      No         |
      |staging  |  51089847        |   10/06/2021 3:38 PM    |    QUALIFIED_LIFE_CHANGE_EVENT    |     $105.92/month   |        Yes          |      No         |

    Then I validate member level eligibility header
    And I validate member level table label and details
      | Env     |       Member          |   CSR   | Relationship to the Primary Account Holder | Tax Filer Status |
      | qa      |    Clark Kent         |         |                  SELF                       |                 |
      | staging |    Albus Dumbledore   |         |                  SELF                       |        SNGL       |

    Then I validate LCE eligibility header
    And I validate LCE table label and details on detailed eligibility
      |   Env     | Life Change Event     |   Impacted Members    | Date of Event |
      |   qa      | LOSS_OF_MEC_OTHER     |     Clark Kent        | 2021-05-10    |
     |  Staging   |  LOSS_OF_MEC_OTHER    |     Albus Dumbledore   | 2021-10-01   |

    Then I validate previous application container header on view detailed eligiblity
    Then I validate Previous application container details
      | Env     |     Plan Year   |  Application ID:  | APTC amount:         | Submitted on:          | Application Purpose:  |
      | qa      |  Plan Year 2021 |  129699130        | N/A                  | 05/10/2021 12:00AM      | QUALIFIED_.. |
      | qa      |  Plan Year 2020 |   45589988        | N/A                  | 09/02/2020 12:00AM      |  QUALIFIED_..  |
      | staging |  Plan Year 2021 |   51089847        | 105.92                | 10/06/2021 3:38PM      | QUALIFIED_..  |

    Then I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    Then I enter an "accountID" in any env "8960126600" "1301076837" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click View Detailed Eligibility button on Individual dashboard
    And I validate primary holder name and account ID on view details eligibility
      | FieldName                     | qa                        | staging        |
      | Primary Account Holder        | Bud Abbott                | Change Change  |
      | Account ID                    | 8960126600                | 1301076837     |

    Then I validate Detailed Eligibility header
    Then I validate Household level application and eligibility data header
    And I validate Household level container label name and details on detailed eligibility
      |Env      | Application ID:  | Submitted on:          |   Application Purpose:              | Total APTC:       | ARP Eligibility:   | Quick Submit:  |
      |qa       | 129307864        |   04/13/2021 12:00 AM  |     QUALIFIED_LIFE_CHANGE_EVENT     |   $355.57/month   |       Yes          |    No          |
      |staging  |  47431661        |   05/10/2021 12:00 AM  |     QUALIFIED_LIFE_CHANGE_EVENT     |   $329.13/month   |       Yes          |    No          |

    Then I validate member level eligibility header
    And I validate member level table label and details
     |  Env     |    Member                 |   CSR    | Relationship to the Primary Account Holder | Tax Filer Status |
     | qa       | Bud Abbott                | 100%     |                  SELF                      | MFJ              |
     | qa       | Lou Costello              |          |                  HUSBAND                   | DEPENDENT        |
     |staging   | apelizxdfchtr apindmtysslbn | 87%   | SELF                                       | SNGL              |

    Then I validate LCE eligibility header
    And I validate LCE table label and details on detailed eligibility
      |Env      |    Life Change Event                        | Impacted Members                | Date of Event |
      | qa       |  MARRIAGE_CIVILUNION_OR_DOMESTIC_PARTNER   |   Bud Abbott\nLou Costello       | 2021-04-03   |
      |staging   |  BIRTH_ADOPTION_OR_PLACEMENT_FOR_ADOPTION  |  apelizxdfchtr apindmtysslbn     | 2021-05-10  |
    Then I validate previous application container header on view detailed eligiblity
    Then I validate Previous application container details
     |Env     |     Plan Year     |   Application ID: |    APTC amount:   | Submitted on:            | Application Purpose:  |
     |qa      |  Plan Year 2021   |     129307864     |     355.57        | 04/13/2021 12:00AM       | QUALIFIED_.. |
     |staging |   Plan Year 2021  |     47431661      |     329.13       | 05/10/2021 12:00AM       | QUALIFIED_..  |

    Then I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    Then I enter an "accountID" in any env "5850216280" "5230867100" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click View Detailed Eligibility button on Individual dashboard
    And I validate primary holder name and account ID on view details eligibility
      | FieldName                     | qa                        | staging       |
      | Primary Account Holder        | Primary apindvpztxem      | apelizzzodz apindnhmrdis      |
      | Account ID                    | 5850216280                | 5230867100     |

    Then I validate Detailed Eligibility header
    Then I validate Household level application and eligibility data header
    And I validate Household level container label name and details on detailed eligibility

     |Env      | Application ID:  | Submitted on:            |    Application Purpose:            |    Total APTC:     | ARP Eligibility:   | Quick Submit:   |
     |qa        | 202697520       |    03/13/2025 4:21 PM     |  QUALIFIED_LIFE_CHANGE_EVENT      |  $724.56/month    |       No               |         No      |
     |staging  |  214097880       |    11/22/2024 10:03 AM    |   RENEWAL_DETERMINATION          |  $431.37/month       |        Yes              | No              |

    Then I validate member level eligibility header
    And I validate member level table label and details
      |Env         |       Member             |     CSR   | Relationship to the Primary Account Holder  | Tax Filer Status |
      | qa        | Primary apindvpztxem      |           |                 SELF                        |       MFJ       |
      | qa        | wife apindvpztxem         |           |                 WIFE                        |     DEPENDENT   |
      | qa        | sontwo apindvpztxem       |           |                 SON                         |     DEPENDENT   |
      | qa        | sonone apindvpztxem       |           |                 SON                         |     DEPENDENT   |
      | staging   |  apelizzzodz apindnhmrdis |     94%   |                 SELF                        |     SNGL         |
      | staging   | Wald Membrana             |           |                 STEP_SON                    |       DEPENDENT   |

    Then I validate previous application container header on view detailed eligiblity
    Then I validate Previous application container order

    Then I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    Then I enter an "accountID" in any env "3126106680" "5230867100" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click View Detailed Eligibility button on Individual dashboard
    Then I validate Detailed Eligibility header
    Then I validate Household level application and eligibility data header
    Then I validate member level eligibility header
    And I validate member level table label and details
      | Env      | Member                     | CSR      | Relationship to the Primary Account Holder | Tax Filer Status |
      | qa       |  apelizyprgp apindhvmhmxl  |         |             SELF                            |                  |
      | qa       |  Baby Messi                |         |              SON                           |                  |
      | staging   |  apelizzzodz apindnhmrdis |     94%   |             SELF                        |     SNGL         |
      | staging   | Wald Membrana             |           |             STEP_SON                    |       DEPENDENT   |

    Then I validate Previous application container order
    Then I close current tab and switch back to previous tab
    And I logout from Admin Portal