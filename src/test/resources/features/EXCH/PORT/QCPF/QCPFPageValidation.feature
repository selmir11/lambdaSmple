@port @portQCPF
Feature:  QCPF: page validation

@SLER-2010
  Scenario: QCPF: page validation

    Given I open the login page on the "QCPF" portal
    And I validate I am on the "QCPF" page
    Then I click get started on QCPF Page
    And I validate I am on the "QCPF Input Information" page
    Then I enter basic information Name "Joe" sex "Male" DOB "01/1991" in QCPF page
    And I enter location and coverage zipCode "80204" county "Denver" in QCPF page
    Then I click "No" for financial help question in QCPF page
    And I click continue button in QCPF page
    Then I validate I am on the "QCPF Preferences" page
    And I click this looks right button in QCPF page
    Then I validate I am on the "QCPF Preferences Doctor" page
    And I click continue button in QCPF page
    Then I validate I am on the "QCPF Preferences Medication" page
    And I click continue button in QCPF page
    Then I validate I am on the "QCPF List of Plans" page
    Then I click ok got it button in QCPF page
    Then I validate I am on the "QCPF Plan results" page
    Then I click view plan button in QCPF page
    Then I click choose plan button in QCPF page
    And I validate I am on the "QCPF Plan Next steps" page







