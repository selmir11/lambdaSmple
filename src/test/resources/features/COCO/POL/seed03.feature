Feature: Seed03 - COCO
  Scenario: Seed 03 For COCO- Family of 4

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
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "103 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "35,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
#   SPOUSE
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Wife", "03051989", "Female", and applying "Yes"
      |Primary:Spouse|
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "103 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Wife"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
  #  DAUGHTER
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Daughter", "04212013", "Female", and applying "Yes"
      |Primary:Child or Other dependent|
      |Wife:Child or Other dependent|
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "103 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Daughter"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
#    SON
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Son", "12222016", "Male", and applying "Yes"
      |Primary:Child or Other dependent|
      |Wife:Child or Other dependent|
      |Daughter:Sibling|
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "103 Coco Drive", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Son"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
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
    #    And I check "None of these" life change event checkbox  --OPEN ENROLLMENT ONLY--
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "CoCo Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Wife,Son,Daughter" coco
    Then I click continue on coco start shopping page
    Then I validate I am on the "CoCo Grouping Members Medical" page
    Then I click continue on grouping Members Medical coco page
    Then I validate I am on the "CoCo Medical Plan Results" page
    #  --SES ON--
    #    And I select "Select Health Value Colorado Option Silver Enhanced 94% Off Exchange" coco medical plan
    #  --SES OFF --
    And I select or skip the medical plans for groups on medical plan page
      | Group 1:Select Health Value Colorado Option Bronze |
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
      |3:01012024|
      |4:01012024|
    And I update the Financial Start date of member
      |1:01012024|
      |2:01012024|
      |3:01012024|
      |4:01012024|
    And I click Save Button Medical
    And I select the reason to confirm the changes
    Then I close current tab and switch back to previous tab
    And logout from Admin Portal

