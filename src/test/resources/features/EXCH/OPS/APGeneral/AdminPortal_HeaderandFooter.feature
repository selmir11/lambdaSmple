@OPS @APGeneral
Feature: Verify Header, Footer and welcome back button link on my documents page for admin portal user
  @SLER-701
  Scenario:SLER-701:Verify Header, Footer and welcome back button link on my documents page for admin portal user
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "4007812610" "4007795117" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I select year "Previous Year" in plan year
    And I verify the page text in "English" on the My Documents Page
#    Verify Footer and welcome back navigate button
    Then I validate Welcome back button navigates to welcome page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Exch" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I verify text on the "Exch" "Footer" in "English"
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
#    Verify Header and sign out
    And I click on the Colorado Connect or C4 Logo in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click link my docs on accountOverview page
    And I click on Learn More in the Header
    And I validate I am on the "Contact Us" page and close tab
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click link my docs on accountOverview page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I click link my docs on accountOverview page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "ExpertHelp in community" Header
    And I go to the previous browser page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application History" page


  @SLER-235
  Scenario:SLER-235:Verify Footer and login page on admin portal [RT-1084]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I verify text on the "Exch" "Footer" in "English"
    And I click on "Facebook" Icon in the Footer
    And I validate I am on the "Facebook" page and close tab
    And I click on "X" Icon in the Footer
    And I validate I am on the "X" page and close tab
    And I click on "YouTube" Icon in the Footer
    And I validate I am on the "YouTube" page and close tab
    And I click on "Instagram" Icon in the Footer
    And I validate I am on the "Instagram" page and close tab
    And I click on "LinkedIn" Icon in the Footer
    And I validate I am on the "LinkedIn" page and close tab
    And I click on "Threads" Icon in the Footer
    And I validate I am on the "Threads" page and close tab
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I search for the "individual" title
    Then I logout from Admin Portal

