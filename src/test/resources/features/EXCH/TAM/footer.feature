@TAM @TamExch
Feature: Footer verification - Multiple pages

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
      | InstagramIcon          | Login • Instagram                                    | instagram.com                                    |
      | ThreadsIcon            | Threads                                              | threads.com                                      |
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
      | InstagramIcon          | Login • Instagram                                    | instagram.com                                    |
      | ThreadsIcon            | Threads                                              | threads.com                                      |

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
      | YouTubeIcon            | YouTube                                              | youtube.com                                              |
      | LinkedInIcon           | LinkedIn                                             | www.linkedin.com                                         |
      | InstagramIcon          | Login • Instagram                                    | instagram.com                                            |
      | ThreadsIcon            | Threads                                              | threads.com                                              |

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
      | InstagramIcon          | Login • Instagram                                    | instagram.com                                    |
      | ThreadsIcon            | Threads                                              | threads.com                                      |

    Then I select the projected income option "No" and continue
  #TaxPage
    Then I validate I am on the "Tax status" page
    And I change the language from Elmo header to "Spanish" if it isn't already in that language
    Then I validate page Navigation works for Footer hyperlink text in "Spanish"
      | HyperLinkText          | ExpectedPageTitle                                    | ContainsUrl                                              |
      | Póliza de privacidad   | Política de Privacidad • Connect for Health Colorado | connectforhealthco.com/es/politica-de-privacidad/        |
      | Términos y Condiciones | Términos de uso • Connect for Health Colorado        | connectforhealthco.com/es/terminos-de-uso/               |
      | Comentarios            | Póngase en contacto • Connect for Health Colorado    | connectforhealthco.com/es/pongase-en-contacto/           |
      | FacebookIcon           | Facebook                                             | facebook.com                                             |
      | xIcon                  | X                                                    | x.com                                                    |
      | YouTubeIcon            | YouTube                                              | youtube.com                                              |
      | LinkedInIcon           | LinkedIn                                             | www.linkedin.com                                         |
      | InstagramIcon          | Login • Instagram                                    | instagram.com                                            |
      | ThreadsIcon            | Threads                                              | threads.com                                              |

    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    #ELMO page
    Then I validate I am on the "Other Health Coverage" page
    Then I validate page Navigation works for Footer hyperlink text in "Spanish"
      | HyperLinkText          | ExpectedPageTitle                                    | ContainsUrl                                              |
      | Póliza de privacidad   | Política de Privacidad • Connect for Health Colorado | connectforhealthco.com/es/politica-de-privacidad/        |
      | Términos y Condiciones | Términos de uso • Connect for Health Colorado        | connectforhealthco.com/es/terminos-de-uso/               |
      | Comentarios            | Póngase en contacto • Connect for Health Colorado    | connectforhealthco.com/es/pongase-en-contacto/           |
      | FacebookIcon           | Facebook                                             | facebook.com                                             |
      | xIcon                  | X                                                    | x.com                                                    |
      | YouTubeIcon            | YouTube                                              | youtube.com                                              |
      | LinkedInIcon           | LinkedIn                                             | www.linkedin.com                                         |
      | InstagramIcon          | Login • Instagram                                    | instagram.com                                            |
      | ThreadsIcon            | Threads                                              | threads.com                                              |
    And I click on Sign Out in the Header for "Elmo"


  @SLER-2266
  Scenario:  SLER-2266 The copyright statement text in the footer doesn't coincide with the links above - Privacy Policy | Terms of Use | Contact Us - Spanish
    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle      | ContainsUrl                           |
      | Privacy Policy | Privacy Policy         | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use           | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us             | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook               | facebook.com                          |
      | xIcon          | X                      | x.com                                 |
      | YouTubeIcon    | YouTube                | youtube.com                           |
      | LinkedInIcon   | LinkedIn               | www.linkedin.com                      |
      | InstagramIcon  | Login • Instagram      | instagram.com                         |
      | ThreadsIcon    | Threads                | threads.com                           |
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
      | InstagramIcon  | Login • Instagram | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.com                           |
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
      | InstagramIcon  | Login • Instagram | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.com                           |
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
      | InstagramIcon  | Login • Instagram | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.com                           |
    Then I select the projected income option "No" and continue
  #TaxPage
    Then I validate I am on the "Tax status" page
    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
      | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook          | facebook.com                          |
      | xIcon          | X                 | x.com                                 |
      | YouTubeIcon    | YouTube           | youtube.com                           |
      | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
      | InstagramIcon  | Login • Instagram | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.com                           |
    Then I select "No" for will you be claimed as dependent question
    Then I select "Yes" for will file tax return question
    Then I select the "Single" tax filing option on the Tax Status page
    Then I select "No" for will claim dependents question
    Then I click Save and Continue on Tax Status page
    #ELMO page
    Then I validate I am on the "Other Health Coverage" page
    Then I validate page Navigation works for Footer hyperlink text in "English"
      | HyperLinkText  | ExpectedPageTitle | ContainsUrl                           |
      | Privacy Policy | Privacy Policy    | connectforhealthco.com/privacy-policy |
      | Terms          | Terms of Use      | connectforhealthco.com/terms-of-use   |
      | Contact Us     | Contact Us        | connectforhealthco.com/contact-us     |
      | FacebookIcon   | Facebook          | facebook.com                          |
      | xIcon          | X                 | x.com                                 |
      | YouTubeIcon    | YouTube           | youtube.com                           |
      | LinkedInIcon   | LinkedIn          | www.linkedin.com                      |
      | InstagramIcon  | Login • Instagram | instagram.com                         |
      | ThreadsIcon    | Threads           | threads.com                           |
    And I click on Sign Out in the Header for "Elmo"
