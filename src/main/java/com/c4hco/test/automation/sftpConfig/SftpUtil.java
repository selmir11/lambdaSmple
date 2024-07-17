
package com.c4hco.test.automation.sftpConfig;

import com.c4hco.test.automation.Dto.SharedData;
import com.c4hco.test.automation.edi.ediUtil.Edi834Util;
import com.c4hco.test.automation.utils.ApplicationProperties;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import org.testng.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SftpUtil {
    private Session session;
    Edi834Util edi834Util = new Edi834Util();

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

    public void downloadFileWithSftp(String remoteFilePath, String fileNameToDownload) throws JSchException {
        connectToSftp();
        String localPath = SharedData.getLocalPathToDownloadFile();
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

    public String getLocalSftpDownloadPath(){
        String timestamp = new SimpleDateFormat("MMddyyyy-HHmmss").format(new Date());
        String sftpFolderPath = "target/sftp-downloads/download-" + timestamp;
        File reportFolder = new File(sftpFolderPath);
        if (!reportFolder.exists()) {
            boolean folderCreated = reportFolder.mkdirs();
            if (!folderCreated) {
                System.out.println("Failed to create the report folder.");
            }
        }
        return sftpFolderPath;
    }

    public void validateFileIsNotEmpty(String filename){
        String sftpFolderPath = SharedData.getLocalPathToDownloadFile();
        try{
            File file = new File(sftpFolderPath+"\\"+filename);
            InputStream inputStream = new FileInputStream(file);

            if (inputStream != null) {
                System.out.println("EDI File Found on SFTP Server");
                edi834Util.validateFileIsNotEmpty(inputStream);
            } else {
                System.err.println("File not found in the resource folder.");
                Assert.fail("!!EDI File looking for is not found!!");
            }
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
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


    public void readEdiFromLocal(){
        try{
            ClassLoader classLoader = getClass().getClassLoader();
           // InputStream inputStream = classLoader.getResourceAsStream("4STMultiINS");
           InputStream inputStream = classLoader.getResourceAsStream("1ST1INS1LS");

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
}
