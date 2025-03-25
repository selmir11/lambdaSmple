@TAM @TamCoCo @PageValidationWelcomePage
Feature: Page Validation-Welcome Page

  Background: I go the login portal
    Given I open the login page on the "login" portal
    Then I validate I am on the "Login" page
    When I click create a new account on login page
    Then I validate I am on the "Prescreen" page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page

  @SLCR-884 @SLCR-888 @SLCR-889 @SLCR-890 @SLCR-891 @SLCR-892
  Scenario Outline: <TestNumber> ELIG-As a CoCo user, I want to see Colorado Option-branded logos associated with PY2024 plans so that the correct Issuer logos are displayed - <carrierOption>
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "05101994", "Male", and applying "Yes"
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "20000.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I validate I am on the "CoCo Family Overview" page
    And I select continue on the Family Overview page
    And I select "Birth" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I enter a valid signature
    And I click Continue on the Declarations And Signature Page CoCo
    And I click Continue on the Application Results Page CoCo
    Then I validate I am on the "Start Shopping" page
    Then I click "No" to the Tobacco usage question on start shopping page for "Primary" coco
    And I get the application id from the url from tobacco page coco
    Then I click continue on coco start shopping page
    And I select the COCO Insurance Company dropdown
    And I select "<carrierOption>" to filter for desired COCO plan provider
    And I select the first medical plan option CoCo
    And I click Continue on the Medical Plans Page CoCo
    And I click Continue button on the Medical Dental Page CoCo
    And I select "Acknowledgement" agreement checkbox CoCo
    And I select "Submit" agreement checkbox CoCo
    And I enter householder signature on the Enrollment Agreements page CoCo
    And I select submit enrollment button on the Enrollment Agreements CoCo page
    Then I click all done from payment portal page coco
    Then I validate I am on the "CoCo Welcome" page
    Then I validate the plan image for "<carrierOption>" on welcome page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

    Examples:
      |TestNumber| carrierOption                       |
      |SLCR-884  | Anthem	                           |
      |SLCR-888  | Cigna Healthcare                    |
      |SLCR-889  | Denver Health                       |
      |SLCR-890  | Kaiser Permanente                   |
      |SLCR-891  | Rocky Mountain Health Plans / UHC   |
      |SLCR-892  | Select Health                       |

