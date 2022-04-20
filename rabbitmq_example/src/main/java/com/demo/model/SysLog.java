package com.demo.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @auther gz
 * @date 2022-04-20  15:32
 * @description
 */
@Data
@TableName("sys_log")
public class SysLog {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    private String module;

    private String data;

    private String memo;

    @TableField("create_time")
    private Date createTime;


}
