Feature: Easy Enrollment API

  @SLER-1830 @EE_API @NVOExchRegression
  Scenario: Easy Enrollment API validation failure for invalid SSN
    Given I get Easy Enrollment API base URL
    When I send a request with the following data: adjustedGrossIncome:"40000", emailAddress:"random_email", filedByDeadline:"1", filingType:"1", firstName:"John", householdSize:"1", lastName:"Smith", mailingAddressLine1:"123 Street", zipCode:"80205", middleInitial:"M", phoneNumber:"7206574321", dateOfBirth:"11201994", ssn:"random"
    And I send the DOR to C4 API request
    Then response status code should be 400
    And validation message should be "{taxHouseholdMembers[0].ssn:: Must be 9 digits}"
