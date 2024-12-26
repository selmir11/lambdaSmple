@OPS
Feature: new admin LCE
  @SLER-1906
  Scenario:IndDash: Verify Header and Footer
    When I open the login page on the "login" portal
    When I login as "C4testadmlce@gmail.com" and "ALaska12!" individual existing user
    Then I wait for 3000 milliseconds
    Then I navigate to admin lce url

#    Verify Logo, Header, Footer and Titles
    Then I validate "Logo" for Admin Portal
    Then I verify Title for admin LCE page
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab

#    Verify Look up button, displaying current - last three financial years, dropdown arrows and app data message
    Then I enter an account ID in "5890916640" "4007384519" accountID field
    Then I click on Look up button
    Then I wait for 3000 milliseconds
    Then I click on verify select plan year to edit message is displaying on admin lce page
    Then I verify current year and previous three financial years are displaying in applictaion data
    Then I click on application data dropdown arrow
    Then I verify no application data message is displayed
