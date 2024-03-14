# new feature
# Tags: optional

Feature: checking Let's chat functionality on My Documents page

@SLCR-45-WIP
  Scenario: search for CoCo account and go to My Documents page to validate chat widget
  Given I open the login page on the "admin" portal
  Then I login as Admin User
  And I validate I am on the "Admin dashboard" page
  Then I check "cocoIndividual" user type to search on Admin Portal dashboard


   # Then I click "search"
   # Then I validate chat widget is present
   # And I open on chat widget
   # Then I minimize the chat window