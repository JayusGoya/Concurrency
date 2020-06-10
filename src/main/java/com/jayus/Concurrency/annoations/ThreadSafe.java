package com.jayus.Concurrency.annoations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/** 课程用来标记 线程安全 的类或者写法
 * @author: wangjiajun
 * @date: 2020-06-10 16:04
 */
// Target :Annotation所修饰的对象范围
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ThreadSafe {
    String value() default "";
}
