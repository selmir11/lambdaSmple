Feature: Additional information for yourself page - Validate te zip code and county

  Background: I go the login portal
    Given I open the login page on the "login" portal
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
    Then I click EditUpdate on Family Overview page for "Primary"
    And I enter details on tell us about yourself page and continue with "01011991", "Female", and applying "Yes"
    Then I validate I am on the "CoCo Additional information for yourself" page

  @SLCR-667 @NVOCoCoRegression
  Scenario Outline: County validations for primary member
    And I enter my residential address "1234 Road", "<city>", "<State>", "<zipCode>", "<county>"
    And I validate the available counties from dropdown to select are
      | <expectedCounties> |
    And I click on Sign Out in the Header for "Elmo"
    Examples:
      | city              | State | zipCode | county      | expectedCounties               |
      | Colorado Springs  | CO    | 80916   | EL PASO     | EL PASO                        |
      | Denver            | CO    | 80205   | DENVER      | DENVER                         |
      | Cudahy            | CA    | 90201   | LOS ANGELES | LOS ANGELES                    |
      | Federal Heights   | CO    | 80260   | ADAMS       | ADAMS                          |
      | Jacksonville      | FL    | 32244   | DUVAL       | DUVAL,CLAY                     |
      | Guffey            | CO    | 80820   | PARK        | PARK                           |
      | Branson           | CO    | 81027   | LAS ANIMAS  | LAS ANIMAS                     |
      | Rocky Ford        | CO    | 81067   | OTERO       | OTERO                          |
      | Orem              | UT    | 84059   | UTAH        | UTAH                           |
      | Washington Algona | WA    | 98001   | KING        | KING                           |
      | Brookside Canon   | CO    | 81212   | FREMONT     | FREMONT                        |
      | Arvada            | CO    | 80002   | ADAMS       | ADAMS,JEFFERSON                |
      | Commerce City     | CO    | 80216   | ADAMS       | ADAMS,DENVER                   |
      | Erie              | CO    | 80504   | BOULDER     | BOULDER,LARIMER,WELD           |
      | AL Rome           | GA    | 30165   | FLOYD       | CHATTOOGA,FLOYD                |
      | Bluff             | UT    | 84531   | SAN JUAN    | SAN JUAN                       |
      | Alpharetta        | GA    | 30004   | FULTON      | CHEROKEE,FORSYTH,FULTON        |
      | Black Forest      | CO    | 80106   | DOUGLAS     | DOUGLAS,EL PASO,ELBERT         |
      | Castle Pines      | CO    | 80108   | DOUGLAS     | DOUGLAS                        |
      | Colorado City     | CO    | 81069   | PUEBLO      | CROWLEY,CUSTER,HUERFANO,PUEBLO |
      | Monte Vista       | CO    | 81144   | ALAMOSA     | ALAMOSA,RIO GRANDE             |

  @SLCR-667
  Scenario Outline: Validate County is greyed out for primary member
    And I enter my residential address "1234 Road", "DENVER", "CO", "80205", "DENVER"
    And I update the state and zipcode to "<state>" and "<zipcode>"
    Then I validate the county field is greyed out
    Examples:
      | state | zipcode |
      | CA    | 80504   |
      | NV    | 95959   |

  @SLCR-668
  Scenario Outline: County validations for additional member
    And I enter my residential address "1234 Road", "DENVER", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Wife", "03051989", "Male", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional information for yourself" page
    And I enter residential address details for additional member "1234 Road", "<city>", "<State>", "<zipCode>", "<county>"
    And I validate the available counties from dropdown to select are
      | <expectedCounties> |
    And I click on Sign Out in the Header for "Elmo"
    Examples:
      | city              | State | zipCode | county      | expectedCounties               |
      | Colorado Springs  | CO    | 80916   | EL PASO     | EL PASO                        |
      | Denver            | CO    | 80205   | DENVER      | DENVER                         |
      | Cudahy            | CA    | 90201   | LOS ANGELES | LOS ANGELES                    |
      | Federal Heights   | CO    | 80260   | ADAMS       | ADAMS                          |
      | Jacksonville      | FL    | 32244   | DUVAL       | DUVAL,CLAY                     |
      | Guffey            | CO    | 80820   | PARK        | PARK                           |
      | Branson           | CO    | 81027   | LAS ANIMAS  | LAS ANIMAS                     |
      | Rocky Ford        | CO    | 81067   | OTERO       | OTERO                          |
      | Orem              | UT    | 84059   | UTAH        | UTAH                           |
      | Washington Algona | WA    | 98001   | KING        | KING                           |
      | Brookside Canon   | CO    | 81212   | FREMONT     | FREMONT                        |
      | Arvada            | CO    | 80002   | ADAMS       | ADAMS,JEFFERSON                |
      | Commerce City     | CO    | 80216   | ADAMS       | ADAMS,DENVER                   |
      | Erie              | CO    | 80504   | BOULDER     | BOULDER,LARIMER,WELD           |
      | AL Rome           | GA    | 30165   | FLOYD       | CHATTOOGA,FLOYD                |
      | Bluff             | UT    | 84531   | SAN JUAN    | SAN JUAN                       |
      | Alpharetta        | GA    | 30004   | FULTON      | CHEROKEE,FORSYTH,FULTON        |
      | Black Forest      | CO    | 80106   | DOUGLAS     | DOUGLAS,EL PASO,ELBERT         |
      | Castle Pines      | CO    | 80108   | DOUGLAS     | DOUGLAS                        |
      | Colorado City     | CO    | 81069   | PUEBLO      | CROWLEY,CUSTER,HUERFANO,PUEBLO |
      | Monte Vista       | CO    | 81144   | ALAMOSA     | ALAMOSA,RIO GRANDE             |

  @SLCR-668
  Scenario Outline: Validate County is greyed out for additional member
    And I enter my residential address "1234 Road", "DENVER", "CO", "80205", "DENVER"
    And I select "Yes" for mailing address option
    And I select "Yes" for live in Colorado option
    And I click continue on the Add info for yourself page
    Then I validate I am on the "Race and Ethnicity" page
    And I select "Prefer not to answer" for race and ethnicity option for "Primary"
    And I click save and continue on the Race and Ethnicity page
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page
    And I select "None of these" as deductions option
    And I select continue on the Deductions CoCo page
    Then I select the projected income option "No" on Income Summary CoCo page
    And I select continue on the income Summary CoCo page
    Then I select add another family member on the Family Overview page
    Then I enter details on tell us about additional members of your household page with "Wife", "03051989", "Male", and applying "Yes"
      | Primary:Spouse |
    And I click continue on Tell us about additional members of your household page
    Then I validate I am on the "CoCo Additional information for yourself" page
    And I enter residential address details for additional member "1234 Road", "DENVER", "CO", "80205", "DENVER"
    And I update the state and zipcode to "<state>" and "<zipcode>" for additional member
    Then I validate the county field is greyed out for additional member
    And I click on Sign Out in the Header for "Elmo"
    Examples:
      | state | zipcode |
      | CA    | 80504   |
      | NV    | 95959   |