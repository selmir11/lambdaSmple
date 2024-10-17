@portCOCO @FindExpertHelpCoCo @AssistNetCoCo
Feature: Change authorized assister functionality on the Manage who helps you page

  @SLCR-368
  Scenario: Authorizing an assister for an individual account
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    And I click create my account from pre-screen page
    Then I validate I am on the "Create Account" page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header

    Then I verify Find Expert Help header Text in "English"
    Then I verify Find Expert Help page "CoCo" title Text in "English"

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

    And I click on Sign Out in the Header for "Elmo"