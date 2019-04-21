package com.guanghuan3.homework.myspringframework.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator
 * on 2019/4/20.
 */
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAutowired {
    String name() default "";
}
