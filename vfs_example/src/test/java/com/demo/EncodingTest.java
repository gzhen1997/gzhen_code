package com.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.auth.StaticUserAuthenticator;
import org.apache.commons.vfs2.impl.DefaultFileSystemConfigBuilder;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

/**
 * @auther gz
 * @date 2022-04-22  11:12
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class EncodingTest {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() throws FileSystemException, JsonProcessingException {
        StaticUserAuthenticator auth = new StaticUserAuthenticator("domain", "root", "root");
        FileSystemOptions opts = new FileSystemOptions();
        DefaultFileSystemConfigBuilder.getInstance().setUserAuthenticator(opts, auth);
        SftpFileSystemConfigBuilder.getInstance().setFileNameEncoding(opts, "UTF-8");
        FileSystemManager manager = VFS.getManager();
        FileObject fo = manager.resolveFile("sftp://192.168.96.131/", opts);
//        FileObject fo = manager.resolveFile("sftp://gzhen/", opts);
        Long start = System.currentTimeMillis();
//        FileObject[] fileObject = getFileObject(fo);
//        for (FileObject object : fileObject) {
//            System.out.println(object.getName());
//        }
        FileObject[] files = fo.findFiles(new AllFileSelector());
//
//
        int index = 0;
        for (FileObject file : files) {
            System.out.println(file.getName());
//            redisTemplate.opsForValue().set("fo:" + index++, objectMapper.writeValueAsBytes(fo));
        }
        System.out.println(System.currentTimeMillis() - start);
       /* FileObject[] children = fo.getChildren();
        for (FileObject child : children) {
            System.out.println(child.getName());
        }*/
    }
}
