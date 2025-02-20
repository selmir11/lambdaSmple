@TAXTOOLS @SLER-2179
Feature:Tax Tool: - Silver - Verifying the correct amount is displayed

  Scenario Outline:Silver - Verifying the correct amount is displayed for one member

    Given I open the login page on the "tax Silver" portal
    When I validate I am on the "tax Silver" page
    Then I enter for one member "<zipCode>" and "<county>" "<age>" and validate "<ExpectedPremium>" "<ExpectedProvider>" "<ExpectedPlan>"
    Examples:
      | zipCode | county  | age | ExpectedPremium | ExpectedProvider                | ExpectedPlan                                                                                          |
      | 80203   | DENVER  | 32  | $386.17         | Denver Health Medical Plan      | Elevate Health Plans Colorado Option Silver                                                           |
      | 80134   | DOUGLAS | 67  | $980.46         | Kaiser Permanente               | KP Select CO Silver 5000/25                                                                           |
      | 81658   | EAGLE   | 43  | $632.25         | Anthem Blue Cross & Blue Shield | Anthem Colorado Option Silver Mountain Enhanced Std                                                   |
      | 80828   | LINCOLN | 27  | $506.38         | Anthem Blue Cross & Blue Shield | Anthem Silver Pathway X HMO 5000 $0 Select Drugs                                                      |
      | 81611   | PITKIN  | 77  | $1377.75        | Rocky Mountain Health Plans     | RMHP Valley Silver Value ($0 Virtual Urgent Care + $0 PCP Visits, $5 Tier 2 Rx, $0 Insulin, Rx Copay) |
      | 81501   | MESA    | 29  | $398.23         | Rocky Mountain Health Plans     | RMHP Monument One Silver Advantage ($0 Virtual Urgent Care, $5 Tier 2 Rx, $0 Insulin, Rx Copay)       |
      | 80501   | WELD    | 34  | $404.72         | Cigna                           | Cigna Connect Flex Silver 3750                                                                        |
      | 81146   | ALAMOSA | 59  | $1257.74        | Anthem Blue Cross & Blue Shield | Anthem Silver Pathway X HMO 5000 $0 Select Drugs                                                      |
      | 81059   | OTERO   | 72  | $1449.57        | Anthem Blue Cross & Blue Shield | Anthem Silver Pathway X HMO 5000 $0 Select Drugs                                                      |


  Scenario Outline: Silver - Verifying the correct amount is displayed for two member
    Given I open the login page on the "tax Silver" portal
    When I validate I am on the "tax Silver" page
    Then I enter for one member "<zipCode>" and "<county>" "<age1>" second member "<age2>"and validate "<ExpectedPremium>" "<ExpectedProvider>" "<ExpectedPlan>"
    Examples:
      | zipCode | county     | age1 | age2 | ExpectedPremium | ExpectedProvider            | ExpectedPlan                                                                                          |
#   bug to be fixed
      #      | 81230   | Gunnison   | 45   | 40   | $663.16         | Rocky Mountain Health Plans | RMHP Valley Silver Value ($0 Virtual Urgent Care + $0 PCP Visits, $5 Tier 2 Rx, $0 Insulin, Rx Copay) |
      | 81435   | San Miguel | 38   | 40   | $1159.15        | Rocky Mountain Health Plans | RMHP Valley Silver Value ($0 Virtual Urgent Care + $0 PCP Visits, $5 Tier 2 Rx, $0 Insulin, Rx Copay) |


  Scenario Outline: Silver - Verifying the correct amount is displayed for three member
    Given I open the login page on the "tax Silver" portal
    When I validate I am on the "tax Silver" page
    Then I enter for one member "<zipCode>" and "<county>" "<age1>" second member "<age2>" third member "<age3>" and validate "<ExpectedPremium>" "<ExpectedProvider>" "<ExpectedPlan>"
    Examples:
      | zipCode | county   | age1 | age2 | age3 | ExpectedPremium | ExpectedProvider            | ExpectedPlan                                |
      | 80202   | Denver   | 56   | 54   | 15   | $1730.43        | Denver Health Medical Plan  | Elevate Health Plans Colorado Option Silver |
      | 80134   | Elbert   | 31   | 33   | 8    | $1038.72        | Kaiser Permanente           | KP Colorado Option Silver                   |
      | 81301   | San Juan | 40   | 34   | 19   | $1428.54        | Rocky Mountain Health Plans | RMHP Valley Colorado Option Silver          |

  Scenario Outline: Silver - Verifying the correct amount is displayed for four member
    Given I open the login page on the "tax Silver" portal
    When I validate I am on the "tax Silver" page
    Then I enter for one member "<zipCode>" and "<county>" "<age1>" second member "<age2>" third member "<age3>" fourth member "<age4>"and validate "<ExpectedPremium>" "<ExpectedProvider>" "<ExpectedPlan>"
    Examples:
      | zipCode | county   | age1 | age2 | age3 | age4 | ExpectedPremium | ExpectedProvider            | ExpectedPlan                                                                                          |
      | 81427   | Ouray    | 32   | 33   | 10   | 12   | $1796.13        | Rocky Mountain Health Plans | RMHP Valley Silver Value ($0 Virtual Urgent Care + $0 PCP Visits, $5 Tier 2 Rx, $0 Insulin, Rx Copay) |
      | 80010   | Arapahoe | 51   | 62   | 16   | 20   | $2143.70        | Denver Health Medical Plan  | Elevate Health Plans Colorado Option Silver                                      |


  Scenario Outline: Silver - Verifying the correct amount is displayed for five member
    Given I open the login page on the "tax Silver" portal
    When I validate I am on the "tax Silver" page
    Then I enter for one member "<zipCode>" and "<county>" "<age1>" second member "<age2>" third member "<age3>" fourth member "<age4>" fifth member "<age5>" and validate "<ExpectedPremium>" "<ExpectedProvider>" "<ExpectedPlan>"
    Examples:
      | zipCode | county    | age1 | age2 | age3 | age4 | age5 | ExpectedPremium | ExpectedProvider            | ExpectedPlan                                |
      | 80002   | Jefferson | 55   | 54   | 19   | 20   | 13   | $2298.43        | Denver Health Medical Plan  | Elevate Health Plans Colorado Option Silver |
      | 80446   | Grand     | 50   | 51   | 15   | 12   | 10   | $2537.25        | Rocky Mountain Health Plans | RMHP Sky Colorado Option Silver             |


  Scenario Outline: Silver - Verifying the correct amount is displayed for six member
    Given I open the login page on the "tax Silver" portal
    When I validate I am on the "tax Silver" page
    Then I enter for one member "<zipCode>" and "<county>" "<age1>" second member "<age2>" third member "<age3>" fourth member "<age4>" fifth member "<age5>" sixth member "<age6>" and validate "<ExpectedPremium>" "<ExpectedProvider>" "<ExpectedPlan>"
    Examples:
      | zipCode | county | age1 | age2 | age3 | age4 | age5 | age6 | ExpectedPremium | ExpectedProvider            | ExpectedPlan                                |
      | 80002   | Adams  | 55   | 54   | 19   | 20   | 13   | 10   | $2298.43        | Denver Health Medical Plan  | Elevate Health Plans Colorado Option Silver |
      | 80482   | Grand  | 50   | 51   | 15   | 12   | 10   | 7    | $2537.25        | Rocky Mountain Health Plans | RMHP Sky Colorado Option Silver             |







