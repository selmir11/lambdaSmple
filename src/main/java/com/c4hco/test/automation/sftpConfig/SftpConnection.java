package com.c4hco.test.automation.sftpConfig;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SftpConnection {

    public static void main(String[] args){
        String localPath = "";
        String fileName = "";
        String sftpPath = "";
        String sftpHostname = "";
        String sftpPort = "";
        String sftpUsername = "";
        // should give the private key path - Move to app.properties?
        String sftpPassword = "";

            try{
                JSch jsch = new JSch();
                Session session = jsch.getSession(sftpUsername, sftpHostname, Integer.valueOf(sftpPort) );
                session.setConfig("StrictHostKeyChecking", "no");
                session.setPassword(sftpPassword);
                System.out.println("====connecting=====");
                session.connect();
                System.out.println("=====Connected=====");

                Channel channel = session.openChannel("sftp");

                ChannelSftp sftpChannel = (ChannelSftp) channel;
              sftpChannel.connect();

              // sftpChannel.put - to read write files to sftp

                // copy file from host to local path
                sftpChannel.get(sftpPath+fileName, localPath);

                sftpChannel.disconnect();
                session.disconnect();

            }catch(Exception e){
                e.printStackTrace();
            }
    }
}
