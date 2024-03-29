//package com.c4hco.test.automation.sftpConfig;
//
//import com.c4hco.test.automation.utils.ApplicationProperties;
//import com.jcraft.jsch.ChannelSftp;
//import com.jcraft.jsch.JSch;
//import com.jcraft.jsch.JSchException;
//import com.jcraft.jsch.Session;
//import org.junit.Assert;
//
//import java.io.File;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
//public class SftpUtil {
//    private String sftpHostname = "localhost";
//    private int sftpPort;
//    private String sftpUsername = "";
//    private String privateKeyPath = "";
//    private Session session;
//    private final String env = ApplicationProperties.getInstance().getProperty("env");
//    private String localPath = " ";
//    // fileName and sftpPath should be removed. These hardcoded ones are only for code development
//    String fileName = "999_KPCONNECTOR_I_2020092103210000_990000000_D_O";
//    String sftpPath = "/inboundedi/outbound999/";
//
//    public SftpUtil(){
//        initializeSftpConfiguration();
//    }
//
//    private void initializeSftpConfiguration(){
//        sftpUsername = ApplicationProperties.getInstance().getProperty("sftpUsername");
//        privateKeyPath = ApplicationProperties.getInstance().getProperty("sftpPrivateKeyPath");
//        localPath = getLocalSftpDownloadPath();
//        sftpPort = 10021;
//
////        // setting the sftp port
////        if(SharedData.getAppType().equals("coco")){
////            if("qa".equals(env)){
////                sftpPort = 10023;
////            }else if("staging".equals(env)){
////                sftpPort = 10024;
////            }
////        }else if("exchange".equals(SharedData.getAppType())){
////            if("qa".equals(env)){
////                sftpPort = 10021;
////            }else if("staging".equals(env)){
////                sftpPort = 10022;
////            }
////        }
//        connectToSftp();
//        getLocalSftpDownloadPath();
//    }
//
//    public void connectToSftp(){
//        try{
//            JSch jsch = new JSch();
//            jsch.addIdentity(privateKeyPath);
//                System.out.println("sftpusername::"+sftpUsername);
//            System.out.println("sftpHostname::"+sftpHostname);
//            System.out.println("sftpPort::"+sftpPort
//            );
//            session = jsch.getSession(sftpUsername,sftpHostname,sftpPort);
//            session.setConfig("StrictHostKeyChecking", "no");
//            session.connect();
//
//        }catch(Exception e){
//            e.printStackTrace();
//            Assert.fail("Error while connecting to SFTP server");
//        }
//    }
//
////    public void downloadFileWithSftp() throws JSchException {
////        // This method is for code development purpose only. Use the below method with parameters for actual use.
////        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
////        channelSftp.connect();
////        System.out.println("sftpPath--"+sftpPath);
////        System.out.println("filename--"+fileName);
////        System.out.println("localpath--"+localPath);
////
////        try{
////            channelSftp.get(sftpPath+fileName, localPath);
////
////            InputStream inputStream = channelSftp.get(sftpPath+fileName);
////            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
////
////            String line;
////           System.out.println("reader lines::"+ reader.lines());
////            while ((line = reader.readLine()) != null) {
////                System.out.println("line--"+line+"\n"); // Print or process the line as needed
////
////                String[] fields = line.split(",");
////
////                // Process each field
////                for (String field : fields) {
////                    System.out.println("field-trim::"+field.trim()+"\n"); // Print each field (trimmed to remove leading/trailing whitespace)
////                }
////            }
////
////            reader.close();
////
////        }catch(Exception e){
////            Assert.fail("File Doesn't Exist");
////            e.printStackTrace();
////        }finally {
////            channelSftp.disconnect();
////        }
////    }
//
//    public void downloadFileWithSftp(String remoteFilePath, String fileNameToDownload) throws JSchException {
//        ChannelSftp channelSftp = (ChannelSftp) session.openChannel("sftp");
//        channelSftp.connect();
//        try{
//            channelSftp.get(remoteFilePath+fileNameToDownload, localPath);
//        }catch(Exception e){
//            e.printStackTrace();
//        }finally {
//            channelSftp.disconnect();
//        }
//    }
//
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
//
//    public void disconnectFromSftp(){
//        if(session != null && session.isConnected()){
//            session.disconnect();
//        }
//    }
//
//    private String getLocalSftpDownloadPath(){
//        String timestamp = new SimpleDateFormat("MMddyyyy-HHmmss").format(new Date());
//        String reportFolderPath = "target/sftp-downloads/download-" + timestamp;
//        // Create the timestamped folder
//        File reportFolder = new File(reportFolderPath);
//        if (!reportFolder.exists()) {
//            boolean folderCreated = reportFolder.mkdirs();
//            if (!folderCreated) {
//                System.out.println("Failed to create the report folder.");
//            }
//        }
//        return reportFolderPath;
//    }
//}