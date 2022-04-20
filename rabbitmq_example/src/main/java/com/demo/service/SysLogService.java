package com.demo.service;

import com.demo.dto.UserLoginDto;
import com.demo.mapper.SysLogMapper;
import com.demo.model.SysLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @auther gz
 * @date 2022-04-20  16:20
 * @description
 */
@Service
@Slf4j
public class SysLogService {

    @Resource
    private ObjectMapper objectMapper;

    @Resource
    private SysLogMapper sysLogMapper;

    @Async
    public void recordLog(UserLoginDto userLoginDto) {
        try {
            SysLog sysLog = new SysLog();
            sysLog.setUserId(userLoginDto.getUserId());
            sysLog.setModule("用户登录模块");
            sysLog.setData(objectMapper.writeValueAsString(userLoginDto));
            sysLog.setMemo("用户登录成功记录相关登录信息");
            sysLog.setCreateTime(new Date());
            sysLogMapper.insert(sysLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
