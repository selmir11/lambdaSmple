@SLER-154
Feature: checking Let's chat functionality on My Documents page

@SLER-154
  Scenario: search for Individual account in Admin Portal and go to My Documents page to validate chat widget
  Given I open the login page on the "admin" portal
  Then I login as Admin User
  And I validate I am on the "Admin dashboard" page
  Then I check box "coco" user type to search on Admin Portal dashboard
  Then I check box "individual" user type to search on Admin Portal dashboard
  And I enter specific "1101086728" account number
  Then I click search button on admin portal
  And I click acct in Search Results table on admin portal
  Then I click "On Behalf Of (OBO)" from application links dropdown
  Then I click link my docs on accountOverview page
  Then I validate chat widget is present
  And I open on chat widget
  Then I minimize the chat window

