package com.c4hco.test.automation.sftpConfig;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

public class SftpConnection {

    public static void main(){
        String localPath = "D:\\Users\\nkamireddy\\Desktop\\automation_files_from_sftp";
        String fileName = "834_DENVERHEALTH_C_2022120707080268_100000053_D_I";
        String sftpPath = "/inboundedi/mockediresponse/";
        String sftpHostname = "localhost";
        String sftpPort = "10023";
        String sftpUsername = "nkamireddy";
        // should give the private key path - Move to app.properties?
        String privateKeyPath = "D:\\Users\\nkamireddy\\Desktop\\public private keys\\niveditha_kamireddy_private.ppk";

            try{
                JSch jsch = new JSch();


                Session session = jsch.getSession(sftpUsername, sftpHostname, Integer.valueOf(sftpPort) );
                session.setConfig("StrictHostKeyChecking", "no");

                jsch.addIdentity(privateKeyPath);
                System.out.println("====connecting=====");
                session.connect();
                System.out.println("=====Connected=====");
                System.out.println("-------session connected?---"+session.isConnected());

                Channel channel = session.openChannel("sftp");

                ChannelSftp sftpChannel = (ChannelSftp) channel;
              sftpChannel.connect();

             System.out.println("channel.isConnected()===="+channel.isConnected());

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
