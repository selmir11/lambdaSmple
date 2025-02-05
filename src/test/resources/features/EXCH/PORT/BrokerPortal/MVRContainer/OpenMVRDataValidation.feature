@port  @MVRContainer
Feature: Open MVR container data in Broker Portal

  Background:
    Given I open the login page on the "broker" portal
    Then I validate I am on the "Login" page
    When I open the login page on the "broker" portal
    And I login as Broker User any environment "C4PortTesting+mvrStg@outlook.com" password "ALaska12!" and "C4PortTesting+mvrTypes@outlook.com" password "ALaska12!"
    Then I open outlook Tab
    And I sign in to outlook with Valid Credentials "C4PortTesting@outlook.com" and "ALaska12!"
    Then I open the MFA notice
    And I get the MFA code
    And I delete the open notice
    Then I sign out of Outlook
    Then I enter the MFA code and click Verify
    And  I validate I am on the "Agency Dashboard" page
@SLER-2089
  Scenario Outline:Member has an open Income MVR
    Then I validate the MVR container text in the dashboard Page
    Then I search for STG "<STGClient>" QA "<QAClient>" in search mvr container
    And I validate the MVR Type "<MVRType>" and action Type "<ActionButton>"
    And I clear the MVR search box in broker dashboard page
    Then I click on broker userName and logout

Examples:
  | STGClient     | QAClient   | MVRType                       | ActionButton |
  | tryblzjrvj    | Mertie     | Income                        | Verify Info  |
  | Primarybfxsyw | Sandra     | American Indian/Alaska Native | Upload Doc   |
  | Sonxfypgufv   | czvtav     | Citizenship                   | Upload Doc   |
  | yakxnjdeq     | scsgtgrl   | Lawful Presence               | Upload Doc   |
  | Sonxfypgufv   | czvtav     | SSN                           | Upload Doc   |
  | OPENINCARMVR  | cccobixaqu | Incarceration                 | Upload Doc   |
  | OPENDEATHMVR  | Mertie     | Proof of Life                 | Upload Doc   |
  | Pecoy         | Joe        | Peace Corps                   | Upload Doc   |
  | Mediy         | Joe        | Medicare                      | Upload Doc   |
  | Vhpcy         | Joe        | VA                            | Upload Doc   |
  | Triy          | Joe        | TRICARE                       | Upload Doc   |





