# memberDetails
# Tags: ops

Feature: Member details

  Scenario: Validate member data on Welcome page
   @Given Login to admin Portal and search for Coco account
   public void login_to_admin_portal_and _search(){
  }
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page