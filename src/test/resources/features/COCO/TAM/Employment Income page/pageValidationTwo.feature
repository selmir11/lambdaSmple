@TAM @pageValidation @TamCoCo
Feature: Tests related to the Employment Income page Validation

  Background: I go to the login portal
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page
    And I apply for the current year in CoCo
    And I click Continue on my own button from Manage who helps you page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Spouse", "03021995", "Female", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "102 COCO DRIVE", "BOULDER", "CO", "80020", "BOULDER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I verify the header for additional member on the CoCo Employment income page in "English"

  @SLCR-834
  Scenario: SLCR-834 Page Validation-Additional Member Employment Income
    And I click continue on the Employment income page
    And I verify validation text on the CoCo Employment Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color   |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | #960000 |
    And I select "Yes" employment option
    And I click continue on the Employment income page
    And I verify validation text on the CoCo Employment Income page
      | Text                                   | fontSize | fontFamily            | fontWeight | color   |
      | Amount is required                     | 14px     | "PT Sans", sans-serif | 400        | #960000 |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | #960000 |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | #960000 |
      | Please select one of the options below | 14px     | "PT Sans", sans-serif | 400        | #960000 |

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page