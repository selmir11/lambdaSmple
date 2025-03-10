@TAM @TamCoCo
Feature: Navigation-Welcome Page

  Background: I go the login portal
    Given I open the login page on the "login" portal
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "coco" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I validate I am on the "CAC Screener" page
    Then I click continue signing in on the CAC Screener page
    Then I validate I am on the "CoCo Welcome" page

    @SLCR-28 @PageNavigationWelcomePage @TAMSmoke
  Scenario: SLCR-28 I check navigation from CoCo Welcome page - English
    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    Then I click the back button from Find Expert Help page
    Then I validate I am on the "CoCo Welcome" page
      And I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
      And I click on "Application Results" link on welcome page
    Then I validate I am on the "Application Results CoCo" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
      And I click on "My Plans" link on welcome page
      Then I validate I am on the "My Plans CoCo" page
      And I click on Apply for Coverage in the "Elmo" Header
      Then I validate I am on the "CoCo Welcome" page
      And I click on "My Documents and Letters" link on welcome page
    Then I validate I am on the "My Documents" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
      And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Welcome" page
      And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Welcome" page

    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    And I click on Learn More in the Header
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page


  @SLCR-40 @PageNavigationWelcomePage @TAMSmoke
  Scenario: SLCR-40 I check navigation from CoCo Welcome page - Spanish
    And I change the language from header to "Spanish"
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page

    And I apply for the current year in CoCo
    Then I validate I am on the "Find Expert Help" page
    Then I validate I am on the "Spanish" page
    Then I click the back button from Find Expert Help page
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy in "Header Spanish"
    Then I click on "My Profile" link on welcome page
    Then I validate I am on the "My Profile" page
    And I change the language from header to "Spanish"
    Then I validate I am on the "Spanish" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy in "Header Spanish"
    Then I click on "Application Results" link on welcome page
    Then I validate I am on the "Application Results CoCo" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I verify the header in "Spanish" on the Application Results Page CoCo
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on "My Plans" link on welcome page
    Then I validate I am on the "My Plans CoCo" page
    Then I validate I am on the "Spanish" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I click on "My Documents and Letters" link on welcome page
    Then I validate I am on the "My Documents" page
    And I verify the page text in "Spanish Headers" on the My Documents Page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page

    And I click on Privacy Policy in the "Individual Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on Terms Of Use in the "Individual Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on Contact Us in the "CoCo" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page

    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on Find a Plan in the "Elmo" Header
    Then I validate I am on the "Application Results CoCo" page
    Then I validate I am on the "Spanish" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on My Account in the "Elmo" Header
    Then I validate I am on the "My Profile" page
    And I change the language from header to "Spanish"
    Then I validate I am on the "Spanish" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy in "Header Spanish"
    And I click on Learn More in the Header
    And I validate I am on the "Contact Us" page and close tab
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy in "Header Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "Find Expert Help" page
    Then I validate I am on the "Spanish" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    Then I validate I am on the "Spanish" page
    And I click on the Username in the "CoCo" Header
    Then I validate I am on the "My Profile" page
    And I change the language from header to "Spanish"
    Then I validate I am on the "Spanish" page
    Then I click on Go back to Welcome page Button on My Profile CoCo
    Then I validate I am on the "CoCo Welcome" page
    Then I verify text on the Welcome page for an account without a policy in "Header Spanish"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page


  @SLCR-148 @PageNavigationWelcomePage
  Scenario: SLCR-148 The 'Find Expert Assistance' link stops working when navigate back to the error and unauthorized pages in Welcome portal
    #Step1
    Then I wait for 200 milliseconds
    And I change the C4 url to "Welcome portal Error CoCo"
    Then I validate I am on the "Error" page
    And I click Back to Welcome page Button on error CoCo page
    Then I click Go Back button from chrome browser
    And I verify User name Link is displayed in the "CoCo" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    #Step2
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I change the C4 url to "Welcome portal Unauthorized CoCo"
    Then I validate I am on the "Unauthorized" page
    And I verify User name Link is displayed in the "CoCo" Header
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-389 @PageNavigationWelcomePage
  Scenario: SLCR-389 I want a message displayed after being navigated to the Welcome page through the ELMO Income page header so that I know to select the apply/make changes button to continue - English
    #Step2
    And I apply for the current year in CoCo
    Then I validate I am on the "FindExpertHelpCoco" page
    #Step3
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    #Step4
    Then I click Go Back button from chrome browser
    Then I validate I am on the "FindExpertHelpCoco" page
    And I wait for 900 milliseconds
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    #Step5
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step6
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step7
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I validate I am on the "CoCo Tell us about yourself" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step8
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step9
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step10
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step11
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "14,052.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step12
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    Then I select "None of these" as additional income option CoCO page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step13
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step14
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step15
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    And I select continue on the Family Overview page
    And I select "InsuranceLoss" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step16
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Daughter", "01011996", "Female", and applying "Yes"
      |Primary:Child or Other dependent|
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    And I select "Prefer not to answer" for race and ethnicity option for "Daughter"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step17
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Daughter"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step18
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Daughter"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I select "None of these" as additional income option CoCO page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "English"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-391 @PageNavigationWelcomePage
  Scenario: SLCR-391 I want a message displayed after being navigated to the Welcome page through the ELMO Income page header so that I know to select the apply/make changes button to continue - Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    #Step2
    And I apply for the current year in CoCo
    Then I validate I am on the "FindExpertHelpCoco" page
    #Step3
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    #Step4
    Then I click Go Back button from chrome browser
    Then I validate I am on the "FindExpertHelpCoco" page
    And I wait for 900 milliseconds
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    #Step5
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step6
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I validate I am on the "CoCo Family Overview" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step7
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I validate I am on the "CoCo Tell us about yourself" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step8
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I enter details on tell us about yourself page and continue with "01161990", "Female", and applying "Yes"
    Then I validate I am on the "CoCo Additional info for additional member" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step9
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I enter my residential address "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step10
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step11
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I select "Yes" employment option
    And I enter "14,052.00" income amount
    And I select "Annually" income frequency option
    And I select "No" income seasonal option
    And I select "No" income changes option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step12
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    Then I select "None of these" as additional income option CoCO page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step13
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I validate I am on the "CoCo Income Summary" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step14
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Primary"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I click continue on the Employment income page
    And I select continue on the Additional Income CoCO page
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    And I select continue on the Family Overview page
    Then I validate I am on the "CoCo life change event" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step15
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    And I select continue on the Family Overview page
    And I select "InsuranceLoss" life change event with event date of "Today"
    And I select continue on the LCE page
    Then I validate I am on the "CoCo Declarations and Signature" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step16
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I select add another family member on the Family Overview page
    Then I validate I am on the "CoCo Tell us about additional members" page
    Then I enter details on tell us about additional members of your household page with "Daughter", "01011996", "Female", and applying "Yes"
      |Primary:Padre/madre o tutor |
    And I click continue on Tell us about additional members of your household page
    And I enter residential address details for additional member "1234 Road", "Denver", "CO", "80205", "DENVER"
    And I select "Yes" for live in Colorado option for additional member
    And I click continue on the Additional information for additional member page
    And I select "Prefer not to answer" for race and ethnicity option for "Daughter"
    And I click save and continue on the Race and Ethnicity page
    Then I validate I am on the "CoCo Employment Income" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step17
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Daughter"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I validate I am on the "CoCo Additional Income" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page
    #Step18
    And I apply for the current year in CoCo
    Then I click Continue on my own button from Manage who helps you page
    Then I click EditUpdate on Family Overview page for "Daughter"
    Then I click Save and Continue only on the tell us about yourself page
    And I click continue on the Add info for yourself page
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    Then I select "None of these" as additional income option CoCO page
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I wait for 900 milliseconds
    Then I click Go Back button from chrome browser
    Then I validate I am on the "CoCo Welcome" page
    And I validate notification banner on welcome page in "Spanish"
    And I click on Get Assistance in the "Exch" Header
    And I click on Find Expert Assistance in the "CoCo" Header
    Then I validate I am on the "FindExpertHelpCoco" page
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I validate no notification banner on welcome page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLCR-734
  Scenario: SLCR-734 I want to be directed to the unauthorized page so that I know I have tried to access a page I am not authorized to access
