@SLER-130 @OPS @COCO @AP

Feature: AdminPortal: General: Header, footer, and error message validation on Login screen
  @SLER-130

  Scenario:SLER-130:Validate Header on Login screen
    Given I open the login page on the "admin" portal
    Then I validate "Logo" for Admin Portal
    Then I validate "clicking on logo navigates Connect For Health" for Admin Portal
    Then I validate "TitleTextValidate" for Admin Portal

  Scenario: Validate Footer on Login screen
    Given I open the login page on the "admin" portal
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

  Scenario: Validate Error message on Login screen
    Given I open the login page on the "admin" portal
    When I click on sign in on login page
    Then I receive error message for Username
    Then I receive error message for Password
    And I receive message I forgot username and password