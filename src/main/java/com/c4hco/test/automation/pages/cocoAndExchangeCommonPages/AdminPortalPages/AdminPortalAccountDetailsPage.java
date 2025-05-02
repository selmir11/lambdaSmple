package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.AdminPortalPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class AdminPortalAccountDetailsPage {

    public BasicActions basicActions;
    SoftAssert softAssert = new SoftAssert();

    public AdminPortalAccountDetailsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(css = ".account-detail-row div")
    List<WebElement> accDetailsLabelAndValues;

    @FindBy(xpath = "//*[contains(@class, 'dashboardHeader1') and contains(text(), 'Primary Account Holder:')]")
    WebElement headerText;

    @FindBy(id = "btn-edit")
    WebElement EditFieldsButton;

    @FindBy(xpath = "//*[(@class='dashboardHeader2') and (contains(text(), 'Account ID'))]")
    WebElement accountIDText;

    @FindBy(xpath = "//*[@class='group-title']")
    WebElement accountDetailText;

    @FindBy(xpath = "//*[contains(text(),'For Primary Account Holder')]")
    WebElement primaryAcctHolderText;

    @FindBy(xpath = "//*[text()='Full Name:']")
    WebElement fullNameLabel;

    @FindBy(xpath = "//*[@id='individualDashboardCocoTitle']")
    WebElement CocoDashboardHeader;

    @FindBy(css = ".dashboardHeader2")
    WebElement labelAccountId;

    @FindBy(xpath = "//div[@class='account-table-label body-text-2 bold-text']")
    List<WebElement> labelAccountTableBodyText2;

    @FindBy(xpath = "//div[@class='account-table-field body-text-1']")
    List<WebElement> valuesAccountTableFieldsBodyText1;


    public void validatePrimaryMemDetails(){
        basicActions.waitForElementListToBePresent(accDetailsLabelAndValues, 10);
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        validateHeaderDetails(primaryMem);
        softAssert.assertEquals(accDetailsLabelAndValues.get(1).getText(), primaryMem.getCompleteFullName(), "name did not match");
        softAssert.assertEquals(accDetailsLabelAndValues.get(11).getText(), basicActions.changeDateFormat(primaryMem.getDob(), "MMddyyyy", "MM/dd/yyyy"), "DOB did not match!");
        softAssert.assertAll();
    }

    private void validateHeaderDetails(MemberDetails primaryMem){
        basicActions.waitForElementToBePresent(headerText, 10);
        softAssert.assertEquals(headerText.getText(), "Primary Account Holder: "+primaryMem.getSignature(), "Primary person's name from header did not match");
    }

    public void clickEditFieldsViaOBOButton(){
        basicActions.waitForElementToBePresent(EditFieldsButton, 30);
        EditFieldsButton.click();
    }

    public void validateAllDetailsOfPrimaryHolder() {

        basicActions.wait(10000);
        basicActions.refreshPage();
        basicActions.waitForElementListToBePresent(accDetailsLabelAndValues, 10);
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        validateHeaderDetails(primaryMem);
        validateAccountNumber(primaryMem);
        validateSubHeaderDetails();
        validateFullName(primaryMem);
        validateUserName(primaryMem);
        validateResAddress(primaryMem);
        validateMailingAddress(primaryMem);
        validateSSN(primaryMem);
        validateDOB(primaryMem);
        validateEmailAddress(primaryMem);
        validateHomeNumber(primaryMem);
        validateMobileNumber(primaryMem);
        validateContactMethod(primaryMem);
        validatePreferreddLanguage(primaryMem);
        softAssert.assertAll();
    }

    private void validatePreferreddLanguage(MemberDetails primaryMem) {
        softAssert.assertEquals(accDetailsLabelAndValues.get(20).getText(), "Preferred Written Language:", "Preferred Written Language: label did not match");
        softAssert.assertEquals(accDetailsLabelAndValues.get(21).getText(), primaryMem.getWrittenLanguage(), "Preferred Written Language: did not match");
    }

    private void validateContactMethod(MemberDetails primaryMem) {
        softAssert.assertEquals(accDetailsLabelAndValues.get(18).getText(), "Preferred Contact Method:", "Preferred Contact Method: label did not match");
        if(primaryMem.getContactPref() != null) {
            softAssert.assertEquals(accDetailsLabelAndValues.get(19).getText(),primaryMem.getContactPref(), "Preferred Contact Method: did not match");
        }
        else {
            softAssert.assertEquals(accDetailsLabelAndValues.get(19).getText(),"Email", "Preferred Contact Method: did not match");
        }
    }

    private void validateMobileNumber(MemberDetails primaryMem) {
        String MobileNumber = (primaryMem.getAlternatePhNum() != null ? primaryMem.getAlternatePhNum() : primaryMem.getPhoneNumber());
        String formatedMobileNumber = MobileNumber.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
        softAssert.assertEquals(accDetailsLabelAndValues.get(16).getText(), "Mobile Number:", "Mobile label did not match");
        softAssert.assertEquals(accDetailsLabelAndValues.get(17).getText(), formatedMobileNumber, "Mobile did not match");
    }

    private void validateHomeNumber(MemberDetails primaryMem) {
        String formatedPhoneNumber = primaryMem.getPhoneNumber().replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
        softAssert.assertEquals(accDetailsLabelAndValues.get(14).getText(), "Home Number:", "Username label did not match");
        softAssert.assertEquals(accDetailsLabelAndValues.get(15).getText(), formatedPhoneNumber, "Username did not match");
    }

    private void validateEmailAddress(MemberDetails primaryMem) {
        softAssert.assertEquals(accDetailsLabelAndValues.get(12).getText(), "Email Address:", "Email label did not match");
        softAssert.assertEquals(accDetailsLabelAndValues.get(13).getText(), primaryMem.getEmailId(), "Email did not match");
    }

    private void validateDOB(MemberDetails primaryMem) {
        softAssert.assertEquals(accDetailsLabelAndValues.get(10).getText(), "Date of Birth:", "DOB label did not match");
        softAssert.assertEquals(accDetailsLabelAndValues.get(11).getText(), basicActions.changeDateFormat(primaryMem.getDob(), "MMddyyyy", "MM/dd/yyyy"), "DOB did not match!");
    }

    private void validateSSN(MemberDetails primaryMem) {
        String fullSsn =primaryMem.getSsn();
        String lastFourSsn = fullSsn != null && fullSsn.length() >= 4 ? fullSsn.substring(fullSsn.length() - 4) : "";
        softAssert.assertEquals(accDetailsLabelAndValues.get(8).getText(), "Social Security Number:", "SSN label did not match");
        softAssert.assertEquals(accDetailsLabelAndValues.get(9).getText(), lastFourSsn, "SSN did not match");
    }

    private void validateMailingAddress(MemberDetails primaryMem) {
        String MailingAddrLine1 =  primaryMem.getMailingAddress().getAddressLine1();
        String MailingAddrCounty = primaryMem.getMailingAddress().getAddressCity();
        String MailingAddrState = primaryMem.getMailingAddress().getAddressState();
        String MailingAddrZipcode =  primaryMem.getMailingAddress().getAddressZipcode();
        String MailingAddress = MailingAddrLine1 +"\n"+MailingAddrCounty +", "+MailingAddrState +" "+MailingAddrZipcode ;
        softAssert.assertEquals(accDetailsLabelAndValues.get(6).getText(), "Mailing Address:", "Mailing  Address label did not match");
        softAssert.assertEquals(accDetailsLabelAndValues.get(7).getText(), MailingAddress, "Mailing  Address label did not match");
    }

    private void validateResAddress(MemberDetails primaryMem) {
        String AddressLine1 =  primaryMem.getResAddress().getAddressLine1();
        String AddressCounty = primaryMem.getResAddress().getAddressCity();
        String AddressState = primaryMem.getResAddress().getAddressState();
        String AddressZipcode =  primaryMem.getResAddress().getAddressZipcode();
        String ResAddress = AddressLine1 +"\n"+AddressCounty +", "+AddressState +" "+AddressZipcode ;
        softAssert.assertEquals(accDetailsLabelAndValues.get(4).getText(), "Residential Address:", "Residential Address label did not match");
        softAssert.assertEquals(accDetailsLabelAndValues.get(5).getText(), ResAddress, "Residential Address label did not match");
    }

    private void validateUserName(MemberDetails primaryMem) {
        softAssert.assertEquals(accDetailsLabelAndValues.get(2).getText(), "Username:", "Username label did not match");
        if(primaryMem.getIncorrectEmail() != null) {
            softAssert.assertEquals(accDetailsLabelAndValues.get(3).getText(),primaryMem.getIncorrectEmail(), "Preferred Contact Method: did not match");
        }
        else {
            softAssert.assertEquals(accDetailsLabelAndValues.get(3).getText(), primaryMem.getEmailId(), "Username did not match");
        }
    }

    private void validateFullName(MemberDetails primaryMem) {
        softAssert.assertEquals(accDetailsLabelAndValues.get(0).getText(), "Full Name:", "full name label did not match");
        softAssert.assertEquals(accDetailsLabelAndValues.get(1).getText(), primaryMem.getCompleteFullName(), "Full name did not match");
    }

    private void validateSubHeaderDetails() {
        softAssert.assertEquals(accountDetailText.getText(),"Account Details","Account detail header  did not match");
        softAssert.assertEquals(primaryAcctHolderText.getText(),"For Primary Account Holder","For Primary Account Holder text did not match");
    }

    private void validateAccountNumber(MemberDetails primaryMem) {
        String [] AccountID = accountIDText.getText().split(",");
        softAssert.assertEquals(AccountID[0], "Account ID: " +primaryMem.getAccount_id() + " ",  "Account did not match");
    }

    public void validateCocoDetailsOfPrimaryHolder() {
        basicActions.wait(10000);
        basicActions.refreshPage();
        basicActions.waitForElementListToBePresent(accDetailsLabelAndValues, 10);
        MemberDetails primaryMem = SharedData.getPrimaryMember();
        validateCocoHeaderDetails(primaryMem);
        validateCocoAccountNumber(primaryMem);

        validateSubHeaderDetails();
        validateFullName(primaryMem);
        validateUserName(primaryMem);
        validateResAddress(primaryMem);
        validateMailingAddress(primaryMem);
        validateSSN(primaryMem);
        validateDOB(primaryMem);
        validateEmailAddress(primaryMem);
        validateHomeNumber(primaryMem);
        validateMobileNumber(primaryMem);
        validateContactMethod(primaryMem);
        validatePreferreddLanguage(primaryMem);
        softAssert.assertAll();

    }

    private void validateCocoAccountNumber(MemberDetails primaryMem) {
        String [] AccountID = accountIDText.getText().split(",");
        softAssert.assertEquals(AccountID[0], "Account ID: " +primaryMem.getAccount_id() , "Account did not match");
    }

    private void validateCocoHeaderDetails(MemberDetails primaryMem){
        basicActions.waitForElementToBePresent(headerText, 10);
        softAssert.assertEquals(CocoDashboardHeader.getText() , "Colorado Connect" , "Coco header not match");
        softAssert.assertEquals(headerText.getText(), "Primary Account Holder: "+primaryMem.getSignature(), "Primary person's name from header did not match");
    }
    public void verifyFontColorFormatOfPrimaryAccountHolderLabel(){
        softAssert.assertEquals(headerText.getCssValue("font-family"), "\"PT Sans\"", "Primary account holder-font family mismatch");
        softAssert.assertEquals(headerText.getCssValue("font-size"), "36px", "Primary account holder-font size error");
        softAssert.assertEquals(headerText.getCssValue("color"), "rgba(77, 77, 79, 1)", "Primary account holder-Color mismatch");
        softAssert.assertAll();
    }
    public void verifyAccountIdDisplayedInAnyEnv(String staging,String qa){
        if (SharedData.getEnv().equals("staging")) {
            Assert.assertTrue(labelAccountId.getText().contains(staging),"Account Id not present in staging");
        } else {
            Assert.assertTrue(labelAccountId.getText().contains(qa),"Account Id not present in qa");
        }
    }
    public void verifyAccountTableLabelOfAccountDetailContainer(){
        for (WebElement element:labelAccountTableBodyText2){
            softAssert.assertEquals(element.getCssValue("font-family"), "\"PT Sans\"", element.getText()+"-font family mismatch");
            softAssert.assertEquals(element.getCssValue("font-size"), "15px", element.getText()+"-font size error");
            softAssert.assertEquals(element.getCssValue("font-weight"), "700", element.getText()+"-font weight mismatch");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(77, 77, 79, 1)", element.getText()+"-Color mismatch");
            softAssert.assertAll();
        }
    }
    public void verifyPrimaryAccountHolderNameInAccountDetailContainer(){
        Assert.assertEquals(valuesAccountTableFieldsBodyText1.get(0).getText().trim(),Arrays.stream(headerText.getText().split(":")).skip(1).toList().get(0).trim(),"Member name is not correct");
    }
    public void verifyAccountTableFieldValuesOfAccountDetailContainer(){
        for (WebElement element:valuesAccountTableFieldsBodyText1){
            softAssert.assertEquals(element.getCssValue("font-family"), "\"PT Sans\"", element.getText()+"-font family mismatch");
            softAssert.assertEquals(element.getCssValue("font-size"), "16px", element.getText()+"-font size error");
            softAssert.assertEquals(element.getCssValue("font-weight"), "400", element.getText()+"-font weight mismatch");
            softAssert.assertEquals(element.getCssValue("color"), "rgba(77, 77, 79, 1)", element.getText()+"-Color mismatch");
            softAssert.assertAll();
        }
    }
}
