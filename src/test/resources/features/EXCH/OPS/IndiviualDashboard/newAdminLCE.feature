@OPS @Exch @IndiviualDashboard
Feature: new admin LCE

  Background:
    When I open the login page on the "login" portal
    When I login as "C4testadmlce@gmail.com" and "ALaska12!" individual existing user
    Then I wait for 3000 milliseconds
    Then I navigate to admin lce url

  @SLER-1906
    Scenario: :IndDash: Verify Header and Footer
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

  @SLER-1996
  Scenario: New admin LCE: Recreate application link navigation and verify links from page
    Then I enter an account ID in "5020327630" "5020327630" accountID field
    Then I click on Look up button
    Then I click on application data dropdown arrow
    Then I click on Recreate application link number 1 for plan year 2025 on the Admin LCE page
    Then I verify Confirm change effective dates pop up displays on Admin LCE page
    Then I enter the effective date to "0430" for year "2025" on Admin LCE page
    Then I click on confirm button on Admin LCE page


  @SLER-2078
  Scenario: New admin LCE: Validate changes after submitting LCE - Open bugs # NVO-5515, OPS- 6605
    Then I enter an account ID in "5020327630" "5020327630" accountID field
    Then I click on Look up button
    Then I wait for 3000 milliseconds
    Then I click on application data dropdown arrow
    Then I click on Recreate application link number 1 for plan year 2025 on the Admin LCE page
    Then I verify Confirm change effective dates pop up displays for plan year 2025 on Admin LCE page
    Then I enter the effective date to "0101" for year "2025" on Admin LCE page
    Then I click on confirm button on Admin LCE page
#    And I validate I am on the "Admin LCE confirmation" page - not working now
    And I wait for 2000 milliseconds
    Then I validate confirmation message for plan year 2025 on admin LCE confirmation page with effective date
    And I click Continue via OBO button on Admin LCE page
