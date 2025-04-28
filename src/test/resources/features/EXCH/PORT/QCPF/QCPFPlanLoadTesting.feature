@port @portQCPF
Feature:QCPF: plan load testing

  @SLER-2110
  Scenario Outline: Verifying total plan number by county and carrier plan breakdown

    Given I open the login page on the "QCPF" portal
    And I validate I am on the "QCPF" page
    Then I click get started on QCPF Page
    And I validate I am on the "QCPF Input Information" page
    Then I enter basic information Name "<name>" sex "<sex>" DOB "<DOB>" in QCPF page
    And I enter location and coverage zipCode "<zipCode>" county "<county>" in QCPF page
    Then I click "No" for financial help question in QCPF page
    And I click continue button in QCPF page
    Then I validate I am on the "QCPF Preferences" page
    And I click this looks right button in QCPF page
    Then I validate I am on the "QCPF Preferences Doctor" page
    And I click continue button in QCPF page
    Then I validate I am on the "QCPF Preferences Medication" page
    And I click continue button in QCPF page
    Then I validate I am on the "QCPF List of Plans" page
    Then I click ok got it button in QCPF page
    Then I validate I am on the "QCPF Plan results" page
    And I validate the total number "<plansNumber>" of plans displayed and for Plan Anthem Blue Cross & Blue Shield "<Anthem>", Kaiser Permanente "<Kaiser>", Denver Health Medical Plan "<Denver Health>", Cigna "<Cigna>", Rocky Mountain Health Plans "<Rocky Mountain>", Select Health "<Select>"
    Then I click start over button in QCPF page

    Examples:
      | name | sex  | DOB     | zipCode | county    | plansNumber | Anthem | Kaiser | Denver Health | Cigna | Rocky Mountain | Select |
      | joe  | Male | 01/2000 | 80207   | Denver    | 89          | 27     | 10     | 11            | 12    | 25             | 4      |
      | joe  | Male | 01/2000 | 80123   | Jefferson | 89          | 27     | 10     | 11            | 12    | 25             | 4      |
      | joe  | Male | 01/2000 | 80022   | Adams     | 89          | 27     | 10     | 11            | 12    | 25             | 4      |


  @SLER-2110
  Scenario Outline: Verifying total plan number by county and carrier for 5 plan breakdown
    Given I open the login page on the "QCPF" portal
    And I validate I am on the "QCPF" page
    Then I click get started on QCPF Page
    And I validate I am on the "QCPF Input Information" page
    Then I enter basic information Name "<name>" sex "<sex>" DOB "<DOB>" in QCPF page
    And I enter location and coverage zipCode "<zipCode>" county "<county>" in QCPF page
    Then I click "No" for financial help question in QCPF page
    And I click continue button in QCPF page
    Then I validate I am on the "QCPF Preferences" page
    And I click this looks right button in QCPF page
    Then I validate I am on the "QCPF Preferences Doctor" page
    And I click continue button in QCPF page
    Then I validate I am on the "QCPF Preferences Medication" page
    And I click continue button in QCPF page
    Then I validate I am on the "QCPF List of Plans" page
    Then I click ok got it button in QCPF page
    Then I validate I am on the "QCPF Plan results" page
    And I validate the total number "<plansNumber>" of plans displayed and for Plan Anthem Blue Cross & Blue Shield "<Anthem>", Kaiser Permanente "<Kaiser>", Denver Health Medical Plan "<Denver Health>", Cigna "<Cigna>", Rocky Mountain Health Plans "<Rocky Mountain>"
    Then I click start over button in QCPF page

    Examples:
      | name | sex  | DOB     | zipCode | county    | plansNumber | Anthem | Kaiser | Denver Health | Cigna | Rocky Mountain |
      | joe  | Male | 01/2000 | 80109   | Douglas   | 85          | 27     | 10     | 11            | 12    | 25             |
      | joe  | Male | 01/2000 | 80301   | Boulder   | 85          | 27     | 10     | 11            | 12    | 25             |

  @SLER-2110
Scenario Outline: Verifying total plan count by county
  Given I open the login page on the "QCPF" portal
  And I validate I am on the "QCPF" page
  Then I click get started on QCPF Page
  And I validate I am on the "QCPF Input Information" page
  Then I enter basic information Name "<name>" sex "<sex>" DOB "<DOB>" in QCPF page
  And I enter location and coverage zipCode "<zipCode>" county "<county>" in QCPF page
  Then I click "No" for financial help question in QCPF page
  And I click continue button in QCPF page
  Then I validate I am on the "QCPF Preferences" page
  And I click this looks right button in QCPF page
  Then I validate I am on the "QCPF Preferences Doctor" page
  And I click continue button in QCPF page
  Then I validate I am on the "QCPF Preferences Medication" page
  And I click continue button in QCPF page
  Then I validate I am on the "QCPF List of Plans" page
  Then I click ok got it button in QCPF page
  Then I validate I am on the "QCPF Plan results" page
  And I validate the total number "<plansNumber>" of plans displayed by county
  Then I click start over button in QCPF page
  Examples:
    | name | sex  | DOB     | zipCode | county      | plansNumber |
    | joe  | Male | 01/2000 | 80829   | El Paso     | 62          |
    | joe  | Male | 01/2000 | 80813   | Teller      | 51          |
    | joe  | Male | 01/2000 | 80444   | Clear Creek | 62          |
    | joe  | Male | 01/2000 | 80475   | Park        | 66          |
    | joe  | Male | 01/2000 | 81101   | Alamosa     | 25          |
    | joe  | Male | 01/2000 | 81212   | Fremont     | 29          |
    | joe  | Male | 01/2000 | 81621   | Eagle       | 35          |
    | joe  | Male | 01/2000 | 81230   | Gunnison    | 25          |
    | joe  | Male | 01/2000 | 81321   | Montezuma   | 39          |
    | joe  | Male | 01/2000 | 80424   | Summit      | 39          |

    #full test: We conduct a full test once an update is made to the QCPF page.
