package com.ds;

import com.alibaba.druid.util.Utils;
import com.ds.annotation.DataSource;
import com.ds.dto.UserDto;
import com.ds.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.core.annotation.AnnotationFilter;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * @auther gz
 * @date 2022-05-10  16:04
 * @description
 */

public class ResTest {

    @Test
    public void resTest() throws IOException {
        String content = Utils.readFromResource("static/common.txt");
        String replace = content
                .replace(
                        "this.buildFooter();",
                        "");
        System.out.println(replace);
    }

    @Test
    public void annoTest() throws NoSuchMethodException {
//        if (AnnotationFilter.PLAIN.matches(annotationType) ||
//                AnnotationsScanner.hasPlainJavaAnnotationsOnly(clazz)) {
//            A annotation = clazz.getDeclaredAnnotation(annotationType);
//            if (annotation != null) {
//                return annotation;
//            }
//            // For backwards compatibility, perform a superclass search with plain annotations
//            // even if not marked as @Inherited: e.g. a findAnnotation search for @Deprecated
//            Class<?> superclass = clazz.getSuperclass();
//            if (superclass == null || superclass == Object.class) {
//                return null;
//            }
//            return findAnnotation(superclass, annotationType);
//        }
        boolean matches = AnnotationFilter.PLAIN.matches(DataSource.class);
        System.out.println(matches);
        System.out.println(DataSource.class.getName());
        DataSource declaredAnnotation = UserServiceImpl.class.getDeclaredAnnotation(DataSource.class);
        System.out.println(declaredAnnotation);
        Method insertMethod = UserServiceImpl.class.getMethod("insert", UserDto.class);
        DataSource annotation = insertMethod.getDeclaredAnnotation(DataSource.class);
        System.out.println(annotation);
        System.out.println("------------------------------");
        Method insert = Role.class.getDeclaredMethod("insert");
        DS ds = insert.getAnnotation(DS.class);
        String value = ds.value();
        System.out.println(value);
        System.out.println(ds);
    }
}

class Role{

    @DS
    String insert(){
        return "insert";
    }
}



@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface DS{
    String value() default "master";
}
