package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import com.c4hco.test.automation.sftpConfig.SftpUtil;
import com.jcraft.jsch.JSchException;
import io.cucumber.java.en.Then;

public class sftpStepDefinitions {
    SftpUtil sftpUtil = new SftpUtil();

    @Then("I go to the sftp path and download the file")
    public void goToSftpLocationAndDownload() throws JSchException {
        sftpUtil.connectToSftp();
        sftpUtil.downloadFileWithSftp();
        sftpUtil.disconnectFromSftp();
        // should give sftpPath to download from and file name
        // these should have saved from else where accordingly - otherwise will end up having multiple steps for multiple scenarios
    }

}
