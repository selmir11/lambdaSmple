@OPS @Exch @MyDocs
@SLER-2397
Feature: RT-2066: OPS: My Docs: Security: URL Manipulation Broker
  @SLER-2397
  Scenario: OPS: My Docs: Security: URL Manipulation Broker
# Verify doc opens from broker account with access
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "Amethyst.Broker@invalid.com" password "ALaska13!" and "Amethyst.Broker@invalid.com" password "ALaska13!"
    And I validate I am on the "Broker Portal Your Clients" page
    And I search for a client named for staging "apelizeaswv" or for QA "carol"
    And I wait for 2000 milliseconds
    Then I click on the first client in my list
    Then I validate the "Manage" option is displayed
    Then I click "manage" the client
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And  I select year "Current Year" in plan year
    And I wait for 2000 milliseconds
    When I click on expand arrow for 1st document
    Then I verify file downloaded is "IND_Notify Client of Broker Authorization" and it is not empty
    Then I click on Sign Out in the Header for "Elmo"
###      Removing Broker access
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click on sign in on login page
    And I enter valid credential STG username "apindgwgmkktapeliz@test.com" PW "ALaska16!" QA username "dopheim6+071524.2@gmail.com" PW "ALaska12!" for individual user without sign in any env
    When I click on sign in on login page
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "ExpertHelp in community" Header
    And I wait for 2000 milliseconds
    Then I Remove my current Broker
    And I "Ok" my decision to remove my current broker
    And I validate no broker is authorized
      Then I click on Sign Out in the Header for "Elmo"
##    Verifying cannot open doc from de-authorized broker
    Given I open the login page on the "broker" portal
    And I validate I am on the "Login" page
    And I login as Broker User any environment "Amethyst.Broker@invalid.com" password "ALaska13!" and "Amethyst.Broker@invalid.com" password "ALaska13!"
    And I validate I am on the "Broker Portal Your Clients" page
    And I search for a client named for staging "eight" or for QA "new"
    And I wait for 2000 milliseconds
    Then I click on the first client in my list
    Then I validate the "Manage" option is displayed
    Then I click "manage" the client
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I navigate to "connectforhealthco.com/my-documents-services/documents/118689" url for qa and "connectforhealthco.com/my-documents-services/documents/147956" for staging
    And I verify I receive access denied message
    Then I click Go Back button from chrome browser
    Then I click on Sign Out in the Header for "Elmo"
#    Re-authorising broker
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click on sign in on login page
    And I enter valid credential STG username "apindgwgmkktapeliz@test.com" PW "ALaska16!" QA username "dopheim6+071524.2@gmail.com" PW "ALaska12!" for individual user without sign in any env
    When I click on sign in on login page
    Then I validate I am on the "Account Overview" page
    Then I click link my docs on accountOverview page
    Then I validate I am on the "My Documents" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "ExpertHelp in community" Header
    And I wait for 2000 milliseconds
    And I click on Find a Broker
    Then I Search authorized Broker "Amethyst"
    And I click on Search button in find certified broker page
    And I click more details from the first broker result container
    Then I click the Authorize broker button

    Then I click the "Authorize Broker" button on the Authorize a broker modal
    Then I click on Sign Out in the Header for "Elmo"


