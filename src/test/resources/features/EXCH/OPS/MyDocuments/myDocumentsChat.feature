@OPS @Exch @MyDocs
@SLER-154
Feature: checking Let's chat functionality on My Documents page

@SLER-154
  Scenario: search for Individual account in Admin Portal and go to My Documents page to validate chat widget
  Given I open the login page on the "login" portal
  And I validate I am on the "Login" page
  Then I login as "inibinzydimINI@test.com" and "ALaska12!" individual existing user
  Then I validate I am on the "Account Overview" page
  Then I click link my docs on accountOverview page
  Then I validate chat widget is present
  And I open on chat widget
  Then I minimize the chat window

