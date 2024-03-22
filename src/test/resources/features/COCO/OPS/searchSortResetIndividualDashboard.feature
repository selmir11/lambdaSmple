# new feature
# Tags: optional

Feature: on Individual dashboard check search, sort and reset functionality

  Scenario: default search to Individual
    Given  I open the login page on the "admin" portal
    Then I login as Admin User
    And I validate I am on the "Admin dashboard" page
  #  When I am directed to the {page}}
 #   And I see default radio button Individual is selected
    Then I verify title text on the Individual search page