package com.c4hco.test.automation.pages.cocoPages;

import com.c4hco.test.automation.utils.BasicActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

public class TermsOfUseCoCoPage {

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[1]")
    WebElement title;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/p")
    WebElement p1;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[1]/li[1]")
    WebElement ol1;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[1]/li[2]")
    WebElement ol2;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[1]/li[3]")
    WebElement ol3;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[1]/li[4]")
    WebElement ol4;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[1]/li[5]")
    WebElement ol5;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[1]/li[6]")
    WebElement ol6;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[1]/li[7]")
    WebElement ol7;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[1]/li[8]")
    WebElement ol8;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[1]/li[8]/p[2]")
    WebElement p2;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[2]/li[1]")
    WebElement ol9;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[2]/li[2]")
    WebElement ol10;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[3]/li[1]")
    WebElement ol11;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[3]/li[2]")
    WebElement ol12;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[3]/li[3]")
    WebElement ol13;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[3]/li[4]")
    WebElement ol14;

    @FindBy(xpath = "/html/body/app-root/div/div/div/app-terms-of-use/app-container/div/div/div[2]/div/ol[3]/li[5]")
    WebElement ol15;

    SoftAssert softAssert = new SoftAssert();
    private BasicActions basicActions;


    public TermsOfUseCoCoPage(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }


