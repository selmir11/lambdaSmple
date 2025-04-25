@COCOSIR @SIR-COCOX
 #SLCR-9xx, SLCR-9xx
Feature: Shopping Page - Continue and Go back funtionality

  Background: I go the login portal
    Given I open the login page on the "login" portal


  @SLCR-9xx @planNotAvailableOnePerson
  Scenario: SLCR-9xx This will enroll an adult and validate the no plan available label on the 2nd enrollment - Plan Results page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"

    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

    Then I validate I am on the "CoCo Employment Income" page
    And I select "Yes" employment option
    And I enter "40,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

    Then I validate I am on the "CoCo Additional Income" page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I select "Anthem Colorado Option Silver Pathway Essentials Std" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo
    Then I validate I am on the "planSummaryMedicalDental" page
    And I click continue on coco plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page

    Then I click all done from payment portal page coco

    # end intial enrollment

    Then I validate I am on the "CoCo Welcome" page
    And I click make Changes button on welcome page

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"

    Then I validate I am on the "Tell us about yourself" page
    Then I click Save and Continue only on the tell us about yourself page

    Then I validate I am on the "CoCo Additional information for yourself" page
    And I update my residential address "1234 test road", "Telluride", "CO", "81435", "San Miguel"
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I click save and continue on the Race and Ethnicity page

    Then I validate I am on the "CoCo Employment Income" page
    And I click continue on the Employment income page

    Then I validate I am on the "CoCo Additional Income" page
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    Then I click continue on start shopping page

    Then I validate I am on the "Medical Plan Results" page
    And I validate that the "English" no longer available plan label is on the COCO Medical Plan Results page
    And  I change the language from header to "Spanish"
    And I validate that the "Spanish" no longer available plan label is on the COCO Medical Plan Results page
    And  I change the language from header to "English"

    And I wait for 2000 milliseconds
    #And I validate that the Continue button is disabled on the COCO Medical Plan Results page
    And I select the first medical plan option CoCo
    And I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Plan Summary" page
    And I click continue on coco plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page

    Then I click all done from payment portal page coco
    And I click on Sign Out in the Header for "Portal"


  @SLCR-xxx @@planNotAvailableTwoPerson
  Scenario: SLCR-927 - This will create Family of 2 members - couple - edit group
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation

    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page

    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"

    Then I enter details on tell us about yourself page and continue with "01161988", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "10,000.00" income amount
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
    Then I select add another family member on the Family Overview page

    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Spouse", "03051989", "Female", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page

    Then I validate I am on the "CoCo Additional info for additional member" page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page

    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Spouse"
    And I click save and continue on the Race and Ethnicity page

    And I select "Yes" employment option
    And I enter "10,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page

    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I wait for 2000 milliseconds
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page

    And I select the No projected Income button on the Income Summary page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse" coco
    Then I click continue on coco start shopping page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click on edit enrollment groups link in coco page

    Then I validate I am on the "Edit Grouping Members Medical" page
    Then I create new group in edit medical grouping coco page and drag members to the new group
      | Primary:Group1 |
      | Spouse:Group2    |
    Then I click save button to save the groups in CoCo Page
    And I validated message on success enrollment grouping pop-up in CoCo Page
    Then I click on continue button on success pop-up in CoCo Page

    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical coco page

    Then I validate I am on the "Medical Plan Results" page
    And I wait for 2000 milliseconds
    And I select the COCO Metal Tier dropdown
    And I wait for 2000 milliseconds
    And I select "Silver" to filter for a  COCO Metal Tier plan
    And I validate the COCO plan option 1 has text "Cigna Connect Colorado Option Silver Off Exchange"
    And I select "Cigna Connect Colorado Option Silver Off Exchange" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Medical Plan Results" page
    And I wait for 2000 milliseconds
    And I select the COCO Metal Tier dropdown
    And I wait for 2000 milliseconds
    And I select "Bronze" to filter for a  COCO Metal Tier plan
    And I select "Cigna Healthcare" to filter for desired COCO plan provider
    And I validate the COCO plan option 1 has text "Cigna Connect Colorado Option Bronze"
    And I select "Cigna Connect Colorado Option Bronze" coco medical plan
    Then I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Plan Summary" page
    And I click continue on coco plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page

    Then I click all done from payment portal page coco

    #end intial enrollment

    Then I validate I am on the "CoCo Welcome" page
    And I click make Changes button on welcome page

    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page

    Then I validate I am on the "CoCo Family Overview" page
    Then I click EditUpdate on Family Overview page for "Primary"

    Then I validate I am on the "Tell us about yourself" page
    Then I click Save and Continue only on the tell us about yourself page

    Then I validate I am on the "CoCo Additional information for yourself" page
    And I update my residential address "1234 test road", "Telluride", "CO", "81435", "San Miguel"
    And I click continue on the Add info for yourself page

    Then I validate I am on the "Race and Ethnicity" page
    And I click save and continue on the Race and Ethnicity page

    Then I validate I am on the "CoCo Employment Income" page
    And I click continue on the Employment income page

    Then I validate I am on the "CoCo Additional Income" page
    And I select continue on the Additional Income CoCO page

    Then I validate I am on the "CoCo Deductions" page
    And I select continue on the Deductions CoCo page

    Then I validate I am on the "CoCo Income Summary" page
    And I select continue on the income Summary CoCo page

    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page

    Then I validate I am on the "CoCo life change event" page
    And I select "MoveToCO" life change event with event date of "Today"
    And I select continue on the LCE page

    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo

    Then I validate I am on the "Application Results CoCo" page
    And I click Continue on the Application Results Page CoCo

    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse" coco
    Then I click continue on coco start shopping page

     #primary and spouse - previous edited group is reset to the default of 1 group
    Then I validate I am on the "Grouping Members Medical" page
    Then I click continue on grouping Members Medical coco page

    Then I validate I am on the "Medical Plan Results" page
    And I validate that the "English" no longer available plan label is on the COCO Medical Plan Results page
    And  I change the language from header to "Spanish"
    And I validate that the "Spanish" no longer available plan label is on the COCO Medical Plan Results page
    And  I change the language from header to "English"

    And I wait for 2000 milliseconds
    #And I validate that the Continue button is disabled on the COCO Medical Plan Results page
    And I select the first medical plan option CoCo
    And I click Continue on the Medical Plans Page CoCo

    Then I validate I am on the "Plan Summary" page
    And I click continue on coco plan summary page

    Then I validate I am on the "Enrollment Agreements" page
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page

    Then I click all done from payment portal page coco
