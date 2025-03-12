@TAM @TamExch
Feature: Page Text-Income Opt Out Page

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

    And I validate I am on the "Employment Income" page

  @SLER-1903 @PageNavigationEmploymentIncome @TAMSmoke
  Scenario: SLER-1903 NR Bug (exch): TypeError
#    Step 1
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    And I enter self-employment details with "54000.00" income at "Annually" frequency and "Yes" to same or lower
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page
#    Step 2
    Then I click Edit on Income Summary row 1
    And I select the option "No" to self employment
    And I enter employment details with "1300000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page
#    Step 3
    Then I click Edit on Income Summary row 1
    And I select the option "Yes" to self employment
    And I enter self-employment details with "54000.00" income at "Annually" frequency and "Yes" to same or lower
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

  @SLER-2065
  Scenario: SLER-2065 I want to be directed to the unauthorized page so that I know I have tried to access a page I am not authorized to access
#    check in English and change to Spanish
    Then I validate Employment Info Page header in "English"
    And I change the C4 url to "Employment Income Unauthorized Exch"
    Then I validate I am on the "Unauthorized" page
    Then I verify unauthorized text in "English"
    And I verify text on the "Exch" "Header" in "English"
    And I verify text on the "Exch" "Footer" in "English"
    And I set the browser resolution to 1200 x 800
    And I change the language from header to "Spanish"
    And I set the browser resolution to Maximized
    Then I verify unauthorized text in "Spanish"
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
#    check in Spanish and change to English
    And I click on Apply for Coverage in the "Elmo" Header
    Then I validate I am on the "My Account Overview" page
    Then I apply for the current year
    Then I select "No" option on the Let us guide you page
    And I click on save and continue button
    Then I click on continue with  application button on Before you begin page
    And I report "Birth" and click continue
    Then I click Continue on my own button from Manage who helps you page
    And I click continue on Tell us about yourself page
    And I click continue on the Add Address page
    And I click continue on the Race and Ethnicity page
    And I click continue on the Citizenship page
    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I validate I am on the "Employment Income" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate Employment Info Page header in "Spanish"
    And I change the C4 url to "Employment Income Unauthorized Exch"
    Then I validate I am on the "Unauthorized" page
    Then I verify unauthorized text in "Spanish"
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    And I set the browser resolution to 1200 x 800
    And I change the language from header to "English"
    And I set the browser resolution to Maximized
    Then I verify unauthorized text in "English"
    And I verify text on the "Exch" "Header" in "English"
    And I verify text on the "Exch" "Footer" in "English"

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page


  @SLER-2076
  Scenario Outline: SLER-2076 ELIG-Self-employment income-Page Text [RT-997]
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    And I change the language from Elmo header to "<Language>" if it isn't already in that language
    Then I validate the Net Income Frequency Dropdown Menu in "<Language>"
    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

    Examples:
    |Language|
    |English|
    |Spanish|

  @SLER-2264
  Scenario:  SLER-2264 The copyright statement text in the footer doesn't coincide with the links above - Privacy Policy | Terms of Use | Contact Us - Spanish
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    And I verify text on the "Exch" "Header" in "Spanish"
    And I verify text on the "Exch" "Footer" in "Spanish"
    Then I validate page Navigation works for Footer hyperlink text in "Spanish"
      | HyperLinkText          | ExpectedPageTitle                                    | ContainsUrl                                              |
      | Póliza de privacidad   | Política de Privacidad • Connect for Health Colorado | connectforhealthco.com/es/politica-de-privacidad/        |
      | Términos y Condiciones | Términos de uso • Connect for Health Colorado        | connectforhealthco.com/es/terminos-de-uso/               |
      | Comentarios            | Póngase en contacto • Connect for Health Colorado    | connectforhealthco.com/es/pongase-en-contacto/           |
      | FacebookIcon           | Facebook                                             | facebook.com                                             |
      | xIcon                  | X                                                    | x.com                                                    |
      | YouTubeIcon            | YouTube                                              | youtube.com                     |
      | LinkedInIcon           | LinkedIn                                             | www.linkedin.com |
      | InstagramIcon          | instagram                                            | instagram.com                                    |
      | ThreadsIcon            | Threads                                              | threads.net                                      |
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page
    Then I validate page Navigation works for Footer hyperlink text in "Spanish"
      | HyperLinkText          | ExpectedPageTitle                                    | ContainsUrl                                              |
      | Póliza de privacidad   | Política de Privacidad • Connect for Health Colorado | connectforhealthco.com/es/politica-de-privacidad/        |
      | Términos y Condiciones | Términos de uso • Connect for Health Colorado        | connectforhealthco.com/es/terminos-de-uso/               |
      | Comentarios            | Póngase en contacto • Connect for Health Colorado    | connectforhealthco.com/es/pongase-en-contacto/           |
      | FacebookIcon           | Facebook                                             | facebook.com                                             |
      | xIcon                  | X                                                    | x.com                                                    |
      | YouTubeIcon            | YouTube                                              | youtube.com                     |
      | LinkedInIcon           | LinkedIn                                             | www.linkedin.com |
      | InstagramIcon          | instagram                                            | instagram.com                                    |
      | ThreadsIcon            | Threads                                              | threads.net                                      |

    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
  #Deductions Page
    Then I validate I am on the "Deductions" page
    Then I validate page Navigation works for Footer hyperlink text in "Spanish"
      | HyperLinkText          | ExpectedPageTitle                                    | ContainsUrl                                              |
      | Póliza de privacidad   | Política de Privacidad • Connect for Health Colorado | connectforhealthco.com/es/politica-de-privacidad/        |
      | Términos y Condiciones | Términos de uso • Connect for Health Colorado        | connectforhealthco.com/es/terminos-de-uso/               |
      | Comentarios            | Póngase en contacto • Connect for Health Colorado    | connectforhealthco.com/es/pongase-en-contacto/           |
      | FacebookIcon           | Facebook                                             | facebook.com                                             |
      | xIcon                  | X                                                    | x.com                                                    |
      | YouTubeIcon            | YouTube                                              | youtube.com                     |
      | LinkedInIcon           | LinkedIn                                             | www.linkedin.com |
      | InstagramIcon          | instagram                                            | instagram.com                                    |
      | ThreadsIcon            | Threads                                              | threads.net                                      |

    Then I validate I am on the "Deductions" page
    And I verify the header for Primary Member on the Deductions page in "Spanish"
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I validate page Navigation works for Footer hyperlink text in "Spanish"
      | HyperLinkText          | ExpectedPageTitle                                    | ContainsUrl                                              |
      | Póliza de privacidad   | Política de Privacidad • Connect for Health Colorado | connectforhealthco.com/es/politica-de-privacidad/        |
      | Términos y Condiciones | Términos de uso • Connect for Health Colorado        | connectforhealthco.com/es/terminos-de-uso/               |
      | Comentarios            | Póngase en contacto • Connect for Health Colorado    | connectforhealthco.com/es/pongase-en-contacto/           |
      | FacebookIcon           | Facebook                                             | facebook.com                                             |
      | xIcon                  | X                                                    | x.com                                                    |
      | YouTubeIcon            | YouTube                                              | youtube.com                     |
      | LinkedInIcon           | LinkedIn                                             | www.linkedin.com |
      | InstagramIcon          | instagram                                            | instagram.com                                    |
      | ThreadsIcon            | Threads                                              | threads.net                                      |

    Then I select the projected income option "No" and continue
  #TaxPage
    Then I validate I am on the "Tax status Elmo" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate page Navigation works for Footer hyperlink text in "Spanish"
      | HyperLinkText          | ExpectedPageTitle                                    | ContainsUrl                                              |
      | Póliza de privacidad   | Política de Privacidad • Connect for Health Colorado | connectforhealthco.com/es/politica-de-privacidad/        |
      | Términos y Condiciones | Términos de uso • Connect for Health Colorado        | connectforhealthco.com/es/terminos-de-uso/               |
      | Comentarios            | Póngase en contacto • Connect for Health Colorado    | connectforhealthco.com/es/pongase-en-contacto/           |
      | FacebookIcon           | Facebook                                             | facebook.com                                             |
      | xIcon                  | X                                                    | x.com                                                    |
      | YouTubeIcon            | YouTube                                              | youtube.com                     |
      | LinkedInIcon           | LinkedIn                                             | www.linkedin.com |
      | InstagramIcon          | instagram                                            | instagram.com                                    |
      | ThreadsIcon            | Threads                                              | threads.net                                      |

    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status Elmo page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status Elmo page
    #ELMO page
    Then I validate I am on the "Elmo Other Health Coverage" page
    Then I validate page Navigation works for Footer hyperlink text in "Spanish"
      | HyperLinkText          | ExpectedPageTitle                                    | ContainsUrl                                              |
      | Póliza de privacidad   | Política de Privacidad • Connect for Health Colorado | connectforhealthco.com/es/politica-de-privacidad/        |
      | Términos y Condiciones | Términos de uso • Connect for Health Colorado        | connectforhealthco.com/es/terminos-de-uso/               |
      | Comentarios            | Póngase en contacto • Connect for Health Colorado    | connectforhealthco.com/es/pongase-en-contacto/           |
      | FacebookIcon           | Facebook                                             | facebook.com                                             |
      | xIcon                  | X                                                    | x.com                                                    |
      | YouTubeIcon            | YouTube                                              | youtube.com                     |
      | LinkedInIcon           | LinkedIn                                             | www.linkedin.com |
      | InstagramIcon          | instagram                                            | instagram.com                                    |
      | ThreadsIcon            | Threads                                              | threads.net                                      |
    And I click on Sign Out in the Header for "Elmo"


  @SLER-2266
  Scenario:  SLER-2266 The copyright statement text in the footer doesn't coincide with the links above - Privacy Policy | Terms of Use | Contact Us - Spanish
    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
      | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook          | facebook.com                          |
      | xIcon          | X                 | x.com                                 |
      | YouTubeIcon    | YouTube           | youtube.com                           |
      | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
      | InstagramIcon  | instagram         | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.net                           |
    Then I select the option "No" to employment
    And I click continue on the Employment Info Page
    Then I validate I am on the "Additional income" page
    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
      | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook          | facebook.com                          |
      | xIcon          | X                 | x.com                                 |
      | YouTubeIcon    | YouTube           | youtube.com                           |
      | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
      | InstagramIcon  | instagram         | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.net                           |
    Then I validate I am on the "Additional income" page
    Then I click None of these as additional income option and continue
  #Deductions Page
    Then I validate I am on the "Deductions" page
    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
      | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook          | facebook.com                          |
      | xIcon          | X                 | x.com                                 |
      | YouTubeIcon    | YouTube           | youtube.com                           |
      | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
      | InstagramIcon  | instagram         | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.net                           |
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I validate I am on the "Income Summary" page
    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
      | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook          | facebook.com                          |
      | xIcon          | X                 | x.com                                 |
      | YouTubeIcon    | YouTube           | youtube.com                           |
      | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
      | InstagramIcon  | instagram         | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.net                           |
    Then I select the projected income option "No" and continue
  #TaxPage
    Then I validate I am on the "Tax status Elmo" page
    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
      | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook          | facebook.com                          |
      | xIcon          | X                 | x.com                                 |
      | YouTubeIcon    | YouTube           | youtube.com                           |
      | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
      | InstagramIcon  | instagram         | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.net                           |
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status Elmo page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status Elmo page
    #ELMO page
    Then I validate I am on the "Elmo Other Health Coverage" page
    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
      | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook          | facebook.com                          |
      | xIcon          | X                 | x.com                                 |
      | YouTubeIcon    | YouTube           | youtube.com                           |
      | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
      | InstagramIcon  | instagram         | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.net                           |
    And I click on Sign Out in the Header for "Elmo"

  @SLER-2270
  Scenario: SLER-2270 As an Exchange user, I need navigation functionality to navigate from the modernized ESI page to Exchange

    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "1276000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click continue on the Employment Summary Page
    Then I click None of these as additional income option and continue
    Then I validate I am on the "Deductions" page
    Then I click None of these as deduction option and continue
    Then I select the projected income option "No" and continue
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status Elmo page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status Elmo page
    Then I validate I am on the "Elmo Other Health Coverage" page

    Then I validate selecting insurance options
      | InsuranceOption       |
      | Health First Colorado |
      | CHP+                  |
      | Medicare              |
      | job                   |
      | HRA                   |
      | Retiree Health Plan   |
      | Peace Corps           |
      | COBRA                 |
      | VA Health Care        |
      | TRICARE               |
      | Other                 |
      | None of these         |

    #Medicare
    Then I select "Medicare" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I verify the header for "Primary" Member on the Medicare page in "English"
    And I validate I am on the "Elmo Ohc Medicare" page
    Then I click "Yes" for currently eligible in Medicare question
    Then I check checkbox for Part "A"
    Then I enter Part A amount of "150.00"
    Then I click "Yes" for Part "A" insurance ending in 60 days in Medicare question
    Then I enter end date of "Current Month" for Medicare part "A"
    And I click Go Back on the Elmo OHC Medicare page

    #ESI
    Then I select "None of these" as ELMO health coverage option
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "ESI" page
    And I verify the header for Primary Member on the ESI page in "English"
    Then I select the "0" employer for "Primary" member on the ESI page
    Then I select "Yes" for meet the Minimum Value Standard on the ESI page
    Then I enter "220.03" for employee amount question on the ESI page
    Then I select the Are you currently enrolled "Yes" button on the ESI page
    Then I select the Will Insurance End "Yes" button on the ESI page
    Then I enter the end date as "Current Month" on the ESI page
    Then I select the Are you voluntarily ending "Yes" button on the ESI page
    Then I select the Go Back button on the ESI page

    #HRA
    Then I select "None of these" as ELMO health coverage option
    Then I select "HRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo HRA" page
    Then I select Current Year year dropdown on the Elmo OHC HRA page
    Then I enter "6.00" amount on the Elmo OHC HRA page
    Then I select "ICHRA" for HRA type
    Then I select "Yes" for opt out on the Elmo OHC HRA page
    Then I click Go Back on the Elmo OHC HRA page

    #RetiRee
    Then I select "None of these" as ELMO health coverage option
    Then I select "Retiree Health Plan" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohc Retiree" page
    Then I click "Yes" for currently enrolled in Retiree question
    Then I click "Yes" for insurance ending in 60 days in Retiree question
    Then I enter the end date as "Future Day" on the Retiree page
    Then I click "No" for insurance ending voluntary for Retiree question
    Then I click Go Back on the Elmo OHC Retiree page

    #PeaceCorps
    Then I select "None of these" as ELMO health coverage option
    Then I select "Peace Corps" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohc Peace Corps" page
    Then I click "Yes" for currently enrolled in Peace Corps question
    Then I click "Yes" for insurance ending in 60 days in Peace Corps question
    Then I enter the end date as "Future Day" on the Peace Corps page
    Then I click "No" for insurance ending voluntary for Peace Corps question
    Then I click Go Back on the Elmo OHC Peace Corps page

    #Cobra
    Then I select "None of these" as ELMO health coverage option
    Then I select "COBRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo COBRA" page
    Then I click "Yes" for currently enrolled in COBRA question
    Then I click "Yes" for insurance ending in 60 days in COBRA question
    Then I enter the end date as "Future Day" on the Cobra page
    Then I click "No" for insurance ending voluntary for COBRA question
    Then I click Go Back on the Elmo OHC Cobra page

   #VAhealthcare
    Then I select "None of these" as ELMO health coverage option
    Then I select "VA Health Care" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohc VA Healthcare" page
    Then I click "Yes" for currently enrolled in VA Healthcare question
    Then I click "Yes" for insurance ending in 60 days in VA Healthcare question
    Then I enter the end date as "Future Day" on the VA Healthcare page
    Then I click "No" for insurance ending voluntary for VA Healthcare question
    Then I click Go Back on the Elmo OHC VA Healthcare page

    #TRICARE
    Then I select "None of these" as ELMO health coverage option
    Then I select "TRICARE" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohc Tricare" page
    Then I click "Yes" for currently enrolled in Tricare question
    Then I click "Yes" for insurance ending in 60 days in Tricare question
    Then I enter the end date as "Future Day" on the Tricare page
    Then I click "No" for insurance ending voluntary for Tricare question
    Then I click Go Back on the Elmo OHC Tricare page

          #individual
    Then I select "None of these" as ELMO health coverage option
    Then I select "Other" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I validate I am on the "Elmo Ohc Individual Insurance" page
    Then I click "Yes" for currently enrolled in Individual Insurance question
    Then I click "Yes" for insurance ending in 60 days in Individual Insurance question
    Then I enter the end date as "Future Day" on the Individual Insurance page
    Then I click "No" for insurance ending voluntary for Individual Insurance question
    Then I click continue on the Elmo OHC Individual Insurance page

    And I click plus icon next to member on household page for "Primary"
    And I click the edit income icon on household page for "Primary"
    Then I click continue on the Employment Summary Page
    Then I click continue on the Additional Income page
    Then I click continue on the Deductions page
    Then I select the projected income option "No" and continue
    Then I click Save and Continue on Tax Status Elmo page

    Then I validate selecting insurance options
      | InsuranceOption       |
      | Health First Colorado |
      | CHP+                  |
      | Medicare              |
      | job                   |
      | HRA                   |
      | Retiree Health Plan   |
      | Peace Corps           |
      | COBRA                 |
      | VA Health Care        |
      | TRICARE               |
      | Other                 |
      | None of these         |

    Then I select "Medicare" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    And I click Go Back on the Elmo OHC Medicare page
    Then I select "None of these" as ELMO health coverage option
    Then I select "job" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I select the Go Back button on the ESI page
    Then I select "None of these" as ELMO health coverage option
    Then I select "HRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click Go Back on the Elmo OHC HRA page
    Then I select "None of these" as ELMO health coverage option
    Then I select "Retiree Health Plan" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click Go Back on the Elmo OHC Retiree page
    Then I select "None of these" as ELMO health coverage option
    Then I select "Peace Corps" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click Go Back on the Elmo OHC Peace Corps page
    Then I select "None of these" as ELMO health coverage option
    Then I select "COBRA" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click Go Back on the Elmo OHC Cobra page
    Then I select "None of these" as ELMO health coverage option
    Then I select "VA Health Care" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click Go Back on the Elmo OHC VA Healthcare page
    Then I select "None of these" as ELMO health coverage option
    Then I select "TRICARE" as ELMO health coverage option
    Then I click continue on the ELMO health coverage page
    Then I click Go Back on the Elmo OHC Tricare page

    And I click on Sign Out in the Header for "Elmo"

  @SLER-2272
  Scenario: SLER-2272 As a user on the Employment Summary page, I need the ability to remove a job/employer so that I can accurately report my employment details
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    And I enter employment details with "3000000" income at "Annually" frequency
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page
    Then I click on Add job or self-employment on the Employment Summary Page
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "1500000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page
    Then I click on Add job or self-employment on the Employment Summary Page
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "200000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click on Add job or self-employment on the Employment Summary Page
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "50000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    #DB step
    And I validate the employee income details row count 4
    Then I click on Remove job "First" entered for Primary on the Employment Summary Page
    And I validate I am on the "Employment Summary" page
    And I validate the employee income details row count 3
    Then I click on Remove job "First" entered for Primary on the Employment Summary Page
    And I validate I am on the "Employment Summary" page
    And I validate the employee income details row count 2
    Then I click on Remove job "First" entered for Primary on the Employment Summary Page
    And I validate I am on the "Employment Summary" page
    And I validate the employee income details row count 1
    Then I click on Remove job "First" entered for Primary on the Employment Summary Page
    And I validate I am on the "Employment Summary" page
    And I validate the employee income details row count 0


  @SLER-2301
  Scenario: SLER-2301 As a Exch user on the Employment Summary page, I want to see the employment summary list presented in the order it was added so that I can review and update
    Then I select the option "Yes" to employment
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "200000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    Then I click on Add job or self-employment on the Employment Summary Page
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "200000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page
    Then I click on Add job or self-employment on the Employment Summary Page
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "200000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page

    Then I click on Add job or self-employment on the Employment Summary Page
    And I select the option "No" to self employment
    Then I enter company details with addressline1 as "123 Test Address" and city as "Denver" and state as "CO" and zipcode as "80205" and income "200000" at frequency "Annually"
    And I select the option "No" to seasonal employment
    And I select the option "No" to projected income
    And I click continue on the Employment Info Page
    And I validate company names in employment summary page
    Then I click on Remove job "Third" entered for Primary on the Employment Summary Page
    And I validate company names in employment summary page
    Then I click on Remove job "First" entered for Primary on the Employment Summary Page
    And I validate company names in employment summary page
    And I click on Sign Out in the Header for "Elmo"

  @SLER-2276
  Scenario: SLER-2276 ELIG-Self-employment income-Page Navigation[RT-1203]
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    Then I validate Employment Info Page header in "English"
    Then I validate I am on the "Employment Income" page
    Then I select the option "Yes" to employment
    And I select the option "Yes" to self employment
    And I enter self-employment details with "54000.00" income at "Annually" frequency and "Yes" to same or lower
    And I click continue on the Employment Info Page
    And I validate I am on the "Employment Summary" page
    Then I click Edit on Income Summary row 1
    Then I validate I am on the "Employment Income" page





