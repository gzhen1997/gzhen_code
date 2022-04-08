package com.demo.annotation;

import java.lang.annotation.*;

/**
 * @auther gz
 * @date 2022-04-08  13:52
 * @description
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface CustomizeScanner {
}
