package com.c4hco.test.automation.pages.exchPages;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
public class DocumentLookupPage {
    private BasicActions basicActions;

    SoftAssert softAssert = new SoftAssert();

    public DocumentLookupPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
 PageFactory.initElements(basicActions.getDriver(), this);
    }
    @FindBy(css = ".search-title")
    WebElement title;

    @FindBy(xpath = "//input[@value='advancedSearch']")
    WebElement advancedSearchradio;

    @FindBy(xpath = "//input[@value ='documentHandle']")
    WebElement documentHandleSearch;

    @FindBy(xpath = " //label[normalize-space()='Advanced Search']")
    WebElement advancedSearchlabel;

    @FindBy(xpath = "(//div[@class='drop-down-option drop-down-option-selected'])[1]")
    WebElement documentTypeDropdown;

    @FindBy(xpath = "//div[@class='drop-down-secondary-options']//span")
    List<WebElement> documentTypeDropdownOptions;

    @FindBy(id = "documentHandle")
    WebElement documentHandle;

    @FindBy(xpath = "//button[normalize-space()='Submit']")
    WebElement submitButton;

    @FindBy(xpath = "//td[normalize-space()='Document Name']")
    WebElement documentName;

    @FindBy(xpath = "//td[normalize-space()='Document type']")
    WebElement documentType;

    @FindBy(xpath = "//td[normalize-space()='Account ID']")
    WebElement accountID;
    @FindBy(xpath = "//td[normalize-space()='Document Display Name']")
    WebElement documentDisplayName;
    @FindBy(xpath = "//td[normalize-space()='Created Date']")
    WebElement createdDate;
    @FindBy(xpath = "//td[normalize-space()='Archived Date']")
    WebElement archivedDate;
    @FindBy(xpath = "//td[normalize-space()='File Format']")
    WebElement fileFormat;

    @FindBy(css = "span[placement='top']")
    WebElement documentfiletxt;

    @FindBy(xpath = "//span[normalize-space()='1095A Dispute']")
    WebElement documentDisplayTxt;

    @FindBy(xpath = "//tbody/tr[1]/td[3]/a[1]")
    WebElement accountNo;

    @FindBy(css = "a[placement='top']")
    WebElement documentDisplayNameTxt;

    @FindBy(xpath = "//app-document-lookup//table/tbody/tr/td[5]")
    WebElement txtCreateDate;

    @FindBy(xpath = "//tbody//tr//td[6]")
    WebElement txtArchivedDate;

    @FindBy(xpath = "//tbody//tr//td[7]")
    WebElement txtFileFormat;

    @FindBy(xpath = "//div[@class='drop-down-secondary-options']//span")
    List<WebElement> sortOption;

    @FindBy(xpath = "(//div[@class='drop-down-option drop-down-option-selected'])[3]")
    WebElement sortDropdown;

    @FindBy(xpath = "//tbody/tr/td[2]")
    List <WebElement> documentTypecolumn;

    @FindBy(xpath = "//tbody/tr/td[5]")
    List <WebElement> createdDatecolumn;

    @FindBy(xpath = "//input[@id='searchFrom']")
    WebElement fromDate;

    @FindBy(xpath = "//input[@id='searchTo']")
    WebElement ToDate;

    public void validateTitle() {
        basicActions.switchtoactiveTab();
        softAssert.assertTrue(basicActions.waitForElementToBePresent(title, 10));
        softAssert.assertEquals(title.getText(), "Document Lookup Tool");
        softAssert.assertAll();
    }

    public void selectAdvancedSearch() {
        softAssert.assertTrue(basicActions.waitForElementToBeClickable(advancedSearchradio, 15));
        advancedSearchradio.click();
        softAssert.assertEquals(advancedSearchlabel.getText(), "Advanced Search");
        softAssert.assertAll();
    }

    public void clickdropdown() {
        documentTypeDropdown.click();
    }

    public void searchDocumentHandle() {
        documentHandleSearch.click();
        basicActions.waitForElementToBePresent(documentHandle, 50);
        if (SharedData.getEnv().equals("qa"))
            documentHandle.sendKeys("90159");
        else{
            documentHandle.sendKeys("55510");
        }
        submitButton.click();
    }

    public void verifyAdminTableColumns() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(documentName, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(documentType, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(accountID, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(documentDisplayName, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(createdDate, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(archivedDate, 10));
        softAssert.assertTrue(basicActions.waitForElementToBePresent(fileFormat, 10));
        softAssert.assertAll();
    }

    public void verifycontent() {
        softAssert.assertTrue(basicActions.waitForElementToBePresent(documentfiletxt, 10));
        softAssert.assertEquals(documentfiletxt.getText(), "IND_1095A Dispu..");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(documentDisplayTxt, 10));
        softAssert.assertEquals(documentDisplayTxt.getText(), "1095A Dispute");
        softAssert.assertTrue(basicActions.waitForElementToBePresent(accountNo, 20));
        if (SharedData.getEnv().equals("staging")) {
            softAssert.assertEquals(accountNo.getText(), "1907010548");
            softAssert.assertEquals(documentDisplayNameTxt.getText(), "Correction Requ..");
            softAssert.assertEquals(txtCreateDate.getText(), "10/26/2020 15:47:56");
            softAssert.assertEquals(txtArchivedDate.getText(), "10/26/2020 15:47:56");
            softAssert.assertEquals(txtFileFormat.getText(), "DOCX");
            softAssert.assertAll();
        } else {
            softAssert.assertEquals(accountNo.getText(), "2719004301");
            softAssert.assertEquals(documentDisplayNameTxt.getText(), "Correction Proo..");
            softAssert.assertEquals(txtCreateDate.getText(), "10/07/2020 14:04:03");
            softAssert.assertEquals(txtArchivedDate.getText(), "10/07/2020 14:04:02");
            softAssert.assertEquals(txtArchivedDate.getText(), "10/07/2020 14:04:02");
            softAssert.assertEquals(txtFileFormat.getText(), "PNG");
            softAssert.assertAll();
        }
    }

    public void selectoption(String text){
        basicActions.selectValueFromDropdown(documentTypeDropdown,documentTypeDropdownOptions,text);
    }

    public void selectsortoption(String text) {
        basicActions.selectValueFromDropdown(sortDropdown,sortOption,text);
    }

   public void clickSubmit(){
       softAssert.assertTrue(basicActions.waitForElementToBeClickable(submitButton, 20));
       submitButton.click();
       softAssert.assertAll();
   }

   public void inputdates(){
        softAssert.assertTrue(basicActions.waitForElementToBePresent(fromDate,20));
        fromDate.sendKeys("03/01/2024");
       softAssert.assertTrue(basicActions.waitForElementToBePresent(ToDate,20));
       ToDate.sendKeys("05/01/2024");
       softAssert.assertAll();
    }
    public void verifysortoptionsasc(List<WebElement> options) {
        List<String> OriginalList = options.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> NewList = OriginalList.stream().sorted().collect(Collectors.toList());
        softAssert.assertEquals(NewList, OriginalList);
        softAssert.assertAll();
    }
    public void verifysortoptionsdesc(List<WebElement> options) {
        List<String> OriginalList = options.stream().map(WebElement::getText).collect(Collectors.toList());
        List<String> NewList = OriginalList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        softAssert.assertEquals(NewList, OriginalList);
        softAssert.assertAll();
    }
        public void verifySortasc (String sortbyoptions){
        clickSubmit();
        basicActions.wait(10);
            switch (sortbyoptions){
                case "Document Type":
                  verifysortoptionsasc(documentTypecolumn);
                    break;
                case "Created Date":
                   verifysortoptionsasc(createdDatecolumn);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid sort option: " +sortbyoptions );
            }
    }

    public void verifysortdesc(String sortbyoptions){
          clickSubmit();
        switch (sortbyoptions){
            case "Document Type":
              verifysortoptionsdesc(documentTypecolumn);
                break;
            case "Created Date":
              verifysortoptionsdesc(createdDatecolumn);
                break;
            default:
                throw new IllegalArgumentException("Invalid sort option: " +sortbyoptions );
        }
    }

    public void verifysort(String ascdescoptions,String sortbyoptions){
        switch(ascdescoptions) {
            case "asc":
                verifySortasc(sortbyoptions);
                break;
            case "desc":
                verifysortdesc(sortbyoptions);
                break;
            default:
                throw new IllegalArgumentException("Invalid sort option: " +ascdescoptions );

        }
    }
    public void clickDropdowns() {
        String Options[] = {"Exchange", "Individual", "SHOP", "Broker", "Navigator", "Carrier", "Appeal"};

        for (String option : Options) {
            basicActions.selectValueFromDropdown(documentTypeDropdown, documentTypeDropdownOptions, option);
            String selectedOptionText = documentTypeDropdown.getText();
            softAssert.assertTrue(selectedOptionText.equals(option));
            softAssert.assertAll();
        }
    }
}
