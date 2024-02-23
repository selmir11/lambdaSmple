package com.c4hco.test.automation.utils;

import org.apache.commons.lang.RandomStringUtils;

public class RandomDynamicData {
     // TO DO:: check if we need this. If needed move all the login credentials/details generation here.

    public static String randomStringEmail;
    public String fullEmail;
    private static RandomDynamicData single_instance = null;
    public String randomAlphanumericString() {
        String generatedString = RandomStringUtils.randomAlphabetic(5);

        System.out.println("Generated String: "+generatedString);
        return generatedString;
    }
    public String fname = "FN"+randomAlphanumericString();
    public String lname = "LN"+randomAlphanumericString();
    private  RandomDynamicData()
    {
        randomStringEmail = lname + ((int)(Math.random() * 1000));
        System.out.println("String for Email: " + randomStringEmail);
        fullEmail = randomStringEmail + "@gmail.com";
       }

    public String loginPassword = "ALaska12!";

    public static synchronized RandomDynamicData getInstance()
    {
        if (single_instance == null)
            single_instance = new RandomDynamicData();

        return single_instance;
    }

}
