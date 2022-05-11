package com.ds.ds.impl;

import com.ds.ds.DynamicDataSourceContextHolder;
import com.ds.ds.DynamicDataSourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @auther gz
 * @date 2022-05-11  13:56
 * @description
 */

public class DynamicDataSource extends AbstractRoutingDataSource {

    @Autowired
    DynamicDataSourceProvider dynamicDataSourceProvider;

    public DynamicDataSource(DynamicDataSourceProvider dynamicDataSourceProvider) {
        this.dynamicDataSourceProvider = dynamicDataSourceProvider;
        Map<Object, Object> targetDataSources = new HashMap<>(dynamicDataSourceProvider.loadDataSources());
        super.setTargetDataSources(targetDataSources);
        super.setDefaultTargetDataSource(dynamicDataSourceProvider.loadDataSources().get(DynamicDataSourceProvider.DEFAULT_DATASOURCE));
        super.afterPropertiesSet();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        String dataSourceType = DynamicDataSourceContextHolder.getDataSourceType();
        return dataSourceType;
    }
}
