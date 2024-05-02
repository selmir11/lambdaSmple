@APTC @APTCCalculator
Feature: API Tests related to APTC

  @Teller @SLER-308
  Scenario: Single Member Household in Teller County with FPL over 400%
    When I send an APTCCalculator Request with Magi "58321.00", Zip "80863", Fips "08119", FPL "400.01", DOB "1981-01-01" and expect APTC "41.98" and Contribution Amount "8.5"