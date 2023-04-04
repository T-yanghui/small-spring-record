package org.example.beans.factory.annotation;

import java.lang.annotation.*;
/**
 * @author yang
 * @version 1.0.0
 * @ClassName Value.java
 * @Description TODO
 * @createTime 2023/04/01
 */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Value {

    /**
     * The actual value expression: e.g. "#{systemProperties.myProp}".
     */
    String value();

}