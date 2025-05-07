@OPS @Exch @ExchMyDocs
Feature: OPS MyDocs Download hCentive document

  @SLER-2153
  Scenario:SLER-2153:OPS MyDocs Download hCentive document[RT-1988]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "6103120466" "1801096812" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    When I select All and Documents from drop down below Past Documents and Letters
    When I click on expand arrow for 1st document
    Then I verify file downloaded is "Peace Corps" and it is not empty