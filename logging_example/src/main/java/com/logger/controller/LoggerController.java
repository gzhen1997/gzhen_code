package com.logger.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther gz
 * @date 2022-04-28  13:57
 * @description
 */
@RestController
@Slf4j
public class LoggerController {

//    private static final Logger log = LoggerFactory.getLogger(LoggerController.class);

    @GetMapping("log")
    public void logger(){
        log.trace("trace-级别");
        log.debug("debug-级别");
        log.info("info-级别");
        log.warn("warn-级别");
        log.error("error-级别");
    }
}
