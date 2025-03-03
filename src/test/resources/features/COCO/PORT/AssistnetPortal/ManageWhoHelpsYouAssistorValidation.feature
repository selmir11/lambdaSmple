@portCOCO @SLCR-365
Feature: Manage who helps you Assister Text validation

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
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate I am on the "FindExpertHelpCoco" page
    Then I verify Find Expert Help header Text in "Spanish"
    Then I verify Find Expert Help page "CoCo" title Text in "Spanish"
    And I change the language from header to "English"
    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page
    And I validate the Continue on my own button "is not displayed"

    And I validate the current assister text exists
    And I validate the current assister table header labels

    And I validate my assister details in the current assister table are "Blue River Assisters", "Ucr14" or "8Gvzo", "80205", "720-894-1592", Assister, Approved
    Then I Remove my current Assister
    And I "Ok" my decision to remove my current assister
    And I validate no assister is authorized

    And I validate the Previous Broker Assister text
    And I validate the Previous Broker Assister table header labels
    Then I validate the Assister details in the Previous Broker Assister table are "Blue River Assisters", "Ucr14", or "8Gvzo", "80205", "720-894-1592", Assister
    And I validate the Continue on my own button "is not displayed"

    And I click the Authorize Assister Organization button
    Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
    And I validate the authorization success message
    Then I click Go Back on the Authorize Assister Organization page

    Then I click on change the existing assister
    Then I authorize my assister's site ID "Ucr14" or "8Gvzo"
    And I validate the warning text to authorize new or keep the same assister
    Then I click on "keep Current Organisation" in the warning container to authorize new or keep the same assister
    Then I click Go Back on the Authorize Assister Organization page
    And I validate the Previous Broker Assister table is not displayed
    And I validate my assister details in the current assister table are "Blue River Assisters", "Ucr14" or "8Gvzo", "80205", "720-894-1592", Assister, Approved
    Then I Remove my current Assister
    And I "Ok" my decision to remove my current assister
    And I validate no assister is authorized
    And I validate the Continue on my own button "is not displayed"
    And I wait for 200 milliseconds
    Then I click on Sign Out in the Header for "Elmo"






