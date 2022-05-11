package com.ds.aop;

import com.ds.annotation.DataSource;
import com.ds.ds.DynamicDataSourceContextHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @auther gz
 * @date 2022-05-11  9:56
 * @description
 */
@Aspect
@Order(1)
@Component
public class DataSourceAspect {

    /**
     * annotation 针对方法
     * within 针对类
     */
    @Pointcut("@annotation(com.ds.annotation.DataSource)"
            + "|| @within(com.ds.annotation.DataSource)")
    public void dsPc() {}

    @Around("dsPc()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        DataSource dataSource = getDataSource(point);

        if (Objects.nonNull(dataSource)) {
            DynamicDataSourceContextHolder.setDataSourceType(dataSource.dataSourceName());
        }

        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }

    /**
     * 获取需要切换的数据源
     */
    public DataSource getDataSource(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataSource dataSource = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);
        if (Objects.nonNull(dataSource)) {
            return dataSource;
        }
        return AnnotationUtils.findAnnotation(signature.getDeclaringType(), DataSource.class);
    }
}
