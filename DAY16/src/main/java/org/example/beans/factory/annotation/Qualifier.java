package org.example.beans.factory.annotation;

import java.lang.annotation.*;

/**
 * @author yang
 * @version 1.0.0
 * @ClassName Qualifier.java
 * @Description TODO
 * @createTime 2023/04/01
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Qualifier {

    String value() default "";

}