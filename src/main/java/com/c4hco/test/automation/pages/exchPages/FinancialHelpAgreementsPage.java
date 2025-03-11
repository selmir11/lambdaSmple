package com.c4hco.test.automation.pages.exchPages;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class FinancialHelpAgreementsPage {

    private BasicActions basicActions;

    public FinancialHelpAgreementsPage (WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(),  this);
    }

    @FindBy(id ="SOL-FinHelpAgreements-Continue")
    WebElement continueButton;
    @FindBy(id ="SOL-FinHelpAgreements-GoBack")
    WebElement goBackButton;
    @FindBy(id = "SOL-FinHelpAgreements-ElectronicSignatureLegalEffect")
    WebElement signatureInput;
    @FindBy(xpath = "(//input[@id='SOL-FinHelpAgreements-ElectronicSignatureLegalEffect'])[2]")
    WebElement signatureForSecondTaxPayer;
    @FindBy(xpath = "(//input[@id='SOL-FinHelpAgreements-ElectronicSignatureLegalEffect'])[3]")
    WebElement signatureForThirdTaxPayer;
    @FindBy(css="mat-checkbox input")
    WebElement termsAndAgreeChkbx;
    @FindBy(css="mat-checkbox input")
    List<WebElement> agreementsChckbx;
    @FindBy(css = "lib-loader .loader-overlay #loader-icon")
    WebElement spinner;
    @FindBy(id="SOL-FinHelpAgreements-HaveReadTermsAgree")
    WebElement understandAcknowledgeChckbx;
    @FindBy(id="SOL-FinHelpAgreements-SignatureLegality")
    WebElement understandSigChckbx;
    @FindBy(id="SOL-FinHelpAgreements-HouseholdAuthority")
    WebElement understandAuthorityChckbx;
    @FindBy(id="SOL-FinHelpAgreements-Title")
    WebElement financialagrePageTitle;
    @FindBy(id="SOL-FinHelpAgreements-UnderstandCreditHealthCoverage")
    WebElement financialagrePagePara1;
    @FindBy(id="SOL-FinHelpAgreements-TaxRequirements")
    WebElement financialagrePageTaxRequirements;
    @FindBy(id="SOL-FinHelpAgreements-FederalIncomeForTaxYear")
    WebElement financialagrePageTaxRequirementsPoint1;
    @FindBy(id="SOL-FinHelpAgreements-MarriedIncomeTaxSpouse")
    WebElement financialagrePageTaxRequirementsPoint2;
    @FindBy(id="SOL-FinHelpAgreements-FederalIncomeReturn")
    WebElement financialagrePageTaxRequirementsPoint3;
    @FindBy(id="SOL-FinHelpAgreements-ExemptionDeduction")
    WebElement financialagrePageTaxRequirementsPoint4;
    @FindBy(id="SOL-FinHelpAgreements-ExemptionDeduction-Enrolled")
    WebElement financialagrePageTaxRequirementsPoint5;
    @FindBy(id="SOL-FinHelpAgreements-ExemptionDeduction-APTC")
    WebElement financialagrePageTaxRequirementsPoint6;
    @FindBy(id="SOL-FinHelpAgreements-AlsoUnderstandThat")
    WebElement financialagrePageReportingChange;
    @FindBy(id="SOL-FinHelpAgreements-ReceiveAdvancePremiumTax")
    WebElement financialagrePageReportingChangePara1;
    @FindBy(id="SOL-FinHelpAgreements-IRSReview")
    WebElement financialagrePageIRSIncomeReview;
    @FindBy(id="SOL-FinHelpAgreements-IRSIncomeCompare")
    WebElement financialagrePageIRSIncomeReviewPoint1;
    @FindBy(id="SOL-FinHelpAgreements-IRSIncomeLower")
    WebElement financialagrePageIRSIncomeReviewPoint2;
    @FindBy(id="SOL-FinHelpAgreements-IRSIncomeHigher")
    WebElement financialagrePageIRSIncomeReviewPoint3;
    @FindBy(xpath ="//*[@class='control-label']/b")
    List<WebElement> textControlLabel;
    @FindBy(id="SOL-FinHelpAgreements-HaveReadTermsAgree")
    List<WebElement> textLabelCheckBox1;
    @FindBy(id="SOL-FinHelpAgreements-SignatureLegality")
    List<WebElement> textLabelCheckBox2;
    @FindBy(id="SOL-FinHelpAgreements-HouseholdAuthority")
    List<WebElement> textLabelCheckBox3;


    SoftAssert softAssert = new SoftAssert();



    public void enterSignature(){
        basicActions.waitForElementToBeClickable(signatureInput, 10);
        signatureInput.sendKeys(SharedData.getPrimaryMember().getSignature());
    }

    public void enterTaxPayersSignature(String taxHolder){
        String memberSignature;
        switch (taxHolder) {
            case "taxHolder1":
                 memberSignature = "(//div[1]/div[4]/span)";
                String signatureFirstMember = basicActions.getDriver().findElement(By.xpath(memberSignature)).getText();
                signatureInput.click();
                signatureInput.sendKeys(signatureFirstMember);
                break;
            case "taxHolder2":
                 memberSignature = "(//div[1]/div[5]/span)";
                String signatureSecondMember = basicActions.getDriver().findElement(By.xpath(memberSignature)).getText();
                signatureForSecondTaxPayer.click();
                signatureForSecondTaxPayer.sendKeys(signatureSecondMember);
                break;
            case "taxHolder3":
                memberSignature = "(//div[1]/div[6]/span)";
                String signatureThirdMember = basicActions.getDriver().findElement(By.xpath(memberSignature)).getText();
                signatureForThirdTaxPayer.click();
                signatureForThirdTaxPayer.sendKeys(signatureThirdMember);
                break;

            default:
                throw new IllegalArgumentException("Invalid option: ");
        }

    }

    public void selectTermsAgreementsCheckbox(){
        basicActions.waitForElementToBePresent(termsAndAgreeChkbx, 20);
            basicActions.waitForElementToDisappear( spinner, 15 );
            basicActions.waitForElementListToBePresentWithRetries(agreementsChckbx, 10);
            understandAcknowledgeChckbx.click();
            understandSigChckbx.click();
            understandAuthorityChckbx.click();
        }

    public void clickContinue() {
        basicActions.waitForElementToBeClickable(continueButton, 5);
        basicActions.scrollToElement(continueButton);
        continueButton.click();

    }

    public void verifyFinancialAgreementPageVerbiage() {
        basicActions.waitForElementToBePresent(financialagrePageTitle, 10);
        softAssert.assertEquals(financialagrePageTitle.getText(), "Financial Agreements");
        softAssert.assertEquals(financialagrePagePara1.getText(), "I understand that if my monthly payments are reduced by Advance Premium Tax Credits (APTC), which are paid on my behalf to lower the cost of coverage for myself and/or my dependents, I must follow these requirements:");
        softAssert.assertEquals(financialagrePageTaxRequirements.getText(), "Tax Filing Requirements");
        softAssert.assertEquals(financialagrePageTaxRequirementsPoint1.getText(), "I will file a federal income tax return in 2026 for the 2025 tax year.");
        softAssert.assertEquals(financialagrePageTaxRequirementsPoint2.getText(), "If I am married at the end of 2025, I will file a joint income tax return with my spouse unless I qualify for an exceptional circumstance, such as domestic abuse or spousal abandonment.");
        softAssert.assertEquals(financialagrePageTaxRequirementsPoint3.getText(), "No one else will be able to claim me as a dependent on their 2025 federal income tax return.");
        softAssert.assertEquals(financialagrePageTaxRequirementsPoint4.getText(), "I will include all individuals listed as family members on this application on my 2025 federal income tax return if they:\n" +
                "Are enrolled in a Connect for Health Colorado plan.\n" +
                "And their monthly payments are partially or fully covered by Advance Premium Tax Credits.");
        softAssert.assertEquals(financialagrePageTaxRequirementsPoint5.getText(), "Are enrolled in a Connect for Health Colorado plan.");
        softAssert.assertEquals(financialagrePageTaxRequirementsPoint6.getText(), "And their monthly payments are partially or fully covered by Advance Premium Tax Credits.");
        softAssert.assertEquals(financialagrePageReportingChange.getText(), "Reporting Changes");
        softAssert.assertEquals(financialagrePageReportingChangePara1.getText(), "I am required to report any changes to my household or income as soon as they occur, as these changes may affect my eligibility for Advance Premium Tax Credits");
        softAssert.assertEquals(financialagrePageIRSIncomeReview.getText(), "IRS Income Review");
        softAssert.assertEquals(financialagrePageIRSIncomeReviewPoint1.getText(), "When I file my 2025 federal income tax return, the Internal Revenue Service (IRS) will compare the income reported on my tax return to the income on my application.\n" +
                "If the income is lower than what I reported, I may be eligible to receive additional tax credits.\n" +
                "If the income is higher than what I reported, I may owe additional federal income taxes");
        softAssert.assertEquals(financialagrePageIRSIncomeReviewPoint2.getText(), "If the income is lower than what I reported, I may be eligible to receive additional tax credits.");
        softAssert.assertEquals(financialagrePageIRSIncomeReviewPoint3.getText(), "If the income is higher than what I reported, I may owe additional federal income taxes");
        softAssert.assertEquals(textLabelCheckBox1.get(0).getText(), "I understand and agree. My signature represents this acknowledgment.");
        softAssert.assertEquals(textLabelCheckBox2.get(0).getText(), "I understand that my electronic signature has the same legal effect and can be enforced in the same way as a written signature.");
        softAssert.assertEquals(textLabelCheckBox3.get(0).getText(), "I have the authority to sign on behalf of all the people listed in my tax household.");

        softAssert.assertEquals(goBackButton.getText(), "Go back");
        softAssert.assertEquals(continueButton.getText(), "Continue");
        softAssert.assertAll();
    }
}
