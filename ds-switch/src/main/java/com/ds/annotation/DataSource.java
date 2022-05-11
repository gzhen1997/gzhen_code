package com.ds.annotation;

import com.ds.ds.DynamicDataSourceProvider;
import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auther gz
 * @date 2022-05-11  9:54
 * @description
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DataSource {

    String dataSourceName() default DynamicDataSourceProvider.DEFAULT_DATASOURCE;

    @AliasFor("dataSourceName")
    String value() default DynamicDataSourceProvider.DEFAULT_DATASOURCE;
}
