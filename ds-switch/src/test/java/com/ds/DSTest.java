package com.ds;

import com.ds.ds.impl.YamlDynamicDataSourceProvider;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @auther gz
 * @date 2022-05-10  16:40
 * @description
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DSTest {

    @Autowired
    private YamlDynamicDataSourceProvider dataSourceProvider;

    @Test
    public void test() {
        dataSourceProvider.loadDataSources();
    }
}
