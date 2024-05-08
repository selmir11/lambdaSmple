@APTC @APTCCalculator
Feature: API Tests related to APTC

  @SLER-308  @Teller @SLER-308
  Scenario Outline: Single Member Household in Teller County with FPL over 400%
      Given I get APTC CALCULATOR base URL
      When I send the household Information's: "<household>", "<Zip>", "<Fips>", "<FPL>", "<DOB>"
      And I send the APTC Calculator Request
      Then status code should be 200
      And I expect "<APTC>" and "<Contribution Amount>"
      Examples:
        | household | Zip   | Fips  | FPL    | DOB        | APTC   | Contribution Amount |
        | 58321.0   | 80863 | 08119 | 400.01 | 1981-01-01 | 41.98  | 8.5                 |
        | 57420.0   | 80220 | 08031 | 422.52 | 1971-01-01 | 258.6  | 8.5                 |
        | 57960.0   | 80461 | 08065 | 426.49 | 1961-01-01 | 834.87 | 8.5                 |
        | 61180.0   | 81650 | 08045 | 450.18 | 1959-01-01 | 944.39 | 8.5                 |




