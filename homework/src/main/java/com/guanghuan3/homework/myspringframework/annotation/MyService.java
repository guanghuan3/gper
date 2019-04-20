package com.guanghuan3.homework.myspringframework.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator
 * on 2019/4/18.
 */
@Target({ElementType.TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyService {

    String name() default "";
}
