package com.c4hco.test.automation.stepDefinitions.sftpSteps;

import com.c4hco.test.automation.sftpConfig.SftpUtil;
import com.jcraft.jsch.JSchException;
import io.cucumber.java.en.And;

public class sftpStepDefinitions {
    SftpUtil sftpUtil = new SftpUtil();

    @And("I download the file from sftp server with location {string}")
    public void validateFileExists(String remoteLocation) throws JSchException {
        sftpUtil.downloadFileWithSftp(remoteLocation);
    }

}
