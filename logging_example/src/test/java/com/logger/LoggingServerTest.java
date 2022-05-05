package com.logger;

import com.logger.controller.LoggerController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @auther gz
 * @date 2022-04-28  14:14
 * @description
 */
@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class LoggingServerTest {

    @Resource
    private LoggerController loggerController;

    @Test
    public void loggerTest() {
        loggerController.logger();
    }
}