    public void verifyPageText() {

        softAssert.assertEquals(title.getText(), "Terms of Use");
        softAssert.assertEquals(p1.getText(), "Welcome to the websites of Colorado Connect (the \u201CSite\u201D). The Site is operated by the Connect for Health Colorado Company, a Colorado corporation doing business as Colorado Connect, (\u201CWe\u201D or \u201CUs\u201D). Please carefully read these Terms of Use. By using the Site, you acknowledge and agree that you have read and agree to be bound by these Terms of Use (this \u201CAgreement\u201D). This Agreement is made between Colorado Connect and You or, in the case that you represent and are using the Site on behalf of a company or other entity, that company or other entity (\u201CYou\u201D). IF YOU DO NOT AGREE TO BE BOUND BY THIS AGREEMENT, PLEASE EXIT THE SITE NOW AND REFRAIN FROM USING ANY MATERIAL THAT YOU MAY HAVE DOWNLOADED FROM THE SITE.");
        softAssert.assertEquals(ol1.getText().trim(), "USE OF THE SITE. All use of the Site is subject to the terms of this Agreement. You may access and use the Site solely for lawful purposes. You must be 13 years or older to use the Site. Colorado Connect reserves the right at any time and in its sole discretion to modify, suspend, or discontinue the Site (or any portion thereof) with or without notice.");
        softAssert.assertEquals(ol2.getText().trim(), "REGISTRATION. To access some areas of the Site, You may have to apply for and be approved as a registered user (a \u201CRegistered User\u201D) of the Site. Your approval as a Registered User is at the sole discretion of Colorado Connect. Upon approval as a Registered User, You may be asked to create a password-protected account (an \u201CAccount\u201D). You agree to keep your Account information and password confidential. You agree to notify Colorado Connect immediately of any actual or suspected unauthorized use of your Account. You are solely responsible for all activities that occur through Your Account. Colorado Connect will not be responsible for any loss to You caused by your failure to comply with these obligations. In connection with your application to become a Registered User, You will be asked to submit certain information about yourself (\u201CRegistration Information\u201D). You represent and warrant that: (a) all Registration Information You provide is true, accurate, current, and complete; and (b) You will maintain and promptly update the Registration Information to keep it true, accurate, current, and complete. As part of the registration process, You may be assigned or permitted to create a user ID for use in identifying your Account (a \u201CUser ID\u201D). You may not: (i) select or use a User ID of another person with the intent to impersonate that person; (ii) use a User ID in which another person has rights without such person\u2019s authorization; or (iii) use a User ID that Colorado Connect, in its sole discretion, deems offensive. Failure to comply with the foregoing shall constitute a breach of this Agreement, which may result in immediate termination of your Account.");
        softAssert.assertEquals(ol3.getText().trim(), "TERM AND TERMINATION. This Agreement will be effective on the date You first use the Site and will continue until terminated. Colorado Connect may terminate or modify this Agreement immediately, for any reason or no reason, with or without notice to You. You may terminate this Agreement upon written notice to Colorado Connect, such termination effective upon receipt of such notice by Colorado Connect. Colorado Connect may also suspend your use of the Site or deactivate a User ID and direct You to cease using the Site with or without notice to You and with or without cause. Upon any termination of this Agreement, all rights granted to You under this Agreement will cease and You must promptly discontinue all access to any part of the Site and the use of any Content downloaded or otherwise obtained from the Site. Sections 3, 4, 5, 7, 10, 11, and 15 will survive termination or expiration of this Agreement for any reason as they apply to the rights granted to Colorado Connect and the restrictions placed on You.");
        softAssert.assertEquals(ol4.getText().trim(), "CONTENT. The Site and the entire contents of the Site, including, but not limited to, text, files, images, graphics, illustrations, audio, video, and photographs on or offered through the Site (collectively, \u201CContent\u201D) are protected by intellectual property rights, including, as applicable and without limitation, copyrights, trademarks, patents, and other proprietary and intellectual property rights (\u201CIntellectual Property Rights\u201D) of Colorado Connect or other third parties who have granted rights to Colorado Connect.");
        softAssert.assertEquals(ol5.getText().trim(), "USE OF THE CONTENT. Your access to or use of the Content is subject to the terms and conditions of this Agreement. You may use the Content only in the form provided on or through the Site solely for your own informational purposes. You may not use any Content for any commercial purpose or charge a fee or other consideration in exchange for the Content. You may not utilize the Content to sell, advertise, endorse, or otherwise promote any other service, product, or party. All use of the Content must be accompanied by an acknowledgment that the Content is owned by Colorado Connect. You must otherwise abide by all Intellectual Property Rights, notices, information, or restrictions contained on or in any Content. Unless otherwise noted on the Site, as between You and Colorado Connect, its partners, affiliates, and licensors (\u201CAffiliates\u201D), all Content is owned by Colorado Connect and its Affiliates. Except as stated in this Agreement, You are granted no licenses or rights, whether by implication, estoppel, or otherwise, in or to the Site or Content, or any Intellectual Property Rights therein or related thereto, and You may not modify, reproduce, perform, display, create derivative works from, republish, post, transmit, participate in the transfer or sale of, distribute, or in any way exploit any portion of the Site or Content without the prior written permission of Colorado Connect. If you would like to use the Content in a manner that is not expressly set forth in this Agreement, please contact us using the \u201CContact Us\u201D page.");
        softAssert.assertEquals(ol6.getText().trim(), "MARKS. Unless otherwise labeled, all trademarks, service marks, logos, banners, and page headers displayed on this Site (collectively, the \u201CMarks\u201D) are the property of Colorado Connect and its Affiliates. Except as expressly set forth in this Agreement, You may not display, link to, or otherwise use the Marks without the prior written permission of Colorado Connect.");
        softAssert.assertEquals(ol7.getText().trim(), "POSTINGS AND UPLOADS. The Site may include forums, bulletin boards, chat rooms, or other opportunities through which you may provide or upload Content of your own to the Site. You agree not to upload or provide any Content that is: (1) libelous, defamatory, obscene, abusive, pornographic, threatening, or an invasion of privacy; (2) an infringement of the Intellectual Property Rights of any third party; (3) illegal in any way or that advocates illegal activity; (4) an advertisement or solicitation of funds, goods, or services; (5) an endorsement or advertisement for any candidate for public office; (6) a software virus or contains any other harmful computer code, files, or programs. We reserve the right to refuse to post or remove any post or Content which in our sole discretion violates this Section 7 without prior notice. You hereby represent and warrant to Colorado Connect and its Affiliates that You own all right, title, and interest in and to any Content that You provide or upload to the Site, or that You have sufficient rights, whether by implication, estoppel, or otherwise, to post or upload Content and to grant Colorado Connect the rights discussed in this Section 7. You will indemnify, defend, and hold harmless Colorado Connect and its Affiliates from any and all third-party claims, losses, liabilities, damages, fees, expenses, and costs (including attorneys\u2019 fees and court costs) that result from a breach or alleged breach of any representation or warranty set forth in Section 7. By providing or uploading any Content to the Site, You grant Colorado Connect a nonexclusive, royalty-free, perpetual, irrevocable, and fully sublicensable right to use, copy, store, reproduce, modify, display, adapt, publish, translate, create derivative works from, distribute, and display such Content throughout the world in any form, media, software, or technology of any kind. In addition, you waive all moral rights in the Content, including any Content you post or upload, or warrant that all moral rights applicable to such Content have been waived. You also grant Colorado Connect the right to use Your name in connection with the reproduction or distribution of such material.");
        softAssert.assertEquals(ol8.getText().trim(), "CLAIMS OF INFRINGEMENT. Just as Colorado Connect requires users of the Site to respect the copyrights and other intellectual property rights of Colorado Connect, its Affiliates, and other third parties, Colorado Connect respects the copyrights and other intellectual property rights of users of the Site and other third parties. If You believe in good faith that Your copyrighted work has been reproduced on the Site without authorization in a way that constitutes copyright infringement, You may notify our designated copyright agent by mail to:\n" +
                " \n" +
                "Colorado Connect\n" +
                "c/o Connect for Health Colorado\n" +
                "4600 S. Ulster Street, Suite 300\n" +
                "Denver, CO 80237\n" +
                "Please provide the following information to Colorado Connect:\n" +
                "(1) The identity of the infringed work, and of the allegedly infringing work;\n" +
                "(2) Your name, address, daytime phone number, and Email address, if available;\n" +
                "(3) A statement that You have a good-faith belief that the use of the copyrighted work is not authorized by the owner, his or her agent, or the law;\n" +
                "(4) A statement of the accuracy of the notice and, under penalty of perjury, that You are authorized to act on behalf of the owner; and\n" +
                "(5) Your electronic or physical signature.");
        softAssert.assertEquals(ol9.getText().trim(), "REPRESENTATIONS AND WARRANTIES. You hereby represent, warrant, and covenant for the benefit of Colorado Connect and its Affiliates that: (1) You have the legal right and authority to enter into this Agreement, and, if You are accepting this Agreement on behalf of a company or other entity, to bind the company or other entity to the terms of this Agreement; (2) You have the legal right and authority to perform Your obligations under this Agreement and to grant the rights and licenses described in this Agreement and in any applicable additional agreement You enter into in connection with any of the Services; (3) all information You provide to Colorado Connect in connection with this Agreement and Your access to the Site and use of the Services is correct and current.");
        softAssert.assertEquals(ol10.getText().trim(), "DISCLAIMER AND LIMITATION OF LIABILITY.\n" +
                " \n" +
                "10.1 Disclaimer. THE SITE IS PROVIDED BY Colorado Connect \u201CAS IS\u201D and \u201CAS AVAILABLE\u201D WITH NO WARRANTIES WHATSOEVER. NEITHER Colorado Connect NOR ITS AFFILIATES REPRESENT OR ENDORSE THE ACCURACY OR RELIABILITY OF ANY ADVICE, OPINION, STATEMENT, OR OTHER INFORMATION DISPLAYED, DOWNLOADED FROM, OR DISTRIBUTED THROUGH THE SITE. YOU AGREE THAT YOUR ACCESS TO THE SITE IS AT YOUR OWN RISK AND THAT YOU ARE SOLELY RESPONSIBLE FOR ANY LIABILITY OR DAMAGE YOU INCUR THROUGH ACCESS TO THE SITE. EXCEPT WHERE THE LAWS AND REGULATIONS OF A PARTICULAR JURISDICTION CONCERNING WARRANTIES CANNOT BE WAIVED OR EXCLUDED BY AGREEMENT, COLORADO CONNECT EXPRESSLY DISCLAIMS ALL WARRANTIES, WHETHER EXPRESS OR IMPLIED, REGARDING THE SITE, INCLUDING, WITHOUT LIMITATION, ALL WARRANTIES OF TITLE, NONINFRINGEMENT, MERCHANTABILITY, AND FITNESS FOR A PARTICULAR PURPOSE. YOU RECOGNIZE THAT THE CURRENT STATE OF TECHNOLOGY DOES NOT ALLOW FOR ERROR-FREE ACCESS TO THE SITE AND INTERRUPTIONS, CRASHES, AND DOWNTIME BEYOND COLORADO CONNECT\u2019S CONTROL MAY OCCUR FROM TIME TO TIME.\n" +
                " \n" +
                "10.2 Limitation. IN NO EVENT WILL COLORADO CONNECT BE LIABLE FOR ANY DIRECT, CONSEQUENTIAL, SPECIAL, INDIRECT, EXEMPLARY, OR PUNITIVE DAMAGES, WHETHER IN CONTRACT, TORT, OR ANY OTHER LEGAL THEORY, IN CONNECTION WITH YOUR ACCESS TO THE SITE OR USE OF THE SERVICES, EVEN IF COLORADO CONNECT HAS BEEN ADVISED OF THE POSSIBILITY OF SUCH DAMAGES AND NOTWITHSTANDING ANY FAILURE OF ESSENTIAL PURPOSE OR ANY LIMITED REMEDY. COLORADO CONNECT\u2019S TOTAL AGGREGATE LIABILITY FOR ANY DAMAGES ARISING OUT OF OR RELATED TO THIS AGREEMENT WILL NOT EXCEED $250.");
        softAssert.assertEquals(ol11.getText().trim(), "INDEMNIFICATION. You hereby indemnify, defend, and hold harmless Colorado Connect and its Affiliates, employees, agents, contractors, assigns, licensees, and successors in interest (\u201CIndemnified Parties\u201D) from any and all claims, losses, liabilities, damages, fees, expenses, and costs (including attorneys\u2019 fees, court costs, damage awards, and settlement amounts) that result from any claim or allegation against any Indemnified Party arising from Your accessing the Site or Your breach of any term of this Agreement. Colorado Connect will provide You with notice of any such claim or allegation, and Colorado Connect will have the right to participate in the defense of any such claim at its expense.");
        softAssert.assertEquals(ol12.getText().trim(), "PRIVACY POLICY. Colorado Connect\u2019s privacy policy, a copy of which is available at (the \u201CPrivacy Policy\u201D), is incorporated in this Agreement by reference. By accepting this Agreement, You expressly consent to the use and disclosure of your personally identifiable and other information as described in the Privacy Policy.");
        softAssert.assertEquals(ol13.getText().trim(), "LINKED SITES. The Site contains links to third-party sites that are not under the control of Colorado Connect, and Colorado Connect is not responsible for any content on any linked site. If you access a third-party site from the Site, then you do so at your own risk. Colorado Connect provides links only as a convenience, and the inclusion of the link does not imply that Colorado Connect endorses or accepts any responsibility for the content on those third-party sites. Colorado Connect welcomes links to the Site. You may establish a link to this Site, provided that the link does not state or imply any sponsorship or endorsement of your site by Colorado Connect or your site does not endorse or oppose any candidate for public office. You may not use on your site, any Content or Marks appearing on the Site in establishing the link. You may not frame or otherwise incorporate into another site the Content or other materials on the Site without prior written consent of Colorado Connect.");
        softAssert.assertEquals(ol14.getText().trim(), "NOTICES. Except as expressly stated otherwise, any notices required or allowed under this Agreement will be given to Colorado Connect by postal mail to the address for Colorado Connect listed on the Site. If applicable law requires that Colorado Connect accepts email notices (but not otherwise), then You may send Colorado Connect email notice using the \u201CContact Us\u201D page. A link to the Contact Us page is available on each page of the Site. With respect to Colorado Connect\u2019s notices to You, Colorado Connect may provide notice of amendments by posting them on the Site and upon such posting any amendment shall be deemed effective notice as set forth in Section 15.6. You agree to check for changes.");
        softAssert.assertEquals(ol15.getText().trim(), "GENERAL TERMS.\n" +
                " \n" +
                "15.1 Third-Party Beneficiaries. Colorado Connect\u2019s Affiliates are intended third-party beneficiaries under this Agreement with the right to enforce the provisions that directly concern Content to which they have rights.\n" +
                " \n" +
                "15.2 Nonassignment. You may not assign or transfer any of Your rights hereunder, and any attempt to do so will be null and void.\n" +
                " \n" +
                "15.3 Integration. This Agreement sets forth the entire understanding of the parties and supersedes any and all prior oral and written agreements or understandings between the parties regarding the subject matter of this Agreement. This Agreement may not be modified except upon mutual written agreement of both parties. The waiver by either party of a breach of any provision of this Agreement will not operate or be interpreted as a waiver of any other or subsequent breach.\n" +
                " \n" +
                "15.4 Severability. If for any reason any provision of this Agreement shall be held invalid or unenforceable in whole or in part in any jurisdiction, such provision shall, as to such jurisdiction, be ineffective to the extent of such invalidity or unenforceability, without in any manner affecting the validity or enforceability thereof in any other jurisdiction or the remaining provisions hereof in any jurisdiction.\n" +
                " \n" +
                "15.5 Jurisdiction and Venue. This Agreement will be governed by the laws of the State of Colorado, without giving effect to any conflict of laws principles. The parties specifically exclude from application to the Agreement the United Nations Convention on Contracts for the International Sale of Goods and the Uniform Computer Information Transactions Act. You hereby irrevocably and unconditionally consent to the jurisdiction and venue in the state and federal courts sitting in Denver, Colo. In any such dispute, the prevailing party will be entitled to recover its reasonable attorneys\u2019 fees and expenses from the other party.\n" +
                " \n" +
                "15.6 Modifications. Colorado Connect reserves the right, at any time and without notice, to add to, change, update, or modify the site and these Terms of Use, simply by posting such addition, change, update, or modification on this site. Any such addition, change, update, or modification will be effective immediately upon posting on the Site.");
        softAssert.assertAll();
    }
}
