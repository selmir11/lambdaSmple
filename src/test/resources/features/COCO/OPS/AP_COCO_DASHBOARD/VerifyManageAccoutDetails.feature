@OPS @COCO
Feature: Admin Portal as OBO verify member details
  @SLCR-863 @OPSRegression
  Scenario: OPS: CoCo: Change Account Details and Verify on Profile [CCRT-140]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Admin Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin Portal search" page
    And I select "coco" checkbox on Admin Portal Dashboard
    Then I click create account on admin portal
    And I enter general mandatory data for "coco" account creation
    Then I verify account created successfully message displays
    And I select "coco" checkbox on Admin Portal Dashboard
    And I search for user and click email from search results
    And I click "On Behalf Of (OBO)" from application links dropdown
    Then I validate I am on the "Account Overview" page

    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    And I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "11281986", "Male", and applying "Yes"
    And I enter my residential address "PO BOX 1454", "DENVER", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "White or European" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "37,000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "Birth" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    Then I enter a OBO signature on the Declarations And Signature Page CoCo

    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page

    Then I close current tab and switch back to previous tab

    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    And I select "coco" checkbox on Admin Portal Dashboard

    And I search for the user with account id
    Then I select the first record from the search results
    Then I validate I am on the "Admin Portal individual dashboard" page

    #Validation for original data
    Then I verify Coco Primary account holder and account number displays
    Then I validate Selected Member label and member data on the far left side
    Then I validate content from Account Summary Container
    Then I click on manage account details button on admin portal Individual dashboard
    Then I validate I am on the "account details" page
    Then I validate all Coco details for primary holder on account details page
    Then I click on Edit Fields via OBO button on the account details page
    Then I close current tab and switch back to previous tab
    Then I switch to the tab number 1
    And I click on Make Changes Button

    # updating email, address, Contact method and language for the first time on same account
    Then I update the contact email address on profile page
    And I update the contact home phone number on profile page
    And I update the contact mobile phone number on profile page
    And I change the Preferred Contact Method to "Mail"
    And I update Preferred Written Language to "Spanish"
    And I click on the My Profile Save Button while OBO
    Then I click on Go back to Welcome page Button on My Profile Exch

    # updating full name, DOB and address for the second time on same account
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I update full name of member with prefix "Primary"
    Then I update Coco DOB to new DOB of "02031995"
    Then I click Save and Continue only on the tell us about yourself page
    And I update my residential address "101 Update Lane", "Denver", "CO", "80205", "DENVER"
    Then I select "No" for mailing address option
    And I update my mailing address "101 Update Lane", "Denver", "CO", "80205", "DENVER"
    Then I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I select "Birth" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    Then I enter a OBO signature on the Declarations And Signature Page CoCo
    And I click Continue on the Declarations And Signature Page CoCo
    Then I validate I am on the "Application Results CoCo" page

    Then I close current tab and switch back to previous tab
    And I validate I am on the "Admin Portal individual dashboard" page
    Then I click Go Back on admin portal broker dashboard
    And I click on reset button on admin portal search page
    And I select "coco" checkbox on Admin Portal Dashboard

    And I search for the user with account id
    Then I select the first record from the search results
    Then I validate I am on the "Admin Portal individual dashboard" page
    #validate updated primary holder details
    Then I verify Coco Primary account holder and account number displays
    Then I validate Selected Member label and member data on the far left side
    Then I validate content from Account Summary Container
    Then I click on manage account details button on admin portal Individual dashboard
    Then I validate I am on the "account details" page
    Then I validate all Coco details for primary holder on account details page
    Then I close current tab and switch back to previous tab
    And I logout from Admin Portal

