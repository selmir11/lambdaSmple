@APTC @APTCCalculator
Feature: API Tests related to APTC

  @SLER-308 @SLER-424 @SLER-425 @SLER-426 @SLER-427 @SLER-439 @SLER-440 @SLER-441 @SLER-442 @SLER-459 @SLER-460 @SLER-461 @SLER-462 @SLER-463 @SLER-464 @SLER-502 @SLER-503 @SLER-504 @SLER-505
  Scenario Outline: Single Member Household
      Given I get APTC CALCULATOR base URL
      When I send the single member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>"
      And I send the APTC Calculator Request
      Then status code should be 200
      And I expect "<APTC>" and "<Contribution Amount>"
      Examples:
        | Magi      | Zip   | Fips  | FPL    | DOB        | APTC    | Contribution Amount |
        | 58321.0   | 80863 | 08119 | 400.01 | 1981-01-01 | 41.98   | 8.5                 |
        | 61600.0   | 80220 | 08031 | 422.50 | 1971-01-01 | 228.99  | 8.5                 |
        | 62182.0   | 80461 | 08065 | 426.49 | 1961-01-01 | 804.96  | 8.5                 |
        | 65650.0   | 81650 | 08045 | 450.27 | 1959-01-01 | 912.73  | 8.5                 |
        | 68000.0   | 80435 | 08117 | 466.39 | 1990-01-01 | 30.5    | 8.5                 |
        | 43740.0   | 80470 | 08093 | 300.00 | 1976-01-01 | 315.02  | 6.0                 |
        | 47000.0   | 80487 | 08107 | 322.36 | 1972-01-01 | 601.67  | 6.56                |
        | 55500.0   | 81504 | 08077 | 380.66 | 1962-01-01 | 651.68  | 8.02                |
        | 58320.0   | 81144 | 08105 | 400.00 | 1958-01-01 | 1036.47 | 8.5                 |
        | 36450.0   | 80127 | 08059 | 250.00 | 1958-01-01 | 856.9   | 4.0                 |
        | 37000.0   | 80166 | 08005 | 253.77 | 1958-01-01 | 850.42  | 4.15                |
        | 39000.0   | 80134 | 08035 | 267.49 | 1995-01-01 | 212.2   | 4.7                 |
        | 42000.0   | 80801 | 08121 | 288.07 | 1995-01-01 | 347.39  | 5.52                |
        | 43011.0   | 80127 | 08059 | 295.00 | 1995-01-01 | 157.05  | 5.8                 |
        | 40241.0   | 80801 | 08121 | 276.00 | 1958-01-01 | 1280.56 | 5.04                |
        | 30120.0   | 80127 | 08059 | 200.00 | 1958-01-01 | 928.2   | 2.0                 |
        | 30120.0   | 80166 | 08005 | 200.00 | 1958-01-01 | 928.2   | 2.0                 |
        | 35076.0   | 80801 | 08121 | 232.91 | 1958-01-01 | 1352.63 | 3.32                |
        | 37650.0   | 80801 | 08121 | 250.00 | 1958-01-01 | 1324.07 | 4.0                 |

  @SLER-428 @SLER-429 @SLER-430 @SLER-443 @SLER-444 @SLER-445 @SLER-446 @SLER-447 @SLER-448 @SLER-466 @SLER-467 @SLER-507 @SLER-508
  Scenario Outline: Two Member Household
    Given I get APTC CALCULATOR base URL
    When I send the two member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi      | Zip   | Fips  | FPL    | DOB        | DOB2        | APTC    | Contribution Amount |
      | 69715.0   | 81006 | 08101 | 478.16 | 1982-01-01 | 2011-01-01  | 274.68  | 8.5                 |
      | 83000.0   | 80220 | 08031 | 420.89 | 1981-01-01 | 1983-01-01  | 279.28  | 8.5                 |
      | 98600.0   | 80524 | 08069 | 500.00 | 1982-01-01 | 1973-01-01  | 397.84  | 8.5                 |
      | 59200.0   | 80461 | 08065 | 300.20 | 1985-01-01 | 2007-01-01  | 609.55  | 6.01                |
      | 69100.0   | 80634 | 08123 | 350.41 | 1983-01-01 | 1989-01-01  | 423.38  | 7.26                |
      | 74000.0   | 80521 | 08069 | 375.25 | 1967-01-01 | 1969-01-01  | 1117.83 | 7.88                |
      | 78880.0   | 80203 | 08031 | 400.00 | 1996-01-01 | 1999-01-01  | 123.22  | 8.5                 |
      | 59300.0   | 80461 | 08065 | 300.71 | 1985-01-01 | 2007-01-01  | 608.42  | 6.02                |
      | 65500.0   | 80448 | 08093 | 332.15 | 1970-01-01 | 1975-01-01  | 882.47  | 6.8                 |
      | 49243.0   | 80219 | 08031 | 249.71 | 1991-01-01 | 2011-01-01  | 476.53  | 3.99                |
      | 59160.0   | 80449 | 08093 | 300.00 | 1981-01-01 | 1958-01-01  | 1126.49 | 6.0                 |
      | 40880.0   | 80219 | 08031 | 200.00 | 1991-01-01 | 2010-01-01  | 572.07  | 2.0                 |
      | 44588.0   | 81324 | 08033 | 218.14 | 1980-01-01 | 1985-01-01  | 1005.19 | 2.73                |

  @SLER-431 @SLER-432 @SLER-449 @SLER-450 @SLER-451 @SLER-468
  Scenario Outline: Three Member Household
    Given I get APTC CALCULATOR base URL
    When I send the three member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL    | DOB        | DOB2        | DOB3        | APTC    | Contribution Amount |
      | 103300.0   | 80106 | 08039 | 400.08 | 1992-01-01 | 1998-01-01  | 2021-01-01  | 255.11  | 8.5                 |
      | 129100.0   | 81143 | 08109 | 500.00 | 1989-01-01 | 1989-01-01  | 2013-01-01  | 636.1   | 8.5                 |
      | 74800.0    | 80444 | 08019 | 300.88 | 1994-01-01 | 1994-01-01  | 2017-01-01  | 632.36  | 6.02                |
      | 85000.0    | 80920 | 08041 | 341.91 | 1990-01-01 | 2011-01-01  | 2013-01-01  | 421.03  | 7.05                |
      | 64300.0    | 80447 | 08049 | 258.65 | 1990-01-01 | 1991-01-01  | 2018-01-01  | 1107.47 | 4.35                |

  @SLER-433 @SLER-452 @SLER-469 @SLER-470 @SLER-509 @SLER-510
  Scenario Outline: Four Member Household
    Given I get APTC CALCULATOR base URL
    When I send the four member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL    | DOB        | DOB2        | DOB3        | DOB4        | APTC    | Contribution Amount |
      | 125000.0   | 80440 | 08093 | 400.64 | 1962-01-01 | 1963-01-01  | 2001-01-01  | 2002-01-01  | 1622.59 | 8.5                 |
      | 113000.0   | 80813 | 08119 | 376.67 | 1961-01-01 | 1963-01-01  | 2001-01-01  | 2002-01-01  | 1857.62 | 7.92                |
      | 90000.0    | 80513 | 08069 | 300.00 | 1976-01-01 | 1971-01-01  | 2006-01-01  | 2011-01-01  | 1389.6  | 6.0                 |
      | 90000.0    | 80219 | 08031 | 300.00 | 1961-01-01 | 1966-01-01  | 2011-01-01  | 2016-01-01  | 1842.72 | 6.0                 |
      | 78000.0    | 80219 | 08031 | 250.00 | 1980-01-01 | 1991-01-01  | 2003-01-01  | 2017-01-01  | 1161.94 | 4.0                 |
      | 78000.0    | 80219 | 08031 | 250.00 | 1961-01-01 | 1965-01-01  | 2011-01-01  | 2016-01-01  | 2050.66 | 4.0                 |

  @SLER-434 @SLER-453 @SLER-471 @SLER-511
  Scenario Outline: Five Member Household
    Given I get APTC CALCULATOR base URL
    When I send the five member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>", "<DOB5>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL    | DOB        | DOB2        | DOB3        | DOB4        | DOB5        | APTC    | Contribution Amount |
      | 175700.0   | 80444 | 08019 | 500.00 | 1977-01-01 | 1977-01-01  | 2009-01-01  | 2011-01-01  | 2013-01-01  | 578.04  | 8.5                 |
      | 140560.0   | 81432 | 08091 | 400.00 | 1991-01-01 | 1992-01-01  | 2016-01-01  | 2018-01-01  | 2020-01-01  | 1151.83 | 8.5                 |
      | 96227.0    | 80474 | 08047 | 273.84 | 1958-01-01 | 1965-01-01  | 2002-01-01  | 2003-01-01  | 2011-01-01  | 2381.29 | 4.95                |
      | 88385.0    | 80474 | 08047 | 241.62 | 1958-01-01 | 1965-01-01  | 2002-01-01  | 2003-01-01  | 2011-01-01  | 2508.59 | 3.66                |

  @SLER-435 @SLER-454
  Scenario Outline: Six Member Household
    Given I get APTC CALCULATOR base URL
    When I send the six member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>", "<DOB5>", "<DOB6>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL     | DOB        | DOB2        | DOB3        | DOB4        | DOB5        | DOB6        | APTC    | Contribution Amount |
      | 181500.0   | 80132 | 08041 | 450.60  | 1991-01-01 | 1991-01-01  | 2013-01-01  | 2013-01-01  | 2013-01-01  | 2015-01-01  | 287.58  | 8.5                 |
      | 121000.0   | 81301 | 08067 | 300.40  | 1988-01-01 | 1989-01-01  | 2012-01-01  | 2012-01-01  | 2012-01-01  | 2015-01-01  | 1369.31 | 6.01                |

  @SLER-436 @SLER-455
  Scenario Outline: Seven Member Household
    Given I get APTC CALCULATOR base URL
    When I send the seven member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>", "<DOB5>", "<DOB6>", "<DOB7>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL     | DOB        | DOB2        | DOB3        | DOB4        | DOB5        | DOB6        | DOB7        | APTC    | Contribution Amount |
      | 272600.0   | 81611 | 08097 | 600.18  | 1971-01-01 | 1972-01-01  | 2009-01-01  | 2013-01-01  | 2013-01-01  | 2015-01-01  | 2017-01-01  | 987.63  | 8.5                 |
      | 150000.0   | 81425 | 08085 | 330.25  | 1962-01-01 | 1963-01-01  | 1998-01-01  | 2000-01-01  | 2002-01-01  | 2004-01-01  | 2006-01-01  | 4018.93 | 6.76                |

  @SLER-437 @SLER-456 @SLER-472 @SLER-512
  Scenario Outline: Eight Member Household
    Given I get APTC CALCULATOR base URL
    When I send the eight member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>", "<DOB5>", "<DOB6>", "<DOB7>", "<DOB8>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL     | DOB        | DOB2        | DOB3        | DOB4        | DOB5        | DOB6        | DOB7        | DOB8        | APTC    | Contribution Amount |
      | 220000.0   | 80302 | 08013 | 435.13  | 1986-01-01 | 1987-01-01  | 2015-01-01  | 2015-01-01  | 2015-01-01  | 2018-01-01  | 2018-01-01  | 2018-01-01  | 0.26    | 8.5                 |
      | 177000.0   | 80480 | 08057 | 350.08  | 1961-01-01 | 1962-01-01  | 1997-01-01  | 1997-01-01  | 1997-01-01  | 1999-01-01  | 1999-01-01  | 1999-01-01  | 6200.89 | 7.25                |
      | 126400.0   | 80480 | 08057 | 250.00  | 1958-01-01 | 1968-01-01  | 2002-01-01  | 2003-01-01  | 2005-01-01  | 2007-01-01  | 2009-01-01  | 2011-01-01  | 5642.22 | 4.0                 |
      | 129849.0   | 80822 | 08125 | 246.30  | 1958-01-01 | 1968-01-01  | 2002-01-01  | 2003-01-01  | 2005-01-01  | 2007-01-01  | 2009-01-01  | 2011-01-01  | 4411.21 | 3.85                |

  @SLER-438 @SLER-457
  Scenario Outline: Nine Member Household
    Given I get APTC CALCULATOR base URL
    When I send the nine member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>", "<DOB5>", "<DOB6>", "<DOB7>", "<DOB8>", "<DOB9>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL     | DOB        | DOB2        | DOB3        | DOB4        | DOB5        | DOB6        | DOB7        | DOB8        | DOB9        | APTC    | Contribution Amount |
      | 225000.0   | 80504 | 08123 | 403.95  | 1976-01-01 | 1977-01-01  | 2011-01-01  | 2011-01-01  | 2011-01-01  | 2013-01-01  | 2013-01-01  | 2013-01-01  | 2013-01-01  | 237.52  | 8.5                 |
      | 215000.0   | 81321 | 08083 | 386.00  | 1976-01-01 | 1977-01-01  | 2000-01-01  | 2000-01-01  | 2000-01-01  | 2000-01-01  | 2013-01-01  | 2013-01-01  | 2013-01-01  | 2490.02 | 8.15                |

  @SLER-458 @SLER-513
  Scenario Outline: Ten Member Household
    Given I get APTC CALCULATOR base URL
    When I send the ten member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>", "<DOB5>", "<DOB6>", "<DOB7>", "<DOB8>", "<DOB9>", "<DOB10>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL     | DOB        | DOB2        | DOB3        | DOB4        | DOB5        | DOB6        | DOB7        | DOB8        | DOB9        | DOB10       | APTC    | Contribution Amount |
      | 243360.0   | 81147 | 08007 | 400.00  | 1974-01-01 | 1974-01-01  | 1999-01-01  | 1999-01-01  | 1999-01-01  | 2000-01-01  | 2000-01-01  | 2000-01-01  | 2009-01-01  | 2009-01-01  | 2957.54 | 8.5                 |
      | 182520.0   | 81003 | 08101 | 300.00  | 1958-01-01 | 1961-01-01  | 1995-01-01  | 2005-01-01  | 2007-01-01  | 2009-01-01  | 2011-01-01  | 2013-01-01  | 2015-01-01  | 2020-01-01  | 2665.12 | 6.0                 |
      | 158700.0   | 81003 | 08101 | 250.00  | 1958-01-01 | 1961-01-01  | 1995-01-01  | 2005-01-01  | 2007-01-01  | 2009-01-01  | 2011-01-01  | 2013-01-01  | 2015-01-01  | 2020-01-01  | 3048.72 | 4.0                 |

  @SLER-465 @SLER-506
  Scenario Outline: Two Member Household with different zip codes
    Given I get APTC CALCULATOR base URL
    When I send the two member in different zip codes household's Information: "<Magi>", "<Zip>", "<Fips>", "<Zip2>", "<Fips2>", "<FPL>", "<DOB>", "<DOB2>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi      | Zip   | Fips  | Zip2  | Fips2 | FPL    | DOB        | DOB2        | APTC    | Contribution Amount |
      | 54336.0   | 80234 | 08001 | 80219 | 08031 | 275.54 | 1980-01-01 | 2011-01-01  | 477.72  | 5.02                |
      | 51100.0   | 80801 | 08121 | 80219 | 08031 | 250.00 | 1980-01-01 | 2010-01-01  | 883.39  | 4.0                 |