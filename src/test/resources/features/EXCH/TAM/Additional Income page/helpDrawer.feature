@TAM @TamExch
Feature: Page Text-Additional Income Page

  Background:
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "10011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I enter generic mailing address details
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click continue on family overview page
    And I Apply for financial help
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page
    And I set the browser resolution to 1536 x 864

  @SLER-925 @HelpDrawerAdditionalIncomePage
  Scenario: SLER-925 Validate help drawer text on the Additional income page - English
    And I select "Help me understand" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Full" verbiage in "English"
    Then I click on "Alimony Received" link in Help Drawer on the Additional Income page
    And I validate I am on the "Alimony Received" page and close tab
    Then I click on "Capital Gains" link in Help Drawer on the Additional Income page
    And I validate I am on the "Capital Gains" page and close tab
    Then I click on "Income from Rental" link in Help Drawer on the Additional Income page
    And I validate I am on the "Income from Rental" page and close tab
    Then I click on "Pension" link in Help Drawer on the Additional Income page
    And I validate I am on the "Pension" page and close tab
    Then I click on "Private Retirement Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Private Retirement Income" page and close tab
    Then I click on "Title II Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Title II Income" page and close tab
    Then I click on "Unemployment Insurance" link in Help Drawer on the Additional Income page
    And I validate I am on the "Unemployment Insurance" page and close tab
    Then I click on "Investment Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Investment Income" page and close tab
    Then I click on "Untaxed Foreign Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Untaxed Foreign Income" page and close tab
    Then I click on "Royalty Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Royalty Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Help me understand" icon on the Additional Income Page

    And I select "side help" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Full" verbiage in "English"
    Then I click on "Alimony Received" link in Help Drawer on the Additional Income page
    And I validate I am on the "Alimony Received" page and close tab
    Then I click on "Capital Gains" link in Help Drawer on the Additional Income page
    And I validate I am on the "Capital Gains" page and close tab
    Then I click on "Income from Rental" link in Help Drawer on the Additional Income page
    And I validate I am on the "Income from Rental" page and close tab
    Then I click on "Pension" link in Help Drawer on the Additional Income page
    And I validate I am on the "Pension" page and close tab
    Then I click on "Private Retirement Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Private Retirement Income" page and close tab
    Then I click on "Title II Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Title II Income" page and close tab
    Then I click on "Unemployment Insurance" link in Help Drawer on the Additional Income page
    And I validate I am on the "Unemployment Insurance" page and close tab
    Then I click on "Investment Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Investment Income" page and close tab
    Then I click on "Untaxed Foreign Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Untaxed Foreign Income" page and close tab
    Then I click on "Royalty Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Royalty Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "close help" icon on the Additional Income Page

    And I select "Alimony Received" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Alimony Received" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Alimony Received" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Alimony Received" icon on the Additional Income Page

    And I select "Capital Gains" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Capital Gains" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Capital Gains" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Capital Gains" icon on the Additional Income Page

    And I select "Income from rental property" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Income from rental property" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Income from Rental" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Income from rental property" icon on the Additional Income Page

    And I select "Pension" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Pension" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Pension" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Pension" icon on the Additional Income Page

    And I select "Private Retirement income" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Private Retirement income" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Private Retirement Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Private Retirement income" icon on the Additional Income Page

    And I select "Income from Social Security" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Income from Social Security" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Title II Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Income from Social Security" icon on the Additional Income Page

    And I select "Unemployment insurance benefit" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Unemployment insurance benefit" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Unemployment Insurance" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Unemployment insurance benefit" icon on the Additional Income Page

    And I select "Investment Income" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Investment Income" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Investment Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Investment Income" icon on the Additional Income Page

    And I select "Cash Support" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Cash Support" verbiage in "English"
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Cash Support" icon on the Additional Income Page

    And I select "Untaxed foreign income" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Untaxed foreign income" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Untaxed Foreign Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Untaxed foreign income" icon on the Additional Income Page

    And I select "Royalty income" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Royalty income" verbiage in "English"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Royalty Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Royalty income" icon on the Additional Income Page

    And I select "Taxable income from Tribal Sources" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Taxable income from Tribal Sources" verbiage in "English"
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Taxable income from Tribal Sources" icon on the Additional Income Page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-926 @HelpDrawerAdditionalIncomePage
  Scenario: SLER-926 Validate help drawer text on the Additional income page - Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I validate I am on the "Spanish" page
    And I select "Help me understand" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    Then I validate Additional Income help drawer "Full" verbiage in "Spanish"
    Then I click on "Alimony Received" link in Help Drawer on the Additional Income page
    And I validate I am on the "Alimony Received" page and close tab
    Then I click on "Capital Gains" link in Help Drawer on the Additional Income page
    And I validate I am on the "Capital Gains" page and close tab
    Then I click on "Income from Rental" link in Help Drawer on the Additional Income page
    And I validate I am on the "Income from Rental" page and close tab
    Then I click on "Pension" link in Help Drawer on the Additional Income page
    And I validate I am on the "Pension" page and close tab
    Then I click on "Private Retirement Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Private Retirement Income" page and close tab
    Then I click on "Title II Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Title II Income" page and close tab
    Then I click on "Unemployment Insurance" link in Help Drawer on the Additional Income page
    And I validate I am on the "Unemployment Insurance" page and close tab
    Then I click on "Investment Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Investment Income" page and close tab
    Then I click on "Untaxed Foreign Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Untaxed Foreign Income" page and close tab
    Then I click on "Royalty Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Royalty Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Help me understand" icon on the Additional Income Page

    And I select "side help" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    Then I validate Additional Income help drawer "Full" verbiage in "Spanish"
    Then I click on "Alimony Received" link in Help Drawer on the Additional Income page
    And I validate I am on the "Alimony Received" page and close tab
    Then I click on "Capital Gains" link in Help Drawer on the Additional Income page
    And I validate I am on the "Capital Gains" page and close tab
    Then I click on "Income from Rental" link in Help Drawer on the Additional Income page
    And I validate I am on the "Income from Rental" page and close tab
    Then I click on "Pension" link in Help Drawer on the Additional Income page
    And I validate I am on the "Pension" page and close tab
    Then I click on "Private Retirement Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Private Retirement Income" page and close tab
    Then I click on "Title II Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Title II Income" page and close tab
    Then I click on "Unemployment Insurance" link in Help Drawer on the Additional Income page
    And I validate I am on the "Unemployment Insurance" page and close tab
    Then I click on "Investment Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Investment Income" page and close tab
    Then I click on "Untaxed Foreign Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Untaxed Foreign Income" page and close tab
    Then I click on "Royalty Income" link in Help Drawer on the Additional Income page
    And I validate I am on the "Royalty Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "close help" icon on the Additional Income Page

    And I select "Alimony Received" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    Then I validate Additional Income help drawer "Alimony Received" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Alimony Received" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Alimony Received" icon on the Additional Income Page

    And I select "Capital Gains" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    Then I validate Additional Income help drawer "Capital Gains" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Capital Gains" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Capital Gains" icon on the Additional Income Page

    And I select "Income from rental property" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    And I verify the header for Primary Member on the Additional Income page in "Spanish"
    Then I validate Additional Income help drawer "Income from rental property" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Income from Rental" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Income from rental property" icon on the Additional Income Page

    And I select "Pension" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    Then I validate Additional Income help drawer "Pension" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Pension" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Pension" icon on the Additional Income Page

    And I select "Private Retirement income" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    Then I validate Additional Income help drawer "Private Retirement income" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Private Retirement Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Private Retirement income" icon on the Additional Income Page

    And I select "Income from Social Security" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    And I verify the header for Primary Member on the Additional Income page in "Spanish"
    Then I validate Additional Income help drawer "Income from Social Security" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Title II Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Income from Social Security" icon on the Additional Income Page

    And I select "Unemployment insurance benefit" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    Then I validate Additional Income help drawer "Unemployment insurance benefit" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Unemployment Insurance" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Unemployment insurance benefit" icon on the Additional Income Page

    And I select "Investment Income" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    Then I validate Additional Income help drawer "Investment Income" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Investment Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Investment Income" icon on the Additional Income Page

    And I select "Cash Support" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    And I verify the header for Primary Member on the Additional Income page in "Spanish"
    Then I validate Additional Income help drawer "Cash Support" verbiage in "Spanish"
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Cash Support" icon on the Additional Income Page

    And I select "Untaxed foreign income" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    Then I validate Additional Income help drawer "Untaxed foreign income" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Untaxed Foreign Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Untaxed foreign income" icon on the Additional Income Page

    And I select "Royalty income" icon on the Additional Income Page
    Then I validate I am on the "Additional income" page
    Then I validate Additional Income help drawer "Royalty income" verbiage in "Spanish"
    Then I click on "Item" link in Help Drawer on the Additional Income page
    And I validate I am on the "Royalty Income" page and close tab
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Royalty income" icon on the Additional Income Page

    And I select "Taxable income from Tribal Sources" icon on the Additional Income Page
    Then I validate Additional Income help drawer "Taxable income from Tribal Sources" verbiage in "Spanish"
    And I click on "Contact Us" link in Help Drawer on the Additional Income page
    And I validate I am on the "We Can Help" page and close tab
    And I select "Taxable income from Tribal Sources" icon on the Additional Income Page

    And I click on Sign Out in the Header for "Elmo"