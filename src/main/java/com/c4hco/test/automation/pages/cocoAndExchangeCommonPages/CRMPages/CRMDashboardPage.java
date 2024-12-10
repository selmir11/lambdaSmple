package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.CRMPages;

import com.c4hco.test.automation.Dto.MemberDetails;
import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class CRMDashboardPage {

    @FindBy(id = "GlobalSearchBox")
    WebElement txtCRMDashSearchBox;

    @FindBy(css = "#navigateBackButtontab-id-0 > span")
    WebElement btnGoBack;

    @FindBy(css = "#mectrl_headerPicture")
    WebElement btnHdrPic;

    @FindBy(css = "#mectrl_body_signOut")
    WebElement lnkSignOut;

    @FindBy(css = ".table-cell.tile-menu.tile-menu-float img")
    WebElement btnThreeDots;

    @FindBy(id = "forgetLink")
    WebElement btnForget;

    private BasicActions basicActions;

    public CRMDashboardPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void CRMDashboardSearchUserEmailandOpenFirst() {
        basicActions.wait(10000);
        List<WebElement> okButtonList = WebDriverManager.getDriver().findElements(By.id("okButton_1"));
        if (!okButtonList.isEmpty() && okButtonList.get(0).isDisplayed()) {
            okButtonList.get(0).click();
            System.out.println("Clicked the OK Button.");
            basicActions.wait(2000);

        } else {
            System.out.println("OK Button not present or not visible, continuing with the search.");
        }

        basicActions.waitForElementToBePresentWithRetries(txtCRMDashSearchBox, 60);
        txtCRMDashSearchBox.sendKeys(SharedData.getPrimaryMember().getEmailId());
        basicActions.wait(3000);
        txtCRMDashSearchBox.sendKeys(Keys.RETURN);
    }

    public void CRMDashboardSearchBrokerNameandOpenFirst(String brokerType) {
        basicActions.wait(10000);
        List<WebElement> okButtonList = WebDriverManager.getDriver().findElements(By.id("okButton_1"));
        if (!okButtonList.isEmpty() && okButtonList.get(0).isDisplayed()) {
            okButtonList.get(0).click();
            System.out.println("Clicked the OK Button.");
            basicActions.wait(2000);

        } else {
            System.out.println("OK Button not present or not visible, continuing with the search.");
        }

        basicActions.waitForElementToBePresentWithRetries(txtCRMDashSearchBox, 60);
        switch (brokerType) {
            case "Agency Owner":
                txtCRMDashSearchBox.sendKeys(SharedData.getAgencyOwner().getBroker_name());
                break;
            case "Broker":
                txtCRMDashSearchBox.sendKeys(SharedData.getBroker().getBroker_name());
                break;
            default:
                throw new IllegalArgumentException("Invalid option: " + brokerType);
        }
        basicActions.wait(3000);
        txtCRMDashSearchBox.sendKeys(Keys.RETURN);
    }

    public void searchByUserEmail(String stageEmail, String qaEmail){
        basicActions.wait(10000);
        basicActions.waitForElementToBePresentWithRetries(txtCRMDashSearchBox, 60);
        if (SharedData.getEnv().equals("staging")){
            txtCRMDashSearchBox.sendKeys(stageEmail);
            initializeData(stageEmail);
        }else{
            txtCRMDashSearchBox.sendKeys(qaEmail);
            initializeData(qaEmail);
        }
        basicActions.wait(3000);
        txtCRMDashSearchBox.sendKeys(Keys.RETURN);
    }

    public void initializeData(String email){
        String firstName = "";
        String lastName = "";
        String[] emailParts = email.split("@");
        if (emailParts.length != 2 || !emailParts[1].equals("test.com")) {
            System.out.println("Invalid email format");
            return;
        }
        String[] nameParts = emailParts[0].split("\\.");
        if (nameParts.length == 2) {
            firstName = nameParts[0];
            lastName = nameParts[1];
        } else {
            System.out.println("Invalid email format");
            return;
        }

        MemberDetails subscriber = new MemberDetails();
        List<MemberDetails> allMembersList = new ArrayList<>();
        subscriber.setFirstName(firstName);
        subscriber.setLastName(lastName);
        subscriber.setEmailId(email);
        subscriber.setPassword("ALaska12!");
        subscriber.setIsSubscriber("Y");
        SharedData.setPrimaryMember(subscriber);
        allMembersList.add(subscriber);
        SharedData.setAllMembers(allMembersList);
        System.out.println("Name is "+SharedData.getPrimaryMember().getFirstName()+" "+ SharedData.getPrimaryMember().getLastName());
        System.out.println("Email is "+SharedData.getPrimaryMember().getEmailId());
        System.out.println("Password is "+SharedData.getPrimaryMember().getPassword());
    }

    public void clickGoBack(){
        basicActions.waitForElementToBePresentWithRetries(btnGoBack, 60);
        btnGoBack.click();
    }

    public void signOutOfCrm(){
        basicActions.waitForElementToBePresentWithRetries(btnHdrPic, 60);
        btnHdrPic.click();
        basicActions.waitForElementToBePresentWithRetries(lnkSignOut, 60);
        lnkSignOut.click();
        basicActions.wait(3000);
        basicActions.waitForElementToBePresentWithRetries(btnThreeDots, 60);
        btnThreeDots.click();
        basicActions.waitForElementToBePresentWithRetries(btnForget, 60);
        btnForget.click();
    }
}