#    | joe  | Male | 01/2000 | 80166   | Arapahoe     | 89          |
#    | joe  | Male | 01/2000 | 80021   | Broomfield   | 85          |
#    | joe  | Male | 01/2000 | 80106   | Elbert       | 73          |
#    | joe  | Male | 01/2000 | 80474   | Gilpin       | 62          |
#    | joe  | Male | 01/2000 | 80511   | Larimer      | 66          |
#    | joe  | Male | 01/2000 | 81504   | Mesa         | 47          |
#    | joe  | Male | 01/2000 | 80634   | Weld         | 66          |
#    | joe  | Male | 01/2000 | 81006   | Pueblo       | 39          |
#    | joe  | Male | 01/2000 | 81073   | Baca         | 14          |
#    | joe  | Male | 01/2000 | 81054   | Bent         | 14          |
#    | joe  | Male | 01/2000 | 81201   | Chaffee      | 25          |
#    | joe  | Male | 01/2000 | 80810   | Cheyenne     | 14          |
#    | joe  | Male | 01/2000 | 81129   | Conejos      | 25          |
#    | joe  | Male | 01/2000 | 81133   | Costilla     | 25          |
#    | joe  | Male | 01/2000 | 81063   | Crowley      | 14          |
#    | joe  | Male | 01/2000 | 81252   | Custer       | 25          |
#    | joe  | Male | 01/2000 | 81089   | Huerfano     | 25          |
#    | joe  | Male | 01/2000 | 81036   | Kiowa        | 14          |
#    | joe  | Male | 01/2000 | 80815   | Kit Carson   | 14          |
#    | joe  | Male | 01/2000 | 81082   | Las Animas   | 14          |
#    | joe  | Male | 01/2000 | 80826   | Lincoln      | 14          |
#    | joe  | Male | 01/2000 | 80751   | Logan        | 25          |
#    | joe  | Male | 01/2000 | 81130   | Mineral      | 25          |
#    | joe  | Male | 01/2000 | 80653   | Morgan       | 29          |
#    | joe  | Male | 01/2000 | 81067   | Otero        | 14          |
#    | joe  | Male | 01/2000 | 80734   | Phillips     | 25          |
#    | joe  | Male | 01/2000 | 81043   | Prowers      | 14          |
#    | joe  | Male | 01/2000 | 81132   | Rio Grande   | 25          |
#    | joe  | Male | 01/2000 | 81149   | Saguache     | 25          |
#    | joe  | Male | 01/2000 | 80749   | Sedgwick     | 25          |
#    | joe  | Male | 01/2000 | 80801   | Washington   | 14          |
#    | joe  | Male | 01/2000 | 80758   | Yuma         | 14          |
#    | joe  | Male | 01/2000 | 81147   | Archuleta    | 39          |
#    | joe  | Male | 01/2000 | 81416   | Delta        | 37          |
#    | joe  | Male | 01/2000 | 81324   | Dolores      | 29          |
#    | joe  | Male | 01/2000 | 81650   | Garfield     | 25          |
#    | joe  | Male | 01/2000 | 80459   | Grand        | 29          |
#    | joe  | Male | 01/2000 | 81235   | Hinsdale     | 25          |
#    | joe  | Male | 01/2000 | 80430   | Jackson      | 14          |
#    | joe  | Male | 01/2000 | 81301   | La Plata     | 39          |
#    | joe  | Male | 01/2000 | 80461   | Lake         | 29          |
#    | joe  | Male | 01/2000 | 81625   | Moffat       | 37          |
#    | joe  | Male | 01/2000 | 81401   | Montrose     | 25          |
#    | joe  | Male | 01/2000 | 81427   | Ouray        | 25          |
#    | joe  | Male | 01/2000 | 81611   | Pitkin       | 25          |
#    | joe  | Male | 01/2000 | 81648   | Rio Blanco   | 37          |
#    | joe  | Male | 01/2000 | 80487   | Routt        | 45          |
#    | joe  | Male | 01/2000 | 81433   | San Juan     | 29          |
#    | joe  | Male | 01/2000 | 81423   | San Miguel   | 25          |
