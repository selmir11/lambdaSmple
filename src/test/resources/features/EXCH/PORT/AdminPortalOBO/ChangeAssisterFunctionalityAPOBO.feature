@port @FindExpertHelp @AssistNet @AdminPortalOBO
Feature: Change authorized assister functionality on the Manage who helps you page via Admin Portal OBO

  @SLER-1163
  Scenario: Change authorized assister functionality on the Manage who helps you page via Admin Portal OBO
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    Then I click create account on admin portal
    And I validate I am on the "Create Account" page
    Then I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Admin search" page
    And  I search for user and click email from search results
    Then I validate I am on the "Admin Portal individual dashboard" page
    Then I validate "Admin Portal Text Display" for Admin Portal
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I switch to the tab number 1
    And I validate I am on the "Account Overview" page

    And I click on Get Assistance in the "Exch NonElmo" Header
    And I click on Find Expert Assistance in the "individual dashboard" Header

    Then I verify Find Expert Help header Text in "English"
    Then I verify Find Expert Help page "Exch" title Text in "English"
    Then I validate the Authorize Assister Organization button "is displayed"

    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page

    Then I verify Manage who helps you header text in "English"
    And I validate the current assister text exists
    And I validate the current assister table header labels

    And I validate my assister details in the current assister table are "Blue River Assisters", "Ucr14" or "8Gvzo", "80205", "720-894-1592", Assister, Approved
    And I validate the Change Assister button "is displayed"

    Then I click on change the existing assister
    Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
    And I validate the warning text to authorize new or keep the same assister
    Then I click on "keep Current Organisation" in the warning container to authorize new or keep the same assister
    Then I click Go Back on the Authorize Assister Organization page

    And I validate the Previous Broker Assister table is not displayed
    And I validate my assister details in the current assister table are "Blue River Assisters", "Ucr14" or "8Gvzo", "80205", "720-894-1592", Assister, Approved

    Then I verify Manage who helps you header text in "English"

    Then I click on change the existing assister
    Then I authorize my assister's site ID "hEHb0" or "Giglp"
    Then I click on "authorize New Organisation" in the warning container to authorize new or keep the same assister
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page

    Then I verify Manage who helps you header text in "English"

    And I validate my assister details in the current assister table are "Assisters Inc", "hEHb0" or "Giglp", "80246", "303-123-9548", Assister, Approved

    Then I validate the Assister details in the Previous Broker Assister table are "Blue River Assisters", "Ucr14", or "8Gvzo", "80205", "720-894-1592", Assister

    Then I Remove my current Assister
    And I "Ok" my decision to remove my current assister
    And I validate no assister is authorized

    And I click on Sign Out in the Header for "WhoHelpsYouPage"