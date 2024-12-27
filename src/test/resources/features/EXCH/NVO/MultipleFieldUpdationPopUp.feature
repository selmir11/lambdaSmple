@SLER-1861
Feature: Validate Error pop-up that prevents from overwriting multiple fields

  Scenario: Add language to the pop-up
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "Birth" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "12121990", "Female" and applying "Yes"
      |Primary:Spouse|
    And I mark the Additional member is pregnant as "No"
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    And I click on My Account in the "NonElmo" Header
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "Other" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I update full name of member with prefix "Primary"
    Then I update DOB to new DOB of "03031983"
    Then I update SSN number to new SSN number "653-03-5288"
    Then I click continue on Tell us about yourself page
    And I validate restrict multiple field edits pop up text on Tell us about yourself page
      | This change can't be made online. For help making this change, contact our Service Center at                                                               |
      | 855-675-2626                                                                                                                                               |
      | If you want to change the Primary Contact on your account, please click                                                                                    |
      | Primary Contact? The primary contact is the person we send emails and letters to. They are also responsible for keeping the account information up to date.|
      | If you need to add a new person, please click                                                                                                              |
    Then I click "English" close button under restrict multiple field edits pop up on Tell us about yourself page
    Then I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    And I click plus icon next to member on household page for "Spouse"
    Then I click edit basic information icon on household page for "Spouse"
    Then I update full name of member with prefix "Spouse"
    Then I update DOB to new DOB of "02021982"
    Then I update SSN number to new SSN number "653-03-6288"
    Then I click continue on Tell us about yourself page
    And I validate restrict multiple field edits pop up text on Tell us about yourself page
      | This change can't be made online. For help making this change, contact our Service Center at                                                               |
      | 855-675-2626                                                                                                                                               |
      | If you want to change the Primary Contact on your account, please click                                                                                    |
      | Primary Contact? The primary contact is the person we send emails and letters to. They are also responsible for keeping the account information up to date.|
      | If you need to add a new person, please click                                                                                                              |
    Then I click "English" close button under restrict multiple field edits pop up on Tell us about yourself page
    And I select "No" as pregnancy option
    Then I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click on My Account in the "NonElmo" Header
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "NoneOfThese" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I update full name of member with prefix "Primary"
    Then I update DOB to new DOB of "03031983"
    Then I update SSN number to new SSN number "653-03-5688"
    Then I click continue on Tell us about yourself page
    And I validate restrict multiple field edits pop up text on Tell us about yourself page
      | This change can't be made online. For help making this change, contact our Service Center at                                                               |
      | 855-675-2626                                                                                                                                               |
      | If you want to change the Primary Contact on your account, please click                                                                                    |
      | Primary Contact? The primary contact is the person we send emails and letters to. They are also responsible for keeping the account information up to date.|
      | If you need to add a new person, please click                                                                                                              |
    Then I click "English" close button under restrict multiple field edits pop up on Tell us about yourself page
    Then I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    Then I validate I am on the "Family Overview" page
    And I click plus icon next to member on household page for "Spouse"
    Then I click edit basic information icon on household page for "Spouse"
    Then I update full name of member with prefix "Spouse"
    Then I update DOB to new DOB of "02021982"
    Then I update SSN number to new SSN number "653-03-6288"
    Then I click continue on Tell us about yourself page
    And I validate restrict multiple field edits pop up text on Tell us about yourself page
      | This change can't be made online. For help making this change, contact our Service Center at                                                               |
      | 855-675-2626                                                                                                                                               |
      | If you want to change the Primary Contact on your account, please click                                                                                    |
      | Primary Contact? The primary contact is the person we send emails and letters to. They are also responsible for keeping the account information up to date.|
      | If you need to add a new person, please click                                                                                                              |
    Then I click "English" close button under restrict multiple field edits pop up on Tell us about yourself page
    And I select "No" as pregnancy option
    Then I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click on My Account in the "NonElmo" Header
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "NoneOfThese" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    And I change the language from header to "Spanish NonElmo"
    Then I validate I am on the "Spanish" page
    Then I update full name of member with prefix "Primary"
    Then I update DOB to new DOB of "03031983"
    Then I update SSN number to new SSN number "653-03-5488"
    Then I click continue on Tell us about yourself page
    And I validate restrict multiple field edits pop up text on Tell us about yourself page
      | No se puede hacer este cambio en línea. Si necesita ayuda para hacer el cambio, comuníquese a nuestro centro de atención al                                                                        |
      | 855-675-2626                                                                                                                                                                                       |
      | Si desea cambiar el contacto principal de su cuenta, haga clic                                                                                                                                     |
      | ¿Quién es el contacto principal? El contacto principal es la persona a quien le enviamos correos electrónicos y cartas. También es responsable de mantener actualizada la información de la cuenta.|
      | Si necesita agregar o quitar a una persona, haga clic                                                                                                                                              |
    Then I click "Spanish" close button under restrict multiple field edits pop up on Tell us about yourself page
    And I click on Sign Out in the Header for "NonElmo"

  Scenario: Clicking on the “pop-up links
    Given I open the login page on the "login" portal
    And I validate I am on the "Login" page
    When I click create a new account on login page
    Then I click create my account from pre-screen page
    And I enter general mandatory data for "exchange" account creation
    Then I validate I am on the "Login" page
    And  I enter valid credentials to login
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "NoneOfThese" and click continue
    Then I select "member" from the who are you question
    And I am a member with City "Denver" in State "CO" with dob "01011980" in county "DENVER" with zipcode "80205"
    Then I answer all Id proofing questions and click continue
    And I click continue button on Congratulations page
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I select "Male" as sex option
    And I select "Yes" to Are You Applying
    And I click continue on Tell us about yourself page
    Then I validate I am on the "Add Address" page
    Then I enter member with address line1 "1234 Road" in city "Denver" in state "CO" with zipcode "80205" and county "DENVER"
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Primary"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    Then I click Add Another Family Member
    Then I validate I am on the "Add Member" page
    Then I enter details on tell us about additional members of your household exch page and continue with "Spouse", "12121990", "Female" and applying "Yes"
      |Primary:Spouse|
    And I mark the Additional member is pregnant as "No"
    And I click continue on Tell us about additional members page
    Then I validate I am on the "Add Address" page
    Then I select "Household" for Residential Address
    And I select "Yes" for CO Resident option
    And I select "No" for Federally Recognized Tribe option
    And I select "No" for Hardship Exemption option
    And I select "No" for Disability option
    And I select "No" to the recently denied medicaid question
    And I select "No" for Incarceration option
    And I click continue on the Add Address page
    Then I validate I am on the "Elmo Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity for "Spouse"
    And I click continue on the Race and Ethnicity page
    Then I validate I am on the "Citizenship" page
    Then I select "Yes" for Citizen option
    And I select "No" for Naturalized Immigrant option
    And I click continue on the Citizenship page
    And I click on My Account in the "NonElmo" Header
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "NoneOfThese" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I update full name of member with prefix "Primary"
    Then I update DOB to new DOB of "03031983"
    Then I update SSN number to new SSN number "653-03-5288"
    Then I click continue on Tell us about yourself page
    Then I click on please click here link to change primary contact
    Then I validate I am on the "My Profile" page
    And I click on My Account in the "Elmo" Header
    Then I apply for the current year
    Then I validate I am on the "Let us guide you" page
    And I select "no" option on the Let us guide you page
    And I click on save and continue button
    Then I validate I am on the "Before you begin" page
    And I click on continue with  application button on Before you begin page
    Then I validate I am on the "Report a life change" page
    And I report "NoneOfThese" and click continue
    Then I validate I am on the "Find Expert Help" page
    Then I click Continue on my own button from Manage who helps you page
    Then I update full name of member with prefix "Primary"
    Then I update DOB to new DOB of "03031983"
    Then I update SSN number to new SSN number "653-03-5348"
    Then I click continue on Tell us about yourself page
    Then I click on please click here link to add new person
    Then I validate I am on the "Family Overview" page
    And I click on Sign Out in the Header for "NonElmo"