package com.demo;

import com.jcraft.jsch.*;
import org.apache.commons.vfs2.provider.sftp.TrustEveryoneUserInfo;

import java.io.*;
import java.util.Properties;
import java.util.Vector;

/**
 * @auther gz
 * @date 2022-04-21  17:05
 * @description
 */

public class JschMain {

    public static void main(final String[] args) throws Exception {
        final Properties props = new Properties();
        props.setProperty("StrictHostKeyChecking", "false");
        final JSch jsch = new JSch();
        final Session session = jsch.getSession("root", "192.168.96.130", 22);
        //TrustEveryoneUserInfo trustEveryoneUserInfo =
        session.setUserInfo(new TrustEveryoneUserInfo());
        session.setPassword("root");
        session.connect();
        final ChannelExec chan = (ChannelExec) session.openChannel("exec");
        chan.setCommand("pwd");
        chan.connect();
        InputStream inputStream = chan.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String content;
        do {
            content = bufferedReader.readLine();
            System.out.println(content);
        } while (content != null);
//        chan.start();
//        final Vector<?> list = chan.ls("/home/gz/app");
//        list.forEach(System.err::println);
        System.err.println("done");
        chan.disconnect();
        session.disconnect();
    }
}