#    check in English and change to Spanish
    Then I wait for 100 milliseconds
    Then I verify text on the Welcome page for first time signed into an account in "English"
    And I change the C4 url to "Welcome portal Unauthorized CoCo"
    Then I wait for 100 milliseconds
    Then I validate I am on the "Unauthorized" page
    Then I verify unauthorized text in "English"
    And I verify text on the "CoCo" "Header" in "English"
    And I verify text on the "CoCo" "Footer" in "English"
    And I change the language from header to "Spanish"
    Then I wait for 50 milliseconds
    Then I verify unauthorized text in "Spanish"
    And I verify text on the "CoCo" "Header" in "Spanish"
    And I verify text on the "CoCo" "Footer" in "Spanish"
#    check in Spanish and change to English
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "CoCo Welcome" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I verify text on the Welcome page for an account without a policy in "Spanish"
    And I change the C4 url to "Welcome portal Unauthorized CoCo"
    Then I validate I am on the "Unauthorized" page
    Then I verify unauthorized text in "Spanish"
    And I verify text on the "CoCo" "Header" in "Spanish"
    And I verify text on the "CoCo" "Footer" in "Spanish"
    And I change the language from header to "English"
    Then I wait for 50 milliseconds
    Then I verify unauthorized text in "English"
    And I verify text on the "CoCo" "Header" in "English"
    And I verify text on the "CoCo" "Footer" in "English"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page