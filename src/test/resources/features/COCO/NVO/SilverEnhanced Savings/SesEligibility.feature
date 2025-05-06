Feature: Coco user Validate the eligibility - Tests Run during Open Enrollment

  @SLCR-711
  Scenario: Validate fields from member rules result table by adding a dependent to an active ses eligibility during ses limited for new year
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And I login with "SES" credentials
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    And I get the account Id from my profile page coco
    And I get the name of the primary person from my profile page coco
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "getFromSharedData"
    Then I validate I am on the "CoCo Tell us about yourself" page
    And I get the memberId of primary member from url
    Then I click Go Back on the tell us about yourself page
    Then I validate I am on the "CoCo Family Overview" page
    Then I select add another family member on the Family Overview page
    And I enter details on tell us about additional members of your household page with name "Wife", dob "03051989", gender "Female", and applying "Yes"
    And I select the relationship to primary member as "Spouse"
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Wife"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "Birth" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I wait for 5000 milliseconds
    And I verify the application result details in DB as "ELIGIBLE_FOR_HP2" for "getFromSharedData"
    And I verify the application result details in DB as "ELIGIBLE_FOR_HP2_LIMITED" for "Wife"
    Then I verify the created by value as "HiaePhaseTwoGrandfatheringAppenderService" for "getFromSharedData" and determination as "ELIGIBLE_FOR_HP2"
    Then I verify the created by value as "RulesEngineAppenderService" for "Wife" and determination as "ELIGIBLE_FOR_HP2_LIMITED"

  @SLCR-687 @NVOCoCoRegression
  Scenario: Validate 2025 eligibility remains after over income is reported
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    And I login with "SES Constant" credentials
    Then I validate I am on the "CAC Screener" page
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    And I get the account Id from my profile page coco
    And I get the name of the primary person from my profile page coco
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "getFromSharedData"
    And I get the memberId of primary member from url
    Then I validate I am on the "CoCo Tell us about yourself" page
    And I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "InsuranceLoss" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I wait for 2000 milliseconds
    And I verify the application result details in DB as "ELIGIBLE_FOR_HP2" for "getFromSharedData"
    Then I verify the created by value as "HiaePhaseTwoGrandfatheringAppenderService" for "getFromSharedData" and determination as "ELIGIBLE_FOR_HP2"


