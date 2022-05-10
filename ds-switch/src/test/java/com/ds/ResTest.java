package com.ds;

import com.alibaba.druid.util.Utils;
import org.junit.Test;

import java.io.IOException;

/**
 * @auther gz
 * @date 2022-05-10  16:04
 * @description
 */

public class ResTest {

    @Test
    public void resTest() throws IOException {
        String content = Utils.readFromResource("static/common.txt");
//        System.out.println(content);
        String replace = content
                .replace(
                        "this.buildFooter();",
                        "");
        System.out.println(replace);
    }
}
