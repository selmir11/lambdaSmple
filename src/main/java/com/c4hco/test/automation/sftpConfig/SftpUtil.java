
package com.c4hco.test.automation.sftpConfig;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.edi.ediUtil.Ib834Util;
import com.c4hco.test.automation.edi.ediUtil.Ib999Util;
import com.c4hco.test.automation.edi.ediUtil.Ob834Util;
import com.c4hco.test.automation.edi.ediUtil.Ob999Util;
import com.c4hco.test.automation.utils.ApplicationProperties;
import com.c4hco.test.automation.utils.BasicActions;
import com.jcraft.jsch.*;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class SftpUtil {
    private Session session;
    Ob834Util edi834Util = new Ob834Util();
    Ib834Util ib834Util = new Ib834Util();
    Ib999Util ib999Util = new Ib999Util();
    Ob999Util ob999Util = new Ob999Util();
    BasicActions basicActions = new BasicActions();

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
        String passPhrase = ApplicationProperties.getInstance().getProperty("sftpPassphrase");

        int sftpPort =  setSftpPort();

        try{
            JSch jsch = new JSch();
            jsch.addIdentity(privateKeyPath, passPhrase);
            session = jsch.getSession(sftpUsername,"localhost",sftpPort);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();
            System.out.println("---!!! SFTP CONNECTED !!!---");

        }catch(Exception e){
            e.printStackTrace();
            Assert.fail("Error while connecting to SFTP server");
        }
    }

    public void downloadFileWithSftp(String remoteFilePath, String fileNameToDownload) {
        try {
            connectToSftp();
            String localPath = SharedData.getLocalPathToDownloadFile();
            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            try {
                channelSftp.get(remoteFilePath + fileNameToDownload, localPath);
            } catch (Exception  e) {
                e.printStackTrace();
                throw new RuntimeException("SFTP operation failed ", e);
            } finally {
                channelSftp.disconnect();
                disconnectFromSftp();
            }
        } catch (Exception e){
            // fail
            throw new RuntimeException("SFTP operation failed ", e);
        }
    }
    public void downloadOb999File(String remoteFilePath, String fileNameToDownload){
        try {
            connectToSftp();
            String localPath = SharedData.getLocalPathToDownloadFile();
            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();

            try {
                String fullRemotePath = remoteFilePath.endsWith("/") ? remoteFilePath + fileNameToDownload : remoteFilePath + "/" + fileNameToDownload;
                System.out.println("Checking for file: " + fullRemotePath);

                int maxRetries = 5;
                int retryCount = 0;

                while (retryCount < maxRetries) {
                    try {
                        Vector<ChannelSftp.LsEntry> files = channelSftp.ls(fullRemotePath);
                        if (!files.isEmpty()) {
                            System.out.println("Ob999 File found! Downloading...");
                            channelSftp.get(fullRemotePath, localPath);
                            System.out.println("Download successful!");
                            break; // Exit loop after successful download
                        }
                    } catch (SftpException e) {
                        System.out.println("File not found, retrying in 5 seconds...");
                        basicActions.wait(5000);
                        retryCount++;
                    }
                }

                if (retryCount == maxRetries) {
                    throw new RuntimeException("File was not found after " + maxRetries + " retries: " + fullRemotePath);
                }

            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("SFTP operation failed ", e);
            } finally {
                channelSftp.disconnect();
                disconnectFromSftp();
                //  Runtime.getRuntime().exec("cmd.exe /c explorer /select," + reportFolder.getAbsolutePath());
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /im explorer.exe && start explorer");
                Thread.sleep(2000); // Adjust if needed
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /im explorer.exe");
            }
        } catch (Exception e) {
            throw new RuntimeException("SFTP operation failed ", e);
        }
    }


    public void uploadFileInSftp(String fileName, String remoteFilePath) {
        try {
            connectToSftp();
            String localPath = SharedData.getLocalPathToDownloadFile();
            basicActions.wait(3000);
            ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
            channelSftp.connect();
            try {
                channelSftp.put(localPath + "/" + fileName, remoteFilePath);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                channelSftp.disconnect();
                disconnectFromSftp();
            }
        } catch(JSchException e){
            Assert.fail("Exception");
        }
    }

    public void disconnectFromSftp(){
        if(session != null && session.isConnected()){
            session.disconnect();
        }
    }

    public String getLocalSftpDownloadPath(){
        String timestamp = new SimpleDateFormat("MMddyyyy-HHmmss").format(new Date());
        String sftpFolderPath = "target/sftp-downloads/download-" + timestamp;
        try {
            File reportFolder = new File(sftpFolderPath);
            if (!reportFolder.exists()) {
                boolean folderCreated = reportFolder.mkdirs();
                if (!folderCreated) {
                    System.out.println("Failed to create the report folder.");
                }
              //  Runtime.getRuntime().exec("cmd.exe /c explorer /select," + reportFolder.getAbsolutePath());
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /im explorer.exe && start explorer");
                Thread.sleep(2000); // Adjust if needed
                Runtime.getRuntime().exec("cmd.exe /c taskkill /f /im explorer.exe");
            }
        } catch (IOException|InterruptedException e) {
            throw new RuntimeException(e);
        }
        return sftpFolderPath;
    }

    public void validateFileIsNotEmpty(String filename){
        String sftpFolderPath = SharedData.getLocalPathToDownloadFile();
        try{
            File file = new File(sftpFolderPath+"\\"+filename);

            // Check if file exists and is not a directory before trying to open it
            if (!file.exists() || !file.isFile()) {
                System.err.println("File not found in the resource folder.");
                Assert.fail("!!EDI File looking for is not found!!"+filename);
            }

            InputStream inputStream = new FileInputStream(file);

            if (inputStream != null) {
                System.out.println("EDI File Found on SFTP Server");
                edi834Util.validateFileIsNotEmpty(inputStream);
            } else {
                System.err.println("File not found in the resource folder.");
                Assert.fail("!!EDI File looking for is not found!!");
            }
            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
            Assert.fail("!!EDI File looking for is not found!!");
        }
    }

    public void readEdiFile(String filename){
        String sftpFolderPath = SharedData.getLocalPathToDownloadFile();
        try{
            File file = new File(sftpFolderPath+"\\"+filename);
            InputStream inputStream = new FileInputStream(file);

            if (inputStream != null) {
                System.out.println("EDI File Found on SFTP Server");
                edi834Util.parseEdiFile(inputStream);
            } else {
                System.err.println("File not found in the resource folder.");
            }
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void checkEdiFileLocalOrSftp(String filename,String remoteFilePath){
        String sftpFolderPath = SharedData.getLocalPathToDownloadFile();

        try {
            File file = new File(sftpFolderPath + "\\" + filename);
        if (file.exists()) {
            System.out.println("File found in the local folder");
        }
        else {
            String sftpDownloadPath = getLocalSftpDownloadPath();
            SharedData.setLocalPathToDownloadFile(sftpDownloadPath);
            downloadFileWithSftp(remoteFilePath, filename);
            System.out.println("File found in the SFTP folder");
        }
    }catch (Exception e){
        e.printStackTrace();
        Assert.fail("!!EDI File looking for is not found!!");
    }
    }

    public void readIb999File(String filename){
        String sftpFolderPath = SharedData.getLocalPathToDownloadFile();
        try{
            File file = new File(sftpFolderPath+"\\"+filename);
            InputStream inputStream = new FileInputStream(file);

            if (inputStream != null) {
                System.out.println("EDI File Found on SFTP Server");
                ib999Util.parseIb999(inputStream);
            } else {
                System.err.println("File not found in the resource folder.");
            }
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void readOb999File(String filename){
        String sftpFolderPath = SharedData.getLocalPathToDownloadFile();
        try{
            File file = new File(sftpFolderPath+"\\"+filename);
            // Check if file exists and is not a directory before trying to open it
            if (!file.exists() || !file.isFile()) {
                System.err.println("File not found in the resource folder.");
                Assert.fail("!!EDI File looking for is not found!!"+filename);
            }
            InputStream inputStream = new FileInputStream(file);

            if (inputStream != null) {
                System.out.println("EDI File Found on SFTP Server");
                ob999Util.parseOb999(inputStream);
            } else {
                System.err.println("File not found in the resource folder.");
            }
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }
    public void readIb834EdiFile(String filename){
        String sftpFolderPath = SharedData.getLocalPathToDownloadFile();
        try{
            File file = new File(sftpFolderPath+"\\"+filename);
            InputStream inputStream = new FileInputStream(file);

            if (inputStream != null) {
                System.out.println("Ib834 EDI File Found on SFTP Server");
                ib834Util.parseIb834File(inputStream);
            } else {
                System.err.println("Ib834 File not found in the resource folder.");
            }
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    public void readEdiFromLocal(){
        try{
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("4STMultiINS");

            if (inputStream != null) {
                System.out.println("File found");
                edi834Util.parseEdiFile(inputStream);
            } else {
                System.err.println("File 'edi_384' not found in the resource folder.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void readEdi999FromLocal(){
        try{
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("999_DNV_file");

            if (inputStream != null) {
                System.out.println("File found");
                ib999Util.parseIb999(inputStream);
            } else {
                System.err.println("File 'edi_999' not found in the resource folder.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void readIb834FromLocal(){
        try{
            ClassLoader classLoader = getClass().getClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("ib834FaComplex");

            if (inputStream != null) {
                System.out.println("File found");
                ib834Util.parseIb834File(inputStream);
            } else {
                System.err.println("File 'edi_384' not found in the resource folder.");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
