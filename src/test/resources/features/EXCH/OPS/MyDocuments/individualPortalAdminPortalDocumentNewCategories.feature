@OPS @Exch @ExchMyDocs
Feature: My documents new categories for Individual portal as well as Admin portal
  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page

  @SLER-2414
  Scenario:SLER-2414: OPS: MyDocs: New Categories(RT-2092)
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I verify Document header on my document page
      | My Documents and Letters |
    Then I verify Sub header on my document page
      | We need more information to confirm or verify what you told us in your application. |
    And I click on upload another document
    And I click on what type of document is this dropdown and verify the following categories
      | Customer Authorization Form                            |
      | Appeals                                                |
      | Medicare                                               |
      | Health First Colorado (Medicaid) Application           |
      | Health First Colorado (Medicaid) Redetermination (RRR) |
    And I close button to close modal
    Then I click on Sign Out in the Header for "Elmo"
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
    And I click on what type of document is this dropdown and verify the following categories
      | Customer Authorization Form                            |
      | Appeals                                                |
      | Medicare                                               |
      | Health First Colorado (Medicaid) Application           |
      | Health First Colorado (Medicaid) Redetermination (RRR) |
    And I close button to close modal
    Then I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page