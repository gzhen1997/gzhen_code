package com.ds.ds;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @auther gz
 * @date 2022-05-11  9:37
 * @description
 */

public interface DynamicDataSourceProvider {

    String DEFAULT_DATASOURCE = "master";
    /**
     * 加载所有的数据源
     * @return 数据源集合
     */
    Map<String, DataSource> loadDataSources();
}
