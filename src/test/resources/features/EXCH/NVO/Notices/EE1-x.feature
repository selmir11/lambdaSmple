@NVO @NVOPDF
Feature: EE-1-2 Notices
  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-1415 @WIP
  Scenario: Easy Enrollment API validation success; EE-1-1
    Given I get Easy Enrollment API base URL
    Then I send a request body with the following data: adjustedGrossIncome:"55000", emailAddress:"random_email", filedByDeadline:"1", filingType:"1", firstName:"Mack", householdSize:"1", lastName:"Smith", mailingAddressLine1:"1234 Road", mailingAddressLine2:"", city:"Denver", zipCode:"80202", middleInitial:"", phoneNumber:"1234123412", dateOfBirth:"12011971", ssn:"random", year:"2022"
    And I send the DOR to C4 API request
    Then response status code should be 200


  @SLER-1416 @WIP
  Scenario: Easy Enrollment API validation success; EE-1-2
    Given I get Easy Enrollment API base URL
    Then I send a request body with the following data: adjustedGrossIncome:"55000", emailAddress:"random_email", filedByDeadline:"0", filingType:"1", firstName:"Mack", householdSize:"1", lastName:"Smith", mailingAddressLine1:"1234 Road", mailingAddressLine2:"", city:"Denver", zipCode:"80202", middleInitial:"", phoneNumber:"1234123412", dateOfBirth:"12011971", ssn:"random", year:"2022"
    And I send the DOR to C4 API request
    Then response status code should be 200