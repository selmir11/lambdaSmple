@OPS @manageplan @COCO
Feature: OPS CoCo MP NFA Removing Subscriber from policy[CCRT-353]
  @SLCR-942
Scenario: OPS CoCo MP NFA Removing Subscriber from policy[CCRT-353]
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
And I click Continue on my own button from Manage who helps you page
Then I click EditUpdate on Family Overview page for "Primary"
Then I enter details on tell us about yourself page and continue with "11181993", "Male", and applying "Yes"
And I enter my residential address "102 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
And I select "Yes" for mailing address option
And I select "Yes" for live in Colorado option
And I click continue on the Add info for yourself page
Then I validate I am on the "Race and Ethnicity" page
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
And I select "None of these" as deductions option
And I select continue on the Deductions CoCo page
Then I select the projected income option "No" on Income Summary CoCo page
And I select continue on the income Summary CoCo page
Then I validate I am on the "CoCo Family Overview" page
Then I select add another family member on the Family Overview page
Then I enter details on tell us about additional members of your household page with "Spouse", "03021995", "Female", and applying "Yes"
| Primary:Spouse |
And I click continue on Tell us about additional members of your household page
And I enter residential address details for additional member "102 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
And I select "Yes" for live in Colorado option for additional member
And I click continue on the Add info for yourself page
Then I validate I am on the "Race and Ethnicity" page
And I select "Prefer not to answer" for race and ethnicity option for "Spouse"
And I click save and continue on the Race and Ethnicity page
And I select "No" employment option
And I click continue on the Employment income page
And I select None of these as additional income option
And I select continue on the Additional Income CoCO page
And I select "None of these" as deductions option
And I select continue on the Deductions CoCo page
Then I select the projected income option "No" on Income Summary CoCo page
And I select continue on the income Summary CoCo page
Then I validate I am on the "CoCo Family Overview" page
And I select continue on the Family Overview page

And I select "Birth" life change event with event date of "Today"
And I select continue on the LCE page
Then I validate I am on the "CoCo Declarations and Signature" page
Then I enter a OBO signature on the Declarations And Signature Page CoCo
And I click Continue on the Declarations And Signature Page CoCo
Then I validate I am on the "Application Results CoCo" page

And I click Continue on the Application Results Page CoCo
Then I validate I am on the "Start Shopping" page
And I click "No" to the Tobacco usage question on start shopping page for "Primary,Spouse" coco
And I get the application id from the url from tobacco page coco
Then I click continue on coco start shopping page
Then I click continue on grouping Members Medical coco page
Then I validate I am on the "Medical Plan Results" page
And I select or skip the medical plans for groups on medical plan page
| Group 1:KP Colorado Option Bronze |

Then I validate I am on the "planSummaryMedicalDental" page
And I set medical premium amount
And I click continue on coco plan summary page
Then I validate I am on the "Enrollment Agreements" page
And I select "Acknowledgement" agreement checkbox CoCo
And I select "Submit" agreement checkbox CoCo
And I enter householder signature on the Enrollment Agreements page CoCo
And I select submit enrollment button on the Enrollment Agreements CoCo page
Then I click all done from payment portal page coco
Then I validate I am on the "CoCo Welcome" page

And I close current tab and switch back to previous tab
#    Manage Plans Change Start Dates to 1/1
And I wait for 1000 milliseconds
Then I click on manage plan button on admin portal Individual dashboard
Then I click Make Changes Medical button
And I wait for 1000 milliseconds
And I update the Coverage Start date of member
  | 1:First Day Of Current Year |
  | 2:First Day Of Current Year |
And I wait for 1000 milliseconds
And I update the Financial Start date of member
  | 1:First Day Of Current Year |
  | 2:First Day Of Current Year |
And I click Save Button Medical
And I wait for 1000 milliseconds
And I select the reason to confirm the changes
Then I select Plans "Medical" Termed policy with "Today" coverage end date on manage plan page
Then I validate termed "Medical" all details table in DB for 2 member for DB row 0 on AP Manage Plans
#Remove primary
And I click "On Behalf Of (OBO)" from application links dropdown
Then I validate I am on the "Account Overview" page

And I apply for the current year in CoCo
And I click Continue on my own button from Manage who helps you page
Then I click EditUpdate on Family Overview page for "Primary"
Then I enter details on tell us about yourself page and continue with "11181993", "Male", and applying "No"
And I click continue on the Add info for yourself page
Then I validate I am on the "Race and Ethnicity" page
And I select "Prefer not to answer" for race and ethnicity option for "Primary"
And I click save and continue on the Race and Ethnicity page
And I click continue on the Employment income page
And I select None of these as additional income option
And I select continue on the Additional Income CoCO page
And I select "None of these" as deductions option
And I select continue on the Deductions CoCo page
Then I select the projected income option "No" on Income Summary CoCo page
And I select continue on the income Summary CoCo page
Then I validate I am on the "CoCo Family Overview" page
And I select continue on the Family Overview page
And I check "None of these" life change event checkbox
And I select continue on the LCE page
Then I validate I am on the "CoCo Declarations and Signature" page
Then I enter a OBO signature on the Declarations And Signature Page CoCo
And I click Continue on the Declarations And Signature Page CoCo
Then I validate I am on the "Application Results CoCo" page
#    Validate third policy on manage plan
And I close current tab and switch back to previous tab
Then I click on manage plan button on admin portal Individual dashboard
And I validate I am on the "Manage Plans" page
And I refresh the page
And I select Plans Med Active Policy
Then I validate current "Medical" all details table in DB for 1 members on AP Manage Plans

