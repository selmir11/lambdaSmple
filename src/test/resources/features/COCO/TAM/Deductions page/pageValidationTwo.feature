@TAM @pageValidation @TamCoCo @test
Feature: Tests related to the Deductions page

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
    And I select "No" employment option
    And I click continue on the Employment income page
    And I select None of these as additional income option
    And I select continue on the Additional Income CoCO page
    Then I validate I am on the "CoCo Deductions" page

  @SLCR-839 @SLCR-840 @test
  Scenario Outline: <TestNumber>  ELIG-Page Validation-Additional Member Deductions - <Language>
    And I change the language from header to "<Language>"
    And I verify the header for additional member on the CoCo Deductions page in "<Language>"
    Then I select "Alimony" as deduction option with "" amount at "<Frequency>" frequency
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | <AmtRequired>      | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Alimony" as deduction option with "60" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Alimony" as Deductions option with "0.60" amount at "5: Weekly" frequency CoCo page
    Then I select "None of these" as deductions option
    Then I select "Alimony" as deduction option with "-999,999,9.9@ A" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Alimony" as Deductions option with "60,999,999.99" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Alimony" in "<Language>"
    And I refresh the page
    Then I select "Alimony" as deduction option with "64.00" amount
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text           | fontSize | fontFamily            | fontWeight | color              |
      | <PleaseSelect> | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Alimony" as deduction option with "78.00" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Alimony" as Deductions option with "640,078.00" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Alimony" in "<Language>"
    Then I select "None of these" as deductions option

    Then I select "Domestic production" as deduction option with "" amount at "<Frequency>" frequency
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | <AmtRequired>      | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Domestic production" as deduction option with "60" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Domestic production" as Deductions option with "0.60" amount at "5: Weekly" frequency CoCo page
    Then I select "None of these" as deductions option
    Then I select "Domestic production" as deduction option with "-999,999,9.9@ A" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Domestic production" as Deductions option with "60,999,999.99" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Domestic production" in "<Language>"
    And I refresh the page
    Then I select "Domestic production" as deduction option with "64.00" amount
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text           | fontSize | fontFamily            | fontWeight | color              |
      | <PleaseSelect> | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Domestic production" as deduction option with "78.00" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Domestic production" as Deductions option with "640,078.00" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Domestic production" in "<Language>"
    Then I select "None of these" as deductions option

    Then I select "HSA" as deduction option with "" amount at "<Frequency>" frequency
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | <AmtRequired>      | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "HSA" as deduction option with "60" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "HSA" as Deductions option with "0.60" amount at "5: Weekly" frequency CoCo page
    Then I select "None of these" as deductions option
    Then I select "HSA" as deduction option with "-999,999,9.9@ A" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "HSA" as Deductions option with "60,999,999.99" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "HSA" in "<Language>"
    And I refresh the page
    Then I select "HSA" as deduction option with "64.00" amount
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text           | fontSize | fontFamily            | fontWeight | color              |
      | <PleaseSelect> | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "HSA" as deduction option with "78.00" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "HSA" as Deductions option with "640,078.00" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "HSA" in "<Language>"
    Then I select "None of these" as deductions option

    Then I select "Pre-tax retirement" as deduction option with "" amount at "<Frequency>" frequency
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | <AmtRequired>      | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Pre-tax retirement" as deduction option with "60" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Pre-tax retirement" as Deductions option with "0.60" amount at "5: Weekly" frequency CoCo page
    Then I select "None of these" as deductions option
    Then I select "Pre-tax retirement" as deduction option with "-999,999,9.9@ A" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Pre-tax retirement" as Deductions option with "60,999,999.99" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Pre-tax retirement" in "<Language>"
    And I refresh the page
    Then I select "Pre-tax retirement" as deduction option with "64.00" amount
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text           | fontSize | fontFamily            | fontWeight | color              |
      | <PleaseSelect> | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Pre-tax retirement" as deduction option with "78.00" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Pre-tax retirement" as Deductions option with "640,078.00" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Pre-tax retirement" in "<Language>"
    Then I select "None of these" as deductions option

    Then I select "School tuition" as deduction option with "" amount at "<Frequency>" frequency
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | <AmtRequired>      | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "School tuition" as deduction option with "60" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "School tuition" as Deductions option with "0.60" amount at "5: Weekly" frequency CoCo page
    Then I select "None of these" as deductions option
    Then I select "School tuition" as deduction option with "-999,999,9.9@ A" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "School tuition" as Deductions option with "60,999,999.99" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "School tuition" in "<Language>"
    And I refresh the page
    Then I select "School tuition" as deduction option with "64.00" amount
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text           | fontSize | fontFamily            | fontWeight | color              |
      | <PleaseSelect> | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "School tuition" as deduction option with "78.00" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "School tuition" as Deductions option with "640,078.00" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "School tuition" in "<Language>"
    Then I select "None of these" as deductions option

    Then I select "Self-employment tax" as deduction option with "" amount at "<Frequency>" frequency
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | <AmtRequired>      | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Self-employment tax" as deduction option with "60" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Self-employment tax" as Deductions option with "0.60" amount at "5: Weekly" frequency CoCo page
    Then I select "None of these" as deductions option
    Then I select "Self-employment tax" as deduction option with "-999,999,9.9@ A" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Self-employment tax" as Deductions option with "60,999,999.99" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Self-employment tax" in "<Language>"
    And I refresh the page
    Then I select "Self-employment tax" as deduction option with "64.00" amount
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text           | fontSize | fontFamily            | fontWeight | color              |
      | <PleaseSelect> | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Self-employment tax" as deduction option with "78.00" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Self-employment tax" as Deductions option with "640,078.00" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Self-employment tax" in "<Language>"
    Then I select "None of these" as deductions option

    Then I select "Student loan" as deduction option with "" amount at "<Frequency>" frequency
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | <AmtRequired>      | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Student loan" as deduction option with "60" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Student loan" as Deductions option with "0.60" amount at "5: Weekly" frequency CoCo page
    Then I select "None of these" as deductions option
    Then I select "Student loan" as deduction option with "-999,999,9.9@ A" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Student loan" as Deductions option with "60,999,999.99" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Student loan" in "<Language>"
    And I refresh the page
    Then I select "Student loan" as deduction option with "64.00" amount
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text           | fontSize | fontFamily            | fontWeight | color              |
      | <PleaseSelect> | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Student loan" as deduction option with "78.00" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Student loan" as Deductions option with "640,078.00" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Student loan" in "<Language>"
    Then I select "None of these" as deductions option

    Then I select "Self-employment health insurance" as deduction option with "" amount at "<Frequency>" frequency
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | <AmtRequired>      | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Self-employment health insurance" as deduction option with "60" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Self-employment health insurance" as Deductions option with "0.60" amount at "5: Weekly" frequency CoCo page
    Then I select "None of these" as deductions option
    Then I select "Self-employment health insurance" as deduction option with "-999,999,9.9@ A" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Self-employment health insurance" as Deductions option with "60,999,999.99" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Self-employment health insurance" in "<Language>"
    And I refresh the page
    Then I select "Self-employment health insurance" as deduction option with "64.00" amount
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text           | fontSize | fontFamily            | fontWeight | color              |
      | <PleaseSelect> | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Self-employment health insurance" as deduction option with "78.00" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Self-employment health insurance" as Deductions option with "640,078.00" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Self-employment health insurance" in "<Language>"
    Then I select "None of these" as deductions option

    Then I select "Self-employment retirement" as deduction option with "" amount at "<Frequency>" frequency
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | <AmtRequired>      | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Self-employment retirement" as deduction option with "60" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Self-employment retirement" as Deductions option with "0.60" amount at "5: Weekly" frequency CoCo page
    Then I select "None of these" as deductions option
    Then I select "Self-employment retirement" as deduction option with "-999,999,9.9@ A" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Self-employment retirement" as Deductions option with "60,999,999.99" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Self-employment retirement" in "<Language>"
    And I refresh the page
    Then I select "Self-employment retirement" as deduction option with "64.00" amount
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text           | fontSize | fontFamily            | fontWeight | color              |
      | <PleaseSelect> | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Self-employment retirement" as deduction option with "78.00" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Self-employment retirement" as Deductions option with "640,078.00" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Self-employment retirement" in "<Language>"
    Then I select "None of these" as deductions option

    Then I select "Moving expenses" as deduction option with "" amount at "<Frequency>" frequency
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text               | fontSize | fontFamily            | fontWeight | color              |
      | <AmtRequired>      | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Moving expenses" as deduction option with "60" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Moving expenses" as Deductions option with "0.60" amount at "5: Weekly" frequency CoCo page
    Then I select "None of these" as deductions option
    Then I select "Moving expenses" as deduction option with "-999,999,9.9@ A" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Moving expenses" as Deductions option with "60,999,999.99" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Moving expenses" in "<Language>"
    And I refresh the page
    Then I select "Moving expenses" as deduction option with "64.00" amount
    And I select continue on the Deductions CoCo page
    And I validate the error text with its properties and the error icon on the CoCo Deductions page
      | Text           | fontSize | fontFamily            | fontWeight | color              |
      | <PleaseSelect> | 14px     | "PT Sans", sans-serif | 400        | rgba(150, 0, 0, 1) |
    Then I select "None of these" as deductions option
    Then I select "Moving expenses" as deduction option with "78.00" amount at "<Frequency>" frequency
    Then I verify no errors show for Deductions options CoCo page
    Then I verify "Moving expenses" as Deductions option with "640,078.00" amount at "5: Weekly" frequency CoCo page
    Then I verify Deductions CoCo amount Minimum and Maximum for "Moving expenses" in "<Language>"
    Then I select "None of these" as deductions option

    And I click on Sign Out in the Header for "Elmo"
    Then I validate I am on the "Login" page

    Examples:
      |TestNumber|Language|Frequency   |AmtRequired                 |PleaseSelect                             |
      |SLCR-839  |English |Weekly      |Amount is required          |Please select one of the options below   |
      |SLCR-840  |Spanish |Semanalmente|Esta cantidad es obligatoria|Seleccione una de las siguientes opciones|
