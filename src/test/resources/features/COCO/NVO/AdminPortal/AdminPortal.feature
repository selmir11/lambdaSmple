Feature: Admin Portal Validations

  Background: I go the login portal
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on Sign Out in the Header for "Elmo"

    @SLCR-670
    Scenario: Admin portal validations for account creation in coco
      And I open the login page on the "admin" portal
      And I refresh the page
      And I validate I am on the "Login" page
      When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
      And I validate I am on the "Admin search" page
      And I select "coco" checkbox on Admin Portal Dashboard
      And I search for user and click email from search results
      Then I click on view button for "Account Activity" report
      Then I validate I am on the "Account Activity" page
      Then I validate the account activity record for "Account Creation"