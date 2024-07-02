package com.c4hco.test.automation.pages.exchPages;

import com.c4hco.test.automation.utils.BasicActions;
import com.c4hco.test.automation.utils.WebDriverManager;
import jakarta.mail.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.Properties;

public class GmailNoticesverify {
    private BasicActions basicActions;

    public GmailNoticesverify(WebDriver webDriver) {
        basicActions = new BasicActions(webDriver);
        PageFactory.initElements(basicActions.getDriver(), this);
    }


        public void Noticesverify() throws MessagingException, InterruptedException {

            Properties properties = new Properties();
            properties.setProperty("mail.store.protocol", "imaps"); // For IMAP over SSL
            properties.setProperty("mail.imap.host", "imap.gmail.com");
            properties.setProperty("mail.imap.port", "993");


            Session session = Session.getInstance(properties);


            Store store = session.getStore("imaps");
            store.connect("imap.gmail.com", "unicy245@gmail.com", "hifr khpf boti reyq");


            Folder inbox = store.getFolder("INBOX");
            inbox.open(Folder.READ_ONLY);

            boolean found = false;
            while (!found) {

                Message[] messages = inbox.getMessages();
                System.out.println("Total messages: " + messages.length);

                if (messages.length > 0) {
                    Message firstMessage = messages[messages.length-1];
                    System.out.println("Subject: " + firstMessage.getSubject());
                    System.out.println("Received: " + firstMessage.getReceivedDate());
                    if ("Confirmation: Your Connect for Health Colorado Plan Selection (EN-002-04)".equals(firstMessage.getSubject())) {
                        System.out.println("Subject: " + firstMessage.getSubject());
                        System.out.println("Received: " + firstMessage.getReceivedDate());
                        found = true;
                    }
                }

                if (!found) {
                    System.out.println("Email with subject 'EN-002-04' not found. Waiting...");
                    Thread.sleep(60000);
                    inbox.close(false);
                    inbox.open(Folder.READ_ONLY);
                }
            }

            inbox.close(false);
            store.close();
        }


    }


