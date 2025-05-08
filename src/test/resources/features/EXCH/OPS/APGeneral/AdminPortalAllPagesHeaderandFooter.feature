@APGeneral
Feature: Verify Header, Footer on all pages in admin portal user

  @SLER-2386
  Scenario:SLER-2386:OPS: verify  Header, footer, and application links [RT-1096]
    Given I open the login page on the "admin" portal
    And I refresh the page
    And I validate I am on the "Login" page
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    And I validate I am on the "Admin search" page
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I search for the "individual" title
    Then I validate "Logo" and style properties
       | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I click "userDropdown" arrow on admin portal
    Then I logout from Admin Portal
    And I refresh the page
    Then I validate "TitleTextValidate" for Admin Portal
    Given I open the login page on the "admin" portal
    When I login as Admin User any environment "adminPortalADUser_UN_STG" password "adminPortalADUser_PW_STG" and "adminPortalADUser_UN_QA" password "adminPortalADUser_PW_QA"
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  Okta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    #Individual search
    And I select "individual" checkbox on Admin Portal Dashboard
    Then I enter an "accountID" in any env "4006112196" "6103530786" to search user
    Then I click on Search button in AP dashboard page
    Then I select the first record from the search results
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  On Behalf Of (OBO)\nOkta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
      And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    #Manage Plans
    Then I click on manage plan button on admin portal Individual dashboard
    And I validate I am on the "Manage Plans" page
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  On Behalf Of (OBO)\nOkta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    #Manage Account Access
    Then I close current tab and switch back to previous tab
    And I click "Manage Account Access" from account summary container
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  On Behalf Of (OBO)\nOkta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    #Manage Account Details
    Then I close current tab and switch back to previous tab
    Then I click on manage account details button on admin portal Individual dashboard
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  On Behalf Of (OBO)\nOkta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
      #EDI Transactions
    Then I close current tab and switch back to previous tab
    Then I click on view button for "EDI Transactions" report
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  On Behalf Of (OBO)\nOkta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
      #Exclusion Reason
    Then I close current tab and switch back to previous tab
    Then I click on view button for "Exclusion Reason" report
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  On Behalf Of (OBO)\nOkta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    #Detailed EDI
    Then I close current tab and switch back to previous tab
    Then I click on view button for "Detailed EDI" report
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  On Behalf Of (OBO)\nOkta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    #Account Activity
    Then I close current tab and switch back to previous tab
    Then I click on view button for "Account Activity" report
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  On Behalf Of (OBO)\nOkta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    #Detailed Eligibility
    Then I close current tab and switch back to previous tab
    And I click View Detailed Eligibility button on Individual dashboard
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  On Behalf Of (OBO)\nOkta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    # Broker
    Then I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I select "Broker" checkbox on Admin Portal Dashboard
    Then I search for the "Broker" title
    Then I enter an "accountID" in any env "2518005561" "7670732006" to search user
    Then I click on Search button in AP dashboard page
    And I select the first broker record from the search results
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  Okta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    # Broker - View Report
    Then I click "View Report" on Account Summary container AP Broker dashboard page
    Then I switch to the tab number 1
    And I validate Account Activity title row
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  Okta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    #Program Manager
    Then I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    And I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I search for the "Program Manager" title
    Then I enter an "accountID" in any env "9006664025" "3558300720" to search user
    Then I click on Search button in AP dashboard page
    And I click acct first row from Search Results table in admin portal
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  Okta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    # Program Manager Account Activity - View Report
    Then I click "View Report" on Account Summary container AP Broker dashboard page
    Then I switch to the tab number 1
    And I validate Account Activity title row
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  Okta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    #Program manager Account create
    Then I close current tab and switch back to previous tab
    Then I click Go Back on admin portal broker dashboard
    Then I select "Program Manager" checkbox on Admin Portal Dashboard
    Then I click create account on admin portal
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  Okta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    #Agency
    Then I go to the previous browser page
    And I select "Agency" checkbox on Admin Portal Dashboard
    Then I search for the "Agency" title
    Then I enter an "StateLicenseNumber" in any env "1234567890" "1234567890" to search user
    Then I click on Search button in AP dashboard page
    And I select the first broker record from the search results
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  Okta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    #CBMS Case ID Search
    Then I click Go Back on admin portal broker dashboard
    And I click "CBMS Case ID Search" from application links dropdown
    Then I switch to the tab number 1
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  Okta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    # Document Lookup
    Then I close current tab and switch back to previous tab
    And I click "Document Lookup" from application links dropdown
    Then I switch to the tab number 1
    Then I validate "Logo" and style properties
      | property              |   value |
      | text                  | Connect for Health Colorado |
      | text-align            | start               |
    Then I validate "Admin Portal" and style properties
      | property              |   value |
      | text                  | Admin Portal|
      | background-color      | rgba(0, 0, 0, 0)  |
      | text-align            | start               |
    Then I validate "FirstName Display" and style properties
      | property              |   value |
      | text                  | Hello, C4test |
      | text-align            | start               |
    Then I validate "UserDropdown" and style properties
      | property              |   value |
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(206, 205, 205, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | start               |
      | text                  | Account Information\nLogout|
    Then I validate "applicationDropDown" and style properties
      | property              |   value |
      | text                  |  Okta Console\nCBMS Case ID Search\nDocument Lookup\nAdmin LCE\nAP Account Creation|
      | background-color      | rgba(255, 255, 255, 1)  |
      | border-top-color      | rgba(255, 255, 255, 1)  |
      | border-bottom-color   | rgba(206, 205, 205, 1)  |
      | border-left-color     | rgba(206, 205, 205, 1)  |
      | border-right-color    | rgba(206, 205, 205, 1)  |
      | text-align            | left               |
    Then I click "applicationDropDown" arrow on admin portal
    And I click "Okta Console" from application links dropdown
    And I validate I am on the "Okta Console" page and close tab
    And I click "Admin LCE" from application links dropdown
    And I validate I am on the "Admin LCE" page and close tab
    And I click on Privacy Policy in the "Admin Portal" Footer
    And I validate I am on the "Privacy Policy" page and close tab
    And I click on Terms Of Use in the "Admin Portal" Footer
    And I validate I am on the "Terms Of Use" page and close tab
    And I click on Contact Us in the "Admin Portal" Footer
    And I validate I am on the "Contact Us" page and close tab
    Then I verify Copy Rights text in the Header or in the Footer
    Then I close current tab and switch back to previous tab
    Then I logout from Admin Portal