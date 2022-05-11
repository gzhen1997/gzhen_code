package com.ds.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

import java.util.Date;

/**
 * @auther gz
 * @date 2022-05-11  14:23
 * @description
 */
//@Configuration
public class MybatisMetaDataConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("createTime",new Date());
    }

    @Override
    public void updateFill(MetaObject metaObject) {

    }
}
