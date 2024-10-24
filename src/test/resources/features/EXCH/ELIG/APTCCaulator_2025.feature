@APTCCalculator
Feature: API Tests related to APTC

  @SLER-308 @SLER-424 @SLER-425 @SLER-426 @SLER-427 @SLER-439 @SLER-440 @SLER-441 @SLER-442 @SLER-459 @SLER-460 @SLER-461 @SLER-462 @SLER-463 @SLER-464 @SLER-502 @SLER-503 @SLER-504 @SLER-505 @SLER-520 @SLER-521 @SLER-522 @SLER-523 @SLER-524 @SLER-525 @SLER-530 @SLER-597 @SLER-598 @SLER-599 @SLER-600
  Scenario Outline: Single Member Household
    Given I get APTC CALCULATOR base URL
    When I send the single member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi      | Zip   | Fips  | FPL    | DOB        | APTC    | Contribution Amount |
      | 60242.0   | 80863 | 08119 | 400.01 | 1981-01-01 | 68.65   | 8.5                 |
      | 63628.0   | 80220 | 08031 | 422.50 | 1971-01-01 | 279.08  | 8.5                 |
      | 64229.0   | 80461 | 08065 | 426.49 | 1961-01-01 | 891.64  | 8.5                 |
      | 67811.0   | 81650 | 08045 | 450.27 | 1959-01-01 | 1066.41 | 8.5                 |
      | 70238.0   | 80435 | 08117 | 466.39 | 1990-01-01 | 22.9    | 8.5                 |
      | 45180.0   | 80470 | 08093 | 300.00 | 1976-01-01 | 364.35  | 6.0                 |
      | 48547.0   | 80487 | 08107 | 322.36 | 1972-01-01 | 563.83  | 6.56                |
      | 57327.0   | 81504 | 08077 | 380.66 | 1962-01-01 | 659.0   | 8.02                |
      | 60240.0   | 81144 | 08105 | 400.00 | 1958-01-01 | 844.63  | 8.5                 |
      | 37650.0   | 80127 | 08059 | 250.00 | 1958-01-01 | 899.95  | 4.0                 |
      | 38218.0   | 80166 | 08005 | 253.77 | 1958-01-01 | 893.25  | 4.15                |
      | 40284.0   | 80134 | 08035 | 267.49 | 1995-01-01 | 230.19  | 4.7                 |
      | 43383.0   | 80801 | 08121 | 288.07 | 1995-01-01 | 281.33  | 5.52                |
      | 44427.0   | 80127 | 08059 | 295.00 | 1995-01-01 | 173.23  | 5.8                 |
      | 41566.0   | 80801 | 08121 | 276.00 | 1958-01-01 | 1096.75 | 5.04                |
      | 30120.0   | 80127 | 08059 | 200.00 | 1958-01-01 | 975.25  | 2.0                 |
      | 30120.0   | 80166 | 08005 | 200.00 | 1958-01-01 | 975.25  | 2.0                 |
      | 35076.0   | 80801 | 08121 | 232.91 | 1958-01-01 | 1174.39 | 3.32                |
      | 37650.0   | 80801 | 08121 | 250.00 | 1958-01-01 | 1145.83 | 4.0                 |
      | 22590.0   | 80219 | 08031 | 150.00 | 1958-01-01 | 1025.45 | 0.0                 |
      | 26893.0   | 80477 | 08107 | 178.57 | 1999-01-01 | 390.61  | 1.14                |
      | 26893.0   | 80219 | 08031 | 178.57 | 1999-01-01 | 324.4   | 1.14                |
      | 26893.0   | 80477 | 08107 | 178.57 | 1985-01-01 | 493.85  | 1.14                |
      | 26893.0   | 80219 | 08031 | 178.57 | 2001-01-01 | 316.21  | 1.14                |
      | 24787.0   | 81303 | 08067 | 164.59 | 2000-01-01 | 415.53  | 0.58                |
      | 20030.0   | 80123 | 08059 | 133.00 | 1981-01-01 | 477.51  | 0.0                 |
      | 20030.0   | 81140 | 08021 | 133.00 | 1971-01-01 | 904.77  | 0.0                 |
      | 20030.0   | 80821 | 08073 | 133.00 | 1961-01-01 | 1271.33 | 0.0                 |
      | 20030.0   | 80498 | 08117 | 133.00 | 1959-01-01 | 1277.63 | 0.0                 |

  @SLER-428 @SLER-429 @SLER-430 @SLER-443 @SLER-444 @SLER-445 @SLER-446 @SLER-447 @SLER-448 @SLER-466 @SLER-467 @SLER-507 @SLER-508 @SLER-526 @SLER-601 @SLER-602 @SLER-603 @SLER-604
  Scenario Outline: Two Member Household
    Given I get APTC CALCULATOR base URL
    When I send the two member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi      | Zip   | Fips  | FPL    | DOB        | DOB2        | APTC    | Contribution Amount |
      | 97736.0   | 81006 | 08101 | 478.16 | 1982-01-01 | 2011-01-01  | 56.9    | 8.5                 |
      | 86030.0   | 80220 | 08031 | 420.89 | 1981-01-01 | 1983-01-01  | 321.03  | 8.5                 |
      | 102200.0  | 80524 | 08069 | 500.00 | 1982-01-01 | 1973-01-01  | 442.46  | 8.5                 |
      | 61361.0   | 80461 | 08065 | 300.20 | 1985-01-01 | 2007-01-01  | 676.4   | 6.01                |
      | 71624.0   | 80634 | 08123 | 350.41 | 1983-01-01 | 1989-01-01  | 467.25  | 7.26                |
      | 76701.0   | 80521 | 08069 | 375.25 | 1967-01-01 | 1969-01-01  | 1216.73 | 7.88                |
      | 81760.0   | 80203 | 08031 | 400.00 | 1996-01-01 | 1999-01-01  | 153.37  | 8.5                 |
      | 61465.0   | 80461 | 08065 | 300.71 | 1985-01-01 | 2007-01-01  | 675.23  | 6.02                |
      | 67891.0   | 80448 | 08093 | 332.15 | 1970-01-01 | 1975-01-01  | 1004.54 | 6.8                 |
      | 51041.0   | 80219 | 08031 | 249.71 | 1991-01-01 | 2011-01-01  | 506.82  | 3.99                |
      | 61320.0   | 80449 | 08093 | 300.00 | 1981-01-01 | 1958-01-01  | 1214.7  | 6.0                 |
      | 40880.0   | 80219 | 08031 | 200.00 | 1991-01-01 | 2010-01-01  | 631.57  | 2.0                 |
      | 44588.0   | 81324 | 08033 | 218.14 | 1980-01-01 | 1985-01-01  | 1120.55 | 2.73                |
      | 37546.0   | 81089 | 08055 | 183.69 | 2000-01-01 | 2004-01-01  | 807.1   | 1.35                |
      | 27185.0   | 80446 | 08049 | 133.00 | 1982-01-01 | 2011-01-01  | 952.49  | 0.0                 |
      | 27185.0   | 81052 | 08099 | 133.00 | 1981-01-01 | 1983-01-01  | 1153.52 | 0.0                 |
      | 27185.0   | 80731 | 08095 | 133.00 | 1970-01-01 | 1973-01-01  | 1749.96 | 0.0                 |
      | 27185.0   | 81154 | 08105 | 133.00 | 1997-01-01 | 1998-01-01  | 904.76  | 0.0                 |

  @SLER-431 @SLER-432 @SLER-449 @SLER-450 @SLER-451 @SLER-468 @SLER-527 @SLER-605 @SLER-606
  Scenario Outline: Three Member Household
    Given I get APTC CALCULATOR base URL
    When I send the three member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL    | DOB        | DOB2        | DOB3        | APTC    | Contribution Amount |
      | 103301.0   | 80106 | 08039 | 400.08 | 1992-01-01 | 1998-01-01  | 2021-01-01  | 310.04  | 8.5                 |
      | 129100.0   | 81143 | 08109 | 500.00 | 1989-01-01 | 1989-01-01  | 2013-01-01  | 452.23  | 8.5                 |
      | 77687.0    | 80444 | 08019 | 300.88 | 1994-01-01 | 1994-01-01  | 2017-01-01  | 676.82  | 6.02                |
      | 88281.0    | 80920 | 08041 | 341.91 | 1990-01-01 | 2011-01-01  | 2013-01-01  | 457.34  | 7.05                |
      | 66783.0    | 80447 | 08049 | 258.65 | 1990-01-01 | 1991-01-01  | 2018-01-01  | 1194.95 | 4.35                |
      | 50793.0    | 81063 | 08025 | 196.72 | 2000-01-01 | 2003-01-01  | 2015-01-01  | 1094.35 | 1.87                |
      | 37741.0    | 80301 | 08013 | 146.17 | 2000-01-01 | 2001-01-01  | 2018-01-01  | 887.19  | 0.0                 |
      | 34341.0    | 81050 | 08089 | 133.00 | 1992-01-01 | 1993-01-01  | 2019-01-01  | 1333.21 | 0.0                 |
      | 34341.0    | 80758 | 08125 | 133.00 | 1988-01-01 | 2012-01-01  | 2013-01-01  | 1173.02 | 0.0                 |


  @SLER-433 @SLER-452 @SLER-469 @SLER-470 @SLER-509 @SLER-510 @SLER-607
  Scenario Outline: Four Member Household
    Given I get APTC CALCULATOR base URL
    When I send the four member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL    | DOB        | DOB2        | DOB3        | DOB4        | APTC    | Contribution Amount |
      | 125000.0   | 80440 | 08093 | 400.64 | 1962-01-01 | 1963-01-01  | 2001-01-01  | 2002-01-01  | 1821.93 | 8.5                 |
      | 117521.0   | 80813 | 08119 | 376.67 | 1961-01-01 | 1963-01-01  | 2001-01-01  | 2002-01-01  | 2016.36 | 7.92                |
      | 93600.0    | 80513 | 08069 | 300.00 | 1976-01-01 | 1971-01-01  | 2006-01-01  | 2011-01-01  | 1487.24 | 6.0                 |
      | 93600.0    | 80219 | 08031 | 300.00 | 1961-01-01 | 1966-01-01  | 2011-01-01  | 2016-01-01  | 1970.18 | 6.0                 |
      | 78000.0    | 80219 | 08031 | 250.00 | 1980-01-01 | 1991-01-01  | 2003-01-01  | 2017-01-01  | 1251.86 | 4.0                 |
      | 78000.0    | 80219 | 08031 | 250.00 | 1961-01-01 | 1965-01-01  | 2011-01-01  | 2016-01-01  | 2216.12 | 4.0                 |
      | 57689.0    | 81330 | 08083 | 184.90 | 1958-01-01 | 1958-01-01  | 1984-01-01  | 2005-01-01  | 3455.74 | 1.4                 |
      | 41496.0    | 81054 | 08011 | 133.00 | 1962-01-01 | 1963-01-01  | 2001-01-01  | 2002-01-01  | 3316.06 | 0.0                 |

  @SLER-434 @SLER-453 @SLER-471 @SLER-511 @SLER-608
  Scenario Outline: Five Member Household
    Given I get APTC CALCULATOR base URL
    When I send the five member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>", "<DOB5>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL    | DOB        | DOB2        | DOB3        | DOB4        | DOB5        | APTC    | Contribution Amount |
      | 182900.0   | 80444 | 08019 | 500.00 | 1977-01-01 | 1977-01-01  | 2009-01-01  | 2011-01-01  | 2013-01-01  | 662.38  | 8.5                 |
      | 146320.0   | 81432 | 08091 | 400.00 | 1991-01-01 | 1992-01-01  | 2016-01-01  | 2018-01-01  | 2020-01-01  | 1390.4  | 8.5                 |
      | 100171.0   | 80474 | 08047 | 273.84 | 1958-01-01 | 1965-01-01  | 2002-01-01  | 2003-01-01  | 2011-01-01  | 2520.12 | 4.95                |
      | 88385.0    | 80474 | 08047 | 241.62 | 1958-01-01 | 1965-01-01  | 2002-01-01  | 2003-01-01  | 2011-01-01  | 2663.7  | 3.66                |
      | 48651.0    | 81073 | 08009 | 133.00 | 1991-01-01 | 1993-01-01  | 2016-01-01  | 2020-01-01  | 2011-01-01  | 1988.37 | 0.0                 |

  @SLER-435 @SLER-454 @SLER-528 @SLER-609
  Scenario Outline: Six Member Household
    Given I get APTC CALCULATOR base URL
    When I send the six member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>", "<DOB5>", "<DOB6>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL     | DOB        | DOB2        | DOB3        | DOB4        | DOB5        | DOB6        | APTC    | Contribution Amount |
      | 189072.0   | 80132 | 08041 | 450.60  | 1991-01-01 | 1991-01-01  | 2013-01-01  | 2013-01-01  | 2013-01-01  | 2015-01-01  | 335.46  | 8.5                 |
      | 126048.0   | 81301 | 08067 | 300.40  | 1988-01-01 | 1989-01-01  | 2012-01-01  | 2012-01-01  | 2012-01-01  | 2015-01-01  | 1397.18 | 6.01                |
      | 78998.0    | 80822 | 08125 | 188.27  | 1961-01-01 | 1971-01-01  | 1996-01-01  | 2000-01-01  | 2003-01-01  | 2016-01-01  | 3722.97 | 1.53                |
      | 55807.0    | 80720 | 08121 | 133.00  | 1988-01-01 | 1991-01-01  | 2013-01-01  | 2013-01-01  | 2013-01-01  | 2015-01-01  | 2011.68 | 0.0                 |

  @SLER-436 @SLER-455 @SLER-610
  Scenario Outline: Seven Member Household
    Given I get APTC CALCULATOR base URL
    When I send the seven member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>", "<DOB5>", "<DOB6>", "<DOB7>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL     | DOB        | DOB2        | DOB3        | DOB4        | DOB5        | DOB6        | DOB7        | APTC    | Contribution Amount |
      | 284125.0   | 81611 | 08097 | 600.18  | 1971-01-01 | 1972-01-01  | 2009-01-01  | 2013-01-01  | 2013-01-01  | 2015-01-01  | 2017-01-01  | 1371.72 | 8.5                 |
      | 156340.0   | 81425 | 08085 | 330.25  | 1962-01-01 | 1963-01-01  | 1998-01-01  | 2000-01-01  | 2002-01-01  | 2004-01-01  | 2006-01-01  | 4697.3  | 6.76                |
      | 62962.0    | 81521 | 08077 | 133.00  | 1963-01-01 | 1965-01-01  | 1997-01-01  | 1999-01-01  | 2003-01-01  | 2005-01-01  | 2007-01-01  | 3734.8  | 0.0                 |

  @SLER-437 @SLER-456 @SLER-472 @SLER-512 @SLER-529 @SLER-531 @SLER-532 @SLER-611
  Scenario Outline: Eight Member Household
    Given I get APTC CALCULATOR base URL
    When I send the eight member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>", "<DOB5>", "<DOB6>", "<DOB7>", "<DOB8>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL     | DOB        | DOB2        | DOB3        | DOB4        | DOB5        | DOB6        | DOB7        | DOB8        | APTC    | Contribution Amount |
      | 229401.0   | 80302 | 08013 | 435.13  | 1986-01-01 | 1987-01-01  | 2015-01-01  | 2015-01-01  | 2015-01-01  | 2018-01-01  | 2018-01-01  | 2018-01-01  | 0       | 8.5                 |
      | 184562.0   | 80480 | 08057 | 350.08  | 1961-01-01 | 1962-01-01  | 1997-01-01  | 1997-01-01  | 1997-01-01  | 1999-01-01  | 1999-01-01  | 1999-01-01  | 5423.3  | 7.25                |
      | 131800.0   | 80480 | 08057 | 250.00  | 1958-01-01 | 1968-01-01  | 2002-01-01  | 2003-01-01  | 2005-01-01  | 2007-01-01  | 2009-01-01  | 2011-01-01  | 4978.42 | 4.0                 |
      | 129849.0   | 80822 | 08125 | 246.30  | 1958-01-01 | 1968-01-01  | 2002-01-01  | 2003-01-01  | 2005-01-01  | 2007-01-01  | 2009-01-01  | 2011-01-01  | 3896.82 | 3.85                |
      | 79080.0    | 80219 | 08031 | 150.00  | 1966-01-01 | 1971-01-01  | 2003-01-01  | 2003-01-01  | 2005-01-01  | 2006-01-01  | 2015-01-01  | 2017-01-01  | 3217.87 | 0.0                 |
      | 72754.0    | 81435 | 08113 | 138.00  | 1954-01-01 | 1961-01-01  | 1995-01-01  | 2004-01-01  | 2007-01-01  | 2009-01-01  | 2011-01-01  | 2013-01-01  | 5502.27 | 0.0                 |
      | 77377.0    | 81435 | 08113 | 146.77  | 1958-01-01 | 1961-01-01  | 1995-01-01  | 2003-01-01  | 2007-01-01  | 2009-01-01  | 2011-01-01  | 2013-01-01  | 5502.27 | 0.0                 |
      | 70118.0    | 81657 | 08037 | 133.00  | 1961-01-01 | 1962-01-01  | 1997-01-01  | 1997-01-01  | 1997-01-01  | 1999-01-01  | 1999-01-01  | 1999-01-01  | 5231.91 | 0.0                 |

  @SLER-438 @SLER-457 @SLER-612
  Scenario Outline: Nine Member Household
    Given I get APTC CALCULATOR base URL
    When I send the nine member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>", "<DOB5>", "<DOB6>", "<DOB7>", "<DOB8>", "<DOB9>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL     | DOB        | DOB2        | DOB3        | DOB4        | DOB5        | DOB6        | DOB7        | DOB8        | DOB9        | APTC    | Contribution Amount |
      | 234695.0   | 80504 | 08123 | 403.95  | 1976-01-01 | 1977-01-01  | 2011-01-01  | 2011-01-01  | 2011-01-01  | 2013-01-01  | 2013-01-01  | 2013-01-01  | 2013-01-01  | 324.18  | 8.5                 |
      | 224266.0   | 81321 | 08083 | 386.00  | 1976-01-01 | 1977-01-01  | 2000-01-01  | 2000-01-01  | 2000-01-01  | 2000-01-01  | 2013-01-01  | 2013-01-01  | 2013-01-01  | 2587.44 | 8.15                |
      | 77273.0    | 81648 | 08103 | 133.00  | 1976-01-01 | 1977-01-01  | 2000-01-01  | 2000-01-01  | 2000-01-01  | 2000-01-01  | 2013-01-01  | 2013-01-01  | 2013-01-01  | 3923.16 | 0.0                 |

  @SLER-458 @SLER-513
  Scenario Outline: Ten Member Household
    Given I get APTC CALCULATOR base URL
    When I send the ten member household's Information: "<Magi>", "<Zip>", "<Fips>", "<FPL>", "<DOB>", "<DOB2>", "<DOB3>", "<DOB4>", "<DOB5>", "<DOB6>", "<DOB7>", "<DOB8>", "<DOB9>", "<DOB10>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi       | Zip   | Fips  | FPL     | DOB        | DOB2        | DOB3        | DOB4        | DOB5        | DOB6        | DOB7        | DOB8        | DOB9        | DOB10       | APTC    | Contribution Amount |
      | 253920.0   | 81147 | 08007 | 400.00  | 1974-01-01 | 1974-01-01  | 1999-01-01  | 1999-01-01  | 1999-01-01  | 2000-01-01  | 2000-01-01  | 2000-01-01  | 2009-01-01  | 2009-01-01  | 3112.62 | 8.5                 |
      | 190440.0   | 81003 | 08101 | 300.00  | 1958-01-01 | 1961-01-01  | 1995-01-01  | 2005-01-01  | 2007-01-01  | 2009-01-01  | 2011-01-01  | 2013-01-01  | 2015-01-01  | 2020-01-01  | 2535.02 | 6.0                 |
      | 158700.0   | 81003 | 08101 | 250.00  | 1958-01-01 | 1961-01-01  | 1995-01-01  | 2005-01-01  | 2007-01-01  | 2009-01-01  | 2011-01-01  | 2013-01-01  | 2015-01-01  | 2020-01-01  | 2958.22 | 4.0                 |

  @SLER-465 @SLER-506
  Scenario Outline: Two Member Household with different zip codes
    Given I get APTC CALCULATOR base URL
    When I send the two member in different zip codes household's Information: "<Magi>", "<Zip>", "<Fips>", "<Zip2>", "<Fips2>", "<FPL>", "<DOB>", "<DOB2>"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "<APTC>" and "<Contribution Amount>"
    Examples:
      | Magi      | Zip   | Fips  | Zip2  | Fips2 | FPL    | DOB        | DOB2        | APTC    | Contribution Amount |
      | 56320.0   | 80234 | 08001 | 80219 | 08031 | 275.54 | 1980-01-01 | 2011-01-01  | 519.39  | 5.02                |
      | 51100.0   | 80801 | 08121 | 80219 | 08031 | 250.00 | 1980-01-01 | 2010-01-01  | 809.25  | 4.0                 |

  @SLER-681
  Scenario: Two Tax Housesholds. One with Two Members
    Given I get APTC CALCULATOR base URL
    When I send information for two tax households one with two members: Magi1:"111026.0", Magi2:"80042.0", Zip:"80480", Fips:"08057", FPL1:"430.00", FPL2:"310.0", DOB1:"1981-01-01", DOB2:"1983-01-01", DOB3:"1996-01-01"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "662.35, 178.69" and "8.5, 6.25"

  @SLER-682
  Scenario: Two Tax Households. One with Three Members. One with One Member That Does Not Qualify for APTC.
    Given I get APTC CALCULATOR base URL
    When I send information for two tax households one with three members and one with one no APTC Member: Magi1:"78000.0", Magi2:"0.0", Zip:"80513", Fips:"08069", FPL1:"250.0", FPL2:"0.0", DOB1:"1976-01-01", DOB2:"1971-01-01", DOB3:"2011-01-01", DOB4:"1986-01-01"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "1363.55, 0.0" and "4.0, 0.0"

  @SLER-683
  Scenario: Two Tax Households. One with Three Members. One with One Member.
    Given I get APTC CALCULATOR base URL
    When I send information for two tax households one with three members and one with one Member: Magi1:"78000.0", Magi2:"60840.0", Zip:"80513", Fips:"08069", FPL1:"250.0", FPL2:"195.0", DOB1:"1976-01-01", DOB2:"1971-01-01", DOB3:"2011-01-01", DOB4:"1986-01-01"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "1363.55, 353.57" and "4.0, 1.8"

  @SLER-684
  Scenario: Three Tax Households. One with Three Members. Two with One Member.
    Given I get APTC CALCULATOR base URL
    When I send information for three tax households one with three members and two with one Member: Magi1:"133517", Magi2:"59625.0", Magi3:"51212.0", Zip:"81144", Fips:"08105", FPL1:"365.0", FPL2:"163.0", FPL3:"140.0", DOB1:"1981-01-01", DOB2:"1983-01-01", DOB3:"2006-01-01", DOB4:"1958-01-01", DOB5:"1985-01-01"
    And I send the APTC Calculator Request
    Then status code should be 200
    And I expect "703.9, 1245.49, 541.59" and "7.63, 0.52, 0.0"