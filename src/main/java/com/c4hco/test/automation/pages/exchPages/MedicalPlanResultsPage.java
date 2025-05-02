package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class MedicalPlanResultsPage {
    private BasicActions basicActions;
     Optional<Integer> optionalInt;
    SoftAssert softAssert = new SoftAssert();

    public MedicalPlanResultsPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='PlanResults-SelectThisPlan_1']")
    WebElement selectFirstPlan;

    @FindBy(id = "PlanResults-SelectThisPlan_1")
    WebElement firstMedicalPlanName;

    @FindBy(xpath = "//*[@id='MedicalPlanResults-Continue']")
    public WebElement continueBtn;

    @FindBy(id = "PlanResults-ComparePlans")
    WebElement clickCompare;

    @FindBy (id = "MedicalPlanResults-SaveAndExit")
    WebElement btnSaveExit;

    @FindBy (id = "MedicalPlanResults-GoBack")
    WebElement btnGoBack;

    @FindBy (id="MedicalPlanResults-Skip")
    WebElement btnSkip;

    @FindBy(id = "PlanResults-PlanCompareCheckbox_1")
    WebElement firstCompareBox;

    @FindBy(id = "PlanResults-PlanCompareCheckbox_2")
    WebElement secondCompareBox;

    @FindBy(id = "PlanResults-PlanCompareCheckbox_3")
    WebElement thirdCompareBox;

    @FindBy(id = "PlanResults-PlanCompareCheckbox_4")
    WebElement fourthCompareBox;

    @FindBy(xpath = "//*[@class = 'container-fluid']")
    WebElement compareWarningText;

    @FindBy(id = "MedicalPlanResults-Okay")
    WebElement compareWarningOKbutton;

    @FindBy(css = "#PlanResults-InsuranceCompany")
    WebElement insuranceCompanyDropdown;

    @FindBy(id = "PlanResults-ResetFilters")
    WebElement filterResetButton;

    @FindBy(id = "PlanResults-MetalTier")
    WebElement metalTierDropdown;

    @FindBy(id = "PlanResults-HSAFilter")
    WebElement hsaDropdown;
    @FindBy(css = ".header-1")
    WebElement medicalplanheader;

    @FindBy(xpath =  "//*[@id = 'PlanResults-HSAFilter-input']")
    WebElement hsaOption;

    @FindBy(id = "PlanResults-CoOptionPlans")
    WebElement coloradoOptionDropdown;

    @FindBy(css = ".mdc-checkbox #PlanResults-CoOptionPlans-input")
    WebElement coloradoOptionSelection;

    @FindBy(css = ".c4-type-header-sm")
    List<WebElement> medicalPlanNamesList;

    @FindBy(css = "pagination-template .pagination-next a")
    WebElement nextPageArrow;

    @FindBy(css = ".plan-results-container .responsive-text-align-left")
    WebElement planCount;

    @FindBy(id = "PlanResults-PlanDetails_1")
    WebElement btnDetail;

    @FindBy(css=".fas.fa-spinner.fa-spin")
    WebElement spinner;

    @FindBy(xpath = "//div[@id='MPcollapse'] //span[contains(@class,'ngx-slider-floor')]")
    WebElement txtpremiumamnt;

    @FindBy(id = "PlanResults-CurrentPlanLabel")
    WebElement greenMedicalBannerText;


    public void selectfromProviderList(String Selecting) {
        basicActions.waitForElementToDisappear( spinner,60 );
        String providerPath = "//label[text()='" + Selecting + "']";
        basicActions.getDriver().findElement(By.xpath(providerPath)).click();
    }

    public void SelectFirstMedicalPlan() {
        basicActions.waitForElementToDisappear( spinner,120);
        basicActions.waitForElementToBePresentWithRetries(selectFirstPlan, 50);
        selectFirstPlan.click();
    }

    public void clickContinue() {
        basicActions.waitForElementToDisappear( spinner,160 );
        basicActions.waitForElementToBePresentWithRetries(continueBtn,80);
        basicActions.scrollToElement( continueBtn );
        continueBtn.click();
    }

    public void clickGoBack(){
        basicActions.waitForAngular(120 );
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresentWithRetries( btnGoBack,30 );
        basicActions.scrollToElement( btnGoBack );
        btnGoBack.click();
    }

    public void clickSkip(){
        basicActions.waitForElementToDisappear(spinner, 30);
        basicActions.waitForElementToBePresentWithRetries(btnSkip, 30);
        basicActions.scrollToElement( btnSkip );
        btnSkip.click();
    }

    public void selectFirstMedicalPlanDetailButton(){
         basicActions.waitForElementToDisappear( spinner,20 );
         basicActions.waitForElementToBePresent( btnDetail,30 );
         btnDetail.click();
    }
    public void clickCompare() {
        basicActions.waitForElementToBePresent(clickCompare, 30);
        clickCompare.click();
    }

    public void clickFirstTwoCompareButtons() {
        basicActions.waitForElementToDisappear( spinner,40 );
        basicActions.waitForElementToBePresent( firstCompareBox,10 );
        firstCompareBox.click();
        secondCompareBox.click();
    }

    public void clickFirstThreeCompareButtons(){
        basicActions.waitForElementToDisappear( spinner,40 );
        basicActions.waitForElementToBePresent( firstCompareBox,10 );
        firstCompareBox.click();
        secondCompareBox.click();
        thirdCompareBox.click();
    }

    public void clickFirstFourCompareButtons(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresent( firstCompareBox,10 );
        firstCompareBox.click();
        secondCompareBox.click();
        thirdCompareBox.click();
        fourthCompareBox.click();

    }

    public void validateCompareBoxWarningTxt(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresentWithRetries( compareWarningText,20);
        softAssert.assertEquals(compareWarningText.getText(), "You may select two or three plans to compare.\n" +"Okay");
        softAssert.assertAll();
        compareWarningOKbutton.click();
    }

    public void clickInsuranceCompanyDropdown() {
        basicActions.waitForElementToDisappear( spinner,160 );
        basicActions.waitForElementToBePresentWithRetries( insuranceCompanyDropdown,80 );
        basicActions.scrollToElement( insuranceCompanyDropdown );
        insuranceCompanyDropdown.click();

    }

    public void clickMetalTierDropdown() {
        basicActions.waitForElementToDisappear( spinner,50 );
        basicActions.waitForElementToBePresent( metalTierDropdown,30 );
        metalTierDropdown.click();

    }

    public void clickHSADropdown() {
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresent(hsaDropdown, 30);
        hsaDropdown.click();
    }

    public void selectHSAOption() {
        basicActions.waitForElementToDisappear( spinner,30 );
        basicActions.waitForElementToBePresentWithRetries(hsaOption, 100);
        hsaOption.click();

    }

    public void clickColoradoOptionDropdown() {
        basicActions.waitForElementToDisappear( spinner,15 );
        basicActions.waitForElementToBePresent(coloradoOptionDropdown, 30);
        coloradoOptionDropdown.click();
    }

    public void selectColoradoOptionSelection() {
        ((JavascriptExecutor) basicActions.getDriver()).executeScript("arguments[0].click()", coloradoOptionSelection);
        Assert.assertTrue(coloradoOptionSelection.isSelected());
    }

    public void selectfromMetalTierList(String Selecting) {
        String providerPath = "//label[text()='" + Selecting + "']";
        basicActions.getDriver().findElement(By.xpath(providerPath)).click();
    }

    public void validatePlanResults(int index, String planText) {
        basicActions.waitForElementToBePresent(selectFirstPlan, 10);
        //index = index - 1; //Index of the page starts at 0, so we take the visible order and subtract 1
        String indexString = String.valueOf(index); //turns the int index into a string value.
        String planID = "PlanResults-SelectThisPlan_" + indexString; //sets the ID String using the index
        WebElement ePlanID = basicActions.getDriver().findElement(By.id(planID)); //sets the Web element based on the ID
        String expectedText = ePlanID.getText();
        expectedText.equals(planText); // compares the expected text gathered in previous line to the planText passed into the function.
    }

    public void selectMedicalPlan(String planName){
        MemberDetails subscriber = SharedData.getPrimaryMember();
        subscriber.setMedicalPlan(planName);
        SharedData.setPrimaryMember(subscriber);
        List<MemberDetails> memberslist = SharedData.getMembers();
        basicActions.waitForElementToDisappear(spinner, 30);
        if(memberslist !=null){
            for (int i = 0; i < memberslist.size(); i++) {
                memberslist.get(i).setMedicalPlan(planName);
            }
        }
            do {
            optionalInt = checkIfPlanPresent(planName);
            if (optionalInt.isPresent()) {
                clickPlanButton(optionalInt.get()+1);
            } else {
                paginateRight();
            }
        } while(optionalInt.isEmpty());
    }

    public void selectMedicalPlanForGrp(String planName, String grpNum){
        List<MemberDetails> memberslist = basicActions.getAllMedicalEligibleMemInfo();
        basicActions.waitForElementToDisappear(spinner, 30);
      for(MemberDetails member: memberslist){
        if(member.getMedGroupInd().equals(grpNum)){
            member.setMedicalPlan(planName);
        }
      }
        do {
            optionalInt = checkIfPlanPresent(planName);
            if (optionalInt.isPresent()) {
                clickPlanButton(optionalInt.get()+1);
            } else {
                paginateRight();
            }
        } while(optionalInt.isEmpty());
        clickContinue();
    }

    private Optional<Integer> checkIfPlanPresent(String planName) {
        basicActions.waitForElementListToBePresent(medicalPlanNamesList, 10);
        return IntStream.range(0, medicalPlanNamesList.size())
                .filter(i -> medicalPlanNamesList.get(i).getText().equals(planName))
                .boxed()
                .findFirst();
    }

    private void clickPlanButton(int index){
         basicActions.wait(2000);
         basicActions.waitForElementToBePresent(spinner, 10);
        String planID = "PlanResults-SelectThisPlan_" + index;
        WebElement ePlanID = basicActions.getDriver().findElement(By.id(planID));
        basicActions.waitForElementToBeClickable(ePlanID, 10);
        ePlanID.click();
    }

    private void paginateRight(){
        basicActions.waitForElementToBePresent(nextPageArrow, 60);
        basicActions.waitForElementToDisappear(spinner, 60);
        Assert.assertTrue(nextPageArrow.isEnabled(), "Right arrow to click is not enabled!");
        nextPageArrow.click();
    }

    public void validatePlanCount(String plansCount){
        basicActions.waitForElementToBePresent(planCount, 30);
        Assert.assertEquals(planCount.getText(), plansCount+" of "+plansCount+" Medical Plans", "Medical plans count did not match");
    }

    public void selectPlansForGroups(List<String> plansOfGroups){
        for(String planOfGroup: plansOfGroups){
            String[] parts = planOfGroup.split(":");
            String plan = parts[1];
            Matcher matcher = Pattern.compile("\\d+").matcher(parts[0]);
            String groupNum = matcher.find() ? matcher.group() : null;

            basicActions.waitForElementToDisappear(spinner, 10);
            basicActions.waitForElementToBePresent(medicalplanheader, 10);
            basicActions.wait(3000);
            Matcher matcher_header = Pattern.compile("\\d+").matcher(medicalplanheader.getText());
            String headerGroupNum = matcher_header.find() ? matcher.group() : null;
            Assert.assertEquals(headerGroupNum, groupNum, "Group number from header and step did not match!");

            if(plan.equals("skip")){
                setSkippedGroupNumber(groupNum);
            } else {
                selectMedicalPlanForGrp(plan, groupNum);
            }
        }
    }


    private void setSkippedGroupNumber(String groupNum){
        List<MemberDetails> allEligMembers = basicActions.getAllMedicalEligibleMemInfo();
        for(MemberDetails member: allEligMembers){
           if(member.getMedGroupInd().equals(groupNum)){
               member.setHasMedicalPlan(false);
           }
        }
        clickSkip();
    }


    public void verifyPremiumAmountIsNotZero() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementToBePresent(txtpremiumamnt, 20);
        softAssert.assertNotEquals(txtpremiumamnt.getAttribute("innerText"), "0");
        softAssert.assertAll();
    }

    public void getMedicalPlanMarketNames() {
        basicActions.waitForElementToDisappear(spinner, 20);
        basicActions.waitForElementListToBePresent(medicalPlanNamesList, 20);
        while (true) {
            getPlanNamesFromPage();
            if (checkIfLastPage()) {
                break;
            }
            paginateRight();
        }
    }

    private Boolean checkIfLastPage() {
        basicActions.waitForElementListToBePresent(medicalPlanNamesList, 10);
        return !basicActions.waitForElementToBePresent(nextPageArrow, 10);
    }

    private void getPlanNamesFromPage(){
        List<String> medicalPlansList = SharedData.getMedicalPlansList();
        if(medicalPlansList==null){
            medicalPlansList = new ArrayList<>();
        }

        for (WebElement planName : medicalPlanNamesList) {
            medicalPlansList.add(planName.getText());
        }
        SharedData.setMedicalPlansList(medicalPlansList);
    }

    public void validateTotalMedicalPlans(int expectedCount){
        int medicalPlansListcount = SharedData.getMedicalPlansList().size();
        softAssert.assertEquals(medicalPlansListcount, expectedCount, "The number of medical plans does not match the expected count");
        softAssert.assertAll();

    }
    public void validateMedicalGreenBannerTxt(String language){
        basicActions.waitForElementToDisappear( spinner, 20 );
        switch (language) {
            case "English":
                validateMedicalGreenBannerEnglishTxt();
                break;
            case "Spanish":
                validateMedicalGreenBannerSpanishTxt();
                break;
            default:
                throw new IllegalArgumentException( "Invalid option: " + language );

        }
    }

    public void validateMedicalGreenBannerEnglishTxt(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresentWithRetries( greenMedicalBannerText,20);
        softAssert.assertEquals(greenMedicalBannerText.getText(), "Current plan");
        softAssert.assertAll();
    }

    public void validateMedicalGreenBannerSpanishTxt(){
        basicActions.waitForElementToDisappear( spinner,20 );
        basicActions.waitForElementToBePresentWithRetries( greenMedicalBannerText,20);
        softAssert.assertEquals(greenMedicalBannerText.getText(), "Plan actual");
        softAssert.assertAll();
    }


}





