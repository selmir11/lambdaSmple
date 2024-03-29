package com.c4hco.test.automation.sftpConfig;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.utils.ApplicationProperties;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.junit.Assert;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SftpUtil {
    private Session session;

    public SftpUtil(){

    }

    public int setSftpPort(){
        final String env = ApplicationProperties.getInstance().getProperty("env");
        int sftpPort = 0;
        if(SharedData.getAppType().equals("coco")){
            if("qa".equals(env)){
                sftpPort = 10023;
            }else if("staging".equals(env)){
                sftpPort = 10024;
            }
        }else if("exchange".equals(SharedData.getAppType())){
            if("qa".equals(env)){
                sftpPort = 10021;
            }else if("staging".equals(env)){
                sftpPort = 10022;
            }
        }
        return sftpPort;
    }

    public void connectToSftp(){
        String sftpUsername = ApplicationProperties.getInstance().getProperty("sftpUsername");
        String privateKeyPath = ApplicationProperties.getInstance().getProperty("sftpPrivateKeyPath");
        int sftpPort = setSftpPort();

        try{
            JSch jsch = new JSch();
            jsch.addIdentity(privateKeyPath);
                System.out.println("sftpusername::"+sftpUsername);
            System.out.println("sftpPort::"+sftpPort
            );
            session = jsch.getSession(sftpUsername,"localhost",sftpPort);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

        }catch(Exception e){
            e.printStackTrace();
            Assert.fail("Error while connecting to SFTP server");
        }
    }

    public void downloadFileWithSftp(String remoteFilePath) throws JSchException {
        String fileNameToDownload = ""; // TO DO: Think for a solution - will have multiple files, for now atleast 2.
        // put fileNames in list and for each list, download and validate.
        connectToSftp();
        String localPath = getLocalSftpDownloadPath();
        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
        channelSftp.connect();
        try{
            channelSftp.get(remoteFilePath+fileNameToDownload, localPath);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            channelSftp.disconnect();
            disconnectFromSftp();
        }
    }

    public void disconnectFromSftp(){
        if(session != null && session.isConnected()){
            session.disconnect();
        }
    }

    private String getLocalSftpDownloadPath(){
        String timestamp = new SimpleDateFormat("MMddyyyy-HHmmss").format(new Date());
        String reportFolderPath = "target/sftp-downloads/download-" + timestamp;
        // Create the timestamped folder
        File reportFolder = new File(reportFolderPath);
        if (!reportFolder.exists()) {
            boolean folderCreated = reportFolder.mkdirs();
            if (!folderCreated) {
                System.out.println("Failed to create the report folder.");
            }
        }
        return reportFolderPath;
    }

    //    public void uploadFileWithSftp(String remoteFilePath) throws JSchException {
//        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
//        channelSftp.connect();
//        try{
//            channelSftp.put(localPath,remoteFilePath);
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally {
//            channelSftp.disconnect();
//        }
//    }
    
}