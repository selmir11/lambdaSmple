package com.c4hco.test.automation.pages.cocoAndExchangeCommonPages.BrokerPortalPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class TermsAndConditionsPage {
    SoftAssert softAssert = new SoftAssert();

    @FindBy(id = "terms-page-header")
    WebElement termsAndConditionsPageTitle;

    @FindBy(id = "terms-header")
    WebElement termsAndConditionsTextTile;

    @FindBy(id = "terms-disclaimer")
    WebElement termsAndConditionsTextDisclaimer;

    @FindBy(id = "terms-sect-1")
    WebElement termsAndConditionsTextSection1;

    @FindBy(id = "terms-sect-2")
    WebElement termsAndConditionsTextSection2;

    @FindBy(id = "terms-sect-3")
    WebElement termsAndConditionsTextSection3;

    @FindBy(id = "terms-sect-4")
    WebElement termsAndConditionsTextSection4;

    @FindBy(id = "terms-sect-5")
    WebElement termsAndConditionsTextSection5;

    @FindBy(id = "terms-sect-6")
    WebElement termsAndConditionsTextSection6;

    @FindBy(id = "terms-sect-7")
    WebElement termsAndConditionsTextSection7;

    @FindBy(id = "terms-sect-8")
    WebElement termsAndConditionsTextSection8;

    @FindBy(id = "terms-sect-9")
    WebElement termsAndConditionsTextSection9;

    @FindBy(id = "terms-sect-10")
    WebElement termsAndConditionsTextSection10;

    @FindBy(id = "terms-sect-11")
    WebElement termsAndConditionsTextSection11;

    @FindBy(id = "terms-sect-12")
    WebElement termsAndConditionsTextSection12;

    @FindBy(id = "terms-sect-13")
    WebElement termsAndConditionsTextSection13;

    @FindBy(id = "terms-sect-14")
    WebElement termsAndConditionsTextSection14;

    @FindBy(id = "terms-sect-15")
    WebElement termsAndConditionsTextSection15;

    @FindBy(id = "terms-sect-16")
    WebElement termsAndConditionsTextSection16;

    @FindBy(id = "terms-submit")
    WebElement submitTermsAndConditionsPage;

    @FindBy(id = "tc-error")
    WebElement termsAgreementError;

    @FindBy(xpath = "//*[@id='terms-checkbox-container']/div[1]/div/lib-checkbox-control/label/span")
    WebElement agreeToTermsAndConditionsCheckboxText;

    @FindBy(xpath = "//*[@id='terms-checkbox']//em[@class='fa fa-check']")
    WebElement checkboxAgreeToTermsAndConditionsPage;

    @FindBy(id = "BP-TermsAndConditions-GoBack")
    WebElement goBackTermsAndConditionsPage;

    @FindBy(xpath = "//*[@id='elem']/app-profile-complete/div/div[3]/button")
    WebElement goToMyDashboardButton;

    private BasicActions basicActions;

    public TermsAndConditionsPage(WebDriver webDriver){
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }

    public void validateTermsPageTitle(){
        basicActions.waitForElementToBePresentWithRetries(termsAndConditionsPageTitle,10);
        softAssert.assertEquals(termsAndConditionsPageTitle.getText(),"Terms and Conditions");
        softAssert.assertAll();
    }

    public void validateTermsConditionsText(){
        basicActions.waitForElementToBePresentWithRetries(termsAndConditionsTextTile,10);
        softAssert.assertEquals(termsAndConditionsTextTile.getText(),"Agreement for use of Broker Portal");
        softAssert.assertEquals(termsAndConditionsTextDisclaimer.getText(),"Please read these Terms & Conditions carefully. By using the Broker portal, you acknowledge and agree that you have read and agree to be bound by these Terms & Conditions (this \"Agreement\"). This Agreement is made between Connect for Health Colorado and You. IF YOU DO NOT AGREE TO BE BOUND BY THIS AGREEMENT, PLEASE EXIT THE BROKER PORTAL NOW AND REFRAIN FROM USING ANY MATERIAL THAT YOU MAY HAVE DOWNLOADED FROM THE BROKER PORTAL.");
        softAssert.assertEquals(termsAndConditionsTextSection1.getText(),"1. USE OF THE BROKER PORTAL. All use of the Broker portal is subject to the terms of this Agreement. You may access and use the Broker portal solely for lawful purposes. Connect for Health Colorado reserves the right at any time and in its sole discretion to modify, suspend, or discontinue the Broker portal (or any portion thereof) with notice.");
        softAssert.assertEquals(termsAndConditionsTextSection2.getText(),"2. REGISTRATION. To access some areas of the Broker portal, you may have to apply for and be approved as a registered user (a \"Registered User\") of the Broker portal. Your approval as a Registered User is at the sole discretion of Connect for Health Colorado. Upon approval as a Registered User, You may be asked to create a password-protected account (an \"Account\"). You agree to keep your Account information and password confidential. You agree to notify Connect for Health Colorado immediately of any actual or suspected unauthorized use of, or access toyour Account. You are solely responsible for all activities that occur through Your Account. Connect for Health Colorado will not be responsible for any loss to you caused by your failure to comply with these obligations. In connection with your application to become a Registered User, You will be asked to submit certain information about yourself (\"Registration Information\" ). You represent and warrant that: (a) all Registration Information You provide is true, accurate, current, and complete; and (b) You will maintain and promptly update the Registration Information to keep it true, accurate, current, and complete. As part of the registration process, you may be assigned or permitted to create a user ID for use in identifying your Account (a \"User ID\"). You may not: (i) select or use a User ID of another person with the intent to impersonate that person; (ii) use a User ID in which another person has rights without such person's authorization; or (iii) use a User ID that Connect for Health Colorado, in its sole discretion, deems offensive. Failure to comply with the foregoing shall constitute a breach of this Agreement, which may result in immediate termination of your Account.");
        softAssert.assertEquals(termsAndConditionsTextSection3.getText(),"3. TERM AND TERMINATION. This Agreement will be effective on the date you first use the Broker portal and will continue until terminated. Connect for Health Colorado may terminate or modify this Agreement immediately, for any reason, with notice to you. You may terminate this Agreement upon written notice to Connect for Health Colorado, such termination effective 90 days following receipt of such notice by Connect for Health Colorado. Connect for Health Colorado may also suspend your use of the Broker portal or deactivate a User ID and direct you to cease using the Broker portal with notice to you and with cause. Upon any termination of this Agreement, all rights granted to you under this Agreement will cease and you must promptly discontinue all access to any part of the Broker portal and the use of any Content downloaded or otherwise obtained from the Broker portal. Any Content downloaded or printed must be immediately securely deleted or disposed of. Sections 3, 4, 5, 7, 10, 11, and 15 will survive termination or expiration of this Agreement for any reason as they apply to the rights granted to Connect for Health Colorado and the restrictions placed on you.");
        softAssert.assertEquals(termsAndConditionsTextSection4.getText(),"4. CONTENT. The Broker portal and the entire contents of the Broker portal, including, but not limited to, text, files, images, graphics, illustrations, audio, video, and photographs on or offered through the Broker portal (collectively, \"Content\") are protected by intellectual property rights, including, as applicable and without limitation, copyrights, trademarks, patents, and other proprietary and intellectual property rights (\"Intellectual Property Rights\") of Connect for Health Colorado or other third parties who have granted rights to Connect for Health Colorado.");
        softAssert.assertEquals(termsAndConditionsTextSection5.getText(),"5. USE OF THE CONTENT. Your access to or use of the Content is subject to the terms and conditions of this Agreement. You may use the Content only in the form provided on or through the Broker portal solely for your own informational purposes. You may not use any Content for any commercial purpose or charge a fee or other consideration in exchange for the Content. You may not utilize the Content to sell, advertise, endorse, or otherwise promote any other service, product, or party. All use of the Content must be accompanied by an acknowledgment that the Content is owned by Connect for Health Colorado. You must otherwise abide by all Intellectual Property Rights, notices, information, or restrictions contained on or in any Content. Unless otherwise noted on the Broker portal, as between you and Connect for Health Colorado, its partners, affiliates, and licensors (\"Affiliates\"), all Content is owned by Connect for Health Colorado and its Affiliates. Except as stated in this Agreement, You are granted no licenses or rights, whether by implication, estoppel, or otherwise, in or to the Broker portal or Content, or any Intellectual Property Rights therein or related thereto, and You may not modify, reproduce, perform, display, create derivative works from, republish, post, transmit, participate in the transfer or sale of, distribute, or in any way exploit any portion of the Broker portal or Content without the prior written permission of Connect for Health Colorado. If you would like to use the Content in a manner that is not expressly set forth in this Agreement, please contact us through the Connect for Health Colorado staff representatives who assist Brokers.");
        softAssert.assertEquals(termsAndConditionsTextSection6.getText(),"6. MARKS. Unless otherwise labeled, all trademarks, service marks, logos, banners, and page headers displayed on this Broker portal (collectively, the \"Marks\") are the property of Connect for Health Colorado and its Affiliates. Except as expressly set forth in this Agreement, You may not display, link to, or otherwise use the Marks without the prior written permission of Connect for Health Colorado.");
        softAssert.assertEquals(termsAndConditionsTextSection7.getText(),"7. POSTINGS AND UPLOADS. The Broker portal may include forums, bulletin boards, chat rooms, or other opportunities through which you may provide or upload Content of your own to the Broker portal. You agree not to upload or provide any Content that is: (1) libelous, defamatory, obscene, abusive, pornographic, threatening, or an invasion of privacy; (2) an infringement of the Intellectual Property Rights of any third party; (3) illegal in any way or that advocates illegal activity; (4) an advertisement or solicitation of funds, goods, or services; (5) an endorsement or advertisement for any candidate for public office; (6) a software virus or contains any other harmful computer code, files, or programs. We reserve the right to refuse to post or remove any post or Content which in our sole discretion violates this Section 7 without prior notice. You hereby represent and warrant to Connect for Health Colorado and its Affiliates that You own all right, title, and interest in and to any Content that You provide or upload to the Broker portal, or that You have sufficient rights, whether by implication, estoppel, or otherwise, to post or upload Content and to grant Connect for Health Colorado the rights discussed in this Section 7. You will indemnify, defend, and hold harmless Connect for Health Colorado and its Affiliates from any and all third-party claims, losses, liabilities, damages, fees, expenses, and costs (including attorneys' fees and court costs) that result from a breach or alleged breach of any representation or warranty set forth in Section 7. By providing or uploading any Content to the Broker portal, You grant Connect for Health Colorado a nonexclusive, royalty-free, perpetual, irrevocable, and fully sub licensable right to use, copy, store, reproduce, modify, display, adapt, publish, translate, create derivative works from, distribute, and display such Content throughout the world in any form, media, software, or technology of any kind. In addition, you waive all moral rights in the Content, including any Content you post or upload, or warrant that all moral rights applicable to such Content have been waived. You also grant Connect for Health Colorado the right to use your name in connection with the reproduction or distribution of such material.");
        softAssert.assertEquals(termsAndConditionsTextSection8.getText(),"8. CLAIMS OF INFRINGEMENT. Just as Connect for Health Colorado requires users of the Broker portal to respect the copyrights and other intellectual property rights of Connect for Health Colorado, its Affiliates, and other third parties, Connect for Health Colorado respects the copyrights and other intellectual property rights of users of the Broker portal and other third parties. If you believe in good faith that your copyrighted work has been reproduced on the Broker portal without authorization in a way that constitutes copyright infringement, you may notify our designated copyright agent by mail to:Connect for Health Colorado, 4600 S. Ulster St. #300, Denver, CO 80237 Showing clients require authorization\n\nPlease provide the following information to Connect for Health Colorado:\n\n(1) The identity of the infringed work, and of the allegedly infringing work;\n(2) Your name, address, daytime phone number, and Email address, if available;\n(3) A statement that You have a good-faith belief that the use of the copyrighted work is not authorized by the owner, his or her agent, or the law;\n(4) A statement of the accuracy of the notice and, under penalty of perjury, that You are authorized to act on behalf of the owner; and\n(5) Your electronic or physical signature.");
        softAssert.assertEquals(termsAndConditionsTextSection9.getText(),"9. REPRESENTATIONS AND WARRANTIES. You hereby represent, warrant, and covenant for the benefit of Connect for Health Coloradoand its Affiliates that: (1) You have the legal right and authority to enter into this Agreement, and, if You are accepting this Agreement on behalf of a company or other entity, to bind the company or other entity to the terms of this Agreement; (2) You have the legal right and authority to perform Your obligations under this Agreement and to grant the rights and licenses described in this Agreement and in any applicable additional agreement You enter into in connection with any of the Services; (3) all information You provide to Connect for Health Coloradoin connection with this Agreement and Your access to the Broker portal and use of the Services is correct and current.");
        softAssert.assertEquals(termsAndConditionsTextSection10.getText(),"10. DISCLAIMER AND LIMITATION OF LIABILITY.\n\n1. Disclaimer. THE BROKER PORTAL IS PROVIDED BY CONNECT FOR HEALTH COLORADO\"AS IS\" and \"AS AVAILABLE\" WITH NO WARRANTIES WHATSOEVER. NEITHER CONNECT FOR HEALTH COLORADO NOR ITS AFFILIATES REPRESENT OR ENDORSE THE ACCURACY OR RELIABILITY OF ANY ADVICE, OPINION, STATEMENT, OR OTHER INFORMATION DISPLAYED, DOWNLOADED FROM, OR DISTRIBUTED THROUGH THE BROKER PORTAL. YOU AGREE THAT YOUR ACCESS TO THE BROKER PORTAL IS AT YOUR OWN RISK AND THAT YOU ARE SOLELY RESPONSIBLE FOR ANY LIABILITY OR DAMAGE YOU INCUR THROUGH ACCESS TO THE BROKER PORTAL. EXCEPT WHERE THE LAWS AND REGULATIONS OF A PARTICULAR JURISDICTION CONCERNING WARRANTIES CANNOT BE WAIVED OR EXCLUDED BY AGREEMENT, CONNECT FOR HEALTH COLORADO EXPRESSLY DISCLAIMS ALL WARRANTIES, WHETHER EXPRESS OR IMPLIED, REGARDING THE BROKER PORTAL, INCLUDING, WITHOUT LIMITATION, ALL WARRANTIES OF TITLE, NONINFRINGEMENT, MERCHANTABILITY, AND FITNESS FOR A PARTICULAR PURPOSE. YOU RECOGNIZE THAT THE CURRENT STATE OF TECHNOLOGY DOES NOT ALLOW FOR ERROR-FREE ACCESS TO THE BROKER PORTAL AND INTERRUPTIONS, CRASHES, AND DOWNTIME BEYOND CONNECT FOR HEALTH COLORADO\u2019S CONTROL MAY OCCUR FROM TIME TO TIME.\n\n2. Limitation. IN NO EVENT WILL CONNECT FOR HEALTH COLORADO BE LIABLE FOR ANY DIRECT, CONSEQUENTIAL, SPECIAL, INDIRECT, EXEMPLARY, OR PUNITIVE DAMAGES, WHETHER IN CONTRACT, TORT, OR ANY OTHER LEGAL THEORY, IN CONNECTION WITH YOUR ACCESS TO THE BROKER PORTAL OR USE OF THE SERVICES, EVEN IF CONNECT FOR HEALTH COLORADO HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES AND NOTWITHSTANDING ANY FAILURE OF ESSENTIAL PURPOSE OR ANY LIMITED REMEDY. CONNECT FOR HEALTH COLORADO\u2019S TOTAL AGGREGATE LIABILITY FOR ANY DAMAGES ARISING OUT OF OR RELATED TO THIS AGREEMENT WILL NOT EXCEED $250 (TWO HUNDRED AND FIFTY DOLLARS).");
        softAssert.assertEquals(termsAndConditionsTextSection11.getText(),"11. INDEMNIFICATION. You hereby indemnify, defend, and hold harmless Connect for Health Coloradoand its Affiliates, employees, agents, contractors, assigns, licensees, and successors in interest (\"Indemnified Parties\") from any and all claims, losses, liabilities, damages, fees, expenses, and costs (including attorneys' fees, court costs, damage awards, and settlement amounts) that result from any claim or allegation against any Indemnified Party arising from Your accessing the Broker portal or Your breach of any term of this Agreement. Connect for Health Coloradowill provide you with notice of any such claim or allegation, and Connect for Health Coloradowill have the right to participate in the defense of any such claim at its expense.");
        softAssert.assertEquals(termsAndConditionsTextSection12.getText(),"12. PRIVACY POLICY. Connect for Health Colorado\u2019sprivacy policy, a copy of which is available at https://connectforhealthco.com/privacy-policy/is incorporated in this Agreement by reference. By accepting this Agreement, You expressly consent to the use and disclosure of your personally identifiable and other information as described in the Privacy Policy. You also agree to comply with your obligations to protect personally identifiable information as required under 45 CFR \u00A7155.260 and any other applicable laws, statutes, regulations, or guidance materials. You expressly acknowledge that this includes the privacy and security standards and obligations noted in the Certified Producer Agreement as stated in \u00A7155.260(b)(3)");
        softAssert.assertEquals(termsAndConditionsTextSection13.getText(),"13. LINKED BROKER PORTALS. The Broker portal contains links to third-party broker portals that are not under the control of Connect for Health Colorado, and Connect for Health Coloradois not responsible for any content on any linked broker portal. If you access a third-party broker portal from the Broker portal, then you do so at your own risk. Connect for Health Colorado provides links only as a convenience, and the inclusion of the link does not imply that Connect for Health Coloradoendorses or accepts any responsibility for the content on those third-party broker portals. Connect for Health Coloradowelcomes links to the Broker portal. You may establish a link to this Broker portal, provided that the link does not state or imply any sponsorship or endorsement of your broker portal by Connect for Health Coloradoor your broker portal does not endorse or oppose any candidate for public office. You may not use on your broker portal, any Content or Marks appearing on the Broker portal in establishing the link. You may not frame or otherwise incorporate into another broker portal the Content or other materials on the Broker portal without prior written consent of Connect for Health Colorado.");
        softAssert.assertEquals(termsAndConditionsTextSection14.getText(),"14. NOTICES. Except as expressly stated otherwise, any notices required or allowed under this Agreement will be given to Connect for Health Coloradoby postal mail to the address for Connect for Health Coloradolisted on the Broker portal. If applicable law requires that Connect for Health Coloradoaccepts email notices (but not otherwise), then you may send Connect for Health Coloradoemail notice using the \"Contact Us\" page. A link to the Contact Us page is available on each page of the Broker portal. With respect to Connect for Health Coloradonotices to You, Connect for Health Colorado may provide notice of amendments by posting them on the Broker portal and upon such posting any amendment shall be deemed effective notice as set forth in this section.");
        softAssert.assertEquals(termsAndConditionsTextSection15.getText(),"15. You agree to check for changes.");
        softAssert.assertEquals(termsAndConditionsTextSection16.getText(),"16. GENERAL TERMS.\n\n1. Third-Party Beneficiaries. Connect for Health Colorado\u2019s Affiliates are intended third-party beneficiaries under this Agreement with the right to enforce the provisions that directly concern Content to which they have rights.\n2. No assignment. You may not assign or transfer any of your rights hereunder, and any attempt to do so will be null and void.\n3. Integration. This Agreement sets forth the entire understanding of the parties regarding use of the Broker portal and supersedes any and all prior oral and written agreements or understandings between the parties regarding the subject matter of this Agreement. This Agreement may not be modified except upon mutual written agreement of both parties. The waiver by either party of a breach of any provision of this Agreement will not operate or be interpreted as a waiver of any other or subsequent breach.\n4. Severability. If for any reason any provision of this Agreement shall be held invalid or unenforceable in whole or in part in any jurisdiction, such provision shall, as to such jurisdiction, be ineffective to the extent of such invalidity or unenforcability, without in any manner affecting the validity or enforceability thereof in any other jurisdiction or the remaining provisions hereof in any jurisdiction.\n5. Jurisdiction and Venue. This Agreement will be governed by the laws of the State of Colorado, without giving effect to any conflict of laws principles. The parties specifically exclude from application to the Agreement the United Nations Convention on Contracts for the International Sale of Goods and the Uniform Computer Information Transactions Act. You hereby irrevocably and unconditionally consent to the jurisdiction and venue in the state and federal courts sitting in Denver, Colo. In any such dispute, the prevailing party will be entitled to recover its reasonable attorneys' fees and expenses from the other party.\n6. Modifications. Connect for Health Colorado reserves the right, at any time and without notice, to add to, change, update, or modify the Broker portal and these Terms of Use, simply by posting such addition, change, update, or modification on this Broker portal. Any such addition, change, update, or modification will be effective immediately upon posting on the Broker portal.");
        softAssert.assertAll();
    }

    public void clickSubmitBrokerPortalTermsPage(){
        basicActions.waitForElementToBeClickable(submitTermsAndConditionsPage,10);
        submitTermsAndConditionsPage.click();
    }

    public void validateSubmitButtonDisabled(){
        basicActions.waitForElementToBePresentWithRetries(submitTermsAndConditionsPage,10);
        softAssert.assertFalse(submitTermsAndConditionsPage.isEnabled());
        softAssert.assertAll();
    }

    public void validateTermsAgreementError(){
        basicActions.waitForElementToBePresentWithRetries(termsAgreementError,10);
        softAssert.assertEquals(termsAgreementError.getText(),"You must agree to the Terms and Conditions.");
        softAssert.assertAll();
    }

    public void validateTermsCheckboxText(){
        basicActions.waitForElementToBePresentWithRetries(agreeToTermsAndConditionsCheckboxText,10);
        softAssert.assertEquals(agreeToTermsAndConditionsCheckboxText.getText(),"I agree to the Terms & Conditions provided.");
        softAssert.assertAll();
    }

    public void agreeBrokerPortalTermsPage(){
        basicActions.waitForElementToBePresentWithRetries(checkboxAgreeToTermsAndConditionsPage,10);
        checkboxAgreeToTermsAndConditionsPage.click();
    }

    public void clickGoBackTermsConditions(){
        basicActions.waitForElementToBePresentWithRetries(goBackTermsAndConditionsPage,10);
        goBackTermsAndConditionsPage.click();
    }

    public void clickGoToMyDashboard(){
        basicActions.waitForElementToBePresentWithRetries(goToMyDashboardButton, 10);
        goToMyDashboardButton.click();
    }
}
