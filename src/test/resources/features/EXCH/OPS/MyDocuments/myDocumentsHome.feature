@OPS
Feature: My Document Home Page validations

  @SLER-2090 @OPSRegression
  Scenario: OPS MyDocs Navigating to file explorer[RT-1819]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click on upload another document
    When I select document "TestMyDocs.docx" and upload
    Then I see the document "TestMyDocs.docx" that I choose in the Upload modal
    When I click on close to remove the uploaded document
    Then I verify document removed successfully
    And I close button to close modal
    Then I see the username that I am currently logged into

  @SLER-2109 @OPSRegression
  Scenario: OPS MyDocs Select Type and checks errors[RT-1938]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I enter general mandatory data for "exchange" account creation
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    And I click on upload another document
    When I select any type of document from dropdown
    When I select any category of document from dropdown
    When I click on upload my document button
    Then I validate file required error message
    And I close button to close modal
    And I click on upload another document
    When I click on upload my document button
    Then I validate selection required error message
    Then I validate font colour height and size of selection required error
    Then I validate border colour of type and category dropdown
    When I select any type of document from dropdown
    When I select any category of document from dropdown
    Then I validate selection required error message disappear
