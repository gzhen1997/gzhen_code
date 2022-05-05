package com.demo;

import org.junit.Test;

/**
 * @auther gz
 * @date 2022-04-28  17:04
 * @description
 */

public class EnumTest {

    @Test
    public void enumTest() {
        Type ftp = Enum.valueOf(Type.class, "FTP");
        Type sftp = Enum.valueOf(Type.class, "SFTP");
        System.out.println(ftp);
        int ordinal = sftp.ordinal();
        System.out.println("ordinal:" + ordinal);
    }
}


enum Type {
    FTP,
    SFTP
}
