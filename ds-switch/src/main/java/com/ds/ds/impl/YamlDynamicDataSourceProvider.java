package com.ds.ds.impl;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.ds.config.DruidProperties;
import com.ds.ds.DynamicDataSourceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @auther gz
 * @date 2022-05-11  9:38
 * @description
 */
@Configuration
@EnableConfigurationProperties(DruidProperties.class)
public class YamlDynamicDataSourceProvider implements DynamicDataSourceProvider {

    @Autowired
    DruidProperties druidProperties;

    @Override
    public Map<String, DataSource> loadDataSources() {
        Map<String, DataSource> ds = new HashMap<>(druidProperties.getDs().size());
        try {
            Map<String, Map<String, String>> map = druidProperties.getDs();
            Set<String> keySet = map.keySet();
            for (String s : keySet) {
                DruidDataSource dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(map.get(s));
                ds.put(s, druidProperties.dataSource(dataSource));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ds;

    }
}
