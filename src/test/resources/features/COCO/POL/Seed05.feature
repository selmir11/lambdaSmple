Feature: Seed05 - COCO
# verification WIP

  Scenario: Seed 05 For COCO- MULTI-GROUP (DIFFERENT RATING AREAS)

    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And I enter valid credentials to login
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    Then I click Primary EditUpdate on the Family Overview page
    Then I enter details on tell us about yourself page and continue with "09051959", "Male", and applying "Yes"
    And I enter my residential address "105 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "I prefer not to answer" ethnicity option
    And I select "Native Hawaiian/Other Pacific Islander" race option
    And I click continue on the Ethnicity and race page
    And I select "Yes" employment option
    And I enter "20,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select None of these as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
#   SPOUSE
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Wife", "07271963", "Female", and applying "Yes"
      |Primary:Spouse|
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "105 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "CoCo Ethnicity and Race" page
    And I select "I prefer not to answer" ethnicity option
    And I select "Native Hawaiian/Other Pacific Islander" race option
    And I click continue on the Ethnicity and race page
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select None of these as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
  #  Son
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Son", "08281999", "Male", and applying "Yes"
      |Primary:Child or Other dependent|
      |Wife:Child or Other dependent|
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter complete residential address details for additional member addressLine1 "101 Diff Drive",addressLine2 "Seed05",city "Denver",state "CO",zipcode "80205",county "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "CoCo Ethnicity and Race" page
    And I select "I prefer not to answer" ethnicity option
    And I select "Not listed" race option
    And I click continue on the Ethnicity and race page
    And I select "Yes" employment option
    And I enter "20,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select None of these as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
#    Daughter In-Law
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "DIL", "05052001", "Female", and applying "Yes"
      |Primary:Other Relative|
      |Wife:Other Relative|
      |Son:Spouse|
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter complete residential address details for additional member addressLine1 "101 Diff Drive",addressLine2 "Seed05",city "Denver",state "CO",zipcode "80205",county "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "CoCo Ethnicity and Race" page
    And I select "I prefer not to answer" ethnicity option
    And I select "Not listed" race option
    And I click continue on the Ethnicity and race page
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select None of these as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "CoCo Start Shopping" page
    Then I click continue on coco start shopping page
    Then I validate I am on the "CoCo Grouping Members Medical" page
    Then I validate that there are 2 default groups in coco page
    And  I click on edit enrollment groups link in coco page
    And I create new group in edit medical grouping coco page and drag members to the new group
      | Primary,Wife:Group1 |
      | Son,DIL:Group2 |
    Then I click save button to save the groups in CoCo Page
    Then I click on continue button on success pop-up in CoCo Page
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical coco page
    Then I validate I am on the "CoCo Medical Plan Results" page
    And I select "Anthem Colorado Option Bronze Pathway Essentials Std" coco medical plan
    And I click Continue on the Medical Plans Page CoCo
    And I select "RMHP Colorado Doctors Plan Colorado Option Bronze" coco medical plan
    And I click Continue on the Medical Plans Page CoCo
    Then I validate I am on the "Coco Plan Summary" page
    And I click continue on coco plan summary page
    Then I validate I am on the "CoCo Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page
    And I click on Sign Out in the Header for "Elmo"

    Given I open the login page on the "admin" portal
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin dashboard" page
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    Then I click on "Manage Plans" user dashboard button
    Then I click Make Changes Medical button
    And I update the Coverage Start date of member
      |1:01012024|
      |2:01012024|
    And I update the Financial Start date of member
      |1:01012024|
      |2:01012024|
    And I click Save Button Medical
    And I select the reason to confirm the changes
    # need to select group from selectPolicy Dropdown to update the dates - WIP
#    Then I click Make Changes Medical button
#    And I update the Coverage Start date of member
#      |1:01012024|
#      |2:01012024|
#    And I update the Financial Start date of member
#      |1:01012024|
#      |2:01012024|
#    And I click Save Button Medical
#    And I select the reason to confirm the changes
#    Then I close current tab and switch back to previous tab
#    And logout from Admin Portal

