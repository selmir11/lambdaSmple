@OPS @COCOMydocs
Feature: Verify Header, Footer and welcome back button link on my documents page for admin portal user
  @SLCR-80
  Scenario: SLCR-80 Verify Header, Footer and welcome back button link on my documents page for admin portal user
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I validate I am on the "Admin search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "5890916640" "4007384519" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    And I initiate incoming page
    And I click on "My Documents and Letters" link on welcome page
    Then I validate I am on the "My Documents" page
#    Verify Footer and welcome back navigate button
    Then I validate Welcome back button navigates to welcome page
    And I click on "My Documents and Letters" link on welcome page
    Then I validate I am on the "My Documents" page
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
#    Verify Header, Document displays in document letters containers and welcome back button navigation, sign out and displaying login page again after sign out
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Documents and Letters" link on welcome page
    And I select year "All" in plan year
    Then I validate the notice "IND_Plan Selection and Payment Confirmation (EN-002-04)" exist in my document letter Containers
    And I click on Learn More in the Header
    And I validate I am on the "Contact Us" page and close tab
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on "My Documents and Letters" link on welcome page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    And I click on "My Documents and Letters" link on welcome page
    Then I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    And I go to the previous browser page
    And I click on Sign Out in the Header for "Elmo"
    And I validate I am on the "Login" page




