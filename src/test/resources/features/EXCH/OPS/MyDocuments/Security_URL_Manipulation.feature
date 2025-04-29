@OPS @Exch @MyDocuments
Feature: OPS: MyDocs: Security: URL Manipulation Individual

  @SLER-2382
  Scenario: RT-2062: OPS: MyDocs: Security: URL Manipulation Individual
#    Valid user
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click on sign in on login page
    And I enter valid credential STG username "AutomationUser.AghfszcbTest@test.com" PW "ALaska12!" QA username "mgtpmcedfdMG@test.com" PW "ALaska12!" for individual user without sign in any env
    When I click on sign in on login page
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And  I select year "All" in plan year
    And I wait for 2000 milliseconds
    Then I validate all uploaded documents or notices loaded for my account start with "IND"
      | IND_Welcome Message (AM-001-01)     |
#    access denied verify when trying to use url
   Then I navigate to "connectforhealthco.com/my-documents-services/documents/50871" url for qa and "connectforhealthco.com/my-documents-services/documents/50871" for staging
    And I verify I receive access denied message
    Then I navigate to "connectforhealthco.com/my-documents-services/documents/122008" url for qa and "connectforhealthco.com/my-documents-services/documents/52131" for staging
    And I verify I receive access denied message
    Then I navigate to "connectforhealthco.com/my-documents-services/documents/121745" url for qa and "connectforhealthco.com/my-documents-services/documents/156819" for staging
    And I verify I receive access denied message
    Then I navigate to "connectforhealthco.com/my-documents-services/documents/122020" url for qa and "connectforhealthco.com/my-documents-services/documents/156716" for staging
    And I verify I receive access denied message
    Then I navigate to "connectforhealthco.com/my-documents-services/documents/441" url for qa and "connectforhealthco.com/my-documents-services/documents/110796" for staging
    And I verify I receive access denied message
    Then I navigate to "connectforhealthco.com/MyDocuments/home?lang=en" url for qa and "connectforhealthco.com/MyDocuments/home?lang=en" for staging
    And I click on Sign Out in the Header for "Elmo"
##  Log into different Ind account with same browser and open doc with access but cannot open doc opened in last account
    And I enter valid credential STG username "AutomationUser.LpupzmctTest@test.com" PW "ALaska12!" QA username "AutomationUser.YmclgiknTest@test.com" PW "ALaska12!" for individual user without sign in any env
    When I click on sign in on login page
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I select year "All" in plan year
    And I wait for 2000 milliseconds
    Then I validate all uploaded documents or notices loaded for my account start with "IND"
      | IND_Welcome Message (AM-001-01)     |
    Then I navigate to "connectforhealthco.com/my-documents-services/documents/120485" url for qa and "connectforhealthco.com/my-documents-services/documents/156171" for staging
    And I verify I receive access denied message



