package com.demo;

import org.apache.commons.vfs2.*;
import org.apache.commons.vfs2.provider.sftp.SftpFileSystemConfigBuilder;

/**
 * @auther gz
 * @date 2022-04-21  11:21
 * @description
 */

public class VfsMain {

    public static void main(String[] args) throws FileSystemException {
        // 找到 Jar 文件
        FileSystemManager fsManager = VFS.getManager();
        FileSystemOptions options = new FileSystemOptions();
        SftpFileSystemConfigBuilder instance = SftpFileSystemConfigBuilder
                .getInstance();
        instance.setUserDirIsRoot(options,false);
//        FileObject jarFile = fsManager.resolveFile("jar:D:\\nacos-server.jar");
        FileObject fileObject = fsManager.resolveFile("jar:sftp://gz:gz@192.168.96.130/home/gz/app/nacos-server.jar",options);
//        fileObject.isExecutable();
        if (fileObject.isFolder()){
            FileObject[] children = fileObject.getChildren();
            // 列出 Jar 文件的子项
//        FileObject[] children = jarFile.getChildren();
            System.out.println("子级" + fileObject.getName().getURI());
            for (int i = 0; i < children.length; i++) {
                System.out.println(children[i].getName().getBaseName());
            }
        }



    }

}
