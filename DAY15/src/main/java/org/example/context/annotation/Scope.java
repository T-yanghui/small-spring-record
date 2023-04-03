package org.example.context.annotation;

import java.lang.annotation.*;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName Scope.java
 * @Description TODO
 * @createTime 2023/03/24
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Scope {
    String value() default "singleton";
}
