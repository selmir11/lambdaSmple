package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import io.cucumber.java.en.Then;

public class sftpStepDefinitions {
    @Then("I go to the sftp path and download the file")
    public void goToSftpLocation(String sftpPath){
        // should give sftpPath to download from and file name
        // these should have saved from else where accordingly - otherwise will end up having multiple steps for multiple scenarios
    }

}
